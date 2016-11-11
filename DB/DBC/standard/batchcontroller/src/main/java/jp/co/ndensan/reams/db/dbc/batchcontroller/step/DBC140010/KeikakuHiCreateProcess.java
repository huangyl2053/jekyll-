/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KeikakuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KeikakuHiRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳の計画費のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class KeikakuHiCreateProcess extends BatchProcessBase<KeikakuHiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get計画費");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 計画費List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        計画費List = new BatchEntityCreatedTempTableWriter(KeikakuHiEntity.TABLE_NAME,
                KeikakuHiEntity.class);
    }

    @Override
    protected void process(KeikakuHiRelateEntity entity) {
        計画費List.insert(get給付実績居宅サービス計画費データ(entity));
    }

    private KeikakuHiEntity get給付実績居宅サービス計画費データ(KeikakuHiRelateEntity entity) {
        KeikakuHiEntity 計画費データ = new KeikakuHiEntity();
        計画費データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        計画費データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        計画費データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        計画費データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        計画費データ.set通し番号(entity.getDbt3017().getToshiNo());
        計画費データ.set明細行番号(entity.getDbt3025().getServicePlanhiMeisaiLineNo());
        計画費データ.set指定基準該当等事業所区分コード(entity.getDbt3025().getShiteiKijunGaitoJigyoshaKubunCode());
        計画費データ.set単位数単価(entity.getDbt3025().getTanisuTanka());
        計画費データ.set居宅サービス計画作成依頼届出年月日(entity.getDbt3025().getKyotakuServiceSakuseiIraiYMD());
        計画費データ.setサービスコード(entity.getDbt3025().getServiceCode());
        計画費データ.set単位数(entity.getDbt3025().getTanisu());
        計画費データ.set回数(entity.getDbt3025().getKaisu());
        計画費データ.setサービス単位数(entity.getDbt3025().getServiceTanisu());
        計画費データ.setサービス単位数合計(entity.getDbt3025().getServiceTanisuTotal());
        計画費データ.set請求金額(entity.getDbt3025().getSeikyuKingaku());
        計画費データ.set担当介護支援専門員番号(entity.getDbt3025().getTantouKaigoShienSemmoninNo());
        計画費データ.set摘要(entity.getDbt3025().getTekiyo());
        計画費データ.set後単位数(entity.getDbt3025().getAtoTanisu());
        計画費データ.set後回数(entity.getDbt3025().getAtoKaisu());
        計画費データ.set後サービス単位数(entity.getDbt3025().getAtoServiceTanisu());
        計画費データ.set後サービス単位数合計(entity.getDbt3025().getAtoServiceTanisuTotal());
        計画費データ.set後請求金額(entity.getDbt3025().getAtoSeikyuKingaku());
        計画費データ.set再審査回数(entity.getDbt3025().getSaishinsaKaisu());
        計画費データ.set過誤回数(entity.getDbt3025().getKagoKaisu());
        計画費データ.set審査年月(entity.getDbt3025().getShinsaYM());
        計画費データ.set略称(entity.getDbT3118_ryakusho());
        return 計画費データ;
    }

}
