/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3046ShokanServicePlan200604Entity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3046ShokanServicePlan200604Dac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求サービス計画200604を管理するクラスです。
 */
public class ShokanServicePlan200604Manager {

    private final DbT3046ShokanServicePlan200604Dac dac;

    /**
     * コンストラクタです。
     */
    public ShokanServicePlan200604Manager() {
        dac = InstanceProvider.create(DbT3046ShokanServicePlan200604Dac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3046ShokanServicePlan200604Dac}
     */
    ShokanServicePlan200604Manager(DbT3046ShokanServicePlan200604Dac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求サービス計画200604を返します。
     *
     *
     * @return ShokanServicePlan200604
     */
    @Transaction
    public ShokanServicePlan200604 get償還払請求サービス計画200604() {

        DbT3046ShokanServicePlan200604Entity entity = dac.selectByKey();
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanServicePlan200604(entity);
    }

    /**
     * 償還払請求サービス計画200604を全件返します。
     *
     * @return List<ShokanServicePlan200604>
     */
    @Transaction
    public List<ShokanServicePlan200604> get償還払請求サービス計画200604一覧() {
        List<ShokanServicePlan200604> businessList = new ArrayList<>();

        for (DbT3046ShokanServicePlan200604Entity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanServicePlan200604(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求サービス計画200604{@link ShokanServicePlan200604}を保存します。
     *
     * @param 償還払請求サービス計画200604 {@link ShokanServicePlan200604}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求サービス計画200604(ShokanServicePlan200604 償還払請求サービス計画200604) {
        requireNonNull(償還払請求サービス計画200604, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200604"));
        if (!償還払請求サービス計画200604.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求サービス計画200604.toEntity());
    }
}
