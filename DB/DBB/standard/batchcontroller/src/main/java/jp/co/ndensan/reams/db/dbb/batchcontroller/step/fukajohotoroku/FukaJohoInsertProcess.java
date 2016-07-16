package jp.co.ndensan.reams.db.dbb.batchcontroller.step.fukajohotoroku;

import jp.co.ndensan.reams.db.dbb.business.core.fukajohotoroku.FukaJohoInsertResult;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.FukaJohoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課の情報登録Processクラスです。
 *
 * @reamsid_L DBB-9040-080 duanzhanli
 */
public class FukaJohoInsertProcess extends BatchProcessBase<FukaJohoTorokuRelateEntity> {

    private static final RString 賦課情報 = new RString("jp.co.ndensan.reams.db.dbb.persistence."
            + "db.mapper.relate.fukajohotoroku.IFukaJohoTorokuMapper.get登録情報");
    private FlexibleYear fukaNendo = FlexibleYear.EMPTY;
    private TsuchishoNo tsuchishoNo = TsuchishoNo.EMPTY;
    private FlexibleYear choteiNendo = FlexibleYear.EMPTY;

    @BatchWriter
    BatchPermanentTableWriter<DbT2002FukaEntity> dbT2002Writer;
    @BatchWriter
    BatchPermanentTableWriter<DbT2003KibetsuEntity> dbT2003Writer;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(賦課情報);
    }

    @Override
    protected void createWriter() {
        dbT2002Writer = new BatchPermanentTableWriter(DbT2002FukaEntity.class);
        dbT2003Writer = new BatchPermanentTableWriter(DbT2003KibetsuEntity.class);
    }

    @Override
    protected void process(FukaJohoTorokuRelateEntity entity) {
        insert介護賦課(entity.get賦課情報一時Entity());
        insert介護期別(entity);

    }

    private void insert介護期別(FukaJohoTorokuRelateEntity entity) {
        DbT2003KibetsuEntity db2003entity = new FukaJohoInsertResult().getDbT2003Entity(entity);
        db2003entity.setChoshuHouhou(get徴収方法(entity));
        dbT2003Writer.insert(db2003entity);
    }

    private RString get徴収方法(FukaJohoTorokuRelateEntity entity) {
        ShunoKamokuFinder manager = ShunoKamokuFinder.createInstance();
        RString 徴収方法 = RString.EMPTY;
        if (manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収).getコード().value().contains(entity.get科目コード())) {
            徴収方法 = ChoshuHohoKibetsu.特別徴収.getコード();
        }
        if (manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収).getコード().value().contains(entity.get科目コード())) {
            徴収方法 = ChoshuHohoKibetsu.普通徴収.getコード();
        }
        return 徴収方法;
    }

    private void insert介護賦課(DbT2002FukaJohoTempTableEntity entity) {
        if (fukaNendo.equals(entity.getFukaNendo()) && tsuchishoNo.equals(entity.getTsuchishoNo())
                && choteiNendo.equals(entity.getChoteiNendo())) {
            return;
        }
        fukaNendo = entity.getFukaNendo();
        tsuchishoNo = entity.getTsuchishoNo();
        choteiNendo = entity.getChoteiNendo();
        dbT2002Writer.insert(new FukaJohoInsertResult().getDbT2002Entity(entity));
    }
}
