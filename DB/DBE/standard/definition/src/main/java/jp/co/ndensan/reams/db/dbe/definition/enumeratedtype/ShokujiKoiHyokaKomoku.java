/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医が判断した、食事行為に関する評価項目です。
 *
 * @author n8178 城間篤人
 */
public enum ShokujiKoiHyokaKomoku {

    /**
     * 自立して食事が行える、または何とか自分で食事を取ることができることを表す評価項目です。
     */
    自立ないし何とか自分で食べられる("1"),
    /**
     * 全面介助を表す項目です。
     */
    全面介助("2"),
    /**
     * 記載が無いことを示す項目です。
     */
    記載無し("9");
    private final RString 項目コード;

    private ShokujiKoiHyokaKomoku(String 項目コード) {
        this.項目コード = new RString(項目コード);
    }

    /**
     * 食事行為評価項目を表すコードを返します。
     *
     * @return 項目コード
     */
    public RString get項目コード() {
        return 項目コード;
    }

    /**
     * 引数に渡された項目コードに対応する、食事行為評価項目を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param 項目コード 項目コード
     * @return 対応する項目
     * @throws IllegalArgumentException 引数に対応する項目が存在しないとき
     */
    public static ShokujiKoiHyokaKomoku toValue(RString 項目コード) throws IllegalArgumentException {
        for (ShokujiKoiHyokaKomoku 食事行為評価項目 : values()) {
            if (食事行為評価項目.get項目コード().equals(項目コード)) {
                return 食事行為評価項目;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない.getMessage().replace("対応する食事行為評価項目").evaluate());
    }
}
