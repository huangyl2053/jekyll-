/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.iraijohodatatorikomi;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.iraijohodatatorikomi.NinteiShinseiJohoRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 依頼情報データ受取（オルカ）のクラスです。
 *
 * @reamsid_L DBE-1600-010 lishengli
 */
public class NinteiShinseiJohoIraiJohoData {

    private final NinteiShinseiJohoRelateEntity relateEntity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link NinteiShinseiJohoRelateEntity}より{@link NinteiShinseiJohoIraiJohoData}を生成します。
     *
     * @param relateEntity DBより取得した{@link NinteiShinseiJohoRelateEntity}
     */
    public NinteiShinseiJohoIraiJohoData(NinteiShinseiJohoRelateEntity relateEntity) {
        this.relateEntity = relateEntity;
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public RString get保険者番号() {
        return relateEntity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return relateEntity.getHihokenshaNo();
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public RString get認定申請年月日() {
        if (relateEntity.getNinteiShinseiYMD() != null && !relateEntity.getNinteiShinseiYMD().isEmpty()) {
            return new RString(relateEntity.getNinteiShinseiYMD().toString());
        }
        return RString.EMPTY;
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        if (relateEntity.getHihokenshaName() != null && !relateEntity.getHihokenshaName().isEmpty()) {
            return relateEntity.getHihokenshaName().value();
        }
        return RString.EMPTY;
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        if (relateEntity.getSeinengappiYMD() != null && !relateEntity.getSeinengappiYMD().isEmpty()) {
            return new RString(relateEntity.getSeinengappiYMD().toString());
        }
        return RString.EMPTY;
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        if (relateEntity.getSeibetsu() != null && !relateEntity.getSeibetsu().isEmpty()) {
            return Seibetsu.toValue(relateEntity.getSeibetsu().value()).get名称();
        }
        return RString.EMPTY;
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        if (relateEntity.getYubinNo() != null && !relateEntity.getYubinNo().isEmpty()) {
            return relateEntity.getYubinNo().getEditedYubinNo();
        }
        return RString.EMPTY;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        if (relateEntity.getJusho() != null && !relateEntity.getJusho().isEmpty()) {
            return relateEntity.getJusho().value();
        }
        return RString.EMPTY;
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return relateEntity.getIryoKikanMeisho();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return relateEntity.getShujiiName();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        if (relateEntity.getShinseishoKanriNo() != null && !relateEntity.getShinseishoKanriNo().isEmpty()) {
            return relateEntity.getShinseishoKanriNo().value();
        }
        return RString.EMPTY;
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 主治医氏名
     */
    public RString get厚労省IF識別コード() {
        if (relateEntity.getKoroshoIfShikibetsuCode() != null && !relateEntity.getKoroshoIfShikibetsuCode().isEmpty()) {
            return relateEntity.getKoroshoIfShikibetsuCode().value();
        }
        return RString.EMPTY;
    }
}
