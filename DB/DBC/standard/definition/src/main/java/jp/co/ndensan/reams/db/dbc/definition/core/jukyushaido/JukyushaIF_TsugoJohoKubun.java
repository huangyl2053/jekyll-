/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者IF_突合情報区分を表す列挙型です。
 *
 *  @reamsid_L DBC-2760-010 jianglaisheng
 */
public enum JukyushaIF_TsugoJohoKubun {
 
    /**
     * コード:1 名称:保険者保有受給者情報 表示名称:保険者保有受給者情報
     */
    保険者保有受給者情報("1", "保険者保有受給者情報"),
    
    /**
     * コード:２ 名称:国保連保有受給者情報 表示名称:国保連保有受給者情報
     */
    国保連保有受給者情報("2", "国保連保有受給者情報");
    
    private final RString code;
    private final RString fullName;
    
    private JukyushaIF_TsugoJohoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給者IF_突合情報区分を返します。
     *
     * @return 受給者IF_突合情報区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給者IF_突合情報区分の名称を返します。
     *
     * @return 受給者IF_突合情報区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給者IF_突合情報区分のコードと一致する内容を探します。
     *
     * @param code 受給者IF_突合情報区分のコード
     * @return {@code code} に対応する受受給者IF_突合情報区分
     */
    public static JukyushaIF_TsugoJohoKubun toValue(RString code) {

        for (JukyushaIF_TsugoJohoKubun jukyushaIF : JukyushaIF_TsugoJohoKubun.values()) {
            if (jukyushaIF.code.equals(code)) {
                return jukyushaIF;
            }
        }
        throw new IllegalArgumentException(
                UrSystemErrorMessages.変換不可.getReplacedMessage("受給者IF_突合情報区分のコード"));
    }
}
