package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB004001;

import jp.co.ndensan.reams.db.dbb.business.core.fukajohotoroku.FukaJohoInsertResult;
import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.FukaJohoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.kamoku.shunokamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

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
        insert介護賦課(entity);
        insert介護期別(entity);
    }

    private void insert介護期別(FukaJohoTorokuRelateEntity entity) {
        if (!is歳出還付(entity)) {
            DbT2003KibetsuEntity db2003entity = new FukaJohoInsertResult().getDbT2003Entity(entity);
            db2003entity.setChoshuHouhou(get徴収方法(entity));
            dbT2003Writer.insert(db2003entity);
        }
    }

    private boolean is歳出還付(FukaJohoTorokuRelateEntity entity) {
        return getRturn(entity)
                || Decimal.ZERO.compareTo(entity.getFuKibetsuGaku01()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku02()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku03()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku04()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku05()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku06()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku07()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku08()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku09()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku10()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku11()) == 0
                && Decimal.ZERO.compareTo(entity.getFuKibetsuGaku12()) == 0;
    }

    private static boolean getRturn(FukaJohoTorokuRelateEntity entity) {
        return entity.getFuKibetsuGaku01() == null
                && entity.getFuKibetsuGaku02() == null
                && entity.getFuKibetsuGaku03() == null
                && entity.getFuKibetsuGaku04() == null
                && entity.getFuKibetsuGaku05() == null
                && entity.getFuKibetsuGaku06() == null
                && entity.getFuKibetsuGaku07() == null
                && entity.getFuKibetsuGaku08() == null
                && entity.getFuKibetsuGaku09() == null
                && entity.getFuKibetsuGaku10() == null
                && entity.getFuKibetsuGaku11() == null
                && entity.getFuKibetsuGaku12() == null;
    }

    private RString get徴収方法(FukaJohoTorokuRelateEntity entity) {
        ShunoKamokuFinder manager = ShunoKamokuFinder.createInstance();
        RString 徴収方法 = RString.EMPTY;
        IShunoKamoku 科目_特別徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_特別徴収);
        if (entity.get科目コード() != null && 科目_特別徴収 != null
                && 科目_特別徴収.getコード().value().contains(entity.get科目コード().value())) {
            徴収方法 = ChoshuHohoKibetsu.特別徴収.getコード();
        }
        IShunoKamoku 科目_普通徴収 = manager.get科目(ShunoKamokuShubetsu.介護保険料_普通徴収);
        if (entity.get科目コード() != null && 科目_普通徴収 != null
                && 科目_普通徴収.getコード().value().contains(entity.get科目コード().value())) {
            徴収方法 = ChoshuHohoKibetsu.普通徴収.getコード();
        }
        return 徴収方法;
    }

    private void insert介護賦課(FukaJohoTorokuRelateEntity entity) {
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
