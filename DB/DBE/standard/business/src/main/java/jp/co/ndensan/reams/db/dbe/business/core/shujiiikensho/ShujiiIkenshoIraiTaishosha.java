/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikensho;

import jp.co.ndensan.reams.db.dbe.business.core.kaigoiryokikan.KaigoIryoKikan;
import jp.co.ndensan.reams.db.dbe.business.core.kaigodoctor.KaigoDoctor;
import jp.co.ndensan.reams.db.dbe.business.core.YokaigoNintei.YokaigoNinteiProgress;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼対象者のクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShujiiIkenshoIraiTaishosha {

    private final YokaigoNinteiProgress 認定進捗情報;
    private final ShinseishoKanriNo 申請書管理番号;
    private final ShoKisaiHokenshaNo 証記載保険者番号;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleDate 認定申請年月日;
    private final Code 認定申請区分;
    private final IKojin 個人情報;
    private final RString 氏名;
    private final RString 住所;
    private final KaigoIryoKikan 主治医医療機関;
    private final KaigoDoctor 主治医;
    private final RString 主治医意見書依頼対象 = new RString("主治医意見書依頼対象");

    /**
     * コンストラクタです。
     *
     * @param 認定進捗情報 認定進捗情報
     * @param 申請書管理番号 申請書管理番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請年月日 認定申請年月日
     * @param 認定申請区分 認定申請区分
     * @param 個人情報 個人情報
     * @param 氏名 氏名
     * @param 住所 住所
     * @param 主治医医療機関 主治医医療機関
     * @param 主治医 主治医
     * @throws NullPointerException
     * {@code 認定進捗情報}がnullの場合、{@code 申請書管理番号}がnullの場合、{@code 証記載保険者番号}がnullの場合、
     * {@code 被保険者番号}がnullの場合、{@code 認定申請年月日}がnullの場合、{@code 認定申請区分}がnullの場合、
     * {@code 個人情報}がnullの場合、{@code 氏名}がnullの場合、または{@code 住所}がnullの場合
     */
    public ShujiiIkenshoIraiTaishosha(
            YokaigoNinteiProgress 認定進捗情報,
            ShinseishoKanriNo 申請書管理番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleDate 認定申請年月日,
            Code 認定申請区分,
            IKojin 個人情報,
            RString 氏名,
            RString 住所,
            KaigoIryoKikan 主治医医療機関,
            KaigoDoctor 主治医) throws NullPointerException {

        this.認定進捗情報 = requireNonNull(認定進捗情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定進捗情報", 主治医意見書依頼対象.toString()));
        this.申請書管理番号 = requireNonNull(申請書管理番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("申請書管理番号", 主治医意見書依頼対象.toString()));
        this.証記載保険者番号 = requireNonNull(証記載保険者番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("証記載保険者番号", 主治医意見書依頼対象.toString()));
        this.被保険者番号 = requireNonNull(被保険者番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("被保険者番号", 主治医意見書依頼対象.toString()));
        this.認定申請年月日 = requireNonNull(認定申請年月日, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定申請年月日", 主治医意見書依頼対象.toString()));
        this.認定申請区分 = requireNonNull(認定申請区分, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定申請区分", 主治医意見書依頼対象.toString()));
        this.個人情報 = requireNonNull(個人情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("個人情報", 主治医意見書依頼対象.toString()));
        this.氏名 = requireNonNull(氏名, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("氏名", 主治医意見書依頼対象.toString()));
        this.住所 = requireNonNull(住所, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("住所", 主治医意見書依頼対象.toString()));
        this.主治医医療機関 = 主治医医療機関;
        this.主治医 = 主治医;
    }

    /**
     * 認定進捗情報を返します。
     *
     * @return 認定進捗情報
     */
    public YokaigoNinteiProgress get認定進捗情報() {
        return 認定進捗情報;
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return 証記載保険者番号;
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
     * 認定申請区分を返します。
     *
     * @return 認定申請区分
     */
    public Code get認定申請区分() {
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
    public KaigoDoctor get主治医() {
        return 主治医;
    }
}
