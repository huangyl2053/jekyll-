/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0710022;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 住宅改修費支給申請_償還払決定情報登録画面のデータ
 *
 * @reamsid_L DBC-0992-110 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoukanFutsuKetteiJouhouTourokuParameter implements Serializable {

    private Decimal 支払金額合計;
    private RString 支給区分;
    private RString 増減理由;
    private Decimal 増減単位;
    private RDate 決定日;
    private RString 不支給理由１;
    private RString 不支給理由２;
}
