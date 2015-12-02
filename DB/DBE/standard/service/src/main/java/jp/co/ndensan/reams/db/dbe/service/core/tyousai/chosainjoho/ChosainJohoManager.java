/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.tyousai.chosainjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.tyousai.chosainjoho.ChosainJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査員情報を管理するクラスです。
 */
public class ChosainJohoManager {

    private final DbT5913ChosainJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ChosainJohoManager() {
        dac = InstanceProvider.create(DbT5913ChosainJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5913ChosainJohoDac}
     */
    ChosainJohoManager(DbT5913ChosainJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 調査員情報を全件返します。
     *
     * @return ChosainJohoの{@code list}
     */
    @Transaction
    public List<ChosainJoho> get調査員情報一覧() {
        List<ChosainJoho> businessList = new ArrayList<>();

        for (DbT5913ChosainJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChosainJoho(entity));
        }

        return businessList;
    }

    /**
     * 調査員情報{@link ChosainJoho}を保存します。
     *
     * @param 調査員情報 {@link ChosainJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save調査員情報(ChosainJoho 調査員情報) {
        requireNonNull(調査員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報"));
        if (!調査員情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(調査員情報.toEntity());
    }
}
