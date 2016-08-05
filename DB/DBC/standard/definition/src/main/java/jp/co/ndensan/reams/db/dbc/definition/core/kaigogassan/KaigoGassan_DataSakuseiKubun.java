/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kaigogassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算_データ作成区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 zhujun
 */
public enum KaigoGassan_DataSakuseiKubun {

    /**
     * コード:1 名称:1:自己負担額確認情報（括） 略称:定義なし
     */
    自己負担額確認情報括("1", "自己負担額確認情報（括）"),
    /**
     * コード:2 名称:2:国保連 略称:定義なし
     */
    国保連("2", "国保連");

    private final RString code;
    private final RString fullName;

    private KaigoGassan_DataSakuseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額合算_データ作成区分のコードを返します。
     *
     * @return 高額合算_データ作成区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額合算_データ作成区分の名称を返します。
     *
     * @return 高額合算_データ作成区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額合算_データ作成区分のコードと一致する内容を探します。
     *
     * @param code 高額合算_データ作成区分のコード
     * @return {@code code} に対応する高額合算_データ作成区分
     */
    public static KaigoGassan_DataSakuseiKubun toValue(RString code) {

        for (KaigoGassan_DataSakuseiKubun insho : KaigoGassan_DataSakuseiKubun.values()) {
            if (insho.code.equals(code)) {
                return insho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額合算_データ作成区分"));
    }
}
