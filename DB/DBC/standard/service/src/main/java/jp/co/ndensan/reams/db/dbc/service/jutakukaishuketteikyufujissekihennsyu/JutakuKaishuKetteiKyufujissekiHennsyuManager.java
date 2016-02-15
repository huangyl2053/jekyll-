/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.jutakukaishuketteikyufujissekihennsyu;

/**
 *
 * @author LDNS lijunjun
 */
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.GeifuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * @author LDNS lijunjun
 */
public class JutakuKaishuKetteiKyufujissekiHennsyuManager {

    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;

    private JutakuKaishuKetteiKyufujissekiHennsyuManager() {
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * 支給決定給付実績編集
     *
     * @param 給付実績編集汎用Entity
     * @param 償還払請求住宅改修リスト
     * @param 償還払請求集計Entity
     */
    public void createSikyuKetteiKyufujisseki(GeifuEntity 給付実績編集汎用Entity,
            List<DbT3049ShokanJutakuKaishuEntity> 償還払請求住宅改修リスト,
            DbT3053ShokanShukeiEntity 償還払請求集計Entity) {

        ShikibetsuCode 識別コード = 給付実績編集汎用Entity.getShikibetsuCode();
        IShikibetsuTaishoGyomuHanteiKey gyomuKey = ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        ShikibetsuTaishoSearchKeyBuilder builder = new ShikibetsuTaishoSearchKeyBuilder(gyomuKey);
        List<IKojin> Kojin
                = ShikibetsuTaishoService.getKojinFinder().get個人s(builder.set識別コード(識別コード).build());
        if (Kojin == null) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace("宛名識別対象").evaluate());
        }
        HihokenshaNo 被保険者番号 = 償還払請求集計Entity.getHiHokenshaNo();
        FlexibleYearMonth サービス年月 = 償還払請求集計Entity.getServiceTeikyoYM();
        DbT4001JukyushaDaichoEntity 受給者台帳entity = 受給者台帳Dac.select受給者台帳情報(被保険者番号, サービス年月);
        if (受給者台帳entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace("認定有効期間").evaluate());
        }
        KokanShikibetsuNo 交換情報識別番号;
        FlexibleYearMonth サービス提供年月 = 償還払請求集計Entity.getServiceTeikyoYM();
        if (サービス提供年月.isBeforeOrEquals(new FlexibleYearMonth("200303"))) {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1131"));
        } else if (new FlexibleYearMonth("200304").isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(new FlexibleYearMonth("200510"))) {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1132"));
        } else if (new FlexibleYearMonth("200510").isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(new FlexibleYearMonth("200604"))) {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1133"));
        } else if (new FlexibleYearMonth("200604").isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(new FlexibleYearMonth("200804"))) {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1134"));
        } else if (new FlexibleYearMonth("200804").isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(new FlexibleYearMonth("200904"))) {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1135"));
        } else if (new FlexibleYearMonth("200904").isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(new FlexibleYearMonth("201204"))) {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1136"));
        } else if (new FlexibleYearMonth("201204").isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(new FlexibleYearMonth("201504"))) {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1137"));
        } else {
            交換情報識別番号 = new KokanShikibetsuNo(new RString("1138"));
        }

        DbT3017KyufujissekiKihonEntity 給付実績基本entity = new DbT3017KyufujissekiKihonEntity();
        DbT3038ShokanKihonEntity 償還払請求基本Entity = new DbT3038ShokanKihonEntity();//TODO
        RString 通し番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.実績管理番号.getコード()).nextString();
        給付実績基本entity.setKokanShikibetsuNo(交換情報識別番号);
        給付実績基本entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(償還払請求基本Entity.getYoshikiNo()));
        給付実績基本entity.setRecodeShubetsuCode(new RString("01"));
        給付実績基本entity.setKyufuSakuseiKubunCode(給付実績編集汎用Entity.getKyufuSakuseiKubunCode());
        給付実績基本entity.setShokisaiHokenshaNo(new HokenshaNo(給付実績編集汎用Entity.getShoKisaiHokenshaNo().toString()));
        給付実績基本entity.setHiHokenshaNo(償還払請求基本Entity.getHiHokenshaNo());
        給付実績基本entity.setServiceTeikyoYM(償還払請求基本Entity.getServiceTeikyoYM());
        給付実績基本entity.setKyufuJissekiKubunCode(new RString("2"));
        給付実績基本entity.setJigyoshoNo(償還払請求基本Entity.getJigyoshaNo());
        給付実績基本entity.setToshiNo(通し番号);
        給付実績基本entity.setUmareYMD(Kojin.get(0).get生年月日().toFlexibleDate());
        給付実績基本entity.setSeibetsuCode(Kojin.get(0).get性別().toRString());
        給付実績基本entity.setYoKaigoJotaiKubunCode(new RString(受給者台帳entity.getYokaigoJotaiKubunCode().toString()));
        給付実績基本entity.setNinteiYukoKaishiYMD(受給者台帳entity.getNinteiYukoKikanKaishiYMD());
        給付実績基本entity.setNinteiYukoShuryoYMD(受給者台帳entity.getNinteiYukoKikanShuryoYMD());
        給付実績基本entity.setHokenKyufuritsu(償還払請求基本Entity.getHokenKyufuritsu());
        給付実績基本entity.setMaeHokenServiceTanisu(new Decimal(償還払請求基本Entity.getServiceTanisu()));
        給付実績基本entity.setMaeHokenSeikyugaku(償還払請求基本Entity.getHokenSeikyugaku());
        給付実績基本entity.setMaeHokenRiyoshaFutangaku(new Decimal(償還払請求基本Entity.getRiyoshaFutangaku()));
        給付実績基本entity.setShinsaYM(給付実績編集汎用Entity.getShinsaYM());
        給付実績基本entity.setSeiriNo(償還払請求基本Entity.getSeiriNp());
        給付実績基本entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(false);

        DbT3027KyufujissekiJutakuKaishuhiEntity 給付実績住宅改修費entity = new DbT3027KyufujissekiJutakuKaishuhiEntity();
        for (int i = 0; i < 償還払請求住宅改修リスト.size(); i++) {
            給付実績住宅改修費entity.setKokanJohoShikibetsuNo(給付実績基本entity.getKokanShikibetsuNo());
            給付実績住宅改修費entity.setInputShikibetsuNo(給付実績基本entity.getInputShikibetsuNo());
            給付実績住宅改修費entity.setRecodeShubetsuCode(new RString("08"));
            給付実績住宅改修費entity.setShokisaiHokenshaNo(給付実績基本entity.getShokisaiHokenshaNo());
            給付実績住宅改修費entity.setHiHokenshaNo(給付実績基本entity.getHiHokenshaNo());
            給付実績住宅改修費entity.setServiceTeikyoYM(給付実績基本entity.getServiceTeikyoYM());
            給付実績住宅改修費entity.setJigyoshoNo(給付実績基本entity.getJigyoshoNo());
            給付実績住宅改修費entity.setToshiNo(給付実績基本entity.getToshiNo());
            給付実績住宅改修費entity.setMeisaiNo(new RString("000" + (i + 1)));
            給付実績住宅改修費entity.setServiceCode(償還払請求住宅改修リスト.get(i).getServiceCode());
            給付実績住宅改修費entity.setJutakuKaishuchakkoYMD(償還払請求住宅改修リスト.get(i).getJutakuKaishuChakkoYMD());
            給付実績住宅改修費entity.setJutakuKaishuJigyoshaName(償還払請求住宅改修リスト.get(i).getJutakuKaishuJigyoshaName());
            給付実績住宅改修費entity.setJuutakukaishuJyutakuAdress(償還払請求住宅改修リスト.get(i).getJutakuKaishuJutakuAddress());
            給付実績住宅改修費entity.setKaishuKingaku(new Decimal(償還払請求住宅改修リスト.get(i).getKaishuKingaku()));
            給付実績住宅改修費entity.setShinsaYM(給付実績基本entity.getShinsaYM());
            給付実績住宅改修費entity.setSeiriNo(給付実績基本entity.getSeiriNo());
        }

        DbT3033KyufujissekiShukeiEntity 給付実績集計entity = new DbT3033KyufujissekiShukeiEntity();
        給付実績集計entity.setKokanJohoShikibetsuNo(給付実績基本entity.getKokanShikibetsuNo());
        給付実績集計entity.setInputShikibetsuNo(給付実績基本entity.getInputShikibetsuNo());
        給付実績集計entity.setRecodeShubetsuCode(new RString("10"));
        給付実績集計entity.setShokisaiHokenshaNo(給付実績基本entity.getShokisaiHokenshaNo());
        給付実績集計entity.setHiHokenshaNo(給付実績基本entity.getHiHokenshaNo());
        給付実績集計entity.setServiceTeikyoYM(給付実績基本entity.getServiceTeikyoYM());
        給付実績集計entity.setJigyoshoNo(給付実績基本entity.getJigyoshoNo());
        給付実績集計entity.setToshiNo(給付実績基本entity.getToshiNo());
        給付実績集計entity.setServiceSyuruiCode(償還払請求集計Entity.getServiceShuruiCode());
        給付実績集計entity.setPlanTanisu(new Decimal(償還払請求集計Entity.getPlanTanisu()));
        給付実績集計entity.setGendogakuKanriTaishoTanisu(new Decimal(償還払請求集計Entity.getGendogakuKanriTaishogaiTanisu()));
        給付実績集計entity.setGendogakuKanritaishogaiTanisu(new Decimal(償還払請求集計Entity.getGendogakuKanriTaishogaiTanisu()));
        給付実績集計entity.setTankiNyushoPlanNissu(new Decimal(償還払請求集計Entity.getTankiNyushoPlanNissu()));
        給付実績集計entity.setTankiNyushoJitsunissu(new Decimal(償還払請求集計Entity.getTankiNyushoJitsunissu()));
        給付実績集計entity.setHokenTanisuTotal(new Decimal(償還払請求集計Entity.getTanisuTotal()));
        給付実績集計entity.setHokenTanisuTani(償還払請求集計Entity.getTanisuTanka());
        給付実績集計entity.setHokenSeikyugaku(償還払請求集計Entity.getSeikyugaku());
        給付実績集計entity.setHokenRiyoshaFutangaku(new Decimal(償還払請求集計Entity.getRiyoshaFutangaku()));
        給付実績集計entity.setShinsaYM(給付実績基本entity.getShinsaYM());
        給付実績集計entity.setSeiriNo(給付実績基本entity.getSeiriNo());
    }

}
