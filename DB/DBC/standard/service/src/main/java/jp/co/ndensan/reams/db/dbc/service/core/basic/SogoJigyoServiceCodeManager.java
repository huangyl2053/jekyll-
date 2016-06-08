/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoServiceCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7122SogoJigyoServiceCodeEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT7122SogoJigyoServiceCodeDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護予防・日常生活支援総合事業サービスコードを管理するクラスです。
 */
public class SogoJigyoServiceCodeManager {

    private final DbT7122SogoJigyoServiceCodeDac dac;

    /**
     * コンストラクタです。
     */
    public SogoJigyoServiceCodeManager() {
        dac = InstanceProvider.create(DbT7122SogoJigyoServiceCodeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7122SogoJigyoServiceCodeDac}
     */
    SogoJigyoServiceCodeManager(DbT7122SogoJigyoServiceCodeDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護予防・日常生活支援総合事業サービスコードを返します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return SogoJigyoServiceCode
     */
    @Transaction
    public SogoJigyoServiceCode get介護予防_日常生活支援総合事業サービスコード(
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT7122SogoJigyoServiceCodeEntity entity = dac.selectByKey(
                サービス種類コード,
                サービス項目コード,
                適用開始年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SogoJigyoServiceCode(entity);
    }

    /**
     * 介護予防・日常生活支援総合事業サービスコードを全件返します。
     *
     * @return List<SogoJigyoServiceCode>
     */
    @Transaction
    public List<SogoJigyoServiceCode> get介護予防_日常生活支援総合事業サービスコード一覧() {
        List<SogoJigyoServiceCode> businessList = new ArrayList<>();

        for (DbT7122SogoJigyoServiceCodeEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SogoJigyoServiceCode(entity));
        }

        return businessList;
    }

    /**
     * 介護予防・日常生活支援総合事業サービスコード{@link SogoJigyoServiceCode}を保存します。
     *
     * @param 介護予防_日常生活支援総合事業サービスコード {@link SogoJigyoServiceCode}
     * @return 更新結果
     */
    @Transaction
    public boolean save介護予防_日常生活支援総合事業サービスコード(SogoJigyoServiceCode 介護予防_日常生活支援総合事業サービスコード) {
        requireNonNull(介護予防_日常生活支援総合事業サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護予防・日常生活支援総合事業サービスコード"));
        if (!介護予防_日常生活支援総合事業サービスコード.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護予防_日常生活支援総合事業サービスコード.toEntity());
    }
}
