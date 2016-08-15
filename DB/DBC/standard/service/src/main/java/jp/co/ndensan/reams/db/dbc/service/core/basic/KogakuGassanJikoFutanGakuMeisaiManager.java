/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanJikoFutanGakuMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算自己負担額明細を管理するクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class KogakuGassanJikoFutanGakuMeisaiManager {

    private final DbT3071KogakuGassanJikoFutanGakuMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuGassanJikoFutanGakuMeisaiManager() {
        dac = InstanceProvider.create(DbT3071KogakuGassanJikoFutanGakuMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3071KogakuGassanJikoFutanGakuMeisaiDac}
     */
    KogakuGassanJikoFutanGakuMeisaiManager(DbT3071KogakuGassanJikoFutanGakuMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算自己負担額明細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 対象月 TaishoM
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanJikoFutanGakuMeisai
     */
    @Transaction
    public KogakuGassanJikoFutanGakuMeisai get高額合算自己負担額明細(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            RString 対象月,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                対象月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuGassanJikoFutanGakuMeisai(entity);
    }

    /**
     * 対象月除く合致する高額合算自己負担額明細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 履歴番号 RirekiNo
     * @return List<KogakuGassanJikoFutanGakuMeisai>
     */
    @Transaction
    public List<KogakuGassanJikoFutanGakuMeisai> get対象月除く負担額明細(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        List<KogakuGassanJikoFutanGakuMeisai> businessList = new ArrayList<>();

        for (DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity : dac.selectMeisai(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                履歴番号
        )) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanJikoFutanGakuMeisai(entity));
        }

        return businessList;
    }

    /**
     * 高額合算自己負担額明細を全件返します。
     *
     * @return List<KogakuGassanJikoFutanGakuMeisai>
     */
    @Transaction
    public List<KogakuGassanJikoFutanGakuMeisai> get高額合算自己負担額明細一覧() {
        List<KogakuGassanJikoFutanGakuMeisai> businessList = new ArrayList<>();

        for (DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanJikoFutanGakuMeisai(entity));
        }

        return businessList;
    }

    /**
     * 高額合算自己負担額明細{@link KogakuGassanJikoFutanGakuMeisai}を保存します。
     *
     * @param 高額合算自己負担額明細 {@link KogakuGassanJikoFutanGakuMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算自己負担額明細(KogakuGassanJikoFutanGakuMeisai 高額合算自己負担額明細
    ) {
        requireNonNull(高額合算自己負担額明細, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算自己負担額明細"));
        if (!高額合算自己負担額明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算自己負担額明細.toEntity());
    }
}
