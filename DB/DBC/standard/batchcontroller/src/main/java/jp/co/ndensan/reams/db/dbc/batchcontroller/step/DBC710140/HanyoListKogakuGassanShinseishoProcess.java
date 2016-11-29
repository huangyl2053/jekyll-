/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.hanyolistkogakugassanshinseisho.HanyoListKogakuGassanShinseishoOutPutOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.kaigokogakugassan.Kaigogassan_ChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.hanyolistkogakugassanshinseishojoho.HanyoListKogakuGassanShinseishoJohoDataCreate;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.authority.ShunoKamokuAuthority;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * バッチ設計_DBCBT23014_汎用リスト出力(高額合算申請書情報)Process
 *
 * @reamsid_L DBC-3103-020 fuyanling
 */
public class HanyoListKogakuGassanShinseishoProcess extends BatchProcessBase<HanyoListKogakuGassanShinseishoJohoEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.hanyolistkogakugassanshinseishojoho."
            + "IHanyoListKogakuGassanShinseishoJohoMapper.getCSVData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701014");
    private static final RString ITEM = new RString("～");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　高額合算申請書情報CSV");
    private static final RString 英数字ファイル名 = new RString("HanyoList_KogakuGassanShinseishoJoho.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final Code CODE = new Code("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 保険者 = new RString("保険者：");
    private static final RString 抽出区分 = new RString("抽出区分：");
    private static final RString 対象年度 = new RString("対象年度：");
    private static final RString 申請年月日 = new RString("申請年月日：");
    private static final RString 支給申請書整理番号 = new RString("支給申請書整理番号：");
    private static final RString 送付年月 = new RString("送付年月：");
    private static final RString すべて = new RString("すべて");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString HEAD_連番 = new RString("連番");
    private static final RString HEAD_識別コード = new RString("識別コード");
    private static final RString HEAD_住民種別 = new RString("住民種別");
    private static final RString HEAD_氏名 = new RString("氏名");
    private static final RString HEAD_氏名カナ = new RString("氏名カナ");
    private static final RString HEAD_生年月日 = new RString("生年月日");
    private static final RString HEAD_年齢 = new RString("年齢");
    private static final RString HEAD_性別 = new RString("性別");
    private static final RString HEAD_続柄コード = new RString("続柄コード");
    private static final RString HEAD_世帯コード = new RString("世帯コード");
    private static final RString HEAD_世帯主名 = new RString("世帯主名");
    private static final RString HEAD_住所コード = new RString("住所コード");
    private static final RString HEAD_郵便番号 = new RString("郵便番号");
    private static final RString HEAD_住所_番地_方書 = new RString("住所＋番地＋方書");
    private static final RString HEAD_住所 = new RString("住所");
    private static final RString HEAD_番地 = new RString("番地");
    private static final RString HEAD_方書 = new RString("方書");
    private static final RString HEAD_行政区コード = new RString("行政区コード");
    private static final RString HEAD_行政区名 = new RString("行政区名");
    private static final RString HEAD_地区１ = new RString("地区１");
    private static final RString HEAD_地区２ = new RString("地区２");
    private static final RString HEAD_地区３ = new RString("地区３");
    private static final RString HEAD_連絡先１ = new RString("連絡先１");
    private static final RString HEAD_連絡先２ = new RString("連絡先２");
    private static final RString HEAD_登録異動日 = new RString("登録異動日");
    private static final RString HEAD_登録事由 = new RString("登録事由");
    private static final RString HEAD_登録届出日 = new RString("登録届出日");
    private static final RString HEAD_住定異動日 = new RString("住定異動日");
    private static final RString HEAD_住定事由 = new RString("住定事由");
    private static final RString HEAD_住定届出日 = new RString("住定届出日");
    private static final RString HEAD_消除異動日 = new RString("消除異動日");
    private static final RString HEAD_消除事由 = new RString("消除事由");
    private static final RString HEAD_消除届出日 = new RString("消除届出日");
    private static final RString HEAD_転出入理由 = new RString("転出入理由");
    private static final RString HEAD_前住所郵便番号 = new RString("前住所郵便番号");
    private static final RString HEAD_前住所_番地_方書 = new RString("前住所＋番地＋方書");
    private static final RString HEAD_前住所 = new RString("前住所");
    private static final RString HEAD_前住所番地 = new RString("前住所番地");
    private static final RString HEAD_前住所方書 = new RString("前住所方書");
    private static final RString HEAD_市町村コード = new RString("市町村コード");
    private static final RString HEAD_市町村名 = new RString("市町村名");
    private static final RString HEAD_保険者コード = new RString("保険者コード");
    private static final RString HEAD_保険者名 = new RString("保険者名");
    private static final RString HEAD_空白 = new RString("空白");
    private static final RString HEAD_送付先氏名 = new RString("送付先氏名");
    private static final RString HEAD_送付先氏名カナ = new RString("送付先氏名カナ");
    private static final RString HEAD_送付先住所コード = new RString("送付先住所コード");
    private static final RString HEAD_送付先郵便番号 = new RString("送付先郵便番号");
    private static final RString HEAD_送付先住所_番地_方書 = new RString("送付先住所＋番地＋方書");
    private static final RString HEAD_送付先住所 = new RString("送付先住所");
    private static final RString HEAD_送付先番地 = new RString("送付先番地");
    private static final RString HEAD_送付先方書 = new RString("送付先方書");
    private static final RString HEAD_送付先行政区コード = new RString("送付先行政区コード");
    private static final RString HEAD_送付先行政区名 = new RString("送付先行政区名");
    private static final RString HEAD_被保険者番号 = new RString("被保険者番号");
    private static final RString HEAD_資格取得事由 = new RString("資格取得事由");
    private static final RString HEAD_資格取得日 = new RString("資格取得日");
    private static final RString HEAD_資格取得届出日 = new RString("資格取得届出日");
    private static final RString HEAD_喪失事由 = new RString("喪失事由");
    private static final RString HEAD_資格喪失日 = new RString("資格喪失日");
    private static final RString HEAD_資格喪失届日 = new RString("資格喪失届日");
    private static final RString HEAD_資格区分 = new RString("資格区分");
    private static final RString HEAD_住所地特例状態 = new RString("住所地特例状態");
    private static final RString HEAD_銀行郵便区分 = new RString("銀行郵便区分");
    private static final RString HEAD_銀行コード = new RString("銀行コード");
    private static final RString HEAD_支店コード = new RString("支店コード");
    private static final RString HEAD_銀行名カナ = new RString("銀行名カナ");
    private static final RString HEAD_銀行名 = new RString("銀行名");
    private static final RString HEAD_支店名カナ = new RString("支店名カナ");
    private static final RString HEAD_支店名 = new RString("支店名");
    private static final RString HEAD_口座種目 = new RString("口座種目");
    private static final RString HEAD_口座番号 = new RString("口座番号");
    private static final RString HEAD_名義人カナ_短 = new RString("名義人カナ（短）");
    private static final RString HEAD_名義人_短 = new RString("名義人（短）");
    private static final RString HEAD_名義人カナ = new RString("名義人カナ");
    private static final RString HEAD_名義人 = new RString("名義人");
    private static final RString HEAD_受給申請事由 = new RString("受給申請事由");
    private static final RString HEAD_受給申請日 = new RString("受給申請日");
    private static final RString HEAD_受給要介護度 = new RString("受給要介護度");
    private static final RString HEAD_受給認定開始日 = new RString("受給認定開始日");
    private static final RString HEAD_受給認定終了日 = new RString("受給認定終了日");
    private static final RString HEAD_受給認定日 = new RString("受給認定日");
    private static final RString HEAD_受給旧措置 = new RString("受給旧措置");
    private static final RString HEAD_受給みなし更新認定 = new RString("受給みなし更新認定");
    private static final RString HEAD_受給直近事由 = new RString("受給直近事由");
    private static final RString HEAD_対象年度 = new RString("対象年度");
    private static final RString HEAD_給付_証記載保険者番号 = new RString("（給付）証記載保険者番号");
    private static final RString HEAD_整理番号 = new RString("整理番号");
    private static final RString HEAD_履歴番号 = new RString("履歴番号");
    private static final RString HEAD_申請状況区分 = new RString("申請状況区分");
    private static final RString HEAD_申請年月日 = new RString("申請年月日");
    private static final RString HEAD_支給申請書整理番号 = new RString("支給申請書整理番号");
    private static final RString HEAD_国保_支給申請書整理番号 = new RString("国保 支給申請書整理番号");
    private static final RString HEAD_支給申請区分 = new RString("支給申請区分");
    private static final RString HEAD_対象計算期間_開始 = new RString("対象計算期間（開始）");
    private static final RString HEAD_対象計算期間_終了 = new RString("対象計算期間（終了）");
    private static final RString HEAD_支給申請形態 = new RString("支給申請形態");
    private static final RString HEAD_自己負担額証明書交付申請の有無 = new RString("自己負担額証明書交付申請の有無");
    private static final RString HEAD_申請代表者_氏名_漢字 = new RString("申請代表者 氏名（漢字）");
    private static final RString HEAD_所得区分 = new RString("所得区分");
    private static final RString HEAD_70歳以上の者に係る所得区分 = new RString("70歳以上の者に係る所得区分");
    private static final RString HEAD_資格喪失年月日 = new RString("資格喪失年月日");
    private static final RString HEAD_資格喪失事由 = new RString("資格喪失事由");
    private static final RString HEAD_加入期間_開始年月日 = new RString("加入期間 開始年月日");
    private static final RString HEAD_加入期間_終了年月日 = new RString("加入期間 終了年月日");
    private static final RString HEAD_国保保険者番号 = new RString("国保保険者番号");
    private static final RString HEAD_国保保険者名称 = new RString("国保保険者名称");
    private static final RString HEAD_国保被保険者証記号 = new RString("国保被保険者証記号");
    private static final RString HEAD_国保被保険者証番号 = new RString("国保被保険者証番号");
    private static final RString HEAD_国保世帯番号 = new RString("国保世帯番号");
    private static final RString HEAD_国保続柄 = new RString("国保続柄");
    private static final RString HEAD_国保加入期間_開始年月日 = new RString("国保加入期間・開始年月日");
    private static final RString HEAD_国保加入期間_終了年月日 = new RString("国保加入期間・終了年月日");
    private static final RString HEAD_後期保険者番号 = new RString("後期保険者番号");
    private static final RString HEAD_後期広域連合名称 = new RString("後期広域連合名称");
    private static final RString HEAD_後期被保険者番号 = new RString("後期被保険者番号");
    private static final RString HEAD_後期加入期間_開始年月日 = new RString("後期加入期間・開始年月日");
    private static final RString HEAD_後期加入期間_終了年月日 = new RString("後期加入期間・終了年月日");
    private static final RString HEAD_支払方法区分 = new RString("支払方法区分");
    private static final RString HEAD_支払場所 = new RString("支払場所");
    private static final RString HEAD_支払場所_短 = new RString("支払場所(短)");
    private static final RString HEAD_支払期間開始年月日 = new RString("支払期間開始年月日");
    private static final RString HEAD_支払期間終了年月日 = new RString("支払期間終了年月日");
    private static final RString HEAD_支払期間開始年月日_曜日 = new RString("支払期間開始年月日(曜日)");
    private static final RString HEAD_支払期間終了年月日_曜日 = new RString("支払期間終了年月日(曜日)");
    private static final RString HEAD_支払期間開始年月日_時間 = new RString("支払期間開始年月日(時間)");
    private static final RString HEAD_支払期間終了年月日_時間 = new RString("支払期間終了年月日(時間)");
    private static final RString HEAD_口座履歴番号 = new RString("口座履歴番号");
    private static final RString HEAD_加入０１保険者名 = new RString("加入０１保険者名");
    private static final RString HEAD_加入０１加入開始日 = new RString("加入０１加入開始日");
    private static final RString HEAD_加入０１加入終了日 = new RString("加入０１加入終了日");
    private static final RString HEAD_加入０１証明書番号 = new RString("加入０１証明書番号");
    private static final RString HEAD_加入０２保険者名 = new RString("加入０２保険者名");
    private static final RString HEAD_加入０２加入開始日 = new RString("加入０２加入開始日");
    private static final RString HEAD_加入０２加入終了日 = new RString("加入０２加入終了日");
    private static final RString HEAD_加入０２証明書番号 = new RString("加入０２証明書番号");
    private static final RString HEAD_加入０３保険者名 = new RString("加入０３保険者名");
    private static final RString HEAD_加入０３加入開始日 = new RString("加入０３加入開始日");
    private static final RString HEAD_加入０３加入終了日 = new RString("加入０３加入終了日");
    private static final RString HEAD_加入０３証明書番号 = new RString("加入０３証明書番号");
    private static final RString HEAD_加入０４保険者名 = new RString("加入０４保険者名");
    private static final RString HEAD_加入０４加入開始日 = new RString("加入０４加入開始日");
    private static final RString HEAD_加入０４加入終了日 = new RString("加入０４加入終了日");
    private static final RString HEAD_加入０４証明書番号 = new RString("加入０４証明書番号");
    private static final RString HEAD_加入０５保険者名 = new RString("加入０５保険者名");
    private static final RString HEAD_加入０５加入開始日 = new RString("加入０５加入開始日");
    private static final RString HEAD_加入０５加入終了日 = new RString("加入０５加入終了日");
    private static final RString HEAD_加入０５証明書番号 = new RString("加入０５証明書番号");
    private static final RString HEAD_加入０６保険者名 = new RString("加入０６保険者名");
    private static final RString HEAD_加入０６加入開始日 = new RString("加入０６加入開始日");
    private static final RString HEAD_加入０６加入終了日 = new RString("加入０６加入終了日");
    private static final RString HEAD_加入０６証明書番号 = new RString("加入０６証明書番号");
    private static final RString HEAD_加入０７保険者名 = new RString("加入０７保険者名");
    private static final RString HEAD_加入０７加入開始日 = new RString("加入０７加入開始日");
    private static final RString HEAD_加入０７加入終了日 = new RString("加入０７加入終了日");
    private static final RString HEAD_加入０７証明書番号 = new RString("加入０７証明書番号");
    private static final RString HEAD_加入０８保険者名 = new RString("加入０８保険者名");
    private static final RString HEAD_加入０８加入開始日 = new RString("加入０８加入開始日");
    private static final RString HEAD_加入０８加入終了日 = new RString("加入０８加入終了日");
    private static final RString HEAD_加入０８証明書番号 = new RString("加入０８証明書番号");
    private static final RString HEAD_加入０９保険者名 = new RString("加入０９保険者名");
    private static final RString HEAD_加入０９加入開始日 = new RString("加入０９加入開始日");
    private static final RString HEAD_加入０９加入終了日 = new RString("加入０９加入終了日");
    private static final RString HEAD_加入０９証明書番号 = new RString("加入０９証明書番号");
    private static final RString HEAD_加入１０保険者名 = new RString("加入１０保険者名");
    private static final RString HEAD_加入１０加入開始日 = new RString("加入１０加入開始日");
    private static final RString HEAD_加入１０加入終了日 = new RString("加入１０加入終了日");
    private static final RString HEAD_加入１０証明書番号 = new RString("加入１０証明書番号");
    private static final RString HEAD_支給申請書情報送付年月 = new RString("支給申請書情報送付年月");
    private static final RString HEAD_自己負担額計算年月 = new RString("自己負担額計算年月");
    private static final RString ORDER_BY = new RString("ORDER BY ");
    private static final RString 出力順_被保険者番号 = new RString("\"高額合算申請書_被保険者番号\" ASC, ");
    private static final RString 出力順_対象年度 = new RString("\"高額合算申請書_対象年度\" ASC, ");
    private static final RString 出力順_支給申請書整理番号_6_11
            = new RString("SUBSTR(\"高額合算申請書_支給申請書整理番号\",6,11) ASC, ");
    private static final RString 出力順_支給申請書整理番号 = new RString("\"高額合算申請書_支給申請書整理番号\" ASC, ");
    private static final RString 出力順_履歴番号 = new RString("\"高額合算申請書_履歴番号\" ASC");
    private RString 出力有無;
    private HanyoListKogakuGassanShinseishoJohoProcessParameter parameter;
    private HanyoListKogakuGassanShinseishoJohoDataCreate dataCreate;
    private RString eucFilePath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private Association 地方公共団体;
    private Decimal 連番;
    private FlexibleDate システム日付;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private ChohyoSeigyoKyotsu 帳票制御共通;

    @BatchWriter
    private CsvWriter<HanyoListKogakuGassanShinseishoJohoCSVEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        出力有無 = CSV出力有無_なし;
        連番 = Decimal.ONE;
        dataCreate = new HanyoListKogakuGassanShinseishoJohoDataCreate();
        KozaSearchKeyBuilder builder = new KozaSearchKeyBuilder();
        builder.setサブ業務コード(SubGyomuCode.DBC介護給付);
        builder.set業務コード(GyomuCode.DB介護保険);
        builder.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()));
        builder.set基準日(システム日付);
        IKozaSearchKey searchKey = builder.build();
        parameter.setSearchkey(searchKey);
        ShunoKamokuAuthority sut = InstanceProvider.create(ShunoKamokuAuthority.class);
        List<KamokuCode> list = sut.get更新権限科目コード(parameter.getReamsLoginId());
        parameter.setList(list);
        parameter.set出力項目(get出力順());
        return new BatchDbReader(READ_DATA_ID, parameter.toMybatisParam());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 英数字ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
        if (parameter.is項目名付加()) {
            eucCsvWriter.writeLine(getHeader());
        }
    }

    @Override
    protected void beforeExecute() {
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701014.getReportId());
        personalDataList = new ArrayList<>();
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        市町村名MasterMap = new HashMap<>();
        List<KoseiShichosonMaster> 市町村名Master = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (KoseiShichosonMaster koseiShichosonMaster : 市町村名Master) {
            市町村名MasterMap.put(koseiShichosonMaster.get市町村コード().value(), koseiShichosonMaster);
        }
    }

    @Override
    protected void process(HanyoListKogakuGassanShinseishoJohoEntity entity) {
        出力有無 = CSV出力有無_あり;
        Association 導入団体情報 = AssociationFinderFactory.createInstance().getAssociation(entity.get最新被保台帳_市町村コード());
        eucCsvWriter.writeLine(dataCreate.createCsvData(entity, parameter, 連番,
                市町村名MasterMap, 帳票制御共通, 地方公共団体, 導入団体情報));
        連番 = 連番.add(Decimal.ONE);
        personalDataList.add(toPersonalData(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        if (personalDataList == null || personalDataList.isEmpty()) {
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        } else {
            AccessLogUUID accessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLog);
        }
        バッチ出力条件リストの出力();
    }

    private PersonalData toPersonalData(HanyoListKogakuGassanShinseishoJohoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(CODE, 被保険者番号,
                entity.get高額合算申請書_被保険者番号());
        return PersonalData.of(entity.get宛名Entity().getShikibetsuCode(), expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString 出力件数 = new RString(String.valueOf(eucCsvWriter.getCount()));
        List<RString> 出力条件 = get出力条件();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                導入団体コード,
                市町村名,
                RString.EMPTY,
                日本語ファイル名,
                出力件数,
                出力有無,
                英数字ファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private RString monthToRString(FlexibleYearMonth 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private RString dataToRString(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.ICHI_NEN)
                .separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    private List<RString> get出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出対象者);
        出力条件.add(builder.toRString());
        builder = get保険者名();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get抽出区分();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get対象年度();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get申請年月日();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get支給申請書整理番号();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }
        builder = get送付年月();
        if (builder != null) {
            出力条件.add(builder.toRString());
        }

        return 出力条件;
    }

    private RStringBuilder get抽出区分() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出区分);
        if (parameter.get抽出区分() == null || parameter.get抽出区分().isEmpty()) {
            return null;
        }
        builder.append(Kaigogassan_ChushutsuKubun.toValue(parameter.get抽出区分()).get名称());
        return builder;
    }

    private RStringBuilder get保険者名() {
        RStringBuilder builder = new RStringBuilder();
        if (parameter.get保険者コード() == null || parameter.get保険者コード().isEmpty()
                || すべて.equals(parameter.get保険者コード())) {
            return null;
        }
        builder.append(保険者);
        Association 地方公共団体コード = AssociationFinderFactory.createInstance().getAssociation(
                new LasdecCode(parameter.get保険者コード()));
        builder.append(地方公共団体コード.get市町村名());
        return builder;
    }

    private RStringBuilder get申請年月日() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(申請年月日);
        if ((parameter.get申請年月日From() == null || parameter.get申請年月日From().isEmpty())
                && (parameter.get申請年月日To() == null || parameter.get申請年月日To().isEmpty())) {
            return null;
        }
        if (parameter.get申請年月日From() != null && !parameter.get申請年月日From().isEmpty()
                && parameter.get申請年月日To() != null && !parameter.get申請年月日To().isEmpty()) {
            return builder.append(dataToRString(parameter.get申請年月日From())).append(ITEM)
                    .append(dataToRString(parameter.get申請年月日To()));
        } else if (parameter.get申請年月日To() == null || parameter.get申請年月日To().isEmpty()) {
            return builder.append(dataToRString(parameter.get申請年月日From())).append(ITEM);
        } else if (parameter.get申請年月日From() == null || parameter.get申請年月日From().isEmpty()) {
            return builder.append(ITEM).append(dataToRString(parameter.get申請年月日To()));
        }

        return null;
    }

    private RStringBuilder get支給申請書整理番号() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(支給申請書整理番号);
        if ((parameter.get支給申請書整理番号From() == null || parameter.get支給申請書整理番号From().isEmpty())
                && (parameter.get支給申請書整理番号To() == null || parameter.get支給申請書整理番号To().isEmpty())) {
            return null;
        }
        if (parameter.get支給申請書整理番号From() != null && !parameter.get支給申請書整理番号From().isEmpty()
                && parameter.get支給申請書整理番号To() != null && !parameter.get支給申請書整理番号To().isEmpty()) {
            return builder.append(parameter.get支給申請書整理番号From()).append(ITEM)
                    .append(parameter.get支給申請書整理番号To());
        } else if (parameter.get支給申請書整理番号To() == null || parameter.get支給申請書整理番号To().isEmpty()) {
            return builder.append(parameter.get支給申請書整理番号From()).append(ITEM);
        } else if (parameter.get支給申請書整理番号From() == null || parameter.get支給申請書整理番号From().isEmpty()) {
            return builder.append(ITEM).append(parameter.get支給申請書整理番号To());
        }
        return null;
    }

    private RStringBuilder get送付年月() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(送付年月);
        if ((parameter.get送付年月From() == null || parameter.get送付年月From().isEmpty())
                && (parameter.get送付年月To() == null || parameter.get送付年月To().isEmpty())) {
            return null;
        }
        if (parameter.get送付年月From() != null && !parameter.get送付年月From().isEmpty()
                && parameter.get送付年月To() != null && !parameter.get送付年月To().isEmpty()) {
            return builder.append(monthToRString(parameter.get送付年月From())).append(ITEM)
                    .append(monthToRString(parameter.get送付年月To()));
        } else if (parameter.get送付年月To() == null || parameter.get送付年月To().isEmpty()) {
            return builder.append(monthToRString(parameter.get送付年月From())).append(ITEM);
        } else if (parameter.get送付年月From() == null || parameter.get送付年月From().isEmpty()) {
            return builder.append(ITEM).append(monthToRString(parameter.get送付年月To()));
        }
        return null;
    }

    private RStringBuilder get対象年度() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象年度);
        if (parameter.get対象年度() != null && !parameter.get対象年度().isEmpty()) {
            return builder.append(DateConverter.getWarekiYear(new RYear(parameter.get対象年度().toString())));
        }
        return null;
    }

    private HanyoListKogakuGassanShinseishoJohoCSVEntity getHeader() {
        HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity = new HanyoListKogakuGassanShinseishoJohoCSVEntity();
        csvEntity.set連番(HEAD_連番);
        csvEntity.set識別コード(HEAD_識別コード);
        csvEntity.set住民種別(HEAD_住民種別);
        csvEntity.set氏名(HEAD_氏名);
        csvEntity.set氏名カナ(HEAD_氏名カナ);
        csvEntity.set生年月日(HEAD_生年月日);
        csvEntity.set年齢(HEAD_年齢);
        csvEntity.set性別(HEAD_性別);
        csvEntity.set続柄コード(HEAD_続柄コード);
        csvEntity.set世帯コード(HEAD_世帯コード);
        csvEntity.set世帯主名(HEAD_世帯主名);
        csvEntity.set住所コード(HEAD_住所コード);
        csvEntity.set郵便番号(HEAD_郵便番号);
        csvEntity.set住所番地方書(HEAD_住所_番地_方書);
        csvEntity.set住所(HEAD_住所);
        csvEntity.set番地(HEAD_番地);
        csvEntity.set方書(HEAD_方書);
        csvEntity.set行政区コード(HEAD_行政区コード);
        csvEntity.set行政区名(HEAD_行政区名);
        csvEntity.set地区１(HEAD_地区１);
        csvEntity.set地区２(HEAD_地区２);
        csvEntity.set地区３(HEAD_地区３);
        csvEntity.set連絡先１(HEAD_連絡先１);
        csvEntity.set連絡先２(HEAD_連絡先２);
        csvEntity.set登録異動日(HEAD_登録異動日);
        csvEntity.set登録事由(HEAD_登録事由);
        csvEntity.set登録届出日(HEAD_登録届出日);
        csvEntity.set住定異動日(HEAD_住定異動日);
        csvEntity.set住定事由(HEAD_住定事由);
        csvEntity.set住定届出日(HEAD_住定届出日);
        csvEntity.set消除異動日(HEAD_消除異動日);
        csvEntity.set消除事由(HEAD_消除事由);
        csvEntity.set消除届出日(HEAD_消除届出日);
        csvEntity.set転出入理由(HEAD_転出入理由);
        csvEntity.set前住所郵便番号(HEAD_前住所郵便番号);
        csvEntity.set前住所番地方書(HEAD_前住所_番地_方書);
        csvEntity.set前住所(HEAD_前住所);
        csvEntity.set前住所番地(HEAD_前住所番地);
        csvEntity.set前住所方書(HEAD_前住所方書);
        csvEntity.set市町村コード(HEAD_市町村コード);
        csvEntity.set市町村名(HEAD_市町村名);
        csvEntity.set保険者コード(HEAD_保険者コード);
        csvEntity.set保険者名(HEAD_保険者名);
        csvEntity.set空白(HEAD_空白);
        csvEntity.set送付先氏名(HEAD_送付先氏名);
        csvEntity.set送付先氏名カナ(HEAD_送付先氏名カナ);
        csvEntity.set送付先住所コード(HEAD_送付先住所コード);
        csvEntity.set送付先郵便番号(HEAD_送付先郵便番号);
        csvEntity.set送付先住所番地方書(HEAD_送付先住所_番地_方書);
        csvEntity.set送付先住所(HEAD_送付先住所);
        csvEntity.set送付先番地(HEAD_送付先番地);
        csvEntity.set送付先方書(HEAD_送付先方書);
        csvEntity.set送付先行政区コード(HEAD_送付先行政区コード);
        csvEntity.set送付先行政区名(HEAD_送付先行政区名);
        csvEntity.set被保険者番号(HEAD_被保険者番号);
        csvEntity.set資格取得事由(HEAD_資格取得事由);
        csvEntity.set資格取得日(HEAD_資格取得日);
        csvEntity.set資格取得届出日(HEAD_資格取得届出日);
        csvEntity.set喪失事由(HEAD_喪失事由);
        csvEntity.set資格喪失日(HEAD_資格喪失日);
        csvEntity.set資格喪失届日(HEAD_資格喪失届日);
        csvEntity.set資格区分(HEAD_資格区分);
        csvEntity.set住所地特例状態(HEAD_住所地特例状態);
        csvEntity.set銀行郵便区分(HEAD_銀行郵便区分);
        csvEntity.set銀行コード(HEAD_銀行コード);
        csvEntity.set支店コード(HEAD_支店コード);
        csvEntity.set銀行名カナ(HEAD_銀行名カナ);
        csvEntity.set銀行名(HEAD_銀行名);
        csvEntity.set支店名カナ(HEAD_支店名カナ);
        csvEntity.set支店名(HEAD_支店名);
        csvEntity.set口座種目(HEAD_口座種目);
        csvEntity.set口座番号(HEAD_口座番号);
        csvEntity.set名義人カナ短(HEAD_名義人カナ_短);
        csvEntity.set名義人短(HEAD_名義人_短);
        csvEntity.set名義人カナ(HEAD_名義人カナ);
        csvEntity.set名義人(HEAD_名義人);
        csvEntity.set受給申請事由(HEAD_受給申請事由);
        csvEntity.set受給申請日(HEAD_受給申請日);
        csvEntity.set受給要介護度(HEAD_受給要介護度);
        csvEntity.set受給認定開始日(HEAD_受給認定開始日);
        csvEntity.set受給認定終了日(HEAD_受給認定終了日);
        csvEntity.set受給認定日(HEAD_受給認定日);
        csvEntity.set受給旧措置(HEAD_受給旧措置);
        csvEntity.set受給みなし更新認定(HEAD_受給みなし更新認定);
        csvEntity.set受給直近事由(HEAD_受給直近事由);
        csvEntity.set対象年度(HEAD_対象年度);
        csvEntity.set給付証記載保険者番号(HEAD_給付_証記載保険者番号);
        csvEntity.set整理番号(HEAD_整理番号);
        csvEntity.set履歴番号(HEAD_履歴番号);
        csvEntity.set申請状況区分(HEAD_申請状況区分);
        csvEntity.set申請年月日(HEAD_申請年月日);
        csvEntity.set支給申請書整理番号(HEAD_支給申請書整理番号);
        csvEntity.set国保支給申請書整理番号(HEAD_国保_支給申請書整理番号);
        csvEntity.set支給申請区分(HEAD_支給申請区分);
        csvEntity.set対象計算期間開始(HEAD_対象計算期間_開始);
        csvEntity.set対象計算期間終了(HEAD_対象計算期間_終了);
        csvEntity.set支給申請形態(HEAD_支給申請形態);
        csvEntity.set自己負担額証明書交付申請の有無(HEAD_自己負担額証明書交付申請の有無);
        csvEntity.set申請代表者氏名漢字(HEAD_申請代表者_氏名_漢字);
        csvEntity.set所得区分(HEAD_所得区分);
        csvEntity.set歳以上の者に係る所得区分(HEAD_70歳以上の者に係る所得区分);
        csvEntity.set資格喪失年月日(HEAD_資格喪失年月日);
        csvEntity.set資格喪失事由(HEAD_資格喪失事由);
        csvEntity.set加入期間開始年月日(HEAD_加入期間_開始年月日);
        csvEntity.set加入期間終了年月日(HEAD_加入期間_終了年月日);

        setMesai(csvEntity);

        return csvEntity;

    }

    private void setMesai(HanyoListKogakuGassanShinseishoJohoCSVEntity csvEntity) {
        csvEntity.set国保保険者番号(HEAD_国保保険者番号);
        csvEntity.set国保保険者名称(HEAD_国保保険者名称);
        csvEntity.set国保被保険者証記号(HEAD_国保被保険者証記号);
        csvEntity.set国保被保険者証番号(HEAD_国保被保険者証番号);
        csvEntity.set国保世帯番号(HEAD_国保世帯番号);
        csvEntity.set国保続柄(HEAD_国保続柄);
        csvEntity.set国保加入期間開始年月日(HEAD_国保加入期間_開始年月日);
        csvEntity.set国保加入期間終了年月日(HEAD_国保加入期間_終了年月日);
        csvEntity.set後期保険者番号(HEAD_後期保険者番号);
        csvEntity.set後期広域連合名称(HEAD_後期広域連合名称);
        csvEntity.set後期被保険者番号(HEAD_後期被保険者番号);
        csvEntity.set後期加入期間開始年月日(HEAD_後期加入期間_開始年月日);
        csvEntity.set後期加入期間終了年月日(HEAD_後期加入期間_終了年月日);
        csvEntity.set支払方法区分(HEAD_支払方法区分);
        csvEntity.set支払場所(HEAD_支払場所);
        csvEntity.set支払場所短(HEAD_支払場所_短);
        csvEntity.set支払期間開始年月日(HEAD_支払期間開始年月日);
        csvEntity.set支払期間終了年月日(HEAD_支払期間終了年月日);
        csvEntity.set支払期間開始年月日曜日(HEAD_支払期間開始年月日_曜日);
        csvEntity.set支払期間終了年月日曜日(HEAD_支払期間終了年月日_曜日);
        csvEntity.set支払期間開始年月日時間(HEAD_支払期間開始年月日_時間);
        csvEntity.set支払期間終了年月日時間(HEAD_支払期間終了年月日_時間);
        csvEntity.set口座履歴番号(HEAD_口座履歴番号);
        csvEntity.set加入０１保険者名(HEAD_加入０１保険者名);
        csvEntity.set加入０１加入開始日(HEAD_加入０１加入開始日);
        csvEntity.set加入０１加入終了日(HEAD_加入０１加入終了日);
        csvEntity.set加入０１証明書番号(HEAD_加入０１証明書番号);
        csvEntity.set加入０２保険者名(HEAD_加入０２保険者名);
        csvEntity.set加入０２加入開始日(HEAD_加入０２加入開始日);
        csvEntity.set加入０２加入終了日(HEAD_加入０２加入終了日);
        csvEntity.set加入０２証明書番号(HEAD_加入０２証明書番号);
        csvEntity.set加入０３保険者名(HEAD_加入０３保険者名);
        csvEntity.set加入０３加入開始日(HEAD_加入０３加入開始日);
        csvEntity.set加入０３加入終了日(HEAD_加入０３加入終了日);
        csvEntity.set加入０３証明書番号(HEAD_加入０３証明書番号);
        csvEntity.set加入０４保険者名(HEAD_加入０４保険者名);
        csvEntity.set加入０４加入開始日(HEAD_加入０４加入開始日);
        csvEntity.set加入０４加入終了日(HEAD_加入０４加入終了日);
        csvEntity.set加入０４証明書番号(HEAD_加入０４証明書番号);
        csvEntity.set加入０５保険者名(HEAD_加入０５保険者名);
        csvEntity.set加入０５加入開始日(HEAD_加入０５加入開始日);
        csvEntity.set加入０５加入終了日(HEAD_加入０５加入終了日);
        csvEntity.set加入０５証明書番号(HEAD_加入０５証明書番号);
        csvEntity.set加入０６保険者名(HEAD_加入０６保険者名);
        csvEntity.set加入０６加入開始日(HEAD_加入０６加入開始日);
        csvEntity.set加入０６加入終了日(HEAD_加入０６加入終了日);
        csvEntity.set加入０６証明書番号(HEAD_加入０６証明書番号);
        csvEntity.set加入０７保険者名(HEAD_加入０７保険者名);
        csvEntity.set加入０７加入開始日(HEAD_加入０７加入開始日);
        csvEntity.set加入０７加入終了日(HEAD_加入０７加入終了日);
        csvEntity.set加入０７証明書番号(HEAD_加入０７証明書番号);
        csvEntity.set加入０８保険者名(HEAD_加入０８保険者名);
        csvEntity.set加入０８加入開始日(HEAD_加入０８加入開始日);
        csvEntity.set加入０８加入終了日(HEAD_加入０８加入終了日);
        csvEntity.set加入０８証明書番号(HEAD_加入０８証明書番号);
        csvEntity.set加入０９保険者名(HEAD_加入０９保険者名);
        csvEntity.set加入０９加入開始日(HEAD_加入０９加入開始日);
        csvEntity.set加入０９加入終了日(HEAD_加入０９加入終了日);
        csvEntity.set加入０９証明書番号(HEAD_加入０９証明書番号);
        csvEntity.set加入１０保険者名(HEAD_加入１０保険者名);
        csvEntity.set加入１０加入開始日(HEAD_加入１０加入開始日);
        csvEntity.set加入１０加入終了日(HEAD_加入１０加入終了日);
        csvEntity.set加入１０証明書番号(HEAD_加入１０証明書番号);
        csvEntity.set支給申請書情報送付年月(HEAD_支給申請書情報送付年月);
        csvEntity.set自己負担額計算年月(HEAD_自己負担額計算年月);
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順());
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = MyBatisOrderByClauseCreator.create(HanyoListKogakuGassanShinseishoOutPutOrder.class, order);
            出力順 = 出力順.concat(EUC_WRITER_DELIMITER);
        }
        if (RString.isNullOrEmpty(出力順)) {
            出力順 = 出力順.concat(ORDER_BY);
        }
        出力順 = 出力順.concat(出力順_被保険者番号);
        出力順 = 出力順.concat(出力順_対象年度);
        出力順 = 出力順.concat(出力順_支給申請書整理番号_6_11);
        出力順 = 出力順.concat(出力順_支給申請書整理番号);
        出力順 = 出力順.concat(出力順_履歴番号);
        return 出力順;
    }
}
