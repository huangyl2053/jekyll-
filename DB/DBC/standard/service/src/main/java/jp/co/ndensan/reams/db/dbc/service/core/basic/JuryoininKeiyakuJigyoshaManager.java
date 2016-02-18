/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3077JuryoininKeiyakuJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任契約事業者を管理するクラスです。
 */
public class JuryoininKeiyakuJigyoshaManager {

    private final DbT3077JuryoininKeiyakuJigyoshaDac dac;

    /**
     * コンストラクタです。
     */
    public JuryoininKeiyakuJigyoshaManager() {
        dac = InstanceProvider.create(DbT3077JuryoininKeiyakuJigyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3077JuryoininKeiyakuJigyoshaDac}
     */
    JuryoininKeiyakuJigyoshaManager(DbT3077JuryoininKeiyakuJigyoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受領委任契約事業者を返します。
     *
     * @param 契約事業者番号 JigyoshaKeiyakuNo
     * @return JuryoininKeiyakuJigyosha
     */
    @Transaction
    public JuryoininKeiyakuJigyosha get受領委任契約事業者(
            RString 契約事業者番号) {
        requireNonNull(契約事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約事業者番号"));

        DbT3077JuryoininKeiyakuJigyoshaEntity entity = dac.selectByKey(
                契約事業者番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JuryoininKeiyakuJigyosha(entity);
    }

    /**
     * 受領委任契約事業者を全件返します。
     *
     * @return List<JuryoininKeiyakuJigyosha>
     */
    @Transaction
    public List<JuryoininKeiyakuJigyosha> get受領委任契約事業者一覧() {
        List<JuryoininKeiyakuJigyosha> businessList = new ArrayList<>();

        for (DbT3077JuryoininKeiyakuJigyoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JuryoininKeiyakuJigyosha(entity));
        }

        return businessList;
    }

    /**
     * 受領委任契約事業者{@link JuryoininKeiyakuJigyosha}を保存します。
     *
     * @param 受領委任契約事業者 {@link JuryoininKeiyakuJigyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受領委任契約事業者(JuryoininKeiyakuJigyosha 受領委任契約事業者) {
        requireNonNull(受領委任契約事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任契約事業者"));
        if (!受領委任契約事業者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受領委任契約事業者.toEntity());
    }
}
