/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業者選択を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum JigyoshaSentaku {

    /**
     * コード:1 名称:計画事業者 略称:定義なし
     */
    計画事業者("1", "計画事業者"),
    /**
     * コード:2 名称:サービス事業者 略称:定義なし
     */
    サービス事業者("2", "サービス事業者"),
    /**
     * コード:2 名称:計画事業者＋サービス事業者 略称:定義なし
     */
    計画事業者とサービス事業者("3", "計画事業者＋サービス事業者");
    private final RString code;
    private final RString fullName;

    private JigyoshaSentaku(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事業者選択のコードを返します。
     *
     * @return 事業者選択のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事業者選択の名称を返します。
     *
     * @return 事業者選択の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事業者選択のコードと一致する内容を探します。
     *
     * @param code 事業者選択のコード
     * @return {@code code} に対応する対象リスト
     */
    public static JigyoshaSentaku toValue(RString code) {
        for (JigyoshaSentaku jigyoshasentaku : JigyoshaSentaku.values()) {
            if (jigyoshasentaku.code.equals(code)) {
                return jigyoshasentaku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業者選択"));
    }
}
