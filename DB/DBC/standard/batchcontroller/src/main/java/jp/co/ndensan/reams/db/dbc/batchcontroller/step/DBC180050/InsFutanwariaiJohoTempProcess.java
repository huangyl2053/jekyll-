/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.FutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.InsFutanwariaiJohoTempResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.nenjiriyoshafutanwariaihantei.DbWT1801ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(利用者負担割合情報の取得)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class InsFutanwariaiJohoTempProcess extends BatchProcessBase<InsFutanwariaiJohoTempResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get利用者負担割合明細Newest");
    @BatchWriter
    private IBatchTableWriter<DbWT1801ShoriKekkaKakuninListEntity> 処理結果確認リストWriter;
    @BatchWriter
    private IBatchTableWriter<FutanWariaiTempEntity> 負担割合情報一時表Writer;
    private static final RString エラー区分_負担割合_削除 = new RString("01");
    private static final RString エラー区分_負担割合_取得 = new RString("02");
    private static final RString 開始月 = new RString("08");
    private static final RString TEMP_TABLE = new RString("futanWariaiTemp");
    private static final RString 確認リスト_TEMP_TABLE = new RString("DbWT1801ShoriKekkaKakuninList");
    private static final RString 零壱 = new RString("01");
    private static final RString 壱零 = new RString("10");
    private static final RString 弐零 = new RString("20");
    private static final RString 九零 = new RString("90");
    private static final RString 八零 = new RString("80");
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
        処理結果確認リストWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                DbWT1801ShoriKekkaKakuninListEntity.class).tempTableName(確認リスト_TEMP_TABLE).build();
    }

    @Override
    protected void process(InsFutanwariaiJohoTempResultEntity entity) {
        if (entity.get利用者負担割合明細最新Entity() != null) {
            if (entity.get利用者負担割合明細最新Entity().getIsDeleted()) {
                DbWT1801ShoriKekkaKakuninListEntity 処理結果確認リストEntity = new DbWT1801ShoriKekkaKakuninListEntity();
                処理結果確認リストEntity.setErrorKubun(エラー区分_負担割合_削除);
                処理結果確認リストEntity.setHihokenshaNo(entity.get被保険者番号().value());
                処理結果確認リストWriter.insert(処理結果確認リストEntity);
            } else {
                get負担割合情報一時表(entity);
            }
        } else {
            DbWT1801ShoriKekkaKakuninListEntity 処理結果確認リストEntity = new DbWT1801ShoriKekkaKakuninListEntity();
            処理結果確認リストEntity.setErrorKubun(エラー区分_負担割合_取得);
            処理結果確認リストEntity.setHihokenshaNo(entity.get被保険者番号().value());
            処理結果確認リストWriter.insert(処理結果確認リストEntity);
        }
    }

    @Override
    protected void afterExecute() {
        負担割合情報一時表Writer.insert(負担割合情報一時表);
    }

    private void get負担割合情報一時表(InsFutanwariaiJohoTempResultEntity entity) {
        if (開始Flag
                || (被保険者番号.equals(entity.get被保険者番号()) && 年度.equals(entity.get年度()))) {
            給付率データを設定(entity);
        } else {
            負担割合情報一時表Writer.insert(負担割合情報一時表);
            負担割合情報一時表 = new FutanWariaiTempEntity();
        }
    }

    private void 給付率データを設定(InsFutanwariaiJohoTempResultEntity entity) {
        開始Flag = false;
        年度 = entity.get年度();
        被保険者番号 = entity.get被保険者番号();
        負担割合情報一時表.set被保険者番号(entity.get被保険者番号());
        負担割合情報一時表.set年度(年度);

        if (entity.get利用者負担割合明細最新Entity().getYukoKaishiYMD() != null
                && entity.get利用者負担割合明細最新Entity().getYukoShuryoYMD() != null) {
            FlexibleYearMonth 開始年月 = new FlexibleYearMonth(年度.toDateString().concat(開始月));
            set給付率01(entity, 開始年月);
            set給付率02(entity, 開始年月);
            set給付率03(entity, 開始年月);
            set給付率04(entity, 開始年月);
            set給付率05(entity, 開始年月);
            set給付率06(entity, 開始年月);
            set給付率07(entity, 開始年月);
            set給付率08(entity, 開始年月);
            set給付率09(entity, 開始年月);
            set給付率10(entity, 開始年月);
            set給付率11(entity, 開始年月);
            set給付率12(entity, 開始年月);
        }
    }

    private void set給付率01(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月)) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率01(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率01(八零);
            }
        }
    }

    private void set給付率02(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(1))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率02(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率02(八零);
            }
        }
    }

    private void set給付率03(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(二))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率03(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率03(八零);
            }
        }
    }

    private void set給付率04(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(三))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率04(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率04(八零);
            }
        }
    }

    private void set給付率05(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(四))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率05(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率05(八零);
            }
        }
    }

    private void set給付率06(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(五))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率06(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率06(八零);
            }
        }
    }

    private void set給付率07(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(六))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率07(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率07(八零);
            }
        }
    }

    private void set給付率08(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(七))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率08(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率08(八零);
            }
        }
    }

    private void set給付率09(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(八))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率09(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率09(八零);
            }
        }
    }

    private void set給付率10(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(九))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率10(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率10(八零);
            }
        }
    }

    private void set給付率11(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(十))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率11(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率11(八零);
            }
        }
    }

    private void set給付率12(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 開始年月) {
        if (is期間中(entity, 開始年月.plusMonth(十一))) {
            if (壱零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率12(九零);
            } else if (弐零.equals(entity.get利用者負担割合明細最新Entity().getFutanWariaiKubun())) {
                負担割合情報一時表.set給付率12(八零);
            }
        }
    }

    private boolean is期間中(InsFutanwariaiJohoTempResultEntity entity, FlexibleYearMonth 年月) {
        FlexibleDate 年月の月末日 = new FlexibleDate(年月.plusMonth(1).toDateString().concat(零壱)).minusDay(1);
        FlexibleDate 有効開始日 = entity.get利用者負担割合明細最新Entity().getYukoKaishiYMD();
        FlexibleDate 有効終了日 = entity.get利用者負担割合明細最新Entity().getYukoShuryoYMD();
        if (有効開始日 != null && 有効終了日 != null) {
            return 年月の月末日.isBeforeOrEquals(有効終了日) && 有効開始日.isBeforeOrEquals(年月の月末日);
        }
        return false;
    }
}
