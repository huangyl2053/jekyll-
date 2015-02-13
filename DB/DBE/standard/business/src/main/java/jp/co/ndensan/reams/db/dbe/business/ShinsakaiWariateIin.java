/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiIinShukketsuKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.TimeString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;

/**
 * 審査会に割り当てられた審査会委員を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiWariateIin {

    private final ShinsakaiDetail 審査会情報;
    private final ShinsakaiIin 審査会委員情報;
    private final ShinsainKubun 認定審査員区分;
    private final GogitaichoKubun 合議体長区分;
    private final Range<TimeString> 審査時間;
    private final ShinsakaiIinShukketsuKubun 出欠区分;

    /**
     * 引数から審査会割当委員に必要な情報を受け取り、インスタンスを生成します。
     *
     * @param 審査会情報 審査会情報
     * @param 審査会委員情報 審査会委員情報
     * @param 認定審査員区分 認定審査員区分
     * @param 合議体長区分 合議体長区分
     * @param 審査時間 審査時間
     * @param 出欠区分 出欠区分
     * @throws NullPointerException 審査会情報、委員情報のいずれかにnullが渡されたとき
     */
    public ShinsakaiWariateIin(ShinsakaiDetail 審査会情報, ShinsakaiIin 審査会委員情報, ShinsainKubun 認定審査員区分,
            GogitaichoKubun 合議体長区分, Range<TimeString> 審査時間, ShinsakaiIinShukketsuKubun 出欠区分) throws NullPointerException {
        requireNonNull(審査会情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("審査会情報", getClass().getName()));
        requireNonNull(審査会委員情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("審査会委員情報", getClass().getName()));

        this.審査会情報 = 審査会情報;
        this.審査会委員情報 = 審査会委員情報;
        this.認定審査員区分 = 認定審査員区分;
        this.合議体長区分 = 合議体長区分;
        this.審査時間 = 審査時間;
        this.出欠区分 = 出欠区分;
    }

    /**
     * 割り当てられている審査会の情報を返します。
     *
     * @return 審査会情報
     */
    public ShinsakaiDetail get審査会情報() {
        return 審査会情報;
    }

    /**
     * 審査会委員情報を返します。
     *
     * @return 審査会委員情報
     */
    public ShinsakaiIin get審査会委員情報() {
        return 審査会委員情報;
    }

    /**
     * 認定審査員区分を返します。
     *
     * @return 認定審査員区分
     */
    public ShinsainKubun get認定審査員区分() {
        return 認定審査員区分;
    }

    /**
     * 合議体長区分を返します。
     *
     * @return 合議体長区分
     */
    public GogitaichoKubun get合議体長区分() {
        return 合議体長区分;
    }

    /**
     * 審査時間を返します。
     *
     * @return 審査時間
     */
    public Range<TimeString> get審査時間() {
        return 審査時間;
    }

    /**
     * 出欠区分を返します。
     *
     * @return 出欠区分
     */
    public ShinsakaiIinShukketsuKubun get出欠区分() {
        return 出欠区分;
    }
}
