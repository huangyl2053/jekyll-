/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護保険高額総合事業サービス費支給申請書のEntityクラスです。
 *
 * @reamsid_L DBC-4770-080 jianglaisheng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuJigyoShikyuShinseishoEntity {

    private ShinseiJohoChohyoTempEntity 申請情報帳票発行一時;
    private RString 認証者役職名;
    private RDate システム日付;
    private boolean is空白;
    private RString 連番;
}
