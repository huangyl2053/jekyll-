/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置者を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 tianyh
 */
public enum KyuShochiSha {

    /**
     * コード:1 名称:旧措置含 略称:定義なし
     */
    旧措置含("1", "旧措置含"),
    /**
     * コード:2 名称:旧措置者 略称:定義なし
     */
    旧措置者("2", "旧措置者"),
    /**
     * コード:3 名称:旧措置他 略称:定義なし
     */
    旧措置他("3", "旧措置他");

    private final RString code;
    private final RString fullName;

    private KyuShochiSha(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 旧措置者のコードを返します。
     *
     * @return 旧措置者のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 旧措置者の名称を返します。
     *
     * @return 旧措置者の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置者のコードと一致する内容を探します。
     *
     * @param code 旧措置者のコード
     * @return {@code code} に対応する旧措置者
     */
    public static KyuShochiSha toValue(RString code) {
        for (KyuShochiSha kyakashaKubun : KyuShochiSha.values()) {
            if (kyakashaKubun.code.equals(code)) {
                return kyakashaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対応する旧措置者"));
    }
}
