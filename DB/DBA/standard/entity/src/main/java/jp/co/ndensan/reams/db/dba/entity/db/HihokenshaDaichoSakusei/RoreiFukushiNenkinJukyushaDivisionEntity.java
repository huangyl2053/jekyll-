/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.hihokenshadaichosakusei;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 分割した老齢福祉受給のエンティティクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RoreiFukushiNenkinJukyushaDivisionEntity {

    private List<RString> 老齢福祉No;
    private List<FlexibleDate> 老齢福祉受給開始日;
    private List<FlexibleDate> 老齢福祉受給終了日;
}
