/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic.shujiijoho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.shujiijoho.ShujiiMaster;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho.ShujiiMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho.ShujiiMasterSearchParameter;
import jp.co.ndensan.reams.db.dbe.entity.basic.shujiijoho.ShujiiMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.shujiijoho.IShujiiMasterJohoMapper;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医情報クラスです。
 *
 */
public class ShujiiMasterFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShujiiMasterFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param MapperProvider {@link mapperProvider}
     */
    ShujiiMasterFinder(MapperProvider mapperProvider) {
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiMasterFinder}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiMasterFinder}のインスタンス
     */
    public static ShujiiMasterFinder createInstance() {
        return InstanceProvider.create(ShujiiMasterFinder.class);
    }

    /**
     * 検索条件に従い、主治医情報を検索します。
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     * @return ShujiiMaster 主治医情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ShujiiMaster> getShujiiIchiranList(ShujiiMasterMapperParameter 主治医情報検索条件) {
        requireNonNull(主治医情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報検索条件"));
        IShujiiMasterJohoMapper mapper = mapperProvider.create(IShujiiMasterJohoMapper.class);
        List<ShujiiMasterRelateEntity> relateEntityList = mapper.selectShujiiIchiranList(主治医情報検索条件);
        if (relateEntityList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiMaster>emptyList(), 0, false);
        }
        List<ShujiiMaster> 主治医情報List = new ArrayList<>();
        for (ShujiiMasterRelateEntity entity : relateEntityList) {
            主治医情報List.add(new ShujiiMaster(entity));
        }
        return SearchResult.of(主治医情報List, 0, false);
    }

    /**
     * 検索条件に従い、主治医情報を検索します。
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     * @return NinteiChosainMaster 主治医情報 nullが返る可能性があります。
     */
    @Transaction
    public SearchResult<ShujiiJoho> getShujiiJohoList(ShujiiMasterMapperParameter 主治医情報検索条件) {
        List<ShujiiJoho> businessList = new ArrayList<>();
        IShujiiMasterJohoMapper mapper = mapperProvider.create(IShujiiMasterJohoMapper.class);
        List<DbT5912ShujiiJohoEntity> entityList = mapper.selectShujiiJohoList(主治医情報検索条件);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<ShujiiJoho>emptyList(), 0, false);
        }
        for (DbT5912ShujiiJohoEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new ShujiiJoho(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 検索条件に従い、主治医情報の件数を検索します。
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     * @return 主治医情報の件数
     */
    @Transaction
    public int getShujiiJohoCount(ShujiiMasterSearchParameter 主治医情報検索条件) {
        IShujiiMasterJohoMapper mapper = mapperProvider.create(IShujiiMasterJohoMapper.class);
        return mapper.selectShujiiJohoCount(主治医情報検索条件);
    }

    /**
     * 検索条件に従い、要介護認定申請情報件数検索処理。
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     * @return 要介護認定申請情報の件数
     */
    @Transaction
    public int getNinteiShinseiJohoCount(ShujiiMasterSearchParameter 主治医情報検索条件) {
        IShujiiMasterJohoMapper mapper = mapperProvider.create(IShujiiMasterJohoMapper.class);
        return mapper.selectNinteiShinseiJohoCount(主治医情報検索条件);
    }

    /**
     * 検索条件に従い、主治医意見書作成依頼情報件数検索処理
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     * @return 主治医意見書作成依頼情報の件数
     */
    @Transaction
    public int getIkenshoIraiJohoCount(ShujiiMasterSearchParameter 主治医情報検索条件) {
        IShujiiMasterJohoMapper mapper = mapperProvider.create(IShujiiMasterJohoMapper.class);
        return mapper.selectIkenshoIraiJohoCount(主治医情報検索条件);
    }

    /**
     * 検索条件に従い、主治医医療機関名検索します。
     *
     * @param 主治医情報検索条件 主治医情報検索条件
     * @return 主治医医療機関名
     */
    @Transaction
    public RString getShujiiIryoKikanJoho(ShujiiMasterSearchParameter 主治医情報検索条件) {
        IShujiiMasterJohoMapper mapper = mapperProvider.create(IShujiiMasterJohoMapper.class);
        return mapper.selectShujiiIryoKikanJoho(主治医情報検索条件);
    }
}
