/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.view;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.view.JuryoininKeiyakuJigyoshaAlive;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbV3077JuryoininKeiyakuJigyoshaAliveDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任事業者Aliveを管理するクラスです。
 */
public class JuryoininKeiyakuJigyoshaAliveManager {

    private final DbV3077JuryoininKeiyakuJigyoshaAliveDac dac;

    /**
     * コンストラクタです。
     */
    public JuryoininKeiyakuJigyoshaAliveManager() {
        dac = InstanceProvider.create(DbV3077JuryoininKeiyakuJigyoshaAliveDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbV3077JuryoininKeiyakuJigyoshaAliveDac}
     */
    JuryoininKeiyakuJigyoshaAliveManager(DbV3077JuryoininKeiyakuJigyoshaAliveDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受領委任事業者Aliveを返します。
     *
     * @param 事業者契約番号 事業者契約番号
     * @param 開始年月日 開始年月日
     * @param 履歴番号 履歴番号
     * @return JuryoininKeiyakuJigyoshaAlive
     */
    @Transaction
    public JuryoininKeiyakuJigyoshaAlive get受領委任事業者Alive(
            RString 事業者契約番号,
            FlexibleDate 開始年月日,
            int 履歴番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbV3077JuryoininKeiyakuJigyoshaEntity entity = dac.selectByKey(
                事業者契約番号,
                開始年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JuryoininKeiyakuJigyoshaAlive(entity);
    }

    /**
     * 受領委任事業者Aliveを全件返します。
     *
     * @return JuryoininKeiyakuJigyoshaAliveの{@code list}
     */
    @Transaction
    public List<JuryoininKeiyakuJigyoshaAlive> get受領委任事業者Alive一覧() {
        List<JuryoininKeiyakuJigyoshaAlive> businessList = new ArrayList<>();

        for (DbV3077JuryoininKeiyakuJigyoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JuryoininKeiyakuJigyoshaAlive(entity));
        }

        return businessList;
    }

    /**
     * 受領委任事業者Alive{@link JuryoininKeiyakuJigyoshaAlive}を保存します。
     *
     * @param 受領委任事業者Alive {@link JuryoininKeiyakuJigyoshaAlive}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受領委任事業者Alive(JuryoininKeiyakuJigyoshaAlive 受領委任事業者Alive) {
        requireNonNull(受領委任事業者Alive, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任事業者Alive"));
        if (!受領委任事業者Alive.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受領委任事業者Alive.toEntity());
    }
}
