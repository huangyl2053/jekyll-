/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaMoshitate;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3062SaishinsaMoshitateDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査申立を管理するクラスです。
 */
public class SaishinsaMoshitateManager {

    private final DbT3062SaishinsaMoshitateDac dac;

    /**
     * コンストラクタです。
     */
    public SaishinsaMoshitateManager() {
        dac = InstanceProvider.create(DbT3062SaishinsaMoshitateDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3062SaishinsaMoshitateDac}
     */
    SaishinsaMoshitateManager(DbT3062SaishinsaMoshitateDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する再審査申立を返します。
     *
     * @param 事業所番号 JigyoshoNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param サービス種類コード ServiceTeikyoShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 履歴番号 RirekiNo
     * @return SaishinsaMoshitate
     */
    @Transaction
    public SaishinsaMoshitate get再審査申立(
            JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            Decimal 履歴番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3062SaishinsaMoshitateEntity entity = dac.selectByKey(
                事業所番号,
                被保険者番号,
                サービス提供年月,
                サービス種類コード,
                サービス項目コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SaishinsaMoshitate(entity);
    }

    /**
     * 再審査申立を全件返します。
     *
     * @return List<SaishinsaMoshitate>
     */
    @Transaction
    public List<SaishinsaMoshitate> get再審査申立一覧() {
        List<SaishinsaMoshitate> businessList = new ArrayList<>();

        for (DbT3062SaishinsaMoshitateEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SaishinsaMoshitate(entity));
        }

        return businessList;
    }

    /**
     * 再審査申立{@link SaishinsaMoshitate}を保存します。
     *
     * @param 再審査申立 {@link SaishinsaMoshitate}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save再審査申立(SaishinsaMoshitate 再審査申立) {
        requireNonNull(再審査申立, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査申立"));
        if (!再審査申立.hasChanged()) {
            return false;
        }
        return 1 == dac.save(再審査申立.toEntity());
    }
}
