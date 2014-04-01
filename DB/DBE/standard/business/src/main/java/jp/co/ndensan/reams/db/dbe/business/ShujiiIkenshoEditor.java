/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.IShujiiIkenshoItem;
import jp.co.ndensan.reams.db.dbe.definition.ShujiiIkenshoItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
     * 意見書結果を設定します。<br />
     * 意見書結果が設定済みの場合は上書きします。指定した意見書項目が存在しない場合、意見書結果は設定しません。
     *
     * @param itemKubun 意見書項目区分
     * @param result 意見書結果（RString型）
     */
    public void setResult(E itemKubun, RString result) {
        T item = regulation.get(itemKubun);
        if (item != null) {
            ShujiiIkenshoItem newItem = item.is意見書結果項目() ? ((ShujiiIkenshoItemForResult) item).get意見書項目() : (ShujiiIkenshoItem) item;
            regulation.put(itemKubun, (T) new ShujiiIkenshoItemForResult(newItem, result));
        }
    }

    /**
     * 意見書結果を設定します。<br />
     * 意見書結果が設定済みの場合は上書きします。指定した意見書項目が存在しない場合、意見書結果は設定しません。
     *
     * @param itemKubun 意見書項目区分
     * @param result 意見書結果（int型）
     */
    public void setResult(E itemKubun, int result) {
        setResult(itemKubun, new RString(String.valueOf(result)));
    }

    /**
     * 意見書結果を設定します。<br />
     * 意見書結果が設定済みの場合は上書きします。指定した意見書項目が存在しない場合、意見書結果は設定しません。
     *
     * @param itemKubun 意見書項目区分
     * @param result 意見書結果（boolean型）
     */
    public void setResult(E itemKubun, boolean result) {
        setResult(itemKubun, new RString(result ? "1" : "0"));
    }

    /**
     * 意見書結果を返します。<br />
     * 事前にisResultSetメソッドを使用して意見書結果が設定済みであることを確認した上で呼び出して下さい。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果をRString型で返します。指定した意見書項目が存在しない場合、または意見書結果が未設定の場合はnullを返します。
     */
    public RString getResultByString(E itemKubun) {
        T result = regulation.get(itemKubun);
        return result == null || !result.is意見書結果項目() ? null : ((ShujiiIkenshoItemForResult) result).get意見書結果();
    }

    /**
     * 意見書結果を返します。<br />
     * 事前にisResultSetメソッドを使用して意見書結果が設定済みであることを確認した上で呼び出して下さい。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果をint型で返します。指定した意見書項目が存在しない場合、または意見書結果が未設定の場合は0を返します。
     */
    public int getResultByInt(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 意見書結果を返します。<br />
     * 事前にisResultSetメソッドを使用して意見書結果が設定済みであることを確認した上で呼び出して下さい。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果をCode型で返します。指定した意見書項目が存在しない場合、または意見書結果が未設定の場合はnullを返します。
     */
    public Code getResultByCode(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? null : new Code(result);
    }

    /**
     * 意見書結果を返します。<br />
     * 事前にisResultSetメソッドを使用して意見書結果が設定済みであることを確認した上で呼び出して下さい。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果をboolean型（"0"以外:true、"0":false）で返します。指定した意見書項目が存在しない場合、または意見書結果が未設定の場合はfalseを返します。
     */
    public boolean getResultByBool(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? false : !result.equals(new RString("0"));
    }

    /**
     * 意見書結果が設定されているかどうか判定します。
     *
     * @param itemKubun 意見書項目区分
     * @return 意見書結果が設定済みの場合はtrueを返します。指定した意見書項目が存在しない場合、または意見書結果が未設定の場合はfalseを返します。
     */
    public boolean isResultSet(E itemKubun) {
        T result = regulation.get(itemKubun);
        return result != null && result.is意見書結果項目();
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
