/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.FukaCalculateSetaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.FukaCalculateTempEntity;
import jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka.CreatCalCulateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課計算中間一時テーブルに登録のクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class InsSetaiTempProcess extends BatchProcessBase<FukaCalculateSetaiEntity> {

    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".honnsanteifuka.IHonnSanteiFukaMapper.select世帯員");
    private static final RString 賦課計算中間_NAME = new RString("FukaCalculateTemp");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;
    private FukaCalculateTempEntity 賦課計算中間Entity;
    private CreatCalCulateEntity manager;
    private TsuchishoNo 通知書番号 = TsuchishoNo.EMPTY;
    private FlexibleYear 賦課年度 = FlexibleYear.EMPTY;
    private FlexibleYear 調定年度 = FlexibleYear.EMPTY;
    private HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
    private int index;

    @Override
    public void initialize() {
        index = 1;
        manager = CreatCalCulateEntity.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTPATH);
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(賦課計算中間_NAME, FukaCalculateTempEntity.class);
    }

    @Override
    protected void process(FukaCalculateSetaiEntity entity) {
        if (通知書番号.equals(entity.getTsuchishoNo())
                && 賦課年度.equals(entity.getFukaNendo())
                && 調定年度.equals(entity.getChoteiNendo())
                && 被保険者番号.equals(entity.get賦課計算中間Entity().getHonSanJon_hihokenshaNo())) {
            賦課計算中間Entity = manager.creat世帯員所得情報Entity(賦課計算中間Entity, entity.get世帯員Entity(), index);
            set区分Key(entity);
        } else {
            if (賦課計算中間Entity != null) {
                tableWriter.update(賦課計算中間Entity);
            }
            index = 1;
            賦課計算中間Entity = entity.get賦課計算中間Entity();
            賦課計算中間Entity = manager.creat世帯員所得情報Entity(賦課計算中間Entity, entity.get世帯員Entity(), index);
            set区分Key(entity);
        }
        index++;
    }

    @Override
    protected void afterExecute() {
        if (賦課計算中間Entity != null) {
            tableWriter.update(賦課計算中間Entity);
        }
    }

    private void set区分Key(FukaCalculateSetaiEntity entity) {
        通知書番号 = entity.getTsuchishoNo();
        賦課年度 = entity.getFukaNendo();
        調定年度 = entity.getChoteiNendo();
        被保険者番号 = entity.get賦課計算中間Entity().getHonSanJon_hihokenshaNo();
    }

}
