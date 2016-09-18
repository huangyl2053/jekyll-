/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc150030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecoderiyojokyo.KyufuJissekiMeisaiGetProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470ToukeihyoMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470ToukeihyoMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470shoriKekkaListTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名情報抽出処理Processクラスです。
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
public class ShikibetsuTaishoProcess
        extends BatchProcessBase<DbWT3470ToukeihyoMeisaichukanTempEntity> {

    private KyufuJissekiMeisaiGetProcessParameter parameter;

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecoderiyojokyo."
                    + "IServicecodeRiyojokyoMapper.get宛名情報抽出処理");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 統計表明細中間一時tableWriter;
    private static final RString 統計表明細中間一時_TABLE_NAME = new RString("DbWT3470ToukeihyoMeisaichukan");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT3470shoriKekkaList");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString NUM = new RString("99");
    private int count;

    @Override
    protected void initialize() {
        count = INT_0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());

    }

    @Override
    protected void createWriter() {
        統計表明細中間一時tableWriter = new BatchEntityCreatedTempTableWriter(
                統計表明細中間一時_TABLE_NAME, DbWT3470ToukeihyoMeisaiTempEntity.class);
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(
                処理結果リスト一時_TABLE_NAME, DbWT3470shoriKekkaListTempEntity.class);
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process(DbWT3470ToukeihyoMeisaichukanTempEntity entity) {
        count = count + INT_1;
        統計表明細中間一時tableWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
        if (INT_0 == count) {
            DbWT3470shoriKekkaListTempEntity エラー結果 = new DbWT3470shoriKekkaListTempEntity();
            エラー結果.setErrorKubun(NUM);
            エラー結果.setKey1(parameter.get年月範囲開始());
            エラー結果.setKey2(parameter.get年月範囲終了());
            エラー結果.setKey3(parameter.get対象サービス種類());
            エラー結果.setKey4(parameter.get選択対象());
            エラー結果.setKey5(parameter.get市町村コード());
            処理結果リスト一時tableWriter.insert(エラー結果);
        }
    }
}
