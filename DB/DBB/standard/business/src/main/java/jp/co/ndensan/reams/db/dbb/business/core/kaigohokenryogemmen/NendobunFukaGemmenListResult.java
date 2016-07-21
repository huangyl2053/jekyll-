/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.kaigohokenryogemmen;

import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.NendobunFukaGemmenList;

/**
 * 介護保険料減免
 *
 * @reamsid_L DBB-1660-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendobunFukaGemmenListResult {

    private NendobunFukaGemmenList 年度分賦課減免リスト;
    private ChoshuHoho 介護徴収方法;
}
