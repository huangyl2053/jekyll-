/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.dbb1110001;

import java.util.List;
import static java.util.Objects.requireNonNull;
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
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBBBT51003_所得情報一覧表作成です。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class DBB1110001_ShotokujohoIchiranhyoSakuseiFlow extends BatchFlowBase<ShotokujohoIchiranhyoSakuseiBatchParameter> {

    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final RString INDEX_111 = new RString("111");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final RString MSG_処理年度 = new RString("処理年度");
    private static final RString MSG_抽出対象チックボックス = new RString("抽出対象チックボックス");
    private static final RString MSG_抽出対象ラジオボタン = new RString("抽出対象ラジオボタン");
    private static final RString MSG_抽出期間開始日時 = new RString("抽出期間開始日時");
    private static final RString MSG_抽出期間終了日時 = new RString("抽出期間終了日時");
    private static final RString MSG_市町村情報リスト = new RString("市町村情報リスト");
    private static final RString MSG_出力順 = new RString("出力順");
    private static final RString MSG_開始日時 = new RString("開始日時");
    private static final RString MSG_終了日時 = new RString("終了日時");

    private static final String 所得情報一覧表のデータ取得_単一 = "tanitsuShichosonShotokuIchiarnProcess";
    private static final String 所得情報一覧表のデータ取得_広域 = "koikiShichosonShotokuIchiarnProcess";
    private static final String 介護保険所得情報一覧表出力 = "prtKaigoHokenShotokuJohoIchiranProcess";
    private static final String 処理日付管理マスタを登録 = "registShoriDateKanriProcess";
    private RString 出力順;
    private RString 改頁項目ID;

    @Override
    protected void defineFlow() {
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
        executeStep(処理日付管理マスタを登録);
    }

    /**
     * 単一市町村の所得情報一覧取得です。
     *
     * @return IBatchFlowCommand
     */
    @Step(所得情報一覧表のデータ取得_単一)
    protected IBatchFlowCommand tanitsuShichosonShotokuIchiarnProcess() {
        ShotokujohoIchiranhyoSakuseiProcessParameter parameter = getParameter().toProcessParameter();
        requireNonNull(parameter.get処理年度(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_処理年度.toString()));
        requireNonNull(parameter.getチェックボックス(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_抽出対象チックボックス.toString()));
        requireNonNull(parameter.getラジオボタン(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_抽出対象ラジオボタン.toString()));
        requireNonNull(parameter.get開始日時(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_抽出期間開始日時.toString()));
        requireNonNull(parameter.get終了日時(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_抽出期間終了日時.toString()));
        requireNonNull(parameter.get出力順(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_出力順.toString()));
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
        requireNonNull(parameter.get処理年度(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_処理年度.toString()));
        requireNonNull(parameter.getチェックボックス(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_抽出対象チックボックス.toString()));
        requireNonNull(parameter.getラジオボタン(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_抽出対象ラジオボタン.toString()));
        requireNonNull(parameter.get市町村情報リスト(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_市町村情報リスト.toString()));
        requireNonNull(parameter.get出力順(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_出力順.toString()));
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
        RString 導入形態コード = parameter.get導入形態コード();
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            requireNonNull(parameter.get抽出期間開始日時(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_開始日時.toString()));
            requireNonNull(parameter.get抽出期間終了日時(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_終了日時.toString()));
            return loopBatch(RegistShoriDateKanriProcess.class).arguments(parameter).define();
        } else {
            requireNonNull(parameter.get市町村情報リスト(), UrSystemErrorMessages.値がnull.getReplacedMessage(MSG_市町村情報リスト.toString()));
            List<ShichosonJouhouResult> 市町村情報リスト = parameter.get市町村情報リスト();
            for (ShichosonJouhouResult result : 市町村情報リスト) {
                parameter.set市町村コード(result.get市町村コード());
                parameter.set市町村識別ID(result.get市町村識別ID());
                parameter.set開始年月日(result.get開始年月日());
                parameter.set終了年月日(result.get終了年月日());
                parameter.set開始時刻(result.get開始時刻());
                parameter.set終了時刻(result.get終了時刻());
                return loopBatch(RegistShoriDateKanriProcess.class).arguments(parameter).define();
            }
        }
        return null;
    }

}
