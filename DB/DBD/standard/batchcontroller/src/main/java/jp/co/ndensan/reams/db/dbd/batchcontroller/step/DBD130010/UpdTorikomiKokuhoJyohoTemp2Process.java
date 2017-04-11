/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD130010;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd130010.UpdTorikomiKokuhoJyohoTemp2ProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd130010.TorikomiKokuhoJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd130010.TorikomiKokuhoJyohoResultEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBD130010_国保資格異動情報取込
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
public class UpdTorikomiKokuhoJyohoTemp2Process extends BatchProcessBase<TorikomiKokuhoJyohoResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.dbd130010.IKokuhoShikakuIdoInMapper.get取込国保情報Temp");
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
    private boolean 文言設定flag;

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
        文言設定flag = entity.get取込国保情報Entity().is文言設定flag();
        if (entity.get件数() > 1 && ＩＦ種類_電算.equals(processParameter.getIf種類())) {
            entity.get取込国保情報Entity().setエラーコード(エラーコード_14);
            if (文言設定flag) {
                entity.get取込国保情報Entity().setエラー文言(コード文言_住民コード);
                文言設定flag = false;
            }
            entity.get取込国保情報Entity().setエラー区分(エラー区分);
        }

        if (entity.get件数() > 1 && ＩＦ種類_電算２.equals(processParameter.getIf種類())) {
            entity.get取込国保情報Entity().setエラーコード(エラーコード_70);
            if (文言設定flag) {
                entity.get取込国保情報Entity().setエラー文言(コード文言_住民コード);
                文言設定flag = false;
            }
            entity.get取込国保情報Entity().setエラー区分(エラー区分);
        }
        entity.get取込国保情報Entity().set文言設定flag(文言設定flag);
        torikomiKokuhoJyohoWriter.update(entity.get取込国保情報Entity());
    }
}
