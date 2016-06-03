/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.seikatsuhogorireki;

import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 生活保護履歴情報Entityクラスです。
 *
 * @reamsid_L DBZ-4520-010 zhangzhiming
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SeikatsuhogoRelateEntity {

    private ShikibetsuCode shikibetsuCode;
    private GyomuCode gyomuCode;
    private FlexibleDate jukyuKaishiYMD;
    private FlexibleDate jukyuHaishiYMD;
    private RString jukyushaNo;
    private RString kaigoRyoDairiNofuKubun;
    private FlexibleYearMonth kaigoRyoDairiNofuYM;
    private RString kyugoShisetsuNyuTaishoKubun;
    private FlexibleDate kyugoShisetsuNyutaishoYMD;
    private RString jukyuTeishiKaishiYMD;
    private RString jukyuTeishiShuryoYMD;
    private RString fujoShuruiCode;
    private RString fujoShurui;
}
