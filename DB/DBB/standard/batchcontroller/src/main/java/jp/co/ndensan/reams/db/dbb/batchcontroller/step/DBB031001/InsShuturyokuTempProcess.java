/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB031001;

import jp.co.ndensan.reams.db.dbb.definition.core.honnsanteifuka.ShuturyokuParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt4300.HonsanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.honnsanteifuka.ShuturyokuTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 出力順Tempに登録のクラスです。
 *
 * @reamsid_L DBB-0730-010 lijunjun
 */
public class InsShuturyokuTempProcess extends BatchProcessBase<DbT2015KeisangoJohoEntity> {

    private static final int NUM_0 = 0;
    private static final RString 徴収方法_特別徴収 = new RString("0");
    private static final RString 徴収方法_普通徴収 = new RString("1");
    private static final RString 徴収方法_併用徴収 = new RString("2");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate"
            + ".honnsanteifuka.IHonnSanteiFukaMapper.select出力順");
    private static final RString 出力順_NAME = new RString("ShuturyokuTemp");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter tableWriter;
    private HonsanteiFukaProcessParameter processParameter;
    private ShuturyokuParameter myBatisParameter;

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(出力順_NAME, ShuturyokuTempEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = new ShuturyokuParameter();
        myBatisParameter.set調定年度(processParameter.get調定年度());
        myBatisParameter.set賦課年度(processParameter.get賦課年度());
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void process(DbT2015KeisangoJohoEntity entity) {
        ShuturyokuTempEntity tempEntity = new ShuturyokuTempEntity();
        tempEntity.setTsuchishoNo(entity.getTsuchishoNo());
        RString 徴収方法 = editor徴収方法(entity);
        tempEntity.setChoshuHoho(徴収方法);
        tableWriter.insert(tempEntity);
    }

    private RString editor徴収方法(DbT2015KeisangoJohoEntity entity) {
        Decimal 特徴期別金額の合計 = check期別金額NULL(entity.getTkKibetsuGaku04())
                .add(check期別金額NULL(entity.getTkKibetsuGaku05()))
                .add(check期別金額NULL(entity.getTkKibetsuGaku06()));
        Decimal 普徴期期別金額合計 = check期別金額NULL(entity.getFuKibetsuGaku01()).add(check期別金額NULL(entity.getFuKibetsuGaku02()))
                .add(check期別金額NULL(entity.getFuKibetsuGaku03())).add(check期別金額NULL(entity.getFuKibetsuGaku04()))
                .add(check期別金額NULL(entity.getFuKibetsuGaku05())).add(check期別金額NULL(entity.getFuKibetsuGaku06()))
                .add(check期別金額NULL(entity.getFuKibetsuGaku07())).add(check期別金額NULL(entity.getFuKibetsuGaku08()))
                .add(check期別金額NULL(entity.getFuKibetsuGaku09())).add(check期別金額NULL(entity.getFuKibetsuGaku10()))
                .add(check期別金額NULL(entity.getFuKibetsuGaku11())).add(check期別金額NULL(entity.getFuKibetsuGaku12()))
                .add(check期別金額NULL(entity.getFuKibetsuGaku13())).add(check期別金額NULL(entity.getFuKibetsuGaku14()));
        if (特徴期別金額の合計.compareTo(Decimal.ZERO) == NUM_0
                && 普徴期期別金額合計.compareTo(Decimal.ZERO) == NUM_0) {
            return RString.EMPTY;
        } else if (Decimal.ONE.compareTo(特徴期別金額の合計) <= NUM_0
                && 普徴期期別金額合計.compareTo(Decimal.ZERO) == NUM_0) {
            return 徴収方法_特別徴収;
        } else if (特徴期別金額の合計.compareTo(Decimal.ZERO) == NUM_0
                && Decimal.ONE.compareTo(普徴期期別金額合計) <= NUM_0) {
            return 徴収方法_普通徴収;
        } else if (Decimal.ONE.compareTo(特徴期別金額の合計) <= NUM_0
                && Decimal.ONE.compareTo(普徴期期別金額合計) <= NUM_0) {
            return 徴収方法_併用徴収;
        } else {
            return RString.EMPTY;
        }
    }

    private Decimal check期別金額NULL(Decimal 期別金額) {
        if (期別金額 == null) {
            return Decimal.ZERO;
        }
        return 期別金額;
    }

}
