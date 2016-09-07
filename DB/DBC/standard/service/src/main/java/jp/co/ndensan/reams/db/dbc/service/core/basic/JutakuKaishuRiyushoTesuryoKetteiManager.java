/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JutakuKaishuRiyushoTesuryoKettei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求決定を管理するクラスです。
 */
public class JutakuKaishuRiyushoTesuryoKetteiManager {

    private final DbT3094JutakuKaishuRiyushoTesuryoKetteiDac dac;

    /**
     * コンストラクタです。
     */
    public JutakuKaishuRiyushoTesuryoKetteiManager() {
        dac = InstanceProvider.create(DbT3094JutakuKaishuRiyushoTesuryoKetteiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3094JutakuKaishuRiyushoTesuryoKetteiDac}
     */
    JutakuKaishuRiyushoTesuryoKetteiManager(DbT3094JutakuKaishuRiyushoTesuryoKetteiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する住宅改修理由書作成手数料請求決定を返します。
     *
     * @param 介護住宅改修理由書作成事業者番号 RiyushoSakuseiJigyoshaNo
     * @param 決定年月日 KetteiYMD
     * @param 履歴番号 RirekiNo
     * @return JutakuKaishuRiyushoTesuryoKettei
     */
    @Transaction
    public JutakuKaishuRiyushoTesuryoKettei get住宅改修理由書作成手数料請求決定(
            JigyoshaNo 介護住宅改修理由書作成事業者番号,
            FlexibleDate 決定年月日,
            Decimal 履歴番号) {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity = dac.selectByKey(
                介護住宅改修理由書作成事業者番号,
                決定年月日,
                履歴番号.intValue());
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JutakuKaishuRiyushoTesuryoKettei(entity);
    }

    /**
     * 住宅改修理由書作成手数料請求決定を全件返します。
     *
     * @return List<JutakuKaishuRiyushoTesuryoKettei>
     */
    @Transaction
    public List<JutakuKaishuRiyushoTesuryoKettei> get住宅改修理由書作成手数料請求決定一覧() {
        List<JutakuKaishuRiyushoTesuryoKettei> businessList = new ArrayList<>();

        for (DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JutakuKaishuRiyushoTesuryoKettei(entity));
        }

        return businessList;
    }

    /**
     * 住宅改修理由書作成手数料請求決定{@link JutakuKaishuRiyushoTesuryoKettei}を保存します。
     *
     * @param 住宅改修理由書作成手数料請求決定 {@link JutakuKaishuRiyushoTesuryoKettei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save住宅改修理由書作成手数料請求決定(JutakuKaishuRiyushoTesuryoKettei 住宅改修理由書作成手数料請求決定) {
        requireNonNull(住宅改修理由書作成手数料請求決定, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求決定"));
        if (!住宅改修理由書作成手数料請求決定.hasChanged()) {
            return false;
        }
        return 1 == dac.save(住宅改修理由書作成手数料請求決定.toEntity());
    }
}
