/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shujiiikenshoteishutsuiraishohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshosakusei.ShujiiIkenshoSakuseiRyoSeikyushoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshosakuseiryo.IkenshoSakuseiRyo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 帳票「主治医意見書作成料請求書」の出力バッチフ処理クラスです
 */
public class ShujiiIkenshoSakuseiRyoSeikyushoProcess extends BatchProcessBase<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper."
            + "get主治医意見書提出依頼書発行");
    private static final ReportId 帳票ID = ReportIdDBE.DBE234001.getReportId();
    private static final RString 記号 = new RString("✔");
    private static final RString 文字列1 = new RString("1");
    private static final RString IKENSHOSAKUSEIRYO_11 = new RString("11");
    private static final RString IKENSHOSAKUSEIRYO_12 = new RString("12");
    private static final RString IKENSHOSAKUSEIRYO_21 = new RString("21");
    private static final RString IKENSHOSAKUSEIRYO_22 = new RString("22");
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT8 = 8;
    private static final int INT9 = 9;
    private static final int INT10 = 10;
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
    private static final RString IKENSHOSAKUSEISEIKYUUSHO = new RString("【主治医意見書作成料請求書出力区分】");
    private static final RString IKENSHOTEISHUTU = new RString("【介護保険指定医依頼兼主治医意見書提出意見依頼書出力区分】");
    private IShujiiIkenshoTeishutsuIraishoHakkoMapper mapper;
    private List<ShujiiIkenshoSakuseiRyoSeikyushoItem> itemList;
    private ShujiiIkenshoTeishutsuIraishoHakkoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> batchWriter;
    private ReportSourceWriter<ShujiiIkenshoSakuseiRyoSeikyushoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IShujiiIkenshoTeishutsuIraishoHakkoMapper.class);
        itemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShujiiIkenshoTeishutsuIraishoHakkoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        update認定調査依頼情報(entity);
        itemList.add(setItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (itemList != null && !itemList.isEmpty()) {
            ShujiiIkenshoSakuseiRyoSeikyushoReport report = ShujiiIkenshoSakuseiRyoSeikyushoReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private ShujiiIkenshoSakuseiRyoSeikyushoItem setItem(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        ShujiiIkenshoSakuseiRyoSeikyushoItem item = new ShujiiIkenshoSakuseiRyoSeikyushoItem();
        item.setGengo(RDate.getNowDate().toDateString());
        item.setAtesakiHokenshaName(entity.get保険者名());
        // TODO 内部QA894　Redmine#79148　意見書作成料の表示名がない
        item.setShinkiZaitakuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_11).get名称());
        item.setShinkiShisetsuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_12).get名称());
        item.setKeizokuZaitakuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_21).get名称());
        item.setKeizokuShisetsuKingaku(IkenshoSakuseiRyo.toValue(IKENSHOSAKUSEIRYO_22).get名称());
        RString hihokenshaNo = entity.get被保険者番号();
        if (!RString.isNullOrEmpty(hihokenshaNo) && INT10 <= hihokenshaNo.length()) {
            item.setHihokenshaNo1(entity.get被保険者番号().substring(0, 1));
            item.setHihokenshaNo2(entity.get被保険者番号().substring(1, 2));
            item.setHihokenshaNo3(entity.get被保険者番号().substring(2, INT3));
            item.setHihokenshaNo4(entity.get被保険者番号().substring(INT3, INT4));
            item.setHihokenshaNo5(entity.get被保険者番号().substring(INT4, INT5));
            item.setHihokenshaNo6(entity.get被保険者番号().substring(INT5, INT6));
            item.setHihokenshaNo7(entity.get被保険者番号().substring(INT6, INT7));
            item.setHihokenshaNo8(entity.get被保険者番号().substring(INT7, INT8));
            item.setHihokenshaNo9(entity.get被保険者番号().substring(INT8, INT9));
            item.setHihokenshaNo10(entity.get被保険者番号().substring(INT9, INT10));
        }
        item.setHihokenshaNameKana(entity.get被保険者氏名カナ());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setBirthYMD(entity.get生年月日());
        item.setSeibetsu(Seibetsu.toValue(entity.get性別()).get名称());
        if (ZaitakuShisetsuKubun.在宅.getコード().equals(entity.get在宅施設区分())) {
            item.setIkenshosyubetu1(記号);
        } else {
            item.setIkenshosyubetu1(RString.EMPTY);
        }
        // TODO 内部QA913　設定項目は帳票Itemと違う
        if (ZaitakuShisetsuKubun.施設.getコード().equals(entity.get在宅施設区分())) {
            item.setIkenshosyubetu1(記号);
        } else {
            item.setIkenshosyubetu1(RString.EMPTY);
        }
        if (IkenshoSakuseiKaisuKubun.初回.getコード().equals(entity.get意見書作成回数区分())) {
            item.setIkenshosyubetu2(記号);
        } else {
            item.setIkenshosyubetu2(RString.EMPTY);
        }
        // TODO 内部QA913　設定項目は帳票Itemと違う
        if (IkenshoSakuseiKaisuKubun._2回目以降.getコード().equals(entity.get意見書作成回数区分())) {
            item.setIkenshosyubetu2(記号);
        } else {
            item.setIkenshosyubetu2(RString.EMPTY);
        }
        item.setSeikyuIryokikanName(entity.get医療機関名称());
        item.setSeikyuIryokikanDaihyoName(entity.get代表者名());
        item.setSeikyuIryokikanYubinNo(entity.get医療機関郵便番号());
        item.setSeikyuIryokikanJusho(entity.get医療機関住所());
        item.setSeikyuIryokikanTel(entity.get医療機関電話番号());
        set意見書作成料(entity, item);
        return item;
    }

    private void set意見書作成料(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity, ShujiiIkenshoSakuseiRyoSeikyushoItem item) {
        if (IkenshoIraiKubun.初回依頼.getCode().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.get在宅施設区分())) {
            RString shinkiZaitakuKingaku = item.getShinkiZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiZaitakuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiZaitakuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiZaitakuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiZaitakuKingaku.substring(INT3, INT4));
        }
        if (IkenshoIraiKubun.初回依頼.getCode().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(entity.get在宅施設区分())) {
            RString shinkiShisetsuKingaku = item.getShinkiShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(shinkiShisetsuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(shinkiShisetsuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(shinkiShisetsuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(shinkiShisetsuKingaku.substring(INT3, INT4));

        }
        if (IkenshoIraiKubun.再依頼.getCode().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.在宅.getコード().equals(entity.get在宅施設区分())) {
            RString keizokuZaitakuKingaku = item.getKeizokuZaitakuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuZaitakuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuZaitakuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuZaitakuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuZaitakuKingaku.substring(INT3, INT4));

        }
        if (IkenshoIraiKubun.再依頼.getCode().equals(entity.get主治医意見書依頼区分())
                && ZaitakuShisetsuKubun.施設.getコード().equals(entity.get在宅施設区分())) {
            RString keizokuShisetsuKingaku = item.getKeizokuShisetsuKingaku();
            item.setIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(0, 1));
            item.setIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(1, 2));
            item.setIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(2, INT3));
            item.setIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(INT3, INT4));
            item.setSeikyugakuIkenshoSakuseiRyo1(keizokuShisetsuKingaku.substring(0, 1));
            item.setSeikyugakuIkenshoSakuseiRyo2(keizokuShisetsuKingaku.substring(1, 2));
            item.setSeikyugakuIkenshoSakuseiRyo3(keizokuShisetsuKingaku.substring(2, INT3));
            item.setSeikyugakuIkenshoSakuseiRyo4(keizokuShisetsuKingaku.substring(INT3, INT4));
        }

    }

    private void update認定調査依頼情報(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        DbT5301ShujiiIkenshoIraiJohoEntity dbT5301Entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        dbT5301Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbT5301Entity.setIkenshoIraiRirekiNo(entity.get最大依頼履歴番号());
        dbT5301Entity.setLogicalDeletedFlag(false);
        RString iraiToYMD = processParamter.getIraiToYMD();
        if (!RString.isNullOrEmpty(iraiToYMD)) {
            dbT5301Entity.setIraishoShutsuryokuYMD(new FlexibleDate(iraiToYMD));
            dbT5301Entity.setIkenshoShutsuryokuYMD(new FlexibleDate(iraiToYMD));
        }
        RString 主治医意見書作成期限設定方法 = BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限設定方法, SubGyomuCode.DBE認定支援);
        if (文字列1.equals(主治医意見書作成期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.主治医意見書作成期限日数,
                            SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 作成依頼日 = entity.get主治医意見書作成依頼年月日();
                    dbT5301Entity.setIkenshoSakuseiKigenYMD(作成依頼日.plusDay(期限日数));
                    break;
                case "1":
                    dbT5301Entity.setIkenshoSakuseiKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5301Entity.setIkenshoSakuseiKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        mapper.update主治医意見書作成依頼情報(dbT5301Entity);
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("－");
        RString ジョブ番号 = new RString("56");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(processParamter.getIraiFromYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(processParamter.getIraiToYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAI);
        builder.append(processParamter.getShujiiikenshoSakuseiIrai());
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
        builder = new RStringBuilder();
        builder.append(HAKKOBI);
        builder.append(processParamter.getHakkobi());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TEISHUTSUKIGEN);
        builder.append(processParamter.getTeishutsuKigen());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(KYOTSUHIZUKE);
        builder.append(processParamter.getKyotsuHizuke());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEIIRAI);
        builder.append(processParamter.isIkenshoSakuseiirai());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEISEIKYUU);
        builder.append(processParamter.isIkenshoSakuseiSeikyuu());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(SHUJIIIKENSHOSAKUSEIIRAISHO);
        builder.append(processParamter.isShujiiIkenshoSakuseiIraisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOKINYUU);
        builder.append(processParamter.isIkenshoKinyuu());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOKINYUUOCR);
        builder.append(processParamter.isIkenshoKinyuuOCR());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOSAKUSEISEIKYUUSHO);
        builder.append(processParamter.isIkenshoSakuseiSeikyuusho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IKENSHOTEISHUTU);
        builder.append(processParamter.isIkenshoTeishutu());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                ReportIdDBE.DBE230001.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
