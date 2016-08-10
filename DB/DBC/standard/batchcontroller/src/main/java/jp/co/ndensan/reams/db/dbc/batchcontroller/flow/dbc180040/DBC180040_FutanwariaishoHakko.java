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
import jp.co.ndensan.reams.db.dbc.definition.batchprm.futanwariaishohakko.FutanwariaishoHakkoBatchParameter;
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
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK3001_負担割合証発行（一括）のバッチ処理フロー
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class DBC180040_FutanwariaishoHakko extends BatchFlowBase<FutanwariaishoHakkoBatchParameter> {

    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString 全件用紙タイプ = new RString("全件用紙タイプ");
    private static final RString 異動認定分用紙タイプ = new RString("異動、認定分用紙タイプ");
    private IFutanwariaishoHakkoMapper mapper;

    private static final String 利用者負担割合期間 = "FutanWariaiInsertProcess";
    private static final String 負担割合証 = "FutanWariaiShoOutputProcess";
    private static final String 負担割合証連帳縦 = "FutanWariaiShoRenchoTateOutputProcess";
    private static final String 負担割合証連帳横 = "FutanWariaiShoRenchoYokoOutputProcess";
    private static final String 負担割合証発行一覧表 = "FutanWariaiShoHakkoIchiranOutputProcess";
    private static final String 処理日付管理 = "ShoriDateKanriUpdateProcess";
    private static final String 利用者負担割合証 = "RiyoshaFutanWariaiShoInsertProcess";

    @Override
    protected void defineFlow() {
        RString type = getType();
        executeStep(利用者負担割合期間);
        executeStep(利用者負担割合証);
        if (ONE.equals(type)) {
            executeStep(負担割合証);
        } else if (TWO.equals(type)) {
            executeStep(負担割合証連帳縦);
        } else if (THREE.equals(type)) {
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
    protected IBatchFlowCommand createReport1() {
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
    protected IBatchFlowCommand createReport2() {
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
    protected IBatchFlowCommand createReport3() {
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
    protected IBatchFlowCommand createReport4() {
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
    protected IBatchFlowCommand createReport5() {
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
    protected IBatchFlowCommand createReport6() {
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
    protected IBatchFlowCommand createReport7() {
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
        if (ZERO.equals(getParameter().get出力対象())) {
            param.set項目名(全件用紙タイプ);
        } else {
            param.set項目名(異動認定分用紙タイプ);
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
        param.setバッチ起動時処理日時(RDateTime.now());
        return param;
    }

}
