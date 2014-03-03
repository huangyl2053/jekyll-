/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IshiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IshiShikibetsuNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShujiiIryoKikanCode;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;

/**
 * 主治医意見書作成依頼情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoSakuseiIraiJoho {

    private final ShinseishoKanriNo 申請書管理番号;
    private final IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号;
    private final ShujiiIryoKikanCode 主治医医療機関コード;
    private final IshiShikibetsuNo 医師識別番号;
    private final IkenshoIraiKubun 意見書作成依頼区分;
    private final int 意見書作成回数;
    private final IshiKubun 医師区分;
    private final FlexibleDate 意見書作成依頼年月日;
    private final FlexibleDate 意見書作成期限年月日;
    private final FlexibleDate 意見書出力年月日;
    private final FlexibleDate 請求書出力年月日;
    private final SakuseiryoSeikyuKubun 作成料請求区分;
    private final FlexibleDate 意見書作成督促年月日;
    private final IkenshoSakuseiTokusokuHoho 意見書作成督促方法;
    private final int 意見書作成督促回数;
    private final RString 意見書作成督促メモ;

    /**
     * インスタンスを生成します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 意見書作成依頼履歴番号 意見書作成依頼履歴番号
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 医師識別番号 医師識別番号
     * @param 意見書作成依頼区分 意見書作成依頼区分
     * @param 意見書作成回数 意見書作成回数
     * @param 医師区分 医師区分
     * @param 意見書作成依頼年月日 意見書作成依頼年月日
     * @param 意見書作成期限年月日 意見書作成期限年月日
     * @param 意見書出力年月日 意見書出力年月日
     * @param 請求書出力年月日 請求書出力年月日
     * @param 作成料請求区分 作成料請求区分
     * @param 意見書作成督促年月日 意見書作成督促年月日
     * @param 意見書作成督促方法 意見書作成督促方法
     * @param 意見書作成督促回数 意見書作成督促回数
     * @param 意見書作成督促メモ 意見書作成督促メモ
     */
    public ShujiiIkenshoSakuseiIraiJoho(
            ShinseishoKanriNo 申請書管理番号,
            IkenshosakuseiIraiRirekiNo 意見書作成依頼履歴番号,
            ShujiiIryoKikanCode 主治医医療機関コード,
            IshiShikibetsuNo 医師識別番号,
            IkenshoIraiKubun 意見書作成依頼区分,
            int 意見書作成回数,
            IshiKubun 医師区分,
            FlexibleDate 意見書作成依頼年月日,
            FlexibleDate 意見書作成期限年月日,
            FlexibleDate 意見書出力年月日,
            FlexibleDate 請求書出力年月日,
            SakuseiryoSeikyuKubun 作成料請求区分,
            FlexibleDate 意見書作成督促年月日,
            IkenshoSakuseiTokusokuHoho 意見書作成督促方法,
            int 意見書作成督促回数,
            RString 意見書作成督促メモ) {
        this.申請書管理番号 = requireNonNull(申請書管理番号, Messages.E00001.replace("申請書管理番号").getMessage());
        this.意見書作成依頼履歴番号 = requireNonNull(意見書作成依頼履歴番号, Messages.E00001.replace("意見書作成依頼履歴番号").getMessage());
        this.主治医医療機関コード = requireNonNull(主治医医療機関コード, Messages.E00001.replace("主治医医療機関コード").getMessage());
        this.医師識別番号 = requireNonNull(医師識別番号, Messages.E00001.replace("医師識別番号").getMessage());
        this.意見書作成依頼区分 = requireNonNull(意見書作成依頼区分, Messages.E00001.replace("意見書作成依頼区分").getMessage());
        this.意見書作成回数 = 意見書作成回数;
        this.医師区分 = requireNonNull(医師区分, Messages.E00001.replace("医師区分").getMessage());
        this.意見書作成依頼年月日 = 意見書作成依頼年月日;
        this.意見書作成期限年月日 = 意見書作成期限年月日;
        this.意見書出力年月日 = 意見書出力年月日;
        this.請求書出力年月日 = 請求書出力年月日;
        this.作成料請求区分 = 作成料請求区分;
        this.意見書作成督促年月日 = 意見書作成督促年月日;
        this.意見書作成督促方法 = 意見書作成督促方法;
        this.意見書作成督促回数 = 意見書作成督促回数;
        this.意見書作成督促メモ = 意見書作成督促メモ;
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
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public ShujiiIryoKikanCode get主治医医療機関コード() {
        return 主治医医療機関コード;
    }

    /**
     * 医師識別番号を返します。
     *
     * @return 医師識別番号
     */
    public IshiShikibetsuNo get医師識別番号() {
        return 医師識別番号;
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
     * 請求書出力年月日を返します。
     *
     * @return 請求書出力年月日
     */
    public FlexibleDate get請求書出力年月日() {
        return 請求書出力年月日;
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
     * 意見書作成督促年月日を返します。
     *
     * @return 意見書作成督促年月日
     */
    public FlexibleDate get意見書作成督促年月日() {
        return 意見書作成督促年月日;
    }

    /**
     * 意見書作成督促方法を返します。
     *
     * @return 意見書作成督促方法
     */
    public IkenshoSakuseiTokusokuHoho get意見書作成督促方法() {
        return 意見書作成督促方法;
    }

    /**
     * 意見書作成督促回数を返します。
     *
     * @return 意見書作成督促回数
     */
    public int get意見書作成督促回数() {
        return 意見書作成督促回数;
    }

    /**
     * 意見書作成督促メモを返します。
     *
     * @return 意見書作成督促メモ
     */
    public RString get意見書作成督促メモ() {
        return 意見書作成督促メモ;
    }
}
