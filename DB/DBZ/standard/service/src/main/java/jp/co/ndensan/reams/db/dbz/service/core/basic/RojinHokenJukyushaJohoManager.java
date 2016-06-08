/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.RojinHokenJukyushaJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7005RojinHokenJukyushaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老人保健受給者情報を管理するクラスです。
 */
public class RojinHokenJukyushaJohoManager {

    private final DbT7005RojinHokenJukyushaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public RojinHokenJukyushaJohoManager() {
        dac = InstanceProvider.create(DbT7005RojinHokenJukyushaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7005RojinHokenJukyushaJohoDac}
     */
    RojinHokenJukyushaJohoManager(DbT7005RojinHokenJukyushaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する老人保健受給者情報を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @return RojinHokenJukyushaJoho
     */
    @Transaction
    public RojinHokenJukyushaJoho get老人保健受給者情報(
            ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbT7005RojinHokenJukyushaJohoEntity entity = dac.selectByKey(
                識別コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RojinHokenJukyushaJoho(entity);
    }

    /**
     * 老人保健受給者情報を全件返します。
     *
     * @return List<RojinHokenJukyushaJoho>
     */
    @Transaction
    public List<RojinHokenJukyushaJoho> get老人保健受給者情報一覧() {
        List<RojinHokenJukyushaJoho> businessList = new ArrayList<>();

        for (DbT7005RojinHokenJukyushaJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RojinHokenJukyushaJoho(entity));
        }

        return businessList;
    }

    /**
     * 老人保健受給者情報{@link RojinHokenJukyushaJoho}を保存します。
     *
     * @param 老人保健受給者情報 {@link RojinHokenJukyushaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save老人保健受給者情報(RojinHokenJukyushaJoho 老人保健受給者情報) {
        requireNonNull(老人保健受給者情報, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者情報"));
        if (!老人保健受給者情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(老人保健受給者情報.toEntity());
    }
}
