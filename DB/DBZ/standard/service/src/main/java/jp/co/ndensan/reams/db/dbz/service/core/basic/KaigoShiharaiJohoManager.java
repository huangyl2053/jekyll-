/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoShiharaiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7004KaigoShiharaiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7004KaigoShiharaiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護支払情報を管理するクラスです。
 */
public class KaigoShiharaiJohoManager {

    private final DbT7004KaigoShiharaiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoShiharaiJohoManager() {
        dac = InstanceProvider.create(DbT7004KaigoShiharaiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7004KaigoShiharaiJohoDac}
     */
    KaigoShiharaiJohoManager(DbT7004KaigoShiharaiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護支払情報を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 科目コード KamokuCode
     * @param 決定年月日 KetteiYMD
     * @return KaigoShiharaiJoho
     */
    @Transaction
    public KaigoShiharaiJoho get介護支払情報(
            ShikibetsuCode 識別コード,
            KamokuCode 科目コード,
            FlexibleDate 決定年月日) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(科目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("科目コード"));
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));

        DbT7004KaigoShiharaiJohoEntity entity = dac.selectByKey(
                識別コード,
                科目コード,
                決定年月日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoShiharaiJoho(entity);
    }

    /**
     * 介護支払情報を全件返します。
     *
     * @return List<KaigoShiharaiJoho>
     */
    @Transaction
    public List<KaigoShiharaiJoho> get介護支払情報一覧() {
        List<KaigoShiharaiJoho> businessList = new ArrayList<>();

        for (DbT7004KaigoShiharaiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoShiharaiJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護支払情報{@link KaigoShiharaiJoho}を保存します。
     *
     * @param 介護支払情報 {@link KaigoShiharaiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護支払情報(KaigoShiharaiJoho 介護支払情報) {
        requireNonNull(介護支払情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護支払情報"));
        if (!介護支払情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護支払情報.toEntity());
    }
}
