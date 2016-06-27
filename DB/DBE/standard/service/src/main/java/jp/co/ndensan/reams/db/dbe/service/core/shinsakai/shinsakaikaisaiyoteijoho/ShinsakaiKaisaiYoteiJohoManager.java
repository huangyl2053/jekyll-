/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaiyoteijoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikaisaiyoteijoho.IShinsakaiKaisaiYoteiJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaikaisaikekkajoho.ShinsakaiKaisaiKekkaJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaionseijoho.ShinsakaiOnseiJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催予定情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
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
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiKaisaiYoteiJohoManager}のインスタンス
     */
    public static ShinsakaiKaisaiYoteiJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiKaisaiYoteiJohoManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会開催予定情報を返します。
     *
     * @param 介護認定審査会開催予定情報検索条件 介護認定審査会開催予定情報検索条件
     * @return ShinsakaiKaisaiYoteiJoho2 nullが返る可能性があります。
     */
    @Transaction
    public ShinsakaiKaisaiYoteiJoho2 get介護認定審査会開催予定情報(ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件) {
        requireNonNull(介護認定審査会開催予定情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報検索条件"));
        IShinsakaiKaisaiYoteiJohoMapper mapper = mapperProvider.create(IShinsakaiKaisaiYoteiJohoMapper.class);

        ShinsakaiKaisaiYoteiJohoRelateEntity relateEntity = mapper.getShinsakaiKaisaiYoteiJohoEntity(介護認定審査会開催予定情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiKaisaiYoteiJoho2(relateEntity);
    }

    /**
     * 介護認定審査会開催予定情報{@link ShinsakaiKaisaiYoteiJoho2}を保存します。
     *
     * @param 介護認定審査会開催予定情報 介護認定審査会開催予定情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShinsakaiKaisaiYoteiJoho2 介護認定審査会開催予定情報) {
        requireNonNull(介護認定審査会開催予定情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報"));

        if (!介護認定審査会開催予定情報.hasChanged()) {
            return false;
        }
        介護認定審査会開催予定情報 = 介護認定審査会開催予定情報.modifiedModel();
        save介護認定審査会開催結果情報リスト(介護認定審査会開催予定情報.getShinsakaiKaisaiKekkaJohoList());
        save介護認定審査会音声情報リスト(介護認定審査会開催予定情報.getShinsakaiOnseiJohoList());
        save介護認定審査会割当委員情報リスト(介護認定審査会開催予定情報.getShinsakaiWariateIinJoho2List());
        save介護認定審査会割当情報リスト(介護認定審査会開催予定情報.getShinsakaiWariateJoho2List());
        return 1 == 介護認定審査会開催予定情報Dac.save(介護認定審査会開催予定情報.toEntity());
    }

    /**
     * 介護認定審査会開催予定情報{@link ShinsakaiKaisaiYoteiJoho2}を保存します。
     *
     * @param 介護認定審査会開催予定情報 介護認定審査会開催予定情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean updateBy開催無(ShinsakaiKaisaiYoteiJoho2 介護認定審査会開催予定情報) {
        requireNonNull(介護認定審査会開催予定情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報"));

        if (!介護認定審査会開催予定情報.hasChanged()) {
            return false;
        }
        介護認定審査会開催予定情報 = 介護認定審査会開催予定情報.modifiedModel();
        save介護認定審査会開催結果情報リスト(介護認定審査会開催予定情報.getShinsakaiKaisaiKekkaJohoList());
        save介護認定審査会音声情報リスト(介護認定審査会開催予定情報.getShinsakaiOnseiJohoList());
        updateOrDelete介護認定審査会割当委員情報リスト(介護認定審査会開催予定情報.getShinsakaiWariateIinJoho2List());
        return 1 == 介護認定審査会開催予定情報Dac.save(介護認定審査会開催予定情報.toEntity());
    }

    /**
     * 介護認定審査会開催予定情報{@link ShinsakaiKaisaiYoteiJoho2}を保存します。
     *
     * @param 介護認定審査会開催予定情報 介護認定審査会開催予定情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean updateBy開催(ShinsakaiKaisaiYoteiJoho2 介護認定審査会開催予定情報) {
        requireNonNull(介護認定審査会開催予定情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報"));

        if (!介護認定審査会開催予定情報.hasChanged()) {
            return false;
        }
        介護認定審査会開催予定情報 = 介護認定審査会開催予定情報.modifiedModel();
        save介護認定審査会開催結果情報リスト(介護認定審査会開催予定情報.getShinsakaiKaisaiKekkaJohoList());
        save介護認定審査会音声情報リスト(介護認定審査会開催予定情報.getShinsakaiOnseiJohoList());
        updateOrDelete介護認定審査会割当委員情報リスト(介護認定審査会開催予定情報.getShinsakaiWariateIinJoho2List());
        return true;
    }

    private void save介護認定審査会開催結果情報リスト(List<ShinsakaiKaisaiKekkaJoho2> 介護認定審査会開催結果情報List) {
        for (ShinsakaiKaisaiKekkaJoho2 介護認定審査会開催結果情報 : 介護認定審査会開催結果情報List) {
            介護認定審査会開催結果情報Manager.save介護認定審査会開催結果情報(介護認定審査会開催結果情報);
        }
    }

    private void save介護認定審査会音声情報リスト(List<ShinsakaiOnseiJoho2> 介護認定審査会音声情報List) {
        for (ShinsakaiOnseiJoho2 介護認定審査会音声情報 : 介護認定審査会音声情報List) {
            介護認定審査会音声情報Manager.save介護認定審査会音声情報(介護認定審査会音声情報);
        }
    }

    private void save介護認定審査会割当委員情報リスト(List<ShinsakaiWariateIinJoho2> 介護認定審査会割当委員情報List) {
        for (ShinsakaiWariateIinJoho2 介護認定審査会割当委員情報 : 介護認定審査会割当委員情報List) {
            介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(介護認定審査会割当委員情報);
        }
    }

    private void updateOrDelete介護認定審査会割当委員情報リスト(List<ShinsakaiWariateIinJoho2> 介護認定審査会割当委員情報List) {
        for (ShinsakaiWariateIinJoho2 介護認定審査会割当委員情報 : 介護認定審査会割当委員情報List) {
            if (介護認定審査会割当委員情報.toEntity().getState().equals(EntityDataState.Deleted)) {
                介護認定審査会割当委員情報Manager.deletePhysical(介護認定審査会割当委員情報);
                continue;
            }
            介護認定審査会割当委員情報Manager.save介護認定審査会割当委員情報(介護認定審査会割当委員情報);
        }
    }

    private void save介護認定審査会割当情報リスト(List<ShinsakaiWariateJoho2> 介護認定審査会割当情報List) {
        for (ShinsakaiWariateJoho2 介護認定審査会割当情報 : 介護認定審査会割当情報List) {
            介護認定審査会割当情報Manager.save介護認定審査会割当情報(介護認定審査会割当情報);
        }
    }
}
