/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GappeiJoho;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7055GappeiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併情報を管理するクラスです。
 */
public class GappeiJohoManager {

    private final DbT7055GappeiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public GappeiJohoManager() {
        dac = InstanceProvider.create(DbT7055GappeiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7055GappeiJohoDac}
     */
    GappeiJohoManager(DbT7055GappeiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する合併情報を返します。
     *
     * @param 合併年月日 GappeiYMD
     * @param 地域番号 ChiikiNo
     * @return GappeiJoho
     */
    @Transaction
    public GappeiJoho get合併情報(
            FlexibleDate 合併年月日,
            RString 地域番号) {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));

        DbT7055GappeiJohoEntity entity = dac.selectByKey(
                合併年月日,
                地域番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GappeiJoho(entity);
    }

    /**
     * 合併情報を全件返します。
     *
     * @return List<GappeiJoho>
     */
    @Transaction
    public List<GappeiJoho> get合併情報一覧() {
        List<GappeiJoho> businessList = new ArrayList<>();

        for (DbT7055GappeiJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new GappeiJoho(entity));
        }

        return businessList;
    }

    /**
     * 合併情報{@link GappeiJoho}を保存します。
     *
     * @param 合併情報 {@link GappeiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save合併情報(GappeiJoho 合併情報) {
        requireNonNull(合併情報, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));
        if (!合併情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(合併情報.toEntity());
    }
}
