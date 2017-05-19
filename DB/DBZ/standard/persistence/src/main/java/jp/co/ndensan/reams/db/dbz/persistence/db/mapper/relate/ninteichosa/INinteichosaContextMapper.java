/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.ninteichosa;

import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteichosa.NinteichosaContextMapperParameter;

/**
 * 認定調査関連情報を取得します。
 */
public interface INinteichosaContextMapper {

    /**
     * @param param 調査依頼履歴を表すパラメータ
     * @return 指定の条件以前に認定調査が実施されている場合、{@code true}.
     */
    boolean hasBeenExaminedBefore(NinteichosaContextMapperParameter param);
}
