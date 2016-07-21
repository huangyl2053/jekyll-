/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsahoshuichiran;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬一覧表のデータ取得パラメータクラスです。
 *
 * @reamsid_L DBE-1920-030 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsaHoshuIchiranMybitisParamter implements IMyBatisParameter {

    private final RString 審査会開催年月;

    /**
     * インスタンスを生成します。
     *
     * @param 審査会開催年月 審査会開催年月
     */
    private ShinsaHoshuIchiranMybitisParamter(RString 審査会開催年月) {
        this.審査会開催年月 = 審査会開催年月;
    }

    /**
     * 介護認定審査会委員報酬一覧表のデータ取得のパラメータを作成します。
     *
     * @param 審査会開催年月 審査会開催年月
     * @return 介護認定審査会委員報酬一覧表のデータ取得パラメータ
     */
    public static ShinsaHoshuIchiranMybitisParamter createParamter(RString 審査会開催年月) {
        return new ShinsaHoshuIchiranMybitisParamter(審査会開催年月);
    }
}
