/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoShukei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求集計を管理するクラスです。
 */
public class JutakuKaishuRiyushoTesuryoShukeiManager {

    private final DbT3096JutakuKaishuRiyushoTesuryoShukeiDac dac;

    /**
     * コンストラクタです。
     */
    public JutakuKaishuRiyushoTesuryoShukeiManager() {
        dac = InstanceProvider.create(DbT3096JutakuKaishuRiyushoTesuryoShukeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3096JutakuKaishuRiyushoTesuryoShukeiDac}
     */
    JutakuKaishuRiyushoTesuryoShukeiManager(DbT3096JutakuKaishuRiyushoTesuryoShukeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する住宅改修理由書作成手数料請求集計を返します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 集計開始年月 ShukeiKaishiYM
     * @param 履歴番号 RirekiNo
     * @return JutakuKaishuRiyushoTesuryoShukei
     */
    @Transaction
    public JutakuKaishuRiyushoTesuryoShukei get住宅改修理由書作成手数料請求集計(
            HokenshaNo 証記載保険者番号,
            FlexibleYearMonth 集計開始年月,
            Decimal 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(集計開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity = dac.selectByKey(
                証記載保険者番号,
                集計開始年月,
                履歴番号.intValue());
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JutakuKaishuRiyushoTesuryoShukei(entity);
    }

    /**
     * 住宅改修理由書作成手数料請求集計を全件返します。
     *
     * @return List<JutakuKaishuRiyushoTesuryoShukei>
     */
    @Transaction
    public List<JutakuKaishuRiyushoTesuryoShukei> get住宅改修理由書作成手数料請求集計一覧() {
        List<JutakuKaishuRiyushoTesuryoShukei> businessList = new ArrayList<>();

        for (DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JutakuKaishuRiyushoTesuryoShukei(entity));
        }

        return businessList;
    }

    /**
     * 住宅改修理由書作成手数料請求集計{@link JutakuKaishuRiyushoTesuryoShukei}を保存します。
     *
     * @param 住宅改修理由書作成手数料請求集計 {@link JutakuKaishuRiyushoTesuryoShukei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save住宅改修理由書作成手数料請求集計(JutakuKaishuRiyushoTesuryoShukei 住宅改修理由書作成手数料請求集計) {
        requireNonNull(住宅改修理由書作成手数料請求集計, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求集計"));
        if (!住宅改修理由書作成手数料請求集計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(住宅改修理由書作成手数料請求集計.toEntity());
    }
}
