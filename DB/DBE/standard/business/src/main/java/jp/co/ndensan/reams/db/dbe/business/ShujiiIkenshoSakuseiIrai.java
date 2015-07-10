/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書作成依頼情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiIrai {

    private final ShinseishoKanriNo 申請書管理番号;
    private final IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号;
    private final KaigoDoctor 介護医師;
    private final IkenshoIraiKubun 意見書作成依頼区分;
    private final int 意見書作成回数;
    private final IshiKubun 医師区分;
    private final FlexibleDate 意見書作成依頼年月日;
    private final FlexibleDate 意見書作成期限年月日;
    private final FlexibleDate 意見書出力年月日;
    private final FlexibleDate 請求書出力年月日;
    private final SakuseiryoSeikyuKubun 作成料請求区分;
    private final ShujiiIkenshoSakuseiTokusoku 意見書作成督促情報;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書作成依頼履歴番号 意見書作成依頼履歴番号
     * @param 介護医師 介護医師
     * @param 意見書作成依頼区分 意見書作成依頼区分
     * @param 意見書作成回数 意見書作成回数
     * @param 医師区分 医師区分
     * @param 意見書作成依頼年月日 意見書作成依頼年月日
     * @param 意見書作成期限年月日 意見書作成期限年月日
     * @param 意見書出力年月日 意見書出力年月日
     * @param 請求書出力年月日 請求書出力年月日
     * @param 作成料請求区分 作成料請求区分
     * @param 意見書作成督促情報 意見書作成督促情報
     */
    public ShujiiIkenshoSakuseiIrai(
            ShinseishoKanriNo 申請書管理番号,
            IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号,
            KaigoDoctor 介護医師,
            IkenshoIraiKubun 意見書作成依頼区分,
            int 意見書作成回数,
            IshiKubun 医師区分,
            FlexibleDate 意見書作成依頼年月日,
            FlexibleDate 意見書作成期限年月日,
            FlexibleDate 意見書出力年月日,
            FlexibleDate 請求書出力年月日,
            SakuseiryoSeikyuKubun 作成料請求区分,
            ShujiiIkenshoSakuseiTokusoku 意見書作成督促情報) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.意見書作成依頼履歴番号 = requireNonNull(意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成依頼履歴番号"));
        this.介護医師 = requireNonNull(介護医師, UrSystemErrorMessages.値がnull.getReplacedMessage("介護医師"));
        this.意見書作成依頼区分 = requireNonNull(意見書作成依頼区分, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成依頼区分"));
        this.意見書作成回数 = 意見書作成回数;
        this.医師区分 = requireNonNull(医師区分, UrSystemErrorMessages.値がnull.getReplacedMessage("医師区分"));
        this.意見書作成依頼年月日 = 意見書作成依頼年月日;
        this.意見書作成期限年月日 = 意見書作成期限年月日;
        this.意見書出力年月日 = 意見書出力年月日;
        this.請求書出力年月日 = 請求書出力年月日;
        this.作成料請求区分 = 作成料請求区分;
        this.意見書作成督促情報 = 意見書作成督促情報;
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
     * 意見書作成依頼履歴番号を返します。
     *
     * @return 意見書作成依頼履歴番号
     */
    public IkenshosakuseiIraiRirekiNo get意見書作成依頼履歴番号() {
        return 意見書作成依頼履歴番号;
    }

    /**
     * 介護医師を返します。
     *
     * @return 介護医師
     */
    public KaigoDoctor get介護医師() {
        return 介護医師;
    }

    /**
     * 意見書作成依頼区分を返します。
     *
     * @return 意見書作成依頼区分
     */
    public IkenshoIraiKubun get意見書作成依頼区分() {
        return 意見書作成依頼区分;
    }

    /**
     * 意見書作成回数を返します。
     *
     * @return 意見書作成回数
     */
    public int get意見書作成回数() {
        return 意見書作成回数;
    }

    /**
     * 医師区分を返します。
     *
     * @return 医師区分
     */
    public IshiKubun get医師区分() {
        return 医師区分;
    }

    /**
     * 意見書作成依頼年月日を返します。
     *
     * @return 意見書作成依頼年月日
     */
    public FlexibleDate get意見書作成依頼年月日() {
        return 意見書作成依頼年月日;
    }

    /**
     * 意見書作成が依頼済みかどうか判定します。
     *
     * @return 依頼済みの場合はtrueを返します。
     */
    public boolean is意見書作成依頼済み() {
        return 意見書作成依頼年月日 != FlexibleDate.MIN;
    }

    /**
     * 意見書作成期限年月日を返します。
     *
     * @return 意見書作成期限年月日
     */
    public FlexibleDate get意見書作成期限年月日() {
        return 意見書作成期限年月日;
    }

    /**
     * 意見書出力年月日を返します。
     *
     * @return 意見書出力年月日
     */
    public FlexibleDate get意見書出力年月日() {
        return 意見書出力年月日;
    }

    /**
     * 意見書が出力済みかどうか判定します。
     *
     * @return 出力済みの場合はtrueを返します。
     */
    public boolean is意見書出力済み() {
        return 意見書出力年月日 != FlexibleDate.MIN;
    }

    /**
     * 請求書出力年月日を返します。
     *
     * @return 請求書出力年月日
     */
    public FlexibleDate get請求書出力年月日() {
        return 請求書出力年月日;
    }

    /**
     * 請求書が出力済みかどうか判定します。
     *
     * @return 出力済みの場合はtrueを返します。
     */
    public boolean is請求書出力済み() {
        return 請求書出力年月日 != FlexibleDate.MIN;
    }

    /**
     * 作成料請求区分を返します。
     *
     * @return 作成料請求区分
     */
    public SakuseiryoSeikyuKubun get作成料請求区分() {
        return 作成料請求区分;
    }

    /**
     * 意見書作成督促情報を返します。
     *
     * @return 意見書作成督促情報
     */
    public ShujiiIkenshoSakuseiTokusoku get意見書作成督促情報() {
        return 意見書作成督促情報;
    }

    /**
     * 意見書作成が督促済みかどうか判定します。
     *
     * @return 督促済みの場合はtrueを返します。
     */
    public boolean is意見書作成督促済み() {
        if (意見書作成督促情報 == null) {
            return false;
        }
        if (意見書作成督促情報.get意見書作成督促年月日() == null
                && 意見書作成督促情報.get意見書作成督促方法() == null
                && 意見書作成督促情報.get意見書作成督促回数() == 0
                && 意見書作成督促情報.get意見書作成督促メモ() == null) {
            return false;
        }
        return true;
    }
}
