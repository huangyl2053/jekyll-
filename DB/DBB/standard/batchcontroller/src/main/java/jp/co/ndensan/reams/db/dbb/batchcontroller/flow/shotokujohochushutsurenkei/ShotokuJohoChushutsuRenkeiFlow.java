/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow.shotokujohochushutsurenkei;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.shotokujohochushutsurenkei.ShotokuJohoChushutsuRenkeiCreateTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.shotokujohochushutsurenkei.ShotokuJohoChushutsuRenkeiInsertTempProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako.SystemTimeShutokuProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shutokujohochushutsurenkei.ShutokuJohoChushutsuRenkeiBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shorikega.ShoriKegaKakunin;
import jp.co.ndensan.reams.db.dbb.service.core.shotokujohochushutsurenkeibatch.ShotokuJohoChushutsuRenkeiBatch;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 所得情報抽出・連携（バッチ）バッチフロークラスです。
 *
 * @reamsid_L DBB-1690-060 sunhui
 */
public class ShotokuJohoChushutsuRenkeiFlow extends BatchFlowBase<ShutokuJohoChushutsuRenkeiBatchParameter> {

    private static final String システム日時の取得 = "getSystemDate";
    private static final String 識別コード変換 = "shikibetsuCodehenkan";
    private static final String CSVファイル読み込み = "csvFileYomikomi";
    private static final String 所得情報チェック = "shutokujohoCheck";
    private static final String 介護所得管理登録 = "kaigoShutokuKanriToroku";
    private static final String 帳票の発行 = "chouhyouHakou";
    private static final String 所得情報登録エラーリスト作成 = "shotokujohoTorokuErrList";
    private static final String 処理日付管理マスタの更新 = "updShoriHidukeKanri";
    private static final String 業務コンフィグの更新 = "updGyumuConfig";
    private static final String TEMP_TABLE_CREATE = "tempTableCreateProcess";
    private static final String TEMP_TABLE_INSERT = "tempTableInsertProcess";
    private static final RString 当初_広域 = new RString("1");
    private static final RString 当初_単一 = new RString("3");
    private static final RString 変更理由KEY = new RString("を使用して更新");
    private ShutokuJohoChushutsuRenkeiBatchParameter parameter;

    @Override
    protected void defineFlow() {
        executeStep(システム日時の取得);
        executeStep(識別コード変換);
        executeStep(CSVファイル読み込み);
        executeStep(所得情報チェック);
        executeStep(介護所得管理登録);
        executeStep(帳票の発行);
        executeStep(所得情報登録エラーリスト作成);
        executeStep(処理日付管理マスタの更新);
        executeStep(業務コンフィグの更新);
        executeStep(TEMP_TABLE_CREATE);
        executeStep(TEMP_TABLE_INSERT);
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(システム日時の取得)
    protected IBatchFlowCommand getSystemDate() {
        ShutokuJohoShuchutsuRenkeiProcessParameter para = new ShutokuJohoShuchutsuRenkeiProcessParameter(
                parameter.get処理年度(), parameter.get市町村情報List(), parameter.get出力順ID(), parameter.get帳票ID(),
                parameter.get共有ファイル名(), parameter.get共有ファイルID(), parameter.get処理区分(), parameter.get処理日時());
        return simpleBatch(SystemTimeShutokuProcess.class).arguments(para).define();
    }

    /**
     * 識別コード変換を行います。
     *
     * @return バッチコマンド
     */
    @Step(識別コード変換)
    protected IBatchFlowCommand shikibetsuCodehenkan() {
        // TODO 様式なし
        return null;
    }

    /**
     * CSVファイル読み込みを行います。
     *
     */
    @Step(CSVファイル読み込み)
    protected void csvFileYomikomi() {
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        new ShotokuJohoChushutsuRenkeiBatch().selectShotokuJoho(parameter.get処理区分(), parameter.get市町村情報List());
    }

    /**
     * 所得情報チェックを行います。
     *
     * @return List<ShoriKegaKakunin>
     */
    @Step(所得情報チェック)
    protected List<ShoriKegaKakunin> shutokujohoCheck() {
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        List<ShoriKegaKakunin> shoriKegaKakuninList = new ShotokuJohoChushutsuRenkeiBatch()
                .checkShotokuJoho(parameter.get処理年度(), parameter.get処理区分());
        return shoriKegaKakuninList;
    }

    /**
     * 介護所得管理登録を行います。
     *
     */
    @Step(介護所得管理登録)
    protected void kaigoShutokuKanriToroku() {
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        new ShotokuJohoChushutsuRenkeiBatch().insKaigoShotokuKanri();
    }

    /**
     * 帳票の発行を行います。
     *
     */
    @Step(帳票の発行)
    protected void chouhyouHakou() {
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        new ShotokuJohoChushutsuRenkeiBatch().spoolShotokuJohoIchiran(parameter.get処理区分(),
                parameter.get市町村情報List(), parameter.get帳票ID(), parameter.get処理日時(), parameter.get出力順ID());
    }

    /**
     * 所得情報登録エラーリスト作成を行います。
     *
     */
    @Step(所得情報登録エラーリスト作成)
    protected void shotokujohoTorokuErrList() {
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        List<ShoriKegaKakunin> shoriKegaKakuninList = new ShotokuJohoChushutsuRenkeiBatch()
                .checkShotokuJoho(parameter.get処理年度(), parameter.get処理区分());
        new ShotokuJohoChushutsuRenkeiBatch().spoolShotokuJohoTorokuErrList(shoriKegaKakuninList, parameter.get処理日時());
    }

    /**
     * 処理日付管理マスタの更新を行います。
     *
     */
    @Step(処理日付管理マスタの更新)
    protected void updShoriHidukeKanri() {
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        new ShotokuJohoChushutsuRenkeiBatch().updShoriHidukeKanri(parameter.get処理区分(), parameter.get処理年度(), parameter.get処理日時());
    }

    /**
     * 業務コンフィグの更新を行います。
     *
     */
    @Step(業務コンフィグの更新)
    protected void updGyumuConfig() {
        parameter = new ShutokuJohoChushutsuRenkeiBatchParameter();
        if (当初_広域.equals(parameter.get処理区分()) || 当初_単一.equals(parameter.get処理区分())) {
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.日付関連_所得年度,
                    new RString(parameter.get処理年度().toString()), get変更理由(), RString.EMPTY, RDate.getNowDate());
            BusinessConfig.update(SubGyomuCode.DBB介護賦課, ConfigNameDBB.日付関連_調定年度,
                    new RString(parameter.get処理年度().toString()), get変更理由(), RString.EMPTY, RDate.getNowDate());
        }
    }

    private RString get変更理由() {
        RStringBuilder 変更理由 = new RStringBuilder();
        変更理由.append(UrControlDataFactory.createInstance().getMenuID()).append(変更理由KEY);
        return 変更理由.toRString();
    }

    /**
     * 所得情報Tempを行います。
     *
     * @return バッチコマンド
     */
    @Step(TEMP_TABLE_CREATE)
    protected IBatchFlowCommand tempTableCreateProcess() {
        return simpleBatch(ShotokuJohoChushutsuRenkeiCreateTempProcess.class).define();
    }

    /**
     * 介護所得Tempを行います。
     *
     * @return バッチコマンド
     */
    @Step(TEMP_TABLE_INSERT)
    protected IBatchFlowCommand tempTableInsertProcess() {
        return simpleBatch(ShotokuJohoChushutsuRenkeiInsertTempProcess.class).define();
    }

}
