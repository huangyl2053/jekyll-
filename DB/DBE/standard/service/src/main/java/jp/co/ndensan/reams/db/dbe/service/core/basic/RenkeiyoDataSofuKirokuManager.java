/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.RenkeiyoDataSofuKiroku;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5191RenkeiyoDataSofuKirokuEntity;
import jp.co.ndensan.reams.db.dbe.persistence.basic.DbT5191RenkeiyoDataSofuKirokuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連携用データ送付記録を管理するクラスです。
 */
public class RenkeiyoDataSofuKirokuManager {

    private final DbT5191RenkeiyoDataSofuKirokuDac dac;

    /**
     * コンストラクタです。
     */
    public RenkeiyoDataSofuKirokuManager() {
        dac = InstanceProvider.create(DbT5191RenkeiyoDataSofuKirokuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5191RenkeiyoDataSofuKirokuDac}
     */
    RenkeiyoDataSofuKirokuManager(DbT5191RenkeiyoDataSofuKirokuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する連携用データ送付記録を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 資料作成日 資料作成日
     * @return RenkeiyoDataSofuKiroku
     */
    @Transaction
    public RenkeiyoDataSofuKiroku get連携用データ送付記録(
            ShinseishoKanriNo 申請書管理番号,
            FlexibleDate 資料作成日) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(資料作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("資料作成日"));

        DbT5191RenkeiyoDataSofuKirokuEntity entity = dac.selectByKey(
                申請書管理番号,
                資料作成日);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RenkeiyoDataSofuKiroku(entity);
    }

    /**
     * 連携用データ送付記録を全件返します。
     *
     * @return RenkeiyoDataSofuKirokuの{@code list}
     */
    @Transaction
    public List<RenkeiyoDataSofuKiroku> get連携用データ送付記録一覧() {
        List<RenkeiyoDataSofuKiroku> businessList = new ArrayList<>();

        for (DbT5191RenkeiyoDataSofuKirokuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RenkeiyoDataSofuKiroku(entity));
        }

        return businessList;
    }

    /**
     * 連携用データ送付記録{@link RenkeiyoDataSofuKiroku}を保存します。
     *
     * @param 連携用データ送付記録 {@link RenkeiyoDataSofuKiroku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save連携用データ送付記録(RenkeiyoDataSofuKiroku 連携用データ送付記録) {
        requireNonNull(連携用データ送付記録, UrSystemErrorMessages.値がnull.getReplacedMessage("連携用データ送付記録"));
        if (!連携用データ送付記録.hasChanged()) {
            return false;
        }
        return 1 == dac.save(連携用データ送付記録.toEntity());
    }
}
