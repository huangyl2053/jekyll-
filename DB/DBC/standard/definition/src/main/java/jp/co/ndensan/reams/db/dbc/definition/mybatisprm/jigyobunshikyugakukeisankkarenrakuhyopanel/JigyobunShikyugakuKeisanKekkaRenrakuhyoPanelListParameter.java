/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jigyobunshikyugakukeisankkarenrakuhyopanel;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象データ取得のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-4840-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter implements IMyBatisParameter {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private RString 連絡票整理番号;
    private HokenshaNo 証記載保険者番号;

    /**
     * コンストラクタです
     *
     * @param 被保険者番号 HihokenshaNo 
     * @param 対象年度 FlexibleYear
     * @param 連絡票整理番号 RString
     * @param 証記載保険者番号 HokenshaNo
     */
    public JigyobunShikyugakuKeisanKekkaRenrakuhyoPanelListParameter(HihokenshaNo 被保険者番号, 
            FlexibleYear 対象年度, RString 連絡票整理番号, HokenshaNo 証記載保険者番号) {

        this.被保険者番号 = 被保険者番号;
        this.対象年度 = 対象年度;
        this.連絡票整理番号 = 連絡票整理番号;
        this.証記載保険者番号 = 証記載保険者番号;
    }
}
