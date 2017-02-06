/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.sonota;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
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
    private final UUID uuid;
    private OCRID oCRID = OCRID.EMPTY;
    private ShinseiKey key = ShinseiKey.EMPTY;
    private SheetID sheetID = SheetID.EMPTY;
    private RString 保険者番号 = RString.EMPTY;
    private RString 申請日 = RString.EMPTY;
    private RString 被保険者番号 = RString.EMPTY;

    private OcrSonota(RString line) {
        this.uuid = UUID.randomUUID();
        this.データ行_文字列 = line;
        init(this.データ行_文字列);
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
        return new OcrSonota(line);
    }

    //CHECKSTYLE IGNORE MagicNumber FOR NEXT 18 LINES
    private void init(RString line) {
        List<RString> columns = Collections.unmodifiableList(line.split(","));
        if (columns == null || columns.isEmpty()) {
            return;
        }
        RString ocrID = columns.get(0);
        if (!OCRID._801.value().equals(ocrID)) {
            return;
        }
        this.oCRID = OCRID.toValueOrEMPTY(columns.get(0));
        this.sheetID = new SheetID(columns.get(1));
        this.保険者番号 = columns.get(2);
        this.申請日 = get西暦_年(columns.get(3));
        this.被保険者番号 = columns.get(4);
        this.key = new ShinseiKey(this.get保険者番号(), this.get被保険者番号(), this.get申請日());
    }

    private static RString get西暦_年(RString 和暦_日付) {
        return RDate.canConvert(和暦_日付)
                ? new RDate(和暦_日付.toString()).toDateString()
                : RString.EMPTY;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.uuid);
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
        if (!Objects.equals(this.uuid, other.uuid)) {
            return false;
        }
        return true;
    }
}
