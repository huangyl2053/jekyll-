/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.TenshutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1011TenshutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1011TenshutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転出保留対象者を管理するクラスです。
 */
public class TenshutsuHoryuTaishoshaManager {

    private final DbT1011TenshutsuHoryuTaishoshaDac dac;

    /**
     * コンストラクタです。
     */
    public TenshutsuHoryuTaishoshaManager() {
        dac = InstanceProvider.create(DbT1011TenshutsuHoryuTaishoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1011TenshutsuHoryuTaishoshaDac}
     */
    TenshutsuHoryuTaishoshaManager(DbT1011TenshutsuHoryuTaishoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する転出保留対象者を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return TenshutsuHoryuTaishosha
     */
    @Transaction
    public TenshutsuHoryuTaishosha get転出保留対象者(
            ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT1011TenshutsuHoryuTaishoshaEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TenshutsuHoryuTaishosha(entity);
    }

    /**
     * 転出保留対象者を全件返します。
     *
     * @return List<TenshutsuHoryuTaishosha>
     */
    @Transaction
    public List<TenshutsuHoryuTaishosha> get転出保留対象者一覧() {
        List<TenshutsuHoryuTaishosha> businessList = new ArrayList<>();

        for (DbT1011TenshutsuHoryuTaishoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TenshutsuHoryuTaishosha(entity));
        }

        return businessList;
    }

    /**
     * 転出保留対象者{@link TenshutsuHoryuTaishosha}を保存します。
     *
     * @param 転出保留対象者 {@link TenshutsuHoryuTaishosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save転出保留対象者(TenshutsuHoryuTaishosha 転出保留対象者) {
        requireNonNull(転出保留対象者, UrSystemErrorMessages.値がnull.getReplacedMessage("転出保留対象者"));
        if (!転出保留対象者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(転出保留対象者.toEntity());
    }
}
