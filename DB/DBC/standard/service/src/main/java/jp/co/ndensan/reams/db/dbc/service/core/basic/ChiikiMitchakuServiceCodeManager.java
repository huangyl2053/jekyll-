/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ChiikiMitchakuServiceCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7121ChiikiMitchakuServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7121ChiikiMitchakuServiceCodeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 地域密着型介護サービスコードを管理するクラスです。
 */
public class ChiikiMitchakuServiceCodeManager {

    private final DbT7121ChiikiMitchakuServiceCodeDac dac;

    /**
     * コンストラクタです。
     */
    public ChiikiMitchakuServiceCodeManager() {
        dac = InstanceProvider.create(DbT7121ChiikiMitchakuServiceCodeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7121ChiikiMitchakuServiceCodeDac}
     */
    ChiikiMitchakuServiceCodeManager(DbT7121ChiikiMitchakuServiceCodeDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する地域密着型介護サービスコードを返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return ChiikiMitchakuServiceCode
     */
    @Transaction
    public ChiikiMitchakuServiceCode get地域密着型介護サービスコード(
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7121ChiikiMitchakuServiceCodeEntity entity = dac.selectByKey(
                サービス種類コード,
                サービス項目コード,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ChiikiMitchakuServiceCode(entity);
    }

    /**
     * 地域密着型介護サービスコードを全件返します。
     *
     * @return List<ChiikiMitchakuServiceCode>
     */
    @Transaction
    public List<ChiikiMitchakuServiceCode> get地域密着型介護サービスコード一覧() {
        List<ChiikiMitchakuServiceCode> businessList = new ArrayList<>();

        for (DbT7121ChiikiMitchakuServiceCodeEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ChiikiMitchakuServiceCode(entity));
        }

        return businessList;
    }

    /**
     * 地域密着型介護サービスコード{@link ChiikiMitchakuServiceCode}を保存します。
     *
     * @param 地域密着型介護サービスコード {@link ChiikiMitchakuServiceCode}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save地域密着型介護サービスコード(ChiikiMitchakuServiceCode 地域密着型介護サービスコード) {
        requireNonNull(地域密着型介護サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("地域密着型介護サービスコード"));
        if (!地域密着型介護サービスコード.hasChanged()) {
            return false;
        }
        return 1 == dac.save(地域密着型介護サービスコード.toEntity());
    }
}
