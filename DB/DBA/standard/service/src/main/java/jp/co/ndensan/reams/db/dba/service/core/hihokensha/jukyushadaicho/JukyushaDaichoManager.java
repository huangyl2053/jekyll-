/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.jukyushadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.jukyushadaicho.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳を管理するクラスです。
 */
public class JukyushaDaichoManager {

    private final DbT4001JukyushaDaichoDac dac;

    /**
     * コンストラクタです。
     */
    public JukyushaDaichoManager() {
        dac = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4001JukyushaDaichoDac}
     */
    JukyushaDaichoManager(DbT4001JukyushaDaichoDac dac) {
        this.dac = dac;
    }

    /**
     * 受給者台帳{@link JukyushaDaicho}を保存します。
     *
     * @param 受給者台帳 {@link JukyushaDaicho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受給者台帳(JukyushaDaicho 受給者台帳) {
        requireNonNull(受給者台帳, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳"));
        if (!受給者台帳.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受給者台帳.toEntity());
    }
}
