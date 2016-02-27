/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.param.sikakukanrenido;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 資格関連異動補助のParameterクラスです。
 */
public final class SikakuKanrenIdoParameter {

    private final HihokenshaNo hihokenshaNo;
    private final boolean isHihokenshaNo;
    private final ShikibetsuCode shikibetsuCode;
    private final FlexibleDate shikakuShutokuYMD;

    private SikakuKanrenIdoParameter(
            HihokenshaNo hihokenshaNo,
            boolean isHihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate shikakuShutokuYMD) {
        this.hihokenshaNo = hihokenshaNo;
        this.isHihokenshaNo = isHihokenshaNo;
        this.shikibetsuCode = shikibetsuCode;
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * パラメータ設定
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @param shikakuShutokuYMD 取得日
     * @return JigyoshaInputGuideParameter
     */
    public static SikakuKanrenIdoParameter createParam(
            HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate shikakuShutokuYMD) {
        boolean isHihokenshaNo = false;

        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            isHihokenshaNo = true;
        }

        return new SikakuKanrenIdoParameter(
                hihokenshaNo,
                isHihokenshaNo,
                shikibetsuCode,
                shikakuShutokuYMD);
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * isHihokenshaNoを返します。
     *
     * @return isHihokenshaNo
     */
    public boolean isIsHihokenshaNo() {
        return isHihokenshaNo;
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getshikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 取得日を返します。
     *
     * @return 取得日
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

}
