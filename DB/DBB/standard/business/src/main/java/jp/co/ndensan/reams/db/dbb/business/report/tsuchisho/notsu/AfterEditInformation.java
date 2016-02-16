/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urc.definition.core.noki.nokikanri.GennenKanen;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 編集後納期情報です。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class AfterEditInformation {

    private RString 期;
    private RString 月;
    private RString 随時;
    private RString 納期開始日;
    private RString 納期開始日_西暦;
    private RString 納期終了日;
    private RString 納期終了日_西暦;
    private RString 納期限;
    private RString 納期限_西暦;
    private GennenKanen 現年過年区分;
    private RString 通知書発行日;
    private RString 通知書発行日_西暦;

}
