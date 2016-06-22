/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.dbe223001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokujoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.dbe223001.NinteiChosaTokusokujoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.chosa.ChohyoAtesakiKeisho;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe223001.NinteiChosaTokusokujoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001.AtenaKikan;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.dbe223001.NinteiChosaTokusokujoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe223001.IDbe223001RelateMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査督促状の作成クラスです。
 *
 * @reamsid_L DBE-0030-040 xuyue
 */
public class NinteiChosaTokusokujoReportProcess extends BatchProcessBase<NinteiChosaTokusokujoRelateEntity> {

    /**
     * OutputParameter用キー outShinseishoKanriNoList
     */
    public static final RString OUT_SHINSEISHO_KANRINO_LIST;
    private NinteiChosaTokusokujoProcessParameter paramter;
    private static final ReportId REPORT_DBE223001 = ReportIdDBE.DBE223001_NinteiChosaTokusokujo.getReportId();
    @BatchWriter
    private BatchReportWriter<NinteiChosaTokusokujoReportSource> batchWrite;
    private ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter;
    IDbe223001RelateMapper mapper;

    private NinteiChosaTokusokujoBodyItem bodyItem;
    private final int パターン番号_1 = 1;

    private static final RString 星アイコン = new RString("＊");
    private static final RString 明 = new RString("明");
    private static final RString 大 = new RString("大");
    private static final RString 昭 = new RString("昭");
    private static final int 一桁 = 1;

    RString 文書番号;
    NinshoshaSource ninshoshaSource;
    Map<Integer, RString> 通知文;
    AtenaKikan atenaKikan;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.dbe223001.IDbe223001RelateMapper.select要介護認定調査督促状ByKey");

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
    protected void beforeExecute() {
        mapper = getMapper(IDbe223001RelateMapper.class);
        getKyotsuData();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toNinteiChosaTokusokujoMybatisParameter());
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

    private void getKyotsuData() {
        文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBE認定支援, REPORT_DBE223001, paramter.getTemp_基準日());
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援, REPORT_DBE223001, paramter.getTemp_基準日(), reportSourceWriter);
        通知文 = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, REPORT_DBE223001, KamokuCode.EMPTY, パターン番号_1);

        DbT7051KoseiShichosonMasterEntity shichoson = mapper.select市町村コード(paramter.getTemp_保険者コード());
        RString temp_市町村コード = RString.EMPTY;
        if (shichoson != null) {
            temp_市町村コード = shichoson.getShichosonCode().getColumnValue();
        }
        atenaKikan = mapper.select宛名機関(paramter.toNinteiChosaTokusokujoMybatisParameter(new LasdecCode(temp_市町村コード)));
        if (atenaKikan == null) {
            atenaKikan = new AtenaKikan();
        }
    }

    private NinteiChosaTokusokujoBodyItem setBodyItem(NinteiChosaTokusokujoRelateEntity entity) {

        RString 宛名郵便番号 = RString.EMPTY;
        if (atenaKikan.get宛名郵便番号() != null) {
            宛名郵便番号 = atenaKikan.get宛名郵便番号().getColumnValue();
        }
        RString 住所 = RString.EMPTY;
        if (atenaKikan.get宛名住所() != null) {
            住所 = atenaKikan.get宛名住所();
        }
        RString customerBarCode = ReportUtil.getCustomerBarCode(宛名郵便番号, 住所);

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

        RString 帳票宛先敬称コード;
        RString tempP_宛名名称付与;
        try {
            帳票宛先敬称コード = DbBusinessConfig.get(ConfigNameDBE.認定調査督促状_宛先敬称, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
            tempP_宛名名称付与 = ChohyoAtesakiKeisho.toValue(帳票宛先敬称コード).get名称();
        } catch (Exception e) {
            tempP_宛名名称付与 = RString.EMPTY;
        }
        RString title;
        try {
            title = DbBusinessConfig.get(ConfigNameDBE.要介護認定調査督促状, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        } catch (Exception e) {
            title = RString.EMPTY;
        }

        return new NinteiChosaTokusokujoBodyItem(
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.koinShoryaku,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.ninshoshaShimeiKakeru,
                文書番号,
                通知文.get(1),
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
                通知文.get(2),
                宛名郵便番号,
                住所,
                atenaKikan.get宛名機関名(),
                atenaKikan.get宛名氏名(),
                tempP_宛名名称付与,
                customerBarCode,
                entity.getTemp_保険者番号(),
                title
        );
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
