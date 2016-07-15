/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特徴平準化計算対象者一覧entity
 *
 * @reamsid_L DBB-0810-020 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeijyunkaTaishoshaEntity {

    private FlexibleYear 調定年度;
    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private RString 更正前後区分;
    private RString 作成処理名;
    private int 賦課履歴番号;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private SetaiCode 世帯コード;
    private int 世帯員数;
    private FlexibleDate 資格取得日;
    private RString 資格取得事由;
    private FlexibleDate 資格喪失日;
    private RString 資格喪失事由;
    private RString 生活保護扶助種類;
    private FlexibleDate 生保開始日;
    private FlexibleDate 生保廃止日;
    private FlexibleDate 老齢開始日;
    private FlexibleDate 老齢廃止日;
    private FlexibleDate 賦課期日;
    private RString 課税区分;
    private RString 世帯課税区分;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;
    private RString 保険料段階;
    private RString 保険料算定段階1;
    private Decimal 算定年額保険料1;
    private FlexibleYearMonth 月割開始年月1;
    private FlexibleYearMonth 月割終了年月1;
    private RString 保険料算定段階2;
    private Decimal 算定年額保険料2;
    private FlexibleYearMonth 月割開始年月2;
    private FlexibleYearMonth 月割終了年月2;
    private YMDHMS 調定日時;
    private RString 調定事由1;
    private RString 調定事由2;
    private RString 調定事由3;
    private RString 調定事由4;
    private RString 更正月;
    private Decimal 減免前介護保険料年額;
    private Decimal 減免額;
    private Decimal 確定介護保険料年額;
    private RString 保険料段階仮算定時;
    private int 徴収方法履歴番号;
    private YMDHMS 異動基準日時;
    private RString 口座区分;
    private RString 境界層区分;
    private RString 職権区分;
    private LasdecCode 賦課市町村コード;
    private Decimal 特徴歳出還付額;
    private Decimal 普徴歳出還付額;
    private Decimal 特徴期期別金額01;
    private Decimal 特徴期期別金額02;
    private Decimal 特徴期期別金額03;
    private Decimal 特徴期期別金額04;
    private Decimal 特徴期期別金額05;
    private Decimal 特徴期期別金額06;
    private Decimal 普徴期期別金額01;
    private Decimal 普徴期期別金額02;
    private Decimal 普徴期期別金額03;
    private Decimal 普徴期期別金額04;
    private Decimal 普徴期期別金額05;
    private Decimal 普徴期期別金額06;
    private Decimal 普徴期期別金額07;
    private Decimal 普徴期期別金額08;
    private Decimal 普徴期期別金額09;
    private Decimal 普徴期期別金額10;
    private Decimal 普徴期期別金額11;
    private Decimal 普徴期期別金額12;
    private Decimal 普徴期期別金額13;
    private Decimal 普徴期期別金額14;
    private RString 徴収方法4月;
    private RString 徴収方法5月;
    private RString 徴収方法6月;
    private RString 徴収方法7月;
    private RString 徴収方法8月;
    private RString 徴収方法9月;
    private RString 徴収方法10月;
    private RString 徴収方法11月;
    private RString 徴収方法12月;
    private RString 徴収方法1月;
    private RString 徴収方法2月;
    private RString 徴収方法3月;
    private RString 徴収方法翌4月;
    private RString 徴収方法翌5月;
    private RString 徴収方法翌6月;
    private RString 徴収方法翌7月;
    private RString 徴収方法翌8月;
    private RString 徴収方法翌9月;
    private RString 仮徴収基礎年金番号;
    private RString 仮徴収年金コード;
    private RString 仮徴収捕捉月;
    private RString 本徴収基礎年金番号;
    private RString 本徴収年金コード;
    private RString 本徴収捕捉月;
    private RString 翌年度仮徴収基礎年金番号;
    private RString 翌年度仮徴収年金コード;
    private RString 翌年度仮徴収捕捉月;
    private boolean 依頼情報送付済みフラグ;
    private boolean 追加依頼情報送付済みフラグ;
    private YMDHMS 特別徴収停止日時;
    private RString 特別徴収停止事由コード;
    private Decimal 特徴収入額01;
    private Decimal 特徴収入額02;
    private Decimal 特徴収入額03;
    private Decimal 特徴収入額04;
    private Decimal 特徴収入額05;
    private Decimal 特徴収入額06;
    private Decimal 普徴収入額01;
    private Decimal 普徴収入額02;
    private Decimal 普徴収入額03;
    private Decimal 普徴収入額04;
    private Decimal 普徴収入額05;
    private Decimal 普徴収入額06;
    private Decimal 普徴収入額07;
    private Decimal 普徴収入額08;
    private Decimal 普徴収入額09;
    private Decimal 普徴収入額10;
    private Decimal 普徴収入額11;
    private Decimal 普徴収入額12;
    private Decimal 普徴収入額13;
    private Decimal 普徴収入額14;
    private UaFt200FindShikibetsuTaishoEntity 宛名の情報;
    private RString 特別徴収業務者コード;
    private RString 備考コード;
    private boolean 平準化済フラグ;
    private Decimal 変更前特徴額_１期;
    private Decimal 変更前特徴額_２期;
    private Decimal 変更前特徴額_３期;
    private Decimal 変更前特徴額_４期;
    private Decimal 変更前特徴額_５期;
    private Decimal 変更前特徴額_６期;
}
