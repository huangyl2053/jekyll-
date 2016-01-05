/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaijoho.GogitaiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5591GogitaiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho.gogitaijoho.IGogitaiJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaiwariateiinjoho.GogitaiWariateIinJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体情報を管理するクラスです。
 */
public class GogitaiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5591GogitaiJohoDac 合議体情報Dac;
    private final ShinsakaiKaisaiBashoJohoManager 介護認定審査会開催場所情報Manager;
    private final GogitaiWariateIinJohoManager 合議体割当委員情報Manager;

    /**
     * コンストラクタです。
     */
    GogitaiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.合議体情報Dac = InstanceProvider.create(DbT5591GogitaiJohoDac.class);
        this.介護認定審査会開催場所情報Manager = new ShinsakaiKaisaiBashoJohoManager();
        this.合議体割当委員情報Manager = GogitaiWariateIinJohoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 合議体情報Dac 合議体情報Dac
     * @param 介護認定審査会開催場所情報Manager 介護認定審査会開催場所情報Manager
     * @param 合議体割当委員情報Manager 合議体割当委員情報Manager
     */
    GogitaiJohoManager(
            MapperProvider mapperProvider,
            DbT5591GogitaiJohoDac 合議体情報Dac,
            ShinsakaiKaisaiBashoJohoManager 介護認定審査会開催場所情報Manager,
            GogitaiWariateIinJohoManager 合議体割当委員情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.合議体情報Dac = 合議体情報Dac;
        this.介護認定審査会開催場所情報Manager = 介護認定審査会開催場所情報Manager;
        this.合議体割当委員情報Manager = 合議体割当委員情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GogitaiJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link GogitaiJohoManager}のインスタンス
     */
    public static GogitaiJohoManager createInstance() {
        return InstanceProvider.create(GogitaiJohoManager.class);
    }

    /**
     * 主キーに合致する合議体情報を返します。
     *
     * @param 合議体情報検索条件 合議体情報検索条件
     * @return GogitaiJoho nullが返る可能性があります。
     */
    @Transaction
    public GogitaiJoho get合議体情報(GogitaiJohoMapperParameter 合議体情報検索条件) {
        requireNonNull(合議体情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体情報検索条件"));
        IGogitaiJohoMapper mapper = mapperProvider.create(IGogitaiJohoMapper.class);

        GogitaiJohoRelateEntity relateEntity = mapper.select合議体情報ByKey(合議体情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new GogitaiJoho(relateEntity);
    }

    /**
     * 主キー1に合致する合議体情報のリストを返します。
     *
     * @param 合議体情報検索条件 合議体情報検索条件
     * @return GogitaiJohoの{@code list}
     */
    @Transaction
    public List<GogitaiJoho> get合議体情報リストBy主キー1(GogitaiJohoMapperParameter 合議体情報検索条件) {
        requireNonNull(合議体情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体情報検索条件"));
        IGogitaiJohoMapper mapper = mapperProvider.create(IGogitaiJohoMapper.class);

        List<GogitaiJohoRelateEntity> relateEntityList = mapper.select合議体情報リストBy主キー1(合議体情報検索条件);

        ArrayList<GogitaiJoho> 合議体情報List = new ArrayList<>();
        for (GogitaiJohoRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            合議体情報List.add(new GogitaiJoho(relateEntity));
        }
        return 合議体情報List;

    }

    /**
     * 合議体情報{@link GogitaiJoho}を保存します。
     *
     * @param 合議体情報 合議体情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(GogitaiJoho 合議体情報) {
        requireNonNull(合議体情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体情報"));

        if (!合議体情報.hasChanged()) {
            return false;
        }
        合議体情報 = 合議体情報.modifiedModel();
        save介護認定審査会開催場所情報リスト(合議体情報.getShinsakaiKaisaiBashoJohoList());
        save合議体割当委員情報リスト(合議体情報.getGogitaiWariateIinJohoList());
        return 1 == 合議体情報Dac.save(合議体情報.toEntity());
    }

    /**
     * 合議体情報{@link GogitaiJoho}を物理削除します。
     *
     * @param 合議体情報 合議体情報
     * @return 削除あり:true、削除なし:false <br>
     * いずれかのテーブルに削除があればtrueを返す
     */
    @Transaction
    public boolean deletePhysical(GogitaiJoho 合議体情報) {
        requireNonNull(合議体情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体情報"));

        deletePhysical合議体割当委員情報リスト(合議体情報.getGogitaiWariateIinJohoList());
        return 1 == 合議体情報Dac.deletePhysical(合議体情報.toEntity());
    }

    private void deletePhysical合議体割当委員情報リスト(List<GogitaiWariateIinJoho> 合議体割当委員情報List) {
        for (GogitaiWariateIinJoho 合議体割当委員情報 : 合議体割当委員情報List) {
            合議体割当委員情報Manager.deletePhysical(合議体割当委員情報);
        }
    }

    private void save介護認定審査会開催場所情報リスト(List<ShinsakaiKaisaiBashoJoho> 介護認定審査会開催場所情報List) {
        for (ShinsakaiKaisaiBashoJoho 介護認定審査会開催場所情報 : 介護認定審査会開催場所情報List) {
            介護認定審査会開催場所情報Manager.save介護認定審査会開催場所情報(介護認定審査会開催場所情報);
        }
    }

    private void save合議体割当委員情報リスト(List<GogitaiWariateIinJoho> 合議体割当委員情報List) {
        for (GogitaiWariateIinJoho 合議体割当委員情報 : 合議体割当委員情報List) {
            合議体割当委員情報Manager.save(合議体割当委員情報);
        }
    }
}
