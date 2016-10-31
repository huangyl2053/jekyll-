/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.InsFutanWariaiYMTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.InsFutanwariaiJohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.KoseiTaishoKyuhuzissekiJohouSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.KyuhuzissekiJohoSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.KyuhuzissekiJohoSakuseiYoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.SelKyuhuzissekiKihonTorigaDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.SelRiyoushaHutanwariaitorigaDataProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.ShoriHidukeKanriTeburuKoshiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.ShoriKekkaKakuninProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.UpdRiyoshaFutangengakuTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050.UpdShiharaihohoHenkoTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180050.DBC180050_KoseiTaishoKyufuJissekiIchiranParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.SelKyuhuzissekiKihonTorigaDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.SelRiyoushaHutanwariaitorigaDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.ShoriHidukeKanriTeburuKoshiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.ShoriKekkaKakuninListProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧Flow
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class DBC180050_KoseiTaishoKyufuJissekiIchiran extends BatchFlowBase<DBC180050_KoseiTaishoKyufuJissekiIchiranParameter> {

    private RDateTime バッチ起動時処理日時;

    private static final String SEL_RIYOUSHAHUTANWARIAITORIGA = "SelRiyoushaHutanwariaitorigaDataProcess";
    private static final String SEL_KYUHUZISSEKIKIHONTORIGA = "SelKyuhuzissekiKihonTorigaDataProcess";
    private static final String INS_FUTANWARIAIJOHOTEMP = "InsFutanwariaiJohoTempProcess";
    private static final String UPD_RIYOSHAFUTANGENGAKUTEMP = "UpdRiyoshaFutangengakuTempProcess";
    private static final String UPD_SHIHARAIHOHOHENKOTEMP = "UpdShiharaihohoHenkoTempProcess";
    private static final String KYUHUZISSEKI_JOHOSAKUSEIYO = "KyuhuzissekiJohoSakuseiYoProcess";
    private static final String KYUHUZISSEKI_JOHOSAKUSEI = "KyuhuzissekiJohoSakuseiProcess";
    private static final String INS_FUTANWARIAIYMTEMP = "InsFutanWariaiYMTempProcess";
    private static final String KYUHUZISSEKIJOHO_USAKUSEI = "KoseiTaishoKyuhuzissekiJohouSakusei";
    private static final String KOSEITAISHO_KYUHUZISSEKII = "KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcess";
    private static final String SHORIHIDUKE_KANRITEBURUKOSHI = "ShoriHidukeKanriTeburuKoshiProcess";
    private static final String SHORIKEKKA_KAKUNINLIST = "ShoriKekkaKakuninListProcess";

    @Override
    protected void initialize() {
        バッチ起動時処理日時 = RDate.getNowDateTime();
    }

    @Override
    protected void defineFlow() {
        executeStep(SEL_RIYOUSHAHUTANWARIAITORIGA);
        executeStep(SEL_KYUHUZISSEKIKIHONTORIGA);
        executeStep(INS_FUTANWARIAIJOHOTEMP);
        executeStep(UPD_RIYOSHAFUTANGENGAKUTEMP);
        executeStep(UPD_SHIHARAIHOHOHENKOTEMP);
        executeStep(KYUHUZISSEKI_JOHOSAKUSEIYO);
        executeStep(KYUHUZISSEKI_JOHOSAKUSEI);
        executeStep(INS_FUTANWARIAIYMTEMP);
        executeStep(KYUHUZISSEKIJOHO_USAKUSEI);
        executeStep(KOSEITAISHO_KYUHUZISSEKII);
        executeStep(SHORIHIDUKE_KANRITEBURUKOSHI);
        executeStep(SHORIKEKKA_KAKUNINLIST);
    }

    /**
     * 利用者負担割合トリガデータ抽出
     *
     * @return IBatchFlowCommand
     */
    @Step(SEL_RIYOUSHAHUTANWARIAITORIGA)
    protected IBatchFlowCommand 利用者負担割合トリガデータ抽出() {
        return loopBatch(SelRiyoushaHutanwariaitorigaDataProcess.class)
                .arguments(toSelRiyoushaHutanwariaitorigaDataProcessParameter())
                .define();
    }

    /**
     * 給付実績トリガデータ抽出
     *
     * @return IBatchFlowCommand
     */
    @Step(SEL_KYUHUZISSEKIKIHONTORIGA)
    protected IBatchFlowCommand 給付実績トリガデータ抽出() {
        return loopBatch(SelKyuhuzissekiKihonTorigaDataProcess.class)
                .arguments(toSelKyuhuzissekiKihonTorigaDataProcessParameter())
                .define();
    }

    /**
     * 利用者負担割合情報の取得
     *
     * @return IBatchFlowCommand
     */
    @Step(INS_FUTANWARIAIJOHOTEMP)
    protected IBatchFlowCommand 利用者負担割合情報の取得() {
        return loopBatch(InsFutanwariaiJohoTempProcess.class).define();
    }

    /**
     * 利用者負担減額情報の取得
     *
     * @return IBatchFlowCommand
     */
    @Step(UPD_RIYOSHAFUTANGENGAKUTEMP)
    protected IBatchFlowCommand 利用者負担減額情報の取得() {
        return loopBatch(UpdRiyoshaFutangengakuTempProcess.class).define();
    }

    /**
     * 支払方法変更情報の取得
     *
     * @return IBatchFlowCommand
     */
    @Step(UPD_SHIHARAIHOHOHENKOTEMP)
    protected IBatchFlowCommand 支払方法変更情報の取得() {
        return loopBatch(UpdShiharaihohoHenkoTempProcess.class).define();
    }

    /**
     * 給付実績情報作成用
     *
     * @return IBatchFlowCommand
     */
    @Step(KYUHUZISSEKI_JOHOSAKUSEIYO)
    protected IBatchFlowCommand 給付実績情報作成用() {
        return loopBatch(KyuhuzissekiJohoSakuseiYoProcess.class).define();
    }

    /**
     * 給付実績情報作成
     *
     * @return IBatchFlowCommand
     */
    @Step(KYUHUZISSEKI_JOHOSAKUSEI)
    protected IBatchFlowCommand 給付実績情報作成() {
        return loopBatch(KyuhuzissekiJohoSakuseiProcess.class).define();
    }

    /**
     * 給付実績情報年月作成
     *
     * @return IBatchFlowCommand
     */
    @Step(INS_FUTANWARIAIYMTEMP)
    protected IBatchFlowCommand 給付実績情報年月作成() {
        return loopBatch(InsFutanWariaiYMTempProcess.class).define();
    }

    /**
     * 更正対象給付実績情報の作成
     *
     * @return IBatchFlowCommand
     */
    @Step(KYUHUZISSEKIJOHO_USAKUSEI)
    protected IBatchFlowCommand 更正対象給付実績情報の作成() {
        return loopBatch(KoseiTaishoKyuhuzissekiJohouSakuseiProcess.class).define();
    }

    /**
     * 更正対象給付実績一覧表出力
     *
     * @return IBatchFlowCommand
     */
    @Step(KOSEITAISHO_KYUHUZISSEKII)
    protected IBatchFlowCommand 更正対象給付実績一覧表出力() {
        return loopBatch(KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcess.class)
                .arguments(toKoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter()).define();
    }

    /**
     * 処理日付管理テーブル更新
     *
     * @return IBatchFlowCommand
     */
    @Step(SHORIHIDUKE_KANRITEBURUKOSHI)
    protected IBatchFlowCommand 処理日付管理テーブル更新() {
        return loopBatch(ShoriHidukeKanriTeburuKoshiProcess.class)
                .arguments(toShoriHidukeKanriTeburuKoshiProcessParameter()).define();
    }

    /**
     * 処理結果確認リスト作成
     *
     * @return IBatchFlowCommand
     */
    @Step(SHORIKEKKA_KAKUNINLIST)
    protected IBatchFlowCommand 処理結果確認リスト作成() {
        return loopBatch(ShoriKekkaKakuninProcess.class)
                .arguments(toShoriKekkaKakuninListProcessParameter()).define();
    }

    private SelRiyoushaHutanwariaitorigaDataProcessParameter toSelRiyoushaHutanwariaitorigaDataProcessParameter() {
        return new SelRiyoushaHutanwariaitorigaDataProcessParameter(getParameter().get抽出期間開始日時().getRDateTime(),
                getParameter().get抽出期間終了日時().getRDateTime());
    }

    private SelKyuhuzissekiKihonTorigaDataProcessParameter toSelKyuhuzissekiKihonTorigaDataProcessParameter() {
        return new SelKyuhuzissekiKihonTorigaDataProcessParameter(getParameter().get抽出期間開始日時().getRDateTime(),
                getParameter().get抽出期間終了日時().getRDateTime());
    }

    private KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter toKoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter() {
        return new KoseiTaishoKyuhuzissekiItiranhyoShuturyokuProcessParameter(getParameter().get出力順ID(),
                getParameter().get抽出期間開始日時().getRDateTime(), getParameter().get抽出期間終了日時().getRDateTime());
    }

    private ShoriHidukeKanriTeburuKoshiProcessParameter toShoriHidukeKanriTeburuKoshiProcessParameter() {
        return new ShoriHidukeKanriTeburuKoshiProcessParameter(getParameter().get抽出期間開始日時().getRDateTime(),
                getParameter().get抽出期間終了日時().getRDateTime());
    }

    private ShoriKekkaKakuninListProcessParameter toShoriKekkaKakuninListProcessParameter() {
        return new ShoriKekkaKakuninListProcessParameter(バッチ起動時処理日時);
    }
}
