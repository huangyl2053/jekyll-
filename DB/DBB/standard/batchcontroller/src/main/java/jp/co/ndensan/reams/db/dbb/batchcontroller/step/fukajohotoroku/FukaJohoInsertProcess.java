package jp.co.ndensan.reams.db.dbb.batchcontroller.step.fukajohotoroku;

import jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.FukaJohoTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.shunokamoku.ShunoKamokuManager;
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
        DbT2003KibetsuEntity dbt2003 = new DbT2003KibetsuEntity();
        DbT2002FukaJohoTempTableEntity 賦課情報一時Entity = entity.get賦課情報一時Entity();
        dbt2003.setChoteiNendo(賦課情報一時Entity.getChoteiNendo());
        dbt2003.setFukaNendo(賦課情報一時Entity.getFukaNendo());
        dbt2003.setTsuchishoNo(賦課情報一時Entity.getTsuchishoNo());
        dbt2003.setRirekiNo(賦課情報一時Entity.getRirekiNo());
        dbt2003.setChoshuHouhou(get徴収方法(entity));
        dbt2003.setKi(entity.get期());
        dbt2003.setChoteiId(entity.get調定ID());
        dbT2003Writer.insert(dbt2003);
    }

    private RString get徴収方法(FukaJohoTorokuRelateEntity entity) {
        ShunoKamokuManager manager = new ShunoKamokuManager();
        RString 徴収方法 = RString.EMPTY;
        //TODO 内部QA1133　科目コードが取得できない
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
        DbT2002FukaEntity dbT2002 = new DbT2002FukaEntity();
        dbT2002.setChoteiNendo(entity.getChoteiNendo());
        dbT2002.setFukaNendo(entity.getFukaNendo());
        dbT2002.setTsuchishoNo(entity.getTsuchishoNo());
        dbT2002.setRirekiNo(entity.getRirekiNo());
        dbT2002.setHihokenshaNo(entity.getHihokenshaNo());
        dbT2002.setShikibetsuCode(entity.getShikibetsuCode());
        dbT2002.setSetaiCode(entity.getSetaiCode());
        dbT2002.setSetaiInsu(entity.getSetaiInsu());
        dbT2002.setShikakuShutokuYMD(entity.getShikakuShutokuYMD());
        dbT2002.setShikakuShutokuJiyu(entity.getShikakuShutokuJiyu());
        dbT2002.setShikakuSoshitsuYMD(entity.getShikakuSoshitsuYMD());
        dbT2002.setShikakuSoshitsuJiyu(entity.getShikakuSoshitsuJiyu());
        dbT2002.setSeihofujoShurui(entity.getSeihofujoShurui());
        dbT2002.setSeihoKaishiYMD(entity.getSeihoKaishiYMD());
        dbT2002.setSeihoHaishiYMD(entity.getSeihoHaishiYMD());
        dbT2002.setRonenKaishiYMD(entity.getRonenKaishiYMD());
        dbT2002.setRonenHaishiYMD(entity.getRonenHaishiYMD());
        dbT2002.setFukaYMD(entity.getFukaYMD());
        dbT2002.setKazeiKubun(entity.getKazeiKubun());
        dbT2002.setSetaikazeiKubun(entity.getSetaikazeiKubun());
        dbT2002.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        dbT2002.setNenkinShunyuGaku(entity.getNenkinShunyuGaku());
        dbT2002.setHokenryoDankai(entity.getHokenryoDankai());
        dbT2002.setHokenryoDankai1(entity.getHokenryoDankai1());
        dbT2002.setNengakuHokenryo1(entity.getNengakuHokenryo1());
        dbT2002.setTsukiwariStartYM1(entity.getTsukiwariStartYM1());
        dbT2002.setTsukiwariEndYM1(entity.getTsukiwariEndYM1());
        dbT2002.setHokenryoDankai2(entity.getHokenryoDankai2());
        dbT2002.setNengakuHokenryo2(entity.getNengakuHokenryo2());
        dbT2002.setTsukiwariStartYM2(entity.getTsukiwariStartYM2());
        dbT2002.setTsukiwariEndYM2(entity.getTsukiwariEndYM2());
        dbT2002.setChoteiNichiji(entity.getChoteiNichiji());
        dbT2002.setChoteiJiyu1(entity.getChoteiJiyu1());
        dbT2002.setChoteiJiyu2(entity.getChoteiJiyu2());
        dbT2002.setChoteiJiyu3(entity.getChoteiJiyu3());
        dbT2002.setChoteiJiyu4(entity.getChoteiJiyu4());
        dbT2002.setKoseiM(entity.getKoseiM());
        dbT2002.setGemmenMaeHokenryo(entity.getGemmenMaeHokenryo());
        dbT2002.setGemmenGaku(entity.getGemmenGaku());
        dbT2002.setKakuteiHokenryo(entity.getKakuteiHokenryo());
        dbT2002.setHokenryoDankaiKarisanntei(entity.getHokenryoDankaiKarisanntei());
        dbT2002.setChoshuHohoRirekiNo(entity.getChoshuHohoRirekiNo());
        dbT2002.setIdoKijunNichiji(entity.getIdoKijunNichiji());
        dbT2002.setKozaKubun(entity.getKozaKubun());
        dbT2002.setKyokaisoKubun(entity.getKyokaisoKubun());
        dbT2002.setShokkenKubun(entity.getShokkenKubun());
        dbT2002.setFukaShichosonCode(entity.getFukaShichosonCode());
        dbT2002.setTkSaishutsuKampuGaku(entity.getTkSaishutsuKampuGaku());
        dbT2002.setFuSaishutsuKampuGaku(entity.getFuSaishutsuKampuGaku());
        dbT2002Writer.insert(dbT2002);
    }
}
