/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
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
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiToRoKuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKeTuKeBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
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
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKaiToRoKuRelate;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKaiToRoKuRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKeTuKeRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.yokaigoninteitasklist.IYokaigoNinteiTaskListMapper;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * タスク一覧共有画面の検索処理クラスです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
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
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<KoShiTaisyoBusiness>
     */
    @Transaction
    public SearchResult<KoShiTaisyoBusiness> get更新対象モード(YokaigoNinteiTaskListParameter parameter) {
        List<KoShiTaisyoBusiness> 更新対象List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<KoShiTaisyoRelateEntity> entityList = mapper.get更新対象(parameter);
        for (KoShiTaisyoRelateEntity entity : entityList) {
            更新対象List.add(new KoShiTaisyoBusiness(entity));
        }
        return SearchResult.of(更新対象List, 0, false);
    }

    /**
     * 申請受付モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<ShiSeiKeTuKeBusiness>
     */
    @Transaction
    public SearchResult<ShiSeiKeTuKeBusiness> get申請受付モード(YokaigoNinteiTaskListParameter parameter) {
        List<ShiSeiKeTuKeBusiness> 申請受付List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShiSeiKeTuKeRelateEntity> entityList = mapper.get申請受付(parameter);
        for (ShiSeiKeTuKeRelateEntity entity : entityList) {
            申請受付List.add(new ShiSeiKeTuKeBusiness(entity));
        }
        return SearchResult.of(申請受付List, 0, false);
    }

    /**
     * 調査依頼モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<CyoSaiRaiBusiness>
     */
    @Transaction
    public SearchResult<CyoSaiRaiBusiness> get調査依頼モード(YokaigoNinteiTaskListParameter parameter) {
        List<CyoSaiRaiBusiness> 調査依頼List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<CyoSaiRaiRelateEntity> entityList = mapper.get調査依頼(parameter);
        for (CyoSaiRaiRelateEntity entity : entityList) {
            調査依頼List.add(new CyoSaiRaiBusiness(entity));
        }
        return SearchResult.of(調査依頼List, 0, false);
    }

    /**
     * 前調査依頼を取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前調査依頼モード(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前調査依頼(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前調査依頼(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前調査依頼(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {
        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 意見書依頼モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<IKnSyoiRaiBusiness>
     */
    @Transaction
    public SearchResult<IKnSyoiRaiBusiness> get意見書依頼モード(YokaigoNinteiTaskListParameter parameter) {
        List<IKnSyoiRaiBusiness> 意見書依頼List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<IKnSyoiRaiRelateEntity> entityList = mapper.get意見書依頼(parameter);
        for (IKnSyoiRaiRelateEntity entity : entityList) {
            意見書依頼List.add(new IKnSyoiRaiBusiness(entity));
        }
        return SearchResult.of(意見書依頼List, 0, false);
    }

    /**
     * 調査入手モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<CyoSaNyuSyuBusiness>
     */
    @Transaction
    public SearchResult<CyoSaNyuSyuBusiness> get調査入手モード(YokaigoNinteiTaskListParameter parameter) {
        List<CyoSaNyuSyuBusiness> 調査入手List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<CyoSaNyuSyuRelateEntity> entityList = mapper.get調査入手(parameter);
        for (CyoSaNyuSyuRelateEntity entity : entityList) {
            調査入手List.add(new CyoSaNyuSyuBusiness(entity));
        }
        return SearchResult.of(調査入手List, 0, false);
    }

    /**
     * 前調査入手を取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前調査入手モード(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前調査入手(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前調査入手(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前調査入手(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {
        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 意見書入手モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<IkenSyoNyuSyuBusiness>
     */
    @Transaction
    public SearchResult<IkenSyoNyuSyuBusiness> get意見書入手モード(YokaigoNinteiTaskListParameter parameter) {
        List<IkenSyoNyuSyuBusiness> 意見書入手List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<IkenSyoNyuSyuRelateEntity> entityList = mapper.get意見書入手(parameter);
        for (IkenSyoNyuSyuRelateEntity entity : entityList) {
            意見書入手List.add(new IkenSyoNyuSyuBusiness(entity));
        }
        return SearchResult.of(意見書入手List, 0, false);
    }

    /**
     * 一次判定モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<IChiJiHanTeiBusiness>
     */
    @Transaction
    public SearchResult<IChiJiHanTeiBusiness> get一次判定モード(YokaigoNinteiTaskListParameter parameter) {
        List<IChiJiHanTeiBusiness> 一次判定List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<IChiJiHanTeiRelateEntity> entityList = mapper.get一次判定(parameter);
        for (IChiJiHanTeiRelateEntity entity : entityList) {
            一次判定List.add(new IChiJiHanTeiBusiness(entity));
        }
        return SearchResult.of(一次判定List, 0, false);
    }

    /**
     * マスキングモードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<IChiJiHanTeiBusiness>
     */
    @Transaction
    public SearchResult<MaSuKinGuBusiness> getマスキングモード(YokaigoNinteiTaskListParameter parameter) {
        List<MaSuKinGuBusiness> マスキングList = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<MaSuKinGuRelateEntity> entityList = mapper.getマスキング(parameter);
        for (MaSuKinGuRelateEntity entity : entityList) {
            マスキングList.add(new MaSuKinGuBusiness(entity));
        }
        return SearchResult.of(マスキングList, 0, false);
    }

    /**
     * 審査会登録モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<ShinSaKaiToRoKuBusiness>
     */
    @Transaction
    public SearchResult<ShinSaKaiToRoKuBusiness> get審査会登録モード(YokaigoNinteiTaskListParameter parameter) {
        List<ShinSaKaiToRoKuBusiness> 審査会登録List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelateEntity> entityList = mapper.get審査会登録(parameter);
        for (ShinSaKaiToRoKuRelateEntity entity : entityList) {
            審査会登録List.add(new ShinSaKaiToRoKuBusiness(entity));
        }
        return SearchResult.of(審査会登録List, 0, false);
    }

    /**
     * 前意見書依頼を取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前意見書依頼(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前意見書依頼(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前意見書依頼(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    /**
     * 前意見書入手を取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前意見書入手(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前意見書入手(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前意見書入手(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    /**
     * 適用情報リストを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前審査会登録(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前審査会登録(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前審査会登録(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前審査会登録(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {
        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 前二次判定リストを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前二次判定(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前二次判定(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前二次判定(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前二次判定(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {

        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 前月例処理リストを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前月例処理(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前月例処理(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前月例処理(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前月例処理(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {

        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 前審査受付リストを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前審査受付(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前審査受付(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前審査受付(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前審査受付(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {

        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 前一次判定リストを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前一次判定(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前一次判定(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前一次判定(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前一次判定(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {

        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 前マスキングリストを取得します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return 他住所地特例者管理 他住所地特例者管理
     */
    @Transaction
    public ShinSaKaiBusiness get前マスキング(YokaigoNinteiTaskListParameter parameter) {
        ShinSaKaiBusiness shinSaKaiBusiness = new ShinSaKaiBusiness();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKaiToRoKuRelate> entityList = mapper.get前マスキング(parameter);
        for (ShinSaKaiToRoKuRelate shinSaKaiToRoKuRelate : entityList) {
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報 = shinSaKaiToRoKuRelate.get要介護認定完了情報EntityLsit();
            set前マスキング(要介護認定完了情報, shinSaKaiBusiness);
        }
        return shinSaKaiBusiness;
    }

    private void set前マスキング(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {

        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    private void set前意見書入手(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {
        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    private void set前意見書依頼(
            List<DbT5105NinteiKanryoJohoEntity> 要介護認定完了情報,
            ShinSaKaiBusiness shinSaKaiBusiness) {
        List<NinteiKanryoJoho> 要介護認定完了情報Lsit = new ArrayList();
        for (DbT5105NinteiKanryoJohoEntity entity : 要介護認定完了情報) {
            entity.initializeMd5();
            要介護認定完了情報Lsit.add(new NinteiKanryoJoho(entity));
        }
        shinSaKaiBusiness.set要介護認定完了情報Lsit(要介護認定完了情報Lsit);
    }

    /**
     * 二次判定モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<ShinSaKaiToRoKuBusiness>
     */
    @Transaction
    public SearchResult<NiJiHanTeiBusiness> get二次判定モード(YokaigoNinteiTaskListParameter parameter) {
        List<NiJiHanTeiBusiness> 二次判定List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<NiJiHanTeiRelateEntity> entityList = mapper.get二次判定(parameter);
        for (NiJiHanTeiRelateEntity entity : entityList) {
            二次判定List.add(new NiJiHanTeiBusiness(entity));
        }
        return SearchResult.of(二次判定List, 0, false);
    }

    /**
     * 月例処理モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<GeTuReiSyoRiBusiness>
     */
    @Transaction
    public SearchResult<GeTuReiSyoRiBusiness> get月例処理モード(YokaigoNinteiTaskListParameter parameter) {
        List<GeTuReiSyoRiBusiness> 月例処理List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<GeTuReiSyoRiRelateEntity> entityList = mapper.get月例処理(parameter);
        for (GeTuReiSyoRiRelateEntity entity : entityList) {
            月例処理List.add(new GeTuReiSyoRiBusiness(entity));
        }
        return SearchResult.of(月例処理List, 0, false);
    }

    /**
     * 審査受付モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<ShinSaKeTuKeBusiness>
     */
    @Transaction
    public SearchResult<ShinSaKeTuKeBusiness> get審査受付モード(YokaigoNinteiTaskListParameter parameter) {
        List<ShinSaKeTuKeBusiness> 審査受付List = new ArrayList<>();
        IYokaigoNinteiTaskListMapper mapper = mapperProvider.create(IYokaigoNinteiTaskListMapper.class);
        List<ShinSaKeTuKeRelateEntity> entityList = mapper.get審査受付(parameter);
        for (ShinSaKeTuKeRelateEntity entity : entityList) {
            審査受付List.add(new ShinSaKeTuKeBusiness(entity));
        }
        return SearchResult.of(審査受付List, 0, false);
    }
}
