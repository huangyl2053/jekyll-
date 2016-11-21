/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.NushiJuminJohoResult;
import jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho.SetaiInn;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo.ShotokuShokaihyoTateReport;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyo.ShotokuShokaihyoYokoReport;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.SaiHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoTateSource;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyo.ShotokuShokaihyoYokoSource;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoDataHenshu;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.KaigoToiawasesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.KaigoToiawasesakiManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.chihokokyodantai.ShichosonAtesaki;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.core.tashichosonsofusakimaintenance.SofusakiGroup;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.CityAtesakiService;
import jp.co.ndensan.reams.ur.urz.service.core.chihokokyodantai.ICityAtesakiFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 所得照会票の出力のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class PrtShotokushokaihyoProcess extends BatchProcessBase<ShotokuShoukaiDataTempEntity> {

    /**
     * PARAMETER_OUT_OUTPUTCOUNT
     */
    public static final RString PARAMETER_OUT_OUTPUTCOUNT;

    private static final RString INDEX_0 = new RString("0");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final int INT_6 = 6;
    private static final int INT_9 = 9;
    private static final int INT_10 = 10;
    private static final int INT_15 = 15;
    private static final RString 役所 = new RString("役所");
    private static final RString 役場 = new RString("役場");
    private static final RString 区 = new RString("区");
    private static final RString 市 = new RString("市");
    private static final RString 町 = new RString("町");
    private static final RString 村 = new RString("村");
    private static final RString カンマ = new RString(",");
    private static final RString 転出者 = new RString("3");
    private static final RString 文字列_001 = new RString("001");
    private static final RString 定数_処理年度 = new RString("処理年度");
    private static final RString 定数_照会年月日 = new RString("照会年月日");
    private static final RString 定数_出力対象 = new RString("出力対象");
    private static final RString 定数_テストプリント = new RString("テストプリント");
    private static final RString 定数_有り = new RString("有り");
    private static final RString 定数_無し = new RString("無し");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定数_再発行対象リスト = new RString("再発行対象リスト");
    private static final RString CSV出力有無_有り = new RString("あり");
    private static final RString CSVファイル名_一覧表 = new RString("所得照会票");
    private static final RString 所得照会票_EUCファイル名 = new RString("ShotokushokaihyoHakkoIchiran.csv");
    private static final ReportId 帳票分類ID = new ReportId("DBB100001_ShotokuShokaihyoDaihyo");
    private static final FlexibleYear 管理年度 = new FlexibleYear("0000");
    private static final RString 項目名 = new RString("通知書タイプ");
    private static final RString 項目名_文書タイトル = new RString("文書タイトル");
    private static final RString 項目名_送付先担当課名称 = new RString("送付先担当課名称");
    private static final ReportId 帳票ID = new ReportId("DBB100001_ShotokuShokaihyoDaihyo");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.selectAll所得照会票1");

    private BatchReportWriter<ShotokuShokaihyoTateSource> tateReportWriter;
    private BatchReportWriter<ShotokuShokaihyoYokoSource> yokoReportWriter;
    private ReportSourceWriter<ShotokuShokaihyoTateSource> tateSourceWriter;
    private ReportSourceWriter<ShotokuShokaihyoYokoSource> yokoSourceWriter;

    static {
        PARAMETER_OUT_OUTPUTCOUNT = new RString("outputCount");
    }

    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private ShotokuShoukaiDataTempEntity 所得照会票データ;
    private ShotokuShoukaiDataTempEntity 所得照会票データbefore;
    private OutputParameter<RString> outputCount;
    private NinshoshaSource sourceBuilder;
    private Association association;
    private KaigoToiawasesaki 差出人情報;
    private RString 通知書タイプ;
    private RString 送付先担当課名称;
    private RString 文書タイトル;
    private RString 種別コード;
    private RString 送付先住所コード = RString.EMPTY;
    private SetaiCode 世帯コード = SetaiCode.EMPTY;
    private RString 候補者区分 = RString.EMPTY;
    private RString 現住所コード = RString.EMPTY;
    private List<SetaiInn> 世帯員リスト;

    @Override
    public void initialize() {
        世帯員リスト = new ArrayList<>();
        outputCount = new OutputParameter<>();
        KaigoToiawasesakiManager manager = new KaigoToiawasesakiManager();
        差出人情報 = manager.get介護問合せ先(SubGyomuCode.DBB介護賦課, 帳票ID);
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        association = finder.getAssociation();
        種別コード = NinshoshaDenshikoinshubetsuCode.保険者印.getコード();
        ChohyoSeigyoHanyo 帳票制御汎用Entity = TokuchoKaishiTsuchishoDataHenshu.createInstance()
                .load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名);
        通知書タイプ = 帳票制御汎用Entity.get設定値();
        文書タイトル = TokuchoKaishiTsuchishoDataHenshu.createInstance()
                .load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名_文書タイトル).get設定値();
        送付先担当課名称 = TokuchoKaishiTsuchishoDataHenshu.createInstance()
                .load帳票制御汎用ByKey(帳票分類ID, 管理年度, 項目名_送付先担当課名称).get設定値();
        outputCount.setValue(INDEX_0);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECTPATH);
    }

    @Override
    protected void createWriter() {
        if (文字列_001.equals(通知書タイプ)) {
            yokoReportWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdDBB.DBB100001.getReportId().value(), SubGyomuCode.DBB介護賦課).create();
            yokoSourceWriter = new ReportSourceWriter<>(yokoReportWriter);

            sourceBuilder = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100001.getReportId(),
                    processParameter.get照会年月日(), 種別コード, KenmeiFuyoKubunType.県と郡, yokoSourceWriter);
        } else {
            tateReportWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdDBB.DBB100002.getReportId().value(), SubGyomuCode.DBB介護賦課).create();
            tateSourceWriter = new ReportSourceWriter<>(tateReportWriter);

            sourceBuilder = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB100002.getReportId(),
                    processParameter.get照会年月日(), 種別コード, KenmeiFuyoKubunType.県と郡, tateSourceWriter);
        }
    }

    @Override
    protected void process(ShotokuShoukaiDataTempEntity t) {
        所得照会票データ = t;
        if (送付先住所コード.equals(所得照会票データ.getSoufusenzenkokuJushoCode() == null ? RString.EMPTY : 所得照会票データ.getSoufusenzenkokuJushoCode())
                && 世帯コード.equals(所得照会票データ.getSetaiCode())
                && 候補者区分.equals(所得照会票データ.getKouhoshakubun() == null ? RString.EMPTY : 所得照会票データ.getKouhoshakubun())
                && 現住所コード.equals(所得照会票データ.getZenkokuJushoCode() == null ? RString.EMPTY : 所得照会票データ.getZenkokuJushoCode())) {
            set世帯員();
        } else if (世帯員リスト.isEmpty()) {
            所得照会票データbefore = t;
            set世帯員();
            setKey();
        } else {
            所得照会票Report();
            世帯員リスト.clear();
            set世帯員();
            setKey();
            所得照会票データbefore = t;
        }

    }

    @Override
    protected void afterExecute() {
        int 出力ページ数 = 0;
        出力ページ数 = 所得照会票Report();
        if (文字列_001.equals(通知書タイプ)) {
            yokoReportWriter.close();
        } else {
            tateReportWriter.close();
        }
        loadバッチ出力条件リスト(出力ページ数, CSV出力有無_有り, CSVファイル名_一覧表);
    }

    private int 所得照会票Report() {
        NushiJuminJohoResult result = creat所得照会票データ();
        if (文字列_001.equals(通知書タイプ)) {
            new ShotokuShokaihyoYokoReport(result, sourceBuilder, 文書タイトル, 送付先担当課名称).writeBy(yokoSourceWriter);
            return yokoSourceWriter.pageCount().value();
        } else {
            new ShotokuShokaihyoTateReport(result, sourceBuilder, 文書タイトル, 送付先担当課名称).writeBy(tateSourceWriter);
            return tateSourceWriter.pageCount().value();
        }
    }

    private void setKey() {
        送付先住所コード = 所得照会票データ.getSoufusenzenkokuJushoCode() == null ? RString.EMPTY : 所得照会票データ.getSoufusenzenkokuJushoCode();
        世帯コード = 所得照会票データ.getSetaiCode();
        候補者区分 = 所得照会票データ.getKouhoshakubun() == null ? RString.EMPTY : 所得照会票データ.getKouhoshakubun();
        現住所コード = 所得照会票データ.getZenkokuJushoCode() == null ? RString.EMPTY : 所得照会票データ.getZenkokuJushoCode();
    }

    private void set世帯員() {
        SetaiInn setaiInn = new SetaiInn();
        setaiInn.set住民状態コード(所得照会票データ.getJuminJotaiCode());
        FlexibleDate 転入届出日 = 所得照会票データ.getTorokuTodokedeYMD() == null ? FlexibleDate.EMPTY
                : new FlexibleDate(所得照会票データ.getTorokuTodokedeYMD());
        setaiInn.set転出日(転入届出日);
        setaiInn.set転入異動日(所得照会票データ.getIdoYMD());
        setaiInn.set識別コード(所得照会票データ.getShikibetsuCode());
        setaiInn.setカナ氏名(所得照会票データ.getKanaMeisho().getColumnValue());
        setaiInn.set氏名(所得照会票データ.getMeisho().getColumnValue());
        setaiInn.set生年月日(所得照会票データ.getSeinengappiYMD());
        世帯員リスト.add(setaiInn);
    }

    private void loadバッチ出力条件リスト(int 出力ページ数,
            RString csv出力有無, RString 帳票名) {

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_処理年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get処理年度().wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_照会年月日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get照会年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_出力対象).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get出力対象()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        RString 有無し;
        if (processParameter.isテストプリント()) {
            有無し = 定数_有り;
        } else {
            有無し = 定数_無し;
        }
        builder.append((FORMAT_LEFT).concat(定数_テストプリント).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(有無し));
        出力条件リスト.add(builder.toRString());
        List<SaiHakkoParameter> 再発行対象リスト = processParameter.get再発行対象リスト();
        if (再発行対象リスト != null) {
            for (SaiHakkoParameter param : 再発行対象リスト) {
                builder = new RStringBuilder();
                RString 発行件数 = new RString(String.valueOf(param.get発行件数()));
                RString 処理年度 = new RString(param.get処理年度().toString());
                RString ユーザ = param.getユーザ();
                RString 処理日時 = new RString(param.get処理日時().toString());
                builder.append((FORMAT_LEFT).concat(定数_再発行対象リスト).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                        .concat(発行件数).concat(カンマ).concat(RString.FULL_SPACE)
                        .concat(処理年度).concat(カンマ).concat(RString.FULL_SPACE)
                        .concat(ユーザ).concat(カンマ).concat(RString.FULL_SPACE).concat(処理日時));
                出力条件リスト.add(builder.toRString());
            }
        } else {
            builder = new RStringBuilder();
            builder.append((FORMAT_LEFT).concat(定数_再発行対象リスト).concat(FORMAT_RIGHT));
            出力条件リスト.add(builder.toRString());
        }

        RString reportId;
        if (文字列_001.equals(通知書タイプ)) {
            reportId = ReportIdDBB.DBB100001.getReportId().getColumnValue();
        } else {
            reportId = ReportIdDBB.DBB100002.getReportId().getColumnValue();
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                reportId,
                association.getLasdecCode_().value(),
                association.get市町村名(),
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                new RString(String.valueOf(出力ページ数)),
                csv出力有無,
                所得照会票_EUCファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();

    }

    private NushiJuminJohoResult creat所得照会票データ() {
        NushiJuminJohoResult result = new NushiJuminJohoResult();
        result.set住民税課税年度(processParameter.get処理年度());
        result.set発行日(new RDate(processParameter.get照会年月日().toString()));
        result.set市町村名(association.get市町村名());
        set所得照会先(result);
        result.set生年月日(所得照会票データbefore.getSeinengappiYMD());
        if (!転出者.equals(所得照会票データbefore.getJuminJotaiCode())) {
            result.set転入前住所(所得照会票データbefore.getZenjusho());
        } else {
            result.set転出先住所(所得照会票データbefore.getGenjusho());
        }
        result.set氏名(所得照会票データbefore.getHihokenshaName());
        result.set世帯コード(所得照会票データbefore.getSetaiCode());
        result.set前住所(所得照会票データbefore.getZenjusho());
        result.set現住所(所得照会票データbefore.getGenjusho());
        result.set住民状態コード(所得照会票データbefore.getJuminJotaiCode());
        result.set世帯員リスト(世帯員リスト);
        result.set担当部署名(差出人情報.get部署名());
        result.set担当者名(差出人情報.get担当者名());
        result.set庁舎名(差出人情報.get庁舎名());
        result.set所在地(差出人情報.get所在地());
        result.set内線番号(差出人情報.get内線番号());
        result.set差出人_郵便番号(差出人情報.get郵便番号());
        result.set電話番号(差出人情報.get電話番号());
        result.set住民種別コード(所得照会票データbefore.getJuminShubetsuCode());
        return result;
    }

    private void set所得照会先(NushiJuminJohoResult result) {
        ICityAtesakiFinder atesakiFinder = CityAtesakiService.createCityAtesakiFinder();
        LasdecCode 全国住所コード = LasdecCode.EMPTY;
        if (所得照会票データbefore.getZenkokuJushoCode() != null) {
            RString ZenkokuJushoCode = 所得照会票データbefore.getZenkokuJushoCode().trim();
            if (ZenkokuJushoCode.length() >= INT_6) {
                全国住所コード = new LasdecCode(所得照会票データbefore.getZenkokuJushoCode().substring(INT_0, INT_6));
            }
        }
        ShichosonAtesaki atesaki = atesakiFinder.get市町村宛先(全国住所コード, SofusakiGroup.所得照会関連.getCode());
        YubinNo 郵便番号 = YubinNo.EMPTY;
        RString 住所 = RString.EMPTY;
        AtenaBanchi 番地 = AtenaBanchi.EMPTY;
        RString 役所_役場名 = RString.EMPTY;
        RString 役所_役場名の上段 = RString.EMPTY;
        RString 役所_役場名の下段 = RString.EMPTY;
        RString 住所の上段 = RString.EMPTY;
        RString 住所の下段 = RString.EMPTY;
        if (atesaki != null) {
            郵便番号 = atesaki.get郵便番号();
            番地 = atesaki.get番地();
            住所 = atesaki.get住所();
            RString 名称 = atesaki.get名称();
            if (名称 != null && !名称.isEmpty()) {
                役所_役場名 = editor役所_役場名(名称, 役所_役場名, atesaki);
            }
            if (役所_役場名.length() >= INT_10) {
                役所_役場名の上段 = 役所_役場名.substring(INT_0, INT_9);
                役所_役場名の下段 = 役所_役場名.substring(INT_9, 役所_役場名.length());
            }
            if (役所_役場名.length() <= INT_9) {
                役所_役場名の下段 = 役所_役場名;
            }
        }
        住所 = 住所.concat(RString.FULL_SPACE).concat(番地.value());
        if (住所.length() >= INT_15) {
            住所の上段 = 住所.substring(INT_0, INT_15);
            住所の下段 = 住所.substring(INT_15, 住所.length());
        }
        if (住所.length() <= INT_15) {
            住所の下段 = 住所;
        }
        result.set郵便番号(郵便番号);
        result.set役所_役場名_上段(役所_役場名の上段);
        result.set役所_役場名_下段(役所_役場名の下段);
        result.set住所_上段(住所の上段);
        result.set住所_下段(住所の下段);
    }

    private RString editor役所_役場名(RString 名称, RString 役所_役場名, ShichosonAtesaki atesaki) {
        if (区.equals(名称.substring(名称.length() - INT_1, 名称.length()))
                || 市.equals(名称.substring(名称.length() - INT_1, 名称.length()))) {
            役所_役場名 = atesaki.get方書().value().concat(役所);
        }
        if (町.equals(名称.substring(名称.length() - INT_1, 名称.length()))
                || 村.equals(名称.substring(名称.length() - INT_1, 名称.length()))) {
            役所_役場名 = atesaki.get方書().value().concat(役場);
        }
        return 役所_役場名;
    }

}
