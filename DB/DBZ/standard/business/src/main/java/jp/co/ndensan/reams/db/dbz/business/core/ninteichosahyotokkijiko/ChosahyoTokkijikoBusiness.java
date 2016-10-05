/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 要介護認定調査票（特記事項）のBusinessです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosahyoTokkijikoBusiness {

    private final RString hokenshaNo4;
    private final RString shinseiYY1;
    private final RString shinseiYY2;
    private final RString shinseiMM1;
    private final RString shinseiMM2;
    private final RString shinseiDD1;
    private final RString shinseiDD2;
    private final RString hokenshaNo1;
    private final RString hokenshaNo2;
    private final RString hokenshaNo3;
    private final RString hokenshaNo5;
    private final RString hokenshaNo6;
    private final RString hihokenshaNo1;
    private final RString hihokenshaNo3;
    private final RString hihokenshaNo4;
    private final RString hihokenshaNo5;
    private final RString hihokenshaNo6;
    private final RString hihokenshaNo7;
    private final RString hihokenshaNo8;
    private final RString hihokenshaNo9;
    private final RString hihokenshaNo10;
    private final RString hihokenshaNo2;
    private final RString hihokenshaName;

    /**
     * コンストラクタです。
     *
     * @param hokenshaNo4 証記載保険者番号4
     * @param shinseiYY1 申請年1
     * @param shinseiYY2 申請年2
     * @param shinseiMM1 申請月1
     * @param shinseiMM2 申請月2
     * @param shinseiDD1 申請日1
     * @param shinseiDD2 申請日2
     * @param hokenshaNo1 証記載保険者番号1
     * @param hokenshaNo2 証記載保険者番号2
     * @param hokenshaNo3 証記載保険者番号3
     * @param hokenshaNo5 証記載保険者番号5
     * @param hokenshaNo6 証記載保険者番号6
     * @param hihokenshaNo1 被保険者番号1
     * @param hihokenshaNo3 被保険者番号3
     * @param hihokenshaNo4 被保険者番号4
     * @param hihokenshaNo5 被保険者番号5
     * @param hihokenshaNo6 被保険者番号6
     * @param hihokenshaNo7 被保険者番号7
     * @param hihokenshaNo8 被保険者番号8
     * @param hihokenshaNo9 被保険者番号9
     * @param hihokenshaNo10 被保険者番号10
     * @param hihokenshaNo2 被保険者番号2
     * @param hihokenshaName 被保険者名
     */
    public ChosahyoTokkijikoBusiness(
            RString hokenshaNo4,
            RString shinseiYY1,
            RString shinseiYY2,
            RString shinseiMM1,
            RString shinseiMM2,
            RString shinseiDD1,
            RString shinseiDD2,
            RString hokenshaNo1,
            RString hokenshaNo2,
            RString hokenshaNo3,
            RString hokenshaNo5,
            RString hokenshaNo6,
            RString hihokenshaNo1,
            RString hihokenshaNo3,
            RString hihokenshaNo4,
            RString hihokenshaNo5,
            RString hihokenshaNo6,
            RString hihokenshaNo7,
            RString hihokenshaNo8,
            RString hihokenshaNo9,
            RString hihokenshaNo10,
            RString hihokenshaNo2,
            RString hihokenshaName
    ) {
        this.hokenshaNo4 = hokenshaNo4;
        this.shinseiYY1 = shinseiYY1;
        this.shinseiYY2 = shinseiYY2;
        this.shinseiMM1 = shinseiMM1;
        this.shinseiMM2 = shinseiMM2;
        this.shinseiDD1 = shinseiDD1;
        this.shinseiDD2 = shinseiDD2;
        this.hokenshaNo1 = hokenshaNo1;
        this.hokenshaNo2 = hokenshaNo2;
        this.hokenshaNo3 = hokenshaNo3;
        this.hokenshaNo5 = hokenshaNo5;
        this.hokenshaNo6 = hokenshaNo6;
        this.hihokenshaNo1 = hihokenshaNo1;
        this.hihokenshaNo3 = hihokenshaNo3;
        this.hihokenshaNo4 = hihokenshaNo4;
        this.hihokenshaNo5 = hihokenshaNo5;
        this.hihokenshaNo6 = hihokenshaNo6;
        this.hihokenshaNo7 = hihokenshaNo7;
        this.hihokenshaNo8 = hihokenshaNo8;
        this.hihokenshaNo9 = hihokenshaNo9;
        this.hihokenshaNo10 = hihokenshaNo10;
        this.hihokenshaNo2 = hihokenshaNo2;
        this.hihokenshaName = hihokenshaName;
    }
}
