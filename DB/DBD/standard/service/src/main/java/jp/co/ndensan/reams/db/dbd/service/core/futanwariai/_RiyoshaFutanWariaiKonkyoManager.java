/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.futanwariai;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3115RiyoshaFutanWariaiKonkyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合世帯員を管理するクラスです。
 */
public class _RiyoshaFutanWariaiKonkyoManager {

    private final DbT3115RiyoshaFutanWariaiKonkyoDac dac;

    /**
     * コンストラクタです。
     */
    public _RiyoshaFutanWariaiKonkyoManager() {
        dac = InstanceProvider.create(DbT3115RiyoshaFutanWariaiKonkyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3115RiyoshaFutanWariaiKonkyoDac}
     */
    _RiyoshaFutanWariaiKonkyoManager(DbT3115RiyoshaFutanWariaiKonkyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する利用者負担割合世帯員を返します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 枝番号 EdaNo
     * @param 世帯員被保険者番号 SetaiinHihokenshaNo
     * @return RiyoshaFutanWariaiKonkyo
     */
    @Transaction
    public RiyoshaFutanWariaiKonkyo get利用者負担割合世帯員(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            int 枝番号,
            HihokenshaNo 世帯員被保険者番号) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));
        requireNonNull(世帯員被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員被保険者番号"));

        DbT3115RiyoshaFutanWariaiKonkyoEntity entity = dac.selectByKey(
                年度,
                被保険者番号,
                履歴番号,
                枝番号,
                世帯員被保険者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RiyoshaFutanWariaiKonkyo(entity);
    }

    /**
     * 利用者負担割合世帯員を全件返します。
     *
     * @return List<RiyoshaFutanWariaiKonkyo>
     */
    @Transaction
    public List<RiyoshaFutanWariaiKonkyo> get利用者負担割合世帯員一覧() {
        List<RiyoshaFutanWariaiKonkyo> businessList = new ArrayList<>();

        for (DbT3115RiyoshaFutanWariaiKonkyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RiyoshaFutanWariaiKonkyo(entity));
        }

        return businessList;
    }

    /**
     * 利用者負担割合世帯員{@link RiyoshaFutanWariaiKonkyo}を保存します。
     *
     * @param 利用者負担割合世帯員 {@link RiyoshaFutanWariaiKonkyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save利用者負担割合世帯員(RiyoshaFutanWariaiKonkyo 利用者負担割合世帯員) {
        requireNonNull(利用者負担割合世帯員, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合世帯員"));
        if (!利用者負担割合世帯員.hasChanged()) {
            return false;
        }
        return 1 == dac.save(利用者負担割合世帯員.toEntity());
    }
}
