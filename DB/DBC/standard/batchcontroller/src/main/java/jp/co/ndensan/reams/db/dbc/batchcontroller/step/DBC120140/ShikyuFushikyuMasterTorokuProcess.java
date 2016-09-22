/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120140;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc120140.ShikyuFushikyuSaishoriJunbiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * マスタ登録です。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuMasterTorokuProcess extends BatchProcessBase<DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get高額合算支給不支給決定一時データ全件");
    private static final RString 発行フラグ = new RString("0");

    private ShikyuFushikyuSaishoriJunbiProcessParameter parameter;

    @BatchWriter
    private BatchPermanentTableWriter 高額合算支給不支給決定tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算支給不支給決定tableWriter
                = new BatchPermanentTableWriter(
                        DbT3074KogakuGassanShikyuFushikyuKetteiEntity.class);
    }

    @Override
    protected void process(DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity entity) {
        if (null == entity.get被保険者番号() || RString.isNullOrEmpty(entity.get対象年度())
                || null == entity.get保険者番号() || RString.isNullOrEmpty(entity.get支給申請書整理番号())) {
            return;
        }
        DbT3074KogakuGassanShikyuFushikyuKetteiEntity 登録用Entity = new DbT3074KogakuGassanShikyuFushikyuKetteiEntity();
        登録用Entity.setHihokenshaNo(entity.get被保険者番号());
        登録用Entity.setTaishoNendo(new FlexibleYear(entity.get対象年度()));
        登録用Entity.setHokenshaNo(entity.get保険者番号());
        登録用Entity.setShikyuSeiriNo(entity.get支給申請書整理番号());
        登録用Entity.setRirekiNo(entity.get履歴番号());
        登録用Entity.setJikoFutanSeiriNo(entity.get自己負担額証明書整理番号());
        登録用Entity.setHokenSeidoCode(entity.get保険制度コード());
        登録用Entity.setKokuho_HihokenshaShoKigo(entity.get被保険者証記号());
        if (!RString.isNullOrEmpty(entity.get対象計算期間開始年月日())) {
            登録用Entity.setKeisanKaishiYMD(new FlexibleDate(entity.get対象計算期間開始年月日()));
        }
        if (!RString.isNullOrEmpty(entity.get対象計算期間終了年月日())) {
            登録用Entity.setKeisanShuryoYMD(new FlexibleDate(entity.get対象計算期間終了年月日()));
        }
        if (!RString.isNullOrEmpty(entity.get申請年月日())) {
            登録用Entity.setShinseiYMD(new FlexibleDate(entity.get申請年月日()));
        }
        if (!RString.isNullOrEmpty(entity.get決定年月日())) {
            登録用Entity.setKetteiYMD(new FlexibleDate(entity.get決定年月日()));
        }
        登録用Entity.setJikoFutanSogaku(entity.get自己負担総額());
        登録用Entity.setShikyuKubunCode(entity.get支給区分コード());
        登録用Entity.setShikyugaku(entity.get支給額());
        登録用Entity.setKyufuShurui(entity.get給付の種類());
        登録用Entity.setFushikyuRiyu(entity.get不支給理由());
        登録用Entity.setBiko(entity.get備考());
        登録用Entity.setShiharaiHohoKubun(entity.get支払方法区分());
        登録用Entity.setShiharaiBasho(entity.get支払場所());
        if (!RString.isNullOrEmpty(entity.get支払期間開始年月日())) {
            登録用Entity.setShiharaiKaishiYMD(new FlexibleDate(entity.get支払期間開始年月日()));
        }
        if (!RString.isNullOrEmpty(entity.get支払期間終了年月日())) {
            登録用Entity.setShiharaiShuryoYMD(new FlexibleDate(entity.get支払期間終了年月日()));
        }
        登録用Entity.setHeichoNaiyo(RString.EMPTY);
        登録用Entity.setShiharaiKaishiTime(entity.get支払期間開始時間());
        登録用Entity.setShiharaiShuryoTime(entity.get支払期間終了時間());
        登録用Entity.setKetteiTsuchiSakuseiYMD(null);
        登録用Entity.setFurikomiTsuchiSakuseiYMD(null);
        登録用Entity.setUketoriYM(parameter.get処理年月());
        if (null != entity.get口座ID()) {
            登録用Entity.setKozaID(entity.get口座ID());
        }
        登録用Entity.setKetteiTsuchiRealHakkoFlag(発行フラグ);
        登録用Entity.setState(EntityDataState.Added);
        高額合算支給不支給決定tableWriter.insert(登録用Entity);
    }

}
