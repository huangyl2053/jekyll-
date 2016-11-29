/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanShinseiUpdataParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishokanshinsei.ShokanKetteiTsuchiShokanShinseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 償還払い支給不支給償還払支給申請DB更新を処理します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShokanShinseiDBUpdateProcess extends BatchProcessBase<DbT3034ShokanShinseiEntity> {

    private static final RString 償還払支給申請情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get償還払支給申請情報");
    private static final RString 発行有無_2 = new RString("２号発行有無");
    private static final int NUM_4 = 4;

    @BatchWriter
    BatchPermanentTableWriter<DbT3034ShokanShinseiEntity> dbT3034Writer;

    ShokanKetteiTsuchiShokanShinseiProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString 発行有無 = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御汎発行有無 = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 発行有無_2);
        if (帳票制御汎発行有無 != null) {
            発行有無 = 帳票制御汎発行有無.get設定値();
        }
        ShokanShinseiUpdataParameter sqlParam = ShokanShinseiUpdataParameter.createParam(発行有無);
        return new BatchDbReader(償還払支給申請情報取得SQL, sqlParam);
    }

    @Override
    protected void createWriter() {
        dbT3034Writer = new BatchPermanentTableWriter(DbT3034ShokanShinseiEntity.class);
    }

    @Override
    protected void process(DbT3034ShokanShinseiEntity entity) {
        entity.setShiharaiBasho(parameter.get支払場所());
        entity.setShiharaiKaishiYMD(parameter.get支払期間From() == null
                ? FlexibleDate.EMPTY : new FlexibleDate(parameter.get支払期間From().toDateString()));
        entity.setShiharaiShuryoYMD(parameter.get支払期間To() == null
                ? FlexibleDate.EMPTY : new FlexibleDate(parameter.get支払期間To().toDateString()));
        entity.setShiharaiKaishiTime(parameter.get開始時間() == null
                ? RString.EMPTY : parameter.get開始時間().toFormattedTimeString(DisplayTimeFormat.HH時mm分).remove(2).remove(NUM_4));
        entity.setShiharaiShuryoTime(parameter.get終了時間() == null
                ? RString.EMPTY : parameter.get終了時間().toFormattedTimeString(DisplayTimeFormat.HH時mm分).remove(2).remove(NUM_4));
        dbT3034Writer.update(entity);
    }

    @Override
    protected void afterExecute() {

    }

}
