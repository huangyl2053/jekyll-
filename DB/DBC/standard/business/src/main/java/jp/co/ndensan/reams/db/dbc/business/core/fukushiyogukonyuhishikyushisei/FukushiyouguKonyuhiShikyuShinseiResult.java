/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.fukushiyogukonyuhishikyushisei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支給申請一覧取得RelateEntity結果
 */
public class FukushiyouguKonyuhiShikyuShinseiResult implements Serializable {

    private final FukushiyouguKonyuhiShikyuShinsei entity;

    /**
     * コンストラクタです。
     *
     * @param entity 支給申請一覧取得RelateEntity
     */
    public FukushiyouguKonyuhiShikyuShinseiResult(FukushiyouguKonyuhiShikyuShinsei entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を取得する。
     *
     * @return HihokenshaNo 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return this.entity.get被保険者番号();
    }

    /**
     * サービス提供年月を取得する。
     *
     * @return FlexibleYearMonth サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return this.entity.getサービス提供年月();
    }

    /**
     * 整理番号を取得する。
     *
     * @return RString 整理番号
     */
    public RString get整理番号() {
        return this.entity.get整理番号();
    }

    /**
     * 事業者番号を取得する。
     *
     * @return JigyoshaNo 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return this.entity.get事業者番号();
    }

    /**
     * 様式番号を取得する。
     *
     * @return RString 様式番号
     */
    public RString get様式番号() {
        return this.entity.get様式番号();
    }

    /**
     * 明細番号を取得する。
     *
     * @return RString 明細番号
     */
    public RString get明細番号() {
        return this.entity.get明細番号();
    }

    /**
     * 申請年月日を取得する。
     *
     * @return FlexibleDate 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return this.entity.get申請年月日();
    }

    /**
     * 支給_不支給決定区分を取得する。
     *
     * @return RString 支給_不支給決定区分
     */
    public RString get支給_不支給決定区分() {
        return this.entity.get支給_不支給決定区分();
    }

    /**
     * 決定日を取得する。
     *
     * @return FlexibleDate 決定日
     */
    public FlexibleDate get決定日() {
        return this.entity.get決定日();
    }

    /**
     * 商品名を取得する。
     *
     * @return RString 商品名
     */
    public RString get商品名() {
        return this.entity.get商品名();
    }

    /**
     * 購入金額合計を取得する。
     *
     * @return Decimal 購入金額合計
     */
    public Decimal get購入金額合計() {
        return this.entity.get購入金額合計();
    }
}
