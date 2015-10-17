/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininKeiyakusha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3078ShokanJuryoininKeiyakushaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還受領委任契約者を管理するクラスです。
 */
public class ShokanJuryoininKeiyakushaManager {

    private final DbT3078ShokanJuryoininKeiyakushaDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanJuryoininKeiyakushaManager() {
        dac = InstanceProvider.create(DbT3078ShokanJuryoininKeiyakushaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3078ShokanJuryoininKeiyakushaDac}
     */
    ShokanJuryoininKeiyakushaManager(DbT3078ShokanJuryoininKeiyakushaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還受領委任契約者を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return ShokanJuryoininKeiyakusha
     */
    @Transaction
    public ShokanJuryoininKeiyakusha get償還受領委任契約者(
            HihokenshaNo 被保険者番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3078ShokanJuryoininKeiyakushaEntity entity = dac.selectByKey(
                被保険者番号,
                証記載保険者番号,
                受付年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanJuryoininKeiyakusha(entity);
    }

    /**
     * 償還受領委任契約者を全件返します。
     *
     * @return List<ShokanJuryoininKeiyakusha>
     */
    @Transaction
    public List<ShokanJuryoininKeiyakusha> get償還受領委任契約者一覧() {
        List<ShokanJuryoininKeiyakusha> businessList = new ArrayList<>();

        for (DbT3078ShokanJuryoininKeiyakushaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanJuryoininKeiyakusha(entity));
        }

        return businessList;
    }

    /**
     * 償還受領委任契約者{@link ShokanJuryoininKeiyakusha}を保存します。
     *
     * @param 償還受領委任契約者 {@link ShokanJuryoininKeiyakusha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還受領委任契約者(ShokanJuryoininKeiyakusha 償還受領委任契約者) {
        requireNonNull(償還受領委任契約者, UrSystemErrorMessages.値がnull.getReplacedMessage("償還受領委任契約者"));
        if (!償還受領委任契約者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還受領委任契約者.toEntity());
    }
}
