/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130020.UpdTorikomiKokuhoJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreshaJyohoRealEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 後期高齢者情報のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public class UpdTorikomiKokiKoreshaJyohoTemp1Processs extends BatchProcessBase<KokiKoreshaJyohoRealEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper.get取込後期高齢者情報");
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString エラーコード_13 = new RString("13");
    private static final RString エラーコード_72 = new RString("72");
    private static final RString コード文言_住民コード = new RString("住民コードが重複しています。１件のみ登録します");
    private static final RString エラー区分 = new RString("1");
    private static final RString TEMP_TABLE = new RString("tempTorikomiKokuhoJyoho");
    private UpdTorikomiKokuhoJyohoTempProcessParameter processParameter;
    private boolean 文言設定flag;

    @BatchWriter
    private IBatchTableWriter<TorikomiKokiKoreshaJyohoEntity> 一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        一時tableWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorikomiKokiKoreshaJyohoEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KokiKoreshaJyohoRealEntity entity) {
        文言設定flag = entity.get取込後期高齢者情報Entity().is文言設定flag();
        if (entity.get件数() > 1) {
            if (ＩＦ種類_電算.equals(processParameter.getIF種類())) {
                entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_13);
                entity.get取込後期高齢者情報Entity().setエラー文言(コード文言_住民コード);
                entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
            }

            if (ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
                entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_72);
                entity.get取込後期高齢者情報Entity().setエラー文言(コード文言_住民コード);
                entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
            }
        }
        entity.get取込後期高齢者情報Entity().set文言設定flag(文言設定flag);
        一時tableWriter.update(entity.get取込後期高齢者情報Entity());
    }
}
