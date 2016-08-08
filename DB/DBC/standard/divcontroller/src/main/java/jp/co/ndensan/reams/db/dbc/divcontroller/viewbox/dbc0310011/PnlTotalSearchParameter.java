
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0310011;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任払いの契約事業者を管理する画面のパラメータです。
 *
 * @reamsid_L DBC-2130-010 cuilin
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class PnlTotalSearchParameter implements Serializable {

    private static final long serialVersionUID = -6680438140785085181L;

    private final RString 契約番号;
    private final RString 契約サービス種類;
    private final RString 被保番号;
    private final RString 氏名;
    private final FlexibleDate 契約申請日;
    private final FlexibleDate 契約決定日;
    private final RString 契約事業者番号;
    private final RString 契約事業者名;
    private final RString 識別コード;

    /**
     * パラメータを作成する。
     *
     * @param 契約番号 RString
     * @param 契約サービス種類 RString
     * @param 被保番号 RString
     * @param 氏名 RString
     * @param 契約申請日 FlexibleDate
     * @param 契約決定日 FlexibleDate
     * @param 契約事業者番号 RString
     * @param 契約事業者名 RString
     * @param 識別コード RString
     */
    public PnlTotalSearchParameter(RString 契約番号,
            RString 契約サービス種類,
            RString 被保番号,
            RString 氏名,
            FlexibleDate 契約申請日,
            FlexibleDate 契約決定日,
            RString 契約事業者番号,
            RString 契約事業者名,
            RString 識別コード) {
        this.契約番号 = 契約番号;
        this.契約サービス種類 = 契約サービス種類;
        this.被保番号 = 被保番号;
        this.氏名 = 氏名;
        this.契約申請日 = 契約申請日;
        this.契約決定日 = 契約決定日;
        this.契約事業者番号 = 契約事業者番号;
        this.契約事業者名 = 契約事業者名;
        this.識別コード = 識別コード;
    }
}
