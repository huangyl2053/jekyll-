/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定更新お知らせ通知書発行のSQL結果クラスです。。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class KoshinOshiraseTsuchiUpdateEntity {

    private Code koroshoIfShikibetsuCode;
    private RString hihokenshaNo;
    private AtenaMeisho hihokenshaName;
    private AtenaKanaMeisho hihokenshaKana;
    private FlexibleDate ninteiShinseiYMD;
    private RString ninteiShinseiRiyu;
    private Code ninteiShinseiShinseijiKubunCode;
    private Code ninteiShinseiHoreiKubunCode;
    private JigyoshaNo nyushoShisetsuCode;
    private FlexibleDate seinengappiYMD;
    private Code seibetsu;
    private TelNo telNo;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private ShinseishoKanriNo shinseishoKanriNo;
    private FlexibleDate ninteiYMD;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private Code yokaigoJotaiKubunCode;
    private Code shichosonCode;
    private RString shichosonMeisho;
    private JigyoshaNo jigyoshaNo;
    private RString jigyoshaMeisho;
    private AtenaKanaMeisho jigyoshaName;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;

}
