/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護（予防）サービス費支給申請書（ゆうちょ）のEntityクラスです。
 *
 * @reamsid_L DBC-4770-070 jianglaisheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuShikyuShinseishoYuchoEntity {

    private ShinseiJohoChohyoTempEntity 申請情報帳票発行一時;
    private RString 認証者役職名;
    private RDate システム日付;
    private boolean is金融機関表示;
    private RString 注意文;
    private RString 連番;
}
