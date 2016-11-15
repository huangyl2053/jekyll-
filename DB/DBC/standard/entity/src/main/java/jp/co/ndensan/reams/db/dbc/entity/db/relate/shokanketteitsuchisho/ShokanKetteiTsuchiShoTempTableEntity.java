/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 償還払い支給（不支給）決定通知書情報一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class ShokanKetteiTsuchiShoTempTableEntity extends DbTableEntityBase<ShokanKetteiTsuchiShoTempTableEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate uketsukeYMD;
    private RString shinseishaKubun;
    private RString shiharaiHohoKubunCode;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private FlexibleDate ketteiYMD;
    private RString ketteiTsuchiNo;
    private RString shikyuHushikyuKetteiKubun;
    private Decimal shiharaiKingaku;
    private Decimal shiharaiKingakuUchiwakeRiyoshabun;
    private Decimal sagakuKingakuGokei;
    @PrimaryKey
    private KinyuKikanCode kinyuKikanCode;
    private RString kinyuKikanMeisi;
    @PrimaryKey
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    private RString kinyuKikanShitenMeisi;
    private RString yokinShubetsu;
    private RString yokinShubetsuMeisho;
    private RString kozaNo;
    private AtenaKanaMeisho kozaMeiginin;
    private AtenaMeisho kozaMeigininKanji;
    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;
    private ShikibetsuCode shikibetsuCode;
    private Code hihokennshaKubunCode;
    private LasdecCode shichosonCode;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private RString meisho;
    private HihokenshaNo sashitomeHiHokenshaNo;
    private RString sashitomeKojoNo;
    private int kozaId;
}
