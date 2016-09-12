/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kogakugassankyufujisseki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3075KogakuGassanKyufuJissekiDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4001JukyushaDaichoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算給付実績照会クラスです。
 *
 * @reamsid_L DBC-3010-030 linghuhang
 *
 */
public class KogakuGassanKyufuJissekiFinder {

    private final DbT3075KogakuGassanKyufuJissekiDac 高額合算給付実績;
    private final DbT3105SogoJigyoTaishoshaDac 総合事業対象者;
    private final DbT4001JukyushaDaichoDac 受給者台帳;

    /**
     * コンストラクタです。
     */
    KogakuGassanKyufuJissekiFinder(DbT3075KogakuGassanKyufuJissekiDac dac,
            DbT3105SogoJigyoTaishoshaDac dbt3015, DbT4001JukyushaDaichoDac dbt4001) {
        this.高額合算給付実績 = dac;
        this.総合事業対象者 = dbt3015;
        this.受給者台帳 = dbt4001;
    }

    /**
     * コンストラクタです。
     */
    public KogakuGassanKyufuJissekiFinder() {
        this.高額合算給付実績 = InstanceProvider.create(DbT3075KogakuGassanKyufuJissekiDac.class);
        this.総合事業対象者 = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
        this.受給者台帳 = InstanceProvider.create(DbT4001JukyushaDaichoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuGassanKyufuJissekiFinder}のインスタンスを返します。
     *
     * @return KogakuGassanKyufuJissekiFinder
     */
    public static KogakuGassanKyufuJissekiFinder createInstance() {
        return InstanceProvider.create(KogakuGassanKyufuJissekiFinder.class);
    }

    /**
     * 資格取得除外者一覧取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return SearchResult<KogakuGassanKyufuJisseki>
     */
    @Transaction
    public SearchResult<KogakuGassanKyufuJisseki> getKogakuGassanKyufuJisseki(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        List<DbT3075KogakuGassanKyufuJissekiEntity> entityList = 高額合算給付実績.getKogakuGassanKyufuJisseki(被保険者番号);
        if (entityList.isEmpty()) {
            return SearchResult.of(Collections.<KogakuGassanKyufuJisseki>emptyList(), 0, false);
        }
        List<KogakuGassanKyufuJisseki> businessList = new ArrayList<>();
        for (DbT3075KogakuGassanKyufuJissekiEntity entity : entityList) {
            businessList.add(new KogakuGassanKyufuJisseki(entity));
        }
        return SearchResult.of(businessList, 0, false);
    }

    /**
     * データ存在チェックする。
     *
     * @param 被保険者番号 被保険者番号
     * @return 受給者台帳、総合事業対象者のどちらか存在しない場合、true
     */
    @Transaction
    public boolean isデータ存在チェック(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        boolean isデータ存在 = false;
        List<DbT4001JukyushaDaichoEntity> 受給者台帳データ = 受給者台帳.get受給者台帳(被保険者番号);
        List<DbT3105SogoJigyoTaishoshaEntity> 総合事業対象者データ = 総合事業対象者.get総合事業対象者(被保険者番号);
        if (受給者台帳データ == null || 受給者台帳データ.isEmpty() || 総合事業対象者データ == null || 総合事業対象者データ.isEmpty()) {
            isデータ存在 = true;
        }
        return isデータ存在;
    }

    /**
     * 高額合算給付実績データ存在チェックする。
     *
     * @param 被保険者番号 被保険者番号
     * @return 高額合算給付実績か存在しない場合、true
     */
    @Transaction
    public boolean is高額合算給付実績チェック(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        boolean isデータ存在 = false;
        List<DbT3075KogakuGassanKyufuJissekiEntity> 高額合算給付実績データ = 高額合算給付実績.get高額合算給付実績(被保険者番号);
        if (高額合算給付実績データ == null || 高額合算給付実績データ.isEmpty()) {
            isデータ存在 = true;
        }
        return isデータ存在;
    }
}
