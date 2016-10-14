/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shinchokudataoutputeuccsv;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.niinteichosajoho.ShinchokuDataOutputEucCsvEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBE491001_日次進捗データ作成ですためのBatch用CSVBusinessクラスです。
 *
 * @reamsid_L DBD-1510-010 liuyl
 */
public class ShinchokuDataOutputEucCsvBusiness {

    private ShinchokuDataOutputEucCsvEntity csvEntity;

    /**
     * コンストラクタです。
     *
     * @param csvEntity ShinchokuDataOutputEucCsvEntity
     */
    public ShinchokuDataOutputEucCsvBusiness(ShinchokuDataOutputEucCsvEntity csvEntity) {
        this.csvEntity = csvEntity;
    }

    /**
     * 被保険者区分コードを返します。
     *
     * @return RString
     */
    public RString get被保険者区分コード() {
        return csvEntity.get被保険者区分コード();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return RString
     */
    public RString get被保険者番号() {
        return csvEntity.get被保険者番号();
    }

    /**
     * 保険者番号を返します。
     *
     * @return RString
     */
    public RString get保険者番号() {
        return csvEntity.get保険者番号();
    }

    /**
     * 住所を返します。
     *
     * @return RString
     */
    public RString get住所() {
        return csvEntity.get住所();
    }

    /**
     * 年齢を返します。
     *
     * @return RString
     */
    public RString get年齢() {
        return csvEntity.get年齢();
    }

    /**
     * 認定申請日を返します。
     *
     * @return RString
     */
    public RString get認定申請日() {
        return csvEntity.get認定申請日();
    }

    /**
     * 性別コードを返します。
     *
     * @return RString
     */
    public RString get性別コード() {
        return csvEntity.get性別コード();
    }

    /**
     * 生年月日を返します。
     *
     * @return RString
     */
    public RString get生年月日() {
        return csvEntity.get生年月日();
    }

    /**
     * 識別コードを返します。
     *
     * @return RString
     */
    public RString get識別コード() {
        return csvEntity.get識別コード();
    }

    /**
     * 被保険者漢字氏名を返します。
     *
     * @return RString
     */
    public RString get被保険者漢字氏名() {
        return csvEntity.get被保険者漢字氏名();
    }

    /**
     * 申請区分申請時コードを返します。
     *
     * @return RString
     */
    public RString get申請区分申請時コード() {
        return csvEntity.get申請区分申請時コード();
    }
}
