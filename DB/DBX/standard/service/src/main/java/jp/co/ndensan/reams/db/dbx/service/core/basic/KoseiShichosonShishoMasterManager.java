/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7052KoseiShichosonShishoMasterDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村支所マスタを管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 chengsanyuan
 */
public class KoseiShichosonShishoMasterManager {

    private final DbT7052KoseiShichosonShishoMasterDac dac;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonShishoMasterManager() {
        dac = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7052KoseiShichosonShishoMasterDac}
     */
    KoseiShichosonShishoMasterManager(DbT7052KoseiShichosonShishoMasterDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KoseiShichosonShishoMasterManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KoseiShichosonShishoMasterManager}のインスタンス
     */
    public static KoseiShichosonShishoMasterManager createInstance() {
        return InstanceProvider.create(KoseiShichosonShishoMasterManager.class);
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

        DbT7052KoseiShichosonShishoMasterEntity entity = dac.selectByKey(
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

        for (DbT7052KoseiShichosonShishoMasterEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KoseiShichosonShishoMaster(entity));
        }

        return businessList;
    }

    /**
     * 市町村コードで構成市町村支所マスタを取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 支所コード 支所コード
     * @return KoseiShichosonShishoMasterの{@code list}
     */
    @Transaction
    public SearchResult<KoseiShichosonShishoMaster> get構成市町村支所マスタ一覧By市町村コード(
            LasdecCode 市町村コード, ShishoCode 支所コード) {
        List<KoseiShichosonShishoMaster> businessList = new ArrayList<>();
        for (DbT7052KoseiShichosonShishoMasterEntity entity : dac.selectByShichosonCode(市町村コード)) {
            entity.initializeMd5();
            businessList.add(new KoseiShichosonShishoMaster(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * 支所コードで構成市町村支所マスタを取得します。
     *
     * @param 支所コード 支所コード
     * @return KoseiShichosonShishoMasterの{@code list}
     */
    @Transaction
    public SearchResult<KoseiShichosonShishoMaster> get構成市町村支所マスタ一覧By支所コード(ShishoCode 支所コード) {
        List<KoseiShichosonShishoMaster> businessList = new ArrayList<>();
        for (DbT7052KoseiShichosonShishoMasterEntity entity : dac.selectByShishoCode(支所コード)) {
            entity.initializeMd5();
            businessList.add(new KoseiShichosonShishoMaster(entity));
        }
        return SearchResult.of(businessList, 0, false);
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
