/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCRで認識した認定調査票 特記事項の項目番号を扱います。
 */
public final class KomokuNo {

    public static final KomokuNo EMPTY;

    static {
        EMPTY = new KomokuNo();
    }
    private static final int REMBAN_INDEX = 3;

    private final RString chosaKomokuNo;
    private final RString remban;

    private KomokuNo() {
        this.chosaKomokuNo = RString.EMPTY;
        this.remban = RString.EMPTY;
    }

    /**
     * @param value OCRで取り込んだ4桁の値
     */
    public KomokuNo(RString value) {
        RString trimed = value.trim();
        if (trimed.isEmpty()) {
            this.chosaKomokuNo = RString.EMPTY;
            this.remban = RString.EMPTY;
            return;
        }
        this.chosaKomokuNo = trimed.substringEmptyOnError(0, REMBAN_INDEX);
        this.remban = formatRemban(value);
    }

    private static RString formatRemban(RString rawValue) {
        RString rembanPart = rawValue.substringEmptyOnError(REMBAN_INDEX);
        int rembanValue = 0;
        try {
            rembanValue = rembanPart.isEmpty() ? 0 : Integer.valueOf(rembanPart.toString());
        } catch (NumberFormatException e) {
        }
        return new RString(String.format("%02d", rembanValue));
    }

    /**
     * @return 特記事項と対応する調査項目の番号、もしくは、空
     */
    public RString getChosaKomokuNo() {
        return this.chosaKomokuNo;
    }

    /**
     * @return 連番（00～99の値、もしくは、空）
     */
    public RString getRemban() {
        return this.remban;
    }

    /**
     * @return 空の値を保持する場合、{@code true}.
     */
    public boolean isEmpty() {
        return EMPTY.equals(this);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.chosaKomokuNo);
        hash = 97 * hash + Objects.hashCode(this.remban);
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
        final KomokuNo other = (KomokuNo) obj;
        if (!Objects.equals(this.chosaKomokuNo, other.chosaKomokuNo)) {
            return false;
        }
        return Objects.equals(this.remban, other.remban);
    }

    @Override
    public String toString() {
        return "KomokuNo{" + "chosaKomokuNo=" + chosaKomokuNo + ", remban=" + remban + '}';
    }
}
