/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定情報提供ビジネスクラスです。
 *
 * @author N3212 竹内 和紀
 */
public class YokaigoNinteiJohoTeikyoBusiness {

    private final YokaigoNinteiJohoTeikyoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity NinnteiRiriRelateEntity
     */
    public YokaigoNinteiJohoTeikyoBusiness(YokaigoNinteiJohoTeikyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.get保険者番号();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.get厚労省IF識別コード();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return entity.get年齢();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return entity.get性別();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.get郵便番号();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * 申請区分_申を返します。
     *
     * @return 申請区分_申
     */
    public RString get申請区分_申() {
        return entity.get申請区分_申();
    }

    /**
     * 申請区分_法を返します。
     *
     * @return 申請区分_法
     */
    public RString get申請区分_法() {
        return entity.get申請区分_法();
    }

    /**
     * 情報提供資料出力年月日を返します。
     *
     * @return 情報提供資料出力年月日
     */
    public FlexibleDate get情報提供資料出力年月日() {
        return entity.get情報提供資料出力年月日();
    }

    /**
     * 前回厚労省IF識別コードを返します。
     *
     * @return 前回厚労省IF識別コード
     */
    public RString get前回厚労省IF識別コード() {
        return entity.get前回厚労省IF識別コード();
    }

    /**
     * 前回認定日を返します。
     *
     * @return 前回認定日
     */
    public FlexibleDate get前回認定日() {
        return entity.get前回認定日();
    }

    /**
     * 前回認定有効期間開始年月日を返します。
     *
     * @return 前回認定有効期間開始年月日
     */
    public FlexibleDate get前回認定有効期間開始年月日() {
        return entity.get前回認定有効期間開始年月日();
    }

    /**
     * 前回認定有効期間終了年月日を返します。
     *
     * @return 前回認定有効期間終了年月日
     */
    public FlexibleDate get前回認定有効期間終了年月日() {
        return entity.get前回認定有効期間終了年月日();
    }

    /**
     * 前回認定有効期間を返します。
     *
     * @return 前回認定有効期間
     */
    public RString get前回認定有効期間() {
        return entity.get前回認定有効期間();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.get住所();
    }

    /**
     * 電話を返します。
     *
     * @return 電話
     */
    public RString get電話() {
        return entity.get電話();
    }

    /**
     * 連絡先郵便番号を返します。
     *
     * @return 連絡先郵便番号
     */
    public RString get連絡先郵便番号() {
        return entity.get連絡先郵便番号();
    }

    /**
     * 連絡先住所を返します。
     *
     * @return 連絡先住所
     */
    public RString get連絡先住所() {
        return entity.get連絡先住所();
    }

    /**
     * 連絡先電話電話を返します。
     *
     * @return 連絡先電話電話
     */
    public RString get連絡先電話電話() {
        return entity.get連絡先電話電話();
    }

    /**
     * 連絡先携帯電話を返します。
     *
     * @return 連絡先携帯電話
     */
    public RString get連絡先携帯電話() {
        return entity.get連絡先携帯電話();
    }

    /**
     * 連絡先氏名を返します。
     *
     * @return 連絡先氏名
     */
    public RString get連絡先氏名() {
        return entity.get連絡先氏名();
    }

    /**
     * 関係を返します。
     *
     * @return 関係
     */
    public RString get関係() {
        return entity.get関係();
    }

    /**
     * 審査会開催日を返します。
     *
     * @return 審査会開催日
     */
    public FlexibleDate get審査会開催日() {
        return entity.get審査会開催日();
    }

    /**
     * 一次判定結果を返します。
     *
     * @return 一次判定結果
     */
    public RString get一次判定結果() {
        return entity.get一次判定結果();
    }

    /**
     * 一次判定結果_認知症加算を返します。
     *
     * @return 一次判定結果_認知症加算
     */
    public RString get一次判定結果_認知症加算() {
        return entity.get一次判定結果_認知症加算();
    }

    /**
     * 二次判定結果を返します。
     *
     * @return 二次判定結果
     */
    public RString get二次判定結果() {
        return entity.get二次判定結果();
    }

    /**
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate get二次判定年月日() {
        return entity.get二次判定年月日();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return entity.get認定有効期間開始年月日();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return entity.get認定有効期間終了年月日();
    }

    /**
     * 認定有効期間を返します。
     *
     * @return 認定有効期間
     */
    public RString get認定有効期間() {
        return entity.get認定有効期間();
    }

    /**
     * 要介護状態像例コードを返します。
     *
     * @return 要介護状態像例コード
     */
    public RString get要介護状態像例コード() {
        return entity.get要介護状態像例コード();
    }

    /**
     * 特定疾病を返します。
     *
     * @return 特定疾病
     */
    public RString get特定疾病() {
        return entity.get特定疾病();
    }

    /**
     * 審査会意見を返します。
     *
     * @return 審査会意見
     */
    public RString get審査会意見() {
        return entity.get審査会意見();
    }

    /**
     * 実施年月日を返します。
     *
     * @return 実施年月日
     */
    public FlexibleDate get実施年月日() {
        return entity.get実施年月日();
    }

    /**
     * 実施場所コードを返します。
     *
     * @return 実施場所コード
     */
    public RString get実施場所コード() {
        return entity.get実施場所コード();
    }

    /**
     * 実施場所名称を返します。
     *
     * @return 実施場所名称
     */
    public RString get実施場所名称() {
        return entity.get実施場所名称();
    }

    /**
     * 概況調査特記事項を返します。
     *
     * @return 概況調査特記事項
     */
    public RString get概況調査特記事項() {
        return entity.get概況調査特記事項();
    }

    /**
     * 調査員氏名を返します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.get調査員氏名();
    }

    /**
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.get事業者名称();
    }

    /**
     * 作成年月日を返します。
     *
     * @return 作成年月日
     */
    public FlexibleDate get作成年月日() {
        return entity.get作成年月日();
    }

    /**
     * サービス区分コードを返します。
     *
     * @return サービス区分コード
     */
    public RString getサービス区分コード() {
        return entity.getサービス区分コード();
    }

    /**
     * 施設名を返します。
     *
     * @return 施設名
     */
    public RString get施設名() {
        return entity.get施設名();
    }

    /**
     * 施設住所を返します。
     *
     * @return 施設住所
     */
    public RString get施設住所() {
        return entity.get施設住所();
    }

    /**
     * 施設電話番号を返します。
     *
     * @return 施設電話番号
     */
    public RString get施設電話番号() {
        return entity.get施設電話番号();
    }

    /**
     * 障害高齢者自立度を返します。
     *
     * @return 障害高齢者自立度
     */
    public RString get障害高齢者自立度() {
        return entity.get障害高齢者自立度();
    }

    /**
     * 認知症高齢者自立度を返します。
     *
     * @return 認知症高齢者自立度
     */
    public RString get認知症高齢者自立度() {
        return entity.get認知症高齢者自立度();
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return entity.get被保険者区分コード();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.get主治医医療機関コード();
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.get主治医コード();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.get主治医氏名();
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public RString get合議体番号() {
        return entity.get合議体番号();
    }

    /**
     * 審査会審査順を返します。
     *
     * @return 審査会審査順
     */
    public RString get審査会審査順() {
        return entity.get審査会審査順();
    }

    /**
     * 前回認定結果を返します。
     *
     * @return 前回認定結果
     */
    public RString get前回認定結果() {
        return entity.get前回認定結果();
    }

    /**
     * 前々回要介護度を返します。
     *
     * @return 前々回要介護度
     */
    public RString get前々回要介護度() {
        return entity.get前々回要介護度();
    }

    /**
     * 前々回認定有効期間を返します。
     *
     * @return 前々回認定有効期間
     */
    public RString get前々回認定有効期間() {
        return entity.get前々回認定有効期間();
    }

    /**
     * 前々回認定有効期間_開始を返します。
     *
     * @return 前々回認定有効期間_開始
     */
    public RString get前々回認定有効期間_開始() {
        return entity.get前々回認定有効期間_開始();
    }

    /**
     * 前々回認定有効期間_終了を返します。
     *
     * @return 前々回認定有効期間_終了
     */
    public RString get前々回認定有効期間_終了() {
        return entity.get前々回認定有効期間_終了();
    }

    /**
     * 前回二次判定年月日を返します。
     *
     * @return 前回二次判定年月日
     */
    public RString get前回二次判定年月日() {
        return entity.get前回二次判定年月日();
    }

    /**
     * 前回認定有効期間_開始を返します。
     *
     * @return 前回認定有効期間_開始
     */
    public RString get前回認定有効期間_開始() {
        return entity.get前回認定有効期間_開始();
    }

    /**
     * 前回認定有効期間_終了を返します。
     *
     * @return 前回認定有効期間_終了
     */
    public RString get前回認定有効期間_終了() {
        return entity.get前回認定有効期間_終了();
    }

    /**
     * 前回状態像を返します。
     *
     * @return 前回状態像
     */
    public RString get前回状態像() {
        return entity.get前回状態像();
    }

    /**
     * 所属を返します。
     *
     * @return 所属
     */
    public RString get所属() {
        return entity.get所属();
    }

    /**
     * 市町村名を返します。
     *
     * @return 市町村名
     */
    public RString get市町村名() {
        return entity.get市町村名();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public RString get事業者番号() {
        return entity.get事業者番号();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.get認定調査員コード();
    }

    /**
     * 調査員資格を返します。
     *
     * @return 調査員資格
     */
    public RString get調査員資格() {
        return entity.get調査員資格();
    }

    /**
     * 要介護認定等基準時間を返します。
     *
     * @return 要介護認定等基準時間
     */
    public RString get要介護認定等基準時間() {
        return entity.get要介護認定等基準時間();
    }

    /**
     * 要介護認定等基準時間_食事を返します。
     *
     * @return 要介護認定等基準時間_食事
     */
    public RString get要介護認定等基準時間_食事() {
        return entity.get要介護認定等基準時間_食事();
    }

    /**
     * 要介護認定等基準時間_排泄を返します。
     *
     * @return 要介護認定等基準時間_排泄
     */
    public RString get要介護認定等基準時間_排泄() {
        return entity.get要介護認定等基準時間_排泄();
    }

    /**
     * 要介護認定等基準時間_移動を返します。
     *
     * @return 要介護認定等基準時間_移動
     */
    public RString get要介護認定等基準時間_移動() {
        return entity.get要介護認定等基準時間_移動();
    }

    /**
     * 要介護認定等基準時間_清潔保持を返します。
     *
     * @return 要介護認定等基準時間_清潔保持
     */
    public RString get要介護認定等基準時間_清潔保持() {
        return entity.get要介護認定等基準時間_清潔保持();
    }

    /**
     * 要介護認定等基準時間_間接ケアを返します。
     *
     * @return 要介護認定等基準時間_間接ケア
     */
    public RString get要介護認定等基準時間_間接ケア() {
        return entity.get要介護認定等基準時間_間接ケア();
    }

    /**
     * 要介護認定等基準時間_BPSD関連を返します。
     *
     * @return 要介護認定等基準時間_BPSD関連
     */
    public RString get要介護認定等基準時間_BPSD関連() {
        return entity.get要介護認定等基準時間_BPSD関連();
    }

    /**
     * 要介護認定等基準時間_機能訓練を返します。
     *
     * @return 要介護認定等基準時間_機能訓練
     */
    public RString get要介護認定等基準時間_機能訓練() {
        return entity.get要介護認定等基準時間_機能訓練();
    }

    /**
     * 要介護認定等基準時間_医療関連を返します。
     *
     * @return 要介護認定等基準時間_医療関連
     */
    public RString get要介護認定等基準時間_医療関連() {
        return entity.get要介護認定等基準時間_医療関連();
    }

    /**
     * 要介護認定等基準時間_認知症加算を返します。
     *
     * @return 要介護認定等基準時間_認知症加算
     */
    public RString get要介護認定等基準時間_認知症加算() {
        return entity.get要介護認定等基準時間_認知症加算();
    }

    /**
     * 警告コードを返します。
     *
     * @return 警告コード
     */
    public RString get警告コード() {
        return entity.get警告コード();
    }

    /**
     * 中間評価項目得点第1群を返します。
     *
     * @return 中間評価項目得点第1群
     */
    public RString get中間評価項目得点第1群() {
        return entity.get中間評価項目得点第1群();
    }

    /**
     * 中間評価項目得点第2群を返します。
     *
     * @return 中間評価項目得点第2群
     */
    public RString get中間評価項目得点第2群() {
        return entity.get中間評価項目得点第2群();
    }

    /**
     * 中間評価項目得点第3群を返します。
     *
     * @return 中間評価項目得点第3群
     */
    public RString get中間評価項目得点第3群() {
        return entity.get中間評価項目得点第3群();
    }

    /**
     * 中間評価項目得点第4群を返します。
     *
     * @return 中間評価項目得点第4群
     */
    public RString get中間評価項目得点第4群() {
        return entity.get中間評価項目得点第4群();
    }

    /**
     * 中間評価項目得点第5群を返します。
     *
     * @return 中間評価項目得点第5群
     */
    public RString get中間評価項目得点第5群() {
        return entity.get中間評価項目得点第5群();
    }

    /**
     * 蓋然性を返します。
     *
     * @return 蓋然性
     */
    public RString get蓋然性() {
        return entity.get蓋然性();
    }

    /**
     * 安定性を返します。
     *
     * @return 安定性
     */
    public RString get安定性() {
        return entity.get安定性();
    }

    /**
     * 給付区分を返します。
     *
     * @return 給付区分
     */
    public RString get給付区分() {
        return entity.get給付区分();
    }

    /**
     * テキスト_イメージ区分を返します。
     *
     * @return テキスト_イメージ区分
     */
    public RString getテキスト_イメージ区分() {
        return entity.getテキスト_イメージ区分();
    }

    /**
     * 施設利用を返します。
     *
     * @return 施設利用
     */
    public RString get施設利用() {
        return entity.get施設利用();
    }

    /**
     * 変更事由を返します。
     *
     * @return 変更事由
     */
    public RString get変更事由() {
        return entity.get変更事由();
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.get認定審査会完了年月日();
    }

    /**
     * YokaigoNinteiJohoTeikyoEntityを返します。
     *
     * @return YokaigoNinteiJohoTeikyoEntity
     */
    public YokaigoNinteiJohoTeikyoEntity toEntity() {
        return entity;
    }
}
