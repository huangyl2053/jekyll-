/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.zenkaininteikekkajoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.zenkaininteikekkajoho.ZenkaiNinteiKekkaJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 前回結果情報検索のインタフェイスです。
 */
public interface IZenkaiNinteiKekkaJohoMapper {
    
    /**
     * 前回受給の要介護度を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return DbT4101NinteiShinseiJohoEntity
     */
    DbT4101NinteiShinseiJohoEntity get要介護度_前回受給(ShinseishoKanriNo shinseishoKanriNo);
    
    /**
     * 前回認定の要介護度を取得します。
     * @param shinseishoKanriNo 申請書管理番号
     * @return DbT5101NinteiShinseiJohoEntity
     */
    DbT5101NinteiShinseiJohoEntity get要介護度_前回認定(ShinseishoKanriNo shinseishoKanriNo);
    
    /**
     * 今回受給の要介護度を取得します。
     * @param shinseishoKanriNo 申請管理番号
     * @return ZenkaiNinteiKekkaJohoRelateEntity
     */
    ZenkaiNinteiKekkaJohoRelateEntity get要介護度_今回受給(ShinseishoKanriNo shinseishoKanriNo);
    
    /**
     * 今回認定の要介護度を取得します。
     * @param shinseishoKanriNo 申請管理番号
     * @return ZenkaiNinteiKekkaJohoRelateEntity
     */
    ZenkaiNinteiKekkaJohoRelateEntity get要介護度_今回認定(ShinseishoKanriNo shinseishoKanriNo);
    
    /**
     * 受給の前回申請管理番号を取得します。
     * @param shinseishoKanriNo 申請管理番号
     * @return 前回申請管理番号
     */
    RString get前回申請管理番号_受給(ShinseishoKanriNo shinseishoKanriNo);
    
    /**
     * 認定の前回申請管理番号を取得します。
     * @param shinseishoKanriNo 申請管理番号
     * @return 前回申請管理番号
     */
    RString get前回申請管理番号_認定(ShinseishoKanriNo shinseishoKanriNo);
}
