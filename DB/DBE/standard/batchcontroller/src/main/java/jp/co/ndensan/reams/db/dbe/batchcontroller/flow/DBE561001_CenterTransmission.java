/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.CenterTransmissionProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.ChosaItemTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.SoshinDataSakuseiTaishoshaChushutsuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.IkenItemTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.ServiceJokyoTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.UpdateGaibuRenkeiDataoutputJohoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.UpdateNinteiShinseiJohoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.ZenkaiChosaItemTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.ZenkaiServiceJokyoTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE561001.DBE561001_CenterTransmissionParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.SoshinDataSakuseiTaishoshaTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.batch.flow.value.NewTempTableCreateOption;
import jp.co.ndensan.reams.uz.uza.batch.flow.value.PKColumn;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ作成のバッチ定義クラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class DBE561001_CenterTransmission extends BatchFlowBase<DBE561001_CenterTransmissionParameter> {

    private static final String 送信データ作成対象者一覧一時テーブル = "SoshinDataSakuseiTaishoshaTempTableSakusei";
    private static final String 送信データ作成対象者抽出 = "SoshinDataSakuseiTaishoshaChushutsu";
    private static final String 調査票概況調査サービスの状況一時テーブル = "NinteichosahyoServiceJokyoTempTableSakusei";
    private static final String 前回調査票概況調査サービスの状況一時テーブル = "ZenkaiNinteichosahyoServiceJokyoTempTableSakusei";
    private static final String 要介護認定主治医意見書意見項目一時テーブル = "ShujiiIkenshoIkenItemTempTableSakusei";
    private static final String 認定調査票基本調査調査項目一時テーブル = "NinteichosahyoChosaItemTempTableSakusei";
    private static final String 前回調査票基本調査調査項目一時テーブル = "ZenkaiNinteichosahyoChosaItemTempTableSakusei";
    private static final String センター送信データ作成ファイル出力 = "CenterTransmissionProcessFileSyuturyoku";
    private static final String DB出力要介護認定申請情報 = "UpdateDbT5101NinteiShinseiJoho";
    private static final String DB出力外部連携データ抽出情報 = "UpdateDbT7211GaibuRenkeiDataoutputJoho";
    private List<RString> 出力された申請書管理番号;

    @Override
    protected void defineFlow() {
        executeStep(送信データ作成対象者一覧一時テーブル);
        executeStep(送信データ作成対象者抽出);
        executeStep(調査票概況調査サービスの状況一時テーブル);
        executeStep(前回調査票概況調査サービスの状況一時テーブル);
        executeStep(要介護認定主治医意見書意見項目一時テーブル);
        executeStep(認定調査票基本調査調査項目一時テーブル);
        executeStep(前回調査票基本調査調査項目一時テーブル);
        executeStep(センター送信データ作成ファイル出力);
        出力された申請書管理番号 = getResult(List.class, new RString(センター送信データ作成ファイル出力),
                CenterTransmissionProcess.OUTPUTSHINSEISHOKANRINO);
        if (!出力された申請書管理番号.isEmpty()) {
            executeStep(DB出力要介護認定申請情報);
            executeStep(DB出力外部連携データ抽出情報);
        }
    }

    @Step(送信データ作成対象者一覧一時テーブル)
    IBatchFlowCommand createSoshinDataSakuseiTaishoshaTempTable() {
        PKColumn primaryKey = new PKColumn(PrimaryKey.Name, PrimaryKey.Column);
        NewTempTableCreateOption option = new NewTempTableCreateOption().primaryKey(primaryKey);
        return createTempTable(SoshinDataSakuseiTaishoshaTempEntity.TABLE_NAME, SoshinDataSakuseiTaishoshaTempEntity.class, option).define();
    }

    /**
     * 画面で指定された条件に該当する対象者を抽出します。
     *
     * @return バッチコマンド
     */
    @Step(送信データ作成対象者抽出)
    IBatchFlowCommand insertSoshinDataSakuseiTaishoshaTempTable() {
        return loopBatch(SoshinDataSakuseiTaishoshaChushutsuProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 調査票概況調査サービスの状況一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(調査票概況調査サービスの状況一時テーブル)
    IBatchFlowCommand createServiceJokyoTempTable() {
        return loopBatch(ServiceJokyoTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 前回調査票概況調査サービスの状況一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(前回調査票概況調査サービスの状況一時テーブル)
    IBatchFlowCommand createZenkaiServiceJokyoTempTable() {
        return loopBatch(ZenkaiServiceJokyoTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 要介護認定主治医意見書意見項目一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(要介護認定主治医意見書意見項目一時テーブル)
    IBatchFlowCommand createShujiiIkenshoIkenItemTempTable() {
        return loopBatch(IkenItemTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 認定調査票（基本調査）調査項目一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(認定調査票基本調査調査項目一時テーブル)
    IBatchFlowCommand createNinteichosahyoChosaItemTempTable() {
        return loopBatch(ChosaItemTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 前回認定調査票（基本調査）調査項目一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(前回調査票基本調査調査項目一時テーブル)
    IBatchFlowCommand createZenkaiNinteichosahyoChosaItemTempTable() {
        return loopBatch(ZenkaiChosaItemTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * センター送信データ作成ファイルを出力します。
     *
     * @return バッチコマンド
     */
    @Step(センター送信データ作成ファイル出力)
    IBatchFlowCommand createCenterTransmission() {
        return loopBatch(CenterTransmissionProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 要介護認定申請情報をUPDATEします。
     *
     * @return バッチコマンド
     */
    @Step(DB出力要介護認定申請情報)
    IBatchFlowCommand updateNinteiShinseiJoho() {
        return loopBatch(UpdateNinteiShinseiJohoProcess.class)
                .arguments(new CenterTransmissionUpdateProcessParameter(出力された申請書管理番号)).define();
    }

    /**
     * 外部連携データ抽出情報をUPDATEします。
     *
     * @return バッチコマンド
     */
    @Step(DB出力外部連携データ抽出情報)
    IBatchFlowCommand updateGaibuRenkeiDataoutputJoho() {
        return loopBatch(UpdateGaibuRenkeiDataoutputJohoProcess.class)
                .arguments(new CenterTransmissionUpdateProcessParameter(出力された申請書管理番号)).define();
    }

    private static class PrimaryKey {

        static final String Name = "SoshinDataSakuseiTaishoshaTemp_pkey";
        static final String Column = "shinseishoKanriNo";
    }
}
