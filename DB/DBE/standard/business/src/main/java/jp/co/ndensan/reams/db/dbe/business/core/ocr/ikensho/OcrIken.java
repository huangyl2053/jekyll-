/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho;

import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCRIKEN.csvの取込結果1行を扱います。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class OcrIken implements IOcrData {

    private static final RString 意見書_表 = new RString("701");
    private static final RString 意見書_裏 = new RString("702");
    private static final RString 意見書_ID777 = new RString("777");
    private static final RString 意見書_ID778 = new RString("778");
    private static final int 切り出し桁数 = 1;
    private static final int 桁数固定値_内科 = 0;
    private static final int 桁数固定値_皮膚科 = 1;
    private static final int 桁数固定値_リハビリテーション科 = 2;
    private static final int 桁数固定値_精神科 = 3;
    private static final int 桁数固定値_泌尿器科 = 4;
    private static final int 桁数固定値_歯科 = 5;
    private static final int 桁数固定値_外科 = 6;
    private static final int 桁数固定値_婦人科 = 7;
    private static final int 桁数固定値_その他受診科 = 8;
    private static final int 桁数固定値_整形外科 = 9;
    private static final int 桁数固定値_眼科 = 10;
    private static final int 桁数固定値_脳神経外科 = 11;
    private static final int 桁数固定値_耳鼻咽喉科 = 12;
    //key
    @lombok.Setter(lombok.AccessLevel.PRIVATE)
    private ShinseiKey key;

    // 1行の内容
    private RString データ行_文字列;

    //OCRID
    private OCRID oCRID;

    //sheetID
    private SheetID sheetID;

    // ID701　ここから
    private RString 保険者番号;
    private RString 申請日;
    private RString 被保険者番号;
    private RString 同意の有無;
    // （１）最終診察日
    private RString 最終診察日;
    private RString 記入日;
    // （２）受領日
    private RString 受領日;
    // （２）意見書作成回数
    private RString 意見書作成回数;
    // （３）他科受信の有無
    private RString 他科受診の有無;
    private RString 記入のあった科; // 内科, 皮膚科,リハビリテーション科,精神科,泌尿器科,歯科,外科,婦人科,その他,整形外科,眼科,脳神経外科,耳鼻咽喉科;
    private RString 内科受診の有無;
    private RString 精神科受診の有無;
    private RString 外科受診の有無;
    private RString 整形外科受診の有無;
    private RString 脳神経外科の有無;
    private RString 皮膚科受診の有無;
    private RString 泌尿器科受診の有無;
    private RString 婦人科受診の有無;
    private RString 耳鼻咽喉科受診の有無;
    private RString リハビリテーション科受診の有無;
    private RString 歯科受診の有無;
    private RString 眼科の有無;
    private RString その他受診科の有無;
    // １．傷病に関する意見
    // （１）診断名
    private RString 発症年月日１和暦;
    private RString 発症年月日１;
    private RString 発症年月日２和暦;
    private RString 発症年月日２;
    private RString 発症年月日３和暦;
    private RString 発症年月日３;
    // （２）症状としての安定性
    private RString 症状の安定性;
    // （３）生活機能の低下の直接の原因となっている傷病特定疾病の経過及び投薬内容を含む治療内容
    // ２．特別な医療
    // ■処置内容
    private RString 処置内容; //点滴の管理,ストーマの処置,気管切開の処置,中心静脈栄養,酸素療法,疼痛の看護,透析,レスピレーター,経菅栄養
    // ■特別な対応
    private RString 特別な対応; // モニター測定,褥痩（じょくそう）の処置
    // ■失禁への対応
    private RString カテーテル;
    // ３．心身の状態に関する意見
    // （１）日常生活の自立度等について
    private RString 障害高齢者の自立度;
    private RString 認知症高齢者の自立度;
    // （２）認知症の中核症状
    private RString 短期記憶;
    private RString 認知能力;
    private RString 伝達能力;
    // （３）認知症の周辺情報;
    private RString 問題行動の有無;
    private RString 問題行動; // 幻視・幻聴,火の不始末,妄想,不潔行為,昼夜逆転,異食行動,暴言,性的問題行動,暴行,その他,介護への抵抗,徘徊
    // （４）その他の精神・神経症状
    private RString 精神神経症状;
    private RString 専門科医受診;

    // ID702 ここから
    // （５）心身の状態
    private RString 利き腕;
    private RString 過去6ヶ月間の体重の変化;
    private RString 四肢欠損;
    private RString 麻痺;
    private RString 麻痺右上肢;
    private RString 麻痺右上肢程度;
    private RString 麻痺右下肢;
    private RString 麻痺右下肢程度;
    private RString 麻痺左上肢;
    private RString 麻痺左上肢程度;
    private RString 麻痺左下肢;
    private RString 麻痺左下肢程度;
    private RString 麻痺その他;
    private RString 麻痺その他程度;
    private RString 筋力低下;
    private RString 筋力低下程度;
    private RString 間接の拘縮;
    private RString 間接の拘縮程度;
    private RString 間接の痛み;
    private RString 間接の痛み程度;
    private RString 失調不随意運動;
    private RString 失調不随意上肢; // 1桁目：右、2桁目：左
    private RString 失調不随意下肢; // 1桁目：右、2桁目：左
    private RString 失調不随意体幹; // 1桁目：右、2桁目：左
    private RString 褥痩; // じょくそう
    private RString 褥痩程度;
    private RString その他皮膚疾患;
    private RString その他皮膚疾患程度;
    // ４．生活機能とサービスに関する意見
    // （１）移動
    private RString 屋外歩行;
    private RString 車いすの使用;
    private RString 歩行補助具装具の使用;
    // （２）栄養・食生活
    private RString 食事行為;
    private RString 現在の栄養状況;
    // （３）現在あるかまたは今後発生の可能性が高い状態とその対処方針
    private RString 現在または今後発生の可能性の高い状態; //尿失禁,転倒・骨折,移動能力の低下,褥痩（じょくそう）,心肺機能の低下,閉じこもり,意欲低下,徘徊,低栄養,摂食・嚥下機能低下,脱水,易感染症,がん等による疼痛,その他
    // （４）介護の必要の程度に関する予後の見通し
    private RString 予後の見通し;
    // （５）医学的管理の必要性
    private RString 医学的管理の必要性チェック; //訪問介護,訪問看護,看護職員の訪問による相談・支援,訪問歯科診療,訪問薬剤管理指導,訪問リハビリテーション,短期入所療養介護,訪問歯科衛生指導,訪問栄養食事指導,通所リハビリテーション,その他の医療系サービス
    private RString 医学的管理の必要性下線;
    // （６）サービス提供時における医学的観点からの留意事項
    private RString 血圧;
    private RString 移動;
    private RString 摂食;
    private RString 運動;
    private RString 嚥下;
    // （７）感染症の有無
    private RString 感染症;
    // ５．その他特記すべき事項
    private RString 主治医への結果連絡;

    // 全体イメージ（帳票一面のイメージ）中で、表側の画像を示すインデックス（規定外、規定外IDで利用する）
    private RString 全体イメージ表側インデックス;

    private OcrIken() {
    }

    /**
     * 行を解析した結果より、インスタンスを生成します。
     *
     * 存在しない項目の値は、{@link RString#EMPTY}など、null以外の値で初期化されます。
     *
     * @param line 行
     * @return {@link OcrIken}
     */
    public static OcrIken parsed(RString line) {
        return parseデータ行(line);
    }

    private static OcrIken parseデータ行(RString line) {
        OcrIken result = new OcrIken();
        result.clear();
        result.setデータ行_文字列(line);
        List<RString> columns = Collections.unmodifiableList(line.split(","));
        if (columns == null || columns.isEmpty()) {
            return result;
        }
        RString ocrID = columns.get(0);
        if (意見書_表.equals(ocrID)) {
            //CHECKSTYLE IGNORE MagicNumber FOR NEXT 33 LINES
            result.setOCRID(OCRID.toValueOrEMPTY(columns.get(0)));
            result.setSheetID(new SheetID(columns.get(1)));
            result.set保険者番号(columns.get(2));
            result.set申請日(get西暦_年(columns.get(3)));
            result.set被保険者番号(columns.get(4));
            result.setKey(new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日()));
            result.set同意の有無(columns.get(5));
            result.set最終診察日(get西暦_年(columns.get(6)));
            result.set記入日(get西暦_年(columns.get(7)));
            result.set受領日(get西暦_年(columns.get(8)));
            result.set意見書作成回数(columns.get(9));
            result.set他科受診の有無(columns.get(10));
            result.set記入のあった科(columns.get(11));
            result.set受診科(columns.get(11));
            result.set発症年月日１和暦(columns.get(12));
            result.set発症年月日１(get西暦_年(columns.get(13)));
            result.set発症年月日２和暦(columns.get(14));
            result.set発症年月日２(get西暦_年(columns.get(15)));
            result.set発症年月日３和暦(columns.get(16));
            result.set発症年月日３(get西暦_年(columns.get(17)));
            result.set症状の安定性(columns.get(18));
            result.set処置内容(columns.get(19));
            result.set特別な対応(columns.get(20));
            result.setカテーテル(columns.get(21));
            result.set障害高齢者の自立度(columns.get(22));
            result.set認知症高齢者の自立度(columns.get(23));
            result.set短期記憶(columns.get(24));
            result.set認知能力(columns.get(25));
            result.set伝達能力(columns.get(26));
            result.set問題行動の有無(columns.get(27));
            result.set問題行動(columns.get(28));
            result.set精神神経症状(columns.get(29));
            result.set専門科医受診(columns.get(30));

        } else if (意見書_裏.equals(ocrID)) {
            //CHECKSTYLE IGNORE MagicNumber FOR NEXT 50 LINES
            result.setOCRID(OCRID.toValueOrEMPTY(columns.get(0)));
            result.setSheetID(new SheetID(columns.get(1)));
            result.set保険者番号(columns.get(2));
            result.set申請日(get西暦_年(columns.get(3)));
            result.set被保険者番号(columns.get(4));
            result.setKey(new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日()));
            result.set利き腕(columns.get(5));
            result.set過去6ヶ月間の体重の変化(columns.get(6));
            result.set四肢欠損(columns.get(7));
            result.set麻痺(columns.get(8));
            result.set麻痺右上肢(columns.get(9));
            result.set麻痺右上肢程度(columns.get(10));
            result.set麻痺右下肢(columns.get(11));
            result.set麻痺右下肢程度(columns.get(12));
            result.set麻痺左上肢(columns.get(13));
            result.set麻痺左上肢程度(columns.get(14));
            result.set麻痺左下肢(columns.get(15));
            result.set麻痺左下肢程度(columns.get(16));
            result.set麻痺その他(columns.get(17));
            result.set麻痺その他程度(columns.get(18));
            result.set筋力低下(columns.get(19));
            result.set筋力低下程度(columns.get(20));
            result.set間接の拘縮(columns.get(21));
            result.set間接の拘縮程度(columns.get(22));
            result.set間接の痛み(columns.get(23));
            result.set間接の痛み程度(columns.get(24));
            result.set失調不随意運動(columns.get(25));
            result.set失調不随意上肢(columns.get(26));
            result.set失調不随意下肢(columns.get(27));
            result.set失調不随意体幹(columns.get(28));
            result.set褥痩(columns.get(29));
            result.set褥痩程度(columns.get(30));
            result.setその他皮膚疾患(columns.get(31));
            result.setその他皮膚疾患程度(columns.get(32));
            result.set屋外歩行(columns.get(33));
            result.set車いすの使用(columns.get(34));
            result.set歩行補助具装具の使用(columns.get(35));
            result.set食事行為(columns.get(36));
            result.set現在の栄養状況(columns.get(37));
            result.set現在または今後発生の可能性の高い状態(columns.get(38));
            result.set予後の見通し(columns.get(39));
            result.set医学的管理の必要性チェック(columns.get(40));
            result.set医学的管理の必要性下線(columns.get(41));
            result.set血圧(columns.get(42));
            result.set移動(columns.get(43));
            result.set摂食(columns.get(44));
            result.set運動(columns.get(45));
            result.set嚥下(columns.get(46));
            result.set感染症(columns.get(47));
            result.set主治医への結果連絡(columns.get(48));

        } else if (意見書_ID777.equals(ocrID)) {
            //CHECKSTYLE IGNORE MagicNumber FOR NEXT 17 LINES
            result.setOCRID(OCRID.toValueOrEMPTY(columns.get(0)));
            result.setSheetID(new SheetID(columns.get(1)));
            result.set保険者番号(columns.get(2));
            result.set申請日(get西暦_年(columns.get(3)));
            result.set被保険者番号(columns.get(4));
            result.setKey(new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日()));
            result.set記入日(get西暦_年(columns.get(5)));
            result.set受領日(get西暦_年(columns.get(6)));
            result.set障害高齢者の自立度(columns.get(7));
            result.set認知症高齢者の自立度(columns.get(8));
            result.set短期記憶(columns.get(9));
            result.set認知能力(columns.get(10));
            result.set伝達能力(columns.get(11));
            result.set食事行為(columns.get(12));
            result.set主治医への結果連絡(columns.get(13));
            result.set全体イメージ表側インデックス(columns.get(14));
            result.set同意の有無(columns.get(15));

        } else if (意見書_ID778.equals(ocrID)) {
            //CHECKSTYLE IGNORE MagicNumber FOR NEXT 7 LINES
            result.setOCRID(OCRID.toValueOrEMPTY(columns.get(0)));
            result.setSheetID(new SheetID(columns.get(1)));
            result.set保険者番号(columns.get(2));
            result.set申請日(get西暦_年(columns.get(3)));
            result.set被保険者番号(columns.get(4));
            result.setKey(new ShinseiKey(result.get保険者番号(), result.get被保険者番号(), result.get申請日()));

        }
        return result;
    }

    private static RString get西暦_年(RString 和暦_日付) {
        return RDate.canConvert(和暦_日付)
                ? new RDate(和暦_日付.toString()).toDateString()
                : RString.EMPTY;
    }

    private void set受診科(RString 記入のあった科) {
        this.set内科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_内科, 桁数固定値_内科 + 切り出し桁数));
        this.set精神科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_精神科, 桁数固定値_精神科 + 切り出し桁数));
        this.set外科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_外科, 桁数固定値_外科 + 切り出し桁数));
        this.set整形外科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_整形外科, 桁数固定値_整形外科 + 切り出し桁数));
        this.set脳神経外科の有無(記入のあった科.substringEmptyOnError(桁数固定値_脳神経外科, 桁数固定値_脳神経外科 + 切り出し桁数));
        this.set皮膚科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_皮膚科, 桁数固定値_皮膚科 + 切り出し桁数));
        this.set泌尿器科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_泌尿器科, 桁数固定値_泌尿器科 + 切り出し桁数));
        this.set婦人科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_婦人科, 桁数固定値_婦人科 + 切り出し桁数));
        this.set耳鼻咽喉科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_耳鼻咽喉科, 桁数固定値_耳鼻咽喉科 + 切り出し桁数));
        this.setリハビリテーション科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_リハビリテーション科, 桁数固定値_リハビリテーション科 + 切り出し桁数));
        this.set歯科受診の有無(記入のあった科.substringEmptyOnError(桁数固定値_歯科, 桁数固定値_歯科 + 切り出し桁数));
        this.set眼科の有無(記入のあった科.substringEmptyOnError(桁数固定値_眼科, 桁数固定値_眼科 + 切り出し桁数));
        this.setその他受診科の有無(記入のあった科.substringEmptyOnError(桁数固定値_その他受診科, 桁数固定値_その他受診科 + 切り出し桁数));
    }

    /**
     * 各要素を初期化します。
     *
     * 文字列項目の値は{@link RString#EMPTY}、{@code Collection}の場合は空のインスタンスで初期化します。
     */
    private void clear() {
        this.データ行_文字列 = RString.EMPTY;
        this.key = ShinseiKey.EMPTY;
        this.oCRID = OCRID.EMPTY;
        this.sheetID = SheetID.EMPTY;

        this.保険者番号 = RString.EMPTY;
        this.申請日 = RString.EMPTY;
        this.被保険者番号 = RString.EMPTY;
        this.同意の有無 = RString.EMPTY;
        this.最終診察日 = RString.EMPTY;
        this.記入日 = RString.EMPTY;
        this.受領日 = RString.EMPTY;
        this.意見書作成回数 = RString.EMPTY;
        this.他科受診の有無 = RString.EMPTY;
        this.記入のあった科 = RString.EMPTY;

        this.内科受診の有無 = RString.EMPTY;
        this.精神科受診の有無 = RString.EMPTY;
        this.外科受診の有無 = RString.EMPTY;
        this.整形外科受診の有無 = RString.EMPTY;
        this.脳神経外科の有無 = RString.EMPTY;
        this.皮膚科受診の有無 = RString.EMPTY;
        this.泌尿器科受診の有無 = RString.EMPTY;
        this.婦人科受診の有無 = RString.EMPTY;
        this.耳鼻咽喉科受診の有無 = RString.EMPTY;
        this.リハビリテーション科受診の有無 = RString.EMPTY;
        this.歯科受診の有無 = RString.EMPTY;
        this.眼科の有無 = RString.EMPTY;
        this.その他受診科の有無 = RString.EMPTY;

        this.発症年月日１和暦 = RString.EMPTY;
        this.発症年月日１ = RString.EMPTY;
        this.発症年月日２和暦 = RString.EMPTY;
        this.発症年月日２ = RString.EMPTY;
        this.発症年月日３和暦 = RString.EMPTY;
        this.発症年月日３ = RString.EMPTY;
        this.症状の安定性 = RString.EMPTY;
        this.処置内容 = RString.EMPTY;
        this.特別な対応 = RString.EMPTY;
        this.カテーテル = RString.EMPTY;
        this.障害高齢者の自立度 = RString.EMPTY;
        this.認知症高齢者の自立度 = RString.EMPTY;
        this.短期記憶 = RString.EMPTY;
        this.認知能力 = RString.EMPTY;
        this.伝達能力 = RString.EMPTY;
        this.問題行動の有無 = RString.EMPTY;
        this.問題行動 = RString.EMPTY;
        this.精神神経症状 = RString.EMPTY;
        this.専門科医受診 = RString.EMPTY;

        this.利き腕 = RString.EMPTY;
        this.過去6ヶ月間の体重の変化 = RString.EMPTY;
        this.四肢欠損 = RString.EMPTY;
        this.麻痺 = RString.EMPTY;
        this.麻痺右上肢 = RString.EMPTY;
        this.麻痺右上肢程度 = RString.EMPTY;
        this.麻痺右下肢 = RString.EMPTY;
        this.麻痺右下肢程度 = RString.EMPTY;
        this.麻痺左上肢 = RString.EMPTY;
        this.麻痺左上肢程度 = RString.EMPTY;
        this.麻痺左下肢 = RString.EMPTY;
        this.麻痺左下肢程度 = RString.EMPTY;
        this.麻痺その他 = RString.EMPTY;
        this.麻痺その他程度 = RString.EMPTY;
        this.筋力低下 = RString.EMPTY;
        this.筋力低下程度 = RString.EMPTY;
        this.間接の拘縮 = RString.EMPTY;
        this.間接の拘縮程度 = RString.EMPTY;
        this.間接の痛み = RString.EMPTY;
        this.間接の痛み程度 = RString.EMPTY;
        this.失調不随意運動 = RString.EMPTY;
        this.失調不随意上肢 = RString.EMPTY;
        this.失調不随意下肢 = RString.EMPTY;
        this.失調不随意体幹 = RString.EMPTY;
        this.褥痩 = RString.EMPTY;
        this.褥痩程度 = RString.EMPTY;
        this.その他皮膚疾患 = RString.EMPTY;
        this.その他皮膚疾患程度 = RString.EMPTY;
        this.屋外歩行 = RString.EMPTY;
        this.車いすの使用 = RString.EMPTY;
        this.歩行補助具装具の使用 = RString.EMPTY;
        this.食事行為 = RString.EMPTY;
        this.現在の栄養状況 = RString.EMPTY;
        this.現在または今後発生の可能性の高い状態 = RString.EMPTY;
        this.予後の見通し = RString.EMPTY;
        this.医学的管理の必要性チェック = RString.EMPTY;
        this.医学的管理の必要性下線 = RString.EMPTY;
        this.血圧 = RString.EMPTY;
        this.移動 = RString.EMPTY;
        this.摂食 = RString.EMPTY;
        this.運動 = RString.EMPTY;
        this.嚥下 = RString.EMPTY;
        this.感染症 = RString.EMPTY;
        this.主治医への結果連絡 = RString.EMPTY;

        this.全体イメージ表側インデックス = RString.EMPTY;
    }
}
