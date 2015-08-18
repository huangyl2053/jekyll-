/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.FukaAlive;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV2002FukaAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課Aliveを管理するクラスです。
 */
public class FukaAliveManager {

    private final DbV2002FukaAliveDac dac;

    /**
     * コンストラクタです。
     */
    public FukaAliveManager() {
        dac = InstanceProvider.create(DbV2002FukaAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV2002FukaAliveDac}
     */
    FukaAliveManager(DbV2002FukaAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する賦課Aliveを返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return FukaAlive
     */
    @Transaction
    public FukaAlive get賦課Alive(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbV2002FukaEntity entity = dac.selectByKey(
                調定年度,
                賦課年度,
                通知書番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new FukaAlive(entity);
    }

    /**
     * 賦課Aliveを全件返します。
     *
     * @return FukaAliveの{@code list}
     */
    @Transaction
    public List<FukaAlive> get賦課Alive一覧() {
        List<FukaAlive> businessList = new ArrayList<>();

        for (DbV2002FukaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new FukaAlive(entity));
        }

        return businessList;
    }

    /**
     * 賦課Alive{@link FukaAlive}を保存します。
     *
     * @param 賦課Alive {@link FukaAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save賦課Alive(FukaAlive 賦課Alive) {
        requireNonNull(賦課Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課Alive"));
        if (!賦課Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(賦課Alive.toEntity());
    }
}
