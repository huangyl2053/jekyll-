/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険料納入通知書（本算定）【期毎タイプ】 雛形部品
 *
 * @reamsid_L DBB-9110-160 liangbc
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinshoshaSource {

    private RString 電子公印;
    private RString 発効年月日;
    private RString 承認者役職名;
    private RString 承認者役職名1;
    private RString 公印文字列;
    private RString 承認者役職名2;
    private RString 承認者氏名掛ける;
    private RString 承認者氏名掛けない;
    private RString 公印書略;

}
