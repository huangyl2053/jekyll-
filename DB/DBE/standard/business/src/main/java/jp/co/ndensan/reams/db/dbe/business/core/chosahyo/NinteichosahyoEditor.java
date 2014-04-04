/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyo;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.INinteichosaItemKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査票を編集するクラスです。
 *
 * @author N8156 宮本 康
 * @param <E> INinteichosaItemKubun
 * @param <T> INinteichosaItem
 */
public class NinteichosahyoEditor<E extends INinteichosaItemKubun, T extends INinteichosaItem> {

    private Map<E, T> regulation;
    private final INinteichosaItemGroup[] itemGroup;

    /**
     * インスタンスを生成します。
     *
     * @param chosahyo 調査票
     */
    public NinteichosahyoEditor(Ninteichosahyo<E, T> chosahyo) {
        this.regulation = chosahyo.get調査票定義();
        this.itemGroup = chosahyo.get調査項目グループ();
    }

    /**
     * 調査項目を設定します。
     *
     * @param item 調査項目
     */
    public void setItem(T item) {
        if (item != null) {
            regulation.put((E) item.get調査項目区分(), item);
        }
    }

    /**
     * 調査結果を設定します。<br />
     * 調査結果が設定済みの場合は上書きします。指定した調査項目が存在しない場合、調査結果は設定しません。
     *
     * @param itemKubun 調査項目区分
     * @param result 調査結果（RString型）
     */
    public void setResult(E itemKubun, RString result) {
        T item = regulation.get(itemKubun);
        if (item != null) {
            NinteichosaItem newItem = item.is調査結果項目() ? ((NinteichosaItemForResult) item).get調査項目() : (NinteichosaItem) item;
            regulation.put(itemKubun, (T) new NinteichosaItemForResult(newItem, result));
        }
    }

    /**
     * 調査結果を設定します。<br />
     * 調査結果が設定済みの場合は上書きします。指定した調査項目が存在しない場合、調査結果は設定しません。
     *
     * @param itemKubun 調査項目区分
     * @param result 調査結果（int型）
     */
    public void setResult(E itemKubun, int result) {
        setResult(itemKubun, new RString(String.valueOf(result)));
    }

    /**
     * 調査結果を返します。<br />
     * 事前にisResultSetメソッドを使用して調査結果が設定済みであることを確認した上で呼び出して下さい。
     *
     * @param itemKubun 調査項目区分
     * @return 調査結果をRString型で返します。指定した調査項目が存在しない場合、または調査結果が未設定の場合はnullを返します。
     */
    public RString getResultByString(E itemKubun) {
        T result = regulation.get(itemKubun);
        return result == null || !result.is調査結果項目() ? null : ((NinteichosaItemForResult) result).get調査結果();
    }

    /**
     * 調査結果を返します。<br />
     * 事前にisResultSetメソッドを使用して調査結果が設定済みであることを確認した上で呼び出して下さい。
     *
     * @param itemKubun 調査項目区分
     * @return 調査結果をint型で返します。指定した調査項目が存在しない場合、または調査結果が未設定の場合は0を返します。
     */
    public int getResultByInt(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 調査結果を返します。<br />
     * 事前にisResultSetメソッドを使用して調査結果が設定済みであることを確認した上で呼び出して下さい。
     *
     * @param itemKubun 調査項目区分
     * @return 調査結果をCode型で返します。指定した調査項目が存在しない場合、または調査結果が未設定の場合はnullを返します。
     */
    public Code getResultByCode(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? null : new Code(result);
    }

    /**
     * 調査結果が設定されているかどうか判定します。
     *
     * @param itemKubun 調査項目区分
     * @return 調査結果が設定済みの場合はtrueを返します。指定した調査項目が存在しない場合、または調査結果が未設定の場合はfalseを返します。
     */
    public boolean isResultSet(E itemKubun) {
        T result = regulation.get(itemKubun);
        return result != null && result.is調査結果項目();
    }

    /**
     * 調査票のインスタンスを生成して返します。
     *
     * @return 調査票
     */
    public Ninteichosahyo<E, T> getNinteichosahyo() {
        return new Ninteichosahyo(regulation, itemGroup);
    }
}
