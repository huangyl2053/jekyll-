/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180020.DBC180020ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.RiyoshaFutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.RiyoshaFutanWariaiTempUnionEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiKonkyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.RiyoshaFutanWariaiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyoshafutanwariaihantei.RiyoshaFutanWariaiHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合判定マージのクラスです。<br/>
 * 処理詳細8
 *
 * @reamsid_L DBC-4950-030 liuyang
 */
public class FutanWariaiHanteiMergeProcess extends BatchKeyBreakBase<RiyoshaFutanWariaiTempUnionEntity> {

    private static final RString 明細TABLENAME = new RString("RiyoshaFutanWariaiMeisaiTemp");
    private static final RString 根拠TABLENAME = new RString("RiyoshaFutanWariaiKonkyoTemp");
    private static final RString LINE = new RString("|");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "riyoshafutanwariaihantei.IRiyoshaFutanwariaiMapper.select負担割合判定マージ");
    private DBC180020ProcessParameter parameter;
    private RiyoshaFutanWariaiHantei service;
    private HihokenshaNo beforeNo;
    private HihokenshaNo nowNo;
    private RString beforeKey;
    private FlexibleYear nendo;
    private List<RiyoshaFutanWariaiMeisaiTempEntity> 明細Entities;
    private List<RiyoshaFutanWariaiKonkyoTempEntity> 根拠Entities;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合明細Temp;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter 利用者負担割合根拠Temp;

    @Override
    protected void initialize() {
        beforeKey = RString.EMPTY;
        service = RiyoshaFutanWariaiHantei.createInstance();
        nendo = new FlexibleYear(parameter.getTaishoNendo().toDateString());
        明細Entities = new ArrayList<>();
        根拠Entities = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        利用者負担割合明細Temp
                = new BatchEntityCreatedTempTableWriter(明細TABLENAME, RiyoshaFutanWariaiMeisaiTempEntity.class);
        利用者負担割合根拠Temp
                = new BatchEntityCreatedTempTableWriter(根拠TABLENAME, RiyoshaFutanWariaiKonkyoTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, parameter.toMyBatisParameter(RiyoshaFutanWariaiHantei.createInstance().
                getTaishoShuryobi(parameter.getTaishoNendo())));
    }

    @Override
    protected void usualProcess(RiyoshaFutanWariaiTempUnionEntity entity) {
        RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細 = entity.get利用者負担割合明細();
        RiyoshaFutanWariaiKonkyoTempEntity 利用者負担割合根拠 = entity.get利用者負担割合根拠();
        if (getBefore() == null) {
            addHandle(利用者負担割合明細, 利用者負担割合根拠);
            return;
        }
        beforeNo = getBefore().get利用者負担割合明細().getHihokenshaNo();
        nowNo = 利用者負担割合明細.getHihokenshaNo();
        if (beforeNo.equals(nowNo)) {
            addHandle(利用者負担割合明細, 利用者負担割合根拠);
            return;
        }
        insertHandle();
        明細Entities.clear();
        根拠Entities.clear();
        addHandle(利用者負担割合明細, 利用者負担割合根拠);
    }

    private void addHandle(RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細,
            RiyoshaFutanWariaiKonkyoTempEntity 利用者負担割合根拠) {
        RString nowKey = getKey(利用者負担割合明細);
        if (!beforeKey.equals(nowKey)) {
            明細Entities.add(利用者負担割合明細);
            beforeKey = nowKey;
        }
        if (利用者負担割合根拠 != null) {
            根拠Entities.add(利用者負担割合根拠);
        }
    }

    private void insertHandle() {
        RiyoshaFutanWariaiTempEntity mergeResult = service.futanWariaiHanteiMerge(明細Entities, 根拠Entities, nendo);
        List<RiyoshaFutanWariaiMeisaiTempEntity> meisaiResults = mergeResult.get利用者負担割合明細情報();
        for (RiyoshaFutanWariaiMeisaiTempEntity result : meisaiResults) {
            利用者負担割合明細Temp.insert(result);
        }
        List<RiyoshaFutanWariaiKonkyoTempEntity> konkyoResults = mergeResult.get利用者負担割合根拠情報();
        for (RiyoshaFutanWariaiKonkyoTempEntity result : konkyoResults) {
            利用者負担割合根拠Temp.insert(result);
        }
    }

    @Override
    protected void afterExecute() {
        if (明細Entities == null || 明細Entities.isEmpty()) {
            return;
        }
        insertHandle();
    }

    @Override
    protected void keyBreakProcess(RiyoshaFutanWariaiTempUnionEntity t) {
    }

    private RString getKey(RiyoshaFutanWariaiMeisaiTempEntity 利用者負担割合明細) {
        return 利用者負担割合明細.getHihokenshaNo().value().concat(LINE).concat(new RString(利用者負担割合明細.getEdaNo()));
    }
}
