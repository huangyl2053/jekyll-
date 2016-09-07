/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 構成市町村情報
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikiZenShichosonJohoParameter {

    private RString shichosonShokibetsuID;
    private LasdecCode shichosonCode;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString kokuhorenKoikiShichosonNo;
    private RString shichosonMeisho;
    private RString todofukenMeisho;
    private RString gunMeisho;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private RString yusenChikuCode;
    private RString tyohyoTodoufukenHyojiUmu;
    private RString tyohyoGunHyojiUmu;
    private RString tyohyoShichosonHyojiUmu;
    private RString tyohyoJushoHenshuHouhou;
    private RString tyohyoKatagakiHyojiUmu;
    private RString gaikokujinHyojiHouhou;
    private RString rojinhokenShichosonNo;
    private RString rokenJukyushaNoTaikei;
    private RString shotokuHikidashiHoho;
    private RString nofugakuDataRenkeiHoho;
    private RString tokuchoBunpaishuyaku;
    private FlexibleDate ikoYMD;
    private FlexibleDate kanyuYMD;
    private FlexibleDate ridatsuYMD;
    private RString gappeiKyuShichosonKubun;
    private RString gappeiKyuShichosonHyojiUmu;
    private RString gappeiChiikiNo;
    private ShoKisaiHokenshaNo unyoHokenshaNo;
    private FlexibleDate unyoKaishiYMD;
    private FlexibleDate unyoShuryoYMD;
    private RString unyoKeitaiKubun;

}
