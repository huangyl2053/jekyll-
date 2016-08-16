/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoKofuKaishu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7037ShoKofuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7037ShoKofuKaishuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 証交付回収を管理するクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class ShoKofuKaishuManager {

    private final DbT7037ShoKofuKaishuDac dac;

    /**
     * コンストラクタです。
     */
    public ShoKofuKaishuManager() {
        dac = InstanceProvider.create(DbT7037ShoKofuKaishuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7037ShoKofuKaishuDac}
     */
    ShoKofuKaishuManager(DbT7037ShoKofuKaishuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する証交付回収を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 交付証種類 KofuShoShurui
     * @param 履歴番号 RirekiNo
     * @return ShoKofuKaishu
     */
    @Transaction
    public ShoKofuKaishu get証交付回収(
            HihokenshaNo 被保険者番号,
            RString 交付証種類,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7037ShoKofuKaishuEntity entity = dac.selectByKey(
                被保険者番号,
                交付証種類,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoKofuKaishu(entity);
    }

    /**
     * 証交付回収を全件返します。
     *
     * @return List<ShoKofuKaishu>
     */
    @Transaction
    public List<ShoKofuKaishu> get証交付回収一覧() {
        List<ShoKofuKaishu> businessList = new ArrayList<>();

        for (DbT7037ShoKofuKaishuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShoKofuKaishu(entity));
        }

        return businessList;
    }

    /**
     * 証交付回収{@link ShoKofuKaishu}を保存します。
     *
     * @param 証交付回収 {@link ShoKofuKaishu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save証交付回収(ShoKofuKaishu 証交付回収) {
        requireNonNull(証交付回収, UrSystemErrorMessages.値がnull.getReplacedMessage("証交付回収"));
        if (!証交付回収.hasChanged()) {
            return false;
        }
        return 1 == dac.save(証交付回収.toEntity());
    }

    /**
     * 主キーに合致する証交付回収を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 交付証種類 KofuShoShurui
     * @return ShoKofuKaishu
     */
    @Transaction
    public ShoKofuKaishu get証交付回収(
            HihokenshaNo 被保険者番号,
            RString 交付証種類) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(交付証種類, UrSystemErrorMessages.値がnull.getReplacedMessage("交付証種類"));

        DbT7037ShoKofuKaishuEntity entity = dac.selectByKey(
                被保険者番号,
                交付証種類
        );
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShoKofuKaishu(entity);
    }

}
