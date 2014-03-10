/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定申請取下げ対象者を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiTorisageTaishosha {

    private final ShinseishoKanriNo 申請書管理No;
    private final ShichosonCode 市町村コード;
    private final KaigoHihokenshaNo 被保険者番号;
    private final FlexibleDate 認定申請年月日;
    //TODO n8178 城間篤人
    //今後、独自クラスとして認定申請区分コード_申請時を作成予定。作成後修正を行う 2014年2月末
    private final NinteiShinseiKubunShinsei 認定申請区分コード_申請時;
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
    public NinteiShinseiTorisageTaishosha(ShinseishoKanriNo 申請書管理No, ShichosonCode 市町村コード, KaigoHihokenshaNo 被保険者番号,
            FlexibleDate 認定申請年月日, NinteiShinseiKubunShinsei 認定申請区分コード_申請時, NinteiShinseiTorisage 認定申請取下げ) {

        requireNonNull(申請書管理No, Messages.E00003.replace("申請書管理No", getClass().getName()).getMessage());
        requireNonNull(市町村コード, Messages.E00003.replace("市町村コード", getClass().getName()).getMessage());
        requireNonNull(被保険者番号, Messages.E00003.replace("被保険者番号", getClass().getName()).getMessage());
        requireNonNull(認定申請年月日, Messages.E00003.replace("認定申請年月日", getClass().getName()).getMessage());
        requireNonNull(認定申請区分コード_申請時, Messages.E00003.replace("認定申請区分コード(申請時)", getClass().getName()).getMessage());
        requireNonNull(認定申請取下げ, Messages.E00003.replace("認定申請取下げ", getClass().getName()).getMessage());

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
    public KaigoHihokenshaNo get被保険者番号() {
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
    public NinteiShinseiKubunShinsei get認定申請区分コード_申請時() {
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
