/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaikaisaibashojoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5592ShinsakaiKaisaiBashoJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.IDbT5592ShinsakaiKaisaiBashoJohoMapper;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催場所情報を管理するクラスです。
 */
public class ShinsakaiKaisaiBashoJohoManager {

    private final DbT5592ShinsakaiKaisaiBashoJohoDac dac;
    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiBashoJohoManager() {
        dac = InstanceProvider.create(DbT5592ShinsakaiKaisaiBashoJohoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5592ShinsakaiKaisaiBashoJohoDac}
     */
    ShinsakaiKaisaiBashoJohoManager(DbT5592ShinsakaiKaisaiBashoJohoDac dac) {
        this.dac = dac;
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiBashoJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiBashoJohoManager}のインスタンス
     */
    public static ShinsakaiKaisaiBashoJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiBashoJohoManager.class);
    }
    
    /**
     * 主キーに合致する介護認定審査会開催場所情報を返します。
     *
     * @param 介護認定審査会開催場所コード 介護認定審査会開催場所コード
     * @return ShinsakaiKaisaiBashoJoho
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiBashoJoho> get介護認定審査会開催場所情報(
            RString 介護認定審査会開催場所コード) {
        requireNonNull(介護認定審査会開催場所コード
                , UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所コード"));
         List<ShinsakaiKaisaiBashoJoho> businessList = new ArrayList<>();
        DbT5592ShinsakaiKaisaiBashoJohoEntity entity = dac.selectByKey(
                介護認定審査会開催場所コード);
        if (entity == null) {
            return null;
        }
        businessList.add(new ShinsakaiKaisaiBashoJoho(entity));
        entity.initializeMd5();
        return SearchResult.of(businessList, businessList.size(), true);
    }

    /**
     * 介護認定審査会開催場所情報を全件返します。
     *
     * @return ShinsakaiKaisaiBashoJohoの{@code list}
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiBashoJoho> get介護認定審査会開催場所情報一覧() {
        List<ShinsakaiKaisaiBashoJoho> businessList = new ArrayList<>();
        for (DbT5592ShinsakaiKaisaiBashoJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiKaisaiBashoJoho(entity));
        }

        return SearchResult.of(businessList, businessList.size(), true);
    }

    /**
     * 介護認定審査会開催場所情報一覧情報を取得します。
     *
     * @param param 合議体情報を特定するためのMyBatis用パラメータクラスです。
     * @return ShinsakaiKaisaiBashoJohoの{@code list}
     */
    @Transaction
    public SearchResult<ShinsakaiKaisaiBashoJoho> get介護認定審査会開催場所情報一覧(GogitaiJohoMapperParameter param) {
        List<ShinsakaiKaisaiBashoJoho> businessList = new ArrayList<>();
        IDbT5592ShinsakaiKaisaiBashoJohoMapper iDbT5592Mapper 
                = mapperProvider.create(IDbT5592ShinsakaiKaisaiBashoJohoMapper.class);
        List<DbT5592ShinsakaiKaisaiBashoJohoEntity> dbT5592EntityList = iDbT5592Mapper.getYiChiRanEntity(param);
        for (DbT5592ShinsakaiKaisaiBashoJohoEntity entity : dbT5592EntityList) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiKaisaiBashoJoho(entity));
        }
        return SearchResult.of(businessList, businessList.size(), true);
    }
    
     /**
     * 介護認定審査会開催場所情報{@link ShinsakaiKaisaiBashoJoho}を更新します。
     *
     * @param 介護認定審査会開催場所情報 {@link ShinsakaiKaisaiBashoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean 介護認定審査会開催場所情報の更新(ShinsakaiKaisaiBashoJoho 介護認定審査会開催場所情報) {
        requireNonNull(介護認定審査会開催場所情報, 
                UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所情報"));
        if (!介護認定審査会開催場所情報.hasChanged()) {
            return false;
        }
        DbT5592ShinsakaiKaisaiBashoJohoEntity dbT5592Entity = 介護認定審査会開催場所情報.toEntity();
        dbT5592Entity.setState(EntityDataState.Modified);
        return 1 == dac.save(dbT5592Entity);
    }
    
     /**
     * 介護認定審査会開催場所情報{@link ShinsakaiKaisaiBashoJoho}を追加します。
     *
     * @param 介護認定審査会開催場所情報 {@link ShinsakaiKaisaiBashoJoho}
     * @return 追加件数 追加結果の件数を返します。
     */
    @Transaction
    public boolean 介護認定審査会開催場所情報の追加(ShinsakaiKaisaiBashoJoho 介護認定審査会開催場所情報) {
        requireNonNull(介護認定審査会開催場所情報, 
                UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所情報"));
        if (!介護認定審査会開催場所情報.hasChanged()) {
            return false;
        }
        DbT5592ShinsakaiKaisaiBashoJohoEntity dbT5592Entity = 介護認定審査会開催場所情報.toEntity();
        dbT5592Entity.setState(EntityDataState.Added);
        return 1 == dac.save(dbT5592Entity);
    }
    
     /**
     * 介護認定審査会開催場所情報{@link ShinsakaiKaisaiBashoJoho}を削除します。
     *
     * @param 介護認定審査会開催場所情報 {@link ShinsakaiKaisaiBashoJoho}
     * @return 削除件数 削除結果の件数を返します。
     */
    @Transaction
    public boolean 介護認定審査会開催場所情報の削除(ShinsakaiKaisaiBashoJoho 介護認定審査会開催場所情報) {
        requireNonNull(介護認定審査会開催場所情報, 
                UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所情報"));
        DbT5592ShinsakaiKaisaiBashoJohoEntity dbT5592Entity = 介護認定審査会開催場所情報.toEntity();
        dbT5592Entity.setState(EntityDataState.Deleted);
        return 1 == dac.save(dbT5592Entity);
    }
    
    /**
     * 介護認定審査会開催場所情報{@link ShinsakaiKaisaiBashoJoho}を保存します。
     *
     * @param 介護認定審査会開催場所情報 {@link ShinsakaiKaisaiBashoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会開催場所情報(ShinsakaiKaisaiBashoJoho 介護認定審査会開催場所情報) {
        requireNonNull(介護認定審査会開催場所情報, 
                UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所情報"));
        if (!介護認定審査会開催場所情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会開催場所情報.toEntity());
    }
}
