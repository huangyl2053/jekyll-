/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC180050;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KyuhuzissekiJohoSakuseiResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc180050.KyuhuzissekiJohoTempEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBCMNK4001_更正対象給付実績一覧(給付実績集計情報の取得)
 *
 * @reamsid_L DBC-4960-030 dengwei
 */
public class KyuhuzissekiJohoSakuseiProcess extends BatchProcessBase<KyuhuzissekiJohoSakuseiResultEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc180050.IKoseiTaishoKyufuJissekiIchiranMapper.get給付実績情報作成データ");
    @BatchWriter
    private IBatchTableWriter<KyuhuzissekiJohoTempEntity> tempTableWriter;
    private static final RString TEMP_TABLE = new RString("kyuhuzissekiJohoTemp");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        tempTableWriter = BatchWriters.batchEntityCreatedTempTableWriter(
                KyuhuzissekiJohoTempEntity.class).tempTableName(TEMP_TABLE).build();
    }

    @Override
    protected void process(KyuhuzissekiJohoSakuseiResultEntity entity) {
        KyuhuzissekiJohoTempEntity tempEntity = new KyuhuzissekiJohoTempEntity();
        tempEntity.set被保険者番号(entity.get被保険者番号());
        tempEntity.set年度(entity.get年度());
        tempEntity.set入力識別番号(entity.get入力識別番号());
        tempEntity.setサービス提供年月(entity.getサービス提供年月());
        tempEntity.set事業所番号(entity.get事業所番号());
        tempEntity.set整理番号(entity.get整理番号());
        tempEntity.setサービス種類コード(entity.getサービス種類コード());
        tempEntity.set給付実績情報作成区分コード(entity.get給付実績情報作成区分コード());
        tempEntity.set保険給付率(entity.get保険給付率());
        tempEntity.set後保険請求分請求額(entity.get後保険請求分請求額());
        tempEntity.set利用者負担額(entity.get利用者負担額());
        if (entity.get軽減率() != null) {
            tempEntity.set軽減率(entity.get軽減率());
        }

        if (entity.get後軽減後利用者負担額() != null) {
            tempEntity.set軽減後自己負担額(entity.get後軽減後利用者負担額());
        }

        if (entity.get支払済金額合計() != null
                && entity.get高額支給額() != null) {
            tempEntity.set高額サービス費用額(entity.get支払済金額合計().add(entity.get高額支給額()));
        }

        tempTableWriter.insert(tempEntity);
    }
}
