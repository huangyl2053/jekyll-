/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseishoucho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshikyushinseishoyuchosource.KogakuJigyoShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
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
    private final RString count;
    private final RString attion = new RString("注意");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;

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
        this.count = 連番;
    }

    /**
     * 帳票設計_DBC100071_介護保険高額総合事業サービス費支給申請書（ゆうちょ銀行）の項目編集です
     *
     * @param source KogakuJigyoShikyuShinseishoYuchoSource
     * @return KogakuJigyoShikyuShinseishoYuchoSource
     */
    @Override
    public KogakuJigyoShikyuShinseishoYuchoSource edit(KogakuJigyoShikyuShinseishoYuchoSource source) {
        if (帳票出力対象データ.getServiceTeikyoYMChohyo() != null) {
            source.taishoYM = 帳票出力対象データ.getServiceTeikyoYMChohyo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (システム日付 != null) {
            source.hakkoubi = システム日付.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        if (帳票出力対象データ.getShinseishaShimeiKanaChohyo() != null) {
            source.hihokenshaNameKana = 帳票出力対象データ.getShinseishaShimeiKanaChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getShinseishaShimeiChohyo() != null) {
            source.hihokenshaName = 帳票出力対象データ.getShinseishaShimeiChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getSeinengappiYMD() != null) {
            source.birthYMD = 帳票出力対象データ.getSeinengappiYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        source.seibetsu = Seibetsu.toValue(帳票出力対象データ.getSeibetsuCode()).get名称();
        source.hihokenJusho = 帳票出力対象データ.getShinseishaJushoChohyo();
        if (帳票出力対象データ.getShinseishaTelNoChohyo() != null) {
            source.telNo = 帳票出力対象データ.getShinseishaTelNoChohyo().getColumnValue();
        }
        if (帳票出力対象データ.getShoKisaiHokenshaNoChohyo() != null) {
            source.hokenshaNo = 帳票出力対象データ.getShoKisaiHokenshaNoChohyo().value();
        }
        if (帳票出力対象データ.getHihokenshaNoChohyo() != null) {
            source.hihokenshaNo = 帳票出力対象データ.getHihokenshaNoChohyo().value();
        }
        if (帳票出力対象データ.getKojinNo() != null) {
            source.kojinNo = 帳票出力対象データ.getKojinNo().value();
        }
        source.ninshoshaYakushokuMei = 認証者役職名;
        source.chuiTitle = attion;
        source.chuibun = 注意文;
        if (is金融機関表示 && 帳票出力対象データ.getTsuchoKigoChohyo() != null && 帳票出力対象データ.getTsuchoNoChohyo() != null) {
            source.tuchoKigo1 = 帳票出力対象データ.getTsuchoKigoChohyo().substringReturnAsPossible(INDEX_0, INDEX_1);
            source.tuchoKigo2 = 帳票出力対象データ.getTsuchoKigoChohyo().substringReturnAsPossible(INDEX_1, INDEX_2);
            source.tuchoKigo3 = 帳票出力対象データ.getTsuchoKigoChohyo().substringReturnAsPossible(INDEX_2, INDEX_3);
            source.tuchoKigo4 = 帳票出力対象データ.getTsuchoKigoChohyo().substringReturnAsPossible(INDEX_3, INDEX_4);
            source.tuchoKigo5 = 帳票出力対象データ.getTsuchoKigoChohyo().substringReturnAsPossible(INDEX_4, INDEX_5);
            source.tuchoNo1 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_0, INDEX_1);
            source.tuchoNo2 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_1, INDEX_2);
            source.tuchoNo3 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_2, INDEX_3);
            source.tuchoNo4 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_3, INDEX_4);
            source.tuchoNo5 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_4, INDEX_5);
            source.tuchoNo6 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_5, INDEX_6);
            source.tuchoNo7 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_6, INDEX_7);
            source.tuchoNo8 = 帳票出力対象データ.getTsuchoNoChohyo().substringReturnAsPossible(INDEX_7, INDEX_8);
        }
        source.remban = count;
        source.識別コード = 帳票出力対象データ.getShikibetsuCodeChohyo();
        return source;
    }
}
