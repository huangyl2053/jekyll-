/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteishinseitoroku;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.NinteiShinseiTorokuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseitoroku.RirekiJohoRelateEntity;
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
     * 被保険者番号から、履歴情報データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 履歴情報
     */
    List<RirekiJohoRelateEntity> getDataForCom(RString 被保険者番号);
            
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5202PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5101PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5102PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5105PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5115PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5116PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5120PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5121PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5122PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5123PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5129PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5130PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5131PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5150PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5190PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5191PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5201PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5203PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5204PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5205PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5206PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5207PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5208PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5209PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5210PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5211PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5212PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5213PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5300PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5301PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5302PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5303PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5304PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5305PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5510PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5590PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5601PhysicalByShinseishoKanriNo(RString 申請書管理番号);
//
//    /**
//     * を削除します。
//     *
//     * @param 申請書管理番号 RString
//     */
//    void deleteDbT5602PhysicalByShinseishoKanriNo(RString 申請書管理番号);
    
}
