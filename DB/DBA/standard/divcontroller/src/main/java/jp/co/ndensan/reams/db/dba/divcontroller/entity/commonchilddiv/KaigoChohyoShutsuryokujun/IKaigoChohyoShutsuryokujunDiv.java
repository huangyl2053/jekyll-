/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun;

import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 介護帳票出力順の共有子Divのインタフェースクラスです。
 */
public interface IKaigoChohyoShutsuryokujunDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Div情報(CSV)をロードします。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     */
    void loadCSVMode(SubGyomuCode subGyomuCode, ReportId reportId);

    /**
     * 共有子Div情報(帳票)をロードします。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     */
    void loadChohyoMode(SubGyomuCode subGyomuCode, ReportId reportId);

    /**
     * 入力データチェックです。
     */
    void checkInput();
}
