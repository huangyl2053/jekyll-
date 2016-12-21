/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikaisai;

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

    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString 合議体名称;
    private RString gogitaiMei;
    private RString 種類;
    private RString shinsakaiKaisaiBashoName;
    private Decimal shinsakaiWariateZumiNinzu;
    private Decimal shinsakaiYoteiTeiin;
    private boolean gogitaiDummyFlag;
    private int 合議体番号;
    private int 最大審査順;

}
