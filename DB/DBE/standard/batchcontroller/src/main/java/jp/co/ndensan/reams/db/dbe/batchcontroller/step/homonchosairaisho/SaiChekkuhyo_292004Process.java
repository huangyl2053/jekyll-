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
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ChosahyoSaiCheckhyoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.saichekkuhyo.SaiChekkuhyoReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinchishoNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ShogaiNichijoSeikatsuJiritsudoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * 帳票「認定調査票差異チェック票_DBE292001」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-140 duanzhanli
 */
public class SaiChekkuhyo_292004Process extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get認定調査結果");
    private static final ReportId 帳票ID = ReportIdDBE.DBE292001.getReportId();
    private static final RString IFSHIKIBETSUCODE99A = new RString("99A");
    private static final RString IFSHIKIBETSUCODE02A = new RString("02A");
    private static final RString IFSHIKIBETSUCODE06A = new RString("06A");
    private static final RString IFSHIKIBETSUCODE09A = new RString("09A");
    private RString shinseishoKanriNo = RString.EMPTY;
    private List<ChosahyoSaiCheckhyoRelateEntity> checkEntityList;
    private HomonChosaIraishoProcessParamter processParamter;
    private final Map<RString, RString> 前回連番Map = new HashMap();
    @BatchWriter
    private BatchReportWriter<SaiChekkuhyoReportSource> batchReportWriter;
    private ReportSourceWriter<SaiChekkuhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
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
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        getcheckEntityList(entity);
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
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
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
}
