/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KagoMoshitate;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3059KagoMoshitateDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤申立を管理するクラスです。
 */
public class KagoMoshitateManager {

    private final DbT3059KagoMoshitateDac dac;

    /**
     * コンストラクタです。
     */
    public KagoMoshitateManager() {
        dac = InstanceProvider.create(DbT3059KagoMoshitateDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3059KagoMoshitateDac}
     */
    KagoMoshitateManager(DbT3059KagoMoshitateDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する過誤申立を返します。
     *
     * @param 事業所番号 JigyoshoNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 履歴番号 RirekiNo
     * @return KagoMoshitate
     */
    @Transaction
    public KagoMoshitate get過誤申立(
            JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            int 履歴番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3059KagoMoshitateEntity entity = dac.selectByKey(
                事業所番号,
                被保険者番号,
                サービス提供年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KagoMoshitate(entity);
    }

    /**
     * 過誤申立を全件返します。
     *
     * @return List<KagoMoshitate>
     */
    @Transaction
    public List<KagoMoshitate> get過誤申立一覧() {
        List<KagoMoshitate> businessList = new ArrayList<>();

        for (DbT3059KagoMoshitateEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KagoMoshitate(entity));
        }

        return businessList;
    }

    /**
     * 過誤申立{@link KagoMoshitate}を保存します。
     *
     * @param 過誤申立 {@link KagoMoshitate}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save過誤申立(KagoMoshitate 過誤申立) {
        requireNonNull(過誤申立, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤申立"));
        if (!過誤申立.hasChanged()) {
            return false;
        }
        return 1 == dac.save(過誤申立.toEntity());
    }

    /**
     * 過誤申立{@link KagoMoshitate}を保存します。
     *
     * @param 過誤申立 {@link KagoMoshitate}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveOrdelete過誤申立(KagoMoshitate 過誤申立) {
        requireNonNull(過誤申立, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤申立"));
        if (!過誤申立.hasChanged()) {
            return false;
        }
        return 1 == dac.saveOrDelete(過誤申立.toEntity());
    }
}
