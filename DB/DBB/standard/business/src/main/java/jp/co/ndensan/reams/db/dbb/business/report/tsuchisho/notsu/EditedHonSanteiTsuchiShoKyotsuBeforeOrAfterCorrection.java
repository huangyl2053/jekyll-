/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.fuka.KozaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 編集後本算定通知書共通情報の更正前後です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection {

    private Decimal 保険料率;
    private Decimal 減免前保険料_年額;
    private Decimal 減免額;
    private Decimal 確定保険料_年額;
    private RString 保険料段階;
    private RString 保険料算定段階1;
    private Decimal 算定年額保険料1;
    private RString 月割開始年月1;
    private RString 月割開始年月1_西暦;
    private RString 月割終了年月1;
    private RString 月割終了年月1_西暦;
    private RString 保険料算定段階2;
    private Decimal 算定年額保険料2;
    private RString 月割開始年月2;
    private RString 月割開始年月2_西暦;
    private RString 月割終了年月2;
    private RString 月割終了年月2_西暦;
    private RString 期間_自;
    private RString 期間_自_西暦;
    private RString 期間_至;
    private RString 期間_至_西暦;
    private int 月数;
    private RString 月数_ケ月;
    private RString 市町村民税課税区分_本人;
    private RString 市町村民税課税区分_世帯;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;
    private RString 生活保護扶助種類;
    private RString 生保開始日;
    private RString 生保開始日_西暦;
    private RString 生保廃止日;
    private RString 生保廃止日_西暦;
    private RString 老齢開始日;
    private RString 老齢開始日_西暦;
    private RString 老齢廃止日;
    private RString 老齢廃止日_西暦;
    private List<CharacteristicsPhase> 特徴期別金額リスト;
    private Decimal 特別徴収額合計;
    private List<UniversalPhase> 普徴期別金額リスト;
    private Decimal 普通徴収額合計;
    private RString 特別徴収義務者;
    private RString 特別徴収義務者コード;
    private RString 特別徴収対象年金;
    private RString 特別徴収対象年金コード;
    private KozaKubun 口座区分;
    private RString 徴収方法;

}
