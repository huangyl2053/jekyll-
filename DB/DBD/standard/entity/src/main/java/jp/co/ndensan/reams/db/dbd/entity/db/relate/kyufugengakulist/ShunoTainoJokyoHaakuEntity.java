/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 収納滞納状況把握情報の取得SQL用結果クラスです．
 *
 * @reamsid_L DBD-3610-050 x_miaocl
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoTainoJokyoHaakuEntity {

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private AtenaKanaMeisho hihokenshaShimeiKana;
    private AtenaMeisho hihokenshaShimei;
    private SetaiCode setaiCode;//世帯番号
    private GyoseikuCode gyoseikuCode;
    private RString gyoseikuName;//行政区
    private ZenkokuJushoCode jushoCode;//住所コード
    private YubinNo yubinNo;
    private AtenaJusho jusho;//住所
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuSoshitsuYMD;
    private RString shikakuSoshitsuJiyuCode;//喪失事由
    private RString hihokennshaKubunCode;
    private RString koikinaiJushochiTokureiFlag;
    private boolean seihoFlag;//生保フラグ
    private Code koroshoIfShikibetsuCode;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;
    private boolean shiseityuFlag;//申請中フラグ
    private FlexibleDate jukyuShinseiYMD;//
    private RYear choteiNendo;
    private RYear fukaNendo;
    private RString tokucho_FuchoKubun;
    private TsuchishoNo tsuchishoNo;
    private RString kibetsu;//期別
    private Decimal choteigaku;
    private Decimal shunyugaku;
    private Decimal minogaku;//未納額
    private RDate shunyuYMD;
    private RDate tokusokujoHakkoYMD;
    private FlexibleDate jikoKisanYMD;//時効起算日
    private RString jikoKisanJiyu;
    private RString minoKannoKubun;//未納完納区分DBZ
    private RString jikoKubun;//時効区分DBZ
    private HihokenshaNo hihokenshaNo2;
    private DbT4022ShiharaiHohoHenkoTainoEntity shiharaiHohoHenkoTaino;

}
