/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医が判断した、短期記憶の評価について表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum TankiKiokuKomoku {

    /**
     * 問題が無いことを表します。
     */
    問題無し("1"),
    /**
     * 問題があることを表します。
     */
    問題あり("2"),
    /**
     * 記載が無いことを表します。
     */
    記載無し("9");
    private final RString 項目コード;

    private TankiKiokuKomoku(String 項目コード) {
        this.項目コード = new RString(項目コード);
    }

    /**
     * 短期記憶評価項目を表すコードを返します。
     *
     * @return 項目コード
     */
    public RString get項目コード() {
        return 項目コード;
    }

    /**
     * 引数に渡された項目コードに対応する、短期記憶評価項目を返します。<br>
     * 対応する項目が存在しない場合、IllegalArgumentExceptionが発生します。
     *
     * @param 項目コード 項目コード
     * @return 対応する項目
     * @throws IllegalArgumentException 引数に対応する項目が存在しないとき
     */
    public static TankiKiokuKomoku toValue(RString 項目コード) throws IllegalArgumentException {
        for (TankiKiokuKomoku 短期記憶項目 : values()) {
            if (短期記憶項目.get項目コード().equals(項目コード)) {
                return 短期記憶項目;
            }
        }
        throw new IllegalArgumentException();
    }
}
