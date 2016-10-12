/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosaitakusaki;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先マスタを特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteichosaItakusakiKensakuParameter {
    private static final RString 構成市町村マスタ市町村コード重複 = new RString("1");
    private final boolean jokyoFlag;
    private final LasdecCode shichosonCode;
    private final RString searchChosaItakusakiCodeFrom;
    private final RString searchChosaItakusakiCodeTo;
    private final RString jigyoshaMeisho;
    private final RString jigyoshaMeishoKana;
    private final RString chosaItakuKubun;
    private final RString kikanKubun;
    private final Integer limit;
    private final Integer ddlItakusakiMeishoKey;
    private final Integer ddlItakusakiKanaMeishoKey;
    private final RString 市町村識別ID;
    private final boolean 市町村識別ID利用Flag;
    
    private NinteichosaItakusakiKensakuParameter(boolean jokyoFlag, LasdecCode shichosonCode, RString searchChosaItakusakiCodeFrom,
            RString searchChosaItakusakiCodeTo, RString jigyoshaMeisho, RString jigyoshaMeishoKana, RString chosaItakuKubun, RString kikanKubun,
            Integer limit, RString ddlItakusakiMeishoKey, RString ddlItakusakiKanaMeishoKey, RString 市町村識別ID, boolean 市町村識別ID利用Flag) {
        this.jokyoFlag = jokyoFlag;
        this.shichosonCode = shichosonCode;
        this.searchChosaItakusakiCodeFrom = checkForNullOrEmpty(searchChosaItakusakiCodeFrom);
        this.searchChosaItakusakiCodeTo = checkForNullOrEmpty(searchChosaItakusakiCodeTo);
        this.jigyoshaMeisho = checkForNullOrEmpty(jigyoshaMeisho);
        this.jigyoshaMeishoKana = checkForNullOrEmpty(jigyoshaMeishoKana);
        this.chosaItakuKubun = checkForNullOrEmpty(chosaItakuKubun);
        this.kikanKubun = checkForNullOrEmpty(kikanKubun);
        this.limit = limit;
        this.ddlItakusakiMeishoKey = Integer.parseInt(ddlItakusakiMeishoKey.toString());
        this.ddlItakusakiKanaMeishoKey = Integer.parseInt(ddlItakusakiKanaMeishoKey.toString());
        this.市町村識別ID = 市町村識別ID;
        this.市町村識別ID利用Flag = 市町村識別ID利用Flag;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param jokyoFlag 画面の状況フラグ
     * @param shichosonCode 画面の市町村
     * @param searchChosaItakusakiCodeFrom 画面の調査委託先コードFrom
     * @param searchChosaItakusakiCodeTo 画面の調査委託先コードTo
     * @param chosaItakuKubun 画面の調査委託区分
     * @param jigyoshaMeisho 画面の調査委託先名称
     * @param jigyoshaMeishoKana 画面の調査委託先カナ名称
     * @param kikanKubun 画面の機関の区分
     * @param limit 画面で入力した最大表示件数
     * @param ddlItakusakiMeishoKey 画面で入力した調査委託先名称検索条件
     * @param ddlItakusakiKanaMeishoKey 画面で入力した調査委託先名称検索条件
     * @param 市町村識別ID 市町村識別ID
     * @param 構成市町村マスタ市町村コード重複種別 構成市町村マスタ市町村コード重複種別
     * @return 認定調査督促状発行パラメータ
     */
    public static NinteichosaItakusakiKensakuParameter createParam(boolean jokyoFlag, LasdecCode shichosonCode, RString searchChosaItakusakiCodeFrom,
            RString searchChosaItakusakiCodeTo, RString jigyoshaMeisho, RString jigyoshaMeishoKana, RString chosaItakuKubun, RString kikanKubun,
            Integer limit, RString ddlItakusakiMeishoKey, RString ddlItakusakiKanaMeishoKey, RString 市町村識別ID, RString 構成市町村マスタ市町村コード重複種別) {
        return new NinteichosaItakusakiKensakuParameter(jokyoFlag, shichosonCode, searchChosaItakusakiCodeFrom, searchChosaItakusakiCodeTo,
                jigyoshaMeisho, jigyoshaMeishoKana, chosaItakuKubun, kikanKubun, limit, ddlItakusakiMeishoKey, ddlItakusakiKanaMeishoKey, 市町村識別ID,
                構成市町村マスタ市町村コード重複.equals(構成市町村マスタ市町村コード重複種別));
    }
    
    private RString checkForNullOrEmpty(RString str) {
        return RString.isNullOrEmpty(str) ? null : str;
    }
}
