/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.jutakukaishujizenshinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.yokaigoninteijyoho.YokaigoNinteiJyohoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.db.dbc.business.core.yokaigoninteijyoho.YokaigoNinteiJyoho;
import jp.co.ndensan.reams.db.dbc.persistence.db.jutakukaishujizenshinsei.IJutakuKaishuJizenShinseiMapper;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbc.business.core.shiharaikekka.ShiharaiKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.IJutakuKaishuJizenShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinseiChildDivParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.JutakuKaishuJizenShinseiDivParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishuhi.JutakuKaishuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.shiharaikekka.ShiharaiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.shokanshinseijutakukaishu.ShokanShinseiJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3049ShokanJutakuKaishuDac;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.IsKyuSoti;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.DonyukeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.db.dbx.service.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.koikishichosonjoho.KoikiShichosonJohoFinder;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 * @author sunhui
 */
public class JutakuKaishuJizenShinsei {

    private final MapperProvider mapperProvider;
    private final DbT4001JukyushaDaichoDac 受給者台帳Dac;
    DbT3049ShokanJutakuKaishuDac JutakuKaishuDac;
    DbT1001HihokenshaDaichoDac daichoDac;
    DbT3035ShokanJutakuKaishuJizenShinseiDac jizenShinseiDac;

    public JutakuKaishuJizenShinsei(MapperProvider mapperProvider) {
        this.受給者台帳Dac= InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
        this.JutakuKaishuDac=InstanceProvider.create(DbT3049ShokanJutakuKaishuDac.class);
        this.daichoDac=InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.jizenShinseiDac=InstanceProvider.create(DbT3035ShokanJutakuKaishuJizenShinseiDac.class);
        
       this.mapperProvider = mapperProvider;

    }

//    public JutakuKaishuJizenShinsei(MapperProvider provider,
//            DbT4001JukyushaDaichoDac 受給者台帳Dac) {
//        this.mapperProvider = provider;
//        this.受給者台帳Dac = 受給者台帳Dac;
//    }

    public YokaigoNinteiJyoho getYokaigoNinteiJyoho(HihokenshaNo 被保険者番号, FlexibleDate サービス提供年月) {
        DbT4001JukyushaDaichoEntity entity=受給者台帳Dac.getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
                if (entity==null) {
            return null;
        } else {
            YokaigoNinteiJyoho jyoho = new YokaigoNinteiJyoho(entity);
            return jyoho;
        }
//        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
//        IJutakuKaishuJizenShinseiMapperParameter parameter = IJutakuKaishuJizenShinseiMapperParameter.createParameterForJutakuKaishuJizenShinsei(被保険者番号, RString.EMPTY, RString.EMPTY, サービス提供年月, ServiceShuruiCode.EMPTY);
//        List<YokaigoNinteiJyohoEntity> list = mapper.getYokaigoNinteiJyoho(parameter);
//        if (list.isEmpty()) {
//            return null;
//        } else {
//            YokaigoNinteiJyoho jyoho = new YokaigoNinteiJyoho(list.get(0));
//            return jyoho;
//        }
    }

//    public ServiceShuruiCode getServiceShuruiCode(HihokenshaNo 被保険者番号, FlexibleDate サービス提供年月) {
//        YokaigoNinteiJyoho jyoho = getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
//        ServiceShuruiCode shuruiCode = null;
//        if (jyoho == null) {
//            return null;
//        } else {
//            RString 制度改正施行日_平成１８年０４月改正 = BusinessConfig.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, SubGyomuCode.DBU介護統計報告);
//            FlexibleDate 制度改正施行日 = new FlexibleDate(制度改正施行日_平成１８年０４月改正);
//            if ("01".equals(jyoho.get要介護認定状態区分コード().toString())) {
//                if (jyoho.get旧措置者フラグ() == IsKyuSoti.旧措置適用.getコード()) {
//                    shuruiCode = new ServiceShuruiCode("45");
//                    return shuruiCode;
//                } else if (jyoho.get旧措置者フラグ() == IsKyuSoti.適用外.getコード()) {
//                    return null;
//                }
//            } else if (サービス提供年月.compareTo(制度改正施行日) < 0) {
//                switch (jyoho.get要介護認定状態区分コード().toString()) {
//                    case "11":
//                        shuruiCode = new ServiceShuruiCode("45");
//                        return shuruiCode;
//                    case "21":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "22":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "23":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "24":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "25":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    default:
//                        return null;
//
//                }
//            } else if (サービス提供年月.compareTo(制度改正施行日) > 0) {
//                switch (jyoho.get要介護認定状態区分コード().toString()) {
//                    case "12":
//                        shuruiCode = new ServiceShuruiCode("45");
//                        return shuruiCode;
//                    case "13":
//                        shuruiCode = new ServiceShuruiCode("45");
//                        return shuruiCode;
//                    case "11":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "21":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "22":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "23":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "24":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    case "25":
//                        shuruiCode = new ServiceShuruiCode("42");
//                        return shuruiCode;
//                    default:
//                        return null;
//
//                }
//            }
//        }
//        return shuruiCode;
//    }
//
//    public Decimal getShikyuGendoGaku(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
//        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
//        ServiceShuruiCode shuruiCode = getServiceShuruiCode(被保険者番号, サービス提供年月);
//        IJutakuKaishuJizenShinseiMapperParameter parameter = IJutakuKaishuJizenShinseiMapperParameter.createParameterForJutakuKaishuJizenShinsei(被保険者番号, RString.EMPTY, RString.EMPTY, サービス提供年月, shuruiCode);
//        if (shuruiCode == null) {
//            return new Decimal(0);
//        } else {
//            List<Decimal> amount = mapper.get上乗せ償還払い給付種類支給限度額(parameter);
//            if (amount == null) {               
//                amount = mapper.get償還払い給付種類支給限度額(parameter);
//                if (amount == null) {
//                    return new Decimal(0);
//                } else {
//                    return amount.get(0);
//                }
//            } else {
//                return amount.get(0);
//            }
//        }
//    }
//
    public ShiharaiKekka getNewJutakuKaishuHi(HihokenshaNo 被保険者番号) {
        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        IJutakuKaishuJizenShinseiMapperParameter parameter = IJutakuKaishuJizenShinseiMapperParameter.createParameterForJutakuKaishuJizenShinsei(被保険者番号, RString.EMPTY, RString.EMPTY, FlexibleYearMonth.MAX, ServiceShuruiCode.EMPTY);
        List<ShokanShinseiJutakuKaishuEntity> list = mapper.get最新住宅改修の住宅住所(parameter);
        if (list.isEmpty()) {
            return null;
        } else {
            ShokanShinseiJutakuKaishuEntity entity = list.get(0);
            return getJutakuKaishuHi(被保険者番号, entity.getサービス提供年月(), entity.get住宅改修住宅住所());
        }

    }
//
    public ShiharaiKekka getJutakuKaishuHi(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 住宅改修住宅住所) {
        IJutakuKaishuJizenShinseiMapper mapper = mapperProvider.create(IJutakuKaishuJizenShinseiMapper.class);
        List<ShiharaiKekka> list;
        IJutakuKaishuJizenShinseiMapperParameter parameter = IJutakuKaishuJizenShinseiMapperParameter.createParameterForJutakuKaishuJizenShinsei(被保険者番号, 住宅改修住宅住所, 住宅改修住宅住所, サービス提供年月, ServiceShuruiCode.EMPTY);
        List<FlexibleYearMonth> serviceTeikyoYM = mapper.get支払結果計算の開始サービス提供年月限度額リセットがある(parameter);
        if (serviceTeikyoYM.isEmpty()) {
            serviceTeikyoYM = mapper.get支払結果計算の開始サービス提供年月限度額リセットなし(parameter);
            if (serviceTeikyoYM.isEmpty()) {
                return null;
            } else {
                parameter = IJutakuKaishuJizenShinseiMapperParameter.createParameterForJutakuKaishuJizenShinsei(被保険者番号, 住宅改修住宅住所, 住宅改修住宅住所, serviceTeikyoYM.get(0), ServiceShuruiCode.EMPTY);
               list=mapper.get住宅改修費支払結果(parameter);
            }
        } else {
             parameter = IJutakuKaishuJizenShinseiMapperParameter.createParameterForJutakuKaishuJizenShinsei(被保険者番号, 住宅改修住宅住所, 住宅改修住宅住所, serviceTeikyoYM.get(0), ServiceShuruiCode.EMPTY);
               list=mapper.get住宅改修費支払結果(parameter);
        }
        if(list.isEmpty()){
            return null;
        }
        else{
            return list.get(0);
        }
    }
//
    public ShokanJutakuKaishuJizenShinsei getJutakuKaishuJizenShinseiJyoho(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) {
        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = jizenShinseiDac.get償還払支給住宅改修事前申請情報(被保険者番号, サービス提供年月, 整理番号);
        if (entity==null) {
            return null;
        } else {
            return new ShokanJutakuKaishuJizenShinsei(entity);
        }
    }
//
    public String getYoshikiNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) {       
        String yoshiNo = JutakuKaishuDac.get様式番号(被保険者番号, サービス提供年月, 整理番号, 整理番号);
        if (yoshiNo==null) {
            return null;
        } else {
            return yoshiNo;
        }

    }
//
//    public String createYoshikiNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
//        YokaigoNinteiJyoho jyoho = getYokaigoNinteiJyoho(被保険者番号, サービス提供年月);
//        if (jyoho == null) {
//            throw new IllegalArgumentException(UrErrorMessages.存在しない.toString());
//        } else {
////            if(サービス提供年月.getYear().toString()>=ConfigNameDBU.制度改正施行日_平成１８年０４月改正.get名称().toString().substring(beginIndex, endIndex)){
//        }
//        RString 制度改正施行日_平成１８年０４月改正 = BusinessConfig.get(ConfigNameDBU.制度改正施行日_平成１８年０４月改正, SubGyomuCode.DBU介護統計報告);
//        FlexibleYearMonth 制度改正施行日 = new FlexibleYearMonth(制度改正施行日_平成１８年０４月改正);
//        if (サービス提供年月.compareTo(制度改正施行日) < 0) {
//            return "21D1";
//        } else {
//
//            Code 要介護認定状態区分コード = jyoho.get要介護認定状態区分コード();
//            boolean 旧措置者フラグ = jyoho.get旧措置者フラグ();
//            if (("01".equals(要介護認定状態区分コード.toString()) && 旧措置者フラグ == IsKyuSoti.旧措置適用.getコード()) || "12".equals(要介護認定状態区分コード.toString()) || "13".equals(要介護認定状態区分コード.toString())) {
//                return "21D2";
//            } else if ("21".equals(要介護認定状態区分コード.toString()) || "22".equals(要介護認定状態区分コード.toString()) || "23".equals(要介護認定状態区分コード.toString()) || "24".equals(要介護認定状態区分コード.toString()) || "25".equals(要介護認定状態区分コード.toString())) {
//                return "21D1";
//            } else {
//                throw new IllegalArgumentException(UrErrorMessages.存在しない.toString());
//            }
//        }
//
//    }
//
//    public ShiharaiKekka getOldJutakuKaishuHi(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号) {      
//        List<ShiharaiKekkaEntity> list = mapper.get今回住宅改修の住宅住所(parameter);
//        if (list.isEmpty()) {
//            return getNewJutakuKaishuHi(被保険者番号);
//        } else {
//            ShiharaiKekkaEntity entity = list.get(0);
//            return getJutakuKaishuHi(被保険者番号, サービス提供年月, 整理番号);
//        }
//
//    }
//
    public RString getShoKisaiHokenshaNo(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        DbT1001HihokenshaDaichoEntity entity = daichoDac.get被保険者台帳情報(被保険者番号,サービス提供年月);
        LasdecCode 市町村コード;
        if (entity==null) {
            return null;
        } else {
            if (entity.getKoikinaiTokureiSochimotoShichosonCode() != null) {
                市町村コード = entity.getKoikinaiTokureiSochimotoShichosonCode();
            } else {
                市町村コード = entity.getShichosonCode();
            }
        }
        ShichosonSecurityJoho 市町村情報セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        if (市町村情報セキュリティ情報.get導入形態コード().equals(new Code(DonyukeitaiCode.事務単一.toRString()))) {

        } else if (市町村情報セキュリティ情報.get導入形態コード().equals(new Code(DonyukeitaiCode.事務広域.getCode())) || 市町村情報セキュリティ情報.get導入形態コード().equals(new Code(DonyukeitaiCode.事務構成市町村.getCode()))) {
            KoikiShichosonJohoFinder finder = KoikiShichosonJohoFinder.createInstance();
            finder.shichosonCodeYoriShichosonJoho(市町村コード).records().get(0).get証記載保険者番号();
        }
        return null;
    }
//
//    public boolean saveDBDate(JutakuKaishuJizenShinseiDivParameter parameter) {
//        try{
//        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
//        entity.setHiHokenshaNo(parameter.get被保険者番号());
//        entity.setServiceTeikyoYM(parameter.getサービス提供年月());
//        entity.setSeiriNo(parameter.get整理番号());
//        entity.setShoKisaiHokenshaNo(parameter.get証記載保険者番号());
//        entity.setUketsukeYMD(parameter.get受付年月日());
//        entity.setShinseiYMD(parameter.get申請年月日());
//        entity.setShinseiRiyu(parameter.get申請理由());
//        entity.setShinseishaKubun(parameter.get申請者区分());
//        entity.setShinseishaNameKanji(parameter.get申請者氏名());
//        entity.setShinseishaNameKana(parameter.get申請者氏名カナ());
//        entity.setShinseishaYubinNo(parameter.get申請者郵便番号());
//        entity.setShinseishaJusho(parameter.get申請者住所());
//        entity.setShinseishaTelNo(parameter.get申請者電話番号());
//        entity.setShinseiJigyoshaNo(parameter.get申請事業者番号());
//        entity.setRiyushoSakuseiYMD(parameter.get理由書作成日());
//        entity.setRiyushoSakuseishaName(parameter.get理由書作成者());
//        entity.setRiyushoSakuseishaKanaName(parameter.get理由書作成者カナ());
//        entity.setRiyushoSakuseiJigyoshaNo(parameter.get理由書作成事業者番号());
//        entity.setShiharaiHohoKubunCode(parameter.get支払方法区分コード());
//        entity.setShiharaiBasho(parameter.get支払場所());
//        entity.setShiharaiKaishiYMD(parameter.get支払期間開始年月日());
//        entity.setShiharaiShuryoYMD(parameter.get支払期間終了年月日());
//        entity.setShiharaiKaishiTime(parameter.get支払窓口開始時間());
//        entity.setShiharaiShuryoTime(parameter.get支払窓口終了時間());
//        entity.setKozaID(parameter.get口座ID());
//        entity.setJuryoininKeiyakuNo(parameter.get受領委任契約番号());
//        entity.setServiceShuruiCode(parameter.getサービス種類コード());
//        entity.setJutakuShoyusha(parameter.get住宅所有者());
//        entity.setHihokenshaKankei(parameter.get被保険者の関係());
//        entity.setYokaigo3DankaiHenko(parameter.is要介護状態３段階変更());
//        entity.setJutakuJushoHenko(parameter.is住宅住所変更());
//        entity.setHanteiKetteiYMD(parameter.get判定決定年月日());
//        entity.setHanteiKubun(parameter.get判定区分());
//        entity.setShoninJoken(parameter.get承認条件());
//        entity.setFushoninRiyu(parameter.get不承認理由());
//
//        entity.setKyufugakuHiyogakuTotal(parameter.get給付額等費用額合計());
//        entity.setKyufugakuHokenTaishoHiyogaku(parameter.get給付額等保険対象費用額());
//        entity.setKyufugakuRiyoshaJikofutangaku(parameter.get給付額等利用者自己負担額());
//        entity.setKyufugakuHokenkyufuhigaku(parameter.get給付額等保険給付費額());
//        entity.setKetteitsuchishoHakkoYMD(parameter.get事前申請決定通知発行日());
//        entity.setKaishushinseiKubun(parameter.get住宅改修申請区分());
//        entity.setKaishuShinseiTorikeshijiyuCode(parameter.get住宅改修申請取消事由コード());
//        entity.setHokenKyufuritsu(parameter.get保険給付率());
//        entity.setState(EntityDataState.Added);
//        DbT3035ShokanJutakuKaishuJizenShinseiDac dac = new DbT3035ShokanJutakuKaishuJizenShinseiDac();
//
//        dac.save(entity);
//        DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
//        DbT3049ShokanJutakuKaishuDac kaishuDac=new DbT3049ShokanJutakuKaishuDac();
//        JutakuKaishuJizenShinseiChildDivParameter divParameter = null;
//        for (int i = 0; i < parameter.getParameterList().size(); i++) {
//            divParameter = parameter.getParameterList().get(i);
//            shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
//            shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
//            shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
//            shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
//            shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
//            shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
//            shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
//            shokanJutakuKaishuEntity.setServiceCode(divParameter.getサービスコード());
//            shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
//            shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
//            shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
//            shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
//            shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
//            shokanJutakuKaishuEntity.setShinsaHohoKubunCode(divParameter.get審査方法区分コード());
//            shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
//            shokanJutakuKaishuEntity.setSagakuKingaku(divParameter.get差額金額());
//            shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
//            shokanJutakuKaishuEntity.setState(EntityDataState.Added);
//            kaishuDac.save(shokanJutakuKaishuEntity);
//        }
//        }catch(Exception e){
//            return false;
//        }
//        return true;
//    }
// public  boolean updDBDate(JutakuKaishuJizenShinseiDivParameter parameter,RString mode){
//        
//         try{
//        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
//        entity.setHiHokenshaNo(parameter.get被保険者番号());
//        entity.setServiceTeikyoYM(parameter.getサービス提供年月());
//        entity.setSeiriNo(parameter.get整理番号());            
//        entity.setShinseiYMD(parameter.get申請年月日());
//        entity.setShinseiRiyu(parameter.get申請理由());
//        entity.setShinseishaKubun(parameter.get申請者区分());
//        entity.setShinseishaNameKanji(parameter.get申請者氏名());
//        entity.setShinseishaNameKana(parameter.get申請者氏名カナ());
//        entity.setShinseishaYubinNo(parameter.get申請者郵便番号());
//        entity.setShinseishaJusho(parameter.get申請者住所());
//        entity.setShinseishaTelNo(parameter.get申請者電話番号());
//        entity.setShinseiJigyoshaNo(parameter.get申請事業者番号());
//        entity.setRiyushoSakuseiYMD(parameter.get理由書作成日());
//        entity.setRiyushoSakuseishaName(parameter.get理由書作成者());
//        entity.setRiyushoSakuseishaKanaName(parameter.get理由書作成者カナ());
//        entity.setRiyushoSakuseiJigyoshaNo(parameter.get理由書作成事業者番号());
//        entity.setShiharaiHohoKubunCode(parameter.get支払方法区分コード());
//        entity.setShiharaiBasho(parameter.get支払場所());
//        entity.setShiharaiKaishiYMD(parameter.get支払期間開始年月日());
//        entity.setShiharaiShuryoYMD(parameter.get支払期間終了年月日());
//        entity.setShiharaiKaishiTime(parameter.get支払窓口開始時間());
//        entity.setShiharaiShuryoTime(parameter.get支払窓口終了時間());
//        entity.setKozaID(parameter.get口座ID());
//        entity.setJuryoininKeiyakuNo(parameter.get受領委任契約番号());
//        entity.setServiceShuruiCode(parameter.getサービス種類コード());
//        entity.setJutakuShoyusha(parameter.get住宅所有者());
//        entity.setHihokenshaKankei(parameter.get被保険者の関係());
//        entity.setYokaigo3DankaiHenko(parameter.is要介護状態３段階変更());
//        entity.setJutakuJushoHenko(parameter.is住宅住所変更());
//        entity.setHanteiKetteiYMD(parameter.get判定決定年月日());
//        entity.setHanteiKubun(parameter.get判定区分());
//        entity.setShoninJoken(parameter.get承認条件());
//        entity.setFushoninRiyu(parameter.get不承認理由());
//
//        entity.setKyufugakuHiyogakuTotal(parameter.get給付額等費用額合計());
//        entity.setKyufugakuHokenTaishoHiyogaku(parameter.get給付額等保険対象費用額());
//        entity.setKyufugakuRiyoshaJikofutangaku(parameter.get給付額等利用者自己負担額());
//        entity.setKyufugakuHokenkyufuhigaku(parameter.get給付額等保険給付費額());
//        entity.setKetteitsuchishoHakkoYMD(parameter.get事前申請決定通知発行日());
//        entity.setHokenKyufuritsu(parameter.get保険給付率());
//        entity.setState(EntityDataState.Modified);
//        DbT3035ShokanJutakuKaishuJizenShinseiDac dac = new DbT3035ShokanJutakuKaishuJizenShinseiDac();
//
//        dac.save(entity);
//        if(new RString("Modified").equals(mode)){
//        DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity ;
//        DbT3049ShokanJutakuKaishuDac kaishuDac=new DbT3049ShokanJutakuKaishuDac();
//        JutakuKaishuJizenShinseiChildDivParameter divParameter;
//        for (int i = 0; i < parameter.getParameterList().size(); i++) {
//             shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
//            divParameter = parameter.getParameterList().get(i);
//            if(EntityDataState.Added.equals(divParameter.getStatus())){   
//               
//            shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
//            shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
//            shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
//            shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
//            shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
//            shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
//            shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
//            shokanJutakuKaishuEntity.setServiceCode(divParameter.getサービスコード());
//            shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
//            shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
//            shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
//            shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
//            shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
//            shokanJutakuKaishuEntity.setShinsaHohoKubunCode(divParameter.get審査方法区分コード());
//            shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
//            shokanJutakuKaishuEntity.setSagakuKingaku(divParameter.get差額金額());
//            shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
//            shokanJutakuKaishuEntity.setState(EntityDataState.Added);
//            kaishuDac.save(shokanJutakuKaishuEntity);
//            }else if(EntityDataState.Modified.equals(divParameter.getStatus())){
//                shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
//            shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
//            shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
//            shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
//            shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
//            shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
//            shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
//            shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
//            shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
//            shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
//            shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
//            shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
//            shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
//            shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
//            shokanJutakuKaishuEntity.setState(EntityDataState.Modified);
//            kaishuDac.save(shokanJutakuKaishuEntity);
//            }else if(EntityDataState.Deleted.equals(divParameter.getStatus())){
//                shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
//            shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
//            shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
//            shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
//            shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
//            shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
//            shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
//            shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
//             shokanJutakuKaishuEntity.setState(EntityDataState.Modified);
//            kaishuDac.save(shokanJutakuKaishuEntity);
//            }else{
//                 shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
//            shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
//            shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
//            shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
//            shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
//            shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
//            shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
//            shokanJutakuKaishuEntity.setJutakuKaishuChakkoYMD(divParameter.get住宅改修着工年月日());
//            shokanJutakuKaishuEntity.setJutakuKaishuNaiyo(divParameter.get住宅改修内容());
//            shokanJutakuKaishuEntity.setJutakuKaishuJigyoshaName(divParameter.get住宅改修事業者名());
//            shokanJutakuKaishuEntity.setJutakuKaishuJutakuAddress(divParameter.get住宅改修住宅住所());
//            shokanJutakuKaishuEntity.setKaishuKingaku(divParameter.get改修金額());
//            shokanJutakuKaishuEntity.setJutakuKaishuKanseiYMD(divParameter.get住宅改修完成年月日());
//            shokanJutakuKaishuEntity.setJizenServiceTeikyoYM(divParameter.get事前申請サービス提供年月());
//            shokanJutakuKaishuEntity.setState(EntityDataState.Modified);
//            kaishuDac.save(shokanJutakuKaishuEntity);
//            }
//        }
//         }
//        }catch(Exception e){
//            return false;
//        }
//        
//        return true;
//    }
//    
//  public boolean  delDBDate(JutakuKaishuJizenShinseiDivParameter parameter){
//      DbT3049ShokanJutakuKaishuEntity shokanJutakuKaishuEntity ;
//        DbT3049ShokanJutakuKaishuDac kaishuDac=new DbT3049ShokanJutakuKaishuDac();
//        JutakuKaishuJizenShinseiChildDivParameter divParameter;
//        try{
//        for (int i = 0; i < parameter.getParameterList().size(); i++) {
//            shokanJutakuKaishuEntity = new DbT3049ShokanJutakuKaishuEntity();
//            divParameter = parameter.getParameterList().get(i);
//            shokanJutakuKaishuEntity.setHiHokenshaNo(divParameter.get被保険者番号());
//            shokanJutakuKaishuEntity.setServiceTeikyoYM(divParameter.getサービス提供年月());
//            shokanJutakuKaishuEntity.setSeiriNo(divParameter.get整理番号());
//            shokanJutakuKaishuEntity.setJigyoshaNo(divParameter.get事業者番号());
//            shokanJutakuKaishuEntity.setYoshikiNo(divParameter.get様式番号());
//            shokanJutakuKaishuEntity.setMeisaiNo(divParameter.get明細番号());
//            shokanJutakuKaishuEntity.setRenban(divParameter.get連番());
//            shokanJutakuKaishuEntity.setState(EntityDataState.Deleted);
//            kaishuDac.save(shokanJutakuKaishuEntity);                       
//        }
//        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
//        entity.setHiHokenshaNo(parameter.get被保険者番号());
//        entity.setServiceTeikyoYM(parameter.getサービス提供年月());
//        entity.setSeiriNo(parameter.get整理番号());
//        entity.setState(EntityDataState.Deleted);
//        DbT3035ShokanJutakuKaishuJizenShinseiDac dac = new DbT3035ShokanJutakuKaishuJizenShinseiDac();
//        dac.save(entity);
//        }catch(Exception e){
//            return false;
//        }
//        return true;
//  }
//    Decimal getKyufuritsu(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月){
//        Decimal WK給付率=null;
//         List<DbT3113RiyoshaFutanWariaiEntity> list=mapper.getWK給付率(被保険者番号,サービス提供年月);
//         if(list==null){
//             List<DbT4014RiyoshaFutangakuGengakuEntity> 減額給付率list=mapper.get減額給付率(被保険者番号,サービス提供年月);
//             if(減額給付率list==null){
//                 List<DbT4021ShiharaiHohoHenkoEntity> 支払方法変更給付率list=mapper.get支払方法変更給付率(被保険者番号,サービス提供年月);
//                 if(支払方法変更給付率list==null)return  WK給付率;
//                 else return 支払方法変更給付率list.get(0).getKyufuRitsu().value();
//             }else{
//                return 減額給付率list.get(0).getKyuhuritsu().value()
//             }
//         }else{
//                 list.get(0).get
//             }
//    }
}
