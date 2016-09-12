/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.tokeijoho;

/**
 * 資格人数サマリークラスです。
 *
 * @reamsid_L DBU-4120-030 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShikakuSummary {

    private int 資格人数;
    private int 資格人数_内住所地特例者;
    private int 一号被保険者人数;
    private int 一号被保険者人数_内住所地特例者;
    private int 二号被保険者人数;
    private int 二号被保険者人数_内住所地特例者;
    private int 適用除外者;
    private int 他住所地特例者;
}
