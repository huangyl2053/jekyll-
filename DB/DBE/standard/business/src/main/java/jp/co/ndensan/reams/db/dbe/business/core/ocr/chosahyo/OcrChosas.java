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
import jp.co.ndensan.reams.db.dbe.business.core.ocr.Filterd;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
    public TokkiImageFileNames editedFileNames連番重複再付番() {
        return editFileNames連番重複時再付番(this.records);
    }

    //<editor-fold defaultstate="collapsed" desc="editFileNames連番重複時再付番()">
    private static TokkiImageFileNames editFileNames連番重複時再付番(Collection<? extends OcrChosa> records) {
        List<TokkiImageFileName> list = new ArrayList<>();
        for (List<TokkiImageFileName> fileNames
                : groupingByChosaKomokuNo(imageFileNames(records)).values()) {
            list.addAll(renumberInterlappingRemban(fileNames));
        }
        return new TokkiImageFileNames(list);
    }

    private static List<TokkiImageFileName> imageFileNames(Collection<? extends OcrChosa> records) {
        List<TokkiImageFileName> files = new ArrayList<>();
        for (OcrChosa record : records) {
            files.addAll(record.collectTokkiImageFileNames().removedEmptyKomokuNo().toList());
        }
        return files;
    }

    private static Map<RString, List<TokkiImageFileName>> groupingByChosaKomokuNo(Collection<? extends TokkiImageFileName> imageFileNames) {
        Map<RString, List<TokkiImageFileName>> map = new HashMap<>();
        for (TokkiImageFileName file : imageFileNames) {
            RString chosaKomokuNo = file.komokuNo().getChosaKomokuNo();
            if (!map.containsKey(chosaKomokuNo)) {
                map.put(chosaKomokuNo, new ArrayList<TokkiImageFileName>());
            }
            map.get(chosaKomokuNo).add(file);
        }
        return map;
    }

    private static Collection<TokkiImageFileName> renumberInterlappingRemban(List<TokkiImageFileName> files) {
        Collections.sort(files, fileNameAsc());
        List<TokkiImageFileName> duplicates = new ArrayList<>();
        Map<Integer, TokkiImageFileName> result = new HashMap<>();
        for (TokkiImageFileName file : files) {
            int remban = file.komokuNo().getRemban();
            if (result.containsKey(remban)) {
                duplicates.add(file);
                continue;
            }
            result.put(remban, file);
        }
        for (TokkiImageFileName file : duplicates) {
            int newRemban = 1;
            while (result.containsKey(newRemban)) {
                newRemban++;
            }
            result.put(newRemban,
                    new TokkiImageFileName(file.value(), file.komokuNo().renumbered(newRemban))
            );
        }
        return result.values();
    }

    private static Comparator<TokkiImageFileName> fileNameAsc() {
        return new Comparator<TokkiImageFileName>() {
            @Override
            public int compare(TokkiImageFileName o1, TokkiImageFileName o2) {
                return o1.value().compareTo(o2.value());
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
            OCRID ocrID = v.getOcrID();
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
}
