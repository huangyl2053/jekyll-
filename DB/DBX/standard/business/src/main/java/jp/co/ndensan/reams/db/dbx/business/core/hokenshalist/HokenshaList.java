/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.hokenshalist;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * {@link HokenshaSummary}の集合を扱います。
 */
public final class HokenshaList implements Iterable<HokenshaSummary> {

    private final List<HokenshaSummary> list;
    private final Map<LasdecCode, HokenshaSummary> map;
    private final boolean isKoikiFlag;

    private HokenshaList(List<? extends HokenshaSummary> list, boolean is広域) {
        this.map = createLasdecCodeMap(list);
        if (this.map.size() != list.size()) {
            throw new IllegalArgumentException("引数のlistに市町村コードの重複があります。");
        }
        this.list = Collections.<HokenshaSummary>unmodifiableList(list);
        this.isKoikiFlag = is広域;
    }

    private static Map<LasdecCode, HokenshaSummary> createLasdecCodeMap(List<? extends HokenshaSummary> list) {
        Map<LasdecCode, HokenshaSummary> map = new HashMap<>();
        for (HokenshaSummary s : list) {
            map.put(s.get市町村コード(), s);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 広域用のインスタンスを生成します。
     *
     * @param list 保険者のリスト
     * @return 広域用の{@link HokenshaList}
     * @throws IllegalArgumentException 引数のlistの要素に市町村コードの重複がある場合
     */
    public static HokenshaList createFor広域(List<? extends HokenshaSummary> list) {
        return new HokenshaList(list, true);
    }

    /**
     * 単一市町村用のインスタンスを生成します。
     *
     * @param list 保険者のリスト
     * @return 単一市町村用の{@link HokenshaList}
     * @throws IllegalArgumentException 引数のlistの要素に市町村コードの重複がある場合
     */
    public static HokenshaList createFor単一(List<? extends HokenshaSummary> list) {
        return new HokenshaList(list, false);
    }

    /**
     * 広域の場合{@code true}を返却します。
     *
     * @return 広域の場合{@code true}
     */
    public boolean is広域() {
        return this.isKoikiFlag;
    }

    /**
     * 件数を返します。
     *
     * @return 件数
     */
    public int size() {
        return this.list.size();
    }

    /**
     * 指定の市町村コードに該当する保険者の情報を返却します。
     *
     * @param lasdecCode 市町村コード
     * @return 指定の市町村コードに該当する保険者の情報
     * @throws NoSuchElementException 指定の市町村コードに該当する保険者の情報を保持しない場合
     */
    public HokenshaSummary get(LasdecCode lasdecCode) {
        if (!this.map.containsKey(lasdecCode)) {
            throw new NoSuchElementException("指定の市町村コードに該当する要素は存在しません。");
        }
        return this.map.get(lasdecCode);
    }

    /**
     * 保持する要素をListで返却します。
     * 返されるListに対する要素の追加や削除等の変更は不可です。
     *
     * @return 保持する要素をすべて保持したList
     */
    public List<HokenshaSummary> getAll() {
        return Collections.unmodifiableList(list);
    }

    @Override
    public Iterator<HokenshaSummary> iterator() {
        return this.list.iterator();
    }
}
