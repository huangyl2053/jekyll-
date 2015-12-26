/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.tyousai.koseishichosonmaster;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteichosaitakusaki.NinteichosaItakusakiKensakuParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.tyousai.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.tyousai.koseishichosonmaster.IKoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dbe.service.core.tyousai.ninteichosaitakusakijoho.NinteichosaItakusakiJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMasterManager {

    private final MapperProvider mapperProvider;
    private final DbT5051KoseiShichosonMasterDac 構成市町村マスタDac;
    private final NinteichosaItakusakiJohoManager 認定調査委託先情報Manager;

    /**
     * コンストラクタです。
     */
    KoseiShichosonMasterManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.構成市町村マスタDac = InstanceProvider.create(DbT5051KoseiShichosonMasterDac.class);
        this.認定調査委託先情報Manager = NinteichosaItakusakiJohoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 構成市町村マスタDac 構成市町村マスタDac
     * @param 認定調査委託先情報Manager 認定調査委託先情報Manager
     * @param 調査員情報Manager 調査員情報Manager
     */
    KoseiShichosonMasterManager(
            MapperProvider mapperProvider,
            DbT5051KoseiShichosonMasterDac 構成市町村マスタDac,
            NinteichosaItakusakiJohoManager 認定調査委託先情報Manager) {
        this.mapperProvider = mapperProvider;
        this.構成市町村マスタDac = 構成市町村マスタDac;
        this.認定調査委託先情報Manager = 認定調査委託先情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンス
     */
    public static KoseiShichosonMasterManager createInstance() {
        return InstanceProvider.create(KoseiShichosonMasterManager.class);
    }

    /**
     * 主キーに合致する構成市町村マスタを返します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMaster 【　※ツールの都合上、このカッコ部は手動で削除して下さい 構成市町村マスタ】 nullが返る可能性があります。
     */
    @Transaction
    public KoseiShichosonMaster get構成市町村マスタ(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件) {
        requireNonNull(構成市町村マスタ検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ検索条件"));
        IKoseiShichosonMasterMapper mapper = mapperProvider.create(IKoseiShichosonMasterMapper.class);

        KoseiShichosonMasterRelateEntity relateEntity = mapper.select構成市町村マスタByKey(構成市町村マスタ検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KoseiShichosonMaster(relateEntity);
    }

    /**
     * 主キー1に合致する構成市町村マスタのリストを返します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterの{@code list}
     */
    @Transaction
    public List<KoseiShichosonMaster> get構成市町村マスタリストBy主キー1(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件) {
        requireNonNull(構成市町村マスタ検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ検索条件"));
        IKoseiShichosonMasterMapper mapper = mapperProvider.create(IKoseiShichosonMasterMapper.class);

        List<KoseiShichosonMasterRelateEntity> relateEntityList = mapper.select構成市町村マスタリストBy主キー1(構成市町村マスタ検索条件);

        ArrayList<KoseiShichosonMaster> 構成市町村マスタList = new ArrayList<>();
        for (KoseiShichosonMasterRelateEntity relateEntity : relateEntityList) {
            relateEntity.initializeMd5ToEntities();
            構成市町村マスタList.add(new KoseiShichosonMaster(relateEntity));
        }
        return 構成市町村マスタList;

    }

    /**
     * 構成市町村マスタ{@link KoseiShichosonMaster}を保存します。
     *
     * @param 構成市町村マスタ 構成市町村マスタ
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(KoseiShichosonMaster 構成市町村マスタ) {
        requireNonNull(構成市町村マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ"));

        if (!構成市町村マスタ.hasChanged()) {
            return false;
        }
        構成市町村マスタ = 構成市町村マスタ.modifiedModel();
        save認定調査委託先情報リスト(構成市町村マスタ.getNinteichosaItakusakiJohoiList());
        return 1 == 構成市町村マスタDac.save(構成市町村マスタ.toEntity());
    }

    private void save認定調査委託先情報リスト(List<NinteichosaItakusakiJoho> 認定調査委託先情報List) {
        for (NinteichosaItakusakiJoho 認定調査委託先情報 : 認定調査委託先情報List) {
            認定調査委託先情報Manager.save(認定調査委託先情報);
        }
    }

    /**
     * 認定調査委託先マスタ検索のリストを取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntityの{@code list}
     */
    public List<KoseiShichosonMaster> ninteichosaItakusakiSearch(NinteichosaItakusakiKensakuParameter 構成市町村マスタ検索条件) {
        IKoseiShichosonMasterMapper mapper = mapperProvider.create(IKoseiShichosonMasterMapper.class);
        List<KoseiShichosonMasterRelateEntity> entitys = mapper.ninteichosaItakusakiSearch(構成市町村マスタ検索条件);
        List<KoseiShichosonMaster> list = new ArrayList<>();
        for (KoseiShichosonMasterRelateEntity relateEntity : entitys) {
            list.add(new KoseiShichosonMaster(relateEntity));
        }
        return list;
    }
}
