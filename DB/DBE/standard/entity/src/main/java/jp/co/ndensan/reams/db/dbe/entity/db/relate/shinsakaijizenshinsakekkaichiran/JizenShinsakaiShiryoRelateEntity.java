/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事前審査会用結果のクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JizenShinsakaiShiryoRelateEntity {

    private RString shinsakaiKaisaiNo;
    private RString shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaisaiBashoName;
    private RString shinsakaiKaishiYoteiTime;
    private boolean shiryoSakuseiZumiFlag;
    private int gogitaiNo;
    private RString gogitaiMei;
    private int shinsakaiYoteiTeiin;
    private int shinsakaiWariateZumiNinzu;
}
