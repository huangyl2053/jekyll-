/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shinsakaijohokojin;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会情報照会(個人)のParameterクラスです。
 *
 * @reamsid_L DBE-3000-070 zhengshukai
 */
public final class ShinsakaiJohoKojinMapperParameter {

    private final int 合議体番号;
    private final RString 介護認定審査会開催番号;
    private final FlexibleDate 介護認定審査会開催日;

    /**
     * コンストラクタです。
     *
     * @param 合議体番号 int
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会開催日 介護認定審査会開催日
     */
    private ShinsakaiJohoKojinMapperParameter(int 合議体番号, RString 介護認定審査会開催番号, FlexibleDate 介護認定審査会開催日) {
        this.合議体番号 = 合議体番号;
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
        this.介護認定審査会開催日 = 介護認定審査会開催日;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 合議体番号 合議体番号
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会開催日 介護認定審査会開催日
     * @return 委員情報検索パラメータ
     */
    public static ShinsakaiJohoKojinMapperParameter createParam(int 合議体番号, RString 介護認定審査会開催番号, FlexibleDate 介護認定審査会開催日) {

        return new ShinsakaiJohoKojinMapperParameter(合議体番号, 介護認定審査会開催番号, 介護認定審査会開催日);
    }

    /**
     * 合議体番号を返します。
     *
     * @return 合議体番号
     */
    public int get合議体番号() {
        return 合議体番号;
    }

    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return 介護認定審査会開催番号;
    }

    /**
     * 介護認定審査会開催日を返します。
     *
     * @return 介護認定審査会開催日
     */
    public FlexibleDate get介護認定審査会開催日() {
        return 介護認定審査会開催日;
    }
}
