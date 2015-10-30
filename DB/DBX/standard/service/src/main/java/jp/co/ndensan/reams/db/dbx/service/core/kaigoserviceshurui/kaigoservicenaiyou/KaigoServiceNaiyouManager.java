/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigoserviceshurui.kaigoservicenaiyou;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7131KaigoServiceNaiyouDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス内容を管理するクラスです。
 */
public class KaigoServiceNaiyouManager {

    private final DbT7131KaigoServiceNaiyouDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoServiceNaiyouManager() {
        dac = InstanceProvider.create(DbT7131KaigoServiceNaiyouDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7131KaigoServiceNaiyouDac}
     */
    KaigoServiceNaiyouManager(DbT7131KaigoServiceNaiyouDac dac) {
        this.dac = dac;
    }

    /**
     * 介護サービス内容{@link KaigoServiceNaiyou}を保存します。
     *
     * @param 介護サービス内容 {@link KaigoServiceNaiyou}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護サービス内容(KaigoServiceNaiyou 介護サービス内容) {
        requireNonNull(介護サービス内容, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス内容"));
        if (!介護サービス内容.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護サービス内容.toEntity());
    }
}
