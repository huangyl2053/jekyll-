/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.DaisanshaKoiKyufugakuGengaku;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3081DaisanshaKoiKyufugakuGengakuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3081DaisanshaKoiKyufugakuGengakuDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為給付額減額を管理するクラスです。
 */
public class DaisanshaKoiKyufugakuGengakuManager {

    private final DbT3081DaisanshaKoiKyufugakuGengakuDac dac;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiKyufugakuGengakuManager() {
        dac = InstanceProvider.create(DbT3081DaisanshaKoiKyufugakuGengakuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3081DaisanshaKoiKyufugakuGengakuDac}
     */
    DaisanshaKoiKyufugakuGengakuManager(DbT3081DaisanshaKoiKyufugakuGengakuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護第三者行為給付額減額を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 履歴番号 RirekiNo
     * @return DaisanshaKoiKyufugakuGengaku
     */
    @Transaction
    public DaisanshaKoiKyufugakuGengaku get介護第三者行為給付額減額(
            HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3081DaisanshaKoiKyufugakuGengakuEntity entity = dac.selectByKey(
                被保険者番号,
                第三者行為届出管理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DaisanshaKoiKyufugakuGengaku(entity);
    }

    /**
     * 介護第三者行為給付額減額を全件返します。
     *
     * @return List<DaisanshaKoiKyufugakuGengaku>
     */
    @Transaction
    public List<DaisanshaKoiKyufugakuGengaku> get介護第三者行為給付額減額一覧() {
        List<DaisanshaKoiKyufugakuGengaku> businessList = new ArrayList<>();

        for (DbT3081DaisanshaKoiKyufugakuGengakuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new DaisanshaKoiKyufugakuGengaku(entity));
        }

        return businessList;
    }

    /**
     * 介護第三者行為給付額減額{@link DaisanshaKoiKyufugakuGengaku}を保存します。
     *
     * @param 介護第三者行為給付額減額 {@link DaisanshaKoiKyufugakuGengaku}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護第三者行為給付額減額(DaisanshaKoiKyufugakuGengaku 介護第三者行為給付額減額) {
        requireNonNull(介護第三者行為給付額減額, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為給付額減額"));
        if (!介護第三者行為給付額減額.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護第三者行為給付額減額.toEntity());
    }
}
