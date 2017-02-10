/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.Filterd;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Comparators;

/**
 * 複数の{@link OcrChosa}を扱います。
 */
public final class OcrChosas implements Iterable<OcrChosa> {

    private final List<OcrChosa> records;

    private OcrChosas() {
        this.records = new ArrayList<>();
    }

    /**
     * @param records {@link OcrChosa}のcollection
     */
    public OcrChosas(Collection<? extends OcrChosa> records) {
        this.records = new ArrayList<>(records);
    }

    /**
     * @return 正常な要素と不正な要素に分割した結果
     */
    public Filterd<OcrChosas> filterdNormal() {
        List<OcrChosa> normals = new ArrayList<>();
        List<OcrChosa> brokens = new ArrayList<>();
        for (OcrChosa chosa : this) {
            if (chosa.isBroken()) {
                brokens.add(chosa);
            } else {
                normals.add(chosa);
            }
        }
        return new Filterd<>(new OcrChosas(normals), new OcrChosas(brokens));
    }

    /**
     * 保持する{@link OcrChosa}が持つ、特記事項のファイル名と項目番号の全ペアを返します。
     * その過程で、同一調査項目に連番の重複があれば、連番を再付番します。
     *
     * @return 保持する{@link OcrChosa}が持つ、特記事項のファイル名と項目番号の全ペア.
     */
    public OcrTokkiJikoColumns editedFileNames連番再付番() {
        return editFileNames連番重複時再付番(this.records);
    }

    //<editor-fold defaultstate="collapsed" desc="editFileNames連番重複時再付番()">
    private static OcrTokkiJikoColumns editFileNames連番重複時再付番(Collection<? extends OcrChosa> records) {
        List<OcrTokkiJikoColumn> list = new ArrayList<>();
        for (List<OcrTokkiJikoColumn> sameChosaKomokus
                : groupingByChosaKomokuNo(imageFileNames(records)).values()) {
            list.addAll(renumberDuplicateRembanIn(sameChosaKomokus));
        }
        return new OcrTokkiJikoColumns(list);
    }

    private static List<OcrTokkiJikoColumn> imageFileNames(Collection<? extends OcrChosa> records) {
        List<OcrTokkiJikoColumn> columns = new ArrayList<>();
        for (OcrChosa record : records) {
            columns.addAll(record.get特記事項Columns().removedEmptyKomokuNo().toList());
        }
        return columns;
    }

    private static Map<RString, List<OcrTokkiJikoColumn>> groupingByChosaKomokuNo(Collection<? extends OcrTokkiJikoColumn> imageFileNames) {
        Map<RString, List<OcrTokkiJikoColumn>> map = new HashMap<>();
        for (OcrTokkiJikoColumn column : imageFileNames) {
            RString chosaKomokuNo = column.komokuNo().getChosaKomokuNo();
            if (chosaKomokuNo.isEmpty()) {
                continue;
            }
            if (!map.containsKey(chosaKomokuNo)) {
                map.put(chosaKomokuNo, new ArrayList<OcrTokkiJikoColumn>());
            }
            map.get(chosaKomokuNo).add(column);
        }
        return map;
    }

    private static Collection<OcrTokkiJikoColumn> renumberDuplicateRembanIn(List<OcrTokkiJikoColumn> sameChosaKomokus) {
        Collections.sort(sameChosaKomokus, new Comparators.MultiComparator<>(komokuNoAsc(), sheetIDAsc()));
        Map<Integer, OcrTokkiJikoColumn> result = new HashMap<>();
        for (OcrTokkiJikoColumn column : sameChosaKomokus) {
            int newRemban = column.komokuNo().getRemban();
            while (result.containsKey(newRemban)) {
                newRemban++;
            }
            result.put(newRemban,
                    new OcrTokkiJikoColumn(column, column.komokuNo().renumbered(newRemban))
            );
        }
        return result.values();
    }

    private static Comparator<OcrTokkiJikoColumn> komokuNoAsc() {
        return new Comparator<OcrTokkiJikoColumn>() {
            @Override
            public int compare(OcrTokkiJikoColumn o1, OcrTokkiJikoColumn o2) {
                return o1.komokuNo().compareTo(o2.komokuNo());
            }
        };
    }

    private static Comparator<OcrTokkiJikoColumn> sheetIDAsc() {
        return new Comparator<OcrTokkiJikoColumn>() {
            @Override
            public int compare(OcrTokkiJikoColumn o1, OcrTokkiJikoColumn o2) {
                return o1.sheetID().compareTo(o2.sheetID());
            }
        };
    }
    //</editor-fold>

    /**
     * @return {@link OCRID}毎にグループ分けした結果
     */
    public OcrChosasByOCRID groupingByOCRID() {
        Map<OCRID, OcrChosas> map = new HashMap<>();
        for (OcrChosa v : this) {
            OCRID ocrID = v.getOCRID();
            if (!map.containsKey(ocrID)) {
                map.put(ocrID, new OcrChosas());
            }
            map.get(ocrID).add(v);
        }
        return new OcrChosasByOCRID(map);
    }

    private boolean add(OcrChosa ocrChosa) {
        return this.records.add(ocrChosa);
    }

    @Override
    public Iterator<OcrChosa> iterator() {
        return this.records.iterator();
    }

    /**
     * @return 要素の件数
     */
    public int size() {
        return this.records.size();
    }

    /**
     * @return 1件の要素も保持しない場合、{@code true}.
     */
    public boolean isEmpty() {
        return this.records.isEmpty();
    }

    /**
     * @return {@link List}へ変換した結果
     */
    public List<OcrChosa> toList() {
        return new ArrayList<>(this.records);
    }

    /**
     * @return 先頭の要素(存在しない場合あり)
     */
    public Optional<OcrChosa> findFirst() {
        return this.records.isEmpty()
                ? Optional.<OcrChosa>empty()
                : Optional.ofNullable(this.records.get(0));
    }

    /**
     * @param sheetID シートID（帳票連番）
     * @return 指定のシートIDに該当する要素が存在する場合、その要素
     */
    public Optional<OcrChosa> findBySheetID(SheetID sheetID) {
        for (OcrChosa ocrChosa : this) {
            if (Objects.equals(sheetID, ocrChosa.getSheetID())) {
                return Optional.of(ocrChosa);
            }
        }
        return Optional.empty();
    }
}
