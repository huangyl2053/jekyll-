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
public class CreateTargetCsvBusiness {

    private final CreateTargetCsvRelateEntity entity;
    private final CreateCsvDataBusiness createBusiness;

    /**
     * コンストラクタです。
     *
     * @param entity Csvデータ出力情報
     * @param createBusiness Csvデータ出力情報
     */
    public CreateTargetCsvBusiness(CreateTargetCsvRelateEntity entity, CreateCsvDataBusiness createBusiness) {
        this.entity = entity;
        this.createBusiness = createBusiness;
    }

    /**
     * コンストラクタです。
     *
     * @param entity Csvデータ出力情報
     * @return Csvデータ出力情報
     */
    public static CreateTargetCsvBusiness creatCreateTargetCsvBusiness(CreateTargetCsvRelateEntity entity) {
        return new CreateTargetCsvBusiness(entity, new CreateCsvDataBusiness(entity));
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public CreateCsvDataBusiness getCreateCsvDataBusiness() {
        return createBusiness;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * シーケンシャル番号を取得します。
     *
     * @return シーケンシャル番号
     */
    public RString getシーケンシャル番号() {
        return entity.getシーケンシャル番号();
    }

    /**
     * 機能コードを取得します。
     *
     * @return 機能コード
     */
    public RString get機能コード() {
        return entity.get機能コード();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.get識別コード();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.get保険者番号();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 認定申請日を取得します。
     *
     * @return 認定申請日
     */
    public RString get認定申請日() {
        return entity.get認定申請日();
    }

    /**
     * 枝番を取得します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.get枝番();
    }

    /**
     * 申請区分法令コードを取得します。
     *
     * @return 申請区分法令コード
     */
    public RString get申請区分法令コード() {
        return entity.get申請区分法令コード();
    }

    /**
     * 申請区分申請時コードを取得します。
     *
     * @return 申請区分申請時コード
     */
    public RString get申請区分申請時コード() {
        return entity.get申請区分申請時コード();
    }

    /**
     * 取下区分コードを取得します。
     *
     * @return 取下区分コード
     */
    public RString get取下区分コード() {
        return entity.get取下区分コード();
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.get被保険者区分コード();
    }

    /**
     * 申請代行区分コードを取得します。
     *
     * @return 申請代行区分コード
     */
    public RString get申請代行区分コード() {
        return entity.get申請代行区分コード();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.get生年月日();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return entity.get年齢();
    }

    /**
     * 性別コードを取得します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return entity.get性別コード();
    }

    /**
     * 被保険者ｶﾅ氏名を取得します。
     *
     * @return 被保険者ｶﾅ氏名
     */
    public RString get被保険者ｶﾅ氏名() {
        return entity.get被保険者ｶﾅ氏名();
    }

    /**
     * 被保険者漢字氏名を取得します。
     *
     * @return 被保険者漢字氏名
     */
    public RString get被保険者漢字氏名() {
        return entity.get被保険者漢字氏名();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.get郵便番号();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.get住所();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return entity.get電話番号();
    }

    /**
     * 病院施設等の名称を取得します。
     *
     * @return 病院施設等の名称
     */
    public RString get病院施設等の名称() {
        return entity.get病院施設等の名称();
    }

    /**
     * 病院施設等の所在地を取得します。
     *
     * @return 病院施設等の所在地
     */
    public RString get病院施設等の所在地() {
        return entity.get病院施設等の所在地();
    }

    /**
     * 前回の認定審査会結果を取得します。
     *
     * @return 前回の認定審査会結果
     */
    public RString get前回の認定審査会結果() {
        return entity.get前回の認定審査会結果();
    }

    /**
     * 前回の認定有効期間開始を取得します。
     *
     * @return 前回の認定有効期間開始
     */
    public RString get前回の認定有効期間開始() {
        return entity.get前回の認定有効期間開始();
    }

    /**
     * 前回の認定有効期間終了を取得します。
     *
     * @return 前回の認定有効期間終了
     */
    public RString get前回の認定有効期間終了() {
        return entity.get前回の認定有効期間終了();
    }

    /**
     * 主治医医療機関番号を取得します。
     *
     * @return 主治医医療機関番号
     */
    public RString get主治医医療機関番号() {
        return entity.get主治医医療機関番号();
    }

    /**
     * 主治医番号を取得します。
     *
     * @return 主治医番号
     */
    public RString get主治医番号() {
        return entity.get主治医番号();
    }

    /**
     * 意見書依頼日を取得します。
     *
     * @return 意見書依頼日
     */
    public RString get意見書依頼日() {
        return entity.get意見書依頼日();
    }

    /**
     * 意見書入手日を取得します。
     *
     * @return 意見書入手日
     */
    public RString get意見書入手日() {
        return entity.get意見書入手日();
    }

    /**
     * 意見書短期記憶を取得します。
     *
     * @return 意見書短期記憶
     */
    public RString get意見書短期記憶() {
        return entity.get意見書短期記憶();
    }

    /**
     * 意見書認知能力を取得します。
     *
     * @return 意見書認知能力
     */
    public RString get意見書認知能力() {
        return entity.get意見書認知能力();
    }

    /**
     * 意見書伝達能力を取得します。
     *
     * @return 意見書伝達能力
     */
    public RString get意見書伝達能力() {
        return entity.get意見書伝達能力();
    }

    /**
     * 意見書食事行為を取得します。
     *
     * @return 意見書食事行為
     */
    public RString get意見書食事行為() {
        return entity.get意見書食事行為();
    }

    /**
     * 意見書認知症高齢者の日常生活自立度を取得します。
     *
     * @return 意見書認知症高齢者の日常生活自立度
     */
    public RString get意見書認知症高齢者の日常生活自立度() {
        return entity.get意見書認知症高齢者の日常生活自立度();
    }

    /**
     * 調査依頼日を取得します。
     *
     * @return 調査依頼日
     */
    public RString get調査依頼日() {
        return entity.get調査依頼日();
    }

    /**
     * 調査実施日を取得します。
     *
     * @return 調査実施日
     */
    public RString get調査実施日() {
        return entity.get調査実施日();
    }

    /**
     * 指定居宅介護支援事業者等番号を取得します。
     *
     * @return 指定居宅介護支援事業者等番号
     */
    public RString get指定居宅介護支援事業者等番号() {
        return entity.get指定居宅介護支援事業者等番号();
    }

    /**
     * 委託区分を取得します。
     *
     * @return 委託区分
     */
    public RString get委託区分() {
        return entity.get委託区分();
    }

    /**
     * 認定調査員番号を取得します。
     *
     * @return 認定調査員番号
     */
    public RString get認定調査員番号() {
        return entity.get認定調査員番号();
    }

    /**
     * 認定調査員資格コードを取得します。
     *
     * @return 認定調査員資格コード
     */
    public RString get認定調査員資格コード() {
        return entity.get認定調査員資格コード();
    }

    /**
     * 一次判定日を取得します。
     *
     * @return 一次判定日
     */
    public RString get一次判定日() {
        return entity.get一次判定日();
    }

    /**
     * 一次判定結果を取得します。
     *
     * @return 一次判定結果
     */
    public RString get一次判定結果() {
        return entity.get一次判定結果();
    }

    /**
     * 一次判定結果認知症加算を取得します。
     *
     * @return 一次判定結果認知症加算
     */
    public RString get一次判定結果認知症加算() {
        return entity.get一次判定結果認知症加算();
    }

    /**
     * 要介護認定等基準時間を取得します。
     *
     * @return 要介護認定等基準時間
     */
    public RString get要介護認定等基準時間() {
        return entity.get要介護認定等基準時間();
    }

    /**
     * 要介護認定等基準時間食事を取得します。
     *
     * @return 要介護認定等基準時間食事
     */
    public RString get要介護認定等基準時間食事() {
        return entity.get要介護認定等基準時間食事();
    }

    /**
     * 要介護認定等基準時間排泄を取得します。
     *
     * @return 要介護認定等基準時間排泄
     */
    public RString get要介護認定等基準時間排泄() {
        return entity.get要介護認定等基準時間排泄();
    }

    /**
     * 要介護認定等基準時間移動を取得します。
     *
     * @return 要介護認定等基準時間移動
     */
    public RString get要介護認定等基準時間移動() {
        return entity.get要介護認定等基準時間移動();
    }

    /**
     * 要介護認定等基準時間清潔保持を取得します。
     *
     * @return 要介護認定等基準時間清潔保持
     */
    public RString get要介護認定等基準時間清潔保持() {
        return entity.get要介護認定等基準時間清潔保持();
    }

    /**
     * 要介護認定等基準時間間接ケアを取得します。
     *
     * @return 要介護認定等基準時間間接ケア
     */
    public RString get要介護認定等基準時間間接ケア() {
        return entity.get要介護認定等基準時間間接ケア();
    }

    /**
     * 要介護認定等基準時間BPSD関連を取得します。
     *
     * @return 要介護認定等基準時間BPSD関連
     */
    public RString get要介護認定等基準時間BPSD関連() {
        return entity.get要介護認定等基準時間BPSD関連();
    }

    /**
     * 要介護認定等基準時間機能訓練を取得します。
     *
     * @return 要介護認定等基準時間機能訓練
     */
    public RString get要介護認定等基準時間機能訓練() {
        return entity.get要介護認定等基準時間機能訓練();
    }

    /**
     * 要介護認定等基準時間医療関連を取得します。
     *
     * @return 要介護認定等基準時間医療関連
     */
    public RString get要介護認定等基準時間医療関連() {
        return entity.get要介護認定等基準時間医療関連();
    }

    /**
     * 要介護認定等基準時間認知症加算を取得します。
     *
     * @return 要介護認定等基準時間認知症加算
     */
    public RString get要介護認定等基準時間認知症加算() {
        return entity.get要介護認定等基準時間認知症加算();
    }

    /**
     * 中間評価項目得点第１群を取得します。
     *
     * @return 中間評価項目得点第１群
     */
    public RString get中間評価項目得点第１群() {
        return entity.get中間評価項目得点第１群();
    }

    /**
     * 中間評価項目得点第２群を取得します。
     *
     * @return 中間評価項目得点第２群
     */
    public RString get中間評価項目得点第２群() {
        return entity.get中間評価項目得点第２群();
    }

    /**
     * 中間評価項目得点第３群を取得します。
     *
     * @return 中間評価項目得点第３群
     */
    public RString get中間評価項目得点第３群() {
        return entity.get中間評価項目得点第３群();
    }

    /**
     * 中間評価項目得点第４群を取得します。
     *
     * @return 中間評価項目得点第４群
     */
    public RString get中間評価項目得点第４群() {
        return entity.get中間評価項目得点第４群();
    }

    /**
     * 中間評価項目得点第５群を取得します。
     *
     * @return 中間評価項目得点第５群
     */
    public RString get中間評価項目得点第５群() {
        return entity.get中間評価項目得点第５群();
    }

    /**
     * 一次判定警告配列コードを取得します。
     *
     * @return 一次判定警告配列コード
     */
    public RString get一次判定警告配列コード() {
        return entity.get一次判定警告配列コード();
    }

    /**
     * 状態の安定性を取得します。
     *
     * @return 状態の安定性
     */
    public RString get状態の安定性() {
        return entity.get状態の安定性();
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性を取得します。
     *
     * @return 認知症自立度Ⅱ以上の蓋然性
     */
    public RString get認知症自立度Ⅱ以上の蓋然性() {
        return entity.get認知症自立度Ⅱ以上の蓋然性();
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分を取得します。
     *
     * @return 認知機能及び状態安定性から推定される給付区分
     */
    public RString get認知機能及び状態安定性から推定される給付区分() {
        return entity.get認知機能及び状態安定性から推定される給付区分();
    }

    /**
     * 認定審査会資料作成日を取得します。
     *
     * @return 認定審査会資料作成日
     */
    public RString get認定審査会資料作成日() {
        return entity.get認定審査会資料作成日();
    }

    /**
     * 認定審査会予定日を取得します。
     *
     * @return 認定審査会予定日
     */
    public RString get認定審査会予定日() {
        return entity.get認定審査会予定日();
    }

    /**
     * 合議体番号を取得します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 審査会資料番号を取得します。
     *
     * @return 審査会資料番号
     */
    public RString get審査会資料番号() {
        return entity.get審査会資料番号();
    }

    /**
     * 二次判定日を取得します。
     *
     * @return 二次判定日
     */
    public RString get二次判定日() {
        return entity.get二次判定日();
    }

    /**
     * 二次判定結果を取得します。
     *
     * @return 二次判定結果
     */
    public RString get二次判定結果() {
        return entity.get二次判定結果();
    }

    /**
     * 認定有効期間開始を取得します。
     *
     * @return 認定有効期間開始
     */
    public RString get認定有効期間開始() {
        return entity.get認定有効期間開始();
    }

    /**
     * 認定有効期間終了を取得します。
     *
     * @return 認定有効期間終了
     */
    public RString get認定有効期間終了() {
        return entity.get認定有効期間終了();
    }

    /**
     * 特定疾病コードを取得します。
     *
     * @return 特定疾病コード
     */
    public RString get特定疾病コード() {
        return entity.get特定疾病コード();
    }

    /**
     * 要介護１の場合の状態像を取得します。
     *
     * @return 要介護１の場合の状態像
     */
    public RString get要介護１の場合の状態像() {
        return entity.get要介護１の場合の状態像();
    }

    /**
     * 現在のサービス区分コードを取得します。
     *
     * @return 現在のサービス区分コード
     */
    public RString get現在のサービス区分コード() {
        return entity.get現在のサービス区分コード();
    }

    /**
     * 現在の状況を取得します。
     *
     * @return 現在の状況
     */
    public RString get現在の状況() {
        return entity.get現在の状況();
    }

    /**
     * 訪問介護ホームヘルプサービスを取得します。
     *
     * @return 訪問介護ホームヘルプサービス
     */
    public RString get訪問介護ホームヘルプサービス() {
        return entity.get訪問介護ホームヘルプサービス();
    }

    /**
     * 訪問入浴介護を取得します。
     *
     * @return 訪問入浴介護
     */
    public RString get訪問入浴介護() {
        return entity.get訪問入浴介護();
    }

    /**
     * 訪問看護を取得します。
     *
     * @return 訪問看護
     */
    public RString get訪問看護() {
        return entity.get訪問看護();
    }

    /**
     * 訪問リハビリテーションを取得します。
     *
     * @return 訪問リハビリテーション
     */
    public RString get訪問リハビリテーション() {
        return entity.get訪問リハビリテーション();
    }

    /**
     * 居宅療養管理指導を取得します。
     *
     * @return 居宅療養管理指導
     */
    public RString get居宅療養管理指導() {
        return entity.get居宅療養管理指導();
    }

    /**
     * 通所介護デイサービスを取得します。
     *
     * @return 通所介護デイサービス
     */
    public RString get通所介護デイサービス() {
        return entity.get通所介護デイサービス();
    }

    /**
     * 通所リハビリテーションを取得します。
     *
     * @return 通所リハビリテーション
     */
    public RString get通所リハビリテーション() {
        return entity.get通所リハビリテーション();
    }

    /**
     * 短期入所生活介護ショートステイを取得します。
     *
     * @return 短期入所生活介護ショートステイ
     */
    public RString get短期入所生活介護ショートステイ() {
        return entity.get短期入所生活介護ショートステイ();
    }

    /**
     * 短期入所療養介護を取得します。
     *
     * @return 短期入所療養介護
     */
    public RString get短期入所療養介護() {
        return entity.get短期入所療養介護();
    }

    /**
     * 特定施設入居者生活介護を取得します。
     *
     * @return 特定施設入居者生活介護
     */
    public RString get特定施設入居者生活介護() {
        return entity.get特定施設入居者生活介護();
    }

    /**
     * 福祉用具貸与を取得します。
     *
     * @return 福祉用具貸与
     */
    public RString get福祉用具貸与() {
        return entity.get福祉用具貸与();
    }

    /**
     * 特定福祉用具販売を取得します。
     *
     * @return 特定福祉用具販売
     */
    public RString get特定福祉用具販売() {
        return entity.get特定福祉用具販売();
    }

    /**
     * 住宅改修介護給付を取得します。
     *
     * @return 住宅改修介護給付
     */
    public RString get住宅改修介護給付() {
        return entity.get住宅改修介護給付();
    }

    /**
     * 夜間対応型訪問介護を取得します。
     *
     * @return 夜間対応型訪問介護
     */
    public RString get夜間対応型訪問介護() {
        return entity.get夜間対応型訪問介護();
    }

    /**
     * 認知症対応型通所介護を取得します。
     *
     * @return 認知症対応型通所介護
     */
    public RString get認知症対応型通所介護() {
        return entity.get認知症対応型通所介護();
    }

    /**
     * 小規模多機能型居宅介護を取得します。
     *
     * @return 小規模多機能型居宅介護
     */
    public RString get小規模多機能型居宅介護() {
        return entity.get小規模多機能型居宅介護();
    }

    /**
     * 認知症対応型共同生活介護グループホームを取得します。
     *
     * @return 認知症対応型共同生活介護グループホーム
     */
    public RString get認知症対応型共同生活介護グループホーム() {
        return entity.get認知症対応型共同生活介護グループホーム();
    }

    /**
     * 地域密着型特定施設入居者生活介護を取得します。
     *
     * @return 地域密着型特定施設入居者生活介護
     */
    public RString get地域密着型特定施設入居者生活介護() {
        return entity.get地域密着型特定施設入居者生活介護();
    }

    /**
     * 地域密着型介護老人福祉施設入所者生活介護を取得します。
     *
     * @return 地域密着型介護老人福祉施設入所者生活介護
     */
    public RString get地域密着型介護老人福祉施設入所者生活介護() {
        return entity.get地域密着型介護老人福祉施設入所者生活介護();
    }

    /**
     * 定期巡回随時対応型訪問介護看護を取得します。
     *
     * @return 定期巡回随時対応型訪問介護看護
     */
    public RString get定期巡回随時対応型訪問介護看護() {
        return entity.get定期巡回随時対応型訪問介護看護();
    }

    /**
     * 複合型サービスを取得します。
     *
     * @return 複合型サービス
     */
    public RString get複合型サービス() {
        return entity.get複合型サービス();
    }

    /**
     * 介護予防訪問介護ホームヘルプサービスを取得します。
     *
     * @return 介護予防訪問介護ホームヘルプサービス
     */
    public RString get介護予防訪問介護ホームヘルプサービス() {
        return entity.get介護予防訪問介護ホームヘルプサービス();
    }

    /**
     * 介護予防訪問入浴介護を取得します。
     *
     * @return 介護予防訪問入浴介護
     */
    public RString get介護予防訪問入浴介護() {
        return entity.get介護予防訪問入浴介護();
    }

    /**
     * 介護予防訪問看護を取得します。
     *
     * @return 介護予防訪問看護
     */
    public RString get介護予防訪問看護() {
        return entity.get介護予防訪問看護();
    }

    /**
     * 介護予防訪問リハビリテーションを取得します。
     *
     * @return 介護予防訪問リハビリテーション
     */
    public RString get介護予防訪問リハビリテーション() {
        return entity.get介護予防訪問リハビリテーション();
    }

    /**
     * 介護予防居宅療養管理指導を取得します。
     *
     * @return 介護予防居宅療養管理指導
     */
    public RString get介護予防居宅療養管理指導() {
        return entity.get介護予防居宅療養管理指導();
    }

    /**
     * 介護予防通所介護デイサービスを取得します。
     *
     * @return 介護予防通所介護デイサービス
     */
    public RString get介護予防通所介護デイサービス() {
        return entity.get介護予防通所介護デイサービス();
    }

    /**
     * 介護予防短期入所生活介護ショートステイを取得します。
     *
     * @return 介護予防短期入所生活介護ショートステイ
     */
    public RString get介護予防短期入所生活介護ショートステイ() {
        return entity.get介護予防短期入所生活介護ショートステイ();
    }

    /**
     * 介護予防通所リハビリテーションを取得します。
     *
     * @return 介護予防通所リハビリテーション
     */
    public RString get介護予防通所リハビリテーション() {
        return entity.get介護予防通所リハビリテーション();
    }

    /**
     * 介護予防短期入所療養介護を取得します。
     *
     * @return 介護予防短期入所療養介護
     */
    public RString get介護予防短期入所療養介護() {
        return entity.get介護予防短期入所療養介護();
    }

    /**
     * 介護予防特定施設入居者生活介護を取得します。
     *
     * @return 介護予防特定施設入居者生活介護
     */
    public RString get介護予防特定施設入居者生活介護() {
        return entity.get介護予防特定施設入居者生活介護();
    }

    /**
     * 介護予防福祉用具貸与を取得します。
     *
     * @return 介護予防福祉用具貸与
     */
    public RString get介護予防福祉用具貸与() {
        return entity.get介護予防福祉用具貸与();
    }

    /**
     * 特定介護予防福祉用具販売を取得します。
     *
     * @return 特定介護予防福祉用具販売
     */
    public RString get特定介護予防福祉用具販売() {
        return entity.get特定介護予防福祉用具販売();
    }

    /**
     * 住宅改修予防給付を取得します。
     *
     * @return 住宅改修予防給付
     */
    public RString get住宅改修予防給付() {
        return entity.get住宅改修予防給付();
    }

    /**
     * 介護予防認知症対応型通所介護を取得します。
     *
     * @return 介護予防認知症対応型通所介護
     */
    public RString get介護予防認知症対応型通所介護() {
        return entity.get介護予防認知症対応型通所介護();
    }

    /**
     * 介護予防小規模多機能型居宅介護を取得します。
     *
     * @return 介護予防小規模多機能型居宅介護
     */
    public RString get介護予防小規模多機能型居宅介護() {
        return entity.get介護予防小規模多機能型居宅介護();
    }

    /**
     * 介護予防認知症対応型共同生活介護グループホームを取得します。
     *
     * @return 介護予防認知症対応型共同生活介護グループホーム
     */
    public RString get介護予防認知症対応型共同生活介護グループホーム() {
        return entity.get介護予防認知症対応型共同生活介護グループホーム();
    }

    /**
     * 麻痺左上肢を取得します。
     *
     * @return 麻痺左上肢
     */
    public RString get麻痺左上肢() {
        return entity.get麻痺左上肢();
    }

    /**
     * 麻痺右上肢を取得します。
     *
     * @return 麻痺右上肢
     */
    public RString get麻痺右上肢() {
        return entity.get麻痺右上肢();
    }

    /**
     * 麻痺左下肢を取得します。
     *
     * @return 麻痺左下肢
     */
    public RString get麻痺左下肢() {
        return entity.get麻痺左下肢();
    }

    /**
     * 麻痺右下肢を取得します。
     *
     * @return 麻痺右下肢
     */
    public RString get麻痺右下肢() {
        return entity.get麻痺右下肢();
    }

    /**
     * 麻痺その他を取得します。
     *
     * @return 麻痺その他
     */
    public RString get麻痺その他() {
        return entity.get麻痺その他();
    }

    /**
     * 拘縮肩関節を取得します。
     *
     * @return 拘縮肩関節
     */
    public RString get拘縮肩関節() {
        return entity.get拘縮肩関節();
    }

    /**
     * 拘縮股関節を取得します。
     *
     * @return 拘縮股関節
     */
    public RString get拘縮股関節() {
        return entity.get拘縮股関節();
    }

    /**
     * 拘縮膝関節を取得します。
     *
     * @return 拘縮膝関節
     */
    public RString get拘縮膝関節() {
        return entity.get拘縮膝関節();
    }

    /**
     * 拘縮その他を取得します。
     *
     * @return 拘縮その他
     */
    public RString get拘縮その他() {
        return entity.get拘縮その他();
    }

    /**
     * 寝返りを取得します。
     *
     * @return 寝返り
     */
    public RString get寝返り() {
        return entity.get寝返り();
    }

    /**
     * 起き上がりを取得します。
     *
     * @return 起き上がり
     */
    public RString get起き上がり() {
        return entity.get起き上がり();
    }

    /**
     * 座位保持を取得します。
     *
     * @return 座位保持
     */
    public RString get座位保持() {
        return entity.get座位保持();
    }

    /**
     * 両足での立位を取得します。
     *
     * @return 両足での立位
     */
    public RString get両足での立位() {
        return entity.get両足での立位();
    }

    /**
     * 歩行を取得します。
     *
     * @return 歩行
     */
    public RString get歩行() {
        return entity.get歩行();
    }

    /**
     * 立ち上がりを取得します。
     *
     * @return 立ち上がり
     */
    public RString get立ち上がり() {
        return entity.get立ち上がり();
    }

    /**
     * 片足での立位を取得します。
     *
     * @return 片足での立位
     */
    public RString get片足での立位() {
        return entity.get片足での立位();
    }

    /**
     * 洗身を取得します。
     *
     * @return 洗身
     */
    public RString get洗身() {
        return entity.get洗身();
    }

    /**
     * つめ切りを取得します。
     *
     * @return つめ切り
     */
    public RString getつめ切り() {
        return entity.getつめ切り();
    }

    /**
     * 視力を取得します。
     *
     * @return 視力
     */
    public RString get視力() {
        return entity.get視力();
    }

    /**
     * 聴力を取得します。
     *
     * @return 聴力
     */
    public RString get聴力() {
        return entity.get聴力();
    }

    /**
     * 移乗を取得します。
     *
     * @return 移乗
     */
    public RString get移乗() {
        return entity.get移乗();
    }

    /**
     * 移動を取得します。
     *
     * @return 移動
     */
    public RString get移動() {
        return entity.get移動();
    }

    /**
     * えん下を取得します。
     *
     * @return えん下
     */
    public RString getえん下() {
        return entity.getえん下();
    }

    /**
     * 食事摂取を取得します。
     *
     * @return 食事摂取
     */
    public RString get食事摂取() {
        return entity.get食事摂取();
    }

    /**
     * 排尿を取得します。
     *
     * @return 排尿
     */
    public RString get排尿() {
        return entity.get排尿();
    }

    /**
     * 排便を取得します。
     *
     * @return 排便
     */
    public RString get排便() {
        return entity.get排便();
    }

    /**
     * 口腔清潔を取得します。
     *
     * @return 口腔清潔
     */
    public RString get口腔清潔() {
        return entity.get口腔清潔();
    }

    /**
     * 洗顔を取得します。
     *
     * @return 洗顔
     */
    public RString get洗顔() {
        return entity.get洗顔();
    }

    /**
     * 整髪を取得します。
     *
     * @return 整髪
     */
    public RString get整髪() {
        return entity.get整髪();
    }

    /**
     * 上衣の着脱を取得します。
     *
     * @return 上衣の着脱
     */
    public RString get上衣の着脱() {
        return entity.get上衣の着脱();
    }

    /**
     * ズボン等の着脱を取得します。
     *
     * @return ズボン等の着脱
     */
    public RString getズボン等の着脱() {
        return entity.getズボン等の着脱();
    }

    /**
     * 外出頻度を取得します。
     *
     * @return 外出頻度
     */
    public RString get外出頻度() {
        return entity.get外出頻度();
    }

    /**
     * 意思の伝達を取得します。
     *
     * @return 意思の伝達
     */
    public RString get意思の伝達() {
        return entity.get意思の伝達();
    }

    /**
     * 毎日の日課を理解を取得します。
     *
     * @return 毎日の日課を理解
     */
    public RString get毎日の日課を理解() {
        return entity.get毎日の日課を理解();
    }

    /**
     * 生年月日をいうを取得します。
     *
     * @return 生年月日をいう
     */
    public RString get生年月日をいう() {
        return entity.get生年月日をいう();
    }

    /**
     * 短期記憶を取得します。
     *
     * @return 短期記憶
     */
    public RString get短期記憶() {
        return entity.get短期記憶();
    }

    /**
     * 自分の名前をいうを取得します。
     *
     * @return 自分の名前をいう
     */
    public RString get自分の名前をいう() {
        return entity.get自分の名前をいう();
    }

    /**
     * 今の季節を理解を取得します。
     *
     * @return 今の季節を理解
     */
    public RString get今の季節を理解() {
        return entity.get今の季節を理解();
    }

    /**
     * 場所の理解を取得します。
     *
     * @return 場所の理解
     */
    public RString get場所の理解() {
        return entity.get場所の理解();
    }

    /**
     * 徘徊を取得します。
     *
     * @return 徘徊
     */
    public RString get徘徊() {
        return entity.get徘徊();
    }

    /**
     * 外出して戻れないを取得します。
     *
     * @return 外出して戻れない
     */
    public RString get外出して戻れない() {
        return entity.get外出して戻れない();
    }

    /**
     * 被害的を取得します。
     *
     * @return 被害的
     */
    public RString get被害的() {
        return entity.get被害的();
    }

    /**
     * 作話を取得します。
     *
     * @return 作話
     */
    public RString get作話() {
        return entity.get作話();
    }

    /**
     * 感情が不安定を取得します。
     *
     * @return 感情が不安定
     */
    public RString get感情が不安定() {
        return entity.get感情が不安定();
    }

    /**
     * 昼夜逆転を取得します。
     *
     * @return 昼夜逆転
     */
    public RString get昼夜逆転() {
        return entity.get昼夜逆転();
    }

    /**
     * 同じ話をするを取得します。
     *
     * @return 同じ話をする
     */
    public RString get同じ話をする() {
        return entity.get同じ話をする();
    }

    /**
     * 大声を出すを取得します。
     *
     * @return 大声を出す
     */
    public RString get大声を出す() {
        return entity.get大声を出す();
    }

    /**
     * 介護に抵抗を取得します。
     *
     * @return 介護に抵抗
     */
    public RString get介護に抵抗() {
        return entity.get介護に抵抗();
    }

    /**
     * 落ち着きなしを取得します。
     *
     * @return 落ち着きなし
     */
    public RString get落ち着きなし() {
        return entity.get落ち着きなし();
    }

    /**
     * 一人で出たがるを取得します。
     *
     * @return 一人で出たがる
     */
    public RString get一人で出たがる() {
        return entity.get一人で出たがる();
    }

    /**
     * 収集癖を取得します。
     *
     * @return 収集癖
     */
    public RString get収集癖() {
        return entity.get収集癖();
    }

    /**
     * 物や衣類を壊すを取得します。
     *
     * @return 物や衣類を壊す
     */
    public RString get物や衣類を壊す() {
        return entity.get物や衣類を壊す();
    }

    /**
     * ひどい物忘れを取得します。
     *
     * @return ひどい物忘れ
     */
    public RString getひどい物忘れ() {
        return entity.getひどい物忘れ();
    }

    /**
     * 独り言独り笑いを取得します。
     *
     * @return 独り言独り笑い
     */
    public RString get独り言独り笑い() {
        return entity.get独り言独り笑い();
    }

    /**
     * 自分勝手に行動するを取得します。
     *
     * @return 自分勝手に行動する
     */
    public RString get自分勝手に行動する() {
        return entity.get自分勝手に行動する();
    }

    /**
     * 話がまとまらないを取得します。
     *
     * @return 話がまとまらない
     */
    public RString get話がまとまらない() {
        return entity.get話がまとまらない();
    }

    /**
     * 薬の内服を取得します。
     *
     * @return 薬の内服
     */
    public RString get薬の内服() {
        return entity.get薬の内服();
    }

    /**
     * 金銭の管理を取得します。
     *
     * @return 金銭の管理
     */
    public RString get金銭の管理() {
        return entity.get金銭の管理();
    }

    /**
     * 日常の意思決定を取得します。
     *
     * @return 日常の意思決定
     */
    public RString get日常の意思決定() {
        return entity.get日常の意思決定();
    }

    /**
     * 集団への不適応を取得します。
     *
     * @return 集団への不適応
     */
    public RString get集団への不適応() {
        return entity.get集団への不適応();
    }

    /**
     * 買い物を取得します。
     *
     * @return 買い物
     */
    public RString get買い物() {
        return entity.get買い物();
    }

    /**
     * 簡単な調理を取得します。
     *
     * @return 簡単な調理
     */
    public RString get簡単な調理() {
        return entity.get簡単な調理();
    }

    /**
     * 点滴の管理を取得します。
     *
     * @return 点滴の管理
     */
    public RString get点滴の管理() {
        return entity.get点滴の管理();
    }

    /**
     * 中心静脈栄養を取得します。
     *
     * @return 中心静脈栄養
     */
    public RString get中心静脈栄養() {
        return entity.get中心静脈栄養();
    }

    /**
     * 透析を取得します。
     *
     * @return 透析
     */
    public RString get透析() {
        return entity.get透析();
    }

    /**
     * ストーマの処置を取得します。
     *
     * @return ストーマの処置
     */
    public RString getストーマの処置() {
        return entity.getストーマの処置();
    }

    /**
     * 酸素療法を取得します。
     *
     * @return 酸素療法
     */
    public RString get酸素療法() {
        return entity.get酸素療法();
    }

    /**
     * レスピレーターを取得します。
     *
     * @return レスピレーター
     */
    public RString getレスピレーター() {
        return entity.getレスピレーター();
    }

    /**
     * 気管切開の処置を取得します。
     *
     * @return 気管切開の処置
     */
    public RString get気管切開の処置() {
        return entity.get気管切開の処置();
    }

    /**
     * 疼痛の看護を取得します。
     *
     * @return 疼痛の看護
     */
    public RString get疼痛の看護() {
        return entity.get疼痛の看護();
    }

    /**
     * 経管栄養を取得します。
     *
     * @return 経管栄養
     */
    public RString get経管栄養() {
        return entity.get経管栄養();
    }

    /**
     * モニター測定を取得します。
     *
     * @return モニター測定
     */
    public RString getモニター測定() {
        return entity.getモニター測定();
    }

    /**
     * じょくそうの処置を取得します。
     *
     * @return じょくそうの処置
     */
    public RString getじょくそうの処置() {
        return entity.getじょくそうの処置();
    }

    /**
     * カテーテルを取得します。
     *
     * @return カテーテル
     */
    public RString getカテーテル() {
        return entity.getカテーテル();
    }

    /**
     * 障害高齢者自立度を取得します。
     *
     * @return 障害高齢者自立度
     */
    public RString get障害高齢者自立度() {
        return entity.get障害高齢者自立度();
    }

    /**
     * 認知症高齢者自立度を取得します。
     *
     * @return 認知症高齢者自立度
     */
    public RString get認知症高齢者自立度() {
        return entity.get認知症高齢者自立度();
    }

    /**
     * 前回結果_麻痺左上肢を取得します。
     *
     * @return 前回結果_麻痺左上肢
     */
    public RString get前回結果_麻痺左上肢() {
        return entity.get前回結果_麻痺左上肢();
    }

    /**
     * 前回結果_麻痺右上肢を取得します。
     *
     * @return 前回結果_麻痺右上肢
     */
    public RString get前回結果_麻痺右上肢() {
        return entity.get前回結果_麻痺右上肢();
    }

    /**
     * 前回結果_麻痺左下肢を取得します。
     *
     * @return 前回結果_麻痺左下肢
     */
    public RString get前回結果_麻痺左下肢() {
        return entity.get前回結果_麻痺左下肢();
    }

    /**
     * 前回結果_麻痺右下肢を取得します。
     *
     * @return 前回結果_麻痺右下肢
     */
    public RString get前回結果_麻痺右下肢() {
        return entity.get前回結果_麻痺右下肢();
    }

    /**
     * 前回結果_麻痺その他を取得します。
     *
     * @return 前回結果_麻痺その他
     */
    public RString get前回結果_麻痺その他() {
        return entity.get前回結果_麻痺その他();
    }

    /**
     * 前回結果_拘縮肩関節を取得します。
     *
     * @return 前回結果_拘縮肩関節
     */
    public RString get前回結果_拘縮肩関節() {
        return entity.get前回結果_拘縮肩関節();
    }

    /**
     * 前回結果_拘縮股関節を取得します。
     *
     * @return 前回結果_拘縮股関節
     */
    public RString get前回結果_拘縮股関節() {
        return entity.get前回結果_拘縮股関節();
    }

    /**
     * 前回結果_拘縮膝関節を取得します。
     *
     * @return 前回結果_拘縮膝関節
     */
    public RString get前回結果_拘縮膝関節() {
        return entity.get前回結果_拘縮膝関節();
    }

    /**
     * 前回結果_拘縮その他を取得します。
     *
     * @return 前回結果_拘縮その他
     */
    public RString get前回結果_拘縮その他() {
        return entity.get前回結果_拘縮その他();
    }

    /**
     * 前回結果_寝返りを取得します。
     *
     * @return 前回結果_寝返り
     */
    public RString get前回結果_寝返り() {
        return entity.get前回結果_寝返り();
    }

    /**
     * 前回結果_起き上がりを取得します。
     *
     * @return 前回結果_起き上がり
     */
    public RString get前回結果_起き上がり() {
        return entity.get前回結果_起き上がり();
    }

    /**
     * 前回結果_座位保持を取得します。
     *
     * @return 前回結果_座位保持
     */
    public RString get前回結果_座位保持() {
        return entity.get前回結果_座位保持();
    }

    /**
     * 前回結果_両足での立位を取得します。
     *
     * @return 前回結果_両足での立位
     */
    public RString get前回結果_両足での立位() {
        return entity.get前回結果_両足での立位();
    }

    /**
     * 前回結果_歩行を取得します。
     *
     * @return 前回結果_歩行
     */
    public RString get前回結果_歩行() {
        return entity.get前回結果_歩行();
    }

    /**
     * 前回結果_立ち上がりを取得します。
     *
     * @return 前回結果_立ち上がり
     */
    public RString get前回結果_立ち上がり() {
        return entity.get前回結果_立ち上がり();
    }

    /**
     * 前回結果_片足での立位を取得します。
     *
     * @return 前回結果_片足での立位
     */
    public RString get前回結果_片足での立位() {
        return entity.get前回結果_片足での立位();
    }

    /**
     * 前回結果_洗身を取得します。
     *
     * @return 前回結果_洗身
     */
    public RString get前回結果_洗身() {
        return entity.get前回結果_洗身();
    }

    /**
     * 前回結果_つめ切りを取得します。
     *
     * @return 前回結果_つめ切り
     */
    public RString get前回結果_つめ切り() {
        return entity.get前回結果_つめ切り();
    }

    /**
     * 前回結果_視力を取得します。
     *
     * @return 前回結果_視力
     */
    public RString get前回結果_視力() {
        return entity.get前回結果_視力();
    }

    /**
     * 前回結果_聴力を取得します。
     *
     * @return 前回結果_聴力
     */
    public RString get前回結果_聴力() {
        return entity.get前回結果_聴力();
    }

    /**
     * 前回結果_移乗を取得します。
     *
     * @return 前回結果_移乗
     */
    public RString get前回結果_移乗() {
        return entity.get前回結果_移乗();
    }

    /**
     * 前回結果_移動を取得します。
     *
     * @return 前回結果_移動
     */
    public RString get前回結果_移動() {
        return entity.get前回結果_移動();
    }

    /**
     * 前回結果_えん下を取得します。
     *
     * @return 前回結果_えん下
     */
    public RString get前回結果_えん下() {
        return entity.get前回結果_えん下();
    }

    /**
     * 前回結果_食事摂取を取得します。
     *
     * @return 前回結果_食事摂取
     */
    public RString get前回結果_食事摂取() {
        return entity.get前回結果_食事摂取();
    }

    /**
     * 前回結果_排尿を取得します。
     *
     * @return 前回結果_排尿
     */
    public RString get前回結果_排尿() {
        return entity.get前回結果_排尿();
    }

    /**
     * 前回結果_排便を取得します。
     *
     * @return 前回結果_排便
     */
    public RString get前回結果_排便() {
        return entity.get前回結果_排便();
    }

    /**
     * 前回結果_口腔清潔を取得します。
     *
     * @return 前回結果_口腔清潔
     */
    public RString get前回結果_口腔清潔() {
        return entity.get前回結果_口腔清潔();
    }

    /**
     * 前回結果_洗顔を取得します。
     *
     * @return 前回結果_洗顔
     */
    public RString get前回結果_洗顔() {
        return entity.get前回結果_洗顔();
    }
}
