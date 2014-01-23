/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 要介護認定申請取下げ対象者を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiTorisageTaishosha {

    private final ShinseishoKanriNo 申請書管理No;
    private final ShichosonCode 市町村コード;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 認定申請年月日;
    private final RString 認定申請区分コード_申請時;
    private final NinteiShinseiTorisage 認定申請取下げ;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 申請書管理No 申請書管理No
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 認定申請年月日 認定申請年月日
     * @param 認定申請区分コード_申請時 認定申請区分（申請時）コード
     * @param 認定申請取下げ 認定申請取下げ
     */
    public NinteiShinseiTorisageTaishosha(ShinseishoKanriNo 申請書管理No, ShichosonCode 市町村コード, HihokenshaNo 被保険者番号,
            FlexibleDate 認定申請年月日, RString 認定申請区分コード_申請時, NinteiShinseiTorisage 認定申請取下げ) {
        requireNonNull(申請書管理No);
        requireNonNull(市町村コード);
        requireNonNull(被保険者番号);
        requireNonNull(認定申請年月日);
        requireNonNull(認定申請区分コード_申請時);
        requireNonNull(認定申請取下げ);

        this.申請書管理No = 申請書管理No;
        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
        this.認定申請年月日 = 認定申請年月日;
        this.認定申請区分コード_申請時 = 認定申請区分コード_申請時;
        this.認定申請取下げ = 認定申請取下げ;
    }

    /**
     * 申請書管理Noを返します。
     *
     * @return 申請書管理No
     */
    public ShinseishoKanriNo get申請書管理No() {
        return 申請書管理No;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public ShichosonCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 認定申請年月日を返します。
     *
     * @return 認定申請年月日
     */
    public FlexibleDate get認定申請年月日() {
        return 認定申請年月日;
    }

    /**
     * 認定申請区分（申請時）コードを返します。
     *
     * @return 認定申請区分（申請時）コード
     */
    public RString get認定申請区分コード_申請時() {
        return 認定申請区分コード_申請時;
    }

    /**
     * 認定申請取下げの情報を返します。
     *
     * @return 認定申請取下げ
     */
    public NinteiShinseiTorisage get認定申請取下げ() {
        return 認定申請取下げ;
    }
}
