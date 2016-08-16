/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb1110001;

import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001.KoikiShichosonShotokuIchiarnProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001.PrtKaigoHokenShotokuJohoIchiranProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001.RegistShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb1110001.TanitsuShichosonShotokuIchiarnProcess;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiBatchParameter;
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
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51003_所得情報一覧表作成です。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class DBB1110001_ShotokujohoIchiranhyoSakuseiFlow extends BatchFlowBase<ShotokujohoIchiranhyoSakuseiBatchParameter> {

    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final RString INDEX_0 = new RString("0");
    private static final RString INDEX_111 = new RString("111");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final String 所得情報一覧表のデータ取得_単一 = "tanitsuShichosonShotokuIchiarnProcess";
    private static final String 所得情報一覧表のデータ取得_広域 = "koikiShichosonShotokuIchiarnProcess";
    private static final String 介護保険所得情報一覧表出力 = "prtKaigoHokenShotokuJohoIchiranProcess";
    private static final String 処理日付管理マスタを登録 = "registShoriDateKanriProcess";
    private RString 出力順;
    private RString 改頁項目ID;

    @Override
    protected void defineFlow() {
        if (getParameter().get出力順ID() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(
                SubGyomuCode.DBB介護賦課, 帳票ID, getParameter().get出力順ID());
        出力順 = MyBatisOrderByClauseCreator.create(
                KaigoHokenShotokuJohoIchiranProperty.DBB200008ShutsuryokujunEnum.class, outputOrder);
        改頁項目ID = outputOrder.get改頁項目ID();
        RString 導入形態コード = getParameter().get導入形態コード();
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            executeStep(所得情報一覧表のデータ取得_単一);
        } else if (INDEX_111.equals(導入形態コード)) {
            executeStep(所得情報一覧表のデータ取得_広域);
        }
        executeStep(介護保険所得情報一覧表出力);
        RString flag = getResult(RString.class, new RString(介護保険所得情報一覧表出力), PrtKaigoHokenShotokuJohoIchiranProcess.REPORT_FLAG);
        if (!INDEX_0.equals(flag)) {
            executeStep(処理日付管理マスタを登録);
        }
    }

    /**
     * 単一市町村の所得情報一覧取得です。
     *
     * @return IBatchFlowCommand
     */
    @Step(所得情報一覧表のデータ取得_単一)
    protected IBatchFlowCommand tanitsuShichosonShotokuIchiarnProcess() {
        ShotokujohoIchiranhyoSakuseiProcessParameter parameter = getParameter().toProcessParameter();
        parameter.set出力順(出力順);
        if (parameter.get処理年度() == null || parameter.getチェックボックス() == null
                || parameter.getラジオボタン() == null || parameter.get開始日時() == null
                || parameter.get終了日時() == null || parameter.get出力順() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(TanitsuShichosonShotokuIchiarnProcess.class).arguments(parameter).define();
    }

    /**
     * 広域市町村の所得情報一覧取得です。
     *
     * @return IBatchFlowCommand
     */
    @Step(所得情報一覧表のデータ取得_広域)
    protected IBatchFlowCommand koikiShichosonShotokuIchiarnProcess() {
        ShotokujohoIchiranhyoSakuseiProcessParameter parameter = getParameter().toProcessParameter();
        parameter.set出力順(出力順);
        if (parameter.get処理年度() == null || parameter.getチェックボックス() == null
                || parameter.getラジオボタン() == null || (parameter.get市町村情報リスト() == null || parameter.get市町村情報リスト().isEmpty())
                || parameter.get出力順() == null) {
            throw new ApplicationException(UrErrorMessages.検索キーの誤り
                    .getMessage().evaluate());
        }
        return loopBatch(KoikiShichosonShotokuIchiarnProcess.class).arguments(parameter).define();
    }

    /**
     * 介護保険所得情報一覧表出力です。
     *
     * @return IBatchFlowCommand
     */
    @Step(介護保険所得情報一覧表出力)
    protected IBatchFlowCommand prtKaigoHokenShotokuJohoIchiranProcess() {
        ShotokujohoIchiranhyoSakuseiProcessParameter parameter = getParameter().toProcessParameter();
        parameter.set出力順(出力順);
        parameter.set改頁(改頁項目ID);
        return loopBatch(PrtKaigoHokenShotokuJohoIchiranProcess.class).arguments(parameter).define();
    }

    /**
     * 処理日付管理マスタを登録です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理マスタを登録)
    protected IBatchFlowCommand registShoriDateKanriProcess() {
        RegistShoriDateKanriProcessParameter parameter = getParameter().toRegistShoriDateKanriProcessParameter();
        parameter.set市町村情報リスト(getParameter().get市町村情報リスト());
        RString 導入形態コード = parameter.get導入形態コード();
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            if (parameter.get抽出期間開始日時() == null || parameter.get抽出期間終了日時() == null) {
                throw new ApplicationException(UrErrorMessages.検索キーの誤り
                        .getMessage().evaluate());
            }
            return loopBatch(RegistShoriDateKanriProcess.class).arguments(parameter).define();
        } else {
            if (parameter.get市町村情報リスト() == null || parameter.get市町村情報リスト().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.検索キーの誤り
                        .getMessage().evaluate());
            }
            for (ShichosonJouhouResult result : getParameter().get市町村情報リスト()) {
                parameter.set市町村コード(result.get市町村コード());
                parameter.set市町村識別ID(result.get市町村識別ID());
                parameter.set開始年月日(result.get開始年月日());
                parameter.set終了年月日(result.get終了年月日());
                parameter.set開始時刻(result.get開始時刻());
                parameter.set終了時刻(result.get終了時刻());
                parameter.set市町村情報(result);
                return loopBatch(RegistShoriDateKanriProcess.class).arguments(parameter).define();
            }
        }
        return null;
    }

}
