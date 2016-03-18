/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5211NinteichosahyoChosaItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_基本調査_調査項目を管理するクラスです。
 */
public class NinteichosahyoChosaItemManager {

    private final DbT5211NinteichosahyoChosaItemDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoChosaItemManager() {
        dac = InstanceProvider.create(DbT5211NinteichosahyoChosaItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5211NinteichosahyoChosaItemDac}
     */
    NinteichosahyoChosaItemManager(DbT5211NinteichosahyoChosaItemDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_基本調査_調査項目を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 連番 連番
     * @return NinteichosahyoChosaItem
     */
    @Transaction
    public NinteichosahyoChosaItem get認定調査票_基本調査_調査項目(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5211NinteichosahyoChosaItemEntity entity = dac.selectByKey(
                申請書管理番号,
                要介護認定調査履歴番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoChosaItem(entity);
    }

    /**
     * 認定調査票_基本調査_調査項目を全件返します。
     *
     * @return NinteichosahyoChosaItemの{@code list}
     */
    @Transaction
    public List<NinteichosahyoChosaItem> get認定調査票_基本調査_調査項目一覧() {
        List<NinteichosahyoChosaItem> businessList = new ArrayList<>();

        for (DbT5211NinteichosahyoChosaItemEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoChosaItem(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_基本調査_調査項目{@link NinteichosahyoChosaItem}を保存します。
     *
     * @param 認定調査票_基本調査_調査項目 {@link NinteichosahyoChosaItem}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_基本調査_調査項目(NinteichosahyoChosaItem 認定調査票_基本調査_調査項目) {
        requireNonNull(認定調査票_基本調査_調査項目, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査_調査項目"));
        if (!認定調査票_基本調査_調査項目.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_基本調査_調査項目.toEntity());
    }

    /**
     * 認定調査票_基本調査_調査項目{@link NinteichosahyoChosaItem}を削除します。
     *
     * @param 認定調査票_基本調査_調査項目 {@link NinteichosahyoChosaItem}
     * @return 削除件数 削除結果の件数を返します。
     */
    @Transaction
    public boolean delete認定調査票_基本調査_調査項目(NinteichosahyoChosaItem 認定調査票_基本調査_調査項目) {
        requireNonNull(認定調査票_基本調査_調査項目, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査_調査項目"));
        if (!認定調査票_基本調査_調査項目.hasChanged()) {
            return false;
        }
        return 1 == dac.delete(認定調査票_基本調査_調査項目.toEntity());
    }
}
