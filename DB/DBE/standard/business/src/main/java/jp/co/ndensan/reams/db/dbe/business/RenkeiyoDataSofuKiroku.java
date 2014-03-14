/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.HikiwatashiKubun;
import jp.co.ndensan.reams.db.dbe.definition.NinteiShinseijiKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiChousaSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiIkenshoSoufuKubun;
import jp.co.ndensan.reams.db.dbe.definition.SaiSoufuKubun;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 連携用データ送付記録のクラスです。
 *
 * @author n8107 千秋雄
 */
public class RenkeiyoDataSofuKiroku {

    private final ShinseishoKanriNo 申請書管理番号;
    private final KaigoHihokenshaNo 被保険者番号;
    private final NinteiShinseijiKubun 認定申請時区分;
    private final HikiwatashiKubun 引渡し区分;
    private final RDateTime 引渡し日時;
    private final SaiSoufuKubun 再送付区分;
    private final SaiChousaSoufuKubun 再調査送付区分;
    private final SaiIkenshoSoufuKubun 再意見書送付区分;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 被保険者番号 被保険者番号
     * @param 認定申請時区分 認定申請時区分
     * @param 引渡し区分 引渡し区分
     * @param 引渡し日時 引渡し日時
     * @param 再送付区分 再送付区分
     * @param 再調査送付区分 再調査送付区分
     * @param 再意見書送付区分 再意見書送付区分
     * @throws NullPointerException 引数がnullの場合
     */
    public RenkeiyoDataSofuKiroku(ShinseishoKanriNo 申請書管理番号, KaigoHihokenshaNo 被保険者番号,
            NinteiShinseijiKubun 認定申請時区分,
            HikiwatashiKubun 引渡し区分, RDateTime 引渡し日時,
            SaiSoufuKubun 再送付区分, SaiChousaSoufuKubun 再調査送付区分,
            SaiIkenshoSoufuKubun 再意見書送付区分) throws NullPointerException {
        Objects.requireNonNull(申請書管理番号, Messages.E00003.replace("申請書管理番号", getClass().getName()).getMessage());
        Objects.requireNonNull(被保険者番号, Messages.E00003.replace("被保険者番号", getClass().getName()).getMessage());
        Objects.requireNonNull(認定申請時区分, Messages.E00003.replace("認定申請時区分", getClass().getName()).getMessage());
        Objects.requireNonNull(引渡し区分, Messages.E00003.replace("引渡し区分", getClass().getName()).getMessage());
        Objects.requireNonNull(引渡し日時, Messages.E00003.replace("引渡し日時", getClass().getName()).getMessage());
        Objects.requireNonNull(再送付区分, Messages.E00003.replace("再送付区分", getClass().getName()).getMessage());

        this.申請書管理番号 = 申請書管理番号;
        this.被保険者番号 = 被保険者番号;
        this.認定申請時区分 = 認定申請時区分;
        this.引渡し区分 = 引渡し区分;
        this.引渡し日時 = 引渡し日時;
        this.再送付区分 = 再送付区分;
        this.再調査送付区分 = 再調査送付区分;
        this.再意見書送付区分 = 再意見書送付区分;
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
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public KaigoHihokenshaNo get被保険者番号() {
        return 被保険者番号;
    }

    /**
     * 認定申請区分（申請時）を取得します。
     *
     * @return 認定申請時区分
     */
    public NinteiShinseijiKubun get認定申請時区分() {
        return 認定申請時区分;
    }

    /**
     * 引渡し区分を取得します。
     *
     * @return 引渡し区分
     */
    public HikiwatashiKubun get引渡し区分() {
        return 引渡し区分;
    }

    /**
     * 引き渡し済みかそうでないかを判別します。
     *
     * @return 引き渡し区分.引渡し済み;
     */
    public boolean is引き渡し済み() {
        return 引渡し区分 == HikiwatashiKubun.引渡し済み;
    }

    /**
     * 引渡し日時を取得します。
     *
     * @return 引渡し日時
     */
    public RDateTime get引渡し日時() {
        return 引渡し日時;
    }

    /**
     * 再送付区分を取得します。
     *
     * @return 再送付区分
     */
    public SaiSoufuKubun get再送付区分() {
        return 再送付区分;
    }

    /**
     * 再送信の状態を判別します。
     *
     * @return 再送付区分.再送信無し
     */
    public boolean is再送信無し() {
        return 再送付区分 == SaiSoufuKubun.再送信無し;
    }

    /**
     * 再調査送付区分を取得します。
     *
     * @return 再調査送付区分
     */
    public SaiChousaSoufuKubun get再調査送付区分() {
        return 再調査送付区分;
    }

    /**
     * 再意見書送付区分を取得します。
     *
     * @return 再意見書送付区分
     */
    public SaiIkenshoSoufuKubun get再意見書送付区分() {
        return 再意見書送付区分;
    }
}
