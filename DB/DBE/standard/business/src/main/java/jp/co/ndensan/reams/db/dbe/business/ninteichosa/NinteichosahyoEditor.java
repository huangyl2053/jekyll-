/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;

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
     * 調査結果を設定します。
     *
     * @param itemKubun 調査項目区分
     * @param result 調査結果（RString型）
     */
    public void setResult(E itemKubun, RString result) {
        NinteichosaItem item = (NinteichosaItem) regulation.get(itemKubun);
        if (item != null) {
            regulation.put(itemKubun, (T) new NinteichosaItemForResult(item, result));
        }
    }

    /**
     * 調査結果を設定します。
     *
     * @param itemKubun 調査項目区分
     * @param result 調査結果（int型）
     */
    public void setResult(E itemKubun, int result) {
        NinteichosaItem item = (NinteichosaItem) regulation.get(itemKubun);
        if (item != null) {
            regulation.put(itemKubun, (T) new NinteichosaItemForResult(item, new RString(String.valueOf(result))));
        }
    }

    /**
     * 調査結果をRString型で返します。
     *
     * @param itemKubun 調査項目区分
     * @return 調査結果（RString型）
     */
    public RString getResultByString(E itemKubun) {
        NinteichosaItemForResult result = (NinteichosaItemForResult) regulation.get(itemKubun);
        return result == null ? null : result.get調査結果();
    }

    /**
     * 調査結果をint型で返します。
     *
     * @param itemKubun 調査項目区分
     * @return 調査結果（int型）
     */
    public int getResultByInt(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 調査結果をCode型で返します。
     *
     * @param itemKubun 調査項目区分
     * @return 調査結果（Code型）
     */
    public Code getResultByCode(E itemKubun) {
        RString result = getResultByString(itemKubun);
        return result == null ? null : new Code(result);
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
