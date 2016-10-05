/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.saishinsamoshitatetouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitatetouroku.SaishinsaMoshitateTourokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査申立情報のbusinessです。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
public class SaishinsaMoshitateJohoBusiness implements Serializable {

    private final SaishinsaMoshitateTourokuRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 護給付費再審査申立書作成のRelateEntity
     */
    public SaishinsaMoshitateJohoBusiness(SaishinsaMoshitateTourokuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 氏名を取得します。
     *
     * @return the 氏名
     */
    public RString get氏名() {
        return entity.get氏名();
    }

    /**
     * 証記載保険者名を取得します。
     *
     * @return 証記載保険者名
     */
    public RString get証記載保険者名() {
        return entity.get証記載保険者名();
    }

    /**
     * 事業者名を取得します。
     *
     * @return 事業者名
     */
    public RString get事業者名() {
        return entity.get事業者名();
    }

    /**
     * サービス種類コードを取得します。
     *
     * @return サービス種類コード
     */
    public RString getサービス種類コード() {
        return entity.getサービス種類コード();
    }

    /**
     * サービス項目コードを取得します。
     *
     * @return サービス項目コード
     */
    public RString getサービス項目コード() {
        return entity.getサービス項目コード();
    }

    /**
     * insertDantaiCdを取得します。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return entity.getInsertDantaiCd();
    }

    /**
     * insertTimestampを取得します。
     *
     * @return insertTimestamp
     */
    public RString getInsertTimestamp() {
        return entity.getInsertTimestamp();
    }

    /**
     * insertReamsLoginIdを取得します。
     *
     * @return insertReamsLoginId
     */
    public RString getInsertReamsLoginId() {
        return entity.getInsertReamsLoginId();
    }

    /**
     * insertContextIdを取得します。
     *
     * @return insertContextId
     */
    public RString getInsertContextId() {
        return entity.getInsertContextId();
    }

    /**
     * isDeletedを取得します。
     *
     * @return isDeleted
     */
    public RString getIsDeleted() {
        return entity.getIsDeleted();
    }

    /**
     * updateCountを取得します。
     *
     * @return updateCount
     */
    public RString getUpdateCount() {
        return entity.getUpdateCount();
    }

    /**
     * lastUpdateTimestampを取得します。
     *
     * @return lastUpdateTimestamp
     */
    public RString getLastUpdateTimestamp() {
        return entity.getLastUpdateTimestamp();
    }

    /**
     * lastUpdateReamsLoginIdを取得します。
     *
     * @return lastUpdateReamsLoginId
     */
    public RString getLastUpdateReamsLoginId() {
        return entity.getLastUpdateReamsLoginId();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
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
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public RString getサービス提供年月() {
        return entity.getサービス提供年月();
    }

    /**
     * 事業所番号を取得します。
     *
     * @return 事業所番号
     */
    public RString get事業所番号() {
        return entity.get事業所番号();
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public RString get履歴番号() {
        return entity.get履歴番号();
    }

    /**
     * 申立年月日を取得します。
     *
     * @return 申立年月日
     */
    public RString get申立年月日() {
        return entity.get申立年月日();
    }

    /**
     * 申立者区分コードを取得します。
     *
     * @return 申立者区分コード
     */
    public RString get申立者区分コード() {
        return entity.get申立者区分コード();
    }

    /**
     * 申立単位数を取得します。
     *
     * @return 申立単位数
     */
    public RString get申立単位数() {
        return entity.get申立単位数();
    }

    /**
     * 申立事由コード氏名を取得します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.get申立事由コード();
    }

    /**
     * 国保連送付年月を取得します。
     *
     * @return 国保連送付年月
     */
    public RString get国保連送付年月() {
        return entity.get国保連送付年月();
    }

    /**
     * 国保連再送付有フラグを取得します。
     *
     * @return 国保連再送付有フラグ
     */
    public RString get国保連再送付有フラグ() {
        return entity.get国保連再送付有フラグ();
    }

    /**
     * 備考を取得します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.get備考();
    }

    /**
     * 識別コードを取得します。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.get識別コード();
    }
}
