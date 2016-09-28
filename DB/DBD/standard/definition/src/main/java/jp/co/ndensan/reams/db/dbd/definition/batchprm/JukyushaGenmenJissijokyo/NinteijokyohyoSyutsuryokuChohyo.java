/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.batchprm.JukyushaGenmenJissijokyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定状況表出力帳票を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 x_liuwei
 */
public enum NinteijokyohyoSyutsuryokuChohyo {

    /**
     * コード:1 名称:定義なし 略称:定義なし
     */
    受給者減免月別申請認定状況表("1"),
    /**
     * コード:2 名称:定義なし 略称:定義なし
     */
    受給者減免月別認定者数状況表("2");

    private final RString code;

    private NinteijokyohyoSyutsuryokuChohyo(String code) {
        this.code = new RString(code);
    }

    /**
     * 認定状況表出力帳票のコードを返します。
     *
     * @return 障がい者控除認定区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定状況表出力帳票のコードと一致する内容を探します。
     *
     * @param code 認定状況表出力帳票のコード
     * @return {@code code} に対応する認定状況表出力帳票
     */
    public static NinteijokyohyoSyutsuryokuChohyo toValue(RString code) {

        for (NinteijokyohyoSyutsuryokuChohyo chohyo : NinteijokyohyoSyutsuryokuChohyo.values()) {
            if (chohyo.code.equals(code)) {
                return chohyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定状況表出力帳票"));
    }
}
