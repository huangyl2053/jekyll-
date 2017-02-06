/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ocr;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * OCRで認識した認定調査票 特記事項の項目番号を扱います。
 */
public final class KomokuNo implements Comparable<KomokuNo> {

    private static final RString HYPHEN = new RString("-");

    /**
     * 空を表す値です。
     */
    public static final KomokuNo EMPTY;

    static {
        EMPTY = new KomokuNo();
    }
    private static final int REMBAN_INDEX = 3;
    private static final int REMBAN_MIN = 1;
    private static final int REMBAN_MAX = 9;

    private final RString chosaKomokuNo;
    private final RString imageRemban;
    private final int remban;
    private final int beforeRemban;

    private KomokuNo() {
        this.chosaKomokuNo = RString.EMPTY;
        this.imageRemban = RString.EMPTY;
        this.remban = 0;
        this.beforeRemban = 0;
    }

    /**
     * @param chosaKomokuNo 特記事項と対応する調査項目の番号
     * @param remban 連番
     */
    public KomokuNo(RString chosaKomokuNo, int remban) {
        this.chosaKomokuNo = chosaKomokuNo;
        this.remban = remban;
        this.beforeRemban = remban;
        this.imageRemban = toImageRemban(this.remban);
    }

    /**
     * @param value OCRで取り込んだ4桁の値
     */
    public KomokuNo(RString value) {
        RString trimed = value.trim();
        if (trimed.isEmpty()) {
            this.chosaKomokuNo = RString.EMPTY;
            this.imageRemban = RString.EMPTY;
            this.remban = 0;
            this.beforeRemban = 0;
            return;
        }
        this.chosaKomokuNo = trimed.substringEmptyOnError(0, REMBAN_INDEX);
        this.remban = findRemban(value);
        this.beforeRemban = this.remban;
        this.imageRemban = toImageRemban(this.remban);
    }

    private static int findRemban(RString rawValue) {
        RString rembanPart = rawValue.substringEmptyOnError(REMBAN_INDEX);
        try {
            return rembanPart.isEmpty() ? 1 : Integer.valueOf(rembanPart.toString());
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    private RString toImageRemban(int remban) {
        return new RString(String.format("%02d", remban - 1));
    }

    private KomokuNo(KomokuNo old, int newRemban) {
        this.chosaKomokuNo = old.chosaKomokuNo;
        this.remban = newRemban;
        this.beforeRemban = old.remban;
        this.imageRemban = toImageRemban(this.remban);
    }

    /**
     * 指定の値で連番を置き換えた新しいインスタンスを返します。
     *
     * @param remban 新しい連番
     * @return 指定の値で連番を置き換えた新しいインスタンス
     */
    public KomokuNo renumbered(int remban) {
        return new KomokuNo(this, remban);
    }

    /**
     * @return 特記事項と対応する調査項目の番号、もしくは、空
     */
    public RString getChosaKomokuNo() {
        return this.chosaKomokuNo;
    }

    /**
     * イメージの連番を返します。
     * <p/>
     * {@link #getRemban() getRemban()}の戻り値から1を減じた物を、2桁0埋めの形式で編集した値になります。
     * <p/>
     * 例) {@link #getRemban() getRemban()} が 1 を返す場合、"00"
     *
     * @return イメージの連番（2桁0埋め）
     */
    public RString getImageRemban() {
        return this.imageRemban;
    }

    /**
     * @return 連番（数値）
     */
    public int getRemban() {
        return this.remban;
    }

    /**
     * @return 当初の連番
     */
    public int getBeforeRemban() {
        return this.beforeRemban;
    }

    /**
     * @return 連番変更前の文字列表現.
     */
    public RString beforeToRString() {
        return new RStringBuilder().append(chosaKomokuNo).append(HYPHEN).append(beforeRemban).toRString();
    }

    /**
     * @return 連番の再付番が行われている場合、{@code true}
     */
    public boolean hasRenumberd() {
        return this.remban != this.beforeRemban;
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
        hash = 97 * hash + Objects.hashCode(this.imageRemban);
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
        return this.remban == other.remban;
    }

    @Override
    public String toString() {
        return new RStringBuilder().append(chosaKomokuNo).append(HYPHEN).append(remban).toString();
    }

    @Override
    public int compareTo(KomokuNo o) {
        int a = this.chosaKomokuNo.compareTo(o.chosaKomokuNo);
        if (a != 0) {
            return a;
        }
        return Integer.compare(this.remban, o.remban);
    }

    /**
     * @return 有効な連番を持つ場合、{@code true}
     */
    public boolean hasValidRemban() {
        return REMBAN_MIN <= this.remban && this.remban <= REMBAN_MAX;
    }
}
