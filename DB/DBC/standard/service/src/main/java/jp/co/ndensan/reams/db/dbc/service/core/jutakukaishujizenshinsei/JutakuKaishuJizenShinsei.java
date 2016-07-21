/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jutakukaishujizenshinsei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbz.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.hokenkyufuritsuteisu.HokenkyufuritsuTeisu;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishujizenshinsei.JutakuKaishuHiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.KyufuritsuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.NewJutakuKaishuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.ShiharaiKekaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7112ShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujizenshinsei.IJutakuKaishuJizenShinseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4014RiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.message.DbxErrorMessages;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.ShichosonCodeYoriShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.service.core.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 住宅改修費事前申請クラスです
 *
 * @reamsid_L DBC-0990-080 xicongwang
 */
public class JutakuKaishuJizenShinsei {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    private final DbT3049ShokanJutakuKaishuDac jutakuKaishuDac;
    private final DbT1001HihokenshaDaichoDac daichoDac;
    private final DbT3035ShokanJutakuKaishuJizenShinseiDac jizenShinseiDac;
    private final DbT7115UwanoseShokanShuruiShikyuGendoGakuDac shikyuGendoGakuDac;
    private final DbT7112ShokanShuruiShikyuGendoGakuDac shuruiShikyuGendoGakuDac;
    private final DbT4021ShiharaiHohoHenkoDac hohoHenkoDac;
    private final DbT4014RiyoshaFutangakuGengakuDac 負担額減額Dac;
    private final DbT7060KaigoJigyoshaDac 介護事業者Dac;
    private final DbT7130KaigoServiceShuruiDac 介護サービス種類Dac;
    private static final int 区分 = 6;
    private static final RString キー = new RString("hiHokenshaNo");
    private static final RString モード_修正 = new RString("修正");
    private static final RString 単一市町村情報_メッセージ = new RString("介護共通の保険者情報");
    private static final RString 様式番号編集_メッセージ = new RString("?:要介護対象");
    private static final RString 様式番号_21D1 = new RString("21D1");
    private static final RString 様式番号_21D2 = new RString("21D2");
    private static final Code 区分コード_01 = new Code("01");
    private static final Code 区分コード_11 = new Code("11");
    private static final Code 区分コード_12 = new Code("12");
    private static final Code 区分コード_13 = new Code("13");
    private static final Code 区分コード_21 = new Code("21");
    private static final Code 区分コード_22 = new Code("22");
    private static final Code 区分コード_23 = new Code("23");
    private static final Code 区分コード_24 = new Code("24");
    private static final Code 区分コード_25 = new Code("25");
    private static final ServiceShuruiCode 種類コード_42 = new ServiceShuruiCode("42");
    private static final ServiceShuruiCode 種類コード_45 = new ServiceShuruiCode("45");

    /**
     * コンストラクタです。
     */
    public JutakuKaishuJizenShinsei() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.jutakuKaishuDac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
        this.daichoDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.jizenShinseiDac = InstanceProvider.create(DbT3035ShokanJutakuKaishuJizenShinseiDac.class);
        this.shikyuGendoGakuDac = InstanceProvider.create(DbT7115UwanoseShokanShuruiShikyuGendoGakuDac.class);
        this.shuruiShikyuGendoGakuDac = InstanceProvider.create(DbT7112ShokanShuruiShikyuGendoGakuDac.class);
        this.hohoHenkoDac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.負担額減額Dac = InstanceProvider.create(DbT4014RiyoshaFutangakuGengakuDac.class);
        this.介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
        this.介護サービス種類Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JutakuKaishuJizenShinsei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JutakuKaishuJizenShinsei}のインスタンス
     */
    public static JutakuKaishuJizenShinsei createInstance() {
        return InstanceProvider.create(JutakuKaishuJizenShinsei.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 受給者台帳Dac 受給者台帳Dac
     * @param jutakuKaishuDac jutakuKaishuDac
     * @param daichoDac daichoDac
     * @param jizenShinseiDac jizenShinseiDac
     * @param shikyuGendoGakuDac shikyuGendoGakuDac
     * @param shuruiShikyuGendoGakuDac shuruiShikyuGendoGakuDac
     * @param hohoHenkoDac hohoHenkoDac
     * @param 負担額減額Dac 負担額減額Dac
     * @param 介護事業者Dac 介護事業者Dac
     * @param 介護サービス種類Dac DbT7130KaigoServiceShuruiDac
     */
    public JutakuKaishuJizenShinsei(MapperProvider mapperProvider,
            DbT4001JukyushaDaichoDac 受給者台帳Dac,
            DbT3049ShokanJutakuKaishuDac jutakuKaishuDac,
            DbT1001HihokenshaDaichoDac daichoDac,
            DbT3035ShokanJutakuKaishuJizenShinseiDac jizenShinseiDac,
            DbT7115UwanoseShokanShuruiShikyuGendoGakuDac shikyuGendoGakuDac,
            DbT7112ShokanShuruiShikyuGendoGakuDac shuruiShikyuGendoGakuDac,
            DbT4021ShiharaiHohoHenkoDac hohoHenkoDac,
            DbT4014RiyoshaFutangakuGengakuDac 負担額減額Dac,
            DbT7060KaigoJigyoshaDac 介護事業者Dac,
            DbT7130KaigoServiceShuruiDac 介護サービス種類Dac) {
        this.mapperProvider = mapperProvider;
        this.受給者台帳Dac = 受給者台帳Dac;
        this.jutakuKaishuDac = jutakuKaishuDac;
        this.daichoDac = daichoDac;
        this.jizenShinseiDac = jizenShinseiDac;
        this.shikyuGendoGakuDac = shikyuGendoGakuDac;
        this.shuruiShikyuGendoGakuDac = shuruiShikyuGendoGakuDac;
        this.hohoHenkoDac = hohoHenkoDac;
        this.負担額減額Dac = 負担額減額Dac;
        this.介護事業者Dac = 介護事業者Dac;
        this.介護サービス種類Dac = 介護サービス種類Dac;

    }

    /**
     * 要介護認定情報取得メソッド。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 要介護認定情報
     */
    public YokaigoNinteiJyoho getYokaigoNinteiJyoho(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        List<DbT4001JukyushaDaichoEntity> entityList
                = 受給者台帳Dac.getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        YokaigoNinteiJyoho jyoho = new YokaigoNinteiJyoho(entityList.get(0).getYokaigoJotaiKubunCode(),
                entityList.get(0).getKyuSochishaFlag());
        return jyoho;
    }

    /**
     * サービス種類コードを取得するメソッド。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCode(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        YokaigoNinteiJyoho jyoho = getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
        if (jyoho == null) {
            return null;
        }
        RString 制度改正施行年月日
                = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        FlexibleYearMonth 制度改正施行年月 = new FlexibleYearMonth(制度改正施行年月日.substring(0, 区分));
        if (区分コード_01.equals(jyoho.get要介護認定状態区分コード())) {
            if (jyoho.is旧措置者フラグ()) {
                return 種類コード_45;
            } else {
                return null;
            }
        }
        if (サービス提供年月.isBefore(制度改正施行年月)) {
            if (区分コード_11.equals(jyoho.get要介護認定状態区分コード())) {
                return 種類コード_45;
            } else if (区分コード_21.equals(jyoho.get要介護認定状態区分コード())
                    || 区分コード_22.equals(jyoho.get要介護認定状態区分コード())
                    || 区分コード_23.equals(jyoho.get要介護認定状態区分コード())
                    || 区分コード_24.equals(jyoho.get要介護認定状態区分コード())
                    || 区分コード_25.equals(jyoho.get要介護認定状態区分コード())) {
                return 種類コード_42;
            } else {
                return null;
            }
        }
        if (区分コード_12.equals(jyoho.get要介護認定状態区分コード())
                || 区分コード_13.equals(jyoho.get要介護認定状態区分コード())) {
            return 種類コード_45;
        } else if (区分コード_11.equals(jyoho.get要介護認定状態区分コード())
                || 区分コード_21.equals(jyoho.get要介護認定状態区分コード())
                || 区分コード_22.equals(jyoho.get要介護認定状態区分コード())
                || 区分コード_23.equals(jyoho.get要介護認定状態区分コード())
                || 区分コード_24.equals(jyoho.get要介護認定状態区分コード())
                || 区分コード_25.equals(jyoho.get要介護認定状態区分コード())) {
            return 種類コード_42;
        } else {
            return null;
        }
    }

    /**
     * 支給限度額を取得するメソッド。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 支給限度額
     */
    public Decimal getShikyuGendoGaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {

        ServiceShuruiCode shuruiCode = getServiceShuruiCode(被保険者番号, サービス提供年月);
        if (shuruiCode == null) {
            return new Decimal(0);
        }
        List<DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity> entityList
                = shikyuGendoGakuDac.get支給限度額(shuruiCode, サービス提供年月);
        if (entityList != null && !entityList.isEmpty()) {
            return entityList.get(0).getShikyuGendoTaniSu();
        }
        List<DbT7112ShokanShuruiShikyuGendoGakuEntity> gakuentityList = shuruiShikyuGendoGakuDac.
                get償還払い給付種類支給限度額(shuruiCode, サービス提供年月);
        if (gakuentityList == null || gakuentityList.isEmpty()) {
            return new Decimal(0);
        }
        return gakuentityList.get(0).getShikyuGendoTaniSu();
    }

    /**
     * 最新住宅改修費支払結果取得。
     *
     * @param 被保険者番号 被保険者番号
     * @return 支払結果情報
     */
    public ShiharaiKekkaResult getNewJutakuKaishuHi(HihokenshaNo 被保険者番号) {
        Map<String, Object> parameter = new HashMap<>();
        parameter.put(キー.toString(), 被保険者番号);
        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        List<NewJutakuKaishuHiEntity> list = mapper.get最新住宅改修住所(parameter);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return getJutakuKaishuHi(被保険者番号, list.get(0).getServiceTeikyoYM().plusMonth(1),
                list.get(0).getJutakuKaishuJutakuAddress());
    }

    /**
     * 住宅改修費支払結果取得。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 住宅改修住宅住所 住宅改修住宅住所
     * @return 支払結果情報
     */
    public ShiharaiKekkaResult getJutakuKaishuHi(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 住宅改修住宅住所) {

        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        JutakuKaishuHiParameter parameter
                = JutakuKaishuHiParameter.createParameter(被保険者番号, サービス提供年月, null, 住宅改修住宅住所);
        List<DbT3034ShokanShinseiEntity> entityList = mapper.get開始サービス提供年月ある(parameter);
        if (entityList == null || entityList.isEmpty()) {
            entityList = mapper.get開始サービス提供年月なし(parameter);
            if (entityList == null || entityList.isEmpty()) {
                return null;
            }
        }
        FlexibleYearMonth 開始サービス提供年月 = entityList.get(0).getServiceTeikyoYM();
        parameter = JutakuKaishuHiParameter.createParameter(被保険者番号, サービス提供年月,
                開始サービス提供年月, 住宅改修住宅住所);
        ShiharaiKekaEntity result = mapper.get住宅改修費支払結果(parameter);
        if (result == null) {
            return null;
        }
        return new ShiharaiKekkaResult(result);
    }

    /**
     * 償還払支給住宅改修事前申請情報取得。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return 償還払支給住宅改修事前申請情報
     */
    public ShokanJutakuKaishuJizenShinsei getJutakuKaishuJizenShinseiJyoho(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity
                = jizenShinseiDac.get事前申請情報(被保険者番号, サービス提供年月, 整理番号);
        if (entity == null) {
            return null;
        }
        return new ShokanJutakuKaishuJizenShinsei(entity);
    }

    /**
     * 様式番号取得。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return 様式番号
     */
    public RString getYoshikiNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<DbT3049ShokanJutakuKaishuEntity> list = jutakuKaishuDac.get様式番号(被保険者番号,
                サービス提供年月, 整理番号);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0).getYoshikiNo();
    }

    /**
     * 様式番号編集。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 様式番号
     * @throws ApplicationException Exception
     */
    public RString createYoshikiNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月)
            throws ApplicationException {
        YokaigoNinteiJyoho jyoho = getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
        if (jyoho == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("?:要介護対象").evaluate());
        }
        RString 制度改正施行年月日
                = DbBusinessConfig.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        FlexibleYearMonth 制度改正施行日 = new FlexibleYearMonth(制度改正施行年月日.substring(0, 区分));
        if (サービス提供年月.isBefore(制度改正施行日)) {
            return 様式番号_21D1;
        }
        Code 要介護認定状態区分コード = jyoho.get要介護認定状態区分コード();
        boolean 旧措置者フラグ = jyoho.is旧措置者フラグ();
        if ((区分コード_01.equals(要介護認定状態区分コード) && 旧措置者フラグ)
                || 区分コード_12.equals(要介護認定状態区分コード)
                || 区分コード_13.equals(要介護認定状態区分コード)) {
            return 様式番号_21D2;
        }
        if (区分コード_11.equals(要介護認定状態区分コード)
                || 区分コード_21.equals(要介護認定状態区分コード)
                || 区分コード_22.equals(要介護認定状態区分コード)
                || 区分コード_23.equals(要介護認定状態区分コード)
                || 区分コード_24.equals(要介護認定状態区分コード)
                || 区分コード_25.equals(要介護認定状態区分コード)) {
            return 様式番号_21D1;
        }
        throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace(様式番号編集_メッセージ.toString()));
    }

    /**
     * 過去住宅改修費支払結果取得。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @return 支払結果情報
     */
    public ShiharaiKekkaResult getOldJutakuKaishuHi(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        List<DbT3049ShokanJutakuKaishuEntity> entityList = jutakuKaishuDac.get住宅改修住宅住所(被保険者番号,
                サービス提供年月, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return getNewJutakuKaishuHi(被保険者番号);
        }
        return getJutakuKaishuHi(被保険者番号, サービス提供年月, entityList.get(0).getJutakuKaishuJutakuAddress());
    }

    /**
     * 証記載保険者番号取得
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        List<DbT1001HihokenshaDaichoEntity> entityList = daichoDac.get被保険者台帳情報(被保険者番号, サービス提供年月);
        LasdecCode 市町村コード;
        if (entityList == null || entityList.isEmpty()) {
            return null;
        }
        if (nullTOEmpty(entityList.get(0).getKoikinaiTokureiSochimotoShichosonCode()) != null) {
            市町村コード = entityList.get(0).getKoikinaiTokureiSochimotoShichosonCode();
        } else {
            市町村コード = entityList.get(0).getShichosonCode();
        }
        ShichosonSecurityJoho 市町村情報セキュリティ情報
                = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村情報セキュリティ情報 == null) {
            return null;
        }
        Code 導入形態コード = 市町村情報セキュリティ情報.get導入形態コード();
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        if ((new Code(DonyuKeitaiCode.事務単一.getCode()).equals(導入形態コード))) {
            SearchResult<KoikiZenShichosonJoho> 単一市町村情報 = finder.koseiShichosonJoho();
            if (単一市町村情報 == null || 単一市町村情報.records().isEmpty()) {
                throw new ApplicationException(DbxErrorMessages.業務コンフィグなし
                        .getMessage().replace(単一市町村情報_メッセージ.toString()).evaluate());
            }
            return 単一市町村情報.records().get(0).get証記載保険者番号();
        }
        if ((new Code(DonyuKeitaiCode.事務広域.getCode()).equals(導入形態コード))
                || (new Code(DonyuKeitaiCode.事務構成市町村.getCode()).equals(導入形態コード))) {
            SearchResult<ShichosonCodeYoriShichoson> 市町村Entity = finder.shichosonCodeYoriShichosonJoho(市町村コード);
            if (市町村Entity == null || 市町村Entity.records().isEmpty()) {
                throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
            }
            return 市町村Entity.records().get(0).get証記載保険者番号();
        }
        return null;
    }

    /**
     * DB登録メソッド。
     *
     * @param shinsei shinsei
     * @param kaishuList kaishuList
     * @return 完了ステータス
     */
    @Transaction
    public boolean saveDBDate(ShokanJutakuKaishuJizenShinsei shinsei, List<ShokanJutakuKaishu> kaishuList) {

        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = shinsei.toEntity();
        entity.setState(EntityDataState.Added);
        jizenShinseiDac.save(entity);

        if (kaishuList != null && !kaishuList.isEmpty()) {
            for (ShokanJutakuKaishu kaishu : kaishuList) {
                DbT3049ShokanJutakuKaishuEntity dbt3049entity = kaishu.toEntity();
                dbt3049entity.setState(EntityDataState.Added);
                jutakuKaishuDac.save(dbt3049entity);
            }
        }
        return true;
    }

    /**
     * DB更新メソッド。
     *
     * @param shinsei shinsei
     * @param kaishuList kaishuList
     * @param mode mode
     * @return 完了ステータス
     */
    @Transaction
    public boolean updDBDate(ShokanJutakuKaishuJizenShinsei shinsei,
            List<ShokanJutakuKaishu> kaishuList, RString mode) {

        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = shinsei.toEntity();
        entity.setState(EntityDataState.Modified);
        jizenShinseiDac.save(entity);

        if (モード_修正.equals(mode) && (kaishuList != null && !kaishuList.isEmpty())) {
            for (ShokanJutakuKaishu kaishu : kaishuList) {
                if (EntityDataState.Deleted.equals(kaishu.toEntity().getState())) {
                    DbT3049ShokanJutakuKaishuEntity dbt3049entity = kaishu.toEntity();
                    dbt3049entity.setState(EntityDataState.Deleted);
                    jutakuKaishuDac.delete(dbt3049entity);
                } else {
                    jutakuKaishuDac.save(kaishu.toEntity());
                }
            }
        }
        return true;
    }

    /**
     * DB削除メソッド。
     *
     * @param shinsei shinsei
     * @param kaishuList kaishuList
     * @return 完了ステータス
     */
    @Transaction
    public boolean delDBDate(ShokanJutakuKaishuJizenShinsei shinsei, List<ShokanJutakuKaishu> kaishuList) {

        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = shinsei.toEntity();
        entity.setState(EntityDataState.Deleted);
        jizenShinseiDac.delete(entity);

        if (kaishuList != null && !kaishuList.isEmpty()) {
            for (ShokanJutakuKaishu kaishu : kaishuList) {
                DbT3049ShokanJutakuKaishuEntity dbt3049entity = kaishu.toEntity();
                dbt3049entity.setState(EntityDataState.Deleted);
                jutakuKaishuDac.delete(dbt3049entity);
            }
        }
        return true;
    }

    /**
     * 給付率取得メソッド。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @return 給付率
     */
    public HokenKyufuRitsu getKyufuritsu(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {

        RString 初期表示_給付率 = DbBusinessConfig.get(ConfigNameDBC.初期表示_給付率, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        HokenKyufuRitsu 給付率 = null;
        if (!初期表示_給付率.isNullOrEmpty()) {
            給付率 = new HokenKyufuRitsu(new Decimal(Integer.valueOf(初期表示_給付率.toString())));
        }

        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        JutakuKaishuHiParameter parameter
                = JutakuKaishuHiParameter.createParameter(被保険者番号, サービス提供年月, null, null);
        List<KyufuritsuEntity> list = mapper.getWK給付率(parameter);
        if (list != null && !list.isEmpty()) {
            if (FutanwariaiKubun._１割.getコード().equals(list.get(0).getFutanWariaiKubun())) {
                return new HokenKyufuRitsu(new Decimal(Integer.valueOf(HokenkyufuritsuTeisu.定数９０パーセント.getコード().toString())));
            } else if (FutanwariaiKubun._２割.getコード().equals(list.get(0).getFutanWariaiKubun())) {
                return new HokenKyufuRitsu(new Decimal(Integer.valueOf(HokenkyufuritsuTeisu.定数８０パーセント.getコード().toString())));
            }
        }
        List<DbT4014RiyoshaFutangakuGengakuEntity> 減額給付率list
                = 負担額減額Dac.select減額給付率(被保険者番号, サービス提供年月);
        if (減額給付率list != null && !減額給付率list.isEmpty()) {
            return 減額給付率list.get(0).getKyuhuritsu();
        }
        List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更給付率list = hohoHenkoDac.get支払方法変更給付率(
                被保険者番号, サービス提供年月);
        if (支払方法変更給付率list == null || 支払方法変更給付率list.isEmpty()) {
            return 給付率;
        }
        return 支払方法変更給付率list.get(0).getKyufuRitsu();

    }

    /**
     * 作成事業者名称の取得
     *
     * @param 理由書作成事業者番号 JigyoshaNo
     * @return AtenaMeisho
     */
    public AtenaMeisho getJigyoshaName(JigyoshaNo 理由書作成事業者番号) {
        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        DbT7060KaigoJigyoshaEntity entity = 介護事業者Dac.select事業者名称(理由書作成事業者番号, システム日付);
        if (entity == null) {
            return new AtenaMeisho(RString.EMPTY);
        }
        return entity.getJigyoshaName();
    }

    /**
     * サーピス種類名称を取得する
     *
     * @param サービス種類コード サービス種類コード
     * @param サービス提供年月 サービス提供年月
     * @return サーピス種類名称
     */
    public RString getServiceShuruiMeisho(ServiceShuruiCode サービス種類コード, FlexibleYearMonth サービス提供年月) {
        DbT7130KaigoServiceShuruiEntity entity = 介護サービス種類Dac.select給付種類(サービス種類コード, サービス提供年月);
        if (entity == null) {
            return RString.EMPTY;
        }
        return entity.getServiceShuruiMeisho();
    }

    /**
     * 空値判断
     *
     * @param 項目 LasdecCode
     * @return LasdecCode 項目
     */
    private LasdecCode nullTOEmpty(LasdecCode 項目) {
        if (項目 == null || 項目.isEmpty()) {
            return null;
        }
        return 項目;
    }
}
