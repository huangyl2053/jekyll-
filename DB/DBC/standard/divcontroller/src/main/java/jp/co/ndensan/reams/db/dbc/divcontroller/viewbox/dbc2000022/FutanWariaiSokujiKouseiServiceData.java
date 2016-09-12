/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc2000022;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiKonkyo;
import jp.co.ndensan.reams.db.dbd.business.core.futanwariai.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 画面設計_DBCMNK2001_利用者負担割合即時更正_修正の引き継ぎ情報です。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FutanWariaiSokujiKouseiServiceData implements Serializable {

    private static final long serialVersionUID = 1L;

    private RiyoshaFutanWariai 利用者負担割合;
    private List<RiyoshaFutanWariaiMeisai> 利用者負担割合明細list;
    private List<RiyoshaFutanWariaiKonkyo> 利用者負担割合根拠list;
    private RString 漢字氏名;
    private boolean 登録結果;

}
