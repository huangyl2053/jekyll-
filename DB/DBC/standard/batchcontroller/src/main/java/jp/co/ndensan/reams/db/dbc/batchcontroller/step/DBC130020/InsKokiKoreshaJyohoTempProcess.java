/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc130020.UpdTorikomiKokuhoJyohoTempProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.KokiKoreshaJyohoResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoImportEntity;
import jp.co.ndensan.reams.db.dbd.definition.core.hikazeinenkin.TorokuKubun;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 後期高齢者情報インポート用に登録Temp
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public class InsKokiKoreshaJyohoTempProcess extends BatchProcessBase<KokiKoreshaJyohoResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper.get後期高齢者情報インポート用データ");
    private TorikomiKokiKoreshaJyohoImportEntity 後期高齢者情報インポート用Entity;
    private UpdTorikomiKokuhoJyohoTempProcessParameter processParameter;
    private static final RString ＩＦ種類_電算 = new RString("1");
    private static final RString ＩＦ種類_電算２ = new RString("2");
    private static final RString 登録区分_画面登録 = new RString("1");
    private static final RString エラー区分_正常データ = new RString("0");
    private static final RString 取込形式_全件 = new RString("1");
    private static final RString 取込形式_差分 = new RString("2");
    private static final RString エラーコード_32 = new RString("32");
    private static final RString エラーコード_82 = new RString("82");
    private static final RString エラーコード文言 = new RString("画面登録されたデータです");
    private static final RString エラー区分 = new RString("1");
    private static final RString TEMP_TABLE = new RString("tempKokuhoShikakuJyohoInpotoyo");
    @BatchWriter
    private IBatchTableWriter<TorikomiKokiKoreshaJyohoImportEntity> torikomiKokuhoJyohoEntityWriter;

    @Override
    protected void initialize() {
        後期高齢者情報インポート用Entity = null;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        torikomiKokuhoJyohoEntityWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                TorikomiKokiKoreshaJyohoImportEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KokiKoreshaJyohoResultEntity entity) {
        if (entity.get取込後期高齢者情報Entity() != null
                && entity.get現在後期高齢者情報() != null
                && 登録区分_画面登録.equals(entity.get現在後期高齢者情報().getTorokuKubun())) {
            if (ＩＦ種類_電算.equals(processParameter.getIF種類())) {
                entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_32);
                entity.get取込後期高齢者情報Entity().setエラー文言(エラーコード文言);
                entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
            }
            if (ＩＦ種類_電算２.equals(processParameter.getIF種類())) {
                entity.get取込後期高齢者情報Entity().setエラーコード(エラーコード_82);
                entity.get取込後期高齢者情報Entity().setエラー文言(エラーコード文言);
                entity.get取込後期高齢者情報Entity().setエラー区分(エラー区分);
            }
            if (エラー区分_正常データ.equals(entity.get取込後期高齢者情報Entity().getエラー区分())) {
                後期高齢者情報インポート用Entityリストの編集_取込形式_全件(entity);
                後期高齢者情報インポート用Entityリストの編集_取込形式_差分(entity);
            }
        }
        if (後期高齢者情報インポート用Entity != null) {
            torikomiKokuhoJyohoEntityWriter.insert(後期高齢者情報インポート用Entity);
        }
    }

    private void 後期高齢者情報インポート用Entityリストの編集_取込形式_全件(KokiKoreshaJyohoResultEntity entity) {
        if (取込形式_全件.equals(processParameter.get取込形式())) {
            if (entity.get取込後期高齢者情報Entity() != null
                    && entity.get現在後期高齢者情報() != null) {
                get後期高齢者情報インポート用Entitｙ(entity);
            }
            if (entity.get取込後期高齢者情報Entity() != null
                    && entity.get現在後期高齢者情報() == null) {
                取込後期高齢者情報より_項目設定(entity);
            }
            if (entity.get取込後期高齢者情報Entity() == null
                    && entity.get現在後期高齢者情報() != null
                    && TorokuKubun.画面登録.getコード().equals(entity.get現在後期高齢者情報().getTorokuKubun())) {
                現在後期高齢者情報より_項目設定(entity);
            }
        }
    }

    private void 後期高齢者情報インポート用Entityリストの編集_取込形式_差分(KokiKoreshaJyohoResultEntity entity) {
        if (取込形式_差分.equals(processParameter.get取込形式())) {
            if (entity.get取込後期高齢者情報Entity() != null
                    && entity.get現在後期高齢者情報() != null) {
                get後期高齢者情報インポート用Entitｙ(entity);
            }
            if (entity.get取込後期高齢者情報Entity() != null
                    && entity.get現在後期高齢者情報() != null) {
                取込後期高齢者情報より_項目設定(entity);
            }
            if (entity.get取込後期高齢者情報Entity() != null
                    && entity.get現在後期高齢者情報() != null) {
                現在後期高齢者情報より_項目設定(entity);
            }
        }
    }

    private void get後期高齢者情報インポート用Entitｙ(KokiKoreshaJyohoResultEntity entity) {
        if (entity.get取込後期高齢者情報Entity() != null) {
            if (!TorokuKubun.画面登録.getコード().equals(entity.get現在後期高齢者情報().getTorokuKubun())) {
                取込後期高齢者情報より_項目設定(entity);
            } else {
                現在後期高齢者情報より_項目設定(entity);
            }
        }
    }

    private void 取込後期高齢者情報より_項目設定(KokiKoreshaJyohoResultEntity entity) {
        if (!TorokuKubun.画面登録.getコード().equals(entity.get取込後期高齢者情報Entity().get登録区分())) {
            後期高齢者情報インポート用Entity.set識別コード(entity.get取込後期高齢者情報Entity().get住民コード());
            後期高齢者情報インポート用Entity.set個人区分コード(entity.get取込後期高齢者情報Entity().get個人区分コード());
            後期高齢者情報インポート用Entity.set後期高齢保険者番号_市町村(entity.get取込後期高齢者情報Entity().get後期高齢保険者番号_市町村());
            後期高齢者情報インポート用Entity.set後期高齢保険者番号_広域(entity.get取込後期高齢者情報Entity().get後期高齢保険者番号_広域());
            後期高齢者情報インポート用Entity.set後期高齢被保険者番号(entity.get取込後期高齢者情報Entity().get後期高齢被保険者番号());
            後期高齢者情報インポート用Entity.set資格取得事由コード(entity.get取込後期高齢者情報Entity().get資格取得事由コード());
            後期高齢者情報インポート用Entity.set資格喪失事由コード(entity.get取込後期高齢者情報Entity().get資格喪失事由コード());
            後期高齢者情報インポート用Entity.set履歴番号(entity.get取込後期高齢者情報Entity().get履歴番号());
            後期高齢者情報インポート用Entity.set登録区分(entity.get取込後期高齢者情報Entity().get登録区分());
            後期高齢者情報インポート用Entity.set資格取得日(entity.get取込後期高齢者情報Entity().get資格取得年月日());
            後期高齢者情報インポート用Entity.set資格喪失日(entity.get取込後期高齢者情報Entity().get資格喪失年月日());
            後期高齢者情報インポート用Entity.set保険者適用開始日(entity.get取込後期高齢者情報Entity().get保険者適用開始年月日());
            後期高齢者情報インポート用Entity.set保険者適用終了日(entity.get取込後期高齢者情報Entity().get保険者適用開始年月日());
        }
    }

    private void 現在後期高齢者情報より_項目設定(KokiKoreshaJyohoResultEntity entity) {
        後期高齢者情報インポート用Entity.set識別コード(entity.get現在後期高齢者情報().getShikibetsuCd().getColumnValue());
        後期高齢者情報インポート用Entity.set履歴番号(entity.get現在後期高齢者情報().getRirekiNo());
        後期高齢者情報インポート用Entity.set個人区分コード(entity.get現在後期高齢者情報().getKojinKubunCode());
        後期高齢者情報インポート用Entity.set後期高齢保険者番号_市町村(entity.get現在後期高齢者情報().getKokiHokenshaNoCity());
        後期高齢者情報インポート用Entity.set後期高齢保険者番号_広域(entity.get現在後期高齢者情報().getKokiHokenshaNoKoiki());
        後期高齢者情報インポート用Entity.set後期高齢被保険者番号(entity.get現在後期高齢者情報().getKokikoreiHihokenshaNo());
        後期高齢者情報インポート用Entity.set資格取得事由コード(entity.get現在後期高齢者情報().getShikakuShutokuJiyuCode());
        後期高齢者情報インポート用Entity.set資格取得日(entity.get現在後期高齢者情報().getShikakuShutokuYMD());
        後期高齢者情報インポート用Entity.set資格喪失事由コード(entity.get現在後期高齢者情報().getShikakuSoshitsuJiyuCode());
        後期高齢者情報インポート用Entity.set資格喪失日(entity.get現在後期高齢者情報().getShikakuSoshitsuYMD());
        後期高齢者情報インポート用Entity.set保険者適用開始日(entity.get現在後期高齢者情報().getHokenshaKaishiYMD());
        後期高齢者情報インポート用Entity.set保険者適用終了日(entity.get現在後期高齢者情報().getHokenshaShuryoYMD());
        後期高齢者情報インポート用Entity.set登録区分(entity.get現在後期高齢者情報().getTorokuKubun());
    }
}
