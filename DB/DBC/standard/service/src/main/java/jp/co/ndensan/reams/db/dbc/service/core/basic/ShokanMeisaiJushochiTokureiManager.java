/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3107ShokanMeisaiJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求明細_住所地特例を管理するクラスです。
 */
public class ShokanMeisaiJushochiTokureiManager {

    private final DbT3107ShokanMeisaiJushochiTokureiDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanMeisaiJushochiTokureiManager() {
        dac = InstanceProvider.create(DbT3107ShokanMeisaiJushochiTokureiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3107ShokanMeisaiJushochiTokureiDac}
     */
    ShokanMeisaiJushochiTokureiManager(DbT3107ShokanMeisaiJushochiTokureiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求明細_住所地特例を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNp
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 順次番号 JunjiNo
     * @param 履歴番号 RirekiNo
     * @return ShokanMeisaiJushochiTokurei
     */
    @Transaction
    public ShokanMeisaiJushochiTokurei get償還払請求明細_住所地特例(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 順次番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3107ShokanMeisaiJushochiTokureiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                順次番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanMeisaiJushochiTokurei(entity);
    }

    /**
     * 償還払請求明細_住所地特例を全件返します。
     *
     * @return List<ShokanMeisaiJushochiTokurei>
     */
    @Transaction
    public List<ShokanMeisaiJushochiTokurei> get償還払請求明細_住所地特例一覧() {
        List<ShokanMeisaiJushochiTokurei> businessList = new ArrayList<>();

        for (DbT3107ShokanMeisaiJushochiTokureiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanMeisaiJushochiTokurei(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求明細_住所地特例{@link ShokanMeisaiJushochiTokurei}を保存します。
     *
     * @param 償還払請求明細_住所地特例 {@link ShokanMeisaiJushochiTokurei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求明細_住所地特例(ShokanMeisaiJushochiTokurei 償還払請求明細_住所地特例) {
        requireNonNull(償還払請求明細_住所地特例, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求明細_住所地特例")
        );
        if (!償還払請求明細_住所地特例.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求明細_住所地特例.toEntity()
        );
    }
}
