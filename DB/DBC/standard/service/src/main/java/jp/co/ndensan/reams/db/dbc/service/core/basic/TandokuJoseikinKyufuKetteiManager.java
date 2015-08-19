/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.TandokuJoseikinKyufuKettei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3097TandokuJoseikinKyufuKetteiDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村単独助成金給付決定を管理するクラスです。
 */
public class TandokuJoseikinKyufuKetteiManager {

    private final DbT3097TandokuJoseikinKyufuKetteiDac dac;

    /**
     * コンストラクタです。
     */
    public TandokuJoseikinKyufuKetteiManager() {
        dac = InstanceProvider.create(DbT3097TandokuJoseikinKyufuKetteiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3097TandokuJoseikinKyufuKetteiDac}
     */
    TandokuJoseikinKyufuKetteiManager(DbT3097TandokuJoseikinKyufuKetteiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する市町村単独助成金給付決定を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return TandokuJoseikinKyufuKettei
     */
    @Transaction
    public TandokuJoseikinKyufuKettei get市町村単独助成金給付決定(
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3097TandokuJoseikinKyufuKetteiEntity entity = dac.selectByKey(
                被保険者番号,
                受付年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TandokuJoseikinKyufuKettei(entity);
    }

    /**
     * 市町村単独助成金給付決定を全件返します。
     *
     * @return List<TandokuJoseikinKyufuKettei>
     */
    @Transaction
    public List<TandokuJoseikinKyufuKettei> get市町村単独助成金給付決定一覧() {
        List<TandokuJoseikinKyufuKettei> businessList = new ArrayList<>();

        for (DbT3097TandokuJoseikinKyufuKetteiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TandokuJoseikinKyufuKettei(entity));
        }

        return businessList;
    }

    /**
     * 市町村単独助成金給付決定{@link TandokuJoseikinKyufuKettei}を保存します。
     *
     * @param 市町村単独助成金給付決定 {@link TandokuJoseikinKyufuKettei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save市町村単独助成金給付決定(TandokuJoseikinKyufuKettei 市町村単独助成金給付決定) {
        requireNonNull(市町村単独助成金給付決定, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付決定"));
        if (!市町村単独助成金給付決定.hasChanged()) {
            return false;
        }
        return 1 == dac.save(市町村単独助成金給付決定.toEntity());
    }
}
