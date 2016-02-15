/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchishoshiharai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給（不支給）決定通知書情報Entityクラスです。
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
    private FlexibleDate ketteiYMD;
    private Decimal shiharaiKingakuUchiwakeRiyoshabun;
    private Decimal shiharaiKingaku;
    private RString ryakusho;
    private Decimal kingaku;
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
    private RString shoKisaiHokenshaNo;
}
