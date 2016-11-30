/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.taishosetaiinido;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import lombok.Getter;
import lombok.Setter;

/**
 * select基準収入額適用管理のEntityクラスです。
 *
 * @reamsid_L DBC-4640-080 liuxiaoyu
 */
@Getter
@Setter
public class KijunShunyugakuTekiyoKanriEntity {

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private SetaiCode setaiCode;
    @PrimaryKey
    private FlexibleYear nendo;
    @PrimaryKey
    private int rirekiNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    private Decimal kotekiNenkinShunyugaku;
    private Decimal kyuyoShunyugaku;
    private Decimal sonotaShunyugaku;
    private Decimal santeiKijungaku;
    private FlexibleYearMonth tekiyoKaishiYMD;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate shinseishoSakuseiYMD;
    private FlexibleDate shinseishoSakuseiSetaiKijunYMD;
    private FlexibleDate ketteiTsuchishoHakkoYMD;
    private boolean atesakiInjiTaishoshaFlag;
    private int nenshoFuyokojoUnder16Ninzu;
    private int nenshoFuyokojoOver16Ninzu;
    private Decimal setaiinSoShunyugaku;
    private boolean setainushiFlag;
    private Decimal kazeiShotokugaku;
    private Decimal kazeiShotokugakuKojogo;
    private ShikibetsuCode shikibetsuCode;
}
