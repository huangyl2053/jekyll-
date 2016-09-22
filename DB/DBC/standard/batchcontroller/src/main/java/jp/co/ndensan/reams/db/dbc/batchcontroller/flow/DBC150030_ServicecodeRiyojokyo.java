/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.HihokenshaShikibetsuTaishoGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.IchiranServicecodeRiyojokyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.KyufuJissekiKyotakuGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.KyufuJissekiMeisaiGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.KyufujissekiTokuteiNyushosyaKaigoGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.ShikibetsuTaishoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.ShoriKekkaListSakuseiDoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.TaniSuNissuKaisuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150030.UpdateChohyouShutsuryokuyouProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030.DBC150030_ServicecodeRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービスコード別利用状況作成Flowクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class DBC150030_ServicecodeRiyojokyo
        extends BatchFlowBase<DBC150030_ServicecodeRiyojokyoParameter> {

    private static final String 給付実績明細情報の取得処理 = "給付実績明細情報の取得処理";
    private static final String 給付実績居宅サービス計画費情報の取得処理 = "給付実績居宅サービス計画費情報の取得処理";
    private static final String 給付実績特定入所者介護サービス費用情報の取得処理 = "給付実績特定入所者介護サービス費用情報の取得処理";
    private static final String 被保険者_宛名情報取得 = "被保険者_宛名情報取得";
    private static final String 宛名情報抽出処理 = "宛名情報抽出処理";
    private static final String 日数_回数_単位数を取得 = "日数_回数_単位数を取得";
    private static final String 帳票出力用一時TBLの更新処理 = "帳票出力用一時TBLの更新処理";
    private static final String 処理結果リスト作成 = "処理結果リスト作成";
    private static final String 一覧表作成 = "一覧表作成";

    private static final RString 文字_01 = new RString("01");

    private FlowEntity flowEntity;
    private int 明細件数;

    @Override
    protected void defineFlow() {
        executeStep(給付実績明細情報の取得処理);
        flowEntity = getResult(FlowEntity.class, 給付実績明細情報の取得処理,
                KyufuJissekiMeisaiGetProcess.PARAMETER_OUT_FLOWENTITY);
        明細件数 = flowEntity.get明細データ登録件数();
        executeStep(給付実績居宅サービス計画費情報の取得処理);
        flowEntity = getResult(FlowEntity.class, 給付実績居宅サービス計画費情報の取得処理,
                KyufuJissekiKyotakuGetProcess.PARAMETER_OUT_FLOWENTITY);
        明細件数 = flowEntity.get明細データ登録件数();
        executeStep(給付実績特定入所者介護サービス費用情報の取得処理);
        flowEntity = getResult(FlowEntity.class, 給付実績特定入所者介護サービス費用情報の取得処理,
                KyufujissekiTokuteiNyushosyaKaigoGetProcess.PARAMETER_OUT_FLOWENTITY);
        executeStep(被保険者_宛名情報取得);
        executeStep(宛名情報抽出処理);
        executeStep(日数_回数_単位数を取得);
        if (!文字_01.equals(getParameter().getサービス項目コードのまとめ方())) {
            executeStep(帳票出力用一時TBLの更新処理);
        }
        executeStep(一覧表作成);
        executeStep(処理結果リスト作成);
    }

    /**
     * 給付実績明細情報の取得処理。
     *
     * @return KyufuJissekiMeisaiGetProcess
     */
    @Step(給付実績明細情報の取得処理)
    IBatchFlowCommand getKyufuJissekiMeisaiProcess() {
        KyufuJissekiMeisaiGetProcessParameter kyufuJissekiParameter = new KyufuJissekiMeisaiGetProcessParameter();
        kyufuJissekiParameter.set対象年月指定(getParameter().get対象年月指定());
        kyufuJissekiParameter.set対象サービス種類(getParameter().get対象サービス種類());
        kyufuJissekiParameter.set年月範囲開始(getParameter().get年月範囲開始());
        kyufuJissekiParameter.set年月範囲終了(getParameter().get年月範囲終了());
        return loopBatch(KyufuJissekiMeisaiGetProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 給付実績居宅サービス計画費情報の取得処理。
     *
     * @return KyufuJissekiKyotakuGetProcess
     */
    @Step(給付実績居宅サービス計画費情報の取得処理)
    IBatchFlowCommand getKyufuJissekiKyotakuProcess() {
        KyufuJissekiMeisaiGetProcessParameter kyufuJissekiParameter = new KyufuJissekiMeisaiGetProcessParameter();
        kyufuJissekiParameter.set対象年月指定(getParameter().get対象年月指定());
        kyufuJissekiParameter.set対象サービス種類(getParameter().get対象サービス種類());
        kyufuJissekiParameter.set連番(明細件数);
        kyufuJissekiParameter.set年月範囲開始(getParameter().get年月範囲開始());
        kyufuJissekiParameter.set年月範囲終了(getParameter().get年月範囲終了());
        return loopBatch(KyufuJissekiKyotakuGetProcess.class)
                .arguments(kyufuJissekiParameter).define();
    }

    /**
     * 給付実績特定入所者介護サービス費用情報の取得処理。
     *
     * @return KyufujissekiTokuteiNyushosyaKaigoGetProcess
     */
    @Step(給付実績特定入所者介護サービス費用情報の取得処理)
    IBatchFlowCommand getKyufujissekiTokuteiNyushosyaKaigoProcess() {
        KyufuJissekiMeisaiGetProcessParameter kyufuJissekiParameter = new KyufuJissekiMeisaiGetProcessParameter();
        kyufuJissekiParameter.set対象年月指定(getParameter().get対象年月指定());
        kyufuJissekiParameter.set対象サービス種類(getParameter().get対象サービス種類());
        kyufuJissekiParameter.set連番(明細件数);
        kyufuJissekiParameter.set年月範囲開始(getParameter().get年月範囲開始());
        kyufuJissekiParameter.set年月範囲終了(getParameter().get年月範囲終了());
        if (getParameter().get市町村情報() != null) {
            kyufuJissekiParameter.set市町村コード(getParameter().get市町村情報().getコード());
        }
        kyufuJissekiParameter.set選択対象(getParameter().get選択対象());
        return loopBatch(KyufujissekiTokuteiNyushosyaKaigoGetProcess.class)
                .arguments(kyufuJissekiParameter).define();
    }

    /**
     * 被保険者_宛名情報取得。
     *
     * @return HihokenshaShikibetsuTaishoGetProcess
     */
    @Step(被保険者_宛名情報取得)
    IBatchFlowCommand getHihokenshaShikibetsuTaishoProcess() {
        return loopBatch(HihokenshaShikibetsuTaishoGetProcess.class).define();
    }

    /**
     * 宛名情報抽出処理
     *
     * @return ShikibetsuTaishoProcess
     */
    @Step(宛名情報抽出処理)
    IBatchFlowCommand getShikibetsuTaishoProcess() {
        KyufuJissekiMeisaiGetProcessParameter kyufuJissekiParameter = new KyufuJissekiMeisaiGetProcessParameter();
        if (getParameter().get市町村情報() != null) {
            kyufuJissekiParameter.set市町村コード(getParameter().get市町村情報().getコード());
        }
        if (getParameter().get旧市町村情報() != null) {
            kyufuJissekiParameter.set旧市町村コード(getParameter().get旧市町村情報().getコード());
        }
        kyufuJissekiParameter.set選択対象(getParameter().get選択対象());
        kyufuJissekiParameter.set対象コード(getParameter().get対象コードリスト());
        kyufuJissekiParameter.set対象年月指定(getParameter().get対象年月指定());
        kyufuJissekiParameter.set対象サービス種類(getParameter().get対象サービス種類());
        kyufuJissekiParameter.set年月範囲開始(getParameter().get年月範囲開始());
        kyufuJissekiParameter.set年月範囲終了(getParameter().get年月範囲終了());
        return loopBatch(ShikibetsuTaishoProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 日数_回数_単位数を取得。
     *
     * @return TaniSuNissuKaisuProcess
     */
    @Step(日数_回数_単位数を取得)
    IBatchFlowCommand getTaniSuNissuKaisuProcess() {
        KyufuJissekiMeisaiGetProcessParameter kyufuJissekiParameter = new KyufuJissekiMeisaiGetProcessParameter();
        kyufuJissekiParameter.set対象サービス種類(getParameter().get対象サービス種類());
        kyufuJissekiParameter.setサービス項目コードのまとめ方(getParameter().getサービス項目コードのまとめ方());
        return loopBatch(TaniSuNissuKaisuProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 帳票出力用一時TBLの更新処理。
     *
     * @return UpdateChohyouShutsuryokuyouProcess
     */
    @Step(帳票出力用一時TBLの更新処理)
    IBatchFlowCommand updateChohyouShutsuryokuyouProcess() {
        return loopBatch(UpdateChohyouShutsuryokuyouProcess.class).define();
    }

    /**
     * 一覧表作成。
     *
     * @return IchiranServicecodeRiyojokyoProcess
     */
    @Step(一覧表作成)
    IBatchFlowCommand doIchiranServicecodeRiyojokyoProcess() {
        KyufuJissekiMeisaiGetProcessParameter kyufuJissekiParameter = new KyufuJissekiMeisaiGetProcessParameter();
        kyufuJissekiParameter.set対象年月指定(getParameter().get対象年月指定());
        kyufuJissekiParameter.set選択対象(getParameter().get選択対象());
        if (getParameter().get旧市町村情報() != null) {
            kyufuJissekiParameter.set旧市町村コード(getParameter().get旧市町村情報().getコード());
            kyufuJissekiParameter.set旧市町村名(getParameter().get旧市町村情報().get名称());
        }
        return loopBatch(IchiranServicecodeRiyojokyoProcess.class).arguments(kyufuJissekiParameter).define();
    }

    /**
     * 処理結果リスト作成。
     *
     * @return KyufujissekiTokuteiNyushosyaKaigoGetProcess
     */
    @Step(処理結果リスト作成)
    IBatchFlowCommand doShoriKekkaListSakuseiProcess() {
        KyufuJissekiMeisaiGetProcessParameter kyufuJissekiParameter = new KyufuJissekiMeisaiGetProcessParameter();
        return loopBatch(ShoriKekkaListSakuseiDoProcess.class).arguments(kyufuJissekiParameter).define();
    }
}
