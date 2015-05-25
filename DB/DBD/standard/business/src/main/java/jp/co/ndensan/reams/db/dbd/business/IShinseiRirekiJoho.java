/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 構成市町村マスタ情報（ビジネス）を扱うインタフェースです。
 *
 * @author n8223　朴義一
 */
public interface IShinseiRirekiJoho {

    /**
     * 申請管理番号を返します。
     *
     * @return 申請管理番号
     */
    ShinseishoKanriNo get申請管理番号();

    /**
     * 前回申請管理番号を返します。
     *
     * @return 前回申請管理番号
     */
    ShinseishoKanriNo get前回申請管理番号();

}
