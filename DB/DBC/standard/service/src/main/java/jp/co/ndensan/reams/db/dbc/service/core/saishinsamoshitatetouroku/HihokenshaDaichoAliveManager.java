/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.saishinsamoshitatetouroku;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.view.HihokenshaDaichoAlive;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 被保険者台帳管理Aliveを管理するクラスです。
 *
 * @reamsid_L DBC-2230-010 chenxiangyu
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
     * 被保険者番号により、最新の被保険者台帳情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return HihokenshaDaichoAlive
     */
    @Transaction
    public HihokenshaDaichoAlive get最新の被保険者台帳情報(RString 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbV1001HihokenshaDaichoEntity entity = dac.get最新の被保険者台帳情報(new HihokenshaNo(被保険者番号));
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new HihokenshaDaichoAlive(entity);
    }
}
