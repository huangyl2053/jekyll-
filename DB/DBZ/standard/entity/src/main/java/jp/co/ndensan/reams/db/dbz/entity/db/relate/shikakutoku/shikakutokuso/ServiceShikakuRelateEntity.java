/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakutoku.shikakutokuso;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 資格得喪履歴のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceShikakuRelateEntity implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private RString hihokennshaKubunCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString jushochitokureiKaijoJiyuCode;
    private RString jushochiTokureiFlag;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private LasdecCode shichosonCode2;
    private RString shichosonMeisho2;
    private LasdecCode kyuShichosonCode;
    private RString kyuShichosonMeisho;
}
