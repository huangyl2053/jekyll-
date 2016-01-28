/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.jigyosha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.GunshiCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.ServiceJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.ServiceShuruiJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.definition.jigyosha.JigyoshaInputGuideParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.ServiceJigyoshaInputGuideRelateEntity;
import jp.co.ndensan.reams.db.dba.persistence.mapper.jigyosha.JigyoshaInputGuideMapper;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7130KaigoServiceShuruiDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.core.zenkokujusho.ZenkokuJushoSearchShurui;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.gunshiku.UrT0529GunshikuEntity;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJusho;
import jp.co.ndensan.reams.ur.urz.entity.db.basic.zenkokujusho.UrT0101ZenkokuJushoEntity;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.gunshiku.UrT0529GunshikuDac;
import jp.co.ndensan.reams.ur.urz.persistence.db.basic.zenkokujusho.UrT0101ZenkokuJushoDac;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 事業者・施設選択入力ガイドするクラスです。
 */
public class JigyoshaInputGuideFinder {

    private final MapperProvider mapperProvider;
    private final UrT0101ZenkokuJushoDac urT0101Dac;
    private final DbT7130KaigoServiceShuruiDac dbT7130Dac;
    private final UrT0529GunshikuDac urT0529Dac;

    /**
     * コンストラクタ。
     *
     */
    public JigyoshaInputGuideFinder() {

        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.urT0101Dac = InstanceProvider.create(UrT0101ZenkokuJushoDac.class);
        this.dbT7130Dac = InstanceProvider.create(DbT7130KaigoServiceShuruiDac.class);
        this.urT0529Dac = InstanceProvider.create(UrT0529GunshikuDac.class);
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
            UrT0101ZenkokuJushoDac urT0101Dac,
            DbT7130KaigoServiceShuruiDac dbT7130Dac,
            UrT0529GunshikuDac urT0529Dac) {
        this.mapperProvider = mapperProvider;
        this.urT0101Dac = urT0101Dac;
        this.dbT7130Dac = dbT7130Dac;
        this.urT0529Dac = urT0529Dac;
    }

    /**
     * 県コード取得リストを取得します。
     *
     * @return 県コード取得リスト
     */
    public SearchResult<KenCodeJigyoshaInputGuide> getKenCodeJigyoshaInputGuide() {
        List<KenCodeJigyoshaInputGuide> kenCodeList = new ArrayList<>();
        List<UrT0101ZenkokuJushoEntity> urT0101List = urT0101Dac.select(
                and(not(eq(UrT0101ZenkokuJusho.isDeleted, true)), eq(UrT0101ZenkokuJusho.dataKubun, ZenkokuJushoSearchShurui.都道府県.getDataKubun())));
        if (urT0101List == null || urT0101List.isEmpty()) {
            return SearchResult.of(Collections.<KenCodeJigyoshaInputGuide>emptyList(), 0, false);
        }
        for (UrT0101ZenkokuJushoEntity entity : urT0101List) {
            kenCodeList.add(new KenCodeJigyoshaInputGuide(entity));
        }
        return SearchResult.of(kenCodeList, 0, false);
    }

    /**
     * 郡市コード取得リストを取得する。
     *
     * @return 郡市コード取得リスト
     */
    public SearchResult<GunshiCodeJigyoshaInputGuide> getGunshiCodeJigyoshaInputGuide() {
        List<GunshiCodeJigyoshaInputGuide> gunshiCodeList = new ArrayList<>();
        List<UrT0529GunshikuEntity> urt0529List = urT0529Dac.selectAll();
        if (urt0529List == null || urt0529List.isEmpty()) {
            return SearchResult.of(Collections.<KenCodeJigyoshaInputGuide>emptyList(), 0, false);
        }
        for (UrT0529GunshikuEntity entity : urt0529List) {
            gunshiCodeList.add(new GunshiCodeJigyoshaInputGuide(entity));
        }
        return SearchResult.of(gunshiCodeList, 0, false);
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
        JigyoshaInputGuideMapper jigyoshaInputGuideMapper = this.mapperProvider.create(JigyoshaInputGuideMapper.class);
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
        JigyoshaInputGuideMapper jigyoshaInputGuideMapper = this.mapperProvider.create(JigyoshaInputGuideMapper.class);
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
        JigyoshaInputGuideMapper jigyoshaInputGuideMapper = this.mapperProvider.create(JigyoshaInputGuideMapper.class);
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
