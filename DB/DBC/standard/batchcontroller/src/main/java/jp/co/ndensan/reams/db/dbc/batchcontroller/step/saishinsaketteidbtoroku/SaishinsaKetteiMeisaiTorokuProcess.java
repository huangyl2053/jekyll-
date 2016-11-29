/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.saishinsaketteidbtoroku;

import jp.co.ndensan.reams.db.dbc.definition.processprm.saishinsaketteidbtoroku.SaishinsaKetteiDBProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshainmasutatoroku.SaiShinsaKetteiMeisaiTempEntity;
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
public class SaishinsaKetteiMeisaiTorokuProcess extends BatchProcessBase<SaiShinsaKetteiMeisaiTempEntity> {

    private SaishinsaKetteiDBProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "saishinsaketteihokenshainmasutatoroku.ISaishinsaKetteiHokenshaInMasutaTorokuMapper.getSaiShinsaKetteiMeisaiTempTBLData");

    @BatchWriter
    private BatchPermanentTableWriter 再審査決定明細TBLtableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        再審査決定明細TBLtableWriter = new BatchPermanentTableWriter(DbT3064SaishinsaKetteiMeisaiEntity.class);
    }

    @Override
    protected void process(SaiShinsaKetteiMeisaiTempEntity t) {
        DbT3064SaishinsaKetteiMeisaiEntity entity = get再審査決定明細(t, parameter.get保険者区分());
        再審査決定明細TBLtableWriter.insert(entity);
    }

    private DbT3064SaishinsaKetteiMeisaiEntity get再審査決定明細(SaiShinsaKetteiMeisaiTempEntity entity, RString 保険者区分) {
        DbT3064SaishinsaKetteiMeisaiEntity 再審査決定明細Entity = new DbT3064SaishinsaKetteiMeisaiEntity();
        再審査決定明細Entity.setToriatsukaiYM(entity.get取扱年月());
        再審査決定明細Entity.setHokenshaKubun(保険者区分);
        再審査決定明細Entity.setRirekiNo(entity.get履歴番号());
        再審査決定明細Entity.setJigyoshoNo(entity.get事業所番号());
        再審査決定明細Entity.setJigyoshoName(entity.get事業所名());
        再審査決定明細Entity.setHiHokenshaNo(entity.get登録被保険者番号());
        再審査決定明細Entity.setKohiJukyushaNo(entity.get公費受給者番号());
        再審査決定明細Entity.setShokisaiHokenshaNo(entity.get公費証記載保険者番号());
        再審査決定明細Entity.setServiceTeikyoYM(entity.getサービス提供年月());
        再審査決定明細Entity.setServiceShuruiCode(entity.getサービス種類コード());
        再審査決定明細Entity.setServiceShuruiName(entity.getサービス種類名());
        再審査決定明細Entity.setMoushitateJiyuCode(entity.get申立事由コード());
        再審査決定明細Entity.setMoushitateJiyu(entity.get申立事由());
        再審査決定明細Entity.setSaishinsaResultCode(entity.get再審査結果コード());
        再審査決定明細Entity.setToshoSeikyuTanisu(entity.get当初請求単位数());
        再審査決定明細Entity.setGenshinSeikyuTanisu(entity.get原審単位数());
        再審査決定明細Entity.setMoushitateTanisu(entity.get申立単位数());
        再審査決定明細Entity.setKetteiTanisu(entity.get決定単位数());
        再審査決定明細Entity.setChoseiTanisu(entity.get調整単位数());
        再審査決定明細Entity.setHokenshaFutangaku(entity.get保険者負担額());
        再審査決定明細Entity.setTorikomiYM(entity.get取込年月());

        return 再審査決定明細Entity;
    }
}
