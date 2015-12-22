/**
 * Copyright 2011-2015 DEIB - Politecnico di Milano
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Acknowledgements:
 * We would like to thank Davide Barbieri, Emanuele Della Valle,
 * Marco Balduini, Soheila Dehghanzadeh, Shen Gao, and
 * Daniele Dell'Aglio for the effort in the development of the software.
 *
 * This work is partially supported by
 * - the European LarKC project (FP7-215535) of DEIB, Politecnico di
 * Milano
 * - the ERC grant “Search Computing” awarded to prof. Stefano Ceri
 * - the European ModaClouds project (FP7-ICT-2011-8-318484) of DEIB,
 * Politecnico di Milano
 * - the IBM Faculty Award 2013 grated to prof. Emanuele Della Valle;
 * - the City Data Fusion for Event Management 2013 project funded
 * by EIT Digital of DEIB, Politecnico di Milano
 * - the Dynamic and Distributed Information Systems Group of the
 * University of Zurich;
 * - INSIGHT NUIG and Science Foundation Ireland (SFI) under grant
 * No. SFI/12/RC/2289
 */
package eu.larkc.csparql.ui;

import java.util.Observable;

import eu.larkc.csparql.common.RDFTable;
import eu.larkc.csparql.core.ResultFormatter;

public class CounterFormatter extends ResultFormatter {

	private int count = 0;
	private long start = 0;


	//   public void update(final GenericObservable<RDFTable> observed, final RDFTable q) {
	//
	//      if (this.start == 0) {
	//         this.start = System.nanoTime();
	//      }
	//
	//      this.count += q.size();
	//      float timePast = (float) (System.nanoTime() - this.start);
	//      final float freq = (float) this.count / timePast * 1000000000;
	//      
	//      if (timePast>10000000000f) {
	//       this.start = System.nanoTime();
	//       this.count = 0;
	//       System.out.println(freq);
	//      }
	//
	////      if (this.count % 1000 == 0) 
	////    	  System.out.println(freq + " CSPARQL Results/sec");
	//    	  
	//    	  
	//      
	//   }


	@Override
	public void update(Observable o, Object arg) {
		
		RDFTable q = (RDFTable) arg;
		
		if (this.start == 0) {
			this.start = System.nanoTime();
		}

		this.count += q.size();
		float timePast = (float) (System.nanoTime() - this.start);
		final float freq = (float) this.count / timePast * 1000000000;

		if (timePast>10000000000f) {
			this.start = System.nanoTime();
			this.count = 0;
			System.out.println(freq);
		}

	}
}
