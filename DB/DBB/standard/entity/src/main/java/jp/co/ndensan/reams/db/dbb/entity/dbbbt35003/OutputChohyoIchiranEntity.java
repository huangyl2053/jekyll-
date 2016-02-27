/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.dbbbt35003;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面側からの出力帳票一覧データを定義したEntityクラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class OutputChohyoIchiranEntity {

    private RString chohyoName;
    private RString shutsuryokujun;
    private TextBoxNum hdnHyojijun;
 
}
