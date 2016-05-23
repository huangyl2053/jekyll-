/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-021 sunhaidi
 */
public class ShinsakaiWariateJohoManager {

    private final DbT5502ShinsakaiWariateJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiWariateJohoManager() {
        dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5502ShinsakaiWariateJohoDac}
     */
    ShinsakaiWariateJohoManager(DbT5502ShinsakaiWariateJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護認定審査会割当情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 申請書管理番号 申請書管理番号
     * @return ShinsakaiWariateJoho
     */
    @Transaction
    public ShinsakaiWariateJoho get介護認定審査会割当情報(
            RString 介護認定審査会開催番号,
            ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));

        DbT5502ShinsakaiWariateJohoEntity entity = dac.selectByKey(
                介護認定審査会開催番号,
                申請書管理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiWariateJoho(entity);
    }

    /**
     * 介護認定審査会割当情報を全件返します。
     *
     * @return ShinsakaiWariateJohoの{@code list}
     */
    @Transaction
    public List<ShinsakaiWariateJoho> get介護認定審査会割当情報一覧() {
        List<ShinsakaiWariateJoho> businessList = new ArrayList<>();

        for (DbT5502ShinsakaiWariateJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiWariateJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会割当情報{@link ShinsakaiWariateJoho}を保存します。
     *
     * @param 介護認定審査会割当情報 {@link ShinsakaiWariateJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会割当情報(ShinsakaiWariateJoho 介護認定審査会割当情報) {
        requireNonNull(介護認定審査会割当情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報"));
        if (!介護認定審査会割当情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会割当情報.toEntity());
    }
}
