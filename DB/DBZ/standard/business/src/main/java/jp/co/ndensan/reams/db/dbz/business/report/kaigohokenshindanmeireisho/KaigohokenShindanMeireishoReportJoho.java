/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho;

/**
 * 介護保険診断命令書_帳票パラメータクラスです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigohokenShindanMeireishoReportJoho {

    private final KaigohokenShindanMeireishoHeaderItem headItem;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 要介護認定調査依頼書ヘッダ
     */
    public KaigohokenShindanMeireishoReportJoho(
            KaigohokenShindanMeireishoHeaderItem headItem) {

        this.headItem = headItem;
    }
}
