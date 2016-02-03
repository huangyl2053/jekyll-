/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei;

import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 *
 * @author chenaoqi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanFukushiYoguHanbaihiParameter {

    private final RDate 支給申請日From;
    private final RDate 支給申請日To;

    /**
     * コンストラクタです。
     *
     * @param 支給申請日From 支給申請日From
     * @param 支給申請日To 支給申請日To
     */
    public ShokanFukushiYoguHanbaihiParameter(
            RDate 支給申請日From, RDate 支給申請日To) {
        this.支給申請日From = 支給申請日From;
        this.支給申請日To = 支給申請日To;
    }

    /**
     * コンストラクタです
     *
     * @param 支給申請日From 支給申請日From
     * @param 支給申請日To 支給申請日To
     * @return 償還払申請一覧検索パラメータ
     */
    public static ShokanFukushiYoguHanbaihiParameter createSelectByKeyParam(
            RDate 支給申請日From, RDate 支給申請日To) {

        return new ShokanFukushiYoguHanbaihiParameter(支給申請日From, 支給申請日To);
    }

}
