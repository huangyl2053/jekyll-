/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.ninteishinseijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.geninshikkan.GeninShikkan;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.ninteishinseijoho.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikensho.ninteishinseijoho.INinteiShinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.geninshikkan.GeninShikkanManager;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiIkenshoIraiJoho.ShujiiIkenshoIraiJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報を管理するクラスです。
 */
public class NinteiShinseiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private final GeninShikkanManager 原因疾患Manager;
    private final ShujiiIkenshoIraiJohoManager 主治医意見書作成依頼情報Manager;

    /**
     * コンストラクタです。
     */
    NinteiShinseiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.原因疾患Manager = new GeninShikkanManager();
        this.主治医意見書作成依頼情報Manager = ShujiiIkenshoIraiJohoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 要介護認定申請情報Dac 要介護認定申請情報Dac
     * @param 原因疾患Manager 原因疾患Manager
     * @param 主治医意見書作成依頼情報Manager 主治医意見書作成依頼情報Manager
     */
    NinteiShinseiJohoManager(
            MapperProvider mapperProvider,
            DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac,
            GeninShikkanManager 原因疾患Manager,
            ShujiiIkenshoIraiJohoManager 主治医意見書作成依頼情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.要介護認定申請情報Dac = 要介護認定申請情報Dac;
        this.原因疾患Manager = 原因疾患Manager;
        this.主治医意見書作成依頼情報Manager = 主治医意見書作成依頼情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンス
     */
    public static NinteiShinseiJohoManager createInstance() {
        return InstanceProvider.create(NinteiShinseiJohoManager.class);
    }

    /**
     * 主キーに合致する要介護認定申請情報を返します。
     *
     * @param 要介護認定申請情報検索条件 要介護認定申請情報検索条件
     * @return NinteiShinseiJoho nullが返る可能性があります。
     */
    @Transaction
    public NinteiShinseiJoho get要介護認定申請情報(NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件) {
        requireNonNull(要介護認定申請情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報検索条件"));
        INinteiShinseiJohoMapper mapper = mapperProvider.create(INinteiShinseiJohoMapper.class);

        NinteiShinseiJohoEntity relateEntity = mapper.select要介護認定申請情報ByKey(要介護認定申請情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NinteiShinseiJoho(relateEntity);
    }

    /**
     * 主キー1に合致する要介護認定申請情報のリストを返します。
     *
     * @param 要介護認定申請情報検索条件 要介護認定申請情報検索条件
     * @return NinteiShinseiJohoの{@code list}
     */
    @Transaction
    public List<NinteiShinseiJoho> get要介護認定申請情報リストBy主キー1(NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件) {
        requireNonNull(要介護認定申請情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報検索条件"));
        INinteiShinseiJohoMapper mapper = mapperProvider.create(INinteiShinseiJohoMapper.class);

        List<NinteiShinseiJohoEntity> relateEntityList = mapper.select要介護認定申請情報リストBy主キー1(要介護認定申請情報検索条件);

        ArrayList<NinteiShinseiJoho> 要介護認定申請情報List = new ArrayList<>();
        for (NinteiShinseiJohoEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            要介護認定申請情報List.add(new NinteiShinseiJoho(relateEntity));
        }
        return 要介護認定申請情報List;

    }

    /**
     * 要介護認定申請情報{@link NinteiShinseiJoho}を保存します。
     *
     * @param 要介護認定申請情報 要介護認定申請情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteiShinseiJoho 要介護認定申請情報) {
        requireNonNull(要介護認定申請情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報"));

        if (!要介護認定申請情報.hasChanged()) {
            return false;
        }
        要介護認定申請情報 = 要介護認定申請情報.modifiedModel();
        save原因疾患リスト(要介護認定申請情報.getGeninShikkanList());
        save主治医意見書作成依頼情報リスト(要介護認定申請情報.getshujiiIkenshoIraiJohoList());
        return 1 == 要介護認定申請情報Dac.save(要介護認定申請情報.toEntity());
    }

    private void save原因疾患リスト(List<GeninShikkan> 原因疾患List) {
        for (GeninShikkan 原因疾患 : 原因疾患List) {
            原因疾患Manager.save原因疾患(原因疾患);
        }
    }

    private void save主治医意見書作成依頼情報リスト(List<ShujiiIkenshoIraiJoho> 主治医意見書作成依頼情報List) {
        for (ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報 : 主治医意見書作成依頼情報List) {
            主治医意見書作成依頼情報Manager.save(主治医意見書作成依頼情報);
        }
    }
}
