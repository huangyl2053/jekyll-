/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.ShokanJuryoininKeiyakushaAlive;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbV3078ShokanJuryoininKeiyakushaAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 還受領委任契約者Aliveを管理するクラスです。
 */
public class ShokanJuryoininKeiyakushaAliveManager {

    private final DbV3078ShokanJuryoininKeiyakushaAliveDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanJuryoininKeiyakushaAliveManager() {
        dac = InstanceProvider.create(DbV3078ShokanJuryoininKeiyakushaAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV3078ShokanJuryoininKeiyakushaAliveDac}
     */
    ShokanJuryoininKeiyakushaAliveManager(DbV3078ShokanJuryoininKeiyakushaAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する還受領委任契約者Aliveを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     * @return ShokanJuryoininKeiyakushaAlive
     */
    @Transaction
    public ShokanJuryoininKeiyakushaAlive get還受領委任契約者Alive(
            HihokenshaNo 被保険者番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbV3078ShokanJuryoininKeiyakushaEntity entity = dac.selectByKey(
                被保険者番号,
                証記載保険者番号,
                受付年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanJuryoininKeiyakushaAlive(entity);
    }

    /**
     * 還受領委任契約者Aliveを全件返します。
     *
     * @return ShokanJuryoininKeiyakushaAliveの{@code list}
     */
    @Transaction
    public List<ShokanJuryoininKeiyakushaAlive> get還受領委任契約者Alive一覧() {
        List<ShokanJuryoininKeiyakushaAlive> businessList = new ArrayList<>();

        for (DbV3078ShokanJuryoininKeiyakushaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanJuryoininKeiyakushaAlive(entity));
        }

        return businessList;
    }

    /**
     * 還受領委任契約者Alive{@link ShokanJuryoininKeiyakushaAlive}を保存します。
     *
     * @param 還受領委任契約者Alive {@link ShokanJuryoininKeiyakushaAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save還受領委任契約者Alive(ShokanJuryoininKeiyakushaAlive 還受領委任契約者Alive) {
        requireNonNull(還受領委任契約者Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("還受領委任契約者Alive"));
        if (!還受領委任契約者Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(還受領委任契約者Alive.toEntity());
    }
}
