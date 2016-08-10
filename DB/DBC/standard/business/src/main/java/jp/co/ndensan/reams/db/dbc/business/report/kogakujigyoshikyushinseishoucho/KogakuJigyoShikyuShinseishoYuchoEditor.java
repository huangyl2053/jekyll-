/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseishoucho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshikyushinseishoyuchosource.KogakuJigyoShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）Editor
 *
 * @reamsid_L DBC-4770-090 jianglaisheng
 */
public class KogakuJigyoShikyuShinseishoYuchoEditor implements IKogakuJigyoShikyuShinseishoYuchoEditor {

    private final ShinseiJohoChohyoTempEntity 帳票出力対象データ;
    private final RString 認証者役職名;
    private final RDateTime システム日付;
    private final Boolean is金融機関表示;
    private final RString 注意文;
    private final RString 連番;

    /**
     * コンストラクタです
     *
     * @param 帳票出力対象データ ShinseiJohoChohyoTempEntity
     * @param 認証者役職名 RString
     * @param システム日付 RDateTime
     * @param is金融機関表示 Boolean
     * @param 注意文 RString
     * @param 連番 RString
     */
    public KogakuJigyoShikyuShinseishoYuchoEditor(ShinseiJohoChohyoTempEntity 帳票出力対象データ,
            RString 認証者役職名, RDateTime システム日付, Boolean is金融機関表示, RString 注意文, RString 連番) {
        this.帳票出力対象データ = 帳票出力対象データ;
        this.認証者役職名 = 認証者役職名;
        this.システム日付 = システム日付;
        this.is金融機関表示 = is金融機関表示;
        this.注意文 = 注意文;
        this.連番 = 連番;
    }

    /**
     * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）の項目編集です
     *
     * @param source KogakuJigyoShikyuShinseishoYuchoSource
     * @return KogakuJigyoShikyuShinseishoYuchoSource
     */
    @Override
    public KogakuJigyoShikyuShinseishoYuchoSource edit(KogakuJigyoShikyuShinseishoYuchoSource source) {
        source.taishoYM = 帳票出力対象データ.getServiceTeikyoYMChohyo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.hakkoubi = new RString(システム日付.toString());
        source.hihokenshaNameKana = new RString(帳票出力対象データ.getShinseishaShimeiKanaChohyo().toString());
        source.hihokenshaName = new RString(帳票出力対象データ.getShinseishaShimeiChohyo().toString());
        source.birthYMD = 帳票出力対象データ.getSeinengappiYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        source.seibetsu = 帳票出力対象データ.getSeibetsuCode();
        source.hihokenJusho = 帳票出力対象データ.getShinseishaJushoChohyo();
        source.telNo = new RString(帳票出力対象データ.getShinseishaTelNoChohyo().toString());
        source.hokenshaNo = 帳票出力対象データ.getShoKisaiHokenshaNoChohyo().value();
        source.hihokenshaNo = 帳票出力対象データ.getHihokenshaNoChohyo().value();
        source.kojinNo = 帳票出力対象データ.getKojinNo().value();
        source.ninshoshaYakushokuMei = 認証者役職名;
        source.chuiTitle = new RString("注意");
        source.chuibun = 注意文;
        if (is金融機関表示) {
            source.tuchoKigo1 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(0, 1);
            source.tuchoKigo2 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(1, 2);
            source.tuchoKigo3 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(2, 3);
            source.tuchoKigo4 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(3, 4);
            source.tuchoKigo5 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(4, 5);
            source.tuchoNo1 = 帳票出力対象データ.getTsuchoNoChohyo().substring(0, 1);
            source.tuchoNo2 = 帳票出力対象データ.getTsuchoNoChohyo().substring(1, 2);
            source.tuchoNo3 = 帳票出力対象データ.getTsuchoNoChohyo().substring(2, 3);
            source.tuchoNo4 = 帳票出力対象データ.getTsuchoNoChohyo().substring(3, 4);
            source.tuchoNo5 = 帳票出力対象データ.getTsuchoNoChohyo().substring(4, 5);
            source.tuchoNo6 = 帳票出力対象データ.getTsuchoNoChohyo().substring(5, 6);
            source.tuchoNo7 = 帳票出力対象データ.getTsuchoNoChohyo().substring(6, 7);
            source.tuchoNo8 = 帳票出力対象データ.getTsuchoNoChohyo().substring(7, 8);
        }
        source.remban = 連番;
        return source;
    }
}
