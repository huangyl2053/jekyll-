/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonBusiness;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.HihokenshaNoFukaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonTempTableEntity;
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
public class KakobunJissekiKihonProcess4 extends BatchProcessBase<HihokenshaNoFukaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper.get世帯情報取得");
    private static final RString 宛名データ抽出 = new RString("Tempkeisantaisyo");
    private KakobunJissekiKihonBusiness business;
    private KogakuKaigoTaishoshaChushutsuSokyubun sokyubun;
    private Map<RString, List<HihokenshaNoFukaEntity>> maplist;
    private static final RString 更新 = new RString("更新");
    private static final RString 追加 = new RString("追加");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tempTable;

    @Override
    protected void initialize() {
        maplist = new HashMap<>();
        business = new KakobunJissekiKihonBusiness();
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
        List<HihokenshaNoFukaEntity> hihokenshalist;
        List<HihokenshaNoFukaEntity> hihokousinlist;
        maplist = sokyubun.getKakobunJissekiKihon4(business.getHihokensha());
        hihokenshalist = maplist.get(更新);
        hihokousinlist = maplist.get(追加);
        for (HihokenshaNoFukaEntity entity : hihokousinlist) {
            tempTable.insert(business.setprocess4(entity));
        }

        for (HihokenshaNoFukaEntity upentity : hihokenshalist) {
            tempTable.update(business.setprocess4(upentity));
        }
    }
}
