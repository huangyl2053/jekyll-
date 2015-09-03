/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.basic.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5116IchijiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定一次判定結果情報を管理するクラスです。
 */
public class IchijiHanteiKekkaJohoManager {

    private final DbT5116IchijiHanteiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public IchijiHanteiKekkaJohoManager() {
        dac = InstanceProvider.create(DbT5116IchijiHanteiKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5116IchijiHanteiKekkaJohoDac}
     */
    IchijiHanteiKekkaJohoManager(DbT5116IchijiHanteiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する要介護認定一次判定結果情報を返します。
     *
     *
     * @return IchijiHanteiKekkaJoho
     */
    @Transaction
    public IchijiHanteiKekkaJoho get要介護認定一次判定結果情報() {

        DbT5116IchijiHanteiKekkaJohoEntity entity = dac.selectByKey();
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new IchijiHanteiKekkaJoho(entity);
    }

    /**
     * 要介護認定一次判定結果情報を全件返します。
     *
     * @return IchijiHanteiKekkaJohoの{@code list}
     */
    @Transaction
    public List<IchijiHanteiKekkaJoho> get要介護認定一次判定結果情報一覧() {
        List<IchijiHanteiKekkaJoho> businessList = new ArrayList<>();

        for (DbT5116IchijiHanteiKekkaJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new IchijiHanteiKekkaJoho(entity));
        }

        return businessList;
    }

    /**
     * 要介護認定一次判定結果情報{@link IchijiHanteiKekkaJoho}を保存します。
     *
     * @param 要介護認定一次判定結果情報 {@link IchijiHanteiKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定一次判定結果情報(IchijiHanteiKekkaJoho 要介護認定一次判定結果情報) {
        requireNonNull(要介護認定一次判定結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定結果情報"));
        if (!要介護認定一次判定結果情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定一次判定結果情報.toEntity());
    }
}
