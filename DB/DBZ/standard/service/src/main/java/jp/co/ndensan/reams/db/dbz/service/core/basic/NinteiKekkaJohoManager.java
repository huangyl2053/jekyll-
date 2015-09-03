/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5102NinteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5102NinteiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定結果情報を管理するクラスです。
 */
public class NinteiKekkaJohoManager {

    private final DbT5102NinteiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiKekkaJohoManager() {
        dac = InstanceProvider.create(DbT5102NinteiKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5102NinteiKekkaJohoDac}
     */
    NinteiKekkaJohoManager(DbT5102NinteiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定結果情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiKekkaJoho
     */
    @Transaction
    public NinteiKekkaJoho get要介護認定結果情報(
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT5102NinteiKekkaJohoEntity entity = dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiKekkaJoho(entity);
    }

    /**
     * 要介護認定結果情報を全件返します。
     *
     * @return NinteiKekkaJohoの{@code list}
     */
    @Transaction
    public List<NinteiKekkaJoho> get要介護認定結果情報一覧() {
        List<NinteiKekkaJoho> businessList = new ArrayList<>();

        for (DbT5102NinteiKekkaJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiKekkaJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定結果情報{@link NinteiKekkaJoho}を保存します。
     *
     * @param 要介護認定結果情報 {@link NinteiKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定結果情報(NinteiKekkaJoho 要介護認定結果情報) {
        requireNonNull(要介護認定結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報"));
        if (!要介護認定結果情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定結果情報.toEntity());
    }
}
