/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT7120TokuteiShinryoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT7120TokuteiShinryoServiceCodeDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特定診療サービスコードを管理するクラスです。
 */
public class TokuteiShinryoServiceCodeManager {

    private final DbT7120TokuteiShinryoServiceCodeDac dac;

    /**
     * コンストラクタです。
     */
    public TokuteiShinryoServiceCodeManager() {
        dac = InstanceProvider.create(DbT7120TokuteiShinryoServiceCodeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7120TokuteiShinryoServiceCodeDac}
     */
    TokuteiShinryoServiceCodeManager(DbT7120TokuteiShinryoServiceCodeDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する特定診療サービスコードを返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return TokuteiShinryoServiceCode
     */
    @Transaction
    public TokuteiShinryoServiceCode get特定診療サービスコード(
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7120TokuteiShinryoServiceCodeEntity entity = dac.selectByKey(
                サービス種類コード,
                サービス項目コード,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new TokuteiShinryoServiceCode(entity);
    }

    /**
     * 特定診療サービスコードを全件返します。
     *
     * @return List<TokuteiShinryoServiceCode>
     */
    @Transaction
    public List<TokuteiShinryoServiceCode> get特定診療サービスコード一覧() {
        List<TokuteiShinryoServiceCode> businessList = new ArrayList<>();

        for (DbT7120TokuteiShinryoServiceCodeEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new TokuteiShinryoServiceCode(entity));
        }

        return businessList;
    }

    /**
     * 特定診療サービスコード{@link TokuteiShinryoServiceCode}を保存します。
     *
     * @param 特定診療サービスコード {@link TokuteiShinryoServiceCode}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save特定診療サービスコード(TokuteiShinryoServiceCode 特定診療サービスコード) {
        requireNonNull(特定診療サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療サービスコード"));
        if (!特定診療サービスコード.hasChanged()) {
            return false;
        }
        return 1 == dac.save(特定診療サービスコード.toEntity());
    }
}
