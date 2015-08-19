/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給額計算結果を管理するクラスです。
 */
public class KogakuGassanShikyuGakuKeisanKekkaManager {

    private final DbT3072KogakuGassanShikyuGakuKeisanKekkaDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShikyuGakuKeisanKekkaManager() {
        dac = InstanceProvider.create(DbT3072KogakuGassanShikyuGakuKeisanKekkaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3072KogakuGassanShikyuGakuKeisanKekkaDac}
     */
    KogakuGassanShikyuGakuKeisanKekkaManager(DbT3072KogakuGassanShikyuGakuKeisanKekkaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算支給額計算結果を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanShikyuGakuKeisanKekka
     */
    @Transaction
    public KogakuGassanShikyuGakuKeisanKekka get高額合算支給額計算結果(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuGassanShikyuGakuKeisanKekka(entity);
    }

    /**
     * 高額合算支給額計算結果を全件返します。
     *
     * @return List<KogakuGassanShikyuGakuKeisanKekka>
     */
    @Transaction
    public List<KogakuGassanShikyuGakuKeisanKekka> get高額合算支給額計算結果一覧() {
        List<KogakuGassanShikyuGakuKeisanKekka> businessList = new ArrayList<>();

        for (DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanShikyuGakuKeisanKekka(entity));
        }

        return businessList;
    }

    /**
     * 高額合算支給額計算結果{@link KogakuGassanShikyuGakuKeisanKekka}を保存します。
     *
     * @param 高額合算支給額計算結果 {@link KogakuGassanShikyuGakuKeisanKekka}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算支給額計算結果(KogakuGassanShikyuGakuKeisanKekka 高額合算支給額計算結果) {
        requireNonNull(高額合算支給額計算結果, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給額計算結果"));
        if (!高額合算支給額計算結果.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算支給額計算結果.toEntity());
    }
}
