/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.batchcontroller.step.dbx001001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.dbx001001.TokuchoTenbikiTeishiMyBatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.processprm.dbx001001.TokuchoTenbikiTeishiProcessParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin.HihonkenshaNoResult;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.tokuchotenbikiteishichoshuhohokoshin.TokuchoTenbikiTeishiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 特徴天引き停止徴収方法更新のプロセスクラスです。
 *
 * @reamsid_L DBB-9210-030 liuyang
 */
public class TokuchoTembikiProcess
        extends BatchProcessBase<TokuchoTenbikiTeishiEntity> {

    private static final RString 年 = new RString("年");
    private static final RString 月 = new RString("月");
    private static final RString FULLYEAR = new RString("0000");
    private static final RString FULLMONTH = new RString("00");
    private static final RString T_被保険者番号TMP = new RString("HihonkenshaNoTemp");
    private static final RString PATH = new RString("jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate"
            + ".tokuchotenbikiteishichoshuhohokoshin.ITokuchoTenbikiTeishiChoshuhohokoshinMapper.getHihokenshaNos");
    private TokuchoTenbikiTeishiProcessParameter parameter;
    private List<RString> 被保険者番号リスト;
    @BatchWriter
    BatchPermanentTableWriter<DbT2001ChoshuHohoEntity> tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者番号Temp;

    @Override
    protected void initialize() {
        被保険者番号リスト = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(PATH, toMyBatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchPermanentTableWriter<>(DbT2001ChoshuHohoEntity.class);
        被保険者番号Temp = new BatchEntityCreatedTempTableWriter(T_被保険者番号TMP,
                HihonkenshaNoResult.class);
    }

    @Override
    protected void process(TokuchoTenbikiTeishiEntity entity) {
        RString 被保険者番号 = entity.get被保険者番号();
        if (RString.isNullOrEmpty(被保険者番号) || 被保険者番号リスト.contains(被保険者番号)) {
            return;
        }
        HihonkenshaNoResult hihonkenshaNoResult = new HihonkenshaNoResult(被保険者番号);
        被保険者番号Temp.insert(hihonkenshaNoResult);
        被保険者番号リスト.add(被保険者番号);
    }

    private TokuchoTenbikiTeishiMyBatisParameter toMyBatisParameter() {
        parameter.set天引月(formatMonthFull(parameter.get天引月()));
        parameter.set年度(formatYearFull(parameter.get年度()));
        return new TokuchoTenbikiTeishiMyBatisParameter(parameter.get日付関連調定年度(),
                parameter.get天引月(), parameter.get年度());
    }

    private RString formatMonthFull(RString month) {
        if (RString.isNullOrEmpty(month) || month.trim().isEmpty()
                || month.trim().replace(月, RString.EMPTY).trim().isEmpty()) {
            return RString.EMPTY;
        }
        month = month.trim().replace(月, RString.EMPTY).trim();
        return new RString(new Decimal(month.toString()).toString(FULLMONTH.toString()));
    }

    private RString formatYearFull(RString year) {
        if (RString.isNullOrEmpty(year) || year.trim().isEmpty()
                || year.trim().replace(月, RString.EMPTY).trim().isEmpty()) {
            return RString.EMPTY;
        }
        year = year.trim().replace(年, RString.EMPTY).trim();
        return new RString(new Decimal(year.toString()).toString(FULLYEAR.toString()));
    }
}
