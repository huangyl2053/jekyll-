/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.IchijiHanteiResultSofuKubun;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 一次判定結果の送付に関する情報を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiResultSofu {

    private final IchijiHanteiResultSofuKubun 一次判定結果送付区分;
    private final FlexibleDate 一次判定結果送付年月日;

    /**
     * 一次判定の結果が未送付であることを表す定数です。
     */
    public static final IchijiHanteiResultSofu MI_SOFU;

    static {
        MI_SOFU = new IchijiHanteiResultSofu(IchijiHanteiResultSofuKubun.未送付, FlexibleDate.MIN);
    }

    /**
     * 一次判定結果送付区分と送付年月日を指定し、インスタンスを生成します。
     *
     * @param 一次判定結果送付区分 一次判定結果送付区分
     * @param 一次判定結果送付年月日 一次判定結果送付年月日
     */
    public IchijiHanteiResultSofu(IchijiHanteiResultSofuKubun 一次判定結果送付区分, FlexibleDate 一次判定結果送付年月日) {
        this.一次判定結果送付区分 = 一次判定結果送付区分;
        this.一次判定結果送付年月日 = 一次判定結果送付年月日;
    }

    public IchijiHanteiResultSofuKubun get一次判定結果送付区分() {
        return 一次判定結果送付区分;
    }

    public FlexibleDate get一次判定結果送付年月日() {
        return 一次判定結果送付年月日;
    }

}
