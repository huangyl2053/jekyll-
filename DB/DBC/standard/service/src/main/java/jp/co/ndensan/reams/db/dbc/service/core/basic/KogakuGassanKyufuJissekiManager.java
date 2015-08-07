/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算給付実績を管理するクラスです。
 */
public class KogakuGassanKyufuJissekiManager {

    private final DbT3075KogakuGassanKyufuJissekiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuGassanKyufuJissekiManager() {
        dac = InstanceProvider.create(DbT3075KogakuGassanKyufuJissekiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3075KogakuGassanKyufuJissekiDac}
     */
    KogakuGassanKyufuJissekiManager(DbT3075KogakuGassanKyufuJissekiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算給付実績を返します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseiSeiriNo
     * @param 整理番号 SeiriNo
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanKyufuJisseki
     */
    @Transaction
    public KogakuGassanKyufuJisseki get高額合算給付実績(
             KokanShikibetsuCode 交換情報識別番号,
            HihokenshaNo 被保険者番号,
            RString 支給申請書整理番号,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3075KogakuGassanKyufuJissekiEntity entity = dac.selectByKey(
                交換情報識別番号,
                被保険者番号,
                支給申請書整理番号,
                整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuGassanKyufuJisseki(entity);
    }

    /**
     * 高額合算給付実績を全件返します。
     *
     * @return List<KogakuGassanKyufuJisseki>
     */
    @Transaction
    public List<KogakuGassanKyufuJisseki> get高額合算給付実績一覧() {
        List<KogakuGassanKyufuJisseki> businessList = new ArrayList<>();

        for (DbT3075KogakuGassanKyufuJissekiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanKyufuJisseki(entity));
        }

        return businessList;
    }

    /**
     * 高額合算給付実績{@link KogakuGassanKyufuJisseki}を保存します。
     *
     * @param 高額合算給付実績 {@link KogakuGassanKyufuJisseki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算給付実績(KogakuGassanKyufuJisseki 高額合算給付実績) {
        requireNonNull(高額合算給付実績, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算給付実績"));
        if (!高額合算給付実績.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算給付実績.toEntity());
    }
}
