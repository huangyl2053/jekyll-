/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.view.KokuhorenTorikomiJoho;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3104KokuhorenInterfaceKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3104KokuhorenInterfaceKanriDac;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbV3104KokuhorenTorikomiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 国保連情報データ取込
 *
 * @reamsid_L DBC-0980-520 quxiaodong
 */
public class IryoHokenRirekiManager {

    private final DbT3104KokuhorenInterfaceKanriDac dbtdac;
    private final DbV3104KokuhorenTorikomiJohoDac dbvdac;

    /**
     * コンストラクタです。
     */
    public IryoHokenRirekiManager() {
        dbtdac = InstanceProvider.create(DbT3104KokuhorenInterfaceKanriDac.class);
        dbvdac = InstanceProvider.create(DbV3104KokuhorenTorikomiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dbtdac
     * @param dbvdac
     */
    IryoHokenRirekiManager(DbT3104KokuhorenInterfaceKanriDac dbtdac, DbV3104KokuhorenTorikomiJohoDac dbvdac) {
        this.dbtdac = dbtdac;
        this.dbvdac = dbvdac;
    }

    /**
     * 提供API
     *
     * @return IryoHokenRirekiManager
     */
    public static IryoHokenRirekiManager createInstance() {

        return InstanceProvider.create(IryoHokenRirekiManager.class);
    }

    /**
     * 最大処理年月を取得します。
     *
     * @return DbT3104KokuhorenInterfaceKanriEntity
     */
    @Transaction
    public FlexibleYearMonth getMaxShoriYearMonth() {
        DbT3104KokuhorenInterfaceKanriEntity entity = dbtdac.getMaxShoriYM();
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return entity.getShoriYM();
    }

    /**
     * 国保連取込情報取得
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     * @return KokuhorenTorikomiJoho
     */
    @Transaction
    public KokuhorenTorikomiJoho getKokuhorenTorikomiJoho(
            FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));

        DbV3104KokuhorenTorikomiJohoEntity entity = dbvdac.selectByKey(
                処理年月,
                交換情報識別番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KokuhorenTorikomiJoho(entity);
    }

}
