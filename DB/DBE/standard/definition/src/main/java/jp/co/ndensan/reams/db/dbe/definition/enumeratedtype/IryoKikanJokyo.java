/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 医療機関の状況を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum IryoKikanJokyo {

    /**
     * 有効
     */
    有効(true),
    /**
     * 無効
     */
    無効(false);
    private final boolean is有効;

    private IryoKikanJokyo(boolean is有効) {
        this.is有効 = is有効;
    }

    /**
     * 医療機関の状況をbool値で返します。
     *
     * @return 有効ならtrue、無効ならfalse
     */
    public boolean is有効() {
        return is有効;
    }

    /**
     * 引数からbool値を受け取り、対応した医療機関状況を返します。
     *
     * @param is有効 医療機関の状況を表すbool値
     * @return 医療機関状況
     */
    public IryoKikanJokyo toValue(boolean is有効) {
        return is有効 ? IryoKikanJokyo.有効 : IryoKikanJokyo.無効;
    }
}
