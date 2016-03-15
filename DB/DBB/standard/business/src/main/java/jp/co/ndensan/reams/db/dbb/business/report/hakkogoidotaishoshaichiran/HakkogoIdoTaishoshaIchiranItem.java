/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hakkogoidotaishoshaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 通知書発行後異動把握帳票HakkogoIdoTaishoshaIchiranItem
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HakkogoIdoTaishoshaIchiranItem {

    private RString hokenshaNo;
    private RString hokenshaName;
    private RString tsuchishoName;
    private RString printTimeStamp;
    private RString fukaNendo;
    private RString tsuchishoHakkoTimeStamp;
    private RString lastCalculationTimeStamp;
    private RString listIdosha_1;
    private RString listIdosha_2;
    private RString listIdosha_3;
    private RString listIdosha_4;
    private RString listIdosha_5;
    private RString listIdosha_6;
    private RString listIdosha_7;
    private RString title;
}
