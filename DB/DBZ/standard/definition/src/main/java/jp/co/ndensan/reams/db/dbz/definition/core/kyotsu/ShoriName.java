package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理名を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ShoriName {

    /**
     * コード:無し 名称:納付額データ作成 略称:定義なし
     */
    納付額データ作成("納付額データ作成"),
    /**
     * コード:無し 名称:特徴対象者情報取込 略称:定義なし
     */
    特徴対象者情報取込("特徴対象者情報取込"),
    /**
     * コード:無し 名称:特徴依頼情報作成 略称:定義なし
     */
    特徴依頼情報作成("特徴依頼情報作成"),
    /**
     * コード:無し 名称:特徴依頼処理結果情報取込 略称:定義なし
     */
    特徴依頼処理結果情報取込("特徴依頼処理結果情報取込"),
    /**
     * コード:無し 名称:特徴結果情報取込 略称:定義なし
     */
    特徴結果情報取込("特徴結果情報取込"),
    /**
     * コード:無し 名称:特徴異動情報作成 略称:定義なし
     */
    特徴異動情報作成("特徴異動情報作成"),
    /**
     * コード:無し 名称:特別徴収制度間ＩＦ作成 略称:定義なし
     */
    特別徴収制度間ＩＦ作成("特別徴収制度間ＩＦ作成"),
    /**
     * コード:無し 名称:特徴対象者同定 略称:定義なし
     */
    特徴対象者同定("特徴対象者同定"),
    /**
     * コード:無し 名称:依頼金額計算 略称:定義なし
     */
    依頼金額計算_８月分("依頼金額計算_８月分"),
    /**
     * コード:無し 名称:特徴仮算定賦課 略称:定義なし
     */
    特徴仮算定賦課("特徴仮算定賦課"),
    /**
     * コード:無し 名称:普徴仮算定賦課 略称:定義なし
     */
    普徴仮算定賦課("普徴仮算定賦課"),
    /**
     * コード:無し 名称:仮算定異動賦課 略称:定義なし
     */
    仮算定異動賦課("仮算定異動賦課"),
    /**
     * コード:無し 名称:特徴平準化計算_6月分 略称:定義なし
     */
    特徴平準化計算_6月分("特徴平準化計算_6月分"),
    /**
     * コード:無し 名称:特徴平準化計算_8月分 略称:定義なし
     */
    特徴平準化計算_8月分("特徴平準化計算_8月分"),
    /**
     * コード:無し 名称:当初所得引出 略称:定義なし
     */
    当初所得引出("当初所得引出"),
    /**
     * コード:無し 名称:本算定賦課 略称:定義なし
     */
    本算定賦課("本算定賦課"),
    /**
     * コード:無し 名称:異動賦課 略称:定義なし
     */
    異動賦課("異動賦課"),
    /**
     * コード:無し 名称:過年度賦課 略称:定義なし
     */
    過年度賦課("過年度賦課"),
    /**
     * コード:無し 名称:特徴仮算定賦課確定 略称:定義なし
     */
    特徴仮算定賦課確定("特徴仮算定賦課確定"),
    /**
     * コード:無し 名称:普徴仮算定賦課確定 略称:定義なし
     */
    普徴仮算定賦課確定("普徴仮算定賦課確定"),
    /**
     * コード:無し 名称:仮算定異動賦課確定 略称:定義なし
     */
    仮算定異動賦課確定("仮算定異動賦課確定"),
    /**
     * コード:無し 名称:依頼金額計算 略称:定義なし
     */
    依頼金額計算("依頼金額計算"),
    /**
     * コード:無し 名称:特徴平準化_6月分_確定 略称:定義なし
     */
    特徴平準化_6月分_確定("特徴平準化_6月分_確定"),
    /**
     * コード:無し 名称:特徴平準化_8月分_確定 略称:定義なし
     */
    特徴平準化_8月分_確定("特徴平準化_8月分_確定"),
    /**
     * コード:無し 名称:本算定賦課確定 略称:定義なし
     */
    本算定賦課確定("本算定賦課確定"),
    /**
     * コード:無し 名称:異動賦課確定 略称:定義なし
     */
    異動賦課確定("異動賦課確定"),
    /**
     * コード:無し 名称:過年度賦課確定 略称:定義なし
     */
    過年度賦課確定("過年度賦課確定"),
    /**
     * コード:無し 名称:所得引出 略称:定義なし
     */
    所得引出("所得引出"),
    /**
     * コード:無し 名称:所得情報一覧表作成 略称:定義なし
     */
    所得情報一覧表作成("所得情報一覧表作成"),
    /**
     * コード:無し 名称:調定簿作成 略称:定義なし
     */
    調定簿作成("調定簿作成"),
    /**
     * コード:無し 名称:新年度管理情報作成 略称:定義なし
     */
    新年度管理情報作成("新年度管理情報作成"),
    /**
     * コード:無し 名称:年度切替 略称:定義なし
     */
    年度切替("年度切替"),
    /**
     * コード:無し 名称:年齢到達予定者チェックリスト 略称:定義なし
     */
    年齢到達予定者チェックリスト("年齢到達予定者チェックリスト"),
    /**
     * コード:無し 名称:償還払い支給不支給決定通知書一括作成_受付日 略称:定義なし
     */
    償還払い支給不支給決定通知書一括作成_受付日("償還払い支給不支給決定通知書一括作成_受付日"),
    /**
     * コード:無し 名称:償還払い支給不支給決定通知書一括作成_決定日 略称:定義なし
     */
    償還払い支給不支給決定通知書一括作成_決定日("償還払い支給不支給決定通知書一括作成_決定日"),
    /**
     * コード:無し 名称:償還払い支給不支給決定通知書一括作成_決定者受付年月 略称:定義なし
     */
    償還払い支給不支給決定通知書一括作成_決定者受付年月("償還払い支給不支給決定通知書一括作成_決定者受付年月"),
    /**
     * コード:無し 名称:住民異動連携情報登録_他社住基用 略称:定義なし
     */
    住民異動連携情報登録_他社住基用("住民異動連携情報登録_他社住基用"),
    /**
     * コード:無し 名称:更新申請者管理 略称:定義なし
     */
    更新申請者管理("更新申請者管理"),
    /**
     * コード:無し 名称:認定結果通知書 略称:定義なし
     */
    認定結果通知書("認定結果通知書"),
    /**
     * コード:無し 名称:サービス変更通知書 略称:定義なし
     */
    サービス変更通知書("サービス変更通知書"),
    /**
     * コード:無し 名称:要介護区分変更通知書 略称:定義なし
     */
    要介護区分変更通知書("要介護区分変更通知書"),
    /**
     * コード:無し 名称:高額合算自己負担額計算登録 略称:定義なし
     */
    高額合算自己負担額計算登録("高額合算自己負担額計算登録"),
    /**
     * コード:無し 名称:年次利用者負担割合判定 略称:定義なし
     */
    年次利用者負担割合判定("年次利用者負担割合判定"),
    /**
     * コード:無し 名称:異動分利用者負担割合判定 略称:定義なし
     */
    異動分利用者負担割合判定("異動分利用者負担割合判定"),
    /**
     * コード:無し 名称:異動分利用者負担割合判定（過年度） 略称:定義なし
     */
    異動分利用者負担割合判定_過年度("異動分利用者負担割合判定（過年度）"),
    /**
     * コード:無し 名称:受給者台帳 略称:定義なし
     */
    受給者台帳("受給者台帳"),
    /**
     * コード:無し 名称:事業分自己負担額計算 略称:定義なし
     */
    事業分自己負担額計算("事業分自己負担額計算"),
    /**
     * コード:無し 名称:高額合算自己負担額補正（一括） 略称:定義なし
     */
    高額合算自己負担額補正_一括("高額合算自己負担額補正（一括）"),
    /**
     * コード:無し 名称:高額合算支給決定通知書（一括） 略称:定義なし
     */
    高額合算支給決定通知書_一括("高額合算支給決定通知書（一括）"),
    /**
     * コード:無し 名称:負担割合証発行（一括） 略称:定義なし
     */
    負担割合証発行一括("負担割合証発行（一括）"),
    /**
     * コード:無し 名称:非課税年金対象者情報取込 略称:定義なし
     */
    非課税年金対象者情報取込("非課税年金対象者情報取込"),
    /**
     * コード:無し 名称:非課税年金対象者情報アップロード 略称:定義なし
     */
    非課税年金対象者情報アップロード("非課税年金対象者情報アップロード"),
    /**
     * コード:無し 名称:事業分支給額計算 略称:定義なし
     */
    事業分支給額計算("事業分支給額計算"),
    /**
     * コード:無し 名称:自己負担証明書作成_一括 略称:定義なし
     */
    自己負担証明書作成_一括("自己負担証明書作成_一括"),
    /**
     * コード:無し 名称:更正対象給付実績一覧 略称:定義なし
     */
    更正対象給付実績一覧("更正対象給付実績一覧"),
    /**
     * コード:無し 名称:高額サービス費給付振込明細書作成 略称:定義なし
     */
    高額サービス費給付振込明細書作成("高額サービス費給付振込明細書作成"),
    /**
     * コード:無し 名称:償還払い給付振込明細書作成 略称:定義なし
     */
    償還払い給付振込明細書作成("償還払い給付振込明細書作成"),
    /**
     * コード:無し 名称:高額医療合算給付振込明細書作成 略称:定義なし
     */
    高額医療合算給付振込明細書作成("高額医療合算給付振込明細書作成"),
    /**
     * コード:無し 名称:高額サービス費支給決定通知書作成 略称:定義なし
     */
    高額サービス費支給決定通知書作成("高額サービス費支給決定通知書作成"),
    /**
     * コード:無し 名称:給付振込データ作成_償還 略称:定義なし
     */
    給付振込データ作成_償還("給付振込データ作成_償還"),
    /**
     * コード:無し 名称:給付振込データ作成_高額 略称:定義なし
     */
    給付振込データ作成_高額("給付振込データ作成_高額"),
    /**
     * コード:無し 名称:給付振込データ作成_高額合算 略称:定義なし
     */
    給付振込データ作成_高額合算("給付振込データ作成_高額合算"),
    /**
     * コード:無し 名称:給付振込データ作成_償還高額 略称:定義なし
     */
    給付振込データ作成_償還高額("給付振込データ作成_償還高額"),
    /**
     * コード:無し 名称:高額介護対象者抽出_遡及分 略称:定義なし
     */
    高額介護対象者抽出_遡及分("高額介護対象者抽出_遡及分"),
    /**
     * コード:無し 名称:高額サービス等支給不支給決定通知書一括作成 略称:定義なし
     */
    高額サービス等支給不支給決定通知書一括作成("高額サービス等支給不支給決定通知書一括作成"),
    /**
     * コード:無し 名称:事業高額サービス等支給不支給決定通知書一括作成 略称:定義なし
     */
    事業高額サービス等支給不支給決定通知書一括作成("事業高額サービス等支給不支給決定通知書一括作成"),
    /**
     * コード:無し 名称:広域住基連動 略称:定義なし
     */
    広域住基連動("広域住基連動");

    private final RString fullName;

    private ShoriName(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 処理名の名称を返します。
     *
     * @return 処理名の名称
     */
    public RString get名称() {
        return fullName;
    }

}
