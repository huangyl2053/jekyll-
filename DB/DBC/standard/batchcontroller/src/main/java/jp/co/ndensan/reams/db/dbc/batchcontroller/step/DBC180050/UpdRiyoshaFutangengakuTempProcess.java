/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.FutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.UpdRiyoshaFutangengakuTempResultEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(利用者負担減額情報の取得)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class UpdRiyoshaFutangengakuTempProcess extends BatchProcessBase<UpdRiyoshaFutangengakuTempResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.利用者負担減額情報の取得");
    @BatchWriter
    private IBatchTableWriter<FutanWariaiTempEntity> 負担割合情報一時表Writer;
    private static final RString 開始月 = new RString("08");
    private static final RString TEMP_TABLE = new RString("futanWariaiTemp");
    private static final RString 零壱 = new RString("01");
    private static final int 二 = 2;
    private static final int 三 = 3;
    private static final int 四 = 4;
    private static final int 五 = 5;
    private static final int 六 = 6;
    private static final int 七 = 7;
    private static final int 八 = 8;
    private static final int 九 = 9;
    private static final int 十 = 10;
    private static final int 十一 = 11;
    private FlexibleYear 年度;
    private HihokenshaNo 被保険者番号;
    private FutanWariaiTempEntity 負担割合情報一時表;
    private boolean 開始Flag;

    @Override
    protected void initialize() {
        開始Flag = true;
        年度 = FlexibleYear.EMPTY;
        被保険者番号 = HihokenshaNo.EMPTY;
        負担割合情報一時表 = new FutanWariaiTempEntity();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        負担割合情報一時表Writer = BatchWriters.batchEntityCreatedTempTableWriter(
                FutanWariaiTempEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(UpdRiyoshaFutangengakuTempResultEntity entity) {
        if (entity.get利用者負担減額() != null) {
            if (開始Flag
                    || (被保険者番号.equals(entity.get利用者負担減額().getHihokenshaNo()) && 年度.equals(entity.get年度()))) {
                一時表データ取得(entity);
            } else {
                負担割合情報一時表Writer.update(負担割合情報一時表);
                負担割合情報一時表 = new FutanWariaiTempEntity();
                一時表データ取得(entity);
            }
        }
    }

    @Override
    protected void afterExecute() {
        負担割合情報一時表Writer.update(負担割合情報一時表);
    }

    private void 一時表データ取得(UpdRiyoshaFutangengakuTempResultEntity entity) {
        開始Flag = false;
        被保険者番号 = entity.get利用者負担減額().getHihokenshaNo();
        負担割合情報一時表.set被保険者番号(entity.get利用者負担減額().getHihokenshaNo());
        負担割合情報一時表.set年度(entity.get年度());

        if (entity.get利用者負担減額().getTekiyoKaishiYMD() != null
                && entity.get利用者負担減額().getTekiyoShuryoYMD() != null) {
            FlexibleYearMonth 開始年月 = new FlexibleYearMonth(entity.get年度().toDateString().concat(開始月));
            HokenKyufuRitsu 給付率 = entity.get利用者負担減額().getKyuhuritsu();
            if (給付率 != null) {
                set給付率(entity, 開始年月, 給付率);
            }
        }
    }

    private void set給付率(UpdRiyoshaFutangengakuTempResultEntity entity, FlexibleYearMonth 開始年月, HokenKyufuRitsu 給付率) {
        if (is期間中(entity, 開始年月)) {
            負担割合情報一時表.set給付率01(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(1))) {
            負担割合情報一時表.set給付率02(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(二))) {
            負担割合情報一時表.set給付率03(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(三))) {
            負担割合情報一時表.set給付率04(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(四))) {
            負担割合情報一時表.set給付率05(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(五))) {
            負担割合情報一時表.set給付率06(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(六))) {
            負担割合情報一時表.set給付率07(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(七))) {
            負担割合情報一時表.set給付率08(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(八))) {
            負担割合情報一時表.set給付率09(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(九))) {
            負担割合情報一時表.set給付率10(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(十))) {
            負担割合情報一時表.set給付率11(new RString(給付率.value().toString()));
        }

        if (is期間中(entity, 開始年月.plusMonth(十一))) {
            負担割合情報一時表.set給付率12(new RString(給付率.value().toString()));
        }

    }

    private boolean is期間中(UpdRiyoshaFutangengakuTempResultEntity entity, FlexibleYearMonth 年月) {
        FlexibleDate 年月の月末日 = new FlexibleDate(年月.plusMonth(1).toDateString().concat(零壱)).minusDay(1);
        FlexibleDate 適用開始年月日 = entity.get利用者負担減額().getTekiyoKaishiYMD();
        FlexibleDate 適用終了年月日 = entity.get利用者負担減額().getTekiyoShuryoYMD();
        if (適用開始年月日 != null && 適用終了年月日 != null) {
            return 年月の月末日.isBeforeOrEquals(適用終了年月日) && 適用開始年月日.isBeforeOrEquals(年月の月末日);
        }
        return false;
    }
}
