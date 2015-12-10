/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaItakusakiJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5910NinteichosaItakusakiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先情報を管理するクラスです。
 */
public class NinteichosaItakusakiJohoManager {

    private final DbT5910NinteichosaItakusakiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosaItakusakiJohoManager() {
        dac = InstanceProvider.create(DbT5910NinteichosaItakusakiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5910NinteichosaItakusakiJohoDac}
     */
    NinteichosaItakusakiJohoManager(DbT5910NinteichosaItakusakiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査委託先情報を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return NinteichosaItakusakiJoho
     */
    @Transaction
    public NinteichosaItakusakiJoho get認定調査委託先情報(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));

        DbT5910NinteichosaItakusakiJohoEntity entity = dac.selectByKey(
                市町村コード,
                認定調査委託先コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosaItakusakiJoho(entity);
    }

    /**
     * 認定調査委託先情報を全件返します。
     *
     * @return NinteichosaItakusakiJohoの{@code list}
     */
    @Transaction
    public List<NinteichosaItakusakiJoho> get認定調査委託先情報一覧() {
        List<NinteichosaItakusakiJoho> businessList = new ArrayList<>();

        for (DbT5910NinteichosaItakusakiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosaItakusakiJoho(entity));
        }

        return businessList;
    }

    /**
     * 認定調査委託先情報{@link NinteichosaItakusakiJoho}を保存します。
     *
     * @param 認定調査委託先情報 {@link NinteichosaItakusakiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査委託先情報(NinteichosaItakusakiJoho 認定調査委託先情報) {
        requireNonNull(認定調査委託先情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報"));
        if (!認定調査委託先情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査委託先情報.toEntity());
    }
}
