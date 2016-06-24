/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_受給者異動事由を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum JukyushaIF_JukyushaIdoJiyu {

    /**
     * コード:01 名称:受給資格取得 表示名称:受給資格取得
     */
    受給資格取得("01", "受給資格取得"),
    /**
     * コード:02 名称:受給資格喪失 表示名称:受給資格喪失
     */
    受給資格喪失("02", "受給資格喪失"),
    /**
     * コード:03 名称:広域連合における受給者の市町村間転居異動 表示名称:広域連合における受給者の市町村間転居異動
     */
    広域連合における受給者の市町村間転居異動("03", "広域連合における受給者の市町村間転居異動"),
    /**
     * コード:04 名称:合併による新規 表示名称:合併による新規
     */
    合併による新規("04", "合併による新規"),
    /**
     * コード:99 名称:その他異動 表示名称:その他異動
     */
    その他異動("99", "その他異動");

    private final RString code;
    private final RString fullName;

    private JukyushaIF_JukyushaIdoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_受給者異動事由のコードを返します。
     *
     * @return 受給者IF_受給者異動事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_受給者異動事由の名称を返します。
     *
     * @return 受給者IF_受給者異動事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_受給者異動事由のコードと一致する内容を探します。
     *
     * @param code 受給者IF_受給者異動事由のコード
     * @return {@code code} に対応する受給者IF_受給者異動事由
     */
    public static JukyushaIF_JukyushaIdoJiyu toValue(RString code) {

        for (JukyushaIF_JukyushaIdoJiyu jukyushaIF : JukyushaIF_JukyushaIdoJiyu.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_受給者異動事由のコード"));
    }
}
