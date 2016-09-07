/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護（予防）サービス費支給申請書のEntityクラスです。
 *
 * @reamsid_L DBC-4770-060 jianglaisheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuShikyuShinseishoEntity {

    private ShinseiJohoChohyoTempEntity 申請情報帳票発行一時;
    private RString 認証者役職名;
    private RString 注意文;
    private FlexibleDate システム日付;
    private boolean is空白;
    private RString 連番;
}
