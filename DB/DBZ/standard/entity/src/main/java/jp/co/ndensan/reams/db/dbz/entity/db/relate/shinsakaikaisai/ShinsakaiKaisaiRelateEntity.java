/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shinsakaikaisai;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 審査会一覧情報RelateEntityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKaisaiRelateEntity {

    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiShuryoYoteiTime;
    private RString 合議体名称;
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
    private boolean gogitaiDummyFlag;

}
