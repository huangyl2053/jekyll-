/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokujoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.DbeMapperInterfaces;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.NinteiChosaTokusokujoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001.NinteiChosaTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha._NinshoshaManager;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 要介護認定調査督促状の作成クラスです。
 */
public class NinteiChosaTokusokujoReportProcess extends BatchProcessBase<NinteiChosaTokusokujoRelateEntity> {

    /**
     * OutputParameter用キー outShinseishoKanriNoList
     */
    public static final RString OUT_SHINSEISHO_KANRINO_LIST;
    private NinteiChosaTokusokujoProcessParameter paramter;
    private static final ReportId REPORT_DBE223001 = new ReportId("DBE223001_NinteiChosaTokusokujo");
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter;

    private NinteiChosaTokusokujoBodyItem bodyItem;
    private final RString 汎用キー_文書番号 = new RString("文書番号");
    private final int パターン番号_1 = 1;

    private static final RString 星アイコン = new RString("＊");
    private static final RString 明 = new RString("明");
    private static final RString 大 = new RString("大");
    private static final RString 昭 = new RString("昭");
    private static final int 一桁 = 1;

    static {
        OUT_SHINSEISHO_KANRINO_LIST = new RString("outShinseishoKanriNoList");
    }
    private OutputParameter<List<RString>> outShinseishoKanriNoList;
    private List<RString> shinseishoKanriNoList;

    @Override
    protected void initialize() {
        shinseishoKanriNoList = new ArrayList<>();
        outShinseishoKanriNoList = new OutputParameter<>();
        super.initialize();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(DbeMapperInterfaces.要介護認定調査督促状データの抽出.getFullPath(), paramter.toNinteiChosaTokusokujoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBE223001.value(), SubGyomuCode.DBE認定支援).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(NinteiChosaTokusokujoRelateEntity entity) {
        shinseishoKanriNoList.add(entity.getTemp_申請書管理番号().getColumnValue());
        bodyItem = setBodyItem(entity);
    }

    @Override
    protected void afterProcess() {
        NinteiChosaTokusokujoReport report = NinteiChosaTokusokujoReport.createFrom(bodyItem);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        outShinseishoKanriNoList.setValue(shinseishoKanriNoList);
    }

    private NinteiChosaTokusokujoBodyItem setBodyItem(NinteiChosaTokusokujoRelateEntity entity) {

        IBunshoNoFinder bushoFineder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = bushoFineder.get文書番号管理(REPORT_DBE223001, paramter.getTemp_基準日());
        RString 文書番号 = RString.EMPTY;
        if (bushoNo != null) {
            文書番号 = get文書番号(bushoNo);
        }

        _NinshoshaManager ninshoshaManager = new _NinshoshaManager();
        Ninshosha ninshosha = ninshoshaManager.get帳票認証者(GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.認定用印.getコード(), paramter.getTemp_基準日());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        ChohyoSeigyoKyotsu chohyoSeigyoKyotsu = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBE認定支援, REPORT_DBE223001);
        boolean is公印に掛ける = false;
        boolean is公印を省略 = false;
        if (chohyoSeigyoKyotsu != null) {
            is公印に掛ける = chohyoSeigyoKyotsu.get首長名印字位置().equals(new RString("1"));
            is公印を省略 = !chohyoSeigyoKyotsu.is電子公印印字有無();
        }

        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo info = tsuchishoTeikeibunManager.get通知書定型文項目(SubGyomuCode.DBE認定支援, REPORT_DBE223001, KamokuCode.EMPTY, パターン番号_1);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBE認定支援, REPORT_DBE223001);
        List<TsuchishoTeikeibunEntity> tsuchishoTeikeibunList = info.get通知書定型文List();
        int 項目番号;
        RString 通知文定型文 = RString.EMPTY;
        RString 通知文問合せ = RString.EMPTY;
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibun : tsuchishoTeikeibunList) {
            項目番号 = tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentenceNo();
            if (項目番号 == 1) {
                通知文定型文 = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            } else if (項目番号 == 2) {
                通知文問合せ = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            }
        }

        RString tempP_性別男 = RString.EMPTY;
        RString tempP_性別女 = RString.EMPTY;
        RString seibetsuVal = entity.getTemp_性別コード().getColumnValue();
        if (Seibetsu.男.getコード().toString().equals(seibetsuVal.toString())) {
            tempP_性別女 = 星アイコン;
        } else {
            tempP_性別男 = 星アイコン;
        }

        RString tempP_誕生日明治 = 星アイコン;
        RString tempP_誕生日大正 = 星アイコン;
        RString tempP_誕生日昭和 = 星アイコン;
        RString year = entity.getTemp_生年月日().getYear().wareki().getYear().substring(0, 1);
        if (year.startsWith(明)) {
            tempP_誕生日明治 = RString.EMPTY;
        } else if (year.startsWith(大)) {
            tempP_誕生日大正 = RString.EMPTY;
        } else if (year.startsWith(昭)) {
            tempP_誕生日昭和 = RString.EMPTY;
        }

        int 保険者番号の桁 = 0;
        int 被保険者番号の桁 = 0;
        RString 申請区分コード = entity.getTemp_申請区分コード().getColumnValue();
        RString 申請区分 = NinteiShinseiShinseijiKubunCode.toValue(申請区分コード).get名称();
        RString 申請年月日 = entity.getTemp_申請年月日() == null ? RString.EMPTY : entity.getTemp_申請年月日().wareki()
                .eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString();

        return new NinteiChosaTokusokujoBodyItem(
                ninshosha, association,
                reportSourceWriter.getImageFolderPath(), new RDate(paramter.getTemp_基準日().toString()), is公印に掛ける, is公印を省略, KenmeiFuyoKubunType.付与なし,
                文書番号,
                通知文定型文,
                申請区分,
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_保険者番号(), 一桁 * 保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                getLenStr(entity.getTemp_被保険者番号(), 一桁 * 被保険者番号の桁++, 一桁),
                申請年月日,
                entity.getTemp_被保険者氏名カナ() == null ? RString.EMPTY : entity.getTemp_被保険者氏名カナ().getColumnValue(),
                tempP_性別男,
                tempP_性別女,
                entity.getTemp_被保険者氏名() == null ? RString.EMPTY : entity.getTemp_被保険者氏名().getColumnValue(),
                tempP_誕生日明治,
                tempP_誕生日大正,
                tempP_誕生日昭和,
                entity.getTemp_生年月日() == null ? RString.EMPTY : entity.getTemp_生年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString().substring(2),
                entity.getTemp_被保険者郵便番号() == null ? RString.EMPTY : entity.getTemp_被保険者郵便番号().getEditedYubinNo(),
                entity.getTemp_被保険者住所() == null ? RString.EMPTY : entity.getTemp_被保険者住所().getColumnValue(),
                通知文問合せ);
    }

    private RString get文書番号(BunshoNo bushoNo) {
        RString 文書番号 = RString.EMPTY;
        RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
        if (BunshoNoHatsubanHoho.固定.getCode().equalsIgnoreCase(文書番号発番方法)) {
            文書番号 = bushoNo.edit文書番号();
        } else if (BunshoNoHatsubanHoho.手入力.getCode().equalsIgnoreCase(文書番号発番方法)) {
            throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
        } else if (BunshoNoHatsubanHoho.自動採番.getCode().equalsIgnoreCase(文書番号発番方法)) {
            CountedItem 採番 = Saiban.get(SubGyomuCode.DBE認定支援, 汎用キー_文書番号, new FlexibleYear(RDate.getNowDate().getYear().toDateString()));
            文書番号 = bushoNo.edit文書番号(採番.nextString());
        }
        return 文書番号;
    }

    private RString getLenStr(RString rstr, int startIndex, int len) {

        if (!RString.isNullOrEmpty(rstr)) {
            if (rstr.length() >= startIndex + len) {
                return rstr.substring(startIndex, startIndex + len);
            } else if (rstr.length() > startIndex) {
                return rstr.substring(startIndex);
            }
        }
        return RString.EMPTY;
    }
}
