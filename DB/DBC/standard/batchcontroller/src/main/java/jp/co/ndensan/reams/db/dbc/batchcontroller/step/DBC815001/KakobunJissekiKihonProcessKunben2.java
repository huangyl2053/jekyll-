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
    private final RString 処理区分 = new RString("2");
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
        List<HihokenshaNoFukaEntity> hihokenlist = sokyubun.getKakobunJissekiKihon6(処理区分, business.getHihokensha());
        for (HihokenshaNoFukaEntity entity : hihokenlist) {
            tempTable.insert(business.setprocess4(entity));
        }

    }
}
