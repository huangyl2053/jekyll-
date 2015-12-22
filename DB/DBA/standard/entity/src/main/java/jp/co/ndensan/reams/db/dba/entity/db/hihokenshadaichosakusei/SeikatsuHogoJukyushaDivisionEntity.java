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
 * 分割した生活保護受給者のエンティティクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuHogoJukyushaDivisionEntity {

    private List<RString> 生活保護No;
    private List<FlexibleDate> 受給開始日;
    private List<FlexibleDate> 受給廃止日;
    private List<FlexibleDate> 全額停止開始日;
    private List<FlexibleDate> 全額停止終了日;
    private List<RString> 扶助種類;
}
