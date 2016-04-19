/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 特徴収入情報です。
 *
 * @reamsid_L DBB-9020-160 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SpecialIncomeInformation {

    private Kitsuki 期月;
    private Decimal 収入額;

}
