/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiIkenshoJoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.shujiiIkenshoJoho.ShujiiIkenshoJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoJoho.ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikensho.shujiiIkenshoJoho.IShujiiIkenshoJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItemManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書情報を管理するクラスです。
 */
public class ShujiiIkenshoJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5302ShujiiIkenshoJohoDac 要介護認定主治医意見書情報Dac;
    private final ShujiiIkenshoKinyuItemManager 要介護認定主治医意見書記入項目Manager;
    private final ShujiiIkenshoIkenItemManager 要介護認定主治医意見書意見項目Manager;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.要介護認定主治医意見書情報Dac = InstanceProvider.create(DbT5302ShujiiIkenshoJohoDac.class);
        this.要介護認定主治医意見書記入項目Manager = new ShujiiIkenshoKinyuItemManager();
        this.要介護認定主治医意見書意見項目Manager = new ShujiiIkenshoIkenItemManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 要介護認定主治医意見書情報Dac 要介護認定主治医意見書情報Dac
     * @param 要介護認定主治医意見書記入項目Manager 要介護認定主治医意見書記入項目Manager
     * @param 要介護認定主治医意見書意見項目Manager 要介護認定主治医意見書意見項目Manager
     */
    ShujiiIkenshoJohoManager(
            MapperProvider mapperProvider,
            DbT5302ShujiiIkenshoJohoDac 要介護認定主治医意見書情報Dac,
            ShujiiIkenshoKinyuItemManager 要介護認定主治医意見書記入項目Manager,
            ShujiiIkenshoIkenItemManager 要介護認定主治医意見書意見項目Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.要介護認定主治医意見書情報Dac = 要介護認定主治医意見書情報Dac;
        this.要介護認定主治医意見書記入項目Manager = 要介護認定主治医意見書記入項目Manager;
        this.要介護認定主治医意見書意見項目Manager = 要介護認定主治医意見書意見項目Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoJohoManager}のインスタンス
     */
    public static ShujiiIkenshoJohoManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoJohoManager.class);
    }

    /**
     * 主キーに合致する要介護認定主治医意見書情報を返します。
     *
     * @param 要介護認定主治医意見書情報検索条件 要介護認定主治医意見書情報検索条件
     * @return ShujiiIkenshoJoho 【　※ツールの都合上、このカッコ部は手動で削除して下さい 要介護認定主治医意見書情報】
     * nullが返る可能性があります。
     */
    @Transaction
    public ShujiiIkenshoJoho get要介護認定主治医意見書情報(ShujiiIkenshoJohoMapperParameter 要介護認定主治医意見書情報検索条件) {
        requireNonNull(要介護認定主治医意見書情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報検索条件"));
        IShujiiIkenshoJohoMapper mapper = mapperProvider.create(IShujiiIkenshoJohoMapper.class);

        ShujiiIkenshoJohoEntity relateEntity = mapper.select要介護認定主治医意見書情報ByKey(要介護認定主治医意見書情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new ShujiiIkenshoJoho(relateEntity);
    }

    /**
     * 主キー1に合致する要介護認定主治医意見書情報のリストを返します。
     *
     * @param 要介護認定主治医意見書情報検索条件 要介護認定主治医意見書情報検索条件
     * @return ShujiiIkenshoJohoの{@code list}
     */
    @Transaction
    public List<ShujiiIkenshoJoho> get要介護認定主治医意見書情報リストBy主キー1(ShujiiIkenshoJohoMapperParameter 要介護認定主治医意見書情報検索条件) {
        requireNonNull(要介護認定主治医意見書情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報検索条件"));
        IShujiiIkenshoJohoMapper mapper = mapperProvider.create(IShujiiIkenshoJohoMapper.class);

        List<ShujiiIkenshoJohoEntity> relateEntityList = mapper.select要介護認定主治医意見書情報リストBy主キー1(要介護認定主治医意見書情報検索条件);

        ArrayList<ShujiiIkenshoJoho> 要介護認定主治医意見書情報List = new ArrayList<>();
        for (ShujiiIkenshoJohoEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            要介護認定主治医意見書情報List.add(new ShujiiIkenshoJoho(relateEntity));
        }
        return 要介護認定主治医意見書情報List;

    }

    /**
     * 要介護認定主治医意見書情報{@link ShujiiIkenshoJoho}を保存します。
     *
     * @param 要介護認定主治医意見書情報 要介護認定主治医意見書情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        requireNonNull(要介護認定主治医意見書情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報"));

        if (!要介護認定主治医意見書情報.hasChanged()) {
            return false;
        }
        要介護認定主治医意見書情報 = 要介護認定主治医意見書情報.modifiedModel();
        save要介護認定主治医意見書記入項目リスト(要介護認定主治医意見書情報.getShujiiIkenshoKinyuItemList());
        save要介護認定主治医意見書意見項目リスト(要介護認定主治医意見書情報.getShujiiIkenshoIkenItemList());
        return 1 == 要介護認定主治医意見書情報Dac.save(要介護認定主治医意見書情報.toEntity());
    }

    private void save要介護認定主治医意見書記入項目リスト(List<ShujiiIkenshoKinyuItem> 要介護認定主治医意見書記入項目List) {
        for (ShujiiIkenshoKinyuItem 要介護認定主治医意見書記入項目 : 要介護認定主治医意見書記入項目List) {
            要介護認定主治医意見書記入項目Manager.save要介護認定主治医意見書記入項目(要介護認定主治医意見書記入項目);
        }
    }

    private void save要介護認定主治医意見書意見項目リスト(List<ShujiiIkenshoIkenItem> 要介護認定主治医意見書意見項目List) {
        for (ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目 : 要介護認定主治医意見書意見項目List) {
            要介護認定主治医意見書意見項目Manager.save要介護認定主治医意見書意見項目(要介護認定主治医意見書意見項目);
        }
    }
}
