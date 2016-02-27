/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo;

/**
 * 弁明書作成_帳票クラスパラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BemmeisyoReportJoho {

    private final BemmeisyoHeadItem headItem;

    /**
     * コンストラクタを作成します。
     *
     * @param headItem 弁明書ヘッダ
     */
    public BemmeisyoReportJoho(
            BemmeisyoHeadItem headItem) {

        this.headItem = headItem;
    }
}
