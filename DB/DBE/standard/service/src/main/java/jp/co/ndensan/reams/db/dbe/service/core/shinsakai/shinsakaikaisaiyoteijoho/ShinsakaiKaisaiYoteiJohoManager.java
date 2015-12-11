/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoMapperParameter;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5111ShinsakaiOnseiJoho.shinsakaiKaisaiNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5511ShinsakaiKaisaiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikaisaiyoteijoho.IShinsakaiKaisaiYoteiJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催予定情報を管理するクラスです。
 */
public class ShinsakaiKaisaiYoteiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5501ShinsakaiKaisaiYoteiJohoDac 介護認定審査会開催予定情報Dac;
    private final ShinsakaiKaisaiKekkaJohoManager 介護認定審査会開催結果情報Manager;
    private final ShinsakaiOnseiJohoManager 介護認定審査会音声情報Manager;
    private final ShinsakaiWariateIinJohoManager 介護認定審査会割当委員情報Manager;
    private final ShinsakaiWariateJohoManager 介護認定審査会割当情報Manager;

    /**
     * コンストラクタです。
     */
    ShinsakaiKaisaiYoteiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護認定審査会開催予定情報Dac = InstanceProvider.create(DbT5501ShinsakaiKaisaiYoteiJohoDac.class);
        this.介護認定審査会開催結果情報Manager = new ShinsakaiKaisaiKekkaJohoManager();
        this.介護認定審査会音声情報Manager = new ShinsakaiOnseiJohoManager();
        this.介護認定審査会割当委員情報Manager = ShinsakaiWariateIinJohoManager.createInstance();
        this.介護認定審査会割当情報Manager = ShinsakaiWariateJohoManager.createInstance();

    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護認定審査会開催予定情報Dac 介護認定審査会開催予定情報Dac
     * @param 介護認定審査会開催結果情報Manager 介護認定審査会開催結果情報Manager
     * @param 介護認定審査会音声情報Manager 介護認定審査会音声情報Manager
     * @param 介護認定審査会割当委員情報Manager 介護認定審査会割当委員情報Manager
     * @param 介護認定審査会割当情報Manager 介護認定審査会割当情報Manager
     */
    ShinsakaiKaisaiYoteiJohoManager(
            MapperProvider mapperProvider,
            DbT5501ShinsakaiKaisaiYoteiJohoDac 介護認定審査会開催予定情報Dac,
            ShinsakaiKaisaiKekkaJohoManager 介護認定審査会開催結果情報Manager,
            ShinsakaiOnseiJohoManager 介護認定審査会音声情報Manager,
            ShinsakaiWariateIinJohoManager 介護認定審査会割当委員情報Manager,
            ShinsakaiWariateJohoManager 介護認定審査会割当情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護認定審査会開催予定情報Dac = 介護認定審査会開催予定情報Dac;
        this.介護認定審査会開催結果情報Manager = 介護認定審査会開催結果情報Manager;
        this.介護認定審査会音声情報Manager = 介護認定審査会音声情報Manager;
        this.介護認定審査会割当委員情報Manager = 介護認定審査会割当委員情報Manager;
        this.介護認定審査会割当情報Manager = 介護認定審査会割当情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiJohoManager}のインスタンス
     */
    public static ShinsakaiKaisaiYoteiJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiYoteiJohoManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会開催予定情報を返します。
     *
     * @param 介護認定審査会開催予定情報検索条件 介護認定審査会開催予定情報検索条件
     * @return ShinsakaiKaisaiYoteiJoho nullが返る可能性があります。
     */
    @Transaction
    public ShinsakaiKaisaiYoteiJoho get介護認定審査会開催予定情報(ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件) {
        requireNonNull(介護認定審査会開催予定情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報検索条件"));
        IShinsakaiKaisaiYoteiJohoMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiJohoMapper.class);

        ShinsakaiKaisaiYoteiJohoRelateEntity relateEntity = mapper.getShinsakaiKaisaiYoteiJohoEntity(介護認定審査会開催予定情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiKaisaiYoteiJoho(relateEntity);
    }

    /**
     * 介護認定審査会開催予定情報{@link ShinsakaiKaisaiYoteiJoho}を保存します。
     *
     * @param 介護認定審査会開催予定情報 介護認定審査会開催予定情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報) {
        requireNonNull(介護認定審査会開催予定情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報"));

        if (!介護認定審査会開催予定情報.hasChanged()) {
            return false;
        }
        介護認定審査会開催予定情報 = 介護認定審査会開催予定情報.modifiedModel();
        save介護認定審査会開催結果情報リスト(介護認定審査会開催予定情報.getShinsakaiKaisaiKekkaJohoList());
        save介護認定審査会音声情報リスト(介護認定審査会開催予定情報.getShinsakaiOnseiJohoList());
        save介護認定審査会割当委員情報リスト(介護認定審査会開催予定情報.getShinsakaiWariateIinJohoList());
        save介護認定審査会割当情報リスト(介護認定審査会開催予定情報.getShinsakaiWariateJohoList());
        return 1 == 介護認定審査会開催予定情報Dac.save(介護認定審査会開催予定情報.toEntity());
    }

    private void save介護認定審査会開催結果情報リスト(List<ShinsakaiKaisaiKekkaJoho> 介護認定審査会開催結果情報List) {
        for (ShinsakaiKaisaiKekkaJoho 介護認定審査会開催結果情報 : 介護認定審査会開催結果情報List) {
            介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(介護認定審査会開催結果情報);
        }
    }

    private void save介護認定審査会音声情報リスト(List<ShinsakaiOnseiJoho> 介護認定審査会音声情報List) {
        for (ShinsakaiOnseiJoho 介護認定審査会音声情報 : 介護認定審査会音声情報List) {
            介護認定審査会音声情報Manager.save介護認定審査会音声情報(介護認定審査会音声情報);
        }
    }

    private void save介護認定審査会割当委員情報リスト(List<ShinsakaiWariateIinJoho> 介護認定審査会割当委員情報List) {
        for (ShinsakaiWariateIinJoho 介護認定審査会割当委員情報 : 介護認定審査会割当委員情報List) {
            介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(介護認定審査会割当委員情報);
        }
    }

    private void save介護認定審査会割当情報リスト(List<ShinsakaiWariateJoho> 介護認定審査会割当情報List) {
        for (ShinsakaiWariateJoho 介護認定審査会割当情報 : 介護認定審査会割当情報List) {
            介護認定審査会割当情報Manager.save介護認定審査会割当情報(介護認定審査会割当情報);
        }
    }

    /**
     *
     * ヘッドエリア内容を取得する
     *
     * @param 介護認定審査会開催予定情報検索条件
     * @return relateEntity
     */
    @Transaction
    public ShinsakaiKaisaiYoteiJoho getヘッドエリア内容検索(ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件) {
        requireNonNull(介護認定審査会開催予定情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報検索条件"));
        IShinsakaiKaisaiYoteiJohoMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiJohoMapper.class);

        ShinsakaiKaisaiYoteiJohoRelateEntity relateEntity = mapper.getShinsakaiKaisaiYoteiJohoEntity(介護認定審査会開催予定情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiKaisaiYoteiJoho(relateEntity);
    }

    /**
     * 審査会委員一覧検索を取得する
     *
     * @param 介護認定審査会開催予定情報検索条件
     * @return businessList
     */
    @Transaction
    public List<ShinsakaiKaisaiYoteiJoho> get審査会委員一覧検索(ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件) {
        requireNonNull(介護認定審査会開催予定情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報検索条件"));
        IShinsakaiKaisaiYoteiJohoMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiJohoMapper.class);
        List<ShinsakaiKaisaiYoteiJoho> businessList = new ArrayList<>();
        ShinsakaiKaisaiYoteiJohoRelateEntity relateEntity = mapper.getShinsakaiWariateIinJohoEntity(介護認定審査会開催予定情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return businessList;
    }

    /**
     * 護認定審査会音声情報更新処理
     *
     * @param 開催番号
     * @return
     */
    @Transaction
    public boolean insert介護認定審査会音声情報(ShinsakaiOnseiJoho 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        if (!開催番号.hasChanged()) {
            return false;
        }
        //int i = dac.save(調査員);DbT5512ShinsakaiOnseiJohoDac
        return false;
    }

    /**
     * 介護認定審査会開催予定情報更新
     *
     * @param shinsakaiKaisaiNo 開催番号
     * @return entity
     */
    @Transaction
    public int update介護認定審査会開催予定情報更新(ShinsakaiKaisaiYoteiJohoMapperParameter shinsakaiKaisaiNo) {
        requireNonNull(shinsakaiKaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("shinsakaiKaisaiNo"));
        DbT5501ShinsakaiKaisaiYoteiJohoEntity ShinsakaiKaisaiYoteiJohoEntity = new DbT5501ShinsakaiKaisaiYoteiJohoEntity();
        int entity = 介護認定審査会開催予定情報Dac.save(ShinsakaiKaisaiYoteiJohoEntity);
        return entity;
    }

    /**
     * 介護認定審査会開催結果情報更新
     *
     * @param 開催番号
     * @return
     */
    @Transaction
    public boolean update介護認定審査会開催結果情報更新(ShinsakaiKaisaiKekkaJoho 開催番号) {
        requireNonNull(shinsakaiKaisaiNo, UrSystemErrorMessages.値がnull.getReplacedMessage("shinsakaiKaisaiNo"));
        DbT5511ShinsakaiKaisaiKekkaJohoEntity shinsakaiKaisaiKekkaJohoEntity = new DbT5511ShinsakaiKaisaiKekkaJohoEntity();
        // int entity = 介護認定審査会開催結果情報Dac.save(shinsakaiKaisaiKekkaJohoEntity);
        // int i = dac.save(調査員);DbT5511ShinsakaiKaisaiKekkaJohoDac
        return false;//entity;//1 == dac.save(entity.toEntity());
    }

    /**
     * 介護認定審査会割当委員情報更新
     *
     * @param 開催番号
     * @return
     */
    @Transaction
    public DbT5503ShinsakaiWariateIinJohoEntity update介護認定審査会割当委員情報更新(ShinsakaiWariateIinJohoMapperParameter 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        DbT5503ShinsakaiWariateIinJohoEntity ShinsakaiKaisaiYoteiJohoEntity = new DbT5503ShinsakaiWariateIinJohoEntity();
//        if (ShinsakaiKaisaiYoteiJohoEntity == 0) {
//        }
        return ShinsakaiKaisaiYoteiJohoEntity;
    }

    /**
     * 介護認定審査会割当委員情報を物理削除する
     *
     * @param 開催番号
     * @return
     */
    @Transaction
    public boolean delete介護認定審査会割当委員情報(ShinsakaiWariateIinJohoMapperParameter 開催番号) {
        requireNonNull(開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("開催番号"));
        // DbT5503ShinsakaiWariateIinJohoEntity ShinsakaiKaisaiYoteiJohoEntity = new DbT5503ShinsakaiWariateIinJohoEntity();
//        if (!開催番号.hasChanged()) {
//            return false;
//        }
        return false;//1 == 介護認定審査会割当委員情報Dac.save(開催番号.toEntity());
    }
}
