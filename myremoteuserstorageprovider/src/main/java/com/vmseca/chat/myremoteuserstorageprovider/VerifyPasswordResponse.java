package com.vmseca.chat.myremoteuserstorageprovider;

/**
*
* @author sergeykargopolov
*/
public class VerifyPasswordResponse {
   private boolean result;
   
   // if you dont add this, cannot deserialize it from the object value, even
   // though the defaukt object creator exists
   public VerifyPasswordResponse() {}

   public VerifyPasswordResponse(boolean result) {
		this.result = result;
	}

	public boolean getResult() {
       return result;
   }

   public void setResult(boolean result) {
       this.result = result;
   }

}