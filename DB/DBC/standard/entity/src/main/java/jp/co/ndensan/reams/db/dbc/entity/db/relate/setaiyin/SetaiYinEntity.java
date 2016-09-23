/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.setaiyin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * [2_世帯員把握]一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2770-040 jinjue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class SetaiYinEntity extends DbTableEntityBase<SetaiYinEntity> implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate jukyuYMD;
    private FlexibleYear shotokuNendo;
    private RString juushotitokureigaitou;
    private RString shotaishikibetsuCode;
    private FlexibleDate shotaihaakujukyuYMD;
    private RString honninnkubun;
    private RString kazeikubungennmenzen;
    private RString kazeikubungennmengo;
    private RString gekihenkanwasoti;
    private int goukeishotokukingaku;
    private int nenkinnshuunyuugaku;
    private int nenkinnshotokugaku;
    private int kazeishotokugaku;
    private RString tourokugyoumu;
    private RString shotaiinhihokenshaNo;
    private RString honninkazeikubnn;
    private RString shotaikazeikubun;
    private RString shoubokubun;
    private RString roureifukusikubun;
    private RString shotokukubunCode;
    private RString shotaishotokukubunCode;
    private RString shotaiCode;
    private FlexibleDate seinenngappiYMD;
    private RString zokugaraCode;
    private SetaiCode setaiCode;
    private FlexibleDate seinengappiYMD;
    private int kazokuNo;
}
