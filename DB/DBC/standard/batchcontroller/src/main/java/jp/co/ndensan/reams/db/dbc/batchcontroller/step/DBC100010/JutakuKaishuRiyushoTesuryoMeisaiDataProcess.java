/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.TempSeikyuMeisaiItiziDataEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 *
 */
public class JutakuKaishuRiyushoTesuryoMeisaiDataProcess extends BatchProcessBase<TempSeikyuMeisaiItiziDataEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get請求明細一時出力データ");
    @BatchWriter
    private BatchPermanentTableWriter<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> dbT3095EntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        dbT3095EntityWriter = new BatchPermanentTableWriter(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity.class);
    }

    @Override
    protected void process(TempSeikyuMeisaiItiziDataEntity entity) {
        DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity dbt3095Entity = new DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
        dbt3095Entity.setShoKisaiHokenshaNo(shoKisaiHokenshaNoTohokenshaNo(entity.get証記載保険者番号()));
        dbt3095Entity.setHihokenshaNo(entity.get被保険者番号());
        dbt3095Entity.setRirekiNo(entity.get履歴番号());
        dbt3095Entity.setServiceCode(entity.getサービスコード());
        dbt3095Entity.setJutakuKaishuJigyoshaMeisho(new AtenaMeisho(entity.get介護住宅改修事業者名称()));
        dbt3095Entity.setJutakuKaishuChakkoYMD(entity.get介護住宅改修着工年月日());
        dbt3095Entity.setJutakuKaishuJushoShozaisha(new AtenaMeisho(entity.get介護住宅改修住宅所有者()));
        dbt3095Entity.setKaishuTaishoJutakuJusho(entity.get改修対象住宅住所());
        dbt3095Entity.setKaishuNaiyo_kasho_Kibo(entity.get改修内容箇所及び規模());
        dbt3095Entity.setRiyushoSakuseiYMD(entity.get介護住宅改修理由書作成年月日());
        dbt3095Entity.setRiyushoSakuseiJigyoshaNo(entity.get介護住宅改修理由書作成事業者番号());
        dbt3095Entity.setRiyushoSakuseishaMei(new AtenaMeisho(entity.get介護住宅改修理由書作成者名()));
        dbt3095Entity.setRiyushoSakuseishaMeiKana(entity.get介護住宅改修理由書作成者名カナ());
        dbt3095Entity.setRiyushoSakuseiShinseiYMD(entity.get介護住宅改修理由書作成申請年月日());
        dbt3095Entity.setRiyushoSakuseiUketsukeYMD(entity.get介護住宅改修理由書作成受付年月日());
        dbt3095Entity.setShukeiNo(entity.get集計関連付け番号());
        dbt3095Entity.setTaishogaiFlag(entity.is対象外フラグ());
        dbT3095EntityWriter.insert(dbt3095Entity);
    }

    private HokenshaNo shoKisaiHokenshaNoTohokenshaNo(ShoKisaiHokenshaNo date) {
        if (date == null) {
            return HokenshaNo.EMPTY;
        }
        return new HokenshaNo(date.value());
    }
}
