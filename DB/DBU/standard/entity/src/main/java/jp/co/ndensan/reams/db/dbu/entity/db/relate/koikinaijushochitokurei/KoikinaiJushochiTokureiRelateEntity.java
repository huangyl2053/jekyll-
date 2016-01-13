/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.entity.db.relate.koikinaijushochitokurei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 *
 *  広住特適用情報のエンティティクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KoikinaiJushochiTokureiRelateEntity {
    
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
    private FlexibleDate tekiyoTodokedeYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private FlexibleDate jushochitokureiKaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private RString jushochiTokureiFlag;
    private RString koikinaiJushochiTokureiFlag;
    private LasdecCode sochimotoShichosonCode;
    private LasdecCode kyuShichosonCode;
    private boolean logicalDeletedFlag;
    private UaFt200FindShikibetsuTaishoEntity ft200Entity;
}
