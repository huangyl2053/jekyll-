/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuMeisaiItiziEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuShukeiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.TempSeikyuShukeiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010.IKaishuriyushoSeikyushoShinseishoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
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
public class ShukeiKanrendukeBangouUpdateProcess extends BatchProcessBase<SeikyuShukeiItiziDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get請求集計一時用データ");
    IKaishuriyushoSeikyushoShinseishoMapper mapper;
    @BatchWriter
    private BatchPermanentTableWriter<SeikyuMeisaiItiziEUCEntity> eucEntityWriter;
    private List<TempSeikyuShukeiItiziDataEntity> tempEntityList;

    @Override

    protected void initialize() {
        mapper = getMapper(IKaishuriyushoSeikyushoShinseishoMapper.class);
        tempEntityList = mapper.get請求集計一時出力データ();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(SeikyuShukeiItiziDataEntity entity) {
        for (TempSeikyuShukeiItiziDataEntity tempEntity : tempEntityList) {
            if (entity.get証記載保険者番号().equals(tempEntity.get証記載保険者番号())
                    && entity.get介護住宅改修理由書作成事業者番号().equals(tempEntity.get介護住宅改修理由書作成事業者番号())) {
                SeikyuMeisaiItiziEUCEntity eucEntity = new SeikyuMeisaiItiziEUCEntity();
                eucEntity.set集計関連付け番号(tempEntity.get集計関連付け番号());
                eucEntityWriter.update(eucEntity);
            }
        }
    }
}
