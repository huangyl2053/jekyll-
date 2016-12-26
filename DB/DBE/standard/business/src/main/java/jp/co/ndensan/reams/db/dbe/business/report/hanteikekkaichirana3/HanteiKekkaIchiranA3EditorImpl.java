/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkaichirana3;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hanteikekkaichirana3.HanteiKekkaIchiranA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.hanteikekkaichirana3.HanteiKekkaIchiranA3ReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 要介護認定判定結果一覧表Ａ３版のEditorです。
 *
 * @reamsid_L DBE-0180-050 xuyannan
 */
public class HanteiKekkaIchiranA3EditorImpl implements IHanteiKekkaIchiranA3Editor {

    private static final RString 単位 = new RString("月");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString 記号 = new RString("／");
    private final HanteiKekkaIchiranA3Entity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link HanteiKekkaIchiranA3Entity}
     */
    protected HanteiKekkaIchiranA3EditorImpl(HanteiKekkaIchiranA3Entity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定判定結果一覧表Ａ３版を編集します。
     *
     * @param source 帳票ソース
     * @return 帳票ソース
     */
    @Override
    public HanteiKekkaIchiranA3ReportSource edit(HanteiKekkaIchiranA3ReportSource source) {
        return editSource(source);
    }

    private HanteiKekkaIchiranA3ReportSource editSource(HanteiKekkaIchiranA3ReportSource source) {
        source.title = entity.getTitle();
        source.gogitaiNo = new RString(String.valueOf(entity.get合議体番号()));
        source.taishoHokenshaName = entity.get市町村名称();
        RStringBuilder printTimeStamp = new RStringBuilder();
        printTimeStamp.append(entity.getPrintTimeStamp().getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        printTimeStamp.append(RString.HALF_SPACE);
        printTimeStamp.append(String.format("%02d", entity.getPrintTimeStamp().getHour()));
        printTimeStamp.append(DATE_時);
        printTimeStamp.append(String.format("%02d", entity.getPrintTimeStamp().getMinute()));
        printTimeStamp.append(DATE_分);
        printTimeStamp.append(String.format("%02d", entity.getPrintTimeStamp().getSecond()));
        printTimeStamp.append(DATE_秒);
        source.hakkoYMD = printTimeStamp.toRString();
        RStringBuilder 頁数 = new RStringBuilder();
        頁数.append(entity.get当前頁());
        頁数.append(記号);
        頁数.append(entity.get総頁());
        source.pageCount1 = 頁数.toRString();
        source.listHanteikekka_1 = new RString(String.valueOf(entity.get項番()));
        source.listHanteikekka_2 = entity.get市町村名称();
        source.listHanteikekka_3 = entity.get証記載保険者番号();
        source.listHanteikekka_4 = entity.get被保険者氏名();
        source.listHanteikekka_5 = entity.get被保険者番号();
        source.listHanteikekka_6 = entity.get生年月日() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.get生年月日()));
        source.listHanteikekka_7 = Seibetsu.toValue(entity.get性別()).get名称();
        source.listHanteikekka_8 = entity.get認定申請日() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.get認定申請日()));
        source.listHanteikekka_9 = entity.get二次判定年月日() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.get二次判定年月日()));
        source.listHanteikekka_10 = entity.get被保険者区分();
        source.listHanteikekka_11 = entity.get認定申請区分_申請時();
        source.listHanteikekka_12 = entity.get認定申請区分_法令();
        source.listHanteikekka_13 = entity.getTb_一次判定結果();
        source.listHanteikekka_14 = entity.getTb_二次判定要介護状態区分();
        source.listHanteikekka_15 = entity.get一次判定結果();
        source.listHanteikekka_16 = entity.get二次判定要介護状態区分();
        source.listHanteikekka_17 = entity.get要介護状態像例コード();
        source.listHanteikekka_18 = entity.get状態像内容();
        source.listHanteikekka_19 = entity.getTb_二次判定認定有効開始日() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.getTb_二次判定認定有効開始日()));
        source.listHanteikekka_20 = entity.getTb_二次判定認定有効終了日() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.getTb_二次判定認定有効終了日()));
        source.listHanteikekka_21 = 月数(entity.getTb_二次判定認定有効期間());
        source.listHanteikekka_22 = entity.get二次判定認定有効開始年月日() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.get二次判定認定有効開始年月日()));
        source.listHanteikekka_23 = entity.get二次判定認定有効終了年月日() == null
                ? RString.EMPTY : 和暦年月日Fomart(new FlexibleDate(entity.get二次判定認定有効終了年月日()));
        source.listHanteikekka_24 = 月数(entity.get二次判定認定有効期間());
        source.listHanteikekka_25 = entity.get二号特定疾病コード();
        source.listHanteikekka_26 = entity.get二号特定疾病内容();
        source.listHanteikekka_27 = entity.get介護認定審査会意見();
        return source;
    }

    private RString 和暦年月日Fomart(FlexibleDate date) {
        return (date.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD)
                .fillType(FillType.ZERO).toDateString());
    }

    private RString 月数(int 有効期間) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(有効期間);
        builder.append(単位);
        return builder.toRString();
    }
}
