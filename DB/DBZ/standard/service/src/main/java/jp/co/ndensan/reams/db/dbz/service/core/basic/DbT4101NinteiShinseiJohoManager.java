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
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4101NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定申請情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-013 huangh
 */
public class DbT4101NinteiShinseiJohoManager {

    private final DbT4101NinteiShinseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public DbT4101NinteiShinseiJohoManager() {
        dac = InstanceProvider.create(DbT4101NinteiShinseiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4101NinteiShinseiJohoDac}
     */
    DbT4101NinteiShinseiJohoManager(DbT4101NinteiShinseiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link DbT4101NinteiShinseiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link DbT4101NinteiShinseiJohoManager}のインスタンス
     */
    public static DbT4101NinteiShinseiJohoManager createInstance() {
        return InstanceProvider.create(DbT4101NinteiShinseiJohoManager.class);
    }

    /**
     * 主キーに合致する要介護認定申請情報を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return DbT4101NinteiShinseiJoho
     */
    @Transaction
    public DbT4101NinteiShinseiJoho get要介護認定申請情報(
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT4101NinteiShinseiJohoEntity entity = dac.selectByKey(
                申請書管理番号).get();
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DbT4101NinteiShinseiJoho(entity);
    }

    /**
     * 要介護認定申請情報を全件返します。
     *
     * @return DbT4101NinteiShinseiJoho{@code list}
     */
    @Transaction
    public List<DbT4101NinteiShinseiJoho> get要介護認定申請情報一覧() {
        List<DbT4101NinteiShinseiJoho> businessList = new ArrayList<>();

        for (DbT4101NinteiShinseiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new DbT4101NinteiShinseiJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定申請情報{@link DbT4101NinteiShinseiJoho}を保存します。
     *
     * @param 要介護認定申請情報 {@link DbT4101NinteiShinseiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定申請情報(DbT4101NinteiShinseiJoho 要介護認定申請情報) {
        requireNonNull(要介護認定申請情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定申請情報"));
        if (!要介護認定申請情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定申請情報.toEntity());
    }
}
