/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kyufujoho;

import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyufujoho.KyufuJohoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 総合照会_給付情報のBusinessです。
 *
 * @reamsid_L DBU-4100-040 wanghuafeng
 */
public class KyufuJohoBusiness {

    private final KyufuJohoEntity entity;

    /**
     * コンストラクタです。<br/>
     * 対象者一覧に使用します。
     *
     * @param entity KyufuJohoEntity
     */
    public KyufuJohoBusiness(KyufuJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 届出年月日を取得します。
     *
     * @return 届出年月日
     */
    public RString get届出年月日() {
        return entity.get届出年月日();
    }

    /**
     * 事業作成区分を取得します。
     *
     * @return 事業作成区分
     */
    public RString get事業作成区分() {
        return entity.get事業作成区分();
    }

    /**
     * 事業適用開始を取得します。
     *
     * @return 事業適用開始
     */
    public RString get事業適用開始() {
        return entity.get事業適用開始();
    }

    /**
     * 事業適用終了を取得します。
     *
     * @return 受給停止終了日
     */
    public RString get事業適用終了() {
        return entity.get事業適用終了();
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
     * 計画事業所番号を取得します。
     *
     * @return 計画事業所番号
     */
    public RString get計画事業所番号() {
        return entity.get計画事業所番号();
    }

    /**
     * 自己計画作成区分を取得します。
     *
     * @return 自己計画作成区分
     */
    public RString get自己計画作成区分() {
        return entity.get自己計画作成区分();
    }

    /**
     * 自己適用開始を取得します。
     *
     * @return 自己適用開始
     */
    public RString get自己適用開始() {
        return entity.get自己適用開始();
    }

    /**
     * 自己適用終了を取得します。
     *
     * @return 自己適用終了
     */
    public RString get自己適用終了() {
        return entity.get自己適用終了();
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
     * サービス分類コードを取得します。
     *
     * @return サービス分類コード
     */
    public RString getサービス分類コード() {
        return entity.getサービス分類コード();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public KaigoJigyoshaShiteiService get事業者名称() {
        return new KaigoJigyoshaShiteiService(entity.get事業者名称());
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public int get購入金額() {
        return entity.get購入金額();
    }

    /**
     * 保険請求額を取得します。
     *
     * @return 保険請求額
     */
    public int get保険請求額() {
        return entity.get保険請求額();
    }

    /**
     * 利用者負担額を取得します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.get利用者負担額();
    }

    /**
     * 利用者負担額を取得します。
     *
     * @return 利用者負担額
     */
    public int get改修費用合計() {
        return entity.get改修費用合計();
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
     * 整理番号を取得します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.get整理番号();
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
     * 様式番号を取得します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.get様式番号();
    }

    /**
     * 明細番号を取得します。
     *
     * @return 明細番号
     */
    public RString get明細番号() {
        return entity.get明細番号();
    }

    /**
     * 識別番号を取得します。
     *
     * @return 識別番号
     */
    public RString get識別番号() {
        return entity.get識別番号();
    }
}
