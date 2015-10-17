/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GappeiShichoson;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村を管理するクラスです。
 */
public class GappeiShichosonManager {

    private final DbT7056GappeiShichosonDac dac;

    /**
     * コンストラクタです。
     */
    public GappeiShichosonManager() {
        dac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7056GappeiShichosonDac}
     */
    GappeiShichosonManager(DbT7056GappeiShichosonDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する合併市町村を返します。
     *
     * @param 合併年月日 GappeiYMD
     * @param 地域番号 ChiikiNo
     * @param 旧市町村コード KyuShichosonCode
     * @return GappeiShichoson
     */
    @Transaction
    public GappeiShichoson get合併市町村(
            FlexibleDate 合併年月日,
            RString 地域番号,
            LasdecCode 旧市町村コード) {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));

        DbT7056GappeiShichosonEntity entity = dac.selectByKey(
                合併年月日,
                地域番号,
                旧市町村コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GappeiShichoson(entity);
    }

    /**
     * 合併市町村を全件返します。
     *
     * @return List<GappeiShichoson>
     */
    @Transaction
    public List<GappeiShichoson> get合併市町村一覧() {
        List<GappeiShichoson> businessList = new ArrayList<>();

        for (DbT7056GappeiShichosonEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new GappeiShichoson(entity));
        }

        return businessList;
    }

    /**
     * 合併市町村{@link GappeiShichoson}を保存します。
     *
     * @param 合併市町村 {@link GappeiShichoson}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save合併市町村(GappeiShichoson 合併市町村) {
        requireNonNull(合併市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村"));
        if (!合併市町村.hasChanged()) {
            return false;
        }
        return 1 == dac.save(合併市町村.toEntity());
    }
}
