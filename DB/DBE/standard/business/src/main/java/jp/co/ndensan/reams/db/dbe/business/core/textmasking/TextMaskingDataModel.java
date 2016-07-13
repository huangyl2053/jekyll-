/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.textmasking;

import java.io.Serializable;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * テキストマスキングのパラメータクラスです。
 *
 * @reamsid_L DBE-3000-250 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TextMaskingDataModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString 特記事項テキスト_イメージ区分;
    private RString 調査項目番号;
    private int 特記連番;
    private RString 調査項目名称;
    private Map<RString, RString> 特記事項_マッピング;
}
