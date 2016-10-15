/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100010.KaishuriyushoSeikyushoShinseishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuMeisaiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuMeisaiItiziEUCEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 *
 */
public class SeikyuMeisaiItiziDataProcess extends BatchProcessBase<SeikyuMeisaiItiziDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get請求明細データ");
    private KaishuriyushoSeikyushoShinseishoProcessParameter processParameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> dbT3095EntityWriter;
    private BatchPermanentTableWriter<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> dbT3096EntityWriter;
    BatchEntityCreatedTempTableWriter 請求明細一時ファイルB;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaishuriyushoSeikyushoShinseishoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        dbT3095EntityWriter = new BatchPermanentTableWriter(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity.class);
        dbT3096EntityWriter = new BatchPermanentTableWriter(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class);
        請求明細一時ファイルB = new BatchEntityCreatedTempTableWriter(SeikyuMeisaiItiziEUCEntity.TABLE_NAME,
                SeikyuMeisaiItiziEUCEntity.class);
    }

    @Override
    protected void process(SeikyuMeisaiItiziDataEntity entity) {
        entity.getDbT3095().setIsDeleted(true);
        dbT3095EntityWriter.update(entity.getDbT3095());
        entity.getDbT3096().setIsDeleted(true);
        dbT3096EntityWriter.update(entity.getDbT3096());
        SeikyuMeisaiItiziEUCEntity eucEntity = new SeikyuMeisaiItiziEUCEntity();
        eucEntity.set証記載保険者番号(hokenshaNoToShoKisaiHokenshaNo(entity.getDbT3095().getShoKisaiHokenshaNo()));
        eucEntity.set被保険者番号(entity.getDbT3095().getHihokenshaNo());
        eucEntity.set履歴番号(entity.getDbT3095().getRirekiNo());
        eucEntity.setサービスコード(entity.getサービスコード());
        eucEntity.set介護住宅改修事業者名称(entity.get住宅改修事業者名());
        eucEntity.set介護住宅改修着工年月日(entity.get住宅改修着工年月日());
        eucEntity.set介護住宅改修住宅所有者(entity.get住宅所有者());
        eucEntity.set改修対象住宅住所(entity.get住宅改修住宅住所());
        eucEntity.set改修内容箇所及び規模(entity.get住宅改修内容());
        eucEntity.set介護住宅改修理由書作成年月日(entity.get理由書作成日());
        eucEntity.set介護住宅改修理由書作成事業者番号(entity.get理由書作成事業者番号());
        eucEntity.set介護住宅改修理由書作成者名(entity.get理由書作成者());
        eucEntity.set介護住宅改修理由書作成者名カナ(entity.get理由書作成者カナ());
        eucEntity.set介護住宅改修理由書作成申請年月日(entity.get申請年月日());
        eucEntity.set介護住宅改修理由書作成受付年月日(entity.get受付年月日());
        eucEntity.set集計関連付け番号(RString.EMPTY);
        eucEntity.set対象外フラグ(false);
        請求明細一時ファイルB.insert(eucEntity);
    }

    private ShoKisaiHokenshaNo hokenshaNoToShoKisaiHokenshaNo(HokenshaNo date) {
        if (date == null) {
            return ShoKisaiHokenshaNo.EMPTY;
        }
        return new ShoKisaiHokenshaNo(date.value());
    }
}
