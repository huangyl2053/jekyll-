/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 所得照会候補者Temp
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShoukaiKouhoshaTempEntity implements IDbAccessable, Serializable {

    @TempTableColumnOrder(1)
    private RString kouhoshakubun;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private RString juminShubetsuCode;
    @TempTableColumnOrder(4)
    private AtenaMeisho atenaShimei;
    @TempTableColumnOrder(5)
    private AtenaKanaMeisho atenaKanaShimei;
    @TempTableColumnOrder(6)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(7)
    private YubinNo yubinNo;
    @TempTableColumnOrder(8)
    private RString choikiCode;
    @TempTableColumnOrder(9)
    private ZenkokuJushoCode zenkokuJushoCode;
    @TempTableColumnOrder(10)
    private RString jusho;
    @TempTableColumnOrder(11)
    private RString banchi;
    @TempTableColumnOrder(12)
    private RString katagaki;
    @TempTableColumnOrder(13)
    private RString gyoseikuCode;
    @TempTableColumnOrder(14)
    private RString chikuCode1;
    @TempTableColumnOrder(15)
    private RString chikuCode2;
    @TempTableColumnOrder(16)
    private RString chikuCode3;
    @TempTableColumnOrder(17)
    private RString juminJotaiCode;
    @TempTableColumnOrder(18)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(19)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate torokuIdoYMD;
    @TempTableColumnOrder(21)
    private ZenkokuJushoCode tenyuzenzenkokuJushoCode;
    @TempTableColumnOrder(22)
    private RString tenyuzenjusho;
    @TempTableColumnOrder(23)
    private RString tenyuzenbanchi;
    @TempTableColumnOrder(24)
    private RString tenyuzenkatagaki;

}
