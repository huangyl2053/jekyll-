/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-011 sunhaidi
 */
public class NinteiShinseiJohoManager {

    private final DbT5101NinteiShinseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiShinseiJohoManager() {
        dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5101NinteiShinseiJohoDac}
     */
    NinteiShinseiJohoManager(DbT5101NinteiShinseiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteiShinseiJohoManager}のインスタンス
     */
    public static NinteiShinseiJohoManager createInstance() {
        return InstanceProvider.create(NinteiShinseiJohoManager.class);
    }

    /**
     * 主キーに合致する要介護認定申請情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return NinteiShinseiJoho
     */
    @Transaction
    public NinteiShinseiJoho get要介護認定申請情報(
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT5101NinteiShinseiJohoEntity entity = dac.selectByKey(
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteiShinseiJoho(entity);
    }

    /**
     * 要介護認定申請情報を全件返します。
     *
     * @return NinteiShinseiJohoの{@code list}
     */
    @Transaction
    public List<NinteiShinseiJoho> get要介護認定申請情報一覧() {
        List<NinteiShinseiJoho> businessList = new ArrayList<>();

        for (DbT5101NinteiShinseiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteiShinseiJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定申請情報{@link NinteiShinseiJoho}を保存します。
     *
     * @param 要介護認定申請情報 {@link NinteiShinseiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定申請情報(NinteiShinseiJoho 要介護認定申請情報) {
        requireNonNull(要介護認定申請情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報"));
        if (!要介護認定申請情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定申請情報.toEntity());
    }

    /**
     * 広域内要介護認定申請情報{@link NinteiShinseiJoho}を保存します。
     *
     * @param 要介護認定申請情報 {@link NinteiShinseiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save広域内要介護認定申請情報(NinteiShinseiJoho 要介護認定申請情報) {
        requireNonNull(要介護認定申請情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報"));
        if (!要介護認定申請情報.hasChanged()) {
            return false;
        }
        DbT5101NinteiShinseiJohoEntity entity = 要介護認定申請情報.toEntity();
        entity.setState(EntityDataState.Modified);
        return 1 == dac.save(entity);
    }
}
