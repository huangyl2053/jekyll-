/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医が判断した、意思決定を行うための認知能力に対する評価を表す項目です。
 *
 * @author n8178 城間篤人
 */
public enum NinchiNoryokuKomoku {

    /**
     * 自立していることを表します。
     */
    自立("1"),
    /**
     * 意思決定がいくらか困難であることを表します。
     */
    いくらか困難("2"),
    /**
     * 見守りが必要であることを表します。
     */
    見守りが必要("3"),
    /**
     * 意思決定の判断ができないことを表します。
     */
    判断できない("4"),
    /**
     * 記載が無いことを表します。
     */
    記載無し("9");
    private final RString 項目コード;

    private NinchiNoryokuKomoku(String 項目コード) {
        this.項目コード = new RString(項目コード);
    }

    /**
     * 認知能力評価項目を表すコードを返します。
     *
     * @return 項目コード
     */
    public RString get項目コード() {
        return 項目コード;
    }

    /**
     * 引数に渡された項目コードに対応する、認知能力評価項目を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param 項目コード 項目コード
     * @return 対応する項目
     * @throws IllegalArgumentException 引数に対応する項目が存在しないとき
     */
    public static NinchiNoryokuKomoku toValue(RString 項目コード) throws IllegalArgumentException {
        for (NinchiNoryokuKomoku 認知能力項目 : values()) {
            if (認知能力項目.get項目コード().equals(項目コード)) {
                return 認知能力項目;
            }
        }
        throw new IllegalArgumentException();
    }
}
