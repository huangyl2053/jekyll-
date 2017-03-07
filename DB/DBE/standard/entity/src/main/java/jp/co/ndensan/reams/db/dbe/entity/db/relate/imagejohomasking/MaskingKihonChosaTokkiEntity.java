/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.imagejohomasking;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n3509
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class MaskingKihonChosaTokkiEntity {

    private ShinseishoKanriNo 申請書管理番号;
    private int 認定調査履歴番号;
    private RString 認定調査特記事項番号;
    private int 認定調査特記事項連番;
    private RString 特記事項原本;
    private RString 特記事項マスク;
}
