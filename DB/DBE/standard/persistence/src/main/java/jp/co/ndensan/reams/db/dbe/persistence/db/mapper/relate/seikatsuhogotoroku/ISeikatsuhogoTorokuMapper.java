/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.seikatsuhogotoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.seikatsuhogotoroku.SeikatsuhogoTorokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし2号登録のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1310-020 chengsanyuan
 */
public interface ISeikatsuhogoTorokuMapper {

    /**
     * 申請書管理番号から、申請情報を取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 申請情報
     */
    SeikatsuhogoTorokuRelateEntity getShinseiJoho(RString 申請書管理番号);

}
