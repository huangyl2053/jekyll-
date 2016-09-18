/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.FukaSearchAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV7902FukaSearchEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV7902FukaSearchAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 賦課検索Aliveを管理するクラスです。
 */
public class FukaSearchAliveManager {

    private final DbV7902FukaSearchAliveDac dac;

    /**
     * コンストラクタです。
     */
    public FukaSearchAliveManager() {
        dac = InstanceProvider.create(DbV7902FukaSearchAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV7902FukaSearchAliveDac}
     */
    FukaSearchAliveManager(DbV7902FukaSearchAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する賦課検索Aliveを返します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @return FukaSearchAlive
     */
    @Transaction
    public FukaSearchAlive get賦課検索Alive(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbV7902FukaSearchEntity entity = dac.selectByKey(
                調定年度,
                賦課年度,
                通知書番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new FukaSearchAlive(entity);
    }

    /**
     * 識別コードを指定し、賦課年度が最大の賦課Aliveを1件取得します。
     *
     * @param 識別コード 識別コード
     * @return FukaSearchAlive
     */
    @Transaction
    public FukaSearchAlive get賦課年度最大賦課Alive(
            ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbV7902FukaSearchEntity entity = dac.selectBy識別コードOrderBy賦課年度(識別コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new FukaSearchAlive(entity);
    }

    /**
     * 賦課検索Aliveを全件返します。
     *
     * @return FukaSearchAliveの{@code list}
     */
    @Transaction
    public List<FukaSearchAlive> get賦課検索Alive一覧() {
        List<FukaSearchAlive> businessList = new ArrayList<>();

        for (DbV7902FukaSearchEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new FukaSearchAlive(entity));
        }

        return businessList;
    }

    /**
     * 賦課検索Alive{@link FukaSearchAlive}を保存します。
     *
     * @param 賦課検索Alive {@link FukaSearchAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save賦課検索Alive(FukaSearchAlive 賦課検索Alive) {
        requireNonNull(賦課検索Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課検索Alive"));
        if (!賦課検索Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(賦課検索Alive.toEntity());
    }
}
