/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009;

import jp.co.ndensan.reams.db.dbc.business.core.kogakugassan.KogakuGassanData;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 自己負担証明書_2009年以降のパラメタークラスです。
 *
 * @reamsid_L DBC-4810-040 kanghongsong
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JikoFutangakushomeishoFromData {

    private KogakuGassanData 高額合算データ;
    private RString タイトル;
    private RString 文書番号;
    private RString 通知文1;
    private RString 保険者情報;
    private RString 通知文2;
    private RString 備考;
    private NinshoshaSource 認証者情報;
    private SofubutsuAtesakiSource 宛先情報;
    private RString 問合せ先情報;
}
