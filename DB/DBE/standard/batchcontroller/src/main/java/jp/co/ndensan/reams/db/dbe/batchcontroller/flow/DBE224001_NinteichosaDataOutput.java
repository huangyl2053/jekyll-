/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.DbT5207GetProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.DbT5208GetProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.DbT5209GetProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.DbT5210GetProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.DbT5211GetProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.DbT5301UpdateProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.NinteiChosaDataOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.NinteiChosaGaikyoTokkiDataOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.NinteiChosaMainDataGetProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.NinteiChosaTokkiDataOutputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput.NinteiChosainDataOutputProcess;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseirirekijoho.ShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE224001.DBE224001_NinteichosaDataOutputParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosadataoutput.DbT5121MybitisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosadataoutput.NinteiChosaDataOutputFinder;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査データ出力（モバイル）バッチフロークラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
public class DBE224001_NinteichosaDataOutput extends BatchFlowBase<DBE224001_NinteichosaDataOutputParameter> {

    private static final RString 認定調査CSV一時テーブル名 = new RString("DbT9999CSV");
    private static final RString 認定調査CSV一時テーブル名_前回分 = new RString("DbT9999CSV_Zenkai");
    private static final String NINTEICHOSAMAINDATAGET = "ninteichosamaindataget";
    private static final String NINTEICHOSADBT5207DATAGET = "ninteichosadbt5207dataget";
    private static final String NINTEICHOSADBT5208DATAGET = "ninteichosadbt5208dataget";
    private static final String NINTEICHOSADBT5209DATAGET = "ninteichosadbt5209dataget";
    private static final String NINTEICHOSADBT5210DATAGET = "ninteichosadbt5210dataget";
    private static final String NINTEICHOSADBT5211DATAGET = "ninteichosadbt5211dataget";
    private static final String NINTEICHOSADATAOUTPUT = "ninteichosadataoutput";
    private static final String NINTEICHOSATOKKIDATAOUTPUT = "ninteichosatokkidataoutput";
    private static final String NINTEICHOSAGAIKYOTOKKIOUTPUT = "ninteichosagaikyotokkioutput";
    private static final String NINTEICHOSAINDATAOUTPUT = "ninteichosaindataoutput";
    private static final String DBUPDATEPROCESS = "dbT5301UpdateProcess";
    private RString ninteiChosaCsvTempTableName;
    private List<RString> shinseishoKanriNoList;

    @Override
    protected void defineFlow() {

        //前回分を一時テーブルへ保存
        ninteiChosaCsvTempTableName = 認定調査CSV一時テーブル名_前回分;
        shinseishoKanriNoList = get前回申請管理番号List();
        executeStep(NINTEICHOSAMAINDATAGET);
        executeStep(NINTEICHOSADBT5207DATAGET);
        executeStep(NINTEICHOSADBT5208DATAGET);
        executeStep(NINTEICHOSADBT5209DATAGET);
        executeStep(NINTEICHOSADBT5210DATAGET);
        executeStep(NINTEICHOSADBT5211DATAGET);
        //今回分を一時テーブルへ保存
        ninteiChosaCsvTempTableName = 認定調査CSV一時テーブル名;
        shinseishoKanriNoList = null;
        executeStep(NINTEICHOSAMAINDATAGET);
        executeStep(NINTEICHOSADBT5207DATAGET);
        executeStep(NINTEICHOSADBT5208DATAGET);
        executeStep(NINTEICHOSADBT5209DATAGET);
        executeStep(NINTEICHOSADBT5210DATAGET);
        executeStep(NINTEICHOSADBT5211DATAGET);
        //各CSV出力
        executeStep(NINTEICHOSADATAOUTPUT);
        executeStep(NINTEICHOSATOKKIDATAOUTPUT);
        executeStep(NINTEICHOSAGAIKYOTOKKIOUTPUT);
        executeStep(NINTEICHOSAINDATAOUTPUT);
        //DB更新
        executeStep(DBUPDATEPROCESS);
    }

    private List<RString> get前回申請管理番号List() {
        DbT5121MybitisParameter param = DbT5121MybitisParameter.createParam(getParameter().getShinseishoKanriNoList());
        List<ShinseiRirekiJoho> shinseiRirekiJohoList = NinteiChosaDataOutputFinder.createInstance().get前回申請管理番号List(param);
        List<RString> zenkaiShinseishoKanriNoList = new ArrayList<>();
        for (ShinseiRirekiJoho shinseiRirekiJoho : shinseiRirekiJohoList) {
            zenkaiShinseishoKanriNoList.add(shinseiRirekiJoho.get前回申請管理番号().getColumnValue());
        }
        return zenkaiShinseishoKanriNoList;
    }

    private NinteiChosaDataOutputProcessParamter getProcessParameter(RString csvTempTableName, List<RString> zenkaiShinseishoKanriNoList) {
        if (zenkaiShinseishoKanriNoList == null) {
            return getParameter().toNinteiChosaDataOutputProcessParamter(csvTempTableName);
        } else {
            return getParameter().toNinteiChosaDataOutputProcessParamter(csvTempTableName, zenkaiShinseishoKanriNoList);
        }
    }

    /**
     * 認定調査依頼情報のメインデータを一時テーブルに保存するProcessです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSAMAINDATAGET)
    protected IBatchFlowCommand callMainDataGetProcess() {
        return loopBatch(NinteiChosaMainDataGetProcess.class)
                .arguments(getProcessParameter(ninteiChosaCsvTempTableName, shinseishoKanriNoList)).define();
    }

    /**
     * DbT5207のデータを一時テーブルに保存するProcessです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSADBT5207DATAGET)
    protected IBatchFlowCommand callDbT5207DataGetProcess() {
        return loopBatch(DbT5207GetProcess.class)
                .arguments(getProcessParameter(ninteiChosaCsvTempTableName, shinseishoKanriNoList)).define();
    }

    /**
     * DbT5208のデータを一時テーブルに保存するProcessです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSADBT5208DATAGET)
    protected IBatchFlowCommand callDbT5208DataGetProcess() {
        return loopBatch(DbT5208GetProcess.class)
                .arguments(getParameter().toNinteiChosaDataOutputProcessParamter(ninteiChosaCsvTempTableName)).define();
    }

    /**
     * DbT5209のデータを一時テーブルに保存するProcessです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSADBT5209DATAGET)
    protected IBatchFlowCommand callDbT5209DataGetProcess() {
        return loopBatch(DbT5209GetProcess.class)
                .arguments(getProcessParameter(ninteiChosaCsvTempTableName, shinseishoKanriNoList)).define();
    }

    /**
     * DbT5210のデータを一時テーブルに保存するProcessです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSADBT5210DATAGET)
    protected IBatchFlowCommand callDbT5210DataGetProcess() {
        return loopBatch(DbT5210GetProcess.class)
                .arguments(getProcessParameter(ninteiChosaCsvTempTableName, shinseishoKanriNoList)).define();
    }

    /**
     * DbT5211のデータを一時テーブルに保存するProcessです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSADBT5211DATAGET)
    protected IBatchFlowCommand callDbT5211DataGetProcess() {
        return loopBatch(DbT5211GetProcess.class)
                .arguments(getProcessParameter(ninteiChosaCsvTempTableName, shinseishoKanriNoList)).define();
    }

    /**
     * 認定調査データ出力（モバイル）のCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSADATAOUTPUT)
    protected IBatchFlowCommand callNinteiChosaDataOutput() {
        return loopBatch(NinteiChosaDataOutputProcess.class)
                .arguments(getParameter().toNinteiChosaDataCsvProcessParamter(
                                認定調査CSV一時テーブル名, 認定調査CSV一時テーブル名_前回分)).define();
    }

    /**
     * 認定調査データ出力（モバイル）の特記事項データCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSATOKKIDATAOUTPUT)
    protected IBatchFlowCommand callNinteiChosaTokkiDataOutput() {
        return loopBatch(NinteiChosaTokkiDataOutputProcess.class)
                .arguments(getParameter().toNinteiChosaDataOutputProcessParamter(認定調査CSV一時テーブル名)).define();
    }

    /**
     * 認定調査データ出力（モバイル）の概況特記事項データCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSAGAIKYOTOKKIOUTPUT)
    protected IBatchFlowCommand callNinteiChosaGaikyoTokkiDataOutput() {
        return loopBatch(NinteiChosaGaikyoTokkiDataOutputProcess.class)
                .arguments(getParameter().toNinteiChosaDataOutputProcessParamter(認定調査CSV一時テーブル名)).define();
    }

    /**
     * 認定調査データ出力（モバイル）の調査員データCSV出力Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(NINTEICHOSAINDATAOUTPUT)
    protected IBatchFlowCommand callNinteiChosainDataOutput() {
        return loopBatch(NinteiChosainDataOutputProcess.class)
                .arguments(getParameter().toNinteiChosaDataOutputProcessParamter(認定調査CSV一時テーブル名)).define();
    }

    /**
     * 認定調査データ出力（モバイル）のDB更新Processです。
     *
     * @return 認定調査データ出力（モバイル）
     */
    @Step(DBUPDATEPROCESS)
    protected IBatchFlowCommand callDbT5301UpdateProcess() {
        return loopBatch(DbT5301UpdateProcess.class)
                .arguments(getProcessParameter(ninteiChosaCsvTempTableName, shinseishoKanriNoList)).define();
    }
}
