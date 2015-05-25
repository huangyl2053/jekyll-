/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.realservice;

import jp.co.ndensan.reams.db.dbd.business.IShinseiRirekiJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 申請履歴情報を作成するクラスです。
 *
 * @author n8223　朴義一
 */
public abstract class ShinseiRirekiManagerBase implements IShinseiRirekiManager {

    /**
     * 申請履歴情報を取得します。
     *
     * @param 申請管理番号
     * @return 申請履歴情報
     */
    public abstract Optional<IShinseiRirekiJoho> find申請履歴情報(ShinseishoKanriNo 申請管理番号);

}
