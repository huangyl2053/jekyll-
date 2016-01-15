/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.db.relate.gappeijoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 広域合併情報取得_返却Entity
 */
@lombok.Getter
@lombok.Setter
@lombok.AllArgsConstructor
public class KouikiGappeiJyohoEntity implements IDbAccessable {

    private RString chiikiNo;
    private RString gappeiShurui;
    private FlexibleDate gappeiYMD;
    private LasdecCode gappeiShichosonCode;
    private ShoKisaiHokenshaNo hokenshaNo;
    private FlexibleDate kyuJohoFuyoToYMD;
    private FlexibleDate kokuhorenDataFromYMD;
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

    private KouikiGappeiJyohoEntity() {
    }
}
