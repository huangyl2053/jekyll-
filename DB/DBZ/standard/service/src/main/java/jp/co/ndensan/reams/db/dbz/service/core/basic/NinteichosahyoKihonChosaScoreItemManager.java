/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKihonChosaScoreItem;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5212NinteichosahyoKihonChosaScoreItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_基本調査素点項目を管理するクラスです。
 */
public class NinteichosahyoKihonChosaScoreItemManager {

    private final DbT5212NinteichosahyoKihonChosaScoreItemDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKihonChosaScoreItemManager() {
        dac = InstanceProvider.create(DbT5212NinteichosahyoKihonChosaScoreItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5212NinteichosahyoKihonChosaScoreItemDac}
     */
    NinteichosahyoKihonChosaScoreItemManager(DbT5212NinteichosahyoKihonChosaScoreItemDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_基本調査素点項目を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     * @param 連番 連番
     * @return NinteichosahyoKihonChosaScoreItem
     */
    @Transaction
    public NinteichosahyoKihonChosaScoreItem get認定調査票_基本調査素点項目(
            ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号,
            int 連番
    ) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = dac.selectByKey(
                申請書管理番号,
                要介護認定調査履歴番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NinteichosahyoKihonChosaScoreItem(entity);
    }

    /**
     * 認定調査票_基本調査素点項目を全件返します。
     *
     * @return NinteichosahyoKihonChosaScoreItemの{@code list}
     */
    @Transaction
    public List<NinteichosahyoKihonChosaScoreItem> get認定調査票項目一覧() {
        List<NinteichosahyoKihonChosaScoreItem> businessList = new ArrayList<>();

        for (DbT5212NinteichosahyoKihonChosaScoreItemEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NinteichosahyoKihonChosaScoreItem(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_基本調査素点項目{@link NinteichosahyoKihonChosaScoreItem}を保存します。
     *
     * @param 認定調査票_基本調査素点項目 {@link NinteichosahyoKihonChosaScoreItem}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_基本調査素点項目(NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目) {
        requireNonNull(認定調査票_基本調査素点項目, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_基本調査素点項目"));
        if (!認定調査票_基本調査素点項目.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_基本調査素点項目.toEntity());
    }
}
