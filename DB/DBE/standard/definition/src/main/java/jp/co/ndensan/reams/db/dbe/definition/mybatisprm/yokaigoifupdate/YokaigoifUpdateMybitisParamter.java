/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoifupdate;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定IF更新のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-3000-310 jinjue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class YokaigoifUpdateMybitisParamter {

    private final RString 申請書管理番号;
    private final RString 概況調査テキストイメージ区分;

    private YokaigoifUpdateMybitisParamter(RString 申請書管理番号, RString 概況調査テキストイメージ区分) {
        this.申請書管理番号 = 申請書管理番号;
        this.概況調査テキストイメージ区分 = 概況調査テキストイメージ区分;
    }

    /**
     * 要介護認定IF更新のＳＱＬパラメータを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 要介護認定IF更新のパラメータ
     */
    public static YokaigoifUpdateMybitisParamter createParamter(RString 申請書管理番号) {
        return new YokaigoifUpdateMybitisParamter(申請書管理番号, DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援));
    }
}
