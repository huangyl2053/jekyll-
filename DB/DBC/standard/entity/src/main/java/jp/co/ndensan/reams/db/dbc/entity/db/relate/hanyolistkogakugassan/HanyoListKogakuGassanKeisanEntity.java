/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassan;

import java.io.Serializable;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)Entityクラスです。
 *
 * @reamsid_L DBC-3100-020 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanKeisanEntity implements Serializable {

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private HihokenshaNo hihokenshaNo;
    private FlexibleYear taishoNendo;
    private HokenshaNo shoKisaiHokenshaNo;
    private RString shikyuShinseishoSeiriNo;
    private int rirekiNo;
    private RString hokenSeidoCode;
    private RString jikoFutanSeiriNo;
    private FlexibleDate taishoKeisanKaishiYMD;
    private FlexibleDate taishoKeisanShuryoYMD;
    private Decimal setaiFutanSogaku;
    private Decimal setaiGassanGaku;
    private Decimal over70_SetaiGassanGaku;
    private RString shotokuKubun;
    private RString over70_ShotokuKubun;
    private Decimal santeiKijunGaku;
    private Decimal over70_SanteiKijyunGaku;
    private Decimal setaiShikyuSogaku;
    private Decimal over70_SetaiShikyuSogaku;
    private Decimal honninShikyugaku;
    private Decimal over70_honninShikyugaku;
    private RString teiShotoku_1_SaiKeisanUmu;
    private RString biko;
    private YubinNo kekkaRenrakusakiYubinNo;
    private RString kekkaRenrakusakiJusho;
    private RString ketteRenrakusakiMeisho1;
    private RString kekkaRenrakusakiMeisho2;
    private FlexibleDate tsuchiYMD;
    private AtenaMeisho renrakuhyoHakkoshaMei;
    private YubinNo renrakuhyoHakkoshaYubinNo;
    private RString renrakuhyoHakkoshaJusho;
    private YubinNo toiawasesakiYobinNo;
    private RString toiawasesakiJusho;
    private RString toiawasesakiMeisho1;
    private RString toiawasesakiMeisho2;
    private TelNo toiawasesakiTelNo;
    private Decimal over70_FutangakuGokei;
    private Decimal over70_ShikyugakuGokei;
    private Decimal under70_FutangakuGokei;
    private Decimal futangakuGokei;
    private Decimal under70_ShikyugakuGokei;
    private Decimal shikyugakuGokei;
    private RString dataKubun;
    private FlexibleYearMonth uketoriYM;
    private FlexibleYearMonth sofuYM;
    private RString saisoFG;
    private FlexibleDate sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private DbT1001HihokenshaDaichoEntity 最新被保台帳;
    private UaFt250FindAtesakiEntity 宛先;
    private DbT4001JukyushaDaichoEntity 受給者台帳;
}
