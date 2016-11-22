/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.FutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.UpdShiharaihohoHenkoTempResultEntity;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(支払方法変更情報の取得)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class UpdShiharaihohoHenkoTempProcess extends BatchProcessBase<UpdShiharaihohoHenkoTempResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get支払方法変更");
    @BatchWriter
    private IBatchTableWriter<FutanWariaiTempEntity> 負担割合情報一時表Writer;
    private static final RString 開始月 = new RString("08");
    private static final RString TEMP_TABLE = new RString("futanWariaiTemp");
    private static final RString 給付率 = new RString("70");
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
    private boolean 八月違い期間存在Flag;
    private boolean 九月違い期間存在Flag;
    private boolean 十月違い期間存在Flag;
    private boolean 十一月違い期間存在Flag;
    private boolean 十二月違い期間存在Flag;
    private boolean 一月違い期間存在Flag;
    private boolean 二月違い期間存在Flag;
    private boolean 三月違い期間存在Flag;
    private boolean 四月違い期間存在Flag;
    private boolean 五月違い期間存在Flag;
    private boolean 六月違い期間存在Flag;
    private boolean 七月違い期間存在Flag;

    @Override
    protected void initialize() {
        開始Flag = true;
        年度 = FlexibleYear.EMPTY;
        被保険者番号 = HihokenshaNo.EMPTY;
        負担割合情報一時表 = new FutanWariaiTempEntity();
        set存在Flag();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected
            void createWriter() {
        負担割合情報一時表Writer = BatchWriters.batchEntityCreatedTempTableWriter(
                FutanWariaiTempEntity.class
        ).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(UpdShiharaihohoHenkoTempResultEntity entity) {
        if (entity.get支払方法変更() != null) {
            if (開始Flag
                    || (被保険者番号.equals(entity.get支払方法変更().getHihokenshaNo()) && 年度.equals(entity.get負担割合TempEntity().get年度()))) {
                get負担割合情報一時表(entity);
            } else {
                負担割合情報一時表Writer.update(負担割合情報一時表);
                負担割合情報一時表 = entity.get負担割合TempEntity();
                set存在Flag();
                get負担割合情報一時表(entity);
            }
            開始Flag = false;
            被保険者番号 = entity.get支払方法変更().getHihokenshaNo();
            年度 = entity.get負担割合TempEntity().get年度();
        }
    }

    @Override
    protected void afterExecute() {
        負担割合情報一時表Writer.update(負担割合情報一時表);
    }

    private void get負担割合情報一時表(UpdShiharaihohoHenkoTempResultEntity entity) {
        if (開始Flag) {
            負担割合情報一時表 = entity.get負担割合TempEntity();
        }
        if (is全て該当する(entity.get負担割合TempEntity().get年度(), entity)) {
            負担割合情報一時表.set給付率01(給付率);
            負担割合情報一時表.set給付率02(給付率);
            負担割合情報一時表.set給付率03(給付率);
            負担割合情報一時表.set給付率04(給付率);
            負担割合情報一時表.set給付率05(給付率);
            負担割合情報一時表.set給付率06(給付率);
            負担割合情報一時表.set給付率07(給付率);
            負担割合情報一時表.set給付率08(給付率);
            負担割合情報一時表.set給付率09(給付率);
            負担割合情報一時表.set給付率10(給付率);
            負担割合情報一時表.set給付率11(給付率);
            負担割合情報一時表.set給付率12(給付率);
        } else {
            RString 支払給付率 = null;
            Decimal 支払方法変更給付率 = null;
            HokenKyufuRitsu 支払方法 = entity.get支払方法変更().getKyufuRitsu();
            if (支払方法 != null) {
                支払方法変更給付率 = 支払方法.value();
            }
            if (支払方法変更給付率 != null) {
                支払給付率 = new RString(支払方法変更給付率.toString());
            }
            set給付率01(entity, 支払給付率);
            set給付率02(entity, 支払給付率);
            set給付率03(entity, 支払給付率);
            set給付率04(entity, 支払給付率);
            set給付率05(entity, 支払給付率);
            set給付率06(entity, 支払給付率);
            set給付率07(entity, 支払給付率);
            set給付率08(entity, 支払給付率);
            set給付率09(entity, 支払給付率);
            set給付率10(entity, 支払給付率);
            set給付率11(entity, 支払給付率);
            set給付率12(entity, 支払給付率);
        }
    }

    private void set給付率01(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 0)) {
            負担割合情報一時表.set給付率01(支払給付率);
            if (八月違い期間存在Flag) {
                負担割合情報一時表.set給付率01(給付率);
            }
            八月違い期間存在Flag = true;
        }
    }

    private void set給付率02(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 1)) {
            負担割合情報一時表.set給付率02(支払給付率);
            if (九月違い期間存在Flag) {
                負担割合情報一時表.set給付率02(給付率);
            }
            九月違い期間存在Flag = true;
        }
    }

    private void set給付率03(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 二)) {
            負担割合情報一時表.set給付率03(支払給付率);
            if (十月違い期間存在Flag) {
                負担割合情報一時表.set給付率03(給付率);
            }
            十月違い期間存在Flag = true;
        }
    }

    private void set給付率04(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 三)) {
            負担割合情報一時表.set給付率04(支払給付率);
            if (十一月違い期間存在Flag) {
                負担割合情報一時表.set給付率04(給付率);
            }
            十一月違い期間存在Flag = true;
        }
    }

    private void set給付率05(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 四)) {
            負担割合情報一時表.set給付率05(支払給付率);
            if (十二月違い期間存在Flag) {
                負担割合情報一時表.set給付率05(給付率);
            }
            十二月違い期間存在Flag = true;
        }
    }

    private void set給付率06(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 五)) {
            負担割合情報一時表.set給付率06(支払給付率);
            if (一月違い期間存在Flag) {
                負担割合情報一時表.set給付率06(給付率);
            }
            一月違い期間存在Flag = true;
        }
    }

    private void set給付率07(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 六)) {
            負担割合情報一時表.set給付率07(支払給付率);
            if (二月違い期間存在Flag) {
                負担割合情報一時表.set給付率07(給付率);
            }
            二月違い期間存在Flag = true;
        }
    }

    private void set給付率08(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 七)) {
            負担割合情報一時表.set給付率08(支払給付率);
            if (三月違い期間存在Flag) {
                負担割合情報一時表.set給付率08(給付率);
            }
            三月違い期間存在Flag = true;
        }
    }

    private void set給付率09(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 八)) {
            負担割合情報一時表.set給付率09(支払給付率);
            if (四月違い期間存在Flag) {
                負担割合情報一時表.set給付率09(給付率);
            }
            四月違い期間存在Flag = true;
        }
    }

    private void set給付率10(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 九)) {
            負担割合情報一時表.set給付率10(支払給付率);
            if (五月違い期間存在Flag) {
                負担割合情報一時表.set給付率10(給付率);
            }
            五月違い期間存在Flag = true;
        }
    }

    private void set給付率11(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 十)) {
            負担割合情報一時表.set給付率11(支払給付率);
            if (六月違い期間存在Flag) {
                負担割合情報一時表.set給付率11(給付率);
            }
            六月違い期間存在Flag = true;
        }
    }

    private void set給付率12(UpdShiharaihohoHenkoTempResultEntity entity, RString 支払給付率) {
        if (is期間(entity.get負担割合TempEntity().get年度(), entity, 十一)) {
            負担割合情報一時表.set給付率12(支払給付率);
            if (七月違い期間存在Flag) {
                負担割合情報一時表.set給付率12(給付率);
            }
            七月違い期間存在Flag = true;
        }
    }

    private boolean is全て該当する(FlexibleYear 年度, UpdShiharaihohoHenkoTempResultEntity entity) {
        FlexibleYearMonth 対象開始年月 = new FlexibleYearMonth(年度.toDateString().concat(開始月));
        FlexibleYearMonth 対象終了年月 = new FlexibleYearMonth(年度.toDateString().concat(開始月)).plusMonth(十一);
        FlexibleDate tekiyoShuryoYMD = entity.get支払方法変更().getTekiyoShuryoYMD();
        FlexibleDate tekiyoKaishiYMD = entity.get支払方法変更().getTekiyoKaishiYMD();
        return tekiyoShuryoYMD != null && tekiyoKaishiYMD != null
                && 対象終了年月.isBeforeOrEquals(tekiyoShuryoYMD.getYearMonth())
                && tekiyoKaishiYMD.getYearMonth().isBeforeOrEquals(対象開始年月);
    }

    private boolean is期間(FlexibleYear 年度, UpdShiharaihohoHenkoTempResultEntity entity, int 開始年月から_月数) {
        FlexibleYearMonth 対象年月 = new FlexibleYearMonth(年度.toDateString().concat(開始月)).plusMonth(開始年月から_月数);
        FlexibleDate tekiyoShuryoYMD = entity.get支払方法変更().getTekiyoShuryoYMD();
        FlexibleDate tekiyoKaishiYMD = entity.get支払方法変更().getTekiyoKaishiYMD();
        return 対象年月 != null && tekiyoShuryoYMD != null && tekiyoKaishiYMD != null
                && 対象年月.isBeforeOrEquals(tekiyoShuryoYMD.getYearMonth())
                && tekiyoKaishiYMD.getYearMonth().isBeforeOrEquals(対象年月);
    }

    private void set存在Flag() {
        八月違い期間存在Flag = false;
        八月違い期間存在Flag = false;
        九月違い期間存在Flag = false;
        十月違い期間存在Flag = false;
        十一月違い期間存在Flag = false;
        十二月違い期間存在Flag = false;
        一月違い期間存在Flag = false;
        二月違い期間存在Flag = false;
        三月違い期間存在Flag = false;
        四月違い期間存在Flag = false;
        五月違い期間存在Flag = false;
        六月違い期間存在Flag = false;
        七月違い期間存在Flag = false;
    }

}
