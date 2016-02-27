/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼発行一覧表用RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosaIraiRelateEntity {

    private RString iraishoShutsuryokuYMD;
    private RString ninteichosaKigenYMD;
    private RString shichosonCode;
    private RString shichosonMeisho;
    private RString hihokenshaNo;
    private RString hihokenshaName;
    private RString ninteichosaIraiYMD;
    private RString ninteichosaItakusakiCode;
    private RString jigyoshaMeisho;
    private RString daihyoshaName;
    private RString telNo;
    private RString ninteiChosainNo;
    private RString chosainShimei;
}
