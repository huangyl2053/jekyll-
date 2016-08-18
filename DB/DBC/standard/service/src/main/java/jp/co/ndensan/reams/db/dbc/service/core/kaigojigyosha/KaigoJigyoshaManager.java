/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kaigojigyosha;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoJigyosha;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7060KaigoJigyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者を管理するクラスです。
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class KaigoJigyoshaManager {

    private final DbT7060KaigoJigyoshaDac 介護事業者Dac;

    /**
     * コンストラクタです。
     */
    KaigoJigyoshaManager() {
        this.介護事業者Dac = InstanceProvider.create(DbT7060KaigoJigyoshaDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 介護事業者Dac 介護事業者Dac
     */
    KaigoJigyoshaManager(DbT7060KaigoJigyoshaDac 介護事業者Dac) {
        this.介護事業者Dac = 介護事業者Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KaigoJigyoshaManager}のインスタンス
     */
    public static KaigoJigyoshaManager createInstance() {
        return InstanceProvider.create(KaigoJigyoshaManager.class);
    }

    /**
     * 主キーに合致する介護事業者を返します。
     *
     * @param 事業者番号 事業者番号
     * @return KaigoJigyosha nullが返る可能性があります。
     */
    @Transaction
    public KaigoJigyosha get介護事業者(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        List<DbT7060KaigoJigyoshaEntity> relateList = 介護事業者Dac.select介護事業者(事業者番号);
        if (relateList.isEmpty()) {
            return null;
        }
        DbT7060KaigoJigyoshaEntity entity = relateList.get(0);
        entity.initializeMd5();
        return new KaigoJigyosha(entity);
    }
}
