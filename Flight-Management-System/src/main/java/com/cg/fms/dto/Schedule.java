package com.cg.fms.dto;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Schedule {
	  @Id
	  @Column(name = "schedule_id")
      private BigInteger scheduleId;
	  
	  @OneToOne
	 // @JoinColumn(name="")
      private Airport srcAirport;
	  
	  @OneToOne
      private Airport dstnAirport;
	  
	  @Column(name = "departure_date")
      private String deptDateTime;
	  
	  @Column(name = "arrival_date")
      private String arrDateTime;
      public Schedule() {
    	  
      }

      public Schedule(BigInteger scheduleId,Airport srcAirport, Airport dstnAirport, String deptDateTime, String arrDateTime) {
    	  super();
    	  this.scheduleId=scheduleId;
    	  this.srcAirport=srcAirport;
    	  this.dstnAirport=dstnAirport;
    	  this.deptDateTime=deptDateTime;
    	  this.arrDateTime=arrDateTime;
      }
	public BigInteger getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(BigInteger scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Airport getSrcAirport() {
		return srcAirport;
	}
	public void setSrcAirport(Airport srcAirport) {
		this.srcAirport = srcAirport;
	}
	public Airport getDstnAirport() {
		return dstnAirport;
	}
	public void setDstnAirport(Airport dstnAirport) {
		this.dstnAirport = dstnAirport;
	}
	public String getDeptDateTime() {
		return deptDateTime;
	}
	public void setDeptDateTime(String deptDateTime) {
		this.deptDateTime = deptDateTime;
	}
	public String getArrDateTime() {
		return arrDateTime;
	}
	public void setArrDateTime(String arrDateTime) {
		this.arrDateTime = arrDateTime;
	}
    @Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", srcAirport=" + srcAirport + ", dstnAirport=" + dstnAirport
				+ ", deptDateTime=" + deptDateTime + ", arrDateTime=" + arrDateTime + "]";
	}
	@Override
	public int hashCode() {
		final int prime=31;
		int result=1;
		result=prime*result+((arrDateTime==null) ? 0 :arrDateTime.hashCode());
		result=prime*result+((deptDateTime==null) ? 0 :deptDateTime.hashCode());
		result=prime*result+((dstnAirport==null) ? 0 :dstnAirport.hashCode());
		result=prime*result+((scheduleId==null) ? 0 :scheduleId.hashCode());
		result=prime*result+((srcAirport==null) ? 0 :srcAirport.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(this==obj)
			return false;
		if(getClass() !=obj.getClass())
			return false;
		Schedule other=(Schedule) obj;
		if(arrDateTime==null) {
			if(other.arrDateTime!=null)
				return false;
		}else if(!arrDateTime.equals(other.arrDateTime))
			return false;
		if(deptDateTime==null) {
			if(other.deptDateTime!=null)
				return false;
		}else if(!deptDateTime.equals(other.deptDateTime))
			return false;
		if(dstnAirport==null) {
			if(other.dstnAirport!=null)
				return false;
		}else if(!dstnAirport.equals(other.dstnAirport))
			return false;
		if(scheduleId==null) {
			if(other.scheduleId!=null)
				return false;
		}else if(!scheduleId.equals(other.scheduleId))
			return false;
		if(srcAirport==null) {
			if(other.srcAirport!=null)
				return false;
		}else if(!srcAirport.equals(other.srcAirport))
			return false;
		return true;
	}
	
	
}
