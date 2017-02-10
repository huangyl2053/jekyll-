/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.images;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrTokkiJikoColumn;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrTokkiJikoColumns;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特記事項のイメージファイル名をReamsで管理するファイル名へ変換する方法の定義です。
 */
public class TokkijikoFileNameConvertionTheory implements IFileNameConvertionTheory {

    private static final RString REPLACEMENT = new RString("??");
    private static final Map<RString, RString> KOMOKUNO_TO_FILENAME_TABLE;
    private static final Map<Integer, RString> OCR_FILENAME_TABLE;

    static {
        Map<RString, RString> map = new HashMap<>();
        map.put(new RString("101"), new RString("C3001-??.png"));
        map.put(new RString("102"), new RString("C3006-??.png"));
        map.put(new RString("103"), new RString("C3010-??.png"));
        map.put(new RString("104"), new RString("C3011-??.png"));
        map.put(new RString("105"), new RString("C3012-??.png"));
        map.put(new RString("106"), new RString("C3013-??.png"));
        map.put(new RString("107"), new RString("C3014-??.png"));
        map.put(new RString("108"), new RString("C3015-??.png"));
        map.put(new RString("109"), new RString("C3016-??.png"));
        map.put(new RString("110"), new RString("C3017-??.png"));
        map.put(new RString("111"), new RString("C3018-??.png"));
        map.put(new RString("112"), new RString("C3019-??.png"));
        map.put(new RString("113"), new RString("C3020-??.png"));
        map.put(new RString("201"), new RString("C3021-??.png"));
        map.put(new RString("202"), new RString("C3022-??.png"));
        map.put(new RString("203"), new RString("C3023-??.png"));
        map.put(new RString("204"), new RString("C3024-??.png"));
        map.put(new RString("205"), new RString("C3025-??.png"));
        map.put(new RString("206"), new RString("C3026-??.png"));
        map.put(new RString("207"), new RString("C3027-??.png"));
        map.put(new RString("208"), new RString("C3028-??.png"));
        map.put(new RString("209"), new RString("C3029-??.png"));
        map.put(new RString("210"), new RString("C3030-??.png"));
        map.put(new RString("211"), new RString("C3031-??.png"));
        map.put(new RString("212"), new RString("C3032-??.png"));
        map.put(new RString("301"), new RString("C3033-??.png"));
        map.put(new RString("302"), new RString("C3034-??.png"));
        map.put(new RString("303"), new RString("C3035-??.png"));
        map.put(new RString("304"), new RString("C3036-??.png"));
        map.put(new RString("305"), new RString("C3037-??.png"));
        map.put(new RString("306"), new RString("C3038-??.png"));
        map.put(new RString("307"), new RString("C3039-??.png"));
        map.put(new RString("308"), new RString("C3040-??.png"));
        map.put(new RString("309"), new RString("C3041-??.png"));
        map.put(new RString("401"), new RString("C3042-??.png"));
        map.put(new RString("402"), new RString("C3043-??.png"));
        map.put(new RString("403"), new RString("C3044-??.png"));
        map.put(new RString("404"), new RString("C3045-??.png"));
        map.put(new RString("405"), new RString("C3046-??.png"));
        map.put(new RString("406"), new RString("C3047-??.png"));
        map.put(new RString("407"), new RString("C3048-??.png"));
        map.put(new RString("408"), new RString("C3049-??.png"));
        map.put(new RString("409"), new RString("C3050-??.png"));
        map.put(new RString("410"), new RString("C3051-??.png"));
        map.put(new RString("411"), new RString("C3052-??.png"));
        map.put(new RString("412"), new RString("C3053-??.png"));
        map.put(new RString("413"), new RString("C3054-??.png"));
        map.put(new RString("414"), new RString("C3055-??.png"));
        map.put(new RString("415"), new RString("C3056-??.png"));
        map.put(new RString("501"), new RString("C3057-??.png"));
        map.put(new RString("502"), new RString("C3058-??.png"));
        map.put(new RString("503"), new RString("C3059-??.png"));
        map.put(new RString("504"), new RString("C3060-??.png"));
        map.put(new RString("505"), new RString("C3061-??.png"));
        map.put(new RString("506"), new RString("C3062-??.png"));
        map.put(new RString("601"), new RString("C3063-??.png"));
        map.put(new RString("602"), new RString("C3064-??.png"));
        map.put(new RString("603"), new RString("C3065-??.png"));
        map.put(new RString("604"), new RString("C3066-??.png"));
        map.put(new RString("605"), new RString("C3067-??.png"));
        map.put(new RString("606"), new RString("C3068-??.png"));
        map.put(new RString("607"), new RString("C3069-??.png"));
        map.put(new RString("608"), new RString("C3070-??.png"));
        map.put(new RString("609"), new RString("C3071-??.png"));
        map.put(new RString("610"), new RString("C3072-??.png"));
        map.put(new RString("611"), new RString("C3073-??.png"));
        map.put(new RString("612"), new RString("C3074-??.png"));
        map.put(new RString("701"), new RString("C3075-??.png"));
        map.put(new RString("702"), new RString("C3076-??.png"));
        KOMOKUNO_TO_FILENAME_TABLE = Collections.unmodifiableMap(map);

        //CHECKSTYLE IGNORE MagicNumber FOR NEXT 26 LINES
        Map<Integer, RString> map2 = new HashMap<>();
        map2.put(0, new RString("w01i030.png"));
        map2.put(1, new RString("w01i031.png"));
        map2.put(2, new RString("w01i032.png"));
        map2.put(3, new RString("w01i033.png"));
        map2.put(4, new RString("w01i034.png"));
        map2.put(5, new RString("w01i035.png"));
        map2.put(6, new RString("w01i036.png"));
        map2.put(7, new RString("w01i037.png"));
        map2.put(8, new RString("w01i038.png"));
        map2.put(9, new RString("w01i039.png"));
        map2.put(10, new RString("w01i040.png"));
        map2.put(11, new RString("w01i041.png"));
        map2.put(12, new RString("w02i025.png"));
        map2.put(13, new RString("w02i026.png"));
        map2.put(14, new RString("w02i027.png"));
        map2.put(15, new RString("w02i028.png"));
        map2.put(16, new RString("w02i029.png"));
        map2.put(17, new RString("w02i030.png"));
        map2.put(18, new RString("w02i031.png"));
        map2.put(19, new RString("w02i032.png"));
        map2.put(20, new RString("w02i033.png"));
        map2.put(21, new RString("w02i034.png"));
        map2.put(22, new RString("w02i035.png"));
        map2.put(23, new RString("w02i036.png"));
        OCR_FILENAME_TABLE = Collections.unmodifiableMap(map2);
    }

    private final Map<RString, RString> table;

    /**
     * @param columns
     */
    public TokkijikoFileNameConvertionTheory(OcrTokkiJikoColumns columns) {
        Map<RString, RString> map = new HashMap<>();
        for (OcrTokkiJikoColumn column : columns) {
            KomokuNo komokuNo = column.komokuNo();
            if (komokuNo.isEmpty()) {
                continue;
            }
            RString baseFileName = KOMOKUNO_TO_FILENAME_TABLE.get(komokuNo.getChosaKomokuNo());
            if (baseFileName == null) {
                continue;
            }
            map.put(composeFileName(column.sheetID(), column.colmunNo()),
                    baseFileName.replace(REPLACEMENT, komokuNo.getImageRemban()));
        }
        this.table = Collections.unmodifiableMap(map);
    }

    private static RString composeFileName(SheetID sheetID, int columnNo) {
        return new RStringBuilder().append(sheetID.value()).append(OCR_FILENAME_TABLE.get(columnNo)).toRString();
    }

    @Override
    public RString convert(RString fileName) {
        if (table.containsKey(fileName)) {
            return table.get(fileName);
        }
        return RString.EMPTY;
    }

    @Override
    public String toString() {
        return "TokkijikoFileNameConvertionTheory{" + "table=" + table + '}';
    }
}
