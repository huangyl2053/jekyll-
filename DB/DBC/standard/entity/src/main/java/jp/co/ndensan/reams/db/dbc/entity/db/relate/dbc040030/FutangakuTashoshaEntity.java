/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 負担額補正対象者データentityクラスです。
 *
 * @reamsid_L DBC-2320-060 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutangakuTashoshaEntity implements IDbAccessable, Serializable {

    private RString sourceKey;
    private RString sourceKeName;
    private RString kaipejiKey;
    private RString kaipejiKeyName;

    private HihokenshaNo hihokenshaNo;
    private FlexibleYear taishoNendo;
    private HokenshaNo hokenshaNo;
    private RString shikyuShinseishoSeiriNo;
    private int rirekiNo2;

    private RString hokenSeidoCode;
    private RString hokenshaMei;
    private RString kokuho_HihokenshaShoKigo;
    private AtenaKanaMeisho hihokenshaShimeiKana;
    private AtenaMeisho hihokenshaShimei;
    private FlexibleDate umareYMD;
    private Code seibetsuCode;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private FlexibleDate hihokenshaKaishiYMD;
    private FlexibleDate hihokenshaShuryoYMD;
    private FlexibleDate shinseiYMD;

    private Decimal gokei_JikoFutanGaku;
    private Decimal gokei_70_74JikoFutanGaku;
    private Decimal gokei_Under70KogakuShikyuGaku;
    private Decimal gokei_70_74KogakuShikyuGaku;

    private Decimal sumi_Gokei_JikoFutanGaku;
    private Decimal sumi_Gokei_70_74JikoFutanGaku;
    private Decimal sumi_Gokei_Under70KogakuShikyuGaku;
    private Decimal sumi_Gokei_70_74KogakuShikyuGaku;

    private RString dataSakuseiKubun;
    private FlexibleYearMonth kakunin_UketoriYM;
    private FlexibleYearMonth hoseiZumi_SofuYM;
    private FlexibleYearMonth shomeisho_UketoriYM;
    private RString saisoFlag;
    private RString sofuTaishoGaiFlag;
    private FlexibleDate jikoFutanKeisanYMD;
    private FlexibleDate shomeiShoSakuseiYMD;
    private RString jikoFutangakuShomeishoRealHakkoFlag;
    private FlexibleDate batchHoseiJissiYMD;
    private FlexibleDate realHoseiJissiYMD;

    private RString juminShubetsuCode;
    private LasdecCode shichosonCode;
    private YubinNo yubinNo;
    private ZenkokuJushoCode zenkokuJushoCode;
    private GyoseikuCode gyoseikuCode;
    private RString ichiranBiko;
    private RString jikoFutanGakuHoseiJissi;
    private RString kogakuShikyuGakuGakuHoseiJissi;
    private RString ichiranKakuninKubun;
    private RString ichiranKakuninKubun2;

}
