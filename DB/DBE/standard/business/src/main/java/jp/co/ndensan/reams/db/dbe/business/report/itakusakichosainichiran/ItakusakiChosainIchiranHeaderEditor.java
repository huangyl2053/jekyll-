/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import jp.co.ndensan.reams.db.dbe.business.core.itakusakichosainichiran.ItakusakiChosainIchiranHead;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.JyoukyouType;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.NarabiJunType;
import jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran.NextPageType;
import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
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
 *
 * @reamsid_L DBE-0290-020 dongyabin
 */
public class ItakusakiChosainIchiranHeaderEditor implements ItakusakiChosainIchiranEditor {

    private static final RString 有効_VALUE = new RString("有効");
    private static final RString 無効_VALUE = new RString("無効");
    private static final RString KANA = new RString("～");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString 帳票名 = new RString("介護保険 調査委託先・調査員一覧表");
    private static final RString 改頁 = new RString("認定調査委託先コード毎");
    private static final RString 並び順１項１ = new RString("認定調査委託先コード");
    private static final RString 並び順１項２ = new RString("認定調査委託先名称");
    private static final RString 並び順２項１ = new RString("調査員コード");
    private static final RString 並び順２項２ = new RString("調査員氏名");
    private static final RString 並び順２項３ = new RString("調査員カナ氏名");

    private final ItakusakiChosainIchiranHead item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ItakusakiChosainIchiranHead}
     */
    protected ItakusakiChosainIchiranHeaderEditor(ItakusakiChosainIchiranHead item) {
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

        RString 委託先コードFrom = item.getIryoKikanCodeFrom();
        RString 委託先コードTo = item.getIryoKikanCodeTo();
        source.iryoKikanCode = RString.EMPTY;
        if (!RString.isNullOrEmpty(委託先コードFrom) || !RString.isNullOrEmpty(委託先コードTo)) {
            RStringBuilder iryoKikanCodeBulider = new RStringBuilder();
            iryoKikanCodeBulider.append(item.getIryoKikanCodeFrom());
            iryoKikanCodeBulider.append(KANA);
            iryoKikanCodeBulider.append(item.getIryoKikanCodeTo());
            source.iryoKikanCode = iryoKikanCodeBulider.toRString();
        }

        RString 調査員コードFrom = item.getShujiiCodeFrom();
        RString 調査員コードTo = item.getShujiiCodeTo();
        source.shujiiCode = RString.EMPTY;

        if (!RString.isNullOrEmpty(調査員コードFrom) || !RString.isNullOrEmpty(調査員コードTo)) {
            RStringBuilder shujiiCodeBulider = new RStringBuilder();
            shujiiCodeBulider.append(item.getShujiiCodeFrom());
            shujiiCodeBulider.append(KANA);
            shujiiCodeBulider.append(item.getShujiiCodeTo());
            source.shujiiCode = shujiiCodeBulider.toRString();
        }

        if (JyoukyouType.有効のみ.code().equals(item.getShujiiJokyo())) {
            source.shujiiJokyo = JyoukyouType.有効のみ.toRString();
        } else if (JyoukyouType.無効のみ.code().equals(item.getShujiiJokyo())) {
            source.shujiiJokyo = JyoukyouType.無効のみ.toRString();
        } else {
            source.shujiiJokyo = JyoukyouType.全て.toRString();
        }
        source.dataShubetsu = new RString("調査委託先マスタ");
        source.cityCode = item.getCityCode();
        source.cityName = item.getCityName();

        NarabiJunType 並び順種類 = NarabiJunType.toValue(item.getSort());
        RString 並び順１ = RString.EMPTY;
        RString 並び順２ = RString.EMPTY;

        if (並び順種類.compareTo(NarabiJunType.委託先コード_調査員コード) == 0) {
            並び順１ = 並び順１項１;
            並び順２ = 並び順２項１;
        } else if (並び順種類.compareTo(NarabiJunType.委託先コード_調査員氏名) == 0) {
            並び順１ = 並び順１項１;
            並び順２ = 並び順２項２;
        } else if (並び順種類.compareTo(NarabiJunType.委託先コード_調査員カナ氏名) == 0) {
            並び順１ = 並び順１項１;
            並び順２ = 並び順２項３;
        } else if (並び順種類.compareTo(NarabiJunType.委託先名称_調査員コード) == 0) {
            並び順１ = 並び順１項２;
            並び順２ = 並び順２項１;
        } else if (並び順種類.compareTo(NarabiJunType.委託先名称_調査員氏名) == 0) {
            並び順１ = 並び順１項２;
            並び順２ = 並び順２項２;
        } else if (並び順種類.compareTo(NarabiJunType.委託先コード_調査員カナ氏名) == 0) {
            並び順１ = 並び順１項２;
            並び順２ = 並び順２項３;
        }

        source.sort1 = 並び順１;
        source.sort2 = 並び順２;
        source.sort3 = RString.EMPTY;
        source.sort4 = RString.EMPTY;
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
        source.listIchiranhyoUpper_1 = item.getShujiiIryokikanCode();
        source.listIchiranhyoUpper_2 = item.getIryoKikanMeishoKana();
        source.listIchiranhyoUpper_3 = item.getDaihyoshaNameKana();
        RString 郵便番号 = item.getYubinNo();
        source.listIchiranhyoUpper_4 = RString.EMPTY;
        if (!RString.isNullOrEmpty(郵便番号)) {
            source.listIchiranhyoUpper_4 = 郵便番号.substring(0, 3).concat("-").concat(郵便番号.substring(3, 7));
        }
        source.listIchiranhyoUpper_5 = item.getTelNo();
        if (item.isJokyoFlag()) {
            source.listIchiranhyoUpper_6 = 有効_VALUE;
        } else if (!item.isJokyoFlag()) {
            source.listIchiranhyoUpper_6 = 無効_VALUE;
        }
        source.listIchiranhyoUpper_7 = item.getShujiiCode();
        source.listIchiranhyoUpper_8 = item.getShujiiKana();
        RString chosainShikaku = item.getChosainShikaku();
        if (chosainShikaku != null) {
            chosainShikaku = chosainShikaku.replace(" ", "").trim();
        }
        source.listIchiranhyoUpper_9 = chosainShikaku;
        if (chosainShikaku != null && !chosainShikaku.isNullOrEmpty()) {
            source.listIchiranhyoUpper_10 = Sikaku.toValue(chosainShikaku).get名称();
        }
        if (item.isShujiiJokyoFlag()) {
            source.listIchiranhyoUpper_11 = 有効_VALUE;
        } else if (!item.isShujiiJokyoFlag()) {
            source.listIchiranhyoUpper_11 = 無効_VALUE;
        }
        source.listIchiranhyoLower1_1 = item.getIryoKikanMeisho();
        source.listIchiranhyoLower1_2 = item.getDaihyoshaName();
        source.listIchiranhyoLower1_3 = item.getJusho();
        source.listIchiranhyoLower2_1 = item.getShujiiName();
        if (!item.getSeibetsu().trim().isEmpty()) {
            source.listIchiranhyoLower2_2 = Seibetsu.toValue(item.getSeibetsu()).get名称();
        }
        source.listIchiranhyoLower2_3 = item.getShinryokaName();
        return source;
    }

}
