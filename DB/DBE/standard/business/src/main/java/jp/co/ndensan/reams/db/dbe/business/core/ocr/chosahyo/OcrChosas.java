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
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 複数の{@link OcrChosa}を扱います。
 */
public final class OcrChosas {

    private final List<OcrChosa> records;

    /**
     * @param records {@link OcrChosa}のcollection
     */
    public OcrChosas(Collection<? extends OcrChosa> records) {
        this.records = new ArrayList<>(records);
    }

    /**
     * 保持する{@link OcrChosa}が持つ、特記事項のファイル名と項目番号の全ペアを返します。
     * その過程で、同一調査項目に連番の重複があれば、連番を再付番します。
     *
     * @return 保持する{@link OcrChosa}が持つ、特記事項のファイル名と項目番号の全ペア.
     */
    public TokkiImageFileNames editedFileNames連番重複再付番() {
        return create(this.records);
    }

    //<editor-fold defaultstate="collapsed" desc="create()">
    private static TokkiImageFileNames create(Collection<? extends OcrChosa> records) {
        List<TokkiImageFileName> list = new ArrayList<>();
        for (List<TokkiImageFileName> fileNames
                : groupingByChosaKomokuNo(imageFileNames(records)).values()) {
            list.addAll(renumberInterlappingRemban(fileNames));
        }
        return new TokkiImageFileNames(list);
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

    private static List<TokkiImageFileName> imageFileNames(Collection<? extends OcrChosa> records) {
        List<TokkiImageFileName> files = new ArrayList<>();
        for (OcrChosa record : records) {
            files.addAll(record.getTokkiImageFileNames().removedEmptyKomokuNo().toList());
        }
        return files;
    }

    private static Collection<TokkiImageFileName> renumberInterlappingRemban(List<TokkiImageFileName> files) {
        Collections.sort(files, fileNameAsc());
        List<TokkiImageFileName> duplicates = new ArrayList<>();
        Map<Integer, TokkiImageFileName> result = new HashMap<>();
        for (TokkiImageFileName file : files) {
            int remban = file.komokuNo().getRembanAsInt();
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
}
