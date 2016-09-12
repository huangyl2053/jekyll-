/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinsakaijizenshinsakekkaichiran;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJIzenShinsakekkaIchiranMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事前審査結果一覧表のProcessParameterです。
 *
 * @reamsid_L DBE-1640-020 zhaoyao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiJizenshinsakekkaIchiranProcessParameter implements IBatchProcessParameter {

    private final RString 介護認定審査会開催番号;

    /**
     * コンストラクタです。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     */
    public ShinsakaiJizenshinsakekkaIchiranProcessParameter(RString 介護認定審査会開催番号) {
        this.介護認定審査会開催番号 = 介護認定審査会開催番号;
    }

    /**
     * 介護認定審査会委員報酬一覧表のsMybitisパラメータを作成します。
     *
     * @return 介護認定審査会委員報酬一覧表のMybitisParamter
     */
    public ShinsakaiJIzenShinsakekkaIchiranMybitisParamter toMybitisParamter() {
        return ShinsakaiJIzenShinsakekkaIchiranMybitisParamter.createParamter(介護認定審査会開催番号);
    }
}
