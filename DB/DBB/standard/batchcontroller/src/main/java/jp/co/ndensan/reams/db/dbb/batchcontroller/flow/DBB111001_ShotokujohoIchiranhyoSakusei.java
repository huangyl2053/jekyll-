/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB111001.KoikiShichosonShotokuIchiarnProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB111001.PrtKaigoHokenShotokuJohoIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB111001.RegistShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB111001.TanitsuShichosonShotokuIchiarnProcess;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB111001.DBB111001_ShotokujohoIchiranhyoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.RegistShoriDateKanriProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;

/**
 * バッチ設計_DBBBT51003_所得情報一覧表作成です。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class DBB111001_ShotokujohoIchiranhyoSakusei extends BatchFlowBase<DBB111001_ShotokujohoIchiranhyoSakuseiParameter> {

    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final RString INDEX_0 = new RString("0");
    private static final RString INDEX_111 = new RString("111");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final String 所得情報一覧表のデータ取得_単一 = "tanitsuShichosonShotokuIchiarnProcess";
    private static final String 所得情報一覧表のデータ取得_広域 = "koikiShichosonShotokuIchiarnProcess";
    private static final String 介護保険所得情報一覧表出力 = "prtKaigoHokenShotokuJohoIchiranProcess";
    private static final String 処理日付管理マスタを登録 = "registShoriDateKanriProcess";
    private RegistShoriDateKanriProcessParameter parameter;
    private ShotokujohoIchiranhyoSakuseiProcessParameter 広域param;
    private RString 出力順;

    @Override
    protected void defineFlow() {
        if (getParameter().get出力順ID() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID, getParameter().get出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(
                KaigoHokenShotokuJohoIchiranOutPutOrder.class, outputOrder);
        RString 導入形態コード = getParameter().get導入形態コード();
        if (INDEX_120.equals(導入形態コード)) {
            executeStep(所得情報一覧表のデータ取得_単一);
        } else if (INDEX_111.equals(導入形態コード)) {
            for (ShichosonJouhouResult result : getParameter().get市町村情報リスト()) {
                広域param = new ShotokujohoIchiranhyoSakuseiProcessParameter();
                広域param.set市町村情報(result);
                YMDHMS 開始日時 = new YMDHMS(new RDate(result.get開始年月日().toString()), new RTime(result.get開始時刻()));
                YMDHMS 終了日時 = new YMDHMS(new RDate(result.get終了年月日().toString()), new RTime(result.get終了時刻()));
                広域param.set開始日時(開始日時);
                広域param.set終了日時(終了日時);
                executeStep(所得情報一覧表のデータ取得_広域);
            }
        }
        executeStep(介護保険所得情報一覧表出力);
        RString flag = getResult(RString.class, new RString(介護保険所得情報一覧表出力), PrtKaigoHokenShotokuJohoIchiranProcess.REPORT_FLAG);
        if (!INDEX_0.equals(flag)) {
            parameter = getParameter().toRegistShoriDateKanriProcessParameter();
            parameter.set市町村情報リスト(getParameter().get市町村情報リスト());
            if (INDEX_120.equals(導入形態コード)) {
                executeStep(処理日付管理マスタを登録);
            } else if (INDEX_111.equals(導入形態コード)) {
                for (ShichosonJouhouResult result : getParameter().get市町村情報リスト()) {
                    parameter.set市町村コード(result.get市町村コード());
                    parameter.set市町村識別ID(result.get市町村識別ID());
                    parameter.set開始年月日(result.get開始年月日());
                    parameter.set終了年月日(result.get終了年月日());
                    parameter.set開始時刻(result.get開始時刻());
                    parameter.set終了時刻(result.get終了時刻());
                    parameter.set市町村情報(result);
                    executeStep(処理日付管理マスタを登録);
                }
            }
        }
    }

    /**
     * 単一市町村の所得情報一覧取得です。
     *
     * @return IBatchFlowCommand
     */
    @Step(所得情報一覧表のデータ取得_単一)
    protected IBatchFlowCommand tanitsuShichosonShotokuIchiarnProcess() {
        ShotokujohoIchiranhyoSakuseiProcessParameter param = creatBatchParameter();
        param.set出力順(出力順);
        if (param.get処理年度() == null || param.getチェックボックス() == null
                || param.getラジオボタン() == null || param.get開始日時() == null
                || param.get終了日時() == null || param.get出力順() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(TanitsuShichosonShotokuIchiarnProcess.class).arguments(param).define();
    }

    /**
     * 広域市町村の所得情報一覧取得です。
     *
     * @return IBatchFlowCommand
     */
    @Step(所得情報一覧表のデータ取得_広域)
    protected IBatchFlowCommand koikiShichosonShotokuIchiarnProcess() {
        広域param.set導入形態コード(getParameter().get導入形態コード());
        広域param.set市町村コード(getParameter().get市町村コード());
        広域param.set市町村名称(getParameter().get市町村名称());
        広域param.set処理年度(getParameter().get処理年度());
        広域param.setチェックボックス(getParameter().getチェックボックス());
        広域param.setラジオボタン(getParameter().getラジオボタン());
        広域param.set市町村情報リスト(getParameter().get市町村情報リスト());
        広域param.set出力順ID(getParameter().get出力順ID());
        広域param.set出力順(出力順);
        if (広域param.get処理年度() == null || 広域param.getチェックボックス() == null
                || 広域param.getラジオボタン() == null || (広域param.get市町村情報リスト() == null || 広域param.get市町村情報リスト().isEmpty())
                || 広域param.get出力順() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(KoikiShichosonShotokuIchiarnProcess.class).arguments(広域param).define();
    }

    /**
     * 介護保険所得情報一覧表出力です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険所得情報一覧表出力)
    protected IBatchFlowCommand prtKaigoHokenShotokuJohoIchiranProcess() {
        ShotokujohoIchiranhyoSakuseiProcessParameter param = creatBatchParameter();
        return loopBatch(PrtKaigoHokenShotokuJohoIchiranProcess.class).arguments(param).define();
    }

    /**
     * 処理日付管理マスタを登録です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタを登録)
    protected IBatchFlowCommand registShoriDateKanriProcess() {
        if (INDEX_112.equals(parameter.get導入形態コード()) || INDEX_120.equals(parameter.get導入形態コード())) {
            if (parameter.get抽出期間開始日時() == null || parameter.get抽出期間終了日時() == null) {
                throw new ApplicationException(UrErrorMessages.検索キーの誤り
                        .getMessage().evaluate());
            }
        } else if (INDEX_111.equals(parameter.get導入形態コード())
                && (parameter.get市町村情報リスト() == null || parameter.get市町村情報リスト().isEmpty())) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(RegistShoriDateKanriProcess.class).arguments(parameter).define();
    }

    private ShotokujohoIchiranhyoSakuseiProcessParameter creatBatchParameter() {
        ShotokujohoIchiranhyoSakuseiProcessParameter param = new ShotokujohoIchiranhyoSakuseiProcessParameter();
        param.set導入形態コード(getParameter().get導入形態コード());
        param.set市町村コード(getParameter().get市町村コード());
        param.set市町村名称(getParameter().get市町村名称());
        param.set処理年度(getParameter().get処理年度());
        param.setチェックボックス(getParameter().getチェックボックス());
        param.setラジオボタン(getParameter().getラジオボタン());
        param.set開始日時(getParameter().get開始日時());
        param.set終了日時(getParameter().get終了日時());
        param.set市町村情報リスト(getParameter().get市町村情報リスト());
        param.set出力順ID(getParameter().get出力順ID());
        return param;
    }
}
