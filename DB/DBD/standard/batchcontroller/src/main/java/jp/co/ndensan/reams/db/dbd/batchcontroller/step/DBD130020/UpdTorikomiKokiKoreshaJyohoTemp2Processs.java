/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD130020;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd130020.UpdTorikomiKokuhoJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd130020.KokiKoreshaJyohoDataYoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd130020.TorikomiKokiKoreshaJyohoEntity;
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
public class UpdTorikomiKokiKoreshaJyohoTemp2Processs extends BatchProcessBase<KokiKoreshaJyohoDataYoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper.get後期高齢者情報作成用データ");

    private UpdTorikomiKokuhoJyohoTempProcessParameter processParameter;
    private static final RString TEMP_TABLE = new RString("tempTorikomiKokuhoJyoho");
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString エラーコード_31 = new RString("31");
    private static final RString エラーコード_81 = new RString("81");
    private static final RString エラーコード_12 = new RString("12");
    private static final RString エラーコード_71 = new RString("71");
    private static final RString コード文言_住民コード = new RString("変換後の住民コードが重複しています。１件のみ登録します");
    private static final RString コード文言_宛名なし = new RString("住民情報がありません");
    private static final RString エラー区分 = new RString("1");
    private boolean 文言設定flag;
    @BatchWriter
    private IBatchTableWriter<TorikomiKokiKoreshaJyohoEntity> torikomiKokuhoJyohoEntityWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        torikomiKokuhoJyohoEntityWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorikomiKokiKoreshaJyohoEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KokiKoreshaJyohoDataYoEntity entity) {
        文言設定flag = entity.get取込後期高齢者情報Entity().is文言設定flag();
        if (entity.getデータ件数() != null && entity.getデータ件数() > 1 && ＩＦ種類_電算.equals(processParameter.getIF種類())) {
            entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_31);
            if (文言設定flag) {
                entity.get取込後期高齢者情報Entity().setエラー文言(コード文言_住民コード);
                文言設定flag = false;
            }
            entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
        }
        if (entity.getデータ件数() != null && entity.getデータ件数() > 1 && ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
            entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_81);
            if (文言設定flag) {
                entity.get取込後期高齢者情報Entity().setエラー文言(コード文言_住民コード);
                文言設定flag = false;
            }
            entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
        }

        if (entity.get宛名識別対象Entity() == null && ＩＦ種類_電算.equals(processParameter.getIF種類())) {
            entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_12);
            if (文言設定flag) {
                entity.get取込後期高齢者情報Entity().setエラー文言(コード文言_宛名なし);
                文言設定flag = false;
            }
            entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
        }

        if (entity.get宛名識別対象Entity() == null && ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
            entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_71);
            if (文言設定flag) {
                entity.get取込後期高齢者情報Entity().setエラー文言(コード文言_宛名なし);
                文言設定flag = false;
            }
            entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
        }
        entity.get取込後期高齢者情報Entity().set文言設定flag(文言設定flag);
        torikomiKokuhoJyohoEntityWriter.update(entity.get取込後期高齢者情報Entity());
    }
}
