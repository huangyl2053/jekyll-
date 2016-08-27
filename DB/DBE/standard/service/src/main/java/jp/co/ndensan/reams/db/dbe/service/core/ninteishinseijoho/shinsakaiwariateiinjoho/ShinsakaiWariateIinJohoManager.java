/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinsakaiwariateiinjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5503ShinsakaiWariateIinJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5503ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当委員情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 suguangjun
 */
public class ShinsakaiWariateIinJohoManager {

    private final DbT5503ShinsakaiWariateIinJohoDac 介護認定審査会割当委員情報Dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiWariateIinJohoManager() {
        this.介護認定審査会割当委員情報Dac = InstanceProvider.create(DbT5503ShinsakaiWariateIinJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5503ShinsakaiWariateIinJohoDac}
     */
    ShinsakaiWariateIinJohoManager(DbT5503ShinsakaiWariateIinJohoDac 介護認定審査会割当委員情報Dac) {
        this.介護認定審査会割当委員情報Dac = 介護認定審査会割当委員情報Dac;
    }

    /**
     * 主キーに合致する介護認定審査会割当委員情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @return ShinsakaiWariateIinJoho
     */
    @Transaction
    public ShinsakaiWariateIinJoho get介護認定審査会割当委員情報(
            RString 介護認定審査会開催番号, RString 介護認定審査会委員コード) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        DbT5503ShinsakaiWariateIinJohoEntity entity = 介護認定審査会割当委員情報Dac.selectByKey(介護認定審査会開催番号, 介護認定審査会委員コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiWariateIinJoho(entity);
    }

    /**
     * 介護認定審査会割当委員情報{@link ShinsakaiWariateIinJoho}を保存します。
     *
     * @param 介護認定審査会割当委員情報 介護認定審査会割当委員情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save介護認定審査会割当委員情報(ShinsakaiWariateIinJoho 介護認定審査会割当委員情報) {
        requireNonNull(介護認定審査会割当委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報"));
        if (!介護認定審査会割当委員情報.hasChanged()) {
            return false;
        }
        介護認定審査会割当委員情報 = 介護認定審査会割当委員情報.modifiedModel();
        return 1 == 介護認定審査会割当委員情報Dac.save(介護認定審査会割当委員情報.toEntity());
    }

}
