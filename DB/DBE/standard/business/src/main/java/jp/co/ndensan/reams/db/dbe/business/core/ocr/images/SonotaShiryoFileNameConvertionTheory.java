/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IFileNameConvertionTheory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.sonota.OcrSonota;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他資料のイメージファイル名をReamsで管理するファイル名へ変換する方法の定義です。
 */
public class SonotaShiryoFileNameConvertionTheory implements IFileNameConvertionTheory {

    private static final List<RString> FILE_NAMES;

    static {
        FILE_NAMES = Arrays.asList(
                new RString("F1401A00.png"), new RString("F1401B01.png"),
                new RString("F1401C03.png"), new RString("F1401D04.png"),
                new RString("F1401F05.png"), new RString("F1401E06.png")
        );
    }

    private final Map<RString, RString> table;
    private final boolean exceedsLimitFlag;

    public SonotaShiryoFileNameConvertionTheory(Collection<? extends OcrSonota> ocrSonotas) {
        Map<RString, RString> map = new HashMap<>();
        Iterator<RString> fileNames = FILE_NAMES.iterator();
        boolean exceedsLimit = false;
        for (OcrSonota ocrSonota : new ArrayList<>(ocrSonotas)) {
            if (!fileNames.hasNext()) {
                exceedsLimit = true;
                break;
            }
            map.put(ocrSonota.getImageFileName(), fileNames.next());
        }
        this.table = Collections.unmodifiableMap(map);
        this.exceedsLimitFlag = exceedsLimit;
    }

    /**
     * @return 取り込むイメージ数が管理可能な最大数を超える場合、{@code true}.
     */
    public boolean exceedsLimit() {
        return exceedsLimitFlag;
    }

    @Override
    public RString convert(RString fileName) {
        if (table.containsKey(fileName)) {
            return table.get(fileName);
        }
        return RString.EMPTY;
    }
}
