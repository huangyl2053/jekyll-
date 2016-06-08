/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChosainJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5913ChosainJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
     * 主キーに合致する調査員情報を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return ChosainJoho
     */
    @Transaction
    public ChosainJoho get調査員情報(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));

        DbT5913ChosainJohoEntity entity = dac.selectByKey(
                市町村コード,
                認定調査委託先コード,
                認定調査員コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChosainJoho(entity);
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
