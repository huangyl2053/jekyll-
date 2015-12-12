/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3045ShokanServicePlan200004Dac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求サービス計画200004を管理するクラスです。
 */
public class ShokanServicePlan200004Manager {

    private final DbT3045ShokanServicePlan200004Dac dac;

    /**
     * コンストラクタです。
     */
    public ShokanServicePlan200004Manager() {
        dac = InstanceProvider.create(DbT3045ShokanServicePlan200004Dac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3045ShokanServicePlan200004Dac}
     */
    ShokanServicePlan200004Manager(DbT3045ShokanServicePlan200004Dac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求サービス計画200004を返します。
     *
     *
     * @return ShokanServicePlan200004
     */
    @Transaction
    public ShokanServicePlan200004 get償還払請求サービス計画200004() {

        DbT3045ShokanServicePlan200004Entity entity = dac.selectByKey();
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanServicePlan200004(entity);
    }

    /**
     * 償還払請求サービス計画200004を全件返します。
     *
     * @return List<ShokanServicePlan200004>
     */
    @Transaction
    public List<ShokanServicePlan200004> get償還払請求サービス計画200004一覧() {
        List<ShokanServicePlan200004> businessList = new ArrayList<>();

        for (DbT3045ShokanServicePlan200004Entity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanServicePlan200004(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求サービス計画200004{@link ShokanServicePlan200004}を保存します。
     *
     * @param 償還払請求サービス計画200004 {@link ShokanServicePlan200004}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求サービス計画200004(ShokanServicePlan200004 償還払請求サービス計画200004) {
        requireNonNull(償還払請求サービス計画200004, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200004"));
        if (!償還払請求サービス計画200004.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求サービス計画200004.toEntity());
    }
}
