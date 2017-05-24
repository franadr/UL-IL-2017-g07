package lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.primary;

import lu.uni.lassy.excalibur.examples.icrash.dev.java.system.types.design.JIntIs;
import lu.uni.lassy.excalibur.examples.icrash.dev.java.types.stdlib.PtBoolean;

public enum EtService implements JIntIs{
	
	maternity,
	pediatry,
	adult;
	
	public PtBoolean is(){
		return new PtBoolean(this.name() == EtService.maternity.name() ||
				this.name() == EtService.pediatry.name() ||
				this.name() == EtService.adult.name());
	}
	

}
