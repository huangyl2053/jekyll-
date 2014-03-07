/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.IDoctor;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼対象者のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiTaishosha {

    private final ShinseishoKanriNo 申請書管理番号;
    private final ShichosonCode 市町村コード;
    private final KaigoHihokenshaNo 被保険者番号;
    private final FlexibleDate 認定申請年月日;
    private final NinteiShinseiKubunShinsei 認定申請区分;
    private final IKojin 個人情報;
    private final RString 氏名;
    private final RString 住所;
    private final KaigoIryoKikan 主治医医療機関;
    // TODO N8187 久保田英男 主治医は業務クラス(KaigoDoctor)を作成するか検討する。クラスが作成されたら修正を行う。 2014/3月末まで
    private final IDoctor 主治医;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     * @param 認定申請年月日 認定申請年月日
     * @param 認定申請区分 認定申請区分
     * @param 個人情報 個人情報
     * @param 氏名 氏名
     * @param 住所 住所
     * @param 主治医医療機関 主治医医療機関
     * @param 主治医 主治医
     * @throws NullPointerException
     * {@code 申請書管理番号}がnullの場合、{@code 市町村コード}がnullの場合、{@code 被保険者番号}がnullの場合、
     * {@code 認定申請年月日}がnullの場合、{@code 認定申請区分}がnullの場合、{@code 個人情報}がnullの場合、{@code 氏名}がnullの場合
     * または{@code 住所}がnullの場合
     */
    public ShujiiIkenshoIraiTaishosha(
            ShinseishoKanriNo 申請書管理番号,
            ShichosonCode 市町村コード,
            KaigoHihokenshaNo 被保険者番号,
            FlexibleDate 認定申請年月日,
            NinteiShinseiKubunShinsei 認定申請区分,
            IKojin 個人情報,
            RString 氏名,
            RString 住所,
            KaigoIryoKikan 主治医医療機関,
            IDoctor 主治医) throws NullPointerException {

        requireNonNull(申請書管理番号, Messages.E00003.replace("申請書管理番号", "主治医意見書作成依頼対象者").getMessage());
        requireNonNull(市町村コード, Messages.E00003.replace("市町村コード", "主治医意見書作成依頼対象者").getMessage());
        requireNonNull(被保険者番号, Messages.E00003.replace("被保険者番号", "主治医意見書作成依頼対象者").getMessage());
        requireNonNull(認定申請年月日, Messages.E00003.replace("認定申請年月日", "主治医意見書作成依頼対象者").getMessage());
        requireNonNull(認定申請区分, Messages.E00003.replace("認定申請区分", "主治医意見書作成依頼対象者").getMessage());
        requireNonNull(個人情報, Messages.E00003.replace("個人情報", "主治医意見書作成依頼対象者").getMessage());
        requireNonNull(氏名, Messages.E00003.replace("氏名", "主治医意見書作成依頼対象者").getMessage());
        requireNonNull(住所, Messages.E00003.replace("住所", "主治医意見書作成依頼対象者").getMessage());

        this.申請書管理番号 = 申請書管理番号;
        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
        this.認定申請年月日 = 認定申請年月日;
        this.認定申請区分 = 認定申請区分;
        this.個人情報 = 個人情報;
        this.氏名 = 氏名;
        this.住所 = 住所;
        this.主治医医療機関 = 主治医医療機関;
        this.主治医 = 主治医;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
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
     * 認定申請区分を返します。
     *
     * @return 認定申請区分
     */
    public NinteiShinseiKubunShinsei get認定申請区分() {
        return 認定申請区分;
    }

    /**
     * 個人情報を返します。
     *
     * @return 個人情報
     */
    public IKojin get個人情報() {
        return 個人情報;
    }

    /**
     * 氏名を返します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return 氏名;
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * 主治医医療機関を返します。
     *
     * @return 主治医医療機関
     */
    public KaigoIryoKikan get主治医医療機関() {
        return 主治医医療機関;
    }

    /**
     * 主治医を返します。
     *
     * @return 主治医
     */
    public IDoctor get主治医() {
        return 主治医;
    }
}
