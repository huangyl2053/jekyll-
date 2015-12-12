/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.ShikakuSearchAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV7901ShikakuSearchAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格検索Aliveを管理するクラスです。
 */
public class ShikakuSearchAliveManager {

    private final DbV7901ShikakuSearchAliveDac dac;

    /**
     * コンストラクタです。
     */
    public ShikakuSearchAliveManager() {
        dac = InstanceProvider.create(DbV7901ShikakuSearchAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV7901ShikakuSearchAliveDac}
     */
    ShikakuSearchAliveManager(DbV7901ShikakuSearchAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する資格検索Aliveを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return ShikakuSearchAlive
     */
    @Transaction
    public ShikakuSearchAlive get資格検索Alive(
            HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbV7901ShikakuSearchEntity entity = dac.selectByKey(
                被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShikakuSearchAlive(entity);
    }

    /**
     * 資格検索Aliveを全件返します。
     *
     * @return ShikakuSearchAliveの{@code list}
     */
    @Transaction
    public List<ShikakuSearchAlive> get資格検索Alive一覧() {
        List<ShikakuSearchAlive> businessList = new ArrayList<>();

        for (DbV7901ShikakuSearchEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShikakuSearchAlive(entity));
        }

        return businessList;
    }

    /**
     * 資格検索Alive{@link ShikakuSearchAlive}を保存します。
     *
     * @param 資格検索Alive {@link ShikakuSearchAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save資格検索Alive(ShikakuSearchAlive 資格検索Alive) {
        requireNonNull(資格検索Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("資格検索Alive"));
        if (!資格検索Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(資格検索Alive.toEntity());
    }
}
