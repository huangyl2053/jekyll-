/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付額減額滞納者把握情報の取得SQL用結果クラスです．
 *
 * @reamsid_L DBD-3610-050 x_lilh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuGengakuHaakuListSakuseiEntity {

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private AtenaKanaMeisho hihokenshaShimeiKana;
    private AtenaMeisho hihokenshaShimei;
    private SetaiCode setaiCode;
    private GyoseikuCode gyoseikuCode;
    private RString gyoseikuName;
    private ZenkokuJushoCode jushoCode;
    private YubinNo yubinNo;
    private RString jusho;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuJiyuCode;
    private RString hihokennshaKubunCode;
    private boolean koikinaiJushochiTokureiFlag;
    private boolean seihoFlag;
    private Code koroshoIfShikibetsuCode;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;
    private boolean shiseityuFlag;
    private FlexibleDate jukyuShinseiYMD;
    private RYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString tokucho_FuchoKubun;
    private TsuchishoNo tsuchishoNo;
    private RString kibetsu;
    private Decimal choteigaku;
    private Decimal shunyugaku;
    private Decimal minogaku;
    private RDate shunyuYMD;
    private RDate tokusokujoHakkoYMD;
    private FlexibleDate jikoKisanYMD;
    private RString jikoKisanJiyu;
    private RString minoKannoKubun;
    private RString jikoKubun;
    private HihokenshaNo hihokenshaNo2;
    private DbT4025ShiharaiHohoHenkoGengakuEntity shiharaiHohoHenkoGengaku;
    private UaFt200FindShikibetsuTaishoEntity findShikibetsuTaishoEntity;
    private RString tainoKubun;

}
