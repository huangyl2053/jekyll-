/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic.jikofutangakushomeisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseisho;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanMeisai;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jikofutangakushomeisho.JikoFutangakushomeishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeisho.KogakuGassanJohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3068KogakuGassanShinseishoDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3070KogakuGassanJikoFutanGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jikofutangakushomeisho.IJikoFutangakushomeishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7069KaigoToiawasesakiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7069KaigoToiawasesakiDac;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.toiawasesaki.ToiawasesakiSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 自己負担額証明書作成のManagerクラスです。
 *
 * @reamsid_L DBC-4810-010 yaoyahui
 */
public class JikoFutangakushomeishoManager {

    private final DbT3068KogakuGassanShinseishoDac 高額合算申請書Dac;
    private DbT3070KogakuGassanJikoFutanGakuDac 高額合算自己負担額Dac;
    private DbT3170JigyoKogakuGassanJikoFutanGakuDac 事業高額合算自己負担額Dac;
    private DbT7069KaigoToiawasesakiDac 介護問合せ先dac;
    private final MapperProvider mapperProvider;
    private static final RString メニューID_DBCMN63001 = new RString("DBCMN63001");
    private static final RString メニューID_DBCMNN2001 = new RString("DBCMNN2001");
    private IJikoFutangakushomeishoMapper mapper;
    private static final RString 自己負担額証明書作成 = new RString("自己負担額証明書作成");
    private static final RString 事業分_自己負担額証明書作成 = new RString("事業分・自己負担額証明書作成");

    /**
     * コンストラクタです。
     */
    public JikoFutangakushomeishoManager() {
        this.高額合算申請書Dac = InstanceProvider.create(DbT3068KogakuGassanShinseishoDac.class);
        this.高額合算自己負担額Dac = InstanceProvider.create(DbT3070KogakuGassanJikoFutanGakuDac.class);
        this.事業高額合算自己負担額Dac = InstanceProvider.create(DbT3170JigyoKogakuGassanJikoFutanGakuDac.class);
        this.介護問合せ先dac = InstanceProvider.create(DbT7069KaigoToiawasesakiDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link JikoFutangakushomeishoFinder#create}にて生成した{@link JikoFutangakushomeishoManager}のインスタンスを返します。
     *
     * @return JikoFutangakushomeishoManager
     */
    public static JikoFutangakushomeishoManager createInstance() {
        return InstanceProvider.create(JikoFutangakushomeishoManager.class);
    }

    /**
     * get対象者データ
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 保険者番号 HokenshaNo
     * @param 申請状況区分 RString
     * @param 支給申請区分 RString
     * @return DbT3068KogakuGassanShinseishoEntity
     */
    public List<KogakuGassanShinseisho> get対象者データ(HihokenshaNo 被保険者番号,
            RString 保険者番号,
            RString 申請状況区分,
            RString 支給申請区分) {
        mapper = mapperProvider.create(IJikoFutangakushomeishoMapper.class);
        JikoFutangakushomeishoParameter parameter = new JikoFutangakushomeishoParameter();
        parameter.set被保険者番号(被保険者番号);
        parameter.set保険者番号(保険者番号);
        parameter.set申請状況区分(申請状況区分);
        parameter.set支給申請区分(支給申請区分);
        List<DbT3068KogakuGassanShinseishoEntity> 対象者データ = mapper.get対象者データ(parameter);
        List<KogakuGassanShinseisho> 対象者データlist = new ArrayList<>();
        if (0 < 対象者データ.size()) {
            for (DbT3068KogakuGassanShinseishoEntity dbT3068KogakuGassanShinseishoEntity : 対象者データ) {
                対象者データlist.add(new KogakuGassanShinseisho(dbT3068KogakuGassanShinseishoEntity));
            }
        }
        return 対象者データlist;
    }

    /**
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @return KogakuGassanJikoFutanGaku KogakuGassanJikoFutanGaku
     */
    public KogakuGassanJikoFutanGaku get自己負担額証明書整理番号(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            RString 保険者番号,
            RString 支給申請書整理番号) {
        DbT3070KogakuGassanJikoFutanGakuEntity dbt3070 = 高額合算自己負担額Dac.selectJikoFutanGaku(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        if (dbt3070 != null) {
            return new KogakuGassanJikoFutanGaku(dbt3070);
        }
        return null;
    }

    /**
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 RString
     * @return KogakuGassanJikoFutanGaku KogakuGassanJikoFutanGaku
     */
    public JigyoKogakuGassanJikoFutanGaku get自己負担額証明書整理番号_DBCMNN2001(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            RString 保険者番号,
            RString 支給申請書整理番号) {

        DbT3170JigyoKogakuGassanJikoFutanGakuEntity dbt3170 = 事業高額合算自己負担額Dac.selectByKey(被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号);
        if (dbt3170 != null) {
            return new JigyoKogakuGassanJikoFutanGaku(dbt3170);
        }
        return null;
    }

    /**
     * get再計算区分
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 保険者番号 RString
     * @param 対象年度 FlexibleYear
     * @param 支給申請書整理番号 RString
     * @return KogakuGassanShinseisho 再計算
     */
    public KogakuGassanShinseisho get再計算区分(HihokenshaNo 被保険者番号,
            RString 保険者番号,
            FlexibleYear 対象年度,
            RString 支給申請書整理番号) {
        DbT3068KogakuGassanShinseishoEntity 再計算区分データ = 高額合算申請書Dac.selectSaikeisannkubun(被保険者番号, 保険者番号, 対象年度, 支給申請書整理番号);
        if (再計算区分データ != null) {
            return new KogakuGassanShinseisho(再計算区分データ);
        }
        return null;
    }

    /**
     * get問合せ先
     *
     * @return KaigoToiawasesaki
     */
    public ToiawasesakiSource get問合せ先() {

        DbT7069KaigoToiawasesakiEntity dbT7069 = 介護問合せ先dac.selectByKey(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100050.getReportId());
        KaigoToiawasesaki kaigoToiawasesaki = new KaigoToiawasesaki(dbT7069);
        ToiawasesakiSource source = new ToiawasesakiSource();
        if (kaigoToiawasesaki.get郵便番号() != null) {
            source.yubinBango = kaigoToiawasesaki.get郵便番号().value();
        }
        source.shozaichi = kaigoToiawasesaki.get所在地();
        source.choshaBushoName = kaigoToiawasesaki.get庁舎名();
        source.tantoName = kaigoToiawasesaki.get担当者名();
        if (kaigoToiawasesaki.get電話番号() != null) {
            source.telNo = kaigoToiawasesaki.get電話番号().value();
        }
        source.naisenNo = kaigoToiawasesaki.get内線番号();
        return source;
    }

    /**
     * get高額合算情報
     *
     * @param parameter JikoFutangakushomeishoParameter
     * @return KogakuGassanData
     */
    public KogakuGassanData get高額合算情報(JikoFutangakushomeishoParameter parameter) {
        mapper = mapperProvider.create(IJikoFutangakushomeishoMapper.class);
        KogakuGassanData kogakuGassanData = new KogakuGassanData();
        if (メニューID_DBCMN63001.equals(parameter.getメニューID())) {
            KogakuGassanJohoEntity 高額合算情報 = mapper.get高額合算情報1(parameter);
            editKogakuGassanData(高額合算情報, kogakuGassanData, parameter);
        } else if (メニューID_DBCMNN2001.equals(parameter.getメニューID())) {
            KogakuGassanJohoEntity 高額合算情報 = mapper.get高額合算情報2(parameter);
            editKogakuGassanData(高額合算情報, kogakuGassanData, parameter);
        }
        return kogakuGassanData;
    }

    private void editKogakuGassanData(KogakuGassanJohoEntity 高額合算情報, KogakuGassanData kogakuGassanData, JikoFutangakushomeishoParameter parameter) {
        KogakuGassanJohoEntity 宛名から被保険者 = mapper.get宛名から被保険者の個人情報(parameter);
        DbT3068KogakuGassanShinseishoEntity 高額合算申請書entity = 高額合算情報.get高額合算申請書entity();
        DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額entity = 高額合算情報.get高額合算自己負担額entity();
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 高額合算自己負担額明細entity = 高額合算情報.get高額合算自己負担額明細entity();
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = 宛名から被保険者.getUaFt200Entity();
        kogakuGassanData.set被保険者番号(高額合算申請書entity.getHihokenshaNo());
        kogakuGassanData.set対象年度(高額合算申請書entity.getTaishoNendo());
        kogakuGassanData.set保険者番号(new LasdecCode(高額合算申請書entity.getHokenshaNo().value()));
        kogakuGassanData.set保険者名(高額合算自己負担額entity.getHokenshaMei());
        kogakuGassanData.set支給申請書整理番号(高額合算申請書entity.getShikyuShinseishoSeiriNo());
        kogakuGassanData.set対象計算期間開始年月日(高額合算申請書entity.getTaishoKeisanKaishiYMD());
        kogakuGassanData.set対象計算期間終了年月日(高額合算申請書entity.getTaishoKeisanShuryoYMD());
        if (uaFt200Entity != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(uaFt200Entity);
            kogakuGassanData.set被保険者氏名カナ(kojin.get名称().getKana());
            kogakuGassanData.set被保険者氏名(kojin.get名称().getName());
            kogakuGassanData.set生年月日(kojin.get生年月日().toFlexibleDate());
            kogakuGassanData.set性別(kojin.get性別());
            kogakuGassanData.set自己負担額証明書整理番号(高額合算自己負担額entity.getJikoFutanSeiriNo());
            kogakuGassanData.set被保険者期間終了年月日(高額合算自己負担額entity.getHihokenshaShuryoYMD());
            kogakuGassanData.set被保険者期間開始年月日(高額合算自己負担額entity.getHihokenshaKaishiYMD());
            kogakuGassanData.set合計_自己負担額(高額合算自己負担額entity.getGokei_JikoFutanGaku());
            kogakuGassanData.set合計_70_74自己負担額_内訳(高額合算自己負担額entity.getGokei_70_74JikoFutanGaku());
            kogakuGassanData.set補正済_合計_自己負担額(高額合算自己負担額entity.getSumi_Gokei_JikoFutanGaku());
            kogakuGassanData.set補正済_合計_70_74自己負担額_内訳(高額合算自己負担額entity.getSumi_Gokei_70_74JikoFutanGaku());
            kogakuGassanData.set識別コード(ShikibetsuCode.EMPTY);
            List<KogakuGassanMeisai> 明細List = new ArrayList<>();
            KogakuGassanMeisai meisai = new KogakuGassanMeisai();
            meisai.set対象月(高額合算自己負担額明細entity.getTaishoNendo().toDateString());
            meisai.set単70_74自己負担額_内数(高額合算自己負担額明細entity.getUchisu_70_74JikoFutanGaku());
            meisai.set摘要(高額合算自己負担額明細entity.getTekiyo());
            meisai.set自己負担額(高額合算自己負担額明細entity.getJikoFutanGaku());
            明細List.add(meisai);
            kogakuGassanData.set明細List(明細List);
        }
    }

    /**
     * get文書番号
     *
     * @return 文書番号
     */
    public RString get文書番号() {
        return ReportUtil.get文書番号(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100050.getReportId(), FlexibleDate.getNowDate());
    }

    /**
     * getタイトル
     *
     * @param menuId menuId
     * @return タイトル
     */
    public RString getタイトル(RString menuId) {
        if (メニューID_DBCMN63001.equals(menuId)) {
            return 自己負担額証明書作成;
        } else if (メニューID_DBCMNN2001.equals(menuId)) {
            return 事業分_自己負担額証明書作成;
        }
        return null;
    }

    /**
     * get宛先帳票部品
     *
     * @return atesakiSource
     */
    public SofubutsuAtesakiSource get宛先帳票部品() {
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        IAtesaki 宛先s = ShikibetsuTaishoService.getAtesakiFinder().get宛先(宛先builder.build());
        SofubutsuAtesakiSource atesakiSource
                = new SofubutsuAtesakiSourceBuilder(new SofubutsuAtesakiEditorBuilder(宛先s).build()).buildSource();
        return atesakiSource;
    }

}
