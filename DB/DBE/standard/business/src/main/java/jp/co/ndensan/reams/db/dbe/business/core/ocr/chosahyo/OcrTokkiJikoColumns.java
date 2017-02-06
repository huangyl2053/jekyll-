/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
//CHECKSTYLE IGNORE UnusedImports FOR NEXT 1 LINES
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;

/**
 * 複数の{@link OcrTokkiJikoColumn}を扱います。
 */
public class OcrTokkiJikoColumns implements Iterable<OcrTokkiJikoColumn> {

    private final List<OcrTokkiJikoColumn> elements;

    OcrTokkiJikoColumns(Collection<? extends OcrTokkiJikoColumn> collection) {
        this.elements = new ArrayList<>(collection);
    }

    private OcrTokkiJikoColumns() {
        this.elements = new ArrayList<>();
    }

    public List<RString> lightJoinByColumnNo(List<RString> imageFileNames) {
        List<RString> list = new ArrayList<>();
        for (OcrTokkiJikoColumn column : this) {
            int index = column.colmunNo();
            if (imageFileNames.size() <= index) {
                continue;
            }
            list.add(imageFileNames.get(index));
        }
        return list;
    }

    /**
     *
     * @param sheetID
     * @return
     */
    public OcrTokkiJikoColumns filteredBySheetID(SheetID sheetID) {
        List<OcrTokkiJikoColumn> list = new ArrayList<>();
        for (OcrTokkiJikoColumn column : this) {
            if (Objects.equals(column.sheetID(), sheetID)) {
                list.add(column);
            }
        }
        return new OcrTokkiJikoColumns(list);
    }

    public OcrTokkiJikoColumns filteredBySheetIDs(Collection<? extends SheetID> sheetIDs) {
        List<OcrTokkiJikoColumn> list = new ArrayList<>();
        for (OcrTokkiJikoColumn column : this) {
            if (sheetIDs.contains(column.sheetID())) {
                list.add(column);
            }
        }
        return new OcrTokkiJikoColumns(list);
    }

    public OcrTokkiJikoColumns filterdByAnyOcrData(Iterable<? extends IOcrData> anyOcrData) {
        return filteredBySheetIDs(toSheetIDs(anyOcrData));
    }

    private static Set<SheetID> toSheetIDs(Iterable<? extends IOcrData> anyOcrData) {
        Set<SheetID> set = new HashSet<>();
        for (IOcrData ocrData : anyOcrData) {
            set.add(ocrData.getSheetID());
        }
        return set;
    }

    /**
     * @return 調査項目毎に分類された{@link OcrTokkiJikoColumns}
     */
    public Map<RString, OcrTokkiJikoColumns> groupedByChosaKomokuNo() {
        Map<RString, OcrTokkiJikoColumns> map = new HashMap<>();
        for (OcrTokkiJikoColumn column : elements) {
            RString key = column.komokuNo().getChosaKomokuNo();
            if (!map.containsKey(key)) {
                map.put(key, new OcrTokkiJikoColumns());
            }
            map.get(key).add(column);
        }
        return map;
    }

    /**
     * @return 調査項目連番ごとに分類された{@link OcrTokkiJikoColumns}
     */
    public Map<Integer, OcrTokkiJikoColumns> groupedByRemban() {
        Map<Integer, OcrTokkiJikoColumns> map = new HashMap<>();
        for (OcrTokkiJikoColumn column : elements) {
            Integer key = column.komokuNo().getRemban();
            if (!map.containsKey(key)) {
                map.put(key, new OcrTokkiJikoColumns());
            }
            map.get(key).add(column);
        }
        return map;
    }

    private boolean add(OcrTokkiJikoColumn column) {
        return this.elements.add(column);
    }

    /**
     * @return 保持する値が１つ以上ある場合、いずれかの値
     */
    public Optional<OcrTokkiJikoColumn> getAny() {
        return this.elements.isEmpty()
                ? Optional.<OcrTokkiJikoColumn>empty()
                : Optional.of(this.elements.get(0));
    }

    /**
     * @return {@link KomokuNo}が空の要素を除外した新しいインスタンス
     */
    public OcrTokkiJikoColumns removedEmptyKomokuNo() {
        List<OcrTokkiJikoColumn> list = new ArrayList<>();
        for (OcrTokkiJikoColumn a : this.elements) {
            if (!a.komokuNo().isEmpty()) {
                list.add(a);
            }
        }
        return new OcrTokkiJikoColumns(list);
    }

    public OcrTokkiJikoColumns findRembanRenumberd() {
        List<OcrTokkiJikoColumn> list = new ArrayList<>();
        for (OcrTokkiJikoColumn a : this.elements) {
            if (a.komokuNo().hasRenumberd()) {
                list.add(a);
            }
        }
        return new OcrTokkiJikoColumns(list);
    }

    /**
     * @return {@link KomokuNo}が空の要素だけの新しいインスタンス
     */
    public OcrTokkiJikoColumns onlyEmptyKomokuNo() {
        List<OcrTokkiJikoColumn> list = new ArrayList<>();
        for (OcrTokkiJikoColumn a : this.elements) {
            if (a.komokuNo().isEmpty()) {
                list.add(a);
            }
        }
        return new OcrTokkiJikoColumns(list);
    }

    /**
     * @return {@link List}に変換した結果
     */
    public List<OcrTokkiJikoColumn> toList() {
        return new ArrayList<>(this.elements);
    }

    /**
     * @return 保持する{@link KomokuNo}すべて
     */
    public List<KomokuNo> asKomokuNos() {
        List<KomokuNo> list = new ArrayList<>();
        for (OcrTokkiJikoColumn e : this) {
            list.add(e.komokuNo());
        }
        return list;
    }

    /**
     * @param komokuNos 取り除きたい{@link KomokuNo}の{@link Collection}
     * @return 指定の{@link KomokuNo}をすべて取り除いた新しい{@link OcrTokkiJikoColumns}
     */
    public OcrTokkiJikoColumns removed(Collection<? extends KomokuNo> komokuNos) {
        List<OcrTokkiJikoColumn> list = new ArrayList<>();
        for (OcrTokkiJikoColumn a : this) {
            if (komokuNos.contains(a.komokuNo())) {
                continue;
            }
            list.add(a);
        }
        return new OcrTokkiJikoColumns(list);
    }

    @Override
    public Iterator<OcrTokkiJikoColumn> iterator() {
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

}
