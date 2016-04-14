/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.hihokenshoshikakushohakko;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 介護保険施設入退所Entityです。
 *
 * @reamsid_L DBA-1090-021 huangh
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoHokenShisetsuNyutaishoEntity implements IDbAccessable {

    private ShikibetsuCode 識別コード;
    private RString 入所施設種類;
    private RString 入所施設コード;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;
}
