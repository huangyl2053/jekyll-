/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshashiteiservice;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7063KaigoJigyoshaShiteiServiceDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者指定サービスを管理するクラスです。
 */
public class KaigoJigyoshaShiteiServiceManager {

    private final DbT7063KaigoJigyoshaShiteiServiceDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaShiteiServiceManager() {
        dac = InstanceProvider.create(DbT7063KaigoJigyoshaShiteiServiceDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7063KaigoJigyoshaShiteiServiceDac}
     */
    KaigoJigyoshaShiteiServiceManager(DbT7063KaigoJigyoshaShiteiServiceDac dac) {
        this.dac = dac;
    }

    /**
     * 介護事業者指定サービス{@link KaigoJigyoshaShiteiService}を保存します。
     *
     * @param 介護事業者指定サービス {@link KaigoJigyoshaShiteiService}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護事業者指定サービス(KaigoJigyoshaShiteiService 介護事業者指定サービス) {
        requireNonNull(介護事業者指定サービス, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者指定サービス"));
        if (!介護事業者指定サービス.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護事業者指定サービス.toEntity());
    }

    /**
     * 介護事業者指定サービスを返します。
     *
     * @param 事業者番号 事業者番号
     * @return List<KaigoJigyoshaShiteiService>。
     */
    @Transaction
    public List<KaigoJigyoshaShiteiService> get介護事業者指定サービス(JigyoshaNo 事業者番号) {
        List<KaigoJigyoshaShiteiService> list = new ArrayList<>();
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        List<DbT7063KaigoJigyoshaShiteiServiceEntity> relateList = dac.selectBy事業者番号(事業者番号);
        if (relateList.isEmpty()) {
            return list;
        }
        for (DbT7063KaigoJigyoshaShiteiServiceEntity relateEntity : relateList) {
            relateEntity.initializeMd5();
            list.add(new KaigoJigyoshaShiteiService(relateEntity));
        }
        return list;
    }
}
