/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請情報（ビジネス）を扱うインターフェースです。
 *
 * @author N8235 船山 洋介
 */
public interface INinteiShinseiJoho {

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    ShinseishoKanriNo get申請書管理番号();

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    Code get厚労省IF識別コード();

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    RString get証記載保険者番号();

    /**
     * 申請年度を返します。
     *
     * @return 申請年度
     */
    FlexibleYear get申請年度();

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    FlexibleDate get認定申請年月日();

    /**
     * 認定申請枝番コードを返します。
     *
     * @return 認定申請枝番コード
     */
    EdabanCode get認定申請枝番コード();

    /**
     * 認定申請区分_法令_コードを返します。
     *
     * @return 認定申請区分_法令_コード
     */
    Code get認定申請区分_法令_コード();

    /**
     * 認定申請区分_申請時_コードを返します。
     *
     * @return 認定申請区分_申請時_コード
     */
    Code get認定申請区分_申請時_コード();

    /**
     * 取下区分コードを返します。
     *
     * @return 取下区分コード
     */
    Code get取下区分コード();

    /**
     * 被保険者区分コードを返します。
     *
     * @return 被保険者区分コード
     */
    RString get被保険者区分コード();

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    FlexibleDate get生年月日();

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    int get年齢();

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    SeibetsuCode get性別();

    /**
     * 被保険者氏名カナを返します。
     *
     * @return 被保険者氏名カナ
     */
    AtenaKanaMeisho get被保険者氏名カナ();

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    AtenaMeisho get被保険者氏名();

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    YubinNo get郵便番号();

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    AtenaJusho get住所();

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    TelNo get電話番号();

    /**
     * 支所コードを返します。
     *
     * @return 支所コード
     */
    RString get支所コード();

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    ShikibetsuCode get識別コード();

    /**
     * 地区コードを返します。
     *
     * @return 地区コード
     */
    ChikuCode get地区コード();

    /**
     * みなし二号等対象フラグを返します。
     *
     * @return みなし二号等対象フラグ
     */
    boolean isみなし二号等対象フラグ();

    /**
     * 広域内転居区分を返します。
     *
     * @return 広域内転居区分
     */
    Code get広域内転居区分();

    /**
     * 認定申請有効区分を返します。
     *
     * @return 認定申請有効区分
     */
    Code get認定申請有効区分();

    /**
     * 要介護申請_要支援申請の区分を返します。
     *
     * @return 要介護申請_要支援申請の区分
     */
    RString get要介護申請_要支援申請の区分();

    /**
     * 認定申請理由を返します。
     *
     * @return 認定申請理由
     */
    RString get認定申請理由();

    /**
     * 申請サービス削除の理由を返します。
     *
     * @return 申請サービス削除の理由
     */
    RString get申請サービス削除の理由();

    /**
     * 前回要介護状態区分コードを返します。
     *
     * @return 前回要介護状態区分コード
     */
    Code get前回要介護状態区分コード();

    /**
     * 前回認定年月日を返します。
     *
     * @return 前回認定年月日
     */
    FlexibleDate get前回認定年月日();

    /**
     * 前回認定有効期間_開始を返します。
     *
     * @return 前回認定有効期間_開始
     */
    FlexibleDate get前回認定有効期間_開始();

    /**
     * 前回認定有効期間_終了を返します。
     *
     * @return 前回認定有効期間_終了
     */
    FlexibleDate get前回認定有効期間_終了();

    /**
     * 二号医療保険者名を返します。
     *
     * @return 二号医療保険者名
     */
    RString get二号医療保険者名();

    /**
     * 二号医療保険記号番号を返します。
     *
     * @return 二号医療保険記号番号
     */
    RString get二号医療保険記号番号();

    /**
     * 二号特定疾病コードを返します。
     *
     * @return 二号特定疾病コード
     */
    Code get二号特定疾病コード();

    /**
     * 自動割当除外者区分を返します。
     *
     * @return 自動割当除外者区分
     */
    RString get自動割当除外者区分();

    /**
     * 情報提供への同意有無を返します。
     *
     * @return 情報提供への同意有無
     */
    boolean is情報提供への同意有無();

    /**
     * 情報提供資料出力年月日を返します。
     *
     * @return 情報提供資料出力年月日
     */
    FlexibleDate get情報提供資料出力年月日();

    /**
     * 調査区分を返します。
     *
     * @return 調査区分
     */
    Code get調査区分();

    /**
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    RString get認定調査委託先コード();

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    RString get認定調査員コード();

    /**
     * 調査員への連絡事項を返します。
     *
     * @return 調査員への連絡事項
     */
    RString get調査員への連絡事項();

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    RString get主治医医療機関コード();

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    RString get主治医コード();

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    boolean is指定医フラグ();

    /**
     * 意見書データ種別を返します。
     *
     * @return 意見書データ種別
     */
    Code get意見書データ種別();

    /**
     * 主治医への連絡事項を返します。
     *
     * @return 主治医への連絡事項
     */
    RString get主治医への連絡事項();

    /**
     * みなし要介護区分コードを返します。
     *
     * @return みなし要介護区分コード
     */
    Code getみなし要介護区分コード();

    /**
     * 認定延期通知発行しないことに対する同意有無を返します。
     *
     * @return 認定延期通知発行しないことに対する同意有無
     */
    boolean is認定延期通知発行しないことに対する同意有無();

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無
     */
    boolean is施設入所の有無();

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    JigyoshaNo get入所施設コード();

    /**
     * 家庭訪問の有無を返します。
     *
     * @return 家庭訪問の有無
     */
    boolean is家庭訪問の有無();

    /**
     * 訪問調査先郵便番号を返します。
     *
     * @return 訪問調査先郵便番号
     */
    YubinNo get訪問調査先郵便番号();

    /**
     * 訪問調査先住所を返します。
     *
     * @return 訪問調査先住所
     */
    AtenaJusho get訪問調査先住所();

    /**
     * 訪問調査先名称を返します。
     *
     * @return 訪問調査先名称
     */
    AtenaMeisho get訪問調査先名称();

    /**
     * 訪問調査先電話番号を返します。
     *
     * @return 訪問調査先電話番号
     */
    TelNo get訪問調査先電話番号();

    /**
     * 市町村連絡事項を返します。
     *
     * @return 市町村連絡事項
     */
    RString get市町村連絡事項();

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    Code get処理状態区分();

    /**
     * 取下年月日を返します。
     *
     * @return 取下年月日
     */
    FlexibleDate get取下年月日();

    /**
     * 取下理由を返します。
     *
     * @return 取下理由
     */
    RString get取下理由();

    /**
     * 却下年月日を返します。
     *
     * @return 却下年月日
     */
    FlexibleDate get却下年月日();

    /**
     * 却下理由を返します。
     *
     * @return 却下理由
     */
    RString get却下理由();

    /**
     * 延期決定年月日を返します。
     *
     * @return 延期決定年月日
     */
    FlexibleDate get延期決定年月日();

    /**
     * 延期理由を返します。
     *
     * @return 延期理由
     */
    RString get延期理由();

    /**
     * 延期通知発行年月日を返します。
     *
     * @return 延期通知発行年月日
     */
    FlexibleDate get延期通知発行年月日();

    /**
     * 延期通知発行回数を返します。
     *
     * @return 延期通知発行回数
     */
    int get延期通知発行回数();

    /**
     * 延期見込期間開始年月日を返します。
     *
     * @return 延期見込期間開始年月日
     */
    FlexibleDate get延期見込期間開始年月日();

    /**
     * 延期見込期間終了年月日を返します。
     *
     * @return 延期見込期間終了年月日
     */
    FlexibleDate get延期見込期間終了年月日();

    /**
     * 審査継続区分を返します。
     *
     * @return 審査継続区分
     */
    boolean is審査継続区分();

    /**
     * 要介護認定審査会優先振分区分コードを返します。
     *
     * @return 要介護認定審査会優先振分区分コード
     */
    Code get要介護認定審査会優先振分区分コード();

    /**
     * 更新通知発行年月日を返します。
     *
     * @return 更新通知発行年月日
     */
    FlexibleDate get更新通知発行年月日();

    /**
     * 更新通知発行完了年月日を返します。
     *
     * @return 更新通知発行完了年月日
     */
    FlexibleDate get更新通知発行完了年月日();

    /**
     * 認定申請情報登録年月日を返します。
     *
     * @return 認定申請情報登録年月日
     */
    FlexibleDate get認定申請情報登録年月日();

    /**
     * 再調査依頼回数を返します。
     *
     * @return 再調査依頼回数
     */
    int get再調査依頼回数();

    /**
     * 再作成依頼回数を返します。
     *
     * @return 再作成依頼回数
     */
    int get再作成依頼回数();

    /**
     * ＩＦ送付年月日を返します。
     *
     * @return ＩＦ送付年月日
     */
    FlexibleDate getＩＦ送付年月日();

    /**
     * 論理削除区分を返します。
     *
     * @return ＩＦ送付年月日
     */
    boolean is論理削除区分();

}
