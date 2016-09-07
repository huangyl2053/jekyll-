/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.tokeijoho;

/**
 * 賦課人数サマリークラスです。
 *
 * @reamsid_L DBU-4120-030 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class FukaSummary {

    private int 賦課人数;
    private int 特別徴収人数_社保庁;
    private int 特別徴収人数_地共済;
    private int 普通徴収人数;
}
