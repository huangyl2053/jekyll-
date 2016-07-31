/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigohokenrenrakuhyo;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居住費負担限度額記載Entityクラスです。
 *
 * @reamsid_L DBA-1290-070 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyojuhiFutanGendogakuKisai {

    private boolean is居住費の記載あり;
    private Decimal 対象者ユニット型個室金額;
    private Decimal 対象者ユニット型準個室金額;
    private Decimal 対象者従来型特養金額;
    private Decimal 対象者従来型老健療養型金額;
    private Decimal 対象者多床室金額;

}
