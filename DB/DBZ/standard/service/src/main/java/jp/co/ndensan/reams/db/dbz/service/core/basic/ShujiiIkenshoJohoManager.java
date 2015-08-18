/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書情報を管理するクラスです。
 */
public class ShujiiIkenshoJohoManager {

    private final DbT5302ShujiiIkenshoJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoJohoManager() {
        dac = InstanceProvider.create(DbT5302ShujiiIkenshoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5302ShujiiIkenshoJohoDac}
     */
    ShujiiIkenshoJohoManager(DbT5302ShujiiIkenshoJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定主治医意見書情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return ShujiiIkenshoJoho
     */
    @Transaction
    public ShujiiIkenshoJoho get要介護認定主治医意見書情報(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));

        DbT5302ShujiiIkenshoJohoEntity entity = dac.selectByKey(申請書管理番号, 主治医意見書作成依頼履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiIkenshoJoho(entity);
    }

    /**
     * 要介護認定主治医意見書情報を全件返します。
     *
     * @return ShujiiIkenshoJohoの{@code list}
     */
    @Transaction
    public List<ShujiiIkenshoJoho> get要介護認定主治医意見書情報一覧() {
        List<ShujiiIkenshoJoho> businessList = new ArrayList<>();

        for (DbT5302ShujiiIkenshoJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShujiiIkenshoJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定主治医意見書情報{@link ShujiiIkenshoJoho}を保存します。
     *
     * @param 要介護認定主治医意見書情報 {@link ShujiiIkenshoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定主治医意見書情報(ShujiiIkenshoJoho 要介護認定主治医意見書情報) {
        requireNonNull(要介護認定主治医意見書情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報"));
        if (!要介護認定主治医意見書情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定主治医意見書情報.toEntity());
    }
}
