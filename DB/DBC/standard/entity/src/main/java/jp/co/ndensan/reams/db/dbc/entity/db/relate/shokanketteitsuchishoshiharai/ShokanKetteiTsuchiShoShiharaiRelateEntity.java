/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給（不支給）決定通知書情報Entityクラスです。
 *
 * @reamsid_L DBC-1000-030 zuotao
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanKetteiTsuchiShoShiharaiRelateEntity {

    private RString seiriNo;
    private RString ketteiTsuchiNo;
    private HihokenshaNo hiHokenshaNo;
    private RString hiHokenshaShimei;
    private RString jusho;
    private RString yubinNo;
    private RString banchi;
    private FlexibleYearMonth teikyoYM;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate uketsukeYMD;
    private RString shinseishaKubun;
    private FlexibleDate ketteiYMD;
    private Decimal shiharaiKingakuUchiwakeRiyoshabun;
    private Decimal shiharaiKingaku;
    private RString ryakusho;
    private int kingaku;
    private RString tuika;
    private RString serviceNameRyaku;
    private RString shikyuHushikyuKetteiKubun;
    private RString zougenRiyu;
    private KinyuKikanCode kinyuKikanCode;
    private RString kinyuKikanName;
    private RString shideMeisho;
    private RString yokinShubetsuMeisho;
    private RString kozaBango;
    private RString kozaMeigininKanji;
    private RString shiharaiHohoKubunCode;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private RString serviceShuruiCode;
    private ShikibetsuCode shikibetsuCode;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private UaFt250FindAtesakiEntity 宛先Entity;
    private RString shiharaiBasho;
    private RString kinyuKikanShitenCode;
    private RString kozaMeiginin;
    private Decimal sagakuKingakuGokei;
    private RString kinyuKikanMeisi;
    private RString kinyuKikanShitenMeisi;
    private RString yokinShubetsuMeisi;
    private FlexibleDate kaishiYMD;
    private RString hihokennshaKubunCode;
    private RString shichosonCode;
    private RString sashitomeHiHokenshaNo;
    private RString sashitomeKojoNo;
}
