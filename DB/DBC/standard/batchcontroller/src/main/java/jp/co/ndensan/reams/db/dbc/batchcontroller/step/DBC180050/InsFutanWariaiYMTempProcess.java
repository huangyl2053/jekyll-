/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.FutanWariaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.FutanWariaiYMTempEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(負担割合情報年月一時表を作成する)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class InsFutanWariaiYMTempProcess extends BatchProcessBase<FutanWariaiTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get負担割合情報Temp");
    @BatchWriter
    private IBatchTableWriter<FutanWariaiYMTempEntity> 負担割合情報年月一時表Writer;
    private static final RString TEMP_TABLE = new RString("futanWariaiYMTemp");
    private static final RString 開始月 = new RString("08");
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

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        負担割合情報年月一時表Writer = BatchWriters.batchEntityCreatedTempTableWriter(
                FutanWariaiYMTempEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(FutanWariaiTempEntity entity) {
        FlexibleYearMonth 開始年月 = new FlexibleYearMonth(entity.get年度().toDateString().concat(開始月));
        for (int i = 0; i < 11; i++) {
            FutanWariaiYMTempEntity tempEntity = new FutanWariaiYMTempEntity();
            tempEntity.set被保険者番号(entity.get被保険者番号());
            tempEntity.set年度(entity.get年度());
            tempEntity.set年月(開始年月.plusMonth(i));
            tempEntity.set給付率(get給付率(i, entity));
            負担割合情報年月一時表Writer.insert(tempEntity);
        }
    }

    private RString get給付率(int 引数, FutanWariaiTempEntity entity) {
        if (引数 == 0) {
            return entity.get給付率01();
        }

        if (引数 == 1) {
            return entity.get給付率02();
        }

        if (引数 == 二) {
            return entity.get給付率03();
        }

        if (引数 == 三) {
            return entity.get給付率04();
        }

        if (引数 == 四) {
            return entity.get給付率05();
        }

        if (引数 == 五) {
            return entity.get給付率06();
        }

        if (引数 == 六) {
            return entity.get給付率07();
        }

        if (引数 == 七) {
            return entity.get給付率08();
        }

        if (引数 == 八) {
            return entity.get給付率09();
        }

        if (引数 == 九) {
            return entity.get給付率10();
        }

        if (引数 == 十) {
            return entity.get給付率11();
        }

        if (引数 == 十一) {
            return entity.get給付率12();
        }

        return null;
    }
}
