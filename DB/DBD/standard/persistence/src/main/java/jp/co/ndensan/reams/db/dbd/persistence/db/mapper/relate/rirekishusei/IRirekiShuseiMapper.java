/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.rirekishusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.rirekishusei.RirekiShuseiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特殊修正のマッパーインタフェースです。
 *
 * @reamsid_L DBD-1330-010 chengsanyuan
 */
public interface IRirekiShuseiMapper {

    /**
     * 受給者台帳から受給履歴を取得する
     *
     * @param 被保険者番号 被保険者番号
     * @return 受給履歴
     */
    List<RirekiShuseiRelateEntity> getDataForLoad(RString 被保険者番号);
}
