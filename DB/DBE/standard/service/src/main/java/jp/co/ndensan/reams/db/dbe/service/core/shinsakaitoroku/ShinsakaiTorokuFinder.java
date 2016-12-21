/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.service.core.shinsakaitoroku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaitoroku.ShinsakaiTorokuBusiness;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaitoroku.ShinsakaiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaitoroku.IShinsakaiTorokuMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaikaisai.ShinsakaiKaisai;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakaikaisai.ShinsakaiKaisaiParameter;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikaisai.ShinsakaiKaisaiRelateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.yokaigoninteitasklist.ShinSaKaiToRoKuRelate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会登録画面検索クラスです。
 * 
 * @author n3402 猪股 祐太
 */
public class ShinsakaiTorokuFinder {
    
    private final MapperProvider mapperProvider;
    
    /**
     * コンストラクタです。
     */
    public ShinsakaiTorokuFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }
    
    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiTorokuFinder}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiTorokuFinder}のインスタンス
     */
    public static ShinsakaiTorokuFinder createInstance() {
        return InstanceProvider.create(ShinsakaiTorokuFinder.class);
    }

    /**
     * 審査会登録モードの場合でデータを検索します。
     *
     * @param parameter YokaigoNinteiTaskListParameter
     * @return SearchResult<ShinSaKaiToRoKuBusiness>
     */
    @Transaction
    public SearchResult<ShinsakaiTorokuBusiness> get審査会登録モード(YokaigoNinteiTaskListParameter parameter) {
        List<ShinsakaiTorokuBusiness> 審査会登録List = new ArrayList<>();
        IShinsakaiTorokuMapper mapper = mapperProvider.create(IShinsakaiTorokuMapper.class);
        List<ShinsakaiTorokuRelateEntity> entityList = mapper.get審査会登録(parameter);
        for (ShinsakaiTorokuRelateEntity entity : entityList) {
            審査会登録List.add(new ShinsakaiTorokuBusiness(entity));
        }
        return SearchResult.of(審査会登録List, 0, false);
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
        IShinsakaiTorokuMapper mapper = mapperProvider.create(IShinsakaiTorokuMapper.class);
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
     * 審査会一覧を検索します。
     *
     * @param 表示期間From 表示期間From
     * @param 表示期間To 表示期間To
     * @param モード モード
     * @param 表示条件 表示条件
     * @param 最大表示件数 Decimal
     * @param ダミー審査会 ダミー審査会
     * @return ShinsakaiKaisai 審査会一覧情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ShinsakaiKaisai> get審査会一覧(
            RDate 表示期間From,
            RDate 表示期間To,
            RString モード,
            RString 表示条件,
            Decimal 最大表示件数,
            RString ダミー審査会) {
        IShinsakaiTorokuMapper mapper = mapperProvider.create(IShinsakaiTorokuMapper.class);
        RString 期間From;
        RString 期間To;
        if (表示期間From != null && 表示期間To != null) {
            期間From = 表示期間From.toDateString();
            期間To = 表示期間To.toDateString();
        } else if (表示期間From != null && 表示期間To == null) {
            期間From = 表示期間From.toDateString();
            期間To = RDate.MAX.toDateString();

        } else if (表示期間From == null && 表示期間To != null) {
            期間From = RDate.MIN.toDateString();
            期間To = 表示期間To.toDateString();
        } else {
            期間From = RDate.MIN.toDateString();
            期間To = RDate.MAX.toDateString();
        }
        ShinsakaiKaisaiParameter parameter = ShinsakaiKaisaiParameter.createParam(
                期間From,
                期間To,
                モード, 表示条件, 最大表示件数, ダミー審査会);
        List<ShinsakaiKaisaiRelateEntity> relateEntityList = mapper.get審査会一覧(parameter);

        if (relateEntityList == null || relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ShinsakaiKaisai>emptyList(), 0, false);
        }
        List<ShinsakaiKaisai> 審査会情報List = new ArrayList<>();
        for (ShinsakaiKaisaiRelateEntity relateEntity : relateEntityList) {
            審査会情報List.add(new ShinsakaiKaisai(relateEntity));
        }
        return SearchResult.of(審査会情報List, 0, false);
    }
}
