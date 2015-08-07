/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護第三者行為届出を管理するクラスです。
 */
public class DaisanshaKoiTodokedeManager {

    private final DbT3084DaisanshaKoiTodokedeDac dac;

    /**
     * コンストラクタです。
     */
    public DaisanshaKoiTodokedeManager() {
        dac = InstanceProvider.create(DbT3084DaisanshaKoiTodokedeDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3084DaisanshaKoiTodokedeDac}
     */
    DaisanshaKoiTodokedeManager(DbT3084DaisanshaKoiTodokedeDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する介護第三者行為届出を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 第三者行為届出管理番号 TodokedeKanriNo
     * @param 履歴番号 RirekiNo
     * @return DaisanshaKoiTodokede
     */
    @Transaction
    public DaisanshaKoiTodokede get介護第三者行為届出(
             HihokenshaNo 被保険者番号,
            RString 第三者行為届出管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(第三者行為届出管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("第三者行為届出管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3084DaisanshaKoiTodokedeEntity entity = dac.selectByKey(
                被保険者番号,
                第三者行為届出管理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new DaisanshaKoiTodokede(entity);
    }

    /**
     * 介護第三者行為届出を全件返します。
     *
     * @return List<DaisanshaKoiTodokede>
     */
    @Transaction
    public List<DaisanshaKoiTodokede> get介護第三者行為届出一覧() {
        List<DaisanshaKoiTodokede> businessList = new ArrayList<>();

        for (DbT3084DaisanshaKoiTodokedeEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new DaisanshaKoiTodokede(entity));
        }

        return businessList;
    }

    /**
     * 介護第三者行為届出{@link DaisanshaKoiTodokede}を保存します。
     *
     * @param 介護第三者行為届出 {@link DaisanshaKoiTodokede}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護第三者行為届出(DaisanshaKoiTodokede 介護第三者行為届出) {
        requireNonNull(介護第三者行為届出, UrSystemErrorMessages.値がnull.getReplacedMessage("介護第三者行為届出"));
        if (!介護第三者行為届出.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護第三者行為届出.toEntity());
    }
}
