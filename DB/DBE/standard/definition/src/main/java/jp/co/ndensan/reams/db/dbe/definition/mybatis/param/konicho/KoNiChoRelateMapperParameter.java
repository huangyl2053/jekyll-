/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.konicho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * MyBatis用パラメータクラスです。
 */
public class KoNiChoRelateMapperParameter {

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

    private boolean jokyoflag1;
    private boolean jokyoflag2;
    private boolean shichosonCodeflag;
    private boolean ninteichosaItakusakiCodeflagFrom;
    private boolean ninteichosaItakusakiCodeflagTo;
    private boolean jigyoshaMeishoflag;
    private boolean jigyoshaMeishoKanaflag;
    private boolean ninteiChosainNoflagFrom;
    private boolean ninteiChosainNoflagTo;
    private boolean chosainShimeiflag;
    private boolean chosainKanaShimeiflag;
    private boolean chikuCodeflag;

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
            boolean ninteichosaItakusakiCodeflagFrom,
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
        this.ninteichosaItakusakiCodeflagFrom = ninteichosaItakusakiCodeflagFrom;
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
     * @return
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
        boolean ninteichosaItakusakiCodeflagFrom = true;
        boolean ninteichosaItakusakiCodeflagTo = true;
        boolean jigyoshaMeishoflag = true;
        boolean jigyoshaMeishoKanaflag = true;
        boolean ninteiChosainNoflagFrom = true;
        boolean ninteiChosainNoflagTo = true;
        boolean chosainShimeiflag = true;
        boolean chosainKanaShimeiflag = true;
        boolean chikuCodeflag = true;

        if (jokyoFlag == true) {
            jokyoflag1 = false;
        } else {
            jokyoflag2 = true;
        }

        if (shichosonCode == null || shichosonCode.isEmpty()) {
            shichosonCodeflag = false;
        }

        if (ninteichosaItakusakiCodeFrom == null) {
            ninteichosaItakusakiCodeflagFrom = false;
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
                ninteichosaItakusakiCodeflagFrom,
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

    public boolean isJokyoFlag() {
        return jokyoFlag;
    }

    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    public ChosaItakusakiCode getNinteichosaItakusakiCodeFrom() {
        return ninteichosaItakusakiCodeFrom;
    }

    public ChosaItakusakiCode getNinteichosaItakusakiCodeTo() {
        return ninteichosaItakusakiCodeTo;
    }

    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    public RString getJigyoshaMeishoKana() {
        return jigyoshaMeishoKana;
    }

    public ChosainCode getNinteiChosainNoFrom() {
        return ninteiChosainNoFrom;
    }

    public ChosainCode getNinteiChosainNoTo() {
        return ninteiChosainNoTo;
    }

    public RString getChosainShimei() {
        return chosainShimei;
    }

    public RString getChosainKanaShimei() {
        return chosainKanaShimei;
    }

    public RString getChikuCode() {
        return chikuCode;
    }

    public boolean isJokyoflag1() {
        return jokyoflag1;
    }

    public boolean isJokyoflag2() {
        return jokyoflag2;
    }

    public boolean isShichosonCodeflag() {
        return shichosonCodeflag;
    }

    public boolean isNinteichosaItakusakiCodeflagFrom() {
        return ninteichosaItakusakiCodeflagFrom;
    }

    public boolean isNinteichosaItakusakiCodeflagTo() {
        return ninteichosaItakusakiCodeflagTo;
    }

    public boolean isJigyoshaMeishoflag() {
        return jigyoshaMeishoflag;
    }

    public boolean isJigyoshaMeishoKanaflag() {
        return jigyoshaMeishoKanaflag;
    }

    public boolean isNinteiChosainNoflagFrom() {
        return ninteiChosainNoflagFrom;
    }

    public boolean isNinteiChosainNoflagTo() {
        return ninteiChosainNoflagTo;
    }

    public boolean isChosainShimeiflag() {
        return chosainShimeiflag;
    }

    public boolean isChosainKanaShimeiflag() {
        return chosainKanaShimeiflag;
    }

    public boolean isChikuCodeflag() {
        return chikuCodeflag;
    }

}
