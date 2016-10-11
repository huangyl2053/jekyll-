/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.fuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 賦課計算のEntity。
 *
 * @reamsid_L DBB-0870-010 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FuchoKarisanteiTempEntity extends DbTableEntityBase<FuchoKarisanteiTempEntity>
        implements IDbAccessable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private ShikibetsuCode shikibetsuCode;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private RString hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString shikakuHenkoJiyuCode;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private FlexibleDate jushochitokureiTekiyoYMD;
    private FlexibleDate jushochitokureiTekiyoTodokedeYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private FlexibleDate jushochitokureiKaijoTodokedeYMD;
    private RString jushochiTokureiFlag;
    private RString koikinaiJushochiTokureiFlag;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private LasdecCode kyuShichosonCode;
    private boolean logicalDeletedFlag;

    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private TsuchishoNo tsuchishoNo;
    private FlexibleDate fukaYMD;
}
