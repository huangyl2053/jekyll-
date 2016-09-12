/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.zenkaininteikekkajoho;

import jp.co.ndensan.reams.db.dbz.entity.db.relate.zenkaininteikekkajoho.KekkaShosaiJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 結果詳細情報ダイアログを表示する時に引数のクラスです。
 *
 * @reamsid_L DBE-3000-020 dongyabin
 */
public class KekkaShosaiJohoRelate {

    private final KekkaShosaiJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public KekkaShosaiJohoRelate(KekkaShosaiJohoRelateEntity entity) {
        this.entity = entity;
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
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return entity.get認定申請年月日();
    }

    /**
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.get厚労省IF識別コード();
    }

    /**
     * 二次判定要介護状態区分コードを取得します。
     *
     * @return 二次判定要介護状態区分コード
     */
    public RString get二次判定要介護状態区分コード() {
        return entity.get二次判定要介護状態区分コード();
    }

    /**
     * 二次判定認定有効開始年月日を取得します。
     *
     * @return 二次判定認定有効開始年月日
     */
    public FlexibleDate get二次判定認定有効開始年月日() {
        return entity.get二次判定認定有効開始年月日();
    }

    /**
     * 二次判定認定有効終了年月日を取得します。
     *
     * @return 二次判定認定有効終了年月日
     */
    public FlexibleDate get二次判定認定有効終了年月日() {
        return entity.get二次判定認定有効終了年月日();
    }

    /**
     * 介護認定審査会意見を取得します。
     *
     * @return 介護認定審査会意見
     */
    public RString get介護認定審査会意見() {
        return entity.get介護認定審査会意見();
    }

    /**
     * 直近異動事由コードを取得します。
     *
     * @return 直近異動事由コード
     */
    public RString get直近異動事由コード() {
        return entity.get直近異動事由コード();
    }

    /**
     * 削除事由コードを取得します。
     *
     * @return 削除事由コード
     */
    public RString get削除事由コード() {
        return entity.get削除事由コード();
    }

    /**
     * 認定申請理由を取得します。
     *
     * @return 認定申請理由
     */
    public RString get認定申請理由() {
        return entity.get認定申請理由();
    }

    /**
     * 喪失年月日を取得します。
     *
     * @return 喪失年月日
     */
    public FlexibleDate get喪失年月日() {
        return entity.get喪失年月日();
    }

    /**
     * 取下年月日を取得します。
     *
     * @return 取下年月日
     */
    public FlexibleDate get取下年月日() {
        return entity.get取下年月日();
    }

    /**
     * 当初認定有効開始年月日を取得します。
     *
     * @return 当初認定有効開始年月日
     */
    public FlexibleDate get当初認定有効開始年月日() {
        return entity.get当初認定有効開始年月日();
    }

    /**
     * 当初認定有効終了年月日を取得します。
     *
     * @return 当初認定有効終了年月日
     */
    public FlexibleDate get当初認定有効終了年月日() {
        return entity.get当初認定有効終了年月日();
    }

    /**
     * 受給資格証明書発行年月日１を取得します。
     *
     * @return 受給資格証明書発行年月日１
     */
    public FlexibleDate get受給資格証明書発行年月日１() {
        return entity.get受給資格証明書発行年月日１();
    }

    /**
     * 受給資格証明書発行年月日２を取得します。
     *
     * @return 受給資格証明書発行年月日２
     */
    public FlexibleDate get受給資格証明書発行年月日２() {
        return entity.get受給資格証明書発行年月日２();
    }

    /**
     * 認定申請区分_申請時_コードを取得します。
     *
     * @return 認定申請区分_申請時_コード
     */
    public RString get認定申請区分_申請時_コード() {
        return entity.get認定申請区分_申請時_コード();
    }

    /**
     * 認定申請区分_法令_コードを取得します。
     *
     * @return 認定申請区分_法令_コード
     */
    public RString get認定申請区分_法令_コード() {
        return entity.get認定申請区分_法令_コード();
    }
}
