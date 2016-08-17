/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 高額介護（予防）サービス費支給申請書帳票Editorラクタです。
 *
 * @reamsid_L DBC-4770-060 jiangxiaolong
 */
public class KogakuShikyuShinseishoEditor implements IKogakuShikyuShinseishoEditor {

    private final ShinseiJohoChohyoTempEntity 帳票出力対象データ;
    private final RString 認証者役職名;
    private final FlexibleDate システム日付;
    private final boolean is空白;
    private final RString 連番;
    private final RString 注意文;
    private static final RString 文字_注意 = new RString("注意");
    private static final RString 文字_銀行 = new RString("銀行");
    private static final RString 文字_信用金庫 = new RString("信用金庫");
    private static final RString 文字_信用組合 = new RString("信用組合");
    private static final RString 文字_農協 = new RString("農協");
    private static final RString 文字_本店 = new RString("本店");
    private static final RString 文字_支店 = new RString("支店");
    private static final RString 文字_主張書 = new RString("主張書");
    private static final RString 文字_支所 = new RString("支所");

    /**
     * コンストラクタです
     *
     * @param target KogakuShikyuShinseishoEntity
     */
    public KogakuShikyuShinseishoEditor(
            KogakuShikyuShinseishoEntity target) {
        this.帳票出力対象データ = target.get申請情報帳票発行一時();
        this.認証者役職名 = target.get認証者役職名();
        this.システム日付 = target.getシステム日付();
        this.連番 = target.get連番();
        this.is空白 = target.is空白();
        this.注意文 = target.get注意文();
    }

    @Override
    public KogakuShikyuShinseishoSource edit(
            KogakuShikyuShinseishoSource source) {
        if (!this.is空白) {
            source.teikyoYM = パターン62(帳票出力対象データ.getServiceTeikyoYMChohyo());
            source.hihokenshaNameKana = getColumnValue(帳票出力対象データ.getShimeikanaChohyo());
            source.hihokenshaName = getColumnValue(帳票出力対象データ.getMeishoChohyo());
            source.birthYMD = doパターン12(帳票出力対象データ.getSeinengappiYMDChohyo());
            source.seibetsu = 帳票出力対象データ.getSeibetsuCodeChohyo();
            source.hihokenJusho = getColumnValue(帳票出力対象データ.getJushoChohyo());
            source.telNo = getColumnValue(帳票出力対象データ.getTelNoChohyo());
            source.hokenshaNo = getColumnValue(帳票出力対象データ.getShoKisaiHokenshaNoChohyo());
            source.hihokenshaNo = getColumnValue(帳票出力対象データ.getHihokenshaNoChohyo());
            source.kojinNo = getColumnValue(帳票出力対象データ.getKojinNoChohyo());
        }
        source.hakkoubi = doパターン12(システム日付);
        source.ninshoshaYakushokuMei = 認証者役職名;
        source.chuiTitle = 文字_注意;
        source.chuibun = 注意文;
        source.ginko = 文字_銀行;
        source.shinkin = 文字_信用金庫;
        source.shinkumi = 文字_信用組合;
        source.nokyo = 文字_農協;
        source.honten = 文字_本店;
        source.shiten = 文字_支店;
        source.shuccho = 文字_主張書;
        source.shisho = 文字_支所;
        source.remban = 連番;
        source.識別コード = 帳票出力対象データ.getShikibetsuCodeChohyo();

        return source;
    }

    private RString パターン62(FlexibleYearMonth 年月日) {
        if (年月日 == null) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
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
