/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 編集後仮算定通知書共通情報です。
 *
 * @reamsid_L DBB-9110-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EditedKariSanteiTsuchiShoKyotsu {

    private EditedAtesaki 編集後宛先;
    private EditedKojin 編集後個人;
    private RString 表示コード1;
    private RString 表示コード２;
    private RString 表示コード３;
    private RString 表示コード１名;
    private RString 表示コード２名;
    private RString 表示コード３名;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private FlexibleYear 調定年度;
    private RString 調定年度_年度あり;
    private RString 調定年度_年度なし;
    private FlexibleYear 賦課年度;
    private RString 賦課年度_年度あり;
    private RString 賦課年度_年度なし;
    private TsuchishoNo 通知書番号;
    private Boolean 前年度情報有無;
    private PrecedingFiscalYearInformation 前年度情報;
    private EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前;
    private EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後;
    private Decimal 増減額;
    private Decimal 納付済額_未到来期含む;
    private Decimal 納付済額_未到来期含まない;
    private Decimal 普徴納付済額_未到来期含む;
    private Decimal 普徴納付済額_未到来期含まない;
    private Decimal 特徴納付済額_未到来期含む;
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
    private EditedKoza 編集後口座;
    private RString 調定事由１;
    private RString 調定事由２;
    private RString 調定事由３;
    private RString 調定事由４;
    private List<Kitsuki> 特徴納期情報リスト;
    private List<UniversalSignDeliveryInformation> 普徴納期情報リスト;
    private List<OrdinaryIncomeInformation> 普徴収入情報リスト;
    private int 普徴期数;
    private RString 保険者名;
    private LasdecCode 保険者番号;
    private List<OrdinaryIncomeInformation> 特徴収入情報リスト;

}
