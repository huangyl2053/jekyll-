/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.DbT4123NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4123NinteiKeikakuJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定計画情報のデータアクセスクラスです。
 * 
 * @author n3213
 */
public class DbT4123NinteiKeikakuJohoManager {
    
    private final DbT4123NinteiKeikakuJohoDac dac;

    /**
     * コンストラクタです。
     */
    public DbT4123NinteiKeikakuJohoManager() {
        dac = InstanceProvider.create(DbT4123NinteiKeikakuJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4121ShinseiRirekiJohoUketsukeDac}
     */
    DbT4123NinteiKeikakuJohoManager(DbT4123NinteiKeikakuJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請履歴情報{@link ShinseiRirekiJoho}を保存します。
     *
     * @param 認定計画情報 {@link ShinseiRirekiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定計画情報(DbT4123NinteiKeikakuJoho 認定計画情報) {
        requireNonNull(認定計画情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定計画情報"));
        if (!認定計画情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定計画情報.toEntity());
    }
    
    public DbT4123NinteiKeikakuJoho get申請履歴情報ByKey(ShinseishoKanriNo 申請管理番号) {
        DbT4123NinteiKeikakuJohoEntity entity = dac.selectByKey(申請管理番号);
        if (entity == null) {
            return null;
        }
        return new DbT4123NinteiKeikakuJoho(entity);
    }
    
    public RString get認定調査依頼予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.認定調査依頼予定年月日, 基準日);
    }
    
    public RString get認定調査予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.認定調査予定年月日, 基準日);
    }
    
    public RString get主治医意見書作成依頼予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.主治医意見書作成依頼予定年月日, 基準日);
    }
    
    public RString get主治医意見書登録予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.主治医意見書登録予定年月日, 基準日);
    }
    
    public RString get要介護認定一次判定予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.要介護認定一次判定予定年月日, 基準日);
    }
    
    public RString get認定審査会割当予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.認定審査会割当予定年月日, 基準日);
    }
    
    public RString get認定審査会予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.認定審査会予定年月日, 基準日);
    }
    
    public RString getセンター送信予定年月日(FlexibleDate 基準日) {
        return getBusinessConfig(ConfigNameDBE.センター送信予定年月日, 基準日);
    }
    
    private RString getBusinessConfig(ConfigNameDBE configName, FlexibleDate 適用日) {
        return DbBusinessConfig.get(
                configName, new RDate(適用日.getYearValue(), 適用日.getMonthValue(), 適用日.getDayValue()), SubGyomuCode.DBE認定支援);
    }
}
