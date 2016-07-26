/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5110001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5110001.KoshinShinseishaHaakuListMyBatisParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5110001.KoshinShinseishaHaakuListProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5110001.KoshinShinseishaHaakuListCSVEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5110001.PreviousInformationEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5110001.UpdateNotApplicantEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.koshinshinseishahaakulist.IKoshinShinseishaHaakuListMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.EucFileOutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 更新未申請者把握リスト作成CSVファイル出力です。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
public class KoshinShinseishaHaakuListProcess extends BatchProcessBase<UpdateNotApplicantEntity> {

    KoshinShinseishaHaakuListProcessParameter parameter;

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "koshinshinseishahaakulist.IKoshinShinseishaHaakuListMapper.get更新未申請者把握リスト情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBD511003"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private final RString 厚労省IF識別コード_99A = new RString("99A");
    private final RString 厚労省IF識別コード_02A = new RString("02A");
    private final RString 厚労省IF識別コード_06A = new RString("06A");
    private final RString 厚労省IF識別コード_09A = new RString("09A");
    private final RString 厚労省IF識別コード_09B = new RString("09B");
    private final RString ファイル名_日本語 = new RString("更新未申請者把握リスト");
    private final RString ファイル名_英数字 = new RString("KoshinMiShinseishaHaaku.csv");
    private final RString 未申請者全て = new RString("未申請者全て");
    private final RString 対象月まで = new RString("対象月まで");
    private final RString 範囲指定 = new RString("範囲指定");
    private final RString 印刷範囲指定 = new RString("【印刷範囲指定】　");
    private final RString 認定有効期間_終了月 = new RString("【認定有効期間(終了月)】　");
    private final RString 認定有効期間_終了月_From = new RString("【認定有効期間(終了月)From】　");
    private final RString 認定有効期間_終了月_To = new RString("【認定有効期間(終了月)To】　");

    private IKoshinShinseishaHaakuListMapper mapper;

    private int 連番;

    private RString eucFilename;
    private RString spoolWorkPath;
    private List<PersonalData> personalDataList;

    @BatchWriter
    private EucCsvWriter<KoshinShinseishaHaakuListCSVEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void initialize() {
        mapper = getMapper(IKoshinShinseishaHaakuListMapper.class);
        personalDataList = new ArrayList<>();
        spoolWorkPath = Path.getTmpDirectoryPath();
        eucFilename = Path.combinePath(spoolWorkPath, new RString("更新未申請者把握リスト.csv"));
        eucCsvWriterJunitoJugo = new EucCsvWriter.InstanceBuilder(eucFilename, EUC_ENTITY_ID).
                setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();

    }

    @Override
    protected IBatchReader createReader() {
        連番 = 1;
        RString 認定有効期間_終了月 = RString.EMPTY;
        RString 認定有効期間_終了月_From = RString.EMPTY;
        RString 認定有効期間_終了月_To = RString.EMPTY;
        if (parameter.get認定有効期間_終了月() != null) {
            認定有効期間_終了月 = parameter.get認定有効期間_終了月().toDateString();
        }
        if (parameter.get認定有効期間_終了月_From() != null) {
            認定有効期間_終了月_From = parameter.get認定有効期間_終了月_From().toDateString();
        }
        if (parameter.get認定有効期間_終了月_To() != null) {
            認定有効期間_終了月_To = parameter.get認定有効期間_終了月_To().toDateString();
        }
        return new BatchDbReader(MAPPERPATH, new KoshinShinseishaHaakuListMyBatisParameter(
                parameter.get印刷範囲指定(), 認定有効期間_終了月, 認定有効期間_終了月_From, 認定有効期間_終了月_To));
    }

    @Override
    protected void process(UpdateNotApplicantEntity 更新未申請者把握情報) {
        List<PreviousInformationEntity> 前回の情報List
                = mapper.get前回の情報(new KoshinShinseishaHaakuListMyBatisParameter(更新未申請者把握情報.get申請書管理番号()));
        for (PreviousInformationEntity 前回の情報 : 前回の情報List) {
            KoshinShinseishaHaakuListCSVEntity csvEntity = getCSVEntity(連番, 更新未申請者把握情報, 前回の情報);
            連番++;
            eucCsvWriterJunitoJugo.writeLine(csvEntity);
        }
        ExpandedInformation expandedInformations
                = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 更新未申請者把握情報.get申請書管理番号());
        PersonalData personalData = PersonalData.of(ShikibetsuCode.EMPTY, expandedInformations);
        personalDataList.add(personalData);
    }

    @Override
    protected void afterExecute() {
        if (personalDataList.isEmpty()) {
            KoshinShinseishaHaakuListCSVEntity csvEntity = new KoshinShinseishaHaakuListCSVEntity(RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
            eucCsvWriterJunitoJugo.writeLine(csvEntity);
        }
        eucFileOutputJokenhyoFactory();
        eucCsvWriterJunitoJugo.close();
        if (!personalDataList.isEmpty()) {
            AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        }
    }

    private void eucFileOutputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                ファイル名_日本語,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ファイル名_英数字,
                EUC_ENTITY_ID.toRString(),
                new RString(String.valueOf(eucCsvWriterJunitoJugo.getCount())),
                contribute());
        EucFileOutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        if (未申請者全て.equals(parameter.get印刷範囲指定())) {
            出力条件.add(印刷範囲指定.concat(未申請者全て));
        } else if (対象月まで.equals(parameter.get印刷範囲指定())) {
            出力条件.add(印刷範囲指定.concat(対象月まで));
        } else if (範囲指定.equals(parameter.get印刷範囲指定())) {
            出力条件.add(印刷範囲指定.concat(範囲指定));
        }
        if (parameter.get認定有効期間_終了月() != null && parameter.get認定有効期間_終了月().isWareki()) {
            出力条件.add(認定有効期間_終了月.concat(parameter.get認定有効期間_終了月().wareki().toDateString()));
        }
        if (parameter.get認定有効期間_終了月_From() != null && parameter.get認定有効期間_終了月_From().isWareki()) {
            出力条件.add(認定有効期間_終了月_From.concat(parameter.get認定有効期間_終了月_From().wareki().toDateString()));
        }
        if (parameter.get認定有効期間_終了月_To() != null && parameter.get認定有効期間_終了月_To().isWareki()) {
            出力条件.add(認定有効期間_終了月_To.concat(parameter.get認定有効期間_終了月_To().wareki().toDateString()));
        }
        return 出力条件;
    }

    private KoshinShinseishaHaakuListCSVEntity getCSVEntity(int 連番,
            UpdateNotApplicantEntity 更新未申請者把握情報, PreviousInformationEntity 前回の情報) {
        RString 生年月日RString = RString.EMPTY;
        if (!isDateNullOrEmpty(更新未申請者把握情報.get生年月日())) {
            生年月日RString = 更新未申請者把握情報.get生年月日().wareki().toDateString();
        }
        if (null == 前回の情報) {
            return new KoshinShinseishaHaakuListCSVEntity(new RString(連番), 更新未申請者把握情報.get被保険者番号(),
                    更新未申請者把握情報.get被保険者氏名(), 更新未申請者把握情報.get被保険者氏名カナ(), 更新未申請者把握情報.get郵便番号(),
                    更新未申請者把握情報.get住所(), 生年月日RString, new RString(更新未申請者把握情報.get年齢()), RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY);
        }
        RString 前回申請日 = RString.EMPTY;
        if (!isDateNullOrEmpty(前回の情報.get認定申請年月日())) {
            前回申請日 = 前回の情報.get認定申請年月日().wareki().toDateString();
        }
        RString 前回認定日 = RString.EMPTY;
        if (!isDateNullOrEmpty(前回の情報.get二次判定年月日())) {
            前回認定日 = 前回の情報.get二次判定年月日().wareki().toDateString();
        }
        RString 前回認定有効開始日 = RString.EMPTY;
        if (!isDateNullOrEmpty(前回の情報.get二次判定認定有効開始年月日())) {
            前回認定有効開始日 = 前回の情報.get二次判定認定有効開始年月日().wareki().toDateString();
        }
        RString 前回認定有効終了日 = RString.EMPTY;
        if (!isDateNullOrEmpty(前回の情報.get二次判定認定有効終了年月日())) {
            前回認定有効終了日 = 前回の情報.get二次判定認定有効終了年月日().wareki().toDateString();
        }
        RString 前回介護度 = RString.EMPTY;
        if (前回の情報.get二次判定要介護状態区分コード() != null && !前回の情報.get二次判定要介護状態区分コード().isEmpty()) {
            if (厚労省IF識別コード_99A.equals(前回の情報.get厚労省IF識別コード())) {
                前回介護度 = YokaigoJotaiKubun99.toValue(前回の情報.get二次判定要介護状態区分コード()).get名称();
            } else if (厚労省IF識別コード_02A.equals(前回の情報.get厚労省IF識別コード())) {
                前回介護度 = YokaigoJotaiKubun02.toValue(前回の情報.get二次判定要介護状態区分コード()).get名称();
            } else if (厚労省IF識別コード_06A.equals(前回の情報.get厚労省IF識別コード())) {
                前回介護度 = YokaigoJotaiKubun06.toValue(前回の情報.get二次判定要介護状態区分コード()).get名称();
            } else if (厚労省IF識別コード_09A.equals(前回の情報.get厚労省IF識別コード())
                    || 厚労省IF識別コード_09B.equals(前回の情報.get厚労省IF識別コード())) {
                前回介護度 = YokaigoJotaiKubun09.toValue(前回の情報.get二次判定要介護状態区分コード()).get名称();
            }
        }
        return new KoshinShinseishaHaakuListCSVEntity(new RString(連番), 更新未申請者把握情報.get被保険者番号(),
                更新未申請者把握情報.get被保険者氏名(), 更新未申請者把握情報.get被保険者氏名カナ(), 更新未申請者把握情報.get郵便番号(),
                更新未申請者把握情報.get住所(), 生年月日RString, new RString(更新未申請者把握情報.get年齢()), 前回介護度,
                前回申請日, 前回の情報.get認定申請区分_申請時_コード(), 前回認定日, 前回認定有効開始日, 前回認定有効終了日,
                前回の情報.get二次判定認定有効期間(), 前回の情報.get認定調査委託先コード(), 前回の情報.get認定調査委託先情報_事業者名称(),
                前回の情報.get入所施設コード(), 前回の情報.get介護事業者_事業者名称());
    }

    private boolean isDateNullOrEmpty(FlexibleDate 年月日) {
        return null == 年月日 || 年月日.isEmpty();
    }

}
