/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ninteishinseijoho.NinteiShinseiJoho2;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho2;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaiwariatejoho.ShinsakaiWariateJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.taishouwaritsuke.ShinsakaiOrderKakuteiFlagMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiwariatejoho.IShinsakaiWariateJohoMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.util.MapperProvider;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShinsakaiWariateJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5502ShinsakaiWariateJohoDac dac;
    private final NinteiShinseiJohoManager 要介護認定申請情報Manager;

    /**
     * コンストラクタです。
     */
    ShinsakaiWariateJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
        this.要介護認定申請情報Manager = new NinteiShinseiJohoManager();
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護認定審査会割当情報Dac 介護認定審査会割当情報Dac
     * @param 要介護認定申請情報Manager 要介護認定申請情報Manager
     * @param dac {@link DbT5502ShinsakaiWariateJohoDac}
     */
    ShinsakaiWariateJohoManager(
            MapperProvider mapperProvider,
            DbT5502ShinsakaiWariateJohoDac dac,
            NinteiShinseiJohoManager 要介護認定申請情報Manager) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
        this.要介護認定申請情報Manager = 要介護認定申請情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiWariateJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiWariateJohoManager}のインスタンス
     */
    public static ShinsakaiWariateJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiWariateJohoManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会割当情報を返します。
     *
     * @param 介護認定審査会割当情報検索条件 介護認定審査会割当情報検索条件
     * @return ShinsakaiWariateJoho
     */
    @Transaction
    public ShinsakaiWariateJoho2 get介護認定審査会割当情報(ShinsakaiWariateJohoMapperParameter 介護認定審査会割当情報検索条件) {
        requireNonNull(介護認定審査会割当情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報検索条件"));
        IShinsakaiWariateJohoMapper mapper = mapperProvider.create(IShinsakaiWariateJohoMapper.class);

        ShinsakaiWariateJohoRelateEntity relateEntity = mapper.select介護認定審査会割当情報ByKey(介護認定審査会割当情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiWariateJoho2(relateEntity);
    }

    /**
     * 主キーに合致する介護認定審査会割当情報を返します。
     *
     * @param 介護認定審査会割当情報検索条件 介護認定審査会割当情報検索条件
     * @return ShinsakaiWariateJoho
     */
    @Transaction
    public ShinsakaiWariateJoho2 get介護認定審査会割当情報by主キー_審査順確定フラグ非一致(ShinsakaiOrderKakuteiFlagMapperParameter 介護認定審査会割当情報検索条件) {
        requireNonNull(介護認定審査会割当情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報検索条件"));
        IShinsakaiWariateJohoMapper mapper = mapperProvider.create(IShinsakaiWariateJohoMapper.class);

        ShinsakaiWariateJohoRelateEntity relateEntity = mapper.select介護認定審査会割当情報ByKey_審査順確定フラグ非一致(介護認定審査会割当情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiWariateJoho2(relateEntity);
    }

    /**
     * 介護認定審査会割当情報{@link ShinsakaiWariateJoho}を保存します。
     *
     * @param 介護認定審査会割当情報 {@link ShinsakaiWariateJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会割当情報(ShinsakaiWariateJoho2 介護認定審査会割当情報) {
        requireNonNull(介護認定審査会割当情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報"));
        if (!介護認定審査会割当情報.hasChanged()) {
            return false;
        }
        save要介護認定申請情報リスト(介護認定審査会割当情報.getNinteiShinseiJoho2List());
        return 1 == dac.save(介護認定審査会割当情報.toEntity());
    }

    /**
     * 介護認定審査会割当情報{@link ShinsakaiWariateJoho}を保存します。
     *
     * @param 介護認定審査会割当情報 {@link ShinsakaiWariateJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveOrDeletePhysicalBy介護認定審査会割当情報(ShinsakaiWariateJoho2 介護認定審査会割当情報) {
        requireNonNull(介護認定審査会割当情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報"));
        if (!介護認定審査会割当情報.hasChanged()) {
            return false;
        }
        save要介護認定申請情報リスト(介護認定審査会割当情報.getNinteiShinseiJoho2List());
        return 1 == dac.saveOrDeletePhysicalBy(介護認定審査会割当情報.toEntity());
    }

    private void save要介護認定申請情報リスト(List<NinteiShinseiJoho2> 要介護認定申請情報List) {
        for (NinteiShinseiJoho2 要介護認定申請情報 : 要介護認定申請情報List) {
            要介護認定申請情報Manager.save要介護認定申請情報(要介護認定申請情報);
        }
    }
}
