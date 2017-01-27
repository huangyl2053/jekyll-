/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;
//CHECKSTYLE IGNORE UnusedImports FOR NEXT 1 LINES
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;

/**
 * 複数の{@link TokkiImageFileName}を扱います。
 */
public class TokkiImageFileNames implements Iterable<TokkiImageFileName> {

    private final List<TokkiImageFileName> elements;

    TokkiImageFileNames(Collection<? extends TokkiImageFileName> collection) {
        this.elements = new ArrayList<>(collection);
    }

    private TokkiImageFileNames() {
        this.elements = new ArrayList<>();
    }

    /**
     * @return 調査項目毎に分類された{@link TokkiImageFileNames}
     */
    public Map<RString, TokkiImageFileNames> groupedByChosaKomokuNo() {
        Map<RString, TokkiImageFileNames> map = new HashMap<>();
        for (TokkiImageFileName file : elements) {
            RString key = file.komokuNo().getChosaKomokuNo();
            if (!map.containsKey(key)) {
                map.put(key, new TokkiImageFileNames());
            }
            map.get(key).add(file);
        }
        return map;
    }

    /**
     * @return 調査項目連番ごとに分類された{@link TokkiImageFileNames}
     */
    public Map<Integer, TokkiImageFileNames> groupedByRemban() {
        Map<Integer, TokkiImageFileNames> map = new HashMap<>();
        for (TokkiImageFileName file : elements) {
            Integer key = file.komokuNo().getRemban();
            if (!map.containsKey(key)) {
                map.put(key, new TokkiImageFileNames());
            }
            map.get(key).add(file);
        }
        return map;
    }

    private boolean add(TokkiImageFileName file) {
        return this.elements.add(file);
    }

    /**
     * @return 保持する値が１つ以上ある場合、いずれかの値
     */
    public Optional<TokkiImageFileName> getAny() {
        return this.elements.isEmpty()
                ? Optional.<TokkiImageFileName>empty()
                : Optional.of(this.elements.get(0));
    }

    /**
     * @return {@link KomokuNo}が空の要素を除外した新しいインスタンス
     */
    public TokkiImageFileNames removedEmptyKomokuNo() {
        List<TokkiImageFileName> list = new ArrayList<>();
        for (TokkiImageFileName a : this.elements) {
            if (!a.komokuNo().isEmpty()) {
                list.add(a);
            }
        }
        return new TokkiImageFileNames(list);
    }

    /**
     * @return {@link KomokuNo}が空の要素だけの新しいインスタンス
     */
    public TokkiImageFileNames onlyEmptyKomokuNo() {
        List<TokkiImageFileName> list = new ArrayList<>();
        for (TokkiImageFileName a : this.elements) {
            if (a.komokuNo().isEmpty()) {
                list.add(a);
            }
        }
        return new TokkiImageFileNames(list);
    }

    /**
     * @return ファイル名の文字列だけの{@link List}
     */
    public List<RString> fileNameValues() {
        List<RString> list = new ArrayList<>();
        for (TokkiImageFileName fileName : this.elements) {
            list.add(fileName.value());
        }
        return list;
    }

    /**
     * @return {@link List}に変換した結果
     */
    public List<TokkiImageFileName> toList() {
        return new ArrayList<>(this.elements);
    }

    @Override
    public Iterator<TokkiImageFileName> iterator() {
        return this.elements.iterator();
    }

    /**
     * @return ファイル数
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * @return 保持する要素が存在しない場合、{@code true}.
     */
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public String toString() {
        return "TokkiImageFileNames{" + "elements=" + elements + '}';
    }
}
