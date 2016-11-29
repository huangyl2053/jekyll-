/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 編集後本算定通知書共通情報です。
 *
 * @reamsid_L DBB-9020-160 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EditedHonSanteiTsuchiShoKyotsu {

    private EditedAtesaki 編集後宛先;
    private EditedKojin 編集後個人;
    private HyojiCodes 表示コード;
    private HihokenshaNo 被保険者番号;
    private FlexibleYear 調定年度;
    private RString 調定年度_年度あり;
    private RString 調定年度_年度なし;
    private FlexibleYear 賦課年度;
    private RString 賦課年度_年度あり;
    private RString 賦課年度_年度なし;
    private ShikibetsuCode 識別コード;
    private TsuchishoNo 通知書番号;
    private EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正前;
    private EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後;
    private Decimal 減免額;
    private Decimal 増減額;
    private Decimal 納付済額_未到来期含む;
    private Decimal 納付済額_未到来期含まない;
    private Decimal 未到来期の納付済額;
    private Decimal 普徴納付済額_未到来期含む;
    private Decimal 特徴納付済額_未到来期含む;
    private Decimal 普徴納付済額_未到来期含まない;
    private Decimal 特徴納付済額_未到来期含まない;
    private RString 納付済額算出年月日;
    private Decimal 既に納付すべき額;
    private Decimal 今後納付すべき額_調定元に;
    private Decimal 今後納付すべき額_収入元に;
    private Decimal 普徴既に納付すべき額;
    private Decimal 特徴既に納付すべき額;
    private Decimal 普徴今後納付すべき額_調定元に;
    private Decimal 普徴今後納付すべき額_収入元に;
    private Decimal 特徴今後納付すべき額_調定元に;
    private Decimal 特徴今後納付すべき額_収入元に;
    private Decimal 特別徴収額合計;
    private Decimal 普通徴収額合計;
    private EditedKoza 編集後口座;
    private RString 調定事由１;
    private RString 調定事由２;
    private RString 調定事由３;
    private RString 調定事由４;
    private List<AfterEditInformation> 普徴納期情報リスト;
    private List<AfterEditInformation> 特徴納期情報リスト;
    private int 普徴期数_現年度;
    private RString 保険者名;
    private HihokenshaNo 保険者番号;
    private List<SamantabhadraIncomeInformation> 普徴収入情報リスト;
    private List<SpecialIncomeInformation> 特徴収入情報リスト;

}
