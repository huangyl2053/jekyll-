/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 所得照会票データTempのクラスです。
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShoukaiDataTempEntity implements IDbAccessable, Serializable {

    @TempTableColumnOrder(1)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(2)
    private LasdecCode genLasdecCode;
    @TempTableColumnOrder(3)
    private RString zenkokuJushoCode;
    @TempTableColumnOrder(4)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(5)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(6)
    private RString hihokenshaName;
    @TempTableColumnOrder(7)
    private RString hihokenshajusho;
    @TempTableColumnOrder(8)
    private RString zenjusho;
    @TempTableColumnOrder(9)
    private RString genjusho;
    @TempTableColumnOrder(10)
    private AtenaKanaMeisho kanaMeisho;
    @TempTableColumnOrder(11)
    private AtenaMeisho meisho;
    @TempTableColumnOrder(12)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate idoYMD;
    @TempTableColumnOrder(14)
    private RString kouhoshakubun;
    @TempTableColumnOrder(15)
    private RString honninKubun;
    @TempTableColumnOrder(16)
    private RString choikiCode;
    @TempTableColumnOrder(17)
    private RString gyoseikuCode;
    @TempTableColumnOrder(18)
    private RString shichosonCode;
    @TempTableColumnOrder(19)
    private RString zenjushoCode;
    @TempTableColumnOrder(20)
    private YubinNo yubinNo;
    @TempTableColumnOrder(21)
    private RString chikuCode1;
    @TempTableColumnOrder(22)
    private RString chikuCode2;
    @TempTableColumnOrder(23)
    private RString chikuCode3;
    @TempTableColumnOrder(24)
    private RString juminJotaiCode;
    @TempTableColumnOrder(25)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(26)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(27)
    private RString seibetsuCode;
    @TempTableColumnOrder(28)
    private RString juminShubetsuCode;
    @TempTableColumnOrder(29)
    private RString torokuTodokedeYMD;
    @TempTableColumnOrder(30)
    private RString soufusenzenkokuJushoCode;
}
