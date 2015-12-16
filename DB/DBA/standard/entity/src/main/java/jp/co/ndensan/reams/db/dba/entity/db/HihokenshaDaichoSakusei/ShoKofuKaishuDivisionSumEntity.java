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
 *
 * 分割した証交付回収のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoKofuKaishuDivisionSumEntity {

    private List<RString> 証履歴No1;
    private List<FlexibleDate> 証履歴発行日1;
    private List<RString> 証履歴事由名称1;
    private List<FlexibleDate> 証履歴回収日1;

    private List<RString> 証履歴No2;
    private List<FlexibleDate> 証履歴発行日2;
    private List<RString> 証履歴事由名称2;
    private List<FlexibleDate> 証履歴回収日2;
}
