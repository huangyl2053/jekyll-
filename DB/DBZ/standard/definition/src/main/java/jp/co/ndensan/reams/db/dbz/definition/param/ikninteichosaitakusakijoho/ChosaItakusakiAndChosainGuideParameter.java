/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.param.ikninteichosaitakusakijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 調査委託先＆調査員ガイドのParameterクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class ChosaItakusakiAndChosainGuideParameter {

    private final boolean 認定調査委託先コードFROMフラグ;
    private final RString 認定調査委託先コードFROM;
    private final boolean 認定調査委託先コードToフラグ;
    private final RString 認定調査委託先コードTo;
    private final boolean 認定調査状況フラグ;
    private final boolean 認定調査状況無効フラグ;
    private final RString 認定調査状況;
    private final boolean 認定調査委託先名称フラグ;
    private final RString 認定調査委託先名称;
    private final boolean 認定調査委託先カナフラグ;
    private final RString 認定調査委託先カナ;
    private final boolean 認定調査員コードFROMフラグ;
    private final RString 認定調査員コードFROM;
    private final boolean 認定調査員コードToフラグ;
    private final RString 認定調査員コードTo;
    private final boolean 調査員状況フラグ;
    private final boolean 調査員状況無効フラグ;
    private final RString 調査員状況;
    private final boolean 調査員名称フラグ;
    private final RString 調査員名称;
    private final boolean 調査員カナフラグ;
    private final RString 調査員カナ;
    private final boolean usesSaidaiHyojiKensu;
    private final Decimal saidaiHyojiKensu;
    private final RString 市町村コード;
    private final boolean subGyomuCodeFlag;

    private ChosaItakusakiAndChosainGuideParameter(
            boolean 認定調査委託先コードFROMフラグ,
            RString 認定調査委託先コードFROM,
            boolean 認定調査委託先コードToフラグ,
            RString 認定調査委託先コードTo,
            boolean 認定調査状況フラグ,
            boolean 認定調査状況無効フラグ,
            RString 認定調査状況,
            boolean 認定調査委託先名称フラグ,
            RString 認定調査委託先名称,
            boolean 認定調査委託先カナフラグ,
            RString 認定調査委託先カナ,
            boolean 認定調査員コードFROMフラグ,
            RString 認定調査員コードFROM,
            boolean 認定調査員コードToフラグ,
            RString 認定調査員コードTo,
            boolean 調査員状況フラグ,
            boolean 調査員状況無効フラグ,
            RString 調査員状況,
            boolean 調査員名称フラグ,
            RString 調査員名称,
            boolean 調査員カナフラグ,
            RString 調査員カナ,
            boolean usesSaidaiHyojiKensu,
            Decimal saidaiHyojiKensu,
            RString 市町村コード,
            boolean subGyomuCodeFlag
    ) {
        this.認定調査委託先コードFROMフラグ = 認定調査委託先コードFROMフラグ;
        this.認定調査員コードFROM = 認定調査員コードFROM;
        this.認定調査員コードToフラグ = 認定調査員コードToフラグ;
        this.認定調査員コードTo = 認定調査員コードTo;
        this.認定調査委託先コードFROM = 認定調査委託先コードFROM;
        this.認定調査委託先コードToフラグ = 認定調査委託先コードToフラグ;
        this.認定調査委託先コードTo = 認定調査委託先コードTo;
        this.認定調査状況フラグ = 認定調査状況フラグ;
        this.認定調査状況 = 認定調査状況;
        this.認定調査委託先名称フラグ = 認定調査委託先名称フラグ;
        this.認定調査委託先名称 = 認定調査委託先名称;
        this.認定調査委託先カナフラグ = 認定調査委託先カナフラグ;
        this.認定調査委託先カナ = 認定調査委託先カナ;
        this.認定調査員コードFROMフラグ = 認定調査員コードFROMフラグ;
        this.調査員状況フラグ = 調査員状況フラグ;
        this.調査員状況 = 調査員状況;
        this.調査員名称フラグ = 調査員名称フラグ;
        this.調査員名称 = 調査員名称;
        this.調査員カナフラグ = 調査員カナフラグ;
        this.調査員カナ = 調査員カナ;
        this.usesSaidaiHyojiKensu = usesSaidaiHyojiKensu;
        this.saidaiHyojiKensu = saidaiHyojiKensu;
        this.認定調査状況無効フラグ = 認定調査状況無効フラグ;
        this.調査員状況無効フラグ = 調査員状況無効フラグ;
        this.市町村コード = 市町村コード;
        this.subGyomuCodeFlag = subGyomuCodeFlag;
    }

    /**
     * パラメータ設定です
     *
     * @param 認定調査委託先コードFROM RString
     * @param 認定調査委託先コードTo RString
     * @param 認定調査状況 RString
     * @param 認定調査委託先名称 RString
     * @param 認定調査委託先カナ RString
     * @param 認定調査員コードFROM RString
     * @param 認定調査員コードTo RString
     * @param 調査員状況 RString
     * @param 調査員名称 RString
     * @param 調査員カナ RString
     * @param saidaiHyojiKensu Decimal
     * @param 市町村コード RString
     * @param subGyomuCodeFlag boolean
     * @return NinteiChosaIraiShokaiParameter
     */
    public static ChosaItakusakiAndChosainGuideParameter createParam(
            RString 認定調査委託先コードFROM,
            RString 認定調査委託先コードTo,
            RString 認定調査状況,
            RString 認定調査委託先名称,
            RString 認定調査委託先カナ,
            RString 認定調査員コードFROM,
            RString 認定調査員コードTo,
            RString 調査員状況,
            RString 調査員名称,
            RString 調査員カナ,
            Decimal saidaiHyojiKensu,
            RString 市町村コード,
            boolean subGyomuCodeFlag
    ) {
        boolean 認定調査委託先コードFROMフラグ = false;
        boolean 認定調査委託先コードToフラグ = false;
        boolean 認定調査状況フラグ = false;
        boolean 認定調査委託先名称フラグ = false;
        boolean 認定調査委託先カナフラグ = false;
        boolean 認定調査員コードFROMフラグ = false;
        boolean 認定調査員コードToフラグ = false;
        boolean 調査員名称フラグ = false;
        boolean 調査員状況フラグ = false;
        boolean 調査員カナフラグ = false;
        boolean usesSaidaiHyojiKensu = false;
        boolean 認定調査状況無効フラグ = false;
        boolean 調査員状況無効フラグ = false;
        if (!RString.isNullOrEmpty(認定調査委託先コードFROM)) {
            認定調査委託先コードFROMフラグ = true;
        }
        if (!RString.isNullOrEmpty(認定調査委託先コードTo)) {
            認定調査委託先コードToフラグ = true;
        }
        if (new RString("1").equals(認定調査状況)) {
            認定調査状況フラグ = true;
        }
        if (new RString("2").equals(認定調査状況)) {
            認定調査状況無効フラグ = true;
        }
        if (!RString.isNullOrEmpty(認定調査委託先名称)) {
            認定調査委託先名称フラグ = true;

        }
        if (!RString.isNullOrEmpty(認定調査委託先カナ)) {
            認定調査委託先名称フラグ = true;
        }
        if (!RString.isNullOrEmpty(認定調査員コードFROM)) {
            認定調査員コードFROMフラグ = true;
        }
        if (!RString.isNullOrEmpty(認定調査員コードTo)) {
            認定調査員コードToフラグ = true;
        }
        if (new RString("1").equals(調査員状況)) {
            調査員状況フラグ = true;
        }
        if (new RString("2").equals(調査員状況)) {
            調査員状況無効フラグ = true;
        }
        if (!RString.isNullOrEmpty(調査員カナ)) {
            調査員カナフラグ = true;
        }
        if (saidaiHyojiKensu != null) {
            usesSaidaiHyojiKensu = true;
        }
        return new ChosaItakusakiAndChosainGuideParameter(
                認定調査委託先コードFROMフラグ,
                認定調査委託先コードFROM,
                認定調査委託先コードToフラグ,
                認定調査委託先コードTo,
                認定調査状況フラグ,
                認定調査状況無効フラグ,
                認定調査状況,
                認定調査委託先名称フラグ,
                認定調査委託先名称,
                認定調査委託先カナフラグ,
                認定調査委託先カナ,
                認定調査員コードFROMフラグ,
                認定調査員コードFROM,
                認定調査員コードToフラグ,
                認定調査員コードTo,
                調査員状況フラグ,
                調査員状況無効フラグ,
                調査員状況,
                調査員名称フラグ,
                調査員名称,
                調査員カナフラグ,
                調査員カナ,
                usesSaidaiHyojiKensu,
                saidaiHyojiKensu,
                市町村コード,
                subGyomuCodeFlag);
    }
}
