/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.zenkaifuka;

import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.ShunyuJoho;

/**
 * 前年度賦課情報のクラスです。
 *
 * @reamsid_L DBB-9020-160 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ZenkaiFuka {

    private Fuka 賦課情報;
    private ShunyuJoho 収入情報;
}
