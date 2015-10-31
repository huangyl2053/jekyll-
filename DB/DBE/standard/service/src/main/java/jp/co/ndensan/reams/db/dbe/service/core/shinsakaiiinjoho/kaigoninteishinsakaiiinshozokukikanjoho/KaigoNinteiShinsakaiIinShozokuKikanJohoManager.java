/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJoho;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員所属機関情報を管理するクラスです。
 */
public class KaigoNinteiShinsakaiIinShozokuKikanJohoManager {

    private final DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoManager() {
        dac = InstanceProvider.create(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac}
     */
    KaigoNinteiShinsakaiIinShozokuKikanJohoManager(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護認定審査会委員所属機関情報を返します。
     *
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 連番 連番
     * @return KaigoNinteiShinsakaiIinShozokuKikanJoho
     */
    @Transaction
    public KaigoNinteiShinsakaiIinShozokuKikanJoho get介護認定審査会委員所属機関情報(
            RString 介護認定審査会委員コード,
            int 連番) {
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity = dac.selectByKey(
                介護認定審査会委員コード,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KaigoNinteiShinsakaiIinShozokuKikanJoho(entity);
    }

    /**
     * 介護認定審査会委員所属機関情報を全件返します。
     *
     * @return KaigoNinteiShinsakaiIinShozokuKikanJohoの{@code list}
     */
    @Transaction
    public List<KaigoNinteiShinsakaiIinShozokuKikanJoho> get介護認定審査会委員所属機関情報一覧() {
        List<KaigoNinteiShinsakaiIinShozokuKikanJoho> businessList = new ArrayList<>();

        for (DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KaigoNinteiShinsakaiIinShozokuKikanJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会委員所属機関情報{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}を保存します。
     *
     * @param 介護認定審査会委員所属機関情報 {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会委員所属機関情報(KaigoNinteiShinsakaiIinShozokuKikanJoho 介護認定審査会委員所属機関情報) {
        requireNonNull(介護認定審査会委員所属機関情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員所属機関情報"));
        if (!介護認定審査会委員所属機関情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会委員所属機関情報.toEntity());
    }
}
