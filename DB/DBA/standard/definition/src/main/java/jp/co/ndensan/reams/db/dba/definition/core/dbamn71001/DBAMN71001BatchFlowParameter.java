/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.dbamn71001;

import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 65歳年齢到達資格異動バッチパラメータクラスです。
 */
public class DBAMN71001BatchFlowParameter extends BatchParameterBase {

    /**
     *
     * 65歳年齢到達資格異動バッチパラメータクラスです。
     */
    private final FlexibleDate kaishiYMD;
    private final FlexibleDate shuryoYMD;

    /**
     * 65歳年齢到達資格異動バッチパラメータです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     */
    private DBAMN71001BatchFlowParameter(
            FlexibleDate kaishiYMD,
            FlexibleDate shuryoYMD
    ) {
        this.kaishiYMD = kaishiYMD;
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * 65歳年齢到達資格異動バッチのパラメータです。
     *
     * @param kaishiYMD 開始日
     * @param shuryoYMD 終了日
     * @return
     */
    public static DBAMN71001BatchFlowParameter createRoreiFukushiParam(
            FlexibleDate kaishiYMD,
            FlexibleDate shuryoYMD) {
        return new DBAMN71001BatchFlowParameter(
                kaishiYMD,
                shuryoYMD);
    }

    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    public FlexibleDate getShuryoYMD() {
        return shuryoYMD;
    }
}
