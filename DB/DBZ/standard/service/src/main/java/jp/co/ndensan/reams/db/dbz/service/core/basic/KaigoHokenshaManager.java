/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoHokensha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7050KaigoHokenshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険者を管理するクラスです。
 */
public class KaigoHokenshaManager {

    private final DbT7050KaigoHokenshaDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoHokenshaManager() {
        dac = InstanceProvider.create(DbT7050KaigoHokenshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7050KaigoHokenshaDac}
     */
    KaigoHokenshaManager(DbT7050KaigoHokenshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護保険者を返します。
     *
     * @param 広域保険者市町村コード KoikiHokenshaShichosonCode
     * @return KaigoHokensha
     */
    @Transaction
    public KaigoHokensha get介護保険者(
            LasdecCode 広域保険者市町村コード) {
        requireNonNull(広域保険者市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広域保険者市町村コード"));

        DbT7050KaigoHokenshaEntity entity = dac.selectByKey(
                広域保険者市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoHokensha(entity);
    }

    /**
     * 介護保険者を全件返します。
     *
     * @return List<KaigoHokensha>
     */
    @Transaction
    public List<KaigoHokensha> get介護保険者一覧() {
        List<KaigoHokensha> businessList = new ArrayList<>();

        for (DbT7050KaigoHokenshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoHokensha(entity));
        }

        return businessList;
    }

    /**
     * 介護保険者{@link KaigoHokensha}を保存します。
     *
     * @param 介護保険者 {@link KaigoHokensha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護保険者(KaigoHokensha 介護保険者) {
        requireNonNull(介護保険者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険者"));
        if (!介護保険者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護保険者.toEntity());
    }
}
