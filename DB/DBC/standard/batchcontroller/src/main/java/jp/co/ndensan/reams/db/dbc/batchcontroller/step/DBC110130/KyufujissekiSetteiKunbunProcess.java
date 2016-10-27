/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110130;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hokenshakyufujisseki.KyufujissekiSetteiKunbunEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikihon.DbWT1131KyufujissekiKihonTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のバッチ設定区分の取得Processです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
public class KyufujissekiSetteiKunbunProcess extends BatchProcessBase<KyufujissekiSetteiKunbunEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hokenshakyufujisseki."
            + "IHokenshaKyufujissekiMapper.get設定区分");
    private static final RString 給付実績基本一時NAME = new RString("DbWT1131KyufujissekiKihon");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績基本一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        給付実績基本一時tableWriter
                = new BatchEntityCreatedTempTableWriter(給付実績基本一時NAME, DbWT1131KyufujissekiKihonTempEntity.class);
    }

    @Override
    protected void process(KyufujissekiSetteiKunbunEntity entity) {
        DbWT1131KyufujissekiKihonTempEntity updateEntity = get基本一時Entity(entity);
        給付実績基本一時tableWriter.update(updateEntity);
    }

    private DbWT1131KyufujissekiKihonTempEntity get基本一時Entity(KyufujissekiSetteiKunbunEntity entity) {
        DbWT1131KyufujissekiKihonTempEntity tempEntity = entity.get給付実績基本一時データEntity();
        DbT3118ShikibetsuNoKanriEntity 管理entity = entity.get識別番号管理Entity();
        tempEntity.setMeisaiSetteiKubun(管理entity.getMeisaiSetteiKubun());
        tempEntity.setKinkyuShisetsuRyoyoSetteiKubun(管理entity.getKinkyuShisetsuRyoyoSetteiKubun());
        tempEntity.setTokuteiShinryoSetteiKubun(管理entity.getTokuteiShinryoSetteiKubun());
        tempEntity.setShokujiHiyosetteiKubun(管理entity.getShokujiHiyosetteiKubun());
        tempEntity.setKyotakuKeikakuSetteiKubun(管理entity.getKyotakuKeikakuSetteiKubun());
        tempEntity.setFukushoyouguKonyuSetteiKubun(管理entity.getFukushoyouguKonyuSetteiKubun());
        tempEntity.setJutakukaishuSetteiKubun(管理entity.getJutakukaishuSetteiKubun());
        tempEntity.setTokuteishinryoTokubetsuryoyoSetteiKubun(管理entity.getTokuteishinryoTokubetsuryoyoSetteiKubun());
        tempEntity.setTokuteinyushoshaSetteiKubun(管理entity.getTokuteinyushoshaSetteiKubun());
        tempEntity.setShakaifukushiKeigenSetteiKubun(管理entity.getShakaifukushiKeigenSetteiKubun());
        tempEntity.setShoteiShikkanSetteiKubun(管理entity.getShoteiShikkanSetteiKubun());
        tempEntity.setMeisaiJushochitokureiSetteiKubun(管理entity.getMeisaiJushochitokureiSetteiKubun());
        tempEntity.setShukeiSetteiKubun(管理entity.getShukeiSetteiKubun());
        return tempEntity;
    }
}
