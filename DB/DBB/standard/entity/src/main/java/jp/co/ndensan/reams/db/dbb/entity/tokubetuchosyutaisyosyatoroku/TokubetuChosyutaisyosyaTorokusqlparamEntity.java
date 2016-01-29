/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.tokubetuchosyutaisyosyatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * sql parameters
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetuChosyutaisyosyaTorokusqlparamEntity {

    FlexibleYear 賦課年度;
    HihokenshaNo 被保険者番号;
    ShoriName 処理名;
    //ShikakuKubun TODO DBA介護資格.Enum.資格区分.１号被保険者
    RString 資格区分;
    RDate システム日付 = RDate.getNowDate();
    SubGyomuCode サブ業務コード = SubGyomuCode.DBB介護賦課;
    FlexibleYear 年度;

    RString 年度内連番;

}
