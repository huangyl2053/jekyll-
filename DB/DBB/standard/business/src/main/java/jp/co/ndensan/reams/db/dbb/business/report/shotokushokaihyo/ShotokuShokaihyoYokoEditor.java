/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.NushiJuminJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.SetaiInn;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoYokoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;

/**
 * 帳票設計_DBBPR51002_所得照会票のクラスです。
 *
 * @reamsid_L DBB-1710-030 xuhao
 */
public class ShotokuShokaihyoYokoEditor implements IShotokuShokaihyoYokoEditor {

    private final NushiJuminJohoResult 所得照会票;
    private final NinshoshaSource sourceBuilder;
    private final RString 文書タイトル;
    private final RString 送付先担当課名称;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_5 = 5;
    private static final int INT_7 = 7;
    private static final int INT_25 = 25;
    private static final int INT_33 = 33;
    private static final int INT_50 = 50;
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_3 = new RString("3");
    private static final RString RSTRING_4 = new RString("4");
    private static final RString 様 = new RString("様");
    private static final RString 転入日 = new RString("転入日");
    private static final RString 転出届出日 = new RString("転出届出日");
    private static final RString ハイフンつき = new RString("-");
    private CustomerBarCode barcode;
    private CustomerBarCodeResult result;

    /**
     * コンストラクタです。
     *
     * @param 所得照会票 NushiJuminJohoResult
     * @param sourceBuilder NinshoshaSource
     * @param 文書タイトル RString
     * @param 送付先担当課名称 RString
     */
    protected ShotokuShokaihyoYokoEditor(NushiJuminJohoResult 所得照会票,
            NinshoshaSource sourceBuilder,
            RString 文書タイトル,
            RString 送付先担当課名称) {
        this.所得照会票 = 所得照会票;
        this.sourceBuilder = sourceBuilder;
        this.文書タイトル = 文書タイトル;
        this.送付先担当課名称 = 送付先担当課名称;
    }

    @Override
    public ShotokuShokaihyoYokoSource edit(ShotokuShokaihyoYokoSource source) {
        source.sofusakiTantoBushoKeisho = 様;
        source.sofusakiTantoBusho = 送付先担当課名称;
        if (所得照会票.get郵便番号() != null) {
            if (所得照会票.get郵便番号().value().length() == INT_5 || 所得照会票.get郵便番号().value().length() == INT_7) {
                source.sofusakiYubinno = 所得照会票.get郵便番号().value().substring(INT_0, INT_3).concat(ハイフンつき)
                        .concat(所得照会票.get郵便番号().value().substring(INT_3, 所得照会票.get郵便番号().value().length()));
            } else {
                source.sofusakiYubinno = 所得照会票.get郵便番号().value();
            }
        }
        if (所得照会票.get住所_上段() != null && 所得照会票.get住所_上段().length() <= INT_25) {
            source.sofusakiJusho1 = 所得照会票.get住所_上段();
        }
        if (所得照会票.get住所_下段() != null && 所得照会票.get住所_下段().length() <= INT_25) {
            source.sofusakiJusho2 = 所得照会票.get住所_下段();
        }
        source.title3 = 文書タイトル;
        source.sofusakiYakusho1 = 所得照会票.get役所_役場名_上段();
        source.sofusakiYakusho2 = 所得照会票.get役所_役場名_下段();
        if (所得照会票.get住民税課税年度() != null) {
            source.juminzeiNendo2 = 所得照会票.get住民税課税年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (所得照会票.get郵便番号() != null) {
            barcode = new CustomerBarCode();
            RString 住所 = 所得照会票.get住所_上段().concat(所得照会票.get住所_下段());
            result = barcode.convertCustomerBarCode(所得照会票.get郵便番号().value(), 住所);
            source.barcode = result.getCustomerBarCode();
        }
        if (所得照会票.get発行日() != null) {
            source.shokaiYMD = 所得照会票.get発行日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        }
        source.setaiCode = 所得照会票.get世帯コード().value();
        set前住所(source);
        set現住所(source);
        if (RSTRING_3.equals(所得照会票.get住民状態コード())) {
            source.ymdTitle = 転出届出日;
        } else {
            source.ymdTitle = 転入日;
        }
        set転入年月日_1(source);
        set転入年月日_2(source);
        set転入年月日_3(source);
        set転入年月日_4(source);
        source.sofusakiYakushokuName = 所得照会票.get市町村名();
        source.sofusakiYakushokuKeisho = 様;
        source.title1 = 文書タイトル;
        source.title2 = 文書タイトル;
        if (所得照会票.get住民税課税年度() != null) {
            source.juminzeiNendo1 = 所得照会票.get住民税課税年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                    .fillType(FillType.BLANK).toDateString();
        }
        if (RSTRING_3.equals(所得照会票.get住民状態コード())) {
            set転出先住所(source);
        } else {
            set転入前住所(source);
        }
        source.hihokenshaShimei = 所得照会票.get氏名();
        source.hihokenshaumareYMD = 生年月日のフォーマット(new RDate(所得照会票.get生年月日().toString()));
        if (所得照会票.get住民税課税年度() != null) {
            source.kazeiNendo = 所得照会票.get住民税課税年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN)
                    .fillType(FillType.BLANK).toDateString();
        }
        source.denshiKoin = sourceBuilder.denshiKoin;
        source.hakkoYMD = sourceBuilder.hakkoYMD;
        source.ninshoshaShimeiKakenai = sourceBuilder.ninshoshaShimeiKakenai;
        source.ninshoshaYakushokuMei = sourceBuilder.ninshoshaYakushokuMei;
        source.koinShoryaku = sourceBuilder.koinShoryaku;
        if (所得照会票.get差出人_郵便番号() != null) {
            if (所得照会票.get差出人_郵便番号().value().length() == INT_5 || 所得照会票.get差出人_郵便番号().value().length() == INT_7) {
                source.yubinBango = 所得照会票.get差出人_郵便番号().value().substring(INT_0, INT_3).concat(ハイフンつき)
                        .concat(所得照会票.get差出人_郵便番号().value().substring(INT_3, 所得照会票.get差出人_郵便番号().value().length()));
            } else {
                source.yubinBango = 所得照会票.get差出人_郵便番号().value();
            }
        }
        source.shozaichi = 所得照会票.get所在地();
        source.bushoName = 所得照会票.get担当部署名();
        source.tantoName = 所得照会票.get担当者名();
        source.choshaName = 所得照会票.get庁舎名();
        source.naisenNo = 所得照会票.get内線番号();
        if (所得照会票.get電話番号() != null) {
            source.telNo = 所得照会票.get電話番号().value();
        }
        return source;
    }

    private void set転入前住所(ShotokuShokaihyoYokoSource source) {
        if (所得照会票.get転入前住所() != null) {
            if (所得照会票.get転入前住所().length() <= INT_33) {
                source.hihokenshaJusho = 所得照会票.get転入前住所();
            } else {
                source.hihokenshaJusho = 所得照会票.get転入前住所().substring(INT_0, INT_50);
            }
        }
    }

    private void set転出先住所(ShotokuShokaihyoYokoSource source) {
        if (所得照会票.get転出先住所() != null) {
            if (所得照会票.get転出先住所().length() <= INT_50) {
                source.hihokenshaJusho = 所得照会票.get転出先住所();
            } else {
                source.hihokenshaJusho = 所得照会票.get転出先住所().substring(INT_0, INT_50);
            }
        }
    }

    private void set現住所(ShotokuShokaihyoYokoSource source) {
        if (所得照会票.get現住所() != null) {
            if (所得照会票.get現住所().length() <= INT_50) {
                source.genJusho = 所得照会票.get現住所();
            } else {
                source.genJusho = 所得照会票.get現住所().substring(INT_0, INT_50);
            }
        }
    }

    private void set前住所(ShotokuShokaihyoYokoSource source) {
        if (所得照会票.get前住所() != null) {
            if (所得照会票.get前住所().length() <= INT_50) {
                source.zenJusho = 所得照会票.get前住所();
            } else {
                source.zenJusho = 所得照会票.get前住所().substring(INT_0, INT_50);
            }
        }
    }

    private void set転入年月日_4(ShotokuShokaihyoYokoSource source) throws IllegalArgumentException {
        if (INT_4 <= 所得照会票.get世帯員リスト().size()) {
            if (RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_3).get住民状態コード())
                    && 所得照会票.get世帯員リスト().get(INT_3).get転出日() != null
                    && !所得照会票.get世帯員リスト().get(INT_3).get転出日().isEmpty()) {
                source.tennyuYMD4 = new RDate(所得照会票.get世帯員リスト().get(INT_3).get転出日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (!RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_3).get住民状態コード())
                    && 所得照会票.get世帯員リスト().get(INT_3).get転入異動日() != null
                    && !所得照会票.get世帯員リスト().get(INT_3).get転入異動日().isEmpty()) {
                source.tennyuYMD4 = new RDate(所得照会票.get世帯員リスト().get(INT_3).get転入異動日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.shikibetsuCode4 = 所得照会票.get世帯員リスト().get(INT_3).get識別コード().value();
            source.shimeiKana4 = 所得照会票.get世帯員リスト().get(INT_3).getカナ氏名();
            source.shimei4 = 所得照会票.get世帯員リスト().get(INT_3).get氏名();
            source.birthYMD4 = 生年月日のフォーマット(new RDate(所得照会票.get世帯員リスト().get(INT_3).get生年月日().toString()));
        }
    }

    private void set転入年月日_3(ShotokuShokaihyoYokoSource source) throws IllegalArgumentException {
        if (INT_3 <= 所得照会票.get世帯員リスト().size()) {
            if (RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_2).get住民状態コード())
                    && 所得照会票.get世帯員リスト().get(INT_2).get転出日() != null
                    && !所得照会票.get世帯員リスト().get(INT_2).get転出日().isEmpty()) {
                source.tennyuYMD3 = new RDate(所得照会票.get世帯員リスト().get(INT_2).get転出日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (!RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_2).get住民状態コード())
                    && 所得照会票.get世帯員リスト().get(INT_2).get転入異動日() != null
                    && !所得照会票.get世帯員リスト().get(INT_2).get転入異動日().isEmpty()) {
                source.tennyuYMD3 = new RDate(所得照会票.get世帯員リスト().get(INT_2).get転入異動日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.shikibetsuCode3 = 所得照会票.get世帯員リスト().get(INT_2).get識別コード().value();
            source.shimeiKana3 = 所得照会票.get世帯員リスト().get(INT_2).getカナ氏名();
            source.shimei3 = 所得照会票.get世帯員リスト().get(INT_2).get氏名();
            source.birthYMD3 = 生年月日のフォーマット(new RDate(所得照会票.get世帯員リスト().get(INT_2).get生年月日().toString()));
        }
    }

    private void set転入年月日_2(ShotokuShokaihyoYokoSource source) throws IllegalArgumentException {
        if (INT_2 <= 所得照会票.get世帯員リスト().size()) {
            if (RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_1).get住民状態コード())
                    && 所得照会票.get世帯員リスト().get(INT_1).get転出日() != null
                    && !所得照会票.get世帯員リスト().get(INT_1).get転出日().isEmpty()) {
                source.tennyuYMD2 = new RDate(所得照会票.get世帯員リスト().get(INT_1).get転出日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (!RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_1).get住民状態コード())
                    && 所得照会票.get世帯員リスト().get(INT_1).get転入異動日() != null
                    && !所得照会票.get世帯員リスト().get(INT_1).get転入異動日().isEmpty()) {
                source.tennyuYMD2 = new RDate(所得照会票.get世帯員リスト().get(INT_1).get転入異動日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.shikibetsuCode2 = 所得照会票.get世帯員リスト().get(INT_1).get識別コード().value();
            source.shimeiKana2 = 所得照会票.get世帯員リスト().get(INT_1).getカナ氏名();
            source.shimei2 = 所得照会票.get世帯員リスト().get(INT_1).get氏名();
            source.birthYMD2 = 生年月日のフォーマット(new RDate(所得照会票.get世帯員リスト().get(INT_1).get生年月日().toString()));
        }
    }

    private void set転入年月日_1(ShotokuShokaihyoYokoSource source) throws IllegalArgumentException {
        if (INT_1 <= 所得照会票.get世帯員リスト().size()) {
            if (RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_0).get住民状態コード())
                    && !所得照会票.get世帯員リスト().get(INT_0).get転出日().isEmpty() && 所得照会票.get世帯員リスト().get(INT_0).get転出日() != null) {
                source.tennyuYMD1 = new RDate(所得照会票.get世帯員リスト().get(INT_0).get転出日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            if (!RSTRING_3.equals(所得照会票.get世帯員リスト().get(INT_0).get住民状態コード())
                    && !所得照会票.get世帯員リスト().get(INT_0).get転入異動日().isEmpty()
                    && 所得照会票.get世帯員リスト().get(INT_0).get転入異動日() != null) {
                source.tennyuYMD1 = new RDate(所得照会票.get世帯員リスト().get(INT_0).get転入異動日().toString()).wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            }
            source.shikibetsuCode1 = 所得照会票.get世帯員リスト().get(INT_0).get識別コード().value();
            source.shimeiKana1 = 所得照会票.get世帯員リスト().get(INT_0).getカナ氏名();
            source.shimei1 = 所得照会票.get世帯員リスト().get(INT_0).get氏名();
            source.birthYMD1 = 生年月日のフォーマット(new RDate(所得照会票.get世帯員リスト().get(INT_0).get生年月日().toString()));
        }
    }

    private RString 生年月日のフォーマット(RDate 生年月日) {
        RString 住民種別コード = 所得照会票.get住民種別コード();
        if ((RSTRING_1.equals(住民種別コード) || RSTRING_3.equals(住民種別コード)
                || is日本人(所得照会票.get世帯員リスト())) && set生年月日(生年月日)) {
            return 生年月日.wareki().toDateString();
        }
        if ((RSTRING_2.equals(住民種別コード) || RSTRING_4.equals(住民種別コード)
                || is外国人(所得照会票.get世帯員リスト())) && set生年月日TWO(生年月日)) {
            return 生年月日.seireki().toDateString();
        }
        return RString.EMPTY;
    }

    private boolean set生年月日TWO(RDate 生年月日) {
        if (生年月日 != null) {
            return true;
        }
        return false;
    }

    private boolean set生年月日(RDate 生年月日) {
        if (生年月日 != null) {
            return true;
        }
        return false;
    }

    private boolean is日本人(List<SetaiInn> 世帯員リスト) {
        boolean flag = false;
        for (SetaiInn setaiInn : 世帯員リスト) {
            if (RSTRING_1.equals(setaiInn.get住民種別コード()) || RSTRING_3.equals(setaiInn.get住民種別コード())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private boolean is外国人(List<SetaiInn> 世帯員リスト) {
        boolean flag = false;
        for (SetaiInn setaiInn : 世帯員リスト) {
            if (RSTRING_2.equals(setaiInn.get住民種別コード()) || RSTRING_4.equals(setaiInn.get住民種別コード())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
