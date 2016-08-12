/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.report.tokubetuchosyutaisyosyatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * sql parameters
 *
 * @reamsid_L DBB-0670-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetuChosyutaisyosyaTorokusqlparamEntity {

    private FlexibleYear 賦課年度;
    private HihokenshaNo 被保険者番号;
    private ShoriName 処理名;
    private RString 資格区分;
    private RDate システム日付 = RDate.getNowDate();
    private SubGyomuCode サブ業務コード = SubGyomuCode.DBB介護賦課;
    private FlexibleYear 年度;
    private RString 年度内連番;

}
