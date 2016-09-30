/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130010.UpdTorikomiKokuhoJyohoTemp2ProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010.TorikomiKokuhoJyohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper;
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
public class UpdTorikomiKokuhoJyohoTemp2Process extends BatchProcessBase<TorikomiKokuhoJyohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130010.IKokuhoShikakuIdoInMapper.get取込国保情報Temp");
    private List<TorikomiKokuhoJyohoEntity> 取込国保情報Entityリスト;
    private int 検索件数;
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
    protected void initialize() {
        IKokuhoShikakuIdoInMapper mapper = getMapper(IKokuhoShikakuIdoInMapper.class);
        取込国保情報Entityリスト = mapper.get取込国保情報Temp();
        検索件数 = 0;
    }

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
    protected void process(TorikomiKokuhoJyohoEntity entity) {
        for (TorikomiKokuhoJyohoEntity 取込国保情報Entity : 取込国保情報Entityリスト) {
            if (entity.getIN住民コード().equals(取込国保情報Entity.getIN住民コード())) {
                検索件数++;
            }
        }

        if (検索件数 > 1) {
            if (ＩＦ種類_電算.equals(processParameter.getIf種類())) {
                entity.setエラーコード(エラーコード_14);
                entity.setエラー文言(コード文言_住民コード);
                entity.setエラー区分(エラー区分);
            }

            if (ＩＦ種類_電算２.equals(processParameter.getIf種類())) {
                entity.setエラーコード(エラーコード_70);
                entity.setエラー文言(コード文言_住民コード);
                entity.setエラー区分(エラー区分);
            }
        }

        //TODO  仕様の意味は分かりません
        //4.3　4.1にて取得したレコードの中で、資格取得日、資格喪失日が最も大きいレコードに対して項目編集を行なう
        //4.4　バッチパラメータ．保険者区分が "1"(単独保険者)の場合 単一時、住民コードの長さ＞12桁の場合、住民コードの後方１２桁を設定
        torikomiKokuhoJyohoWriter.update(entity);
    }
}
