/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.shiharaihohohenkotsuchishohakko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.business.report.ShiharaiHohoHenkoTsuchisho;
import jp.co.ndensan.reams.db.dbd.definition.core.shiharaihohohenko.ShiharaiHenkoJohoBunruiKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.util.AtesakiPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.util.ShikibetsuTaishoPSMMybatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ShokanKihonJiho.ShokanKihonJihoEntiy;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4024ShiharaiHohoHenkoSashitomeDac;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaiHenkoTsuchiHakko.ShiharaiHenkoTsuchiHakkoMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.util.IAtesakiPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.util.IShikibetsuTaishoPSMMybatisMapper;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100001.ShiharaiHohoHenkoYokokuTsuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100002.ShiharaiHohoHenkoTsuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100003.ShiharaiIchijiSashitomeTsuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100004.TainoHokenryoKojoTsuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100005.KyufugakuGengakuTsuchishoService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100006.SashitomeYokokuTsuchishoNigoService;
import jp.co.ndensan.reams.db.dbd.service.report.dbd100007.SashitomeShobunTsuchishoNigoService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.definition.core.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.reportprinthistory.ChohyoHakkoRirekiJotai;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.HakkoRirekiManagerFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportprinthistory.IHakkoRirekiManager;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 支払方法変更管理各種通知書発行（画面）というビジネスクラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public class ShiharaiHohoHenkoTsuchishoHakkoService {

    private final int パターン番号_１ = 1;
    private final int パターン番号_２ = 2;
    private final int パターン番号_３ = 3;
    private final int パターン番号_４ = 4;
    private final MapperProvider mapperProvider;
    private final DbT4021ShiharaiHohoHenkoDac dac4021;
    private final DbT4024ShiharaiHohoHenkoSashitomeDac dac4024;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoTsuchishoHakkoService() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac4021 = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
        this.dac4024 = InstanceProvider.create(DbT4024ShiharaiHohoHenkoSashitomeDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoHenkoTsuchishoHakkoService}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShiharaiHohoHenkoTsuchishoHakkoService}のインスタンス
     */
    public static ShiharaiHohoHenkoTsuchishoHakkoService createInstance() {
        return InstanceProvider.create(ShiharaiHohoHenkoTsuchishoHakkoService.class);
    }

    /**
     * 選択した支払方法変更管理各種通知書発行
     *
     * @param 帳票タイプリスト LIST<帳票タイプ>
     * @param 帳票情報
     * @param 発行日リスト
     * @param 文書番号リスト
     * @param reportManager 帳票発行処理の制御機能
     * @param 識別コード
     */
    public void pntShiharaiHohoHenkoKanriKakusyu(List<RString> 帳票タイプリスト, ShiharaiHohoHenko 帳票情報, HakouichiList 発行日リスト,
            BunsyubanngaouList 文書番号リスト, ShikibetsuCode 識別コード, ReportManager reportManager) {
        Association association = get地方公共団体();
        UaFt200FindShikibetsuTaishoEntity uaFt200Entity = get宛名情報(識別コード);
        UaFt250FindAtesakiEntity uaFt250Entity = get宛先情報(識別コード);
        for (RString reporttype : 帳票タイプリスト) {
            if (ShiharaiHohoHenkoTsuchisho.支払方法変更予告通知書.get名称().equals(reporttype)) {
                ReportId 帳票分類ID = get帳票分類ID(reporttype);
                publish支払方法変更予告通知書(association, uaFt200Entity, uaFt250Entity, reporttype, 帳票分類ID, 帳票情報,
                        new FlexibleDate(発行日リスト.get予告通知書発行年月日().toDateString()), 文書番号リスト.get予告文書番号(), reportManager);
            } else if (ShiharaiHohoHenkoTsuchisho.支払方法変更通知書.get名称().equals(reporttype)) {
                ReportId 帳票分類ID = get帳票分類ID(reporttype);
                publish支払方法変更通知書(association, uaFt200Entity, uaFt250Entity, reporttype, 帳票分類ID, 帳票情報,
                        new FlexibleDate(発行日リスト.get償還払化通知書発行年月日().toDateString()), 文書番号リスト.get償還払化文書番号(), reportManager);
            } else if (ShiharaiHohoHenkoTsuchisho.支払一時差止通知書.get名称().equals(reporttype)) {
                ReportId 帳票分類ID = get帳票分類ID(reporttype);
                publish支払一時差止通知書(association, uaFt200Entity, uaFt250Entity, reporttype, 帳票分類ID, 帳票情報,
                        new FlexibleDate(発行日リスト.get差止通知書発行年月日().toDateString()), 文書番号リスト.get差止文書番号(), reportManager);
            } else if (ShiharaiHohoHenkoTsuchisho.滞納保険料控除通知書.get名称().equals(reporttype)) {
                ReportId 帳票分類ID = get帳票分類ID(reporttype);
                publish滞納保険料控除通知書(association, uaFt200Entity, uaFt250Entity, reporttype, 帳票分類ID, 帳票情報,
                        new FlexibleDate(発行日リスト.get控除通知書発行年月日().toDateString()), 文書番号リスト.get控除文書番号(), reportManager);
            } else if (ShiharaiHohoHenkoTsuchisho.給付額減額通知書.get名称().equals(reporttype)) {
                ReportId 帳票分類ID = get帳票分類ID(reporttype);
                publish給付額減額通知書(association, uaFt200Entity, uaFt250Entity, reporttype, 帳票分類ID, 帳票情報,
                        new FlexibleDate(発行日リスト.get減額通知書発行年月日().toDateString()), 文書番号リスト.get減額文書番号(), reportManager);
            } else if (ShiharaiHohoHenkoTsuchisho.差止予告通知書_２号用.get名称().equals(reporttype)) {
                ReportId 帳票分類ID = get帳票分類ID(reporttype);
                publish差止予告通知書_２号用(association, uaFt200Entity, uaFt250Entity, reporttype, 帳票分類ID, 帳票情報,
                        new FlexibleDate(発行日リスト.get予告通知書発行年月日().toDateString()), 文書番号リスト.get予告文書番号(), reportManager);
            } else if (ShiharaiHohoHenkoTsuchisho.差止処分通知書_２号用.get名称().equals(reporttype)) {
                ReportId 帳票分類ID = get帳票分類ID(reporttype);
                publish差止処分通知書_２号用(association, uaFt200Entity, uaFt250Entity, reporttype, 帳票分類ID, 帳票情報,
                        new FlexibleDate(発行日リスト.get差止通知書発行年月日().toDateString()), 文書番号リスト.get差止文書番号(), reportManager);
            }
        }
    }

    /**
     * 発行履歴の登録
     *
     * @param sourceData SourceDataCollectionのSourceData
     * @param 発行日 発行日
     * @param 識別コード 識別コード
     * @param hashMap 業務固有情報hashmap
     */
    public void insert発行履歴(SourceData sourceData, RDate 発行日, ShikibetsuCode 識別コード, HashMap<Code, RString> hashMap) {
        IHakkoRirekiManager manager = HakkoRirekiManagerFactory.createInstance();
        List<ShikibetsuCode> shikibetsuCodeList = new ArrayList<>();
        shikibetsuCodeList.add(識別コード);
        manager.insert帳票発行履歴(
                sourceData,
                new FlexibleDate(発行日.toDateString()),
                ChohyoHakkoRirekiJotai.新規作成,
                hashMap, shikibetsuCodeList
        );
    }

    /**
     * 帳票制御共通を取得します
     *
     * @param 帳票分類ID 帳票分類ID
     * @return 帳票制御共通
     */
    public DbT7065ChohyoSeigyoKyotsuEntity load帳票制御共通(ReportId 帳票分類ID) {
        if (帳票分類ID == null || 帳票分類ID.isEmpty()) {
            throw new NullPointerException();
        }
        DbT7065ChohyoSeigyoKyotsuDac dbT7065Dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
        return dbT7065Dac.selectByKey(SubGyomuCode.DBD介護受給, 帳票分類ID);
    }

    /**
     * 帳票制御汎用をキーから取得します。
     *
     * @param 帳票分類ID 帳票分類ID
     * @return List<帳票制御汎用>
     */
    public List load帳票制御汎用(ReportId 帳票分類ID) {
        DbT7067ChohyoSeigyoHanyoDac dbT7067Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        return dbT7067Dac.get帳票制御汎用(SubGyomuCode.DBD介護受給, 帳票分類ID, new FlexibleYear("0000"));
    }

    /**
     * 償還払請求情報の取得します。
     *
     * @param 被保険者番号
     * @param 管理区分
     * @param 履歴番号
     * @param 情報分類区分
     * @return List<帳票制御汎用>
     */
    public List<ShokanKihonJihoEntiy> selectShokanKihon(HihokenshaNo 被保険者番号, RString 管理区分, int 履歴番号, RString 情報分類区分) {
        List<ShokanKihonJihoEntiy> resultList;
        ShiharaiHenkoTsuchiHakkoMapper shiharaiHenkoTsuchiHakkoMapper = this.mapperProvider.create(ShiharaiHenkoTsuchiHakkoMapper.class);
        resultList = shiharaiHenkoTsuchiHakkoMapper.selectShokanKihon(被保険者番号, 管理区分, 履歴番号, 情報分類区分);
        return resultList;
    }

    private void publish支払方法変更予告通知書(Association 地方公共団体, UaFt200FindShikibetsuTaishoEntity 宛名情報, UaFt250FindAtesakiEntity 宛先情報,
            RString 帳票タイプ, ReportId 帳票分類ID, ShiharaiHohoHenko 帳票情報, FlexibleDate 予告通知書発行年月日, RString 予告文書番号, ReportManager reportManager) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプ);
        ShiharaiHohoHenkoYokokuTsuchishoService service = new ShiharaiHohoHenkoYokokuTsuchishoService();
        service.print(ShikibetsuTaishoFactory.createKojin(宛名情報), AtesakiFactory.createInstance(宛先情報), new ChohyoSeigyoKyotsu(dbT7065Entity), 地方公共団体,
                予告通知書発行年月日, 予告文書番号, 通知書定型文List, 帳票分類ID, 帳票情報, reportManager);
        dac4021.updateYokokuTsuchiHakkoYMD(帳票情報.get証記載保険者番号(), 帳票情報.get被保険者番号(),
                帳票情報.get管理区分(), 帳票情報.get履歴番号(), 予告通知書発行年月日);
    }

    private void publish支払方法変更通知書(Association 地方公共団体, UaFt200FindShikibetsuTaishoEntity 宛名情報, UaFt250FindAtesakiEntity 宛先情報,
            RString 帳票タイプ, ReportId 帳票分類ID, ShiharaiHohoHenko 帳票情報, FlexibleDate 償還払化通知書発行年月日, RString 償還払化文書番号, ReportManager reportManager) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプ);
        ShiharaiHohoHenkoTsuchishoService service = new ShiharaiHohoHenkoTsuchishoService();
        service.print(ShikibetsuTaishoFactory.createKojin(宛名情報), AtesakiFactory.createInstance(宛先情報), new ChohyoSeigyoKyotsu(dbT7065Entity), 地方公共団体,
                償還払化通知書発行年月日, 償還払化文書番号, 通知書定型文List, 帳票分類ID, 帳票情報, reportManager);
        dac4021.updateShokanTsuchiHakkoYMD(帳票情報.get証記載保険者番号(), 帳票情報.get被保険者番号(),
                帳票情報.get管理区分(), 帳票情報.get履歴番号(), 償還払化通知書発行年月日);
    }

    private void publish支払一時差止通知書(Association 地方公共団体, UaFt200FindShikibetsuTaishoEntity 宛名情報, UaFt250FindAtesakiEntity 宛先情報,
            RString 帳票タイプ, ReportId 帳票分類ID, ShiharaiHohoHenko 帳票情報, FlexibleDate 差止通知書発行年月日, RString 差止文書番号, ReportManager reportManager) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプ);
        ShiharaiIchijiSashitomeTsuchishoService service = new ShiharaiIchijiSashitomeTsuchishoService();
        service.print(ShikibetsuTaishoFactory.createKojin(宛名情報), AtesakiFactory.createInstance(宛先情報), new ChohyoSeigyoKyotsu(dbT7065Entity), 地方公共団体,
                差止通知書発行年月日, 差止文書番号, 通知書定型文List, 帳票分類ID, 帳票情報, null, reportManager);
        for (ShiharaiHohoHenkoSashitome entity : 帳票情報.getShiharaiHohoHenkoSashitomeList()) {
            dac4024.updateSashitomeTsuchiHakkoYMD(entity.get証記載保険者番号(), entity.get被保険者番号(),
                    entity.get管理区分(), entity.get履歴番号(), entity.get情報分類区分(), entity.get連番(), 差止通知書発行年月日);
        }
    }

    private void publish滞納保険料控除通知書(Association 地方公共団体, UaFt200FindShikibetsuTaishoEntity 宛名情報, UaFt250FindAtesakiEntity 宛先情報,
            RString 帳票タイプ, ReportId 帳票分類ID, ShiharaiHohoHenko 帳票情報, FlexibleDate 控除通知書発行年月日, RString 控除文書番号, ReportManager reportManager) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプ);
        List<ShokanKihonJihoEntiy> shokanKihonJihoEntiyList = selectShokanKihon(帳票情報.get被保険者番号(),
                KanriKubun.一号償還払い化.code(), 帳票情報.get履歴番号(), ShiharaiHenkoJohoBunruiKubun.保険料控除情報.getコード());
        TainoHokenryoKojoTsuchishoService service = new TainoHokenryoKojoTsuchishoService();
        service.print(ShikibetsuTaishoFactory.createKojin(宛名情報), AtesakiFactory.createInstance(宛先情報), new ChohyoSeigyoKyotsu(dbT7065Entity),
                地方公共団体, 控除通知書発行年月日, 控除文書番号, 通知書定型文List, 帳票分類ID, 帳票情報, shokanKihonJihoEntiyList, reportManager);
        for (ShiharaiHohoHenkoSashitome entity : 帳票情報.getShiharaiHohoHenkoSashitomeList()) {
            dac4024.updateKojoTsuchiHakkoYMD(entity.get証記載保険者番号(), entity.get被保険者番号(),
                    entity.get管理区分(), entity.get履歴番号(), entity.get情報分類区分(), entity.get連番(), 控除通知書発行年月日);
        }
    }

    private void publish給付額減額通知書(Association 地方公共団体, UaFt200FindShikibetsuTaishoEntity 宛名情報, UaFt250FindAtesakiEntity 宛先情報,
            RString 帳票タイプ, ReportId 帳票分類ID, ShiharaiHohoHenko 帳票情報, FlexibleDate 減額通知書発行年月日, RString 減額文書番号, ReportManager reportManager) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプ);
        KyufugakuGengakuTsuchishoService service = new KyufugakuGengakuTsuchishoService();
        service.print(ShikibetsuTaishoFactory.createKojin(宛名情報), AtesakiFactory.createInstance(宛先情報), new ChohyoSeigyoKyotsu(dbT7065Entity),
                地方公共団体, 減額通知書発行年月日, 減額文書番号, 通知書定型文List, 帳票分類ID, 帳票情報, reportManager);
        dac4021.updateGemmen_TsuchiHakkoYMD(帳票情報.get証記載保険者番号(), 帳票情報.get被保険者番号(),
                帳票情報.get管理区分(), 帳票情報.get履歴番号(), 減額通知書発行年月日);
    }

    private void publish差止予告通知書_２号用(Association 地方公共団体, UaFt200FindShikibetsuTaishoEntity 宛名情報, UaFt250FindAtesakiEntity 宛先情報,
            RString 帳票タイプ, ReportId 帳票分類ID, ShiharaiHohoHenko 帳票情報, FlexibleDate 予告通知書発行年月日, RString 予告文書番号, ReportManager reportManager) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプ);
        SashitomeYokokuTsuchishoNigoService service = new SashitomeYokokuTsuchishoNigoService();
        service.print(ShikibetsuTaishoFactory.createKojin(宛名情報), AtesakiFactory.createInstance(宛先情報), new ChohyoSeigyoKyotsu(dbT7065Entity), 地方公共団体,
                予告通知書発行年月日, 予告文書番号, 通知書定型文List, 帳票分類ID, 帳票情報, null, reportManager);
        dac4021.updateYokokuTsuchiHakkoYMD(帳票情報.get証記載保険者番号(), 帳票情報.get被保険者番号(),
                帳票情報.get管理区分(), 帳票情報.get履歴番号(), 予告通知書発行年月日);
    }

    private void publish差止処分通知書_２号用(Association 地方公共団体, UaFt200FindShikibetsuTaishoEntity 宛名情報, UaFt250FindAtesakiEntity 宛先情報,
            RString 帳票タイプ, ReportId 帳票分類ID, ShiharaiHohoHenko 帳票情報, FlexibleDate 差止通知書発行年月日, RString 差止文書番号, ReportManager reportManager) {
        DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity = load帳票制御共通(帳票分類ID);
        List<RString> 通知書定型文List = get通知書定型文List(帳票分類ID, dbT7065Entity, 帳票タイプ);
        SashitomeShobunTsuchishoNigoService service = new SashitomeShobunTsuchishoNigoService();
        service.print(ShikibetsuTaishoFactory.createKojin(宛名情報), AtesakiFactory.createInstance(宛先情報), new ChohyoSeigyoKyotsu(dbT7065Entity), 地方公共団体,
                差止通知書発行年月日, 差止文書番号, 通知書定型文List, 帳票分類ID, 帳票情報, reportManager);
        for (ShiharaiHohoHenkoSashitome entity : 帳票情報.getShiharaiHohoHenkoSashitomeList()) {
            dac4024.updateSashitomeTsuchiHakkoYMD(entity.get証記載保険者番号(), entity.get被保険者番号(),
                    entity.get管理区分(), entity.get履歴番号(), entity.get情報分類区分(),
                    entity.get連番(), 差止通知書発行年月日);
        }
    }

    private Association get地方公共団体() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        return finder.getAssociation();
    }

    private UaFt200FindShikibetsuTaishoEntity get宛名情報(ShikibetsuCode 識別コード) {
        ShikibetsuTaishoPSMSearchKeyBuilder shikibetsuTaishoPSMKey
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        shikibetsuTaishoPSMKey.set識別コード(識別コード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = shikibetsuTaishoPSMKey.build();
        ShikibetsuTaishoPSMMybatisParameter shikibetsuTaishoPSMParameter = new ShikibetsuTaishoPSMMybatisParameter(shikibetsuTaishoPSMSearchKey);
        shikibetsuTaishoPSMParameter.setPsmShikibetsuTaisho(new RString(shikibetsuTaishoPSMParameter.toString()));
        IShikibetsuTaishoPSMMybatisMapper shikibetsuTaishoPSMMapper = this.mapperProvider.create(IShikibetsuTaishoPSMMybatisMapper.class);
        return shikibetsuTaishoPSMMapper.selectShikibetsuTaishoPSMMybatis(shikibetsuTaishoPSMParameter);
    }

    private UaFt250FindAtesakiEntity get宛先情報(ShikibetsuCode 識別コード) {
        AtesakiPSMSearchKeyBuilder atesakiPSMKey
                = new AtesakiPSMSearchKeyBuilder(AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        atesakiPSMKey.set識別コード(識別コード);
        IAtesakiPSMSearchKey atesakiPSMSearchKey = atesakiPSMKey.build();
        AtesakiPSMMybatisParameter atesakiPSMMybatisParameter = new AtesakiPSMMybatisParameter(atesakiPSMSearchKey);
        atesakiPSMMybatisParameter.setPsmAtesaki(new RString(atesakiPSMMybatisParameter.toString()));
        IAtesakiPSMMybatisMapper atesakiPSMMapper = this.mapperProvider.create(IAtesakiPSMMybatisMapper.class);
        return atesakiPSMMapper.selectAtesakiPSMMybatis(atesakiPSMMybatisParameter);
    }

    private ReportId get帳票分類ID(RString 帳票タイプ) {
        if (ShiharaiHohoHenkoTsuchisho.支払方法変更予告通知書.get名称().equals(帳票タイプ)) {
            return ReportIdDBD.DBD100001.getReportId();
        } else if (ShiharaiHohoHenkoTsuchisho.支払方法変更通知書.get名称().equals(帳票タイプ)) {
            return ReportIdDBD.DBD100002.getReportId();
        } else if (ShiharaiHohoHenkoTsuchisho.支払一時差止通知書.get名称().equals(帳票タイプ)) {
            return ReportIdDBD.DBD100003.getReportId();
        } else if (ShiharaiHohoHenkoTsuchisho.滞納保険料控除通知書.get名称().equals(帳票タイプ)) {
            return ReportIdDBD.DBD100004.getReportId();
        } else if (ShiharaiHohoHenkoTsuchisho.給付額減額通知書.get名称().equals(帳票タイプ)) {
            return ReportIdDBD.DBD100005.getReportId();
        } else if (ShiharaiHohoHenkoTsuchisho.差止予告通知書_２号用.get名称().equals(帳票タイプ)) {
            return ReportIdDBD.DBD100006.getReportId();
        } else if (ShiharaiHohoHenkoTsuchisho.差止処分通知書_２号用.get名称().equals(帳票タイプ)) {
            return ReportIdDBD.DBD100007.getReportId();
        }
        return null;
    }

    private List get通知書定型文List(ReportId 帳票分類ID, DbT7065ChohyoSeigyoKyotsuEntity dbT7065Entity, RString 帳票タイプ) {
        List<RString> 通知書定型文List = new ArrayList<>();
        int パターン番号 = 0;
        if (ShiharaiHohoHenkoTsuchisho.支払方法変更通知書.get名称().equals(帳票タイプ)
                || ShiharaiHohoHenkoTsuchisho.支払一時差止通知書.get名称().equals(帳票タイプ)
                || ShiharaiHohoHenkoTsuchisho.滞納保険料控除通知書.get名称().equals(帳票タイプ)
                || ShiharaiHohoHenkoTsuchisho.給付額減額通知書.get名称().equals(帳票タイプ)
                || ShiharaiHohoHenkoTsuchisho.差止処分通知書_２号用.get名称().equals(帳票タイプ)) {
            if (TeikeibunMojiSize.フォント小.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_１;
            } else if (TeikeibunMojiSize.フォント大.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_２;
            } else if (TeikeibunMojiSize.フォント上小下大.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_３;
            } else if (TeikeibunMojiSize.フォント上大下小.getコード().equals(dbT7065Entity.getTeikeibunMojiSize())) {
                パターン番号 = パターン番号_４;
            }
        } else {
            パターン番号 = パターン番号_１;
        }
        Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票分類ID, KamokuCode.EMPTY, パターン番号);
        for (Map.Entry<Integer, RString> entry : 通知文Map.entrySet()) {
            通知書定型文List.add(entry.getValue());
        }
        return 通知書定型文List;
    }
}
