/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.core.rorenfukushinenkinjohokanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 老齢福祉年金受給者台帳管理パラメタクラスです。
 *
 */
public class RorenFukushiNenkinJohoKanriParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final HihokenshaNo hihokenshaNo;
    private final FlexibleDate jukyuKaishiYMD;
    private final FlexibleDate jukyuShuryoYMD;

    private RorenFukushiNenkinJohoKanriParameter(
            ShikibetsuCode shikibetsuCode,
            FlexibleDate jukyuKaishiYMD,
            HihokenshaNo hihokenshaNo,
            FlexibleDate jukyuShuryoYMD
    ) {
        this.shikibetsuCode = shikibetsuCode;
        this.jukyuKaishiYMD = jukyuKaishiYMD;
        this.hihokenshaNo = hihokenshaNo;
        this.jukyuShuryoYMD = jukyuShuryoYMD;
    }

    /**
     * 老齢福祉年金受給者台帳管理取得処理のパラメータです。
     *
     * @param shikibetsuCode 識別コード
     * @param jukyuKaishiYMD 受給開始年月日
     * @param hihokenshaNo 被保険者番号
     * @param jukyuShuryoYMD 受給終了年月日
     * @return RoreiFukushiNenkinJohoMapperParameter 老齢福祉年金受給者台帳管理情報パラメータ
     */
    public static RorenFukushiNenkinJohoKanriParameter createParam_RoreiFukushi(
            ShikibetsuCode shikibetsuCode,
            FlexibleDate jukyuKaishiYMD,
            HihokenshaNo hihokenshaNo,
            FlexibleDate jukyuShuryoYMD
    ) {
        return new RorenFukushiNenkinJohoKanriParameter(
                shikibetsuCode,
                jukyuKaishiYMD,
                hihokenshaNo,
                jukyuShuryoYMD);
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 受給開始年月日を返します。
     *
     * @return 受給開始年月日
     */
    public FlexibleDate getJukyuKaishiYMD() {
        return jukyuKaishiYMD;
    }

    /**
     * 受給終了年月日を返します。
     *
     * @return 受給終了年月日
     */
    public FlexibleDate getJukyuShuryoYMD() {
        return jukyuShuryoYMD;
    }
}
