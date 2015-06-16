/*
   Copyright 2009 Jean-Rémy Falleri

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

package fr.labri.galatea;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Concept {

	private Set<Entity> extent;

	private Set<Attribute> intent;

	private Set<Concept> parents;

	private Set<Concept> children;

	public Concept() {
		this.parents = new HashSet<Concept>();
		this.children = new HashSet<Concept>();
		this.intent = new HashSet<Attribute>();
		this.extent = new HashSet<Entity>();
	}

	public Set<Concept> getParents() {
		return parents;
	}

	public Set<Concept> getChildren() {
		return children;
	}

	public void addParent(Concept c) {
		this.parents.add(c);
		c.children.add(this);
	}
	
	public void removeParent(Concept c) {
		this.parents.remove(c);
		c.children.remove(this);
	}
	
	public void addChild(Concept c) {
		this.children.add(c);
		c.parents.add(this);
	}
	
	public void removeChild(Concept c) {
		this.children.remove(c);
		c.parents.remove(this);
	}
	
	public Set<Entity> getExtent() {
		return extent;
	}

	public Set<Attribute> getIntent() {
		return intent;
	}

	public Set<Entity> getSimplifiedExtent() {
		Set<Entity> simplifiedExtent = new HashSet<Entity>();
		for(Entity entity: this.getExtent() ) {
			boolean leafEntity = true;
			for(Concept child: this.children )
				if ( child.getExtent().contains(entity))
					leafEntity = false;
			if ( leafEntity )
				simplifiedExtent.add(entity);
		}
		return simplifiedExtent;
	}

	public Set<Attribute> getSimplifiedIntent() {
		Set<Attribute> simplifiedIntent = new HashSet<Attribute>();
		for( Attribute c: this.getIntent() ) {
			boolean leafAttribute = true;
			for(Concept parent: this.parents )
				if( parent.getIntent().contains(c))
					leafAttribute = false;
			if ( leafAttribute )
				simplifiedIntent.add(c);
		}
		return simplifiedIntent;
	}

	public Set<Concept> getAllChildren() {
		Set<Concept> result = new HashSet<Concept>();
		Set<Concept> temp = new HashSet<Concept>();
		temp.add(this);
		while ( temp.size() > 0 ) {
			Concept concept = pickOne(temp);
			if ( !result.contains(concept)) {
				result.add(concept);
				temp.addAll(concept.getChildren());
			}
		}
		return result;
	}

	public Set<Concept> getAllParents() {
		Set<Concept> result = new HashSet<Concept>();
		Set<Concept> temp = new HashSet<Concept>();
		temp.add(this);
		while ( temp.size() > 0 ) {
			Concept concept = pickOne(temp);
			if ( !result.contains(concept)) {
				result.add(concept);
				temp.addAll(concept.getParents());
			}
		}
		return result;
	}

	public boolean isEntity() {
		return getSimplifiedExtent().size() == 1;
	}

	public boolean isEntityFusion() {
		return getSimplifiedExtent().size() > 1;
	}

	public boolean isNewEntity() {
		return getSimplifiedExtent().size() < 1;
	}
	
	public boolean isGreaterThan(Concept c) {
		return ( this.extent.containsAll(c.extent) );
	}
	
	public boolean isSmallerThan(Concept c) {
		return ( c.extent.containsAll(this.extent) );
	}
	
	public String toString() {
		return "(" + getIntent().toString() + "," + getExtent().toString() + ")";
	}
	
	public int hashCode() {
		return this.intent.hashCode() + this.extent.hashCode();
	}
	
	public boolean equals(Object o) {
		if ( ! (o instanceof Concept) )
			return false;
		else {
			Concept c = (Concept) o;
			boolean extEq = this.extent.equals(c.extent);
			boolean intEq = this.intent.equals(c.intent);
			return extEq && intEq;
		}
	}

	public static Concept pickOne(Set<Concept> concepts) {
		if ( concepts.isEmpty() )
			return null;

		Iterator<Concept> cIt = concepts.iterator();
		Concept tmp = cIt.next();
		cIt.remove();
		return tmp;
	}

}
