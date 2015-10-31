/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.shinsakaiiinjoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJoho;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5594ShinsakaiIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho.IShinsakaiIinJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員情報を管理するクラスです。
 */
public class ShinsakaiIinJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5594ShinsakaiIinJohoDac 介護認定審査会委員情報Dac;
    private final KaigoNinteiShinsakaiIinShozokuKikanJohoManager 介護認定審査会委員所属機関情報Manager;

    /**
     * コンストラクタです。
     */
    ShinsakaiIinJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.介護認定審査会委員情報Dac = InstanceProvider.create(DbT5594ShinsakaiIinJohoDac.class);
        this.介護認定審査会委員所属機関情報Manager = new KaigoNinteiShinsakaiIinShozokuKikanJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護認定審査会委員情報Dac 介護認定審査会委員情報Dac
     * @param 介護認定審査会委員所属機関情報Manager 介護認定審査会委員所属機関情報Manager
     */
    ShinsakaiIinJohoManager(
            MapperProvider mapperProvider,
            DbT5594ShinsakaiIinJohoDac 介護認定審査会委員情報Dac,
            KaigoNinteiShinsakaiIinShozokuKikanJohoManager 介護認定審査会委員所属機関情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.介護認定審査会委員情報Dac = 介護認定審査会委員情報Dac;
        this.介護認定審査会委員所属機関情報Manager = 介護認定審査会委員所属機関情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShinsakaiIinJohoManager}のインスタンス
     */
    public static ShinsakaiIinJohoManager createInstance() {
        return InstanceProvider.create(ShinsakaiIinJohoManager.class);
    }

    /**
     * 主キーに合致する介護認定審査会委員情報を返します。
     *
     * @param 介護認定審査会委員情報検索条件 介護認定審査会委員情報検索条件
     * @return ShinsakaiIinJoho nullが返る可能性があります。
     */
    @Transaction
    public ShinsakaiIinJoho get介護認定審査会委員情報(ShinsakaiIinJohoMapperParameter 介護認定審査会委員情報検索条件) {
        requireNonNull(介護認定審査会委員情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報検索条件"));
        IShinsakaiIinJohoMapper mapper = mapperProvider.create(IShinsakaiIinJohoMapper.class);

        ShinsakaiIinJohoEntity relateEntity = mapper.getShinsakaiIinJohoEntity(介護認定審査会委員情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShinsakaiIinJoho(relateEntity);
    }

    /**
     * 介護認定審査会委員情報{@link ShinsakaiIinJoho}を保存します。
     *
     * @param 介護認定審査会委員情報 介護認定審査会委員情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShinsakaiIinJoho 介護認定審査会委員情報) {
        requireNonNull(介護認定審査会委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報"));

        if (!介護認定審査会委員情報.hasChanged()) {
            return false;
        }
        介護認定審査会委員情報 = 介護認定審査会委員情報.modifiedModel();
        save介護認定審査会委員所属機関情報リスト(介護認定審査会委員情報.getKaigoNinteiShinsakaiIinShozokuKikanJohoList());
        return 1 == 介護認定審査会委員情報Dac.save(介護認定審査会委員情報.toEntity());
    }

    private void save介護認定審査会委員所属機関情報リスト(List<KaigoNinteiShinsakaiIinShozokuKikanJoho> 介護認定審査会委員所属機関情報List) {
        for (KaigoNinteiShinsakaiIinShozokuKikanJoho 介護認定審査会委員所属機関情報 : 介護認定審査会委員所属機関情報List) {
            介護認定審査会委員所属機関情報Manager.save介護認定審査会委員所属機関情報(介護認定審査会委員所属機関情報);
        }
    }
}
