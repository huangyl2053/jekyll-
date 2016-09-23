/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170020.TorikomiDataIchijiSakusei;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170020.DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * バッチ処理「給付費単位数表標準マスタ取込」のフローです。
 *
 * @reamsid_L DBC-3400-030 xuyue
 */
public class DBC170020_KyufuhiTanisuhyoHyojunMasterIn extends BatchFlowBase<DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter> {

    private static final String データのバックアップ = "backupKaigoServiceNaiyou";
    private static final String 取込データ一時作成 = "backupKaigoServiceNaiyou";

    @Override
    protected void defineFlow() {
        executeStep(データのバックアップ);
        executeStep(取込データ一時作成);
    }

    /**
     * データのバックアップを行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(データのバックアップ)
    IBatchFlowCommand backupKaigoServiceNaiyou() {
        return backupToFile(DbT7131KaigoServiceNaiyouEntity.TABLE_NAME).
                define();
    }

    /**
     * 取込データ一時テーブルを作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(取込データ一時作成)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        return loopBatch(TorikomiDataIchijiSakusei.class).define();
    }

}
