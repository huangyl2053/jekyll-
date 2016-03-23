/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteirirekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.param.ninteirirekiichiran.NinteiRirekiIchiranParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;

/**
 * 受給者台帳情報を取得するのマッパーインタフェースです。
 *
 */
public interface INinteiRirekiIchiranMapper {

    /**
     * 受給者台帳情報を取得します。
     *
     * @param params NinteiRirekiIchiranParameter
     * @return List<DbT4001JukyushaDaichoEntity>
     */
    List<DbT4001JukyushaDaichoEntity> getJyukyuuSyaDaiTyouJyoho(NinteiRirekiIchiranParameter params);
}
