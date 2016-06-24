/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.konicho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * MyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KoNiChoRelateMapperParameter {

    private final boolean jokyoFlag;
    private final LasdecCode shichosonCode;
    private final ChosaItakusakiCode ninteichosaItakusakiCodeFrom;
    private final ChosaItakusakiCode ninteichosaItakusakiCodeTo;
    private final RString jigyoshaMeisho;
    private final RString jigyoshaMeishoKana;
    private final ChosainCode ninteiChosainNoFrom;
    private final ChosainCode ninteiChosainNoTo;
    private final RString chosainShimei;
    private final RString chosainKanaShimei;
    private final RString chikuCode;

    private final boolean jokyoflag1;
    private final boolean jokyoflag2;
    private final boolean shichosonCodeflag;
    private final boolean ninteichosaItakusakiCdflagFrom;
    private final boolean ninteichosaItakusakiCodeflagTo;
    private final boolean jigyoshaMeishoflag;
    private final boolean jigyoshaMeishoKanaflag;
    private final boolean ninteiChosainNoflagFrom;
    private final boolean ninteiChosainNoflagTo;
    private final boolean chosainShimeiflag;
    private final boolean chosainKanaShimeiflag;
    private final boolean chikuCodeflag;

    /**
     * 非公開コンストラクタです。
     *
     * @param jokyoFlag 状況フラグ
     * @param shichosonCode 市町村
     * @param ninteichosaItakusakiCode 調査委託先コード
     * @param jigyoshaMeisho 事業者名称
     * @param jigyoshaMeishoKana 事業者名称カナ
     * @param ninteiChosainNo 認定調査員コード
     * @param chosainShimei 調査員氏名
     * @param chosainKanaShimei 調査員カナ氏名
     * @param chikuCode 地区コード
     *
     */
    private KoNiChoRelateMapperParameter(
            boolean jokyoFlag,
            LasdecCode shichosonCode,
            ChosaItakusakiCode ninteichosaItakusakiCodeFrom,
            ChosaItakusakiCode ninteichosaItakusakiCodeTo,
            RString jigyoshaMeisho,
            RString jigyoshaMeishoKana,
            ChosainCode ninteiChosainNoFrom,
            ChosainCode ninteiChosainNoTo,
            RString chosainShimei,
            RString chosainKanaShimei,
            RString chikuCode,
            boolean jokyoflag1,
            boolean jokyoflag2,
            boolean shichosonCodeflag,
            boolean ninteichosaItakusakiCdflagFrom,
            boolean ninteichosaItakusakiCodeflagTo,
            boolean jigyoshaMeishoflag,
            boolean jigyoshaMeishoKanaflag,
            boolean ninteiChosainNoflagFrom,
            boolean ninteiChosainNoflagTo,
            boolean chosainShimeiflag,
            boolean chosainKanaShimeiflag,
            boolean chikuCodeflag
    ) {
        this.jokyoFlag = jokyoFlag;
        this.shichosonCode = shichosonCode;
        this.ninteichosaItakusakiCodeFrom = ninteichosaItakusakiCodeFrom;
        this.ninteichosaItakusakiCodeTo = ninteichosaItakusakiCodeTo;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.jigyoshaMeishoKana = jigyoshaMeishoKana;
        this.ninteiChosainNoFrom = ninteiChosainNoFrom;
        this.ninteiChosainNoTo = ninteiChosainNoTo;
        this.chosainShimei = chosainShimei;
        this.chosainKanaShimei = chosainKanaShimei;
        this.chikuCode = chikuCode;

        this.jokyoflag1 = jokyoflag1;
        this.jokyoflag2 = jokyoflag2;
        this.shichosonCodeflag = shichosonCodeflag;
        this.ninteichosaItakusakiCdflagFrom = ninteichosaItakusakiCdflagFrom;
        this.ninteichosaItakusakiCodeflagTo = ninteichosaItakusakiCodeflagTo;
        this.jigyoshaMeishoflag = jigyoshaMeishoflag;
        this.jigyoshaMeishoKanaflag = jigyoshaMeishoKanaflag;
        this.ninteiChosainNoflagFrom = ninteiChosainNoflagFrom;
        this.ninteiChosainNoflagTo = ninteiChosainNoflagTo;
        this.chosainShimeiflag = chosainShimeiflag;
        this.chosainKanaShimeiflag = chosainKanaShimeiflag;
        this.chikuCodeflag = chikuCodeflag;
    }

    /**
     * 非公開コンストラクタです。
     *
     * @param jokyoFlag boolean
     * @param shichosonCode LasdecCode
     * @param ninteichosaItakusakiCodeFrom ChosaItakusakiCode
     * @param ninteichosaItakusakiCodeTo ChosaItakusakiCode
     * @param jigyoshaMeisho RString
     * @param jigyoshaMeishoKana RString
     * @param ninteiChosainNoFrom ChosainCode
     * @param ninteiChosainNoTo ChosainCode
     * @param chosainShimei RString
     * @param chosainKanaShimei RString
     * @param chikuCode RString
     * @return KoNiChoRelateMapperParameter
     *
     */
    public static KoNiChoRelateMapperParameter createSelectByKeyParam(
            boolean jokyoFlag,
            LasdecCode shichosonCode,
            ChosaItakusakiCode ninteichosaItakusakiCodeFrom,
            ChosaItakusakiCode ninteichosaItakusakiCodeTo,
            RString jigyoshaMeisho,
            RString jigyoshaMeishoKana,
            ChosainCode ninteiChosainNoFrom,
            ChosainCode ninteiChosainNoTo,
            RString chosainShimei,
            RString chosainKanaShimei,
            RString chikuCode) {

        boolean jokyoflag1 = true;
        boolean jokyoflag2 = true;
        boolean shichosonCodeflag = true;
        boolean ninteichosaItakusakiCdflagFrom = true;
        boolean ninteichosaItakusakiCodeflagTo = true;
        boolean jigyoshaMeishoflag = true;
        boolean jigyoshaMeishoKanaflag = true;
        boolean ninteiChosainNoflagFrom = true;
        boolean ninteiChosainNoflagTo = true;
        boolean chosainShimeiflag = true;
        boolean chosainKanaShimeiflag = true;
        boolean chikuCodeflag = true;

        if (jokyoFlag) {
            jokyoflag1 = false;
        } else {
            jokyoflag2 = true;
        }

        if (shichosonCode == null || shichosonCode.isEmpty()) {
            shichosonCodeflag = false;
        }

        if (ninteichosaItakusakiCodeFrom == null) {
            ninteichosaItakusakiCdflagFrom = false;
        }
        if (ninteichosaItakusakiCodeTo == null) {
            ninteichosaItakusakiCodeflagTo = false;
        }
        if (jigyoshaMeisho == null || jigyoshaMeisho.isEmpty()) {
            jigyoshaMeishoflag = false;
        }
        if (jigyoshaMeishoKana == null || jigyoshaMeishoKana.isEmpty()) {
            jigyoshaMeishoKanaflag = false;
        }
        if (ninteiChosainNoFrom == null) {
            ninteiChosainNoflagFrom = false;
        }
        if (ninteiChosainNoTo == null) {
            ninteiChosainNoflagTo = false;
        }
        if (chosainShimei == null || chosainShimei.isEmpty()) {
            chosainShimeiflag = false;
        }
        if (chosainKanaShimei == null || chosainKanaShimei.isEmpty()) {
            chosainKanaShimeiflag = false;
        }
        if (chikuCode == null || chikuCode.isEmpty()) {
            chikuCodeflag = false;
        }

        return new KoNiChoRelateMapperParameter(
                jokyoFlag,
                shichosonCode,
                ninteichosaItakusakiCodeFrom,
                ninteichosaItakusakiCodeTo,
                jigyoshaMeisho,
                jigyoshaMeishoKana,
                ninteiChosainNoFrom,
                ninteiChosainNoTo,
                chosainShimei,
                chosainKanaShimei,
                chikuCode,
                jokyoflag1,
                jokyoflag2,
                shichosonCodeflag,
                ninteichosaItakusakiCdflagFrom,
                ninteichosaItakusakiCodeflagTo,
                jigyoshaMeishoflag,
                jigyoshaMeishoKanaflag,
                ninteiChosainNoflagFrom,
                ninteiChosainNoflagTo,
                chosainShimeiflag,
                chosainKanaShimeiflag,
                chikuCodeflag
        );
    }

    /**
     *
     * @return jokyoFlag
     */
    public boolean isJokyoFlag() {
        return jokyoFlag;
    }

    /**
     *
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     *
     * @return ninteichosaItakusakiCodeFrom
     */
    public ChosaItakusakiCode getNinteichosaItakusakiCodeFrom() {
        return ninteichosaItakusakiCodeFrom;
    }

    /**
     *
     * @return ninteichosaItakusakiCodeTo
     */
    public ChosaItakusakiCode getNinteichosaItakusakiCodeTo() {
        return ninteichosaItakusakiCodeTo;
    }

    /**
     *
     * @return jigyoshaMeisho
     */
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     *
     * @return jigyoshaMeishoKana
     */
    public RString getJigyoshaMeishoKana() {
        return jigyoshaMeishoKana;
    }

    /**
     *
     * @return ninteiChosainNoFrom
     */
    public ChosainCode getNinteiChosainNoFrom() {
        return ninteiChosainNoFrom;
    }

    /**
     *
     * @return ninteiChosainNoTo
     */
    public ChosainCode getNinteiChosainNoTo() {
        return ninteiChosainNoTo;
    }

    /**
     *
     * @return chosainShimei
     */
    public RString getChosainShimei() {
        return chosainShimei;
    }

    /**
     *
     * @return chosainKanaShimei
     */
    public RString getChosainKanaShimei() {
        return chosainKanaShimei;
    }

    /**
     *
     * @return chikuCode
     */
    public RString getChikuCode() {
        return chikuCode;
    }

    /**
     *
     * @return jokyoflag1
     */
    public boolean isJokyoflag1() {
        return jokyoflag1;
    }

    /**
     *
     * @return jokyoflag2
     */
    public boolean isJokyoflag2() {
        return jokyoflag2;
    }

    /**
     *
     * @return shichosonCodeflag
     */
    public boolean isShichosonCodeflag() {
        return shichosonCodeflag;
    }

    /**
     *
     * @return ninteichosaItakusakiCdflagFrom
     */
    public boolean isNinteichosaItakusakiCodeflagFrom() {
        return ninteichosaItakusakiCdflagFrom;
    }

    /**
     *
     * @return ninteichosaItakusakiCodeflagTo
     */
    public boolean isNinteichosaItakusakiCodeflagTo() {
        return ninteichosaItakusakiCodeflagTo;
    }

    /**
     *
     * @return jigyoshaMeishoflag
     */
    public boolean isJigyoshaMeishoflag() {
        return jigyoshaMeishoflag;
    }

    /**
     *
     * @return jigyoshaMeishoKanaflag
     */
    public boolean isJigyoshaMeishoKanaflag() {
        return jigyoshaMeishoKanaflag;
    }

    /**
     *
     * @return ninteiChosainNoflagFrom
     */
    public boolean isNinteiChosainNoflagFrom() {
        return ninteiChosainNoflagFrom;
    }

    /**
     *
     * @return ninteiChosainNoflagTo
     */
    public boolean isNinteiChosainNoflagTo() {
        return ninteiChosainNoflagTo;
    }

    /**
     *
     * @return chosainShimeiflag
     */
    public boolean isChosainShimeiflag() {
        return chosainShimeiflag;
    }

    /**
     *
     * @return chosainKanaShimeiflag
     */
    public boolean isChosainKanaShimeiflag() {
        return chosainKanaShimeiflag;
    }

    /**
     *
     * @return chikuCodeflag
     */
    public boolean isChikuCodeflag() {
        return chikuCodeflag;
    }

}
