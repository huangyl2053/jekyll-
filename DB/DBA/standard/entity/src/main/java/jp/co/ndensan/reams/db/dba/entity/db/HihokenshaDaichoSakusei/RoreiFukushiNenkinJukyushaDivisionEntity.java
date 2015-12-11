/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.HihokenshaDaichoSakusei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class RoreiFukushiNenkinJukyushaDivisionEntity {

    private List<String> 老齢福祉No;
    private List<FlexibleDate> 老齢福祉受給開始日;
    private List<FlexibleDate> 老齢福祉受給終了日;
}
