/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ServiceCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7119ServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7119ServiceCodeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * サービスコードを管理するクラスです。
 */
public class ServiceCodeManager {

    private final DbT7119ServiceCodeDac dac;

    /**
     * コンストラクタです。
     */
    public ServiceCodeManager() {
        dac = InstanceProvider.create(DbT7119ServiceCodeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7119ServiceCodeDac}
     */
    ServiceCodeManager(DbT7119ServiceCodeDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致するサービスコードを返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return ServiceCode
     */
    @Transaction
    public ServiceCode getサービスコード(
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7119ServiceCodeEntity entity = dac.selectByKey(
                サービス種類コード,
                サービス項目コード,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ServiceCode(entity);
    }

    /**
     * サービスコードを全件返します。
     *
     * @return List<ServiceCode>
     */
    @Transaction
    public List<ServiceCode> getサービスコード一覧() {
        List<ServiceCode> businessList = new ArrayList<>();

        for (DbT7119ServiceCodeEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ServiceCode(entity));
        }

        return businessList;
    }

    /**
     * サービスコード{@link ServiceCode}を保存します。
     *
     * @param サービスコード {@link ServiceCode}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        if (!サービスコード.hasChanged()) {
            return false;
        }
        return 1 == dac.save(サービスコード.toEntity());
    }
}
