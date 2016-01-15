/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShinseishoKanyureki;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3069KogakuGassanShinseishoKanyurekiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算申請書加入歴を管理するクラスです。
 */
public class KogakuGassanShinseishoKanyurekiManager {

    private final DbT3069KogakuGassanShinseishoKanyurekiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShinseishoKanyurekiManager() {
        dac = InstanceProvider.create(DbT3069KogakuGassanShinseishoKanyurekiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3069KogakuGassanShinseishoKanyurekiDac}
     */
    KogakuGassanShinseishoKanyurekiManager(DbT3069KogakuGassanShinseishoKanyurekiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算申請書加入歴を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 整理番号 SeiriNo
     * @param 加入歴番号 KanyurekiNo
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanShinseishoKanyureki
     */
    @Transaction
    public KogakuGassanShinseishoKanyureki get高額合算申請書加入歴(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            RString 加入歴番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(加入歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加入歴番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3069KogakuGassanShinseishoKanyurekiEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                保険者番号,
                整理番号,
                加入歴番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuGassanShinseishoKanyureki(entity);
    }

    /**
     * 高額合算申請書加入歴を全件返します。
     *
     * @return List<KogakuGassanShinseishoKanyureki>
     */
    @Transaction
    public List<KogakuGassanShinseishoKanyureki> get高額合算申請書加入歴一覧() {
        List<KogakuGassanShinseishoKanyureki> businessList = new ArrayList<>();

        for (DbT3069KogakuGassanShinseishoKanyurekiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanShinseishoKanyureki(entity));
        }

        return businessList;
    }

    /**
     * 高額合算申請書加入歴{@link KogakuGassanShinseishoKanyureki}を保存します。
     *
     * @param 高額合算申請書加入歴 {@link KogakuGassanShinseishoKanyureki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算申請書加入歴(KogakuGassanShinseishoKanyureki 高額合算申請書加入歴) {
        requireNonNull(高額合算申請書加入歴, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算申請書加入歴"));
        if (!高額合算申請書加入歴.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算申請書加入歴.toEntity());
    }
}
