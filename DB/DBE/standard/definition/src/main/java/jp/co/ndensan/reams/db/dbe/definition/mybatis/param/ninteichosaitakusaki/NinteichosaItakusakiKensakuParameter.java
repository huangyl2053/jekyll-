/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosaitakusaki;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先マスタを特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class NinteichosaItakusakiKensakuParameter {

    private final boolean jokyoFlag;
    private final LasdecCode shichosonCode;
    private final RString searchChosaItakusakiCodeFrom;
    private final RString searchChosaItakusakiCodeTo;
    private final RString jigyoshaMeisho;
    private final RString jigyoshaMeishoKana;
    private final RString chosaItakuKubun;
    private final RString kikanKubun;
    private final Integer limit;

    private NinteichosaItakusakiKensakuParameter(boolean jokyoFlag, LasdecCode shichosonCode, RString searchChosaItakusakiCodeFrom,
            RString searchChosaItakusakiCodeTo, RString jigyoshaMeisho, RString jigyoshaMeishoKana, RString chosaItakuKubun, RString kikanKubun,
            Integer limit) {
        this.jokyoFlag = jokyoFlag;
        this.shichosonCode = shichosonCode;
        this.searchChosaItakusakiCodeFrom = searchChosaItakusakiCodeFrom;
        this.searchChosaItakusakiCodeTo = searchChosaItakusakiCodeTo;
        this.jigyoshaMeisho = jigyoshaMeisho;
        this.jigyoshaMeishoKana = jigyoshaMeishoKana;
        this.chosaItakuKubun = chosaItakuKubun;
        this.kikanKubun = kikanKubun;
        this.limit = limit;
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
     * @return 認定調査督促状発行パラメータ
     */
    public static NinteichosaItakusakiKensakuParameter createParam(boolean jokyoFlag, LasdecCode shichosonCode, RString searchChosaItakusakiCodeFrom,
            RString searchChosaItakusakiCodeTo, RString jigyoshaMeisho, RString jigyoshaMeishoKana, RString chosaItakuKubun, RString kikanKubun,
            Integer limit) {
        return new NinteichosaItakusakiKensakuParameter(jokyoFlag, shichosonCode, searchChosaItakusakiCodeFrom, searchChosaItakusakiCodeTo,
                jigyoshaMeisho, jigyoshaMeishoKana, chosaItakuKubun, kikanKubun, limit);
    }
}
