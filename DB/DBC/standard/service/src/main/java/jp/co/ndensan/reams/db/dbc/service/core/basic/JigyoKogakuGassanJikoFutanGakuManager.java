/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanJikoFutanGaku;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額合算自己負担額を管理するクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JigyoKogakuGassanJikoFutanGakuManager {

    private final DbT3170JigyoKogakuGassanJikoFutanGakuDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoKogakuGassanJikoFutanGakuManager() {
        dac = InstanceProvider.create(DbT3170JigyoKogakuGassanJikoFutanGakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3170JigyoKogakuGassanJikoFutanGakuDac}
     */
    JigyoKogakuGassanJikoFutanGakuManager(DbT3170JigyoKogakuGassanJikoFutanGakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算自己負担額を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanJikoFutanGaku
     */
    @Transaction
    public JigyoKogakuGassanJikoFutanGaku get高額合算自己負担額(
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

        DbT3170JigyoKogakuGassanJikoFutanGakuEntity entity = dac.selectByKeys(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoKogakuGassanJikoFutanGaku(entity);
    }

    /**
     * 高額合算自己負担額を全件返します。
     *
     * @return List<JigyoKogakuGassanJikoFutanGaku>
     */
    @Transaction
    public List<JigyoKogakuGassanJikoFutanGaku> get高額合算自己負担額一覧() {
        List<JigyoKogakuGassanJikoFutanGaku> businessList = new ArrayList<>();

        for (DbT3170JigyoKogakuGassanJikoFutanGakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuGassanJikoFutanGaku(entity));
        }

        return businessList;
    }

    /**
     * 被保険者番号で高額合算自己負担額を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<KogakuGassanJikoFutanGaku>
     */
    @Transaction
    public List<JigyoKogakuGassanJikoFutanGaku> getBy被保険者番号(HihokenshaNo 被保険者番号) {
        List<JigyoKogakuGassanJikoFutanGaku> businessList = new ArrayList<>();

        for (DbT3170JigyoKogakuGassanJikoFutanGakuEntity entity : dac.selectByHihokenshaNo(被保険者番号)) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuGassanJikoFutanGaku(entity));
        }

        return businessList;
    }

    /**
     * 主キーに合致する高額合算自己負担額を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @return KogakuGassanJikoFutanGaku
     */
    @Transaction
    public JigyoKogakuGassanJikoFutanGaku getMax履歴番号(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));

        DbT3170JigyoKogakuGassanJikoFutanGakuEntity entity = dac.selectMaxRirekiNo(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号
        );
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoKogakuGassanJikoFutanGaku(entity);
    }

    /**
     * 高額合算自己負担額{@link JigyoKogakuGassanJikoFutanGaku}を保存します。
     *
     * @param 高額合算自己負担額 {@link JigyoKogakuGassanJikoFutanGaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算自己負担額(JigyoKogakuGassanJikoFutanGaku 高額合算自己負担額) {
        requireNonNull(高額合算自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算自己負担額"));
        if (!高額合算自己負担額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算自己負担額.toEntity());
    }
}
