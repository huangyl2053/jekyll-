/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表一時TBLに登録されているサービス提供年月取得（重複を除く）のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class ServiceTeikyoYMSelectProcess extends BatchProcessBase<FlexibleYearMonth> {

    /**
     * データ有無の判定です。
     */
    public static final RString データ有無;

    static {
        データ有無 = new RString("outData");
    }
    private OutputParameter<List<FlexibleYearMonth>> outData;

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.selectサービス提供年月");

    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;
    List<FlexibleYearMonth> サービス提供年月List;

    @Override
    protected void initialize() {
        outData = new OutputParameter<>();
        サービス提供年月List = new ArrayList<>();
        outData.setValue(サービス提供年月List);
    }

    @Override
    protected void createWriter() {
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void process(FlexibleYearMonth サービス提供年月) {
        サービス提供年月List.add(サービス提供年月);
    }
}
