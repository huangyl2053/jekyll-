/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170020.KaigoSabisuNaiyoCSVSakusei;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170020.KaigoSabisuNaiyoMasterKoshin;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC170020.TorikomiDataIchijiSakusei;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC170020.DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.io.Path;

/**
 * バッチ処理「給付費単位数表標準マスタ取込」のフローです。
 *
 * @reamsid_L DBC-3400-030 xuyue
 */
public class DBC170020_KyufuhiTanisuhyoHyojunMasterIn extends BatchFlowBase<DBC170020_KyufuhiTanisuhyoHyojunMasterInParameter> {

    private static final String データのバックアップ = "backupKaigoServiceNaiyou";
    private static final String 取込データ一時作成 = "TorikomiDataIchijiSakusei";
    private static final String 介護サービス内容取込結果CSV作成 = "KaigoSabisuNaiyoCSVSakusei";
    private static final String 介護サービス内容マスタ更新 = "KaigoSabisuNaiyoMasterKoshin";

    @Override
    protected void defineFlow() {
        executeStep(データのバックアップ);
        executeStep(取込データ一時作成);
        executeStep(介護サービス内容取込結果CSV作成);
        executeStep(介護サービス内容マスタ更新);
    }

    /**
     * データのバックアップを行います。
     *
     * @return IBatchFlowCommand
     */
    @Step(データのバックアップ)
    IBatchFlowCommand backupKaigoServiceNaiyou() {
        return backupToFile(DbT7131KaigoServiceNaiyouEntity.TABLE_NAME, Path.combinePath(Path.getTmpDirectoryPath())).
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

    /**
     * 介護サービス内容取込結果CSV作成します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護サービス内容取込結果CSV作成)
    protected IBatchFlowCommand calKaigoSabisuNaiyoCSVSakusei() {
        return loopBatch(KaigoSabisuNaiyoCSVSakusei.class).define();
    }

    /**
     * 介護サービス内容更新します。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護サービス内容マスタ更新)
    protected IBatchFlowCommand calKaigoSabisuNaiyoMasterKoshin() {
        return loopBatch(KaigoSabisuNaiyoMasterKoshin.class).define();
    }
}
