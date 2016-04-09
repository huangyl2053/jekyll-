/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitai;

import jp.co.ndensan.reams.db.dbe.business.core.ShinsainKubun;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakai.ShinsakaiIin;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 合議体に割り当てられた審査会委員を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiWariateIin {

    private final ShinsakaiIin 委員情報;
    private final ShinsainKubun 認定調査員区分;
    private final GogitaichoKubun 合議体長区分;
    private final GogitaiDetail 合議体情報;

    /**
     * 引数から値を受け取るコンストラクタです。
     *
     * @param 委員情報 委員情報
     * @param 認定調査員区分 認定調査員区分
     * @param 合議体長区分 合議体長区分
     * @param 合議体情報 合議体情報
     * @throws NullPointerException 委員情報にnullが渡されたとき
     */
    public GogitaiWariateIin(ShinsakaiIin 委員情報, ShinsainKubun 認定調査員区分, GogitaichoKubun 合議体長区分, GogitaiDetail 合議体情報)
            throws NullPointerException {
        requireNonNull(委員情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("委員情報", getClass().getName()));
        requireNonNull(合議体情報, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("合議体情報", getClass().getName()));

        this.委員情報 = 委員情報;
        this.認定調査員区分 = 認定調査員区分;
        this.合議体長区分 = 合議体長区分;
        this.合議体情報 = 合議体情報;
    }

    /**
     * 委員情報を返します。
     *
     * @return 委員情報
     */
    public ShinsakaiIin get委員情報() {
        return 委員情報;
    }

    /**
     * 認定調査員区分を返します。
     *
     * @return 認定調査員区分
     */
    public ShinsainKubun get認定調査員区分() {
        return 認定調査員区分;
    }

    /**
     * 合議体長区分を返します。
     *
     * @return 合議体調区分
     */
    public GogitaichoKubun get合議体長区分() {
        return 合議体長区分;
    }

    /**
     * 自身が割り当てられている合議体の情報を返します。
     *
     * @return 合議体情報
     */
    public GogitaiDetail get合議体情報() {
        return 合議体情報;
    }
}
