/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.iryohokenkanyujokyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.iryohokenkanyujokyo.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1008IryohokenKanyuJokyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険医療保険加入状況を管理するクラスです。
 */
public class IryohokenKanyuJokyoManager {

    private final DbT1008IryohokenKanyuJokyoDac dac;

    /**
     * コンストラクタです。
     */
    public IryohokenKanyuJokyoManager() {
        dac = InstanceProvider.create(DbT1008IryohokenKanyuJokyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1008IryohokenKanyuJokyoDac}
     */
    IryohokenKanyuJokyoManager(DbT1008IryohokenKanyuJokyoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護保険医療保険加入状況{@link IryohokenKanyuJokyo}を保存します。
     *
     * @param 介護保険医療保険加入状況 {@link IryohokenKanyuJokyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護保険医療保険加入状況(IryohokenKanyuJokyo 介護保険医療保険加入状況) {
        requireNonNull(介護保険医療保険加入状況, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険医療保険加入状況"));
        if (!介護保険医療保険加入状況.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護保険医療保険加入状況.toEntity());
    }
}
