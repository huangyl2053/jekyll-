/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsakaikaisaioshirasetsuchi;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiItem;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaikaisaioshirasetsuchi.ShinsakaiKaisaiOshiraseTsuchiReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 介護認定審査会開催のお知らせEditorです。
 *
 * @reamsid_L DBE-0150-110 lishengli
 */
class ShinsakaiKaisaiOshiraseTsuchiEditor implements IShinsakaiKaisaiOshiraseTsuchiEditor {

    private static final int INT_4 = 4;
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_2 = 2;
    private final ShinsakaiKaisaiOshiraseTsuchiItem item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ShinsakaiKaisaiOshiraseTsuchiItem}
     */
    protected ShinsakaiKaisaiOshiraseTsuchiEditor(ShinsakaiKaisaiOshiraseTsuchiItem item) {
        this.item = item;
    }

    /**
     *
     * @param source 介護認定審査会開催のお知らせReportSourceクラス
     * @return ShinsakaiKaisaiOshiraseTsuchiReportSource 介護認定審査会開催のお知らせReportSourceクラス
     */
    @Override
    public ShinsakaiKaisaiOshiraseTsuchiReportSource edit(ShinsakaiKaisaiOshiraseTsuchiReportSource source) {
        return editHeader(source);
    }

    private ShinsakaiKaisaiOshiraseTsuchiReportSource editHeader(ShinsakaiKaisaiOshiraseTsuchiReportSource source) {
        source.bunshoNo = item.get文書番号();
        source.hakkoYMD1 = getパターン9(item.get発行日());
        source.yubinNo = item.get宛名郵便番号();
        source.jushoText = item.get宛名住所();
        source.kikanNameText = item.get宛名機関名();
        source.shimeiText = item.get宛名氏名();
        source.meishoFuyo = item.get宛名名称付与();
        source.title = item.get帳票名();
        source.denshiKoin = item.get電子公印();
        source.koinMojiretsu = item.get電子公印文字列();
        source.koinShoryaku = item.get電子公印省略();
        source.customerBarCode = item.getカスタマーバーコード();
        source.pageCount = item.getページ番号();
        source.ninshoshaShimeiKakenai = item.get認証者氏名公印掛けない();
        source.ninshoshaShimeiKakeru = item.get認証者氏名公印掛ける();
        source.ninshoshaYakushokuMei = item.get認証者役職名();
        source.ninshoshaYakushokuMei1 = item.get認証者役職名1行目();
        source.ninshoshaYakushokuMei2 = item.get認証者役職名2行目();
        source.tsuchibun1 = item.get通知文1();
        source.tsuchibun2 = item.get通知文2();
        source.shinsakaiKaisaiYMD = get開催日時();
        source.kaisaiKaijo = item.get開催会場();
        source.gogitaiNo = item.get合議体();
        source.listKaisaiJoho_1 = get開催番号();
        source.listKaisaiJoho_2 = item.get開催日() != null && !item.get開催日().isEmpty()
                ? item.get開催日().wareki().toDateString() : RString.EMPTY;
        source.listKaisaiJoho_3 = get開催時刻();
        source.listKaisaiJoho_4 = item.get合議体番号().padZeroToLeft(INT_2);
        source.listKaisaiJoho_5 = item.get会場();
        source.listJusho_1 = item.get住所();
        source.listTelNo_1 = item.get電話番号();
        source.tsuchibun3 = item.get通知文3();
        return source;
    }

    private RString get開催時刻() {
        RStringBuilder 開催時刻 = new RStringBuilder();
        開催時刻.append(item.get開催時刻().padZeroToLeft(INT_4).substring(INT_0, INT_2));
        開催時刻.append(new RString(":"));
        開催時刻.append(item.get開催時刻().padZeroToLeft(INT_4).substring(INT_2));
        return 開催時刻.toRString();
    }

    private RString get開催番号() {
        RStringBuilder 開催番号 = new RStringBuilder();
        開催番号.append(new RString("第"));
        if (item.get開催番号().length() > INT_4) {
            開催番号.append(Integer.valueOf(item.get開催番号().substring(item.get開催番号().length() - INT_4).toString()));
        } else {
            開催番号.append(Integer.valueOf(item.get開催番号().toString()));
        }
        開催番号.append(new RString("回"));
        return 開催番号.toRString();
    }

    private RString get開催日時() {
        List<RString> 予定時刻 = item.get予定時刻().split(":");
        RStringBuilder 開催日時 = new RStringBuilder();
        開催日時.append(getパターン9(item.get開催予定年月日()))
                .append(new RString(" "))
                .append(予定時刻.get(INT_0).padZeroToLeft(INT_2))
                .append(new RString("時"))
                .append(予定時刻.get(INT_1).padZeroToLeft(INT_2))
                .append(new RString("分"));
        return 開催日時.toRString();
    }

    private RString getパターン9(FlexibleDate 予定年月日) {
        if (予定年月日 != null) {
            return 予定年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン9(RDate 発行日) {
        if (発行日 != null) {
            return 発行日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }
}
