/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.fuka.fukakeisan;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 年度分賦課リストのクラスです。
 *
 * @reamsid_L DBB-0660-030 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NendobunFukaList implements Serializable {

    private FlexibleYear 賦課年度;
    private TsuchishoNo 通知書番号;
    private FukaJoho 現年度;
    private FukaJoho 過年度1;
    private FukaJoho 過年度2;
    private FukaJoho 過年度3;
    private FukaJoho 過年度4;
    private FukaJoho 過年度5;
    private FlexibleDate 賦課期日;
    private FukaJoho 最新賦課の情報;
    private boolean has過年度賦課;
}
