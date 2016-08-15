/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.NendoKirikae;

import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 年度切替バッチのパラメッタ
 *
 * @reamsid_L DBB_9010_002 zhengshenlei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendoKirikaeParameter {

    private RDate 調定年度;
}
