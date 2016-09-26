/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150050;

import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodetanimeisaiichiran.KyufuJissekiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030.DbWT3470shoriKekkaListTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150050.DbWT3470ServiceMeisaichukanTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 宛名情報抽出処理Processクラスです。
 *
 * @reamsid_L DBC-3330-040 jiangxiaolong
 */
public class ShikibetsuTaishoInfoProcess
        extends BatchProcessBase<DbWT3470ServiceMeisaichukanTempEntity> {

    private KyufuJissekiProcessParameter parameter;

    private static final RString READ_DATA_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.servicecodetanimeisaiichiran."
                    + "IServicecodeTaniMeisaiIchiranMapper.get宛名情報抽出処理");
    @BatchWriter
    BatchEntityCreatedTempTableWriter サービス明細中間一時tableWriter;
    private static final RString サービス明細中間一時_TABLE_NAME = new RString("DbWT3470ServiceMeisaichukan");
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
        サービス明細中間一時tableWriter = new BatchEntityCreatedTempTableWriter(
                サービス明細中間一時_TABLE_NAME, DbWT3470ServiceMeisaichukanTempEntity.class);
        処理結果リスト一時tableWriter = new BatchEntityCreatedTempTableWriter(
                処理結果リスト一時_TABLE_NAME, DbWT3470shoriKekkaListTempEntity.class);
    }

    @Override
    protected void process(DbWT3470ServiceMeisaichukanTempEntity entity) {
        count = count + INT_1;
        サービス明細中間一時tableWriter.insert(entity);
    }

    @Override
    protected void afterExecute() {
        if (INT_0 == count) {
            DbWT3470shoriKekkaListTempEntity エラー結果 = new DbWT3470shoriKekkaListTempEntity();
            エラー結果.setErrorKubun(NUM);
            エラー結果.setShoHokanehshaNo(ShoKisaiHokenshaNo.EMPTY);
            エラー結果.setHihokenshaNo(HihokenshaNo.EMPTY);
            エラー結果.setKey1(parameter.get開始年月());
            エラー結果.setKey2(parameter.get終了年月());
            RString 対象サービス種類 = RString.EMPTY;
            for (RString code : parameter.getサービス種類コードリスト()) {
                対象サービス種類.concat(code != null ? code : RString.EMPTY);
            }
            エラー結果.setKey3(対象サービス種類);
            エラー結果.setKey4(parameter.get地区指定());
            エラー結果.setKey5(parameter.get市町村コード());
            エラー結果.setHihokenshaKanaShimei(RString.EMPTY);
            エラー結果.setHihokenshaShimei(RString.EMPTY);
            エラー結果.setBiko(RString.EMPTY);
            処理結果リスト一時tableWriter.insert(エラー結果);
        }
    }
}
