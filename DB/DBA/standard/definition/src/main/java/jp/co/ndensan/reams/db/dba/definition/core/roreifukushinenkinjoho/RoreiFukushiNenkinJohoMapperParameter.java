/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.roreifukushinenkinjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * MyBatis用パラメータクラスです。
 */
public final class RoreiFukushiNenkinJohoMapperParameter {

    /**
     * 老齢福祉年金情報パラメータです。
     *
     */
    private final ShikibetsuCode shikibetsuCode;
    private final HihokenshaNo hihokenshaNo;
    private final FlexibleDate jukyuKaishiYMD;
    private final FlexibleDate jukyuShuryoYMD;

    /**
     * 老齢福祉年金情報取得処理のパラメータです。
     *
     * @param shikibetsuCode 識別コード
     * @param jukyuKaishiYMD 受給開始年月日
     * @param hihokenshaNo 被保険者番号
     * @param jukyuShuryoYMD 受給終了年月日
     */
    private RoreiFukushiNenkinJohoMapperParameter(
            ShikibetsuCode shikibetsuCode,
            FlexibleDate jukyuKaishiYMD,
            HihokenshaNo hihokenshaNo,
            FlexibleDate jukyuShuryoYMD) {
        this.shikibetsuCode = requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.jukyuKaishiYMD = requireNonNull(jukyuKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("受給開始年月日"));
        this.hihokenshaNo = hihokenshaNo;
        this.jukyuShuryoYMD = jukyuShuryoYMD;
    }

    /**
     * 老齢福祉年金情報取得処理のパラメータです。
     *
     * @param shikibetsuCode 識別コード
     * @param jukyuKaishiYMD 受給開始年月日
     * @param hihokenshaNo 被保険者番号
     * @param jukyuShuryoYMD 受給終了年月日
     * @return RoreiFukushiNenkinJohoMapperParameter 老齢福祉年金情報パラメータ
     */
    public static RoreiFukushiNenkinJohoMapperParameter createRoreiFukushiParam(
            ShikibetsuCode shikibetsuCode,
            FlexibleDate jukyuKaishiYMD,
            HihokenshaNo hihokenshaNo,
            FlexibleDate jukyuShuryoYMD) {
        return new RoreiFukushiNenkinJohoMapperParameter(
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
