package jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.fukaatena.FukaAtena;
import jp.co.ndensan.reams.db.dbb.business.core.fukajoho.fukajoho.FukaJoho;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty.DBB100012ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuBeforeCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NokiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.HeijunkaHenkoOutputJoken;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoIdoshaTorokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho.DbTKeisangoJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.DbT2002FukaTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KariSanteigakuHenkoTsuchishoHakkoIchiranData;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2017TsuchishoHakkogoIdoshaDac;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.FukaNokiResearcher;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHohoBuilder;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.TokuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7065ChohyoSeigyoKyotsuDac;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki._Atesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.service.core.maskedkoza.MaskedKozaCreator;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urc.business.core.noki.nokikanri.Noki;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)のビジネスです。
 *
 * @reamsid_L DBB-0820-040 xuyue
 */
public class TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko {

    private final MapperProvider mapperProvider;
    private final ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper mapper;
    private final DbT2017TsuchishoHakkogoIdoshaDac dac;
    private final DbT7065ChohyoSeigyoKyotsuDac dbt7065dac;

    private static final ReportId 帳票分類ID_DBB100012 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private static final ReportId REPORT_ID_DBB100012 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private static final RString 代行プリント送付票_処理名 = new RString("特徴平準化（特徴6月分）通知書一括発行");
    private static final RString ファイル名 = new RString("TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranData.csv");
    private static final RString ファイル名TEMP = new RString("TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranDataTemp.csv");
    private static final RString 拡張子_TEMP = new RString("Temp");
    private static final RString CSVファイル名 = new RString("特別徴収平準化仮算定額変更通知書発行一覧表");
    private static final RString EUCファイル名 = new RString("TokuChoHeijunkaTsuchishoHakkoIchiran.csv");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final RString 抽出条件_発行日 = new RString("【発行日】");
    private static final RString 抽出条件_出力対象 = new RString("【出力対象】");
    private static final int INDEX_6 = 6;
    private static final RString なし = new RString("なし");
    private static final RString あり = new RString("あり");
    private static final RString SIGN = new RString(" ＞ ");
    private static final RString 区分_管内 = new RString("1");
    private static final RString 区分_管外 = new RString("2");
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int 期1 = 1;
    private static final int 期2 = 2;
    private static final int 期3 = 3;
    private static final int 期4 = 4;
    private static final int 期5 = 5;
    private static final int 期6 = 6;
    private static final int 期7 = 7;
    private static final int 期8 = 8;
    private static final int 期9 = 9;
    private static final int 期10 = 10;
    private static final int 期11 = 11;
    private static final int 期12 = 12;
    private static final int 期13 = 13;
    private static final int 期14 = 14;

    /**
     * コンストラクタです。
     */
    TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.class);
        this.dac = InstanceProvider.create(DbT2017TsuchishoHakkogoIdoshaDac.class);
        this.dbt7065dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
    }

    /**
     * 特徴平準化（特徴6月分）通知書一括発行(バッチ)のビジネスを生成します。
     *
     * @return 利用者負担額減額申請（画面）のビジネス
     */
    public static TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko createInstance() {
        return InstanceProvider.create(TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.class);
    }

    /**
     * 計算後情報テーブルの更新前後区分が「更正前」のデータにより、仮算定額変更情報一時テーブルの計算後情報「更正前」情報を更新する。
     *
     * @param param パラメータ
     */
    public void update計算後情報更正前(TokuchoHeijunka6gatsuMyBatisParameter param) {
        mapper.update計算後情報更正前(param);
    }

    /**
     * 通知書発行後異動者登録
     *
     * @param fukaTemp 介護賦課一時テーブルのエンティティ
     * @param param パラメータ
     * @param 連番 連番
     */
    @Transaction
    public void insTsuchishoHakkogoIdosha(DbT2002FukaTempTableEntity fukaTemp, TsuchishoIdoshaTorokuProcessParameter param, int 連番) {

        DbT2017TsuchishoHakkogoIdoshaEntity entity = new DbT2017TsuchishoHakkogoIdoshaEntity();
        entity.setReportID(new ReportId(param.get帳票ID()));
        entity.setChohyosakuseiTimestamp(new YMDHMS(param.get帳票作成日時()));
        entity.setFukaNendo(fukaTemp.getKoseigo_fukaNendo());
        entity.setTsuchishoNo(fukaTemp.getKoseigo_tsuchishoNo());
        entity.setShikibetsuCode(fukaTemp.getKoseigo_shikibetsuCode());
        entity.setHihokenshaNo(fukaTemp.getKoseigo_hihokenshaNo());
        entity.setKeisanTimestamp(fukaTemp.getKoseigo_choteiNichiji());
        entity.setGaitoRemban(連番);
        entity.setIdoAriFlag(false);
        dac.save(entity);
    }

    /**
     * 帳票制御共通情報を取得します。
     *
     * @return 帳票制御共通情報
     */
    public DbT7065ChohyoSeigyoKyotsuEntity find帳票制御共通情報() {
        return dbt7065dac.selectByKey(SubGyomuCode.DBB介護賦課, 帳票分類ID_DBB100012);
    }

    /**
     * 前年度・特徴期別金額06を更新します。
     *
     * @param parameter パラメータ
     */
    public void update前年度特徴期別金額06(TokuchoHeijunka6gatsuMyBatisParameter parameter) {
        mapper.update前年度特徴期別金額06(parameter);
    }

    /**
     * 継続の被保険者区分を更新します。
     *
     * @param entity 介護賦課一時テーブルのエンティティ
     * @return 介護賦課一時テーブルのエンティティ
     */
    public DbT2002FukaTempTableEntity set継続の被保険者区分_更新対象(DbT2002FukaTempTableEntity entity) {
        RString 被保険者区分 = new RString("0");
        entity.setHihokenshaKubun(被保険者区分);
        return entity;
    }

    /**
     * 介護賦課一時テーブルのエンティティの被保険者区分を4月開始にセットします。
     *
     * @param entity 介護賦課一時テーブルのエンティティ
     * @return 介護賦課一時テーブルのエンティティ
     */
    public DbT2002FukaTempTableEntity set4月開始の被保険者区分_更新対象(DbT2002FukaTempTableEntity entity) {
        RString 被保険者区分 = new RString("1");
        entity.setHihokenshaKubun(被保険者区分);
        return entity;
    }

    /**
     * 介護賦課一時テーブルのエンティティの被保険者区分を6月開始にセットします。
     *
     * @param entity 介護賦課一時テーブルのエンティティ
     * @return 介護賦課一時テーブルのエンティティ
     */
    public DbT2002FukaTempTableEntity set6月開始の被保険者区分_更新対象(DbT2002FukaTempTableEntity entity) {
        RString 被保険者区分 = new RString("2");
        entity.setHihokenshaKubun(被保険者区分);
        return entity;
    }

    /**
     * 特別徴収平準化仮算定額変更通知書発行一覧表CSVを出力して、代行プリント送付票の出力とバッチ条件を出力します。
     *
     * @param csv有無 csv有無 true:有
     * @param parameter 帳票の発行パラメータ
     * @param 帳票制御共通情報 帳票制御共通情報
     * @param 導入団体クラス 導入団体クラス
     * @param outputOrder outputOrder
     * @param 通知書ページ数 通知書ページ数
     */
    public void 代行プリント送付票の出力とバッチ条件の出力(boolean csv有無,
            TsuchishoHakoProcessParameter parameter, DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報,
            Association 導入団体クラス,
            IOutputOrder outputOrder, int 通知書ページ数) {

        代行プリント送付票の出力(parameter, 帳票制御共通情報, 導入団体クラス, outputOrder, 通知書ページ数);
        バッチ出力条件リストの出力(parameter, 導入団体クラス, outputOrder, csv有無, 通知書ページ数);
    }

    /**
     * 帳票の改頁を設定します。
     *
     * @param outputOrder IOutputOrder
     * @param pageBreakKeys pageBreakKeys
     */
    public void set改頁Key(IOutputOrder outputOrder, List pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
                改頁１ = to帳票物理名(list.get(0).get項目ID());
            }
            if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
                改頁２ = to帳票物理名(list.get(INDEX_1).get項目ID());
            }
            if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
                改頁３ = to帳票物理名(list.get(INDEX_2).get項目ID());
            }
            if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
                改頁４ = to帳票物理名(list.get(INDEX_3).get項目ID());
            }
            if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
                改頁５ = to帳票物理名(list.get(INDEX_4).get項目ID());
            }

            if (!改頁１.isEmpty()) {
                pageBreakKeys.add(改頁１);
            }
            if (!改頁２.isEmpty()) {
                pageBreakKeys.add(改頁２);
            }
            if (!改頁３.isEmpty()) {
                pageBreakKeys.add(改頁３);
            }
            if (!改頁４.isEmpty()) {
                pageBreakKeys.add(改頁４);
            }
            if (!改頁５.isEmpty()) {
                pageBreakKeys.add(改頁５);
            }
        }
    }

    /**
     * 仮算定額変更通知書情報を作成します。
     *
     * @param param 帳票の発行パラメータ
     * @param tmpEntity 仮算定額変更情報一時テーブルエンティティ
     * @param 帳票制御共通情報 帳票制御共通情報
     * @param association association
     * @return 仮算定額変更通知書情報
     */
    public KariSanteiTsuchiShoKyotsu 仮算定額変更通知書情報の作成(TsuchishoHakoProcessParameter param, KarisanteiGakuHenkoEntity tmpEntity,
            DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報, Association association) {

        KariSanteiTsuchiShoKyotsu kariSanteiTsuchiShoKyotsu = new KariSanteiTsuchiShoKyotsu();
        kariSanteiTsuchiShoKyotsu.set発行日(param.get発行日());
        kariSanteiTsuchiShoKyotsu.set帳票分類ID(REPORT_ID_DBB100012);
        kariSanteiTsuchiShoKyotsu.set処理区分(ShoriKubun.バッチ);
        kariSanteiTsuchiShoKyotsu.set地方公共団体(association);
        kariSanteiTsuchiShoKyotsu.set賦課の情報_更正後(getFukaAtena(tmpEntity, tmpEntity.get更正後計算後情報()));
        kariSanteiTsuchiShoKyotsu.set賦課の情報_更正前(getFukaAtena(tmpEntity, tmpEntity.get更正前計算後情報()));
        kariSanteiTsuchiShoKyotsu.set納組情報(tmpEntity.get納組());
        kariSanteiTsuchiShoKyotsu.set普徴納期情報リスト(get普徴納期情報リスト(new RYear(param.get調定年度().toString())));
        kariSanteiTsuchiShoKyotsu.set特徴納期情報リスト(get特徴納期情報リスト(new RYear(param.get調定年度().toString())));
        if (tmpEntity.get宛先() != null) {
            kariSanteiTsuchiShoKyotsu.set宛先情報(new _Atesaki(tmpEntity.get宛先()));
        }
        kariSanteiTsuchiShoKyotsu.set口座情報(set口座(tmpEntity.get口座()));
        kariSanteiTsuchiShoKyotsu.set徴収方法情報_更正前(set徴収方法情報(tmpEntity.get更正前計算後情報()));
        kariSanteiTsuchiShoKyotsu.set徴収方法情報_更正後(set徴収方法情報(tmpEntity.get更正後計算後情報()));
        if (tmpEntity.get対象者_追加含む情報_更正後() != null) {
            kariSanteiTsuchiShoKyotsu.set対象者_追加含む_情報_更正後(new NenkinTokuchoKaifuJoho(tmpEntity.get対象者_追加含む情報_更正後()));
        }
        kariSanteiTsuchiShoKyotsu.set帳票制御共通(new ChohyoSeigyoKyotsu(帳票制御共通情報));
        return kariSanteiTsuchiShoKyotsu;
    }

    /**
     * csvファイルのデータを作成します。
     *
     * @param 編集後仮算定通知書共通 編集後仮算定通知書共通
     * @param param 帳票の発行パラメータ
     * @param 連番 連番
     * @param 通知書番号 通知書番号
     * @param entity 仮算定額変更情報一時テーブルのエンティティ
     * @return csvデータ
     */
    public KariSanteigakuHenkoTsuchishoHakkoIchiranData csvData作成(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通,
            TsuchishoHakoProcessParameter param, int 連番, TsuchishoNo 通知書番号, KarisanteiGakuHenkoEntity entity) {

        EditedKariSanteiTsuchiShoKyotsuBeforeCorrection 更正前;
        if (編集後仮算定通知書共通.get更正前() == null) {
            更正前 = new EditedKariSanteiTsuchiShoKyotsuBeforeCorrection();
        } else {
            更正前 = 編集後仮算定通知書共通.get更正前();
        }

        KariSanteigakuHenkoTsuchishoHakkoIchiranData data = new KariSanteigakuHenkoTsuchishoHakkoIchiranData();

        RString 調定日時 = param.get帳票作成日時().getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        data.set作成年月日(調定日時);
        data.set作成日時(調定日時);
        data.set年度(param.get賦課年度().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).fillType(FillType.BLANK).toDateString());
        data.set連番(new RString(連番));
        if (編集後仮算定通知書共通.get編集後宛先() != null) {
            data.set郵便番号(編集後仮算定通知書共通.get編集後宛先().get郵便番号());
            data.set住所(編集後仮算定通知書共通.get編集後宛先().get編集後住所());
            set町域管内管外住所(編集後仮算定通知書共通, data, entity);
            if (編集後仮算定通知書共通.get編集後宛先().get行政区コード() != null) {
                data.set行政区コード(編集後仮算定通知書共通.get編集後宛先().get行政区コード().getColumnValue());
            }
        }
        if (編集後仮算定通知書共通.get編集後個人() != null) {
            data.set性別(編集後仮算定通知書共通.get編集後個人().get性別());
            data.set生年月日(編集後仮算定通知書共通.get編集後個人().get生年月日Csv());

            if (編集後仮算定通知書共通.get編集後個人().get番地() != null) {
                data.set番地(編集後仮算定通知書共通.get編集後個人().get番地().getColumnValue());
            }
            if (編集後仮算定通知書共通.get編集後個人().get世帯コード() != null) {
                data.set世帯コード(編集後仮算定通知書共通.get編集後個人().get世帯コード().getColumnValue());
            }
            if (編集後仮算定通知書共通.get編集後個人().get名称() != null) {
                data.set被保険者氏名(編集後仮算定通知書共通.get編集後個人().get名称().getName().getColumnValue());
            }
        }

        if (更正前.get更正前特徴期別金額01() != null) {
            data.set変更前特徴額１期(new RString(更正前.get更正前特徴期別金額01().toString()));
        }
        if (更正前.get更正前特徴期別金額02() != null) {
            data.set変更前特徴額２期(new RString(更正前.get更正前特徴期別金額02().toString()));
        }
        if (更正前.get更正前特徴期別金額03() != null) {
            data.set変更前特徴額３期(new RString(更正前.get更正前特徴期別金額03().toString()));
        }
        if (通知書番号 != null) {
            data.set通知書番号(通知書番号.getColumnValue());
        }

        set更正後(編集後仮算定通知書共通, data);
        return data;
    }

    private void set町域管内管外住所(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通,
            KariSanteigakuHenkoTsuchishoHakkoIchiranData data, KarisanteiGakuHenkoEntity entity) {
        if (entity.get宛名() != null && 区分_管内.equals(entity.get宛名().getKannaiKangaiKubun())) {
            data.set町域管内管外住所(編集後仮算定通知書共通.get編集後宛先().get町域());
        } else if (entity.get宛名() != null && 区分_管外.equals(entity.get宛名().getKannaiKangaiKubun())) {
            AtenaJusho 住所 = entity.get宛名().getJusho();
            if (住所 != null) {
                data.set町域管内管外住所(住所.getColumnValue());
            }
        }
    }

    private void set更正後(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通, KariSanteigakuHenkoTsuchishoHakkoIchiranData data) {
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後;
        if (編集後仮算定通知書共通.get更正後() == null) {
            更正後 = new EditedKariSanteiTsuchiShoKyotsuAfterCorrection();
        } else {
            更正後 = 編集後仮算定通知書共通.get更正後();
        }
        data.set特別徴収業務者コード(更正後.get更正後特別徴収義務者コード());
        data.set特別徴収業務者(更正後.get更正後特別徴収義務者());
        data.set特別徴収対象年金コード(更正後.get更正後特別徴収対象年金コード());
        data.set特別徴収対象年金(更正後.get更正後特別徴収対象年金());
        if (更正後.get更正後特徴期別金額01() != null) {
            data.set変更後特徴額１期(new RString(更正後.get更正後特徴期別金額01().toString()));
        }
        if (更正後.get更正後特徴期別金額02() != null) {
            data.set変更後特徴額２期(new RString(更正後.get更正後特徴期別金額02().toString()));
        }
        if (更正後.get更正後特徴期別金額03() != null) {
            data.set変更後特徴額３期(new RString(更正後.get更正後特徴期別金額03().toString()));
        }
    }

    private void set改頁名前(IOutputOrder outputOrder, List pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.size() > INDEX_0 && list.get(INDEX_0).is改頁項目()) {
                改頁１ = to帳票フィールド名前(list.get(INDEX_0));
            }
            if (list.size() > INDEX_1 && list.get(INDEX_1).is改頁項目()) {
                改頁２ = to帳票フィールド名前(list.get(INDEX_1));
            }
            if (list.size() > INDEX_2 && list.get(INDEX_2).is改頁項目()) {
                改頁３ = to帳票フィールド名前(list.get(INDEX_2));
            }
            if (list.size() > INDEX_3 && list.get(INDEX_3).is改頁項目()) {
                改頁４ = to帳票フィールド名前(list.get(INDEX_3));
            }
            if (list.size() > INDEX_4 && list.get(INDEX_4).is改頁項目()) {
                改頁５ = to帳票フィールド名前(list.get(INDEX_4));
            }

            if (!改頁１.isEmpty()) {
                pageBreakKeys.add(改頁１);
            }
            if (!改頁２.isEmpty()) {
                pageBreakKeys.add(改頁２);
            }
            if (!改頁３.isEmpty()) {
                pageBreakKeys.add(改頁３);
            }
            if (!改頁４.isEmpty()) {
                pageBreakKeys.add(改頁４);
            }
            if (!改頁５.isEmpty()) {
                pageBreakKeys.add(改頁５);
            }
        }
    }

    /**
     * 代行プリント送付票の出力を行います。
     *
     * @param param 帳票発行パラメータ
     * @param 帳票制御共通情報 帳票制御共通情報
     * @param 導入団体クラス 導入団体クラス
     * @param outputOrder outputOrder
     * @param 通知書ページ数 通知書ページ数
     */
    private void 代行プリント送付票の出力(TsuchishoHakoProcessParameter param, DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報,
            Association 導入団体クラス,
            IOutputOrder outputOrder, int 通知書ページ数) {
        if (!帳票制御共通情報.getDaikoPrintUmu()) {
            return;
        }

        List<RString> 出力順項目List = new ArrayList<>();
        int i = 1;
        if (outputOrder != null && outputOrder.get設定項目リスト() != null) {
            for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
                if (i++ <= INDEX_5) {
                    出力順項目List.add(setSortItem.get項目名());
                }
            }
        }

        List<RString> 改ページ項目List = new ArrayList<>();
        set改頁名前(outputOrder, 改ページ項目List);

        List<Decimal> ページ数List = new ArrayList<>();
        ページ数List.add(new Decimal(通知書ページ数));

        List<RString> 抽出条件List = new ArrayList<>();
        RStringBuilder 発行日Builder = new RStringBuilder();
        RStringBuilder 出力対象Builder = new RStringBuilder();
        発行日Builder.append(抽出条件_発行日).append(param.get発行日().wareki().toDateString());
        出力対象Builder.append(抽出条件_出力対象).append(HeijunkaHenkoOutputJoken.toValue(new RString(param.get出力対象区分())));
        抽出条件List.add(発行日Builder.toRString());
        抽出条件List.add(出力対象Builder.toRString());

        List<RString> 帳票名List = new ArrayList<>();
        if (ReportIdDBB.DBB100012.getReportId().getColumnValue().equals(param.get帳票ID())) {
            帳票名List.add(ReportIdDBB.DBB100012.getReportName());
        } else {
            帳票名List.add(ReportIdDBB.DBB100013.getReportName());
        }

        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBB介護賦課,
                導入団体クラス.getLasdecCode_(), 導入団体クラス.get市町村名(),
                ジョブ番号.concat(RString.HALF_SPACE).concat(new RString(String.valueOf(JobContextHolder.getJobId()))),
                代行プリント送付票_処理名,
                代行プリント送付票_帳票ID.getColumnValue(),
                帳票名List, ページ数List, 抽出条件List,
                出力順項目List, 改ページ項目List, Collections.<RString>emptyList());
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        daikoPrint.print();
    }

    /**
     * バッチ出力条件リストの出力を行います。
     *
     * @param param 帳票発行パラメータ
     * @param association 導入団体クラス
     * @param outputOrder IOutputOrder
     * @param csv有無 true:有 false:無
     * @param 通知書一覧ページ数 通知書一覧ページ数
     */
    private void バッチ出力条件リストの出力(TsuchishoHakoProcessParameter param, Association association,
            IOutputOrder outputOrder, boolean csv有無,
            int 通知書ページ数) {

        RString csv出力有無 = csv有無 ? あり : なし;
        RString csvファイル名 = csv有無 ? CSVファイル名 : new RString("-");

        List<RString> 出力条件List = new ArrayList<>();
        RStringBuilder 発行日Builder = new RStringBuilder();
        RStringBuilder 出力対象Builder = new RStringBuilder();
        RStringBuilder 出力順Builder = new RStringBuilder();
        発行日Builder.append(抽出条件_発行日).append(param.get発行日().wareki().toDateString());
        出力対象Builder.append(抽出条件_出力対象).append(HeijunkaHenkoOutputJoken.toValue(new RString(param.get出力対象区分())));

        List<ISetSortItem> list = outputOrder.get設定項目リスト();
        if (list != null && list.size() > INDEX_0) {
            出力順Builder.append(list.get(INDEX_0).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > INDEX_1) {
            出力順Builder.append(list.get(INDEX_1).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > INDEX_2) {
            出力順Builder.append(list.get(INDEX_2).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > INDEX_3) {
            出力順Builder.append(list.get(INDEX_3).get項目名()).append(SIGN);
        }
        if (list != null && list.size() > INDEX_4) {
            出力順Builder.append(list.get(INDEX_4).get項目名()).append(SIGN);
        }
        RString 出力順RStr = RString.EMPTY;
        if (出力順Builder.length() > 0) {
            出力順RStr = 出力順Builder.substring(0, 出力順Builder.length() - INDEX_3);
        }

        出力条件List.add(発行日Builder.toRString());
        出力条件List.add(出力対象Builder.toRString());
        出力条件List.add(出力順RStr);

        RString 帳票名;
        if (ReportIdDBB.DBB100012.getReportId().getColumnValue().equals(param.get帳票ID())) {
            帳票名 = ReportIdDBB.DBB100012.getReportName();
        } else {
            帳票名 = ReportIdDBB.DBB100013.getReportName();
        }

        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                param.get帳票ID(), association.getLasdecCode_().getColumnValue(), association.get市町村名(),
                ジョブ番号.concat(RString.HALF_SPACE).concat(new RString(String.valueOf(JobContextHolder.getJobId()))),
                帳票名,
                new RString(通知書ページ数.toString()), csv出力有無, csvファイル名, 出力条件List);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;

        if (DBB100012ShutsuryokujunEnum.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_郵便;
        } else if (DBB100012ShutsuryokujunEnum.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_行政区コード;
        } else if (DBB100012ShutsuryokujunEnum.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_世帯コード;
        } else if (DBB100012ShutsuryokujunEnum.生年月日.get項目ID().equals(項目ID)) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_生年月日;
        } else if (DBB100012ShutsuryokujunEnum.性別.get項目ID().equals(項目ID)) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_性別;
        } else if (DBB100012ShutsuryokujunEnum.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource.改頁_市町村コード;
        }

        return 帳票物理名;
    }

    private RString to帳票フィールド名前(ISetSortItem item) {

        RString 帳票物理名 = RString.EMPTY;

        if (DBB100012ShutsuryokujunEnum.郵便番号.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = item.get項目名();
        } else if (DBB100012ShutsuryokujunEnum.行政区コード.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = item.get項目名();
        } else if (DBB100012ShutsuryokujunEnum.世帯コード.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = item.get項目名();
        } else if (DBB100012ShutsuryokujunEnum.生年月日.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = item.get項目名();
        } else if (DBB100012ShutsuryokujunEnum.性別.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = item.get項目名();
        } else if (DBB100012ShutsuryokujunEnum.市町村コード.get項目ID().equals(item.get項目ID())) {
            帳票物理名 = item.get項目名();
        }

        return 帳票物理名;
    }

    private FukaAtena getFukaAtena(KarisanteiGakuHenkoEntity entity, DbTKeisangoJohoTempTableEntity 計算後情報) {
        if (計算後情報 == null) {
            return new FukaAtena();
        }

        FukaJohoRelateEntity fukaJohoRelateEntity = new FukaJohoRelateEntity();
        DbT2002FukaEntity dbT2002FukaEntity = fukaJohoRelateEntity.get介護賦課Entity();
        dbT2002FukaEntity.setChoteiNendo(計算後情報.getChoteiNendo());
        dbT2002FukaEntity.setChoteiNendo(計算後情報.getChoteiNendo());
        dbT2002FukaEntity.setFukaNendo(計算後情報.getFukaNendo());
        dbT2002FukaEntity.setTsuchishoNo(計算後情報.getTsuchishoNo());
        dbT2002FukaEntity.setRirekiNo(計算後情報.getFukaRirekiNo());
        dbT2002FukaEntity.setHihokenshaNo(計算後情報.getHihokenshaNo());
        dbT2002FukaEntity.setShikibetsuCode(計算後情報.getShikibetsuCode());
        dbT2002FukaEntity.setSetaiCode(計算後情報.getSetaiCode());
        dbT2002FukaEntity.setSetaiInsu(計算後情報.getSetaiInsu());
        dbT2002FukaEntity.setShikakuShutokuYMD(計算後情報.getShikakuShutokuYMD());
        dbT2002FukaEntity.setShikakuShutokuJiyu(計算後情報.getShikakuShutokuJiyu());
        dbT2002FukaEntity.setShikakuSoshitsuYMD(計算後情報.getShikakuSoshitsuYMD());
        dbT2002FukaEntity.setShikakuSoshitsuJiyu(計算後情報.getShikakuSoshitsuJiyu());
        dbT2002FukaEntity.setSeihofujoShurui(計算後情報.getSeihofujoShurui());
        dbT2002FukaEntity.setSeihoKaishiYMD(計算後情報.getSeihoKaishiYMD());
        dbT2002FukaEntity.setSeihoHaishiYMD(計算後情報.getSeihoHaishiYMD());
        dbT2002FukaEntity.setRonenKaishiYMD(計算後情報.getRonenKaishiYMD());
        dbT2002FukaEntity.setRonenHaishiYMD(計算後情報.getRonenHaishiYMD());
        dbT2002FukaEntity.setFukaYMD(計算後情報.getFukaYMD());
        dbT2002FukaEntity.setKazeiKubun(計算後情報.getKazeiKubun());
        dbT2002FukaEntity.setSetaikazeiKubun(計算後情報.getSetaikazeiKubun());
        dbT2002FukaEntity.setGokeiShotokuGaku(計算後情報.getGokeiShotokuGaku());
        dbT2002FukaEntity.setNenkinShunyuGaku(計算後情報.getNenkinShunyuGaku());
        dbT2002FukaEntity.setHokenryoDankai(計算後情報.getHokenryoDankai());
        dbT2002FukaEntity.setHokenryoDankai1(計算後情報.getHokenryoDankai1());
        dbT2002FukaEntity.setNengakuHokenryo1(計算後情報.getNengakuHokenryo1());
        dbT2002FukaEntity.setTsukiwariStartYM1(計算後情報.getTsukiwariStartYM1());
        dbT2002FukaEntity.setTsukiwariEndYM1(計算後情報.getTsukiwariEndYM1());
        dbT2002FukaEntity.setHokenryoDankai2(計算後情報.getHokenryoDankai2());
        dbT2002FukaEntity.setNengakuHokenryo2(計算後情報.getNengakuHokenryo2());
        dbT2002FukaEntity.setTsukiwariStartYM2(計算後情報.getTsukiwariStartYM2());
        dbT2002FukaEntity.setTsukiwariEndYM2(計算後情報.getTsukiwariEndYM2());
        dbT2002FukaEntity.setChoteiNichiji(計算後情報.getChoteiNichiji());
        dbT2002FukaEntity.setChoteiJiyu1(計算後情報.getChoteiJiyu1());
        dbT2002FukaEntity.setChoteiJiyu2(計算後情報.getChoteiJiyu2());
        dbT2002FukaEntity.setChoteiJiyu3(計算後情報.getChoteiJiyu3());
        dbT2002FukaEntity.setChoteiJiyu4(計算後情報.getChoteiJiyu4());
        dbT2002FukaEntity.setKoseiM(計算後情報.getKoseiM());
        dbT2002FukaEntity.setGemmenMaeHokenryo(計算後情報.getGemmenMaeHokenryo());
        dbT2002FukaEntity.setGemmenGaku(計算後情報.getGemmenGaku());
        dbT2002FukaEntity.setKakuteiHokenryo(計算後情報.getKakuteiHokenryo());
        dbT2002FukaEntity.setHokenryoDankaiKarisanntei(計算後情報.getHokenryoDankaiKarisanntei());
        dbT2002FukaEntity.setChoshuHohoRirekiNo(計算後情報.getChoshuHohoRirekiNo());
        dbT2002FukaEntity.setIdoKijunNichiji(計算後情報.getIdoKijunNichiji());
        dbT2002FukaEntity.setKozaKubun(計算後情報.getKozaKubun());
        dbT2002FukaEntity.setKyokaisoKubun(計算後情報.getKyokaisoKubun());
        dbT2002FukaEntity.setShokkenKubun(計算後情報.getShokkenKubun());
        dbT2002FukaEntity.setFukaShichosonCode(計算後情報.getFukaShichosonCode());
        dbT2002FukaEntity.setTkSaishutsuKampuGaku(計算後情報.getTkSaishutsuKampuGaku());
        dbT2002FukaEntity.setFuSaishutsuKampuGaku(計算後情報.getFuSaishutsuKampuGaku());

        FukaJoho fukaJoho = new FukaJoho(fukaJohoRelateEntity);
        IKojin kojin = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        FukaAtena fukaAtena = new FukaAtena();
        fukaAtena.set賦課情報(fukaJoho);
        fukaAtena.set宛名(kojin);
        return fukaAtena;
    }

    private IKoza set口座(TokuteiKozaRelateEntity koza) {
        if (koza == null || koza.getUaT0310KozaEntity().getKozaId() == 0L) {
            return null;
        }
        MaskedKozaCreator maskedKozaCreator = MaskedKozaCreator.createInstance(SubGyomuCode.DBB介護賦課);
        return maskedKozaCreator.createマスク編集済口座(new Koza(koza));
    }

    private ChoshuHoho set徴収方法情報(DbTKeisangoJohoTempTableEntity entity) {
        if (entity == null || entity.getFukaNendo() == null || entity.getHihokenshaNo() == null) {
            return null;
        }
        ChoshuHoho choshuHoho = new ChoshuHoho(entity.getFukaNendo(), entity.getHihokenshaNo(), entity.getFukaRirekiNo());
        ChoshuHohoBuilder builder = choshuHoho.createBuilderForEdit();
        builder.set仮徴収_基礎年金番号(entity.getKariNenkinNo());
        builder.set仮徴収_年金コード(entity.getKariNenkinCode());
        builder.set仮徴収_捕捉月(entity.getKariHosokuM());
        builder.set依頼情報送付済みフラグ(entity.isIraiSohuzumiFlag());
        builder.set履歴番号(entity.getFukaRirekiNo());
        builder.set徴収方法10月(entity.getChoshuHoho10gatsu());
        builder.set徴収方法11月(entity.getChoshuHoho11gatsu());
        builder.set徴収方法12月(entity.getChoshuHoho12gatsu());
        builder.set徴収方法1月(entity.getChoshuHoho1gatsu());
        builder.set徴収方法2月(entity.getChoshuHoho2gatsu());
        builder.set徴収方法3月(entity.getChoshuHoho3gatsu());
        builder.set徴収方法4月(entity.getChoshuHoho4gatsu());
        builder.set徴収方法5月(entity.getChoshuHoho5gatsu());
        builder.set徴収方法6月(entity.getChoshuHoho6gatsu());
        builder.set徴収方法7月(entity.getChoshuHoho7gatsu());
        builder.set徴収方法8月(entity.getChoshuHoho8gatsu());
        builder.set徴収方法9月(entity.getChoshuHoho9gatsu());
        builder.set徴収方法翌4月(entity.getChoshuHohoYoku4gatsu());
        builder.set徴収方法翌5月(entity.getChoshuHohoYoku5gatsu());
        builder.set徴収方法翌6月(entity.getChoshuHohoYoku6gatsu());
        builder.set徴収方法翌7月(entity.getChoshuHohoYoku7gatsu());
        builder.set徴収方法翌8月(entity.getChoshuHohoYoku8gatsu());
        builder.set徴収方法翌9月(entity.getChoshuHohoYoku9gatsu());
        builder.set本徴収_基礎年金番号(entity.getHonNenkinNo());
        builder.set本徴収_年金コード(entity.getHonNenkinCode());
        builder.set本徴収_捕捉月(entity.getHonHosokuM());
        builder.set特別徴収停止事由コード(entity.getTokuchoTeishiJiyuCode());
        builder.set特別徴収停止日時(entity.getTokuchoTeishiNichiji());
        builder.set翌年度仮徴収_基礎年金番号(entity.getYokunendoKariNenkinNo());
        builder.set翌年度仮徴収_年金コード(entity.getYokunendoKariNenkinCode());
        builder.set被保険者番号(entity.getHihokenshaNo());
        builder.set賦課年度(entity.getFukaNendo());
        builder.set追加依頼情報送付済みフラグ(entity.isTsuikaIraiSohuzumiFlag());
        return builder.build();

    }

    private List<NokiJoho> get普徴納期情報リスト(RYear 調定年度) {

        FukaNokiResearcher 賦課納期取得 = new FukaNokiResearcher(調定年度);
        Noki noki;
        NokiJoho nokiJoho;

        List<NokiJoho> 普徴納期情報リスト = new ArrayList<>();
        for (Kitsuki 期月 : new FuchoKiUtil().get期月リスト().filtered仮算定期間().toList()) {
            noki = 賦課納期取得.get普徴納期(期月.get期AsInt());
            nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月);
            nokiJoho.set納期(noki);
            普徴納期情報リスト.add(nokiJoho);
        }
        return 普徴納期情報リスト;
    }

    private List<NokiJoho> get特徴納期情報リスト(RYear 調定年度) {
        FukaNokiResearcher 賦課納期取得 = new FukaNokiResearcher(調定年度);
        Noki noki;
        NokiJoho nokiJoho;

        List<NokiJoho> 特徴納期情報リスト = new ArrayList<>();
        for (int i = 1; i <= INDEX_6; i++) {
            Kitsuki 期月 = new TokuchoKiUtil().get期月リスト().get期の最初月(i);
            noki = 賦課納期取得.get普徴納期(期月.get期AsInt());
            nokiJoho = new NokiJoho();
            nokiJoho.set期月(期月);
            nokiJoho.set納期(noki);
            特徴納期情報リスト.add(nokiJoho);
        }
        return 特徴納期情報リスト;
    }

    /**
     * 編集後仮算定通知書に、普徴と特徴情報を設定します。
     *
     * @param 編集後仮算定通知書 編集後仮算定通知書
     * @param entity 仮算定額変更情報一時テーブルのデータエンティティ
     */
    public void set普徴と特徴(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書, KarisanteiGakuHenkoEntity entity) {
        List<UniversalPhase> 更正前普徴期別金額リスト = new ArrayList<>();
        List<UniversalPhase> 更正後普徴期別金額リスト = new ArrayList<>();

        if (編集後仮算定通知書.get更正前() != null) {
            更正前普徴期別金額リスト.add(setUniversalPhase(期1, entity.get更正前計算後情報().getFuKibetsuGaku01()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期2, entity.get更正前計算後情報().getFuKibetsuGaku02()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期3, entity.get更正前計算後情報().getFuKibetsuGaku03()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期4, entity.get更正前計算後情報().getFuKibetsuGaku04()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期5, entity.get更正前計算後情報().getFuKibetsuGaku05()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期6, entity.get更正前計算後情報().getFuKibetsuGaku06()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期7, entity.get更正前計算後情報().getFuKibetsuGaku07()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期8, entity.get更正前計算後情報().getFuKibetsuGaku08()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期9, entity.get更正前計算後情報().getFuKibetsuGaku09()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期10, entity.get更正前計算後情報().getFuKibetsuGaku10()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期11, entity.get更正前計算後情報().getFuKibetsuGaku11()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期12, entity.get更正前計算後情報().getFuKibetsuGaku12()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期13, entity.get更正前計算後情報().getFuKibetsuGaku13()));
            更正前普徴期別金額リスト.add(setUniversalPhase(期14, entity.get更正前計算後情報().getFuKibetsuGaku14()));
            編集後仮算定通知書.get更正前().set更正前普徴期別金額リスト(更正前普徴期別金額リスト);
            編集後仮算定通知書.get更正前().set更正前特徴期別金額01(entity.get更正前計算後情報().getTkKibetsuGaku01());
            編集後仮算定通知書.get更正前().set更正前特徴期別金額02(entity.get更正前計算後情報().getTkKibetsuGaku02());
            編集後仮算定通知書.get更正前().set更正前特徴期別金額03(entity.get更正前計算後情報().getTkKibetsuGaku03());
        }
        if (編集後仮算定通知書.get更正後() != null) {
            更正後普徴期別金額リスト.add(setUniversalPhase(期1, entity.get更正後計算後情報().getFuKibetsuGaku01()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期2, entity.get更正後計算後情報().getFuKibetsuGaku02()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期3, entity.get更正後計算後情報().getFuKibetsuGaku03()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期4, entity.get更正後計算後情報().getFuKibetsuGaku04()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期5, entity.get更正後計算後情報().getFuKibetsuGaku05()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期6, entity.get更正後計算後情報().getFuKibetsuGaku06()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期7, entity.get更正後計算後情報().getFuKibetsuGaku07()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期8, entity.get更正後計算後情報().getFuKibetsuGaku08()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期9, entity.get更正後計算後情報().getFuKibetsuGaku09()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期10, entity.get更正後計算後情報().getFuKibetsuGaku10()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期11, entity.get更正後計算後情報().getFuKibetsuGaku11()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期12, entity.get更正後計算後情報().getFuKibetsuGaku12()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期13, entity.get更正後計算後情報().getFuKibetsuGaku13()));
            更正後普徴期別金額リスト.add(setUniversalPhase(期14, entity.get更正後計算後情報().getFuKibetsuGaku14()));
            編集後仮算定通知書.get更正後().set更正後普徴期別金額リスト(更正後普徴期別金額リスト);
            編集後仮算定通知書.get更正後().set更正後特徴期別金額01(entity.get更正後計算後情報().getTkKibetsuGaku01());
            編集後仮算定通知書.get更正後().set更正後特徴期別金額02(entity.get更正後計算後情報().getTkKibetsuGaku02());
            編集後仮算定通知書.get更正後().set更正後特徴期別金額03(entity.get更正後計算後情報().getTkKibetsuGaku03());
        }
    }

    private UniversalPhase setUniversalPhase(int 期, Decimal 金額) {
        UniversalPhase uni = new UniversalPhase();
        uni.set期(期);
        uni.set金額(金額);
        return uni;
    }

}
