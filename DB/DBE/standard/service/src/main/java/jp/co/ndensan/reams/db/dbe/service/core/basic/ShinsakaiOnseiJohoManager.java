/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiOnseiJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5512ShinsakaiOnseiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会音声情報を管理するクラスです。
 */
public class ShinsakaiOnseiJohoManager {

    private final DbT5512ShinsakaiOnseiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiOnseiJohoManager() {
        dac = InstanceProvider.create(DbT5512ShinsakaiOnseiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5512ShinsakaiOnseiJohoDac}
     */
    ShinsakaiOnseiJohoManager(DbT5512ShinsakaiOnseiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護認定審査会音声情報を返します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 連番 連番
     * @return ShinsakaiOnseiJoho
     */
    @Transaction
    public ShinsakaiOnseiJoho get介護認定審査会音声情報(
            int 介護認定審査会開催番号,
            int 連番) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5512ShinsakaiOnseiJohoEntity entity = dac.selectByKey(
                介護認定審査会開催番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShinsakaiOnseiJoho(entity);
    }

    /**
     * 介護認定審査会音声情報を全件返します。
     *
     * @return ShinsakaiOnseiJohoの{@code list}
     */
    @Transaction
    public List<ShinsakaiOnseiJoho> get介護認定審査会音声情報一覧() {
        List<ShinsakaiOnseiJoho> businessList = new ArrayList<>();

        for (DbT5512ShinsakaiOnseiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShinsakaiOnseiJoho(entity));
        }

        return businessList;
    }

    /**
     * 介護認定審査会音声情報{@link ShinsakaiOnseiJoho}を保存します。
     *
     * @param 介護認定審査会音声情報 {@link ShinsakaiOnseiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会音声情報(ShinsakaiOnseiJoho 介護認定審査会音声情報) {
        requireNonNull(介護認定審査会音声情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会音声情報"));
        if (!介護認定審査会音声情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会音声情報.toEntity());
    }
}
