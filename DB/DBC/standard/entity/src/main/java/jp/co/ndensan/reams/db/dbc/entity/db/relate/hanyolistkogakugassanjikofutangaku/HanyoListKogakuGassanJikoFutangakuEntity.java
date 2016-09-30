/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanjikofutangaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 汎用リスト出力(高額合算自己負担額情報)Entityクラスです。
 *
 * @reamsid_L DBC-3102-020 sunqingzhu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanJikoFutangakuEntity {

    private LasdecCode 市町村コード;
    private HihokenshaNo 被保険者番号;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 被保険者区分コード;
    private boolean 住所地特例フラグ;
    private RString 受給申請事由;
    private RString 要支援者認定申請区分;
    private FlexibleDate 受給申請年月日;
    private RString 要介護認定状態区分コード;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private FlexibleDate 認定年月日;
    private boolean 旧措置者フラグ;
    private RString みなし要介護区分コード;
    private RString 直近異動事由コード;
    private RString 対象年度;
    private RString 保険者番号;
    private RString 支給申請書整理番号;
    private RString 履歴番号;
    private RString 所得区分;
    private RString 所得区分_70歳以上;
    private RString 自己負担額証明書整理番号;
    private RString 異動区分;
    private RString 補正済自己負担額送付区分;
    private FlexibleDate 対象計算期間開始年月日;
    private FlexibleDate 対象計算期間終了年月日;
    private FlexibleDate 被保険者期間開始年月日;
    private FlexibleDate 被保険者期間終了年月日;
    private FlexibleDate 申請年月日;
    private HihokenshaNo 高額合算自己負担額_被保険者番号;
    private Decimal 高額合算自己負担額明細004_自己負担額;
    private Decimal 高額合算自己負担額明細004_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細004_70_74高額支給額;
    private Decimal 高額合算自己負担額明細005_自己負担額;
    private Decimal 高額合算自己負担額明細005_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細005_70_74高額支給額;
    private Decimal 高額合算自己負担額明細006_自己負担額;
    private Decimal 高額合算自己負担額明細006_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細006_70_74高額支給額;
    private Decimal 高額合算自己負担額明細007_自己負担額;
    private Decimal 高額合算自己負担額明細007_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細007_70_74高額支給額;
    private Decimal 高額合算自己負担額明細008_自己負担額;
    private Decimal 高額合算自己負担額明細008_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細008_70_74高額支給額;
    private Decimal 高額合算自己負担額明細009_自己負担額;
    private Decimal 高額合算自己負担額明細009_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細009_70_74高額支給額;
    private Decimal 高額合算自己負担額明細010_自己負担額;
    private Decimal 高額合算自己負担額明細010_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細010_70_74高額支給額;
    private Decimal 高額合算自己負担額明細011_自己負担額;
    private Decimal 高額合算自己負担額明細011_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細011_70_74高額支給額;
    private Decimal 高額合算自己負担額明細012_自己負担額;
    private Decimal 高額合算自己負担額明細012_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細012_70_74高額支給額;
    private Decimal 高額合算自己負担額明細101_自己負担額;
    private Decimal 高額合算自己負担額明細101_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細101_70_74高額支給額;
    private Decimal 高額合算自己負担額明細102_自己負担額;
    private Decimal 高額合算自己負担額明細102_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細102_70_74高額支給額;
    private Decimal 高額合算自己負担額明細103_自己負担額;
    private Decimal 高額合算自己負担額明細103_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細103_70_74高額支給額;
    private Decimal 高額合算自己負担額明細104_自己負担額;
    private Decimal 高額合算自己負担額明細104_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細104_70_74高額支給額;
    private Decimal 高額合算自己負担額明細105_自己負担額;
    private Decimal 高額合算自己負担額明細105_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細105_70_74高額支給額;
    private Decimal 高額合算自己負担額明細106_自己負担額;
    private Decimal 高額合算自己負担額明細106_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細106_70_74高額支給額;
    private Decimal 高額合算自己負担額明細107_自己負担額;
    private Decimal 高額合算自己負担額明細107_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細107_70_74高額支給額;
    private Decimal 高額合算自己負担額_合計_自己負担額;
    private Decimal 高額合算自己負担額_合計_70_74自己負担額_内訳;
    private Decimal 高額合算自己負担額_合計_70_74高額支給額;
    private Decimal 高額合算自己負担額明細004_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細004_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細004_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細005_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細005_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細005_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細006_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細006_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細006_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細007_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細007_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細007_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細008_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細008_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細008_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細009_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細009_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細009_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細010_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細010_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細010_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細011_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細011_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細011_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細012_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細012_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細012_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細101_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細101_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細101_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細102_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細102_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細102_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細103_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細103_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細103_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細104_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細104_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細104_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細105_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細105_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細105_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細106_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細106_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細106_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額明細107_補正済_自己負担額;
    private Decimal 高額合算自己負担額明細107_補正済_70_74自己負担額_内数;
    private Decimal 高額合算自己負担額明細107_補正済_70_74高額支給額;
    private Decimal 高額合算自己負担額_補正済_合計_自己負担額;
    private Decimal 高額合算自己負担額_補正済_合計_70_74自己負担額_内訳;
    private Decimal 高額合算自己負担額_補正済_合計_70_74高額支給額;
    private RString 高額合算自己負担額_データ作成区分;
    private FlexibleYearMonth 高額合算自己負担額_自己負担額確認情報受取年月;
    private FlexibleYearMonth 高額合算自己負担額_補正済自己負担額情報送付年月;
    private FlexibleYearMonth 高額合算自己負担額_自己負担額証明書情報受取年月;
    private RString 高額合算自己負担額_送付対象外フラグ;
    private FlexibleDate 高額合算自己負担額_自己負担額計算年月日;
    private FlexibleDate 高額合算自己負担額_自己負担額証明書作成年月日;
    private FlexibleDate 高額合算自己負担額_バッチ補正実施年月日;
    private FlexibleDate 高額合算自己負担額_リアル補正実施年月日;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private UaFt250FindAtesakiEntity 宛先Entity;

}
