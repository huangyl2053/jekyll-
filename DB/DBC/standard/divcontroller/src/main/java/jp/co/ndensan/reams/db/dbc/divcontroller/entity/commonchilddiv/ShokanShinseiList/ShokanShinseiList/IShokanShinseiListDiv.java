package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanShinseiList.ShokanShinseiList;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBC-0960-010 hezhenzhen
 */
public interface IShokanShinseiListDiv extends ICommonChildDivBaseProperties {

    public void initialize(RString 状態, HihokenshaNo 被保険者番号, FlexibleYearMonth サービス年月From, FlexibleYearMonth サービス年月To);
}
