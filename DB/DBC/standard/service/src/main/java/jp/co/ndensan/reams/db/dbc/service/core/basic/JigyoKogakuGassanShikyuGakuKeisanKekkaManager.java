/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuGakuKeisanKekka;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額合算支給額計算結果を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 chenyadong
 */
public class JigyoKogakuGassanShikyuGakuKeisanKekkaManager {

    private final DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoKogakuGassanShikyuGakuKeisanKekkaManager() {
        dac = InstanceProvider.create(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac}
     */
    JigyoKogakuGassanShikyuGakuKeisanKekkaManager(DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する事業高額合算支給額計算結果を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     * @return JigyoKogakuGassanShikyuGakuKeisanKekka
     */
    @Transaction
    public JigyoKogakuGassanShikyuGakuKeisanKekka get事業高額合算支給額計算結果(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoKogakuGassanShikyuGakuKeisanKekka(entity);
    }

    /**
     * 事業高額合算支給額計算結果を全件返します。
     *
     * @return JigyoKogakuGassanShikyuGakuKeisanKekkaの{@code list}
     */
    @Transaction
    public List<JigyoKogakuGassanShikyuGakuKeisanKekka> get事業高額合算支給額計算結果一覧() {
        List<JigyoKogakuGassanShikyuGakuKeisanKekka> businessList = new ArrayList<>();

        for (DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuGassanShikyuGakuKeisanKekka(entity));
        }

        return businessList;
    }

    /**
     * 主キーに合致する高額合算支給額計算結果を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 証記載保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @return List<JigyoKogakuGassanShikyuGakuKeisanKekka>
     */
    @Transaction
    public List<JigyoKogakuGassanShikyuGakuKeisanKekka> get事業高額合算支給額計算結果一覧(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号) {
        List<JigyoKogakuGassanShikyuGakuKeisanKekka> businessList = new ArrayList<>();
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        for (DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity entity : dac.selectAll(被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号)) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuGassanShikyuGakuKeisanKekka(entity));
        }

        return businessList;

    }
}
