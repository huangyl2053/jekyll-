/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiKaisaiYoteiJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5501ShinsakaiKaisaiYoteiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催予定情報を管理するクラスです。
 */
public class ShinsakaiKaisaiYoteiJohoManager {

    private final DbT5501ShinsakaiKaisaiYoteiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiYoteiJohoManager() {
        dac = InstanceProvider.create(DbT5501ShinsakaiKaisaiYoteiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5501ShinsakaiKaisaiYoteiJohoDac}
     */
    ShinsakaiKaisaiYoteiJohoManager(DbT5501ShinsakaiKaisaiYoteiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護認定審査会開催予定情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @return ShinsakaiKaisaiYoteiJoho
     */
    @Transaction
    public ShinsakaiKaisaiYoteiJoho get介護認定審査会開催予定情報(
            RString 介護認定審査会開催番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));

        DbT5501ShinsakaiKaisaiYoteiJohoEntity entity = dac.selectByKey(
                介護認定審査会開催番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiKaisaiYoteiJoho(entity);
    }

    /**
     * 介護認定審査会開催予定情報を全件返します。
     *
     * @return ShinsakaiKaisaiYoteiJohoの{@code list}
     */
    @Transaction
    public List<ShinsakaiKaisaiYoteiJoho> get介護認定審査会開催予定情報一覧() {
        List<ShinsakaiKaisaiYoteiJoho> businessList = new ArrayList<>();

        for (DbT5501ShinsakaiKaisaiYoteiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiKaisaiYoteiJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会開催予定情報{@link ShinsakaiKaisaiYoteiJoho}を保存します。
     *
     * @param 介護認定審査会開催予定情報 {@link ShinsakaiKaisaiYoteiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会開催予定情報(ShinsakaiKaisaiYoteiJoho 介護認定審査会開催予定情報) {
        requireNonNull(介護認定審査会開催予定情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催予定情報"));
        if (!介護認定審査会開催予定情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会開催予定情報.toEntity());
    }
}
