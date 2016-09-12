/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.seikatsuhogorireki;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seikatsuhogorireki.SeikatsuhogoParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seikatsuhogorireki.SeikatsuhogoRelateEntity;

/**
 * 生活保護履歴情報を取得するのマッパーインタフェースです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
public interface ISeikatsuhogoRirekiMapper {

    /**
     * 生活保護履歴情報を取得します。
     *
     * @param parameter SeikatsuhogoParameter
     * @return List<SeikatsuhogoRelateEntity>
     */
    List<SeikatsuhogoRelateEntity> get生活保護履歴情報(SeikatsuhogoParameter parameter);
}
