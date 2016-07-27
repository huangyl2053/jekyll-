/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBDBT13011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt13011.GeneralPurposeListOutputProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputEucCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt13011.GeneralPurposeListOutputNotContainNoEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.AtenaSelectBatchParameter;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.MinashiCode;
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
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * バッチ設計_DBDBT13011_汎用リスト出力(施設入退所)事前準備_process処理クラスです。
 *
 * @reamsid_L DBD-1570-030 x_lilh
 */
public class GeneralPurposeListOutputExecProcess extends BatchProcessBase<GeneralPurposeListOutputEntity> {

    private static final RString 届出区分_1 = new RString("1");
    private static final RString 届出区分_2 = new RString("2");
    private static final RString 届出区分_3 = new RString("3");
    private static final RString 住特 = new RString("住特");
    private static final RString 住所地特例フラグ_TRUE = new RString("0");
    private static final RString 有効 = new RString("有効");
    private static final RString 無効 = new RString("無効");
    private static final RString 資格取得前申請区分_資格取得前申請 = new RString("資格取得前申請");
    private static final RString 指定医区分_指定医 = new RString("指定医");
    private static final RString 入所施設種類_11 = new RString("11");
    private static final RString 入所施設種類_12 = new RString("12");
    private static final RString 入所施設種類_21 = new RString("21");

    private static final RString 新規 = new RString("新規");
    private static final RString 変更 = new RString("変更");
    private static final RString 暫定 = new RString("暫定");

    private static final RString 未登録 = RString.EMPTY;
    private static final RString 追加_認定 = new RString("認定　　　　　");
    private static final RString 要介護度変更申請認定 = new RString("変更申請認定　");
    private static final RString 要介護度変更申請却下 = new RString("変更申請却下　");
    private static final RString サービス種類変更申請認定 = new RString("サ変更申請認定");
    private static final RString サービス種類変更申請却下 = new RString("サ変更申請却下");
    private static final RString 削除 = new RString("削除　　　　　");
    private static final RString 修正 = new RString("修正　　　　　");
    private static final RString 受給申請却下 = new RString("受給申請却下　");
    private static final RString 削除回復 = new RString("削除回復　　　");
    private static final RString 職権記載 = new RString("職権記載　　　");
    private static final RString 職権修正 = new RString("職権修正　　　");
    private static final RString 職権取消 = new RString("職権取消　　　");
    private static final RString 履歴修正 = new RString("履歴修正　　　");

    private static final RString 日本語ファイル名 = new RString("汎用リスト　施設入退所CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_ShisetuNyutaisyo.csv");
    private static final RString 出力条件表_保険者 = new RString("保険者：");
    private static final RString 出力条件表_基準日 = new RString("基準日：");
    private static final RString 出力条件表_取得日 = new RString("取得日：～　");
    private static final RString 出力条件表_対象データ_直近のみ = new RString("対象データ：直近のみ");
    private static final RString 出力条件表_喪失区分 = new RString("喪失区分：");
    private static final RString 出力条件表_年齢 = new RString("年齢：");
    private static final RString 出力条件表_歳 = new RString("歳");
    private static final RString 出力条件表_中間符号 = new RString("～");
    private static final RString 出力条件表_年齢基準日 = new RString("年齢基準日：");
    private static final RString 出力条件表_左丸括弧 = new RString("(");
    private static final RString 出力条件表_右丸括弧 = new RString(")");
    private static final RString 出力条件表_生年月日 = new RString("生年月日：");
    private static final RString 出力条件表_HALF_SPACE = RString.HALF_SPACE;

    private static final RString 出力条件表_住所 = new RString("住所： ");
    private static final RString 出力条件表_行政区 = new RString("行政区： ");
    private static final RString 出力条件表_地区１ = new RString("地区１： ");
    private static final RString 出力条件表_地区２ = new RString("地区２： ");
    private static final RString 出力条件表_地区３ = new RString("地区３： ");

    private static final RString TRUE = new RString("true");
    private static final RString FALSE = new RString("false");

    private static final RString ETC = new RString("etc.");
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;

    private static final RString みなし = new RString("みなし");

    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString 要支援申請 = new RString("要支援申請");
    private static final RString 要介護申請 = new RString("要介護申請");

    private static final RString 初回申請 = new RString("初回申請");
    private static final RString 再申請内 = new RString("再申請内");
    private static final RString 再申請外 = new RString("再申請外");
    private static final RString 支援から申請 = new RString("支援から申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString サ変更申請 = new RString("サ変更申請");
    private static final RString 施行前申請 = new RString("施行前申請");
    private static final RString 追加 = new RString("追加");

    private static final RString 資格判定なし = new RString("資格判定なし");
    private static final RString 年齢 = new RString("年齢");
    private static final RString 生年月日 = new RString("生年月日");
    private static final RString 全て = new RString("全て");
    private static final RString すべて = new RString("すべて");

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBD701010");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private GeneralPurposeListOutputProcessParameter processParamter;
    private EucCsvWriter<GeneralPurposeListOutputEucCsvEntity> eucCsvWriter;
    private EucCsvWriter<GeneralPurposeListOutputNotContainNoEucCsvEntity> eucNotContainNoCsvWriter;

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.generalPurposeListOutput."
            + "IGeneralPurposeListOutputMapper.getGeneralPurposeListOutputInfo");

    private Association 地方公共団体情報;
    private RDateTime sysDateTime;
    private HokenshaList 保険者リスト;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;
    private int i = 0;

    @Override
    protected void initialize() {
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        保険者リスト = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        personalDataList = new ArrayList<>();
    }

    @Override
    protected void beforeExecute() {
        // 地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        //sysDateTime = RDateTime.now();
        // 保険者リスト = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        //personalDataList = new ArrayList<>();

//        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
//                new ReportId(processParamter.get帳票ID()), processParamter.getReamsLoginID(), processParamter.get改頁出力順ID());
//        RString 出力順 = MyBatisOrderByClauseCreator.create(ShiharaiHohoHenkoHaakuIchiranOrderKey.class, outputOrder);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toGeneralPurposeListOutputMybatisParameter(psmShikibetsuTaisho, psmAtesaki));
    }

    int csvcount = 0;

    @Override
    protected void process(GeneralPurposeListOutputEntity entity) {

        GeneralPurposeListOutputEucCsvEntity eucCsvEntity = new GeneralPurposeListOutputEucCsvEntity();
        setEucCsvEntity(eucCsvEntity, entity);
        eucCsvWriter.writeLine(eucCsvEntity);
        csvcount++;
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        eucFileOutputJohoFactory();
//        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
//        manager.spool(eucFilePath, log);
    }

    private PersonalData toPersonalData(GeneralPurposeListOutputEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者台帳管理_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_ShisetuNyutaisyo.csv"));
        if (processParamter.is連番付加()) {
            eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(processParamter.is項目名付加()).
                    build();
        } else {
            eucNotContainNoCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(processParamter.is項目名付加()).
                    build();
        }
    }

    private void eucFileOutputJohoFactory() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                日本語ファイル名,
                地方公共団体情報.getLasdecCode_().getColumnValue(),
                地方公共団体情報.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                英数字ファイル名,
                EUC_ENTITY_ID.toRString(),
                new RString(String.valueOf(eucCsvWriter.getCount())),
                get出力条件表());
        EucFileOutputJokenhyoFactory.createInstance(item).print();
    }

    private void setEucCsvEntity(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        if (processParamter.is連番付加()) {
            eucCsvEntity.set連番(new RString(String.valueOf(++i)));
        }
        set宛名情報について(eucCsvEntity, entity);
        set宛先情報について(eucCsvEntity, entity);
        set被保険者台帳管理について(eucCsvEntity, entity);
        set医療保険加入状況について(eucCsvEntity, entity);
        set受給者台帳(eucCsvEntity, entity);
        set今回申請届出について(eucCsvEntity, entity);
        set申請届出事業者について(eucCsvEntity, entity);
        set今回申請について(eucCsvEntity, entity);
        set今回調査委託先について(eucCsvEntity, entity);
        set今回調査員について(eucCsvEntity, entity);
        set今回主治医医療機関について(eucCsvEntity, entity);
        set今回主治医について(eucCsvEntity, entity);
        set今回調査依頼について(eucCsvEntity, entity);
        set今回計画情報について(eucCsvEntity, entity);
        set今回完了情報について(eucCsvEntity, entity);
        set今回意見書作成依頼について(eucCsvEntity, entity);
        set今回意見書情報について(eucCsvEntity, entity);
        set今回一次判定結果について(eucCsvEntity, entity);
        set今回結果情報について(eucCsvEntity, entity);
        set初回受給情報について(eucCsvEntity, entity);
        set初回申請について(eucCsvEntity, entity);
        set前回受給情報について(eucCsvEntity, entity);
        set前回申請について(eucCsvEntity, entity);
        set前々回受給情報について(eucCsvEntity, entity);
        set今回調査結果_基本について(eucCsvEntity, entity);
        set介護保険施設入退所について(eucCsvEntity, entity);
        set居宅届出について(eucCsvEntity, entity);
        set事業者作成について(eucCsvEntity, entity);
        set計画事業者について(eucCsvEntity, entity);
        set計画事業者代表者について(eucCsvEntity, entity);
        set自己作成について(eucCsvEntity, entity);
        set指定事業者について(eucCsvEntity, entity);
        set除外他特適用施設について(eucCsvEntity, entity);
    }

    private void set宛名情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //宛名 を IKojin
        if (entity.getPsmEntity() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.getPsmEntity());
            eucCsvEntity.set識別コード(kojin.get識別コード().getColumnValue());
            eucCsvEntity.set住民種別(kojin.get住民状態().住民状態略称());
            eucCsvEntity.set氏名(kojin.get名称().getName().getColumnValue());
            eucCsvEntity.set氏名カナ(kojin.get名称().getKana().getColumnValue());
            eucCsvEntity.set生年月日(edit年月日_yyyymmdd(kojin.get生年月日().toFlexibleDate()));
            eucCsvEntity.set年齢(kojin.get年齢算出().get年齢());
            eucCsvEntity.set性別(kojin.get性別().getName().getShortJapanese());

            eucCsvEntity.set続柄コード(kojin.get続柄コードリスト().toTsuzukigaraCode().getColumnValue());
            eucCsvEntity.set世帯コード(kojin.get世帯コード().getColumnValue());
            eucCsvEntity.set世帯主名(kojin.get世帯主名().getColumnValue());
            eucCsvEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
            eucCsvEntity.set郵便番号(kojin.get住所().get郵便番号().getEditedYubinNo());
            eucCsvEntity.set住所_番地_方書(get住所_番地_方書(kojin.get住所().get住所(),
                    new RString(kojin.get住所().get番地().toString()),
                    kojin.get住所().get方書().getColumnValue()));
            eucCsvEntity.set住所(kojin.get住所().get住所());
            eucCsvEntity.set番地(new RString(kojin.get住所().get番地().toString()));
            eucCsvEntity.set方書(kojin.get住所().get方書().getColumnValue());
            eucCsvEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
            eucCsvEntity.set行政区名(kojin.get行政区画().getGyoseiku().get名称());
            eucCsvEntity.set地区１(kojin.get行政区画().getChiku1().getコード().getColumnValue());
            eucCsvEntity.set地区２(kojin.get行政区画().getChiku2().getコード().getColumnValue());
            eucCsvEntity.set地区３(kojin.get行政区画().getChiku3().getコード().getColumnValue());
            eucCsvEntity.set連絡先１(kojin.get連絡先１().getColumnValue());
            eucCsvEntity.set連絡先２(kojin.get連絡先２().getColumnValue());
            eucCsvEntity.set登録異動日(edit年月日_yyyymmdd(kojin.get登録異動年月日()));
            eucCsvEntity.set登録事由(kojin.get登録事由().get異動事由略称());
            eucCsvEntity.set登録届出日(edit年月日_yyyymmdd(kojin.get登録届出年月日()));
            eucCsvEntity.set住定異動日(edit年月日_yyyymmdd(kojin.get住定異動年月日()));
            eucCsvEntity.set住定事由(kojin.get住定事由().get異動事由略称());
            eucCsvEntity.set住定届出日(edit年月日_yyyymmdd(kojin.get住定届出年月日()));
            eucCsvEntity.set消除異動日(edit年月日_yyyymmdd(kojin.get消除異動年月日()));
            eucCsvEntity.set消除事由(kojin.get消除事由().get異動事由略称());
            eucCsvEntity.set消除届出日(edit年月日_yyyymmdd(kojin.get消除届出年月日()));
            eucCsvEntity.set転出入理由(RString.EMPTY);
            eucCsvEntity.set前住所郵便番号(kojin.get転入前().get郵便番号().getEditedYubinNo());
            eucCsvEntity.set前住所_番地_方書(get住所_番地_方書(kojin.get転入前().get住所(),
                    new RString(kojin.get転入前().get番地().toString()),
                    kojin.get転入前().get方書().getColumnValue()));
            eucCsvEntity.set前住所(kojin.get転入前().get住所());
            eucCsvEntity.set前住所番地(new RString(kojin.get転入前().get番地().toString()));
            eucCsvEntity.set前住所方書(kojin.get転入前().get方書().getColumnValue());

            eucCsvEntity.set市町村コード(new RString("TODO"));
            eucCsvEntity.set市町村名(地方公共団体情報.get地方公共団体コード().getColumnValue());
            eucCsvEntity.set保険者コード(new RString("TODO"));
            eucCsvEntity.set保険者名(new RString("TODO"));
            eucCsvEntity.set空白(RString.EMPTY);
        }
    }

    private void set宛先情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //宛先 を IAtesaki
        if (entity.getAtesakiEntity() != null) {
            IAtesaki atesaki = AtesakiFactory.createInstance(entity.getAtesakiEntity());
            eucCsvEntity.set送付先氏名(atesaki.get宛先名称().getName().getColumnValue());
            eucCsvEntity.set送付先氏名カナ(atesaki.get宛先名称().getKana().getColumnValue());
            eucCsvEntity.set送付先住所コード(atesaki.get宛先住所().get全国住所コード().getColumnValue());
            eucCsvEntity.set送付先郵便番号(atesaki.get宛先住所().get郵便番号().getEditedYubinNo());
            eucCsvEntity.set送付先住所_番地_方書(get住所_番地_方書(atesaki.get宛先住所().get住所(),
                    new RString(atesaki.get宛先住所().get番地().toString()),
                    atesaki.get宛先住所().get方書().getColumnValue()));
            eucCsvEntity.set送付先住所(atesaki.get宛先住所().get住所());
            eucCsvEntity.set送付先番地(new RString(atesaki.get宛先住所().get番地().toString()));
            eucCsvEntity.set送付先方書(atesaki.get宛先住所().get方書().getColumnValue());
            eucCsvEntity.set送付先行政区コード(atesaki.get宛先行政区().getコード().getColumnValue());
            eucCsvEntity.set送付先行政区名(atesaki.get宛先行政区().get名称());
            eucCsvEntity.set被保険者番号(new RString("TODO"));
        }
    }

    private void set被保険者台帳管理について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //被保険者台帳管理
        eucCsvEntity.set被保険者番号(entity.get被保険者台帳管理_被保険者番号());
        eucCsvEntity.set資格取得事由(getコードマスタ(DBACodeShubetsu.介護資格取得事由_被保険者.getコード(),
                new Code(entity.get被保険者台帳管理_資格取得事由コード())));
        eucCsvEntity.set資格取得日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格取得年月日()));
        eucCsvEntity.set資格取得届出日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格取得届出年月日()));
        eucCsvEntity.set喪失事由(entity.get被保険者台帳管理_資格喪失事由コード());
        eucCsvEntity.set資格喪失日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格喪失年月日()));
        eucCsvEntity.set資格喪失届日(edit年月日_yyyymmdd(entity.get被保険者台帳管理_資格喪失届出年月日()));
        eucCsvEntity.set資格区分(entity.get被保険者台帳管理_被保険者区分コード());

        eucCsvEntity.set住所地特例状態(edit住所地特例フラグ(entity.get被保険者台帳管理_住所地特例フラグ()));
        if (住所地特例フラグ_TRUE.equals(entity.get被保険者台帳管理_広域内住所地特例フラグ())) {
            eucCsvEntity.set資格_証記載保険者番号(保険者リスト.get(new LasdecCode(entity.get被保険者台帳管理_広住特措置元市町村コード()))
                    .get証記載保険者番号().getColumnValue());
        } else {
            eucCsvEntity.set資格_証記載保険者番号(保険者リスト.get(new LasdecCode(entity.get被保険者台帳管理_市町村コード()))
                    .get証記載保険者番号().getColumnValue());
        }
    }

    private void set医療保険加入状況について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //医療保険加入状況
        eucCsvEntity.set医療保険種別(getコードマスタ(DBACodeShubetsu.医療保険種類.getコード(),
                new Code(entity.get医療保険加入状況_医療保険種別コード())));
        eucCsvEntity.set医療保険番号(entity.get医療保険加入状況_医療保険番号());
        eucCsvEntity.set医療保険者名(entity.get医療保険加入状況_医療保険者名称());
        eucCsvEntity.set医療保険記号番号(entity.get医療保険加入状況_医療保険記号番号());
    }

    private void set受給者台帳(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //受給者台帳
        eucCsvEntity.set特定疾病(entity.get受給者台帳_2号特定疾病コード());
        eucCsvEntity.set受給申請事由(edit受給申請事由(entity.get受給者台帳_受給申請事由(), entity.get受給者台帳_要支援者認定申請区分()));
        eucCsvEntity.set申請理由(entity.get受給者台帳_申請理由());
        //TODO
        eucCsvEntity.set申請関係者(entity.get受給者台帳_本人との関係());
        eucCsvEntity.set本人関係(entity.get受給者台帳_本人との関係());
        eucCsvEntity.set受給申請日(edit年月日_yyyymmdd(entity.get受給者台帳_受給申請年月日()));
        eucCsvEntity.set審査回答日(edit年月日_yyyymmdd(entity.get受給者台帳_認定年月日()));
        eucCsvEntity.set認定開始日(edit年月日_yyyymmdd(entity.get受給者台帳_認定有効期間開始年月日()));
        eucCsvEntity.set認定終了日(edit年月日_yyyymmdd(entity.get受給者台帳_認定有効期間終了年月日()));
        eucCsvEntity.set認定日(edit年月日_yyyymmdd(entity.get受給者台帳_認定年月日()));
        eucCsvEntity.set旧措置(edit旧措置(entity.is受給者台帳_旧措置者フラグ()));
        eucCsvEntity.setみなし更新認定(editみなし更新(entity.get受給者台帳_みなし要介護区分コード()));

        eucCsvEntity.set指定サービス種類(edit指定サービス種類(entity.get受給者台帳_指定サービス種類01(),
                entity.get受給者台帳_指定サービス種類02(),
                entity.get受給者台帳_指定サービス種類03(),
                entity.get受給者台帳_指定サービス種類04(),
                entity.get受給者台帳_指定サービス種類05(),
                entity.get受給者台帳_指定サービス種類06()
        ));
        eucCsvEntity.set受給喪失日(edit年月日_yyyymmdd(entity.get受給者台帳_喪失年月日()));
        eucCsvEntity.set直近事由(entity.get受給者台帳_直近異動事由コード());
        eucCsvEntity.set受給状況(edit受給状況(entity.get受給者台帳_有効無効区分()));
        eucCsvEntity.set異動事由コード(edit異動事由コード(entity.get受給者台帳_データ区分()));
        eucCsvEntity.set異動事由追加文(entity.get受給者台帳_異動理由());
        eucCsvEntity.set削除理由コード(entity.get受給者台帳_削除事由コード());
        eucCsvEntity.set異動事由文言(edit異動事由文言(entity.get受給者台帳_直近異動事由コード()));
        eucCsvEntity.set削除理由文言(entity.get受給者台帳_削除事由コード());
        eucCsvEntity.set支援申請区分(edit支援申請区分(entity.get受給者台帳_要支援者認定申請区分()));

        eucCsvEntity.set訪問支給限度額単位数(entity.get受給者台帳_支給限度単位数());
        eucCsvEntity.set訪問支給限度有効開始年月日(edit年月日_yyyymmdd(entity.get受給者台帳_支給限度有効開始年月日()));
        eucCsvEntity.set訪問支給限度有効終了年月日(edit年月日_yyyymmdd(entity.get受給者台帳_支給限度有効終了年月日()));
        eucCsvEntity.set短期入所支給限度日数(entity.get受給者台帳_短期入所支給限度日数());
        eucCsvEntity.set短期入所支給限度有効開始年月日(edit年月日_yyyymmdd(entity.get受給者台帳_短期入所支給限度開始年月日()));
        eucCsvEntity.set短期入所支給限度有効終了年月日(edit年月日_yyyymmdd(entity.get受給者台帳_短期入所支給限度終了年月日()));
        eucCsvEntity.set当初認定有効開始年月日(edit年月日_yyyymmdd(entity.get受給者台帳_当初認定有効開始年月日()));
        eucCsvEntity.set当初認定有効終了年月日(edit年月日_yyyymmdd(entity.get受給者台帳_当初認定有効終了年月日()));

        eucCsvEntity.set受給資格証明書発行日１(edit年月日_yyyymmdd(entity.get受給者台帳_受給資格証明書発行年月日１()));
        eucCsvEntity.set受給資格証明書発行日２(edit年月日_yyyymmdd(entity.get受給者台帳_受給資格証明書発行年月日２()));
        eucCsvEntity.set資格取得前申請区分(edit資格取得前申請区分(entity.is受給者台帳_資格取得前申請フラグ()));
        eucCsvEntity.set一次判定結果_重み(RString.EMPTY);

    }

    private void set今回申請届出について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回申請届出
        eucCsvEntity.set申請氏名(entity.get今回申請届出_申請届出者氏名());
        eucCsvEntity.set申請氏名カナ(entity.get今回申請届出_申請届出者氏名カナ());
        eucCsvEntity.set申請者郵便番号(edit郵便番号(entity.get今回申請届出_申請届出者郵便番号()));

        eucCsvEntity.set申請住所(entity.get今回申請届出_申請届出者住所());
        eucCsvEntity.set申請連絡先(entity.get今回申請届出_申請届出者電話番号());
        eucCsvEntity.set申請事業コード(entity.get今回申請届出_申請届出代行事業者番号());
    }

    private void set申請届出事業者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //申請届出事業者
        eucCsvEntity.set申請代行事業者名(entity.get申請届出事業者_事業者名称());
        eucCsvEntity.set申請代行事業者名カナ(entity.get申請届出事業者_事業者名称カナ());
    }

    private void set今回申請について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回申請
        eucCsvEntity.set調査委託先コード(entity.get今回申請_認定調査委託先コード());
        eucCsvEntity.set調査員コード(entity.get今回申請_認定調査員コード());

        eucCsvEntity.set医療機関コード(entity.get今回申請_主治医医療機関コード());
        eucCsvEntity.set主治医コード(entity.get今回申請_主治医コード());

        eucCsvEntity.set認定延期通知書発行年月日(edit年月日_yyyymmdd(entity.get今回申請_延期通知発行年月日()));
        eucCsvEntity.set認定延期通知書発行回数(entity.get今回申請_延期通知発行回数());
        eucCsvEntity.set延期処理見込み開始年月日(edit年月日_yyyymmdd(entity.get今回申請_延期見込期間開始年月日()));
        eucCsvEntity.set延期処理見込み終了年月日(edit年月日_yyyymmdd(entity.get今回申請_延期見込期間終了年月日()));
        eucCsvEntity.set指定医区分(edit指定医区分(entity.is今回申請_指定医フラグ()));
        entity.get今回一次判定結果_要介護認定一次判定結果コード();

//        eucCsvEntity.set一次判定要介護度(edit要介護度(KoroshoInterfaceShikibetsuCode.toValue(entity.get今回申請_厚労省IF識別コード()),
//                entity.get今回一次判定結果_要介護認定一次判定結果コード()));
//        eucCsvEntity.set要介護度(edit要介護度(KoroshoInterfaceShikibetsuCode.toValue(entity.get今回申請_厚労省IF識別コード()),
//                entity.get受給者台帳_要介護認定状態区分コード()));
    }

    private void set今回調査委託先について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回調査委託先
        eucCsvEntity.set委託先名(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set委託先名カナ(entity.get今回調査委託先_事業者名称カナ());
        eucCsvEntity.set委託先代表者名(entity.get今回調査委託先_代表者名());
        eucCsvEntity.set委託先代表者名カナ(entity.get今回調査委託先_代表者名カナ());
        eucCsvEntity.set委託先郵便番号(edit郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set委託先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set委託先連絡先(entity.get今回調査委託先_電話番号());
        if (entity.is今回調査委託先_状況フラグ()) {
            eucCsvEntity.set委託先状況(TRUE);
        } else {
            eucCsvEntity.set委託先状況(FALSE);
        }
        eucCsvEntity.set訪問調査先郵便番号(edit郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set訪問調査先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set訪問調査先名称(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set訪問調査先電話番号(entity.get今回調査委託先_電話番号());
    }

    private void set今回調査員について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {

        //今回調査員
        eucCsvEntity.set調査員氏名(entity.get今回調査員_調査員氏名());
        eucCsvEntity.set調査員氏名カナ(entity.get今回調査員_調査員氏名カナ());
        eucCsvEntity.set調査員性別(entity.get今回調査員_性別());
        eucCsvEntity.set調査員郵便(edit郵便番号(entity.get今回調査員_郵便番号()));
        eucCsvEntity.set調査員住所(entity.get今回調査員_住所());
        eucCsvEntity.set調査員連絡先(entity.get今回調査員_電話番号());
        eucCsvEntity.set調査員資格(entity.get今回調査員_調査員資格());
        eucCsvEntity.set調査員所属機関名(entity.get今回調査員_所属機関名称());
        if (entity.is今回調査員_状況フラグ()) {
            eucCsvEntity.set調査員状況(TRUE);
        } else {
            eucCsvEntity.set調査員状況(FALSE);
        }
    }

    private void set今回主治医医療機関について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {

        //今回主治医医療機関
        eucCsvEntity.set医療機関名称(entity.get今回主治医医療機関_医療機関名称());
        eucCsvEntity.set医療機関名称カナ(entity.get今回主治医医療機関_医療機関名称カナ());
        eucCsvEntity.set医療機関代表者名(entity.get今回主治医医療機関_代表者名());
        eucCsvEntity.set医療機関代表者名カナ(entity.get今回主治医医療機関_代表者名カナ());
        eucCsvEntity.set医療機関郵便番号(edit郵便番号(entity.get今回主治医医療機関_郵便番号()));
        eucCsvEntity.set医療機関住所(entity.get今回主治医医療機関_住所());
        eucCsvEntity.set医療機関連絡先(entity.get今回主治医医療機関_電話番号());
        eucCsvEntity.set医療機関状況(edit状況(entity.is今回主治医医療機関_状況フラグ()));
    }

    private void set今回主治医について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {

        //今回主治医
        eucCsvEntity.set主治医名(entity.get今回主治医_主治医氏名());
        eucCsvEntity.set主治医名カナ(entity.get今回主治医_主治医カナ());
        eucCsvEntity.set主治医性別(entity.get今回主治医_性別());
        eucCsvEntity.set主治医所属(entity.get今回主治医_診療科名称());
        eucCsvEntity.set主治医状況(edit状況(entity.is今回主治医_状況フラグ()));
    }

    private void set今回調査依頼について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回調査依頼
        eucCsvEntity.set調査委託日(edit年月日_yyyymmdd(entity.get今回調査依頼_認定調査依頼年月日()));
    }

    private void set今回計画情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回計画情報
        eucCsvEntity.set調査予定日(edit年月日_yyyymmdd(entity.get今回計画情報_認定調査予定年月日()));
        eucCsvEntity.set意見予定日(edit年月日_yyyymmdd(entity.get今回計画情報_主治医意見書登録予定年月日()));
        eucCsvEntity.set審査予定日(edit年月日_yyyymmdd(entity.get今回計画情報_認定審査会予定年月日()));

    }

    private void set今回完了情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回完了情報
        eucCsvEntity.set調査終了日(edit年月日_yyyymmdd(entity.get今回完了情報_認定調査完了年月日()));
    }

    private void set今回意見書作成依頼について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回意見書作成依頼
        eucCsvEntity.set意見依頼日(edit年月日_yyyymmdd(entity.get今回意見書作成依頼_主治医意見書作成依頼年月日()));
    }

    private void set今回意見書情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回意見書情報
        eucCsvEntity.set意見取寄日(edit年月日_yyyymmdd(entity.get今回意見書情報_主治医意見書受領年月日()));
    }

    private void set今回一次判定結果について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回一次判定結果
        eucCsvEntity.set一次判定日(edit年月日_yyyymmdd(entity.get今回一次判定結果_要介護認定一次判定年月日()));
    }

    private void set今回結果情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回結果情報
        eucCsvEntity.set資料作成日(edit年月日_yyyymmdd(entity.get今回結果情報_介護認定審査会資料作成年月日()));
        eucCsvEntity.set審査会意見(entity.get今回結果情報_介護認定審査会意見());
    }

    private void set初回受給情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //初回受給情報
        eucCsvEntity.set初回申請日(edit年月日_yyyymmdd(entity.get初回受給情報_受給申請年月日()));
        eucCsvEntity.set初回認定日(edit年月日_yyyymmdd(entity.get初回受給情報_認定年月日()));

//        eucCsvEntity.set初回要介護度(edit要介護度(KoroshoInterfaceShikibetsuCode.toValue(entity.get初回申請_厚労省IF識別コード()),
//                entity.get初回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set初回認定開始日(edit年月日_yyyymmdd(entity.get初回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set初回認定終了日(edit年月日_yyyymmdd(entity.get初回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set初回申請事由(edit受給申請事由(entity.get初回受給情報_受給申請事由(), entity.get初回申請_要支援者認定申請区分()));
        eucCsvEntity.set初回みなし更新(entity.get初回受給情報_みなし要介護区分コード());
        eucCsvEntity.set初回当初認定有効開始日(edit年月日_yyyymmdd(entity.get初回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set初回当初認定有効終了日(edit年月日_yyyymmdd(entity.get初回受給情報_当初認定有効終了年月日()));
    }

    private void set初回申請について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //初回申請
        eucCsvEntity.set初回支援申請事由(edit支援申請事由(new Code(entity.get初回申請_要支援者認定申請区分())));
    }

    private void set前回受給情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //前回受給情報
        eucCsvEntity.set前回申請日(edit年月日_yyyymmdd(entity.get前回受給情報_受給申請年月日()));
        eucCsvEntity.set前回認定日(edit年月日_yyyymmdd(entity.get前回受給情報_認定年月日()));
//        eucCsvEntity.set前回要介護度(edit要介護度(KoroshoInterfaceShikibetsuCode.toValue(entity.get前回申請_厚労省IF識別コード()),
//                entity.get前回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前回認定開始日(edit年月日_yyyymmdd(entity.get前回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set前回認定終了日(edit年月日_yyyymmdd(entity.get前回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set前回受給申請事由(edit受給申請事由(entity.get前回受給情報_受給申請事由(),
                entity.get前回申請_要支援者認定申請区分()));
        eucCsvEntity.set前回みなし更新(entity.get前回受給情報_みなし要介護区分コード());
        eucCsvEntity.set前回当初認定有効開始日(edit年月日_yyyymmdd(entity.get前回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set前回当初認定有効終了日(edit年月日_yyyymmdd(entity.get前回受給情報_当初認定有効終了年月日()));
    }

    private void set前回申請について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //前回申請
        // eucCsvEntity.set前回支援申請事由(edit支援申請事由(new Code(entity.get前回申請_要支援者認定申請区分())));
    }

    private void set前々回受給情報について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //前々回受給情報
        eucCsvEntity.set前々回申請日(edit年月日_yyyymmdd(entity.get前々回受給情報_受給申請年月日()));
        eucCsvEntity.set前々回認定日(edit年月日_yyyymmdd(entity.get前々回受給情報_認定年月日()));
        eucCsvEntity.set前々回要介護度(edit要介護度(KoroshoInterfaceShikibetsuCode.toValue(entity.get前々回申請_厚労省IF識別コード()),
                entity.get前々回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前々回認定開始日(edit年月日_yyyymmdd(entity.get前々回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set前々回認定終了日(edit年月日_yyyymmdd(entity.get前々回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set前々回受給申請事由(edit受給申請事由(entity.get前々回受給情報_受給申請事由(),
                entity.get前々回申請_要支援者認定申請区分()));
        eucCsvEntity.set前々回みなし更新(editみなし更新(entity.get前々回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set前々回当初認定有効開始日(edit年月日_yyyymmdd(entity.get前々回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set前々回当初認定有効終了日(edit年月日_yyyymmdd(entity.get前々回受給情報_当初認定有効終了年月日()));
        eucCsvEntity.set前々回支援申請事由(edit支援申請区分(entity.get前々回受給情報_要支援者認定申請区分()));
    }

    private void set今回調査結果_基本について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //今回調査結果_基本
        eucCsvEntity.set障害高齢者自立度(edit障害高齢者自立度(entity.get今回調査結果_基本_認定調査_障害高齢者の日常生活自立度コード()));
        eucCsvEntity.set認知症高齢者自立度(edit認知症高齢者自立度(entity.get今回調査結果_基本_認定調査_認知症高齢者の日常生活自立度コード()));
    }

    private void set介護保険施設入退所について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //介護保険施設入退所
        eucCsvEntity.set指定事業者コード(entity.get施設入所_入所施設コード());
        eucCsvEntity.set施設入所日(edit年月日_yyyymmdd(entity.get施設入所_入所年月日()));
        eucCsvEntity.set施設退所日(edit年月日_yyyymmdd(entity.get施設入所_退所年月日()));
        //この項目は実装外
        eucCsvEntity.set転出先保険者番号(RString.EMPTY);

    }

    private void set居宅届出について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //居宅届出
        eucCsvEntity.set届出区分(edit届出区分(entity.get居宅届出_届出区分()));
        eucCsvEntity.set計画届出日(edit年月日_yyyymmdd(entity.get居宅届出_届出年月日()));
    }

    private void set事業者作成について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //事業者作成
        eucCsvEntity.set居宅計画作成区分(edit居宅計画作成区分(entity.get事業者作成_作成区分コード()));
        eucCsvEntity.set計画事業者番号(entity.get事業者作成_計画事業者番号());
        eucCsvEntity.set計画適用開始日(edit年月日_yyyymmdd(entity.get事業者作成_適用開始年月日()));
        eucCsvEntity.set計画適用終了日(edit年月日_yyyymmdd(entity.get事業者作成_適用終了年月日()));
    }

    private void set計画事業者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //計画事業者
        eucCsvEntity.set計画事業者名(entity.get計画事業者_事業者名称());
        eucCsvEntity.set計画事業者カナ(entity.get計画事業者_事業者名称カナ());
    }

    private void set計画事業者代表者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //計画事業者代表者
        eucCsvEntity.set計画管理者名(entity.get計画事業者代表者_代表者名());
        eucCsvEntity.set計画管理者カナ(entity.get計画事業者代表者_代表者名カナ());
    }

    private void set自己作成について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //自己作成
        eucCsvEntity.set計画作成日(edit年月日_yyyymmdd(entity.get自己作成_計画作成年月日()));
        eucCsvEntity.set計画変更日(edit年月日_yyyymmdd(entity.get自己作成_計画変更年月日()));
        eucCsvEntity.set変更理由(entity.get自己作成_計画変更事由());
    }

    private void set指定事業者について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //指定事業者
        if (is入所施設種類_11(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者代表者名(entity.get指定事業者代表者_代表者名());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get指定事業者代表者_代表者名カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get指定事業者代表者_代表者役職名());

            eucCsvEntity.set指定事業者名(entity.get指定事業者_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get指定事業者_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(edit郵便番号(entity.get指定事業者_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get指定事業者_事業者住所());
            eucCsvEntity.set指定事業者電話番号(entity.get指定事業者_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get指定事業者_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(entity.get指定事業者_所属人数());
            eucCsvEntity.set指定事業者利用者数(entity.get指定事業者_利用者数());
            eucCsvEntity.set指定事業者認定日(edit年月日_yyyymmdd(entity.get指定事業者_有効開始日()));
            eucCsvEntity.set指定事業者取消日(edit年月日_yyyymmdd(entity.get指定事業者_有効終了日()));
            eucCsvEntity.set指定事業者実施地域(entity.get指定事業者_サービス実施地域());

        }
    }

    private void set除外他特適用施設について(GeneralPurposeListOutputEucCsvEntity eucCsvEntity,
            GeneralPurposeListOutputEntity entity) {
        //除外他特適用施設
        if (is入所施設種類_12_21(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者名(entity.get除外他特適用施設_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get除外他特適用施設_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(edit郵便番号(entity.get除外他特適用施設_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get除外他特適用施設_事業者住所());
            eucCsvEntity.set指定事業者代表者名(entity.get除外他特適用施設_代表者名称());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get除外他特適用施設_代表者名称カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get除外他特適用施設_役職());
            eucCsvEntity.set指定事業者電話番号(entity.get除外他特適用施設_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get除外他特適用施設_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            eucCsvEntity.set指定事業者利用者数(RString.EMPTY);
            eucCsvEntity.set指定事業者認定日(edit年月日_yyyymmdd(entity.get除外他特適用施設_有効開始年月日()));
            eucCsvEntity.set指定事業者取消日(edit年月日_yyyymmdd(entity.get除外他特適用施設_有効終了年月日()));
            eucCsvEntity.set指定事業者実施地域(RString.EMPTY);
        }
    }

    private RString edit年月日_yyyymmdd(FlexibleDate date) {

        if (date == null || FlexibleDate.EMPTY.equals(date)) {
            return RString.EMPTY;
        }

        if (processParamter.is日付スラッシュ付加()) {
            if (!FlexibleDate.EMPTY.equals(date)) {
                StringBuilder builder = new StringBuilder();
                builder.append(date.getYearMonth());
                builder.append(date.getDayValue());

                return new RString(builder.toString());
            }
            if (!FlexibleDate.EMPTY.equals(date)) {
                return new RString(date.toString());
            }
            return RString.EMPTY;
        }
        return new RString(date.toString());
    }

    private RString edit月日_yyyymm(FlexibleDate date) {

        if (processParamter.is日付スラッシュ付加()) {
            if (!FlexibleDate.EMPTY.equals(date)) {
                return date.getYearMonth().toDateString();
            }
            return RString.EMPTY;
        }
        if (!FlexibleDate.EMPTY.equals(date)) {
            return date.getYearMonth().toDateString();
        }
        return RString.EMPTY;
    }

    private RString get住所_番地_方書(RString 住所, RString 番地, RString 方書) {

        StringBuilder builder = new StringBuilder();
        if (!住所.isNullOrEmpty()) {
            builder.append(住所);
        }
        if (!番地.isNullOrEmpty()) {
            builder.append(番地);
        }
        builder.append(RString.FULL_SPACE);
        if (!方書.isNullOrEmpty()) {
            builder.append(方書);
        }
        return new RString(builder.toString());
    }

    private RString edit届出区分(RString todokedeKubun) {
        if (届出区分_1.equals(todokedeKubun)) {
            return 新規;
        } else if (届出区分_2.equals(todokedeKubun)) {
            return 変更;
        } else if (届出区分_3.equals(todokedeKubun)) {
            return 暫定;
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit住所地特例フラグ(RString jushochiTokureiFlag) {
        if (住所地特例フラグ_TRUE.equals(jushochiTokureiFlag)) {
            return 住特;
        }
        return RString.EMPTY;
    }

    private RString edit状況(boolean jokyoFlag) {
        if (jokyoFlag) {
            return 有効;
        }
        return 無効;
    }

    private RString edit資格取得前申請区分(boolean shikakuShutokuMaeShinseiFlag) {
        if (shikakuShutokuMaeShinseiFlag) {
            return 資格取得前申請区分_資格取得前申請;
        }
        return RString.EMPTY;
    }

    private RString edit指定医区分(boolean shiteiiFlag) {
        if (shiteiiFlag) {
            return 指定医区分_指定医;
        }
        return RString.EMPTY;
    }

    private boolean is入所施設種類_11(RString nyushoShisetsuShurui) {
        return 入所施設種類_11.equals(nyushoShisetsuShurui);
    }

    private boolean is入所施設種類_12_21(RString nyushoShisetsuShurui) {
        return 入所施設種類_12.equals(nyushoShisetsuShurui) || 入所施設種類_21.equals(nyushoShisetsuShurui);
    }

    private RString edit要介護度(KoroshoInterfaceShikibetsuCode koroshoIfCode, RString code) {
        return YokaigoJotaiKubunSupport.toValue(koroshoIfCode, code).getName();
    }

    private List<RString> get出力条件表() {
        List<RString> list = new ArrayList<>();
        AtenaSelectBatchParameter atenaSelectBatchParameter = processParamter.get宛名抽出条件();
        NenreiSoChushutsuHoho nenreiSoChushutsuHoho = atenaSelectBatchParameter.getAgeSelectKijun();

        if (!atenaSelectBatchParameter.getShichoson_Code().getColumnValue().isNullOrEmpty()
                && すべて.equals(atenaSelectBatchParameter.getShichoson_Code().getColumnValue())) {
            list.add(出力条件表_保険者.concat(地方公共団体情報.get地方公共団体コード().code市町村RString()));
        }

        if (processParamter.get基準日() != null) {
            list.add(出力条件表_基準日.concat(processParamter.get基準日().toString()));
        }

        if (processParamter.get日付範囲From() != null && processParamter.get日付範囲To() != null) {
            list.add(processParamter.get抽出項目区分().concat(processParamter.get日付範囲From().toString()).concat(出力条件表_中間符号)
                    .concat(processParamter.get日付範囲To().toString()));
        }
        if (processParamter.get日付範囲From() != null && processParamter.get日付範囲To() == null) {
            list.add(processParamter.get抽出項目区分().concat(processParamter.get日付範囲From().toString()).concat(出力条件表_中間符号));
        }
        if (processParamter.get日付範囲From() == null && processParamter.get日付範囲To() != null) {
            list.add(出力条件表_取得日.concat(出力条件表_中間符号).concat(RString.HALF_SPACE).concat(processParamter.get日付範囲To().toString()));
        }

        if (processParamter.is直近データ抽出()) {
            list.add(出力条件表_対象データ_直近のみ);
        }

        if (!processParamter.get喪失区分().isNullOrEmpty() && !資格判定なし.equals(processParamter.get喪失区分())) {
            list.add(出力条件表_喪失区分.concat(processParamter.get喪失区分()));
        }

        set出力条件表_年齢(atenaSelectBatchParameter, nenreiSoChushutsuHoho, list);
        set出力条件表_生年月日(atenaSelectBatchParameter, nenreiSoChushutsuHoho, list);
        set出力条件表_地区選択(atenaSelectBatchParameter, list);
        return list;
    }

    private void set出力条件表_年齢(AtenaSelectBatchParameter atenaSelectBatchParameter,
            NenreiSoChushutsuHoho nenreiSoChushutsuHoho,
            List<RString> list) {
        if (年齢.equals(nenreiSoChushutsuHoho.get名称())) {
            Range<Decimal> ageRange = atenaSelectBatchParameter.getNenreiRange();
            Decimal startAge = ageRange.getFrom();
            Decimal endAge = ageRange.getTo();

            if (Decimal.ZERO != startAge && Decimal.ZERO != endAge) {
                list.add(出力条件表_年齢
                        .concat(startAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(endAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_左丸括弧)
                        .concat(出力条件表_年齢基準日)
                        .concat(processParamter.get基準日().toString())
                        .concat(出力条件表_右丸括弧));
            }
            if (Decimal.ZERO != startAge && Decimal.ZERO == endAge) {
                list.add(出力条件表_年齢
                        .concat(startAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_左丸括弧)
                        .concat(出力条件表_年齢基準日)
                        .concat(processParamter.get基準日().toString())
                        .concat(出力条件表_右丸括弧));
            }

            if (Decimal.ZERO == startAge && Decimal.ZERO != endAge) {
                list.add(出力条件表_年齢
                        .concat(endAge.toString())
                        .concat(出力条件表_歳)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_左丸括弧)
                        .concat(出力条件表_年齢基準日)
                        .concat(processParamter.get基準日().toString())
                        .concat(出力条件表_右丸括弧));
            }
        }
    }

    private void set出力条件表_生年月日(AtenaSelectBatchParameter atenaSelectBatchParameter,
            NenreiSoChushutsuHoho nenreiSoChushutsuHoho,
            List<RString> list) {
        if (生年月日.equals(nenreiSoChushutsuHoho.get名称())) {
            Range<RDate> seinengappiRange = atenaSelectBatchParameter.getSeinengappiRange();
            RDate startSeinengappiRange = seinengappiRange.getFrom();
            RDate endSeinengappiRange = seinengappiRange.getFrom();
            if (startSeinengappiRange != null && endSeinengappiRange != null) {
                list.add(出力条件表_生年月日
                        .concat(startSeinengappiRange.toDateString())
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(出力条件表_HALF_SPACE)
                        .concat(endSeinengappiRange.toDateString()));
            }
            if (startSeinengappiRange != null && endSeinengappiRange == null) {
                list.add(出力条件表_生年月日
                        .concat(startSeinengappiRange.toDateString())
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号));
            }
            if (startSeinengappiRange == null && endSeinengappiRange != null) {
                list.add(出力条件表_生年月日
                        .concat(出力条件表_HALF_SPACE)
                        .concat(出力条件表_中間符号)
                        .concat(endSeinengappiRange.toDateString()));
            }
        }
    }

    private void set出力条件表_地区選択(AtenaSelectBatchParameter atenaSelectBatchParameter, List<RString> list) {
        if (atenaSelectBatchParameter.getChiku_Kubun() != null && 全て.equals(atenaSelectBatchParameter.getChiku_Kubun().get名称())) {

            list.add(出力条件表_住所.concat(edit地区選択(atenaSelectBatchParameter.getJusho_From(), atenaSelectBatchParameter.getJusho_To())));
            list.add(出力条件表_行政区.concat(edit地区選択(atenaSelectBatchParameter.getGyoseiku_From(), atenaSelectBatchParameter.getGyoseiku_To())));
            list.add(出力条件表_地区１.concat(edit地区選択(atenaSelectBatchParameter.getChiku1_From(), atenaSelectBatchParameter.getChiku1_To())));
            list.add(出力条件表_地区２.concat(edit地区選択(atenaSelectBatchParameter.getChiku2_From(), atenaSelectBatchParameter.getChiku2_To())));
            list.add(出力条件表_地区３.concat(edit地区選択(atenaSelectBatchParameter.getChiku3_From(), atenaSelectBatchParameter.getChiku3_To())));
        }
    }

    private RString edit地区選択(RString from, RString to) {

        RString 地区選択Str = RString.EMPTY;
        if (!from.isNullOrEmpty() && !to.isNullOrEmpty()) {
            地区選択Str = from
                    .concat(出力条件表_HALF_SPACE)
                    .concat(出力条件表_中間符号)
                    .concat(出力条件表_HALF_SPACE)
                    .concat(to);
        }
        if (!from.isNullOrEmpty() && to.isNullOrEmpty()) {
            地区選択Str = from
                    .concat(出力条件表_HALF_SPACE)
                    .concat(出力条件表_中間符号);
        }
        if (from.isNullOrEmpty() && !to.isNullOrEmpty()) {
            地区選択Str = 出力条件表_中間符号
                    .concat(出力条件表_HALF_SPACE)
                    .concat(to);
        }
        return 地区選択Str;
    }

    private RString getコードマスタ(CodeShubetsu コード種別, Code コード) {
        return CodeMaster.getCodeRyakusho(コード種別, コード);
    }

    private RString edit受給申請事由(RString jukyuShinseiJiyu, RString shienShinseiKubun) {
        if (JukyuShinseiJiyu.初回申請.getコード().equals(jukyuShinseiJiyu)) {
            return 初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(jukyuShinseiJiyu)) {
            return 再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(jukyuShinseiJiyu)) {
            return 再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(jukyuShinseiJiyu)) {

            if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(shienShinseiKubun)) {
                return 支援から申請;
            }

            return 区分変更申請;
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(jukyuShinseiJiyu)) {
            return サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.getコード().equals(jukyuShinseiJiyu)) {
            return 施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.getコード().equals(jukyuShinseiJiyu)) {
            return 追加;
        }
        return RString.EMPTY;
    }

    private RString edit旧措置(boolean kyuSochishaFlag) {
        if (kyuSochishaFlag) {
            return 旧措置者;
        }
        return RString.EMPTY;
    }

    private RString edit支援申請区分(RString shienShinseiKubun) {

        if (要支援申請.equals(shienShinseiKubun)) {
            return 要支援申請;
        }
        return 要介護申請;
    }

    private RString edit支援申請事由(Code ninteiShinseiHoreiKubunCode) {

        if (NinteiShienShinseiKubun.認定支援申請.getコード().equals(ninteiShinseiHoreiKubunCode.getColumnValue())) {
            return 要支援申請;
        } else {
            return 要介護申請;
        }
    }

    private RString edit指定サービス種類(RString shiteiServiceShurui01,
            RString shiteiServiceShurui02,
            RString shiteiServiceShurui03,
            RString shiteiServiceShurui04,
            RString shiteiServiceShurui05,
            RString shiteiServiceShurui06) {

        StringBuilder builder = new StringBuilder();

        if (!shiteiServiceShurui01.isNullOrEmpty()) {
            builder.append(shiteiServiceShurui01.subSequence(INDEX_0, INDEX_2));
        }
        if (!shiteiServiceShurui02.isNullOrEmpty()) {
            builder.append(shiteiServiceShurui02.subSequence(INDEX_0, INDEX_2));
        }
        if (!shiteiServiceShurui03.isNullOrEmpty()) {
            builder.append(shiteiServiceShurui03.subSequence(INDEX_0, INDEX_2));
        }
        if (!shiteiServiceShurui04.isNullOrEmpty()) {
            builder.append(shiteiServiceShurui04.subSequence(INDEX_0, INDEX_2));
        }
        if (!shiteiServiceShurui05.isNullOrEmpty()) {
            builder.append(shiteiServiceShurui05.subSequence(INDEX_0, INDEX_2));
        }
        if (!shiteiServiceShurui06.isNullOrEmpty()) {
            builder.append(ETC);
        }
        return new RString(builder.toString());
    }

    private RString edit障害高齢者自立度(RString code) {
        RString result = RString.EMPTY;
        try {
            result = ShogaiNichijoSeikatsuJiritsudoCode.toValue(code).get名称();
        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    private RString edit認知症高齢者自立度(RString code) {
        RString result = RString.EMPTY;
        try {
            result = NinchishoNichijoSeikatsuJiritsudoCode.toValue(code).get名称();
        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    private RString edit居宅計画作成区分(RString sakuseiKubunCode) {
        if (sakuseiKubunCode == null) {
            return RString.EMPTY;
        }
        return KyotakuservicekeikakuSakuseikubunCode.toValue(sakuseiKubunCode).get名称();

    }

    private RString editみなし更新(RString minashiCode) {
        try {
            if (MinashiCode.通常の認定.getコード().equals(minashiCode)) {
                return RString.EMPTY;
            } else {
                return MinashiCode.toValue(minashiCode).get名称();
            }
        } catch (Exception ex) {
            return RString.EMPTY;
        }
    }

    private RString edit受給状況(RString yukoMukoKubun) {

        if (YukoMukoKubun.有効.getコード().equals(yukoMukoKubun)) {
            return 有効;
        } else if (YukoMukoKubun.無効.getコード().equals(yukoMukoKubun)) {
            return 無効;
        } else {
            return RString.EMPTY;
        }
    }

    private RString edit郵便番号(RString yubinNo) {

        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return new YubinNo(yubinNo).getEditedYubinNo();
    }

    private RString edit異動事由コード(RString dataKubun) {

        if (dataKubun == null) {
            return RString.EMPTY;
        }
        if (Datakubun.通常_認定.getコード().equals(dataKubun)) {
            return RString.EMPTY;
        }
        return Datakubun.toValue(dataKubun).get名称();
    }

    private RString edit異動事由文言(RString chokkinIdoJiyuCode) {
        if (ChokkinIdoJiyuCode.未登録.getコード().equals(chokkinIdoJiyuCode)) {
            return 未登録;
        } else if (ChokkinIdoJiyuCode.追加_認定.getコード().equals(chokkinIdoJiyuCode)) {
            return 追加_認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請認定.getコード().equals(chokkinIdoJiyuCode)) {
            return 要介護度変更申請認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請却下.getコード().equals(chokkinIdoJiyuCode)) {
            return 要介護度変更申請却下;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請認定.getコード().equals(chokkinIdoJiyuCode)) {
            return サービス種類変更申請認定;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請却下.getコード().equals(chokkinIdoJiyuCode)) {
            return サービス種類変更申請却下;
        } else if (ChokkinIdoJiyuCode.削除.getコード().equals(chokkinIdoJiyuCode)) {
            return 削除;
        } else if (ChokkinIdoJiyuCode.修正.getコード().equals(chokkinIdoJiyuCode)) {
            return 修正;
        } else if (ChokkinIdoJiyuCode.受給申請却下.getコード().equals(chokkinIdoJiyuCode)) {
            return 受給申請却下;
        } else if (ChokkinIdoJiyuCode.削除回復.getコード().equals(chokkinIdoJiyuCode)) {
            return 削除回復;
        } else if (ChokkinIdoJiyuCode.職権記載.getコード().equals(chokkinIdoJiyuCode)) {
            return 職権記載;
        } else if (ChokkinIdoJiyuCode.職権修正.getコード().equals(chokkinIdoJiyuCode)) {
            return 職権修正;
        } else if (ChokkinIdoJiyuCode.職権取消.getコード().equals(chokkinIdoJiyuCode)) {
            return 職権取消;
        } else if (ChokkinIdoJiyuCode.履歴修正.getコード().equals(chokkinIdoJiyuCode)) {
            return 履歴修正;
        }
        return RString.EMPTY;
    }
}
