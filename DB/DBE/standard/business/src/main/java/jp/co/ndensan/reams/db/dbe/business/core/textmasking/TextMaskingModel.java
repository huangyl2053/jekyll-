/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.textmasking;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author n3509
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TextMaskingModel implements Serializable {

    private static final long serialVersionUID = 1L;
    private RString 編集タイトル;
    private RString 調査項目番号;
    private int 特記連番;
    private RString 原本テキスト;
    private RString マスキング対象テキスト;
}
