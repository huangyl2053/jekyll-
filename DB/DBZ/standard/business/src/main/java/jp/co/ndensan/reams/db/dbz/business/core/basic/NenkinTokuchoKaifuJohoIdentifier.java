/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 年金特徴回付情報（介護継承）の識別子です。
 *
 * @reamsid_L DBZ-9999-012 yangchenbing
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Value
public class NenkinTokuchoKaifuJohoIdentifier implements Serializable {

    private static final long serialVersionUID = 1207086073086253113L;
    private final GyomuCode 業務コード;
    private final FlexibleYear 処理年度;
    private final RString 通知内容コード;
    private final FlexibleYearMonth 処理対象年月;
    private final RString 基礎年金番号;
    private final RString 年金コード;
    private final RString 構成市町村コード;
    private final int 連番;

    /**
     * コンストラクタです。
     *
     * @param 業務コード GyomuCode
     * @param 処理年度 FlexibleYear
     * @param 通知内容コード RString
     * @param 処理対象年月 FlexibleYearMonth
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @param 構成市町村コード RString
     * @param 連番 int
     */
    public NenkinTokuchoKaifuJohoIdentifier(GyomuCode 業務コード,
            FlexibleYear 処理年度,
            RString 通知内容コード,
            FlexibleYearMonth 処理対象年月,
            RString 基礎年金番号,
            RString 年金コード,
            RString 構成市町村コード,
            int 連番) {
        this.業務コード = 業務コード;
        this.処理年度 = 処理年度;
        this.通知内容コード = 通知内容コード;
        this.処理対象年月 = 処理対象年月;
        this.基礎年金番号 = 基礎年金番号;
        this.年金コード = 年金コード;
        this.構成市町村コード = 構成市町村コード;
        this.連番 = 連番;
    }
}
