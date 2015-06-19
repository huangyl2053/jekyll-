/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 削除事由の列挙型です
 *
 * @author n8235
 */
public enum SakujoJiyuCode implements IRStringConvertable {

    /**
     * 過誤による削除 <br />
     * コード : 01
     */
    過誤による削除("01"),
    /**
     * 資格喪失による削除 <br />
     * コード : 02
     */
    資格喪失による削除("02"),
    /**
     * 変更申請による削除 <br />
     * コード : 03
     */
    変更申請による削除("03"),
    /**
     * 再調査による削除 <br />
     * コード : 04
     */
    再調査による削除("04"),
    /**
     * 不服申立による削除 <br />
     * コード : 05
     */
    不服申立による削除("05"),
    //    認定取下げによる削除("06"),

    /**
     * 認定取下げによる削除 <br />
     * コード : 09
     */
    認定取下げによる削除("09");

    private final RString code;

    private SakujoJiyuCode(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.code;
    }

    /**
     * 指定のコードに対応するSakujoJiyuCodeを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するSakujoJiyuCode
     * @throws IllegalArgumentException 指定のコードに対応するSakujoJiyuCodeがないとき
     */
    public static SakujoJiyuCode toValue(RString code) throws IllegalArgumentException {
        for (SakujoJiyuCode target : values()) {
            if (target.code().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する課税区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
