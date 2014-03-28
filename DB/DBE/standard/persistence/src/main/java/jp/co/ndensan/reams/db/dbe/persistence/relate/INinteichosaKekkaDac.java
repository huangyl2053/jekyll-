/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.relate;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.db.dbz.persistence.IReplaceable;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定調査結果のデータアクセスインターフェースです。
 *
 * @author N8156 宮本 康
 */
public interface INinteichosaKekkaDac extends IReplaceable<NinteichosaKekkaEntity>, IDeletable<NinteichosaKekkaEntity> {

    /**
     * 引数の条件に該当する要介護認定調査結果エンティティを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査履歴番号 認定調査履歴番号
     * @return 要介護認定調査結果エンティティ
     */
    @Transaction
    NinteichosaKekkaEntity select(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査履歴番号);
}
