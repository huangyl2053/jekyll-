/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbipanel;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBE622001_支払いデータ作成RelateEntityクラスです。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HoshushiharaiJumbiPanelBatchRelateEntity implements Serializable {

    private static final long serialVersionUID = 1980804750210236814L;
    private RString shujiiIryoKikanCode;
    private RString ninteichosainCode;
    private int chosaItakuryo;
    private RString shujiiCode;
    private int ikenshoSakuseiryo;
    private int shinsakaiHoshuGokei;
    private RString ninteichosaItakusakiCode;
    private RString ninteiChosainNo;
    private RString sonotaKikanCode;
    private RString shinsakaiIinCode;
}
