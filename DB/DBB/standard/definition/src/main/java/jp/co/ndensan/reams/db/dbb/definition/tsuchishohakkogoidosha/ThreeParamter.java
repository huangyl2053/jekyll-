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
@Getter
public class ThreeParamter {

    private final ReportId 帳票ID;
    private final YMDHMS 帳票作成日時;

    /**
     * ThreeParamter
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    ThreeParamter(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * ThreeParamter
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @return ThreeParamter
     */
    public static ThreeParamter createSelectByKeyParam(ReportId 帳票ID, YMDHMS 帳票作成日時) {
        return new ThreeParamter(帳票ID, 帳票作成日時);
    }
}
