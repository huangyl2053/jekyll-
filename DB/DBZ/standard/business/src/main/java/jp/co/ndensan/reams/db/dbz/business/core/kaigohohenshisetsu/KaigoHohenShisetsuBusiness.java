/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kaigohohenshisetsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kaigohohenshisetsu.KaigoHohenShisetsuRelateEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 施設情報取得Businessクラスです。
 */
public class KaigoHohenShisetsuBusiness {

    private final KaigoHohenShisetsuRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity KaigoHohenShisetsuRelateEntity
     */
    public KaigoHohenShisetsuBusiness(KaigoHohenShisetsuRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 台帳種別のgetメソッドです。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return entity.getDaichoShubetsu();
    }

    /**
     * 入所施設種類のgetメソッドです。
     *
     * @return 入所施設種類
     */
    public RString get入所施設種類() {
        return entity.getNyushoShisetsuShurui();
    }

    /**
     * 入所施設コードのgetメソッドです。
     *
     * @return 入所施設コード
     */
    public JigyoshaNo get入所施設コード() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 入所処理年月日のgetメソッドです。
     *
     * @return 入所処理年月日
     */
    public FlexibleDate get入所処理年月日() {
        return entity.getNyushoShoriYMD();
    }

    /**
     * 入所年月日のgetメソッドです。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所処理年月日のgetメソッドです。
     *
     * @return 退所処理年月日
     */
    public FlexibleDate get退所処理年月日() {
        return entity.getTaishoShoriYMD();
    }

    /**
     * 退所年月日のgetメソッドです。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 部屋記号番号のgetメソッドです。
     *
     * @return 部屋記号番号
     */
    public RString get部屋記号番号() {
        return entity.getRoomKigoNo();
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaName();
    }

    /**
     * 保険者番号のgetメソッドです。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }
}
