/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報を管理するクラスです。
 */
public class NinteichosaIraiJohoManager {

    private final DbT5201NinteichosaIraiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosaIraiJohoManager() {
        dac = InstanceProvider.create(DbT5201NinteichosaIraiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5201NinteichosaIraiJohoDac}
     */
    NinteichosaIraiJohoManager(DbT5201NinteichosaIraiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査依頼情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return NinteichosaIraiJoho
     */
    @Transaction
    public NinteichosaIraiJoho get認定調査依頼情報(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbT5201NinteichosaIraiJohoEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosaIraiJoho(entity);
    }

    /**
     * 認定調査依頼情報を全件返します。
     *
     * @return NinteichosaIraiJohoの{@code list}
     */
    @Transaction
    public List<NinteichosaIraiJoho> get認定調査依頼情報一覧() {
        List<NinteichosaIraiJoho> businessList = new ArrayList<>();

        for (DbT5201NinteichosaIraiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosaIraiJoho(entity));
        }

        return businessList;
    }

    /**
     * 認定調査依頼情報{@link NinteichosaIraiJoho}を保存します。
     *
     * @param 認定調査依頼情報 {@link NinteichosaIraiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査依頼情報(NinteichosaIraiJoho 認定調査依頼情報) {
        requireNonNull(認定調査依頼情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼情報"));
        if (!認定調査依頼情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査依頼情報.toEntity());
    }
}
