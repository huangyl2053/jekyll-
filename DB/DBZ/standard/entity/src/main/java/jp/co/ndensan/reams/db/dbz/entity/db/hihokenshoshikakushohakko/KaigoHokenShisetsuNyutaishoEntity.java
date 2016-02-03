/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険施設入退所Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShisetsuNyutaishoEntity {

    private RString 識別コード;
    private RString 入所施設種類;
    private RString 入所施設コード;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
}
