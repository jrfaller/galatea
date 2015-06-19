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
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Context {
	
	protected Set<Attribute> attributes;
	
	protected Set<Entity> entities;
	
	protected Map<Entity,Set<Attribute>> relation;
	
	protected Map<Attribute,Set<Entity>> reverseRelation;
	
	public Context() {
		this.attributes = new LinkedHashSet<Attribute>();
		this.entities = new LinkedHashSet<Entity>();
		this.relation = new LinkedHashMap<Entity, Set<Attribute>>();
		this.reverseRelation = new LinkedHashMap<Attribute, Set<Entity>>();
	}
	
	public void addPair(Entity e,Attribute a) {
		if ( !relation.containsKey(e) )
			relation.put(e,new HashSet<Attribute>());
		
		if ( !reverseRelation.containsKey(a) )
			reverseRelation.put(a,new HashSet<Entity>());
		
		relation.get(e).add(a);
		reverseRelation.get(a).add(e);
	}
	
	public boolean hasPair(Entity e,Attribute a) {
		return this.getAttributes(e).contains(a);
	}
	
	public int getPairNb() {
		int p = 0;
		for( Set<Attribute> attrs: relation.values() ) p += attrs.size();
		return p;
	}
	
	public void addAttribute(Attribute a) {
		this.attributes.add(a);
	}
	
	public Set<Attribute> getAttributes(Entity e) {
		if ( relation.containsKey(e) )
			return relation.get(e);
		else
			return new HashSet<Attribute>();
	}
	
	public Set<Attribute> getAttributes() {
		return attributes;
	}
	
	public int getAttributeNb() {
		return attributes.size();
	}
	
	public void addEntity(Entity e) {
		this.entities.add(e);
	}
	
	public Set<Entity> getEntities(Attribute a) {
		if ( reverseRelation.containsKey(a) )
			return reverseRelation.get(a);
		else
			return new HashSet<Entity>();
	}
	
	public Set<Entity> getEntities() {
		return entities;
	}
	
	public int getEntityNb() {
		return entities.size();
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + " with " + getEntityNb() +
		" entities, " + getAttributeNb() + " attributes and " +
		getPairNb() + " pairs in the binary relation.";
	}
	
}
