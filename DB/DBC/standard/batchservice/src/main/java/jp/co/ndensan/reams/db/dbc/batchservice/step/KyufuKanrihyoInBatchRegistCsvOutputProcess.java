/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.DbcMapperInterfaces;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuKanrihyoTorikomi.KeikakuSakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuKanrihyoTorikomi.SakuseiKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KyufuKanrihyoTorikomi.ShubetsuKubun;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KyufuKanrihyoInIchiRanEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.KyufuKanrihyoInKekkaEntity;
import jp.co.ndensan.reams.ur.urz.batchservice.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.batchservice.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.InputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 給付管理票取込結果CSV出力の処理クラスです。
 *
 * @author N8156 宮本 康
 */
public class KyufuKanrihyoInBatchRegistCsvOutputProcess extends BatchProcessBase<DbTKyufukanrihyoDataTempTableEntity> {

    public static final RString INPUT_PARAM_KEY_出力順ID = new RString("出力順ID");
    public static final RString OUTPUT_PARAM_KEY_一覧ファイル = new RString("一覧ファイル");
    public static final RString OUTPUT_PARAM_KEY_結果ファイル = new RString("結果ファイル");

    private static final RString マッパーID = DbcMapperInterfaces.給付管理票取込_一時データ取得.getFullPath();
    private static final ReportId 帳票ID = new ReportId(new RString("DBC900001_KyufukanrihyoTorikomiKekkaIchiran"));
    private static final RString 一覧EUCエンティティID = new RString("KyufuKanrihyoInIchiRanEntity");
    private static final RString 結果EUCエンティティID = new RString("KyufuKanrihyoInKekkaEntity");
    private static final RString 一覧ファイル名 = new RString("KyufuKanrihyoInIchiRan.csv");
    private static final RString 結果ファイル名 = new RString("KyufuKanrihyoInKekka.csv");
    private static final int 出力順数 = 5;
    private static final List<RString> 出力順パラメータ = Arrays.asList(
            new RString("sortSequence1"),
            new RString("sortSequence2"),
            new RString("sortSequence3"),
            new RString("sortSequence4"),
            new RString("sortSequence5"));
    private static final List<RString> 昇降順パラメータ = Arrays.asList(
            new RString("sortSequence1Order"),
            new RString("sortSequence2Order"),
            new RString("sortSequence3Order"),
            new RString("sortSequence4Order"),
            new RString("sortSequence5Order"));
    private static final RString 支援事業者未登録 = new RString("支援事業者未登録");
    private static final RString 集計レコード = new RString("99");
    private static final FlexibleYearMonth サービス単位出力基準 = new FlexibleYearMonth("200604");

    private InputParameter<Long> 出力順ID;
    private OutputParameter<RString> 一覧ファイル;
    private OutputParameter<RString> 結果ファイル;

    private IChohyoShutsuryokujunFinder shutsuryokujunFinder;
    private FileSpoolManager ichiranSpoolManager;
    private FileSpoolManager kekkaSpoolManager;
    private RString 一覧ファイルパス;
    private RString 結果ファイルパス;
    private int 連番;
    private int 訪問通所サービス件数;
    private int 短期入所サービス件数;
    private int 居宅サービス件数;

    @BatchWriter
    private CsvWriter<KyufuKanrihyoInIchiRanEntity> ichiranWriter;
    @BatchWriter
    private CsvWriter<KyufuKanrihyoInKekkaEntity> kekkaWriter;

    @Override
    protected void initialize() {
        super.initialize();
        shutsuryokujunFinder = InstanceProvider.createWithCustomize(IChohyoShutsuryokujunFinder.class);
        setParameter();
        ichiranSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        kekkaSpoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 結果EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        一覧ファイル = new OutputParameter<>();
        結果ファイル = new OutputParameter<>();
        連番 = 1;
        訪問通所サービス件数 = 0;
        短期入所サービス件数 = 0;
        居宅サービス件数 = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(マッパーID, super.sqlParameter);
    }

    @Override
    protected void createWriter() {
        一覧ファイルパス = Path.combinePath(ichiranSpoolManager.getEucOutputDirectry(), 一覧ファイル名);
        結果ファイルパス = Path.combinePath(kekkaSpoolManager.getEucOutputDirectry(), 結果ファイル名);
        this.ichiranWriter = BatchWriters.csvWriter(KyufuKanrihyoInIchiRanEntity.class).filePath(一覧ファイルパス).build();
        this.kekkaWriter = BatchWriters.csvWriter(KyufuKanrihyoInKekkaEntity.class).filePath(結果ファイルパス).build();
    }

    @Override
    protected void beforeExecute() {
        ichiranWriter.writeLine(create一覧Header());
        kekkaWriter.writeLine(create結果Header());
    }

    @Override
    protected void process(DbTKyufukanrihyoDataTempTableEntity entity) {
        ichiranWriter.writeLine(to一覧Data(entity));
    }

    @Override
    protected void afterExecute() {
        kekkaWriter.writeLine(to結果Data());
        ichiranWriter.close();
        kekkaWriter.close();
        ichiranSpoolManager.spool(一覧ファイルパス);
        kekkaSpoolManager.spool(結果ファイルパス);
        一覧ファイル.setValue(一覧ファイルパス);
        結果ファイル.setValue(結果ファイルパス);
    }

    private KyufuKanrihyoInIchiRanEntity create一覧Header() {
        KyufuKanrihyoInIchiRanEntity csvEntity = new KyufuKanrihyoInIchiRanEntity();
        csvEntity.set連番(new RString("連番"));
        csvEntity.set対象年月(new RString("対象年月"));
        csvEntity.set支援事業者番号(new RString("支援事業者番号"));
        csvEntity.set支援事業者名称(new RString("支援事業者名称"));
        csvEntity.set計画作成区分コード(new RString("計画作成区分コード"));
        csvEntity.set計画作成区分(new RString("計画作成区分"));
        csvEntity.set作成区分コード(new RString("作成区分コード"));
        csvEntity.set作成区分(new RString("作成区分"));
        csvEntity.set被保険者番号(new RString("被保険者番号"));
        csvEntity.set被保険者氏名(new RString("被保険者氏名"));
        csvEntity.set作成種別区分コード(new RString("作成種別区分コード"));
        csvEntity.set作成種別区分(new RString("作成種別区分"));
        csvEntity.set要介護状態区分コード(new RString("要介護状態区分コード"));
        csvEntity.set要介護状態区分(new RString("要介護状態区分"));
        csvEntity.set限度額管理期間_開始(new RString("限度額管理期間（開始）"));
        csvEntity.set限度額管理期間_終了(new RString("限度額管理期間（終了）"));
        csvEntity.set区分支給限度基準額(new RString("区分支給限度基準額"));
        csvEntity.set指定サービス単位(new RString("指定サービス単位"));
        csvEntity.set基準該当サービス単位(new RString("基準該当サービス単位"));
        csvEntity.set合計単位(new RString("合計単位"));
        csvEntity.set証記載保険者番号(new RString("証記載保険者番号"));
        csvEntity.set備考(new RString("備考"));
        return csvEntity;
    }

    private KyufuKanrihyoInIchiRanEntity to一覧Data(DbTKyufukanrihyoDataTempTableEntity entity) {

        KyufuKanrihyoInIchiRanEntity csvEntity = new KyufuKanrihyoInIchiRanEntity();

        csvEntity.set連番(new RString(Integer.toString(連番++)));

        RString 対象年月 = entity.getTaishoYM();
        csvEntity.set対象年月(対象年月);

        csvEntity.set支援事業者番号(entity.getServiceTeikyoJigyoshoNo());
        csvEntity.set支援事業者名称(entity.getJigyoshoMeisho());

        KeikakuSakuseiKubun 計画作成区分 = KeikakuSakuseiKubun.toValue(entity.getKyotakuKeikakuSakuseiKubunCode());
        csvEntity.set計画作成区分コード(計画作成区分.getCode());
        csvEntity.set計画作成区分(計画作成区分.getName());

        SakuseiKubun 作成区分 = SakuseiKubun.toValue(entity.getKyufukanrihyoSakuseiKubunCode());
        csvEntity.set作成区分コード(作成区分.getCode());
        csvEntity.set作成区分(作成区分.getName());

        csvEntity.set被保険者番号(entity.getShinHihokenshaNo());
        csvEntity.set被保険者氏名(entity.getKanjiMeisho());

        ShubetsuKubun 作成種別区分 = ShubetsuKubun.toValue(entity.getKyufukanrihyoShubetsuKubunCode());
        csvEntity.set作成種別区分コード(作成種別区分.getCode());
        csvEntity.set作成種別区分(作成種別区分.getName());

        // TODO N8156 宮本 康 URにenum追加後に対応する
        csvEntity.set要介護状態区分コード(entity.getYokaigojotaiKubunCode());
        csvEntity.set要介護状態区分(RString.EMPTY);

        csvEntity.set限度額管理期間_開始(entity.getGendogakuTekiyoKaishiYMD());
        csvEntity.set限度額管理期間_終了(entity.getGendogakuTekiyoShuryoYMD());
        csvEntity.set区分支給限度基準額(getCommaValue(entity.getKyotakuKaigoyoboShikyugendogaku()));

        if (!対象年月.isEmpty() && new FlexibleYearMonth(entity.getTaishoYM()).isBefore(サービス単位出力基準)) {
            csvEntity.set指定サービス単位(getCommaValue(entity.getShiteiServiceShokei()));
            csvEntity.set基準該当サービス単位(getCommaValue(entity.getKijunGaitoServiceShokei()));
        } else {
            csvEntity.set指定サービス単位(RString.EMPTY);
            csvEntity.set基準該当サービス単位(RString.EMPTY);
        }

        csvEntity.set合計単位(getCommaValue(entity.getKyufuKeikakuGokeiTanisuNissu()));
        csvEntity.set証記載保険者番号(entity.getShokisaiHokenshaNo());
        csvEntity.set備考((計画作成区分.getCode().isEmpty() && entity.getJigyoshoMeisho().isEmpty()) ? 支援事業者未登録 : RString.EMPTY);

        if (entity.getKyufukanrihyoMeisaigyoNo().equals(集計レコード)) {
            if (作成種別区分 == ShubetsuKubun.訪問通所サービス) {
                訪問通所サービス件数++;
            } else if (作成種別区分 == ShubetsuKubun.短期入所サービス) {
                短期入所サービス件数++;
            } else if (作成種別区分 == ShubetsuKubun.居宅サービス) {
                居宅サービス件数++;
            }
        }

        return csvEntity;
    }

    private KyufuKanrihyoInKekkaEntity create結果Header() {
        KyufuKanrihyoInKekkaEntity csvEntity = new KyufuKanrihyoInKekkaEntity();
        csvEntity.set作成日付(new RString("作成日付"));
        csvEntity.set作成時間(new RString("作成時間"));
        csvEntity.set出力順名称1(new RString("出力順名称１"));
        csvEntity.set出力順昇降順指示1(new RString("出力順昇降順指示１"));
        csvEntity.set出力順名称2(new RString("出力順名称２"));
        csvEntity.set出力順昇降順指示2(new RString("出力順昇降順指示２"));
        csvEntity.set出力順名称3(new RString("出力順名称３"));
        csvEntity.set出力順昇降順指示3(new RString("出力順昇降順指示３"));
        csvEntity.set出力順名称4(new RString("出力順名称４"));
        csvEntity.set出力順昇降順指示4(new RString("出力順昇降順指示４"));
        csvEntity.set出力順名称5(new RString("出力順名称５"));
        csvEntity.set出力順昇降順指示5(new RString("出力順昇降順指示５"));
        csvEntity.set訪問通所サービス件数(new RString("訪問通所サービス件数"));
        csvEntity.set短期入所サービス件数(new RString("短期入所サービス件数"));
        csvEntity.set居宅サービス件数(new RString("居宅サービス件数"));
        csvEntity.set合計件数(new RString("合計件数"));
        return csvEntity;
    }

    private KyufuKanrihyoInKekkaEntity to結果Data() {

        KyufuKanrihyoInKekkaEntity csvEntity = new KyufuKanrihyoInKekkaEntity();

        RDate 作成日付 = RDate.getNowDate();
        csvEntity.set作成日付(作成日付.seireki().separator(Separator.SLASH).toDateString());

        RTime 作成時間 = RDate.getNowTime();
        csvEntity.set作成時間(new RString(String.format("%1$02d:%2$02d:%3$02d", 作成時間.getHour(), 作成時間.getMinute(), 作成時間.getSecond())));

        csvEntity.set出力順名称1(getParameter(出力順パラメータ.get(0)));
        csvEntity.set出力順昇降順指示1(getParameter(昇降順パラメータ.get(0)));
        csvEntity.set出力順名称2(getParameter(出力順パラメータ.get(1)));
        csvEntity.set出力順昇降順指示2(getParameter(昇降順パラメータ.get(1)));
        csvEntity.set出力順名称3(getParameter(出力順パラメータ.get(2)));
        csvEntity.set出力順昇降順指示3(getParameter(昇降順パラメータ.get(2)));
        csvEntity.set出力順名称4(getParameter(出力順パラメータ.get(3)));
        csvEntity.set出力順昇降順指示4(getParameter(昇降順パラメータ.get(3)));
        csvEntity.set出力順名称5(getParameter(出力順パラメータ.get(4)));
        csvEntity.set出力順昇降順指示5(getParameter(昇降順パラメータ.get(4)));
        csvEntity.set訪問通所サービス件数(getCommaValue(訪問通所サービス件数));
        csvEntity.set短期入所サービス件数(getCommaValue(短期入所サービス件数));
        csvEntity.set居宅サービス件数(getCommaValue(居宅サービス件数));
        csvEntity.set合計件数(getCommaValue(訪問通所サービス件数 + 短期入所サービス件数 + 居宅サービス件数));

        return csvEntity;
    }

    private RString getCommaValue(RString data) {
        if (data == null || data.isEmpty()) {
            return RString.EMPTY;
        }
        return getCommaValue(Integer.parseInt(data.replace(",", "").toString()));
    }

    private RString getCommaValue(int data) {
        return new RString(String.format("%1$,d", data));
    }

    private void setParameter() {
        IOutputOrder outputOrder = shutsuryokujunFinder.get出力順(
                SubGyomuCode.DBC介護給付, 帳票ID, UrControlDataFactory.createInstance().getLoginInfo().getUserId(), 出力順ID.getValue());
        if (outputOrder == null) {
            return;
        }

        List<ISetSortItem> sortItemList = outputOrder.get設定項目リスト();
        for (int index = 0; index < ((sortItemList.size() < 出力順数) ? sortItemList.size() : 出力順数); index++) {
            ISetSortItem sortItem = sortItemList.get(index);
            super.sqlParameter.put(出力順パラメータ.get(index).toString(), sortItem.get項目名());
            super.sqlParameter.put(昇降順パラメータ.get(index).toString(), new RString(sortItem.get昇降順().getOrder()));
        }
    }

    private RString getParameter(RString key) {
        RString value = (RString) super.sqlParameter.get(key.toString());
        return (value != null) ? value : RString.EMPTY;
    }
}
