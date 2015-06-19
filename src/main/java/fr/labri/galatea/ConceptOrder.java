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

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ConceptOrder implements Iterable<Concept> {

	protected Set<Concept> concepts;
	
	public ConceptOrder() {
		this.concepts = new LinkedHashSet<Concept>();
	}

	public Set<Concept> getConcepts() {
		return concepts;
	}

	@Override
	public Iterator<Concept> iterator() {
		return concepts.iterator();
	}
	
	public int newEntityNb() {
		int i = 0;
		for ( Concept c: this ) if ( c.isNewEntity() ) i++;
		return i;
	}
	
	public int entityFusionNb() {
		int i = 0;
		for ( Concept c: this ) if ( c.isEntityFusion() ) i++;
		return i;
	}
	
	public int entityNb() {
		int i = 0;
		for ( Concept c: this ) if ( c.isEntity() ) i++;
		return i;
	}

	public int size() {
		return this.concepts.size();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " with " 
			+ size() + " concepts. " + entityNb() + " entity concepts, " 
			+ entityFusionNb() + " entity fusion concepts and "
			+ newEntityNb() + " new entity concepts.";
	}
	
}
