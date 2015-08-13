/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.JukyushaDaichoAlive;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV4001JukyushaDaichoAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳Aliveを管理するクラスです。
 */
public class JukyushaDaichoAliveManager {

    private final DbV4001JukyushaDaichoAliveDac dac;

    /**
     * コンストラクタです。
     */
    public JukyushaDaichoAliveManager() {
        dac = InstanceProvider.create(DbV4001JukyushaDaichoAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV4001JukyushaDaichoAliveDac}
     */
    JukyushaDaichoAliveManager(DbV4001JukyushaDaichoAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受給者台帳Aliveを返します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番 枝番
     * @param 受給申請事由 受給申請事由
     * @return JukyushaDaichoAlive
     */
    @Transaction
    public JukyushaDaichoAlive get受給者台帳Alive(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));

        DbV4001JukyushaDaichoEntity entity = dac.selectByKey(
                市町村コード,
                被保険者番号,
                履歴番号,
                枝番,
                受給申請事由);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JukyushaDaichoAlive(entity);
    }

    /**
     * 受給者台帳Aliveを全件返します。
     *
     * @return JukyushaDaichoAliveの{@code list}
     */
    @Transaction
    public List<JukyushaDaichoAlive> get受給者台帳Alive一覧() {
        List<JukyushaDaichoAlive> businessList = new ArrayList<>();

        for (DbV4001JukyushaDaichoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JukyushaDaichoAlive(entity));
        }

        return businessList;
    }

    /**
     * 受給者台帳Alive{@link JukyushaDaichoAlive}を保存します。
     *
     * @param 受給者台帳Alive {@link JukyushaDaichoAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受給者台帳Alive(JukyushaDaichoAlive 受給者台帳Alive) {
        requireNonNull(受給者台帳Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳Alive"));
        if (!受給者台帳Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受給者台帳Alive.toEntity());
    }
}
