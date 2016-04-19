/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴納期情報Entity。
 *
 * @reamsid_L DBB-0820-050 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class 普徴納期情報Entity {

    private RString 期月;
    private RString 随時;
    private RString 納期開始日;
    private RString 納期終了日;
    private RString 納期限;
    private RString 現年過年区分;
    private RString 通知書発行日;

}
