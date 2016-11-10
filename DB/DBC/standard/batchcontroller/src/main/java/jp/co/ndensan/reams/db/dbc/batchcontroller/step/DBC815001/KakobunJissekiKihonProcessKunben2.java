/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.HihokenshaNoFukaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonTempTableEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoshaChushutsuSokyubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）のProcessです。
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class KakobunJissekiKihonProcessKunben2 extends BatchProcessBase<HihokenshaNoFukaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper.get処理区分1");
    private KakobunJissekiKihonBusiness business;
    private KogakuKaigoTaishoshaChushutsuSokyubun sokyubun;
    private IKogakuKaigoTaishoshaChushutsuSokyubunMapper mapper;
    private static final RString 宛名データ抽出 = new RString("Tempkeisantaisyo");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempTable;

    @Override
    protected void initialize() {
        business = new KakobunJissekiKihonBusiness();
        mapper = getMapper(IKogakuKaigoTaishoshaChushutsuSokyubunMapper.class);
        sokyubun = KogakuKaigoTaishoshaChushutsuSokyubun.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);

    }

    @Override
    protected void createWriter() {
        tempTable = new BatchEntityCreatedTempTableWriter(宛名データ抽出,
                KakobunJissekiKihonTempTableEntity.class);
    }

    @Override
    protected void process(HihokenshaNoFukaEntity entity) {
        business.setHihokensha(entity);
    }

    @Override
    protected void afterExecute() {
        mapper.delete計算対象ファイル();
        List<HihokenshaNoFukaEntity> hihokenlist = sokyubun.getKakobunJissekiKihon6(new RString("2"), business.getHihokensha());
        for (HihokenshaNoFukaEntity entity : hihokenlist) {
            KakobunJissekiKihonTempTableEntity temoTableEntity = new KakobunJissekiKihonTempTableEntity();
            temoTableEntity.setShikibetsuCode(entity.get識別コード());
            temoTableEntity.setHihokenshaNo(entity.get被保険者番号());
            temoTableEntity.setShotsicode(entity.get世帯コード());
            temoTableEntity.setNendo(entity.get賦課年度());
            temoTableEntity.setNengetsu(entity.get年月());
            temoTableEntity.setNengetsuymd(entity.get年月日());
            temoTableEntity.setChusyutsumaster1(entity.get抽出_マスタ1());
            temoTableEntity.setChusyutsumaster2(entity.get抽出_マスタ2());
            temoTableEntity.setChusyutsumaster3(entity.get抽出_マスタ3());
            temoTableEntity.setChusyutsumaster4(entity.get抽出_マスタ4());
            temoTableEntity.setChusyutsumaster5(entity.get抽出_マスタ5());
            temoTableEntity.setChusyutsumaster6(entity.get抽出_マスタ6());
            temoTableEntity.setChusyutsumaster7(entity.get抽出_マスタ7());
            temoTableEntity.setChusyutsumaster8(entity.get抽出_マスタ8());
            temoTableEntity.setChusyutsumaster9(entity.get抽出_マスタ9());
            temoTableEntity.setChusyutsumaster10(entity.get抽出_マスタ10());
            temoTableEntity.setChusyutsujiyu1(entity.get抽出_事由1());
            temoTableEntity.setChusyutsujiyu2(entity.get抽出_事由2());
            temoTableEntity.setChusyutsujiyu3(entity.get抽出_事由3());
            temoTableEntity.setChusyutsujiyu4(entity.get抽出_事由4());
            temoTableEntity.setChusyutsujiyu5(entity.get抽出_事由5());
            temoTableEntity.setChusyutsujiyu6(entity.get抽出_事由6());
            temoTableEntity.setChusyutsujiyu7(entity.get抽出_事由7());
            temoTableEntity.setChusyutsujiyu8(entity.get抽出_事由8());
            temoTableEntity.setChusyutsujiyu9(entity.get抽出_事由9());
            temoTableEntity.setChusyutsujiyu10(entity.get抽出_事由10());
            temoTableEntity.setChusyutsushikibetsu1(entity.get抽出_識別コード1());
            temoTableEntity.setChusyutsushikibetsu2(entity.get抽出_識別コード2());
            temoTableEntity.setChusyutsushikibetsu3(entity.get抽出_識別コード3());
            temoTableEntity.setChusyutsushikibetsu4(entity.get抽出_識別コード4());
            temoTableEntity.setChusyutsushikibetsu5(entity.get抽出_識別コード5());
            temoTableEntity.setChusyutsushikibetsu6(entity.get抽出_識別コード6());
            temoTableEntity.setChusyutsushikibetsu7(entity.get抽出_識別コード7());
            temoTableEntity.setChusyutsushikibetsu8(entity.get抽出_識別コード8());
            temoTableEntity.setChusyutsushikibetsu9(entity.get抽出_識別コード9());
            temoTableEntity.setChusyutsushikibetsu10(entity.get抽出_識別コード10());
            tempTable.insert(temoTableEntity);
        }

    }
}
