/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.syujii.shujiijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.shujiijoho.ShujiiJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5912ShujiiJohoDac;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医情報を管理するクラスです。
 */
public class ShujiiJohoManager {

    private final DbT5912ShujiiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiJohoManager() {
        dac = InstanceProvider.create(DbT5912ShujiiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5912ShujiiJohoDac}
     */
    ShujiiJohoManager(DbT5912ShujiiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する主治医情報を返します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @return ShujiiJoho
     */
    @Transaction
    public ShujiiJoho get主治医情報(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード,
            RString 主治医コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));

        DbT5912ShujiiJohoEntity entity = dac.selectByKey(
                市町村コード,
                主治医医療機関コード,
                主治医コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiJoho(entity);
    }

    /**
     * 主治医情報{@link ShujiiJoho}を保存します。
     *
     * @param 主治医情報 {@link ShujiiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save主治医情報(ShujiiJoho 主治医情報) {
        requireNonNull(主治医情報, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報"));
        if (!主治医情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(主治医情報.toEntity());
    }
}
