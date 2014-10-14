/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 定型文区分の列挙型です。
 *
 * @author n9606 漢那憲作
 */
public enum TeikeibunKubun implements IRStringConvertable {

    /**
     * 特記事項 ("0")
     */
    特記事項(new RString("0")),
    /**
     * 特記事項以外 ("1")
     */
    特記事項以外(new RString("1"));
    private final RString code;

    private TeikeibunKubun(RString kubun) {
        this.code = kubun;
    }

    /**
     * 指定された定型文区分コードに該当する定型文区分を返します。
     *
     * @param kubun 定型文区分コード
     * @return 引数のコードに対応するTeikeibunKubun型のenum
     * @throws IllegalArgumentException 実在しない定型文区分コードの場合
     */
    public static TeikeibunKubun toValue(RString kubun) throws NullPointerException, IllegalArgumentException {

        for (TeikeibunKubun item : TeikeibunKubun.values()) {
            if (item.code.equals(kubun)) {
                return item;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("該当する定型文区分").getMessage());
    }

    /**
     * 定型文区分を返します。
     *
     * @return 定型文区分コード
     */
    public RString getCode() {
        return this.code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}
