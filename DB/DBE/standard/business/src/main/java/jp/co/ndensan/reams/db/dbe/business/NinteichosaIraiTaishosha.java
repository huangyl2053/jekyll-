/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiShinseiDate;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonCode;
import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.ur.urf.definition.enumeratedtype.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼対象者のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaIraiTaishosha {

    private ShinseishoKanriNo 申請書管理番号;
    private ShichosonCode 市町村コード;
    private KaigoHihokenshaNo 被保険者番号;
    private NinteiShinseiDate 認定申請年月日;
    private NinteiShinseiKubunShinsei 認定申請区分;
    private IKojin 個人情報;
    private RString 氏名;
    private RString 住所;
    private NinteichosaItakusaki 認定調査委託先;
    private IKaigoJigyosha 事業者情報;
    private INinteiChosain 認定調査員情報;

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
     * @param 認定調査委託先 認定調査委託先
     * @param 事業者情報 事業者情報
     * @param 認定調査員情報 認定調査員情報
     * @throws NullPointerException
     * {@code 申請書管理番号}がnullの場合、{@code 市町村コード}がnullの場合、{@code 被保険者}がnullの場合、
     * {@code 認定申請年月日}がnullの場合、{@code 認定申請区分}がnullの場合、{@code 個人情報}がnullの場合、{@code 氏名}がnullの場合、または{@code 住所}がnullの場合
     */
    public NinteichosaIraiTaishosha(ShinseishoKanriNo 申請書管理番号, ShichosonCode 市町村コード, KaigoHihokenshaNo 被保険者番号,
            NinteiShinseiDate 認定申請年月日, NinteiShinseiKubunShinsei 認定申請区分, IKojin 個人情報, RString 氏名, RString 住所,
            NinteichosaItakusaki 認定調査委託先, IKaigoJigyosha 事業者情報, INinteiChosain 認定調査員情報) throws NullPointerException {

        requireNonNull(申請書管理番号, Messages.E00003.replace("申請書管理番号", "認定調査依頼対象者").getMessage());
        requireNonNull(市町村コード, Messages.E00003.replace("市町村コード", "認定調査依頼対象者").getMessage());
        requireNonNull(被保険者番号, Messages.E00003.replace("被保険者", "認定調査依頼対象者").getMessage());
        requireNonNull(認定申請年月日, Messages.E00003.replace("認定申請年月日", "認定調査依頼対象者").getMessage());
        requireNonNull(認定申請区分, Messages.E00003.replace("認定申請区分", "認定調査依頼対象者").getMessage());
        requireNonNull(個人情報, Messages.E00003.replace("個人情報", "認定調査依頼対象者").getMessage());
        requireNonNull(氏名, Messages.E00003.replace("氏名", "認定調査依頼対象者").getMessage());
        requireNonNull(住所, Messages.E00003.replace("住所", "認定調査依頼対象者").getMessage());

        this.申請書管理番号 = 申請書管理番号;
        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
        this.認定申請年月日 = 認定申請年月日;
        this.認定申請区分 = 認定申請区分;
        this.個人情報 = 個人情報;
        this.氏名 = 氏名;
        this.住所 = 住所;
        this.認定調査委託先 = 認定調査委託先;
        this.事業者情報 = 事業者情報;
        this.認定調査員情報 = 認定調査員情報;
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public ShichosonCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public KaigoHihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 認定申請年月日を取得します。
     *
     * @return 認定申請年月日
     */
    public NinteiShinseiDate get認定申請年月日() {
        return 認定申請年月日;
    }

    /**
     * 認定申請区分を取得します。
     *
     * @return 認定申請区分
     */
    public NinteiShinseiKubunShinsei get認定申請区分() {
        return 認定申請区分;
    }

    /**
     * 個人情報を取得します。
     *
     * @return 個人情報
     */
    public IKojin get個人情報() {
        return 個人情報;
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        return 氏名;
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return 住所;
    }

    /**
     * 認定調査委託先を取得します。
     *
     * @return 認定調査委託先
     */
    public NinteichosaItakusaki get認定調査委託先() {
        return 認定調査委託先;
    }

    /**
     * 事業者情報を取得します。
     *
     * @return 事業者情報
     */
    public IKaigoJigyosha get事業者情報() {
        return 事業者情報;
    }

    /**
     * 認定調査員情報を取得します。
     *
     * @return 認定調査員情報
     */
    public INinteiChosain get認定調査員情報() {
        return 認定調査員情報;
    }
}
