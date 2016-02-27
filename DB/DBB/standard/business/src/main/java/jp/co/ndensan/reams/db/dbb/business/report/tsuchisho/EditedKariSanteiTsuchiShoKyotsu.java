/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EditedKariSanteiTsuchiShoKyotsu {

    RString 編集後宛先;//
    RString 編集後個人;//
    RString 表示コード;//
    HihokenshaNo 被保険者番号;
    ShikibetsuCode 識別コード;
    FlexibleYear 調定年度;
    RString 調定年度_年度あり;
    RString 調定年度_年度なし;
    FlexibleYear 賦課年度;
    RString 賦課年度_年度あり;
    RString 賦課年度_年度なし;
    TsuchishoNo 通知書番号;
    boolean 前年度情報有無;

    RString 前年度賦課年度;
    RString 前年度保険料段階;
    Decimal 前年度保険料率;
    Decimal 前年度減免前介護保険料_年額;
    Decimal 前年度確定介護保険料_年額;
    Decimal 前年度特徴期別金額01;
    Decimal 前年度特徴期別金額02;
    Decimal 前年度特徴期別金額03;
    Decimal 前年度特徴期別金額04;
    Decimal 前年度特徴期別金額05;
    Decimal 前年度最終期特徴期別介護保険料;
    Decimal 前年度最終期普徴期別介護保険料;

    Decimal 更正前介護保険料仮徴収額合計;
    Decimal 更正前介護保険料減免額;
    Decimal 更正前特徴期別金額01;
    Decimal 更正前特徴期別金額02;
    Decimal 更正前特徴期別金額03;
    Decimal 更正前特徴期別金額合計;
    List<普徴期別金額Entity> 更正前普徴期別金額リスト;
    Decimal 更正前普徴期別金額合計;
    RString 更正前資格取得日;
    RString 更正前資格取得日_西暦;
    RString 更正前資格喪失日;
    RString 更正前資格喪失日_西暦;
    RString 更正前期間_自;
    RString 更正前期間_自_西暦;
    RString 更正前期間_至;
    RString 更正前期間_至_西暦;
    RString 更正前保険料段階;
    RString 更正前保険料率;
    RString 更正前特別徴収義務者;
    RString 更正前特別徴収対象年金;
    RString 更正前特別徴収義務者コード;//
    RString 更正前特別徴収対象年金コード;//
    KozaKubun 更正前口座区分;
    RString 更正前生保開始日;
    RString 更正前生保開始日_西暦;
    RString 更正前生活保護扶助種類;
    RString 更正前徴収方法;

    Decimal 更正後介護保険料仮徴収額合計;
    Decimal 更正後介護保険料減免額;
    Decimal 更正後特徴期別金額01;
    Decimal 更正後特徴期別金額02;
    Decimal 更正後特徴期別金額03;
    Decimal 更正後特徴期別金額合計;
    List<普徴期別金額Entity> 更正後普徴期別金額リスト;
    Decimal 更正後普徴第１期金額;
    Decimal 更正後普徴第２期金額;
    Decimal 更正後普徴期別金額合計;
    RString 更正後資格取得日;
    RString 更正後資格取得日_西暦;
    RString 更正後資格喪失日;
    RString 更正後資格喪失日_西暦;
    RString 更正後期間_自;
    RString 更正後期間_自_西暦;
    RString 更正後期間_至;
    RString 更正後期間_至__西暦;
    RString 更正後保険料段階;
    RString 更正後保険料率;
    RString 更正後特別徴収義務者;
    RString 更正後特別徴収対象年金;
    RString 更正後特別徴収義務者コード;	//
    RString 更正後特別徴収対象年金コード;	//
    KozaKubun 更正後口座区分;
    RString 更正後生保開始日;
    RString 更正後生保開始日_西暦;
    RString 更正後生活保護扶助種類;
    //text 更正後徴収方法;

    Decimal 増減額;
    Decimal 納付済額_未到来期含む;
    Decimal 納付済額_未到来期含まない;
    Decimal 普徴納付済額_未到来期含む1;
    Decimal 特徴納付済額_未到来期含まない1;
    Decimal 普徴納付済額_未到来期含む2;
    Decimal 特徴納付済額_未到来期含まない2;
    RString 納付済額算出年月日;//
    Decimal 既に納付すべき額;
    Decimal 今後納付すべき額;
    Decimal 普徴既に納付すべき額;
    Decimal 特徴既に納付すべき額;
    Decimal 普徴今後納付すべき額_調定元に;
    Decimal 普徴今後納付すべき額_収入元に;
    Decimal 特徴今後納付すべき額;
    RString 編集後口座;//
    RString 調定事由１;
    RString 調定事由２;
    RString 調定事由３;
    RString 調定事由４;

    List<特徴納期情報Entity> 特徴納期情報リスト;
    List<普徴納期情報Entity> 普徴納期情報リスト;

    int 普徴期数;
    //text 保険者名;
    RString 保険者番号;//
    List<収入情報Entity> 普徴収入情報リスト;

    List<収入情報Entity> 特徴収入情報リスト;

}
