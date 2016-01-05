/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.syujii.koseishichosonmaster;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbe.persistence.core.basic.MapperProvider;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.koseishichosonmaster.IKoseiShichosonMasterMapper;
import jp.co.ndensan.reams.db.dbe.service.core.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMasterManager {

    private final MapperProvider mapperProvider;
    private final DbT5051KoseiShichosonMasterDac 構成市町村マスタDac;
    private final ShujiiIryoKikanJohoManager 主治医医療機関情報Manager;

    /**
     * コンストラクタです。
     */
    KoseiShichosonMasterManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.構成市町村マスタDac = InstanceProvider.create(DbT5051KoseiShichosonMasterDac.class);
        this.主治医医療機関情報Manager = ShujiiIryoKikanJohoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 構成市町村マスタDac 構成市町村マスタDac
     * @param 主治医医療機関情報Manager 主治医医療機関情報Manager
     */
    KoseiShichosonMasterManager(
            MapperProvider mapperProvider,
            DbT5051KoseiShichosonMasterDac 構成市町村マスタDac,
            ShujiiIryoKikanJohoManager 主治医医療機関情報Manager
    ) {
        this.mapperProvider = mapperProvider;
        this.構成市町村マスタDac = 構成市町村マスタDac;
        this.主治医医療機関情報Manager = 主治医医療機関情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KoseiShichosonMasterManager}のインスタンス
     */
    public static KoseiShichosonMasterManager createInstance() {
        return InstanceProvider.create(KoseiShichosonMasterManager.class);
    }

    /**
     * 主キーに合致する構成市町村マスタを返します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMaster
     */
    @Transaction
    public KoseiShichosonMaster get構成市町村マスタ(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件) {
        requireNonNull(構成市町村マスタ検索条件, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ検索条件"));
        IKoseiShichosonMasterMapper mapper = mapperProvider.create(IKoseiShichosonMasterMapper.class);

        KoseiShichosonMasterRelateEntity relateEntity = mapper.getKoseiShichosonMasterRelateEntity(構成市町村マスタ検索条件);
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
        save主治医医療機関情報リスト(構成市町村マスタ.getShujiiIryoKikanJohoList());
        return 1 == 構成市町村マスタDac.save(構成市町村マスタ.toEntity());
    }

    private void save主治医医療機関情報リスト(List<ShujiiIryoKikanJoho> 主治医医療機関情報List) {
        for (ShujiiIryoKikanJoho 主治医医療機関情報 : 主治医医療機関情報List) {
            主治医医療機関情報Manager.save(主治医医療機関情報);
        }
    }
}
