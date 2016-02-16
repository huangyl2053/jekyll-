/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 編集後仮算定通知書共通情報の前年度情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PrecedingFiscalYearInformation {

    private RString 前年度賦課年度;
    private RString 前年度保険料段階;
    private Decimal 前年度保険料率;
    private Decimal 前年度減免前介護保険料_年額;
    private Decimal 前年度確定介護保険料_年額;
    private Decimal 前年度特徴期別金額01;
    private Decimal 前年度特徴期別金額02;
    private Decimal 前年度特徴期別金額03;
    private Decimal 前年度特徴期別金額04;
    private Decimal 前年度特徴期別金額05;
    private Decimal 前年度最終期特徴期別介護保険料;
    private Decimal 前年度最終期普徴期別介護保険料;

}
