/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.rirekishusei;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.rirekishusei.RirekiShuseiMapperParameter;
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

    /**
     * 受給者台帳の履歴番号を更新する。
     *
     * @param param 受給者台帳更新の項目
     * @return 更新件数
     */
    int upd履歴番号(RirekiShuseiMapperParameter param);
}
