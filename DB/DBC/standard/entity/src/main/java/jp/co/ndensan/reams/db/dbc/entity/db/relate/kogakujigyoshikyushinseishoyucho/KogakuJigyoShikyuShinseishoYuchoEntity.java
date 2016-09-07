/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakujigyoshikyushinseishoyucho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）のエンティティクラスです。
 *
 * @reamsid_L DBC-4770-090 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
public class KogakuJigyoShikyuShinseishoYuchoEntity {

    private ShinseiJohoChohyoTempEntity 帳票出力対象データ;
    private RString 認証者役職名;
    private RDateTime システム日付;
    private Boolean is金融機関表示;
    private RString 注意文;
    private RString 連番;
}
