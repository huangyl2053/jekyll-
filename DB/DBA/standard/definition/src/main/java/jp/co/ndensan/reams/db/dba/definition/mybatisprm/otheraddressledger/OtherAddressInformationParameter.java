/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.otheraddressledger;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 他市町村住所地特例者情報の取得検索keyクラスです。
 *
 * @reamsid_L DBA-0402-020 wangjie2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class OtherAddressInformationParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final RString 保険者種別;

    private OtherAddressInformationParameter(ShikibetsuCode shikibetsuCode, RString 保険者種別) {
        this.shikibetsuCode = shikibetsuCode;
        this.保険者種別 = 保険者種別;
    }

    /**
     * OtherAddressInformationParameterを返します。
     *
     * @param shikibetsuCode shikibetsuCode
     * @param 保険者種別 保険者種別
     * @return OtherAddressInformationParameter
     */
    public static OtherAddressInformationParameter createParam_common(ShikibetsuCode shikibetsuCode, RString 保険者種別) {
        return new OtherAddressInformationParameter(shikibetsuCode, 保険者種別);
    }

    /**
     * OtherAddressInformationParameterを返します。
     *
     * @param shikibetsuCode shikibetsuCode
     * @param 保険者種別 保険者種別
     * @return OtherAddressInformationParameter
     */
    public static OtherAddressInformationParameter createParam_ServiceOtherAddressInformation(
            ShikibetsuCode shikibetsuCode, RString 保険者種別) {
        return createParam_common(shikibetsuCode, 保険者種別);
    }

}
