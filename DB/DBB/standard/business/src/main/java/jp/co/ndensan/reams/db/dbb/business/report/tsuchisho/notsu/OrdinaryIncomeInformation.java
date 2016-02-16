/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 編集後仮算定通知書共通情報の普徴収入情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OrdinaryIncomeInformation {

    private Kitsuki 期月;
    private Decimal 収入額;

}
