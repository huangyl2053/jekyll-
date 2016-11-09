/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.HukushiYouguEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.HukushiYouguRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のList福祉用具のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class HukushiYouguListCreateProcess extends BatchProcessBase<HukushiYouguRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get福祉用具");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 福祉用具List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        福祉用具List = new BatchEntityCreatedTempTableWriter(HukushiYouguEntity.TABLE_NAME,
                HukushiYouguEntity.class);
    }

    @Override
    protected void process(HukushiYouguRelateEntity entity) {
        福祉用具List.insert(get福祉用具データ(entity));
    }

    private HukushiYouguEntity get福祉用具データ(HukushiYouguRelateEntity entity) {
        HukushiYouguEntity 福祉用具データ = new HukushiYouguEntity();
        福祉用具データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        福祉用具データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        福祉用具データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        福祉用具データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        福祉用具データ.set通し番号(entity.getDbt3017().getToshiNo());
        福祉用具データ.set明細番号(entity.getDbt3026().getMeisaiNo());
        福祉用具データ.setサービスコード(entity.getDbt3026().getServiceCode().value());
        福祉用具データ.set福祉用具購入年月日(entity.getDbt3026().getFukushiyoguHanbaiYMD());
        福祉用具データ.set摘要(entity.getDbt3026().getTekiyo());
        福祉用具データ.set審査年月(entity.getDbt3026().getShinsaYM());
        福祉用具データ.set福祉用具商品名(entity.getDbt3026().getFukushiyoguShohinName());
        福祉用具データ.set福祉用具製造事業者名(entity.getDbt3026().getFukushiyoguSeizoJigyoshaName());
        福祉用具データ.set福祉用具販売事業者名(entity.getDbt3026().getFukushiyoguHanbaiJigyoshaName());
        福祉用具データ.set福祉用具種目コード(entity.getDbt3026().getFukushiyoguSyumokuCode());
        福祉用具データ.set購入金額(entity.getDbt3026().getHanbaiKingaku());
        return 福祉用具データ;
    }
}
