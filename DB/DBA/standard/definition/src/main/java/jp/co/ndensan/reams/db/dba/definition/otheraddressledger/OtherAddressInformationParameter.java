/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.otheraddressledger;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * 他市町村住所地特例者情報の取得検索keyクラスです。
 *
 * @reamsid_L DBA-0402-020 wangjie2
 */
public final class OtherAddressInformationParameter {

    private final ShikibetsuCode shikibetsuCode;

    /**
     * shikibetsuCodeを返します。
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return this.shikibetsuCode;
    }

    private OtherAddressInformationParameter(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * OtherAddressInformationParameterを返します。
     *
     * @param shikibetsuCode shikibetsuCode
     * @return OtherAddressInformationParameter
     */
    public static OtherAddressInformationParameter createParam_common(ShikibetsuCode shikibetsuCode) {
        return new OtherAddressInformationParameter(shikibetsuCode);
    }

    /**
     * OtherAddressInformationParameterを返します。
     *
     * @param shikibetsuCode shikibetsuCode
     * @return OtherAddressInformationParameter
     */
    public static OtherAddressInformationParameter createParam_ServiceOtherAddressInformation(ShikibetsuCode shikibetsuCode) {
        return createParam_common(shikibetsuCode);
    }

}
