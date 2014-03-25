/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会委員の口座情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinKoza {

    private final KinyuKikanCode 金融機関コード;
    private final KinyuKikanShitenCode 金融機関支店コード;
    private final RString 口座種別;
    private final RString 口座名義人;
    private final RString 口座名義人カナ;
    private final RString 口座番号;

    /**
     * 引数からメンバを受け取り、インスタンスを生成します。
     *
     * @param 金融機関コード 金融機関コード
     * @param 金融機関支店コード 金融機関支店コード
     * @param 口座種別 口座種別
     * @param 口座名義人 口座名義人
     * @param 口座名義人カナ 口座名義人カナ
     * @param 口座番号 口座番号
     * @throws NullPointerException 引数のいずれかにnullが渡されたとき
     */
    public ShinsakaiIinKoza(KinyuKikanCode 金融機関コード, KinyuKikanShitenCode 金融機関支店コード, RString 口座種別,
            RString 口座名義人, RString 口座名義人カナ, RString 口座番号) throws NullPointerException {
        requireNonNull(金融機関コード, Messages.E00003.replace("金融機関コード", getClass().getName()).getMessage());
        requireNonNull(金融機関支店コード, Messages.E00003.replace("金融機関支店コード", getClass().getName()).getMessage());
        requireNonNull(口座種別, Messages.E00003.replace("口座種別", getClass().getName()).getMessage());
        requireNonNull(口座名義人, Messages.E00003.replace("口座名義人", getClass().getName()).getMessage());
        requireNonNull(口座名義人カナ, Messages.E00003.replace("口座名義人カナ", getClass().getName()).getMessage());
        requireNonNull(口座番号, Messages.E00003.replace("口座番号", getClass().getName()).getMessage());

        this.金融機関コード = 金融機関コード;
        this.金融機関支店コード = 金融機関支店コード;
        this.口座種別 = 口座種別;
        this.口座名義人 = 口座名義人;
        this.口座名義人カナ = 口座名義人カナ;
        this.口座番号 = 口座番号;
    }

    /**
     * 金融機関コードを返します。
     *
     * @return 金融機関コード
     */
    public KinyuKikanCode get金融機関コード() {
        return 金融機関コード;
    }

    /**
     * 金融機関コードを返します。
     *
     * @return 金融機関コード
     */
    public KinyuKikanShitenCode get金融機関支店コード() {
        return 金融機関支店コード;
    }

    /**
     * 口座種別を返します。
     *
     * @return 口座種別
     */
    public RString get口座種別() {
        return 口座種別;
    }

    /**
     * 口座名義人を返します。
     *
     * @return 口座名義人
     */
    public RString get口座名義人() {
        return 口座名義人;
    }

    /**
     * 口座名義人のカナを返します。
     *
     * @return 口座名義人カナ
     */
    public RString get口座名義人カナ() {
        return 口座名義人カナ;
    }

    /**
     * 口座番号を返します。
     *
     * @return 口座番号
     */
    public RString get口座番号() {
        return 口座番号;
    }
}
