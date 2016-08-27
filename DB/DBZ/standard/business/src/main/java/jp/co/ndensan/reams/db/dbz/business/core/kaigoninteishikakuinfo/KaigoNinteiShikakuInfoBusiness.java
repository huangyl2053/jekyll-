/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kaigoninteishikakuinfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定資格情報を取得クラスです。
 *
 * @reamsid_L DBZ-1300-060 lizhuoxuan
 */
public class KaigoNinteiShikakuInfoBusiness {

    private final DbT4001JukyushaDaichoEntity dbt4001entity;
    private final DbT1001HihokenshaDaichoEntity dbt1001entity;

    /**
     * 介護認定資格情報項目を返します。
     *
     * @param dbt4001entity DbT4001JukyushaDaichoEntity
     * @param dbt1001entity DbT1001HihokenshaDaichoEntity
     */
    public KaigoNinteiShikakuInfoBusiness(DbT4001JukyushaDaichoEntity dbt4001entity,
            DbT1001HihokenshaDaichoEntity dbt1001entity) {
        this.dbt4001entity = dbt4001entity;
        this.dbt1001entity = dbt1001entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        if (dbt1001entity != null) {
            return dbt1001entity.getHihokenshaNo();
        }
        return HihokenshaNo.EMPTY;
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        if (dbt1001entity != null) {
            return dbt1001entity.getShikakuShutokuYMD();
        }
        return null;
    }

    /**
     * 資格取得事由コードを返します。
     *
     * @return 資格取得事由コード
     */
    public RString get資格取得事由コード() {
        if (dbt1001entity != null) {
            return dbt1001entity.getShikakuShutokuJiyuCode();
        }
        return null;
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        if (dbt1001entity != null) {
            return dbt1001entity.getShikakuSoshitsuYMD();
        }
        return null;
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        if (dbt1001entity != null) {
            return dbt1001entity.getShikakuSoshitsuJiyuCode();
        }
        return null;
    }

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        if (dbt1001entity != null) {
            return dbt1001entity.getJushochiTokureiFlag();
        }
        return RString.EMPTY;
    }

    /**
     * 要介護認定状態区分コードを返します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        if (dbt4001entity != null) {
            return dbt4001entity.getYokaigoJotaiKubunCode();
        }
        return null;
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        if (dbt4001entity != null) {
            return dbt4001entity.getNinteiYukoKikanKaishiYMD();
        }
        return null;
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        if (dbt4001entity != null) {
            return dbt4001entity.getNinteiYukoKikanShuryoYMD();
        }
        return null;
    }

}
