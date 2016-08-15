/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額総合事業サービス費給付お知らせ通知書（提出期限なし）のEntityクラスです。
 *
 * @reamsid_L DBC-4770-110 wangxingpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuJigyoOshiraseTsuchishoKigenNashiEntity {

    private ShinseiJohoChohyoTempEntity 申請情報帳票発行一時;
    private SofubutsuAtesakiSource 送付別宛先;
    private NinshoshaSource 認証者;
    private RString タイトル;
    private RString 文書番号文字列;

    private boolean is自動償還;
    private boolean is空白;

    private RString 通知文1;
    private RString 通知文2;

    private RString 連番;
}
