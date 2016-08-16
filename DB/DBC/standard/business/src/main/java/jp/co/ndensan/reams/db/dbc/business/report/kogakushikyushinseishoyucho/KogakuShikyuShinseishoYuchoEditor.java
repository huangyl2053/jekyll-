/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseishoyucho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseishoyucho.KogakuShikyuShinseishoYuchoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 高額介護（予防）サービス費支給申請書（ゆうちょ）帳票Editorラクタです。
 *
 * @@reamsid_L DBC-4770-070 jiangxiaolong
 */
public class KogakuShikyuShinseishoYuchoEditor implements IKogakuShikyuShinseishoYuchoEditor {

    private final ShinseiJohoChohyoTempEntity 帳票出力対象データ;
    private final RString 認証者役職名;
    private final FlexibleDate システム日付;
    private final boolean is金融機関表示;
    private final RString 連番;
    private final RString 注意文;
    private static final RString 漢字_注意 = new RString("注意");
    private static final int 定値_0 = 0;
    private static final int 定値_1 = 1;
    private static final int 定値_2 = 2;
    private static final int 定値_3 = 3;
    private static final int 定値_4 = 4;
    private static final int 定値_5 = 5;
    private static final int 定値_6 = 6;
    private static final int 定値_7 = 7;
    private static final int 定値_8 = 8;

    /**
     * コンストラクタです
     *
     * @param target KogakuShikyuShinseishoYuchoEntity
     */
    public KogakuShikyuShinseishoYuchoEditor(
            KogakuShikyuShinseishoYuchoEntity target) {
        this.帳票出力対象データ = target.get申請情報帳票発行一時();
        this.認証者役職名 = target.get認証者役職名();
        this.システム日付 = target.getシステム日付();
        this.連番 = target.get連番();
        this.is金融機関表示 = target.is金融機関表示();
        this.注意文 = target.get注意文();
    }

    @Override
    public KogakuShikyuShinseishoYuchoSource edit(
            KogakuShikyuShinseishoYuchoSource source) {
        source.taishoYM = パターン62(帳票出力対象データ.getServiceTeikyoYMChohyo());
        source.hakkoubi = doパターン12(システム日付);
        source.hihokenshaNameKana = getColumnValue(帳票出力対象データ.getShimeikanaChohyo());
        source.hihokenshaName = getColumnValue(帳票出力対象データ.getMeishoChohyo());
        source.birthYMD = doパターン12(帳票出力対象データ.getSeinengappiYMDChohyo());
        source.seibetsu = 帳票出力対象データ.getSeibetsuCodeChohyo();
        source.hihokenJusho = getColumnValue(帳票出力対象データ.getJushoChohyo());
        source.telNo = getColumnValue(帳票出力対象データ.getTelNoChohyo());
        source.hokenshaNo = getColumnValue(帳票出力対象データ.getShoKisaiHokenshaNoChohyo());
        source.hihokenshaNo = getColumnValue(帳票出力対象データ.getHihokenshaNoChohyo());
        source.kojinNo = getColumnValue(帳票出力対象データ.getKojinNoChohyo());
        source.ninshoshaYakushokuMei = 認証者役職名;
        source.chuiTitle = 漢字_注意;
        source.chuibun = 注意文;
        if (this.is金融機関表示) {
            if (帳票出力対象データ.getTsuchoKigoChohyo() != null) {
                source.tuchoKigo1 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(定値_0, 定値_1);
                source.tuchoKigo2 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(定値_1, 定値_2);
                source.tuchoKigo3 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(定値_2, 定値_3);
                source.tuchoKigo4 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(定値_3, 定値_4);
                source.tuchoKigo5 = 帳票出力対象データ.getTsuchoKigoChohyo().substring(定値_4, 定値_5);
            }
            if (帳票出力対象データ.getTsuchoNoChohyo() != null) {
                source.tuchoNo1 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_0, 定値_1);
                source.tuchoNo2 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_1, 定値_2);
                source.tuchoNo3 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_2, 定値_3);
                source.tuchoNo4 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_3, 定値_4);
                source.tuchoNo5 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_4, 定値_5);
                source.tuchoNo6 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_5, 定値_6);
                source.tuchoNo7 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_6, 定値_7);
                source.tuchoNo8 = 帳票出力対象データ.getTsuchoNoChohyo().substring(定値_7, 定値_8);
            }
        } else {
            source.tuchoKigo1 = RString.EMPTY;
            source.tuchoKigo2 = RString.EMPTY;
            source.tuchoKigo3 = RString.EMPTY;
            source.tuchoKigo4 = RString.EMPTY;
            source.tuchoKigo5 = RString.EMPTY;
            source.tuchoNo1 = RString.EMPTY;
            source.tuchoNo2 = RString.EMPTY;
            source.tuchoNo3 = RString.EMPTY;
            source.tuchoNo4 = RString.EMPTY;
            source.tuchoNo5 = RString.EMPTY;
            source.tuchoNo6 = RString.EMPTY;
            source.tuchoNo7 = RString.EMPTY;
            source.tuchoNo8 = RString.EMPTY;
        }
        source.remban = 連番;
        source.識別コード = 帳票出力対象データ.getShikibetsuCodeChohyo();

        return source;
    }

    /**
     * 日付の変換のメソッドです。
     *
     * @param ym 日付
     * @return 日付
     */
    public static RString パターン62(FlexibleYearMonth ym) {
        if (ym == null) {
            return RString.EMPTY;
        }
        return ym.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString doパターン12(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
