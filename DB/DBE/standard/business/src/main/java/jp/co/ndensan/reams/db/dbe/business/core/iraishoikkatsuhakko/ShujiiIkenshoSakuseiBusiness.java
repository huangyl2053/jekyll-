/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou.SyujiyikenshosakuseyiraihakouHeadItem;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE220010.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoSakuseiProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoSakuseiRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * バッチ設計_DBE230003_主治医意見書作成依頼発行一覧表のRelateBusinessクラスです。
 *
 * @reamsid_L DBE-0080-150 duanzhanli
 */
public class ShujiiIkenshoSakuseiBusiness {

    private int 宛名連番 = 1;
    private int 連番 = 1;
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAI = new RString("【主治医意見書作成依頼印刷区分】");
    private static final RString SHUJIIIKENSHO = new RString("【意見書印刷区分】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAILIST = new RString("【主治医意見書作成依頼リスト】");
    private static final RString SHUJIIIRYOKIKANCODE = new RString("　　【主治医医療機関コード】");
    private static final RString ISHINO = new RString("　　【主治医コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString IKENSHOSAKUSEIIRAI = new RString("【主治医意見書作成依頼一覧表出力区分】");
    private static final RString IKENSHOSAKUSEISEIKYUU = new RString("【主治医意見書作成料請求一覧表出力区分】");
    private static final RString SHUJIIIKENSHOSAKUSEIIRAISHO = new RString("【主治医意見書作成依頼書出力区分】");
    private static final RString IKENSHOKINYUU = new RString("【主治医意見書記入用紙出力区分】");
    private static final RString IKENSHOKINYUUOCR = new RString("【主治医意見書記入用紙OCR出力区分】");
    private static final RString IKENSHOKINYUUDESIGN = new RString("【主治医意見書記入用紙（デザイン用紙）出力区分】");
    private static final RString IKENSHOSAKUSEISEIKYUUSHO = new RString("【主治医意見書作成料請求書出力区分】");
    private static final RString IKENSHOTEISHUTU = new RString("【介護保険指定医依頼兼主治医意見書提出意見依頼書出力区分】");

    /**
     * 帳票「帳票設計_DBE230002_主治医意見書作成依頼一覧表」Headerデータを作成するメッソドです。
     *
     * @param processParamter processParamter
     * @return SyujiyikenshosakuseyiraihakouHeadItem
     */
    public SyujiyikenshosakuseyiraihakouHeadItem setHeaderItem(ShujiiIkenshoSakuseiProcessParamter processParamter) {
        return new SyujiyikenshosakuseyiraihakouHeadItem(processParamter.getIraiFromYMD(),
                processParamter.getIraiToYMD(),
                processParamter.getShujiiIkenshoSakuseiIraisho());
    }

    /**
     * 帳票「帳票設計_DBE230002_主治医意見書作成依頼一覧表」Bodyデータを作成するメッソドです。
     *
     * @param entity entity
     * @return SyujiyikenshosakuseyiraihakouBodyItem
     */
    public SyujiyikenshosakuseyiraihakouBodyItem setBodyItem(ShujiiIkenshoSakuseiRelateEntity entity) {
        return new SyujiyikenshosakuseyiraihakouBodyItem(entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get依頼日(),
                entity.get医療機関名称(),
                entity.get代表者名(),
                entity.get連絡先(),
                entity.get主治医名(),
                RString.EMPTY,
                RString.EMPTY,
                entity.get依頼書作成日(),
                entity.get依頼書提出期限(),
                entity.get市町村コード(),
                entity.get市町村名称(),
                entity.get証記載保険者番号());
    }

    /**
     * バッチ出力条件Itemの設定メッソドです。
     *
     * @param 市町村名 市町村名
     * @param 出力ページ数 出力ページ数
     * @param 導入団体コード 導入団体コード
     * @param reportID RString
     * @param reportName reportName
     * @param processParamter
     * @return ReportOutputJokenhyoItem
     */
    public ReportOutputJokenhyoItem バッチ出力条件リストの出力(RString 市町村名,
            RString 出力ページ数,
            RString 導入団体コード,
            RString reportID,
            RString reportName,
            ShujiiIkenshoSakuseiProcessParamter processParamter) {
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("－");
        RString ジョブ番号 = new RString(JobContextHolder.getJobId());
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(ConvertDate(processParamter.getIraiFromYMD()));
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(ConvertDate(processParamter.getIraiToYMD()));
        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(SHUJIIIKENSHOSAKUSEIIRAI);
//        builder.append(processParamter.getShujiiikenshoSakuseiIrai());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHO);
        builder.append(processParamter.getShujiiIkensho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAILIST);
        出力条件.add(builder.toRString());
        List<GridParameter> shujiiIkenshoSakuseiIraiList = processParamter.getShujiiIkenshoSakuseiIraiList();
        for (GridParameter gridParameter : shujiiIkenshoSakuseiIraiList) {
            builder = new RStringBuilder();
            builder.append(SHUJIIIRYOKIKANCODE);
            builder.append(gridParameter.getShujiiIryoKikanCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(ISHINO);
            builder.append(gridParameter.getIshiNo());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(SHOKISAIHOKENSHANO);
            builder.append(gridParameter.getShoKisaiHokenshaNo());
            出力条件.add(builder.toRString());
        }
//        builder = new RStringBuilder();
//        builder.append(HAKKOBI);
//        builder.append(ConvertDate(processParamter.getHakkobi()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(TEISHUTSUKIGEN);
//        builder.append(processParamter.getTeishutsuKigen());
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(KYOTSUHIZUKE);
//        builder.append(ConvertDate(processParamter.getKyotsuHizuke()));
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(IKENSHOSAKUSEIIRAI);
//        builder.append(processParamter.isIkenshoSakuseiirai());
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(IKENSHOSAKUSEISEIKYUU);
//        builder.append(processParamter.isIkenshoSakuseiSeikyuu());
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(SHUJIIIKENSHOSAKUSEIIRAISHO);
//        builder.append(processParamter.isShujiiIkenshoSakuseiIraisho());
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(IKENSHOKINYUU);
//        builder.append(processParamter.isIkenshoKinyuu());
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(IKENSHOKINYUUOCR);
//        builder.append(processParamter.isIkenshoKinyuuOCR());
//        builder = new RStringBuilder();
//        builder.append(IKENSHOKINYUUDESIGN);
//        builder.append(processParamter.isIkenshoKinyuuDesign());
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(IKENSHOSAKUSEISEIKYUUSHO);
//        builder.append(processParamter.isIkenshoSakuseiSeikyuusho());
//        出力条件.add(builder.toRString());
//        builder = new RStringBuilder();
//        builder.append(IKENSHOTEISHUTU);
//        builder.append(processParamter.isIkenshoTeishutu());
//        出力条件.add(builder.toRString());
        return new ReportOutputJokenhyoItem(
                reportID,
                導入団体コード,
                市町村名,
                ジョブ番号,
                reportName,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
    }

    private RString ConvertDate(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        if (!FlexibleDate.canConvert(date)) {
            return date;
        }
        return new FlexibleDate(date).wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.NONE).toDateString();
    }
}
