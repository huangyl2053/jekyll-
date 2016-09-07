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

}
