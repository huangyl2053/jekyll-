/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.UpdTorikomiKokuhoJyohoTemp2ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.TorikomiKokuhoJyohoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.TorikomiKokuhoJyohoResultEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBC130010_国保資格異動情報取込
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class UpdTorikomiKokuhoJyohoTemp2Process extends BatchProcessBase<TorikomiKokuhoJyohoResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper.get取込国保情報Temp");
    @BatchWriter
    private IBatchTableWriter<TorikomiKokuhoJyohoEntity> torikomiKokuhoJyohoWriter;
    private UpdTorikomiKokuhoJyohoTemp2ProcessParameter processParameter;
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString エラーコード_14 = new RString("14");
    private static final RString エラーコード_70 = new RString("70");
    private static final RString コード文言_住民コード = new RString("住民コードが重複しています。１件のみ登録します");
    private static final RString エラー区分 = new RString("1");
    private static final RString TEMP_TABLE = new RString("tempTorikomiKokuhoJyoho");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        torikomiKokuhoJyohoWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorikomiKokuhoJyohoEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(TorikomiKokuhoJyohoResultEntity entity) {
        if (entity.get件数() > 1) {
            if (ＩＦ種類_電算.equals(processParameter.getIf種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_14);
                entity.get取込国保情報Entity().setエラー文言(コード文言_住民コード);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }

            if (ＩＦ種類_電算２.equals(processParameter.getIf種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_70);
                entity.get取込国保情報Entity().setエラー文言(コード文言_住民コード);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }
        }
        torikomiKokuhoJyohoWriter.update(entity.get取込国保情報Entity());
    }
}
