/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinseitoroku;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.yokaigoninteishinchokujohoshokai.HihokenshaJohoParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.NinteiShinseiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.RirekiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査依頼受付／みなし２号審査受付のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1310-010 chengsanyuan
 */
public interface INinteiShinseiTorokuMapper {

    /**
     * 申請書管理番号から、申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 申請情報
     */
    NinteiShinseiTorokuRelateEntity getShuseiJohoForLoad(RString 申請書管理番号);

    /**
     * 申請書管理番号から、申請情報データを取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 申請情報
     */
    RirekiJohoRelateEntity getDataForCom(RString 申請書管理番号);

    /**
     * 証記載保険者番号、被保険者番号から、申請情報データを取得します。
     *
     * @param param 被保険者情報検索条件
     * @return 申請書管理番号
     */
    RString getZenkaiShinseishoKanriNo(HihokenshaJohoParamter param);
            
    /**
     * DbT5101を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5101PhysicalByShinseishoKanriNo(RString 申請書管理番号);

    /**
     * DbT5102を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5102PhysicalByShinseishoKanriNo(RString 申請書管理番号);

    /**
     * DbT5105を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5105PhysicalByShinseishoKanriNo(RString 申請書管理番号);

    /**
     * DbT5120を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5120PhysicalByShinseishoKanriNo(RString 申請書管理番号);

    /**
     * DbT5121を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5121PhysicalByShinseishoKanriNo(RString 申請書管理番号);

    /**
     * DbT5123を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5123PhysicalByShinseishoKanriNo(RString 申請書管理番号);

    /**
     * DbT5150を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5150PhysicalByShinseishoKanriNo(RString 申請書管理番号);

    /**
     * DbT5590を削除します。
     *
     * @param 申請書管理番号 RString
     */
    void deleteDbT5590PhysicalByShinseishoKanriNo(RString 申請書管理番号);
}
