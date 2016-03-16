/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishu;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.ShiharaiKekkaResult;
import jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.definition.core.futanwariai.FutanwariaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.hokenkyufuritsuteisu.HokenkyufuritsuTeisu;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.config.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishujizenshinsei.JutakuKaishuHiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
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
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4014RiyoshaFutangakuGengakuDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 住宅改修費事前申請クラスです
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
    private static final int 区分 = 6;

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
     */
    public JutakuKaishuJizenShinsei(MapperProvider mapperProvider,
            DbT4001JukyushaDaichoDac 受給者台帳Dac,
            DbT3049ShokanJutakuKaishuDac jutakuKaishuDac,
            DbT1001HihokenshaDaichoDac daichoDac,
            DbT3035ShokanJutakuKaishuJizenShinseiDac jizenShinseiDac,
            DbT7115UwanoseShokanShuruiShikyuGendoGakuDac shikyuGendoGakuDac,
            DbT7112ShokanShuruiShikyuGendoGakuDac shuruiShikyuGendoGakuDac,
            DbT4021ShiharaiHohoHenkoDac hohoHenkoDac,
            DbT4014RiyoshaFutangakuGengakuDac 負担額減額Dac) {
        this.mapperProvider = mapperProvider;
        this.受給者台帳Dac = 受給者台帳Dac;
        this.jutakuKaishuDac = jutakuKaishuDac;
        this.daichoDac = daichoDac;
        this.jizenShinseiDac = jizenShinseiDac;
        this.shikyuGendoGakuDac = shikyuGendoGakuDac;
        this.shuruiShikyuGendoGakuDac = shuruiShikyuGendoGakuDac;
        this.hohoHenkoDac = hohoHenkoDac;
        this.負担額減額Dac = 負担額減額Dac;

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
                = DbBusinessConifg.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        FlexibleYearMonth 制度改正施行年月 = new FlexibleYearMonth(制度改正施行年月日.substring(0, 区分));
        if (new Code("01").equals(jyoho.get要介護認定状態区分コード())) {
            if (jyoho.is旧措置者フラグ()) {
                return new ServiceShuruiCode("45");
            } else {
                return null;
            }
        }
        if (サービス提供年月.isBefore(制度改正施行年月)) {
            switch (jyoho.get要介護認定状態区分コード().value().toString()) {
                case "11":
                    return new ServiceShuruiCode("45");
                case "21":
                case "22":
                case "23":
                case "24":
                case "25":
                    return new ServiceShuruiCode("42");
                default:
                    return null;
            }
        }
        switch (jyoho.get要介護認定状態区分コード().value().toString()) {
            case "12":
            case "13":
                return new ServiceShuruiCode("45");
            case "11":
            case "21":
            case "22":
            case "23":
            case "24":
            case "25":
                return new ServiceShuruiCode("42");
            default:
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
        parameter.put("hiHokenshaNo", 被保険者番号);
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
                = DbBusinessConifg.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
        FlexibleYearMonth 制度改正施行日 = new FlexibleYearMonth(制度改正施行年月日.substring(0, 区分));
        if (サービス提供年月.isBefore(制度改正施行日)) {
            return new RString("21D1");
        }
        Code 要介護認定状態区分コード = jyoho.get要介護認定状態区分コード();
        boolean 旧措置者フラグ = jyoho.is旧措置者フラグ();
        if ((new Code("01").equals(要介護認定状態区分コード) && 旧措置者フラグ)
                || new Code("12").equals(要介護認定状態区分コード)
                || new Code("13").equals(要介護認定状態区分コード)) {
            return new RString("21D2");
        }
        if (new Code("11").equals(要介護認定状態区分コード)
                || new Code("21").equals(要介護認定状態区分コード)
                || new Code("22").equals(要介護認定状態区分コード)
                || new Code("23").equals(要介護認定状態区分コード)
                || new Code("24").equals(要介護認定状態区分コード)
                || new Code("25").equals(要介護認定状態区分コード)) {
            return new RString("21D1");
        }
        throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("?:要介護対象"));
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
        if (entityList.get(0).getKoikinaiTokureiSochimotoShichosonCode() != null) {
            市町村コード = entityList.get(0).getKoikinaiTokureiSochimotoShichosonCode();
        } else {
            市町村コード = entityList.get(0).getShichosonCode();
        }
        ShichosonSecurityJoho 市町村情報セキュリティ情報
                = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        Code 導入形態コード = 市町村情報セキュリティ情報.get導入形態コード();
        KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
        if ((new Code(DonyuKeitaiCode.事務単一.getCode()).equals(導入形態コード))) {
            return finder.koseiShichosonJoho().records().get(0).get証記載保険者番号();
        }
        if ((new Code(DonyuKeitaiCode.事務広域.getCode()).equals(導入形態コード))
                || (new Code(DonyuKeitaiCode.事務構成市町村.getCode()).equals(導入形態コード))) {
            return finder.shichosonCodeYoriShichosonJoho(市町村コード).records().get(0).get証記載保険者番号();
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

        jizenShinseiDac.save(shinsei.toEntity());

        if (kaishuList != null && !kaishuList.isEmpty()) {
            for (ShokanJutakuKaishu kaishu : kaishuList) {
                jutakuKaishuDac.save(kaishu.toEntity());
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

        jizenShinseiDac.save(shinsei.toEntity());

        if (new RString("修正").equals(mode) && (kaishuList != null && !kaishuList.isEmpty())) {
            for (ShokanJutakuKaishu kaishu : kaishuList) {
                if (EntityDataState.Deleted.equals(kaishu.toEntity().getState())) {
                    jutakuKaishuDac.delete(kaishu.toEntity());
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

        jizenShinseiDac.delete(shinsei.toEntity());

        if (kaishuList != null && !kaishuList.isEmpty()) {
            for (ShokanJutakuKaishu kaishu : kaishuList) {
                jutakuKaishuDac.delete(kaishu.toEntity());
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

        HokenKyufuRitsu 給付率 = new HokenKyufuRitsu(new Decimal(Integer.valueOf(
                DbBusinessConifg.get(ConfigNameDBC.初期表示_給付率, RDate.getNowDate(), SubGyomuCode.DBC介護給付).toString())));
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
}
