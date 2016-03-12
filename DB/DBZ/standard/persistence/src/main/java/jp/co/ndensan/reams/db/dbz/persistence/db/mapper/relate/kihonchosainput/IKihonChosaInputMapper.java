/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kihonchosainput;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.kihonchosainput.KihonChosaInputEntity;

/**
 *
 * 認定調査基本情報取得です。
 */
public interface IKihonChosaInputMapper {

    /**
     * 認定調査基本情報取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査基本情報リスト
     */
    List<KihonChosaInputEntity> get認定調査基本情報(ShinseishoKanriNo 申請書管理番号);

}
