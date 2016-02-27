/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.otheraddressledger;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * @author wangjie2
 */
public final class OtherAddressInformationParameter {

    private final ShikibetsuCode shikibetsuCode;

    public ShikibetsuCode getShikibetsuCode() {
        return this.shikibetsuCode;
    }

    private OtherAddressInformationParameter(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    public static OtherAddressInformationParameter createParam_common(ShikibetsuCode shikibetsuCode) {
        return new OtherAddressInformationParameter(shikibetsuCode);
    }

    public static OtherAddressInformationParameter createParam_ServiceOtherAddressInformation(ShikibetsuCode shikibetsuCode) {
        return createParam_common(shikibetsuCode);
    }

}
