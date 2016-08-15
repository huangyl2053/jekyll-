 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb901002;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.nendokirikae.NendoKirikaeMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nendokirikae.NendoKirikaeProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタ更新processのクラスです。
 *
 * @reamsid_L DBB-5722-030 xuhao
 */
public class UpdateDbT7022ShoriDateKanriProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private NendoKirikaeProcessParameter processParameter;
    private NendoKirikaeMybatisParameter parameter;
    private static final int INT_1 = 1;

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.nendokirikae."
            + "INendoKirikaeMapper.select処理日付管理マスタ更新");

    @BatchWriter
    private BatchPermanentTableWriter writer;

    @Override
    protected void initialize() {
        super.initialize();
        parameter = new NendoKirikaeMybatisParameter();
        parameter.set調定年度(processParameter.get調定年度().plusYear(INT_1));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter);
    }

    @Override
    protected void createWriter() {
        writer = new BatchPermanentTableWriter(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity entity) {
        entity.setKijunYMD(FlexibleDate.getNowDate());
        entity.setKijunTimestamp(YMDHMS.now());
        writer.update(entity);
    }
}
