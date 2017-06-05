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
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.UpdateNinteiKanryoJohoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.UpdateNinteiShinseiJohoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.ZenkaiChosaItemTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001.ZenkaiServiceJokyoTempTableSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.datarenkei.UpdateGaibuRenkeiDataoutputJohoProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE561001.DBE561001_CenterTransmissionParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.datarenkei.UpdateGaibuRenkeiDataoutputJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.datarenkei.UpdateGaibuRenkeiDataoutputJohoProcessParameter.RenkeiDataType;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.SoshinDataSakuseiTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.batch.flow.value.NewTempTableCreateOption;
import jp.co.ndensan.reams.uz.uza.batch.flow.value.PKColumn;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ作成のバッチ定義クラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class DBE561001_CenterTransmission extends BatchFlowBase<DBE561001_CenterTransmissionParameter> {

    private static final String STEP01_送信データ作成対象者一覧一時テーブル = "SoshinDataSakuseiTaishoshaTempTableSakusei";
    private static final String STEP02_送信データ作成対象者抽出 = "SoshinDataSakuseiTaishoshaChushutsu";
    private static final String STEP03_調査票概況調査サービスの状況一時テーブル = "NinteichosahyoServiceJokyoTempTableSakusei";
    private static final String STEP04_前回調査票概況調査サービスの状況一時テーブル = "ZenkaiNinteichosahyoServiceJokyoTempTableSakusei";
    private static final String STEP05_要介護認定主治医意見書意見項目一時テーブル = "ShujiiIkenshoIkenItemTempTableSakusei";
    private static final String STEP06_認定調査票基本調査調査項目一時テーブル = "NinteichosahyoChosaItemTempTableSakusei";
    private static final String STEP07_前回調査票基本調査調査項目一時テーブル = "ZenkaiNinteichosahyoChosaItemTempTableSakusei";
    private static final String STEP08_センター送信データ作成ファイル出力 = "CenterTransmissionProcessFileSyuturyoku";
    private static final String STEP09_DB出力要介護認定申請情報 = "UpdateDbT5101NinteiShinseiJoho";
    private static final String STEP10_DB出力外部連携データ抽出情報 = "UpdateDbT7211GaibuRenkeiDataoutputJoho";
    private static final String STEP11_DB出力要介護認定完了情報 = "UpdateDbT5105NinteiKanryoJoho";
    private static final RString バッチ実行時 = new RString("1");
    private List<RString> 出力された申請書管理番号;

    @Override
    protected void defineFlow() {
        executeStep(STEP01_送信データ作成対象者一覧一時テーブル);
        executeStep(STEP02_送信データ作成対象者抽出);
        executeStep(STEP03_調査票概況調査サービスの状況一時テーブル);
        executeStep(STEP04_前回調査票概況調査サービスの状況一時テーブル);
        executeStep(STEP05_要介護認定主治医意見書意見項目一時テーブル);
        executeStep(STEP06_認定調査票基本調査調査項目一時テーブル);
        executeStep(STEP07_前回調査票基本調査調査項目一時テーブル);
        executeStep(STEP08_センター送信データ作成ファイル出力);
        出力された申請書管理番号 = getResult(List.class, new RString(STEP08_センター送信データ作成ファイル出力),
                CenterTransmissionProcess.OUTPUTSHINSEISHOKANRINO);
        if (!出力された申請書管理番号.isEmpty()) {
            executeStep(STEP09_DB出力要介護認定申請情報);
            executeStep(STEP10_DB出力外部連携データ抽出情報);
            RString 登録方法 = DbBusinessConfig.get(ConfigNameDBE.センター送信_完了日登録方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            if (バッチ実行時.equals(登録方法)) {
                executeStep(STEP11_DB出力要介護認定完了情報);
            }
        }
    }

    @Step(STEP01_送信データ作成対象者一覧一時テーブル)
    IBatchFlowCommand createSoshinDataSakuseiTaishoshaTempTable() {
        PKColumn primaryKey = new PKColumn(PrimaryKey.Name, PrimaryKey.Column);
        NewTempTableCreateOption option = new NewTempTableCreateOption().primaryKey(primaryKey);
        return createTempTable(SoshinDataSakuseiTaishoshaTempEntity.TABLE_NAME, SoshinDataSakuseiTaishoshaTempEntity.class, option).define();
    }

    /**
     * 画面で指定された条件に該当する対象者を抽出します。
     *
     * 抽出した対象者をSTEP1で作成した SoshinDataSakuseiTaishoshaTemp へ更新します。
     *
     * @return バッチコマンド
     */
    @Step(STEP02_送信データ作成対象者抽出)
    IBatchFlowCommand insertSoshinDataSakuseiTaishoshaTempTable() {
        return loopBatch(SoshinDataSakuseiTaishoshaChushutsuProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 調査票概況調査サービスの状況一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP03_調査票概況調査サービスの状況一時テーブル)
    IBatchFlowCommand createServiceJokyoTempTable() {
        return loopBatch(ServiceJokyoTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 前回調査票概況調査サービスの状況一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP04_前回調査票概況調査サービスの状況一時テーブル)
    IBatchFlowCommand createZenkaiServiceJokyoTempTable() {
        return loopBatch(ZenkaiServiceJokyoTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 要介護認定主治医意見書意見項目一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP05_要介護認定主治医意見書意見項目一時テーブル)
    IBatchFlowCommand createShujiiIkenshoIkenItemTempTable() {
        return loopBatch(IkenItemTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 認定調査票（基本調査）調査項目一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP06_認定調査票基本調査調査項目一時テーブル)
    IBatchFlowCommand createNinteichosahyoChosaItemTempTable() {
        return loopBatch(ChosaItemTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 前回認定調査票（基本調査）調査項目一時テーブルをCREATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP07_前回調査票基本調査調査項目一時テーブル)
    IBatchFlowCommand createZenkaiNinteichosahyoChosaItemTempTable() {
        return loopBatch(ZenkaiChosaItemTempTableSakuseiProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * センター送信データ作成ファイルを出力します。
     *
     * @return バッチコマンド
     */
    @Step(STEP08_センター送信データ作成ファイル出力)
    IBatchFlowCommand createCenterTransmission() {
        return loopBatch(CenterTransmissionProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    /**
     * 要介護認定申請情報をUPDATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP09_DB出力要介護認定申請情報)
    IBatchFlowCommand updateNinteiShinseiJoho() {
        return loopBatch(UpdateNinteiShinseiJohoProcess.class)
                .arguments(new CenterTransmissionUpdateProcessParameter(出力された申請書管理番号)).define();
    }

    /**
     * 外部連携データ抽出情報をUPDATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP10_DB出力外部連携データ抽出情報)
    IBatchFlowCommand updateGaibuRenkeiDataoutputJoho() {
        return loopBatch(UpdateGaibuRenkeiDataoutputJohoProcess.class)
                .arguments(new UpdateGaibuRenkeiDataoutputJohoProcessParameter(
                                出力された申請書管理番号,
                                RenkeiDataType.センター送信,
                                FlexibleDate.getNowDate()
                        ))
                .define();
    }

    /**
     * 要介護認定完了情報をUPDATEします。
     *
     * @return バッチコマンド
     */
    @Step(STEP11_DB出力要介護認定完了情報)
    IBatchFlowCommand updateNinteiKanryoJoho() {
        return loopBatch(UpdateNinteiKanryoJohoProcess.class)
                .arguments(getParameter().toCenterTransmissionProcessParameter()).define();
    }

    private static class PrimaryKey {

        static final String Name = "SoshinDataSakuseiTaishoshaTemp_pkey";
        static final String Column = "shinseishoKanriNo";
    }
}
