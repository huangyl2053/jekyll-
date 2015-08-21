/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.view.ShisetsuNyutaishoAlive;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1004ShisetsuNyutaishoAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所Aliveを管理するクラスです。
 */
public class ShisetsuNyutaishoAliveManager {

    private final DbV1004ShisetsuNyutaishoAliveDac dac;

    /**
     * コンストラクタです。
     */
    public ShisetsuNyutaishoAliveManager() {
        dac = InstanceProvider.create(DbV1004ShisetsuNyutaishoAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV1004ShisetsuNyutaishoDac}
     */
    ShisetsuNyutaishoAliveManager(DbV1004ShisetsuNyutaishoAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護保険施設入退所Aliveを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return ShisetsuNyutaishoAlive
     */
    @Transaction
    public ShisetsuNyutaishoAlive get介護保険施設入退所Alive(
            ShikibetsuCode 識別コード,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbV1004ShisetsuNyutaishoEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShisetsuNyutaishoAlive(entity);
    }

    /**
     * 介護保険施設入退所Aliveを全件返します。
     *
     * @return List<ShisetsuNyutaishoAlive>
     */
    @Transaction
    public List<ShisetsuNyutaishoAlive> get介護保険施設入退所Alive一覧() {
        List<ShisetsuNyutaishoAlive> businessList = new ArrayList<>();

        for (DbV1004ShisetsuNyutaishoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShisetsuNyutaishoAlive(entity));
        }

        return businessList;
    }

    /**
     * 介護保険施設入退所Alive{@link ShisetsuNyutaishoAlive}を保存します。
     *
     * @param 介護保険施設入退所Alive {@link ShisetsuNyutaishoAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護保険施設入退所Alive(ShisetsuNyutaishoAlive 介護保険施設入退所Alive) {
        requireNonNull(介護保険施設入退所Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所Alive"));
        if (!介護保険施設入退所Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護保険施設入退所Alive.toEntity());
    }
}
