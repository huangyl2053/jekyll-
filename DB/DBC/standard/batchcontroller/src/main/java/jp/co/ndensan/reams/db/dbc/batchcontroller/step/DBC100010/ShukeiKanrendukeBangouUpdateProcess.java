/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuMeisaiItiziEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.TempSeikyuMeisaiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.TempSeikyuShukeiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010.IKaishuriyushoSeikyushoShinseishoMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
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
public class ShukeiKanrendukeBangouUpdateProcess extends BatchProcessBase<TempSeikyuMeisaiItiziDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get請求明細集計関連番号データ");
    IKaishuriyushoSeikyushoShinseishoMapper mapper;
    private List<TempSeikyuShukeiItiziDataEntity> tempEntityList;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 請求明細一時ファイルB;

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
    protected void createWriter() {
        請求明細一時ファイルB = new BatchEntityCreatedTempTableWriter(SeikyuMeisaiItiziEUCEntity.TABLE_NAME,
                SeikyuMeisaiItiziEUCEntity.class);
    }

    @Override
    protected void process(TempSeikyuMeisaiItiziDataEntity entity) {
        for (TempSeikyuShukeiItiziDataEntity tempEntity : tempEntityList) {
            if (entity.get証記載保険者番号() != null
                    && entity.get介護住宅改修理由書作成事業者番号() != null
                    && entity.get証記載保険者番号().equals(tempEntity.get証記載保険者番号())
                    && entity.get介護住宅改修理由書作成事業者番号().equals(tempEntity.get介護住宅改修理由書作成事業者番号())) {
                SeikyuMeisaiItiziEUCEntity eucEntity = new SeikyuMeisaiItiziEUCEntity();
                eucEntity.set証記載保険者番号(entity.get証記載保険者番号());
                eucEntity.set被保険者番号(entity.get被保険者番号());
                eucEntity.set履歴番号(entity.get履歴番号());
                eucEntity.setサービスコード(entity.getサービスコード());
                eucEntity.set介護住宅改修事業者名称(entity.get介護住宅改修事業者名称());
                eucEntity.set介護住宅改修着工年月日(entity.get介護住宅改修着工年月日());
                eucEntity.set介護住宅改修住宅所有者(entity.get介護住宅改修住宅所有者());
                eucEntity.set改修対象住宅住所(entity.get改修対象住宅住所());
                eucEntity.set改修内容箇所及び規模(entity.get改修内容箇所及び規模());
                eucEntity.set介護住宅改修理由書作成年月日(entity.get介護住宅改修理由書作成年月日());
                eucEntity.set介護住宅改修理由書作成事業者番号(entity.get介護住宅改修理由書作成事業者番号());
                eucEntity.set介護住宅改修理由書作成者名(entity.get介護住宅改修理由書作成者名());
                eucEntity.set介護住宅改修理由書作成者名カナ(entity.get介護住宅改修理由書作成者名カナ());
                eucEntity.set介護住宅改修理由書作成申請年月日(entity.get介護住宅改修理由書作成申請年月日());
                eucEntity.set介護住宅改修理由書作成受付年月日(entity.get介護住宅改修理由書作成受付年月日());
                eucEntity.set集計関連付け番号(tempEntity.get集計関連番号());
                eucEntity.set対象外フラグ(entity.is対象外フラグ());
                請求明細一時ファイルB.update(eucEntity);
            }
        }
    }
}
