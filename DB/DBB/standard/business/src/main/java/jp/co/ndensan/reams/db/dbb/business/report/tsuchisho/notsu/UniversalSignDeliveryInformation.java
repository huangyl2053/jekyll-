/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.db.dbb.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 編集後仮算定通知書共通情報の普徴納期情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UniversalSignDeliveryInformation {

    private Kitsuki 期月;
    private RString 随時;
    private RString 納期開始日;
    private RString 納期終了日;
    private RString 納期限;
    private RString 現年過年区分;
    private RDate 通知書発行日;

}
