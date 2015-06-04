/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 前回認定結果情報（ビジネス）を扱うインターフェースです。
 *
 * @author n8223
 */
public interface INinteiKekkaJoho {

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    ShinseishoKanriNo get申請書管理番号();

    /**
     * 二次判定年月日を返します。
     *
     * @return 二次判定年月日
     */
    FlexibleDate get二次判定年月日();

    /**
     * 二次判定要介護状態区分コードを返します。
     *
     * @return 二次判定要介護状態区分コード
     */
    Code get二次判定要介護状態区分コード();

    /**
     * 二次判定認定有効期間を返します。
     *
     * @return 二次判定認定有効期間
     */
    Integer get二次判定認定有効期間();

    /**
     * 二次判定認定有効開始年月日を返します。
     *
     * @return 二次判定認定有効開始年月日
     */
    FlexibleDate get二次判定認定有効開始年月日();

    /**
     * 二次判定認定有効終了年月日を返します。
     *
     * @return 二次判定認定有効終了年月日
     */
    FlexibleDate get二次判定認定有効終了年月日();

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    Integer get介護認定審査会開催番号();

    /**
     * 介護認定審査会意見を返します。
     *
     * @return 介護認定審査会意見
     */
    RString get介護認定審査会意見();

    /**
     * 一次判定結果変更理由を返します。
     *
     * @return 一次判定結果変更理由
     */
    RString get一次判定結果変更理由();

    /**
     * 要介護状態像例コードを返します。
     *
     * @return 要介護状態像例コード
     */
    Code get要介護状態像例コード();

    /**
     * 認定審査会意見種類を返します。
     *
     * @return 認定審査会意見種類
     */
    RString get認定審査会意見種類();

    /**
     * 審査会メモを返します。
     *
     * @return 審査会メモ
     */
    RString get審査会メモ();

    /**
     * 二次判定結果入力方法を返します。
     *
     * @return 二次判定結果入力方法
     */
    Code get二次判定結果入力方法();

    /**
     * 二次判定結果入力年月日を返します。
     *
     * @return 二次判定結果入力年月日
     */
    FlexibleDate get二次判定結果入力年月日();
}
