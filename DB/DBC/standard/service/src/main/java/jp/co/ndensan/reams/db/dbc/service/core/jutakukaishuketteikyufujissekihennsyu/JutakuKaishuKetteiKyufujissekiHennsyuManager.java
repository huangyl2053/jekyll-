/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishuketteikyufujissekihennsyu;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraishikyukettekyufujssekihensyu.SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3027KyufujissekiJutakuKaishuhiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinsei.GeifuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.syokanbaraishikyukettekyufujssekihensyu.DealKyufujissekiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3017KyufujissekiKihonDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3027KyufujissekiJutakuKaishuhiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3033KyufujissekiShukeiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraishikyukettekyufujssekihensyu.ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaibanHanyokeyName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Saiban;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 住宅改修費支給決定給付実績編集のクラス
 *
 * @reamsid_L DBC-0992-170 lijunjun
 */
public class JutakuKaishuKetteiKyufujissekiHennsyuManager {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private final DbT3017KyufujissekiKihonDac 給付実績基本Dac;
    private final DbT3027KyufujissekiJutakuKaishuhiDac 給付実績住宅改修費Dac;
    private final DbT3033KyufujissekiShukeiDac 給付実績集計Dac;
    private static final FlexibleYearMonth 平成１５年３月 = new FlexibleYearMonth("200303");
    private static final FlexibleYearMonth 平成１５年４月 = new FlexibleYearMonth("200304");
    private static final FlexibleYearMonth 平成１７年１０月 = new FlexibleYearMonth("200510");
    private static final FlexibleYearMonth 平成１８年４月 = new FlexibleYearMonth("200604");
    private static final FlexibleYearMonth 平成２０年４月 = new FlexibleYearMonth("200804");
    private static final FlexibleYearMonth 平成２１年４月 = new FlexibleYearMonth("200904");
    private static final FlexibleYearMonth 平成２４年４月 = new FlexibleYearMonth("201204");
    private static final FlexibleYearMonth 平成２７年４月 = new FlexibleYearMonth("201504");
    private static final RString 宛名識別対象 = new RString("宛名識別対象");
    private static final RString 認定有効期間 = new RString("認定有効期間");
    private static final RString DATA_01 = new RString("01");
    private static final RString DATA_2 = new RString("2");
    private static final RString DATA_08 = new RString("08");
    private static final RString DATA_10 = new RString("10");
    private static final RString フォーマット = new RString("%04d");
    private static final RString DATA_1131 = new RString("1131");
    private static final RString DATA_1132 = new RString("1132");
    private static final RString DATA_1133 = new RString("1133");
    private static final RString DATA_1134 = new RString("1134");
    private static final RString DATA_1135 = new RString("1135");
    private static final RString DATA_1136 = new RString("1136");
    private static final RString DATA_1137 = new RString("1137");
    private static final RString DATA_1138 = new RString("1138");

    JutakuKaishuKetteiKyufujissekiHennsyuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.給付実績基本Dac = InstanceProvider.create(DbT3017KyufujissekiKihonDac.class);
        this.給付実績住宅改修費Dac = InstanceProvider.create(DbT3027KyufujissekiJutakuKaishuhiDac.class);
        this.給付実績集計Dac = InstanceProvider.create(DbT3033KyufujissekiShukeiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakuKaishuKetteiKyufujissekiHennsyuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JutakuKaishuKetteiKyufujissekiHennsyuManager}のインスタンス
     */
    public static JutakuKaishuKetteiKyufujissekiHennsyuManager createInstance() {
        return InstanceProvider.create(JutakuKaishuKetteiKyufujissekiHennsyuManager.class);
    }

    /**
     * 支給決定給付実績編集
     *
     * @param 給付実績編集汎用Entity GeifuEntity
     * @param 償還払請求住宅改修リスト List<DbT3049ShokanJutakuKaishuEntity>
     * @param 償還払請求集計Entity DbT3053ShokanShukeiEntity
     * @param 償還払請求基本Entity DbT3038ShokanKihonEntity
     */
    public void createSikyuKetteiKyufujisseki(GeifuEntity 給付実績編集汎用Entity,
            List<DbT3049ShokanJutakuKaishuEntity> 償還払請求住宅改修リスト,
            DbT3053ShokanShukeiEntity 償還払請求集計Entity,
            DbT3038ShokanKihonEntity 償還払請求基本Entity) {

        ShikibetsuCode 識別コード = 給付実績編集汎用Entity.getShikibetsuCode();
        ShikibetsuTaishoPSMSearchKeyBuilder builder
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        builder.setデータ取得区分(DataShutokuKubun.直近レコード);
        builder.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey key = builder.build();
        SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter parameter
                = new SyokanbaraiShikyuKetteKyufuJssekiHensyuParameter(key);
        ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper mapper
                = mapperProvider.create(ISyokanbaraiShikyuKetteKyufuJssekiHensyuMapper.class);
        DealKyufujissekiEntity 宛名 = mapper.get宛名(parameter);
        if (宛名 == null) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace(宛名識別対象.toString()).evaluate());
        }
        HihokenshaNo 被保険者番号 = 償還払請求集計Entity.getHiHokenshaNo();
        FlexibleYearMonth サービス提供年月 = 償還払請求集計Entity.getServiceTeikyoYM();
        DbT4001JukyushaDaichoEntity 受給者台帳entity = 受給者台帳Dac
                .select受給者台帳情報(被保険者番号, サービス提供年月);
        if (受給者台帳entity == null) {
            throw new ApplicationException(UrErrorMessages.存在しない
                    .getMessage().replace(認定有効期間.toString()).evaluate());
        }
        KokanShikibetsuNo 交換情報識別番号 = getKokanShikibetsuNo(サービス提供年月);
        DbT3017KyufujissekiKihonEntity 給付実績基本entity = new DbT3017KyufujissekiKihonEntity();
        RString 通し番号 = Saiban.get(SubGyomuCode.DBC介護給付, SaibanHanyokeyName.実績管理番号.getコード()).nextString();
        給付実績基本entity.setKokanShikibetsuNo(交換情報識別番号);
        if (償還払請求基本Entity.getYoshikiNo() != null) {
            給付実績基本entity.setInputShikibetsuNo(new NyuryokuShikibetsuNo(償還払請求基本Entity.getYoshikiNo()));
        }
        給付実績基本entity.setRecodeShubetsuCode(DATA_01);
        給付実績基本entity.setKyufuSakuseiKubunCode(給付実績編集汎用Entity.getKyufuSakuseiKubunCode());
        給付実績基本entity.setShokisaiHokenshaNo(給付実績編集汎用Entity.getShoKisaiHokenshaNo());
        給付実績基本entity.setHiHokenshaNo(償還払請求基本Entity.getHiHokenshaNo());
        給付実績基本entity.setServiceTeikyoYM(償還払請求基本Entity.getServiceTeikyoYM());
        給付実績基本entity.setKyufuJissekiKubunCode(DATA_2);
        給付実績基本entity.setJigyoshoNo(償還払請求基本Entity.getJigyoshaNo());
        給付実績基本entity.setToshiNo(通し番号);
        給付実績基本entity.setUmareYMD(宛名.get生年月日());
        給付実績基本entity.setSeibetsuCode(宛名.get性別コード());
        Code yoKaigoJotaiKubunCode = 受給者台帳entity.getYokaigoJotaiKubunCode();
        if (yoKaigoJotaiKubunCode != null) {
            給付実績基本entity.setYoKaigoJotaiKubunCode(yoKaigoJotaiKubunCode.value());
        }
        給付実績基本entity.setNinteiYukoKaishiYMD(受給者台帳entity.getNinteiYukoKikanKaishiYMD());
        給付実績基本entity.setNinteiYukoShuryoYMD(受給者台帳entity.getNinteiYukoKikanShuryoYMD());
        給付実績基本entity.setHokenKyufuritsu(償還払請求基本Entity.getHokenKyufuritsu());
        給付実績基本entity.setMaeHokenServiceTanisu(償還払請求基本Entity.getServiceTanisu());
        給付実績基本entity.setMaeHokenSeikyugaku(償還払請求基本Entity.getHokenSeikyugaku());
        給付実績基本entity.setMaeHokenRiyoshaFutangaku(償還払請求基本Entity.getRiyoshaFutangaku());
        給付実績基本entity.setShinsaYM(給付実績編集汎用Entity.getShinsaYM());
        給付実績基本entity.setSeiriNo(償還払請求基本Entity.getSeiriNo());
        給付実績基本entity.setHokenshaHoyuKyufujissekiJohoSakujoFlag(false);
        給付実績基本entity.setState(EntityDataState.Added);
        給付実績基本Dac.save(給付実績基本entity);

        DbT3027KyufujissekiJutakuKaishuhiEntity 給付実績住宅改修費entity
                = new DbT3027KyufujissekiJutakuKaishuhiEntity();
        for (int i = 0; i < 償還払請求住宅改修リスト.size(); i++) {
            給付実績住宅改修費entity.setKokanJohoShikibetsuNo(給付実績基本entity.getKokanShikibetsuNo());
            給付実績住宅改修費entity.setInputShikibetsuNo(給付実績基本entity.getInputShikibetsuNo());
            給付実績住宅改修費entity.setRecodeShubetsuCode(DATA_08);
            給付実績住宅改修費entity.setShokisaiHokenshaNo(給付実績基本entity.getShokisaiHokenshaNo());
            給付実績住宅改修費entity.setHiHokenshaNo(給付実績基本entity.getHiHokenshaNo());
            給付実績住宅改修費entity.setServiceTeikyoYM(給付実績基本entity.getServiceTeikyoYM());
            給付実績住宅改修費entity.setJigyoshoNo(給付実績基本entity.getJigyoshoNo());
            給付実績住宅改修費entity.setToshiNo(給付実績基本entity.getToshiNo());
            RString meisaiNo = new RString(String.format(フォーマット.toString(), i + 1));
            給付実績住宅改修費entity.setMeisaiNo(meisaiNo);
            ServiceCode サービスコード = 償還払請求住宅改修リスト.get(i).getServiceCode();
            if (サービスコード != null) {
                給付実績住宅改修費entity.setServiceCode(サービスコード);
            }
            FlexibleDate 住宅改修着工年月日 = 償還払請求住宅改修リスト.get(i).getJutakuKaishuChakkoYMD();
            if (住宅改修着工年月日 != null) {
                給付実績住宅改修費entity.setJutakuKaishuchakkoYMD(住宅改修着工年月日);

            }
            RString 住宅改修事業者名 = 償還払請求住宅改修リスト.get(i).getJutakuKaishuJigyoshaName();
            if (住宅改修事業者名 != null) {
                給付実績住宅改修費entity.setJutakuKaishuJigyoshaName(住宅改修事業者名);
            }

            給付実績住宅改修費entity.setJuutakukaishuJyutakuAdress(償還払請求住宅改修リスト
                    .get(i).getJutakuKaishuJutakuAddress());
            給付実績住宅改修費entity.setKaishuKingaku(new Decimal(償還払請求住宅改修リスト
                    .get(i).getKaishuKingaku()));
            給付実績住宅改修費entity.setShinsaYM(給付実績基本entity.getShinsaYM());
            給付実績住宅改修費entity.setSeiriNo(給付実績基本entity.getSeiriNo());
            給付実績住宅改修費entity.setState(EntityDataState.Added);
            給付実績住宅改修費Dac.save(給付実績住宅改修費entity);
        }

        DbT3033KyufujissekiShukeiEntity 給付実績集計entity = new DbT3033KyufujissekiShukeiEntity();
        給付実績集計entity.setKokanJohoShikibetsuNo(給付実績基本entity.getKokanShikibetsuNo());
        給付実績集計entity.setInputShikibetsuNo(給付実績基本entity.getInputShikibetsuNo());
        給付実績集計entity.setRecodeShubetsuCode(DATA_10);
        給付実績集計entity.setShokisaiHokenshaNo(給付実績基本entity.getShokisaiHokenshaNo());
        給付実績集計entity.setHiHokenshaNo(給付実績基本entity.getHiHokenshaNo());
        給付実績集計entity.setServiceTeikyoYM(給付実績基本entity.getServiceTeikyoYM());
        給付実績集計entity.setJigyoshoNo(給付実績基本entity.getJigyoshoNo());
        給付実績集計entity.setToshiNo(給付実績基本entity.getToshiNo());
        ServiceShuruiCode サービス種類コード = 償還払請求集計Entity.getServiceShuruiCode();
        if (サービス種類コード != null) {
            給付実績集計entity.setServiceSyuruiCode(サービス種類コード);
        }
        給付実績集計entity.setPlanTanisu(new Decimal(償還払請求集計Entity.getPlanTanisu()));
        給付実績集計entity.setGendogakuKanriTaishoTanisu(new Decimal(償還払請求集計Entity
                .getGendogakuKanriTaishoTanisu()));
        給付実績集計entity.setGendogakuKanritaishogaiTanisu(new Decimal(償還払請求集計Entity
                .getGendogakuKanriTaishogaiTanisu()));
        給付実績集計entity.setTankiNyushoPlanNissu(償還払請求集計Entity.getTankiNyushoPlanNissu());
        給付実績集計entity.setTankiNyushoJitsunissu(償還払請求集計Entity.getTankiNyushoJitsunissu());
        給付実績集計entity.setHokenTanisuTotal(new Decimal(償還払請求集計Entity.getTanisuTotal()));
        給付実績集計entity.setHokenTanisuTani(償還払請求集計Entity.getTanisuTanka());
        給付実績集計entity.setHokenSeikyugaku(償還払請求集計Entity.getSeikyugaku());
        給付実績集計entity.setHokenRiyoshaFutangaku(new Decimal(償還払請求集計Entity.getRiyoshaFutangaku()));
        給付実績集計entity.setShinsaYM(給付実績基本entity.getShinsaYM());
        給付実績集計entity.setSeiriNo(給付実績基本entity.getSeiriNo());
        給付実績集計entity.setState(EntityDataState.Added);
        給付実績集計Dac.save(給付実績集計entity);
    }

    private KokanShikibetsuNo getKokanShikibetsuNo(
            FlexibleYearMonth サービス提供年月) {
        KokanShikibetsuNo 交換情報識別番号;
        if (サービス提供年月.isBeforeOrEquals(平成１５年３月)) {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1131);
        } else if (平成１５年４月.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(平成１７年１０月)) {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1132);
        } else if (平成１７年１０月.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(平成１８年４月)) {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1133);
        } else if (平成１８年４月.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(平成２０年４月)) {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1134);
        } else if (平成２０年４月.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(平成２１年４月)) {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1135);
        } else if (平成２１年４月.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(平成２４年４月)) {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1136);
        } else if (平成２４年４月.isBeforeOrEquals(サービス提供年月)
                && サービス提供年月.isBefore(平成２７年４月)) {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1137);
        } else {
            交換情報識別番号 = new KokanShikibetsuNo(DATA_1138);
        }
        return 交換情報識別番号;
    }

}
