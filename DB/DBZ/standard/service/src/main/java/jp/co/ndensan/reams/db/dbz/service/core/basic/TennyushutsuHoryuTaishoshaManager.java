/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.TennyushutsuHoryuTaishosha;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1010TennyushutsuHoryuTaishoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転入保留対象者を管理するクラスです。
 */
public class TennyushutsuHoryuTaishoshaManager {

    private final DbT1010TennyushutsuHoryuTaishoshaDac dac;

    /**
     * コンストラクタです。
     */
    public TennyushutsuHoryuTaishoshaManager() {
        dac = InstanceProvider.create(DbT1010TennyushutsuHoryuTaishoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1010TennyushutsuHoryuTaishoshaDac}
     */
    TennyushutsuHoryuTaishoshaManager(DbT1010TennyushutsuHoryuTaishoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する転入保留対象者を返します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return TennyushutsuHoryuTaishosha
     */
    @Transaction
    public TennyushutsuHoryuTaishosha get転入保留対象者(
            ShikibetsuCode 識別コード,
            Decimal 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT1010TennyushutsuHoryuTaishoshaEntity entity = dac.selectByKey(
                識別コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TennyushutsuHoryuTaishosha(entity);
    }

    /**
     * 転入保留対象者を全件返します。
     *
     * @return List<TennyushutsuHoryuTaishosha>
     */
    @Transaction
    public List<TennyushutsuHoryuTaishosha> get転入保留対象者一覧() {
        List<TennyushutsuHoryuTaishosha> businessList = new ArrayList<>();

        for (DbT1010TennyushutsuHoryuTaishoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TennyushutsuHoryuTaishosha(entity));
        }

        return businessList;
    }

    /**
     * 転入保留対象者{@link TennyushutsuHoryuTaishosha}を保存します。
     *
     * @param 転入保留対象者 {@link TennyushutsuHoryuTaishosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save転入保留対象者(TennyushutsuHoryuTaishosha 転入保留対象者) {
        requireNonNull(転入保留対象者, UrSystemErrorMessages.値がnull.getReplacedMessage("転入保留対象者"));
        if (!転入保留対象者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(転入保留対象者.toEntity());
    }
}
