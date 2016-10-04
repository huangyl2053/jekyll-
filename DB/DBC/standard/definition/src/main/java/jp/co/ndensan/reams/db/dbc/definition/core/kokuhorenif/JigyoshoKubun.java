/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事業所区分フラグを表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 pengxingyi
 */
public enum JigyoshoKubun {

    /**
     * コード:7 名称:指定
     */
    指定事業所("7", "指定"),
    /**
     * コード:8 名称:基準該当
     */
    基準該当事業所("8", "基準該当"),
    /**
     * コード:9 名称:地域密着
     */
    地域密着型サービス事業所("9", "地域密着"),
    /**
     * コード:A 名称:総合事業
     */
    介護予防日常生活支援総合事業事業所("A", "総合事業");
    private final RString code;
    private final RString fullName;

    private JigyoshoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 事業所区分のコードを返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 事業所区分の名称を返します。
     *
     * @return 基準収入額適用申請書登録_抽出対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 事業所区分のコードと一致する内容を探します。
     *
     * @param code 基準収入額適用申請書登録_抽出対象のコード
     * @return {@code code} に対応する基準収入額適用申請書登録_抽出対象
     */
    public static JigyoshoKubun toValue(RString code) {

        for (JigyoshoKubun jigyoshoKubun : JigyoshoKubun.values()) {
            if (jigyoshoKubun.code.equals(code)) {
                return jigyoshoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("事業所区分"));
    }
}
