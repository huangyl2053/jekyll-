/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.sonota;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCRSONOTA.csvの取込結果1行を扱います。
 */
@lombok.Getter
public final class OcrSonota implements IOcrData {

    private final RString データ行_文字列;
    private final int lineNum;
    private OCRID oCRID = OCRID.EMPTY;
    private ShinseiKey key = ShinseiKey.EMPTY;
    private SheetID sheetID = SheetID.EMPTY;
    private RString 保険者番号 = RString.EMPTY;
    private RString 申請日 = RString.EMPTY;
    private RString 被保険者番号 = RString.EMPTY;
    private boolean isBroken;

    private OcrSonota(RString line, int lineNum) {
        this.データ行_文字列 = line;
        this.isBroken = false;
        this.lineNum = lineNum;
    }

    /**
     * 行を解析した結果より、インスタンスを生成します。
     *
     * 存在しない項目の値は、{@link RString#EMPTY}など、null以外の値で初期化されます。
     *
     * @param line 行
     * @param lineNum 行番号
     * @return {@link OcrSonota}
     */
    public static OcrSonota parsed(RString line, int lineNum) {
        try {
            return parseデータ行(line, lineNum);
        } catch (Exception e) {
            OcrSonota ocrSonota = new OcrSonota(line, lineNum);
            ocrSonota.isBroken = true;
            return ocrSonota;
        }
    }

    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 18 LINES
    private static OcrSonota parseデータ行(RString line, int lineNum) {
        OcrSonota result = new OcrSonota(line, lineNum);
        List<RString> columns = Collections.unmodifiableList(line.split(","));
        RString ocrID = columns.get(0);
        if (OCRID._801.value().equals(ocrID)) {
            result.oCRID = OCRID.toValueOrEMPTY(columns.get(0));
            result.sheetID = new SheetID(columns.get(1));
            result.保険者番号 = columns.get(2);
            result.申請日 = get西暦_年(columns.get(3));
            result.被保険者番号 = columns.get(4);
            result.key = new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日());
        } else {
            result.isBroken = true;
        }
        return result;
    }

    private static RString get西暦_年(RString 和暦_日付) {
        return RDate.canConvert(和暦_日付)
                ? new RDate(和暦_日付.toString()).toDateString()
                : RString.EMPTY;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.oCRID);
        hash = 47 * hash + Objects.hashCode(this.sheetID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OcrSonota other = (OcrSonota) obj;
        if (this.oCRID != other.oCRID) {
            return false;
        }
        return Objects.equals(this.sheetID, other.sheetID);
    }
}
