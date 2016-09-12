/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会事前審査結果一覧表のデータ取得パラメータクラスです。
 *
 * @reamsid_L DBE-1640-010 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaiJIzenShinsakekkaIchiranMybitisParamter implements IMyBatisParameter {

    private final RString shinsakaiKaisaiNo;

    private ShinsakaiJIzenShinsakekkaIchiranMybitisParamter(RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 審査会事前審査結果一覧表のデータ取得のパラメータを作成します。
     *
     * @param shinsakaiKaisaiNo 審査会開催番号
     * @return 審査会事前審査結果一覧表のデータ取得パラメータ
     */
    public static ShinsakaiJIzenShinsakekkaIchiranMybitisParamter createParamter(RString shinsakaiKaisaiNo) {
        return new ShinsakaiJIzenShinsakekkaIchiranMybitisParamter(shinsakaiKaisaiNo);
    }
}
