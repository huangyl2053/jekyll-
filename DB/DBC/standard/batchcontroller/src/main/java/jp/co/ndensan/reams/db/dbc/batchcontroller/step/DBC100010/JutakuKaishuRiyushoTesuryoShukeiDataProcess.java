/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.TempSeikyuShukeiItiziDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 *
 */
public class JutakuKaishuRiyushoTesuryoShukeiDataProcess extends BatchProcessBase<TempSeikyuShukeiItiziDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get請求集計一時出力データ");
    @BatchWriter
    private BatchPermanentTableWriter<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> dbT3096EntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        dbT3096EntityWriter = new BatchPermanentTableWriter(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class);
    }

    @Override
    protected void process(TempSeikyuShukeiItiziDataEntity entity) {
        DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity dbt3096Entity = new DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
        dbt3096Entity.setShoKisaiHokenshaNo(shoKisaiHokenshaNoTohokenshaNo(entity.get証記載保険者番号()));
        dbt3096Entity.setRiyushoSakuseiJigyoshaNo(entity.get介護住宅改修理由書作成事業者番号());
        dbt3096Entity.setShukeiNo(entity.get集計関連付け番号());
        dbt3096Entity.setRirekiNo(entity.get履歴番号());
        dbt3096Entity.setShukeiKaishiYM(new FlexibleYearMonth(entity.get集計開始年月().toDateString()));
        dbt3096Entity.setShukeiShuryoYM(new FlexibleYearMonth(entity.get集計終了年月().toDateString()));
        dbt3096Entity.setRiyushoSakuseiKensu(new Decimal(entity.get介護住宅改修理由書作成件数()));
        dbt3096Entity.setRiyushoSakuseiTanka(entity.get介護住宅改修理由書作成単価());
        dbt3096Entity.setRiyushoSakuseiSeikyuKingaku(entity.get介護住宅改修理由書作成請求金額());
        dbT3096EntityWriter.insert(dbt3096Entity);
    }

    private HokenshaNo shoKisaiHokenshaNoTohokenshaNo(ShoKisaiHokenshaNo date) {
        if (date == null) {
            return HokenshaNo.EMPTY;
        }
        return new HokenshaNo(date.value());
    }
}
