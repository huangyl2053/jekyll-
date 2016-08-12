/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額総合事業サービス費給付お知らせ通知書（提出期限あり）Entityクラスです。
 *
 * @reamsid_L DBC-4770-100 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuJigyoOshiraseTsuchishopaParameterEntity {

    private ShinseiJohoChohyoTempEntity 申請情報帳票発行一時;
    private SofubutsuAtesakiSource 送付別宛先;
    private NinshoshaSource 認証者;
    private RString タイトル;
    private boolean is自動償還;
    private boolean is空白;
    private RString 文書番号文字列;
    private FlexibleDate 申請書提出期限;

    private RString 通知文1;
    private RString 通知文2;
    private RString 連番;

}
