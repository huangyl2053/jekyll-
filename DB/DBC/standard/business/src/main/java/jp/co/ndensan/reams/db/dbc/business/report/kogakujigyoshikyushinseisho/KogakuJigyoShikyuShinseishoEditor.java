/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBC100070_介護保険高額総合事業サービス費支給申請書Editor
 *
 * @reamsid_L DBC-4770-080 jianglaisheng
 */
public class KogakuJigyoShikyuShinseishoEditor implements IKogakuJigyoShikyuShinseishoEditor {

    private final ShinseiJohoChohyoTempEntity 帳票出力対象データ;
    private final RString 認証者役職名;
    private final RDate システム日付;
    private final boolean is空白;
    private final RString 注意文;
    private final RString count;
    private final RString attion = new RString("注意");
    private final RString messageGK = new RString("銀行");
    private final RString messageSK = new RString("信用金庫");
    private final RString messageSKU = new RString("信用組合");
    private final RString messageNK = new RString("農協");
    private final RString messageHT = new RString("本店");
    private final RString messageST = new RString("支店");
    private final RString messageSC = new RString("主張書");
    private final RString messageSS = new RString("支所");

    /**
     * コンストラクタです
     *
     * @param entity KogakuJigyoShikyuShinseishoEntity
     */
    public KogakuJigyoShikyuShinseishoEditor(KogakuJigyoShikyuShinseishoEntity entity) {
        this.帳票出力対象データ = entity.get申請情報帳票発行一時();
        this.認証者役職名 = entity.get認証者役職名();
        this.システム日付 = entity.getシステム日付();
        this.is空白 = entity.is空白();
        this.注意文 = entity.get注意文();
        this.count = entity.get連番();
    }

    /**
     * 帳票設計_DBC100070_介護保険高額総合事業サービス費支給申請書の項目編集です
     *
     * @param source KogakuJigyoShikyuShinseishoSource
     * @return KogakuJigyoShikyuShinseishoSource
     */
    @Override
    public KogakuJigyoShikyuShinseishoSource edit(KogakuJigyoShikyuShinseishoSource source) {
        if (!is空白) {
            if (帳票出力対象データ.getServiceTeikyoYMChohyo() != null) {
                source.taishoYM = 帳票出力対象データ.getServiceTeikyoYMChohyo().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
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
                source.hokenshaNo = 帳票出力対象データ.getShoKisaiHokenshaNoChohyo().getColumnValue();
            }
            if (帳票出力対象データ.getHihokenshaNoChohyo() != null) {
                source.hihokenshaNo = 帳票出力対象データ.getHihokenshaNoChohyo().getColumnValue();
            }
            if (帳票出力対象データ.getKojinNo() != null) {
                source.kojinNo = 帳票出力対象データ.getKojinNo().getColumnValue();
            }
        }

        if (システム日付 != null) {
            source.hakkoubi = システム日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }

        source.ninshoshaYakushokuMei = 認証者役職名;
        source.chuiTitle = attion;
        source.chuibun = 注意文;
        source.ginko = messageGK;
        source.shinkin = messageSK;
        source.shinkumi = messageSKU;
        source.nokyo = messageNK;
        source.honten = messageHT;
        source.shiten = messageST;
        source.shuccho = messageSC;
        source.shisho = messageSS;
        source.remban = count;
        source.識別コード = 帳票出力対象データ.getShikibetsuCodeChohyo();
        return source;
    }

}
