/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.CareManagementEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.CareManagementRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のListケアマネジメント費のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class CareManagementListCreateProcess extends BatchProcessBase<CareManagementRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "getケアマネジメント費");
    @BatchWriter
    BatchEntityCreatedTempTableWriter ケアマネジメント費List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        ケアマネジメント費List = new BatchEntityCreatedTempTableWriter(CareManagementEntity.TABLE_NAME,
                CareManagementEntity.class);
    }

    @Override
    protected void process(CareManagementRelateEntity entity) {
        ケアマネジメント費List.insert(getケアマネジメント費データ(entity));
    }

    private CareManagementEntity getケアマネジメント費データ(CareManagementRelateEntity entity) {
        CareManagementEntity ケアマネジメント費データ = new CareManagementEntity();
        ケアマネジメント費データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        ケアマネジメント費データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        ケアマネジメント費データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        ケアマネジメント費データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        ケアマネジメント費データ.set通し番号(entity.getDbt3017().getToshiNo());
        ケアマネジメント費データ.set明細行番号(entity.getDbt3031().getServicePlanhiMeisaiLineNo());
        ケアマネジメント費データ.set指定基準該当等事業所区分コード(entity.getDbt3031().getShiteiKijungaitoJigyoshoKubunCode());
        ケアマネジメント費データ.set単位数単価(entity.getDbt3031().getTanisuTanka());
        ケアマネジメント費データ.set居宅サービス計画作成依頼届出年月日(entity.getDbt3031().getKyotakuServiceSakuseiIraiYMD());
        ケアマネジメント費データ.setサービスコード(entity.getDbt3031().getServiceCode().value());
        ケアマネジメント費データ.set単位数(entity.getDbt3031().getTanisu());
        ケアマネジメント費データ.set回数(entity.getDbt3031().getKaisu());
        ケアマネジメント費データ.setサービス単位数(entity.getDbt3031().getServiceTanisu());
        ケアマネジメント費データ.setサービス単位数合計(entity.getDbt3031().getSerivceTanisuTotal());
        ケアマネジメント費データ.set請求金額(entity.getDbt3031().getSeikyuKingaku());
        ケアマネジメント費データ.set利用者負担額(entity.getDbt3031().getRiyoushaFutangaku());
        ケアマネジメント費データ.set担当介護支援専門員番号(entity.getDbt3031().getTantoKaigoShienSemmoninNo());
        ケアマネジメント費データ.set摘要(entity.getDbt3031().getTekiyo());
        ケアマネジメント費データ.set後単位数(entity.getDbt3031().getAtoTanisu());
        ケアマネジメント費データ.set後回数(entity.getDbt3031().getAtoKaisu());
        ケアマネジメント費データ.set後サービス単位数(entity.getDbt3031().getAtoServiceTanisu());
        ケアマネジメント費データ.set後サービス単位数合計(entity.getDbt3031().getAtoServiceTanisuTotal());
        ケアマネジメント費データ.set後請求金額(entity.getDbt3031().getAtoSeikyuKingaku());
        ケアマネジメント費データ.set後利用者負担額(entity.getDbt3031().getAtoRiyoshaFutangaku());
        ケアマネジメント費データ.set再審査回数(entity.getDbt3031().getSaishinsaKaisu());
        ケアマネジメント費データ.set過誤回数(entity.getDbt3031().getKagoKaisu());
        ケアマネジメント費データ.set審査年月(entity.getDbt3031().getShinsaYM());
        ケアマネジメント費データ.set略称(entity.getDbT3118_ryakusho());
        return ケアマネジメント費データ;
    }

}
