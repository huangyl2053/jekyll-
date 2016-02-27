/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanshinseiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshinseiichiran.ShokanShinseiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払支給申請リストを取得するクラスです。
 *
 */
public class ShokanShinseiIchiran {

    private final ShokanShinseiIchiranRelateEntity relateEntity;

    /**
     * コンストラクタです。
     *
     * @param relateEntity ShokanShinseiIchiranRelateEntity
     */
    public ShokanShinseiIchiran(ShokanShinseiIchiranRelateEntity relateEntity) {
        this.relateEntity = relateEntity;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return relateEntity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス年月() {
        return relateEntity.getServiceTeikyoYM();
    }

    /**
     * 整理番号を取得します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return relateEntity.getSeiriNo();
    }

    /**
     * 申請年月日を取得します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return relateEntity.getShinseiYMD();
    }

    /**
     * 送付年月を取得します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return relateEntity.getSofuYM();
    }

    /**
     * 様式番号を取得します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return relateEntity.getYoshikiNo();
    }

    /**
     * 決定年月日を取得します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return relateEntity.getKetteiYMD();
    }

    /**
     * サービス提供年月Fromを取得します。
     *
     * @return サービス提供年月From
     */
    public FlexibleYearMonth サービス提供年月From() {
        return relateEntity.getサービス提供年月From();
    }

    /**
     * サービス提供年月Toを取得します。
     *
     * @return サービス提供年月To
     */
    public FlexibleYearMonth サービス提供年月To() {
        return relateEntity.getサービス提供年月To();
    }
}
