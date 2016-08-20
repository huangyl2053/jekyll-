/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.tokeijoho;

/**
 * 受給人数サマリークラスです。
 *
 * @reamsid_L DBU-4120-030 sunhaidi
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class JukyuSummary {

    private int 受給人数;
    private int 要介護１人数;
    private int 要介護２人数;
    private int 要介護３人数;
    private int 要介護４人数;
    private int 要介護５人数;
    private int 要支援１人数;
    private int 要支援２人数;
    private int 経過的要介護人数;
    private int 自立人数;
}
