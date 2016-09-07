/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.jyukyusyajoho;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.jyukyusyajoho.JukyuNinteiJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_受給認定情報Businessです。
 *
 * @reamsid_L DBU-4100-030 xuyannan
 */
public class JukyuNinteiJohoBusiness {

    private final JukyuNinteiJohoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 総合照会_受給認定情報Entity
     */
    public JukyuNinteiJohoBusiness(JukyuNinteiJohoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定状態区分コードを返します。
     *
     * @return 要介護認定状態区分コード
     */
    public RString get要介護認定状態区分コード() {
        return entity.get要介護認定状態区分コード();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public RString get認定有効期間開始年月日() {
        return entity.get認定有効期間開始年月日();
    }

    /**
     * 受給申請年月日を返します。
     *
     * @return 受給申請年月日
     */
    public RString get受給申請年月日() {
        return entity.get受給申請年月日();
    }

    /**
     * 受給申請事由を返します。
     *
     * @return 受給申請事由
     */
    public RString get受給申請事由() {
        return entity.get受給申請事由();
    }

    /**
     * 旧措置者フラグを返します。
     *
     * @return 旧措置者フラグ
     */
    public boolean is旧措置者フラグ() {
        return entity.is旧措置者フラグ();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public RString get認定有効期間終了年月日() {
        return entity.get認定有効期間終了年月日();
    }

    /**
     * 認定年月日を返します。
     *
     * @return 認定年月日
     */
    public RString get認定年月日() {
        return entity.get認定年月日();
    }

    /**
     * データ区分を返します。
     *
     * @return データ区分
     */
    public RString getデータ区分() {
        return entity.getデータ区分();
    }

    /**
     * 認定申請区分_申請時コードを返します。
     *
     * @return 認定申請区分_申請時コード
     */
    public RString get認定申請区分_申請時コード() {
        return entity.get認定申請区分_申請時コード();
    }

    /**
     * 認定申請区分_法令コードを返します。
     *
     * @return 認定申請区分_法令コード
     */
    public RString get認定申請区分_法令コード() {
        return entity.get認定申請区分_法令コード();
    }
}
