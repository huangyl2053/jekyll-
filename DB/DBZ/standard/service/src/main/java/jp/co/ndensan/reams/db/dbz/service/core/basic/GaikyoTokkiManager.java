/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5206GaikyoTokkiDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票_概況特記を管理するクラスです。
 */
public class GaikyoTokkiManager {

    private final DbT5206GaikyoTokkiDac dac;

    /**
     * コンストラクタです。
     */
    public GaikyoTokkiManager() {
        dac = InstanceProvider.create(DbT5206GaikyoTokkiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5206GaikyoTokkiDac}
     */
    GaikyoTokkiManager(DbT5206GaikyoTokkiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する認定調査票_概況特記を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @return GaikyoTokki
     */
    @Transaction
    public GaikyoTokki get認定調査票_概況特記(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));

        DbT5206GaikyoTokkiEntity entity = dac.selectByKey(
                申請書管理番号,
                認定調査依頼履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new GaikyoTokki(entity);
    }

    /**
     * 認定調査票_概況特記を全件返します。
     *
     * @return GaikyoTokkiの{@code list}
     */
    @Transaction
    public List<GaikyoTokki> get認定調査票_概況特記一覧() {
        List<GaikyoTokki> businessList = new ArrayList<>();

        for (DbT5206GaikyoTokkiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new GaikyoTokki(entity));
        }

        return businessList;
    }

    /**
     * 認定調査票_概況特記{@link GaikyoTokki}を保存します。
     *
     * @param 認定調査票_概況特記 {@link GaikyoTokki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況特記(GaikyoTokki 認定調査票_概況特記) {
        requireNonNull(認定調査票_概況特記, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票_概況特記"));
        if (!認定調査票_概況特記.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況特記.toEntity());
    }
}
