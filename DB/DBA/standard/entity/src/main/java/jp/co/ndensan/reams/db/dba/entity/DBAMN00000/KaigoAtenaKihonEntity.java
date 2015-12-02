/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.DBAMN00000;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 介護資格系基本情報Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KaigoAtenaKihonEntity implements Cloneable, Serializable {

    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString edaNo;
    private RString idoJiyuCode;
    @PrimaryKey
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
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;

}
