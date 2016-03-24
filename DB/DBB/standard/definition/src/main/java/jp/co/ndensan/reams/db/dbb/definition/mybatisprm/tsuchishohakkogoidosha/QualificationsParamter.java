/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tsuchishohakkogoidosha;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import lombok.Getter;

/**
 * QualificationsParamter
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class QualificationsParamter {

    private final ReportId 帳票ID;
    private final YMDHMS 帳票作成日時;
    private final RDateTime 最大計算処理日時;
    private final RDateTime システム日時;

    /**
     * TwoParamter
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @param 最大計算処理日時 最大計算処理日時
     */
    private QualificationsParamter(ReportId 帳票ID, YMDHMS 帳票作成日時, YMDHMS 最大計算処理日時) {
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
        this.最大計算処理日時 = 最大計算処理日時.getRDateTime();
        this.システム日時 = RDateTime.now();
    }

    /**
     * createSelectByKeyParam
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @param 最大計算処理日時 最大計算処理日時
     * @return QualificationsParamter
     */
    public static QualificationsParamter createSelectByKeyParam(ReportId 帳票ID, YMDHMS 帳票作成日時,
            YMDHMS 最大計算処理日時) {
        return new QualificationsParamter(帳票ID, 帳票作成日時, 最大計算処理日時);
    }

}
