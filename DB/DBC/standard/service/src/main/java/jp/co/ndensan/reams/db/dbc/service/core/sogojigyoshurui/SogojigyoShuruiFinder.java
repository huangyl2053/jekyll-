/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.sogojigyoshurui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoShuruiShikyuGendoGaku;
import jp.co.ndensan.reams.db.dbc.business.core.sogojigyoshurui.SogojigyoShuruiSearchResult;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshuruishikyugendogaku.SogojigyoShuruiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyoshuruishikyugendogaku.ISogojigyoShuruiMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合事業種類支給限度額情報の取得クラスです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
public class SogojigyoShuruiFinder {

    private static final RString 要支援1 = new RString("12");
    private static final RString 要支援2 = new RString("13");
    private static final RString 二次予防 = new RString("01");

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    SogojigyoShuruiFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}
     */
    SogojigyoShuruiFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SogojigyoShuruiFinder}のインスタンスを返します。
     *
     * @return SogojigyoShuruiFinder
     */
    public static SogojigyoShuruiFinder createInstance() {
        return InstanceProvider.create(SogojigyoShuruiFinder.class);
    }

    /**
     * 総合事業種類支給限度額情報を取得します。
     *
     * @return 検索結果{@link SearchResult}
     */
    @Transaction
    public SearchResult<SogojigyoShuruiSearchResult> get総合事業種類支給限度額情報() {

        ISogojigyoShuruiMapper mapper = mapperProvider.create(ISogojigyoShuruiMapper.class);
        List<SogojigyoShuruiEntity> resultList = mapper.get総合事業種類情報();
        if (resultList.isEmpty()) {
            return SearchResult.of(Collections.<SogojigyoShuruiSearchResult>emptyList(), 0, false);
        }
        List<SogojigyoShuruiSearchResult> businessList = new ArrayList();
        List<FlexibleYearMonth> 適用開始日List = new ArrayList<>();
        for (SogojigyoShuruiEntity entity : resultList) {
            if (!適用開始日List.contains(entity.get総合事業種類情報().getTekiyoKaishiYM())) {
                適用開始日List.add(entity.get総合事業種類情報().getTekiyoKaishiYM());
            }
        }
        List<RString> サービス種類名称List = new ArrayList<>();
        for (SogojigyoShuruiEntity entity : resultList) {
            if (!サービス種類名称List.contains(entity.getサービス種類名称())) {
                サービス種類名称List.add(entity.getサービス種類名称());
            }
        }
        SogojigyoShuruiEntity result1;
        SogojigyoShuruiEntity result2;
        SogojigyoShuruiEntity result3;
        SogoJigyoShuruiShikyuGendoGaku result要支援1 = null;
        SogoJigyoShuruiShikyuGendoGaku result要支援2 = null;
        SogoJigyoShuruiShikyuGendoGaku result二次予防 = null;
        for (FlexibleYearMonth 適用開始日 : 適用開始日List) {
            for (RString サービス種類名称 : サービス種類名称List) {
                result1 = get日常生活支援総合事業種類支給限度額(resultList, 要支援1, 適用開始日, サービス種類名称);
                result2 = get日常生活支援総合事業種類支給限度額(resultList, 要支援2, 適用開始日, サービス種類名称);
                result3 = get日常生活支援総合事業種類支給限度額(resultList, 二次予防, 適用開始日, サービス種類名称);
                if (result1 == null && result2 == null && result3 == null) {
                    continue;
                }
                if (result1 != null) {
                    サービス種類名称 = result1.getサービス種類名称();
                    result要支援1 = new SogoJigyoShuruiShikyuGendoGaku(result1.get総合事業種類情報());
                }
                if (result2 != null) {
                    サービス種類名称 = result2.getサービス種類名称();
                    result要支援2 = new SogoJigyoShuruiShikyuGendoGaku(result2.get総合事業種類情報());
                }
                if (result3 != null) {
                    サービス種類名称 = result3.getサービス種類名称();
                    result二次予防 = new SogoJigyoShuruiShikyuGendoGaku(result3.get総合事業種類情報());
                }
                businessList.add(new SogojigyoShuruiSearchResult(result要支援1, result要支援2, result二次予防,
                        サービス種類名称));
            }
        }
        return SearchResult.of(businessList, resultList.size(), false);
    }

    private SogojigyoShuruiEntity get日常生活支援総合事業種類支給限度額(
            List<SogojigyoShuruiEntity> 総合事業種類情報,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始日,
            RString サービス種類名称) {
        for (SogojigyoShuruiEntity entity : 総合事業種類情報) {
            if (要介護状態区分.equals(entity.get総合事業種類情報().getYoKaigoJotaiKubun())
                    && 適用開始日.equals(entity.get総合事業種類情報().getTekiyoKaishiYM())
                    && サービス種類名称.equals(entity.getサービス種類名称())) {
                return entity;
            }
        }
        return null;
    }

}
