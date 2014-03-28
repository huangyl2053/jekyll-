/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ShujiiIkenshoItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.IShujiiIkenshoItem;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;

/**
 * 主治医意見書を編集するクラスです。
 *
 * @author N8156 宮本 康
 * @param <E> IShujiiIkenshoItemKubun
 * @param <T> IShujiiIkenshoItem
 */
public class ShujiiIkenshoEditor<E extends IShujiiIkenshoItemKubun, T extends IShujiiIkenshoItem> {

    private Map<E, T> regulation;
    private final IShujiiIkenshoItemGroup[] itemGroup;

    /**
     * インスタンスを生成します。
     *
     * @param ikensho 意見書
     */
    public ShujiiIkenshoEditor(ShujiiIkensho<E, T> ikensho) {
        this.regulation = ikensho.get意見書定義();
        this.itemGroup = ikensho.get意見書項目グループ();
    }

    /**
     * 意見書項目を設定します。
     *
     * @param item 意見書項目
     */
    public void setItem(T item) {
        if (item != null) {
            regulation.put((E) item.get意見書項目区分(), item);
        }
    }

    /**
     * 意見書結果を設定します。
     *
     * @param itemKubun 意見書項目区分
     * @param result 意見書結果（RString型）
     */
    public void setResult(E itemKubun, RString result) {
        ShujiiIkenshoItem item = (ShujiiIkenshoItem) regulation.get(itemKubun);
        if (item != null) {
            regulation.put(itemKubun, (T) new ShujiiIkenshoItemForResult(item, result));
        }
    }

    /**
     * 意見書結果を設定します。
     *
     * @param itemKubun 意見書項目区分
     * @param result 意見書結果（int型）
     */
    public void setResult(E itemKubun, int result) {
        ShujiiIkenshoItem item = (ShujiiIkenshoItem) regulation.get(itemKubun);
        if (item != null) {
            regulation.put(itemKubun, (T) new ShujiiIkenshoItemForResult(item, new RString(String.valueOf(result))));
        }
    }

    /**
     * 意見書結果を設定します。
     *
     * @param itemKubun 意見書項目区分
     * @param result 意見書結果（boolean型）
     */
    public void setResult(E itemKubun, boolean result) {
        ShujiiIkenshoItem item = (ShujiiIkenshoItem) regulation.get(itemKubun);
        if (item != null) {
            regulation.put(itemKubun, (T) new ShujiiIkenshoItemForResult(item, new RString(result ? "1" : "0")));
        }
    }

    /**
     * 意見書結果をRString型で返します。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果（RString型）
     */
    public RString getResultByString(E itemKubun) {
        ShujiiIkenshoItemForResult result = (ShujiiIkenshoItemForResult) regulation.get(itemKubun);
        return result == null ? null : result.get意見書結果();
    }

    /**
     * 意見書結果をint型で返します。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果（int型）
     */
    public int getResultByInt(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 意見書結果をCode型で返します。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果（Code型）
     */
    public Code getResultByCode(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? null : new Code(result);
    }

    /**
     * 意見書結果をboolean型で返します。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果（boolean型）
     */
    public boolean getResultByBool(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? false : !result.equals(new RString("0"));
    }

    /**
     * 意見書のインスタンスを生成して返します。
     *
     * @return 意見書
     */
    public ShujiiIkensho<E, T> getShujiiIkensho() {
        return new ShujiiIkensho(regulation, itemGroup);
    }
}
