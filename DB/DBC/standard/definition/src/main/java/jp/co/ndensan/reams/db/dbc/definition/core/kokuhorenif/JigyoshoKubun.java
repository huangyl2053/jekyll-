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
     * コード:7 名称:指定事業所 略称:指定 国保連送付コード:1
     */
    指定事業所("7", "指定事業所", "指定", "1"),
    /**
     * コード:8 名称:基準該当事業所 略称:基準該当 国保連送付コード;2
     */
    基準該当事業所("8", "基準該当事業所", "基準該当", "2"),
    /**
     * コード:9 名称:地域密着型サービス事業所 略称:地域密着 国保連送付コード;5
     */
    地域密着型サービス事業所("9", "地域密着型サービス事業所", "地域密着", "5"),
    /**
     * コード:A 名称:介護予防日常生活支援総合事業事業所 略称:総合事業 国保連送付コード;9
     */
    介護予防日常生活支援総合事業事業所("A", "介護予防日常生活支援総合事業事業所", "総合事業", "9");
    private final RString code;
    private final RString fullName;
    private final RString shortName;
    private final RString kokuhorenSofuCode;

    private JigyoshoKubun(String code, String fullname, String shortName, String kokuhorenSofuCode) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
        this.kokuhorenSofuCode = new RString(kokuhorenSofuCode);
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
     * 事業所区分の略称を返します。
     *
     * @return 事業所区分の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 国保連送付コードを返します。
     *
     * @return 国保連送付コード
     */
    public RString get国保連送付コード() {
        return kokuhorenSofuCode;
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
