/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額合算支給不支給決定を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 chenyadong
 */
public class JigyoKogakuGassanShikyuFushikyuKetteiManager {

    private final DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoKogakuGassanShikyuFushikyuKetteiManager() {
        dac = InstanceProvider.create(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac}
     */
    JigyoKogakuGassanShikyuFushikyuKetteiManager(DbT3174JigyoKogakuGassanShikyuFushikyuKetteiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する事業高額合算支給不支給決定を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 履歴番号 履歴番号
     * @return JigyoKogakuGassanShikyuFushikyuKettei
     */
    @Transaction
    public JigyoKogakuGassanShikyuFushikyuKettei get事業高額合算支給不支給決定(
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

        DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoKogakuGassanShikyuFushikyuKettei(entity);
    }

    /**
     * 事業高額合算支給不支給決定を全件返します。
     *
     * @return JigyoKogakuGassanShikyuFushikyuKetteiの{@code list}
     */
    @Transaction
    public List<JigyoKogakuGassanShikyuFushikyuKettei> get事業高額合算支給不支給決定一覧() {
        List<JigyoKogakuGassanShikyuFushikyuKettei> businessList = new ArrayList<>();
        for (DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuGassanShikyuFushikyuKettei(entity));
        }

        return businessList;
    }

    /**
     * 事業高額合算支給不支給決定{@link JigyoKogakuGassanShikyuFushikyuKettei}を保存します。
     *
     * @param 事業高額合算支給不支給決定 {@link JigyoKogakuGassanShikyuFushikyuKettei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save事業高額合算支給不支給決定(JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算支給不支給決定) {
        requireNonNull(事業高額合算支給不支給決定, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額合算支給不支給決定"));
        if (!事業高額合算支給不支給決定.hasChanged()) {
            return false;
        }
        return 1 == dac.save(事業高額合算支給不支給決定.toEntity());
    }

    /**
     * 事業高額合算支給不支給決定を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return JigyoKogakuGassanShikyuFushikyuKetteiの{@code list}
     */
    @Transaction
    public List<JigyoKogakuGassanShikyuFushikyuKettei> get事業高額合算支給不支給決定一覧(HihokenshaNo 被保険者番号) {
        List<JigyoKogakuGassanShikyuFushikyuKettei> businessList = new ArrayList<>();
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        for (DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity entity : dac.selectAll(被保険者番号)) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuGassanShikyuFushikyuKettei(entity));
        }
        return businessList;
    }

}
