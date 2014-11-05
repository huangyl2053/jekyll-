/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoDoi;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteiJohoTeikyoKibo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書の基本情報を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
// TODO N3327 Baseは一般的に抽象クラスに使われる傾向があるので、名前を見直した方が良いかもしれない。
public class ShujiiIkenshoBase {

    private final ShinseishoKanriNo 申請書管理番号;
    private final IkenshosakuseiIraiRirekiNo 意見書履歴番号;
    private final ShujiiIkenshoIraiKubun 意見書依頼区分;
    private final KaigoDoctor 主治医;
    private final FlexibleDate 意見書受領年月日;
    private final FlexibleDate 意見書記入年月日;
    private final ShujiiIkenshoSakuseiKaisu 意見書作成回数;
    private final ShujiiIkenshoSakuseiryoShubetsu 意見書作成料種別;
    private final NinteiJohoTeikyoKibo 認定情報提供希望;
    private final IkenshoDoi 意見書同意;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書履歴番号 意見書履歴番号
     * @param 意見書依頼区分 意見書依頼区分
     * @param 主治医 主治医
     * @param 意見書受領年月日 意見書受領年月日
     * @param 意見書記入年月日 意見書記入年月日
     * @param 意見書作成回数 意見書作成回数
     * @param 意見書作成料種別 意見書作成料種別
     * @param 認定情報提供希望 認定情報提供希望
     * @param 意見書同意 意見書同意
     */
    public ShujiiIkenshoBase(
            ShinseishoKanriNo 申請書管理番号,
            IkenshosakuseiIraiRirekiNo 意見書履歴番号,
            ShujiiIkenshoIraiKubun 意見書依頼区分,
            KaigoDoctor 主治医,
            FlexibleDate 意見書受領年月日,
            FlexibleDate 意見書記入年月日,
            ShujiiIkenshoSakuseiKaisu 意見書作成回数,
            ShujiiIkenshoSakuseiryoShubetsu 意見書作成料種別,
            NinteiJohoTeikyoKibo 認定情報提供希望,
            IkenshoDoi 意見書同意) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.意見書履歴番号 = requireNonNull(意見書履歴番号, Messages.E00001.replace("意見書履歴番号").getMessage());
        this.意見書依頼区分 = requireNonNull(意見書依頼区分, Messages.E00001.replace("意見書依頼区分").getMessage());
        this.主治医 = requireNonNull(主治医, Messages.E00001.replace("主治医").getMessage());
        this.意見書受領年月日 = requireNonNull(意見書受領年月日, Messages.E00001.replace("意見書受領年月日").getMessage());
        this.意見書記入年月日 = requireNonNull(意見書記入年月日, Messages.E00001.replace("意見書記入年月日").getMessage());
        this.意見書作成回数 = requireNonNull(意見書作成回数, Messages.E00001.replace("意見書作成回数").getMessage());
        this.意見書作成料種別 = requireNonNull(意見書作成料種別, Messages.E00001.replace("意見書作成料種別").getMessage());
        this.認定情報提供希望 = requireNonNull(認定情報提供希望, Messages.E00001.replace("認定情報提供希望").getMessage());
        this.意見書同意 = requireNonNull(意見書同意, Messages.E00001.replace("意見書同意").getMessage());
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
     * 意見書履歴番号を返します。
     *
     * @return 意見書履歴番号
     */
    public IkenshosakuseiIraiRirekiNo get意見書履歴番号() {
        return 意見書履歴番号;
    }

    /**
     * 意見書依頼区分を返します。
     *
     * @return 意見書依頼区分
     */
    public ShujiiIkenshoIraiKubun get意見書依頼区分() {
        return 意見書依頼区分;
    }

    /**
     * 主治医を返します。
     *
     * @return 主治医
     */
    public KaigoDoctor get主治医() {
        return 主治医;
    }

    /**
     * 意見書受領年月日を返します。
     *
     * @return 意見書受領年月日
     */
    public FlexibleDate get意見書受領年月日() {
        return 意見書受領年月日;
    }

    /**
     * 意見書記入年月日を返します。
     *
     * @return 意見書記入年月日
     */
    public FlexibleDate get意見書記入年月日() {
        return 意見書記入年月日;
    }

    /**
     * 意見書作成回数を返します。
     *
     * @return 意見書作成回数
     */
    public ShujiiIkenshoSakuseiKaisu get意見書作成回数() {
        return 意見書作成回数;
    }

    /**
     * 意見書作成料種別を返します。
     *
     * @return 意見書作成料種別
     */
    public ShujiiIkenshoSakuseiryoShubetsu get意見書作成料種別() {
        return 意見書作成料種別;
    }

    /**
     * 認定情報提供希望を返します。
     *
     * @return 認定情報提供希望
     */
    public NinteiJohoTeikyoKibo get認定情報提供希望() {
        return 認定情報提供希望;
    }

    /**
     * 認定情報の提供を希望するかどうかを判定します。
     *
     * @return 希望する場合はtrueを返します。
     */
    public boolean is認定情報提供希望() {
        return 認定情報提供希望.is希望();
    }

    /**
     * 意見書同意を返します。
     *
     * @return 意見書同意
     */
    public IkenshoDoi get意見書同意() {
        return 意見書同意;
    }

    /**
     * 意見書に同意するかどうかを判定します。
     *
     * @return 同意する場合はtrueを返します。
     */
    public boolean is意見書同意() {
        return 意見書同意.is同意();
    }
}
