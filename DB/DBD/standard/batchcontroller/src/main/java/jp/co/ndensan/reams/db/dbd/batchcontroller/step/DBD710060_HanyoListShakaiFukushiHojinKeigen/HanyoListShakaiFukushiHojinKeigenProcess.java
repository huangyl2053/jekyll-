/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710060_HanyoListShakaiFukushiHojinKeigen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist.homon.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyukyotsu.Kyakasha;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.DBD710060.HanyoListShakaiFukushiHojinKeigenProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutoshakaifukushihojinkeigen.ShakaiFukushiHojinKeigenEucCsvEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ChokkinIdoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.Datakubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.NinteiShienShinseiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.SakujoJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.ShinseishaKankeiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
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
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
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
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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
 * 汎用リスト出力(社会福祉法人軽減)_process処理クラスです。
 *
 * @reamsid_L DBD-3900-030 mawy
 */
public class HanyoListShakaiFukushiHojinKeigenProcess extends BatchProcessBase<ShakaiFukushiHojinKeigenEntity> {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701002");
    private static final RString 住所地特例 = new RString("住特");
    private static final RString 区分_0 = new RString("0");
    private static final RString 区分_1 = new RString("1");
    private static final RString 区分_2 = new RString("2");
    private static final RString 区分_3 = new RString("3");
    private static final RString CYUSYUTSUTAISYOSHA = new RString("【抽出対象者】");
    private static final RString HOKENSHA = new RString("保険者：");
    private static final RString NENDO = new RString("年度：");
    private static final RString KIZYUNNICHI = new RString("基準日：");
    private static final RString 直近のみ = new RString("対象データ：直近のみ");
    private static final RString 申請者のみ = new RString("対象データ：申請者のみ");
    private static final RString 利用者負担段階 = new RString("利用者負担段階：");
    private static final RString 直近_申請者のみ = new RString("対象データ：直近・申請者のみ");
    private static final RString 負担割合区分 = new RString("負担割合区分：");
    private static final RString FUTANWARIAI_1 = new RString("１割");
    private static final RString FUTANWARIAI_2 = new RString("２割");
    private static final RString CHIKI_1 = new RString("地区１");
    private static final RString CHIKI_2 = new RString("地区２");
    private static final RString CHIKI_3 = new RString("地区３");
    private static final RString GYOSEIKU = new RString("行政区");
    private static final RString JUSYO = new RString("住所");
    private static final RString NENLEI = new RString("年齢");
    private static final RString SEINENGAPPI = new RString("生年月日");
    private static final RString 初回申請 = new RString("初回申請　　");
    private static final RString 再申請内 = new RString("再申請内　　");
    private static final RString 再申請外 = new RString("再申請外　　");
    private static final RString 支援から申請 = new RString("支援から申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString サ変更申請 = new RString("サ変更申請　");
    private static final RString 施行前申請 = new RString("施行前申請　");
    private static final RString 追加 = new RString("追加　　　　");
    private static final RString ARI = new RString("有効");
    private static final RString MURI = new RString("無効");
    private static final RString 旧措置者 = new RString("旧措置者");
    private static final RString MINASHI = new RString("みなし");
    private static final RString 種類 = new RString(" etc.");
    private static final RString 要支援 = new RString("要支援申請");
    private static final RString 要介護 = new RString("要介護申請");
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
    private static final RString SHIKAKUSYUTOKU = new RString("資格取得前申請");
    private static final RString SHITEII = new RString("指定医");
    private static final RString 介護保険施設 = new RString("11");
    private static final RString 住所地特例対象施設 = new RString("12");
    private static final RString 適用除外施設 = new RString("21");
    private static final RString SHINKI = new RString("新規");
    private static final RString HENKO = new RString("変更");
    private static final RString ZATEI = new RString("暫定");
    private static final RString 却下 = new RString("却下");
    private static final RString 承認 = new RString("承認");
    private static final RString 居宅サービス限定 = new RString("居宅サービス限定");
    private static final RString 居住費_食費のみ = new RString("居住費・食費のみ");
    private static final RString 旧措置ユ個のみ = new RString("旧措置ユ個のみ");
    private static final RString 負担軽減者 = new RString("負担軽減者");
    private static final RString その他 = new RString("その他");
    private static final RString 法別区分 = new RString("法別区分：");
    private static final RString 却下者 = new RString("却下者：");
    private static final RString 喪失区分 = new RString("喪失区分：");
    private static final RString 第一段階 = new RString("第一段階");
    private static final RString 第二段階 = new RString("第二段階");
    private static final RString 第三段階 = new RString("第三段階");
    private static final RString 課税層第三段階 = new RString("課税層第三段階");
    private static final RString SAI = new RString("歳");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutoshakaifukushihojinkeigen."
            + "IHanyoRisutoShakaiFukushiHojinKeigenMapper.get汎用リスト");
    private static final RString SPACE = new RString(" ");
    private static final RString POINT = new RString("・");
    private static final RString COLON = new RString(":");
    private static final RString カラ = new RString("～");
    private static final RString 左記号 = new RString("(");
    private static final RString 右記号 = new RString(")");
    private FileSpoolManager manager;
    private RString eucFilePath;
    private HanyoListShakaiFukushiHojinKeigenProcessParameter processParamter;
    private CsvWriter<ShakaiFukushiHojinKeigenEucCsvEntity> eucCsvWriter;
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
                processParamter.toHanyoRisutoShakaiFukushiHoujinKeigenMybatisParameter(psmShikibetsuTaisho, psmAtesaki));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_ShakaiFukushiHojinKeigen.csv"));
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParamter.isCsvkomokumeifuka()).
                build();
    }

    @Override
    protected void process(ShakaiFukushiHojinKeigenEntity entity) {
        ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity = new ShakaiFukushiHojinKeigenEucCsvEntity();
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

    private ShakaiFukushiHojinKeigenEucCsvEntity setBlank() {
        ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity = new ShakaiFukushiHojinKeigenEucCsvEntity();
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
        eucCsvEntity.set医療保険種別(RString.EMPTY);
        eucCsvEntity.set医療保険番号(RString.EMPTY);
        eucCsvEntity.set医療保険者名(RString.EMPTY);
        eucCsvEntity.set医療保険記号番号(RString.EMPTY);
        eucCsvEntity.set特定疾病(RString.EMPTY);
        eucCsvEntity.set受給申請事由(RString.EMPTY);
        eucCsvEntity.set申請理由(RString.EMPTY);
        eucCsvEntity.set申請関係者(RString.EMPTY);
        eucCsvEntity.set本人関係(RString.EMPTY);
        eucCsvEntity.set申請氏名(RString.EMPTY);
        eucCsvEntity.set申請氏名カナ(RString.EMPTY);
        eucCsvEntity.set申請代行事業者名(RString.EMPTY);
        eucCsvEntity.set申請代行事業者名カナ(RString.EMPTY);
        eucCsvEntity.set申請者郵便番号(RString.EMPTY);
        eucCsvEntity.set申請住所(RString.EMPTY);
        eucCsvEntity.set申請連絡先(RString.EMPTY);
        eucCsvEntity.set申請事業コード(RString.EMPTY);
        eucCsvEntity.set受給申請日(RString.EMPTY);
        eucCsvEntity.set調査委託先コード(RString.EMPTY);
        eucCsvEntity.set調査員コード(RString.EMPTY);
        eucCsvEntity.set委託先名(RString.EMPTY);
        eucCsvEntity.set委託先名カナ(RString.EMPTY);
        eucCsvEntity.set委託先代表者名(RString.EMPTY);
        eucCsvEntity.set委託先代表者名カナ(RString.EMPTY);
        eucCsvEntity.set委託先郵便番号(RString.EMPTY);
        eucCsvEntity.set委託先住所(RString.EMPTY);
        eucCsvEntity.set委託先連絡先(RString.EMPTY);
        eucCsvEntity.set委託先状況(RString.EMPTY);
        eucCsvEntity.set調査員氏名(RString.EMPTY);
        eucCsvEntity.set調査員氏名カナ(RString.EMPTY);
        eucCsvEntity.set調査員性別(RString.EMPTY);
        eucCsvEntity.set調査員郵便(RString.EMPTY);
        eucCsvEntity.set調査員住所(RString.EMPTY);
        eucCsvEntity.set調査員連絡先(RString.EMPTY);
        eucCsvEntity.set調査員資格(RString.EMPTY);
        eucCsvEntity.set調査員所属機関名(RString.EMPTY);
        eucCsvEntity.set調査員状況(RString.EMPTY);
        eucCsvEntity.set医療機関コード(RString.EMPTY);
        eucCsvEntity.set主治医コード(RString.EMPTY);
        eucCsvEntity.set医療機関名称(RString.EMPTY);
        eucCsvEntity.set医療機関名称カナ(RString.EMPTY);
        eucCsvEntity.set医療機関代表者名(RString.EMPTY);
        eucCsvEntity.set医療機関代表者名カナ(RString.EMPTY);
        eucCsvEntity.set医療機関郵便番号(RString.EMPTY);
        eucCsvEntity.set医療機関住所(RString.EMPTY);
        eucCsvEntity.set医療機関連絡先(RString.EMPTY);
        eucCsvEntity.set医療機関状況(RString.EMPTY);
        eucCsvEntity.set主治医名(RString.EMPTY);
        eucCsvEntity.set主治医名カナ(RString.EMPTY);
        eucCsvEntity.set主治医性別(RString.EMPTY);
        eucCsvEntity.set主治医所属(RString.EMPTY);
        eucCsvEntity.set主治医状況(RString.EMPTY);
        eucCsvEntity.set一次判定要介護度(RString.EMPTY);
        eucCsvEntity.set調査委託日(RString.EMPTY);
        eucCsvEntity.set調査予定日(RString.EMPTY);
        eucCsvEntity.set調査終了日(RString.EMPTY);
        eucCsvEntity.set意見依頼日(RString.EMPTY);
        eucCsvEntity.set意見予定日(RString.EMPTY);
        eucCsvEntity.set意見取寄日(RString.EMPTY);
        eucCsvEntity.set資料作成日(RString.EMPTY);
        eucCsvEntity.set審査予定日(RString.EMPTY);
        eucCsvEntity.set審査回答日(RString.EMPTY);
        eucCsvEntity.set一次判定日(RString.EMPTY);
        eucCsvEntity.set要介護度(RString.EMPTY);
        eucCsvEntity.set認定開始日(RString.EMPTY);
        eucCsvEntity.set認定終了日(RString.EMPTY);
        eucCsvEntity.set認定日(RString.EMPTY);
        eucCsvEntity.set旧措置(RString.EMPTY);
        eucCsvEntity.setみなし更新認定(RString.EMPTY);
        eucCsvEntity.set審査会意見(RString.EMPTY);
        eucCsvEntity.set指定サービス種類(RString.EMPTY);
        eucCsvEntity.set受給喪失日(RString.EMPTY);
        eucCsvEntity.set直近事由(RString.EMPTY);
        setBlank2(eucCsvEntity);
        return eucCsvEntity;
    }

    private void setBlank2(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity) {
        eucCsvEntity.set受給状況(RString.EMPTY);
        eucCsvEntity.set異動事由コード(RString.EMPTY);
        eucCsvEntity.set異動事由追加文(RString.EMPTY);
        eucCsvEntity.set削除理由コード(RString.EMPTY);
        eucCsvEntity.set異動事由文言(RString.EMPTY);
        eucCsvEntity.set削除理由文言(RString.EMPTY);
        eucCsvEntity.set支援申請区分(RString.EMPTY);
        eucCsvEntity.set初回申請日(RString.EMPTY);
        eucCsvEntity.set初回認定日(RString.EMPTY);
        eucCsvEntity.set初回要介護度(RString.EMPTY);
        eucCsvEntity.set初回認定開始日(RString.EMPTY);
        eucCsvEntity.set初回認定終了日(RString.EMPTY);
        eucCsvEntity.set初回申請事由(RString.EMPTY);
        eucCsvEntity.set初回みなし更新(RString.EMPTY);
        eucCsvEntity.set初回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set初回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set初回支援申請事由(RString.EMPTY);
        eucCsvEntity.set前回申請日(RString.EMPTY);
        eucCsvEntity.set前回認定日(RString.EMPTY);
        eucCsvEntity.set前回要介護度(RString.EMPTY);
        eucCsvEntity.set前回認定開始日(RString.EMPTY);
        eucCsvEntity.set前回認定終了日(RString.EMPTY);
        eucCsvEntity.set前回受給申請事由(RString.EMPTY);
        eucCsvEntity.set前回みなし更新(RString.EMPTY);
        eucCsvEntity.set前回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set前回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set前回支援申請事由(RString.EMPTY);
        eucCsvEntity.set前々回申請日(RString.EMPTY);
        eucCsvEntity.set前々回認定日(RString.EMPTY);
        eucCsvEntity.set前々回要介護度(RString.EMPTY);
        eucCsvEntity.set前々回認定開始日(RString.EMPTY);
        eucCsvEntity.set前々回認定終了日(RString.EMPTY);
        eucCsvEntity.set前々回受給申請事由(RString.EMPTY);
        eucCsvEntity.set前々回みなし更新(RString.EMPTY);
        eucCsvEntity.set前々回当初認定有効開始日(RString.EMPTY);
        eucCsvEntity.set前々回当初認定有効終了日(RString.EMPTY);
        eucCsvEntity.set前々回支援申請事由(RString.EMPTY);
        eucCsvEntity.set障害高齢者自立度(RString.EMPTY);
        eucCsvEntity.set認知症高齢者自立度(RString.EMPTY);
        eucCsvEntity.set訪問支給限度額単位数(RString.EMPTY);
        eucCsvEntity.set訪問支給限度有効開始年月日(RString.EMPTY);
        eucCsvEntity.set訪問支給限度有効終了年月日(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度日数(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度有効開始年月日(RString.EMPTY);
        eucCsvEntity.set短期入所支給限度有効終了年月日(RString.EMPTY);
        eucCsvEntity.set当初認定有効開始年月日(RString.EMPTY);
        eucCsvEntity.set当初認定有効終了年月日(RString.EMPTY);
        eucCsvEntity.set認定延期通知書発行年月日(RString.EMPTY);
        eucCsvEntity.set認定延期通知書発行回数(RString.EMPTY);
        eucCsvEntity.set延期処理見込み開始年月日(RString.EMPTY);
        eucCsvEntity.set延期処理見込み終了年月日(RString.EMPTY);
        eucCsvEntity.set受給資格証明書発行日１(RString.EMPTY);
        eucCsvEntity.set受給資格証明書発行日２(RString.EMPTY);
        eucCsvEntity.set資格取得前申請区分(RString.EMPTY);
        eucCsvEntity.set一次判定結果重み(RString.EMPTY);
        eucCsvEntity.set指定医区分(RString.EMPTY);
        eucCsvEntity.set訪問調査先郵便番号(RString.EMPTY);
        eucCsvEntity.set訪問調査先住所(RString.EMPTY);
        eucCsvEntity.set訪問調査先名称(RString.EMPTY);
        eucCsvEntity.set訪問調査先電話番号(RString.EMPTY);
        eucCsvEntity.set指定事業者コード(RString.EMPTY);
        eucCsvEntity.set施設入所日(RString.EMPTY);
        eucCsvEntity.set施設退所日(RString.EMPTY);
        eucCsvEntity.set指定事業者名(RString.EMPTY);
        eucCsvEntity.set指定事業者名カナ(RString.EMPTY);
        eucCsvEntity.set指定事業者郵便番号(RString.EMPTY);
        eucCsvEntity.set指定事業者住所(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者名(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者名カナ(RString.EMPTY);
        eucCsvEntity.set指定事業者代表者役職(RString.EMPTY);
        eucCsvEntity.set指定事業者電話番号(RString.EMPTY);
        eucCsvEntity.set指定事業者ＦＡＸ番号(RString.EMPTY);
        eucCsvEntity.set指定事業者ケアマネ数(RString.EMPTY);
        eucCsvEntity.set指定事業者利用者数(RString.EMPTY);
        eucCsvEntity.set指定事業者認定日(RString.EMPTY);
        eucCsvEntity.set指定事業者取消日(RString.EMPTY);
        eucCsvEntity.set指定事業者実施地域(RString.EMPTY);
        eucCsvEntity.set転出先保険者番号(RString.EMPTY);
        eucCsvEntity.set確認番号(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減申請日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減決定日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減承認区分(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減開始日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減終了日(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減率(RString.EMPTY);
        eucCsvEntity.set社会福祉法人軽減事由(RString.EMPTY);
        eucCsvEntity.set居宅サービス区分(RString.EMPTY);
        eucCsvEntity.set居住費_食費限定区分(RString.EMPTY);
        eucCsvEntity.set旧措置ユニット型個室限定区分(RString.EMPTY);
        eucCsvEntity.set被保険者番号_総合事業対象者(RString.EMPTY);
        eucCsvEntity.set履歴番号(RString.EMPTY);
        eucCsvEntity.set事業適用開始日(RString.EMPTY);
        eucCsvEntity.set事業適用終了日(RString.EMPTY);
        eucCsvEntity.set事業チェック実施日(RString.EMPTY);
        eucCsvEntity.set事業決定日(RString.EMPTY);
        eucCsvEntity.set届出区分(RString.EMPTY);
        eucCsvEntity.set居宅計画作成区分(RString.EMPTY);
        eucCsvEntity.set計画事業者番号(RString.EMPTY);
        eucCsvEntity.set計画事業者名(RString.EMPTY);
        eucCsvEntity.set計画事業者カナ(RString.EMPTY);
        eucCsvEntity.set計画管理者名(RString.EMPTY);
        eucCsvEntity.set計画管理者カナ(RString.EMPTY);
        eucCsvEntity.set計画適用開始日(RString.EMPTY);
        eucCsvEntity.set計画適用終了日(RString.EMPTY);
        eucCsvEntity.set計画届出日(RString.EMPTY);
        eucCsvEntity.set計画作成日(RString.EMPTY);
        eucCsvEntity.set計画変更日(RString.EMPTY);
        eucCsvEntity.set変更理由(RString.EMPTY);
    }

    private void setEucCsvEntity(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity) {
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
        eucCsvEntity.set医療保険種別(set医療保険種別(entity.get医療保険加入状況_医療保険種別コード()));
        eucCsvEntity.set医療保険番号(entity.get医療保険加入状況_医療保険者番号());
        eucCsvEntity.set医療保険者名(entity.get医療保険加入状況_医療保険者名称());
        eucCsvEntity.set医療保険記号番号(entity.get医療保険加入状況_医療保険記号番号());
        eucCsvEntity.set特定疾病(RString.isNullOrEmpty(entity.get受給者台帳_２号特定疾病コード()) ? RString.EMPTY
                : TokuteiShippei.toValue(entity.get受給者台帳_２号特定疾病コード()).get名称());
        eucCsvEntity.set受給申請事由(set受給申請事由(entity.get受給者台帳_受給申請事由(), entity.get受給者台帳_要支援者認定申請区分()));
        eucCsvEntity.set申請理由(entity.get受給者台帳_申請理由());
        eucCsvEntity.set申請関係者(RString.isNullOrEmpty(entity.get受給者台帳_届出者申請者関係コード()) ? RString.EMPTY
                : ShinseishaKankeiCode.toValue(entity.get受給者台帳_届出者申請者関係コード()).get名称());
        eucCsvEntity.set本人関係(entity.get受給者台帳_届出者本人との関係());
        eucCsvEntity.set申請氏名(entity.get今回申請届出_申請届出者氏名());
        eucCsvEntity.set申請氏名カナ(entity.get今回申請届出_申請届出者氏名カナ());
        eucCsvEntity.set申請代行事業者名(entity.get申請届出事業者_事業者名称());
        eucCsvEntity.set申請代行事業者名カナ(entity.get申請届出事業者_事業者名称カナ());
        eucCsvEntity.set申請者郵便番号(set郵便番号(entity.get今回申請届出_申請届出者郵便番号()));
        eucCsvEntity.set申請住所(entity.get今回申請届出_申請届出者住所());
        eucCsvEntity.set申請連絡先(entity.get今回申請届出_申請届出者電話番号());
        eucCsvEntity.set申請事業コード(entity.get今回申請届出_申請届出代行事業者番号());
        eucCsvEntity.set受給申請日(set年月日(entity.get受給者台帳_受給申請年月日()));
        eucCsvEntity.set調査委託先コード(entity.get今回申請_認定調査委託先コード());
        eucCsvEntity.set調査員コード(entity.get今回申請_認定調査員コード());
        eucCsvEntity.set委託先名(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set委託先名カナ(entity.get今回調査委託先_事業者名称カナ());
        eucCsvEntity.set委託先代表者名(entity.get今回調査委託先_代表者名());
        eucCsvEntity.set委託先代表者名カナ(entity.get今回調査委託先_代表者名カナ());
        eucCsvEntity.set委託先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set委託先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set委託先連絡先(entity.get今回調査委託先_電話番号());
        eucCsvEntity.set委託先状況(entity.is今回調査委託先_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set調査員氏名(entity.get今回調査員_調査員氏名());
        eucCsvEntity.set調査員氏名カナ(entity.get今回調査員_調査員氏名カナ());
        eucCsvEntity.set調査員性別(set性別(entity.get今回調査員_性別()));
        eucCsvEntity.set調査員郵便(set郵便番号(entity.get今回調査員_郵便番号()));
        eucCsvEntity.set調査員住所(entity.get今回調査員_住所());
        eucCsvEntity.set調査員連絡先(entity.get今回調査員_電話番号());
        eucCsvEntity.set調査員資格(RString.isNullOrEmpty(entity.get今回調査員_調査員資格()) ? RString.EMPTY
                : Sikaku.toValue(entity.get今回調査員_調査員資格()).get名称());
        eucCsvEntity.set調査員所属機関名(entity.get今回調査員_所属機関名称());
        eucCsvEntity.set調査員状況(entity.is今回調査員_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set医療機関コード(entity.get今回申請_主治医医療機関コード());
        eucCsvEntity.set主治医コード(entity.get今回申請_主治医コード());
        eucCsvEntity.set医療機関名称(entity.get今回主治医医療機関_医療機関名称());
        eucCsvEntity.set医療機関名称カナ(entity.get今回主治医医療機関_医療機関名称カナ());
        eucCsvEntity.set医療機関代表者名(entity.get今回主治医医療機関_代表者名());
        eucCsvEntity.set医療機関代表者名カナ(entity.get今回主治医医療機関_代表者名カナ());
        eucCsvEntity.set医療機関郵便番号(set郵便番号(entity.get今回主治医医療機関_郵便番号()));
        eucCsvEntity.set医療機関住所(entity.get今回主治医医療機関_住所());
        eucCsvEntity.set医療機関連絡先(entity.get今回主治医医療機関_電話番号());
        eucCsvEntity.set医療機関状況(entity.is今回主治医医療機関_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set主治医名(entity.get今回主治医_主治医氏名());
        eucCsvEntity.set主治医名カナ(entity.get今回主治医_主治医カナ());
        eucCsvEntity.set主治医性別(set性別(entity.get今回主治医_性別()));
        eucCsvEntity.set主治医所属(entity.get今回主治医_診療科名称());
        eucCsvEntity.set主治医状況(entity.is今回主治医_状況フラグ() ? ARI : MURI);
        eucCsvEntity.set一次判定要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(),
                entity.get今回一次判定結果_要介護認定一次判定結果コード()));
        eucCsvEntity.set調査委託日(set年月日(entity.get今回調査依頼_認定調査依頼年月日()));
        eucCsvEntity.set調査予定日(set年月日(entity.get今回計画情報_認定調査予定年月日()));
        eucCsvEntity.set調査終了日(set年月日(entity.get今回完了情報_認定調査完了年月日()));
        setEucCsvEntity2(eucCsvEntity, entity);
    }

    private void setEucCsvEntity2(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity) {
        eucCsvEntity.set意見依頼日(set年月日(entity.get今回意見書作成依頼_主治医意見書作成依頼年月日()));
        eucCsvEntity.set意見予定日(set年月日(entity.get今回計画情報_主治医意見書登録予定年月日()));
        eucCsvEntity.set意見取寄日(set年月日(entity.get今回意見書情報_主治医意見書受領年月日()));
        eucCsvEntity.set資料作成日(set年月日(entity.get今回結果情報_介護認定審査会資料作成年月日()));
        eucCsvEntity.set審査予定日(set年月日(entity.get今回計画情報_認定審査会予定年月日()));
        eucCsvEntity.set審査回答日(set年月日(entity.get受給者台帳_認定年月日()));
        eucCsvEntity.set認定開始日(set年月日(entity.get受給者台帳_認定有効期間開始年月日()));
        eucCsvEntity.set認定終了日(set年月日(entity.get受給者台帳_認定有効期間終了年月日()));
        eucCsvEntity.set認定日(set年月日(entity.get受給者台帳_認定年月日()));
        eucCsvEntity.set旧措置(entity.is受給者台帳_旧措置者フラグ() ? 旧措置者 : RString.EMPTY);
        eucCsvEntity.setみなし更新認定(setみなし更新認定(entity.get受給者台帳_みなし要介護区分コード()));
        eucCsvEntity.set審査会意見(entity.get今回結果情報_介護認定審査会意見());
        RStringBuilder サービス種類 = new RStringBuilder();
        サービス種類.append(entity.get受給者台帳_指定サービス種類01())
                .append(entity.get受給者台帳_指定サービス種類01())
                .append(entity.get受給者台帳_指定サービス種類02())
                .append(entity.get受給者台帳_指定サービス種類03())
                .append(entity.get受給者台帳_指定サービス種類04())
                .append(entity.get受給者台帳_指定サービス種類05());
        if (!RString.isNullOrEmpty(entity.get受給者台帳_指定サービス種類06())) {
            サービス種類.append(種類);
        }
        eucCsvEntity.set指定サービス種類(サービス種類.toRString());
        eucCsvEntity.set受給喪失日(set年月日(entity.get受給者台帳_喪失年月日()));
        eucCsvEntity.set直近事由(entity.get受給者台帳_直近異動事由コード());
        eucCsvEntity.set受給状況(set受給状況(entity.get受給者台帳_有効無効区分()));
        eucCsvEntity.set異動事由コード(set異動事由コード(entity.get受給者台帳_データ区分()));
        eucCsvEntity.set異動事由追加文(entity.get受給者台帳_異動理由());
        eucCsvEntity.set削除理由コード(entity.get受給者台帳_削除事由コード());
        eucCsvEntity.set異動事由文言(set異動事由文言(entity.get受給者台帳_直近異動事由コード()));
        eucCsvEntity.set削除理由文言(set削除理由文言(entity.get受給者台帳_削除事由コード()));
        eucCsvEntity.set支援申請区分(set申請区分(entity.get受給者台帳_要支援者認定申請区分()));
        eucCsvEntity.set初回申請日(set年月日(entity.get初回受給情報_受給申請年月日()));
        eucCsvEntity.set初回認定日(set年月日(entity.get初回受給情報_認定年月日()));
        eucCsvEntity.set初回要介護度(set要介護度(entity.get初回申請_厚労省IF識別コード(),
                entity.get初回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set初回認定開始日(set年月日(entity.get初回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set初回認定終了日(set年月日(entity.get初回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set初回申請事由(set受給申請事由(entity.get初回受給情報_受給申請事由(), entity.get初回申請_要支援者認定申請区分()));
        eucCsvEntity.set初回みなし更新(setみなし更新認定(entity.get初回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set初回当初認定有効開始日(set年月日(entity.get初回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set初回当初認定有効終了日(set年月日(entity.get初回受給情報_当初認定有効終了年月日()));
        eucCsvEntity.set初回支援申請事由(set申請区分(entity.get初回申請_要支援者認定申請区分()));
        eucCsvEntity.set前回申請日(set年月日(entity.get前回受給情報_受給申請年月日()));
        eucCsvEntity.set前回認定日(set年月日(entity.get前回受給情報_認定年月日()));
        eucCsvEntity.set前回要介護度(set要介護度(entity.get前回申請_厚労省IF識別コード(),
                entity.get前回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前回認定開始日(set年月日(entity.get前回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set前回認定終了日(set年月日(entity.get前回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set前回受給申請事由(set受給申請事由(entity.get前回受給情報_受給申請事由(),
                entity.get前回申請_要支援者認定申請区分()));
        eucCsvEntity.set前回みなし更新(setみなし更新認定(entity.get前回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set前回当初認定有効開始日(set年月日(entity.get前回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set前回当初認定有効終了日(set年月日(entity.get前回受給情報_当初認定有効終了年月日()));
        eucCsvEntity.set前回支援申請事由(set申請区分(entity.get前回申請_要支援者認定申請区分()));
        eucCsvEntity.set前々回申請日(set年月日(entity.get前々回受給情報_受給申請年月日()));
        eucCsvEntity.set前々回認定日(set年月日(entity.get前々回受給情報_認定年月日()));
        eucCsvEntity.set前々回要介護度(set要介護度(entity.get前々回申請_厚労省IF識別コード(),
                entity.get前々回受給情報_要介護認定状態区分コード()));
        eucCsvEntity.set前々回認定開始日(set年月日(entity.get前々回受給情報_認定有効期間開始年月日()));
        eucCsvEntity.set前々回認定終了日(set年月日(entity.get前々回受給情報_認定有効期間終了年月日()));
        eucCsvEntity.set前々回受給申請事由(set受給申請事由(entity.get前々回受給情報_受給申請事由(),
                entity.get前々回申請_要支援者認定申請区分()));
        eucCsvEntity.set前々回みなし更新(setみなし更新認定(entity.get前々回受給情報_みなし要介護区分コード()));
        eucCsvEntity.set前々回当初認定有効開始日(set年月日(entity.get前々回受給情報_当初認定有効開始年月日()));
        eucCsvEntity.set前々回当初認定有効終了日(set年月日(entity.get前々回受給情報_当初認定有効終了年月日()));
        eucCsvEntity.set前々回支援申請事由(set申請区分(entity.get前々回受給情報_要支援者認定申請区分()));
        eucCsvEntity.set障害高齢者自立度(set障害高齢者自立度(entity.get今回調査結果_基本_認定調査_障害高齢者の日常生活自立度コード()));
        eucCsvEntity.set認知症高齢者自立度(set認知症高齢者自立度(entity.get今回調査結果_基本_認定調査_認知症高齢者の日常生活自立度コード()));
        eucCsvEntity.set訪問支給限度額単位数(entity.get受給者台帳_支給限度単位数());
        eucCsvEntity.set訪問支給限度有効開始年月日(set年月日(entity.get受給者台帳_支給限度有効開始年月日()));
        eucCsvEntity.set訪問支給限度有効終了年月日(set年月日(entity.get受給者台帳_支給限度有効終了年月日()));
        eucCsvEntity.set短期入所支給限度日数(entity.get受給者台帳_短期入所支給限度日数());
        eucCsvEntity.set短期入所支給限度有効開始年月日(set年月日(entity.get受給者台帳_短期入所支給限度開始年月日()));
        eucCsvEntity.set短期入所支給限度有効終了年月日(set年月日(entity.get受給者台帳_短期入所支給限度終了年月日()));
        eucCsvEntity.set当初認定有効開始年月日(set年月日(entity.get受給者台帳_当初認定有効開始年月日()));
        eucCsvEntity.set当初認定有効終了年月日(set年月日(entity.get受給者台帳_当初認定有効終了年月日()));
        eucCsvEntity.set認定延期通知書発行年月日(set年月日(entity.get今回申請_延期通知発行年月日()));
        eucCsvEntity.set認定延期通知書発行回数(entity.get今回申請_延期通知発行回数());
        eucCsvEntity.set延期処理見込み開始年月日(set年月日(entity.get今回申請_延期見込期間開始年月日()));
        eucCsvEntity.set延期処理見込み終了年月日(set年月日(entity.get今回申請_延期見込期間終了年月日()));
        eucCsvEntity.set受給資格証明書発行日１(set年月日(entity.get受給者台帳_受給資格証明書発行年月日１()));
        eucCsvEntity.set受給資格証明書発行日２(set年月日(entity.get受給者台帳_受給資格証明書発行年月日２()));
        eucCsvEntity.set資格取得前申請区分(entity.is受給者台帳_資格取得前申請フラグ() ? SHIKAKUSYUTOKU : RString.EMPTY);
        eucCsvEntity.set一次判定結果重み(RString.EMPTY);
        eucCsvEntity.set指定医区分(entity.is今回申請_指定医フラグ() ? SHITEII : RString.EMPTY);
        eucCsvEntity.set訪問調査先郵便番号(set郵便番号(entity.get今回調査委託先_郵便番号()));
        eucCsvEntity.set訪問調査先住所(entity.get今回調査委託先_住所());
        eucCsvEntity.set訪問調査先名称(entity.get今回調査委託先_事業者名称());
        eucCsvEntity.set訪問調査先電話番号(entity.get今回調査委託先_電話番号());
        eucCsvEntity.set指定事業者コード(entity.get施設入所_入所施設コード());
        eucCsvEntity.set施設入所日(set年月日(entity.get施設入所_入所年月日()));
        eucCsvEntity.set施設退所日(set年月日(entity.get施設入所_退所年月日()));
        set指定事業者(eucCsvEntity, entity);
        eucCsvEntity.set確認番号(entity.get社会福祉法人等利用者負担軽減_確認番号());
        eucCsvEntity.set社会福祉法人軽減申請日(set年月日(entity.get社会福祉法人等利用者負担軽減_申請年月日()));
        eucCsvEntity.set社会福祉法人軽減決定日(set年月日(entity.get社会福祉法人等利用者負担軽減_決定年月日()));
        eucCsvEntity.set社会福祉法人軽減承認区分(entity.get社会福祉法人等利用者負担軽減_決定区分().equals(区分_0) ? 却下 : 承認);
        eucCsvEntity.set社会福祉法人軽減開始日(set年月日(entity.get社会福祉法人等利用者負担軽減_適用開始年月日()));
        eucCsvEntity.set社会福祉法人軽減終了日(set年月日(entity.get社会福祉法人等利用者負担軽減_適用終了年月日()));
        eucCsvEntity.set社会福祉法人軽減率(entity.get社会福祉法人等利用者負担軽減_軽減率_分子().concat("/")
                .concat(entity.get社会福祉法人等利用者負担軽減_軽減率_分母()));
        eucCsvEntity.set社会福祉法人軽減事由(entity.get社会福祉法人等利用者負担軽減_減免区分());
        eucCsvEntity.set居宅サービス区分(entity.is社会福祉法人等利用者負担軽減_居宅サービス限定() ? 居宅サービス限定 : RString.EMPTY);
        eucCsvEntity.set居住費_食費限定区分(entity.is社会福祉法人等利用者負担軽減_居住費_食費のみ() ? 居住費_食費のみ : RString.EMPTY);
        eucCsvEntity.set旧措置ユニット型個室限定区分(entity.is社会福祉法人等利用者負担軽減_旧措置者ユニット型個室のみ() ? 旧措置ユ個のみ : RString.EMPTY);
        eucCsvEntity.set被保険者番号_総合事業対象者(entity.get総合事業対象者_被保険者番号());
        eucCsvEntity.set履歴番号(entity.get総合事業対象者_履歴番号());
        eucCsvEntity.set事業適用開始日(set年月日(entity.get総合事業対象者_適用開始年月日()));
        eucCsvEntity.set事業適用終了日(set年月日(entity.get総合事業対象者_適用終了年月日()));
        eucCsvEntity.set事業チェック実施日(set年月日(entity.get総合事業対象者_チェックリスト実施日()));
        eucCsvEntity.set事業決定日(set年月日(entity.get総合事業対象者_決定年月日()));
        eucCsvEntity.set転出先保険者番号(RString.EMPTY);
        eucCsvEntity.set届出区分(set届出区分(entity.get居宅届出_届出区分()));
        eucCsvEntity.set居宅計画作成区分(set居宅計画作成区分(entity.get事業者作成_作成区分コード()));
        eucCsvEntity.set計画事業者番号(entity.get事業者作成_計画事業者番号());
        eucCsvEntity.set計画事業者名(entity.get計画事業者_事業者名称());
        eucCsvEntity.set計画事業者カナ(entity.get計画事業者_事業者名称カナ());
        eucCsvEntity.set計画管理者名(entity.get計画事業者代表者_代表者名());
        eucCsvEntity.set計画管理者カナ(entity.get計画事業者代表者_代表者名カナ());
        eucCsvEntity.set計画適用開始日(set年月日(entity.get事業者作成_適用開始年月日()));
        eucCsvEntity.set計画適用終了日(set年月日(entity.get事業者作成_適用終了年月日()));
        eucCsvEntity.set計画届出日(set年月日(entity.get居宅届出_届出年月日()));
        eucCsvEntity.set計画作成日(set年月日(entity.get自己作成_計画作成年月日()));
        eucCsvEntity.set計画変更日(set年月日(entity.get自己作成_計画変更年月日()));
        eucCsvEntity.set変更理由(entity.get自己作成_計画変更事由());
        eucCsvEntity.set一次判定日(set年月日(entity.get今回一次判定結果_要介護認定一次判定年月日()));
        eucCsvEntity.set要介護度(set要介護度(entity.get今回申請_厚労省IF識別コード(), entity.get受給者台帳_要介護認定状態区分コード()));
    }

    private RString set年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        if (processParamter.isCsvhitsukesurasyuhensyu()) {
            return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        } else {
            return 年月日.seireki().separator(Separator.NONE).fillType(FillType.ZERO).toDateString();
        }

    }

    private RString set要介護度(RString koroshoIfCode, RString code) {
        if (RString.isNullOrEmpty(koroshoIfCode) || RString.isNullOrEmpty(code)) {
            return RString.EMPTY;
        }
        return YokaigoJotaiKubunSupport.toValue(KoroshoInterfaceShikibetsuCode.toValue(koroshoIfCode), code).getName();
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

    private RString set医療保険種別(RString 医療保険種別コード) {
        if (RString.isNullOrEmpty(医療保険種別コード)) {
            return RString.EMPTY;
        }
        UzT0007CodeEntity 医療保険種別 = CodeMaster.getCode(SubGyomuCode.DBA介護資格, new CodeShubetsu("0001"), new Code(医療保険種別コード));
        if (医療保険種別 == null) {
            return RString.EMPTY;
        }
        return 医療保険種別.getコード略称();
    }

    private RString set郵便番号(RString 郵便番号) {
        if (RString.isNullOrEmpty(郵便番号)) {
            return RString.EMPTY;
        }
        return new YubinNo(郵便番号).getEditedYubinNo();
    }

    private RString set受給状況(RString 受給者台帳_有効無効区分) {
        if (RString.isNullOrEmpty(受給者台帳_有効無効区分)) {
            return RString.EMPTY;
        }
        RString 有効無効区分;
        try {
            有効無効区分 = YukoMukoKubun.toValue(受給者台帳_有効無効区分).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (YukoMukoKubun.有効.get名称().equals(有効無効区分)) {
            return ARI;
        } else if (YukoMukoKubun.無効.get名称().equals(有効無効区分)) {
            return MURI;
        }
        return RString.EMPTY;
    }

    private RString set受給申請事由(RString 受給申請事由原, RString 要支援者認定申請区分) {
        if (RString.isNullOrEmpty(受給申請事由原) || RString.isNullOrEmpty(要支援者認定申請区分)) {
            return RString.EMPTY;
        }
        RString 受給申請事由;
        try {
            受給申請事由 = JukyuShinseiJiyu.toValue(受給申請事由原).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (JukyuShinseiJiyu.初回申請.get名称().equals(受給申請事由)) {
            return 初回申請;
        } else if (JukyuShinseiJiyu.再申請_有効期限内.get名称().equals(受給申請事由)) {
            return 再申請内;
        } else if (JukyuShinseiJiyu.再申請_有効期限外.get名称().equals(受給申請事由)) {
            return 再申請外;
        } else if (JukyuShinseiJiyu.要介護度変更申請.get名称().equals(受給申請事由)) {
            if (NinteiShienShinseiKubun.認定支援申請.get名称().equals(
                    NinteiShienShinseiKubun.toValue(要支援者認定申請区分).get名称())) {
                return 支援から申請;
            } else {
                return 区分変更申請;
            }
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.get名称().equals(受給申請事由)) {
            return サ変更申請;
        } else if (JukyuShinseiJiyu.申請_法施行前.get名称().equals(受給申請事由)) {
            return 施行前申請;
        } else if (JukyuShinseiJiyu.追加_申請なしの追加.get名称().equals(受給申請事由)) {
            return 追加;
        }
        return RString.EMPTY;
    }

    private RString setみなし更新認定(RString みなし要介護区分コード) {
        if (RString.isNullOrEmpty(みなし要介護区分コード)) {
            return RString.EMPTY;
        }
        RString みなし要介護区分;
        try {
            みなし要介護区分 = MinashiCode.toValue(みなし要介護区分コード).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (MinashiCode.通常の認定.get名称().equals(みなし要介護区分)) {
            return RString.EMPTY;
        } else {
            return MINASHI;
        }
    }

    private RString set異動事由コード(RString データ区分) {
        if (RString.isNullOrEmpty(データ区分)) {
            return RString.EMPTY;
        }
        RString 異動事由コード = Datakubun.toValue(データ区分).get名称();
        if (Datakubun.通常_認定.get名称().equals(異動事由コード)) {
            return RString.EMPTY;
        } else {
            return 異動事由コード;
        }
    }

    private RString set異動事由文言(RString 異動事由コード) {
        if (RString.isNullOrEmpty(異動事由コード)) {
            return RString.EMPTY;
        }
        RString 直近異動事由 = ChokkinIdoJiyuCode.toValue(異動事由コード).get名称();
        if (ChokkinIdoJiyuCode.未登録.get名称().equals(直近異動事由)) {
            return RString.EMPTY;
        } else if (ChokkinIdoJiyuCode.追加_認定.get名称().equals(直近異動事由)) {
            return 追加_認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請認定.get名称().equals(直近異動事由)) {
            return 要介護度変更申請認定;
        } else if (ChokkinIdoJiyuCode.要介護度変更申請却下.get名称().equals(直近異動事由)) {
            return 要介護度変更申請却下;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請認定.get名称().equals(直近異動事由)) {
            return サービス種類変更申請認定;
        } else if (ChokkinIdoJiyuCode.サービス種類変更申請却下.get名称().equals(直近異動事由)) {
            return サービス種類変更申請却下;
        } else if (ChokkinIdoJiyuCode.削除.get名称().equals(直近異動事由)) {
            return 削除;
        } else if (ChokkinIdoJiyuCode.修正.get名称().equals(直近異動事由)) {
            return 修正;
        } else if (ChokkinIdoJiyuCode.受給申請却下.get名称().equals(直近異動事由)) {
            return 受給申請却下;
        } else if (ChokkinIdoJiyuCode.削除回復.get名称().equals(直近異動事由)) {
            return 削除回復;
        } else if (ChokkinIdoJiyuCode.職権記載.get名称().equals(直近異動事由)) {
            return 職権記載;
        } else if (ChokkinIdoJiyuCode.職権修正.get名称().equals(直近異動事由)) {
            return 職権修正;
        } else if (ChokkinIdoJiyuCode.職権取消.get名称().equals(直近異動事由)) {
            return 職権取消;
        } else if (ChokkinIdoJiyuCode.履歴修正.get名称().equals(直近異動事由)) {
            return 履歴修正;
        }
        return RString.EMPTY;
    }

    private RString set申請区分(RString 認定申請区分) {
        if (RString.isNullOrEmpty(認定申請区分)) {
            return RString.EMPTY;
        }
        RString 申請区分;
        try {
            申請区分 = NinteiShienShinseiKubun.toValue(認定申請区分).get名称();
        } catch (IllegalArgumentException e) {
            return RString.EMPTY;
        }
        if (NinteiShienShinseiKubun.認定支援申請.get名称().equals(申請区分)) {
            return 要支援;
        } else {
            return 要介護;
        }
    }

    private RString set障害高齢者自立度(RString 障害高齢者の日常生活自立度コード) {
        if (RString.isNullOrEmpty(障害高齢者の日常生活自立度コード)) {
            return RString.EMPTY;
        }
        return ShogaiNichijoSeikatsuJiritsudoCode.toValue(障害高齢者の日常生活自立度コード).get名称();
    }

    private RString set認知症高齢者自立度(RString 認知症高齢者の日常生活自立度コード) {
        if (RString.isNullOrEmpty(認知症高齢者の日常生活自立度コード)) {
            return RString.EMPTY;
        }
        return NinchishoNichijoSeikatsuJiritsudoCode.toValue(認知症高齢者の日常生活自立度コード).get名称();
    }

    private void set指定事業者(ShakaiFukushiHojinKeigenEucCsvEntity eucCsvEntity, ShakaiFukushiHojinKeigenEntity entity) {
        if (介護保険施設.equals(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者名(entity.get指定事業者_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get指定事業者_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(set郵便番号(entity.get指定事業者_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get指定事業者_事業者住所());
            eucCsvEntity.set指定事業者代表者名(entity.get指定事業者代表者_代表者名());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get指定事業者代表者_代表者名カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get指定事業者代表者_代表者役職名());
            eucCsvEntity.set指定事業者電話番号(entity.get指定事業者_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get指定事業者_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(entity.get指定事業者_所属人数());
            eucCsvEntity.set指定事業者利用者数(entity.get指定事業者_利用者数());
            eucCsvEntity.set指定事業者認定日(set年月日(entity.get指定事業者_有効開始日()));
            eucCsvEntity.set指定事業者取消日(set年月日(entity.get指定事業者_有効終了日()));
            eucCsvEntity.set指定事業者実施地域(entity.get指定事業者_サービス実施地域());
        } else if (住所地特例対象施設.equals(entity.get施設入所_入所施設種類()) || 適用除外施設.equals(entity.get施設入所_入所施設種類())) {
            eucCsvEntity.set指定事業者名(entity.get除外他特適用施設_事業者名称());
            eucCsvEntity.set指定事業者名カナ(entity.get除外他特適用施設_事業者名称カナ());
            eucCsvEntity.set指定事業者郵便番号(set郵便番号(entity.get除外他特適用施設_郵便番号()));
            eucCsvEntity.set指定事業者住所(entity.get除外他特適用施設_事業者住所());
            eucCsvEntity.set指定事業者代表者名(entity.get除外他特適用施設_代表者名称());
            eucCsvEntity.set指定事業者代表者名カナ(entity.get除外他特適用施設_代表者名称カナ());
            eucCsvEntity.set指定事業者代表者役職(entity.get除外他特適用施設_役職());
            eucCsvEntity.set指定事業者電話番号(entity.get除外他特適用施設_電話番号());
            eucCsvEntity.set指定事業者ＦＡＸ番号(entity.get除外他特適用施設_ＦＡＸ番号());
            eucCsvEntity.set指定事業者ケアマネ数(RString.EMPTY);
            eucCsvEntity.set指定事業者利用者数(RString.EMPTY);
            eucCsvEntity.set指定事業者認定日(set年月日(entity.get除外他特適用施設_有効開始年月日()));
            eucCsvEntity.set指定事業者取消日(set年月日(entity.get除外他特適用施設_有効終了年月日()));
            eucCsvEntity.set指定事業者実施地域(RString.EMPTY);
        }
    }

    private RString set届出区分(RString 届出区分) {
        if (区分_1.equals(届出区分)) {
            return SHINKI;
        } else if (区分_2.equals(届出区分)) {
            return HENKO;
        } else if (区分_3.equals(届出区分)) {
            return ZATEI;
        }
        return RString.EMPTY;
    }

    private RString set居宅計画作成区分(RString 作成区分コード) {
        if (RString.isNullOrEmpty(作成区分コード)) {
            return RString.EMPTY;
        }
        return KyotakuservicekeikakuSakuseikubunCode.toValue(作成区分コード).get名称();
    }

    private PersonalData toPersonalData(ShakaiFukushiHojinKeigenEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get被保険者台帳管理_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private RString set性別(RString 性別コード) {
        if (RString.isNullOrEmpty(性別コード)) {
            return RString.EMPTY;
        }
        return Seibetsu.toValue(性別コード).get名称();
    }

    private RString set削除理由文言(RString 削除事由コード) {
        if (RString.isNullOrEmpty(削除事由コード)) {
            return RString.EMPTY;
        }
        return SakujoJiyuCode.toValue(削除事由コード).get名称();
    }

    private RString set資格区分(RString 被保険者区分コード) {
        if (RString.isNullOrEmpty(被保険者区分コード)) {
            return RString.EMPTY;
        }
        return HihokenshaKubunCode.toValue(被保険者区分コード).get名称();
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        RString csv出力有無 = new RString("無し");
        RString 日本語ファイル名 = new RString("汎用リスト　社会福祉法人軽減CSV");
        RString 英数字ファイル名 = new RString("HanyoList_ShakaiFukushiHojinKeigen.csv");
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
        builder.append(ChushutsuHohoKubun.toValue(processParamter.getCyusyutsuhohokubun()));
        builder.append(SPACE);
        builder.append(COLON);
        builder.append(SPACE);
        if (null != processParamter.getHitsukehanifrom()) {
            builder.append(processParamter.getHitsukehanifrom().wareki().toDateString());
            builder.append(SPACE);
        }
        builder.append(カラ);
        if (null == processParamter.getHitsukehanito()) {
            builder.append(SPACE);
            builder.append(processParamter.getHitsukehanito().wareki().toDateString());
        }
        出力条件.add(builder.toRString());
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getAgeSelectKijun()) {
            出力条件.add(get宛名抽出区分情報());
        }
        if (null != processParamter.getAtenacyusyutsujyoken()
                && null != processParamter.getAtenacyusyutsujyoken().getChiku_Kubun()) {
            出力条件.add(get地区選択区分情報());
        }
        出力条件.add(get対象データ());
        if (!RString.isNullOrEmpty(processParamter.getKyakasha())) {
            builder.append(旧措置者);
            builder.append(COLON);
            builder.append(Kyakasha.toValue(processParamter.getKyakasha()).get名称());
            出力条件.add(builder.toRString());
        }
        if (!RString.isNullOrEmpty(processParamter.getHobetsukubun())) {
            builder.append(法別区分);
            builder.append(HobetsuKubun.toValue(processParamter.getHobetsukubun()).get名称());
            出力条件.add(builder.toRString());
        }
        if (!RString.isNullOrEmpty(processParamter.getKyakasha())) {
            builder.append(却下者);
            builder.append(Kyakasha.toValue(processParamter.getKyakasha()).get名称());
            出力条件.add(builder.toRString());
        }
        if (!RString.isNullOrEmpty(processParamter.getSoshitsukubun())
                && !SoshitsuKubun.資格判定なし.getコード().equals(processParamter.getSoshitsukubun())) {
            builder.append(喪失区分);
            builder.append(SoshitsuKubun.toValue(processParamter.getKyakasha()).get名称());
            出力条件.add(builder.toRString());
        }
        出力条件.add(get旧措置者());
        出力条件.add(get利用者負担段階());
        出力条件.add(get負担割合区分());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                new RString("DBC701002"),
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

    private RString get対象データ() {
        RStringBuilder builder = new RStringBuilder();
        if (processParamter.isNendochokindatacyusyutsu() || processParamter.isChokindatacyusyutsu()
                || processParamter.isJigyotaisyoshadatacyushutsu()) {
            if (processParamter.isShinseishadatacyushutsu()) {
                builder.append(直近_申請者のみ);
            } else {
                builder.append(直近のみ);
            }
        } else if (!processParamter.isNendochokindatacyusyutsu() && !processParamter.isChokindatacyusyutsu()
                && !processParamter.isJigyotaisyoshadatacyushutsu()) {
            builder.append(申請者のみ);
        }
        return builder.toRString();
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

    private RString get旧措置者() {
        RStringBuilder builder = new RStringBuilder();
        if (processParamter.isShiteinyushoshakyusochisha()
                || processParamter.isShiteinyushoshafutankeigensha()
                || processParamter.isShiteinyushoshasonota()) {
            builder.append(旧措置者);
            builder.append(COLON);
            if (processParamter.isShiteinyushoshakyusochisha()) {
                builder.append(旧措置者);
                builder.append(POINT);
            }
            if (processParamter.isShiteinyushoshafutankeigensha()) {
                builder.append(負担軽減者);
                builder.append(POINT);
            }
            if (processParamter.isShiteinyushoshasonota()) {
                builder.append(その他);
            }
        }
        if (builder.toRString().endsWith(POINT)) {
            return builder.toRString().substring(0, builder.toRString().length() - 1);
        }
        return builder.toRString();
    }

    private RString get利用者負担段階() {
        RStringBuilder builder = new RStringBuilder();
        if (processParamter.isShiteinyushoshadaiichidankai()
                || processParamter.isShiteinyushoshadainidankai()
                || processParamter.isShiteinyushoshadaisandankai()
                || processParamter.isShiteinyushoshakazeisou()) {
            builder.append(利用者負担段階);
            if (processParamter.isShiteinyushoshadaiichidankai()) {
                builder.append(第一段階);
                builder.append(POINT);
            }
            if (processParamter.isShiteinyushoshadainidankai()) {
                builder.append(第二段階);
                builder.append(POINT);
            }
            if (processParamter.isShiteinyushoshadaisandankai()) {
                builder.append(第三段階);
                builder.append(POINT);
            }
            if (processParamter.isShiteinyushoshakazeisou()) {
                builder.append(課税層第三段階);
            }
        }
        if (builder.toRString().endsWith(POINT)) {
            return builder.toRString().substring(0, builder.toRString().length() - 1);
        }
        return builder.toRString();
    }

    private RString get負担割合区分() {
        RStringBuilder builder = new RStringBuilder();
        if (processParamter.isJigyotaishoshafutanichiwari()
                || processParamter.isJigyotaishoshafutanniwari()) {
            builder.append(負担割合区分);
            if (processParamter.isJigyotaishoshafutanichiwari()) {
                builder.append(FUTANWARIAI_1);
                builder.append(POINT);
            }
            if (processParamter.isJigyotaishoshafutanniwari()) {
                builder.append(FUTANWARIAI_2);
            }
        }
        if (builder.toRString().endsWith(POINT)) {
            return builder.toRString().substring(0, builder.toRString().length() - 1);
        }
        return builder.toRString();
    }

}
