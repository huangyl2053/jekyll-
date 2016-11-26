/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jikosakusei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅・総合事業区分を表す列挙型です。
 *
 * @reamsid_L DBC-1930-010 huangh
 */
public enum Kyotaku_SogyoJigyoKubun {

    /**
     * コード:1 名称:居宅サービス計画 略称:定義なし
     */
    居宅サービス計画("1", "居宅サービス計画"),
    /**
     * コード:2 名称:総合事業費計画 略称:定義なし
     */
    総合事業費計画("2", "総合事業費計画");

    private final RString code;
    private final RString fullName;

    private Kyotaku_SogyoJigyoKubun(String code, String fullName) {
        this.code = new RString(code);
        this.fullName = new RString(fullName);
    }

    /**
     * 事業高額合算_証明書用データ区分のコードを返します。
     *
     * @return 居宅・総合事業区分のコード
     */
    public RString getCode() {
        return code;
    }

    /**
     * 居宅・総合事業区分の名称を返します。
     *
     * @return 事業高額合算_証明書用データ区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 居宅・総合事業区分のコードと一致する内容を探します。
     *
     * @param code 居宅・総合事業区分のコード
     * @return {@code code} に対応する居宅・総合事業区分
     */
    public static Kyotaku_SogyoJigyoKubun toValue(RString code) {
        for (Kyotaku_SogyoJigyoKubun shoumeishoyoudatakubun : Kyotaku_SogyoJigyoKubun.values()) {
            if (shoumeishoyoudatakubun.code.equals(code)) {
                return shoumeishoyoudatakubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("居宅・総合事業区分"));
    }
}
