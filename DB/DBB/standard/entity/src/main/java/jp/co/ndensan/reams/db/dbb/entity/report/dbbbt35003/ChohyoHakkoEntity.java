/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.dbbbt35003;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票の発行を定義したEntityクラスです。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Setter
@Getter
public class ChohyoHakkoEntity {

    private RString 帳票分類ID;
    private RYear 調定年度;
    private RString 出力対象区分;
    private RDate 発行日;
    private RDateTime 帳票作成日時;
    private RString 出力順ID;
    private RString 出力順;
    private RString 帳票ID;

}
