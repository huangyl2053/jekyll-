/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員所得判定明細高額一時の作成２プロセスのクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
public class InsSetaiinShotokuHanteiMeisaiJigyoKogakuTmpProcess2 extends BatchProcessBase<TempSetaiinShotokuHanteiEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select世帯員所得判定明細一時");
    private static final RString TABLE_世帯員所得判定明細事業高額一時２ = new RString("TempSetaiinShotokuHanteiJigyo2");
    private static final RString TABLE_世帯員所得判定明細事業高額一時３ = new RString("TempSetaiinShotokuHanteiJigyo3");
    private static final FlexibleYear YEAR_2006 = new FlexibleYear("2006");
    private static final FlexibleYear YEAR_2015 = new FlexibleYear("2015");
    private static final int MINUS_1 = -1;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_6 = 6;
    private static final int INT_7 = 7;
    private static final RString RS_01 = new RString("01");
    private boolean 年調整フラグ;
    private FlexibleDate 基準年月日;
    private FlexibleDate ｗｋ年月日;
    private FlexibleYear 年度;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter setaiinShotokuHanteiJigyo2Writer;
    @BatchWriter
    private BatchEntityCreatedTempTableWriter setaiinShotokuHanteiJigyo3Writer;

    @Override
    protected void initialize() {
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID);
    }

    @Override
    protected void createWriter() {
        setaiinShotokuHanteiJigyo2Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得判定明細事業高額一時２, TempSetaiinShotokuHanteiEntity.class);
        setaiinShotokuHanteiJigyo3Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得判定明細事業高額一時３, TempSetaiinShotokuHanteiEntity.class);
    }

    @Override
    protected void process(TempSetaiinShotokuHanteiEntity entity) {
        年調整フラグ = false;
        基準年月日 = entity.getKijunYMD();
        if (基準年月日 == null) {
            return;
        }
        FlexibleYear 年 = 基準年月日.getYear();
        if (年.isBefore(YEAR_2006) && INT_4 <= 基準年月日.getMonthValue() && 基準年月日.getMonthValue() <= INT_5) {
            年調整フラグ = true;
        } else if (YEAR_2006.isBeforeOrEquals(年) && 年.isBefore(YEAR_2015)
                && INT_4 <= 基準年月日.getMonthValue() && 基準年月日.getMonthValue() <= INT_6) {
            年調整フラグ = true;
        } else if (YEAR_2015.isBeforeOrEquals(年) && INT_4 <= 基準年月日.getMonthValue() && 基準年月日.getMonthValue() <= INT_7) {
            年調整フラグ = true;
        }
        if (年調整フラグ) {
            ｗｋ年月日 = new FlexibleDate(基準年月日.getYearMonth().toDateString().concat(RS_01)).plusYear(MINUS_1);
        } else {
            ｗｋ年月日 = new FlexibleDate(基準年月日.getYearMonth().toDateString().concat(RS_01));
        }
        年度 = ｗｋ年月日.getNendo();
        entity.setTsuzukigaraCodeNen(年度);
        entity.setAtena_tsuzukigaraCode(TsuzukigaraCode.EMPTY);
        entity.setAtena_juminShubetsuCode(RString.EMPTY);
        entity.setAtena_seinengappiYMD(FlexibleDate.EMPTY);
        setaiinShotokuHanteiJigyo2Writer.insert(entity);
    }

    @Override
    protected void afterExecute() {
        setaiinShotokuHanteiJigyo3Writer.getInsertCount();
    }
}
