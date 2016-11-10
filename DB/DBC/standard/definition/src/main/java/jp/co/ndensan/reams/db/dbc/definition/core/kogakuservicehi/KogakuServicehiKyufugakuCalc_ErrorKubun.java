/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kogakuservicehi;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費給付額算出_エラー区分を表す列挙型です。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
public enum KogakuServicehiKyufugakuCalc_ErrorKubun {

    /**
     * コード:02 名称:被保険者台帳なし 略称:無
     */
    被保険者台帳なし("02", "被保険者台帳なし"),
    /**
     * コード:21 名称:支払方法変更適用期間内 略称:無
     */
    支払方法変更適用期間内("21", "支払方法変更適用期間内");

    private final RString code;
    private final RString fullName;

    private KogakuServicehiKyufugakuCalc_ErrorKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額介護サービス費給付額算出_エラー区分のコードを返します。
     *
     * @return 高額介護サービス費給付額算出_エラー区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額介護サービス費給付額算出_エラー区分の名称を返します。
     *
     * @return 高額介護サービス費給付額算出_エラー区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額介護サービス費給付額算出_エラー区分のコードと一致する内容を探します。
     *
     * @param code 高額介護サービス費給付額算出_エラー区分のコード
     * @return {@code code} に対応する高額介護サービス費給付額算出_エラー区分
     */
    public static KogakuServicehiKyufugakuCalc_ErrorKubun toValue(RString code) {
        for (KogakuServicehiKyufugakuCalc_ErrorKubun shutsuryokuHoho : KogakuServicehiKyufugakuCalc_ErrorKubun.values()) {
            if (shutsuryokuHoho.code.equals(code)) {
                return shutsuryokuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額介護サービス費給付額算出_エラー区分"));
    }
}
