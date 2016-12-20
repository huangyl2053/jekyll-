/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5911ShujiiIryoKikanJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関情報を管理するクラスです。
 */
public class ShujiiIryoKikanJohoManager {

    private final DbT5911ShujiiIryoKikanJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIryoKikanJohoManager() {
        dac = InstanceProvider.create(DbT5911ShujiiIryoKikanJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5911ShujiiIryoKikanJohoDac}
     */
    ShujiiIryoKikanJohoManager(DbT5911ShujiiIryoKikanJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する主治医医療機関情報を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return ShujiiIryoKikanJoho
     */
    @Transaction
    public ShujiiIryoKikanJoho get主治医医療機関情報(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));

        DbT5911ShujiiIryoKikanJohoEntity entity = dac.selectByKey(
                市町村コード,
                主治医医療機関コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiIryoKikanJoho(entity);
    }

    /**
     * 主治医医療機関情報を全件返します。
     *
     * @return ShujiiIryoKikanJohoの{@code list}
     */
    @Transaction
    public List<ShujiiIryoKikanJoho> get主治医医療機関情報一覧() {
        List<ShujiiIryoKikanJoho> businessList = new ArrayList<>();

        for (DbT5911ShujiiIryoKikanJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShujiiIryoKikanJoho(entity));
        }

        return businessList;
    }

    /**
     * 主治医医療機関情報{@link ShujiiIryoKikanJoho}を保存します。
     *
     * @param 主治医医療機関情報 {@link ShujiiIryoKikanJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save主治医医療機関情報(ShujiiIryoKikanJoho 主治医医療機関情報) {
        requireNonNull(主治医医療機関情報, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関情報"));
        if (!主治医医療機関情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(主治医医療機関情報.toEntity());
    }
}
