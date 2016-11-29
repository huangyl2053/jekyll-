/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.saishinsaketteidbtoroku;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteidbtoroku.SaishinsaKetteiDBProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.SaiShinsaKetteiShukeiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * マスタ登録を実行する。
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
public class SaishinsaKetteiShukeiTorokuProcess extends BatchProcessBase<SaiShinsaKetteiShukeiTempEntity> {

    private SaishinsaKetteiDBProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsaketteihokenshainmasutatoroku.ISaishinsaKetteiHokenshaInMasutaTorokuMapper.getSaiShinsaKetteiShukeiTempTBLData");


    @BatchWriter
    private BatchPermanentTableWriter 再審査決定集計TBLtableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        再審査決定集計TBLtableWriter = new BatchPermanentTableWriter(DbT3063SaishinsaKetteiShukeiEntity.class);
    }

    @Override
    protected void process(SaiShinsaKetteiShukeiTempEntity t) {
        DbT3063SaishinsaKetteiShukeiEntity entity = get再審査決定集計(t, parameter.get保険者区分());
        再審査決定集計TBLtableWriter.insert(entity);
    }

    private DbT3063SaishinsaKetteiShukeiEntity get再審査決定集計(SaiShinsaKetteiShukeiTempEntity entity, RString 保険者区分) {
        DbT3063SaishinsaKetteiShukeiEntity 再審査決定集計Entity = new DbT3063SaishinsaKetteiShukeiEntity();
        再審査決定集計Entity.setToriatsukaiYM(entity.get取扱年月());
        再審査決定集計Entity.setHokenshaKubun(保険者区分);
        再審査決定集計Entity.setRirekiNo(entity.get履歴番号());
        再審査決定集計Entity.setKaigoKyufuhiSeikyuKensu(entity.get介護給付費_請求_件数());
        再審査決定集計Entity.setKaigoKyufuhiSeikyuTanisu(entity.get介護給付費_請求_単位数());
        再審査決定集計Entity.setKaigoKyufuhiSeikyuFutangaku(entity.get介護給付費_請求_保険者負担額());
        再審査決定集計Entity.setKaigoKyufuhiKetteiKensu(entity.get介護給付費_決定_件数());
        再審査決定集計Entity.setKaigoKyufuhiKetteiTanisu(entity.get介護給付費_決定_単位数());
        再審査決定集計Entity.setKaigoKyufuhiKetteiFutangaku(entity.get介護給付費_決定_保険者負担額());
        再審査決定集計Entity.setKaigoKyufuhiChoseiKensu(entity.get介護給付費_調整_件数());
        再審査決定集計Entity.setKaigoKyufuhiChoseiTanisu(entity.get介護給付費_調整_単位数());
        再審査決定集計Entity.setKaigoKyufuhiChoseiFutangaku(entity.get介護給付費_調整_保険者負担額());
        再審査決定集計Entity.setKogakuKaigoServicehiSeikyuKensu(entity.get高額介護サービス費_請求_件数());
        再審査決定集計Entity.setKogakuKaigoServicehiSeikyuTanisu(entity.get高額介護サービス費_請求_単位数());
        再審査決定集計Entity.setKogakuKaigoServicehiSeikyuFutangaku(entity.get高額介護サービス費_請求_保険者負担額());
        再審査決定集計Entity.setKogakuKaigoServicehiKetteiKensu(entity.get高額介護サービス費_決定_件数());
        再審査決定集計Entity.setKogakuKaigoServicehiKetteiTanisu(entity.get高額介護サービス費_決定_単位数());
        再審査決定集計Entity.setKogakuKaigoServicehiKetteiFutangaku(entity.get高額介護サービス費_決定_保険者負担額());
        再審査決定集計Entity.setKogakuKaigoServicehiChoseiKensu(entity.get介護給付費_調整_件数());
        再審査決定集計Entity.setKogakuKaigoServicehiChoseiTanisu(entity.get高額介護サービス費_調整_単位数());
        再審査決定集計Entity.setKogakuKaigoServicehiChoseiFutangaku(entity.get高額介護サービス費_調整_保険者負担額());
        再審査決定集計Entity.setKohiFutanshaNo(entity.get証記載保険者番号());
        再審査決定集計Entity.setSakuseiYMD(entity.get作成年月日());
        再審査決定集計Entity.setSinsaiinkaiName(entity.get審査委員会名());
        再審査決定集計Entity.setTorikomiYM(entity.get取込年月());
        return 再審査決定集計Entity;
    }
}
