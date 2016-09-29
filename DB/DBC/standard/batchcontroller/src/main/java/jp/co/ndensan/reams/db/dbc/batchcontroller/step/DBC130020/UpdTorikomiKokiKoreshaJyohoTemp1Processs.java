/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130020.UpdTorikomiKokuhoJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper;
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
public class UpdTorikomiKokiKoreshaJyohoTemp1Processs extends BatchProcessBase<TorikomiKokiKoreshaJyohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper.get取込後期高齢者情報");
    private List<TorikomiKokiKoreshaJyohoEntity> 取込後期高齢者情報Entityリスト;
    private int 検索件数;
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString エラーコード_13 = new RString("13");
    private static final RString エラーコード_72 = new RString("72");
    private static final RString コード文言_住民コード = new RString("住民コードが重複しています。１件のみ登録します");
    private static final RString エラー区分 = new RString("1");
    private static final RString TEMP_TABLE = new RString("tempTorikomiKokuhoJyoho");
    private UpdTorikomiKokuhoJyohoTempProcessParameter processParameter;

    @BatchWriter
    private IBatchTableWriter<TorikomiKokiKoreshaJyohoEntity> 一時tableWriter;

    @Override
    protected void initialize() {
        IKokikoreishaShikakuIdoInMapper mapper = getMapper(IKokikoreishaShikakuIdoInMapper.class);
        取込後期高齢者情報Entityリスト = mapper.get取込後期高齢者情報();
        検索件数 = 0;
    }

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
    protected void process(TorikomiKokiKoreshaJyohoEntity entity) {
        for (TorikomiKokiKoreshaJyohoEntity 取込国保情報Entity : 取込後期高齢者情報Entityリスト) {
            if (entity.get住民コード().equals(取込国保情報Entity.get住民コード())) {
                検索件数++;
            }
        }
        if (検索件数 > 1) {
            if (ＩＦ種類_電算.equals(processParameter.getIF種類())) {
                entity.setエラーコード(エラーコード_13);
                entity.setエラー文言(コード文言_住民コード);
                entity.setエラー区分(エラー区分);
            }

            if (ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
                entity.setエラーコード(エラーコード_72);
                entity.setエラー文言(コード文言_住民コード);
                entity.setエラー区分(エラー区分);
            }
        }
        //TODO  仕様の意味は分かりません
        //4.3　4.1にて取得したレコードの中で、資格取得日、資格喪失日が最も大きいレコードに対して項目編集を行なう
        //4.4　バッチパラメータ．保険者区分が "1"(単独保険者)の場合 単一時、住民コードの長さ＞12桁の場合、住民コードの後方１２桁を設定
        一時tableWriter.update(entity);
    }
}
