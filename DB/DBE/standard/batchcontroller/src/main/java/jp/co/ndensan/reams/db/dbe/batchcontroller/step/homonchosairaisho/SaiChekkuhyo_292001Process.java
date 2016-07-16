/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.saichekkuhyo.SaiChekkuhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ChosahyoSaiCheckhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「認定調査票差異チェック票_DBE292001」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class SaiChekkuhyo_292001Process extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get認定調査結果");
    private static final ReportId 帳票ID = ReportIdDBE.DBE292001.getReportId();
    private static final RString 文字列1 = new RString("1");
    private static final RString IRAIFROMYMD = new RString("【依頼開始日】");
    private static final RString IRAITOYMD = new RString("【依頼終了日】");
    private static final RString NINTEIOCHOSAIRAISHO = new RString("【認定調査依頼書印刷区分】");
    private static final RString NINTEICHOSAHYO = new RString("【認定調査票印刷区分】");
    private static final RString NINTEICHOSAIRAILIST = new RString("【認定調査依頼リスト】");
    private static final RString NINTEICHOSAITAKUSAKICODE = new RString("　　【認定調査委託先コード】");
    private static final RString NINTEICHOSAINCODE = new RString("　　【認定調査員コード】");
    private static final RString SHOKISAIHOKENSHANO = new RString("　　【証記載保険者番号】");
    private static final RString HAKKOBI = new RString("【発行日】");
    private static final RString TEISHUTSUKIGEN = new RString("【提出期限】");
    private static final RString KYOTSUHIZUKE = new RString("【共通日付】");
    private static final RString NINTEICHOSAIRAISYO = new RString("【認定調査依頼書出力区分】");
    private static final RString NINTEICHOSAHYOKIHON = new RString("【認定調査票(基本調査)出力区分】");
    private static final RString NINTEICHOSAHYOTOKKI = new RString("【認定調査票(特記事項)出力区分】");
    private static final RString NINTEICHOSAHYOGAIKYOU = new RString("【認定調査票(概況調査)出力区分】");
    private static final RString NINTEICHOSAHYOOCRKIHON = new RString("【認定調査票OCR(基本調査)出力区分】");
    private static final RString NINTEICHOSAHYOOCRTOKKI = new RString("【認定調査票OCR(特記事項)出力区分】");
    private static final RString NINTEICHOSAHYOOCRGAIKYOU = new RString("【認定調査票OCR(概況調査)出力区分】");
    private static final RString NINTEICHOSACHECKHYO = new RString("【認定調査差異チェック表出力区分】");
    private static final RString NINTEICHOSAIRAICHOHYO = new RString("【認定調査依頼一覧表出力区分】");
    private static final RString ZENKONINTEICHOSAHYO = new RString("【前回認定調査結果との比較表出力区分】");
    private static final RString IFSHIKIBETSUCODE99A = new RString("99A");
    private static final RString IFSHIKIBETSUCODE02A = new RString("02A");
    private static final RString IFSHIKIBETSUCODE06A = new RString("06A");
    private static final RString IFSHIKIBETSUCODE09A = new RString("09A");
    private RString shinseishoKanriNo = RString.EMPTY;
    private List<ChosahyoSaiCheckhyoRelateEntity> checkEntityList;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private HomonChosaIraishoProcessParamter processParamter;
    private final Map<RString, RString> 前回連番Map = new HashMap();
    @BatchWriter
    private BatchReportWriter<SaiChekkuhyoReportSource> batchReportWriter;
    private ReportSourceWriter<SaiChekkuhyoReportSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201EntityWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        checkEntityList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        dbT5201EntityWriter = new BatchPermanentTableWriter(DbT5201NinteichosaIraiJohoEntity.class);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        getcheckEntityList(entity);
        update認定調査依頼情報(entity);
    }

    @Override
    protected void afterExecute() {
        List<SaiChekkuhyoItem> itemList = new ArrayList<>();
        for (ChosahyoSaiCheckhyoRelateEntity checkEntity : checkEntityList) {
            itemList.add(setItem(checkEntity));
        }
        if (checkEntityList != null && !checkEntityList.isEmpty()) {
            SaiChekkuhyoReport report = SaiChekkuhyoReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private void getcheckEntityList(HomonChosaIraishoRelateEntity entity) {
        ChosahyoSaiCheckhyoRelateEntity checkEntity = new ChosahyoSaiCheckhyoRelateEntity();
        前回連番Map.put(entity.get前回連番(), entity.get前回連番に対する調査項目());
        checkEntity.set被保険者番号(entity.get被保険者番号());
        checkEntity.set被保険者氏名(entity.get被保険者氏名());
        checkEntity.set前回二次判定日(entity.get二次判定年月日());
        checkEntity.set生年月日(entity.get生年月日());
        checkEntity.set年齢(entity.get年齢());
        checkEntity.set前回一次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get要介護認定一次判定結果コード()));
        checkEntity.set前回二次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get二次判定要介護状態区分コード()));
        checkEntity.set前回認知症高齢者自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get前回認知症高齢者自立度()).get名称());
        checkEntity.set前回障害高齢者自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get前回障害高齢者自立度()).get名称());
        if (entity.get申請書管理番号() != null && !shinseishoKanriNo.equals(entity.get申請書管理番号())) {
            shinseishoKanriNo = entity.get申請書管理番号();
            checkEntityList.add(checkEntity);
        }
    }

    private SaiChekkuhyoItem setItem(ChosahyoSaiCheckhyoRelateEntity entity) {
        return new SaiChekkuhyoItem(
                entity.get前回一次判定結果(),
                entity.get被保険者番号(),
                entity.get被保険者氏名(),
                entity.get年齢(),
                entity.get前回二次判定結果(),
                entity.get前回二次判定日(),
                entity.get生年月日(),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()),
                前回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()),
                entity.get前回障害高齢者自立度(),
                entity.get前回認知症高齢者自立度()
        );

    }

    private RString get判定結果(RString 厚労省IF識別コード, RString 判定結果コード) {
        RString 判定結果 = RString.EMPTY;
        if (IFSHIKIBETSUCODE99A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode99.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE09A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode09.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE06A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode06.toValue(判定結果コード).get名称();
        } else if (IFSHIKIBETSUCODE02A.equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode02.toValue(判定結果コード).get名称();
        }
        return 判定結果;
    }

    private void update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {
        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = iHomonChosaIraishoMapper.get認定調査依頼情報(entity);
        RString 認定調査期限設定方法 = DbBusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (文字列1.equals(認定調査期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(DbBusinessConfig.get(ConfigNameDBE.認定調査期限日数,
                            RDate.getNowDate(), SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
                        dbT5201Entity.setNinteichosaKigenYMD(認定調査依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    dbT5201Entity.setNinteichosaKigenYMD(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (!RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        dbT5201Entity.setNinteichosaKigenYMD(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        RString hakkobi = processParamter.getHakkobi();
        if (!RString.isNullOrEmpty(hakkobi)) {
            dbT5201Entity.setChosahyoTouShutsuryokuYMD(new FlexibleDate(hakkobi));
        } else {
            dbT5201Entity.setChosahyoTouShutsuryokuYMD(FlexibleDate.EMPTY);
        }
        dbT5201EntityWriter.update(dbT5201Entity);
    }

    private void バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("－");
        RString ジョブ番号 = new RString("56");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(IRAIFROMYMD);
        builder.append(processParamter.getIraiFromYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(IRAITOYMD);
        builder.append(processParamter.getIraiToYMD());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEIOCHOSAIRAISHO);
        builder.append(processParamter.getNinteioChosaIraisho());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYO);
        builder.append(processParamter.getNinteiChosahyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAILIST);
        出力条件.add(builder.toRString());
        List<GridParameter> ninteiChosaIraiList = processParamter.getNinteiChosaIraiList();
        for (GridParameter gridParameter : ninteiChosaIraiList) {
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAITAKUSAKICODE);
            builder.append(gridParameter.getNinteichosaItakusakiCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(NINTEICHOSAINCODE);
            builder.append(gridParameter.getNinteiChosainCode());
            出力条件.add(builder.toRString());
            builder = new RStringBuilder();
            builder.append(SHOKISAIHOKENSHANO);
            builder.append(gridParameter.getShoKisaiHokenshaNo());
            出力条件.add(builder.toRString());
        }
        builder = new RStringBuilder();
        builder.append(HAKKOBI);
        builder.append(processParamter.getHakkobi());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TEISHUTSUKIGEN);
        builder.append(processParamter.getTeishutsuKigen());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(KYOTSUHIZUKE);
        builder.append(processParamter.getKyotsuHizuke());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAICHOHYO);
        builder.append(processParamter.isNinteiChosaIraiChohyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAIRAISYO);
        builder.append(processParamter.isNinteiChosaIraisyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOKIHON);
        builder.append(processParamter.isNinteiChosahyoKihon());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOTOKKI);
        builder.append(processParamter.isNinteiChosahyoTokki());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOGAIKYOU);
        builder.append(processParamter.isNinteiChosahyoGaikyou());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRKIHON);
        builder.append(processParamter.isNinteiChosahyoOCRKihon());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRTOKKI);
        builder.append(processParamter.isNinteiChosahyoOCRTokki());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSAHYOOCRGAIKYOU);
        builder.append(processParamter.isNinteiChosahyoOCRGaikyou());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(NINTEICHOSACHECKHYO);
        builder.append(processParamter.isNinteiChosaCheckHyo());
        出力条件.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(ZENKONINTEICHOSAHYO);
        builder.append(processParamter.isZenkoNinteiChosahyo());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                ReportIdDBE.DBE292001.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
