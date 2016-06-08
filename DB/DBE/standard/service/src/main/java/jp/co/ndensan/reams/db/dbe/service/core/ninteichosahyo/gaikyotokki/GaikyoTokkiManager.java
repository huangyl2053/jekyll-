/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.gaikyotokki;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.gaikyotokki.GaikyoTokki;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5206GaikyoTokkiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5206GaikyoTokkiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況特記）を管理するクラスです。
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
     * 認定調査票（概況特記）{@link GaikyoTokki}を保存します。
     *
     * @param 認定調査票_概況特記 {@link GaikyoTokki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況特記(GaikyoTokki 認定調査票_概況特記) {
        requireNonNull(認定調査票_概況特記, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況特記）"));
        if (!認定調査票_概況特記.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況特記.toEntity());
    }

    /**
     * 認定調査票（概況特記）を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 概況特記テキストイメージ区分 概況特記テキストイメージ区分
     * @return 認定調査票（概況特記）
     */
    public GaikyoTokki get認定調査票_概況特記(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号, RString 概況特記テキストイメージ区分) {
        DbT5206GaikyoTokkiEntity entity = dac.selectByKey(申請書管理番号, 認定調査依頼履歴番号, 概況特記テキストイメージ区分);
        if (entity == null) {
            return null;
        }
        return new GaikyoTokki(entity);
    }
}
