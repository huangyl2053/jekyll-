/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UrT0705ChoteiKyotsuEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 減免の情報クラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenShojoho {

    private DbT2002FukaEntity 介護賦課;
    private DbT2004GemmenEntity 介護賦課減免;
    private DbT2003KibetsuEntity 介護期別;
    private UrT0705ChoteiKyotsuEntity 調定共通;
    private Decimal 特徴期別金額01;
    private Decimal 特徴期別金額02;
    private Decimal 特徴期別金額03;
    private Decimal 特徴期別金額04;
    private Decimal 特徴期別金額05;
    private Decimal 特徴期別金額06;
    private Decimal 普徴期別金額01;
    private Decimal 普徴期別金額02;
    private Decimal 普徴期別金額03;
    private Decimal 普徴期別金額04;
    private Decimal 普徴期別金額05;
    private Decimal 普徴期別金額06;
    private Decimal 普徴期別金額07;
    private Decimal 普徴期別金額08;
    private Decimal 普徴期別金額09;
    private Decimal 普徴期別金額10;
    private Decimal 普徴期別金額11;
    private Decimal 普徴期別金額12;
    private Decimal 普徴期別金額13;
    private Decimal 普徴期別金額14;
    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private RString 減免状態区分;
    private TsuchishoNo 通知書番号;
    private SetaiCode 世帯コード;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 減免決定日;
    private Decimal 減免額;
    private Decimal 減免前介護保険料;
    private Decimal 確定介護保険料;
    private Code 減免種類;
    private RString 減免事由;
}
