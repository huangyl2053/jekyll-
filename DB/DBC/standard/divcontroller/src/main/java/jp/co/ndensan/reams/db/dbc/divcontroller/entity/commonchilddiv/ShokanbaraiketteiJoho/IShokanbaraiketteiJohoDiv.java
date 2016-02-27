package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShokanbaraiketteiJoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IShokanbaraiketteiJohoDiv extends ICommonChildDivBaseProperties {

    /**
     * 償還払決定一覧初期化を実行します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param serviceTekyoYM サービス提供年月
     * @param seiriNo 整理番号
     * @param gyomuKbn 業務区分
     * @param mode 画面表示モード
     */
    public void loadInitialize(HihokenshaNo hihokenshaNo, FlexibleYearMonth serviceTekyoYM, RString seiriNo, RString gyomuKbn, RString mode);

    /**
     * 償還払決定一覧DIVを取得します。
     *
     * @return 償還払決定一覧DIV
     */
    public ShokanbaraiketteiJohoDiv getShokanbaraiketteiJohoDiv();
}
