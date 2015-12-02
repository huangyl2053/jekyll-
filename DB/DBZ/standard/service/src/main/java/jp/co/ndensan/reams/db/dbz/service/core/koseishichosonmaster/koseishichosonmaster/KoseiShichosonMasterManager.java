/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.koseishichosonmaster.koseishichosonmaster;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.business.core.koseishichosonmaster.koseishichosonshishomaster.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.koseishichosonmaster.IKoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.koseishichosonmaster.koseishichosonshishomaster.KoseiShichosonShishoMasterManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMasterManager {

    private final MapperProvider mapperProvider;
    private final DbT7051KoseiShichosonMasterDac 構成市町村マスタDac;
    private final KoseiShichosonShishoMasterManager 構成市町村支所マスタManager;

    /**
     * コンストラクタです。
     */
    KoseiShichosonMasterManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.構成市町村マスタDac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
        this.構成市町村支所マスタManager = new KoseiShichosonShishoMasterManager();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 構成市町村マスタDac 構成市町村マスタDac
     * @param 構成市町村支所マスタManager 構成市町村支所マスタManager
     */
    KoseiShichosonMasterManager(
            MapperProvider mapperProvider,
            DbT7051KoseiShichosonMasterDac 構成市町村マスタDac,
            KoseiShichosonShishoMasterManager 構成市町村支所マスタManager
    ) {
        this.mapperProvider = mapperProvider;
        this.構成市町村マスタDac = 構成市町村マスタDac;
        this.構成市町村支所マスタManager = 構成市町村支所マスタManager;
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
     * @return KoseiShichosonMaster nullが返る可能性があります。
     */
    @Transaction
    public KoseiShichosonMaster get構成市町村マスタ(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件) {
        requireNonNull(構成市町村マスタ検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ検索条件"));
        IKoseiShichosonMasterMapper mapper = mapperProvider.create(IKoseiShichosonMasterMapper.class);

        KoseiShichosonMasterRelateEntity relateEntity = mapper.getKoseiShichosonEntity(構成市町村マスタ検索条件);
        if (relateEntity == null) {
            return null;
        }
        relateEntity.initializeMd5ToEntities();
        return new KoseiShichosonMaster(relateEntity);
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
        save構成市町村支所マスタリスト(構成市町村マスタ.getKoseiShichosonShishoMasterList());
        return 1 == 構成市町村マスタDac.save(構成市町村マスタ.toEntity());
    }

    private void save構成市町村支所マスタリスト(List<KoseiShichosonShishoMaster> 構成市町村支所マスタList) {
        for (KoseiShichosonShishoMaster 構成市町村支所マスタ : 構成市町村支所マスタList) {
            構成市町村支所マスタManager.save構成市町村支所マスタ(構成市町村支所マスタ);
        }
    }
}
