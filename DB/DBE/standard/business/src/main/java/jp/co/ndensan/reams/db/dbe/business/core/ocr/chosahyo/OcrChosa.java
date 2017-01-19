/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.OcrIken;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import lombok.AccessLevel;

/**
 * OCR情報受入＿バッチ ファイル読み取り結果 クラスです。
 *
 * @author n8429
 */
@lombok.Getter
@lombok.Setter(AccessLevel.PRIVATE)
@SuppressWarnings("PMD.UnusedPrivateField")
public class OcrChosa {

    @lombok.Setter(lombok.AccessLevel.PRIVATE)
    private ShinseiKey key = ShinseiKey.EMPTY;
    private RString データ行_文字列;
    private OCRID ocrID = OCRID.EMPTY;
    private SheetID sheetID = SheetID.EMPTY;

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
    private Code 認知症高齢者の日常生活自立度;
    private Code 障害高齢者の日常生活自立度;

    private Map<RString, KomokuNo> 特記事項ImageFileName_調査項目_Map;

    private OcrChosa() {
    }

    /**
     * 行を解析した結果より、インスタンスを生成します。
     *
     * 存在しない項目の値は、{@link RString#EMPTY}など、null以外の値で初期化されます。
     *
     * @param line 行
     * @return {@link OcrIken}
     */
    public static OcrChosa parsed(RString line) {
        return parseデータ行(line);
    }

    private static OcrChosa parseデータ行(RString line) {
        OcrChosa result = new OcrChosa();
        result.clear();
        result.setデータ行_文字列(line);
        List<RString> columns = Collections.unmodifiableList(line.split(","));
        if (columns == null || columns.isEmpty()) {
            return result;
        }
        result.setOcrID(OCRID.toValueOrEMPTY(columns.get(0)));
        if (result.getOcrID() == OCRID._501) {
            result.setSheetID(new SheetID(columns.get(1)));
            result.set保険者番号(columns.get(2));
            result.set申請日(to西暦_年(columns.get(3)));
            result.set被保険者番号(columns.get(4));
            result.setKey(new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日()));
            result.set実施日時(to西暦_年(columns.get(5)));
            result.set実施場所(columns.get(6));
            result.set記入者(columns.get(7));
            result.set所属機関(columns.get(8));
            result.setサービス区分コード(columns.get(9));
            result.set訪問介護の回数(columns.get(10));
            result.set訪問入浴介護の回数(columns.get(11));
            result.set訪問看護の回数(columns.get(12));
            result.set訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数(columns.get(13));
            result.set居宅療養管理指導の回数(columns.get(14));
            result.set通所看護の回数(columns.get(15));
            result.set通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数(columns.get(16));
            result.set短期入所生活介護の日数(columns.get(17));
            result.set短期入所療養介護の日数(columns.get(18));
            result.set特定施設入所者生活介護の日数(columns.get(19));
            result.set福祉用具貸与の品目(columns.get(20));
            result.set福祉用具購入の品目(columns.get(21));
            result.set住宅改修(columns.get(22));
            result.set夜間対応型訪問介護の日数(columns.get(23));
            result.set認知症対応型通所介護の日数(columns.get(24));
            result.set小規模多機能型居宅介護の日数(columns.get(25));
            result.set認知症対応型共同生活介護の日数(columns.get(26));
            result.set地域密着型特定施設入居者生活介護の日数(columns.get(27));
            result.set地域密着型介護老人福祉施設入居者生活介護の日数(columns.get(28));
            result.set看護小規模多機能型居宅介護(columns.get(29));
            result.set随時対応型訪問介護看護(columns.get(30));
            result.set施設利用の有無(columns.get(31));

        } else if (result.getOcrID() == OCRID._502) {
            result.setSheetID(new SheetID(columns.get(1)));
            result.set保険者番号(columns.get(2));
            result.set申請日(to西暦_年(columns.get(3)));
            result.set被保険者番号(columns.get(4));
            result.setKey(new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日()));
            result.set麻痺(columns.get(5));
            result.set拘縮(columns.get(6));
            result.set寝返り(columns.get(7));
            result.set起き上がり(columns.get(8));
            result.set座位保持(columns.get(9));
            result.set両足での立位(columns.get(10));
            result.set歩行(columns.get(11));
            result.set立ち上がり(columns.get(12));
            result.set片足での立位(columns.get(13));
            result.set洗身(columns.get(14));
            result.setつめ切り(columns.get(15));
            result.set視力(columns.get(16));
            result.set聴力(columns.get(17));
            result.set移乗(columns.get(18));
            result.set移動(columns.get(19));
            result.setえん下(columns.get(20));
            result.set食事摂取(columns.get(21));
            result.set排尿(columns.get(22));
            result.set排便(columns.get(23));
            result.set口腔清潔(columns.get(24));
            result.set洗顔(columns.get(25));
            result.set整髪(columns.get(26));
            result.set上衣の着脱(columns.get(27));
            result.setズボン等の着脱(columns.get(28));
            result.set外出頻度(columns.get(29));
            result.set意思の疎通(columns.get(30));
            result.set毎日の日課を理解(columns.get(31));
            result.set生年月日をいう(columns.get(32));
            result.set短期記憶(columns.get(33));
            result.set自分の名前をいう(columns.get(34));
            result.set今の季節を理解(columns.get(35));
            result.set場所の理解(columns.get(36));
            result.set徘徊(columns.get(37));
            result.set外出して戻れない(columns.get(38));
            result.set被害的(columns.get(39));
            result.set作話(columns.get(40));
            result.set感情が不安定(columns.get(41));
            result.set昼夜逆転(columns.get(42));
            result.set同じ話をする(columns.get(43));
            result.set大声を出す(columns.get(44));
            result.set介護に抵抗(columns.get(45));
            result.set落ち着きなし(columns.get(46));
            result.set一人で出たがる(columns.get(47));
            result.set収集癖(columns.get(48));
            result.set物や衣類を壊す(columns.get(49));
            result.setひどい物忘れ(columns.get(50));
            result.set独り言(columns.get(51));
            result.set自分勝手に行動する(columns.get(52));
            result.set話がまとまらない(columns.get(53));
            result.set薬の内服(columns.get(54));
            result.set金銭の管理(columns.get(55));
            result.set日常の意思決定(columns.get(56));
            result.set集団への不適応(columns.get(57));
            result.set買い物(columns.get(58));
            result.set簡単な調理(columns.get(59));
            result.set過去14日間に受けた治療(columns.get(60));
            result.set障害高齢者の日常生活自立度(new Code(columns.get(61)));
            result.set認知症高齢者の日常生活自立度(new Code(columns.get(62)));
        } else if (result.getOcrID() == OCRID._550) {
            RString sheetIdValue = columns.get(1);
            result.setSheetID(new SheetID(sheetIdValue));
            result.set保険者番号(columns.get(2));
            result.set申請日(to西暦_年(columns.get(3)));
            result.set被保険者番号(columns.get(4));
            result.setKey(new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日()));
            Map<RString, KomokuNo> map = new HashMap<>();
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i030.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 5));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i031.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 6));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i032.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 7));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i033.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 8));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i034.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 9));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i035.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 10));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i036.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 11));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i037.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 12));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i038.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 13));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i039.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 14));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i040.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 15));
            map.put(new RStringBuilder().append(sheetIdValue).append("w01i041.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 16));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i025.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 17));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i026.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 18));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i027.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 19));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i028.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 20));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i029.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 21));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i030.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 22));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i031.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 23));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i032.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 24));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i033.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 25));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i034.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 26));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i035.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 27));
            map.put(new RStringBuilder().append(sheetIdValue).append("w02i036.png").toRString(), getListConvertingKomokuNoOrEMPTY(columns, 28));
            result.set特記事項ImageFileName_調査項目_Map(map);
        }
        return result;
    }

    private static KomokuNo getListConvertingKomokuNoOrEMPTY(List<RString> list, int index) {
        if (list.size() <= index) {
            return KomokuNo.EMPTY;
        }
        return new KomokuNo(list.get(index));
    }

    /**
     * @return 特記事項のイメージフィールド名と調査項目の対応のMapを返します。
     */
    public Map<RString, KomokuNo> get特記事項ImageFileName_調査項目_Map() {
        return Collections.unmodifiableMap(特記事項ImageFileName_調査項目_Map);
    }

    /**
     * @return 項目番号が空であるファイル名をすべて返します。
     */
    public List<RString> get特記事項ImageFileName_KomokuNoIsNotPresent() {
        List<RString> list = new ArrayList<>();
        for (Map.Entry<RString, KomokuNo> entry : get特記事項ImageFileName_調査項目_Map().entrySet()) {
            if (entry.getValue().isEmpty()) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private static RString to西暦_年(RString 和暦_日付) {
        RString 年号 = RDate.getNowDate().wareki().getEra();
        if (和暦_日付 != null) {
            RString 和暦 = 年号.concat(和暦_日付.trim());
            RDate result = new RDate(和暦.toString());
            return result.toDateString();
        }
        return RString.EMPTY;
    }

    /**
     * メンバ変数のクリア
     */
    private void clear() {
        this.key = ShinseiKey.EMPTY;
        this.データ行_文字列 = RString.EMPTY;
        this.ocrID = OCRID.EMPTY;
        this.sheetID = SheetID.EMPTY;

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
        this.認知症高齢者の日常生活自立度 = Code.EMPTY;
        this.障害高齢者の日常生活自立度 = Code.EMPTY;

        this.特記事項ImageFileName_調査項目_Map = new HashMap<>();
    }

}
