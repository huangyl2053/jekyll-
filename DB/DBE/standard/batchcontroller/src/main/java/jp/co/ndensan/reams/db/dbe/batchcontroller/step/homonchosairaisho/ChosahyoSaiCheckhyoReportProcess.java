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
import jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo.ChosahyoSaiCheckhyoItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.iraisho.GridParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ChosahyoSaiCheckhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahyosaicheckhyo.ChosahyoSaiCheckhyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
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
 * 帳票「前回認定調査結果との比較表」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class ChosahyoSaiCheckhyoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get認定調査結果");
    private static final ReportId 帳票ID = ReportIdDBE.DBE293001.getReportId();
    private static final RString 文字列1 = new RString("1");
    private static final RString TITLE = new RString("調査票差異チェック票");
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
    private static final RString UESANKAKU = new RString("▲");
    private static final RString SHITASANKAKU = new RString("▼");
    private Map<RString, RString> 今回連番Map;
    private Map<RString, RString> 前回連番Map;
    private RString shinseishoKanriNo = RString.EMPTY;
    private List<ChosahyoSaiCheckhyoRelateEntity> checkEntityList;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private HomonChosaIraishoProcessParamter processParamter;

    @BatchWriter
    private BatchReportWriter<ChosahyoSaiCheckhyoReportSource> batchReportWriter;
    private ReportSourceWriter<ChosahyoSaiCheckhyoReportSource> reportSourceWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5201NinteichosaIraiJohoEntity> dbT5201EntityWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        checkEntityList = new ArrayList<>();
        今回連番Map = new HashMap();
        前回連番Map = new HashMap();
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
        List<ChosahyoSaiCheckhyoItem> itemList = new ArrayList<>();
        for (ChosahyoSaiCheckhyoRelateEntity checkEntity : checkEntityList) {
            itemList.add(setItem(checkEntity));
        }
        if (checkEntityList != null && !checkEntityList.isEmpty()) {
            ChosahyoSaiCheckhyoReport report = ChosahyoSaiCheckhyoReport.createFrom(itemList);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    private void getcheckEntityList(HomonChosaIraishoRelateEntity entity) {
        ChosahyoSaiCheckhyoRelateEntity checkEntity = new ChosahyoSaiCheckhyoRelateEntity();

        今回連番Map.put(entity.get今回連番(), entity.get今回連番に対する調査項目());
        前回連番Map.put(entity.get前回連番(), entity.get前回連番に対する調査項目());
        checkEntity.set審査会日(entity.get介護認定審査会開催年月日());
        checkEntity.set合議体番号(entity.get合議体番号());
        checkEntity.set被保険者番号(entity.get被保険者番号());
        checkEntity.set被保険者氏名(entity.get被保険者氏名());
        checkEntity.set前回一次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get要介護認定一次判定結果コード()));
        checkEntity.set今回一次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get今回一次判定結果コード()));
        checkEntity.set前回二次判定結果(get判定結果(entity.get厚労省IF識別コード(), entity.get二次判定要介護状態区分コード()));
        checkEntity.set今回認知症高齢者自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get今回認知症高齢者自立度()).get名称());
        checkEntity.set今回障害高齢者自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get今回障害高齢者自立度()).get名称());
        checkEntity.set前回認知症高齢者自立度(NinchishoNichijoSeikatsuJiritsudoCode.toValue(entity.get前回認知症高齢者自立度()).get名称());
        checkEntity.set前回障害高齢者自立度(ShogaiNichijoSeikatsuJiritsudoCode.toValue(entity.get前回障害高齢者自立度()).get名称());
        if (entity.get申請書管理番号() != null && !shinseishoKanriNo.equals(entity.get申請書管理番号())) {
            shinseishoKanriNo = entity.get申請書管理番号();
            checkEntityList.add(checkEntity);
        }
    }

    private ChosahyoSaiCheckhyoItem setItem(ChosahyoSaiCheckhyoRelateEntity entity) {
        ChosahyoSaiCheckhyoItem item = new ChosahyoSaiCheckhyoItem();
        item.setTitle(TITLE);
        item.setHihokenshaNo(entity.get被保険者番号());
        item.setHihokenshaName(entity.get被保険者氏名());
        item.setZenkaiIchijihanteikekka(entity.get前回一次判定結果());
        item.setKonkaiIchijihanteikekka(entity.get今回一次判定結果());
        item.setShinsakaiYMD(entity.get審査会日());
        item.setGogitaiNo(entity.get合議体番号());
        item.setZenkaiNijihanteikekka(entity.get前回二次判定結果());
        setZenkaiChosakekka(item);
        item.setZenkaiChosakekkaNo75(entity.get前回障害高齢者自立度());
        item.setZenkaiChosakekkaNo76(entity.get前回認知症高齢者自立度());
        setKonkaiChosakekka(item);
        item.setKonkaiChosakekkaNo75(entity.get今回障害高齢者自立度());
        item.setKonkaiChosakekkaNo76(entity.get今回認知症高齢者自立度());
        setTokkiFuragu(item);
        return item;
    }

    private void setZenkaiChosakekka(ChosahyoSaiCheckhyoItem item) {
        item.setZenkaiChosakekkaNo1(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()));
        item.setZenkaiChosakekkaNo2(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()));
        item.setZenkaiChosakekkaNo3(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()));
        item.setZenkaiChosakekkaNo4(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()));
        item.setZenkaiChosakekkaNo5(前回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()));
        item.setZenkaiChosakekkaNo6(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()));
        item.setZenkaiChosakekkaNo7(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()));
        item.setZenkaiChosakekkaNo8(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()));
        item.setZenkaiChosakekkaNo9(前回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()));
        item.setZenkaiChosakekkaNo10(前回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()));
        item.setZenkaiChosakekkaNo11(前回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()));
        item.setZenkaiChosakekkaNo12(前回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()));
        item.setZenkaiChosakekkaNo13(前回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()));
        item.setZenkaiChosakekkaNo14(前回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()));
        item.setZenkaiChosakekkaNo15(前回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()));
        item.setZenkaiChosakekkaNo16(前回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()));
        item.setZenkaiChosakekkaNo17(前回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()));
        item.setZenkaiChosakekkaNo18(前回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()));
        item.setZenkaiChosakekkaNo19(前回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()));
        item.setZenkaiChosakekkaNo20(前回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()));
        item.setZenkaiChosakekkaNo21(前回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()));
        item.setZenkaiChosakekkaNo22(前回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()));
        item.setZenkaiChosakekkaNo23(前回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()));
        item.setZenkaiChosakekkaNo24(前回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()));
        item.setZenkaiChosakekkaNo25(前回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()));
        item.setZenkaiChosakekkaNo26(前回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()));
        item.setZenkaiChosakekkaNo27(前回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()));
        item.setZenkaiChosakekkaNo28(前回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()));
        item.setZenkaiChosakekkaNo29(前回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()));
        item.setZenkaiChosakekkaNo30(前回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()));
        item.setZenkaiChosakekkaNo31(前回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()));
        item.setZenkaiChosakekkaNo32(前回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()));
        item.setZenkaiChosakekkaNo33(前回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()));
        item.setZenkaiChosakekkaNo34(前回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()));
        item.setZenkaiChosakekkaNo35(前回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()));
        item.setZenkaiChosakekkaNo36(前回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()));
        item.setZenkaiChosakekkaNo37(前回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()));
        item.setZenkaiChosakekkaNo38(前回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()));
        item.setZenkaiChosakekkaNo39(前回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()));
        item.setZenkaiChosakekkaNo40(前回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()));
        item.setZenkaiChosakekkaNo41(前回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()));
        item.setZenkaiChosakekkaNo42(前回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()));
        item.setZenkaiChosakekkaNo43(前回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()));
        item.setZenkaiChosakekkaNo44(前回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()));
        item.setZenkaiChosakekkaNo45(前回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()));
        item.setZenkaiChosakekkaNo46(前回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()));
        item.setZenkaiChosakekkaNo47(前回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()));
        item.setZenkaiChosakekkaNo48(前回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()));
        item.setZenkaiChosakekkaNo49(前回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()));
        item.setZenkaiChosakekkaNo50(前回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()));
        item.setZenkaiChosakekkaNo51(前回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()));
        item.setZenkaiChosakekkaNo52(前回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()));
        item.setZenkaiChosakekkaNo53(前回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()));
        item.setZenkaiChosakekkaNo54(前回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()));
        item.setZenkaiChosakekkaNo55(前回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()));
        item.setZenkaiChosakekkaNo56(前回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()));
        item.setZenkaiChosakekkaNo57(前回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()));
        item.setZenkaiChosakekkaNo58(前回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()));
        item.setZenkaiChosakekkaNo59(前回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()));
        item.setZenkaiChosakekkaNo60(前回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()));
        item.setZenkaiChosakekkaNo61(前回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()));
        item.setZenkaiChosakekkaNo62(前回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()));
        item.setZenkaiChosakekkaNo63(前回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()));
        item.setZenkaiChosakekkaNo64(前回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()));
        item.setZenkaiChosakekkaNo65(前回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()));
        item.setZenkaiChosakekkaNo66(前回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()));
        item.setZenkaiChosakekkaNo67(前回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()));
        item.setZenkaiChosakekkaNo68(前回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()));
        item.setZenkaiChosakekkaNo69(前回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()));
        item.setZenkaiChosakekkaNo70(前回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()));
        item.setZenkaiChosakekkaNo71(前回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()));
        item.setZenkaiChosakekkaNo72(前回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()));
        item.setZenkaiChosakekkaNo73(前回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()));
        item.setZenkaiChosakekkaNo74(前回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()));
    }

    private void setKonkaiChosakekka(ChosahyoSaiCheckhyoItem item) {
        item.setKonkaiChosakekkaNo1(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左上肢.getコード()));
        item.setKonkaiChosakekkaNo2(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右上肢.getコード()));
        item.setKonkaiChosakekkaNo3(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_左下肢.getコード()));
        item.setKonkaiChosakekkaNo4(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_右下肢.getコード()));
        item.setKonkaiChosakekkaNo5(今回連番Map.get(NinteichosaKomokuMapping09B.麻痺等_その他.getコード()));
        item.setKonkaiChosakekkaNo6(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_肩関節.getコード()));
        item.setKonkaiChosakekkaNo7(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_股関節.getコード()));
        item.setKonkaiChosakekkaNo8(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_膝関節.getコード()));
        item.setKonkaiChosakekkaNo9(今回連番Map.get(NinteichosaKomokuMapping09B.拘縮_その他.getコード()));
        item.setKonkaiChosakekkaNo10(今回連番Map.get(NinteichosaKomokuMapping09B.寝返り.getコード()));
        item.setKonkaiChosakekkaNo11(今回連番Map.get(NinteichosaKomokuMapping09B.起き上がり.getコード()));
        item.setKonkaiChosakekkaNo12(今回連番Map.get(NinteichosaKomokuMapping09B.座位保持.getコード()));
        item.setKonkaiChosakekkaNo13(今回連番Map.get(NinteichosaKomokuMapping09B.両足での立位.getコード()));
        item.setKonkaiChosakekkaNo14(今回連番Map.get(NinteichosaKomokuMapping09B.歩行.getコード()));
        item.setKonkaiChosakekkaNo15(今回連番Map.get(NinteichosaKomokuMapping09B.立ち上がり.getコード()));
        item.setKonkaiChosakekkaNo16(今回連番Map.get(NinteichosaKomokuMapping09B.片足での立位.getコード()));
        item.setKonkaiChosakekkaNo17(今回連番Map.get(NinteichosaKomokuMapping09B.洗身.getコード()));
        item.setKonkaiChosakekkaNo18(今回連番Map.get(NinteichosaKomokuMapping09B.つめ切り.getコード()));
        item.setKonkaiChosakekkaNo19(今回連番Map.get(NinteichosaKomokuMapping09B.視力.getコード()));
        item.setKonkaiChosakekkaNo20(今回連番Map.get(NinteichosaKomokuMapping09B.聴力.getコード()));
        item.setKonkaiChosakekkaNo21(今回連番Map.get(NinteichosaKomokuMapping09B.移乗.getコード()));
        item.setKonkaiChosakekkaNo22(今回連番Map.get(NinteichosaKomokuMapping09B.移動.getコード()));
        item.setKonkaiChosakekkaNo23(今回連番Map.get(NinteichosaKomokuMapping09B.えん下.getコード()));
        item.setKonkaiChosakekkaNo24(今回連番Map.get(NinteichosaKomokuMapping09B.食事摂取.getコード()));
        item.setKonkaiChosakekkaNo25(今回連番Map.get(NinteichosaKomokuMapping09B.排尿.getコード()));
        item.setKonkaiChosakekkaNo26(今回連番Map.get(NinteichosaKomokuMapping09B.排便.getコード()));
        item.setKonkaiChosakekkaNo27(今回連番Map.get(NinteichosaKomokuMapping09B.口腔清潔.getコード()));
        item.setKonkaiChosakekkaNo28(今回連番Map.get(NinteichosaKomokuMapping09B.洗顔.getコード()));
        item.setKonkaiChosakekkaNo29(今回連番Map.get(NinteichosaKomokuMapping09B.整髪.getコード()));
        item.setKonkaiChosakekkaNo30(今回連番Map.get(NinteichosaKomokuMapping09B.上衣の着脱.getコード()));
        item.setKonkaiChosakekkaNo31(今回連番Map.get(NinteichosaKomokuMapping09B.ズボン等の着脱.getコード()));
        item.setKonkaiChosakekkaNo32(今回連番Map.get(NinteichosaKomokuMapping09B.外出頻度.getコード()));
        item.setKonkaiChosakekkaNo33(今回連番Map.get(NinteichosaKomokuMapping09B.意思の伝達.getコード()));
        item.setKonkaiChosakekkaNo34(今回連番Map.get(NinteichosaKomokuMapping09B.毎日の日課を理解.getコード()));
        item.setKonkaiChosakekkaNo35(今回連番Map.get(NinteichosaKomokuMapping09B.生年月日をいう.getコード()));
        item.setKonkaiChosakekkaNo36(今回連番Map.get(NinteichosaKomokuMapping09B.短期記憶.getコード()));
        item.setKonkaiChosakekkaNo37(今回連番Map.get(NinteichosaKomokuMapping09B.自分の名前をいう.getコード()));
        item.setKonkaiChosakekkaNo38(今回連番Map.get(NinteichosaKomokuMapping09B.今の季節を理解.getコード()));
        item.setKonkaiChosakekkaNo39(今回連番Map.get(NinteichosaKomokuMapping09B.場所の理解.getコード()));
        item.setKonkaiChosakekkaNo40(今回連番Map.get(NinteichosaKomokuMapping09B.常時の徘徊.getコード()));
        item.setKonkaiChosakekkaNo41(今回連番Map.get(NinteichosaKomokuMapping09B.外出して戻れない.getコード()));
        item.setKonkaiChosakekkaNo42(今回連番Map.get(NinteichosaKomokuMapping09B.被害的.getコード()));
        item.setKonkaiChosakekkaNo43(今回連番Map.get(NinteichosaKomokuMapping09B.作話.getコード()));
        item.setKonkaiChosakekkaNo44(今回連番Map.get(NinteichosaKomokuMapping09B.感情が不安定.getコード()));
        item.setKonkaiChosakekkaNo45(今回連番Map.get(NinteichosaKomokuMapping09B.昼夜逆転.getコード()));
        item.setKonkaiChosakekkaNo46(今回連番Map.get(NinteichosaKomokuMapping09B.同じ話をする.getコード()));
        item.setKonkaiChosakekkaNo47(今回連番Map.get(NinteichosaKomokuMapping09B.大声を出す.getコード()));
        item.setKonkaiChosakekkaNo48(今回連番Map.get(NinteichosaKomokuMapping09B.介護に抵抗.getコード()));
        item.setKonkaiChosakekkaNo49(今回連番Map.get(NinteichosaKomokuMapping09B.落ち着きなし.getコード()));
        item.setKonkaiChosakekkaNo50(今回連番Map.get(NinteichosaKomokuMapping09B.一人で出たがる.getコード()));
        item.setKonkaiChosakekkaNo51(今回連番Map.get(NinteichosaKomokuMapping09B.収集癖.getコード()));
        item.setKonkaiChosakekkaNo52(今回連番Map.get(NinteichosaKomokuMapping09B.物や衣類を壊す.getコード()));
        item.setKonkaiChosakekkaNo53(今回連番Map.get(NinteichosaKomokuMapping09B.ひどい物忘れ.getコード()));
        item.setKonkaiChosakekkaNo54(今回連番Map.get(NinteichosaKomokuMapping09B.独り言_独り笑い.getコード()));
        item.setKonkaiChosakekkaNo55(今回連番Map.get(NinteichosaKomokuMapping09B.自分勝手に行動する.getコード()));
        item.setKonkaiChosakekkaNo56(今回連番Map.get(NinteichosaKomokuMapping09B.話がまとまらない.getコード()));
        item.setKonkaiChosakekkaNo57(今回連番Map.get(NinteichosaKomokuMapping09B.薬の内服.getコード()));
        item.setKonkaiChosakekkaNo58(今回連番Map.get(NinteichosaKomokuMapping09B.金銭の管理.getコード()));
        item.setKonkaiChosakekkaNo59(今回連番Map.get(NinteichosaKomokuMapping09B.日常の意思決定.getコード()));
        item.setKonkaiChosakekkaNo60(今回連番Map.get(NinteichosaKomokuMapping09B.集団への不適応.getコード()));
        item.setKonkaiChosakekkaNo61(今回連番Map.get(NinteichosaKomokuMapping09B.買い物.getコード()));
        item.setKonkaiChosakekkaNo62(今回連番Map.get(NinteichosaKomokuMapping09B.簡単な調理.getコード()));
        item.setKonkaiChosakekkaNo63(今回連番Map.get(NinteichosaKomokuMapping09B.点滴の管理.getコード()));
        item.setKonkaiChosakekkaNo64(今回連番Map.get(NinteichosaKomokuMapping09B.中心静脈栄養.getコード()));
        item.setKonkaiChosakekkaNo65(今回連番Map.get(NinteichosaKomokuMapping09B.透析.getコード()));
        item.setKonkaiChosakekkaNo66(今回連番Map.get(NinteichosaKomokuMapping09B.ストーマの処置.getコード()));
        item.setKonkaiChosakekkaNo67(今回連番Map.get(NinteichosaKomokuMapping09B.酸素療法.getコード()));
        item.setKonkaiChosakekkaNo68(今回連番Map.get(NinteichosaKomokuMapping09B.レスピレーター.getコード()));
        item.setKonkaiChosakekkaNo69(今回連番Map.get(NinteichosaKomokuMapping09B.気管切開の処置.getコード()));
        item.setKonkaiChosakekkaNo70(今回連番Map.get(NinteichosaKomokuMapping09B.疼痛の看護.getコード()));
        item.setKonkaiChosakekkaNo71(今回連番Map.get(NinteichosaKomokuMapping09B.経管栄養.getコード()));
        item.setKonkaiChosakekkaNo72(今回連番Map.get(NinteichosaKomokuMapping09B.モニター測定.getコード()));
        item.setKonkaiChosakekkaNo73(今回連番Map.get(NinteichosaKomokuMapping09B.じょくそうの処置.getコード()));
        item.setKonkaiChosakekkaNo74(今回連番Map.get(NinteichosaKomokuMapping09B.カテーテル.getコード()));
    }

    private void setTokkiFuragu(ChosahyoSaiCheckhyoItem item) {
        item.setTokkiFuraguNo1(set軽重FLG(item.getZenkaiChosakekkaNo1(), item.getKonkaiChosakekkaNo1()));
        item.setTokkiFuraguNo2(set軽重FLG(item.getZenkaiChosakekkaNo2(), item.getKonkaiChosakekkaNo2()));
        item.setTokkiFuraguNo3(set軽重FLG(item.getZenkaiChosakekkaNo3(), item.getKonkaiChosakekkaNo3()));
        item.setTokkiFuraguNo4(set軽重FLG(item.getZenkaiChosakekkaNo4(), item.getKonkaiChosakekkaNo4()));
        item.setTokkiFuraguNo5(set軽重FLG(item.getZenkaiChosakekkaNo5(), item.getKonkaiChosakekkaNo5()));
        item.setTokkiFuraguNo6(set軽重FLG(item.getZenkaiChosakekkaNo6(), item.getKonkaiChosakekkaNo6()));
        item.setTokkiFuraguNo7(set軽重FLG(item.getZenkaiChosakekkaNo7(), item.getKonkaiChosakekkaNo7()));
        item.setTokkiFuraguNo8(set軽重FLG(item.getZenkaiChosakekkaNo8(), item.getKonkaiChosakekkaNo8()));
        item.setTokkiFuraguNo9(set軽重FLG(item.getZenkaiChosakekkaNo9(), item.getKonkaiChosakekkaNo9()));
        item.setTokkiFuraguNo10(set軽重FLG(item.getZenkaiChosakekkaNo10(), item.getKonkaiChosakekkaNo10()));
        item.setTokkiFuraguNo11(set軽重FLG(item.getZenkaiChosakekkaNo11(), item.getKonkaiChosakekkaNo11()));
        item.setTokkiFuraguNo12(set軽重FLG(item.getZenkaiChosakekkaNo12(), item.getKonkaiChosakekkaNo12()));
        item.setTokkiFuraguNo13(set軽重FLG(item.getZenkaiChosakekkaNo13(), item.getKonkaiChosakekkaNo13()));
        item.setTokkiFuraguNo14(set軽重FLG(item.getZenkaiChosakekkaNo14(), item.getKonkaiChosakekkaNo14()));
        item.setTokkiFuraguNo15(set軽重FLG(item.getZenkaiChosakekkaNo15(), item.getKonkaiChosakekkaNo15()));
        item.setTokkiFuraguNo16(set軽重FLG(item.getZenkaiChosakekkaNo16(), item.getKonkaiChosakekkaNo16()));
        item.setTokkiFuraguNo17(set軽重FLG(item.getZenkaiChosakekkaNo17(), item.getKonkaiChosakekkaNo17()));
        item.setTokkiFuraguNo18(set軽重FLG(item.getZenkaiChosakekkaNo18(), item.getKonkaiChosakekkaNo18()));
        item.setTokkiFuraguNo19(set軽重FLG(item.getZenkaiChosakekkaNo19(), item.getKonkaiChosakekkaNo19()));
        item.setTokkiFuraguNo20(set軽重FLG(item.getZenkaiChosakekkaNo20(), item.getKonkaiChosakekkaNo20()));
        item.setTokkiFuraguNo21(set軽重FLG(item.getZenkaiChosakekkaNo21(), item.getKonkaiChosakekkaNo21()));
        item.setTokkiFuraguNo22(set軽重FLG(item.getZenkaiChosakekkaNo22(), item.getKonkaiChosakekkaNo22()));
        item.setTokkiFuraguNo23(set軽重FLG(item.getZenkaiChosakekkaNo23(), item.getKonkaiChosakekkaNo23()));
        item.setTokkiFuraguNo24(set軽重FLG(item.getZenkaiChosakekkaNo24(), item.getKonkaiChosakekkaNo24()));
        item.setTokkiFuraguNo25(set軽重FLG(item.getZenkaiChosakekkaNo25(), item.getKonkaiChosakekkaNo25()));
        item.setTokkiFuraguNo26(set軽重FLG(item.getZenkaiChosakekkaNo26(), item.getKonkaiChosakekkaNo26()));
        item.setTokkiFuraguNo27(set軽重FLG(item.getZenkaiChosakekkaNo27(), item.getKonkaiChosakekkaNo27()));
        item.setTokkiFuraguNo28(set軽重FLG(item.getZenkaiChosakekkaNo28(), item.getKonkaiChosakekkaNo28()));
        item.setTokkiFuraguNo29(set軽重FLG(item.getZenkaiChosakekkaNo29(), item.getKonkaiChosakekkaNo29()));
        item.setTokkiFuraguNo30(set軽重FLG(item.getZenkaiChosakekkaNo30(), item.getKonkaiChosakekkaNo30()));
        item.setTokkiFuraguNo31(set軽重FLG(item.getZenkaiChosakekkaNo31(), item.getKonkaiChosakekkaNo31()));
        item.setTokkiFuraguNo32(set軽重FLG(item.getZenkaiChosakekkaNo32(), item.getKonkaiChosakekkaNo32()));
        item.setTokkiFuraguNo33(set軽重FLG(item.getZenkaiChosakekkaNo33(), item.getKonkaiChosakekkaNo33()));
        item.setTokkiFuraguNo34(set軽重FLG(item.getZenkaiChosakekkaNo34(), item.getKonkaiChosakekkaNo34()));
        item.setTokkiFuraguNo35(set軽重FLG(item.getZenkaiChosakekkaNo35(), item.getKonkaiChosakekkaNo35()));
        item.setTokkiFuraguNo36(set軽重FLG(item.getZenkaiChosakekkaNo36(), item.getKonkaiChosakekkaNo36()));
        item.setTokkiFuraguNo37(set軽重FLG(item.getZenkaiChosakekkaNo37(), item.getKonkaiChosakekkaNo37()));
        item.setTokkiFuraguNo38(set軽重FLG(item.getZenkaiChosakekkaNo38(), item.getKonkaiChosakekkaNo38()));
        item.setTokkiFuraguNo39(set軽重FLG(item.getZenkaiChosakekkaNo39(), item.getKonkaiChosakekkaNo39()));
        item.setTokkiFuraguNo40(set軽重FLG(item.getZenkaiChosakekkaNo40(), item.getKonkaiChosakekkaNo40()));
        item.setTokkiFuraguNo41(set軽重FLG(item.getZenkaiChosakekkaNo41(), item.getKonkaiChosakekkaNo41()));
        item.setTokkiFuraguNo42(set軽重FLG(item.getZenkaiChosakekkaNo42(), item.getKonkaiChosakekkaNo42()));
        item.setTokkiFuraguNo43(set軽重FLG(item.getZenkaiChosakekkaNo43(), item.getKonkaiChosakekkaNo43()));
        item.setTokkiFuraguNo44(set軽重FLG(item.getZenkaiChosakekkaNo44(), item.getKonkaiChosakekkaNo44()));
        item.setTokkiFuraguNo45(set軽重FLG(item.getZenkaiChosakekkaNo45(), item.getKonkaiChosakekkaNo45()));
        item.setTokkiFuraguNo46(set軽重FLG(item.getZenkaiChosakekkaNo46(), item.getKonkaiChosakekkaNo46()));
        item.setTokkiFuraguNo47(set軽重FLG(item.getZenkaiChosakekkaNo47(), item.getKonkaiChosakekkaNo47()));
        item.setTokkiFuraguNo48(set軽重FLG(item.getZenkaiChosakekkaNo48(), item.getKonkaiChosakekkaNo48()));
        item.setTokkiFuraguNo49(set軽重FLG(item.getZenkaiChosakekkaNo49(), item.getKonkaiChosakekkaNo49()));
        item.setTokkiFuraguNo50(set軽重FLG(item.getZenkaiChosakekkaNo50(), item.getKonkaiChosakekkaNo50()));
        item.setTokkiFuraguNo51(set軽重FLG(item.getZenkaiChosakekkaNo51(), item.getKonkaiChosakekkaNo51()));
        item.setTokkiFuraguNo52(set軽重FLG(item.getZenkaiChosakekkaNo52(), item.getKonkaiChosakekkaNo52()));
        item.setTokkiFuraguNo53(set軽重FLG(item.getZenkaiChosakekkaNo53(), item.getKonkaiChosakekkaNo53()));
        item.setTokkiFuraguNo54(set軽重FLG(item.getZenkaiChosakekkaNo54(), item.getKonkaiChosakekkaNo54()));
        item.setTokkiFuraguNo55(set軽重FLG(item.getZenkaiChosakekkaNo55(), item.getKonkaiChosakekkaNo55()));
        item.setTokkiFuraguNo56(set軽重FLG(item.getZenkaiChosakekkaNo56(), item.getKonkaiChosakekkaNo56()));
        item.setTokkiFuraguNo57(set軽重FLG(item.getZenkaiChosakekkaNo57(), item.getKonkaiChosakekkaNo57()));
        item.setTokkiFuraguNo58(set軽重FLG(item.getZenkaiChosakekkaNo58(), item.getKonkaiChosakekkaNo58()));
        item.setTokkiFuraguNo59(set軽重FLG(item.getZenkaiChosakekkaNo59(), item.getKonkaiChosakekkaNo59()));
        item.setTokkiFuraguNo60(set軽重FLG(item.getZenkaiChosakekkaNo60(), item.getKonkaiChosakekkaNo60()));
        item.setTokkiFuraguNo61(set軽重FLG(item.getZenkaiChosakekkaNo61(), item.getKonkaiChosakekkaNo61()));
        item.setTokkiFuraguNo62(set軽重FLG(item.getZenkaiChosakekkaNo62(), item.getKonkaiChosakekkaNo62()));
        item.setTokkiFuraguNo63(set軽重FLG(item.getZenkaiChosakekkaNo63(), item.getKonkaiChosakekkaNo63()));
        item.setTokkiFuraguNo64(set軽重FLG(item.getZenkaiChosakekkaNo64(), item.getKonkaiChosakekkaNo64()));
        item.setTokkiFuraguNo65(set軽重FLG(item.getZenkaiChosakekkaNo65(), item.getKonkaiChosakekkaNo65()));
        item.setTokkiFuraguNo66(set軽重FLG(item.getZenkaiChosakekkaNo66(), item.getKonkaiChosakekkaNo66()));
        item.setTokkiFuraguNo67(set軽重FLG(item.getZenkaiChosakekkaNo67(), item.getKonkaiChosakekkaNo67()));
        item.setTokkiFuraguNo68(set軽重FLG(item.getZenkaiChosakekkaNo68(), item.getKonkaiChosakekkaNo68()));
        item.setTokkiFuraguNo69(set軽重FLG(item.getZenkaiChosakekkaNo69(), item.getKonkaiChosakekkaNo69()));
        item.setTokkiFuraguNo70(set軽重FLG(item.getZenkaiChosakekkaNo70(), item.getKonkaiChosakekkaNo70()));
        item.setTokkiFuraguNo71(set軽重FLG(item.getZenkaiChosakekkaNo71(), item.getKonkaiChosakekkaNo71()));
        item.setTokkiFuraguNo72(set軽重FLG(item.getZenkaiChosakekkaNo72(), item.getKonkaiChosakekkaNo72()));
        item.setTokkiFuraguNo73(set軽重FLG(item.getZenkaiChosakekkaNo73(), item.getKonkaiChosakekkaNo73()));
        item.setTokkiFuraguNo74(set軽重FLG(item.getZenkaiChosakekkaNo74(), item.getKonkaiChosakekkaNo74()));
        item.setTokkiFuraguNo75(set軽重FLG(item.getZenkaiChosakekkaNo75(), item.getKonkaiChosakekkaNo75()));
        item.setTokkiFuraguNo76(set軽重FLG(item.getZenkaiChosakekkaNo76(), item.getKonkaiChosakekkaNo76()));
    }

    private RString set軽重FLG(RString 前回, RString 今回) {
        RString 軽重FLG = RString.EMPTY;
        if (!RString.isNullOrEmpty(前回) && !RString.isNullOrEmpty(今回) && 前回.compareTo(今回) < 0) {
            軽重FLG = UESANKAKU;
        } else if (!RString.isNullOrEmpty(前回) && !RString.isNullOrEmpty(今回) && 今回.compareTo(前回) < 0) {
            軽重FLG = SHITASANKAKU;
        }
        return 軽重FLG;
    }

    private RString get判定結果(RString 厚労省IF識別コード, RString 判定結果コード) {
        RString 判定結果 = RString.EMPTY;
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode99.toValue(判定結果コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode09.toValue(判定結果コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
            判定結果 = IchijiHanteiKekkaCode06.toValue(判定結果コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
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
                ReportIdDBE.DBE293001.getReportName(),
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
