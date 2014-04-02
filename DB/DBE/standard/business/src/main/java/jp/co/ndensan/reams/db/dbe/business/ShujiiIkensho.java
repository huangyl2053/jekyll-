/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IShujiiIkenshoItemKubun;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書を扱うクラスです。
 *
 * @author N8156 宮本 康
 * @param <E> IShujiiIkenshoItemKubun
 * @param <T> IShujiiIkenshoItem
 */
public class ShujiiIkensho<E extends IShujiiIkenshoItemKubun, T extends IShujiiIkenshoItem> {

    private final Map<E, T> 意見書定義;
    private final IShujiiIkenshoItemGroup[] 意見書項目グループ;

    /**
     * インスタンスを生成します。
     *
     * @param 意見書定義 意見書定義
     * @param 意見書項目グループ 意見書項目グループ
     */
    public ShujiiIkensho(Map<E, T> 意見書定義, IShujiiIkenshoItemGroup[] 意見書項目グループ) {
        this.意見書定義 = requireNonNull(意見書定義, Messages.E00001.replace("意見書定義").getMessage());
        this.意見書項目グループ = requireNonNull(意見書項目グループ, Messages.E00001.replace("意見書項目グループ").getMessage());
    }

    /**
     * 意見書定義を返します。
     *
     * @return 意見書定義
     */
    public Map<E, T> get意見書定義() {
        return new EnumMap(意見書定義);
    }

    /**
     * 引数の意見書項目区分に該当する意見書項目を返します。
     *
     * @param 意見書項目区分 意見書項目区分
     * @return 意見書項目
     */
    public T get意見書項目(E 意見書項目区分) {
        return 意見書定義.get(意見書項目区分);
    }

    /**
     * 引数の意見書項目グループに該当する意見書項目リストを返します。
     *
     * @param 意見書項目グループ 意見書項目グループ
     * @return 意見書項目リスト
     */
    public List<T> get意見書項目List(IShujiiIkenshoItemGroup 意見書項目グループ) {
        List<T> list = new ArrayList<>();
        for (T 意見書項目 : 意見書定義.values()) {
            if (意見書項目.get意見書項目グループ().equals(意見書項目グループ)) {
                list.add(意見書項目);
            }
        }
        return list;
    }

    /**
     * 全意見書項目リストを返します。
     *
     * @return 意見書項目リスト
     */
    public List<T> get意見書項目ListAll() {
        return Collections.unmodifiableList((List) Arrays.asList(意見書定義.values().toArray()));
    }

    /**
     * 主要意見書項目リストを返します。
     *
     * @return 主要意見書項目リスト
     */
    public List<T> get主要意見書項目List() {
        List<T> list = new ArrayList<>();
        for (T 意見書項目 : 意見書定義.values()) {
            if (意見書項目.is主要意見書項目()) {
                list.add(意見書項目);
            }
        }
        return list;
    }

    /**
     * 意見書項目グループを返します。
     *
     * @return 意見書項目グループ
     */
    public IShujiiIkenshoItemGroup[] get意見書項目グループ() {
        return 意見書項目グループ.clone();
    }
}
