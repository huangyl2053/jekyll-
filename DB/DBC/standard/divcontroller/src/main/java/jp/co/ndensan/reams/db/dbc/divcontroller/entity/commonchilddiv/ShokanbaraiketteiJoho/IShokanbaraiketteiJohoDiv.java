package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShokanbaraiketteiJohoDiv extends ICommonChildDivBaseProperties {

    public void loadInitialize(HihokenshaNo hihokenshaNo, FlexibleYearMonth serviceTekyoYM, RString seiriNo, RString gyomuKbn, RString mode);
}
