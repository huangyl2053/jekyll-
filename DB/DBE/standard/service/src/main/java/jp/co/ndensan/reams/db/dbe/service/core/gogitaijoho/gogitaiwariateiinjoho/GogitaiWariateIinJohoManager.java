/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaiwariateiinjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaiWariateIinJoho.GogitaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaiWariateIinJoho.GogitaiWariateIinJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5593GogitaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho.gogitaiWariateIinJoho.IGogitaiWariateIinJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体割当委員情報を管理するクラスです。
 */
public class GogitaiWariateIinJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5593GogitaiWariateIinJohoDac 合議体割当委員情報Dac;
    private final ShinsakaiIinJohoManager 介護認定審査会委員情報Manager;

    /**
     * コンストラクタです。
     */
    GogitaiWariateIinJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.合議体割当委員情報Dac = InstanceProvider.create(DbT5593GogitaiWariateIinJohoDac.class);
        this.介護認定審査会委員情報Manager = new ShinsakaiIinJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 合議体割当委員情報Dac 合議体割当委員情報Dac
     * @param 介護認定審査会委員情報Manager 介護認定審査会委員情報Manager
     */
    GogitaiWariateIinJohoManager(
            MapperProvider mapperProvider,
            DbT5593GogitaiWariateIinJohoDac 合議体割当委員情報Dac,
            ShinsakaiIinJohoManager 介護認定審査会委員情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.合議体割当委員情報Dac = 合議体割当委員情報Dac;
        this.介護認定審査会委員情報Manager = 介護認定審査会委員情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GogitaiWariateIinJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link GogitaiWariateIinJohoManager}のインスタンス
     */
    public static GogitaiWariateIinJohoManager createInstance() {
        return InstanceProvider.create(GogitaiWariateIinJohoManager.class);
    }

    /**
     * 主キーに合致する合議体割当委員情報を返します。
     *
     * @param 合議体割当委員情報検索条件 合議体割当委員情報検索条件
     * @return GogitaiWariateIinJoho nullが返る可能性があります。
     */
    @Transaction
    public GogitaiWariateIinJoho get合議体割当委員情報(GogitaiWariateIinJohoMapperParameter 合議体割当委員情報検索条件) {
        requireNonNull(合議体割当委員情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体割当委員情報検索条件"));
        IGogitaiWariateIinJohoMapper mapper = mapperProvider.create(IGogitaiWariateIinJohoMapper.class);

        GogitaiWariateIinJohoRelateEntity relateEntity = mapper.select合議体割当委員情報ByKey(合議体割当委員情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new GogitaiWariateIinJoho(relateEntity);
    }

    /**
     * 主キー1に合致する合議体割当委員情報のリストを返します。
     *
     * @param 合議体割当委員情報検索条件 合議体割当委員情報検索条件
     * @return GogitaiWariateIinJohoの{@code list}
     */
    @Transaction
    public List<GogitaiWariateIinJoho> get合議体割当委員情報リストBy主キー1(GogitaiWariateIinJohoMapperParameter 合議体割当委員情報検索条件) {
        requireNonNull(合議体割当委員情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体割当委員情報検索条件"));
        IGogitaiWariateIinJohoMapper mapper = mapperProvider.create(IGogitaiWariateIinJohoMapper.class);

        List<GogitaiWariateIinJohoRelateEntity> relateEntityList = mapper.select合議体割当委員情報リストBy主キー1(合議体割当委員情報検索条件);

        ArrayList<GogitaiWariateIinJoho> 合議体割当委員情報List = new ArrayList<>();
        for (GogitaiWariateIinJohoRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            合議体割当委員情報List.add(new GogitaiWariateIinJoho(relateEntity));
        }
        return 合議体割当委員情報List;

    }

    /**
     * 合議体割当委員情報{@link GogitaiWariateIinJoho}を保存します。
     *
     * @param 合議体割当委員情報 合議体割当委員情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(GogitaiWariateIinJoho 合議体割当委員情報) {
        requireNonNull(合議体割当委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体割当委員情報"));

        if (!合議体割当委員情報.hasChanged()) {
            return false;
        }
        合議体割当委員情報 = 合議体割当委員情報.modifiedModel();
        save介護認定審査会委員情報リスト(合議体割当委員情報.getShinsakaiIinJohoList());
        return 1 == 合議体割当委員情報Dac.save(合議体割当委員情報.toEntity());
    }

    private void save介護認定審査会委員情報リスト(List<ShinsakaiIinJoho> 介護認定審査会委員情報List) {
        for (ShinsakaiIinJoho 介護認定審査会委員情報 : 介護認定審査会委員情報List) {
            介護認定審査会委員情報Manager.save介護認定審査会委員情報(介護認定審査会委員情報);
        }
    }
}
