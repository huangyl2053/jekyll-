/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinHaakuNyuryokuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.InsSetaiinHaakuNyuryokuKogakuFlowEntity1;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku.InsSetaiinHaakuNyuryokuKogakuTmpEntity1;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 給付実績基本抽出02のProcessフロークラスです。
 *
 * @reamsid_L DBC-2010-040 jianglaisheng
 */
public class InsSetaiinHaakuNyuryokuKogakuTmpProcess1 extends BatchProcessBase<InsSetaiinHaakuNyuryokuKogakuTmpEntity1> {

    private static final RString 給付実績基本情報高額一時 = new RString("jp.co.ndensan.reams.db.dbc.persistence.db."
            + "mapper.relate.kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "get給付実績基本情報高額一時3");
    private static final RString TABLE_世帯員把握入力一時 = new RString("TempSetaiinHaakuNyuryoku");
    private static final RString RS_01 = new RString("01");
    private static final int YEAR_2006 = 2006;
    private static final int YEAR_2015 = 2015;
    private static final int MONTH_04 = 4;
    private static final int MONTH_05 = 5;
    private static final int MONTH_06 = 6;
    private static final int MONTH_07 = 7;
    private static final int INDEX_1 = 1;
    private static final RString RS_1 = new RString("1");
    private static final RString RS_0 = new RString("0");

    /**
     * returnEntity
     */
    public static final RString PARAMETER_OUT_RETURNENTITY;
    private OutputParameter<InsSetaiinHaakuNyuryokuKogakuFlowEntity1> returnEntity;
    private IKogakuKaigoServicehiKyufugakuSanshutsuMapper mapper;
    private DbT3017KyufujissekiKihonEntity 給付実績基本情報高額一時3情報;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳情報;
    private boolean 年調整フラグ;
    private FlexibleDate ｗｋ年月日;
    private FlexibleDate 適用年月日;
    private FlexibleDate 解除年月日;
    private FlexibleDate 基準年月日;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 世帯員把握入力一時;

    static {
        PARAMETER_OUT_RETURNENTITY = new RString("returnEntity");
    }

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakuKaigoServicehiKyufugakuSanshutsuMapper.class);
        InsSetaiinHaakuNyuryokuKogakuFlowEntity1 flowEntity = new InsSetaiinHaakuNyuryokuKogakuFlowEntity1();
        flowEntity = mapper.getサービス提供年月_高額一時();
        returnEntity = new OutputParameter<>();
        returnEntity.setValue(flowEntity);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(給付実績基本情報高額一時);
    }

    @Override
    protected void createWriter() {
        世帯員把握入力一時 = new BatchEntityCreatedTempTableWriter(TABLE_世帯員把握入力一時,
                TempSetaiinHaakuNyuryokuEntity.class);
    }

    @Override
    protected void process(InsSetaiinHaakuNyuryokuKogakuTmpEntity1 entity) {
        TempSetaiinHaakuNyuryokuEntity insertEntity = new TempSetaiinHaakuNyuryokuEntity();
        給付実績基本情報高額一時3情報 = entity.get給付実績基本情報高額一時３();
        被保険者台帳情報 = entity.get被保険者台帳();
        FlexibleDate 資格取得年月日 = 被保険者台帳情報.getShikakuShutokuYMD();
        FlexibleYearMonth サービス提供年月 = 給付実績基本情報高額一時3情報.getServiceTeikyoYM();
        if (資格取得年月日 != null && サービス提供年月 != null) {
            if (資格取得年月日.getYearMonth().equals(サービス提供年月)) {
                insertEntity.setKijunYMD(資格取得年月日);
            }
            if (資格取得年月日.getYearMonth().isBefore(サービス提供年月)) {
                insertEntity.setKijunYMD(new FlexibleDate(サービス提供年月.toDateString().concat(RS_01)));
            }

            年調整フラグ = false;
            if (サービス提供年月.getYearValue() < YEAR_2006
                    && MONTH_04 <= サービス提供年月.getMonthValue()
                    && サービス提供年月.getMonthValue() <= MONTH_05) {
                年調整フラグ = true;
            }
            if (YEAR_2006 <= サービス提供年月.getYearValue()
                    && サービス提供年月.getYearValue() < YEAR_2015
                    && MONTH_04 <= サービス提供年月.getMonthValue()
                    && サービス提供年月.getMonthValue() <= MONTH_06) {
                年調整フラグ = true;
            }
            if (YEAR_2015 <= サービス提供年月.getYearValue()
                    && MONTH_04 <= サービス提供年月.getMonthValue()
                    && サービス提供年月.getMonthValue() <= MONTH_07) {
                年調整フラグ = true;
            }
            if (年調整フラグ) {
                ｗｋ年月日 = new FlexibleDate(サービス提供年月.toDateString().concat(RS_01)).minusYear(INDEX_1);
            } else {
                ｗｋ年月日 = new FlexibleDate(サービス提供年月.toDateString().concat(RS_01));
            }
            insertEntity.setShotokuNendo(ｗｋ年月日.getNendo());
        }
        get住所地特例該当(insertEntity);
        世帯員把握入力一時.insert(insertEntity);
    }

    private void get住所地特例該当(TempSetaiinHaakuNyuryokuEntity insertEntity) {
        適用年月日 = 被保険者台帳情報.getJushochitokureiTekiyoYMD();
        解除年月日 = 被保険者台帳情報.getJushochitokureiKaijoYMD();
        基準年月日 = insertEntity.getKijunYMD();
        if (適用年月日 != null && !適用年月日.isEmpty()
                && 基準年月日 != null && !基準年月日.isEmpty()) {
            if (適用年月日.isBeforeOrEquals(基準年月日)
                    && (解除年月日 == null
                    || 基準年月日.isBefore(解除年月日))) {
                insertEntity.setJushochiTokureiFlag(RS_1);
            } else {
                insertEntity.setJushochiTokureiFlag(RS_0);
            }
        }
    }

}
