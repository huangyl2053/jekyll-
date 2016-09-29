/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 処理に必要な項目を持っていないデータを削除する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class DataDeleteProcess extends BatchProcessBase<ShikyugakuCalcTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get削除するデータ");
    private static final RString TABLE_NAME = new RString("ShikyugakuCalcTemp");
    private static final RString 区分1 = new RString("1");
    private static final RString 区分3 = new RString("3");
    private static final RString 区分4 = new RString("4");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    private ShikyugakuCalcTempEntity 既存;
    private boolean isFirst;
    private boolean hasKubun3;
    private boolean hasKubun4;

    @Override
    protected void initialize() {
        isFirst = true;
        hasKubun3 = false;
        hasKubun4 = false;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuCalcTempEntity.class);
    }

    @Override
    protected void process(ShikyugakuCalcTempEntity entity) {
        if (isFirst && 区分1.equals(entity.getKubun())) {
            entity.setState(EntityDataState.Deleted);
            tempDbWriter.delete(entity);
            isFirst = false;
            return;
        }
        if (既存 == null) {
            既存 = entity;
            区分の判断(entity);
            return;
        }
        if (既存.getTaishoNendo().equals(entity.getTaishoNendo())
                && 既存.getShoKisaiHokenshaNo().equals(entity.getShoKisaiHokenshaNo())
                && 既存.getShikyuShinseishoSeiriNo().equals(entity.getShikyuShinseishoSeiriNo())
                && 既存.getHihokenshaNo().equals(entity.getHihokenshaNo())) {
            区分の判断(entity);
            if (hasKubun3 || hasKubun4) {
                return;
            }
        }
        if (区分1.equals(entity.getKubun())) {
            entity.setState(EntityDataState.Deleted);
            tempDbWriter.delete(entity);
        }
        既存 = entity;
        区分の判断(entity);
    }

    private void 区分の判断(ShikyugakuCalcTempEntity entity) {
        if (区分3.equals(entity.getKubun())) {
            hasKubun3 = true;
        } else if (区分4.equals(entity.getKubun())) {
            hasKubun4 = true;
        }
    }
}
