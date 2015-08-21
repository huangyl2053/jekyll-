/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaShisetsuNyutaishoAlive;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1004HihokenshaShisetsuNyutaishoAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者施設入退所Aliveを管理するクラスです。
 */
public class HihokenshaShisetsuNyutaishoAliveManager {

    private final DbV1004HihokenshaShisetsuNyutaishoAliveDac dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaShisetsuNyutaishoAliveManager() {
        dac = InstanceProvider.create(DbV1004HihokenshaShisetsuNyutaishoAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV1004HihokenshaShisetsuNyutaishoDac}
     */
    HihokenshaShisetsuNyutaishoAliveManager(DbV1004HihokenshaShisetsuNyutaishoAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する被保険者施設入退所Aliveを返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return HihokenshaShisetsuNyutaishoAlive
     */
    @Transaction
    public HihokenshaShisetsuNyutaishoAlive get被保険者施設入退所Alive(
            ShikibetsuCode 識別コード,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbV1004HihokenshaShisetsuNyutaishoEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaShisetsuNyutaishoAlive(entity);
    }

    /**
     * 被保険者施設入退所Aliveを全件返します。
     *
     * @return List<HihokenshaShisetsuNyutaishoAlive>
     */
    @Transaction
    public List<HihokenshaShisetsuNyutaishoAlive> get被保険者施設入退所Alive一覧() {
        List<HihokenshaShisetsuNyutaishoAlive> businessList = new ArrayList<>();

        for (DbV1004HihokenshaShisetsuNyutaishoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new HihokenshaShisetsuNyutaishoAlive(entity));
        }

        return businessList;
    }

    /**
     * 被保険者施設入退所Alive{@link HihokenshaShisetsuNyutaishoAlive}を保存します。
     *
     * @param 被保険者施設入退所Alive {@link HihokenshaShisetsuNyutaishoAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save被保険者施設入退所Alive(HihokenshaShisetsuNyutaishoAlive 被保険者施設入退所Alive) {
        requireNonNull(被保険者施設入退所Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者施設入退所Alive"));
        if (!被保険者施設入退所Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(被保険者施設入退所Alive.toEntity());
    }
}
