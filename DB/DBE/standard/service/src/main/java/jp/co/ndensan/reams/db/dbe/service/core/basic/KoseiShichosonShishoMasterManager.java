/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5052KoseiShichosonShishoMasterDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村支所マスタを管理するクラスです。
 */
public class KoseiShichosonShishoMasterManager {

    private final DbT5052KoseiShichosonShishoMasterDac dac;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonShishoMasterManager() {
        dac = InstanceProvider.create(DbT5052KoseiShichosonShishoMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5052KoseiShichosonShishoMasterDac}
     */
    KoseiShichosonShishoMasterManager(DbT5052KoseiShichosonShishoMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する構成市町村支所マスタを返します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return KoseiShichosonShishoMaster
     */
    @Transaction
    public KoseiShichosonShishoMaster get構成市町村支所マスタ(
            LasdecCode 市町村コード,
            ShishoCode 支所コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));

        DbT5052KoseiShichosonShishoMasterEntity entity = dac.selectByKey(
                市町村コード,
                支所コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KoseiShichosonShishoMaster(entity);
    }

    /**
     * 構成市町村支所マスタを全件返します。
     *
     * @return KoseiShichosonShishoMasterの{@code list}
     */
    @Transaction
    public List<KoseiShichosonShishoMaster> get構成市町村支所マスタ一覧() {
        List<KoseiShichosonShishoMaster> businessList = new ArrayList<>();

        for (DbT5052KoseiShichosonShishoMasterEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KoseiShichosonShishoMaster(entity));
        }

        return businessList;
    }

    /**
     * 構成市町村支所マスタ{@link KoseiShichosonShishoMaster}を保存します。
     *
     * @param 構成市町村支所マスタ {@link KoseiShichosonShishoMaster}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save構成市町村支所マスタ(KoseiShichosonShishoMaster 構成市町村支所マスタ) {
        requireNonNull(構成市町村支所マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村支所マスタ"));
        if (!構成市町村支所マスタ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(構成市町村支所マスタ.toEntity());
    }
}
