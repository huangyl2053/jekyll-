/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.service.core.shinsakaikaisaikekka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikekkatoroku.IShinsakaiKekkaTorokuMapper;
import jp.co.ndensan.reams.db.dbx.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.NiJiHanTeiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.NiJiHanTeiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKaiToRoKuRelate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会結果登録画面検索クラスです。
 * 
 * @author n3402 猪股祐太
 */
public class ShinsakaiKekkaTorokuFinder {
    
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKekkaTorokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link YokaigoNinteiTaskListFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKekkaTorokuFinder}のインスタンス
     */
    public static ShinsakaiKekkaTorokuFinder createInstance() {
        return InstanceProvider.create(ShinsakaiKekkaTorokuFinder.class);
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
        IShinsakaiKekkaTorokuMapper mapper = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class);
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
     * 二次判定モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<ShinSaKaiToRoKuBusiness>
     */
    @Transaction
    public SearchResult<NiJiHanTeiBusiness> get二次判定モード(YokaigoNinteiTaskListParameter parameter) {
        List<NiJiHanTeiBusiness> 二次判定List = new ArrayList<>();
        IShinsakaiKekkaTorokuMapper mapper = mapperProvider.create(IShinsakaiKekkaTorokuMapper.class);
        List<NiJiHanTeiRelateEntity> entityList = mapper.get二次判定(parameter);
        for (NiJiHanTeiRelateEntity entity : entityList) {
            二次判定List.add(new NiJiHanTeiBusiness(entity));
        }
        return SearchResult.of(二次判定List, 0, false);
    }
}
