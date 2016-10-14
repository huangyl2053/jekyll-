/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100010.KaishuriyushoSeikyushoShinseishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuShukeiItiziDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.SeikyuShukeiItiziEUCEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010.IKaishuriyushoSeikyushoShinseishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 *
 */
public class TempSeikyuShukeiItiziDataProcess extends BatchProcessBase<SeikyuShukeiItiziDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get請求集計一時データ");
    private KaishuriyushoSeikyushoShinseishoProcessParameter processParameter;
    IKaishuriyushoSeikyushoShinseishoMapper mapper;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 請求集計一時ファイルB;
    private int 採番件数;
    private RString 集計関連付け番号;

    @Override
    protected void initialize() {
        mapper = getMapper(IKaishuriyushoSeikyushoShinseishoMapper.class);
        採番件数 = mapper.select採番件数();
        集計関連付け番号 = Saiban.get(SubGyomuCode.DBC介護給付, RString.EMPTY, 採番件数).nextString();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        請求集計一時ファイルB = new BatchEntityCreatedTempTableWriter(SeikyuShukeiItiziEUCEntity.TABLE_NAME,
                SeikyuShukeiItiziEUCEntity.class);
    }

    @Override
    protected void process(SeikyuShukeiItiziDataEntity entity) {
        SeikyuShukeiItiziEUCEntity eucEntity = new SeikyuShukeiItiziEUCEntity();
        eucEntity.set証記載保険者番号(entity.get証記載保険者番号());
        eucEntity.set介護住宅改修理由書作成事業者番号(entity.get介護住宅改修理由書作成事業者番号());
        eucEntity.set集計関連付け番号(集計関連付け番号);
        eucEntity.set履歴番号(1);
        eucEntity.set集計開始年月(processParameter.get作成申請年月日開始());
        eucEntity.set集計終了年月(processParameter.get作成申請年月日終了());
        eucEntity.set介護住宅改修理由書作成件数(entity.get件数());
        RString 単価 = DbBusinessConfig.get(ConfigNameDBC.介護住宅改修理由書作成単価, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        eucEntity.set介護住宅改修理由書作成単価(new Decimal(単価.toString()));
        eucEntity.set介護住宅改修理由書作成請求金額(eucEntity.get介護住宅改修理由書作成単価().multiply(eucEntity.get介護住宅改修理由書作成件数()));
        請求集計一時ファイルB.insert(eucEntity);
    }
}
