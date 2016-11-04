/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jukyushakyufujissekidaicho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.KinkyuuziShisetuRyouyouRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.MeisaiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.ShuukeiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushakyufujissekidaicho.TokuteiServiceHiRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 受給者給付実績台帳Editクラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class JukyushaKyufuDaichoEdit {

    /**
     * List明細をセットです
     *
     * @param list list
     * @return List<MeisaiEntity>
     */
    public List<MeisaiEntity> setMeisaiList(List<MeisaiRelateEntity> list) {
        List<MeisaiEntity> meisaiEntityList = new ArrayList<>();
        for (MeisaiRelateEntity meisai : list) {
            MeisaiEntity meisaiEntity = new MeisaiEntity();
            meisaiEntity.set入力識別番号(meisai.getDbt3018().getInputShikibetsuNo().value());
            meisaiEntity.set被保険者番号(meisai.getDbt3018().getHiHokenshaNo().value());
            meisaiEntity.setサービス提供年月(meisai.getDbt3018().getServiceTeikyoYM());
            meisaiEntity.set事業所番号(meisai.getDbt3018().getJigyoshoNo().value());
            meisaiEntity.set通し番号(meisai.getDbt3018().getToshiNo());
            meisaiEntity.setサービス種類コード(meisai.getDbt3018().getServiceShuruiCode().value());
            meisaiEntity.setサービス項目コード(meisai.getDbt3018().getServiceKomokuCode().value());
            meisaiEntity.setサービス内容(meisai.getServiceName());
            meisaiEntity.set単位数(checkDecimalNUll(meisai.getDbt3018().getTanisu()));
            meisaiEntity.set後単位数(checkDecimalNUll(meisai.getDbt3018().getAtoTanisu()));
            //QA1920
            meisaiEntity.set単位数識別(CodeMaster.getCodeMeisho(new CodeShubetsu(new RString("0027")), new Code(meisai.getTanisuShikibetsuCode())));
            meisaiEntity.set日数回数(checkIntNUll(meisai.getDbt3018().getNissuKaisu()));
            meisaiEntity.set後日数回数(checkIntNUll(meisai.getDbt3018().getAtoNissuKaisu()));
            meisaiEntity.setサービス単位数(checkDecimalNUll(meisai.getDbt3018().getServiceTanisu()));
            meisaiEntity.set後サービス単位数(checkDecimalNUll(meisai.getDbt3018().getAtoServiceTanisu()));
            meisaiEntity.set公費１対象日数回数(checkIntNUll(meisai.getDbt3018().getKohi1TaishoNissuKaisu()));
            meisaiEntity.set後公費１対象日数回数(checkIntNUll(meisai.getDbt3018().getAtoKohi1TaishoNissuKaisu()));
            meisaiEntity.set公費１対象サービス点数(checkDecimalNUll(meisai.getDbt3018().getKohi1TaishoServiceTanisu()));
            meisaiEntity.set後公費１対象サービス点数(checkDecimalNUll(meisai.getDbt3018().getAtoKohi1TaishoServiceTanisu()));
            meisaiEntity.set公費２対象日数回数(checkIntNUll(meisai.getDbt3018().getKohi2TaishoNissuKaisu()));
            meisaiEntity.set後公費２対象日数回数(checkIntNUll(meisai.getDbt3018().getAtoKohi2TaishoNissukaisu()));
            meisaiEntity.set公費２対象サービス点数(checkDecimalNUll(meisai.getDbt3018().getKohi2TaishoServiceTanisu()));
            meisaiEntity.set後公費２対象サービス点数(checkDecimalNUll(meisai.getDbt3018().getAtoKohi2TaishoServiceTanisu()));
            meisaiEntity.set公費３対象日数回数(checkIntNUll(meisai.getDbt3018().getKohi3TaishoNissuKaisu()));
            meisaiEntity.set後公費３対象日数回数(checkIntNUll(meisai.getDbt3018().getAtoKohi3TaishoNissuKaisu()));
            meisaiEntity.set公費３対象サービス点数(checkDecimalNUll(meisai.getDbt3018().getKohi3TaishoServiceTanisu()));
            meisaiEntity.set後公費３対象サービス点数(checkDecimalNUll(meisai.getDbt3018().getAtoKohi3TaishoServiceTanisu()));
            meisaiEntity.set摘要(meisai.getDbt3018().getTekiyo());
            meisaiEntity.set再審査回数(checkIntNUll(meisai.getDbt3018().getSaishinsaKaisu()));
            meisaiEntity.set過誤回数(checkIntNUll(meisai.getDbt3018().getKagoKaisu()));
            meisaiEntity.set審査年月(meisai.getDbt3018().getShinsaYM());
            meisaiEntityList.add(meisaiEntity);
        }
        return meisaiEntityList;
    }

    /**
     * List特定入所者介護サービス費用マスタをセットです
     *
     * @param list list
     * @return List<TokuteiServiceHiEntity>
     */
    public List<TokuteiServiceHiEntity> setTokuteiServiceHiEntity(List<TokuteiServiceHiRelateEntity> list) {
        List<TokuteiServiceHiEntity> tokuteiServiceHiEntityList = new ArrayList<>();
        for (TokuteiServiceHiRelateEntity entity : list) {
            TokuteiServiceHiEntity tokuteiServiceHiEntity = new TokuteiServiceHiEntity();
            tokuteiServiceHiEntity.set入力識別番号(entity.getDbt3029().getInputShikibetsuNo().value());
            tokuteiServiceHiEntity.set被保険者番号(entity.getDbt3029().getHiHokenshaNo().value());
            tokuteiServiceHiEntity.setサービス提供年月(entity.getDbt3029().getServiceTeikyoYM());
            tokuteiServiceHiEntity.set事業所番号(entity.getDbt3029().getJigyoshoNo().value());
            tokuteiServiceHiEntity.set通し番号(entity.getDbt3029().getToshiNo());
            tokuteiServiceHiEntity.set順次番号(entity.getDbt3029().getRecodeJunjiNo());
            tokuteiServiceHiEntity.setサービス種別コード(entity.getDbt3029().getServiceSyuruiCode().value());
            tokuteiServiceHiEntity.setサービス項目コード(entity.getDbt3029().getServiceKomokuCode().value());
            tokuteiServiceHiEntity.setサービス内容(entity.getServiceName());
            tokuteiServiceHiEntity.set費用単価(entity.getDbt3029().getHiyoTanka());
            tokuteiServiceHiEntity.set後費用単価(entity.getDbt3029().getAtoHiyoTanka());
            tokuteiServiceHiEntity.set負担限度額(entity.getDbt3029().getFutanGendogaku());
            tokuteiServiceHiEntity.set日数(checkIntNUll(entity.getDbt3029().getNissu()));
            tokuteiServiceHiEntity.set後日数(checkIntNUll(entity.getDbt3029().getAtoNissu()));
            tokuteiServiceHiEntity.set公費１日数(checkIntNUll(entity.getDbt3029().getKohi1Nissu()));
            tokuteiServiceHiEntity.set後公費１日数(checkIntNUll(entity.getDbt3029().getAtoKohi1Nissu()));
            tokuteiServiceHiEntity.set公費２日数(checkIntNUll(entity.getDbt3029().getKohi2Nissu()));
            tokuteiServiceHiEntity.set後公費２日数(checkIntNUll(entity.getDbt3029().getAtoKohi2Nissu()));
            tokuteiServiceHiEntity.set公費３日数(checkIntNUll(entity.getDbt3029().getKohi3Nissu()));
            tokuteiServiceHiEntity.set後公費３日数(checkIntNUll(entity.getDbt3029().getAtoKohi3Nissu()));
            tokuteiServiceHiEntity.set費用額(checkDecimalNUll(entity.getDbt3029().getHiyogaku()));
            tokuteiServiceHiEntity.set後費用額(checkDecimalNUll(entity.getDbt3029().getAtoHiyogaku()));
            tokuteiServiceHiEntity.set保険分請求額(checkDecimalNUll(entity.getDbt3029().getHokenbunSeikyugaku()));
            tokuteiServiceHiEntity.set後保険分請求額(checkDecimalNUll(entity.getDbt3029().getAtoHokenbunSeikyugaku()));
            tokuteiServiceHiEntity.set公費１負担額明細(checkDecimalNUll(entity.getDbt3029().getKohi1Futangaku()));
            tokuteiServiceHiEntity.set後公費１負担額明細(checkDecimalNUll(entity.getDbt3029().getAtoKohi1Futangaku()));
            tokuteiServiceHiEntity.set公費２負担額明細(checkDecimalNUll(entity.getDbt3029().getKohi2Futangaku()));
            tokuteiServiceHiEntity.set後公費２負担額明細(checkDecimalNUll(entity.getDbt3029().getAtoKohi2Futangaku()));
            tokuteiServiceHiEntity.set公費３負担額明細(checkDecimalNUll(entity.getDbt3029().getKohi3Futangaku()));
            tokuteiServiceHiEntity.set後公費３負担額明細(checkDecimalNUll(entity.getDbt3029().getAtoKohi3Futangaku()));
            tokuteiServiceHiEntity.set利用者負担額(checkDecimalNUll(entity.getDbt3029().getRiyoshaFutangaku()));
            tokuteiServiceHiEntity.set後利用者負担額(checkDecimalNUll(entity.getDbt3029().getAtoRiyoshaFutangaku()));
            tokuteiServiceHiEntity.set再審査回数(checkIntNUll(entity.getDbt3029().getSaishinsaKaisu()));
            tokuteiServiceHiEntity.set過誤回数(checkIntNUll(entity.getDbt3029().getKagoKaisu()));
            tokuteiServiceHiEntity.set審査年月(entity.getDbt3029().getShinsaYM());
            tokuteiServiceHiEntity.set費用額合計(checkDecimalNUll(entity.getDbt3029().getHiyogakuTotal()));
            tokuteiServiceHiEntity.set後費用額合計(checkDecimalNUll(entity.getDbt3029().getAtoHiyogakuTotal()));
            tokuteiServiceHiEntity.set保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getHokenbunSeikyugakuTotal()));
            tokuteiServiceHiEntity.set後保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getAtoHokenbunSeikyugakuTotal()));
            tokuteiServiceHiEntity.set利用者負担額合計(checkDecimalNUll(entity.getDbt3029().getRiyoshaFutangakuTotal()));
            tokuteiServiceHiEntity.set後利用者負担額合計(checkDecimalNUll(entity.getDbt3029().getAtoRiyoshaFutangakuTotal()));
            tokuteiServiceHiEntity.set公費１負担額合計(checkDecimalNUll(entity.getDbt3029().getKohi1FutangakuTotal()));
            tokuteiServiceHiEntity.set後公費１負担額合計(checkDecimalNUll(entity.getDbt3029().getAtoKohi1FutangakuTotal()));
            tokuteiServiceHiEntity.set公費１保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getKohi1Seikyugaku()));
            tokuteiServiceHiEntity.set後公費１保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getAtoKohi1Seikyugaku()));
            tokuteiServiceHiEntity.set公費１本人負担月額(checkDecimalNUll(entity.getDbt3029().getKohi1HonninFutanGetsugaku()));
            tokuteiServiceHiEntity.set後公費１本人負担月額(checkDecimalNUll(entity.getDbt3029().getAtoKohi1HonninFutanGetsugaku()));
            tokuteiServiceHiEntity.set公費２負担額合計(checkDecimalNUll(entity.getDbt3029().getKohi2FutangakuTotal()));
            tokuteiServiceHiEntity.set後公費２負担額合計(checkDecimalNUll(entity.getDbt3029().getAtoKohi2FutangakuTotal()));
            tokuteiServiceHiEntity.set公費２保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getKohi2Seikyugaku()));
            tokuteiServiceHiEntity.set後公費２保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getAtoKohi2Seikyugaku()));
            tokuteiServiceHiEntity.set公費２本人負担月額(checkDecimalNUll(entity.getDbt3029().getKohi2HonninFutanGetsugaku()));
            tokuteiServiceHiEntity.set後公費２本人負担月額(checkDecimalNUll(entity.getDbt3029().getAtoKohi2HonninFutanGetsugaku()));
            tokuteiServiceHiEntity.set公費３負担額合計(checkDecimalNUll(entity.getDbt3029().getKohi3FutangakuTotal()));
            tokuteiServiceHiEntity.set後公費３負担額合計(checkDecimalNUll(entity.getDbt3029().getAtoKohi3FutangakuTotal()));
            tokuteiServiceHiEntity.set公費３保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getKohi3Seikyugaku()));
            tokuteiServiceHiEntity.set後公費３保険分請求額合計(checkDecimalNUll(entity.getDbt3029().getAtoKohi3Seikyugaku()));
            tokuteiServiceHiEntity.set公費３本人負担月額(checkDecimalNUll(entity.getDbt3029().getKohi3HonninFutanGetsugaku()));
            tokuteiServiceHiEntity.set後公費３本人負担月額(checkDecimalNUll(entity.getDbt3029().getAtoKohi3HonninFutanGetsugaku()));
            tokuteiServiceHiEntityList.add(tokuteiServiceHiEntity);
        }
        return tokuteiServiceHiEntityList;
    }

    /**
     * List集計をセットです
     *
     * @param list list
     * @return List<ShuukeiEntity>
     */
    public List<ShuukeiEntity> setShuukeiEntity(List<ShuukeiRelateEntity> list) {
        List<ShuukeiEntity> shuukeiEntityList = new ArrayList<>();
        for (ShuukeiRelateEntity entity : list) {
            RString サービス種類コード = entity.getDbt3033().getServiceSyuruiCode().value();
            ShuukeiEntity shuukeiEntity = new ShuukeiEntity();
            shuukeiEntity.set入力識別番号(entity.getDbt3033().getInputShikibetsuNo().value());
            shuukeiEntity.set被保険者番号(entity.getDbt3033().getHiHokenshaNo().value());
            shuukeiEntity.setサービス提供年月(entity.getDbt3033().getServiceTeikyoYM());
            shuukeiEntity.set事業所番号(entity.getDbt3033().getJigyoshoNo().value());
            shuukeiEntity.set通し番号(entity.getDbt3033().getToshiNo());
            shuukeiEntity.setサービス種類コード(サービス種類コード);
            shuukeiEntity.setサービス種類名称1(setサービス種類名称(サービス種類コード));
            shuukeiEntity.setサービス実日数(checkIntNUll(entity.getDbt3033().getServiceJitsunissu()));
            shuukeiEntity.set計画単位数(checkDecimalNUll(entity.getDbt3033().getPlanTanisu()));
            shuukeiEntity.set限度額管理対象単位数(checkDecimalNUll(entity.getDbt3033().getGendogakuKanriTaishoTanisu()));
            shuukeiEntity.set限度額管理対象外単位数(checkDecimalNUll(entity.getDbt3033().getGendogakuKanritaishogaiTanisu()));
            shuukeiEntity.set請求点数合計(checkDecimalNUll(entity.getDbt3033().getHokenTanisuTotal()));
            shuukeiEntity.set後点数合計(checkDecimalNUll(entity.getDbt3033().getAtoHokenTanisuTotal()));
            shuukeiEntity.set後請求点数単価(checkDecimalNUll(entity.getDbt3033().getHokenTanisuTani()));
            shuukeiEntity.set請求額(checkDecimalNUll(entity.getDbt3033().getHokenSeikyugaku()));
            shuukeiEntity.set後保険請求分請求額(checkDecimalNUll(entity.getDbt3033().getAtoHokenSeikyugaku()));
            shuukeiEntity.set利用者負担額(checkDecimalNUll(entity.getDbt3033().getHokenRiyoshaFutangaku()));
            shuukeiEntity.set出来高点数合計(checkDecimalNUll(entity.getDbt3033().getHokenDekidakaTanisuTotal()));
            shuukeiEntity.set後出来高点数合計(checkDecimalNUll(entity.getDbt3033().getAtoHokenDekidakaTanisuTotal()));
            shuukeiEntity.set出来高請求額(checkDecimalNUll(entity.getDbt3033().getHokenDekidakaSeikyugaku()));
            shuukeiEntity.set後出来高請求額(checkDecimalNUll(entity.getDbt3033().getAtoHokenDekidakaSeikyugaku()));
            shuukeiEntity.set出来高医療費利用者負担額(checkDecimalNUll(entity.getDbt3033().getHokenDekidakaIryohiRiyoshaFutangaku()));
            shuukeiEntity.set公費１点数合計(checkDecimalNUll(entity.getDbt3033().getKohi1TanisuTotal()));
            shuukeiEntity.set後公費１点数合計(checkDecimalNUll(entity.getDbt3033().getAtoKohi1TanisuTotal()));
            shuukeiEntity.set公費１請求額(checkDecimalNUll(entity.getDbt3033().getKohi1Seikyugaku()));
            shuukeiEntity.set後公費１請求額(checkDecimalNUll(entity.getDbt3033().getAtoKohi1Seikyugaku()));
            shuukeiEntity.set公費１公費分本人負担額(checkDecimalNUll(entity.getDbt3033().getKohi1HonninFutangaku()));
            shuukeiEntity.set公費１出来高点数合計(checkDecimalNUll(entity.getDbt3033().getKohi1DekidakaTanisuTotal()));
            shuukeiEntity.set後公費１出来高点数合計(checkDecimalNUll(entity.getDbt3033().getAtoKohi1DekidakaTanisuTotal()));
            shuukeiEntity.set公費１出来高請求額(checkDecimalNUll(entity.getDbt3033().getKohi1DekidakaSeikyugaku()));
            shuukeiEntity.set後公費１出来高請求額(checkDecimalNUll(entity.getDbt3033().getAtoKohi1DekidakaSeikyugaku()));
            shuukeiEntity.set公費２点数合計(checkDecimalNUll(entity.getDbt3033().getKohi2TanisuTotal()));
            shuukeiEntity.set後公費２点数合計(checkDecimalNUll(entity.getDbt3033().getAtoKohi2TanisuTotal()));
            shuukeiEntity.set公費２請求額(checkDecimalNUll(entity.getDbt3033().getKohi2Seikyugaku()));
            shuukeiEntity.set後公費２請求額(checkDecimalNUll(entity.getDbt3033().getAtoKohi2Seikyugaku()));
            shuukeiEntity.set公費２公費分本人負担額(checkDecimalNUll(entity.getDbt3033().getKohi2HonninFutangaku()));
            shuukeiEntity.set公費２出来高点数合計(checkDecimalNUll(entity.getDbt3033().getKohi2DekidakaTanisuTotal()));
            shuukeiEntity.set後公費２出来高点数合計(checkDecimalNUll(entity.getDbt3033().getAtoKohi2DekidakaTanisuTotal()));
            shuukeiEntity.set公費２出来高請求額(checkDecimalNUll(entity.getDbt3033().getKohi2DekidakaSeikyugaku()));
            shuukeiEntity.set後公費２出来高請求額(checkDecimalNUll(entity.getDbt3033().getAtoKohi2DekidakaSeikyugaku()));
            shuukeiEntity.set公費３点数合計(checkDecimalNUll(entity.getDbt3033().getKohi3TanisuTotal()));
            shuukeiEntity.set後公費３点数合計(checkDecimalNUll(entity.getDbt3033().getAtoKohi3TanisuTotal()));
            shuukeiEntity.set公費３請求額(checkDecimalNUll(entity.getDbt3033().getKohi3Seikyugaku()));
            shuukeiEntity.set後公費３請求額(checkDecimalNUll(entity.getDbt3033().getAtoKohi3Seikyugaku()));
            shuukeiEntity.set公費３公費分本人負担額(checkDecimalNUll(entity.getDbt3033().getKohi3HonninFutangaku()));
            shuukeiEntity.set公費３出来高点数合計(checkDecimalNUll(entity.getDbt3033().getKohi3DekidakaTanisuTotal()));
            shuukeiEntity.set後公費３出来高点数合計(checkDecimalNUll(entity.getDbt3033().getAtoKohi3DekidakaTanisuTotal()));
            shuukeiEntity.set公費３出来高請求額(checkDecimalNUll(entity.getDbt3033().getKohi3DekidakaSeikyugaku()));
            shuukeiEntity.set後公費３出来高請求額(checkDecimalNUll(entity.getDbt3033().getAtoKohi3DekidakaSeikyugaku()));
            shuukeiEntity.set再審査回数(checkIntNUll(entity.getDbt3033().getSaishinsaKaisu()));
            shuukeiEntity.set過誤回数(checkIntNUll(entity.getDbt3033().getKagoKaisu()));
            shuukeiEntity.set審査年月(entity.getDbt3033().getShinsaYM());
            shuukeiEntityList.add(shuukeiEntity);
        }
        return shuukeiEntityList;
    }

    private RString setサービス種類名称(RString code) {
        RString サービス種類名称 = RString.EMPTY;
        for (ServiceCategoryShurui serviceCategoryShurui : ServiceCategoryShurui.values()) {
            if (serviceCategoryShurui.getコード().equals(code)) {
                サービス種類名称 = serviceCategoryShurui.get名称();
                break;
            }
        }
        return サービス種類名称;
    }

    /**
     * List施設療養をセットです
     *
     * @param list list
     * @return List<KinkyuuziShisetuRyouyouEntity>
     */
    public List<KinkyuuziShisetuRyouyouEntity> set(List<KinkyuuziShisetuRyouyouRelateEntity> list) {
        List<KinkyuuziShisetuRyouyouEntity> shisetuRyouyouEntityList = new ArrayList<>();
        for (KinkyuuziShisetuRyouyouRelateEntity entity : list) {
            KinkyuuziShisetuRyouyouEntity shisetuRyouyouEntity = new KinkyuuziShisetuRyouyouEntity();
            shisetuRyouyouEntity.set入力識別番号(entity.getDbt3019().getInputShikibetsuNo().value());
            shisetuRyouyouEntityList.add(shisetuRyouyouEntity);
        }
        return shisetuRyouyouEntityList;
    }

    private Integer checkIntNUll(Integer integer) {
        if (null == integer) {
            integer = 0;
        }
        return integer;
    }

    private Decimal checkDecimalNUll(Decimal decimal) {
        if (null == decimal) {
            decimal = Decimal.ZERO;
        }
        return decimal;
    }
}
