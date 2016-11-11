/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShakaiHukushiHouzinKeigenEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShakaiHukushiHouzinKeigenRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のList社会福祉法人軽減額のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class ShakaiHukushiHouzinKeigenListCreateProcess extends BatchProcessBase<ShakaiHukushiHouzinKeigenRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get社会福祉法人軽減額");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 社会福祉法人軽減額List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        社会福祉法人軽減額List = new BatchEntityCreatedTempTableWriter(ShakaiHukushiHouzinKeigenEntity.TABLE_NAME,
                ShakaiHukushiHouzinKeigenEntity.class);
    }

    @Override
    protected void process(ShakaiHukushiHouzinKeigenRelateEntity entity) {
        社会福祉法人軽減額List.insert(get社会福祉法人軽減額データ(entity));
    }

    private ShakaiHukushiHouzinKeigenEntity get社会福祉法人軽減額データ(ShakaiHukushiHouzinKeigenRelateEntity entity) {
        ShakaiHukushiHouzinKeigenEntity 社会福祉法人軽減額データ = new ShakaiHukushiHouzinKeigenEntity();
        社会福祉法人軽減額データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        社会福祉法人軽減額データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        社会福祉法人軽減額データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        社会福祉法人軽減額データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        社会福祉法人軽減額データ.set通し番号(entity.getDbt3017().getToshiNo());
        社会福祉法人軽減額データ.setサービス種類コード(entity.getDbt3030().getServiceSyuruiCode().value());
        社会福祉法人軽減額データ.set軽減率(entity.getDbt3030().getKeigenritsu());
        社会福祉法人軽減額データ.set受領すべき利用者負担の総額(entity.getDbt3030().getRiyoshaFutanTotal());
        社会福祉法人軽減額データ.set軽減額(entity.getDbt3030().getKeigengaku());
        社会福祉法人軽減額データ.set軽減後利用者負担額(entity.getDbt3030().getKeigengoRiyoshaFutangaku());
        社会福祉法人軽減額データ.set備考(entity.getDbt3030().getBiko());
        社会福祉法人軽減額データ.set後受領すべき利用者負担の総額(entity.getDbt3030().getAtoRiyoshaFutanTotal());
        社会福祉法人軽減額データ.set後軽減額(entity.getDbt3030().getAtoKeigengaku());
        社会福祉法人軽減額データ.set後軽減後利用者負担額(entity.getDbt3030().getAtoKeigengoRiyoshaFutangaku());
        社会福祉法人軽減額データ.set再審査回数(entity.getDbt3030().getSaishinsaKaisu());
        社会福祉法人軽減額データ.set過誤回数(entity.getDbt3030().getKagoKaisu());
        社会福祉法人軽減額データ.set審査年月(entity.getDbt3030().getShinsaYM());
        社会福祉法人軽減額データ.set略称(entity.getDbT3118_ryakusho());
        return 社会福祉法人軽減額データ;
    }

}
