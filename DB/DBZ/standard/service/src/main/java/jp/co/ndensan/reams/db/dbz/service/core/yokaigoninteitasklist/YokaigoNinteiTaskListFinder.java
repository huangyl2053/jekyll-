/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaNyuSyuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.GeTuReiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IChiJiHanTeiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IKnSyoiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IkenSyoNyuSyuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.KoShiTaisyoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.MaSuKinGuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.NiJiHanTeiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShiSeiKeTuKeBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiToRoKuBusiness;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.CyoSaNyuSyuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.CyoSaiRaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.GeTuReiSyoRiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.IChiJiHanTeiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.IKnSyoiRaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.IkenSyoNyuSyuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.KoShiTaisyoRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.MaSuKinGuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.NiJiHanTeiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShiSeiKeTuKeRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKaiToRoKuRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.yokaigoninteitasklist.IYokaigoNinteiTaskListMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * タスク一覧共有画面の検索処理クラスです。
 *
 * @reamsid_L DBE-3000-160 houtp
 */
public class YokaigoNinteiTaskListFinder {
    
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public YokaigoNinteiTaskListFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    
    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link MapperProvider}
     */
    YokaigoNinteiTaskListFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiTaskListFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiTaskListFinder}のインスタンス
     */
    public static YokaigoNinteiTaskListFinder createInstance() {
        return InstanceProvider.create(YokaigoNinteiTaskListFinder.class);
    }
    
    /**
     * 更新対象モードの場合でデータを検索します。
     *
     * @return SearchResult<KoShiTaisyoBusiness>
     */
    public SearchResult<KoShiTaisyoBusiness> get更新対象モード() {
        List<KoShiTaisyoBusiness> 更新対象List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<KoShiTaisyoRelateEntity> entityList = mapper.get更新対象();
        for (KoShiTaisyoRelateEntity entity : entityList) {
            更新対象List.add(new KoShiTaisyoBusiness(entity));
        }
        return SearchResult.of(更新対象List, 0, false);
    }

    /**
     * 申請受付モードの場合でデータを検索します。
     *
     * @return SearchResult<ShiSeiKeTuKeBusiness>
     */
    public SearchResult<ShiSeiKeTuKeBusiness> get申請受付モード() {
        List<ShiSeiKeTuKeBusiness> 申請受付List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShiSeiKeTuKeRelateEntity> entityList = mapper.get申請受付();
        for (ShiSeiKeTuKeRelateEntity entity : entityList) {
            申請受付List.add(new ShiSeiKeTuKeBusiness(entity));
        }
        return SearchResult.of(申請受付List, 0, false);
    }

    /**
     * 調査依頼モードの場合でデータを検索します。
     *
     * @return SearchResult<CyoSaiRaiBusiness>
     */
    public SearchResult<CyoSaiRaiBusiness> get調査依頼モード() {
        List<CyoSaiRaiBusiness> 調査依頼List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<CyoSaiRaiRelateEntity> entityList = mapper.get調査依頼();
        for (CyoSaiRaiRelateEntity entity : entityList) {
            調査依頼List.add(new CyoSaiRaiBusiness(entity));
        }
        return SearchResult.of(調査依頼List, 0, false);
    }

    /**
     * 意見書依頼モードの場合でデータを検索します。
     *
     * @return SearchResult<IKnSyoiRaiBusiness>
     */
    public SearchResult<IKnSyoiRaiBusiness> get意見書依頼モード() {
        List<IKnSyoiRaiBusiness> 意見書依頼List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<IKnSyoiRaiRelateEntity> entityList = mapper.get意見書依頼();
        for (IKnSyoiRaiRelateEntity entity : entityList) {
            意見書依頼List.add(new IKnSyoiRaiBusiness(entity));
        }
        return SearchResult.of(意見書依頼List, 0, false);
    }

    /**
     * 調査入手モードの場合でデータを検索します。
     *
     * @return SearchResult<CyoSaNyuSyuBusiness>
     */
    public SearchResult<CyoSaNyuSyuBusiness> get調査入手モード() {
        List<CyoSaNyuSyuBusiness> 調査入手List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<CyoSaNyuSyuRelateEntity> entityList = mapper.get調査入手();
        for (CyoSaNyuSyuRelateEntity entity : entityList) {
            調査入手List.add(new CyoSaNyuSyuBusiness(entity));
        }
        return SearchResult.of(調査入手List, 0, false);
    }

    /**
     * 意見書入手モードの場合でデータを検索します。
     *
     * @return SearchResult<IkenSyoNyuSyuBusiness>
     */
    public SearchResult<IkenSyoNyuSyuBusiness> get意見書入手モード() {
        List<IkenSyoNyuSyuBusiness> 意見書入手List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<IkenSyoNyuSyuRelateEntity> entityList = mapper.get意見書入手();
        for (IkenSyoNyuSyuRelateEntity entity : entityList) {
            意見書入手List.add(new IkenSyoNyuSyuBusiness(entity));
        }
        return SearchResult.of(意見書入手List, 0, false);
    }

    /**
     * 一次判定モードの場合でデータを検索します。
     *
     * @return SearchResult<IChiJiHanTeiBusiness>
     */
    public SearchResult<IChiJiHanTeiBusiness> get一次判定モード() {
        List<IChiJiHanTeiBusiness> 一次判定List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<IChiJiHanTeiRelateEntity> entityList = mapper.get一次判定();
        for (IChiJiHanTeiRelateEntity entity : entityList) {
            一次判定List.add(new IChiJiHanTeiBusiness(entity));
        }
        return SearchResult.of(一次判定List, 0, false);
    }

    /**
     * マスキングモードの場合でデータを検索します。
     *
     * @return SearchResult<IChiJiHanTeiBusiness>
     */
    public SearchResult<MaSuKinGuBusiness> getマスキングモード() {
        List<MaSuKinGuBusiness> マスキングList = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<MaSuKinGuRelateEntity> entityList = mapper.getマスキング();
        for (MaSuKinGuRelateEntity entity : entityList) {
            マスキングList.add(new MaSuKinGuBusiness(entity));
        }
        return SearchResult.of(マスキングList, 0, false);
    }

    /**
     * 審査会登録モードの場合でデータを検索します。
     *
     * @return SearchResult<ShinSaKaiToRoKuBusiness>
     */
    public SearchResult<ShinSaKaiToRoKuBusiness> get審査会登録モード() {
        List<ShinSaKaiToRoKuBusiness> 審査会登録List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelateEntity> entityList = mapper.get審査会登録();
        for (ShinSaKaiToRoKuRelateEntity entity : entityList) {
            審査会登録List.add(new ShinSaKaiToRoKuBusiness(entity));
        }
        return SearchResult.of(審査会登録List, 0, false);
    }

    /**
     * 二次判定モードの場合でデータを検索します。
     *
     * @return SearchResult<ShinSaKaiToRoKuBusiness>
     */
    public SearchResult<NiJiHanTeiBusiness> get二次判定モード() {
        List<NiJiHanTeiBusiness> 二次判定List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<NiJiHanTeiRelateEntity> entityList = mapper.get二次判定();
        for (NiJiHanTeiRelateEntity entity : entityList) {
            二次判定List.add(new NiJiHanTeiBusiness(entity));
        }
        return SearchResult.of(二次判定List, 0, false);
    }

    /**
     * 月例処理モードの場合でデータを検索します。
     *
     * @return SearchResult<GeTuReiSyoRiBusiness>
     */
    public SearchResult<GeTuReiSyoRiBusiness> get月例処理モード() {
        List<GeTuReiSyoRiBusiness> 二次判定List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<GeTuReiSyoRiRelateEntity> entityList = mapper.get月例処理();
        for (GeTuReiSyoRiRelateEntity entity : entityList) {
            二次判定List.add(new GeTuReiSyoRiBusiness(entity));
        }
        return SearchResult.of(二次判定List, 0, false);
    }
}
