/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.ninteichosa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定調査の調査票を扱うクラスです。
 *
 * @author N8156 宮本 康
 * @param <E> Enum
 * @param <T> INinteichosaItem
 */
public class Ninteichosahyo<E extends Enum, T extends INinteichosaItem> {

    private final Map<E, T> 調査票定義;
    private final INinteichosaItemGroup[] 調査項目グループ;

    /**
     * インスタンスを生成します。
     *
     * @param 調査票定義 調査票定義
     * @param 調査項目グループ 調査項目グループ
     */
    public Ninteichosahyo(Map<E, T> 調査票定義, INinteichosaItemGroup[] 調査項目グループ) {
        this.調査票定義 = requireNonNull(調査票定義, Messages.E00001.replace("調査票定義").getMessage());
        this.調査項目グループ = requireNonNull(調査項目グループ, Messages.E00001.replace("調査項目グループ").getMessage());
    }

    /**
     * 引数の調査項目区分に該当する調査項目を返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査項目
     */
    public T get調査項目(E 調査項目区分) {
        return 調査票定義.get(調査項目区分);
    }

    /**
     * 引数の調査項目を調査票定義に設定します。
     *
     * @param 調査項目 調査項目
     */
    public void set調査項目(T 調査項目) {
        if (調査項目 != null) {
            調査票定義.put((E) 調査項目.get調査項目区分(), 調査項目);
        }
    }

    /**
     * 引数の調査項目グループに該当する調査項目リストを返します。
     *
     * @param 調査項目グループ 調査項目グループ
     * @return 調査項目リスト
     */
    public List<T> get調査項目List(INinteichosaItemGroup 調査項目グループ) {
        List<T> list = new ArrayList<>();
        for (T 調査項目 : 調査票定義.values()) {
            if (調査項目.get調査項目グループ().equals(調査項目グループ)) {
                list.add(調査項目);
            }
        }
        return list;
    }

    /**
     * 全調査項目リストを返します。
     *
     * @return 調査項目リスト
     */
    public List<T> get調査項目ListAll() {
        return (List) Arrays.asList(調査票定義.values().toArray());
    }

    /**
     * 調査項目グループを返します。
     *
     * @return 調査項目グループ
     */
    public INinteichosaItemGroup[] get調査項目グループ() {
        return 調査項目グループ.clone();
    }

    /**
     * 調査結果（調査項目単位）のインスタンスを生成して返します。
     *
     * @param 調査項目区分 調査項目区分
     * @param 調査結果 調査結果（RString型）
     * @return 調査結果
     */
    public NinteichosaItemForResult create調査結果(E 調査項目区分, RString 調査結果) {
        INinteichosaItem item = get調査項目(調査項目区分);
        return item == null ? null : new NinteichosaItemForResult(item, 調査結果);
    }

    /**
     * 調査結果（調査項目単位）のインスタンスを生成して返します。
     *
     * @param 調査項目区分 調査項目区分
     * @param 調査結果 調査結果（int型）
     * @return 調査結果
     */
    public NinteichosaItemForResult create調査結果(E 調査項目区分, int 調査結果) {
        return create調査結果(調査項目区分, new RString(String.valueOf(調査結果)));
    }

    /**
     * 引数の調査項目区分に該当する調査結果をRString型で返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査項目
     */
    public RString get調査結果ByStringValue(E 調査項目区分) {
        NinteichosaItemForResult result = (NinteichosaItemForResult) get調査項目(調査項目区分);
        return result == null ? null : result.get調査結果();
    }

    /**
     * 引数の調査項目区分に該当する調査結果をint型で返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査項目
     */
    public int get調査結果ByIntValue(E 調査項目区分) {
        RString result = get調査結果ByStringValue(調査項目区分);
        return result == null ? 0 : Integer.parseInt(result.toString());
    }

    /**
     * 引数の調査項目区分に該当する調査結果をCode型で返します。
     *
     * @param 調査項目区分 調査項目区分
     * @return 調査項目
     */
    public Code get調査結果ByCodeValue(E 調査項目区分) {
        RString result = get調査結果ByStringValue(調査項目区分);
        return result == null ? null : new Code(result);
    }
}
