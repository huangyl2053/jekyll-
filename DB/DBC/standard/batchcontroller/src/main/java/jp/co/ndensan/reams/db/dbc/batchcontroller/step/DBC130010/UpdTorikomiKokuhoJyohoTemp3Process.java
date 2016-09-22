/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.UpdTorikomiKokuhoJyohoTemp3ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.KokuhoKannriDataYoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.TorikomiKokuhoJyohoEntity;
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
public class UpdTorikomiKokuhoJyohoTemp3Process extends BatchProcessBase<KokuhoKannriDataYoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper.get国保管理データ作成用データ");
    @BatchWriter
    private IBatchTableWriter<TorikomiKokuhoJyohoEntity> torikomiKokuhoJyohoEntityWriter;
    private UpdTorikomiKokuhoJyohoTemp3ProcessParameter processParameter;
    private static final RString TEMP_TABLE = new RString("tempTorikomiKokuhoJyoho");
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString エラーコード_31 = new RString("31");
    private static final RString エラーコード_81 = new RString("81");
    private static final RString エラーコード_13 = new RString("13");
    private static final RString エラーコード_69 = new RString("69");
    private static final RString コード文言_住民コード = new RString("変換後の住民コードが重複しています。１件のみ登録します");
    private static final RString コード文言_宛名なし = new RString("住民情報がありません");
    private static final RString エラー区分 = new RString("1");

    @Override
    protected void initialize() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        torikomiKokuhoJyohoEntityWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorikomiKokuhoJyohoEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KokuhoKannriDataYoEntity entity) {
        if (entity.getデータ件数() != null && entity.getデータ件数() > 1) {
            if (ＩＦ種類_電算.equals(processParameter.getIF種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_31);
                entity.get取込国保情報Entity().setエラー文言(コード文言_住民コード);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }

            if (ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_81);
                entity.get取込国保情報Entity().setエラー文言(コード文言_住民コード);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }
        }

        if (entity.get宛名識別対象Entity() == null) {
            if (ＩＦ種類_電算.equals(processParameter.getIF種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_13);
                entity.get取込国保情報Entity().setエラー文言(コード文言_宛名なし);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }

            if (ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
                entity.get取込国保情報Entity().setエラーコード(エラーコード_69);
                entity.get取込国保情報Entity().setエラー文言(コード文言_宛名なし);
                entity.get取込国保情報Entity().setエラー区分(エラー区分);
            }
        }

        torikomiKokuhoJyohoEntityWriter.update(entity.get取込国保情報Entity());
    }
}
