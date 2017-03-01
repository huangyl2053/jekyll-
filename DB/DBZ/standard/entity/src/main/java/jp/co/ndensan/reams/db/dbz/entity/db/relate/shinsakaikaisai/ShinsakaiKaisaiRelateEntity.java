/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaikaisai;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会一覧情報RelateEntityクラスです。
 *
 * @reamsid_L DBE-0120-010 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKaisaiRelateEntity implements Serializable {

    private int totalCount;
    private RString shinsakaiKaisaiNo;
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiShuryoYoteiTime;
    private RString 審査会名称;
    private RString gogitaiMei;
    private RString 種類;
    private RString shinsakaiKaisaiBashoName;
    private Decimal shinsakaiWariateZumiNinzu;
    private Decimal shinsakaiYoteiTeiin;
    private FlexibleDate shinsakaiKaisaiYMD;
    private RString shinsakaiKaishiTime;
    private RString shinsakaiShuryoTime;
    private Decimal shinsakaiJisshiNinzu;
    private RString 音声記録;
    private FlexibleDate mobileDataOutputYMD;
    private boolean shiryoSakuseiZumiFlag;
    private RString shinsakaiShinchokuJokyo;
    private RString 資料作成;
    private boolean gogitaiDummyFlag;
    private int 合議体番号;

}
