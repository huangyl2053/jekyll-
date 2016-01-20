/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariateiinjoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5503ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiwariateiinjoho.IShinsakaiWariateIinJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当委員情報を管理するクラスです。
 */
public class ShinsakaiWariateIinJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5503ShinsakaiWariateIinJohoDac dac;
    private final ShinsakaiIinJohoManager 介護認定審査会委員情報Manager;

    /**
     * コンストラクタです。
     */
    ShinsakaiWariateIinJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        dac = InstanceProvider.create(DbT5503ShinsakaiWariateIinJohoDac.class);
        this.介護認定審査会委員情報Manager = new ShinsakaiIinJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param dac DbT5503ShinsakaiWariateIinJohoDac
     * @param 介護認定審査会委員情報Manager 介護認定審査会委員情報Manager
     */
    ShinsakaiWariateIinJohoManager(
            MapperProvider mapperProvider,
            DbT5503ShinsakaiWariateIinJohoDac dac,
            ShinsakaiIinJohoManager 介護認定審査会委員情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.dac = dac;
        this.介護認定審査会委員情報Manager = 介護認定審査会委員情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiWariateIinJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiWariateIinJohoManager}のインスタンス
     */
    public static ShinsakaiWariateIinJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiWariateIinJohoManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会割当委員情報を返します。
     *
     * @param 介護認定審査会割当委員情報検索条件 介護認定審査会割当委員情報検索条件
     * @return ShinsakaiWariateIinJoho
     */
    @Transaction
    public ShinsakaiWariateIinJoho get介護認定審査会割当委員情報(ShinsakaiWariateIinJohoMapperParameter 介護認定審査会割当委員情報検索条件) {
        requireNonNull(介護認定審査会割当委員情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報検索条件"));
        IShinsakaiWariateIinJohoMapper mapper = mapperProvider.create(IShinsakaiWariateIinJohoMapper.class);

        ShinsakaiWariateIinJohoRelateEntity relateEntity = mapper.select介護認定審査会割当委員情報ByKey(介護認定審査会割当委員情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiWariateIinJoho(relateEntity);
    }

    /**
     * 介護認定審査会割当委員情報{@link ShinsakaiWariateIinJoho}を保存します。
     *
     * @param 介護認定審査会割当委員情報 {@link ShinsakaiWariateIinJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会割当委員情報(ShinsakaiWariateIinJoho 介護認定審査会割当委員情報) {
        requireNonNull(介護認定審査会割当委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報"));
        if (!介護認定審査会割当委員情報.hasChanged()) {
            return false;
        }
        save介護認定審査会委員情報リスト(介護認定審査会割当委員情報.getShinsakaiIinJohoList());
        return 1 == dac.save(介護認定審査会割当委員情報.toEntity());
    }

    private void save介護認定審査会委員情報リスト(List<ShinsakaiIinJoho> 介護認定審査会委員情報List) {
        for (ShinsakaiIinJoho 介護認定審査会委員情報 : 介護認定審査会委員情報List) {
            介護認定審査会委員情報Manager.save介護認定審査会委員情報(介護認定審査会委員情報);
        }
    }

    /**
     * 介護認定審査会割当委員情報{@link GogitaiJoho}を物理削除します。
     *
     * @param 介護認定審査会割当委員情報 介護認定審査会委員情報
     * @return 削除あり:true、削除なし:false <br>
     * いずれかのテーブルに削除があればtrueを返す
     */
    @Transaction
    public boolean deletePhysical(ShinsakaiWariateIinJoho 介護認定審査会割当委員情報) {
        requireNonNull(介護認定審査会割当委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報"));
        return 1 == dac.deletePhysical(介護認定審査会割当委員情報.toEntity());
    }

}
