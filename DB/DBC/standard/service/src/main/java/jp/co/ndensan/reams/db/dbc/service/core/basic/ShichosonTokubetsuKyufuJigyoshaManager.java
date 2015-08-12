/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetsuKyufuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村特別給付サービス事業者を管理するクラスです。
 */
public class ShichosonTokubetsuKyufuJigyoshaManager {

    private final DbT3065ShichosonTokubetsuKyufuJigyoshaDac dac;

    /**
     * コンストラクタです。
     */
    public ShichosonTokubetsuKyufuJigyoshaManager() {
        dac = InstanceProvider.create(DbT3065ShichosonTokubetsuKyufuJigyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3065ShichosonTokubetsuKyufuJigyoshaDac}
     */
    ShichosonTokubetsuKyufuJigyoshaManager(DbT3065ShichosonTokubetsuKyufuJigyoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する市町村特別給付サービス事業者を返します。
     *
     * @param 市町村特別給付用事業者番号 JigyoshaNo
     * @param 市町村特別給付用サービスコード ServiceCode
     * @param 履歴番号 RirekiNo
     * @return ShichosonTokubetsuKyufuJigyosha
     */
    @Transaction
    public ShichosonTokubetsuKyufuJigyosha get市町村特別給付サービス事業者(
            JigyoshaNo 市町村特別給付用事業者番号,
            ServiceCode 市町村特別給付用サービスコード,
            Decimal 履歴番号) {
        requireNonNull(市町村特別給付用事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用事業者番号"));
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity = dac.selectByKey(
                市町村特別給付用事業者番号,
                市町村特別給付用サービスコード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShichosonTokubetsuKyufuJigyosha(entity);
    }

    /**
     * 市町村特別給付サービス事業者を全件返します。
     *
     * @return List<ShichosonTokubetsuKyufuJigyosha>
     */
    @Transaction
    public List<ShichosonTokubetsuKyufuJigyosha> get市町村特別給付サービス事業者一覧() {
        List<ShichosonTokubetsuKyufuJigyosha> businessList = new ArrayList<>();

        for (DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShichosonTokubetsuKyufuJigyosha(entity));
        }

        return businessList;
    }

    /**
     * 市町村特別給付サービス事業者{@link ShichosonTokubetsuKyufuJigyosha}を保存します。
     *
     * @param 市町村特別給付サービス事業者 {@link ShichosonTokubetsuKyufuJigyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save市町村特別給付サービス事業者(ShichosonTokubetsuKyufuJigyosha 市町村特別給付サービス事業者) {
        requireNonNull(市町村特別給付サービス事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス事業者"));
        if (!市町村特別給付サービス事業者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(市町村特別給付サービス事業者.toEntity());
    }
}
