/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fukajoho.fukajoho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.kibetsu.Kibetsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.HeinjunkaAfterParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.fukajoho.FukaJohoRelateMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.fuka.IFukaJohoRelateMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.fukajoho.kibetsu.KibetsuManager;
import jp.co.ndensan.reams.db.dbx.business.core.fuka.Fuka;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2002FukaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課の情報を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 xicongwang
 */
public class FukaJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT2002FukaDac 介護賦課Dac;
    private final KibetsuManager 介護期別Manager;

    /**
     * コンストラクタです。
     */
    FukaJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護賦課Dac = InstanceProvider.create(DbT2002FukaDac.class);
        this.介護期別Manager = KibetsuManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護賦課Dac 介護賦課Dac
     * @param 介護期別Manager 介護期別Manager
     */
    FukaJohoManager(
            MapperProvider mapperProvider,
            DbT2002FukaDac 介護賦課Dac,
            KibetsuManager 介護期別Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護賦課Dac = 介護賦課Dac;
        this.介護期別Manager = 介護期別Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link FukaJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link FukaJohoManager}のインスタンス
     */
    public static FukaJohoManager createInstance() {
        return InstanceProvider.create(FukaJohoManager.class);
    }

    /**
     * 主キーに合致する賦課の情報を返します。
     *
     * @param 賦課の情報検索条件 FukaJohoRelateMapperParameter
     * @return FukaJoho nullが返る可能性があります。
     */
    @Transaction
    public FukaJoho get賦課の情報(FukaJohoRelateMapperParameter 賦課の情報検索条件) {
        requireNonNull(賦課の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課の情報検索条件"));
        IFukaJohoRelateMapper mapper = mapperProvider.create(IFukaJohoRelateMapper.class);

        FukaJohoRelateEntity relateEntity = mapper.select賦課の情報ByKey(賦課の情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new FukaJoho(relateEntity);
    }

    /**
     * 主キーに合致する最新賦課の情報を返します。
     *
     * @param 賦課の情報検索条件 FukaJohoRelateMapperParameter
     * @return FukaJoho nullが返る可能性があります。
     */
    @Transaction
    public List<FukaJoho> get最新の賦課情報(FukaJohoRelateMapperParameter 賦課の情報検索条件) {
        requireNonNull(賦課の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課の情報検索条件"));
        IFukaJohoRelateMapper mapper = mapperProvider.create(IFukaJohoRelateMapper.class);
        List<FukaJohoRelateEntity> relateEntityList = mapper.select最新賦課の情報ByKey(賦課の情報検索条件);
        if (relateEntityList == null || relateEntityList.isEmpty()) {
            return null;
        }
        List<FukaJoho> 最新の賦課情報List = new ArrayList<>();
        for (FukaJohoRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            最新の賦課情報List.add(new FukaJoho(relateEntity));
        }
        return 最新の賦課情報List;
    }

    /**
     * 主キーに合致する賦課の情報を返します。
     *
     * @param parameter 賦課の情報検索条件
     * @return FukaJoho nullが返る可能性があります。
     */
    @Transaction
    public FukaJoho get前年度賦課の情報(Map<String, Object> parameter) {
        IFukaJohoRelateMapper mapper = mapperProvider.create(IFukaJohoRelateMapper.class);

        FukaJohoRelateEntity relateEntity = mapper.select前年度賦課の情報ByKey(parameter);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new FukaJoho(relateEntity);
    }

    /**
     * 合致する賦課の情報を返します。
     *
     * @param parameter 賦課の情報検索条件
     * @return FukaJoho nullが返る可能性があります。
     */
    @Transaction
    public List<FukaJoho> get賦課の情報(Map<String, Object> parameter) {
        IFukaJohoRelateMapper mapper = mapperProvider.create(IFukaJohoRelateMapper.class);

        List<FukaJohoRelateEntity> relateEntityList = mapper.get賦課の情報(parameter);
        if (relateEntityList == null) {
            return null;
        }
        List<FukaJoho> fukajohoList = new ArrayList<>();
        for (FukaJohoRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            fukajohoList.add(new FukaJoho(relateEntity));
        }
        return fukajohoList;
    }

    /**
     * 介護賦課{@link Fuka}を保存します。
     *
     * @param 介護賦課 介護賦課
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(FukaJoho 介護賦課) {
        requireNonNull(介護賦課, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課"));

        if (!介護賦課.hasChanged()) {
            return false;
        }
        介護賦課 = 介護賦課.modifiedModel();
        save介護期別リスト(介護賦課.getKibetsuList());
        return 1 == 介護賦課Dac.save(介護賦課.toEntity());
    }

    private void save介護期別リスト(List<Kibetsu> 介護期別List) {
        for (Kibetsu 介護期別 : 介護期別List) {
            介護期別Manager.save介護期別(介護期別);
        }
    }

    /**
     * 平準化後の賦課の情報_画面を取得します。
     *
     * @param parameter 賦課の情報検索条件
     * @return List<FukaJoho> nullが返る可能性があります。
     */
    @Transaction
    public List<FukaJoho> get平準化後の賦課の情報_画面(HeinjunkaAfterParameter parameter) {
        IFukaJohoRelateMapper mapper = mapperProvider.create(IFukaJohoRelateMapper.class);

        List<FukaJohoRelateEntity> relateEntityList = mapper.get平準化後の賦課の情報_画面(parameter);
        if (relateEntityList == null) {
            return null;
        }
        List<FukaJoho> fukajohoList = new ArrayList<>();
        for (FukaJohoRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            fukajohoList.add(new FukaJoho(relateEntity));
        }
        return fukajohoList;
    }

    /**
     * 平準化後の賦課の情報を取得します。
     *
     * @param parameter 賦課の情報検索条件
     * @return List<FukaJoho> nullが返る可能性があります。
     */
    @Transaction
    public List<FukaJoho> get平準化後の賦課の情報(HeinjunkaAfterParameter parameter) {
        IFukaJohoRelateMapper mapper = mapperProvider.create(IFukaJohoRelateMapper.class);

        List<FukaJohoRelateEntity> relateEntityList = mapper.get平準化後の賦課の情報(parameter);
        if (relateEntityList == null) {
            return null;
        }
        List<FukaJoho> fukajohoList = new ArrayList<>();
        for (FukaJohoRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            fukajohoList.add(new FukaJoho(relateEntity));
        }
        return fukajohoList;

    }

    /**
     * 主キーに合致する履歴番号最大の賦課の情報を返します。
     *
     * @param 賦課の情報検索条件 FukaJohoRelateMapperParameter
     * @return FukaJoho nullが返る可能性があります。
     */
    @Transaction
    public List<FukaJoho> get履歴番号最大の賦課の情報(FukaJohoRelateMapperParameter 賦課の情報検索条件) {
        requireNonNull(賦課の情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課の情報検索条件"));
        IFukaJohoRelateMapper mapper = mapperProvider.create(IFukaJohoRelateMapper.class);

        List<FukaJohoRelateEntity> relateEntityList = mapper.select履歴番号最大の賦課の情報(賦課の情報検索条件);
        if (relateEntityList == null || relateEntityList.isEmpty()) {
            return null;
        }
        List<FukaJoho> 履歴番号最大の賦課の情報List = new ArrayList<>();
        for (FukaJohoRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            履歴番号最大の賦課の情報List.add(new FukaJoho(relateEntity));
        }
        return 履歴番号最大の賦課の情報List;
    }
}
