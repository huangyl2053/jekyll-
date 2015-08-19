/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DaisanshaKoiKyusho;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3082DaisanshaKoiKyushoDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為求償を管理するクラスです。
 */
public class DaisanshaKoiKyushoManager {

    private final DbT3082DaisanshaKoiKyushoDac dac;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiKyushoManager() {
        dac = InstanceProvider.create(DbT3082DaisanshaKoiKyushoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3082DaisanshaKoiKyushoDac}
     */
    DaisanshaKoiKyushoManager(DbT3082DaisanshaKoiKyushoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護第三者行為求償を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 第三者行為求償請求番号 KyushoSeikyuNo
     * @param 履歴番号 RirekiNo
     * @return DaisanshaKoiKyusho
     */
    @Transaction
    public DaisanshaKoiKyusho get介護第三者行為求償(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            RString 第三者行為求償請求番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(第三者行為求償請求番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為求償請求番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3082DaisanshaKoiKyushoEntity entity = dac.selectByKey(
                被保険者番号,
                第三者行為届出管理番号,
                第三者行為求償請求番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DaisanshaKoiKyusho(entity);
    }

    /**
     * 介護第三者行為求償を全件返します。
     *
     * @return List<DaisanshaKoiKyusho>
     */
    @Transaction
    public List<DaisanshaKoiKyusho> get介護第三者行為求償一覧() {
        List<DaisanshaKoiKyusho> businessList = new ArrayList<>();

        for (DbT3082DaisanshaKoiKyushoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new DaisanshaKoiKyusho(entity));
        }

        return businessList;
    }

    /**
     * 介護第三者行為求償{@link DaisanshaKoiKyusho}を保存します。
     *
     * @param 介護第三者行為求償 {@link DaisanshaKoiKyusho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護第三者行為求償(DaisanshaKoiKyusho 介護第三者行為求償) {
        requireNonNull(介護第三者行為求償, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為求償"));
        if (!介護第三者行為求償.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護第三者行為求償.toEntity());
    }
}
