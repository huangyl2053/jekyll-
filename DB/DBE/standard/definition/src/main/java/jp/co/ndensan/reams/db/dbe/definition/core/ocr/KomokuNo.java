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

    /**
     * 空を表す値です。
     */
    public static final KomokuNo EMPTY;

    static {
        EMPTY = new KomokuNo();
    }
    private static final int REMBAN_INDEX = 3;

    private final RString chosaKomokuNo;
    private final RString remban;
    private final int rembanValue;

    private KomokuNo() {
        this.chosaKomokuNo = RString.EMPTY;
        this.remban = RString.EMPTY;
        this.rembanValue = 0;
    }

    /**
     * @param value OCRで取り込んだ4桁の値
     */
    public KomokuNo(RString value) {
        RString trimed = value.trim();
        if (trimed.isEmpty()) {
            this.chosaKomokuNo = RString.EMPTY;
            this.remban = RString.EMPTY;
            this.rembanValue = 0;
            return;
        }
        this.chosaKomokuNo = trimed.substringEmptyOnError(0, REMBAN_INDEX);
        this.rembanValue = findRemban(value);
        this.remban = new RString(String.format("%02d", rembanValue));
    }

    private KomokuNo(RString chosaKomokuNo, int remban) {
        this.chosaKomokuNo = chosaKomokuNo;
        this.rembanValue = remban;
        this.remban = new RString(String.format("%02d", rembanValue));
    }

    /**
     * 指定の値で連番を置き換えた新しいインスタンスを返します。
     *
     * @param remban 新しい連番
     * @return 指定の値で連番を置き換えた新しいインスタンス
     */
    public KomokuNo renumbered(int remban) {
        return new KomokuNo(this.chosaKomokuNo, remban);
    }

    private static int findRemban(RString rawValue) {
        RString rembanPart = rawValue.substringEmptyOnError(REMBAN_INDEX);
        try {
            return rembanPart.isEmpty() ? 0 : Integer.valueOf(rembanPart.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * @return 特記事項と対応する調査項目の番号、もしくは、空
     */
    public RString getChosaKomokuNo() {
        return this.chosaKomokuNo;
    }

    /**
     * @return 連番（00～99 の形へ編集された文字列、もしくは、空）
     */
    public RString getRemban() {
        return this.remban;
    }

    /**
     * @return 連番（数値）
     */
    public int getRembanAsInt() {
        return this.rembanValue;
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
