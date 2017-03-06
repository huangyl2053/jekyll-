/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;

/**
 * 複数の{@link NinteichosahyoTokkijiko}を扱います。
 */
public class NinteichosahyoTokkijikos implements Iterable<NinteichosahyoTokkijiko>, java.io.Serializable {

    final List<NinteichosahyoTokkijiko> elements;

    /**
     * @param elements 保持する要素
     */
    public NinteichosahyoTokkijikos(Collection<? extends NinteichosahyoTokkijiko> elements) {
        this.elements = new ArrayList<>(elements);
    }

    /**
     * @param tokkiJiko 特記事項
     * @return 指定の特記事項に該当する要素のみ
     */
    public NinteichosahyoTokkijikos tokkiJiko(NinteiChosaTokkiJikou tokkiJiko) {
        return new NinteichosahyoTokkijikos(ItemList.of(elements)
                .filter(matches(tokkiJiko))
                .toList());
    }

    /**
     * @return 保持する要素が無い場合、{@code true}.
     */
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    private static IPredicate<NinteichosahyoTokkijiko> matches(final NinteiChosaTokkiJikou o) {
        return new IPredicate<NinteichosahyoTokkijiko>() {
            @Override
            public boolean evaluate(NinteichosahyoTokkijiko t) {
                return Objects.equals(t.get認定調査特記事項番号(), o.get認定調査票_特記情報_認定調査特記事項番号());
            }
        };
    }

    /**
     * @return すべて要素を{@link NinteiChosaTokkiJikou}へ変換した結果（保持する値に重複なし）
     */
    public Set<NinteiChosaTokkiJikou> asTokkiJikoSet() {
        return new HashSet<>(ItemList.of(elements).map(new IFunction<NinteichosahyoTokkijiko, NinteiChosaTokkiJikou>() {
            @Override
            public NinteiChosaTokkiJikou apply(NinteichosahyoTokkijiko t) {
                return t.getTokkiJiko();
            }
        }).toList());
    }

    /**
     * @param remban 連番
     * @return 指定の連番に該当する要素のみ
     */
    public NinteichosahyoTokkijikos remban(int remban) {
        return new NinteichosahyoTokkijikos(ItemList.of(elements)
                .filter(matches(remban))
                .toList());
    }

    private static IPredicate<NinteichosahyoTokkijiko> matches(final int remban) {
        return new IPredicate<NinteichosahyoTokkijiko>() {
            @Override
            public boolean evaluate(NinteichosahyoTokkijiko t) {
                return Objects.equals(t.get認定調査特記事項連番(), remban);
            }
        };
    }

    /**
     * @return
     */
    public Map<Integer, NinteichosahyoTokkijikos> mapByRemban() {
        Map<Integer, NinteichosahyoTokkijikos> result = new HashMap<>();
        for (Map.Entry<Integer, List<NinteichosahyoTokkijiko>> entry
                : groupingByRemban(this.elements).entrySet()) {
            result.put(entry.getKey(), new NinteichosahyoTokkijikos(entry.getValue()));
        }
        return null;
    }

    private static Map<Integer, List<NinteichosahyoTokkijiko>> groupingByRemban(List<NinteichosahyoTokkijiko> tokkiJikos) {
        Map<Integer, List<NinteichosahyoTokkijiko>> map = new HashMap<>();
        for (NinteichosahyoTokkijiko tokki : tokkiJikos) {
            int remban = tokki.get認定調査依頼履歴番号();
            if (!map.containsKey(remban)) {
                map.put(remban, new ArrayList<NinteichosahyoTokkijiko>());
            }
            map.get(remban).add(tokki);
        }
        return map;
    }

    /**
     * @return マスク済みの要素を含む場合、{@code true}.
     */
    public boolean containsMasked() {
        return ItemList.of(elements).anyMatch(Predicates.Maskes);
    }

    /**
     * @return 保持する要素のいずれか
     */
    public Optional<NinteichosahyoTokkijiko> findAny() {
        if (elements.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(this.elements.get(0));
    }

    private enum Predicates implements IPredicate<NinteichosahyoTokkijiko> {

        Maskes {
                    @Override
                    public boolean evaluate(NinteichosahyoTokkijiko t) {
                        return Objects.equals(t.get原本マスク区分(), GenponMaskKubun.マスク.getCode());
                    }
                };
    }

    @Override
    public Iterator<NinteichosahyoTokkijiko> iterator() {
        return this.elements.iterator();
    }
}
