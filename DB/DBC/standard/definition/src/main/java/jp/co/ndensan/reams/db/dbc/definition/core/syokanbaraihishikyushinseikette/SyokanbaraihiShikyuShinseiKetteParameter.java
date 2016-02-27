/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 決定情報登録更新MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SyokanbaraihiShikyuShinseiKetteParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final FlexibleDate 決定年月日;
    private final RString 支給区分;
    private final Decimal 支払金額合計;
    private final int 差額金額;
    private final RString 増減理由等;
    private final RString 不支給理由等1;
    private final RString 不支給理由等2;
    private final int 増減単位;
    private final boolean 差額金額登録フラグ;
    private final JigyoshaNo 事業者番号;
    private final RString 証明書コード;
    private final RString 明細番号;
    private final RString 連番;
    private final RString 画面モード;
    private final ShikibetsuCode 識別コード;
    private final List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 決定年月日 決定年月日
     * @param 支給区分 支給区分
     * @param 支払金額合計 支払金額合計
     * @param 差額金額 差額金額
     * @param 増減理由等 増減理由等
     * @param 不支給理由等1 不支給理由等1
     * @param 不支給理由等2 不支給理由等2
     * @param 増減単位 増減単位
     * @param 差額金額登録フラグ 差額金額登録フラグ
     * @param 事業者番号 事業者番号
     * @param 証明書コード 証明書コード
     * @param 明細番号 明細番号
     * @param 連番 連番
     * @param 画面モード 画面モード
     * @param 識別コード 識別コード
     * @param 決定情報一覧List 決定情報一覧List
     */
    protected SyokanbaraihiShikyuShinseiKetteParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月, RString 整理番号, FlexibleDate 決定年月日, RString 支給区分,
            Decimal 支払金額合計, int 差額金額, RString 増減理由等, RString 不支給理由等1,
            RString 不支給理由等2, int 増減単位, boolean 差額金額登録フラグ, JigyoshaNo 事業者番号,
            RString 証明書コード, RString 明細番号, RString 連番, RString 画面モード, ShikibetsuCode 識別コード,
            List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.決定年月日 = 決定年月日;
        this.支給区分 = 支給区分;
        this.支払金額合計 = 支払金額合計;
        this.差額金額 = 差額金額;
        this.増減理由等 = 増減理由等;
        this.不支給理由等1 = 不支給理由等1;
        this.不支給理由等2 = 不支給理由等2;
        this.増減単位 = 増減単位;
        this.差額金額登録フラグ = 差額金額登録フラグ;
        this.事業者番号 = 事業者番号;
        this.証明書コード = 証明書コード;
        this.明細番号 = 明細番号;
        this.連番 = 連番;
        this.画面モード = 画面モード;
        this.識別コード = 識別コード;
        this.決定情報一覧List = 決定情報一覧List;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 決定年月日 決定年月日
     * @param 支給区分 支給区分
     * @param 支払金額合計 支払金額合計
     * @param 差額金額 差額金額
     * @param 増減理由等 増減理由等
     * @param 不支給理由等1 不支給理由等1
     * @param 不支給理由等2 不支給理由等2
     * @param 増減単位 増減単位
     * @param 差額金額登録フラグ 差額金額登録フラグ
     * @param 事業者番号 事業者番号
     * @param 証明書コード 証明書コード
     * @param 明細番号 明細番号
     * @param 連番 連番
     * @param 画面モード 画面モード
     * @param 識別コード 識別コード
     * @param 決定情報一覧List 決定情報一覧List
     * @return SyokanbaraihiShikyuShinseiKetteParameter
     */
    public static SyokanbaraihiShikyuShinseiKetteParameter createSelectByKeyParam(
            HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, RString 整理番号,
            FlexibleDate 決定年月日, RString 支給区分, Decimal 支払金額合計, int 差額金額, RString 増減理由等,
            RString 不支給理由等1, RString 不支給理由等2, int 増減単位, boolean 差額金額登録フラグ,
            JigyoshaNo 事業者番号, RString 証明書コード, RString 明細番号, RString 連番, RString 画面モード,
            ShikibetsuCode 識別コード, List<SyokanbaraihiShikyuShinseiKetteEntity> 決定情報一覧List) {
        return new SyokanbaraihiShikyuShinseiKetteParameter(被保険者番号, サービス提供年月, 整理番号, 決定年月日,
                支給区分, 支払金額合計, 差額金額, 増減理由等, 不支給理由等1, 不支給理由等2, 増減単位,
                差額金額登録フラグ, 事業者番号, 証明書コード, 明細番号, 連番, 画面モード, 識別コード,
                決定情報一覧List);
    }
}
