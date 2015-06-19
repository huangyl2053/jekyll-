/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.INinteiKekkaJoho;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定結果情報のマネージャーのインタフェースです。
 *
 * @author n8223 朴義一
 */
public interface INinteiKekkaJohoManager {

    /**
     * 指定の申請書管理番号に該当する{@link INinteiKekkaJoho 要介護認定結果情報}を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定申請情報
     */
    Optional<INinteiKekkaJoho> find要介護認定結果情報(ShinseishoKanriNo 申請書管理番号);

    /**
     * 要介護認定結果情報を登録します。
     *
     * @param 要介護認定結果 要介護認定結果
     * @return 登録件数
     */
    int save要介護認定結果(INinteiKekkaJoho 要介護認定結果);

}
