/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiShinryouHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiShinryouHiRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * List給付実績特定診療費の特別療養費のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class TokuteiShinryouHiCreateProcess extends BatchProcessBase<TokuteiShinryouHiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get特定診療費");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 緊急療養List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        緊急療養List = new BatchEntityCreatedTempTableWriter(TokuteiShinryouHiEntity.TABLE_NAME,
                TokuteiShinryouHiEntity.class);
    }

    @Override
    protected void process(TokuteiShinryouHiRelateEntity entity) {
        緊急療養List.insert(get給付実績緊急時施設療養データ(entity));

    }

    private TokuteiShinryouHiEntity get給付実績緊急時施設療養データ(TokuteiShinryouHiRelateEntity entity) {
        TokuteiShinryouHiEntity 緊急療養データ = new TokuteiShinryouHiEntity();
        緊急療養データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        緊急療養データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        緊急療養データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        緊急療養データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        緊急療養データ.set通し番号(entity.getDbt3017().getToshiNo());
        緊急療養データ.set順次番号(entity.getDbt3021().getRecodeJunjiNo());
        緊急療養データ.set傷病名(entity.getDbt3021().getShobyoName());
        緊急療養データ.set再審査回数(entity.getDbt3021().getSaishinsaKaisu());
        緊急療養データ.set過誤回数(entity.getDbt3021().getKagoKaisu());
        緊急療養データ.set審査年月(entity.getDbt3021().getShinsaYM());
        緊急療養データ.set識別番号(entity.getDbt3021().getShikibetsuNo());
        緊急療養データ.set単位数(entity.getDbt3021().getTanisu());
        緊急療養データ.set後単位数(entity.getDbt3021().getAtoTanisu());
        緊急療養データ.set摘要(entity.getDbt3021().getTekiyo());
        緊急療養データ.set回数(entity.getDbt3021().getHokenKaisu());
        緊急療養データ.setサービス点数(entity.getDbt3021().getHokenServiceTanisu());
        緊急療養データ.set合計点数(entity.getDbt3021().getHokenTotalTanisu());
        緊急療養データ.set後回数(entity.getDbt3021().getAtoHokenKaisu());
        緊急療養データ.set後サービス点数(entity.getDbt3021().getAtoHokenServiceTanisu());
        緊急療養データ.set後合計点数(entity.getDbt3021().getAtoHokenTotalTanisu());
        緊急療養データ.set公費１回数(entity.getDbt3021().getKohi1Kaisu());
        緊急療養データ.set公費１サービス点数(entity.getDbt3021().getKohi1ServiceTanisu());
        緊急療養データ.set公費１合計点数(entity.getDbt3021().getKohi1TotalTanisu());
        緊急療養データ.set後公費１回数(entity.getDbt3021().getAtoKohi1Kaisu());
        緊急療養データ.set後公費１サービス点数(entity.getDbt3021().getAtoKohi1ServiceTanisu());
        緊急療養データ.set後公費１合計点数(entity.getDbt3021().getAtoKohi1TotalTanisu());
        緊急療養データ.set公費２回数(entity.getDbt3021().getKohi2Kaisu());
        緊急療養データ.set公費２サービス点数(entity.getDbt3021().getKohi2ServiceTanisu());
        緊急療養データ.set公費２合計点数(entity.getDbt3021().getKohi2TotalTanisu());
        緊急療養データ.set後公費２回数(entity.getDbt3021().getAtoKohi2Kaisu());
        緊急療養データ.set後公費２サービス点数(entity.getDbt3021().getAtoKohi2ServiceTanisu());
        緊急療養データ.set後公費２合計点数(entity.getDbt3021().getAtoKohi2TotalTanisu());
        緊急療養データ.set公費３回数(entity.getDbt3021().getKohi3Kaisu());
        緊急療養データ.set公費３サービス点数(entity.getDbt3021().getKohi3ServiceTanisu());
        緊急療養データ.set公費３合計点数(entity.getDbt3021().getKohi3TotalTanisu());
        緊急療養データ.set後公費３回数(entity.getDbt3021().getAtoKohi3Kaisu());
        緊急療養データ.set後公費３サービス点数(entity.getDbt3021().getAtoKohi3ServiceTanisu());
        緊急療養データ.set後公費３合計点数(entity.getDbt3021().getAtoKohi3TotalTanisu());
        緊急療養データ.set略称(entity.getDbT3118_ryakusho());
        緊急療養データ.setサービス名称(entity.getDbT7120_serviceMeisho());
        return 緊急療養データ;
    }
}
