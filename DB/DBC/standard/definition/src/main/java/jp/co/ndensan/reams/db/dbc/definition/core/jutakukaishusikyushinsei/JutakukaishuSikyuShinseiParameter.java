/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 支給申請登録MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JutakukaishuSikyuShinseiParameter {

    private ShikibetsuCode 識別コード;
    private HokenshaNo 証記載保険者番号;
    private FlexibleDate 決定日;
    private final SaveShokanShinseiParameter 償還払支給申請;
    private final SaveShokanKihonParameter 償還払請求基本;
    private final SaveShokanJutakuKaishuParameter 償還払請求住宅改修;
    private final SaveShokanShukeiParameter 償還払請求集計;
    private final UpShokanHanteiKekkaParameter 償還払支給判定結果;

    /**
     * コンストラクタです。
     *
     */
    private JutakukaishuSikyuShinseiParameter(ShikibetsuCode 識別コード,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 決定日,
            SaveShokanShinseiParameter 償還払支給申請,
            SaveShokanKihonParameter 償還払請求基本,
            SaveShokanJutakuKaishuParameter 償還払請求住宅改修,
            SaveShokanShukeiParameter 償還払請求集計,
            UpShokanHanteiKekkaParameter 償還払支給判定結果) {
        this.識別コード = 識別コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.決定日 = 決定日;
        this.償還払支給申請 = 償還払支給申請;
        this.償還払請求基本 = 償還払請求基本;
        this.償還払請求住宅改修 = 償還払請求住宅改修;
        this.償還払請求集計 = 償還払請求集計;
        this.償還払支給判定結果 = 償還払支給判定結果;

    }

    /**
     * コンストラクタです。
     *
     * @param 識別コード 識別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 決定日 決定日
     * @param 償還払支給申請 償還払支給申請
     * @param 償還払請求基本 償還払請求基本
     * @param 償還払請求住宅改修 償還払請求住宅改修
     * @param 償還払請求集計 償還払請求集計
     * @param 償還払支給判定結果 償還払支給判定結果
     * @return JutakukaishuSikyuShinseiParameter
     */
    public static JutakukaishuSikyuShinseiParameter createSelectByKeyParam(ShikibetsuCode 識別コード,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 決定日,
            SaveShokanShinseiParameter 償還払支給申請,
            SaveShokanKihonParameter 償還払請求基本,
            SaveShokanJutakuKaishuParameter 償還払請求住宅改修,
            SaveShokanShukeiParameter 償還払請求集計,
            UpShokanHanteiKekkaParameter 償還払支給判定結果) {
        return new JutakukaishuSikyuShinseiParameter(識別コード, 証記載保険者番号, 決定日, 償還払支給申請,
                償還払請求基本, 償還払請求住宅改修, 償還払請求集計, 償還払支給判定結果);
    }
}
