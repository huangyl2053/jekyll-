/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.jigyosha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.GunshiCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.ServiceJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.business.core.jigyosha.ServiceShuruiJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.jigyosha.JigyoshaInputGuideParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ServiceJigyoshaInputGuideRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.jigyosha.IJigyoshaInputGuideMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.business.core.gunshiku.Gunshiku;
import jp.co.ndensan.reams.ur.urz.business.core.zenkokujusho.ZenkokuJushoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoSearchShurui;
import jp.co.ndensan.reams.ur.urz.service.core.gunshiku.GunshikuFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.zenkokujusho.ZenkokuJushoFinderFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 事業者・施設選択入力ガイドするクラスです。
 *
 * @reamsid_L DBA-0140-030 houtianpeng
 */
public class JigyoshaInputGuideFinder {

    private final MapperProvider mapperProvider;
    private final DbT7130KaigoServiceShuruiDac dbT7130Dac;

    /**
     * コンストラクタ。
     *
     */
    public JigyoshaInputGuideFinder() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT7130Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JigyoshaInputGuideFinder}のインスタンスを返します。
     *
     * @return JigyoshaInputGuideFinder
     */
    public static JigyoshaInputGuideFinder createInstance() {
        return InstanceProvider.create(JigyoshaInputGuideFinder.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider mapper取得
     */
    JigyoshaInputGuideFinder(MapperProvider mapperProvider,
            DbT7130KaigoServiceShuruiDac dbT7130Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT7130Dac = dbT7130Dac;
    }

    /**
     * 県コード取得リストを取得します。
     *
     * @return 県コード取得リスト
     */
    public SearchResult<ZenkokuJushoItem> getKenCodeJigyoshaInputGuide() {
        List<ZenkokuJushoItem> 県コードList = ZenkokuJushoFinderFactory.
                createInstance().get全国住所Byデータ区分(ZenkokuJushoSearchShurui.都道府県.getDataKubun());

        if (県コードList == null || 県コードList.isEmpty()) {
            return SearchResult.of(Collections.<ZenkokuJushoItem>emptyList(), 0, false);
        }
        return SearchResult.of(県コードList, 0, false);
    }

    /**
     * 郡市コード取得リストを取得する。
     *
     * @return 郡市コード取得リスト
     */
    public SearchResult<GunshiCodeJigyoshaInputGuide> getGunshiCodeJigyoshaInputGuide() {
        List<Gunshiku> gunshiCodeList = GunshikuFinderFactory.createInstance().get郡市区全件();
        List<GunshiCodeJigyoshaInputGuide> gunshiCodeJigyoshaList = new ArrayList<>();
        if (gunshiCodeList == null || gunshiCodeList.isEmpty()) {
            return SearchResult.of(Collections.<GunshiCodeJigyoshaInputGuide>emptyList(), 0, false);
        }
        for (Gunshiku gunshiku : gunshiCodeList) {

            gunshiCodeJigyoshaList.add(new GunshiCodeJigyoshaInputGuide(gunshiku.toEntity()));
        }
        return SearchResult.of(gunshiCodeJigyoshaList, 0, false);
    }

    /**
     * サービス種類取得リストを取得する。
     *
     * @param systemDate システム日付
     * @return サービス種類取得リスト
     */
    public SearchResult<ServiceShuruiJigyoshaInputGuide> getServiceShuruiJigyoshaInputGuide(RYearMonth systemDate) {
        List<ServiceShuruiJigyoshaInputGuide> serviceShuruiList = new ArrayList<>();

        List<DbT7130KaigoServiceShuruiEntity> dbt7130List = dbT7130Dac.selectServiceShurui(systemDate);
        if (dbt7130List == null || dbt7130List.isEmpty()) {
            return SearchResult.of(Collections.<ServiceShuruiJigyoshaInputGuide>emptyList(), 0, false);
        }
        for (DbT7130KaigoServiceShuruiEntity entity : dbt7130List) {
            serviceShuruiList.add(new ServiceShuruiJigyoshaInputGuide(entity));
        }
        return SearchResult.of(serviceShuruiList, 0, false);
    }

    /**
     * サービス事業者取得リストを取得する。
     *
     * @param params JigyoshaInputGuideParameter
     * @return サービス事業者取得リスト
     */
    public SearchResult<ServiceJigyoshaInputGuide> getServiceJigyoshaInputGuide(JigyoshaInputGuideParameter params) {
        IJigyoshaInputGuideMapper jigyoshaInputGuideMapper = this.mapperProvider.create(IJigyoshaInputGuideMapper.class);
        List<ServiceJigyoshaInputGuideRelateEntity> サービス事業者取得リスト = jigyoshaInputGuideMapper.getServiceJigyoshaInputGuide(params);
        if (サービス事業者取得リスト == null || サービス事業者取得リスト.isEmpty()) {
            return SearchResult.of(Collections.<ServiceJigyoshaInputGuide>emptyList(), 0, false);
        }
        List<ServiceJigyoshaInputGuide> serviceJigyoshaList = new ArrayList<>();
        for (ServiceJigyoshaInputGuideRelateEntity entity : サービス事業者取得リスト) {
            serviceJigyoshaList.add(new ServiceJigyoshaInputGuide(entity));
        }
        return SearchResult.of(serviceJigyoshaList, serviceJigyoshaList.size(), (params.getLimitCount() < serviceJigyoshaList.size()));

    }

    /**
     * 適用除外施設取得リストを取得する。
     *
     * @param params JigyoshaInputGuideParameter
     * @return 適用除外施設取得リスト
     */
    public SearchResult<ServiceJigyoshaInputGuide> getTekiyoJogaiInputGuide(JigyoshaInputGuideParameter params) {
        IJigyoshaInputGuideMapper jigyoshaInputGuideMapper = this.mapperProvider.create(IJigyoshaInputGuideMapper.class);
        List<ServiceJigyoshaInputGuideRelateEntity> 適用除外施設取得リスト = jigyoshaInputGuideMapper.getTekiyoJogaiInputGuide(params);
        if (適用除外施設取得リスト == null || 適用除外施設取得リスト.isEmpty()) {
            return SearchResult.of(Collections.<ServiceJigyoshaInputGuide>emptyList(), 0, false);
        }
        List<ServiceJigyoshaInputGuide> tekiyoJogaiList = new ArrayList<>();
        for (ServiceJigyoshaInputGuideRelateEntity entity : 適用除外施設取得リスト) {
            tekiyoJogaiList.add(new ServiceJigyoshaInputGuide(entity));
        }
        return SearchResult.of(tekiyoJogaiList, tekiyoJogaiList.size(), (params.getLimitCount() < tekiyoJogaiList.size()));
    }

    /**
     * その他特例施設取得リストを取得する。
     *
     * @param params JigyoshaInputGuideParameter
     * @return その他特例施設取得リスト
     */
    public SearchResult<ServiceJigyoshaInputGuide> getOtherTokureiInputGuide(JigyoshaInputGuideParameter params) {
        IJigyoshaInputGuideMapper jigyoshaInputGuideMapper = this.mapperProvider.create(IJigyoshaInputGuideMapper.class);
        List<ServiceJigyoshaInputGuideRelateEntity> その他特例施設取得リスト = jigyoshaInputGuideMapper.getOtherTokureiInputGuide(params);
        if (その他特例施設取得リスト == null || その他特例施設取得リスト.isEmpty()) {
            return SearchResult.of(Collections.<ServiceJigyoshaInputGuide>emptyList(), 0, false);
        }
        List<ServiceJigyoshaInputGuide> otherTokureiiList = new ArrayList<>();
        for (ServiceJigyoshaInputGuideRelateEntity entity : その他特例施設取得リスト) {
            otherTokureiiList.add(new ServiceJigyoshaInputGuide(entity));
        }
        return SearchResult.of(otherTokureiiList, otherTokureiiList.size(), (params.getLimitCount() < otherTokureiiList.size()));
    }
}
