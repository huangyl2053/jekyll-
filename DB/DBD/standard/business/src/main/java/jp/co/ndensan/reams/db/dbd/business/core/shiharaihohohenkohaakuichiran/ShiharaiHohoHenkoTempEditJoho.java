/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenkohaakuichiran;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成サービス2償還未払い情報一時テーブル編集クラスです．
 *
 * @reamsid_L DBD-3650-040 x_lilh
 */
public class ShiharaiHohoHenkoTempEditJoho {

    private static final RString 申請中 = new RString("申請中");
    private static final int 件数_0 = 0;

    private int 申請中件数 = 0;
    private int 未通知件数 = 0;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoTempEditJoho() {
    }

    /**
     * 件数編集
     *
     * @param 決定通知書作成年月日 決定通知書作成年月日
     * @param 決定年月日 決定年月日
     */
    public void edit件数について(FlexibleDate 決定通知書作成年月日, FlexibleDate 決定年月日) {
        if (決定通知書作成年月日 == null || 決定通知書作成年月日.isEmpty()) {
            if (決定年月日 == null || 決定年月日.isEmpty()) {
                申請中件数 = 申請中件数 + 1;
            }
            未通知件数 = 未通知件数 + 1;
        }
    }

    /**
     * 編集後申請中設定値
     *
     * @return 編集後申請中設定値
     */
    public RString edit申請中() {
        if (申請中件数 > 件数_0) {
            return 申請中;
        }
        return RString.EMPTY;
    }
}
