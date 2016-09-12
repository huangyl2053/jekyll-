/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosairairirekiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査依頼履歴一覧表のBusinessです。
 *
 * @reamsid_L DBE-1590-031 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ChosairairirekiIchiranBusiness {

    private final RString 直近区分;
    private final RString 被保険者番号;
    private final RString 氏名;
    private final RString 氏名カナ;
    private final RString 住所;
    private final RString 調査機関名;
    private final RString 調査員名;
    private final RString 認定調査依頼日;
    private final RString 申請区分;

    /**
     * コンストラクタです。
     *
     * @param 直近区分 直近区分
     * @param 被保険者番号 被保険者番号
     * @param 氏名 氏名
     * @param 氏名カナ 氏名カナ
     * @param 住所 住所
     * @param 調査機関名 調査機関名
     * @param 調査員名 調査員名
     * @param 認定調査依頼日 認定調査依頼日
     * @param 申請区分 申請区分
     */
    public ChosairairirekiIchiranBusiness(RString 直近区分,
            RString 被保険者番号,
            RString 氏名,
            RString 氏名カナ,
            RString 住所,
            RString 調査機関名,
            RString 調査員名,
            RString 認定調査依頼日,
            RString 申請区分) {
        this.直近区分 = 直近区分;
        this.被保険者番号 = 被保険者番号;
        this.氏名 = 氏名;
        this.氏名カナ = 氏名カナ;
        this.住所 = 住所;
        this.調査機関名 = 調査機関名;
        this.調査員名 = 調査員名;
        this.認定調査依頼日 = 認定調査依頼日;
        this.申請区分 = 申請区分;
    }
}
