/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteishinseijoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosahyo.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteishinseijoho.NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosahyo.ninteishinseijoho.INinteiShinseiJohoMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosairaijoho.NinteichosaIraiJohoManager;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報を管理するクラスです。
 */
public class NinteiShinseiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac;
    private final NinteichosaIraiJohoManager 認定調査依頼情報Manager;

    /**
     * コンストラクタです。
     */
    NinteiShinseiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.要介護認定申請情報Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        this.認定調査依頼情報Manager = NinteichosaIraiJohoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 要介護認定申請情報Dac 要介護認定申請情報Dac
     * @param 認定調査依頼情報Manager 認定調査依頼情報Manager
     */
    NinteiShinseiJohoManager(
            MapperProvider mapperProvider,
            DbT5101NinteiShinseiJohoDac 要介護認定申請情報Dac,
            NinteichosaIraiJohoManager 認定調査依頼情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.要介護認定申請情報Dac = 要介護認定申請情報Dac;
        this.認定調査依頼情報Manager = 認定調査依頼情報Manager;
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
        save認定調査依頼情報リスト(要介護認定申請情報.getNinteichosaIraiJohoList());
        return 1 == 要介護認定申請情報Dac.insert(要介護認定申請情報.toEntity());
    }

    private void save認定調査依頼情報リスト(List<NinteichosaIraiJoho> 認定調査依頼情報List) {
        for (NinteichosaIraiJoho 認定調査依頼情報 : 認定調査依頼情報List) {
            認定調査依頼情報Manager.save(認定調査依頼情報);
        }
    }
}
