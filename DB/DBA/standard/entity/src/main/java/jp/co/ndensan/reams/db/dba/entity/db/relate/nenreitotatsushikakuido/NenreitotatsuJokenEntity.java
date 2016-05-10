/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitotatsushikakuido;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年齢到達条件Entityクラスです。
 *
 * @reamsid_L DBA-0330-020 xuyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NenreitotatsuJokenEntity {

    private FlexibleDate 前回処理期間開始日;
    private FlexibleDate 前回処理期間終了日;
    private RString 年齢到達期間開始日;
    private RString 年齢到達期間終了日;

}
