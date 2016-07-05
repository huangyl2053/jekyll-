/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.ninteichosahoshushokai;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 認定調査報酬照会のbatch用Businessクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaHoshuGoKeFlowBusiness {

    private int 在宅初回;
    private int 在宅再調査;
    private int 施設初回;
    private int 施設再調査;
    private int 委託料合計;
    private FlexibleDate 調査依頼日開始;
    private FlexibleDate 調査依頼日終了;

}
