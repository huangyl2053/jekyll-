/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算支給決定通知書entityクラスです。
 *
 * @reamsid_L DBC-2300-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanShikyuKetteitsuchishoEntity {

    private RString shikyuKubun;
    private RString shutsuryokujunMei1;
    private RString shutsuryokujunMei2;
    private RString shutsuryokujunMei3;
    private RString shutsuryokujunMei4;
    private RString shutsuryokujunMei5;
    private RString kaiPeiji1;
    private RString kaiPeiji2;
    private RString kaiPeiji3;
    private RString kaiPeiji4;
    private RString kaiPeiji5;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYear taishoNendo;
    private HokenshaNo hokenshaNo;
    private RString shikyuSeiriNo;
    private int rirekiNo;
    private RString jikoFutanSeiriNo;
    private RString hokenSeidoCode;
    private RString kokuho_HihokenshaShoKigo;
    private FlexibleDate keisanKaishiYMD;
    private FlexibleDate keisanShuryoYMD;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private Decimal jikoFutanSogaku;
    private RString shikyuKubunCode;
    private Decimal shikyugaku;
    private RString kyufuShurui;
    private RString fushikyuRiyu;
    private RString biko;
    private RString shiharaiHohoKubun;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private FlexibleDate ketteiTsuchiSakuseiYMD;
    private FlexibleDate furikomiTsuchiSakuseiYMD;
    private FlexibleYearMonth uketoriYM;
    private long kozaID;
    private RString ketteiTsuchiRealHakkoFlag;
    private KogakugassanShikyuKetteiKozaJyohoEntity 口座情報;
    private HihokenshaDaichoResultEntity 被保検者情報;
    private UaFt250FindAtesakiEntity 宛先Entity;
}
