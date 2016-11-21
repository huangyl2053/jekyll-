/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得照会票データTempのクラスです。
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuShoukaiDataMapaEntity {

    private ShikibetsuCode shikibetsuCode;
    private LasdecCode genLasdecCode;
    private LasdecCode soufusenzenkokuJushoCode;
    private RString zenkokuJushoCode;
    private SetaiCode setaiCode;
    private HihokenshaNo hihokenshaNo;
    private RString hihokenshaName;
    private RString hihokenshajusho;
    private RString zenjusho;
    private RString genjusho;
    private AtenaKanaMeisho kanaMeisho;
    private AtenaMeisho meisho;
    private FlexibleDate seinengappiYMD;
    private FlexibleDate idoYMD;
    private RString kouhoshakubun;
    private RString honninKubun;
    private RString choikiCode;
    private RString gyoseikuCode;
    private ZenkokuJushoCode shichosonCode;
    private RString zenjushoCode;
    private YubinNo yubinNo;
    private RString chikuCode1;
    private RString chikuCode2;
    private RString chikuCode3;
    private RString juminJotaiCode;
    private RString kannaiKangaiKubun;
    private RString hihokennshaKubunCode;
    private RString seibetsuCode;
    private RString juminShubetsuCode;
    private FlexibleDate torokuTodokedeYMD;
}
