/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC130020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020.TorikomiKokiKoreshaJyohoImportEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 後期高齢者情報に登録パラメータフロークラスです。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
public class InsKokuhoShikakuJyohoProcess extends BatchProcessBase<TorikomiKokiKoreshaJyohoImportEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc130020.IKokikoreishaShikakuIdoInMapper.get取込後期高齢者情報インポート用Entityリスト");
    private static final RString 履歴番号 = new RString("0001");
    @BatchWriter
    private IBatchTableWriter<DbT7124KokiKoreishaInfoEntity> 現在後期高齢者情報Writer;

    @Override
    protected void beforeExecute() {
        IKokikoreishaShikakuIdoInMapper mapper = getMapper(IKokikoreishaShikakuIdoInMapper.class);
        if (mapper.get取込後期高齢者情報インポート用Entitｙ件数() > 0) {
            mapper.delete取込後期高齢者情報();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        現在後期高齢者情報Writer = BatchWriters.batchPermanentTableWriter(DbT7124KokiKoreishaInfoEntity.class).build();
    }

    @Override
    protected void process(TorikomiKokiKoreshaJyohoImportEntity entity) {
        現在後期高齢者情報Writer.insert(get現在後期高齢者情報Entity(entity));
    }

    private DbT7124KokiKoreishaInfoEntity get現在後期高齢者情報Entity(TorikomiKokiKoreshaJyohoImportEntity entity) {
        DbT7124KokiKoreishaInfoEntity 現在後期高齢者情報Entity = new DbT7124KokiKoreishaInfoEntity();
        現在後期高齢者情報Entity.setShikibetsuCd(new ShikibetsuCode(entity.get識別コード()));
        if (entity.get履歴番号() != null) {
            現在後期高齢者情報Entity.setRirekiNo(entity.get履歴番号());
        } else {
            現在後期高齢者情報Entity.setRirekiNo(履歴番号);
        }
        現在後期高齢者情報Entity.setKokiHokenshaNoCity(entity.get後期高齢保険者番号_市町村());
        現在後期高齢者情報Entity.setKokiHokenshaNoKoiki(entity.get後期高齢保険者番号_広域());
        現在後期高齢者情報Entity.setKokikoreiHihokenshaNo(entity.get後期高齢被保険者番号());
        現在後期高齢者情報Entity.setShikakuShutokuJiyuCode(entity.get資格取得事由コード());
        現在後期高齢者情報Entity.setShikakuShutokuYMD(entity.get資格取得日());
        現在後期高齢者情報Entity.setShikakuSoshitsuJiyuCode(entity.get資格喪失事由コード());
        現在後期高齢者情報Entity.setShikakuSoshitsuYMD(entity.get資格喪失日());
        現在後期高齢者情報Entity.setHokenshaKaishiYMD(entity.get保険者適用開始日());
        現在後期高齢者情報Entity.setHokenshaShuryoYMD(entity.get保険者適用終了日());
        現在後期高齢者情報Entity.setKojinKubunCode(entity.get個人区分コード());
        現在後期高齢者情報Entity.setTorokuKubun(entity.get登録区分());
        return 現在後期高齢者情報Entity;
    }
}
