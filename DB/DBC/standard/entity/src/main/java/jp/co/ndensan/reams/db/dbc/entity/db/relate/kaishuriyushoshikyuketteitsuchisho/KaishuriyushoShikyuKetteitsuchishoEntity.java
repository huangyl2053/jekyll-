/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修理由書作成手数料請求取得のEntityです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaishuriyushoShikyuKetteitsuchishoEntity {

    private FlexibleDate shikyu_FushikyuKetteiYMD;
    private RString shikyu_FushikyuKubun;
    private RString fushikyuRiyu;
    private FlexibleDate tesuryoShiharaiYoteiYMD;

    private FlexibleDate riyushoSakuseiUketsukeYMD;
    private HihokenshaNo hihokenshaNo;
    private FlexibleDate riyushoSakuseiYMD;
    private RString kaishuTaishoJutakuJusho;
    private RString kaishuNaiyo_kasho_Kibo;
    private JigyoshaNo riyushoSakuseiJigyoshaNo;

    private AtenaMeisho jutakuKaishuJigyoshaMeisho;
    private Decimal riyushoSakuseiSeikyuKingaku;
    private ShikibetsuCode shikibetsuCode;
    private HokenshaNo shoKisaiHokenshaNo;
    private ServiceCode serviceCode;
    private FlexibleDate jutakuKaishuChakkoYMD;
    private AtenaMeisho jutakuKaishuJushoShozaisha;
    private AtenaMeisho riyushoSakuseishaMei;
    private RString riyushoSakuseishaMeiKana;
    private FlexibleDate riyushoSakuseiShinseiYMD;
    private RString shukeiNo;
    private boolean shukeiFlag;
}
