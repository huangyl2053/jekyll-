/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理Aliveを管理するクラスです。
 */
public class HihokenshaDaichoAliveManager {

    private final DbV1001HihokenshaDaichoAliveDac dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoAliveManager() {
        dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV1001HihokenshaDaichoDac}
     */
    HihokenshaDaichoAliveManager(DbV1001HihokenshaDaichoAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する被保険者台帳管理Aliveを返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return HihokenshaDaichoAlive
     */
    @Transaction
    public HihokenshaDaichoAlive get被保険者台帳管理Alive(
            HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbV1001HihokenshaDaichoEntity entity = dac.selectByKey(
                被保険者番号,
                異動日,
                枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaichoAlive(entity);
    }

    /**
     * 被保険者台帳管理Aliveを全件返します。
     *
     * @return List<HihokenshaDaichoAlive>
     */
    @Transaction
    public List<HihokenshaDaichoAlive> get被保険者台帳管理Alive一覧() {
        List<HihokenshaDaichoAlive> businessList = new ArrayList<>();

        for (DbV1001HihokenshaDaichoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new HihokenshaDaichoAlive(entity));
        }

        return businessList;
    }

    /**
     * 被保険者台帳管理Alive{@link HihokenshaDaichoAlive}を保存します。
     *
     * @param 被保険者台帳管理Alive {@link HihokenshaDaichoAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save被保険者台帳管理Alive(HihokenshaDaichoAlive 被保険者台帳管理Alive) {
        requireNonNull(被保険者台帳管理Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理Alive"));
        if (!被保険者台帳管理Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(被保険者台帳管理Alive.toEntity());
    }
}
