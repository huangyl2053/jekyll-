/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc180040;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040.FutanWariaiInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040.FutanWariaiShoHakkoIchiranOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040.FutanWariaiShoOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040.FutanWariaiShoRenchoTateOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040.FutanWariaiShoRenchoYokoOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040.RiyoshaFutanWariaiShoInsertProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040.ShoriDateKanriUpdateProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.futanwariaishohakko.DBC180040_FutanwariaishoHakkoParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.futanwariaishohakko.FutanwariaishoHakkoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko.IFutanwariaishoHakkoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK3001_負担割合証発行（一括）のバッチ処理フロー
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class DBC180040_FutanwariaishoHakkoFlow extends BatchFlowBase<DBC180040_FutanwariaishoHakkoParameter> {

    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_3 = new RString("3");
    private static final RString 定数_全件用紙タイプ = new RString("全件用紙タイプ");
    private static final RString 定数_異動認定分用紙タイプ = new RString("異動、認定分用紙タイプ");
    private IFutanwariaishoHakkoMapper mapper;
    private RDateTime バッチ起動時処理日時;

    private static final String 利用者負担割合期間 = "FutanWariaiInsertProcess";
    private static final String 負担割合証 = "FutanWariaiShoOutputProcess";
    private static final String 負担割合証連帳縦 = "FutanWariaiShoRenchoTateOutputProcess";
    private static final String 負担割合証連帳横 = "FutanWariaiShoRenchoYokoOutputProcess";
    private static final String 負担割合証発行一覧表 = "FutanWariaiShoHakkoIchiranOutputProcess";
    private static final String 処理日付管理 = "ShoriDateKanriUpdateProcess";
    private static final String 利用者負担割合証 = "RiyoshaFutanWariaiShoInsertProcess";

    @Override
    protected void defineFlow() {
        バッチ起動時処理日時 = RDate.getNowDateTime();
        RString type = getType();
        executeStep(利用者負担割合期間);
        executeStep(利用者負担割合証);
        if (定数_1.equals(type)) {
            executeStep(負担割合証);
        } else if (定数_2.equals(type)) {
            executeStep(負担割合証連帳縦);
        } else if (定数_3.equals(type)) {
            executeStep(負担割合証連帳横);
        }
        executeStep(負担割合証発行一覧表);
        executeStep(処理日付管理);
    }

    /**
     * 利用者負担割合期間Insertです。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担割合期間)
    protected IBatchFlowCommand futanWariaiInsertProcess() {
        return loopBatch(FutanWariaiInsertProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 負担割合証出力です。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担割合証)
    protected IBatchFlowCommand futanWariaiShoOutputProcess() {
        return loopBatch(FutanWariaiShoOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 負担割合証連帳縦出力です。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担割合証連帳縦)
    protected IBatchFlowCommand futanWariaiShoRenchoTateOutputProcess() {
        return loopBatch(FutanWariaiShoRenchoTateOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 負担割合証連帳横出力です。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担割合証連帳横)
    protected IBatchFlowCommand futanWariaiShoRenchoYokoOutputProcess() {
        return loopBatch(FutanWariaiShoRenchoYokoOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 負担割合証発行一覧表出力です。
     *
     * @return IBatchFlowCommand
     */
    @Step(負担割合証発行一覧表)
    protected IBatchFlowCommand futanWariaiShoHakkoIchiranOutputProcess() {
        return loopBatch(FutanWariaiShoHakkoIchiranOutputProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 処理日付管理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(処理日付管理)
    protected IBatchFlowCommand shoriDateKanriUpdateProcess() {
        return loopBatch(ShoriDateKanriUpdateProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    /**
     * 処理日付管理です。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担割合証)
    protected IBatchFlowCommand riyoshaFutanWariaiShoInsertProcess() {
        return loopBatch(RiyoshaFutanWariaiShoInsertProcess.class)
                .arguments(getProcessParameter())
                .define();
    }

    private RString getType() {
        mapper = getMapper(IFutanwariaishoHakkoMapper.class);
        FutanwariaishoHakkoProcessParameter processParam = getProcessParameter();
        FutanwariaishoHakkoMybatisParameter param = processParam.toMybatisParameter();
        param.setサブ業務コード(SubGyomuCode.DBC介護給付.getColumnValue());
        param.set帳票分類ID(ReportIdDBC.DBC100065.getReportId().getColumnValue());
        param.set管理年度(FlexibleYear.MIN);
        if (定数_0.equals(getParameter().get出力対象())) {
            param.set項目名(定数_全件用紙タイプ);
        } else {
            param.set項目名(定数_異動認定分用紙タイプ);
        }
        DbT7067ChohyoSeigyoHanyoEntity 帳票制御汎用キー = mapper.select帳票制御汎用キー(param);
        return 帳票制御汎用キー.getKomokuValue();
    }

    private FutanwariaishoHakkoProcessParameter getProcessParameter() {
        FutanwariaishoHakkoProcessParameter param = new FutanwariaishoHakkoProcessParameter();
        param.set年度(getParameter().get年度());
        param.set交付年月日(getParameter().get交付年月日());
        param.set発行区分(getParameter().get発行区分());
        param.set出力対象(getParameter().get出力対象());
        param.set当初発行区分(getParameter().get当初発行区分());
        param.set抽出期間開始日時(getParameter().get抽出期間開始日時());
        param.set抽出期間終了日時(getParameter().get抽出期間終了日時());
        param.set出力順(getParameter().get出力順());
        param.setAtesakiKey(new AtesakiPSMSearchKeyBuilder(AtesakiGyomuHanteiKeyFactory.createInstace(
                GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付)).build());
        param.setSearchKey(new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).build());
        param.setバッチ起動時処理日時(バッチ起動時処理日時);
        return param;
    }

}
