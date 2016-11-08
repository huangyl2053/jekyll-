/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * List特定入所者介護サービス費用のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class TokuteiServiceHiCreateProcess extends BatchProcessBase<TokuteiServiceHiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get特定入所者介護サービス費用");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 特定List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        特定List = new BatchEntityCreatedTempTableWriter(TokuteiServiceHiEntity.TABLE_NAME,
                TokuteiServiceHiEntity.class);
    }

    @Override
    protected void process(TokuteiServiceHiRelateEntity entity) {
        特定List.insert(get特定入所者介護サービス費用データ(entity));
    }

    private TokuteiServiceHiEntity get特定入所者介護サービス費用データ(TokuteiServiceHiRelateEntity entity) {
        TokuteiServiceHiEntity 特定データ = new TokuteiServiceHiEntity();
        特定データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        特定データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        特定データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        特定データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        特定データ.set通し番号(entity.getDbt3017().getToshiNo());
        特定データ.set順次番号(entity.getDbt3029().getRecodeJunjiNo());
        特定データ.setサービス種別コード(entity.getDbt3029().getServiceSyuruiCode().value());
        特定データ.setサービス項目コード(entity.getDbt3029().getServiceKomokuCode().value());
        特定データ.setサービス内容(entity.getServiceName());
        特定データ.set費用単価(entity.getDbt3029().getHiyoTanka());
        特定データ.set後費用単価(entity.getDbt3029().getAtoHiyoTanka());
        特定データ.set負担限度額(entity.getDbt3029().getFutanGendogaku());
        特定データ.set日数(entity.getDbt3029().getNissu());
        特定データ.set後日数(entity.getDbt3029().getAtoNissu());
        特定データ.set公費１日数(entity.getDbt3029().getKohi1Nissu());
        特定データ.set後公費１日数(entity.getDbt3029().getAtoKohi1Nissu());
        特定データ.set公費２日数(entity.getDbt3029().getKohi2Nissu());
        特定データ.set後公費２日数(entity.getDbt3029().getAtoKohi2Nissu());
        特定データ.set公費３日数(entity.getDbt3029().getKohi3Nissu());
        特定データ.set後公費３日数(entity.getDbt3029().getAtoKohi3Nissu());
        特定データ.set費用額(entity.getDbt3029().getHiyogaku());
        特定データ.set後費用額(entity.getDbt3029().getAtoHiyogaku());
        特定データ.set保険分請求額(entity.getDbt3029().getHokenbunSeikyugaku());
        特定データ.set後保険分請求額(entity.getDbt3029().getAtoHokenbunSeikyugaku());
        特定データ.set公費１負担額明細(entity.getDbt3029().getKohi1Futangaku());
        特定データ.set後公費１負担額明細(entity.getDbt3029().getAtoKohi1Futangaku());
        特定データ.set公費２負担額明細(entity.getDbt3029().getKohi2Futangaku());
        特定データ.set後公費２負担額明細(entity.getDbt3029().getAtoKohi2Futangaku());
        特定データ.set公費３負担額明細(entity.getDbt3029().getKohi3Futangaku());
        特定データ.set後公費３負担額明細(entity.getDbt3029().getAtoKohi3Futangaku());
        特定データ.set利用者負担額(entity.getDbt3029().getRiyoshaFutangaku());
        特定データ.set後利用者負担額(entity.getDbt3029().getAtoRiyoshaFutangaku());
        特定データ.set再審査回数(entity.getDbt3029().getSaishinsaKaisu());
        特定データ.set過誤回数(entity.getDbt3029().getKagoKaisu());
        特定データ.set審査年月(entity.getDbt3029().getShinsaYM());
        特定データ.set費用額合計(entity.getDbt3029().getHiyogakuTotal());
        特定データ.set後費用額合計(entity.getDbt3029().getAtoHiyogakuTotal());
        特定データ.set保険分請求額合計(entity.getDbt3029().getHokenbunSeikyugakuTotal());
        特定データ.set後保険分請求額合計(entity.getDbt3029().getAtoHokenbunSeikyugakuTotal());
        特定データ.set利用者負担額合計(entity.getDbt3029().getRiyoshaFutangakuTotal());
        特定データ.set後利用者負担額合計(entity.getDbt3029().getAtoRiyoshaFutangakuTotal());
        特定データ.set公費１負担額合計(entity.getDbt3029().getKohi1FutangakuTotal());
        特定データ.set後公費１負担額合計(entity.getDbt3029().getAtoKohi1FutangakuTotal());
        特定データ.set公費１保険分請求額合計(entity.getDbt3029().getHokenbunSeikyugakuTotal());
        特定データ.set後公費１保険分請求額合計(entity.getDbt3029().getAtoHokenbunSeikyugakuTotal());
        特定データ.set公費１本人負担月額(entity.getDbt3029().getKohi2HonninFutanGetsugaku());
        特定データ.set後公費１本人負担月額(entity.getDbt3029().getAtoKohi1HonninFutanGetsugaku());
        特定データ.set公費２負担額合計(entity.getDbt3029().getKohi2FutangakuTotal());
        特定データ.set後公費２負担額合計(entity.getDbt3029().getAtoKohi2FutangakuTotal());
        特定データ.set公費２保険分請求額合計(entity.getDbt3029().getKohi2FutangakuTotal());
        特定データ.set後公費２保険分請求額合計(entity.getDbt3029().getAtoKohi2FutangakuTotal());
        特定データ.set公費２本人負担月額(entity.getDbt3029().getKohi2HonninFutanGetsugaku());
        特定データ.set後公費２本人負担月額(entity.getDbt3029().getAtoKohi2HonninFutanGetsugaku());
        特定データ.set公費３負担額合計(entity.getDbt3029().getKohi3FutangakuTotal());
        特定データ.set後公費３負担額合計(entity.getDbt3029().getAtoKohi3FutangakuTotal());
        特定データ.set公費３保険分請求額合計(entity.getDbt3029().getKohi3Seikyugaku());
        特定データ.set後公費３保険分請求額合計(entity.getDbt3029().getAtoKohi3Seikyugaku());
        特定データ.set公費３本人負担月額(entity.getDbt3029().getKohi3HonninFutanGetsugaku());
        特定データ.set後公費３本人負担月額(entity.getDbt3029().getAtoKohi3HonninFutanGetsugaku());
        return 特定データ;

    }

}
