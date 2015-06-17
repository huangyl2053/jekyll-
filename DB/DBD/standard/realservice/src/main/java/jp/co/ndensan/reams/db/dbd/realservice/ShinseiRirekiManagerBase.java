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
 * 申請履歴情報を取得するクラスです。
 *
 * @author n8223　朴義一
 */
public abstract class ShinseiRirekiManagerBase implements IShinseiRirekiManager {

    /**
     * 申請履歴情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 申請履歴情報
     */
    @Override
    public abstract Optional<IShinseiRirekiJoho> find申請履歴情報(ShinseishoKanriNo 申請書管理番号);

    /**
     * 申請履歴情報を取得します。
     *
     * @param 申請履歴情報 IShinseiRirekiJoho
     * @return 申請履歴情報
     */
    @Override
    public abstract int save申請履歴(IShinseiRirekiJoho 申請履歴情報);

}
