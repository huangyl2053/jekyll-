/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.InsKokuhoShikakuJyohoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.InsKokuhoShikakuJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.InsTorikomiKokuhoJyohoTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.KokuhoCsvFyiiruSyutuRyokuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.UpdShoriDateKanriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.UpdTorikomiKokuhoJyohoTemp2Process;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010.UpdTorikomiKokuhoJyohoTemp3Process;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc130010.DBC130010_KokuhoShikakuIdoInParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.InsKokuhoShikakuJyohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.InsKokuhoShikakuJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.InsTorikomiKokuhoJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.UpdShoriDateKanriProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.UpdTorikomiKokuhoJyohoTemp2ProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.UpdTorikomiKokuhoJyohoTemp3ProcessParameter;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class DBC130010_KokuhoShikakuIdoIn extends BatchFlowBase<DBC130010_KokuhoShikakuIdoInParameter> {

    private IKokuhoShikakuIdoInMapper mapper;
    private RString 市町村識別ID;

    private static final String INS_TORIKOMIKOKUHOJYOHOTEMP = "InsTorikomiKokuhoJyohoTempProcess";
    private static final String UPD_TORIKOMIKOKUHOJYOHOTEMP2 = "UpdTorikomiKokuhoJyohoTemp2Process";
    private static final String UPD_TORIKOMIKOKUHOJYOHOTEMP3 = "UpdTorikomiKokuhoJyohoTemp3Process";
    private static final String INS_KOKUHOSHIKAKUJYOHOTEMP = "InsKokuhoShikakuJyohoTempProcess";
    private static final String INS_KOKUHOSHIKAKUJYOHO = "InsKokuhoShikakuJyohoProcess";
    private static final String UPD_SHORIDATEKANRI = "UpdShoriDateKanriProcess";
    private static final String CREATE_CSVFILE = "CreateCsvFileProcess";

    @Override
    protected void initialize() {
        mapper = getMapper(IKokuhoShikakuIdoInMapper.class);
        mapper.get宛名識別コードリスト();
        市町村識別ID = RString.EMPTY;
    }

    @Override
    protected void defineFlow() {
        for (RString value : getParameter().getShoriShichoson()) {
            市町村識別ID = RString.EMPTY;
            市町村識別ID = value;
            executeStep(INS_TORIKOMIKOKUHOJYOHOTEMP);
        }
        executeStep(UPD_TORIKOMIKOKUHOJYOHOTEMP2);
        executeStep(UPD_TORIKOMIKOKUHOJYOHOTEMP3);
        executeStep(INS_KOKUHOSHIKAKUJYOHOTEMP);
        executeStep(INS_KOKUHOSHIKAKUJYOHO);
        executeStep(UPD_SHORIDATEKANRI);
        executeStep(CREATE_CSVFILE);
    }

    @Step(INS_TORIKOMIKOKUHOJYOHOTEMP)
    protected IBatchFlowCommand INS_TORIKOMIKOKUHOJYOHOTEMP() {
        return loopBatch(InsTorikomiKokuhoJyohoTempProcess.class)
                .arguments(getInsTorikomiKokuhoJyohoTempProcessParameter())
                .define();
    }

    @Step(UPD_TORIKOMIKOKUHOJYOHOTEMP2)
    protected IBatchFlowCommand UPD_TORIKOMIKOKUHOJYOHOTEMP2() {
        return loopBatch(UpdTorikomiKokuhoJyohoTemp2Process.class)
                .arguments(getUpdTorikomiKokuhoJyohoTemp2ProcessParameter())
                .define();
    }

    @Step(UPD_TORIKOMIKOKUHOJYOHOTEMP3)
    protected IBatchFlowCommand UPD_TORIKOMIKOKUHOJYOHOTEMP3() {
        return loopBatch(UpdTorikomiKokuhoJyohoTemp3Process.class)
                .arguments(getUpdTorikomiKokuhoJyohoTemp3ProcessParameter())
                .define();
    }

    @Step(INS_KOKUHOSHIKAKUJYOHOTEMP)
    protected IBatchFlowCommand INS_KOKUHOSHIKAKUJYOHOTEMP() {
        return loopBatch(InsKokuhoShikakuJyohoTempProcess.class)
                .arguments(getInsKokuhoShikakuJyohoTempProcessParameter())
                .define();
    }

    @Step(INS_KOKUHOSHIKAKUJYOHO)
    protected IBatchFlowCommand INS_KOKUHOSHIKAKUJYOHO() {
        return loopBatch(InsKokuhoShikakuJyohoProcess.class)
                .arguments(getInsKokuhoShikakuJyohoProcessParameter())
                .define();
    }

    @Step(UPD_SHORIDATEKANRI)
    protected IBatchFlowCommand UPD_SHORIDATEKANRI() {
        return simpleBatch(UpdShoriDateKanriProcess.class)
                .arguments(getUpdShoriDateKanriProcessParameter()).define();
    }

    @Step(CREATE_CSVFILE)
    protected IBatchFlowCommand CREATE_CSVFILE() {
        return loopBatch(KokuhoCsvFyiiruSyutuRyokuProcess.class).define();
    }

    private InsTorikomiKokuhoJyohoTempProcessParameter getInsTorikomiKokuhoJyohoTempProcessParameter() {
        return new InsTorikomiKokuhoJyohoTempProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                市町村識別ID,
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }

    private UpdTorikomiKokuhoJyohoTemp2ProcessParameter getUpdTorikomiKokuhoJyohoTemp2ProcessParameter() {
        return new UpdTorikomiKokuhoJyohoTemp2ProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                getParameter().getShoriShichoson(),
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }

    private UpdTorikomiKokuhoJyohoTemp3ProcessParameter getUpdTorikomiKokuhoJyohoTemp3ProcessParameter() {
        return new UpdTorikomiKokuhoJyohoTemp3ProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                getParameter().getShoriShichoson(),
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }

    private InsKokuhoShikakuJyohoTempProcessParameter getInsKokuhoShikakuJyohoTempProcessParameter() {
        return new InsKokuhoShikakuJyohoTempProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                getParameter().getShoriShichoson(),
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }

    private InsKokuhoShikakuJyohoProcessParameter getInsKokuhoShikakuJyohoProcessParameter() {
        return new InsKokuhoShikakuJyohoProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                getParameter().getShoriShichoson(),
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }

    private UpdShoriDateKanriProcessParameter getUpdShoriDateKanriProcessParameter() {
        return new UpdShoriDateKanriProcessParameter(getParameter().getInsurerDistinction(),
                getParameter().getTableName(),
                getParameter().getShoriShichoson(),
                getParameter().getIfType(),
                getParameter().getTorikomiKeishiki(),
                getParameter().getShoriTimestamp());
    }
}
