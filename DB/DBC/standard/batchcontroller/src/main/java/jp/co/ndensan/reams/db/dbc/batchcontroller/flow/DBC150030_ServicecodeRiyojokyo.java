/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.ChohyouShutsuryokuyouProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.HihokenshaShikibetsuTaishoGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.IchiranServicecodeRiyojokyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.KyufuJissekiKyotakuGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.KyufuJissekiMeisaiGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.KyufujissekiTokuteiNyushosyaKaigoGetProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.ShikibetsuTaishoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.ShoriKekkaListSakuseiDoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.TaniSuNissuKaisuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030.UpdateChohyouShutsuryokuyouProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150030.DBC150030_ServicecodeRiyojokyoParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.DbWT3470UpdateProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.FlowEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470chohyouShutsuryokuyouTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
    private static final String 帳票出力用一時TBLの取得処理 = "帳票出力用一時TBLの取得処理";
    private static final String 帳票出力用一時TBLの更新処理 = "帳票出力用一時TBLの更新処理";
    private static final String 処理結果リスト作成 = "処理結果リスト作成";
    private static final String 一覧表作成 = "一覧表作成";

    private static final RString 文字_01 = new RString("01");

    private FlowEntity flowEntity;
    private int 明細件数;
    private RString サービス種類コード;
    private RString ソート用サービス項目コード;
    private RString 要介護状態区分コード;
    private Decimal 日数_回数集計値;
    private Decimal 単位数集計値;
    private int 履歴番号;
    private List<DbWT3470chohyouShutsuryokuyouTempEntity> tempEntityList;

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
            executeStep(帳票出力用一時TBLの取得処理);
            tempEntityList = getResult(List.class, 帳票出力用一時TBLの取得処理,
                    ChohyouShutsuryokuyouProcess.PARAMETER_OUT_FLOWENTITY);
            for (int i = 0; i < tempEntityList.size(); i++) {
                履歴番号 = tempEntityList.get(i).getRenban();
                サービス種類コード = tempEntityList.get(i).getServiceRyakushou();
                ソート用サービス項目コード = tempEntityList.get(i).getSortYouKomokuCode();
                要介護状態区分コード = tempEntityList.get(i).getYoKaigoJotaiKubunCode();
                日数_回数集計値 = tempEntityList.get(i).getNissuKaisuSyukeichi();
                単位数集計値 = tempEntityList.get(i).getTaniSuSyukeichi();
                executeStep(帳票出力用一時TBLの更新処理);
            }
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
     * 帳票出力用一時TBLの取得処理。
     *
     * @return ChohyouShutsuryokuyouProcess
     */
    @Step(帳票出力用一時TBLの取得処理)
    IBatchFlowCommand getChohyouShutsuryokuyouProcess() {
        return loopBatch(ChohyouShutsuryokuyouProcess.class).define();
    }

    /**
     * 帳票出力用一時TBLの更新処理。
     *
     * @return UpdateChohyouShutsuryokuyouProcess
     */
    @Step(帳票出力用一時TBLの更新処理)
    IBatchFlowCommand updateChohyouShutsuryokuyouProcess() {
        DbWT3470UpdateProcessParameter updateProcessParameter = new DbWT3470UpdateProcessParameter();
        updateProcessParameter.set履歴番号(履歴番号);
        updateProcessParameter.setサービス種類コード(サービス種類コード);
        updateProcessParameter.setソート用サービス項目コード(ソート用サービス項目コード);
        updateProcessParameter.set要介護状態区分コード(要介護状態区分コード);
        updateProcessParameter.set日数_回数集計値(日数_回数集計値);
        updateProcessParameter.set単位数集計値(単位数集計値);
        return loopBatch(UpdateChohyouShutsuryokuyouProcess.class).arguments(updateProcessParameter).define();
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
