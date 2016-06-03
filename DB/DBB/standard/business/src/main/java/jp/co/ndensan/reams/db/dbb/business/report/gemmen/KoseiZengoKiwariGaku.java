/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gemmen;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 更正前後期割額 更正前後の期割額を格納クラスです。
 *
 * @reamsid_L DBB-0740-030 surun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoseiZengoKiwariGaku {

    private RString 特徴期;
    private RString 特徴月;
    private RString 特徴期別金額更正前;
    private RString 特徴期別金額更正後;
    private RString 普徴期;
    private RString 普徴月;
    private RString 普徴期別金額更正前;
    private RString 普徴期別金額更正後;
}
