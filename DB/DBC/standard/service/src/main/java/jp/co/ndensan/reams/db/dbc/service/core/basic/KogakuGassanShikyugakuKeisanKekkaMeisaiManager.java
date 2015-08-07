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
 * 高額合算支給額計算結果明細を管理するクラスです。
 */
public class KogakuGassanShikyugakuKeisanKekkaMeisaiManager {

    private final DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShikyugakuKeisanKekkaMeisaiManager() {
        dac = InstanceProvider.create(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiDac}
     */
    KogakuGassanShikyugakuKeisanKekkaMeisaiManager(DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算支給額計算結果明細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 明細番号 MeisanNo
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanShikyugakuKeisanKekkaMeisai
     */
    @Transaction
    public KogakuGassanShikyugakuKeisanKekkaMeisai get高額合算支給額計算結果明細(
             HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            RString 明細番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                明細番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuGassanShikyugakuKeisanKekkaMeisai(entity);
    }

    /**
     * 高額合算支給額計算結果明細を全件返します。
     *
     * @return List<KogakuGassanShikyugakuKeisanKekkaMeisai>
     */
    @Transaction
    public List<KogakuGassanShikyugakuKeisanKekkaMeisai> get高額合算支給額計算結果明細一覧() {
        List<KogakuGassanShikyugakuKeisanKekkaMeisai> businessList = new ArrayList<>();

        for (DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanShikyugakuKeisanKekkaMeisai(entity));
        }

        return businessList;
    }

    /**
     * 高額合算支給額計算結果明細{@link KogakuGassanShikyugakuKeisanKekkaMeisai}を保存します。
     *
     * @param 高額合算支給額計算結果明細 {@link KogakuGassanShikyugakuKeisanKekkaMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算支給額計算結果明細(KogakuGassanShikyugakuKeisanKekkaMeisai 高額合算支給額計算結果明細) {
        requireNonNull(高額合算支給額計算結果明細, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果明細"));
        if (!高額合算支給額計算結果明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算支給額計算結果明細.toEntity());
    }
}
