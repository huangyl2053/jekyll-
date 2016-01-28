/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.hihokenshashikakuteisei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所地特例入力情報（List<住所地特例Entity>）
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JushochiTokureiEntity {

    private RString 状態;
    private FlexibleDate 適用日;
    private FlexibleDate 適用届出日;
    private RString 適用事由コード;
    private FlexibleDate 解除日;
    private FlexibleDate 解除届出日;
    private RString 解除事由コード;
}
