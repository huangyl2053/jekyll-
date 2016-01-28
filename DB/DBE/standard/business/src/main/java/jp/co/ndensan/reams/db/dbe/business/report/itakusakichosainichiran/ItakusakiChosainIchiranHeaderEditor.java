/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.JyoukyouType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.NarabiJunType;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran.NextPageType;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 認定調査委託先・認定調査員一覧表ヘッダEditorです。
 */
public class ItakusakiChosainIchiranHeaderEditor implements ItakusakiChosainIchiranEditor {

    private final ItakusakiChosainIchiranHeadItem item;

    private static final RString KANA = new RString("～");

    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 帳票名 = new RString("介護保険 調査委託先・調査員一覧表");
    private static final RString 改頁 = new RString("認定調査委託先コード毎");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ItakusakiChosainIchiranHeadItem}
     */
    protected ItakusakiChosainIchiranHeaderEditor(ItakusakiChosainIchiranHeadItem item) {
        this.item = item;
    }

    /**
     * 認定調査委託先・認定調査員一覧表ヘッダEditorです。
     *
     * @param source 調査委託先・調査員一覧表Source
     * @return 認定調査委託先・認定調査員一覧表ヘッダEditor
     */
    @Override
    public ItakusakiChosainIchiranReportSource edit(ItakusakiChosainIchiranReportSource source) {
        return edotHeader(source);
    }

    private ItakusakiChosainIchiranReportSource edotHeader(ItakusakiChosainIchiranReportSource source) {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(DATE_作成);
        source.printTimeStamp = printTimeStampSb.toRString();
        source.title = 帳票名;
        RStringBuilder iryoKikanCodeBulider = new RStringBuilder();
        iryoKikanCodeBulider.append(item.getIryoKikanCodeFrom());
        iryoKikanCodeBulider.append(KANA);
        iryoKikanCodeBulider.append(item.getIryoKikanCodeTo());
        source.iryoKikanCode = iryoKikanCodeBulider.toRString();

        RStringBuilder shujiiCodeBulider = new RStringBuilder();
        shujiiCodeBulider.append(item.getShujiiCodeFrom());
        shujiiCodeBulider.append(KANA);
        shujiiCodeBulider.append(item.getShujiiCodeTo());
        source.shujiiCode = shujiiCodeBulider.toRString();

        if (JyoukyouType.有効のみ.code().equals(item.getShujiiJokyo())) {
            source.shujiiJokyo = JyoukyouType.有効のみ.toRString();
        } else if (JyoukyouType.無効のみ.code().equals(item.getShujiiJokyo())) {
            source.shujiiJokyo = JyoukyouType.無効のみ.toRString();
        } else {
            source.shujiiJokyo = JyoukyouType.全て.toRString();
        }
        source.dataShubetsu = RString.EMPTY;
        source.cityCode = item.getCityCode();
        source.cityName = item.getCityName();
        source.sort1 = NarabiJunType.toValue(item.getSort()).toRString();
        source.sort2 = RString.EMPTY;
        source.sort3 = RString.EMPTY;
        source.sort2 = RString.EMPTY;
        source.sort5 = RString.EMPTY;
        if (NextPageType.委託先コード.code().equals(item.getPage())) {
            source.page1 = 改頁;
        } else {
            source.page1 = RString.EMPTY;
        }
        source.page2 = RString.EMPTY;
        source.page3 = RString.EMPTY;
        source.page4 = RString.EMPTY;
        source.page5 = RString.EMPTY;

        return source;
    }

}
