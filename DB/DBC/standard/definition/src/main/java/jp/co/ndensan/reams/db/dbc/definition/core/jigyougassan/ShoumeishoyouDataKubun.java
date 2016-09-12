/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jigyougassan;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業高額合算_証明書用データ区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 huzongcheng
 */
public enum ShoumeishoyouDataKubun {

    /**
     * コード:1 名称:"" 略称:定義なし
     */
    空白("0", ""),
    /**
     * コード:1 名称:証明書用 略称:定義なし
     */
    証明書用("1", "証明書用");

    private final RString code;
    private final RString fullName;

    private ShoumeishoyouDataKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 事業高額合算_証明書用データ区分のコードを返します。
     *
     * @return 事業高額合算_証明書用データ区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 事業高額合算_証明書用データ区分の名称を返します。
     *
     * @return 事業高額合算_証明書用データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事業高額合算_証明書用データ区分のコードと一致する内容を探します。
     *
     * @param code 事業高額合算_証明書用データ区分のコード
     * @return {@code code} に対応する事業高額合算_証明書用データ区分
     */
    public static ShoumeishoyouDataKubun toValue(RString code) {
        for (ShoumeishoyouDataKubun shoumeishoyoudatakubun : ShoumeishoyouDataKubun.values()) {
            if (shoumeishoyoudatakubun.code.equals(code)) {
                return shoumeishoyoudatakubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業高額合算_証明書用データ区分"));
    }
}
