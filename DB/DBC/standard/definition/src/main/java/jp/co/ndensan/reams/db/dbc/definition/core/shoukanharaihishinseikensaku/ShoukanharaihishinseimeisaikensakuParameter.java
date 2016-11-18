/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.shoukanharaihishinseikensaku;

import java.io.Serializable;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 償還払費申請明細検索キーのParameter。
 *
 * @reamsid_L DBC-1030-020 wangkanglei
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class ShoukanharaihishinseimeisaikensakuParameter implements Serializable {

    private static final long serialVersionUID = 1L;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス年月;
    private final RDate 申請日;
    private final RString 整理番号;
    private final JigyoshaNo 事業者番号;
    private final RString 様式番号;
    private final RString 明細番号;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス年月 FlexibleYearMonth
     * @param 申請日 RString
     * @param 整理番号 RString
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 RString
     * @param 明細番号 RString
     */
    public ShoukanharaihishinseimeisaikensakuParameter(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス年月,
            RDate 申請日,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        this.被保険者番号 = 被保険者番号;
        this.サービス年月 = サービス年月;
        this.申請日 = 申請日;
        this.整理番号 = 整理番号;
        this.事業者番号 = 事業者番号;
        this.様式番号 = 様式番号;
        this.明細番号 = 明細番号;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ShoukanharaihishinseimeisaikensakuParameter) {
            ShoukanharaihishinseimeisaikensakuParameter other明細キー = (ShoukanharaihishinseimeisaikensakuParameter) obj;
            if (this.被保険者番号.equals(other明細キー.被保険者番号)
                    && this.サービス年月.equals(other明細キー.サービス年月)
                    && this.申請日.equals(other明細キー.申請日)
                    && this.整理番号.equals(other明細キー.整理番号)
                    && this.事業者番号.equals(other明細キー.事業者番号)
                    && this.様式番号.equals(other明細キー.様式番号)
                    && this.明細番号.equals(other明細キー.明細番号)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.被保険者番号);
        hash = 89 * hash + Objects.hashCode(this.サービス年月);
        hash = 89 * hash + Objects.hashCode(this.申請日);
        hash = 89 * hash + Objects.hashCode(this.整理番号);
        hash = 89 * hash + Objects.hashCode(this.事業者番号);
        hash = 89 * hash + Objects.hashCode(this.様式番号);
        hash = 89 * hash + Objects.hashCode(this.明細番号);
        return hash;
    }
}
