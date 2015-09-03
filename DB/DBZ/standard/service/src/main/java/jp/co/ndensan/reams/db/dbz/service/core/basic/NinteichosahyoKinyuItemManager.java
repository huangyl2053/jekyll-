/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5209NinteichosahyoKinyuItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況調査_記入項目を管理するクラスです。
 */
public class NinteichosahyoKinyuItemManager {

    private final DbT5209NinteichosahyoKinyuItemDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKinyuItemManager() {
        dac = InstanceProvider.create(DbT5209NinteichosahyoKinyuItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5209NinteichosahyoKinyuItemDac}
     */
    NinteichosahyoKinyuItemManager(DbT5209NinteichosahyoKinyuItemDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_概況調査_記入項目を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 連番 連番
     * @return NinteichosahyoKinyuItem
     */
    @Transaction
    public NinteichosahyoKinyuItem get認定調査票_概況調査_記入項目(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5209NinteichosahyoKinyuItemEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoKinyuItem(entity);
    }

    /**
     * 認定調査票_概況調査_記入項目を全件返します。
     *
     * @return NinteichosahyoKinyuItemの{@code list}
     */
    @Transaction
    public List<NinteichosahyoKinyuItem> get認定調査票_概況調査_記入項目一覧() {
        List<NinteichosahyoKinyuItem> businessList = new ArrayList<>();

        for (DbT5209NinteichosahyoKinyuItemEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoKinyuItem(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_概況調査_記入項目{@link NinteichosahyoKinyuItem}を保存します。
     *
     * @param 認定調査票_概況調査_記入項目 {@link NinteichosahyoKinyuItem}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_記入項目(NinteichosahyoKinyuItem 認定調査票_概況調査_記入項目) {
        requireNonNull(認定調査票_概況調査_記入項目, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況調査_記入項目"));
        if (!認定調査票_概況調査_記入項目.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_記入項目.toEntity());
    }
}
