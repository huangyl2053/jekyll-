/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200904;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3047ShokanServicePlan200904Dac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求サービス計画200904を管理するクラスです。
 */
public class ShokanServicePlan200904Manager {

    private final DbT3047ShokanServicePlan200904Dac dac;

    /**
     * コンストラクタです。
     */
    public ShokanServicePlan200904Manager() {
        dac = InstanceProvider.create(DbT3047ShokanServicePlan200904Dac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3047ShokanServicePlan200904Dac}
     */
    ShokanServicePlan200904Manager(DbT3047ShokanServicePlan200904Dac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求サービス計画200904を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNp
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 MeisaiNo
     * @param 連番 Renban
     * @return ShokanServicePlan200904
     */
    @Transaction
    public ShokanServicePlan200904 get償還払請求サービス計画200904(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT3047ShokanServicePlan200904Entity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                連番
        );
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanServicePlan200904(entity);
    }

    /**
     * 償還払請求サービス計画200904を全件返します。
     *
     * @return List<ShokanServicePlan200904>
     */
    @Transaction
    public List<ShokanServicePlan200904> get償還払請求サービス計画200904一覧() {
        List<ShokanServicePlan200904> businessList = new ArrayList<>();

        for (DbT3047ShokanServicePlan200904Entity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanServicePlan200904(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求サービス計画200904{@link ShokanServicePlan200904}を保存します。
     *
     * @param 償還払請求サービス計画200904 {@link ShokanServicePlan200904}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求サービス計画200904(ShokanServicePlan200904 償還払請求サービス計画200904) {
        requireNonNull(償還払請求サービス計画200904, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200904"));
        if (!償還払請求サービス計画200904.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求サービス計画200904.toEntity());
    }
}
