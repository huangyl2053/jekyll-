/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.tokkitexta4.TokkiText1A4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tokkitexta4.TokkiText1A4Entity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.tokkitexta4.TokkiText1A4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku02A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku06A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09A;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku09B;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyokomoku.NinteichosaKomoku99A;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 委員用特記事項の取得バッチクラスです。
 *
 * @reamsid_L DBE-0150-200 linghuhang
 */
public class IinTokkiJikouDataSakuseiA4Process extends BatchKeyBreakBase<ShinsakaiSiryoKyotsuEntity> {

    private static final RString SELECT_SHINSAKAISIRYOKYOTSU = new RString("jp.co.ndensan.reams.db.dbe.persistence.db"
            + ".mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper.getShinsakaiSiryoKyotsu");
    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(TokkiText1A4ReportSource.ReportSourceFields.hokenshaNo.name())));
    private static final RString ファイルID_C0007 = new RString("C0007.png");
    private static final RString ファイルID_C4101 = new RString("C4101.png");
    private static final RString ファイルID_C4101_BAK = new RString("C4101_BAK.png");
    private static final RString ファイルID_C3001 = new RString("C3001-00.png");
    private static final RString テキスト全面イメージ = new RString("1");
    private static final RString テキスト = new RString("1");
    private static final RString イメージ = new RString("2");
    private static final RString ハイフン = new RString("-");
    private static final int 最大表示行数 = 15;
    private IinTokkiJikouItiziHanteiProcessParameter paramter;
    private IinTokkiJikouItiziHanteiMyBatisParameter myBatisParameter;
    private IShiryoShinsakaiIinMapper mapper;
    private TokkiText1A4Entity 特記事項;
    private RString 特記パターン;
    private int ページ表示行数;
    private int 最大文字数;

    @BatchWriter
    private BatchReportWriter<TokkiText1A4ReportSource> batchWriteA4;
    private ReportSourceWriter<TokkiText1A4ReportSource> reportSourceWriterA4;

    @Override
    protected void initialize() {
        ページ表示行数 = 0;
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        特記パターン = DbBusinessConfig.get(ConfigNameDBE.審査会資料調査特記パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        特記事項 = new TokkiText1A4Entity();
        特記事項.set委員用(true);
        特記事項.set保険者番号(RString.EMPTY);
        特記事項.set被保険者番号(RString.EMPTY);
        特記事項.set名前(RString.EMPTY);
//        RString 文字サイズ = DbBusinessConfig.get(ConfigNameDBE.特記事項文字サイズ, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        最大文字数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.特記事項行最大文字数, RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
//        RString 最大表示行数 = DbBusinessConfig.get(ConfigNameDBE.特記事項最大表示行数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHINSAKAISIRYOKYOTSU, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        batchWriteA4 = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE517141.getReportId().value())
                .addBreak(new BreakerCatalog<TokkiText1A4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriterA4 = new ReportSourceWriter<>(batchWriteA4);
    }

    @Override
    protected void keyBreakProcess(ShinsakaiSiryoKyotsuEntity current) {
        if (hasBrek(getBefore(), current)) {
            TokkiText1A4Report report = new TokkiText1A4Report(特記事項);
            report.writeBy(reportSourceWriterA4);
            ページ表示行数 = 0;
            特記事項 = new TokkiText1A4Entity();
            特記事項.set委員用(true);
            特記事項.set保険者番号(RString.EMPTY);
            特記事項.set被保険者番号(RString.EMPTY);
            特記事項.set名前(RString.EMPTY);
        }
    }

    @Override
    protected void usualProcess(ShinsakaiSiryoKyotsuEntity kyotsuEntity) {
        特記事項.set介護認定審査会開催年月日(kyotsuEntity.getShinsakaiKaisaiYMD());
        特記事項.set認定申請年月日(kyotsuEntity.getNinteiShinseiYMD());
        特記事項.set認定調査実施年月日(kyotsuEntity.getNinteichosaJisshiYMD());
        特記事項.set概況特記テキスト_イメージ区分(kyotsuEntity.getGaikyoChosaTextImageKubun());
        特記事項.set特記パターン(特記パターン);
        if (テキスト.equals(kyotsuEntity.getGaikyoChosaTextImageKubun())) {
            特記事項.set概況調査の特記事項テキスト(kyotsuEntity.getTokki());
        } else if (イメージ.equals(kyotsuEntity.getGaikyoChosaTextImageKubun())) {
            特記事項.set概況調査の特記事項イメージ(getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C0007));
        }
        List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List = get特記情報(kyotsuEntity);
        if (テキスト全面イメージ.equals(特記パターン)) {
            set特記事項Byテキスト全面イメージ(kyotsuEntity, 特記情報List);
        } else {
            List<TokkiA4Entity> 短冊情報リスト = new ArrayList<>();
            for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
                TokkiA4Entity 短冊情報 = new TokkiA4Entity();
                短冊情報.set事項番号(entity.getNinteichosaTokkijikoNo());
                短冊情報.set項目名称(get項目名称(kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo()));
                if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                    短冊情報.set特記事項テキスト_イメージ(entity.getTokkiJiko());
                } else {
//                    TODO QA1472一時案です 2016/08/01 王暁冬
                    RString tokkiImg = getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C3001);
                    短冊情報.set特記事項テキスト_イメージ(tokkiImg);
                }
                短冊情報リスト.add(短冊情報);
            }
            特記事項.set短冊情報リスト(短冊情報リスト);
        }
        ページ表示行数 = ページ表示行数 + 1;
    }

    @Override
    protected void afterExecute() {
        TokkiText1A4Report report = new TokkiText1A4Report(特記事項);
        report.writeBy(reportSourceWriterA4);
        outputJokenhyoFactory();
    }

    private boolean hasBrek(ShinsakaiSiryoKyotsuEntity before, ShinsakaiSiryoKyotsuEntity current) {
        return !(before.getShinsakaiOrder() == current.getShinsakaiOrder()) || ページ表示行数 % 最大表示行数 == 0;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE517141.getReportId().value(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                new RString("概況調査の特記"),
                new RString(reportSourceWriterA4.pageCount().value()),
                RString.EMPTY,
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("合議体番号"), paramter.getGogitaiNo()));
        出力条件.add(条件(new RString("介護認定審査会開催予定年月日"), paramter.getShinsakaiKaisaiYoteiYMD().wareki().toDateString()));
        出力条件.add(条件(new RString("介護認定審査会開催番号"), paramter.getShinsakaiKaisaiNo()));
        return 出力条件;
    }

    private RString 条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(new RString("【"));
        条件.append(バッチパラメータ名);
        条件.append(new RString("】"));
        条件.append(値);
        return 条件.toRString();
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        myBatisParameter.setGenponMaskKubun(GenponMaskKubun.マスク.getコード());
        myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.getTokkiIranJoho(myBatisParameter);
    }

    private void set特記事項Byテキスト全面イメージ(ShinsakaiSiryoKyotsuEntity kyotsuEntity, List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List) {
        boolean isテキスト = false;
        RStringBuilder テキスト全面 = new RStringBuilder();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : 特記情報List) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                isテキスト = true;
                テキスト全面.append(get特記事項テキスト(
                        kyotsuEntity.getKoroshoIfShikibetsuCode(), entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban()));
                テキスト全面.append(entity.getTokkiJiko());
                if ((int) (テキスト全面.length() / 最大文字数) == 2) {
                    テキスト全面.insert(最大文字数 * 2, System.lineSeparator());
                }
                テキスト全面.insert(最大文字数, System.lineSeparator());
                テキスト全面.append(System.lineSeparator());
            }
        }
        if (isテキスト) {
            特記事項.setTokkiText(テキスト全面.toRString());
            特記事項.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.テキスト.getコード());
        } else {
            特記事項.set特記事項テキスト_イメージ区分(TokkijikoTextImageKubun.イメージ.getコード());
            RString tokkiImg = getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C4101);
            if (RString.isNullOrEmpty(tokkiImg)) {
                tokkiImg = getFilePath(kyotsuEntity.getImageSharedFileId(), ファイルID_C4101_BAK);
            }
            特記事項.setTokkiImg(tokkiImg);
        }
    }

    private RString getFilePath(RDateTime sharedFileId, RString filename) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(filename),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), filename);
    }

    private RString get特記事項テキスト(Code 厚労省IF識別コード, RString 調査特記事項番号, int 特記事項連番) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku99A 調査特記事項 = NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku02A 調査特記事項 = NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku06A 調査特記事項 = NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku09A 調査特記事項 = NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            RStringBuilder builder = new RStringBuilder();
            NinteichosaKomoku09B 調査特記事項 = NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号);
            builder.append(調査特記事項.get特記事項番号());
            builder.append(ハイフン);
            builder.append(特記事項連番);
            builder.append(RString.FULL_SPACE);
            builder.append(調査特記事項.get名称());
            return builder.append(RString.FULL_SPACE).toRString();
        }
        return RString.EMPTY;
    }

    private RString get項目名称(Code 厚労省IF識別コード, RString 調査特記事項番号) {
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku99A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku02A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku06A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku09A.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード.value())) {
            return NinteichosaKomoku09B.getAllBy調査特記事項番(調査特記事項番号).get名称();
        }
        return RString.EMPTY;
    }

}
