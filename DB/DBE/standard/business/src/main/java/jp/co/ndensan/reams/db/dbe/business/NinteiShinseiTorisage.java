/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsaKeizokuKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TorisageKubun;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請取下げの情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiShinseiTorisage {

    private final TorisageKubun 取下げ区分;
    private final RString 取下げ理由;
    private final RDate 取下げ年月日;
    private final ShinsaKeizokuKubun 審査継続区分;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 取下げ区分 取下げ区分
     * @param 取下げ理由 取下げ理由
     * @param 取下げ年月日 取下げ年月日
     * @param 審査継続区分 審査継続区分
     */
    public NinteiShinseiTorisage(TorisageKubun 取下げ区分, RString 取下げ理由, RDate 取下げ年月日, ShinsaKeizokuKubun 審査継続区分) {

        this.取下げ区分 = 取下げ区分;
        this.取下げ理由 = 取下げ理由;
        this.取下げ年月日 = 取下げ年月日;
        this.審査継続区分 = 審査継続区分;
    }

    /**
     * 認定申請の取下げ区分を返します。
     *
     * @return 取下げ区分
     */
    public TorisageKubun get取下げ区分() {
        return 取下げ区分;
    }

    /**
     * 取下げ理由を返します。
     *
     * @return 取下げ理由
     */
    public RString get取下げ理由() {
        return 取下げ理由;
    }

    /**
     * 取下げ年月日を返します。
     *
     * @return 取下げ年月日
     */
    public RDate get取下げ年月日() {
        return 取下げ年月日;
    }

    /**
     * 申請継続区分を返します。
     *
     * @return 審査継続区分
     */
    public ShinsaKeizokuKubun get申請継続区分() {
        return 審査継続区分;
    }
}
