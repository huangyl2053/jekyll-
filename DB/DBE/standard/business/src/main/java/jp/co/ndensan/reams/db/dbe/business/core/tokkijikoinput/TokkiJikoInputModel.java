/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.core.tokkijikoinput;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author n3423
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokkiJikoInputModel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private RowState beforeRowState;
    private RowState rowState;
    private RString 特記事項番号;
    private int 特記連番;
    private RString 特記事項;
}
