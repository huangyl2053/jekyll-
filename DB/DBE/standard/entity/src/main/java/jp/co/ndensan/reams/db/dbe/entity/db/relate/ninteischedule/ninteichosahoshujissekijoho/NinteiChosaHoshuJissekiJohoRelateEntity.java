/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託料入力RelateEntityクラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaHoshuJissekiJohoRelateEntity {

    private RString shoKisaiHokenshaNo;
    private RString shichosonMeisho;
    private RString shichosonCode;
    private RString ninteiChosaItakusakiCode;
    private RString ninteiChosainCode;
    private RString chosainShimei;
    private RString chosainKanaShimei;
    private RString chosainShikaku;
    private RString shozokuKikanName;
    private RString jigyoshaMeisho;
    private boolean jokyoFlag;
}
