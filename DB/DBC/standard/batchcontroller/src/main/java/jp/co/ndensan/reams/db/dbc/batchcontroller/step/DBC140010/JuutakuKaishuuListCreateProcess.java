/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.JuutakuKaishuuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.JuutakuKaishuuRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のList住宅改修のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class JuutakuKaishuuListCreateProcess extends BatchProcessBase<JuutakuKaishuuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get住宅改修");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 住宅改修List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        住宅改修List = new BatchEntityCreatedTempTableWriter(JuutakuKaishuuEntity.TABLE_NAME,
                JuutakuKaishuuEntity.class);
    }

    @Override
    protected void process(JuutakuKaishuuRelateEntity entity) {
        住宅改修List.insert(get住宅改修データ(entity));
    }

    private JuutakuKaishuuEntity get住宅改修データ(JuutakuKaishuuRelateEntity entity) {
        JuutakuKaishuuEntity 住宅改修データ = new JuutakuKaishuuEntity();
        住宅改修データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        住宅改修データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        住宅改修データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        住宅改修データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        住宅改修データ.set通し番号(entity.getDbt3017().getToshiNo());
        住宅改修データ.set明細番号(entity.getDbt3027().getMeisaiNo());
        住宅改修データ.setサービスコード(entity.getDbt3027().getServiceCode().value());
        住宅改修データ.set住宅改修着工年月日(entity.getDbt3027().getJutakuKaishuchakkoYMD());
        住宅改修データ.set改修金額(entity.getDbt3027().getKaishuKingaku());
        住宅改修データ.set審査年月(entity.getDbt3027().getShinsaYM());
        住宅改修データ.set住宅改修事業者名(entity.getDbt3027().getJutakuKaishuJigyoshaName());
        住宅改修データ.set住宅改修住宅住所(entity.getDbt3027().getJuutakukaishuJyutakuAdress());
        return 住宅改修データ;
    }

}
