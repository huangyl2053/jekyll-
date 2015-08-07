/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理を管理するクラスです。
 */
public class HihokenshaDaichoManager {

    private final DbT1001HihokenshaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public HihokenshaDaichoManager() {
        dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1001HihokenshaDaichoDac}
     */
    HihokenshaDaichoManager(DbT1001HihokenshaDaichoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する被保険者台帳管理を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日 IdoYMD
     * @param 枝番 EdaNo
     * @return HihokenshaDaicho
     */
    @Transaction
    public HihokenshaDaicho get被保険者台帳管理(
             HihokenshaNo 被保険者番号,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbT1001HihokenshaDaichoEntity entity = dac.selectByKey(
                被保険者番号,
                異動日,
                枝番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaicho(entity);
    }

    /**
     * 被保険者台帳管理を全件返します。
     *
     * @return List<HihokenshaDaicho>
     */
    @Transaction
    public List<HihokenshaDaicho> get被保険者台帳管理一覧() {
        List<HihokenshaDaicho> businessList = new ArrayList<>();

        for (DbT1001HihokenshaDaichoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new HihokenshaDaicho(entity));
        }

        return businessList;
    }

    /**
     * 被保険者台帳管理{@link HihokenshaDaicho}を保存します。
     *
     * @param 被保険者台帳管理 {@link HihokenshaDaicho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save被保険者台帳管理(HihokenshaDaicho 被保険者台帳管理) {
        requireNonNull(被保険者台帳管理, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理"));
        if (!被保険者台帳管理.hasChanged()) {
            return false;
        }
        return 1 == dac.save(被保険者台帳管理.toEntity());
    }
}
