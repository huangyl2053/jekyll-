/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.kojinirainaiyoukoshin;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinirainaiyoukoshin.KojinIraiNaiyouRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 個人依頼内容更新(認定調査票・主治医意見書編集)のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1590-020 zhangzhiming
 */
public interface IKojinIraiNaiyouKoshinMapper {

    /**
     * 訪問調査依頼情報を検索します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<KojinIraiNaiyouRelateEntity>
     */
    List<KojinIraiNaiyouRelateEntity> getChousaIraiJouhou(ShinseishoKanriNo 申請書管理番号);

    /**
     * 主治医依頼情報を検索します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return List<KojinIraiNaiyouRelateEntity>
     */
    List<KojinIraiNaiyouRelateEntity> getSyujiIraiJouhou(ShinseishoKanriNo 申請書管理番号);
}
