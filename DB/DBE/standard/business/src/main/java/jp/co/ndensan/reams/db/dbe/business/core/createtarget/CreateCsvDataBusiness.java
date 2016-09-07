/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.createtarget;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.createtarget.CreateTargetCsvRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信Csvデータ出力情報ビジネスクラスです。
 *
 * @reamsid_L DBE-1680-010 zhangzhiming
 */
public class CreateCsvDataBusiness {

    private final CreateTargetCsvRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity Csvデータ出力情報
     */
    public CreateCsvDataBusiness(CreateTargetCsvRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 前回結果_上衣の着脱を取得します。
     *
     * @return 前回結果_上衣の着脱
     */
    public RString get前回結果_上衣の着脱() {
        return entity.get前回結果_上衣の着脱();
    }

    /**
     * 前回結果_ズボン等の着脱を取得します。
     *
     * @return 前回結果_ズボン等の着脱
     */
    public RString get前回結果_ズボン等の着脱() {
        return entity.get前回結果_ズボン等の着脱();
    }

    /**
     * 前回結果_外出頻度を取得します。
     *
     * @return 前回結果_外出頻度
     */
    public RString get前回結果_外出頻度() {
        return entity.get前回結果_外出頻度();
    }

    /**
     * 前回結果_意思の伝達を取得します。
     *
     * @return 前回結果_意思の伝達
     */
    public RString get前回結果_意思の伝達() {
        return entity.get前回結果_意思の伝達();
    }

    /**
     * 前回結果_毎日の日課を理解を取得します。
     *
     * @return 前回結果_毎日の日課を理解
     */
    public RString get前回結果_毎日の日課を理解() {
        return entity.get前回結果_毎日の日課を理解();
    }

    /**
     * 前回結果_生年月日をいうを取得します。
     *
     * @return 前回結果_生年月日をいう
     */
    public RString get前回結果_生年月日をいう() {
        return entity.get前回結果_生年月日をいう();
    }

    /**
     * 前回結果_短期記憶を取得します。
     *
     * @return 前回結果_短期記憶
     */
    public RString get前回結果_短期記憶() {
        return entity.get前回結果_短期記憶();
    }

    /**
     * 前回結果_自分の名前をいうを取得します。
     *
     * @return 前回結果_自分の名前をいう
     */
    public RString get前回結果_自分の名前をいう() {
        return entity.get前回結果_自分の名前をいう();
    }

    /**
     * 前回結果_今の季節を理解を取得します。
     *
     * @return 前回結果_今の季節を理解
     */
    public RString get前回結果_今の季節を理解() {
        return entity.get前回結果_今の季節を理解();
    }

    /**
     * 前回結果_場所の理解を取得します。
     *
     * @return 前回結果_場所の理解
     */
    public RString get前回結果_場所の理解() {
        return entity.get前回結果_場所の理解();
    }

    /**
     * 前回結果_徘徊を取得します。
     *
     * @return 前回結果_徘徊
     */
    public RString get前回結果_徘徊() {
        return entity.get前回結果_徘徊();
    }

    /**
     * 前回結果_外出して戻れないを取得します。
     *
     * @return 前回結果_外出して戻れない
     */
    public RString get前回結果_外出して戻れない() {
        return entity.get前回結果_外出して戻れない();
    }

    /**
     * 前回結果_被害的を取得します。
     *
     * @return 前回結果_被害的
     */
    public RString get前回結果_被害的() {
        return entity.get前回結果_被害的();
    }

    /**
     * 前回結果_作話を取得します。
     *
     * @return 前回結果_作話
     */
    public RString get前回結果_作話() {
        return entity.get前回結果_作話();
    }

    /**
     * 前回結果_感情が不安定を取得します。
     *
     * @return 前回結果_感情が不安定
     */
    public RString get前回結果_感情が不安定() {
        return entity.get前回結果_感情が不安定();
    }

    /**
     * 前回結果_昼夜逆転を取得します。
     *
     * @return 前回結果_昼夜逆転
     */
    public RString get前回結果_昼夜逆転() {
        return entity.get前回結果_昼夜逆転();
    }

    /**
     * 前回結果_同じ話をするを取得します。
     *
     * @return 前回結果_同じ話をする
     */
    public RString get前回結果_同じ話をする() {
        return entity.get前回結果_同じ話をする();
    }

    /**
     * 前回結果_大声を出すを取得します。
     *
     * @return 前回結果_大声を出す
     */
    public RString get前回結果_大声を出す() {
        return entity.get前回結果_大声を出す();
    }

    /**
     * 前回結果_介護に抵抗を取得します。
     *
     * @return 前回結果_介護に抵抗
     */
    public RString get前回結果_介護に抵抗() {
        return entity.get前回結果_介護に抵抗();
    }

    /**
     * 前回結果_落ち着きなしを取得します。
     *
     * @return 前回結果_落ち着きなし
     */
    public RString get前回結果_落ち着きなし() {
        return entity.get前回結果_落ち着きなし();
    }

    /**
     * 前回結果_一人で出たがるを取得します。
     *
     * @return 前回結果_一人で出たがる
     */
    public RString get前回結果_一人で出たがる() {
        return entity.get前回結果_一人で出たがる();
    }

    /**
     * 前回結果_収集癖を取得します。
     *
     * @return 前回結果_収集癖
     */
    public RString get前回結果_収集癖() {
        return entity.get前回結果_収集癖();
    }

    /**
     * 前回結果_物や衣類を壊すを取得します。
     *
     * @return 前回結果_物や衣類を壊す
     */
    public RString get前回結果_物や衣類を壊す() {
        return entity.get前回結果_物や衣類を壊す();
    }

    /**
     * 前回結果_ひどい物忘れを取得します。
     *
     * @return 前回結果_ひどい物忘れ
     */
    public RString get前回結果_ひどい物忘れ() {
        return entity.get前回結果_ひどい物忘れ();
    }

    /**
     * 前回結果_独り言独り笑いを取得します。
     *
     * @return 前回結果_独り言独り笑い
     */
    public RString get前回結果_独り言独り笑い() {
        return entity.get前回結果_独り言独り笑い();
    }

    /**
     * 前回結果_自分勝手に行動するを取得します。
     *
     * @return 前回結果_自分勝手に行動する
     */
    public RString get前回結果_自分勝手に行動する() {
        return entity.get前回結果_自分勝手に行動する();
    }

    /**
     * 前回結果_話がまとまらないを取得します。
     *
     * @return 前回結果_話がまとまらない
     */
    public RString get前回結果_話がまとまらない() {
        return entity.get前回結果_話がまとまらない();
    }

    /**
     * 前回結果_薬の内服を取得します。
     *
     * @return 前回結果_薬の内服
     */
    public RString get前回結果_薬の内服() {
        return entity.get前回結果_薬の内服();
    }

    /**
     * 前回結果_金銭の管理を取得します。
     *
     * @return 前回結果_金銭の管理
     */
    public RString get前回結果_金銭の管理() {
        return entity.get前回結果_金銭の管理();
    }

    /**
     * 前回結果_日常の意思決定を取得します。
     *
     * @return 前回結果_日常の意思決定
     */
    public RString get前回結果_日常の意思決定() {
        return entity.get前回結果_日常の意思決定();
    }

    /**
     * 前回結果_集団への不適応を取得します。
     *
     * @return 前回結果_集団への不適応
     */
    public RString get前回結果_集団への不適応() {
        return entity.get前回結果_集団への不適応();
    }

    /**
     * 前回結果_買い物を取得します。
     *
     * @return 前回結果_買い物
     */
    public RString get前回結果_買い物() {
        return entity.get前回結果_買い物();
    }

    /**
     * 前回結果_簡単な調理を取得します。
     *
     * @return 前回結果_簡単な調理
     */
    public RString get前回結果_簡単な調理() {
        return entity.get前回結果_簡単な調理();
    }

    /**
     * 前回結果_点滴の管理を取得します。
     *
     * @return 前回結果_点滴の管理
     */
    public RString get前回結果_点滴の管理() {
        return entity.get前回結果_点滴の管理();
    }

    /**
     * 前回結果_中心静脈栄養を取得します。
     *
     * @return 前回結果_中心静脈栄養
     */
    public RString get前回結果_中心静脈栄養() {
        return entity.get前回結果_中心静脈栄養();
    }

    /**
     * 前回結果_透析を取得します。
     *
     * @return 前回結果_透析
     */
    public RString get前回結果_透析() {
        return entity.get前回結果_透析();
    }

    /**
     * 前回結果_ストーマの処置を取得します。
     *
     * @return 前回結果_ストーマの処置
     */
    public RString get前回結果_ストーマの処置() {
        return entity.get前回結果_ストーマの処置();
    }

    /**
     * 前回結果_酸素療法を取得します。
     *
     * @return 前回結果_酸素療法
     */
    public RString get前回結果_酸素療法() {
        return entity.get前回結果_酸素療法();
    }

    /**
     * 前回結果_レスピレーターを取得します。
     *
     * @return 前回結果_レスピレーター
     */
    public RString get前回結果_レスピレーター() {
        return entity.get前回結果_レスピレーター();
    }

    /**
     * 前回結果_気管切開の処置を取得します。
     *
     * @return 前回結果_気管切開の処置
     */
    public RString get前回結果_気管切開の処置() {
        return entity.get前回結果_気管切開の処置();
    }

    /**
     * 前回結果_疼痛の看護を取得します。
     *
     * @return 前回結果_疼痛の看護
     */
    public RString get前回結果_疼痛の看護() {
        return entity.get前回結果_疼痛の看護();
    }

    /**
     * 前回結果_経管栄養を取得します。
     *
     * @return 前回結果_経管栄養
     */
    public RString get前回結果_経管栄養() {
        return entity.get前回結果_経管栄養();
    }

    /**
     * 前回結果_モニター測定を取得します。
     *
     * @return 前回結果_モニター測定
     */
    public RString get前回結果_モニター測定() {
        return entity.get前回結果_モニター測定();
    }

    /**
     * 前回結果_じょくそうの処置を取得します。
     *
     * @return 前回結果_じょくそうの処置
     */
    public RString get前回結果_じょくそうの処置() {
        return entity.get前回結果_じょくそうの処置();
    }

    /**
     * 前回結果_カテーテルを取得します。
     *
     * @return 前回結果_カテーテル
     */
    public RString get前回結果_カテーテル() {
        return entity.get前回結果_カテーテル();
    }

    /**
     * 前回結果_障害高齢者自立度を取得します。
     *
     * @return 前回結果_障害高齢者自立度
     */
    public RString get前回結果_障害高齢者自立度() {
        return entity.get前回結果_障害高齢者自立度();
    }

    /**
     * 前回結果_認知症高齢者自立度を取得します。
     *
     * @return 前回結果_認知症高齢者自立度
     */
    public RString get前回結果_認知症高齢者自立度() {
        return entity.get前回結果_認知症高齢者自立度();
    }

    /**
     * 前回結果_一次判定結果を取得します。
     *
     * @return 前回結果_一次判定結果
     */
    public RString get前回結果_一次判定結果() {
        return entity.get前回結果_一次判定結果();
    }

    /**
     * 前回結果_一次判定結果認知症加算を取得します。
     *
     * @return 前回結果_一次判定結果認知症加算
     */
    public RString get前回結果_一次判定結果認知症加算() {
        return entity.get前回結果_一次判定結果認知症加算();
    }

    /**
     * 前回結果_要介護認定等基準時間を取得します。
     *
     * @return 前回結果_要介護認定等基準時間
     */
    public RString get前回結果_要介護認定等基準時間() {
        return entity.get前回結果_要介護認定等基準時間();
    }

    /**
     * 前回結果_要介護認定等基準時間食事を取得します。
     *
     * @return 前回結果_要介護認定等基準時間食事
     */
    public RString get前回結果_要介護認定等基準時間食事() {
        return entity.get前回結果_要介護認定等基準時間食事();
    }

    /**
     * 前回結果_要介護認定等基準時間排泄を取得します。
     *
     * @return 前回結果_要介護認定等基準時間排泄
     */
    public RString get前回結果_要介護認定等基準時間排泄() {
        return entity.get前回結果_要介護認定等基準時間排泄();
    }

    /**
     * 前回結果_要介護認定等基準時間移動を取得します。
     *
     * @return 前回結果_要介護認定等基準時間移動
     */
    public RString get前回結果_要介護認定等基準時間移動() {
        return entity.get前回結果_要介護認定等基準時間移動();
    }

    /**
     * 前回結果_要介護認定等基準時間清潔保持を取得します。
     *
     * @return 前回結果_要介護認定等基準時間清潔保持
     */
    public RString get前回結果_要介護認定等基準時間清潔保持() {
        return entity.get前回結果_要介護認定等基準時間清潔保持();
    }

    /**
     * 前回結果_要介護認定等基準時間間接ケアを取得します。
     *
     * @return 前回結果_要介護認定等基準時間間接ケア
     */
    public RString get前回結果_要介護認定等基準時間間接ケア() {
        return entity.get前回結果_要介護認定等基準時間間接ケア();
    }

    /**
     * 前回結果_要介護認定等基準時間BPSD_関連を取得します。
     *
     * @return 前回結果_要介護認定等基準時間BPSD_関連
     */
    public RString get前回結果_要介護認定等基準時間BPSD_関連() {
        return entity.get前回結果_要介護認定等基準時間BPSD_関連();
    }

    /**
     * 前回結果_要介護認定等基準時間機能訓練を取得します。
     *
     * @return 前回結果_要介護認定等基準時間機能訓練
     */
    public RString get前回結果_要介護認定等基準時間機能訓練() {
        return entity.get前回結果_要介護認定等基準時間機能訓練();
    }

    /**
     * 前回結果_要介護認定等基準時間医療関連を取得します。
     *
     * @return 前回結果_要介護認定等基準時間医療関連
     */
    public RString get前回結果_要介護認定等基準時間医療関連() {
        return entity.get前回結果_要介護認定等基準時間医療関連();
    }

    /**
     * 前回結果_要介護認定等基準時間認知症加算を取得します。
     *
     * @return 前回結果_要介護認定等基準時間認知症加算
     */
    public RString get前回結果_要介護認定等基準時間認知症加算() {
        return entity.get前回結果_要介護認定等基準時間認知症加算();
    }

    /**
     * 前回結果_中間評価項目得点_第１群を取得します。
     *
     * @return 前回結果_中間評価項目得点_第１群
     */
    public RString get前回結果_中間評価項目得点_第１群() {
        return entity.get前回結果_中間評価項目得点_第１群();
    }

    /**
     * 前回結果_中間評価項目得点_第２群を取得します。
     *
     * @return 前回結果_中間評価項目得点_第２群
     */
    public RString get前回結果_中間評価項目得点_第２群() {
        return entity.get前回結果_中間評価項目得点_第２群();
    }

    /**
     * 前回結果_中間評価項目得点_第３群を取得します。
     *
     * @return 前回結果_中間評価項目得点_第３群
     */
    public RString get前回結果_中間評価項目得点_第３群() {
        return entity.get前回結果_中間評価項目得点_第３群();
    }

    /**
     * 前回結果_中間評価項目得点_第４群を取得します。
     *
     * @return 前回結果_中間評価項目得点_第４群
     */
    public RString get前回結果_中間評価項目得点_第４群() {
        return entity.get前回結果_中間評価項目得点_第４群();
    }

    /**
     * 前回結果_中間評価項目得点_第５群を取得します。
     *
     * @return 前回結果_中間評価項目得点_第５群
     */
    public RString get前回結果_中間評価項目得点_第５群() {
        return entity.get前回結果_中間評価項目得点_第５群();
    }

    /**
     * 前回結果_一次判定警告コードを取得します。
     *
     * @return 前回結果_一次判定警告コード
     */
    public RString get前回結果_一次判定警告コード() {
        return entity.get前回結果_一次判定警告コード();
    }

    /**
     * 前回結果_状態の安定性を取得します。
     *
     * @return 前回結果_状態の安定性
     */
    public RString get前回結果_状態の安定性() {
        return entity.get前回結果_状態の安定性();
    }

    /**
     * 前回結果_認知症自立度Ⅱ以上の蓋然性を取得します。
     *
     * @return 前回結果_認知症自立度Ⅱ以上の蓋然性
     */
    public RString get前回結果_認知症自立度Ⅱ以上の蓋然性() {
        return entity.get前回結果_認知症自立度Ⅱ以上の蓋然性();
    }

    /**
     * 前回結果_認知機能及び状態安定性から推定される給付区分を取得します。
     *
     * @return 前回結果_認知機能及び状態安定性から推定される給付区分
     */
    public RString get前回結果_認知機能及び状態安定性から推定される給付区分() {
        return entity.get前回結果_認知機能及び状態安定性から推定される給付区分();
    }

    /**
     * 前回結果_申請日を取得します。
     *
     * @return 前回結果_申請日
     */
    public RString get前回結果_申請日() {
        return entity.get前回結果_申請日();
    }

    /**
     * 前回結果_二次判定日を取得します。
     *
     * @return 前回結果_二次判定日
     */
    public RString get前回結果_二次判定日() {
        return entity.get前回結果_二次判定日();
    }

    /**
     * 前回結果_現在のサービス区分コードを取得します。
     *
     * @return 前回結果_現在のサービス区分コード
     */
    public RString get前回結果_現在のサービス区分コード() {
        return entity.get前回結果_現在のサービス区分コード();
    }

    /**
     * 前回結果_現在の状況を取得します。
     *
     * @return 前回結果_現在の状況
     */
    public RString get前回結果_現在の状況() {
        return entity.get前回結果_現在の状況();
    }

    /**
     * 前回結果_訪問介護ホームヘルプサービスを取得します。
     *
     * @return 前回結果_訪問介護ホームヘルプサービス
     */
    public RString get前回結果_訪問介護ホームヘルプサービス() {
        return entity.get前回結果_訪問介護ホームヘルプサービス();
    }

    /**
     * 前回結果_訪問入浴介護を取得します。
     *
     * @return 前回結果_訪問入浴介護
     */
    public RString get前回結果_訪問入浴介護() {
        return entity.get前回結果_訪問入浴介護();
    }

    /**
     * 前回結果_訪問看護を取得します。
     *
     * @return 前回結果_訪問看護
     */
    public RString get前回結果_訪問看護() {
        return entity.get前回結果_訪問看護();
    }

    /**
     * 前回結果_訪問リハビリテーションを取得します。
     *
     * @return 前回結果_訪問リハビリテーション
     */
    public RString get前回結果_訪問リハビリテーション() {
        return entity.get前回結果_訪問リハビリテーション();
    }

    /**
     * 前回結果_居宅療養管理指導を取得します。
     *
     * @return 前回結果_居宅療養管理指導
     */
    public RString get前回結果_居宅療養管理指導() {
        return entity.get前回結果_居宅療養管理指導();
    }

    /**
     * 前回結果_通所介護デイサービスを取得します。
     *
     * @return 前回結果_通所介護デイサービス
     */
    public RString get前回結果_通所介護デイサービス() {
        return entity.get前回結果_通所介護デイサービス();
    }

    /**
     * 前回結果_通所リハビリテーションを取得します。
     *
     * @return 前回結果_通所リハビリテーション
     */
    public RString get前回結果_通所リハビリテーション() {
        return entity.get前回結果_通所リハビリテーション();
    }

    /**
     * 前回結果_短期入所生活介護ショートステイを取得します。
     *
     * @return 前回結果_短期入所生活介護ショートステイ
     */
    public RString get前回結果_短期入所生活介護ショートステイ() {
        return entity.get前回結果_短期入所生活介護ショートステイ();
    }

    /**
     * 前回結果_短期入所療養介護を取得します。
     *
     * @return 前回結果_短期入所療養介護
     */
    public RString get前回結果_短期入所療養介護() {
        return entity.get前回結果_短期入所療養介護();
    }

    /**
     * 前回結果_特定施設入居者生活介護を取得します。
     *
     * @return 前回結果_特定施設入居者生活介護
     */
    public RString get前回結果_特定施設入居者生活介護() {
        return entity.get前回結果_特定施設入居者生活介護();
    }

    /**
     * 前回結果_福祉用具貸与を取得します。
     *
     * @return 前回結果_福祉用具貸与
     */
    public RString get前回結果_福祉用具貸与() {
        return entity.get前回結果_福祉用具貸与();
    }

    /**
     * 前回結果_特定福祉用具販売を取得します。
     *
     * @return 前回結果_特定福祉用具販売
     */
    public RString get前回結果_特定福祉用具販売() {
        return entity.get前回結果_特定福祉用具販売();
    }

    /**
     * 前回結果_住宅改修介護給付を取得します。
     *
     * @return 前回結果_住宅改修介護給付
     */
    public RString get前回結果_住宅改修介護給付() {
        return entity.get前回結果_住宅改修介護給付();
    }

    /**
     * 前回結果_夜間対応型訪問介護を取得します。
     *
     * @return 前回結果_夜間対応型訪問介護
     */
    public RString get前回結果_夜間対応型訪問介護() {
        return entity.get前回結果_夜間対応型訪問介護();
    }

    /**
     * 前回結果_認知症対応型通所介護を取得します。
     *
     * @return 前回結果_認知症対応型通所介護
     */
    public RString get前回結果_認知症対応型通所介護() {
        return entity.get前回結果_認知症対応型通所介護();
    }

    /**
     * 前回結果_小規模多機能型居宅介護を取得します。
     *
     * @return 前回結果_小規模多機能型居宅介護
     */
    public RString get前回結果_小規模多機能型居宅介護() {
        return entity.get前回結果_小規模多機能型居宅介護();
    }

    /**
     * 前回結果_認知症対応型共同生活介護グループホームを取得します。
     *
     * @return 前回結果_認知症対応型共同生活介護グループホーム
     */
    public RString get前回結果_認知症対応型共同生活介護グループホーム() {
        return entity.get前回結果_認知症対応型共同生活介護グループホーム();
    }

    /**
     * 前回結果_地域密着型特定施設入居者生活介護を取得します。
     *
     * @return 前回結果_地域密着型特定施設入居者生活介護
     */
    public RString get前回結果_地域密着型特定施設入居者生活介護() {
        return entity.get前回結果_地域密着型特定施設入居者生活介護();
    }

    /**
     * 前回結果_地域密着型介護老人福祉施設入所者生活介護を取得します。
     *
     * @return 前回結果_地域密着型介護老人福祉施設入所者生活介護
     */
    public RString get前回結果_地域密着型介護老人福祉施設入所者生活介護() {
        return entity.get前回結果_地域密着型介護老人福祉施設入所者生活介護();
    }

    /**
     * 前回結果_定期巡回随時対応型訪問介護看護を取得します。
     *
     * @return 前回結果_定期巡回随時対応型訪問介護看護
     */
    public RString get前回結果_定期巡回随時対応型訪問介護看護() {
        return entity.get前回結果_定期巡回随時対応型訪問介護看護();
    }

    /**
     * 前回結果_複合型サービスを取得します。
     *
     * @return 前回結果_複合型サービス
     */
    public RString get前回結果_複合型サービス() {
        return entity.get前回結果_複合型サービス();
    }

    /**
     * 前回結果_介護予防訪問介護ホームヘルプサービスを取得します。
     *
     * @return 前回結果_介護予防訪問介護ホームヘルプサービス
     */
    public RString get前回結果_介護予防訪問介護ホームヘルプサービス() {
        return entity.get前回結果_介護予防訪問介護ホームヘルプサービス();
    }

    /**
     * 前回結果_介護予防訪問入浴介護を取得します。
     *
     * @return 前回結果_介護予防訪問入浴介護
     */
    public RString get前回結果_介護予防訪問入浴介護() {
        return entity.get前回結果_介護予防訪問入浴介護();
    }

    /**
     * 前回結果_介護予防訪問看護を取得します。
     *
     * @return 前回結果_介護予防訪問看護
     */
    public RString get前回結果_介護予防訪問看護() {
        return entity.get前回結果_介護予防訪問看護();
    }

    /**
     * 前回結果_介護予防訪問リハビリテーションを取得します。
     *
     * @return 前回結果_介護予防訪問リハビリテーション
     */
    public RString get前回結果_介護予防訪問リハビリテーション() {
        return entity.get前回結果_介護予防訪問リハビリテーション();
    }

    /**
     * 前回結果_介護予防居宅療養管理指導を取得します。
     *
     * @return 前回結果_介護予防居宅療養管理指導
     */
    public RString get前回結果_介護予防居宅療養管理指導() {
        return entity.get前回結果_介護予防居宅療養管理指導();
    }

    /**
     * 前回結果_介護予防通所介護デイサービスを取得します。
     *
     * @return 前回結果_介護予防通所介護デイサービス
     */
    public RString get前回結果_介護予防通所介護デイサービス() {
        return entity.get前回結果_介護予防通所介護デイサービス();
    }

    /**
     * 前回結果_介護予防通所リハビリテーションを取得します。
     *
     * @return 前回結果_介護予防通所リハビリテーション
     */
    public RString get前回結果_介護予防通所リハビリテーション() {
        return entity.get前回結果_介護予防通所リハビリテーション();
    }

    /**
     * 前回結果_介護予防短期入所生活介護ショートステイを取得します。
     *
     * @return 前回結果_介護予防短期入所生活介護ショートステイ
     */
    public RString get前回結果_介護予防短期入所生活介護ショートステイ() {
        return entity.get前回結果_介護予防短期入所生活介護ショートステイ();
    }

    /**
     * 前回結果_介護予防短期入所療養介護を取得します。
     *
     * @return 前回結果_介護予防短期入所療養介護
     */
    public RString get前回結果_介護予防短期入所療養介護() {
        return entity.get前回結果_介護予防短期入所療養介護();
    }

    /**
     * 前回結果_介護予防特定施設入居者生活介護を取得します。
     *
     * @return 前回結果_介護予防特定施設入居者生活介護
     */
    public RString get前回結果_介護予防特定施設入居者生活介護() {
        return entity.get前回結果_介護予防特定施設入居者生活介護();
    }

    /**
     * 前回結果_介護予防福祉用具貸与を取得します。
     *
     * @return 前回結果_介護予防福祉用具貸与
     */
    public RString get前回結果_介護予防福祉用具貸与() {
        return entity.get前回結果_介護予防福祉用具貸与();
    }

    /**
     * 前回結果_特定介護予防福祉用具販売を取得します。
     *
     * @return 前回結果_特定介護予防福祉用具販売
     */
    public RString get前回結果_特定介護予防福祉用具販売() {
        return entity.get前回結果_特定介護予防福祉用具販売();
    }

    /**
     * 前回結果_住宅改修予防給付を取得します。
     *
     * @return 前回結果_住宅改修予防給付
     */
    public RString get前回結果_住宅改修予防給付() {
        return entity.get前回結果_住宅改修予防給付();
    }

    /**
     * 前回結果_介護予防認知症対応型通所介護を取得します。
     *
     * @return 前回結果_介護予防認知症対応型通所介護
     */
    public RString get前回結果_介護予防認知症対応型通所介護() {
        return entity.get前回結果_介護予防認知症対応型通所介護();
    }

    /**
     * 前回結果_介護予防小規模多機能型居宅介護を取得します。
     *
     * @return 前回結果_介護予防小規模多機能型居宅介護
     */
    public RString get前回結果_介護予防小規模多機能型居宅介護() {
        return entity.get前回結果_介護予防小規模多機能型居宅介護();
    }

    /**
     * 前回結果_介護予防認知症対応型共同生活介護グループホームを取得します。
     *
     * @return 前回結果_介護予防認知症対応型共同生活介護グループホーム
     */
    public RString get前回結果_介護予防認知症対応型共同生活介護グループホーム() {
        return entity.get前回結果_介護予防認知症対応型共同生活介護グループホーム();
    }

    /**
     * 前回識別コードを取得します。
     *
     * @return 前回識別コード
     */
    public RString get前回識別コード() {
        return entity.get前回識別コード();
    }

    /**
     * 認定審査会意見等を取得します。
     *
     * @return 認定審査会意見等
     */
    public RString get認定審査会意見等() {
        return entity.get認定審査会意見等();
    }

    /**
     * 前回結果_整髪を取得します。
     *
     * @return 前回結果_整髪
     */
    public RString get前回結果_整髪() {
        return entity.get前回結果_整髪();
    }
}
