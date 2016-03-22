/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 契約事業者情報を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
public class KeiyakushaParameter {

    private final HihokenshaNo hihokenshaNo;
    private final FlexibleYearMonth shikyushinseiServiceYM;
    private final RString shikyushinseiSeiriNo;
    private final RString keiyakuNo;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 契約番号 契約番号
     */
    public KeiyakushaParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 契約番号) {
        this.hihokenshaNo = 被保険者番号;
        this.shikyushinseiServiceYM = サービス提供年月;
        this.shikyushinseiSeiriNo = 整理番号;
        this.keiyakuNo = 契約番号;
    }

    /**
     * パラメータを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 契約番号 契約番号
     * @return 介護認定審査会委員情報パラメータ
     */
    public static KeiyakushaParameter createParam(
            @lombok.NonNull HihokenshaNo 被保険者番号,
            @lombok.NonNull FlexibleYearMonth サービス提供年月,
            @lombok.NonNull RString 整理番号,
            @lombok.NonNull RString 契約番号) {
        return new KeiyakushaParameter(被保険者番号, サービス提供年月, 整理番号, 契約番号);
    }
}
