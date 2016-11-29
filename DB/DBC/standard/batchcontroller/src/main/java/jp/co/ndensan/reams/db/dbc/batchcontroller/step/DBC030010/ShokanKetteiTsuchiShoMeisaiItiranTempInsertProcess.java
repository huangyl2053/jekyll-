/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC030010;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanketteitsuchishoikkatsu.ShokanHanteiKekkaUpdataParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.shokanketteitsuchishoikkatsu.ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanketteitsuchisho.ShokanKetteiTsuchiShoMeisaiItiranTempTableEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払い支給不支給決定通知書明細一覧一時TBLを作成します。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
public class ShokanKetteiTsuchiShoMeisaiItiranTempInsertProcess extends BatchProcessBase<ShokanKetteiTsuchiShoMeisaiItiranTempTableEntity> {

    private static final RString 決定通知書明細情報取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "shokanketteitsuchishoikkatsusakusei.IShokanKetteiTsuchiShoIkkatsuSakuseiMapper.get決定通知書明細情報一時TBL");
    private static final RString TABLE_償還払い支給不支給決定通知書明細一覧情報 = new RString("ShokanKetteiTsuchiShoMeisaiItiranTemp");
    
    private static final RString 様式番号サブ21C1 = new RString("21C1");
    
    private static final RString 様式番号サブ21C2 = new RString("21C2");
    
    private static final RString 様式番号サブ21D1 = new RString("21D1");
    
    private static final RString 様式番号サブ21D2 = new RString("21D2");
    
    private static final RString 福祉用具 = new RString("福祉用具");
    
    private static final RString 住宅改修 = new RString("住宅改修");
    
    private static final RString 予防 = new RString("予防");
    
    private static final RString 償還 = new RString("償還");
    
    private static final RString サービス分類1 = new RString("1");
    
    private static final RString サービス分類2 = new RString("2");
    
    private static final RString サービス分類3 = new RString("3");
    private static final RString 発行有無_2 = new RString("２号発行有無");

    ShokanKetteiTsuchiShoIkkatsuSakuseiProcessParameter parameter;
    
    
    @BatchWriter
    BatchEntityCreatedTempTableWriter 償還払支給不支給決定通知書明細情報一時TBL;

    @Override
    protected IBatchReader createReader() {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString 発行有無 = RString.EMPTY;
        ChohyoSeigyoHanyo 帳票制御汎発行有無 = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 発行有無_2);
        if (帳票制御汎発行有無 != null) {
            発行有無 = 帳票制御汎発行有無.get設定値();
        }
        ShokanHanteiKekkaUpdataParameter sqlParam = ShokanHanteiKekkaUpdataParameter.createParam(parameter.getChusyuMode(),
                parameter.getInsho(), parameter.getDataFrom(), parameter.getDataTo(), parameter.getKetteishaUketsukeYM(), 発行有無);
        return new BatchDbReader(決定通知書明細情報取得SQL, sqlParam);
    }

    @Override
    protected void createWriter() {
        償還払支給不支給決定通知書明細情報一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_償還払い支給不支給決定通知書明細一覧情報,
                ShokanKetteiTsuchiShoMeisaiItiranTempTableEntity.class);
    }

    @Override
    protected void process(ShokanKetteiTsuchiShoMeisaiItiranTempTableEntity entity) {
        if (null != entity.getSagakuKingakuTtl() && entity.getSagakuKingakuTtl().compareTo(Decimal.ZERO) != 0) {
            entity.setYousikiKingakuTtl(entity.getSagakuKingakuTtl());
        } else {
            entity.setYousikiKingakuTtl(entity.getKaishuKingakuTtl());
        }
        if (様式番号サブ21C1.equals(entity.getYousikibangousabu())) {
            entity.setSabisufunrui(サービス分類1);
            entity.setSyurui1(福祉用具);
            entity.setSyurui2(RString.EMPTY);
        } else if (様式番号サブ21C2.equals(entity.getYousikibangousabu())) {
            entity.setSabisufunrui(サービス分類1);
            entity.setSyurui1(予防);
            entity.setSyurui2(福祉用具);
        } else if (様式番号サブ21D1.equals(entity.getYousikibangousabu())) {
            entity.setSabisufunrui(サービス分類2);
            entity.setSyurui1(住宅改修);
            entity.setSyurui2(RString.EMPTY);
        } else if (様式番号サブ21D2.equals(entity.getYousikibangousabu())) {
            entity.setSabisufunrui(サービス分類2);
            entity.setSyurui1(予防);
            entity.setSyurui2(住宅改修);
        } else {
            entity.setSabisufunrui(サービス分類3);
            entity.setSyurui1(償還);
            entity.setSyurui2(RString.EMPTY);
        }
        償還払支給不支給決定通知書明細情報一時TBL.insert(entity);
    }
}
