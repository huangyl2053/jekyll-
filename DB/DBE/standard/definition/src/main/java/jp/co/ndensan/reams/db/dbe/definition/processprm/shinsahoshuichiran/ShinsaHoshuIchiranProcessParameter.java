/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinsahoshuichiran;

import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsahoshuichiran.ShinsaHoshuIchiranMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員報酬一覧表のProcessParameterです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsaHoshuIchiranProcessParameter implements IBatchProcessParameter {

    private final RString 帳票出力区分;
    private final RString 審査会開催年月;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param 審査会開催年月 審査会開催年月
     */
    public ShinsaHoshuIchiranProcessParameter(RString 帳票出力区分,
            RString 審査会開催年月) {
        this.帳票出力区分 = 帳票出力区分;
        this.審査会開催年月 = 審査会開催年月;
    }

    /**
     * のデータ取得パラメータのデータ取得パラメータを作成します。
     *
     * @return 介護認定審査会委員報酬一覧表のデータ取得パラメータ
     */
    public ShinsaHoshuIchiranMybitisParamter toMybitisParamter() {
        return ShinsaHoshuIchiranMybitisParamter.createParamter(this.審査会開催年月);
    }
}
