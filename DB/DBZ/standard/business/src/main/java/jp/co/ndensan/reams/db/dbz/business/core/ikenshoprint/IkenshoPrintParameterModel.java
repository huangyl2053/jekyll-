/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ikenshoprint;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.gamensenikbn.GamenSeniKbn;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 *
 * 依頼書・認定調査票(OCR)・主治医意見書印刷の項目定義クラスです。
 *
 * @reamsid_L DBE-3000-230 sunhaidi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoPrintParameterModel implements Serializable {

    private static final long serialVersionUID = -4668291514551520575L;

    private List<ShinseishoKanriNo> 申請書管理番号リスト;
    private GamenSeniKbn 遷移元画面区分;
}
