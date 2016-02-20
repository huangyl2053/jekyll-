/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbc.business.core.yokaigoninteijyoho.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.IJutakuKaishuJizenShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinseiChildDivParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinseiDivParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7112ShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.shokanshinseijutakukaishu.ShokanShinseiJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7112ShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7115UwanoseShokanShuruiShikyuGendoGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.jutakukaishujizenshinsei.IJutakuKaishuJizenShinseiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.IsKyuSoti;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
//mport jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
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
    DbT3049ShokanJutakuKaishuDac JutakuKaishuDac;
    DbT1001HihokenshaDaichoDac daichoDac;
    DbT3035ShokanJutakuKaishuJizenShinseiDac jizenShinseiDac;
    DbT7115UwanoseShokanShuruiShikyuGendoGakuDac shikyuGendoGakuDac;
    DbT7112ShokanShuruiShikyuGendoGakuDac shuruiShikyuGendoGakuDac;
    DbT4021ShiharaiHohoHenkoDac hohoHenkoDac;

    public JutakuKaishuJizenShinsei(MapperProvider mapperProvider) {
        this.受給者台帳Dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.JutakuKaishuDac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
        this.daichoDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.jizenShinseiDac = InstanceProvider.create(DbT3035ShokanJutakuKaishuJizenShinseiDac.class);
        this.shikyuGendoGakuDac = InstanceProvider.create(DbT7115UwanoseShokanShuruiShikyuGendoGakuDac.class);
        this.shuruiShikyuGendoGakuDac = InstanceProvider.create(DbT7112ShokanShuruiShikyuGendoGakuDac.class);
        this.hohoHenkoDac=InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.mapperProvider = mapperProvider;

    }

    public static JutakuKaishuJizenShinsei createInstance() {
        return InstanceProvider.create(JutakuKaishuJizenShinsei.class);
    }
    
    /**
     * 要介護認定情報取得メソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return 要介護認定情報
     */
    public YokaigoNinteiJyoho getYokaigoNinteiJyoho(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        List<DbT4001JukyushaDaichoEntity> entityList = 受給者台帳Dac.getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        } else {
            YokaigoNinteiJyoho jyoho = new YokaigoNinteiJyoho(entityList.get(0));
            return jyoho;
        }
    }

    /**
     * 該当被保険者の要介護状態区分に対する住宅改修のサービス種類コードを取得するメソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCode(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        ServiceShuruiCode shuruiCode;
        YokaigoNinteiJyoho jyoho = getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
        if (jyoho == null) {
            return null;
        } else {
            RString 制度改正施行日_平成１８年０４月改正 = BusinessConfig.get(ConfigNameDBU.
                    制度改正施行日_平成１８年０４月改正, SubGyomuCode.DBU介護統計報告);
            FlexibleYearMonth 制度改正施行日 = new FlexibleYearMonth(制度改正施行日_平成１８年０４月改正.substring(0, 6));
            if (new Code("01").equals(jyoho.get要介護認定状態区分コード())) {
                if (jyoho.get旧措置者フラグ() == IsKyuSoti.旧措置適用.getコード()) {
                    shuruiCode = new ServiceShuruiCode("45");
                    return shuruiCode;
                } else {
                    return null;
                }
            } else if (サービス提供年月.isBefore(制度改正施行日)) {
                if (jyoho.get要介護認定状態区分コード() != null) {
                    switch (jyoho.get要介護認定状態区分コード().toString()) {
                        case "11":
                            shuruiCode = new ServiceShuruiCode("45");
                            return shuruiCode;
                        case "21":
                        case "22":
                        case "23":
                        case "24":
                        case "25":
                            shuruiCode = new ServiceShuruiCode("42");
                            return shuruiCode;
                        default:
                            return null;

                    }
                } else {
                    return null;
                }
            } else {
                if (jyoho.get要介護認定状態区分コード() != null) {
                    switch (jyoho.get要介護認定状態区分コード().value().toString()) {
                        case "12":
                        case "13":
                            shuruiCode = new ServiceShuruiCode("45");
                            return shuruiCode;

                        case "11":
                        case "21":
                        case "22":
                        case "23":
                        case "24":
                        case "25":
                            shuruiCode = new ServiceShuruiCode("42");
                            return shuruiCode;
                        default:
                            return null;

                    }
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * 該当被保険者住の要介護状態区分に対する支給限度額を取得するメソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return 支給限度額
     */
    public Decimal getShikyuGendoGaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        Decimal amount;
        ServiceShuruiCode shuruiCode = getServiceShuruiCode(被保険者番号, サービス提供年月);
        //  shuruiCode=new ServiceShuruiCode("42");
        if (shuruiCode == null) {
            return new Decimal(0);
        } else {
            List<DbT7115UwanoseShokanShuruiShikyuGendoGakuEntity> entityList = shikyuGendoGakuDac.
                    get上乗せ償還払い給付種類支給限度額(shuruiCode, サービス提供年月);
            if (entityList == null || entityList.isEmpty() || entityList.get(0).getShikyuGendoTaniSu() == null) {
                List<DbT7112ShokanShuruiShikyuGendoGakuEntity> gakuentityList = shuruiShikyuGendoGakuDac.
                        get償還払い給付種類支給限度額(shuruiCode, サービス提供年月);

                if (entityList == null || gakuentityList.isEmpty() || gakuentityList.get(0).
                        getShikyuGendoTaniSu() == null) {
                    return new Decimal(0);
                } else {
                    amount = gakuentityList.get(0).getShikyuGendoTaniSu();
                    return amount;
                }
            } else {
                amount = entityList.get(0).getShikyuGendoTaniSu();
                return amount;
            }
        }
    }

    /**
     * 最新住宅改修の住宅住所に対する前回までの支払結果を取得するメソッド。
     *
     * @param 被保険者番号
     * @return 支払結果情報
     */
    public ShokanShinsei getNewJutakuKaishuHi(HihokenshaNo 被保険者番号) {
        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        IJutakuKaishuJizenShinseiMapperParameter parameter = IJutakuKaishuJizenShinseiMapperParameter.
                createParameterForJutakuKaishuJizenShinsei(
                        被保険者番号, RString.EMPTY, RString.EMPTY, FlexibleYearMonth.MAX,
                        FlexibleYearMonth.MAX, ServiceShuruiCode.EMPTY);
        List<ShokanShinseiJutakuKaishuEntity> list = mapper.get最新住宅改修の住宅住所(parameter);
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            ShokanShinseiJutakuKaishuEntity entity = list.get(0);           
            return getJutakuKaishuHi(被保険者番号, entity.getServiceTeikyoYM().plusMonth(1),
                    entity.getJutakuKaishuJutakuAddress());
        }
    }

    /**
     * 住宅住所に対する過去の住宅改修費支払結果を取得するメソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 住宅改修住宅住所
     * @return 支払結果情報
     */
    public ShokanShinsei getJutakuKaishuHi(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, 
            RString 住宅改修住宅住所) {
        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        List<DbT3034ShokanShinseiEntity> list;
        IJutakuKaishuJizenShinseiMapperParameter parameter = IJutakuKaishuJizenShinseiMapperParameter.
                createParameterForJutakuKaishuJizenShinsei(被保険者番号, RString.EMPTY, 住宅改修住宅住所,
                        サービス提供年月, FlexibleYearMonth.EMPTY, ServiceShuruiCode.EMPTY);
        List<DbT3034ShokanShinseiEntity> entityList = mapper.
                get支払結果計算の開始サービス提供年月限度額リセットがある(parameter);
        if (entityList == null || entityList.isEmpty()) {
            entityList = mapper.get支払結果計算の開始サービス提供年月限度額リセットなし(parameter);
            if (entityList == null || entityList.isEmpty()) {
                return null;
            } else {
                parameter = IJutakuKaishuJizenShinseiMapperParameter.
                        createParameterForJutakuKaishuJizenShinsei(被保険者番号, 住宅改修住宅住所,
                                住宅改修住宅住所, entityList.get(0).getServiceTeikyoYM(),
                                FlexibleYearMonth.MAX, ServiceShuruiCode.EMPTY);
                list = mapper.get住宅改修費支払結果(parameter);
            }
        } else {
            parameter = IJutakuKaishuJizenShinseiMapperParameter.
                    createParameterForJutakuKaishuJizenShinsei(被保険者番号, 住宅改修住宅住所,
                            住宅改修住宅住所, entityList.get(0).getServiceTeikyoYM(),
                            FlexibleYearMonth.MAX, ServiceShuruiCode.EMPTY);
            list = mapper.get住宅改修費支払結果(parameter);
        }
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return new ShokanShinsei(list.get(0));
        }
    }

    /**
     * 引数の被保険者番号、サービス提供年月、整理番号より、償還払支給住宅改修事前申請情報を取得するメソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return 償還払支給住宅改修事前申請情報
     */
    public ShokanJutakuKaishuJizenShinsei getJutakuKaishuJizenShinseiJyoho(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<DbT3035ShokanJutakuKaishuJizenShinseiEntity> entityList = jizenShinseiDac.
                get償還払支給住宅改修事前申請情報(被保険者番号, サービス提供年月, 整理番号);
        if (entityList == null || entityList.isEmpty()) {
            return null;
        } else {
            return new ShokanJutakuKaishuJizenShinsei(entityList.get(0));
        }
    }

    /**
     * 引数の被保険者番号、サービス提供年月、整理番号より、償還払請求住宅改修から様式番号を取得するメソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return 様式番号
     */
    public RString getYoshikiNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) {
        List<DbT3049ShokanJutakuKaishuEntity> list = JutakuKaishuDac.get様式番号(被保険者番号,
                サービス提供年月, 整理番号);
        if (list==null||list.isEmpty() || list.get(0).getYoshikiNo() == null) {
            return null;
        } else {
            return list.get(0).getYoshikiNo();
        }
    }

    /**
     * 該当被保険者の要介護認定状態区分コードより住宅改修の様式番号を取得するメソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return 様式番号
     */
    public RString createYoshikiNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        YokaigoNinteiJyoho jyoho = getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
        if (jyoho == null) {
            throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("?:要介護対象"));
        } else {
            RString 制度改正施行日_平成１８年０４月改正 = BusinessConfig.
                    get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, SubGyomuCode.DBU介護統計報告);
            FlexibleYearMonth 制度改正施行日 = new FlexibleYearMonth(制度改正施行日_平成１８年０４月改正.
                    substring(0, 6));
            if (サービス提供年月.isBefore(制度改正施行日)) {
                return new RString("21D1");
            } else {
                Code 要介護認定状態区分コード = jyoho.get要介護認定状態区分コード();
                boolean 旧措置者フラグ = jyoho.get旧措置者フラグ();
                if ((new Code("01").equals(要介護認定状態区分コード) && 旧措置者フラグ == IsKyuSoti.旧措置適用.getコード())
                        || new Code("12").equals(要介護認定状態区分コード)
                        || new Code("13").equals(要介護認定状態区分コード)) {
                    return new RString("21D2");
                } else if (new Code("11").equals(要介護認定状態区分コード)||new Code("21").
                        equals(要介護認定状態区分コード) || new Code("22").
                        equals(要介護認定状態区分コード) || new Code("23").equals(要介護認定状態区分コード)
                        || new Code("24").equals(要介護認定状態区分コード) || new Code("25").
                                equals(要介護認定状態区分コード)) {
                    return new RString("21D1");
                } else {
                    throw new ApplicationException(UrErrorMessages.存在しない.getMessage().replace("?:要介護対象"));
                }
            }
        }
    }

    /**
     * 過去住宅改修費支払結果取得メソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @return 支払結果情報
     */
    public ShokanShinsei getOldJutakuKaishuHi(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, 
            RString 整理番号) {
        List<DbT3049ShokanJutakuKaishuEntity> entityList = JutakuKaishuDac.get今回住宅改修の住宅住所(被保険者番号, 
                サービス提供年月, 整理番号);
        if (entityList==null||entityList.isEmpty() || entityList.get(0).getJutakuKaishuJutakuAddress() == null) {
            return getNewJutakuKaishuHi(被保険者番号);
        } else {
            return getJutakuKaishuHi(被保険者番号, サービス提供年月, entityList.get(0).getJutakuKaishuJutakuAddress());
        }

    }

    /**
     * 証記載保険者番号取得メソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return 証記載保険者番号
     */
    public RString getShoKisaiHokenshaNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        List<DbT1001HihokenshaDaichoEntity> entityList = daichoDac.get被保険者台帳情報(被保険者番号, サービス提供年月);
        LasdecCode 市町村コード;
        if (entityList==null||entityList.isEmpty()) {
            return null;
        } else {
            if (entityList.get(0).getKoikinaiTokureiSochimotoShichosonCode() != null) {
                市町村コード = entityList.get(0).getKoikinaiTokureiSochimotoShichosonCode();
            } else {
                市町村コード = entityList.get(0).getShichosonCode();
            }
        }
        ShichosonSecurityJoho 市町村情報セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.
                介護事務);
        Code 導入形態コード = 市町村情報セキュリティ情報.get導入形態コード();
        if ((new Code(DonyuKeitaiCode.事務単一.getCode()).equals(市町村情報セキュリティ情報.get導入形態コード()))) {
            //TODO
            return null;

        } else if ((new Code(DonyuKeitaiCode.事務広域.getCode()).equals(市町村情報セキュリティ情報.get導入形態コード())) ||
                (new Code(DonyuKeitaiCode.事務構成市町村.getCode()).
                        equals(市町村情報セキュリティ情報.get導入形態コード()))) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            return new RString(finder.shichosonCodeYoriShichosonJoho(市町村コード).records().get(0).
                    get証記載保険者番号().toString());
        }

        return null;
    }

    /**
     * DB登録メソッド。
     *
     * @param parameter
     * @return 完了ステータス
     */
    @Transaction
    public boolean saveDBDate(JutakuKaishuJizenShinseiDivParameter parameter) {
        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
        entity.setHiHokenshaNo(parameter.get被保険者番号());
        entity.setServiceTeikyoYM(parameter.getサービス提供年月());
        entity.setSeiriNo(parameter.get整理番号());
        entity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
        entity.setUketsukeYMD(parameter.get受付年月日());
        entity.setShinseiYMD(parameter.get申請年月日());
        entity.setShinseiRiyu(parameter.get申請理由());
        entity.setShinseishaKubun(parameter.get申請者区分());
        entity.setShinseishaNameKanji(parameter.get申請者氏名());
        entity.setShinseishaNameKana(parameter.get申請者氏名カナ());
        entity.setShinseishaYubinNo(parameter.get申請者郵便番号());
        entity.setShinseishaJusho(parameter.get申請者住所());
        entity.setShinseishaTelNo(parameter.get申請者電話番号());
        entity.setShinseiJigyoshaNo(parameter.get申請事業者番号());
        entity.setRiyushoSakuseiYMD(parameter.get理由書作成日());
        entity.setRiyushoSakuseishaName(parameter.get理由書作成者());
        entity.setRiyushoSakuseishaKanaName(parameter.get理由書作成者カナ());
        entity.setRiyushoSakuseiJigyoshaNo(parameter.get理由書作成事業者番号());
        entity.setShiharaiHohoKubunCode(parameter.get支払方法区分コード());
        entity.setShiharaiBasho(parameter.get支払場所());
        entity.setShiharaiKaishiYMD(parameter.get支払期間開始年月日());
        entity.setShiharaiShuryoYMD(parameter.get支払期間終了年月日());
        entity.setShiharaiKaishiTime(parameter.get支払窓口開始時間());
        entity.setShiharaiShuryoTime(parameter.get支払窓口終了時間());
        entity.setKozaID(parameter.get口座ID());
        entity.setJuryoininKeiyakuNo(parameter.get受領委任契約番号());
        entity.setServiceShuruiCode(parameter.getサービス種類コード());
        entity.setJutakuShoyusha(parameter.get住宅所有者());
        entity.setHihokenshaKankei(parameter.get被保険者の関係());
        entity.setYokaigo3DankaiHenko(parameter.is要介護状態３段階変更());
        entity.setJutakuJushoHenko(parameter.is住宅住所変更());
        entity.setHanteiKetteiYMD(parameter.get判定決定年月日());
        entity.setHanteiKubun(parameter.get判定区分());
        entity.setShoninJoken(parameter.get承認条件());
        entity.setFushoninRiyu(parameter.get不承認理由());

        entity.setKyufugakuHiyogakuTotal(parameter.get給付額等費用額合計());
        entity.setKyufugakuHokenTaishoHiyogaku(parameter.get給付額等保険対象費用額());
        entity.setKyufugakuRiyoshaJikofutangaku(parameter.get給付額等利用者自己負担額());
        entity.setKyufugakuHokenkyufuhigaku(parameter.get給付額等保険給付費額());
        entity.setKetteitsuchishoHakkoYMD(parameter.get事前申請決定通知発行日());
        entity.setKaishushinseiKubun(parameter.get住宅改修申請区分());
        entity.setKaishuShinseiTorikeshijiyuCode(parameter.get住宅改修申請取消事由コード());
        entity.setHokenKyufuritsu(parameter.get保険給付率());
        entity.setState(EntityDataState.Added);
        DbT3035ShokanJutakuKaishuJizenShinseiDac dac = InstanceProvider.create(DbT3035ShokanJutakuKaishuJizenShinseiDac.
                class);
        dac.save(entity);
        DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
        DbT3049ShokanJutakuKaishuDac kaishuDac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
        JutakuKaishuJizenShinseiChildDivParameter divParameter;
        for (int i = 0; i < parameter.getParameterList().size(); i++) {
            divParameter = parameter.getParameterList().get(i);
            shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
            shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
            shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
            shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
            shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
            shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
            shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
            shokanJutakuKaishuEntity.setServiceCode(divParameter.getサービスコード());
            shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
            shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
            shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
            shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
            shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
            shokanJutakuKaishuEntity.setShinsaHohoKubunCode(divParameter.get審査方法区分コード());
            shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
            shokanJutakuKaishuEntity.setSagakuKingaku(divParameter.get差額金額());
            shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
            shokanJutakuKaishuEntity.setState(EntityDataState.Added);
            kaishuDac.save(shokanJutakuKaishuEntity);
        }
        return true;
    }

    /**
     * DB更新メソッド。
     *
     * @param parameter
     * @return 完了ステータス
     */
    @Transaction
    public boolean updDBDate(JutakuKaishuJizenShinseiDivParameter parameter, RString mode) {
//
//        try {
        DbT3035ShokanJutakuKaishuJizenShinseiDac dac = InstanceProvider.create(DbT3035ShokanJutakuKaishuJizenShinseiDac.
                class);
        DbT3035ShokanJutakuKaishuJizenShinseiEntity shinSeiEntity = dac.selectByKey(parameter.get被保険者番号(),
                parameter.getサービス提供年月(), parameter.get整理番号());
        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
        entity.setHiHokenshaNo(parameter.get被保険者番号());
        entity.setServiceTeikyoYM(parameter.getサービス提供年月());
        entity.setSeiriNo(parameter.get整理番号());
        entity.setShinseiYMD(parameter.get申請年月日());
        entity.setShinseiRiyu(parameter.get申請理由());
        entity.setShinseishaKubun(parameter.get申請者区分());
        entity.setShinseishaNameKanji(parameter.get申請者氏名());
        entity.setShinseishaNameKana(parameter.get申請者氏名カナ());
        entity.setShinseishaYubinNo(parameter.get申請者郵便番号());
        entity.setShinseishaJusho(parameter.get申請者住所());
        entity.setShinseishaTelNo(parameter.get申請者電話番号());
        entity.setShinseiJigyoshaNo(parameter.get申請事業者番号());
        entity.setRiyushoSakuseiYMD(parameter.get理由書作成日());
        entity.setRiyushoSakuseishaName(parameter.get理由書作成者());
        entity.setRiyushoSakuseishaKanaName(parameter.get理由書作成者カナ());
        entity.setRiyushoSakuseiJigyoshaNo(parameter.get理由書作成事業者番号());
        entity.setShiharaiHohoKubunCode(parameter.get支払方法区分コード());
        entity.setShiharaiBasho(parameter.get支払場所());
        entity.setShiharaiKaishiYMD(parameter.get支払期間開始年月日());
        entity.setShiharaiShuryoYMD(parameter.get支払期間終了年月日());
        entity.setShiharaiKaishiTime(parameter.get支払窓口開始時間());
        entity.setShiharaiShuryoTime(parameter.get支払窓口終了時間());
        entity.setKozaID(parameter.get口座ID());
        entity.setJuryoininKeiyakuNo(parameter.get受領委任契約番号());
        entity.setServiceShuruiCode(parameter.getサービス種類コード());
        entity.setJutakuShoyusha(parameter.get住宅所有者());
        entity.setHihokenshaKankei(parameter.get被保険者の関係());
        entity.setYokaigo3DankaiHenko(parameter.is要介護状態３段階変更());
        entity.setJutakuJushoHenko(parameter.is住宅住所変更());
        entity.setHanteiKetteiYMD(parameter.get判定決定年月日());
        entity.setHanteiKubun(parameter.get判定区分());
        entity.setShoninJoken(parameter.get承認条件());
        entity.setFushoninRiyu(parameter.get不承認理由());
        entity.setKyufugakuHiyogakuTotal(parameter.get給付額等費用額合計());
        entity.setKyufugakuHokenTaishoHiyogaku(parameter.get給付額等保険対象費用額());
        entity.setKyufugakuRiyoshaJikofutangaku(parameter.get給付額等利用者自己負担額());
        entity.setKyufugakuHokenkyufuhigaku(parameter.get給付額等保険給付費額());
        entity.setKetteitsuchishoHakkoYMD(parameter.get事前申請決定通知発行日());
        entity.setHokenKyufuritsu(parameter.get保険給付率());
        entity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
        entity.setState(EntityDataState.Modified);
        dac.save(entity);
        if (new RString("Modified").equals(mode)) {
            DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity;
            DbT3049ShokanJutakuKaishuDac kaishuDac = InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
            JutakuKaishuJizenShinseiChildDivParameter divParameter;
            for (int i = 0; i < parameter.getParameterList().size(); i++) {
                shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
                divParameter = parameter.getParameterList().get(i);
                if (EntityDataState.Added.equals(divParameter.getStatus())) {

                    shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
                    shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
                    shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
                    shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
                    shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
                    shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
                    shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
                    shokanJutakuKaishuEntity.setServiceCode(divParameter.getサービスコード());
                    shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
                    shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
                    shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
                    shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
                    shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
                    shokanJutakuKaishuEntity.setShinsaHohoKubunCode(divParameter.get審査方法区分コード());
                    shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
                    shokanJutakuKaishuEntity.setSagakuKingaku(divParameter.get差額金額());
                    shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
                    shokanJutakuKaishuEntity.setState(EntityDataState.Added);
                    kaishuDac.save(shokanJutakuKaishuEntity);
                } else if (EntityDataState.Modified.equals(divParameter.getStatus())) {
                    shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
                    shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
                    shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
                    shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
                    shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
                    shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
                    shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
                    shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
                    shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
                    shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
                    shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
                    shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
                    shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
                    shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
                    shokanJutakuKaishuEntity.setState(EntityDataState.Modified);
                    kaishuDac.save(shokanJutakuKaishuEntity);
                } else if (EntityDataState.Deleted.equals(divParameter.getStatus())) {
                    shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
                    shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
                    shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
                    shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
                    shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
                    shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
                    shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
                    shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
                    shokanJutakuKaishuEntity.setState(EntityDataState.Modified);
                    kaishuDac.save(shokanJutakuKaishuEntity);
                } else {
                    shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
                    shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
                    shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
                    shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
                    shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
                    shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
                    shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
                    shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
                    shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
                    shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
                    shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
                    shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
                    shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
                    shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
                    shokanJutakuKaishuEntity.setState(EntityDataState.Modified);
                    kaishuDac.save(shokanJutakuKaishuEntity);
                }
            }
        }
//        } catch (NullPointerException e) {
//            return false;
//        }

        return true;
    }

    /**
     * DB削除メソッド。
     *
     * @param parameter
     * @return 完了ステータス
     */
    public boolean delDBDate(JutakuKaishuJizenShinseiDivParameter parameter) {
        DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity;
        DbT3049ShokanJutakuKaishuDac kaishuDac = new DbT3049ShokanJutakuKaishuDac();
        JutakuKaishuJizenShinseiChildDivParameter divParameter;
        try {
            for (int i = 0; i < parameter.getParameterList().size(); i++) {
                shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
                divParameter = parameter.getParameterList().get(i);
                shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
                shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
                shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
                shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
                shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
                shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
                shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
                shokanJutakuKaishuEntity.setState(EntityDataState.Deleted);
                kaishuDac.save(shokanJutakuKaishuEntity);
            }
            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
            entity.setHiHokenshaNo(parameter.get被保険者番号());
            entity.setServiceTeikyoYM(parameter.getサービス提供年月());
            entity.setSeiriNo(parameter.get整理番号());
            entity.setState(EntityDataState.Deleted);
            DbT3035ShokanJutakuKaishuJizenShinseiDac dac = new DbT3035ShokanJutakuKaishuJizenShinseiDac();
            dac.save(entity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 給付率取得メソッド。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return 給付率
     */
    Decimal getKyufuritsu(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        Decimal WK給付率 = null;
        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        IJutakuKaishuJizenShinseiMapperParameter parameter = IJutakuKaishuJizenShinseiMapperParameter.
                createParameterForJutakuKaishuJizenShinsei(被保険者番号, RString.EMPTY, RString.EMPTY, サービス提供年月,
                        FlexibleYearMonth.EMPTY, ServiceShuruiCode.EMPTY);
        List<DbT3113RiyoshaFutanWariaiEntity> list = mapper.getWK給付率(parameter);
        if (list==null||list.isEmpty()) {
            List<DbT4014RiyoshaFutangakuGengakuEntity> 減額給付率list = mapper.get減額給付率(parameter);
            if (list==null||減額給付率list.isEmpty()) {
                List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更給付率list = hohoHenkoDac.get支払方法変更給付率(
                        被保険者番号,サービス提供年月);
                if (支払方法変更給付率list == null||支払方法変更給付率list.isEmpty()||支払方法変更給付率list.get(0).
                        getKyufuRitsu()==null) {
                    return WK給付率;
                } else {
                    if(支払方法変更給付率list.get(0).getKyufuRitsu()==null){
                        return WK給付率;
                    }else{                       
                    return 支払方法変更給付率list.get(0).getKyufuRitsu().value();
                    }
                }
            } else {
                return 減額給付率list.get(0).getKyuhuritsu().value();
            }
        } else {
            //TODO
            return list.get(0).getRirekiNo();
        }
    }
}
