/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpokyuyoshiki1;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1Entity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1ReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 事業状況報告年報（様式１・２　所得段階）のEditorです。
 *
 * @reamsid_L DBU-5610-060 kanghongsong
 */
public class JigyohokokuNenpoKyuyoshiki1Editor implements IJigyohokokuNenpoKyuyoshiki1Editor {

    private static final RString 被保険者数 = new RString("0");
    private static final RString 他の所得段階 = new RString("上記以外");
    private final JigyohokokuNenpoKyuyoshiki1Entity item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link JigyohokokuNenpoKyuyoshiki1Entity item}
     */
    protected JigyohokokuNenpoKyuyoshiki1Editor(JigyohokokuNenpoKyuyoshiki1Entity item) {
        this.item = item;
    }

    @Override
    public JigyohokokuNenpoKyuyoshiki1ReportSource edit(JigyohokokuNenpoKyuyoshiki1ReportSource source) {
        return editSource(source);
    }

    private JigyohokokuNenpoKyuyoshiki1ReportSource editSource(JigyohokokuNenpoKyuyoshiki1ReportSource source) {
        RStringBuilder systemDateTime = new RStringBuilder();
        RDateTime datetime = item.get処理日時();
        systemDateTime.append(datetime.getDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(String.format("%02d", datetime.getHour()));
        systemDateTime.append(new RString("時"));
        systemDateTime.append(String.format("%02d", datetime.getMinute()));
        systemDateTime.append(new RString("分"));
        systemDateTime.append(String.format("%02d", datetime.getSecond()));
        systemDateTime.append(new RString("秒"));
        systemDateTime.append(RString.HALF_SPACE);
        systemDateTime.append(new RString("作成"));
        source.sakuseinichiji = systemDateTime.toRString();
        RStringBuilder shuukeiHani = new RStringBuilder();
        RString 年度 = item.get集計年度().wareki().eraType(EraType.KANJI).toDateString();
        RString 開始年月 = パターン59(item.get集計期間FROM());
        RString 終了年月 = パターン59(item.get集計期間TO());
        shuukeiHani.append("（");
        shuukeiHani.append(年度);
        shuukeiHani.append("分）");
        shuukeiHani.append(開始年月);
        shuukeiHani.append("～");
        shuukeiHani.append(終了年月);
        source.shukeihani = shuukeiHani.toRString();
        source.hokenjano = item.get保険者番号();
        source.hokenjamei = item.get保険者名();
        source.dankai10 = item.get第１段階_被保険者数();
        source.dankai11 = new RString("第1段階");
        source.dankai20 = item.get第２段階_被保険者数();
        source.dankai21 = new RString("第2段階");
        source.dankai30 = item.get第３段階_被保険者数();
        source.dankai31 = new RString("第3段階");
        source.dankai40 = item.get第４段階_被保険者数();
        source.dankai41 = new RString("第4段階");
        source.dankai50 = item.get第５段階_被保険者数();
        source.dankai51 = new RString("第5段階");
        source.dankai60 = item.get第６段階１_被保険者数();
        source.dankai61 = new RString("第6段階");
        source.dankai70 = item.get第６段階２_被保険者数();
        source.dankai71 = new RString("第7段階");
        source.dankai80 = item.get第６段階３_被保険者数();
        source.dankai81 = new RString("第8段階");
        source.dankai90 = item.get第６段階４_被保険者数();
        source.dankai91 = 他の所得段階;
        source.dankai100 = item.get第７段階１_被保険者数();
        source.dankai101 = new RString("第7段階");
        source.dankai110 = item.get第７段階２_被保険者数();
        source.dankai111 = new RString("第8段階");
        source.dankai120 = item.get第７段階３_被保険者数();
        source.dankai121 = new RString("第9段階");
        source.dankai130 = item.get第７段階４_被保険者数();
        source.dankai131 = 他の所得段階;
        source.dankai140 = item.get第８段階１_被保険者数();
        source.dankai141 = new RString("第8段階");
        source.dankai150 = item.get第８段階２_被保険者数();
        source.dankai151 = new RString("第9段階");
        source.dankai160 = item.get第８段階３_被保険者数();
        source.dankai161 = new RString("第10段階");
        source.dankai170 = item.get第８段階４_被保険者数();
        source.dankai171 = 他の所得段階;
        source.dankai180 = item.get第９段階１_被保険者数();
        source.dankai181 = new RString("第9段階");
        source.dankai190 = item.get第９段階２_被保険者数();
        source.dankai191 = new RString("第10段階");
        source.dankai200 = item.get第９段階３_被保険者数();
        source.dankai201 = new RString("第11段階");
        source.dankai210 = item.get第９段階４_被保険者数();
        source.dankai211 = new RString("第12段階");
        source.dankai220 = item.get第９段階５_被保険者数();
        source.dankai221 = new RString("第13段階");
        source.dankai230 = item.get第９段階６_被保険者数();
        source.dankai231 = new RString("第14段階");
        source.dankai240 = item.get第９段階７_被保険者数();
        source.dankai241 = new RString("第15段階");
        source.dankai250 = item.get第９段階８_被保険者数();
        source.dankai251 = new RString("第16段階");
        source.dankai260 = item.get第９段階９_被保険者数();
        source.dankai261 = 他の所得段階;
        if (!被保険者数.equals(item.get不明_被保険者週())) {
            source.dankai270 = item.get不明_被保険者週();
            source.dankai271 = new RString("所得不明段階");
        } else {
            source.dankai270 = new RString("");
            source.dankai271 = new RString("");
        }
        source.tsukihokenryo = item.get標準月額保険料();
        source.gokei = item.get合計();
        return source;
    }

    private static RString パターン59(FlexibleYearMonth date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }
}
