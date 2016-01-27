package jp.co.ndensan.reams.db.dbu.definition.core.roujinhokenjukyushadaichokanri;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老人保健受給者台帳管理パラメタクラスです。
 *
 */
public final class RoujinHokenJukyushaDaichoKanriMapperParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final LasdecCode shichosonCode;
    private final HihokenshaNo hihokenshaNo;
    private final LasdecCode rojinHokenShichosonCode;
    private final RString rojinHokenJukyushaNo;

    private RoujinHokenJukyushaDaichoKanriMapperParameter(
            ShikibetsuCode shikibetsuCode,
            LasdecCode shichosonCode,
            HihokenshaNo hihokenshaNo,
            LasdecCode rojinHokenShichosonCode,
            RString rojinHokenJukyushaNo) {
        this.shikibetsuCode = shikibetsuCode;
        this.shichosonCode = shichosonCode;
        this.hihokenshaNo = hihokenshaNo;
        this.rojinHokenShichosonCode = rojinHokenShichosonCode;
        this.rojinHokenJukyushaNo = rojinHokenJukyushaNo;
    }

    /**
     * 老人保健受給者台帳管理取得処理のパラメータです。
     *
     * @param shikibetsuCode 識別コード
     * @param rojinHokenJukyushaNo 老人保健受給者番号
     * @param shichosonCode 市町村コード
     * @param rojinHokenShichosonCode 老人保健市町村コード
     * @param hihokenshaNo 被保険者番号
     * @return RoujinHokenJukyushaDaichoKanriMapperParameter 老人保健受給者台帳管理情報パラメータ
     */
    public static RoujinHokenJukyushaDaichoKanriMapperParameter createParam_RoujinHoken(
            ShikibetsuCode shikibetsuCode,
            LasdecCode shichosonCode,
            HihokenshaNo hihokenshaNo,
            LasdecCode rojinHokenShichosonCode,
            RString rojinHokenJukyushaNo) {
        return new RoujinHokenJukyushaDaichoKanriMapperParameter(
                shikibetsuCode,
                shichosonCode,
                hihokenshaNo,
                rojinHokenShichosonCode,
                rojinHokenJukyushaNo
        );
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
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
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
     * 老人保健市町村コードを返します。
     *
     * @return 老人保健市町村コード
     */
    public LasdecCode getRojinHokenShichosonCode() {
        return rojinHokenShichosonCode;
    }

    /**
     * 老人保健受給者番号を返します。
     *
     * @return 老人保健受給者番号
     */
    public RString getRojinHokenJukyushaNo() {
        return rojinHokenJukyushaNo;
    }
}
