/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001.InsNinteiGaibuDataOutputHistoryProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001.MakeNinteiShinseiJohoFileKourouProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001.MakeNinteiShinseiJohoFileProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001.ModifyNinteiShinseiJohoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001.NinteiShinseiJohoProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD519001.PntNinteiShinsaHanteiListProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519001.DBD519001_NinteishinseiInfoIfParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.InsNinteiGaibuDataOutputHistoryProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.MakeNinteiShinseiJohoFileProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.ModifyNinteiShinseiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.NinteiShinseiJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd519001.PntNinteiShinsaHanteiListProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請情報IF作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-1480-020 liuyl
 */
public class DBD519001_NinteishinseiInfoIf extends BatchFlowBase<DBD519001_NinteishinseiInfoIfParameter> {

    private static final String 申請情報抽出 = "申請情報抽出";
    private static final String 申請情報IF編集 = "申請情報IF編集";
    private static final String 認定審査判定依頼一覧表発行 = "認定審査判定依頼一覧表発行";
    private static final String 要介護認定外部データ出力 = "要介護認定外部データ出力";
    private static final String 申請情報IFファイル電算標準版作成 = "申請情報IFファイル電算標準版作成";
    private static final String 各テーブルへの登録 = "各テーブルへの登録";
    private static final String 申請情報IFファイル厚労省作成 = "申請情報IFファイル厚労省作成";
    private RString 認定申請IF種類;
    private YMDHMS 開始日時;

    @Override
    protected void initialize() {
        認定申請IF種類 = DbBusinessConfig.get(ConfigNameDBE.認定申請IF種類, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        開始日時 = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {
        executeStep(申請情報抽出);
        if (認定申請IF種類.equals(new RString("3")) || 認定申請IF種類.equals(new RString("4")) || 認定申請IF種類.equals(new RString("5"))) {
            executeStep(申請情報IF編集);
        }
        executeStep(認定審査判定依頼一覧表発行);
        if (getResult(RString.class, new RString(申請情報IF編集), ModifyNinteiShinseiJohoProcess.OUT編集状況フラグ).equals(new RString("0"))) {
            if (認定申請IF種類.equals(new RString("3")) || 認定申請IF種類.equals(new RString("5"))) {
                executeStep(申請情報IFファイル電算標準版作成);
            } else {
                executeStep(申請情報IFファイル厚労省作成);
            }
        }
        executeStep(各テーブルへの登録);
    }

    /**
     * 申請情報抽出のbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(申請情報抽出)
    protected IBatchFlowCommand toNinteiShinseiJohoProcess() {
        return loopBatch(NinteiShinseiJohoProcess.class).
                arguments(creatNinteiShinseiJohoProcessParameter()).
                define();
    }

    /**
     * 申請情報IF編集のbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(申請情報IF編集)
    protected IBatchFlowCommand toModifyNinteiShinseiJohoProcess() {
        return loopBatch(ModifyNinteiShinseiJohoProcess.class).
                arguments(createModifyNinteiShinseiJohoProcessParameter()).
                define();
    }

    /**
     * 認定審査判定依頼一覧表発行のbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(認定審査判定依頼一覧表発行)
    protected IBatchFlowCommand toPntNinteiShinsaHanteiListProcess() {
        return loopBatch(PntNinteiShinsaHanteiListProcess.class).
                arguments(createPntNinteiShinsaHanteiListProcessParameter()).
                define();
    }

    /**
     * 申請情報IFファイル電算標準版作成のbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(申請情報IFファイル電算標準版作成)
    protected IBatchFlowCommand toMakeNinteiShinseiJohoFileProcess() {
        return loopBatch(MakeNinteiShinseiJohoFileProcess.class).
                arguments(createMakeNinteiShinseiJohoFileProcessParameter()).
                define();
    }

    /**
     * 申請情報IFファイル厚労省作成のbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(申請情報IFファイル厚労省作成)
    protected IBatchFlowCommand toMakeNinteiShinseiJohoFileKourouProcess() {
        return loopBatch(MakeNinteiShinseiJohoFileKourouProcess.class).
                arguments(createMakeNinteiShinseiJohoFileProcessParameter()).
                define();
    }

    /**
     * 各テーブルへの登録のbatchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(各テーブルへの登録)
    protected IBatchFlowCommand toInsNinteiGaibuDataOutputHistoryProcess() {
        return loopBatch(InsNinteiGaibuDataOutputHistoryProcess.class).
                arguments(createInsNinteiGaibuDataOutputHistoryProcessParmaeter()).
                define();
    }

    private NinteiShinseiJohoProcessParameter creatNinteiShinseiJohoProcessParameter() {
        DBD519001_NinteishinseiInfoIfParameter flowParameter = getParameter();
        NinteiShinseiJohoProcessParameter parameter = new NinteiShinseiJohoProcessParameter(
                flowParameter.get証記載保険者番号(),
                new HihokenshaNo(flowParameter.get被保険者番号()),
                flowParameter.get今回開始期間FROM(),
                flowParameter.get今回開始期間TO(),
                flowParameter.get対象外被保険者番号リスト());
        return parameter;
    }

    private ModifyNinteiShinseiJohoProcessParameter createModifyNinteiShinseiJohoProcessParameter() {
        DBD519001_NinteishinseiInfoIfParameter flowParameter = getParameter();
        ModifyNinteiShinseiJohoProcessParameter parameter = new ModifyNinteiShinseiJohoProcessParameter(
                認定申請IF種類,
                flowParameter.get市町村コード());
        return parameter;
    }

    private PntNinteiShinsaHanteiListProcessParameter createPntNinteiShinsaHanteiListProcessParameter() {
        DBD519001_NinteishinseiInfoIfParameter flowParameter = getParameter();
        PntNinteiShinsaHanteiListProcessParameter parameter = new PntNinteiShinsaHanteiListProcessParameter();
        parameter.set市町村コード(flowParameter.get市町村コード());
        parameter.set抽出終了日時(flowParameter.get今回開始期間TO());
        parameter.set抽出開始日時(flowParameter.get今回開始期間FROM());
        parameter.set編集状況フラグ(getResult(RString.class, new RString(申請情報IF編集), ModifyNinteiShinseiJohoProcess.OUT編集状況フラグ));
        parameter.set被保険者番号(new HihokenshaNo(flowParameter.get被保険者番号()));
        parameter.set証記載保険者番号(flowParameter.get証記載保険者番号());
        parameter.set認定申請IF種類(認定申請IF種類);
        return parameter;
    }

    private MakeNinteiShinseiJohoFileProcessParameter createMakeNinteiShinseiJohoFileProcessParameter() {
        DBD519001_NinteishinseiInfoIfParameter flowParameter = getParameter();
        MakeNinteiShinseiJohoFileProcessParameter parameter = new MakeNinteiShinseiJohoFileProcessParameter();
        parameter.set市町村コード(flowParameter.get市町村コード());
        parameter.set抽出終了日時(flowParameter.get今回開始期間TO());
        parameter.set抽出開始日時(flowParameter.get今回開始期間FROM());
        parameter.set被保険者番号(new HihokenshaNo(flowParameter.get被保険者番号()));
        parameter.set証記載保険者番号(flowParameter.get証記載保険者番号());
        parameter.set連携データ種類(認定申請IF種類);
        parameter.set連携ファイル名(flowParameter.get新ファイル名());
        return parameter;
    }

    private InsNinteiGaibuDataOutputHistoryProcessParameter createInsNinteiGaibuDataOutputHistoryProcessParmaeter() {
        InsNinteiGaibuDataOutputHistoryProcessParameter parmaeter = new InsNinteiGaibuDataOutputHistoryProcessParameter();
        parmaeter.set開始日時(開始日時);
        parmaeter.set終了日時(YMDHMS.now());
        return parmaeter;
    }
}
