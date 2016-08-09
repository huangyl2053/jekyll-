/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt13015;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoriyoshafutanwariai.HanyoRisutoRiyoshaFutanWariaiEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 汎用リスト出力(利用者負担割合)_process処理クラスです。
 *
 * @reamsid_L DBD-5810-030 mawy
 */
public class HanyoRisutoRiyoshaFutanWariaiProcess extends BatchProcessBase<HanyoRisutoRiyoshaFutanWariaiEntity> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBD701014");
    private static final RString HIHOKENSHANO = new RString("被保険者番号");
    private static final RString RIREKIBANGO = new RString("履歴番号");
    private static final RString EDANO = new RString("枝番号");
    private static final RString 住所地特例 = new RString("住特");
    private static final RString 削除データ = new RString("削除データ");
    private static final RString 発行不要 = new RString("発行不要");
    private static final RString 未発行 = new RString("未発行");
    private static final RString 一括発行 = new RString("一括発行");
    private static final RString 単票発行 = new RString("単票発行");
    private static final RString 直近 = new RString("直近");
    private static final RString 発行区分_0 = new RString("0");
    private static final RString 発行区分_1 = new RString("1");
    private static final RString 発行区分_2 = new RString("2");
    private static final RString CYUSYUTSUTAISYOSHA = new RString("【抽出対象者】");
    private static final RString HOKENSHA = new RString("保険者：");
    private static final RString NENDO = new RString("年度：");
    private static final RString KIZYUNNICHI = new RString("基準日：");
    private static final RString CHOKINNOMI = new RString("対象データ：直近のみ");
    private static final RString FUTANWARIAIKUBUN = new RString("負担割合区分：");
    private static final RString FUTANWARIAI_1_2 = new RString("１割・２割");
    private static final RString FUTANWARIAI_1 = new RString("１割");
    private static final RString FUTANWARIAI_2 = new RString("２割");
    private static final RString CHIKI_1 = new RString("地区１");
    private static final RString CHIKI_2 = new RString("地区２");
    private static final RString CHIKI_3 = new RString("地区３");
    private static final RString GYOSEIKU = new RString("行政区");
    private static final RString JUSYO = new RString("住所");
    private static final RString NENLEI = new RString("年齢");
    private static final RString SEINENGAPPI = new RString("生年月日");
    private static final RString SAI = new RString("歳");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutoriyoshafutanwariai."
            + "IHanyoRisutoRiyoshaFutanWariaiMapper.get汎用リスト");
    private static final RString SPACE = new RString(" ");
    private static final RString COMMA = new RString(",");
    private static final RString COLON = new RString(":");
    private static final RString カラ = new RString("～");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private HanyoRisutoRiyoshaFutanWariaiProcessParameter processParamter;
    private CsvWriter<HanyoRisutoRiyoshaFutanWariaiEucCsvEntity> eucCsvWriter;
    private Association association;
    private HokenshaList hokenshaList;
    private List<PersonalData> personalDataList;
    private int i = 0;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        hokenshaList = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        personalDataList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        RString 出力順 = get出力順();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID,
                processParamter.toHanyoRisutoRiyoshaFutanWariaiMybatisParameter(psmShikibetsuTaisho, psmAtesaki, 出力順));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("UzUDE0831EucAccesslogFileType.csv"));
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParamter.isCsvkomokumeifuka()).
                build();
    }

    @Override
    protected void process(HanyoRisutoRiyoshaFutanWariaiEntity entity) {
        HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity = new HanyoRisutoRiyoshaFutanWariaiEucCsvEntity();
        setEucCsvEntity(eucCsvEntity, entity);
        eucCsvWriter.writeLine(eucCsvEntity);
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        if (processParamter.isCsvkomokumeifuka() && eucCsvWriter.getCount() == 0) {
            eucCsvWriter.writeLine(setBlank());
        }
        eucCsvWriter.close();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilePath, log);
        バッチ出力条件リストの出力();
    }

    private RString get出力順() {
        RStringBuilder orderByClause = new RStringBuilder("order by");
        List<RString> 出力DB項目名 = new ArrayList();
        List<RString> 出力DB項目 = new ArrayList();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, new ReportId(processParamter.getCyohyoid()),
                processParamter.getSyutsuryokujun());
        List<ISetSortItem> 設定項目リスト = order.get設定項目リスト();
        for (ISetSortItem item : 設定項目リスト) {
            出力DB項目名.add(item.getDB項目名());
            出力DB項目.add(item.getDB項目名().concat(SPACE).concat(item.get昇降順().getOrder()));
        }
        if (出力DB項目名.contains(HIHOKENSHANO) && 出力DB項目名.contains(RIREKIBANGO) && !出力DB項目名.contains(EDANO)) {
            for (int index = 0; index < 出力DB項目.size(); index++) {
                if (出力DB項目.get(index).startsWith(RIREKIBANGO)) {
                    出力DB項目.add(index + 1, EDANO);
                }
            }
        } else if (出力DB項目名.contains(HIHOKENSHANO) && !出力DB項目名.contains(RIREKIBANGO) && !出力DB項目名.contains(EDANO)) {
            for (int index = 0; index < 出力DB項目.size(); index++) {
                if (出力DB項目.get(index).startsWith(HIHOKENSHANO)) {
                    出力DB項目.add(index + 1, RIREKIBANGO);
                    出力DB項目.add(index + 2, EDANO);
                }
            }
        } else if (!出力DB項目名.contains(HIHOKENSHANO) && 出力DB項目名.contains(RIREKIBANGO) && !出力DB項目名.contains(EDANO)) {
            for (int index = 0; index < 出力DB項目.size(); index++) {
                if (出力DB項目.get(index).startsWith(RIREKIBANGO)) {
                    出力DB項目.add(index + 1, EDANO);
                }
            }
        } else if (!出力DB項目名.contains(HIHOKENSHANO) && !出力DB項目名.contains(RIREKIBANGO) && !出力DB項目名.contains(EDANO)) {
            出力DB項目.add(HIHOKENSHANO);
            出力DB項目.add(RIREKIBANGO);
            出力DB項目.add(EDANO);
        }
        for (int j = 0; j < 出力DB項目.size(); j++) {
            if (j != 0) {
                orderByClause = orderByClause.append(SPACE).append(COMMA).append(SPACE).append(出力DB項目.get(j));
            } else {
                orderByClause = orderByClause.append(SPACE).append(出力DB項目.get(j));
            }
        }
        return orderByClause.toRString();
    }

    private void setEucCsvEntity(HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity, HanyoRisutoRiyoshaFutanWariaiEntity entity) {
        if (processParamter.isCsvrenbanfuka()) {
            eucCsvEntity.set連番(new RString(String.valueOf(++i)));
        }
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            eucCsvEntity.set識別コード(kojin.get識別コード().value());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set氏名(kojin.get名称().getName().value());
            eucCsvEntity.set氏名カナ(kojin.get名称().getKana().value());
            eucCsvEntity.set生年月日(set年月日(kojin.get生年月日().toFlexibleDate()));
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set性別(kojin.get性別().getName().getShortJapanese());
            eucCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().value());
            eucCsvEntity.set世帯コード(kojin.get世帯コード().value());
            eucCsvEntity.set世帯主名(kojin.get世帯主名().value());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().value());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            RStringBuilder address = new RStringBuilder();
            address.append(kojin.get住所().get住所()).append(kojin.get住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get住所().get方書().value());
            eucCsvEntity.set住所番地方書(address.toRString());
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set番地(kojin.get住所().get番地().getBanchi().value());
            eucCsvEntity.set方書(kojin.get住所().get方書().value());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            eucCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            eucCsvEntity.set地区１(kojin.get行政区画().getChiku1().get名称());
            eucCsvEntity.set地区２(kojin.get行政区画().getChiku2().get名称());
            eucCsvEntity.set地区３(kojin.get行政区画().getChiku3().get名称());
            eucCsvEntity.set連絡先１(kojin.get連絡先１().value());
            eucCsvEntity.set連絡先２(kojin.get連絡先２().value());
            eucCsvEntity.set登録異動日(set年月日(kojin.get登録異動年月日()));
            eucCsvEntity.set登録事由(kojin.get登録事由().get異動事由略称());
            eucCsvEntity.set登録届出日(set年月日(kojin.get登録届出年月日()));
            eucCsvEntity.set住定異動日(set年月日(kojin.get住定異動年月日()));
            eucCsvEntity.set住定事由(kojin.get住定事由().get異動事由略称());
            eucCsvEntity.set住定届出日(set年月日(kojin.get住定届出年月日()));
            eucCsvEntity.set消除異動日(set年月日(kojin.get消除異動年月日()));
            eucCsvEntity.set消除事由(kojin.get消除事由().get異動事由略称());
            eucCsvEntity.set消除届出日(set年月日(kojin.get消除届出年月日()));
            eucCsvEntity.set転出入理由(RString.EMPTY);
            eucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            RStringBuilder addressZen = new RStringBuilder();
            addressZen.append(kojin.get転入前().get住所()).append(kojin.get転入前().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(kojin.get転入前().get方書().value());
            eucCsvEntity.set前住所番地方書(addressZen.toRString());
            eucCsvEntity.set前住所(kojin.get転入前().get住所());
            eucCsvEntity.set前住所番地(kojin.get転入前().get番地().getBanchi().value());
            eucCsvEntity.set前住所方書(kojin.get転入前().get方書().value());
        }
        eucCsvEntity.set市町村コード(entity.get被保険者台帳管理_市町村コード());
        eucCsvEntity.set市町村名(association.get市町村名());
        eucCsvEntity.set保険者コード(association.get地方公共団体コード().value());
        eucCsvEntity.set保険者名(association.getShichosonName_());
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        eucCsvEntity.set資格取得事由(set資格取得事由(entity.get被保険者台帳管理_資格取得事由コード()));
        eucCsvEntity.set資格取得日(set年月日(entity.get被保険者台帳管理_資格取得年月日()));
        eucCsvEntity.set資格取得届出日(set年月日(entity.get被保険者台帳管理_資格取得届出年月日()));
        eucCsvEntity.set喪失事由(set喪失事由(entity.get被保険者台帳管理_資格喪失事由コード()));
        eucCsvEntity.set資格喪失日(set年月日(entity.get被保険者台帳管理_資格喪失年月日()));
        eucCsvEntity.set資格喪失届日(set年月日(entity.get被保険者台帳管理_資格喪失届出年月日()));
        eucCsvEntity.set資格区分(set資格区分(entity.get被保険者台帳管理_被保険者区分コード()));
        eucCsvEntity.set住所地特例状態(new RString("1").equals(entity.get被保険者台帳管理_住所地特例フラグ()) ? 住所地特例 : RString.EMPTY);
        LasdecCode lasdecCode;
        if (new RString("1").equals(entity.get被保険者台帳管理_広域内住所地特例フラグ())) {
            lasdecCode = new LasdecCode(entity.get被保険者台帳管理_広住特措置元市町村コード());
        } else {
            lasdecCode = new LasdecCode(entity.get被保険者台帳管理_市町村コード());
        }
        eucCsvEntity.set資格証記載保険者番号(hokenshaList.get(lasdecCode).get証記載保険者番号().value());
        setEucCsvEntity2(eucCsvEntity, entity);
    }

    private void setEucCsvEntity2(HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity, HanyoRisutoRiyoshaFutanWariaiEntity entity) {
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            eucCsvEntity.set送付先氏名(atesaki.get宛先名称().getName().value());
            eucCsvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().value());
            eucCsvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().value());
            eucCsvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            RStringBuilder 送付address = new RStringBuilder();
            送付address.append(atesaki.get宛先住所().get住所()).append(atesaki.get宛先住所().get番地().getBanchi().value()).append(RString.FULL_SPACE)
                    .append(atesaki.get宛先住所().get方書().value());
            eucCsvEntity.set送付先住所番地方書(送付address.toRString());
            eucCsvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            eucCsvEntity.set送付先番地(atesaki.get宛先住所().get番地().getBanchi().value());
            eucCsvEntity.set送付先方書(atesaki.get宛先住所().get方書().value());
            eucCsvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().value());
            eucCsvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
        }
        eucCsvEntity.set職権フラグ(new RString(String.valueOf(entity.is利用者負担割合_職権変更フラグ())));
        eucCsvEntity.set資格区分(entity.get利用者負担割合明細_資格区分());
        eucCsvEntity.set負担割合区分(entity.get利用者負担割合明細_負担割合区分());
        eucCsvEntity.set判定区分(entity.get利用者負担割合_判定区分());
        eucCsvEntity.set判定日(set年月日(entity.get利用者負担割合_判定日()));
        eucCsvEntity.set有効開始年月日(set年月日(entity.get利用者負担割合明細_有効開始日()));
        eucCsvEntity.set有効終了年月日(set年月日(entity.get利用者負担割合明細_有効終了日()));
        eucCsvEntity.set本人合計所得金額(new RString(entity.get利用者負担割合明細_本人合計所得金額().toString()));
        eucCsvEntity.set世帯１号被保険者数(new RString(String.valueOf(entity.get利用者負担割合明細_世帯１号被保険者数())));
        eucCsvEntity.set年金収入合計(new RString(entity.get利用者負担割合明細_年金収入合計().toString()));
        eucCsvEntity.setその他の合計所得金額合計(new RString(entity.get利用者負担割合明細_その他の合計所得金額合計().toString()));
        eucCsvEntity.set更正事由(entity.get利用者負担割合_更正事由());
        eucCsvEntity.set交付年月日(set年月日(entity.get利用者負担割合_交付日()));
        eucCsvEntity.set削除データ(entity.is利用者負担割合明細_論理削除フラグ() ? 削除データ : RString.EMPTY);
        eucCsvEntity.set年度(entity.get利用者負担割合_年度().toDateString());
        eucCsvEntity.set履歴番号(new RString(String.valueOf(entity.get利用者負担割合_履歴番号())));
        eucCsvEntity.set枝番(new RString(String.valueOf(entity.get利用者負担割合明細_枝番号())));
        eucCsvEntity.set直近情報(entity.get利用者負担割合明細_履歴番号() == entity.get利用者負担割合明細2_履歴番号()
                && entity.get利用者負担割合明細_枝番号() == entity.get利用者負担割合明細2_枝番号() ? 直近 : RString.EMPTY);
        eucCsvEntity.set発行不要(entity.is利用者負担割合_発行不要フラグ() ? 発行不要 : RString.EMPTY);
        if (entity.get利用者負担割合_発行区分().equals(発行区分_0)) {
            eucCsvEntity.set発行区分(未発行);
        } else if (entity.get利用者負担割合_発行区分().equals(発行区分_1)) {
            eucCsvEntity.set発行区分(一括発行);
        } else if (entity.get利用者負担割合_発行区分().equals(発行区分_2)) {
            eucCsvEntity.set発行区分(単票発行);
        } else {
            eucCsvEntity.set発行区分(RString.EMPTY);
        }
        eucCsvEntity.set発行年月日(set年月日(entity.get利用者負担割合_発行日()));
    }

    private PersonalData toPersonalData(HanyoRisutoRiyoshaFutanWariaiEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者台帳管理_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private HanyoRisutoRiyoshaFutanWariaiEucCsvEntity setBlank() {
        HanyoRisutoRiyoshaFutanWariaiEucCsvEntity eucCsvEntity = new HanyoRisutoRiyoshaFutanWariaiEucCsvEntity();
        eucCsvEntity.set連番(RString.EMPTY);
        eucCsvEntity.set識別コード(RString.EMPTY);
        eucCsvEntity.set住民種別(RString.EMPTY);
        eucCsvEntity.set氏名(RString.EMPTY);
        eucCsvEntity.set氏名カナ(RString.EMPTY);
        eucCsvEntity.set生年月日(RString.EMPTY);
        eucCsvEntity.set年齢(RString.EMPTY);
        eucCsvEntity.set性別(RString.EMPTY);
        eucCsvEntity.set続柄コード(RString.EMPTY);
        eucCsvEntity.set世帯コード(RString.EMPTY);
        eucCsvEntity.set世帯主名(RString.EMPTY);
        eucCsvEntity.set住所コード(RString.EMPTY);
        eucCsvEntity.set郵便番号(RString.EMPTY);
        eucCsvEntity.set住所番地方書(RString.EMPTY);
        eucCsvEntity.set住所(RString.EMPTY);
        eucCsvEntity.set番地(RString.EMPTY);
        eucCsvEntity.set方書(RString.EMPTY);
        eucCsvEntity.set行政区コード(RString.EMPTY);
        eucCsvEntity.set行政区名(RString.EMPTY);
        eucCsvEntity.set地区１(RString.EMPTY);
        eucCsvEntity.set地区２(RString.EMPTY);
        eucCsvEntity.set地区３(RString.EMPTY);
        eucCsvEntity.set連絡先１(RString.EMPTY);
        eucCsvEntity.set連絡先２(RString.EMPTY);
        eucCsvEntity.set登録異動日(RString.EMPTY);
        eucCsvEntity.set登録事由(RString.EMPTY);
        eucCsvEntity.set登録届出日(RString.EMPTY);
        eucCsvEntity.set住定異動日(RString.EMPTY);
        eucCsvEntity.set住定事由(RString.EMPTY);
        eucCsvEntity.set住定届出日(RString.EMPTY);
        eucCsvEntity.set消除異動日(RString.EMPTY);
        eucCsvEntity.set消除事由(RString.EMPTY);
        eucCsvEntity.set消除届出日(RString.EMPTY);
        eucCsvEntity.set転出入理由(RString.EMPTY);
        eucCsvEntity.set前住所郵便番号(RString.EMPTY);
        eucCsvEntity.set前住所番地方書(RString.EMPTY);
        eucCsvEntity.set前住所(RString.EMPTY);
        eucCsvEntity.set前住所番地(RString.EMPTY);
        eucCsvEntity.set前住所方書(RString.EMPTY);
        eucCsvEntity.set市町村コード(RString.EMPTY);
        eucCsvEntity.set市町村名(RString.EMPTY);
        eucCsvEntity.set保険者コード(RString.EMPTY);
        eucCsvEntity.set保険者名(RString.EMPTY);
        eucCsvEntity.set空白(RString.EMPTY);
        eucCsvEntity.set送付先氏名(RString.EMPTY);
        eucCsvEntity.set送付先氏名カナ(RString.EMPTY);
        eucCsvEntity.set送付先住所コード(RString.EMPTY);
        eucCsvEntity.set送付先郵便番号(RString.EMPTY);
        eucCsvEntity.set送付先住所番地方書(RString.EMPTY);
        eucCsvEntity.set送付先住所(RString.EMPTY);
        eucCsvEntity.set送付先番地(RString.EMPTY);
        eucCsvEntity.set送付先方書(RString.EMPTY);
        eucCsvEntity.set送付先行政区コード(RString.EMPTY);
        eucCsvEntity.set送付先行政区名(RString.EMPTY);
        eucCsvEntity.set被保険者番号(RString.EMPTY);
        eucCsvEntity.set資格取得事由(RString.EMPTY);
        eucCsvEntity.set資格取得日(RString.EMPTY);
        eucCsvEntity.set資格取得届出日(RString.EMPTY);
        eucCsvEntity.set喪失事由(RString.EMPTY);
        eucCsvEntity.set資格喪失日(RString.EMPTY);
        eucCsvEntity.set資格喪失届日(RString.EMPTY);
        eucCsvEntity.set資格区分(RString.EMPTY);
        eucCsvEntity.set住所地特例状態(RString.EMPTY);
        eucCsvEntity.set資格証記載保険者番号(RString.EMPTY);
        eucCsvEntity.set職権フラグ(RString.EMPTY);
        eucCsvEntity.set資格区分(RString.EMPTY);
        eucCsvEntity.set負担割合区分(RString.EMPTY);
        eucCsvEntity.set判定区分(RString.EMPTY);
        eucCsvEntity.set判定日(RString.EMPTY);
        eucCsvEntity.set有効開始年月日(RString.EMPTY);
        eucCsvEntity.set有効終了年月日(RString.EMPTY);
        eucCsvEntity.set本人合計所得金額(RString.EMPTY);
        eucCsvEntity.set世帯１号被保険者数(RString.EMPTY);
        eucCsvEntity.set年金収入合計(RString.EMPTY);
        eucCsvEntity.setその他の合計所得金額合計(RString.EMPTY);
        eucCsvEntity.set更正事由(RString.EMPTY);
        eucCsvEntity.set交付年月日(RString.EMPTY);
        eucCsvEntity.set削除データ(RString.EMPTY);
        eucCsvEntity.set年度(RString.EMPTY);
        eucCsvEntity.set履歴番号(RString.EMPTY);
        eucCsvEntity.set枝番(RString.EMPTY);
        eucCsvEntity.set直近情報(RString.EMPTY);
        eucCsvEntity.set発行不要(RString.EMPTY);
        eucCsvEntity.set発行区分(RString.EMPTY);
        eucCsvEntity.set発行年月日(RString.EMPTY);
        return eucCsvEntity;
    }

    private RString set年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (processParamter.isCsvhitsukesurasyuhensyu()) {
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
        } else {
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.ZERO).getYearMonth();
        }

    }

    private RString set資格区分(RString 被保険者区分コード) {
        if (RString.isNullOrEmpty(被保険者区分コード)) {
            return RString.EMPTY;
        }
        return HihokenshaKubunCode.toValue(被保険者区分コード).get名称();
    }

    private RString set資格取得事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 資格取得事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0007"), new Code(事由コード));
        if (資格取得事由 == null) {
            return RString.EMPTY;
        }
        return 資格取得事由.getコード略称();
    }

    private RString set喪失事由(RString 事由コード) {
        if (RString.isNullOrEmpty(事由コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 喪失事由 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0010"), new Code(事由コード));
        if (喪失事由 == null) {
            return RString.EMPTY;
        }
        return 喪失事由.getコード略称();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        RString csv出力有無 = new RString("無し");
        RString 日本語ファイル名 = new RString("汎用リスト　利用者負担割合CSV");
        RString 英数字ファイル名 = new RString("HanyoList_RiyosyaFutanwariai.csv");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(CYUSYUTSUTAISYOSHA);
        RStringBuilder builder = new RStringBuilder();
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getShichoson_Code()
                && !processParamter.getAtenacyusyutsujyoken().getShichoson_Code().equals(LasdecCode.EMPTY)) {
            builder.append(HOKENSHA);
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association 地方公共団体 = finder.getAssociation(processParamter.getAtenacyusyutsujyoken().getShichoson_Code());
            builder.append(地方公共団体.get市町村名());
            出力条件.add(builder.toRString());
        }
        if (null != processParamter.getNendo()) {
            builder.append(NENDO);
            builder.append(processParamter.getNendo().wareki().toDateString());
            出力条件.add(builder.toRString());
        }
        if (null != processParamter.getKizyunnichi()) {
            builder.append(KIZYUNNICHI);
            builder.append(processParamter.getKizyunnichi().wareki().toDateString());
            出力条件.add(builder.toRString());
        }
        if (processParamter.isNendochokindatacyusyutsu()) {
            builder.append(CHOKINNOMI);
            出力条件.add(builder.toRString());
        }
        出力条件.add(get事業対象者負担情報());
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getAgeSelectKijun()) {
            出力条件.add(get宛名抽出区分情報());
        }
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getChiku_Kubun()) {
            出力条件.add(get地区選択区分情報());
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                new RString("DBD701012"),
                導入団体コード,
                市町村名,
                ジョブ番号,
                日本語ファイル名,
                出力ページ数,
                csv出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private RString get地区区間出力条件(RString codeFrom, RString fromMesho, RString codeTo, RString toMesho) {
        RStringBuilder builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(codeFrom)) {
            builder.append(左記号);
            builder.append(codeFrom);
            builder.append(右記号);
            builder.append(SPACE);
            builder.append(fromMesho);
            builder.append(SPACE);
        }
        builder.append(カラ);
        if (!RString.isNullOrEmpty(codeTo)) {
            builder.append(SPACE);
            builder.append(左記号);
            builder.append(codeTo);
            builder.append(右記号);
            builder.append(SPACE);
            builder.append(toMesho);
        }
        return builder.toRString();
    }

    private RString get宛名抽出区分情報() {
        RStringBuilder builder = new RStringBuilder();
        if (NenreiSoChushutsuHoho.年齢範囲.equals(processParamter.getAtenacyusyutsujyoken().getAgeSelectKijun())) {
            builder.append(NENLEI);
            builder.append(COLON);
            if (null != processParamter.getAtenacyusyutsujyoken().getNenreiRange().getFrom()) {
                builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getNenreiRange().getFrom().toString()));
                builder.append(SAI);
            }
            builder.append(SPACE);
            builder.append(カラ);
            if (null != processParamter.getAtenacyusyutsujyoken().getNenreiRange().getTo()) {
                builder.append(SPACE);
                builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getNenreiRange().getTo().toString()));
                builder.append(SAI);
            }
        } else if (NenreiSoChushutsuHoho.生年月日範囲.equals(processParamter.getAtenacyusyutsujyoken().getAgeSelectKijun())) {
            builder.append(SEINENGAPPI);
            builder.append(COLON);
            if (null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getFrom()) {
                builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getFrom().toString()));
            }
            builder.append(SPACE);
            builder.append(カラ);
            if (null != processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getTo()) {
                builder.append(SPACE);
                builder.append(new RString(processParamter.getAtenacyusyutsujyoken().getSeinengappiRange().getTo().toString()));
            }
        }
        return builder.toRString();
    }

    private RString get地区選択区分情報() {
        RStringBuilder builder = new RStringBuilder();
        if (Chiku.地区.equals(processParamter.getAtenacyusyutsujyoken().getChiku_Kubun())) {
            if (!RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku1_From())
                    && !RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku1_To())) {
                builder.append(CHIKI_1);
                builder.append(COLON);
                builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getChiku1_From(),
                        processParamter.getAtenacyusyutsujyoken().getChiku1_FromMesho(),
                        processParamter.getAtenacyusyutsujyoken().getChiku1_To(),
                        processParamter.getAtenacyusyutsujyoken().getChiku1_ToMesho()));
            } else if (!RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku2_From())
                    && RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku2_To())) {
                builder.append(CHIKI_2);
                builder.append(COLON);
                builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getChiku2_From(),
                        processParamter.getAtenacyusyutsujyoken().getChiku2_FromMesho(),
                        RString.EMPTY,
                        RString.EMPTY));
            } else if (RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku3_From())
                    && !RString.isNullOrEmpty(processParamter.getAtenacyusyutsujyoken().getChiku3_To())) {
                builder.append(CHIKI_3);
                builder.append(COLON);
                builder.append(get地区区間出力条件(RString.EMPTY,
                        RString.EMPTY,
                        processParamter.getAtenacyusyutsujyoken().getChiku3_To(),
                        processParamter.getAtenacyusyutsujyoken().getChiku3_ToMesho()));
            }
        } else if (Chiku.行政区.equals(processParamter.getAtenacyusyutsujyoken().getChiku_Kubun())) {
            builder.append(GYOSEIKU);
            builder.append(COLON);
            builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getGyoseiku_From(),
                    processParamter.getAtenacyusyutsujyoken().getGyoseiku_FromMesho(),
                    processParamter.getAtenacyusyutsujyoken().getGyoseiku_To(),
                    processParamter.getAtenacyusyutsujyoken().getGyoseiku_ToMesho()));
        } else if (Chiku.住所.equals(processParamter.getAtenacyusyutsujyoken().getChiku_Kubun())) {
            builder.append(JUSYO);
            builder.append(COLON);
            builder.append(get地区区間出力条件(processParamter.getAtenacyusyutsujyoken().getJusho_From(),
                    processParamter.getAtenacyusyutsujyoken().getJusho_FromMesho(),
                    processParamter.getAtenacyusyutsujyoken().getJusho_To(),
                    processParamter.getAtenacyusyutsujyoken().getJusho_ToMesho()));
        }
        return builder.toRString();
    }

    private RString get事業対象者負担情報() {
        RStringBuilder builder = new RStringBuilder();
        if (processParamter.isJigyotaishoshafutanichiwari() && processParamter.isJigyotaishoshafutanniwari()) {
            builder.append(FUTANWARIAIKUBUN);
            builder.append(FUTANWARIAI_1_2);
        } else if (processParamter.isJigyotaishoshafutanichiwari()) {
            builder.append(FUTANWARIAIKUBUN);
            builder.append(FUTANWARIAI_1);
        } else if (processParamter.isJigyotaishoshafutanniwari()) {
            builder.append(FUTANWARIAIKUBUN);
            builder.append(FUTANWARIAI_2);
        }
        return builder.toRString();
    }

}
