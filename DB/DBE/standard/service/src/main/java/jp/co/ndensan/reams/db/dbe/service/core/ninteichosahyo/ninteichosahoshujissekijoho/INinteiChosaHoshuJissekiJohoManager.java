/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahoshujissekijoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiChosaHoshuJissekiJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ininteichosaschebusiness.NinteichosaSchedulBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho.ShujiiIkenshoHoshuJissekiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteiChosaHoshuTankaMybatisParamter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5601NinteiChosaHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho.NinteiChosaHoshuJissekiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteischedule.ninteichosahoshujissekijoho.NinteichosahyoGaikyoChosaRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5601NinteiChosaHoshuJissekiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahoshujissekijoho.INinteiChosaHoshuJissekiJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 認定調査委託料入力クラスです。
 *
 * @reamsid_L DBE-1970-010 wanghui
 */
public class INinteiChosaHoshuJissekiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5601NinteiChosaHoshuJissekiJohoDac dbT5601Dac;

    /**
     * コンストラクタです。
     */
    INinteiChosaHoshuJissekiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT5601Dac = InstanceProvider.create(DbT5601NinteiChosaHoshuJissekiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapperProvider {@link MapperProvider}}
     */
    INinteiChosaHoshuJissekiJohoManager(MapperProvider mapperProvider,
            DbT5601NinteiChosaHoshuJissekiJohoDac dbT5601Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT5601Dac = dbT5601Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link INinteiChosaHoshuJissekiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link INinteiChosaHoshuJissekiJohoManager}のインスタンス
     */
    public static INinteiChosaHoshuJissekiJohoManager createInstance() {
        return InstanceProvider.create(INinteiChosaHoshuJissekiJohoManager.class);
    }

    /**
     * 初期化調査員情報を検索する。
     *
     * @param parametere NinteiChosaHoshuJissekiJohoMybatisParameter
     * @return 調査員情報検索list
     */
    @Transaction
    public SearchResult<NinteiChosaHoshuJissekiJohoBusiness> get初期化調査員情報検索(NinteiChosaHoshuJissekiJohoMybatisParameter parametere) {
        List<NinteiChosaHoshuJissekiJohoBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteiChosaHoshuJissekiJohoMapper mapper = mapperProvider.create(INinteiChosaHoshuJissekiJohoMapper.class);
        List<NinteiChosaHoshuJissekiJohoRelateEntity> 調査員情報検索list = mapper.get調査員情報検索(parametere);
        if (調査員情報検索list == null || 調査員情報検索list.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (NinteiChosaHoshuJissekiJohoRelateEntity entity : 調査員情報検索list) {
            kojinJokyoShokaiList.add(new NinteiChosaHoshuJissekiJohoBusiness(entity));
        }
        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 調査員実績検索情報を検索する。
     *
     * @param parametere NinteichosahyoGaikyoChosaMybatisParameter
     * @return 調査員実績list
     */
    @Transaction
    public SearchResult<NinteichosahyoGaikyoChosaBusiness> get調査員実績検索(NinteichosahyoGaikyoChosaMybatisParameter parametere) {
        List<NinteichosahyoGaikyoChosaBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteiChosaHoshuJissekiJohoMapper mapper = mapperProvider.create(INinteiChosaHoshuJissekiJohoMapper.class);
        List<NinteichosahyoGaikyoChosaRelateEntity> 調査員実績list = mapper.get調査員実績一覧検索(parametere);
        if (調査員実績list == null || 調査員実績list.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (NinteichosahyoGaikyoChosaRelateEntity entity : 調査員実績list) {
            kojinJokyoShokaiList.add(new NinteichosahyoGaikyoChosaBusiness(entity));
        }

        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 調査員実績検索情報を検索する。
     *
     * @param parametere NinteichosahyoGaikyoChosaMybatisParameter
     * @return 調査員実績list
     */
    @Transaction
    public SearchResult<NinteichosahyoGaikyoChosaBusiness> get単価検索(NinteiChosaHoshuTankaMybatisParamter parametere) {
        List<NinteichosahyoGaikyoChosaBusiness> kojinJokyoShokaiList = new ArrayList();
        INinteiChosaHoshuJissekiJohoMapper mapper = mapperProvider.create(INinteiChosaHoshuJissekiJohoMapper.class);
        List<NinteichosahyoGaikyoChosaRelateEntity> 調査員実績list = mapper.get認定調査報酬単価(parametere);
        if (調査員実績list == null || 調査員実績list.isEmpty()) {
            return SearchResult.of(Collections.<NinteichosaSchedulBusiness>emptyList(), 0, false);
        }
        for (NinteichosahyoGaikyoChosaRelateEntity entity : 調査員実績list) {
            kojinJokyoShokaiList.add(new NinteichosahyoGaikyoChosaBusiness(entity));
        }

        return SearchResult.of(kojinJokyoShokaiList, 0, false);
    }

    /**
     * 調査員実績検索情報追加する。
     *
     * @param 調査員実績登録情報 KaigoJigyosha
     * @return count 件数
     */
    @Transaction
    public boolean insertJigyoshaJoho(NinteiChosaHoshuJissekiJoho 調査員実績登録情報
    ) {
        if (!調査員実績登録情報.hasChanged()) {
            return false;
        }
        DbT5601NinteiChosaHoshuJissekiJohoEntity dbT5601entity = 調査員実績登録情報.toEntity();
        dbT5601entity.setState(EntityDataState.Added);
        return 1 == dbT5601Dac.save(dbT5601entity);
    }

    /**
     * 調査員実績検索情報追加する。
     *
     * @param 調査員実績登録情報 KaigoJigyosha
     * @return count 件数
     */
    @Transaction
    public boolean upuaretJigyoshaJoho(NinteiChosaHoshuJissekiJoho 調査員実績登録情報
    ) {
        if (!調査員実績登録情報.hasChanged()) {
            return false;
        }
        DbT5601NinteiChosaHoshuJissekiJohoEntity dbT5601entity = 調査員実績登録情報.toEntity();
        dbT5601entity.setState(EntityDataState.Modified);
        return 1 == dbT5601Dac.save(dbT5601entity);
    }

    /**
     * 施設登録画面用、施設情報を物理削除します。
     *
     * @param models NinteiChosaHoshuJissekiJoho
     * @param key NinteiChosaHoshuJissekiJohoIdentifier
     * @return 更新あり:true、更新なし:false
     */
    @Transaction
    public boolean saveOrDelete(Models<NinteiChosaHoshuJissekiJohoIdentifier, NinteiChosaHoshuJissekiJoho> models,
            NinteiChosaHoshuJissekiJohoIdentifier key) {
        NinteiChosaHoshuJissekiJoho 調査員実績情報 = models.get(key);
        if (調査員実績情報 != null) {
            return 1 == dbT5601Dac.saveOrDeletePhysicalBy(調査員実績情報.toEntity());
        }
        return false;
    }

    /**
     * 調査員実績情報を取得します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return SearchResult<NinteiChosaHoshuJissekiJoho>
     */
    @Transaction
    public SearchResult<NinteiChosaHoshuJissekiJoho> get報酬実績情報(
            RString 認定調査委託先コード,
            RString 認定調査員コード) {
        List<NinteiChosaHoshuJissekiJoho> resultList = new ArrayList<>();
        List<DbT5601NinteiChosaHoshuJissekiJohoEntity> chikuShichosonList = dbT5601Dac.select報酬実績情報(認定調査委託先コード, 認定調査員コード);
        if (chikuShichosonList == null || chikuShichosonList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiIkenshoHoshuJissekiJoho>emptyList(), 0, false);
        }
        for (DbT5601NinteiChosaHoshuJissekiJohoEntity entity : chikuShichosonList) {
            entity.initializeMd5();
            resultList.add(new NinteiChosaHoshuJissekiJoho(entity));
        }
        return SearchResult.of(resultList, 0, false);
    }
}
