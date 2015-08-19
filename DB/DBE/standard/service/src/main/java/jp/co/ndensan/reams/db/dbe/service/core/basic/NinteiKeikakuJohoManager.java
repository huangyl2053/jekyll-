/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5123NinteiKeikakuJohoDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定計画情報を管理するクラスです。
 */
public class NinteiKeikakuJohoManager {

    private final DbT5123NinteiKeikakuJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiKeikakuJohoManager() {
        dac = InstanceProvider.create(DbT5123NinteiKeikakuJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5123NinteiKeikakuJohoDac}
     */
    NinteiKeikakuJohoManager(DbT5123NinteiKeikakuJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定計画情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiKeikakuJoho
     */
    @Transaction
    public NinteiKeikakuJoho get要介護認定計画情報(
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT5123NinteiKeikakuJohoEntity entity = dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiKeikakuJoho(entity);
    }

    /**
     * 要介護認定計画情報を全件返します。
     *
     * @return NinteiKeikakuJohoの{@code list}
     */
    @Transaction
    public List<NinteiKeikakuJoho> get要介護認定計画情報一覧() {
        List<NinteiKeikakuJoho> businessList = new ArrayList<>();

        for (DbT5123NinteiKeikakuJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiKeikakuJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定計画情報{@link NinteiKeikakuJoho}を保存します。
     *
     * @param 要介護認定計画情報 {@link NinteiKeikakuJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定計画情報(NinteiKeikakuJoho 要介護認定計画情報) {
        requireNonNull(要介護認定計画情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定計画情報"));
        if (!要介護認定計画情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定計画情報.toEntity());
    }
}
