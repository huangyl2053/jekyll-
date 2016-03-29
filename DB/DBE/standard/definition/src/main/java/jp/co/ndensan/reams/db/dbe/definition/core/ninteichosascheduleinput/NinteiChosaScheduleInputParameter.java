/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.ninteichosascheduleinput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 調査員情報取得のParameterクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaScheduleInputParameter {

    private final RString 申請者管理番号2;
    private final RString 設定日;
    private final RString 時間枠;
    private final RString 地区コード;
    private final RString 認定調査委託先コード;
    private final RString 認定調査員コード;
    private final RString 市町村コード;
    private final RString 調査員状況02;
    private final boolean has申請者管理番号2;

    /**
     * コンストラクタです。
     *
     * @param 申請者管理番号2 申請者管理番号2
     * @param 設定日 設定日
     * @param 時間枠 時間枠
     * @param 地区コード 地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @param 調査員状況02 調査員状況02
     * @param has申請者管理番号2 has申請者管理番号2
     */
    private NinteiChosaScheduleInputParameter(
            RString 申請者管理番号2,
            RString 設定日,
            RString 時間枠,
            RString 地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 市町村コード,
            RString 調査員状況02,
            boolean has申請者管理番号2) {
        this.申請者管理番号2 = 申請者管理番号2;
        this.設定日 = 設定日;
        this.時間枠 = 時間枠;
        this.地区コード = 地区コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.市町村コード = 市町村コード;
        this.調査員状況02 = 調査員状況02;
        this.has申請者管理番号2 = has申請者管理番号2;
    }

    /**
     * 調査員情報取得のParameteです。
     *
     * @param 申請者管理番号2 申請者管理番号2
     * @param 設定日 設定日
     * @param 時間枠 時間枠
     * @param 地区コード 地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 市町村コード 市町村コード
     * @param 調査員状況02 調査員状況02
     * @return 調査員情報取得のParameter
     */
    public static NinteiChosaScheduleInputParameter createParam(RString 申請者管理番号2,
            RString 設定日,
            RString 時間枠,
            RString 地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 市町村コード,
            RString 調査員状況02) {
        boolean has申請者管理番号2 = false;
        if (!RString.isNullOrEmpty(申請者管理番号2)) {
            has申請者管理番号2 = true;
        }
        return new NinteiChosaScheduleInputParameter(申請者管理番号2,
                設定日,
                時間枠,
                地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード,
                調査員状況02,
                has申請者管理番号2);
    }
}
