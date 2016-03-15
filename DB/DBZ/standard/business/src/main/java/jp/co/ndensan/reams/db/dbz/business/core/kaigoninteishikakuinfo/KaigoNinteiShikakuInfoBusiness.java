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
        return dbt1001entity.getHihokenshaNo();
    }

    /**
     * 資格取得年月日を返します。
     *
     * @return 資格取得年月日
     */
    public FlexibleDate get資格取得年月日() {
        return dbt1001entity.getShikakuShutokuYMD();
    }

    /**
     * 資格取得事由コードを返します。
     *
     * @return 資格取得事由コード
     */
    public RString get資格取得事由コード() {
        return dbt1001entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return dbt1001entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return 資格喪失事由コード
     */
    public RString get資格喪失事由コード() {
        return dbt1001entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 住所地特例フラグを返します。
     *
     * @return 住所地特例フラグ
     */
    public RString get住所地特例フラグ() {
        return dbt1001entity.getJushochiTokureiFlag();
    }

    /**
     * 要介護認定状態区分コードを返します。
     *
     * @return 要介護認定状態区分コード
     */
    public Code get要介護認定状態区分コード() {
        return dbt4001entity.getYokaigoJotaiKubunCode();
    }

    /**
     * 認定有効期間開始年月日を返します。
     *
     * @return 認定有効期間開始年月日
     */
    public FlexibleDate get認定有効期間開始年月日() {
        return dbt4001entity.getNinteiYukoKikanKaishiYMD();
    }

    /**
     * 認定有効期間終了年月日を返します。
     *
     * @return 認定有効期間終了年月日
     */
    public FlexibleDate get認定有効期間終了年月日() {
        return dbt4001entity.getNinteiYukoKikanShuryoYMD();
    }

}
