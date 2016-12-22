/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n2818
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageInputReadResult {

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
    }
}
