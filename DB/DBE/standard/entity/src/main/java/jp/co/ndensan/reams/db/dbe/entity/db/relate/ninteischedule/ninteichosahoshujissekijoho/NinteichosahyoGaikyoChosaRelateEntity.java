/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査委託料入力RelateEntityくラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteichosahyoGaikyoChosaRelateEntity {

    private RString shinseishoKanriNo;
    private RString ninteichosaRirekiNo;
    private RString chosaItakusakiCode;
    private RString chosainCode;
    private RString ninteichosaJisshiYMD;
    private RString ninteichosaJuryoYMD;
    private RString chosaJisshiBashoMeisho;
    private RString ninteichosaIraiYMD;
    private RString chosainShimei;
    private RString ninteiShinseiYMD;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString ninteichosaIraiRirekiNo;
    private RString chosaItakuryo;
    private RString chosaItakuryoShiharaiMemo;
    private boolean isGinkoFurikomiShutsuryoku;
    private RString jigyoshaMeisho;

}
