/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;

/**
 * 特記事項のイメージファイル名と対応する項目の番号のペアを持ちます。
 */
public final class OcrTokkiJikoColumn {

    private final SheetID sheetID;
    private final int theColumnNo;
    private final KomokuNo theKomokuNo;

    OcrTokkiJikoColumn(SheetID sheetID, int theColumnNo, KomokuNo komokuNo) {
        this.sheetID = sheetID;
        this.theColumnNo = theColumnNo;
        this.theKomokuNo = komokuNo;
    }

    OcrTokkiJikoColumn(OcrTokkiJikoColumn old, KomokuNo komokuNo) {
        this(old.sheetID, old.theColumnNo, old.theKomokuNo);
    }

    /**
     * @return シートID（帳票連番）
     */
    public SheetID sheetID() {
        return this.sheetID;
    }

    /**
     * @return カラム番号
     */
    public int colmunNo() {
        return this.theColumnNo;
    }

    /**
     * @return 項目番号
     */
    public KomokuNo komokuNo() {
        return this.theKomokuNo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.theColumnNo);
        hash = 79 * hash + Objects.hashCode(this.theKomokuNo);
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
        final OcrTokkiJikoColumn other = (OcrTokkiJikoColumn) obj;
        if (!Objects.equals(this.theColumnNo, other.theColumnNo)) {
            return false;
        }
        return Objects.equals(this.theKomokuNo, other.theKomokuNo);
    }

}
