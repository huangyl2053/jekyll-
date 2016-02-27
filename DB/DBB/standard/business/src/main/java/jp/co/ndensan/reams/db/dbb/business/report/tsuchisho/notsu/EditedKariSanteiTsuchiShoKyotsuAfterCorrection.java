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
import org.dom4j.Text;

/**
 *
 * 編集後仮算定通知書共通情報の更正後情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class EditedKariSanteiTsuchiShoKyotsuAfterCorrection {

    private Decimal 更正後介護保険料仮徴収額合計;
    private Decimal 更正後介護保険料減免額;
    private Decimal 更正後特徴期別金額01;
    private Decimal 更正後特徴期別金額02;
    private Decimal 更正後特徴期別金額03;
    private Decimal 更正後特徴期別金額合計;
    private List<UniversalPhase> 更正後普徴期別金額リスト;
    private Decimal 更正後普徴第１期金額;
    private Decimal 更正後普徴第２期金額;
    private Decimal 更正後普徴期別金額合計;
    private RString 更正後資格取得日;
    private RString 更正後資格取得日_西暦;
    private RString 更正後資格喪失日;
    private RString 更正後資格喪失日_西暦;
    private RString 期間_自;
    private RString 期間_自_西暦;
    private RString 期間_至;
    private RString 期間_至_西暦;
    private RString 保険料段階;
    private RString 保険料率;
    private RString 更正後特別徴収義務者;
    private RString 更正後特別徴収対象年金;
    private RString 更正後特別徴収義務者コード;
    private RString 更正後特別徴収対象年金コード;
    private KozaKubun 更正後口座区分;
    private RString 生保開始日;
    private RString 生保開始日_西暦;
    private RString 生活保護扶助種類;
    private Text 更正後徴収方法;

}
