package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIs;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;

public enum EtCrisisCategory implements JIntIs{
	immediatelyLifeThreatening, 
	
	imminentlyLifeThreatening,
	
	potentiallyLifeThreatening, 
	
	potentiallySerious,
	
	lessUrgent;
	
	public PtBoolean is(){
		return new PtBoolean(this.name() == EtCrisisCategory.immediatelyLifeThreatening.name()||
				this.name() == EtCrisisCategory.imminentlyLifeThreatening.name() ||
				this.name() == EtCrisisCategory.potentiallyLifeThreatening.name() ||
				this.name() == EtCrisisCategory.potentiallySerious.name() ||
				this.name() == EtCrisisCategory.lessUrgent.name() );
	}

}
