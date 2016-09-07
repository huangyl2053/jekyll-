/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd5030001;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 通知書発行対象者一覧csvファイルのbusinessです。
 *
 * @reamsid_L DBD-2040-010 chenxin
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DgTsuchishoHakkoBussiness {

    private RString hokensha;
    private RString hihoNumber;
    private RString hihoShimei;
    private TextBoxFlexibleDate ninteiShinseiDay;
    private RString shinseiKubunShinseiji;
    private RString shinseiKubunHorei;
    private TextBoxFlexibleDate tsuchiKanryobi;
    private TextBoxFlexibleDate ninteitsuchishobi;
    private TextBoxFlexibleDate kubunhenkotsuchishobi;
    private TextBoxFlexibleDate servicehenkotsuchishobi;
    private TextBoxFlexibleDate ninteikyakatsuchishobi;
    private TextBoxFlexibleDate ninteitorikeshitsuchishobi;
    private RString shinseishoKanriNo;
    private RString shoKisaiHokenshaNo;
}
