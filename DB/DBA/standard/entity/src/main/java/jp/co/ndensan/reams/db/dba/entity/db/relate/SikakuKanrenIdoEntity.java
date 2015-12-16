/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 *
 * 資格関連異動のRelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SikakuKanrenIdoEntity implements IDbAccessable {

    private HihokenshaNo hihokenshaNo;
    private FlexibleDate idoYMD;
    private RString edaNo;
    private FlexibleDate shikakuHenkoYMD;
    private FlexibleDate shikakuHenkoTodokedeYMD;
    private RString jushochitokureiTekiyoJiyuCode;
    private LasdecCode shichosonCode;
    private RString shichosonMeisho;
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    private RString shichosonMeisho2;
    private LasdecCode kyuShichosonCode;
    private RString kyuShichosonMeisho;

}
