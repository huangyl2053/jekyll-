/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.kihonchosainput;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput.KihonChosaInputEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput.KihonChosaSpecialEntity;

/**
 *
 * 認定調査基本情報取得です。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
public interface IKihonChosaInputMapper {

    /**
     * 認定調査基本情報取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査基本情報リスト
     */
    List<KihonChosaInputEntity> get認定調査基本情報(ShinseishoKanriNo 申請書管理番号);

    /**
     * 認定調査特記情報取得します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return 認定調査特記情報リスト
     */
    List<KihonChosaSpecialEntity> get認定調査特記情報(ShinseishoKanriNo 申請書管理番号);

}
