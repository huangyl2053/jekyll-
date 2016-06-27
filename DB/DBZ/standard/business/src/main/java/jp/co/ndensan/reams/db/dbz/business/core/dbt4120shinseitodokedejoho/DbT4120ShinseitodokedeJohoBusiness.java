/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.dbt4120shinseitodokedejoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請届出情報クラスです。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public class DbT4120ShinseitodokedeJohoBusiness {

    private final DbT4120ShinseitodokedeJohoEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 申請履歴情報Entity
     */
    public DbT4120ShinseitodokedeJohoBusiness(DbT4120ShinseitodokedeJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 申請届出代行区分コードを取得します。
     *
     * @return 申請届出代行区分コード
     */
    public Code get申請届出代行区分コード() {
        return entity.getShinseiTodokedeDaikoKubunCode();
    }

    /**
     * 申請届出者氏名を取得します。
     *
     * @return 申請届出者氏名
     */
    public RString get申請届出者氏名() {
        return entity.getShinseiTodokedeshaShimei();
    }

    /**
     * 申請届出者氏名カナを取得します。
     *
     * @return 申請届出者氏名カナ
     */
    public RString get申請届出者氏名カナ() {
        return entity.getShinseiTodokedeshaKanaShimei();
    }

    /**
     * 申請届出者続柄を取得します。
     *
     * @return 申請届出者続柄
     */
    public RString get申請届出者続柄() {
        return entity.getShinseiTodokedeshaTsuzukigara();
    }

    /**
     * 申請届出代行事業者番号を取得します。
     *
     * @return 申請届出代行事業者番号
     */
    public JigyoshaNo get申請届出代行事業者番号() {
        return entity.getShinseiTodokedeDaikoJigyoshaNo();
    }

    /**
     * 事業者区分を取得します。
     *
     * @return 事業者区分
     */
    public RString get事業者区分() {
        return entity.getJigyoshaKubun();
    }

    /**
     * 申請届出者郵便番号を取得します。
     *
     * @return 申請届出者郵便番号
     */
    public YubinNo get申請届出者郵便番号() {
        return entity.getShinseiTodokedeshaYubinNo();
    }

    /**
     * 申請届出者住所を取得します。
     *
     * @return 申請届出者住所
     */
    public RString get申請届出者住所() {
        return entity.getShinseiTodokedeshaJusho();
    }

    /**
     * 申請届出者電話番号を取得します。
     *
     * @return 申請届出者電話番号
     */
    public TelNo get申請届出者電話番号() {
        return entity.getShinseiTodokedeshaTelNo();
    }
}
