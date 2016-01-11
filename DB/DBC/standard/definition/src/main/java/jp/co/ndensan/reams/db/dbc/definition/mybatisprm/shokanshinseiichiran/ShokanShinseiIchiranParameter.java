/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanshinseiichiran;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import lombok.Getter;

/**
 * 償還払支給申請リスト取得条件を特定するためのMyBatis用パラメータクラスです。
 *
 */
@Getter
public class ShokanShinseiIchiranParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月From;
    private final FlexibleYearMonth サービス提供年月To;
    private final boolean isサービス提供年月FromEmpty;
    private final boolean isサービス提供年月ToEmpty;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月From サービス提供年月From
     * @param サービス提供年月To サービス提供年月To
     * @param isサービス提供年月FromEmpty サービス提供年月FromはEmptyかどうか
     * @param isサービス提供年月ToEmpty サービス提供年月ToはEmptyかどうか
     */
    public ShokanShinseiIchiranParameter(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月From, FlexibleYearMonth サービス提供年月To, boolean isサービス提供年月FromEmpty, boolean isサービス提供年月ToEmpty) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月From = サービス提供年月From;
        this.サービス提供年月To = サービス提供年月To;
        this.isサービス提供年月FromEmpty = isサービス提供年月FromEmpty;
        this.isサービス提供年月ToEmpty = isサービス提供年月ToEmpty;
    }

    /**
     * コンストラクタです
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月From サービス提供年月From
     * @param サービス提供年月To サービス提供年月To
     * @return 償還払申請一覧検索パラメータ
     */
    public static ShokanShinseiIchiranParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月From,
            FlexibleYearMonth サービス提供年月To) {

        return new ShokanShinseiIchiranParameter(被保険者番号, サービス提供年月From, サービス提供年月To,
                サービス提供年月From == null || サービス提供年月From.isEmpty(), サービス提供年月To == null || サービス提供年月To.isEmpty());
    }

}
