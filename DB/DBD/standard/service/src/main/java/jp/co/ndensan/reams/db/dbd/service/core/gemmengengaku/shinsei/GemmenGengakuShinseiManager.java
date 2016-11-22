/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.shinsei;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4010GemmenGengakuShinseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 減免減額申請を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class GemmenGengakuShinseiManager {

    private final DbT4010GemmenGengakuShinseiDac dac;

    private static final RString 定数減免減額申請 = new RString("減免減額申請");

    /**
     * コンストラクタです。
     */
    public GemmenGengakuShinseiManager() {
        dac = InstanceProvider.create(DbT4010GemmenGengakuShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT4010GemmenGengakuShinseiDac}
     */
    GemmenGengakuShinseiManager(DbT4010GemmenGengakuShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する減免減額申請を返します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     * @return GemmenGengakuShinsei
     */
    @Transaction
    public GemmenGengakuShinsei get減免減額申請(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 減免減額種類,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT4010GemmenGengakuShinseiEntity entity = dac.selectByKey(
                証記載保険者番号,
                被保険者番号,
                減免減額種類,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GemmenGengakuShinsei(entity);
    }

    /**
     * 減免減額申請を全件返します。
     *
     * @return GemmenGengakuShinseiの{@code list}
     */
    @Transaction
    public List<GemmenGengakuShinsei> get減免減額申請一覧() {
        List<GemmenGengakuShinsei> businessList = new ArrayList<>();

        for (DbT4010GemmenGengakuShinseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new GemmenGengakuShinsei(entity));
        }

        return businessList;
    }

    /**
     * 減免減額申請{@link GemmenGengakuShinsei}を保存します。
     *
     * @param 減免減額申請 {@link GemmenGengakuShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save減免減額申請(GemmenGengakuShinsei 減免減額申請) {
        requireNonNull(減免減額申請, UrSystemErrorMessages.値がnull.getReplacedMessage(定数減免減額申請.toString()));
        if (!減免減額申請.hasChanged()) {
            return false;
        }
        return 1 == dac.save(減免減額申請.toEntity());
    }

    /**
     * 減免減額申請{@link GemmenGengakuShinsei}を保存します。
     *
     * @param 減免減額申請 {@link GemmenGengakuShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean insert減免減額申請(GemmenGengakuShinsei 減免減額申請) {
        requireNonNull(減免減額申請, UrSystemErrorMessages.値がnull.getReplacedMessage(定数減免減額申請.toString()));
        if (!減免減額申請.hasChanged()) {
            return false;
        }
        return 1 == dac.insert(減免減額申請.toEntity());
    }

    /**
     * 減免減額申請{@link GemmenGengakuShinsei}を保存します。
     *
     * @param 減免減額申請 {@link GemmenGengakuShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveOrDeletePhysicalBy減免減額申請(GemmenGengakuShinsei 減免減額申請) {
        requireNonNull(減免減額申請, UrSystemErrorMessages.値がnull.getReplacedMessage(定数減免減額申請.toString()));
        if (!減免減額申請.hasChanged()) {
            return false;
        }
        return 1 == dac.saveOrDeletePhysicalBy(減免減額申請.toEntity());
    }

    /**
     * 減免減額申請{@link GemmenGengakuShinsei}を物理削除します。
     *
     * @param 減免減額申請 {@link GemmenGengakuShinsei}
     * @return 物理削除件数 物理削除結果の件数を返します。
     */
    @Transaction
    public boolean delete減免減額申請(GemmenGengakuShinsei 減免減額申請) {
        requireNonNull(減免減額申請, UrSystemErrorMessages.値がnull.getReplacedMessage(定数減免減額申請.toString()));
        return 1 == dac.delete(減免減額申請.toEntity());
    }
}
