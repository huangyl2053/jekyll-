/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス一覧のBusinessクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
public class ServiceJohoBusiness {

    private final FlexibleDate 有効開始日;
    private final FlexibleDate 有効終了日;
    private final RString サービス種類略称;

    /**
     * コンストラクタです.
     *
     * @param 有効開始日 FlexibleDate
     * @param 有効終了日 FlexibleDate
     * @param サービス種類略称 RString
     */
    public ServiceJohoBusiness(FlexibleDate 有効開始日, FlexibleDate 有効終了日, RString サービス種類略称) {
        this.有効開始日 = 有効開始日;
        this.有効終了日 = 有効終了日;
        this.サービス種類略称 = サービス種類略称;
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効開始日() {
        return 有効開始日;
    }

    /**
     * 有効開始日を取得します。
     *
     * @return 有効開始日
     */
    public FlexibleDate get有効終了日() {
        return 有効終了日;
    }

    /**
     * サービス種類略称を取得します。
     *
     * @return サービス種類略称
     */
    public RString getサービス種類略称() {
        return サービス種類略称;
    }

}
