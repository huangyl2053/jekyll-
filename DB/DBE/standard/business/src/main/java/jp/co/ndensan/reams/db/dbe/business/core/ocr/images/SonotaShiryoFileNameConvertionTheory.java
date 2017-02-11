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
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.sonota.OcrSonota;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * その他資料のイメージファイル名をReamsで管理するファイル名へ変換する方法の定義です。
 */
public class SonotaShiryoFileNameConvertionTheory implements IFileNameConvertionTheory {

    private static final List<RString> REAMS_FILE_NAME;

    static {
        REAMS_FILE_NAME = Arrays.asList(
                new RString("F1401A01.png"), new RString("F1401B02.png"),
                new RString("F1401C03.png"), new RString("F1401D04.png"),
                new RString("F1401F05.png"), new RString("F1401E06.png")
        );
    }

    private final Map<RString, RString> table;
    private final ProcessingResults results;

    /**
     * @param ocrSonotas 関連する{@link OcrSonota}すべて
     * @param fileNamesHaveUsed 現在使用されているファイル名
     */
    public SonotaShiryoFileNameConvertionTheory(Collection<? extends OcrSonota> ocrSonotas, List<RString> fileNamesHaveUsed) {
        this.results = new ProcessingResults();
        List<OcrSonota> sorted = new ArrayList<>(ocrSonotas);
        Collections.sort(sorted, new Comparator<OcrSonota>() {
            @Override
            public int compare(OcrSonota o1, OcrSonota o2) {
                return o1.getSheetID().compareTo(o2.getSheetID());
            }
        });
        Iterator<RString> reamsFileNames = fileNamesHaveNotUsed(fileNamesHaveUsed).iterator();
        Map<RString, RString> map = new HashMap<>();
        for (OcrSonota ocrSonota : sorted) {
            if (!reamsFileNames.hasNext()) {
                this.results.add(ProcessingResultFactory.error(ocrSonota,
                        OcrTorikomiMessages.その他資料_最大数超過.replaced(composeFileName(ocrSonota).toString())));
                continue;
            }
            map.put(composeFileName(ocrSonota), reamsFileNames.next());
        }
        this.table = Collections.unmodifiableMap(map);
    }

    private static RString composeFileName(OcrSonota ocrSonota) {
        return new RStringBuilder().append(ocrSonota.getSheetID().value()).append("w01i000.png").toRString();
    }

    private static List<RString> fileNamesHaveNotUsed(List<RString> fileNamesHaveUsed) {
        List<RString> haveUsedLowerCase = toLowerCaseAll(fileNamesHaveUsed);
        List<RString> list = new ArrayList<>();
        for (RString a : REAMS_FILE_NAME) {
            if (!haveUsedLowerCase.contains(a.toLowerCase())) {
                list.add(a);
            }
        }
        return list;
    }

    private static List<RString> toLowerCaseAll(List<RString> list) {
        List<RString> newlist = new ArrayList<>();
        for (RString a : list) {
            newlist.add(a.toLowerCase());
        }
        return newlist;
    }

    /**
     * @return 保存可能ファイル数超過などを判定した結果の{@link IProcessingResults}
     */
    public IProcessingResults getResults() {
        return this.results;
    }

    @Override
    public RString convert(RString fileName) {
        if (table.containsKey(fileName)) {
            return table.get(fileName);
        }
        return RString.EMPTY;
    }
}
