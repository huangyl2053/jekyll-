
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd800006;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 社会福祉法人等利用者負担軽減対象確認申請書ヘッダのITEMです。
 *
 * @reamsid_L DBA-0540-698 zhangguopeng
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem {

    private final RString 認証者;
    private final RString フリガナ;
    private final RString 被保険者氏名;
    private final RString 確認番号;
    private final RString 被保険者番号;
    private final RString 生年月日;
    private final RString 性別;
    private final RString 郵便番号;
    private final RString 住所;
    private final RString 電話番号;
    private final RString 通知文;

    /**
     * インスタンスを生成します。
     *
     * @param 認証者 認証者
     * @param フリガナ フリガナ
     * @param 被保険者氏名 被保険者氏名
     * @param 確認番号 確認番号
     * @param 被保険者番号 被保険者番号
     * @param 生年月日 生年月日
     * @param 性別 性別
     * @param 郵便番号 郵便番号
     * @param 住所 住所
     * @param 電話番号 電話番号
     * @param 通知文 通知文
     *
     */
    public ShakaiFukushiHojinFutanKeigenTaishoKakuninShinseishoItem(
            RString 認証者,
            RString フリガナ,
            RString 被保険者氏名,
            RString 確認番号,
            RString 被保険者番号,
            RString 生年月日,
            RString 性別,
            RString 郵便番号,
            RString 住所,
            RString 電話番号,
            RString 通知文) {

        this.認証者 = 認証者;
        this.フリガナ = フリガナ;
        this.被保険者氏名 = 被保険者氏名;
        this.確認番号 = 確認番号;
        this.被保険者番号 = 被保険者番号;
        this.生年月日 = 生年月日;
        this.性別 = 性別;
        this.郵便番号 = 郵便番号;
        this.住所 = 住所;
        this.電話番号 = 電話番号;
        this.通知文 = 通知文;
    }
}
