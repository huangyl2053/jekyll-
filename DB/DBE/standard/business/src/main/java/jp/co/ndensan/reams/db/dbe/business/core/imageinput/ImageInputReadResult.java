/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.ocrfiledata.OcrFileLineDataTypeModel;
import jp.co.ndensan.reams.db.dbe.entity.csv.imageinput.OcrJohoOcrImageEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチ イメージ取込み結果 クラスです。
 *
 * @author n2818
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageInputReadResult {

    private RString データ行_文字列;

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

    //ID777
    private RString ID777_記入日;
    private RString ID777_受領日;
    private RString ID777_障害高齢者の自立度;
    private RString ID777_認知症高齢者の自立度;
    private RString ID777_短期記憶;
    private RString ID777_認知能力;
    private RString ID777_伝達能力;
    private RString ID777_食事行為;
    private RString ID777_主治医への結果連絡;

    private OcrJohoOcrImageEntity ocrイメージ行Entity;
    private List<RString> イメージファイル;

    private static final RString 意見書_表 = new RString("701");
    private static final RString 意見書_裏 = new RString("702");
    private static final RString 意見書_ID777 = new RString("777");
    private static final RString 意見書_ID778 = new RString("778");

    /**
     * 各要素の初期化
     */
    public void clear() {
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

        //ID777
        this.ID777_記入日 = RString.EMPTY;
        this.ID777_受領日 = RString.EMPTY;
        this.ID777_障害高齢者の自立度 = RString.EMPTY;
        this.ID777_認知症高齢者の自立度 = RString.EMPTY;
        this.ID777_短期記憶 = RString.EMPTY;
        this.ID777_認知能力 = RString.EMPTY;
        this.ID777_伝達能力 = RString.EMPTY;
        this.ID777_食事行為 = RString.EMPTY;
        this.ID777_主治医への結果連絡 = RString.EMPTY;

        this.イメージファイル = new ArrayList<>();
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
        this.parseデータ行(line);
        return OcrFileLineDataTypeModel.行データタイプ_データ行;
    }

    /**
     * データ行の解析
     *
     * @param line 行文字列
     */
    private void parseデータ行(RString line) {
        データ行_文字列 = line;
        RString 行項目_意見書区分 = RString.EMPTY;
        RString 行項目_保険者番号 = RString.EMPTY;
        RString 行項目_申請日 = RString.EMPTY;
        RString 行項目_被保険者番号 = RString.EMPTY;

        //ID701
        RString 行項目_同意の有無 = RString.EMPTY;
        RString 行項目_最終診察日 = RString.EMPTY;
        RString 行項目_記入日 = RString.EMPTY;
        RString 行項目_受領日 = RString.EMPTY;
        RString 行項目_意見書作成回数 = RString.EMPTY;
        RString 行項目_他科受信の有無 = RString.EMPTY;
        RString 行項目_記入のあった科 = RString.EMPTY;
        RString 行項目_発症年月日１和暦 = RString.EMPTY;
        RString 行項目_発症年月日１ = RString.EMPTY;
        RString 行項目_発症年月日２和暦 = RString.EMPTY;
        RString 行項目_発症年月日２ = RString.EMPTY;
        RString 行項目_発症年月日３和暦 = RString.EMPTY;
        RString 行項目_発症年月日３ = RString.EMPTY;
        RString 行項目_症状の安定性 = RString.EMPTY;
        RString 行項目_処置内容 = RString.EMPTY;
        RString 行項目_特別な対応 = RString.EMPTY;
        RString 行項目_カテーテル = RString.EMPTY;
        RString 行項目_障害高齢者の自立度 = RString.EMPTY;
        RString 行項目_認知症高齢者の自立度 = RString.EMPTY;
        RString 行項目_短期記憶 = RString.EMPTY;
        RString 行項目_認知能力 = RString.EMPTY;
        RString 行項目_伝達能力 = RString.EMPTY;
        RString 行項目_問題行動の有無 = RString.EMPTY;
        RString 行項目_問題行動 = RString.EMPTY;
        RString 行項目_精神神経症状 = RString.EMPTY;
        RString 行項目_専門科医受診 = RString.EMPTY;

        //ID702
        RString 行項目_利き腕 = RString.EMPTY;
        RString 行項目_過去6ヶ月間の体重の変化 = RString.EMPTY;
        RString 行項目_四肢欠損 = RString.EMPTY;
        RString 行項目_麻痺 = RString.EMPTY;
        RString 行項目_麻痺右上肢 = RString.EMPTY;
        RString 行項目_麻痺右上肢程度 = RString.EMPTY;
        RString 行項目_麻痺右下肢 = RString.EMPTY;
        RString 行項目_麻痺右下肢程度 = RString.EMPTY;
        RString 行項目_麻痺左上肢 = RString.EMPTY;
        RString 行項目_麻痺左上肢程度 = RString.EMPTY;
        RString 行項目_麻痺左下肢 = RString.EMPTY;
        RString 行項目_麻痺左下肢程度 = RString.EMPTY;
        RString 行項目_麻痺その他 = RString.EMPTY;
        RString 行項目_麻痺その他程度 = RString.EMPTY;
        RString 行項目_筋力低下 = RString.EMPTY;
        RString 行項目_筋力低下程度 = RString.EMPTY;
        RString 行項目_間接の拘縮 = RString.EMPTY;
        RString 行項目_間接の拘縮程度 = RString.EMPTY;
        RString 行項目_間接の痛み = RString.EMPTY;
        RString 行項目_間接の痛み程度 = RString.EMPTY;
        RString 行項目_失調不随意運動 = RString.EMPTY;
        RString 行項目_失調不随意上肢 = RString.EMPTY;
        RString 行項目_失調不随意下肢 = RString.EMPTY;
        RString 行項目_失調不随意体幹 = RString.EMPTY;
        RString 行項目_褥痩 = RString.EMPTY;
        RString 行項目_褥痩程度 = RString.EMPTY;
        RString 行項目_その他皮膚疾患 = RString.EMPTY;
        RString 行項目_その他皮膚疾患程度 = RString.EMPTY;
        RString 行項目_屋外歩行 = RString.EMPTY;
        RString 行項目_車いすの使用 = RString.EMPTY;
        RString 行項目_歩行補助具装具の使用 = RString.EMPTY;
        RString 行項目_食事行為 = RString.EMPTY;
        RString 行項目_現在の栄養状況 = RString.EMPTY;
        RString 行項目_現在または今後発生の可能性の高い状態 = RString.EMPTY;
        RString 行項目_予後の見通し = RString.EMPTY;
        RString 行項目_医学的管理の必要性チェック = RString.EMPTY;
        RString 行項目_医学的管理の必要性下線 = RString.EMPTY;
        RString 行項目_血圧 = RString.EMPTY;
        RString 行項目_移動 = RString.EMPTY;
        RString 行項目_摂食 = RString.EMPTY;
        RString 行項目_運動 = RString.EMPTY;
        RString 行項目_嚥下 = RString.EMPTY;
        RString 行項目_感染症 = RString.EMPTY;
        RString 行項目_主治医への結果連絡 = RString.EMPTY;

        //ID777
        RString 行項目_ID777_記入日 = RString.EMPTY;
        RString 行項目_ID777_受領日 = RString.EMPTY;
        RString 行項目_ID777_障害高齢者の自立度 = RString.EMPTY;
        RString 行項目_ID777_認知症高齢者の自立度 = RString.EMPTY;
        RString 行項目_ID777_短期記憶 = RString.EMPTY;
        RString 行項目_ID777_認知能力 = RString.EMPTY;
        RString 行項目_ID777_伝達能力 = RString.EMPTY;
        RString 行項目_ID777_食事行為 = RString.EMPTY;
        RString 行項目_ID777_主治医への結果連絡 = RString.EMPTY;

        List<RString> imageList = データ行_文字列.split(",");
        if (imageList != null) {
            行項目_意見書区分 = imageList.get(0);
            if (意見書_表.equals(行項目_意見書区分)) {
                行項目_保険者番号 = imageList.get(2);
                行項目_申請日 = imageList.get(3);
                行項目_被保険者番号 = imageList.get(4);
                行項目_同意の有無 = imageList.get(5);
                行項目_最終診察日 = imageList.get(6);
                行項目_記入日 = imageList.get(7);
                行項目_受領日 = imageList.get(8);
                行項目_意見書作成回数 = imageList.get(9);
                行項目_他科受信の有無 = imageList.get(10);
                行項目_記入のあった科 = imageList.get(11);
                行項目_発症年月日１和暦 = imageList.get(12);
                行項目_発症年月日１ = imageList.get(13);
                行項目_発症年月日２和暦 = imageList.get(14);
                行項目_発症年月日２ = imageList.get(15);
                行項目_発症年月日３和暦 = imageList.get(16);
                行項目_発症年月日３ = imageList.get(17);
                行項目_症状の安定性 = imageList.get(18);
                行項目_処置内容 = imageList.get(19);
                行項目_特別な対応 = imageList.get(20);
                行項目_カテーテル = imageList.get(21);
                行項目_障害高齢者の自立度 = imageList.get(22);
                行項目_認知症高齢者の自立度 = imageList.get(23);
                行項目_短期記憶 = imageList.get(24);
                行項目_認知能力 = imageList.get(25);
                行項目_伝達能力 = imageList.get(26);
                行項目_問題行動の有無 = imageList.get(27);
                行項目_問題行動 = imageList.get(28);
                行項目_精神神経症状 = imageList.get(29);
                行項目_専門科医受診 = imageList.get(30);

                OcrJohoOcrImageEntity データ行Entity = new OcrJohoOcrImageEntity();
                データ行Entity.set意見書区分(行項目_意見書区分);
                データ行Entity.set保険者番号(行項目_保険者番号);
                データ行Entity.set申請日(get西暦_年(行項目_申請日));
                データ行Entity.set被保険者番号(行項目_被保険者番号);
                データ行Entity.set行項目_6(行項目_同意の有無);
                データ行Entity.set行項目_7(get西暦_年(行項目_最終診察日));
                データ行Entity.set行項目_8(get西暦_年(行項目_記入日));
                データ行Entity.set行項目_9(get西暦_年(行項目_受領日));
                データ行Entity.set行項目_10(行項目_意見書作成回数);
                データ行Entity.set行項目_11(行項目_他科受信の有無);
                データ行Entity.set行項目_12(行項目_記入のあった科);
                データ行Entity.set行項目_13(行項目_発症年月日１和暦);
                データ行Entity.set行項目_14(get西暦_年(行項目_発症年月日１和暦, 行項目_発症年月日１));
                データ行Entity.set行項目_15(行項目_発症年月日２和暦);
                データ行Entity.set行項目_16(get西暦_年(行項目_発症年月日２和暦, 行項目_発症年月日２));
                データ行Entity.set行項目_17(行項目_発症年月日３和暦);
                データ行Entity.set行項目_18(get西暦_年(行項目_発症年月日３和暦, 行項目_発症年月日３));
                データ行Entity.set行項目_19(行項目_症状の安定性);
                データ行Entity.set行項目_20(行項目_処置内容);
                データ行Entity.set行項目_21(行項目_特別な対応);
                データ行Entity.set行項目_22(行項目_カテーテル);
                データ行Entity.set行項目_23(行項目_障害高齢者の自立度);
                データ行Entity.set行項目_24(行項目_認知症高齢者の自立度);
                データ行Entity.set行項目_25(行項目_短期記憶);
                データ行Entity.set行項目_26(行項目_認知能力);
                データ行Entity.set行項目_27(行項目_伝達能力);
                データ行Entity.set行項目_28(行項目_問題行動の有無);
                データ行Entity.set行項目_29(行項目_問題行動);
                データ行Entity.set行項目_30(行項目_精神神経症状);
                データ行Entity.set行項目_31(行項目_専門科医受診);

                ocrイメージ行Entity = データ行Entity;

            } else if (意見書_裏.equals(行項目_意見書区分)) {

                行項目_保険者番号 = imageList.get(2);
                行項目_申請日 = imageList.get(3);
                行項目_被保険者番号 = imageList.get(4);
                行項目_利き腕 = imageList.get(5);
                行項目_過去6ヶ月間の体重の変化 = imageList.get(6);
                行項目_四肢欠損 = imageList.get(7);
                行項目_麻痺 = imageList.get(8);
                行項目_麻痺右上肢 = imageList.get(9);
                行項目_麻痺右上肢程度 = imageList.get(10);
                行項目_麻痺右下肢 = imageList.get(11);
                行項目_麻痺右下肢程度 = imageList.get(12);
                行項目_麻痺左上肢 = imageList.get(13);
                行項目_麻痺左上肢程度 = imageList.get(14);
                行項目_麻痺左下肢 = imageList.get(15);
                行項目_麻痺左下肢程度 = imageList.get(16);
                行項目_麻痺その他 = imageList.get(17);
                行項目_麻痺その他程度 = imageList.get(18);
                行項目_筋力低下 = imageList.get(19);
                行項目_筋力低下程度 = imageList.get(20);
                行項目_間接の拘縮 = imageList.get(21);
                行項目_間接の拘縮程度 = imageList.get(22);
                行項目_間接の痛み = imageList.get(23);
                行項目_間接の痛み程度 = imageList.get(24);
                行項目_失調不随意運動 = imageList.get(25);
                行項目_失調不随意上肢 = imageList.get(26);
                行項目_失調不随意下肢 = imageList.get(27);
                行項目_失調不随意体幹 = imageList.get(28);
                行項目_褥痩 = imageList.get(29);
                行項目_褥痩程度 = imageList.get(30);
                行項目_その他皮膚疾患 = imageList.get(31);
                行項目_その他皮膚疾患程度 = imageList.get(32);
                行項目_屋外歩行 = imageList.get(33);
                行項目_車いすの使用 = imageList.get(34);
                行項目_歩行補助具装具の使用 = imageList.get(35);
                行項目_食事行為 = imageList.get(36);
                行項目_現在の栄養状況 = imageList.get(37);
                行項目_現在または今後発生の可能性の高い状態 = imageList.get(38);
                行項目_予後の見通し = imageList.get(39);
                行項目_医学的管理の必要性チェック = imageList.get(40);
                行項目_医学的管理の必要性下線 = imageList.get(41);
                行項目_血圧 = imageList.get(42);
                行項目_移動 = imageList.get(43);
                行項目_摂食 = imageList.get(44);
                行項目_運動 = imageList.get(45);
                行項目_嚥下 = imageList.get(46);
                行項目_感染症 = imageList.get(47);
                行項目_主治医への結果連絡 = imageList.get(48);

                OcrJohoOcrImageEntity データ行Entity = new OcrJohoOcrImageEntity();

                データ行Entity.set意見書区分(行項目_意見書区分);
                データ行Entity.set保険者番号(行項目_保険者番号);
                データ行Entity.set申請日(get西暦_年(行項目_申請日));
                データ行Entity.set被保険者番号(行項目_被保険者番号);
                データ行Entity.set行項目_6(行項目_利き腕);
                データ行Entity.set行項目_7(行項目_過去6ヶ月間の体重の変化);
                データ行Entity.set行項目_8(行項目_四肢欠損);
                データ行Entity.set行項目_9(行項目_麻痺);
                データ行Entity.set行項目_10(行項目_麻痺右上肢);
                データ行Entity.set行項目_11(行項目_麻痺右上肢程度);
                データ行Entity.set行項目_12(行項目_麻痺右下肢);
                データ行Entity.set行項目_13(行項目_麻痺右下肢程度);
                データ行Entity.set行項目_14(行項目_麻痺左上肢);
                データ行Entity.set行項目_15(行項目_麻痺左上肢程度);
                データ行Entity.set行項目_16(行項目_麻痺左下肢);
                データ行Entity.set行項目_17(行項目_麻痺左下肢程度);
                データ行Entity.set行項目_18(行項目_麻痺その他);
                データ行Entity.set行項目_19(行項目_麻痺その他程度);
                データ行Entity.set行項目_20(行項目_筋力低下);
                データ行Entity.set行項目_21(行項目_筋力低下程度);
                データ行Entity.set行項目_22(行項目_間接の拘縮);
                データ行Entity.set行項目_23(行項目_間接の拘縮程度);
                データ行Entity.set行項目_24(行項目_間接の痛み);
                データ行Entity.set行項目_25(行項目_間接の痛み程度);
                データ行Entity.set行項目_26(行項目_失調不随意運動);
                データ行Entity.set行項目_27(行項目_失調不随意上肢);
                データ行Entity.set行項目_28(行項目_失調不随意下肢);
                データ行Entity.set行項目_29(行項目_失調不随意体幹);
                データ行Entity.set行項目_30(行項目_褥痩);
                データ行Entity.set行項目_31(行項目_褥痩程度);
                データ行Entity.set行項目_32(行項目_その他皮膚疾患);
                データ行Entity.set行項目_33(行項目_その他皮膚疾患程度);
                データ行Entity.set行項目_34(行項目_屋外歩行);
                データ行Entity.set行項目_35(行項目_車いすの使用);
                データ行Entity.set行項目_36(行項目_歩行補助具装具の使用);
                データ行Entity.set行項目_37(行項目_食事行為);
                データ行Entity.set行項目_38(行項目_現在の栄養状況);
                データ行Entity.set行項目_39(行項目_現在または今後発生の可能性の高い状態);
                データ行Entity.set行項目_40(行項目_予後の見通し);
                データ行Entity.set行項目_41(行項目_医学的管理の必要性チェック);
                データ行Entity.set行項目_42(行項目_医学的管理の必要性下線);
                データ行Entity.set行項目_43(行項目_血圧);
                データ行Entity.set行項目_44(行項目_移動);
                データ行Entity.set行項目_45(行項目_摂食);
                データ行Entity.set行項目_46(行項目_運動);
                データ行Entity.set行項目_47(行項目_嚥下);
                データ行Entity.set行項目_48(行項目_感染症);
                データ行Entity.set行項目_49(行項目_主治医への結果連絡);

                ocrイメージ行Entity = データ行Entity;
            } else if (意見書_ID777.equals(行項目_意見書区分)) {

                行項目_保険者番号 = imageList.get(2);
                行項目_申請日 = imageList.get(3);
                行項目_被保険者番号 = imageList.get(4);
                行項目_ID777_記入日 = imageList.get(5);
                行項目_ID777_受領日 = imageList.get(6);
                行項目_ID777_障害高齢者の自立度 = imageList.get(7);
                行項目_ID777_認知症高齢者の自立度 = imageList.get(8);
                行項目_ID777_短期記憶 = imageList.get(9);
                行項目_ID777_認知能力 = imageList.get(10);
                行項目_ID777_伝達能力 = imageList.get(11);
                行項目_ID777_食事行為 = imageList.get(12);
                行項目_ID777_主治医への結果連絡 = imageList.get(13);

                OcrJohoOcrImageEntity データ行Entity = new OcrJohoOcrImageEntity();

                データ行Entity.set意見書区分(行項目_意見書区分);
                データ行Entity.set保険者番号(行項目_保険者番号);
                データ行Entity.set申請日(get西暦_年(行項目_申請日));
                データ行Entity.set被保険者番号(行項目_被保険者番号);
                データ行Entity.set行項目_6(get西暦_年(行項目_ID777_記入日));
                データ行Entity.set行項目_7(get西暦_年(行項目_ID777_受領日));
                データ行Entity.set行項目_8(行項目_ID777_障害高齢者の自立度);
                データ行Entity.set行項目_9(行項目_ID777_認知症高齢者の自立度);
                データ行Entity.set行項目_10(行項目_ID777_短期記憶);
                データ行Entity.set行項目_11(行項目_ID777_認知能力);
                データ行Entity.set行項目_12(行項目_ID777_伝達能力);
                データ行Entity.set行項目_13(行項目_ID777_食事行為);
                データ行Entity.set行項目_14(行項目_ID777_主治医への結果連絡);

                ocrイメージ行Entity = データ行Entity;

            } else if (意見書_ID778.equals(行項目_意見書区分)) {

                行項目_保険者番号 = imageList.get(2);
                行項目_申請日 = imageList.get(3);
                行項目_被保険者番号 = imageList.get(4);

                OcrJohoOcrImageEntity データ行Entity = new OcrJohoOcrImageEntity();

                データ行Entity.set意見書区分(行項目_意見書区分);
                データ行Entity.set保険者番号(行項目_保険者番号);
                データ行Entity.set申請日(get西暦_年(行項目_申請日));
                データ行Entity.set被保険者番号(行項目_被保険者番号);

                ocrイメージ行Entity = データ行Entity;

            } else {
                int size = imageList.size();
                if (imageList.get(0).equals("ID777")) {
                    for (int i = 0; i < size; i++) {
                        if (imageList.get(i).contains("\\")) {
                            RString fileTest = imageList.get(i).substring(imageList.get(i).lastIndexOf("\\") + 1);
//                            RString fileName = new RString("I10001.png");
                            イメージファイル.add(fileTest);
                        }
                    }

                } else if (imageList.get(0).equals("ID778")) {
                    for (int i = 0; i < size; i++) {
                        if (imageList.get(i).contains("\\")) {
                            RString fileTest = imageList.get(i).substring(imageList.get(i).lastIndexOf("\\") + 1);
//                            RString fileName = new RString("I10001.png");
                            イメージファイル.add(fileTest);
                        }
                    }
                }

            }
        }
    }

    private RString get西暦_年(RString 和暦_日付) {
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

    private RString get西暦_年(RString 年号, RString 和暦_日付) {
        if (年号 != null && 和暦_日付 != null) {
            和暦_日付 = 和暦_日付.trim();
            RString 和暦 = 年号.concat(和暦_日付);
            RDate result = null;
            result = new RDate(和暦.toString());
            return result.toDateString();
        }
        return RString.EMPTY;
    }
}
