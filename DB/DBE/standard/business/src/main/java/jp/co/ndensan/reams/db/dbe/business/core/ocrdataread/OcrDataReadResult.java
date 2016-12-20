/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocrdataread;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ocrfiledata.OcrFileLineDataTypeModel;
import jp.co.ndensan.reams.db.dbe.entity.csv.jizenshinsakekka.OcrJohoOcrDataRecordEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ ファイル読み取り結果 クラスです。
 *
 * @author n8429
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrDataReadResult {

    private RString 調査区分;
    private RString 申請日;
    private RString 保険者番号;
    private RString 被保険者番号;
    private RString 実施日時;
    private RString 実施場所;
    private RString 記入者;
    private RString 所属機関;
    private RString サービス区分コード;
    private RString 訪問介護の回数;
    private RString 訪問入浴介護の回数;
    private RString 訪問看護の回数;
    private RString 訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数;
    private RString 居宅療養管理指導の回数;
    private RString 通所看護の回数;
    private RString 通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数;
    private RString 短期入所生活介護の日数;
    private RString 短期入所療養介護の日数;
    private RString 特定施設入所者生活介護の日数;
    private RString 福祉用具貸与の品目;
    private RString 福祉用具購入の品目;
    private RString 住宅改修;
    private RString 夜間対応型訪問介護の日数;
    private RString 認知症対応型通所介護の日数;
    private RString 小規模多機能型居宅介護の日数;
    private RString 認知症対応型共同生活介護の日数;
    private RString 地域密着型特定施設入居者生活介護の日数;
    private RString 地域密着型介護老人福祉施設入居者生活介護の日数;
    private RString 看護小規模多機能型居宅介護;
    private RString 随時対応型訪問介護看護;
    private RString 施設利用の有無;

    private RString 麻痺;
    private RString 拘縮;
    private RString 寝返り;
    private RString 起き上がり;
    private RString 座位保持;
    private RString 両足での立位;
    private RString 歩行;
    private RString 立ち上がり;
    private RString 片足での立位;
    private RString 洗身;
    private RString つめ切り;
    private RString 視力;
    private RString 聴力;
    private RString 移乗;
    private RString 移動;
    private RString えん下;
    private RString 食事摂取;
    private RString 排尿;
    private RString 排便;
    private RString 口腔清潔;
    private RString 洗顔;
    private RString 整髪;
    private RString 上衣の着脱;
    private RString ズボン等の着脱;
    private RString 外出頻度;
    private RString 意思の疎通;
    private RString 毎日の日課を理解;
    private RString 生年月日をいう;
    private RString 短期記憶;
    private RString 自分の名前をいう;
    private RString 今の季節を理解;
    private RString 場所の理解;
    private RString 徘徊;
    private RString 外出して戻れない;
    private RString 被害的;
    private RString 作話;
    private RString 感情が不安定;
    private RString 昼夜逆転;
    private RString 同じ話をする;
    private RString 大声を出す;
    private RString 介護に抵抗;
    private RString 落ち着きなし;
    private RString 一人で出たがる;
    private RString 収集癖;
    private RString 物や衣類を壊す;
    private RString ひどい物忘れ;
    private RString 独り言;
    private RString 自分勝手に行動する;
    private RString 話がまとまらない;
    private RString 薬の内服;
    private RString 金銭の管理;
    private RString 日常の意思決定;
    private RString 集団への不適応;
    private RString 買い物;
    private RString 簡単な調理;
    private RString 過去14日間に受けた治療;
    private RString 認知症高齢者の日常生活自立度;
    private RString 障害高齢者の日常生活自立度;

    private RString データ行_文字列;
    private OcrJohoOcrDataRecordEntity ocrDataデータ行Entity;

    private static final RString 概況調査区分 = new RString("501");
    private static final RString 基本調査区分 = new RString("502");

    private List<RString> イメージファイル;

    /**
     * メンバ変数のクリア
     */
    public void clear() {
        this.調査区分 = RString.EMPTY;
        this.保険者番号 = RString.EMPTY;
        this.申請日 = RString.EMPTY;
        this.被保険者番号 = RString.EMPTY;
        this.実施日時 = RString.EMPTY;
        this.実施場所 = RString.EMPTY;
        this.記入者 = RString.EMPTY;
        this.所属機関 = RString.EMPTY;
        this.サービス区分コード = RString.EMPTY;
        this.訪問介護の回数 = RString.EMPTY;
        this.訪問入浴介護の回数 = RString.EMPTY;
        this.訪問看護の回数 = RString.EMPTY;
        this.訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数 = RString.EMPTY;
        this.居宅療養管理指導の回数 = RString.EMPTY;
        this.通所看護の回数 = RString.EMPTY;
        this.通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数 = RString.EMPTY;
        this.短期入所生活介護の日数 = RString.EMPTY;
        this.短期入所療養介護の日数 = RString.EMPTY;
        this.特定施設入所者生活介護の日数 = RString.EMPTY;
        this.福祉用具貸与の品目 = RString.EMPTY;
        this.福祉用具購入の品目 = RString.EMPTY;
        this.住宅改修 = RString.EMPTY;
        this.夜間対応型訪問介護の日数 = RString.EMPTY;
        this.認知症対応型通所介護の日数 = RString.EMPTY;
        this.小規模多機能型居宅介護の日数 = RString.EMPTY;
        this.認知症対応型共同生活介護の日数 = RString.EMPTY;
        this.地域密着型特定施設入居者生活介護の日数 = RString.EMPTY;
        this.地域密着型介護老人福祉施設入居者生活介護の日数 = RString.EMPTY;
        this.看護小規模多機能型居宅介護 = RString.EMPTY;
        this.随時対応型訪問介護看護 = RString.EMPTY;
        this.施設利用の有無 = RString.EMPTY;
        this.麻痺 = RString.EMPTY;
        this.拘縮 = RString.EMPTY;
        this.寝返り = RString.EMPTY;
        this.起き上がり = RString.EMPTY;
        this.座位保持 = RString.EMPTY;
        this.両足での立位 = RString.EMPTY;
        this.歩行 = RString.EMPTY;
        this.立ち上がり = RString.EMPTY;
        this.片足での立位 = RString.EMPTY;
        this.洗身 = RString.EMPTY;
        this.つめ切り = RString.EMPTY;
        this.視力 = RString.EMPTY;
        this.聴力 = RString.EMPTY;
        this.移乗 = RString.EMPTY;
        this.移動 = RString.EMPTY;
        this.えん下 = RString.EMPTY;
        this.食事摂取 = RString.EMPTY;
        this.排尿 = RString.EMPTY;
        this.排便 = RString.EMPTY;
        this.口腔清潔 = RString.EMPTY;
        this.洗顔 = RString.EMPTY;
        this.整髪 = RString.EMPTY;
        this.上衣の着脱 = RString.EMPTY;
        this.ズボン等の着脱 = RString.EMPTY;
        this.外出頻度 = RString.EMPTY;
        this.意思の疎通 = RString.EMPTY;
        this.毎日の日課を理解 = RString.EMPTY;
        this.生年月日をいう = RString.EMPTY;
        this.短期記憶 = RString.EMPTY;
        this.自分の名前をいう = RString.EMPTY;
        this.今の季節を理解 = RString.EMPTY;
        this.場所の理解 = RString.EMPTY;
        this.徘徊 = RString.EMPTY;
        this.外出して戻れない = RString.EMPTY;
        this.被害的 = RString.EMPTY;
        this.作話 = RString.EMPTY;
        this.感情が不安定 = RString.EMPTY;
        this.昼夜逆転 = RString.EMPTY;
        this.同じ話をする = RString.EMPTY;
        this.大声を出す = RString.EMPTY;
        this.介護に抵抗 = RString.EMPTY;
        this.落ち着きなし = RString.EMPTY;
        this.一人で出たがる = RString.EMPTY;
        this.収集癖 = RString.EMPTY;
        this.物や衣類を壊す = RString.EMPTY;
        this.ひどい物忘れ = RString.EMPTY;
        this.独り言 = RString.EMPTY;
        this.自分勝手に行動する = RString.EMPTY;
        this.話がまとまらない = RString.EMPTY;
        this.薬の内服 = RString.EMPTY;
        this.金銭の管理 = RString.EMPTY;
        this.日常の意思決定 = RString.EMPTY;
        this.集団への不適応 = RString.EMPTY;
        this.買い物 = RString.EMPTY;
        this.簡単な調理 = RString.EMPTY;
        this.過去14日間に受けた治療 = RString.EMPTY;
        this.認知症高齢者の日常生活自立度 = RString.EMPTY;
        this.障害高齢者の日常生活自立度 = RString.EMPTY;

    }

    /**
     * 行を解析
     *
     * @param line 行
     * @param 読取中行番号 読取中行番号
     * @return 行データタイプ
     */
    public OcrFileLineDataTypeModel parse(RString line, long 読取中行番号) {
        OcrFileLineDataTypeModel lineDataTypeModel = OcrFileLineDataTypeModel.行データタイプ_対象外;
        lineDataTypeModel = this.parse1(line);
        lineDataTypeModel = OcrFileLineDataTypeModel.行データタイプ_データ行;
        return lineDataTypeModel;
    }

    /**
     * 行を解析
     *
     * @param line 行文字列
     * @param ヘッダー行番号 バッチパラメータで指定された行番号
     * @param 読取中行番号 読取中行番号
     * @return 行データタイプ
     */
    private OcrFileLineDataTypeModel parse1(RString line) {
        this.parse1データ行(line);
        return OcrFileLineDataTypeModel.行データタイプ_データ行;
    }

    /**
     * データ行の解析
     *
     * @param line 行文字列
     */
    private void parse1データ行(RString line) {
        データ行_文字列 = line;
        RString 行項目_調査区分 = RString.EMPTY;
        RString 行項目_保険者番号 = RString.EMPTY;
        RString 行項目_申請日 = RString.EMPTY;
        RString 行項目_被保険者番号 = RString.EMPTY;
        RString 行項目_実施日時 = RString.EMPTY;
        RString 行項目_実施場所 = RString.EMPTY;
        RString 行項目_記入者 = RString.EMPTY;
        RString 行項目_所属機関 = RString.EMPTY;
        RString 行項目_サービス区分コード = RString.EMPTY;
        RString 行項目_訪問介護の回数 = RString.EMPTY;
        RString 行項目_訪問入浴介護の回数 = RString.EMPTY;
        RString 行項目_訪問看護の回数 = RString.EMPTY;
        RString 行項目_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数 = RString.EMPTY;
        RString 行項目_居宅療養管理指導の回数 = RString.EMPTY;
        RString 行項目_通所看護の回数 = RString.EMPTY;
        RString 行項目_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数 = RString.EMPTY;
        RString 行項目_短期入所生活介護の日数 = RString.EMPTY;
        RString 行項目_短期入所療養介護の日数 = RString.EMPTY;
        RString 行項目_特定施設入所者生活介護の日数 = RString.EMPTY;
        RString 行項目_福祉用具貸与の品目 = RString.EMPTY;
        RString 行項目_福祉用具購入の品目 = RString.EMPTY;
        RString 行項目_住宅改修 = RString.EMPTY;
        RString 行項目_夜間対応型訪問介護の日数 = RString.EMPTY;
        RString 行項目_認知症対応型通所介護の日数 = RString.EMPTY;
        RString 行項目_小規模多機能型居宅介護の日数 = RString.EMPTY;
        RString 行項目_認知症対応型共同生活介護の日数 = RString.EMPTY;
        RString 行項目_地域密着型特定施設入居者生活介護の日数 = RString.EMPTY;
        RString 行項目_地域密着型介護老人福祉施設入居者生活介護の日数 = RString.EMPTY;
        RString 行項目_看護小規模多機能型居宅介護 = RString.EMPTY;
        RString 行項目_随時対応型訪問介護看護 = RString.EMPTY;
        RString 行項目_施設利用の有無 = RString.EMPTY;

        RString 行項目_麻痺 = RString.EMPTY;
        RString 行項目_拘縮 = RString.EMPTY;
        RString 行項目_寝返り = RString.EMPTY;
        RString 行項目_起き上がり = RString.EMPTY;
        RString 行項目_座位保持 = RString.EMPTY;
        RString 行項目_両足での立位 = RString.EMPTY;
        RString 行項目_歩行 = RString.EMPTY;
        RString 行項目_立ち上がり = RString.EMPTY;
        RString 行項目_片足での立位 = RString.EMPTY;
        RString 行項目_洗身 = RString.EMPTY;
        RString 行項目_つめ切り = RString.EMPTY;
        RString 行項目_視力 = RString.EMPTY;
        RString 行項目_聴力 = RString.EMPTY;
        RString 行項目_移乗 = RString.EMPTY;
        RString 行項目_移動 = RString.EMPTY;
        RString 行項目_えん下 = RString.EMPTY;
        RString 行項目_食事摂取 = RString.EMPTY;
        RString 行項目_排尿 = RString.EMPTY;
        RString 行項目_排便 = RString.EMPTY;
        RString 行項目_口腔清潔 = RString.EMPTY;
        RString 行項目_洗顔 = RString.EMPTY;
        RString 行項目_整髪 = RString.EMPTY;
        RString 行項目_上衣の着脱 = RString.EMPTY;
        RString 行項目_ズボン等の着脱 = RString.EMPTY;
        RString 行項目_外出頻度 = RString.EMPTY;
        RString 行項目_意思の疎通 = RString.EMPTY;
        RString 行項目_毎日の日課を理解 = RString.EMPTY;
        RString 行項目_生年月日をいう = RString.EMPTY;
        RString 行項目_短期記憶 = RString.EMPTY;
        RString 行項目_自分の名前をいう = RString.EMPTY;
        RString 行項目_今の季節を理解 = RString.EMPTY;
        RString 行項目_場所の理解 = RString.EMPTY;
        RString 行項目_徘徊 = RString.EMPTY;
        RString 行項目_外出して戻れない = RString.EMPTY;
        RString 行項目_被害的 = RString.EMPTY;
        RString 行項目_作話 = RString.EMPTY;
        RString 行項目_感情が不安定 = RString.EMPTY;
        RString 行項目_昼夜逆転 = RString.EMPTY;
        RString 行項目_同じ話をする = RString.EMPTY;
        RString 行項目_大声を出す = RString.EMPTY;
        RString 行項目_介護に抵抗 = RString.EMPTY;
        RString 行項目_落ち着きなし = RString.EMPTY;
        RString 行項目_一人で出たがる = RString.EMPTY;
        RString 行項目_収集癖 = RString.EMPTY;
        RString 行項目_物や衣類を壊す = RString.EMPTY;
        RString 行項目_ひどい物忘れ = RString.EMPTY;
        RString 行項目_独り言 = RString.EMPTY;
        RString 行項目_自分勝手に行動する = RString.EMPTY;
        RString 行項目_話がまとまらない = RString.EMPTY;
        RString 行項目_薬の内服 = RString.EMPTY;
        RString 行項目_金銭の管理 = RString.EMPTY;
        RString 行項目_日常の意思決定 = RString.EMPTY;
        RString 行項目_集団への不適応 = RString.EMPTY;
        RString 行項目_買い物 = RString.EMPTY;
        RString 行項目_簡単な調理 = RString.EMPTY;
        RString 行項目_過去14日間に受けた治療 = RString.EMPTY;
        RString 行項目_認知症高齢者の日常生活自立度 = RString.EMPTY;
        RString 行項目_障害高齢者の日常生活自立度 = RString.EMPTY;

        List<RString> lineList = line.split(",");
        int size = lineList.size();
        if (size == 32) {
            行項目_調査区分 = lineList.get(0);
            行項目_保険者番号 = lineList.get(2);
            行項目_申請日 = lineList.get(3);
            行項目_被保険者番号 = lineList.get(4);
            行項目_実施日時 = lineList.get(5);
            行項目_実施場所 = lineList.get(6);
            行項目_記入者 = lineList.get(7);
            行項目_所属機関 = lineList.get(8);
            行項目_サービス区分コード = lineList.get(9);
            行項目_訪問介護の回数 = lineList.get(10);
            行項目_訪問入浴介護の回数 = lineList.get(11);
            行項目_訪問看護の回数 = lineList.get(12);
            行項目_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数 = lineList.get(13);
            行項目_居宅療養管理指導の回数 = lineList.get(14);
            行項目_通所看護の回数 = lineList.get(15);
            行項目_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数 = lineList.get(16);
            行項目_短期入所生活介護の日数 = lineList.get(17);
            行項目_短期入所療養介護の日数 = lineList.get(18);
            行項目_特定施設入所者生活介護の日数 = lineList.get(19);
            行項目_福祉用具貸与の品目 = lineList.get(20);
            行項目_福祉用具購入の品目 = lineList.get(21);
            行項目_住宅改修 = lineList.get(22);
            行項目_夜間対応型訪問介護の日数 = lineList.get(23);
            行項目_認知症対応型通所介護の日数 = lineList.get(24);
            行項目_小規模多機能型居宅介護の日数 = lineList.get(25);
            行項目_認知症対応型共同生活介護の日数 = lineList.get(26);
            行項目_地域密着型特定施設入居者生活介護の日数 = lineList.get(27);
            行項目_地域密着型介護老人福祉施設入居者生活介護の日数 = lineList.get(28);
            行項目_看護小規模多機能型居宅介護 = lineList.get(29);
            行項目_随時対応型訪問介護看護 = lineList.get(30);
            行項目_施設利用の有無 = lineList.get(31);

        } else if (size == 63) {
            行項目_調査区分 = lineList.get(0);
            行項目_保険者番号 = lineList.get(2);
            行項目_申請日 = lineList.get(3);
            行項目_被保険者番号 = lineList.get(4);
            行項目_麻痺 = lineList.get(5);
            行項目_拘縮 = lineList.get(6);
            行項目_寝返り = lineList.get(7);
            行項目_起き上がり = lineList.get(8);
            行項目_座位保持 = lineList.get(9);
            行項目_両足での立位 = lineList.get(10);
            行項目_歩行 = lineList.get(11);
            行項目_立ち上がり = lineList.get(12);
            行項目_片足での立位 = lineList.get(13);
            行項目_洗身 = lineList.get(14);
            行項目_つめ切り = lineList.get(15);
            行項目_視力 = lineList.get(16);
            行項目_聴力 = lineList.get(17);
            行項目_移乗 = lineList.get(18);
            行項目_移動 = lineList.get(19);
            行項目_えん下 = lineList.get(20);
            行項目_食事摂取 = lineList.get(21);
            行項目_排尿 = lineList.get(22);
            行項目_排便 = lineList.get(23);
            行項目_口腔清潔 = lineList.get(24);
            行項目_洗顔 = lineList.get(25);
            行項目_整髪 = lineList.get(26);
            行項目_上衣の着脱 = lineList.get(27);
            行項目_ズボン等の着脱 = lineList.get(28);
            行項目_外出頻度 = lineList.get(29);
            行項目_意思の疎通 = lineList.get(30);
            行項目_毎日の日課を理解 = lineList.get(31);
            行項目_生年月日をいう = lineList.get(32);
            行項目_短期記憶 = lineList.get(33);
            行項目_自分の名前をいう = lineList.get(34);
            行項目_今の季節を理解 = lineList.get(35);
            行項目_場所の理解 = lineList.get(36);
            行項目_徘徊 = lineList.get(37);
            行項目_外出して戻れない = lineList.get(38);
            行項目_被害的 = lineList.get(39);
            行項目_作話 = lineList.get(40);
            行項目_感情が不安定 = lineList.get(41);
            行項目_昼夜逆転 = lineList.get(42);
            行項目_同じ話をする = lineList.get(43);
            行項目_大声を出す = lineList.get(44);
            行項目_介護に抵抗 = lineList.get(45);
            行項目_落ち着きなし = lineList.get(46);
            行項目_一人で出たがる = lineList.get(47);
            行項目_収集癖 = lineList.get(48);
            行項目_物や衣類を壊す = lineList.get(49);
            行項目_ひどい物忘れ = lineList.get(50);
            行項目_独り言 = lineList.get(51);
            行項目_自分勝手に行動する = lineList.get(52);
            行項目_話がまとまらない = lineList.get(53);
            行項目_薬の内服 = lineList.get(54);
            行項目_金銭の管理 = lineList.get(55);
            行項目_日常の意思決定 = lineList.get(56);
            行項目_集団への不適応 = lineList.get(57);
            行項目_買い物 = lineList.get(58);
            行項目_簡単な調理 = lineList.get(59);
            行項目_過去14日間に受けた治療 = lineList.get(60);
            行項目_認知症高齢者の日常生活自立度 = lineList.get(61);
            行項目_障害高齢者の日常生活自立度 = lineList.get(62);
        } else {
            イメージファイル = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (lineList.get(i).contains("\\")) {
                    RString fileTest = lineList.get(i).substring(lineList.get(i).lastIndexOf("\\") + 1);
                    if (fileTest.contains("01i011")) {
                        RString fileName = new RString("C0001.png");
                        イメージファイル.add(fileName);
                    } else if (fileTest.contains("01i048")) {
                        RString fileName = new RString("C0004.png");
                        イメージファイル.add(fileName);
                    } else if (fileTest.contains("01i049")) {
                        RString fileName = new RString("C0005.png");
                        イメージファイル.add(fileName);
                    } else if (fileTest.contains("01i050")) {
                        RString fileName = new RString("C0006.png");
                        イメージファイル.add(fileName);
                    } else if (fileTest.contains("01i051")) {
                        RString fileName = new RString("G0001.png");
                        イメージファイル.add(fileName);
                    } else if (fileTest.contains("01i038")) {
                        RString fileName = new RString("C0002.png");
                        イメージファイル.add(fileName);
                    } else if (fileTest.contains("01i039")) {
                        RString fileName = new RString("C0003.png");
                        イメージファイル.add(fileName);
                    }
                }
            }
        }

        if (行項目_調査区分.equals(概況調査区分)) {
            OcrJohoOcrDataRecordEntity データ行Entity = new OcrJohoOcrDataRecordEntity();

            データ行Entity.set調査区分(行項目_調査区分);
            データ行Entity.set保険者番号(行項目_保険者番号);
            データ行Entity.set申請日(to西暦_年(行項目_申請日));
            データ行Entity.set被保険者番号(行項目_被保険者番号);
            データ行Entity.set行項目_6(行項目_実施日時);
            データ行Entity.set行項目_7(行項目_実施場所);
            データ行Entity.set行項目_8(行項目_記入者);
            データ行Entity.set行項目_9(行項目_所属機関);
            データ行Entity.set行項目_10(行項目_サービス区分コード);
            データ行Entity.set行項目_11(行項目_訪問介護の回数);
            データ行Entity.set行項目_12(行項目_訪問入浴介護の回数);
            データ行Entity.set行項目_13(行項目_訪問看護の回数);
            データ行Entity.set行項目_14(行項目_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数);
            データ行Entity.set行項目_15(行項目_居宅療養管理指導の回数);
            データ行Entity.set行項目_16(行項目_通所看護の回数);
            データ行Entity.set行項目_17(行項目_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数);
            データ行Entity.set行項目_18(行項目_短期入所生活介護の日数);
            データ行Entity.set行項目_19(行項目_短期入所療養介護の日数);
            データ行Entity.set行項目_20(行項目_特定施設入所者生活介護の日数);
            データ行Entity.set行項目_21(行項目_福祉用具貸与の品目);
            データ行Entity.set行項目_22(行項目_福祉用具購入の品目);
            データ行Entity.set行項目_23(行項目_住宅改修);
            データ行Entity.set行項目_24(行項目_夜間対応型訪問介護の日数);
            データ行Entity.set行項目_25(行項目_認知症対応型通所介護の日数);
            データ行Entity.set行項目_26(行項目_小規模多機能型居宅介護の日数);
            データ行Entity.set行項目_27(行項目_認知症対応型共同生活介護の日数);
            データ行Entity.set行項目_28(行項目_地域密着型特定施設入居者生活介護の日数);
            データ行Entity.set行項目_29(行項目_地域密着型介護老人福祉施設入居者生活介護の日数);
            データ行Entity.set行項目_30(行項目_看護小規模多機能型居宅介護);
            データ行Entity.set行項目_31(行項目_随時対応型訪問介護看護);
            データ行Entity.set行項目_32(行項目_施設利用の有無);
            ocrDataデータ行Entity = データ行Entity;

        } else if (行項目_調査区分.equals(基本調査区分)) {
            OcrJohoOcrDataRecordEntity データ行Entity = new OcrJohoOcrDataRecordEntity();
            データ行Entity.set調査区分(行項目_調査区分);
            データ行Entity.set保険者番号(行項目_保険者番号);
            データ行Entity.set申請日(to西暦_年(行項目_申請日));
            データ行Entity.set被保険者番号(行項目_被保険者番号);
            データ行Entity.set行項目_6(行項目_麻痺);
            データ行Entity.set行項目_7(行項目_拘縮);
            データ行Entity.set行項目_8(行項目_寝返り);
            データ行Entity.set行項目_9(行項目_起き上がり);
            データ行Entity.set行項目_10(行項目_座位保持);
            データ行Entity.set行項目_11(行項目_両足での立位);
            データ行Entity.set行項目_12(行項目_歩行);
            データ行Entity.set行項目_13(行項目_立ち上がり);
            データ行Entity.set行項目_14(行項目_片足での立位);
            データ行Entity.set行項目_15(行項目_洗身);
            データ行Entity.set行項目_16(行項目_つめ切り);
            データ行Entity.set行項目_17(行項目_視力);
            データ行Entity.set行項目_18(行項目_聴力);
            データ行Entity.set行項目_19(行項目_移乗);
            データ行Entity.set行項目_20(行項目_移動);
            データ行Entity.set行項目_21(行項目_えん下);
            データ行Entity.set行項目_22(行項目_食事摂取);
            データ行Entity.set行項目_23(行項目_排尿);
            データ行Entity.set行項目_24(行項目_排便);
            データ行Entity.set行項目_25(行項目_口腔清潔);
            データ行Entity.set行項目_26(行項目_洗顔);
            データ行Entity.set行項目_27(行項目_整髪);
            データ行Entity.set行項目_28(行項目_上衣の着脱);
            データ行Entity.set行項目_29(行項目_ズボン等の着脱);
            データ行Entity.set行項目_30(行項目_外出頻度);
            データ行Entity.set行項目_31(行項目_意思の疎通);
            データ行Entity.set行項目_32(行項目_毎日の日課を理解);
            データ行Entity.set行項目_33(行項目_生年月日をいう);
            データ行Entity.set行項目_34(行項目_短期記憶);
            データ行Entity.set行項目_35(行項目_自分の名前をいう);
            データ行Entity.set行項目_36(行項目_今の季節を理解);
            データ行Entity.set行項目_37(行項目_場所の理解);
            データ行Entity.set行項目_38(行項目_徘徊);
            データ行Entity.set行項目_39(行項目_外出して戻れない);
            データ行Entity.set行項目_40(行項目_被害的);
            データ行Entity.set行項目_41(行項目_作話);
            データ行Entity.set行項目_42(行項目_感情が不安定);
            データ行Entity.set行項目_43(行項目_昼夜逆転);
            データ行Entity.set行項目_44(行項目_同じ話をする);
            データ行Entity.set行項目_45(行項目_大声を出す);
            データ行Entity.set行項目_46(行項目_介護に抵抗);
            データ行Entity.set行項目_47(行項目_落ち着きなし);
            データ行Entity.set行項目_48(行項目_一人で出たがる);
            データ行Entity.set行項目_49(行項目_収集癖);
            データ行Entity.set行項目_50(行項目_物や衣類を壊す);
            データ行Entity.set行項目_51(行項目_ひどい物忘れ);
            データ行Entity.set行項目_52(行項目_独り言);
            データ行Entity.set行項目_53(行項目_自分勝手に行動する);
            データ行Entity.set行項目_54(行項目_話がまとまらない);
            データ行Entity.set行項目_55(行項目_薬の内服);
            データ行Entity.set行項目_56(行項目_金銭の管理);
            データ行Entity.set行項目_57(行項目_日常の意思決定);
            データ行Entity.set行項目_58(行項目_集団への不適応);
            データ行Entity.set行項目_59(行項目_買い物);
            データ行Entity.set行項目_60(行項目_簡単な調理);
            データ行Entity.set行項目_61(行項目_過去14日間に受けた治療);
            データ行Entity.set障害高齢者の日常生活自立度(行項目_障害高齢者の日常生活自立度);
            データ行Entity.set認知症高齢者の日常生活自立度(行項目_認知症高齢者の日常生活自立度);

            ocrDataデータ行Entity = データ行Entity;
        }
    }

    private RString to西暦_年(RString 和暦_日付) {
        RString 年号 = RDate.getNowDate().wareki().getEra();
        if (和暦_日付 != null) {
            和暦_日付 = 和暦_日付.trim();
            RString 和暦 = 年号.concat(和暦_日付);
            RDate result = null;
            result = new RDate(和暦.toString());
            return result.toDateString();
        }
        return RString.EMPTY;
    }
}
