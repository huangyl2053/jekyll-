/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2001ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護徴収方法を管理するクラスです。
 *
 * @reamsid_L DBB-1760-010 sunhui
 */
public class ChoshuHohoManager {

    private final DbT2001ChoshuHohoDac dac;

    /**
     * コンストラクタです。
     */
    public ChoshuHohoManager() {
        dac = InstanceProvider.create(DbT2001ChoshuHohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2001ChoshuHohoDac}
     */
    ChoshuHohoManager(DbT2001ChoshuHohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護徴収方法を返します。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return ChoshuHoho
     */
    @Transaction
    public ChoshuHoho get介護徴収方法(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT2001ChoshuHohoEntity entity = dac.selectByKey(
                賦課年度,
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChoshuHoho(entity);
    }

    /**
     * 検索条件に合致する介護徴収方法を返します。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @return ChoshuHoho
     */
    @Transaction
    public ChoshuHoho get介護徴収方法(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbT2001ChoshuHohoEntity entity = dac.select(
                賦課年度,
                被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChoshuHoho(entity);
    }

    /**
     * 介護徴収方法を全件返します。
     *
     * @return List<ChoshuHoho>
     */
    @Transaction
    public List<ChoshuHoho> get介護徴収方法一覧() {
        List<ChoshuHoho> businessList = new ArrayList<>();

        for (DbT2001ChoshuHohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChoshuHoho(entity));
        }

        return businessList;
    }

    /**
     * 介護徴収方法{@link ChoshuHoho}を保存します。
     *
     * @param 介護徴収方法 {@link ChoshuHoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護徴収方法(ChoshuHoho 介護徴収方法) {
        requireNonNull(介護徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("介護徴収方法"));
        if (!介護徴収方法.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護徴収方法.toEntity());
    }
}
