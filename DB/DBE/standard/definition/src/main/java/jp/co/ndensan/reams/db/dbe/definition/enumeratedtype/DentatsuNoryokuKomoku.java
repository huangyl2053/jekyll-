/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医が判断した、伝達能力に対する評価を表す項目です。
 *
 * @author n8178 城間篤人
 */
public enum DentatsuNoryokuKomoku {

    /**
     * 伝えることができることを表す項目です。
     */
    伝えられる("1"),
    /**
     * 伝達がいくらか困難であることを表す項目です。
     */
    いくらか困難("2"),
    /**
     * 具体的要求に限られることを表す項目です。
     */
    具体的要求に限られる("3"),
    /**
     * 伝えられないことを表す項目です。
     */
    伝えられない("4"),
    /**
     * 記載が無いことを示す項目です。
     */
    記載無し("9");
    private final RString 項目コード;

    private DentatsuNoryokuKomoku(String 項目コード) {
        this.項目コード = new RString(項目コード);
    }

    /**
     * 伝達能力評価項目を表すコードを返します。
     *
     * @return 項目コード
     */
    public RString get項目コード() {
        return 項目コード;
    }

    /**
     * 引数に渡された項目コードに対応する、伝達能力評価項目を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param 項目コード 項目コード
     * @return 対応する項目
     * @throws IllegalArgumentException 引数に対応する項目が存在しないとき
     */
    public static DentatsuNoryokuKomoku toValue(RString 項目コード) throws IllegalArgumentException {
        for (DentatsuNoryokuKomoku 伝達能力項目 : values()) {
            if (伝達能力項目.get項目コード().equals(項目コード)) {
                return 伝達能力項目;
            }
        }
        throw new IllegalArgumentException();
    }
}
