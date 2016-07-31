/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.kihonchosainput;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査基本情報Entityです。
 *
 * @reamsid_L DBE-3000-090 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KihonChosaInputEntity implements Serializable {

    private ShinseishoKanriNo 申請書管理番号;
    private int 認定調査依頼履歴番号;
    private Code 認知症高齢者自立度;
    private Code 障害高齢者自立度;
    private int 調査連番;
    private RString 調査項目;
    private Code 前回認知症高齢者自立度;
    private Code 前回障害高齢者自立度;
    private int 前回調査連番;
    private RString 前回調査項目;
    private boolean 特記事項有無;

}
