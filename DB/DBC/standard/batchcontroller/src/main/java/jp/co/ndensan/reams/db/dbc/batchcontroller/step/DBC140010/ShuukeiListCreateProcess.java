/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jukyushakyufujissekidaicho.JukyushaKyufujissekiDaichoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者給付実績台帳のList集計のセットクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 *
 */
public class ShuukeiListCreateProcess extends BatchProcessBase<ShuukeiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushakyufujissekidaicho.IJukyushaKyufujissekiDaichoMapper."
            + "get集計");
    private static final int サービス種類名称_INDEX = 10;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 集計List;
    private JukyushaKyufujissekiDaichoProcessParameter parameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toJukyushaKyufujissekiDaichoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        集計List = new BatchEntityCreatedTempTableWriter(ShuukeiEntity.TABLE_NAME,
                ShuukeiEntity.class);
    }

    @Override
    protected void process(ShuukeiRelateEntity entity) {
        集計List.insert(get集計データ(entity));
    }

    private ShuukeiEntity get集計データ(ShuukeiRelateEntity entity) {
        ShuukeiEntity 集計データ = new ShuukeiEntity();
        集計データ.set入力識別番号(entity.getDbt3017().getInputShikibetsuNo().value());
        集計データ.set被保険者番号(entity.getDbt3017().getHiHokenshaNo().value());
        集計データ.setサービス提供年月(entity.getDbt3017().getServiceTeikyoYM());
        集計データ.set事業所番号(entity.getDbt3017().getJigyoshoNo().value());
        集計データ.set通し番号(entity.getDbt3017().getToshiNo());
        集計データ.setサービス種類コード(entity.getDbt3033().getServiceSyuruiCode().value());
        RString サービス種類名称 = ServiceCategoryShurui.toValue(entity.getDbt3033().getServiceSyuruiCode().value()).get名称();
        集計データ.setサービス種類名称1(getサービス種類名称(サービス種類名称).get(0));
        集計データ.setサービス種類名称2(getサービス種類名称(サービス種類名称).get(1));
        集計データ.setサービス実日数(entity.getDbt3033().getServiceJitsunissu());
        集計データ.set計画単位数(entity.getDbt3033().getPlanTanisu());
        集計データ.set限度額管理対象単位数(entity.getDbt3033().getGendogakuKanriTaishoTanisu());
        集計データ.set限度額管理対象外単位数(entity.getDbt3033().getGendogakuKanritaishogaiTanisu());
        集計データ.set請求点数合計(entity.getDbt3033().getHokenTanisuTotal());
        集計データ.set後点数合計(entity.getDbt3033().getAtoHokenTanisuTotal());
        集計データ.set後請求点数単価(entity.getDbt3033().getHokenTanisuTani());
        集計データ.set請求額(entity.getDbt3033().getHokenSeikyugaku());
        集計データ.set後保険請求分請求額(entity.getDbt3033().getAtoHokenSeikyugaku());
        集計データ.set利用者負担額(entity.getDbt3033().getHokenRiyoshaFutangaku());
        集計データ.set出来高点数合計(entity.getDbt3033().getHokenDekidakaTanisuTotal());
        集計データ.set後出来高点数合計(entity.getDbt3033().getAtoHokenDekidakaTanisuTotal());
        集計データ.set出来高請求額(entity.getDbt3033().getHokenDekidakaSeikyugaku());
        集計データ.set後出来高請求額(entity.getDbt3033().getAtoHokenDekidakaSeikyugaku());
        集計データ.set出来高医療費利用者負担額(entity.getDbt3033().getHokenDekidakaIryohiRiyoshaFutangaku());
        集計データ.set公費１点数合計(entity.getDbt3033().getKohi1TanisuTotal());
        集計データ.set後公費１点数合計(entity.getDbt3033().getAtoKohi1TanisuTotal());
        集計データ.set公費１請求額(entity.getDbt3033().getKohi1Seikyugaku());
        集計データ.set後公費１請求額(entity.getDbt3033().getAtoKohi1Seikyugaku());
        集計データ.set公費１公費分本人負担額(entity.getDbt3033().getKohi1HonninFutangaku());
        集計データ.set公費１出来高点数合計(entity.getDbt3033().getKohi1DekidakaTanisuTotal());
        集計データ.set後公費１出来高点数合計(entity.getDbt3033().getAtoKohi1DekidakaTanisuTotal());
        集計データ.set公費１出来高請求額(entity.getDbt3033().getKohi1DekidakaSeikyugaku());
        集計データ.set後公費１出来高請求額(entity.getDbt3033().getAtoKohi1DekidakaSeikyugaku());
        集計データ.set公費２点数合計(entity.getDbt3033().getKohi2TanisuTotal());
        集計データ.set後公費２点数合計(entity.getDbt3033().getAtoKohi2TanisuTotal());
        集計データ.set公費２請求額(entity.getDbt3033().getKohi2Seikyugaku());
        集計データ.set後公費２請求額(entity.getDbt3033().getAtoKohi2Seikyugaku());
        集計データ.set公費２公費分本人負担額(entity.getDbt3033().getKohi2HonninFutangaku());
        集計データ.set公費２出来高点数合計(entity.getDbt3033().getKohi2DekidakaTanisuTotal());
        集計データ.set後公費２出来高点数合計(entity.getDbt3033().getAtoKohi2DekidakaTanisuTotal());
        集計データ.set公費２出来高請求額(entity.getDbt3033().getKohi2DekidakaSeikyugaku());
        集計データ.set後公費２出来高請求額(entity.getDbt3033().getAtoKohi2DekidakaSeikyugaku());
        集計データ.set公費３点数合計(entity.getDbt3033().getKohi3TanisuTotal());
        集計データ.set後公費３点数合計(entity.getDbt3033().getAtoKohi3TanisuTotal());
        集計データ.set公費３請求額(entity.getDbt3033().getKohi3Seikyugaku());
        集計データ.set後公費３請求額(entity.getDbt3033().getAtoKohi3Seikyugaku());
        集計データ.set公費３公費分本人負担額(entity.getDbt3033().getKohi3HonninFutangaku());
        集計データ.set公費３出来高点数合計(entity.getDbt3033().getKohi3DekidakaTanisuTotal());
        集計データ.set後公費３出来高点数合計(entity.getDbt3033().getAtoKohi3DekidakaTanisuTotal());
        集計データ.set公費３出来高請求額(entity.getDbt3033().getKohi3DekidakaSeikyugaku());
        集計データ.set後公費３出来高請求額(entity.getDbt3033().getAtoKohi3DekidakaSeikyugaku());
        集計データ.set出来高医療費利用者負担額(entity.getDbt3033().getHokenDekidakaIryohiRiyoshaFutangaku());
        集計データ.set再審査回数(entity.getDbt3033().getSaishinsaKaisu());
        集計データ.set過誤回数(entity.getDbt3033().getKagoKaisu());
        集計データ.set審査年月(entity.getDbt3033().getShinsaYM());
        集計データ.set短期入所計画日数(entity.getDbt3033().getTankiNyushoPlanNissu());
        集計データ.set公費１_出来高医療費負担額(entity.getDbt3033().getKohi1DekidakaIryohiRiyoshaFutangaku());
        集計データ.set公費２_出来高医療費負担額(entity.getDbt3033().getKohi2DekidakaIryohiRiyoshaFutangaku());
        集計データ.set公費３_出来高医療費負担額(entity.getDbt3033().getKohi3DekidakaIryohiRiyoshaFutangaku());
        return 集計データ;
    }

    private List<RString> getサービス種類名称(RString サービス種類名称) {
        List<RString> サービス種類名称List = new ArrayList<>();
        if (サービス種類名称.length() > サービス種類名称_INDEX) {
            サービス種類名称List.add(サービス種類名称.substring(0, サービス種類名称_INDEX));
            サービス種類名称List.add(サービス種類名称.substring(サービス種類名称_INDEX));
        } else {
            サービス種類名称List.add(サービス種類名称);
            サービス種類名称List.add(RString.EMPTY);
        }
        return サービス種類名称List;
    }

}
