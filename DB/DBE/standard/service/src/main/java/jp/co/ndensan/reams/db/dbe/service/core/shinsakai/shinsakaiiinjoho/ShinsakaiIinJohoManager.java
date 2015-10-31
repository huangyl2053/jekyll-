/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiiinjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5594ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5594ShinsakaiIinJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員情報を管理するクラスです。
 */
public class ShinsakaiIinJohoManager {

    private final DbT5594ShinsakaiIinJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinJohoManager() {
        dac = InstanceProvider.create(DbT5594ShinsakaiIinJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5594ShinsakaiIinJohoDac}
     */
    ShinsakaiIinJohoManager(DbT5594ShinsakaiIinJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護認定審査会委員情報を返します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return ShinsakaiIinJoho
     */
    @Transaction
    public ShinsakaiIinJoho get介護認定審査会委員情報(
            RString 介護認定審査会委員コード) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));

        DbT5594ShinsakaiIinJohoEntity entity = dac.selectByKey(
                介護認定審査会委員コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiIinJoho(entity);
    }

    /**
     * 介護認定審査会委員情報を全件返します。
     *
     * @return ShinsakaiIinJohoの{@code list}
     */
    @Transaction
    public List<ShinsakaiIinJoho> get介護認定審査会委員情報一覧() {
        List<ShinsakaiIinJoho> businessList = new ArrayList<>();

        for (DbT5594ShinsakaiIinJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiIinJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会委員情報{@link ShinsakaiIinJoho}を保存します。
     *
     * @param 介護認定審査会委員情報 {@link ShinsakaiIinJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会委員情報(ShinsakaiIinJoho 介護認定審査会委員情報) {
        requireNonNull(介護認定審査会委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報"));
        if (!介護認定審査会委員情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会委員情報.toEntity());
    }
}
