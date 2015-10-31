/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.tyousai.ninteichosaitakusakijoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.koseishichosonmaster.IKoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.chosainjoho.ChosainJohoManager;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.koseishichosonmaster.KoseiShichosonMasterManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先情報を管理するクラスです。
 */
public class NinteichosaItakusakiJohoManager {

    private final MapperProvider mapperProvider;
    private final DbT5910NinteichosaItakusakiJohoDac 認定調査委託先情報Dac;
    private final KoseiShichosonMasterManager 構成市町村マスタManager;
    private final ChosainJohoManager 調査員情報Manager;

    /**
     * コンストラクタです。
     */
    NinteichosaItakusakiJohoManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.認定調査委託先情報Dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
        this.構成市町村マスタManager = new KoseiShichosonMasterManager();
        this.調査員情報Manager = new ChosainJohoManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 認定調査委託先情報Dac 認定調査委託先情報Dac
     * @param 構成市町村マスタManager 構成市町村マスタManager
     * @param 調査員情報Manager 調査員情報Manager
     */
    NinteichosaItakusakiJohoManager(
            MapperProvider mapperProvider,
            DbT5910NinteichosaItakusakiJohoDac 認定調査委託先情報Dac,
            KoseiShichosonMasterManager 構成市町村マスタManager,
            ChosainJohoManager 調査員情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.認定調査委託先情報Dac = 認定調査委託先情報Dac;
        this.構成市町村マスタManager = 構成市町村マスタManager;
        this.調査員情報Manager = 調査員情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaItakusakiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaItakusakiJohoManager}のインスタンス
     */
    public static NinteichosaItakusakiJohoManager createInstance() {
        return InstanceProvider.create(NinteichosaItakusakiJohoManager.class);
    }

    /**
     * 主キーに合致する認定調査委託先情報を返します。
     *
     * @param 認定調査委託先情報検索条件 認定調査委託先情報検索条件
     * @return NinteichosaItakusakiJoho nullが返る可能性があります。
     */
    @Transaction
    public NinteichosaItakusakiJoho get認定調査委託先情報(KoseiShichosonMasterMapperParameter 認定調査委託先情報検索条件) {
        requireNonNull(認定調査委託先情報検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報検索条件"));
        IKoseiShichosonMasterMapper mapper = mapperProvider.create(IKoseiShichosonMasterMapper.class);

        NinteichosaItakusakiJohoRelateEntity relateEntity = mapper.getChosaItakusakiChosainRelateEntity(認定調査委託先情報検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new NinteichosaItakusakiJoho(relateEntity);
    }

    /**
     * 認定調査委託先情報{@link NinteichosaItakusakiJoho}を保存します。
     *
     * @param 認定調査委託先情報 認定調査委託先情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(NinteichosaItakusakiJoho 認定調査委託先情報) {
        requireNonNull(認定調査委託先情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報"));

        if (!認定調査委託先情報.hasChanged()) {
            return false;
        }
        認定調査委託先情報 = 認定調査委託先情報.modifiedModel();
        save構成市町村マスタリスト(認定調査委託先情報.getKoseiShichosonMasterList());
        save調査員情報リスト(認定調査委託先情報.getChosainJohoList());
        return 1 == 認定調査委託先情報Dac.save(認定調査委託先情報.toEntity());
    }

    private void save構成市町村マスタリスト(List<KoseiShichosonMaster> 構成市町村マスタList) {
        for (KoseiShichosonMaster 構成市町村マスタ : 構成市町村マスタList) {
            構成市町村マスタManager.save構成市町村マスタ(構成市町村マスタ);
        }
    }

    private void save調査員情報リスト(List<ChosainJoho> 調査員情報List) {
        for (ChosainJoho 調査員情報 : 調査員情報List) {
            調査員情報Manager.save調査員情報(調査員情報);
        }
    }
}
