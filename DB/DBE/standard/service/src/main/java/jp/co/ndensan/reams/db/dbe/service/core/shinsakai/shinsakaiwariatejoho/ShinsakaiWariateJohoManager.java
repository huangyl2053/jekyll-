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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

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
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiWariateJohoManager}のインスタンス
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
     * 条件に合致する審査会割当データが存在するか否かを返します。
     *
     * @param 管理番号 ShinseishoKanriNo 管理番号
     * @return boolean
     */
    @Transaction
    public boolean get審査会割当データ(ShinseishoKanriNo 管理番号) {
        ShinsakaiWariateJohoMapperParameter 介護認定審査会割当情報検索条件 = ShinsakaiWariateJohoMapperParameter.createSelectByKeyParam(管理番号);
        requireNonNull(介護認定審査会割当情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報検索条件"));
        IShinsakaiWariateJohoMapper mapper = mapperProvider.create(IShinsakaiWariateJohoMapper.class);

        List<ShinsakaiWariateJohoRelateEntity> relateEntity = mapper.select審査会割当データ(介護認定審査会割当情報検索条件);
        if (relateEntity == null || relateEntity.isEmpty()) {
            return false;
        }
        for (ShinsakaiWariateJohoRelateEntity entity : relateEntity) {
            if ((entity.get介護認定審査会割当情報Entity().getHanteiKekkaCode() == null)
                    || entity.get介護認定審査会割当情報Entity().getHanteiKekkaCode().getKey().isEmpty()) {
                return true;
            }
        }

        DbT5105NinteiKanryoJohoEntity 要介護認定完了情報 = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class).selectByKey(介護認定審査会割当情報検索条件.getShinseishoKanriNo());
        if (要介護認定完了情報 == null) {
            return false;
        }
        if (要介護認定完了情報.getNinteiShinsakaiWariateKanryoYMD() != null) {
            if (!要介護認定完了情報.getNinteiShinsakaiWariateKanryoYMD().isEmpty()) {
                return true;
            }
        }
        return false;
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
        return 1 == dac.saveOrDeletePhysicalBy(介護認定審査会割当情報.toEntity());
    }

    private void save要介護認定申請情報リスト(List<NinteiShinseiJoho2> 要介護認定申請情報List) {
        for (NinteiShinseiJoho2 要介護認定申請情報 : 要介護認定申請情報List) {
            要介護認定申請情報Manager.save要介護認定申請情報(要介護認定申請情報);
        }
    }
}
