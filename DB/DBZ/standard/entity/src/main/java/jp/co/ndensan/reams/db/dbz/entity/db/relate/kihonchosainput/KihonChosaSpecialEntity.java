/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査特記情報Entityです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KihonChosaSpecialEntity {

    private ShinseishoKanriNo 申請書管理番号;
    private int 認定調査依頼履歴番号;
    private RString 認定調査特記事項番号;
    private int 認定調査特記事項連番;
    private Code 原本マスク区分;
    private RString 特記事項;

}
