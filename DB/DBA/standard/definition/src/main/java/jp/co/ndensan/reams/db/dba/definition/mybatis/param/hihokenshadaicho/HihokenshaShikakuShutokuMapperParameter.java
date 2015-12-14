/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaicho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 被保険者台帳管理のパラメータです
 */
public final class HihokenshaShikakuShutokuMapperParameter {

    private final HihokenshaNo hihokenshaNo;
    private final boolean isHihokenshaNoAri;
    private final boolean isHihokenshaNoNasi;
    private final FlexibleDate idoYMD;
    private final RString edaNo;
    private final ShikibetsuCode shikibetsuCode;

    /**
     * 非公開コンストラクタです。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @param idoYMD 異動日
     * @param edaNo 枝番
     */
    private HihokenshaShikakuShutokuMapperParameter(
            HihokenshaNo hihokenshaNo,
            boolean isHihokenshaNoAri,
            boolean isHihokenshaNoNasi,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate idoYMD,
            RString edaNo
    ) {
        this.hihokenshaNo = requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        this.isHihokenshaNoAri = requireNonNull(isHihokenshaNoAri, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号ある"));
        this.isHihokenshaNoNasi = requireNonNull(isHihokenshaNoNasi, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号なし"));
        this.shikibetsuCode = requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        this.idoYMD = requireNonNull(idoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        this.edaNo = requireNonNull(edaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
    }

    /**
     * 共通パラメータ設定。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @param idoYMD 異動日
     * @param edaNo 枝番
     * @return HihokenshaShikakuShutokuMapperParameter
     */
    public static HihokenshaShikakuShutokuMapperParameter createParam_common(
            HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode,
            FlexibleDate idoYMD,
            RString edaNo) {
        boolean hihokenshaNoTflg = false;
        boolean hihokenshaNoFflg = false;
        if (hihokenshaNo.isEmpty()) {
            hihokenshaNoFflg = true;
        } else {
            hihokenshaNoTflg = true;
        }
        return new HihokenshaShikakuShutokuMapperParameter(
                hihokenshaNo,
                hihokenshaNoTflg,
                hihokenshaNoFflg,
                shikibetsuCode,
                idoYMD,
                edaNo
        );

    }

    /**
     * 被保険者台帳管理（資格取得）情報用のパラメータを生成します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     * @return 被保険者台帳管理（資格取得）被保険者台帳管理のパラメータ
     */
    public static HihokenshaShikakuShutokuMapperParameter createParam_HokenshaDaicho(
            HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode) {
        return createParam_common(
                hihokenshaNo,
                shikibetsuCode,
                FlexibleDate.MAX,
                RString.EMPTY
        );
    }

    /**
     * 最大枝番を取得用のパラメータを生成します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param idoYMD 異動日
     * @return 被保険者台帳管理のパラメータ
     */
    public static HihokenshaShikakuShutokuMapperParameter createParam_HokenshaEdaban(
            HihokenshaNo hihokenshaNo,
            FlexibleDate idoYMD) {
        return createParam_common(
                hihokenshaNo,
                ShikibetsuCode.EMPTY,
                idoYMD,
                RString.EMPTY
        );
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
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 被保険者番号ありフラグを返します。
     *
     * @return 被保険者番号ありフラグ
     */
    public boolean isHihokenshaNoTflg() {
        return isHihokenshaNoAri;
    }

    /**
     * 被保険者番号なしフラグを返します。
     *
     * @return 被保険者番号なしフラグ
     */
    public boolean isHihokenshaNoFflg() {
        return isHihokenshaNoNasi;
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public RString getEdaNo() {
        return edaNo;
    }

}
