/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc180050.SelRiyoushaHutanwariaitorigaDataMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc180050.SelKyuhuzissekiKihonTorigaDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.SelKyuhuzissekiKihonTorigaDataResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.TorigaDataTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(給付実績基本トリガデータ抽出Process)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class SelKyuhuzissekiKihonTorigaDataProcess extends BatchProcessBase<SelKyuhuzissekiKihonTorigaDataResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get給付実績基本");

    private SelKyuhuzissekiKihonTorigaDataProcessParameter processParameter;
    @BatchWriter
    private IBatchTableWriter<TorigaDataTempEntity> トリガデータTempWriter;
    private static final RString TEMP_TABLE = new RString("torigaDataTemp");
    private static final RString 開始月 = new RString("08");
    private IKoseiTaishoKyufuJissekiIchiranMapper mapper;

    @Override
    protected void initialize() {
        mapper = getMapper(IKoseiTaishoKyufuJissekiIchiranMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toSelRiyoushaHutanwariaitorigaDataMybatisParameter());
    }

    @Override
    protected void createWriter() {
        トリガデータTempWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorigaDataTempEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(SelKyuhuzissekiKihonTorigaDataResultEntity entity) {
        SelRiyoushaHutanwariaitorigaDataMybatisParameter param = new SelRiyoushaHutanwariaitorigaDataMybatisParameter();
        param.set年月(entity.getサービス提供年月());
        param.set被保険者番号(entity.get被保険者番号());
        TorigaDataTempEntity tmpEntity = mapper.has同じTemp(param);
        if (tmpEntity == null) {
            HihokenshaNo 被保険者番号 = entity.get被保険者番号();
            FlexibleYearMonth サービス提供年月 = entity.getサービス提供年月();
            FlexibleYear 年度 = get年度(entity.getサービス提供年月());
            TorigaDataTempEntity tenpEntity = new TorigaDataTempEntity();
            tenpEntity.set年度(年度);
            tenpEntity.set被保険者番号(被保険者番号);
            tenpEntity.set年月(サービス提供年月);
            トリガデータTempWriter.insert(tenpEntity);
        }
    }

    private FlexibleYear get年度(FlexibleYearMonth 年月) {
        if (年月 == null) {
            return null;
        }

        if (年月.isBefore(new FlexibleYearMonth(年月.getYear().toDateString().concat(開始月)))) {
            return 年月.getYear().minusYear(1);
        }
        return 年月.getYear();
    }
}
