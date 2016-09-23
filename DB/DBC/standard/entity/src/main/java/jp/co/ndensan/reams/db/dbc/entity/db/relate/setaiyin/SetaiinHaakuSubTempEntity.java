/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * [2_世帯員把握]テーブルEntityクラスです。
 *
 * @reamsid_L DBC-2770-060 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class SetaiinHaakuSubTempEntity extends DbTableEntityBase<SetaiinHaakuSubTempEntity> implements IDbAccessable {

    // TODO 　一時ファイルでバッチに未実装
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate jukyuYMD;
    private FlexibleYear shotokuNendo;
    private RString juushotitokureigaitou;
}
