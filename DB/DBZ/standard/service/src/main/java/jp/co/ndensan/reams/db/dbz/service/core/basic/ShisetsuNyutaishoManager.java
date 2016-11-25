/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所を管理するクラスです。
 */
public class ShisetsuNyutaishoManager {

    private final DbT1004ShisetsuNyutaishoDac dac;

    /**
     * コンストラクタです。
     */
    public ShisetsuNyutaishoManager() {
        dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1004ShisetsuNyutaishoDac}
     */
    ShisetsuNyutaishoManager(DbT1004ShisetsuNyutaishoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護保険施設入退所を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return ShisetsuNyutaisho
     */
    @Transaction
    public ShisetsuNyutaisho get介護保険施設入退所(
            ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT1004ShisetsuNyutaishoEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShisetsuNyutaisho(entity);
    }

    /**
     * 介護保険施設入退所を全件返します。
     *
     * @return List<ShisetsuNyutaisho>
     */
    @Transaction
    public List<ShisetsuNyutaisho> get介護保険施設入退所一覧() {
        List<ShisetsuNyutaisho> businessList = new ArrayList<>();

        for (DbT1004ShisetsuNyutaishoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShisetsuNyutaisho(entity));
        }

        return businessList;
    }

    /**
     * 介護保険施設入退所{@link ShisetsuNyutaisho}を保存します。
     *
     * @param 介護保険施設入退所 {@link ShisetsuNyutaisho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護保険施設入退所(ShisetsuNyutaisho 介護保険施設入退所) {
        requireNonNull(介護保険施設入退所, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所"));
        if (!介護保険施設入退所.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護保険施設入退所.toEntity());
    }

    /**
     * 介護保険施設入退所を全件返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return int
     */
    @Transaction
    public int get最大履歴番号(ShikibetsuCode 識別コード) {
        DbT1004ShisetsuNyutaishoEntity entity = dac.get最大履歴番号(識別コード);

        if (entity == null) {
            return 0;
        }
        return entity.getRirekiNo();
    }
    
    /**
     * 識別コードで指定した介護保険施設入退所を取得します。
     * @param 識別コード ShikibetsuCode
     * @return List<ShisetsuNyutaisho>
     */
    @Transaction
    public List<ShisetsuNyutaisho> get介護保険施設入退所(ShikibetsuCode 識別コード) {
        List<ShisetsuNyutaisho> businessList = new ArrayList<>();
        for (DbT1004ShisetsuNyutaishoEntity entity : dac.get介護保険施設入退所(識別コード)) {
            entity.initializeMd5();
            businessList.add(new ShisetsuNyutaisho(entity));
        }
        return businessList;
    }
}
