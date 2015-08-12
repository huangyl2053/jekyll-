/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定完了情報を管理するクラスです。
 */
public class NinteiKanryoJohoManager {

    private final DbT5105NinteiKanryoJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiKanryoJohoManager() {
        dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5105NinteiKanryoJohoDac}
     */
    NinteiKanryoJohoManager(DbT5105NinteiKanryoJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定完了情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiKanryoJoho
     */
    @Transaction
    public NinteiKanryoJoho get要介護認定完了情報(
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT5105NinteiKanryoJohoEntity entity = dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiKanryoJoho(entity);
    }

    /**
     * 要介護認定完了情報を全件返します。
     *
     * @return NinteiKanryoJohoの{@code list}
     */
    @Transaction
    public List<NinteiKanryoJoho> get要介護認定完了情報一覧() {
        List<NinteiKanryoJoho> businessList = new ArrayList<>();

        for (DbT5105NinteiKanryoJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiKanryoJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定完了情報{@link NinteiKanryoJoho}を保存します。
     *
     * @param 要介護認定完了情報 {@link NinteiKanryoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定完了情報(NinteiKanryoJoho 要介護認定完了情報) {
        requireNonNull(要介護認定完了情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定完了情報"));
        if (!要介護認定完了情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定完了情報.toEntity());
    }
}
