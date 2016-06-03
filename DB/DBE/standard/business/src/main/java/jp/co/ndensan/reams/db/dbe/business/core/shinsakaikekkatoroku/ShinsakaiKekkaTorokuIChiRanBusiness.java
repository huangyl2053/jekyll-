/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinsakaikekkatoroku;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaikekkatoroku.ShinsakaiKekkaTorokuIChiRanRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会開催結果登録の審査会委員一覧検索Businessです。
 *
 * @reamsid_L DBE-0170-010 wangkun
 */
public class ShinsakaiKekkaTorokuIChiRanBusiness {

    private final ShinsakaiKekkaTorokuIChiRanRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催結果登録の審査会委員一覧検索に使用します。
     *
     * @param entity ShinsakaiKekkaTorokuIChiRanRelateEntity
     */
    public ShinsakaiKekkaTorokuIChiRanBusiness(ShinsakaiKekkaTorokuIChiRanRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 審査会順序を取得します。
     *
     * @return 審査会順序
     */
    public int get審査会順序() {
        return entity.get介護認定審査会審査順();
    }

    /**
     * 保険者番号を取得します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.get市町村名称();
    }

    /**
     * 被保番号を取得します。
     *
     * @return 被保番号
     */
    public RString get被保番号() {
        return entity.get被保険者番号();
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return entity.get被保険者氏名().value();
    }

    /**
     * 被保区分を取得します。
     *
     * @return 被保区分
     */
    public RString get被保区分() {
        return entity.get被保険者区分コード();
    }

    /**
     * 申請区分_申請時を取得します。
     *
     * @return 申請区分_申請時
     */
    public RString get申請区分_申請時() {
        return entity.get申請区分_申請時_コード().value();
    }

    /**
     * 申請区分_法令を取得します。
     *
     * @return 申請区分_法令
     */
    public RString get申請区分_法令() {
        return entity.get申請区分_法令_コード().value();
    }

    /**
     * 認定申請を取得します。
     *
     * @return 認定申請
     */
    public FlexibleDate get認定申請日() {
        return entity.get認定申請年月日();
    }

    /**
     * 前回有効期間終了日を取得します。
     *
     * @return 前回有効期間終了日
     */
    public FlexibleDate get前回有効期間終了日() {
        return entity.get前回認定有効期間_終了();
    }

    /**
     * 前回一次判定を取得します。
     *
     * @return 前回一次判定
     */
    public RString get前回一次判定() {
        return entity.get要介護認定一次判定結果コード().value();
    }

    /**
     * 今回一次判定を取得します。
     *
     * @return 今回一次判定
     */
    public RString get今回一次判定() {
        return entity.get要介護認定一次判定結果コード().value();
    }

    /**
     * 今回二次判定を取得します。
     *
     * @return 今回二次判定
     */
    public RString get今回二次判定() {
        return entity.get二次判定要介護状態区分コード().value();
    }

    /**
     * 判定結果を取得します。
     *
     * @return 判定結果
     */
    public RString get判定結果() {
        return entity.get判定結果コード();
    }

    /**
     * 二次判定日を取得します。
     *
     * @return 二次判定日
     */
    public FlexibleDate get二次判定日() {
        return entity.get二次判定年月日();
    }

    /**
     * 特定疾病を取得します。
     *
     * @return 特定疾病
     */
    public RString get特定疾病() {
        return entity.getコード_２号特定疾病コード().value();
    }

    /**
     * 状態像コードを取得します。
     *
     * @return 状態像コード
     */
    public RString get状態像コード() {
        return entity.get要介護状態像例コード().value();
    }

    /**
     * 認定期間開始を取得します。
     *
     * @return 認定期間開始
     */
    public FlexibleDate get認定期間開始() {
        return entity.get二次判定認定有効開始年月日();
    }

    /**
     * 認定期間終了を取得します。
     *
     * @return 認定期間終了
     */
    public FlexibleDate get認定期間終了() {
        return entity.get二次判定認定有効終了年月日();
    }

    /**
     * 認定期間月数を取得します。
     *
     * @return 認定期間月数
     */
    public RString get認定期間月数() {
        return entity.get被保険者区分コード();
    }

    /**
     * 審査会メモを取得します。
     *
     * @return 審査会メモ
     */
    public RString get審査会メモ() {
        return entity.get審査会メモ();
    }

    /**
     * 審査会意見を取得します。
     *
     * @return 審査会意見
     */
    public RString get審査会意見() {
        return entity.get介護認定審査会意見();
    }

    /**
     * 審査会意見種類を取得します。
     *
     * @return 審査会意見種類
     */
    public RString get審査会意見種類() {
        return entity.get審査会意見種類();
    }

}
