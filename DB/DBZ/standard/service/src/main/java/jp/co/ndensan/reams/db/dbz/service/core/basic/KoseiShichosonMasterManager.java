/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMasterManager {

    private final DbT7051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMasterManager() {
        dac = InstanceProvider.create(DbT7051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7051KoseiShichosonMasterDac}
     */
    KoseiShichosonMasterManager(DbT7051KoseiShichosonMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する構成市町村マスタを返します。
     *
     * @param 市町村識別ID ShichosonShokibetsuID
     * @return KoseiShichosonMaster
     */
    @Transaction
    public KoseiShichosonMaster get構成市町村マスタ(
            RString 市町村識別ID) {
        requireNonNull(市町村識別ID, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村識別ID"));

        DbT7051KoseiShichosonMasterEntity entity = dac.selectByKey(
                市町村識別ID);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KoseiShichosonMaster(entity);
    }

    /**
     * 構成市町村マスタを全件返します。
     *
     * @return List<KoseiShichosonMaster>
     */
    @Transaction
    public List<KoseiShichosonMaster> get構成市町村マスタ一覧() {
        List<KoseiShichosonMaster> businessList = new ArrayList<>();

        for (DbT7051KoseiShichosonMasterEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KoseiShichosonMaster(entity));
        }

        return businessList;
    }

    /**
     * 構成市町村マスタ{@link KoseiShichosonMaster}を保存します。
     *
     * @param 構成市町村マスタ {@link KoseiShichosonMaster}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save構成市町村マスタ(KoseiShichosonMaster 構成市町村マスタ) {
        requireNonNull(構成市町村マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ"));
        if (!構成市町村マスタ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(構成市町村マスタ.toEntity());
    }
}
