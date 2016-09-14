/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120140;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38G1KetteishaIchiranTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu.ShikyuFushikyuTsuchishoIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座情報を登録する。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
public class ShikyuFushikyuKozaJohoTorokuProcess extends BatchProcessBase<ShikyuFushikyuTsuchishoIchiranEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper"
            + ".relate.shikyufushikyu.IShikyuFushikyuInMapper.get通知書および一覧情報");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 高額合算支給不支給決定一時tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時tableWriter;
    private static final RString 高額合算支給不支給決定一時_TABLE_NAME
            = new RString("DbWT38B1KogakuGassanShikyuFushikyuKettei");
    private static final RString 処理結果リスト一時_TABLE_NAME = new RString("DbWT0002KokuhorenTorikomiError");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算支給不支給決定一時tableWriter
                = new BatchEntityCreatedTempTableWriter(高額合算支給不支給決定一時_TABLE_NAME,
                        DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity.class);
        処理結果リスト一時tableWriter
                = new BatchEntityCreatedTempTableWriter(処理結果リスト一時_TABLE_NAME,
                        DbWT0002KokuhorenTorikomiErrorEntity.class);
    }

    @Override
    protected void process(ShikyuFushikyuTsuchishoIchiranEntity entity) {
        if (null != entity.get一覧データ()) {
            do口座情報登録(entity.get通知書データ(), entity.get一覧データ());
        } else {
            do通知書データのみ登録(entity.get通知書データ());
        }

    }

    private void do口座情報登録(DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 通知書データ,
            DbWT38G1KetteishaIchiranTempEntity 一覧データ) {
        通知書データ.set対象年度(一覧データ.get申請対象年度());
        通知書データ.set金融機関コード(一覧データ.get金融機関コード());
        通知書データ.set金融機関支店コード(一覧データ.get金融機関支店コード());
        通知書データ.set口座種目(一覧データ.get口座種目());
        高額合算支給不支給決定一時tableWriter.update(通知書データ.toEntity());
    }

    private void do通知書データのみ登録(DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 通知書データ) {
        DbWT0002KokuhorenTorikomiErrorEntity entity = new DbWT0002KokuhorenTorikomiErrorEntity();
        entity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.データ不正_通知書データのみ.getコード());
        entity.setHihokenshaNo(通知書データ.get被保険者番号());
        entity.setKey1(通知書データ.get帳票関連付け番号());
        処理結果リスト一時tableWriter.insert(entity);
    }

}
