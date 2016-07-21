/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
public class NinteichosahyoGaikyoChosaRelateEntity {

    private RString shinseishoKanriNo;
    private RString ninteichosaRirekiNo;
    private RString chosaItakusakiCode;
    private RString chosainCode;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private RString chosaJisshiBashoMeisho;
    private FlexibleDate ninteichosaIraiYMD;
    private RString chosainShimei;
    private FlexibleDate ninteiShinseiYMD;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString ninteichosaIraiRirekiNo;
    private int chosaItakuryo;
    private RString chosaItakuryoShiharaiMemo;
    private boolean isGinkoFurikomiShutsuryoku;
    private RString jigyoshaMeisho;
    private RString tanka;

}
