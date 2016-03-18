/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import lombok.Getter;

/**
 * 異動者情報
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class IdoshaParamter {

    private final ReportId 帳票ID;
    private final YMDHMS 帳票作成日時;

    /**
     * ThreeParamter
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    private IdoshaParamter(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * IdoshaParamter
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @return IdoshaParamter
     */
    public static IdoshaParamter createSelectByKeyParam(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        return new IdoshaParamter(帳票ID, 帳票作成日時);
    }
}
