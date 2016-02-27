/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.idochecklist;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 他市町村住所地特例のエンティティクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShisetsuNyutaishoEntity {

    private ShikibetsuCode 識別コード;
    private RString 異動事由コード;
    private FlexibleDate 適用年月日;
    private FlexibleDate 適用届出年月日;
    private FlexibleDate 解除年月日;
    private FlexibleDate 解除届出年月日;
    private boolean 論理削除フラグ;
    private RDateTime 更新日時;
    private JigyoshaNo 入所施設コード;
    private FlexibleDate 入所年月日;
    private FlexibleDate 退所年月日;

}
