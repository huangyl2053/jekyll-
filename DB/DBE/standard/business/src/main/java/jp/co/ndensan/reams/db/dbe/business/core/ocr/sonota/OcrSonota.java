/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.sonota;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * OCRSONOTA.csvの取込結果1行を扱います。
 */
@lombok.Getter
public final class OcrSonota {

    private RString データ行_文字列 = RString.EMPTY;
    private OCRID ocrID = OCRID.EMPTY;
    private ShinseiKey key = ShinseiKey.EMPTY;
    private SheetID sheetID = SheetID.EMPTY;
    private RString 保険者番号 = RString.EMPTY;
    private RString 申請日 = RString.EMPTY;
    private RString 被保険者番号 = RString.EMPTY;
    private RString imageFileName = RString.EMPTY;

    private OcrSonota() {
    }

    /**
     * 行を解析した結果より、インスタンスを生成します。
     *
     * 存在しない項目の値は、{@link RString#EMPTY}など、null以外の値で初期化されます。
     *
     * @param line 行
     * @return {@link OcrSonota}
     */
    public static OcrSonota parsed(RString line) {
        return parseデータ行(line);
    }

    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 18 LINES
    private static OcrSonota parseデータ行(RString line) {
        OcrSonota result = new OcrSonota();
        result.データ行_文字列 = line;
        List<RString> columns = Collections.unmodifiableList(line.split(","));
        if (columns == null || columns.isEmpty()) {
            return result;
        }
        RString ocrID = columns.get(0);
        if (!OCRID._801.value().equals(ocrID)) {
            return result;
        }
        result.ocrID = OCRID.toValueOrEMPTY(columns.get(0));
        result.sheetID = new SheetID(columns.get(1));
        result.保険者番号 = columns.get(2);
        result.申請日 = get西暦_年(columns.get(3));
        result.被保険者番号 = columns.get(4);
        result.key = new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日());
        result.imageFileName = new RStringBuilder().append(result.sheetID.value()).append("w01i000.png").toRString();
        return result;
    }

    private static RString get西暦_年(RString 和暦_日付) {
        return RDate.canConvert(和暦_日付)
                ? new RDate(和暦_日付.toString()).toDateString()
                : RString.EMPTY;
    }
}
