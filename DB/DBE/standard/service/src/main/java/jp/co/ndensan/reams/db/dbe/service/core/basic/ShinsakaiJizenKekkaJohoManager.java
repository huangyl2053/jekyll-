/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiJizenKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5508ShinsakaiJizenKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会事前審査結果情報を管理するクラスです。
 */
public class ShinsakaiJizenKekkaJohoManager {

    private final DbT5508ShinsakaiJizenKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiJizenKekkaJohoManager() {
        dac = InstanceProvider.create(DbT5508ShinsakaiJizenKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5508ShinsakaiJizenKekkaJohoDac}
     */
    ShinsakaiJizenKekkaJohoManager(DbT5508ShinsakaiJizenKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護認定審査会事前審査結果情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 介護認定審査会審査順 介護認定審査会審査順
     * @return ShinsakaiJizenKekkaJoho
     */
    @Transaction
    public ShinsakaiJizenKekkaJoho get介護認定審査会事前審査結果情報(
            int 介護認定審査会開催番号,
            RString 介護認定審査会委員コード,
            int 介護認定審査会審査順) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(介護認定審査会審査順, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順"));

        DbT5508ShinsakaiJizenKekkaJohoEntity entity = dac.selectByKey(
                介護認定審査会開催番号,
                介護認定審査会委員コード,
                介護認定審査会審査順);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiJizenKekkaJoho(entity);
    }

    /**
     * 介護認定審査会事前審査結果情報を全件返します。
     *
     * @return ShinsakaiJizenKekkaJohoの{@code list}
     */
    @Transaction
    public List<ShinsakaiJizenKekkaJoho> get介護認定審査会事前審査結果情報一覧() {
        List<ShinsakaiJizenKekkaJoho> businessList = new ArrayList<>();

        for (DbT5508ShinsakaiJizenKekkaJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiJizenKekkaJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会事前審査結果情報{@link ShinsakaiJizenKekkaJoho}を保存します。
     *
     * @param 介護認定審査会事前審査結果情報 {@link ShinsakaiJizenKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会事前審査結果情報(ShinsakaiJizenKekkaJoho 介護認定審査会事前審査結果情報) {
        requireNonNull(介護認定審査会事前審査結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会事前審査結果情報"));
        if (!介護認定審査会事前審査結果情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会事前審査結果情報.toEntity());
    }
}
