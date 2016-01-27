/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShichosonTokubetuKyufuService;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3066ShichosonTokubetuKyufuServiceDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村特別給付サービス内容を管理するクラスです。
 */
public class ShichosonTokubetuKyufuServiceManager {

    private final DbT3066ShichosonTokubetuKyufuServiceDac dac;

    /**
     * コンストラクタです。
     */
    public ShichosonTokubetuKyufuServiceManager() {
        dac = InstanceProvider.create(DbT3066ShichosonTokubetuKyufuServiceDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3066ShichosonTokubetuKyufuServiceDac}
     */
    ShichosonTokubetuKyufuServiceManager(DbT3066ShichosonTokubetuKyufuServiceDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する市町村特別給付サービス内容を返します。
     *
     * @param 市町村特別給付用サービスコード ServiceCode
     * @param 市町村特別給付用サービス有効期間開始年月日 ServiceYukoKikanKaishiYMD
     * @param 履歴番号 RirekiNo
     * @return ShichosonTokubetuKyufuService
     */
    @Transaction
    public ShichosonTokubetuKyufuService get市町村特別給付サービス内容(
            RString 市町村特別給付用サービスコード,
            FlexibleDate 市町村特別給付用サービス有効期間開始年月日,
            int 履歴番号) {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(市町村特別給付用サービス有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間開始年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3066ShichosonTokubetuKyufuServiceEntity entity = dac.selectByKey(
                市町村特別給付用サービスコード,
                市町村特別給付用サービス有効期間開始年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShichosonTokubetuKyufuService(entity);
    }

    /**
     * 市町村特別給付サービス内容を全件返します。
     *
     * @return List<ShichosonTokubetuKyufuService>
     */
    @Transaction
    public List<ShichosonTokubetuKyufuService> get市町村特別給付サービス内容一覧() {
        List<ShichosonTokubetuKyufuService> businessList = new ArrayList<>();

        for (DbT3066ShichosonTokubetuKyufuServiceEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShichosonTokubetuKyufuService(entity));
        }

        return businessList;
    }

    /**
     * 市町村特別給付サービス内容{@link ShichosonTokubetuKyufuService}を保存します。
     *
     * @param 市町村特別給付サービス内容 {@link ShichosonTokubetuKyufuService}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save市町村特別給付サービス内容(ShichosonTokubetuKyufuService 市町村特別給付サービス内容) {
        requireNonNull(市町村特別給付サービス内容, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス内容"));
        if (!市町村特別給付サービス内容.hasChanged()) {
            return false;
        }
        return 1 == dac.save(市町村特別給付サービス内容.toEntity());
    }
}
