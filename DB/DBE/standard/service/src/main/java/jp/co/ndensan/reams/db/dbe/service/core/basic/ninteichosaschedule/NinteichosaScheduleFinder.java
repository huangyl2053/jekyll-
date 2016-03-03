/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.ninteichosaschedule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness.NinteichosaSchedulBusiness;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaschedule.INinteiKanryoJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosaschedule.INinteichosaScheduleMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaschedule.INinteichosaScheduleRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.ninteichosaschedule.INinteichosaSchedule;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 認定調査スケジュール登録3クラスです。
 */
public class NinteichosaScheduleFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    NinteichosaScheduleFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    NinteichosaScheduleFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaScheduleFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaScheduleFinder}のインスタンス
     */
    public static NinteichosaScheduleFinder createInstance() {
        return InstanceProvider.create(NinteichosaScheduleFinder.class);
    }

    /**
     * パラメータ．モード：2(スケジュール照会)の場合、画面の検索条件より、認定調査スケジュール情報を検索する。
     *
     * @param parametere INinteichosaScheduleMybatisParameter
     * @return 該当者一覧照会
     */
    @Transaction
    public SearchResult<NinteichosaSchedulBusiness> getKojinJokyoShokai(INinteichosaScheduleMybatisParameter parametere) {
        List<NinteichosaSchedulBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteichosaSchedule mapper = mapperProvider.create(INinteichosaSchedule.class);
        List<INinteichosaScheduleRelateEntity> 該当者一覧照会 = mapper.selectNinteichosaScheduleList(parametere);
        if (該当者一覧照会 == null || 該当者一覧照会.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (INinteichosaScheduleRelateEntity entity : 該当者一覧照会) {
            kojinJokyoShokaiList.add(new NinteichosaSchedulBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * パラメータ．モード：3(未定者管理)の場合、画面の検索条件より、認定調査スケジュール情報を検索する。
     *
     * @param parametere INinteichosaScheduleMybatisParameter
     * @return 未定者管理
     */
    @Transaction
    public SearchResult<NinteichosaSchedulBusiness> get未定者管理(INinteiKanryoJohoMybatisParameter parametere) {
        List<NinteichosaSchedulBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteichosaSchedule mapper = mapperProvider.create(INinteichosaSchedule.class);
        List<INinteichosaScheduleRelateEntity> 未定者管理 = mapper.selectKoseiShichosonMasterList(parametere);
        if (未定者管理 == null || 未定者管理.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (INinteichosaScheduleRelateEntity entity : 未定者管理) {
            kojinJokyoShokaiList.add(new NinteichosaSchedulBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 画面の「検索対象．申請者」を選択した場合、画面の検索条件より、認定調査スケジュール情報を検索する。
     *
     * @param parametere INinteiKanryoJohoMybatisParameter
     * @return 検索対象申請者
     */
    @Transaction
    public SearchResult<NinteichosaSchedulBusiness> get検索対象申請者(INinteiKanryoJohoMybatisParameter parametere) {
        List<NinteichosaSchedulBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteichosaSchedule mapper = mapperProvider.create(INinteichosaSchedule.class);
        List<INinteichosaScheduleRelateEntity> 検索対象申請者 = mapper.selectNinteiShinseiJohoList(parametere);
        if (検索対象申請者 == null || 検索対象申請者.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (INinteichosaScheduleRelateEntity entity : 検索対象申請者) {
            kojinJokyoShokaiList.add(new NinteichosaSchedulBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 画面の「検索対象．みなし2号」を選択した場合、画面の検索条件より、認定調査スケジュール情報を検索する。
     *
     * @param parametere INinteichosaScheduleMybatisParameter
     * @return 検索対象みなし2号
     */
    @Transaction
    public SearchResult<NinteichosaSchedulBusiness> get検索対象みなし2号(INinteiKanryoJohoMybatisParameter parametere) {
        List<NinteichosaSchedulBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteichosaSchedule mapper = mapperProvider.create(INinteichosaSchedule.class);
        List<INinteichosaScheduleRelateEntity> 検索対象みなし2号 = mapper.selectNinteichosaIraiJohoList(parametere);
        if (検索対象みなし2号 == null || 検索対象みなし2号.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (INinteichosaScheduleRelateEntity entity : 検索対象みなし2号) {
            kojinJokyoShokaiList.add(new NinteichosaSchedulBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 保険者ドロップダウンリスト値取得。
     *
     * @param parametere INinteichosaScheduleMybatisParameter
     * @return 保険者ドロップダウンリスト
     */
    @Transaction
    public SearchResult<NinteichosaSchedulBusiness> get保険者ドロップダウン(INinteiKanryoJohoMybatisParameter parametere) {
        List<NinteichosaSchedulBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteichosaSchedule mapper = mapperProvider.create(INinteichosaSchedule.class);
        List<INinteichosaScheduleRelateEntity> 保険者ドロップダウンリスト = mapper.select保険者ドロップダウンリスト(parametere);
        if (保険者ドロップダウンリスト == null || 保険者ドロップダウンリスト.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (INinteichosaScheduleRelateEntity entity : 保険者ドロップダウンリスト) {
            kojinJokyoShokaiList.add(new NinteichosaSchedulBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 認定調査委託先ドロップダウンリスト値取得。
     *
     * @param parametere INinteichosaScheduleMybatisParameter
     * @return 認定調査委託先ドロップダウンリスト
     */
    @Transaction
    public SearchResult<NinteichosaSchedulBusiness> get認定調査委託先ロップダウン(INinteichosaScheduleMybatisParameter parametere) {
        List<NinteichosaSchedulBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteichosaSchedule mapper = mapperProvider.create(INinteichosaSchedule.class);
        List<INinteichosaScheduleRelateEntity> 認定調査委託先ドロップダウンリスト = mapper.select認定調査委託先ドロップダウンリスト(parametere);
        if (認定調査委託先ドロップダウンリスト == null || 認定調査委託先ドロップダウンリスト.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (INinteichosaScheduleRelateEntity entity : 認定調査委託先ドロップダウンリスト) {
            kojinJokyoShokaiList.add(new NinteichosaSchedulBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }
}
