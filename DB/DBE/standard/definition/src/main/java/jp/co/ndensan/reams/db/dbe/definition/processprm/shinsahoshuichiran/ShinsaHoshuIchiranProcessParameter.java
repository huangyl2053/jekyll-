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
    private final RString 審査回数;
    private final RString 報酬総額;
    private final RString 税額控除;
    private final RString 報酬合計;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param 審査会開催年月 審査会開催年月
     * @param 審査回数 審査回数
     * @param 報酬総額 報酬総額
     * @param 税額控除 税額控除
     * @param 報酬合計 報酬合計
     */
    public ShinsaHoshuIchiranProcessParameter(RString 帳票出力区分,
            RString 審査会開催年月,
            RString 審査回数,
            RString 報酬総額,
            RString 税額控除,
            RString 報酬合計) {
        this.帳票出力区分 = 帳票出力区分;
        this.審査会開催年月 = 審査会開催年月;
        this.審査回数 = 審査回数;
        this.報酬総額 = 報酬総額;
        this.税額控除 = 税額控除;
        this.報酬合計 = 報酬合計;
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
