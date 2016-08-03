/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求明細を管理するクラスです。
 */
public class JutakuKaishuRiyushoTesuryoMeisaiManager {

    private final DbT3095JutakuKaishuRiyushoTesuryoMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public JutakuKaishuRiyushoTesuryoMeisaiManager() {
        dac = InstanceProvider.create(DbT3095JutakuKaishuRiyushoTesuryoMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3095JutakuKaishuRiyushoTesuryoMeisaiDac}
     */
    JutakuKaishuRiyushoTesuryoMeisaiManager(DbT3095JutakuKaishuRiyushoTesuryoMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する住宅改修理由書作成手数料請求明細を返します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return JutakuKaishuRiyushoTesuryoMeisai
     */
    @Transaction
    public JutakuKaishuRiyushoTesuryoMeisai get住宅改修理由書作成手数料請求明細(
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity = dac.selectByKey(
                証記載保険者番号,
                被保険者番号,
                履歴番号.intValue());
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JutakuKaishuRiyushoTesuryoMeisai(entity);
    }

    /**
     * 住宅改修理由書作成手数料請求明細を全件返します。
     *
     * @return List<JutakuKaishuRiyushoTesuryoMeisai>
     */
    @Transaction
    public List<JutakuKaishuRiyushoTesuryoMeisai> get住宅改修理由書作成手数料請求明細一覧() {
        List<JutakuKaishuRiyushoTesuryoMeisai> businessList = new ArrayList<>();

        for (DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JutakuKaishuRiyushoTesuryoMeisai(entity));
        }

        return businessList;
    }

    /**
     * 住宅改修理由書作成手数料請求明細{@link JutakuKaishuRiyushoTesuryoMeisai}を保存します。
     *
     * @param 住宅改修理由書作成手数料請求明細 {@link JutakuKaishuRiyushoTesuryoMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save住宅改修理由書作成手数料請求明細(JutakuKaishuRiyushoTesuryoMeisai 住宅改修理由書作成手数料請求明細) {
        requireNonNull(住宅改修理由書作成手数料請求明細, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求明細"));
        if (!住宅改修理由書作成手数料請求明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(住宅改修理由書作成手数料請求明細.toEntity());
    }
}
