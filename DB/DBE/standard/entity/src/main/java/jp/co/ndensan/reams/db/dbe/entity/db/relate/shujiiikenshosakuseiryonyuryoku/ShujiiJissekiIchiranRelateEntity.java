/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shujiiikenshosakuseiryonyuryoku;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医実績一覧のEntityです。
 *
 * @reamsid_L DBE-1960-010 xuyannan
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiJissekiIchiranRelateEntity {

    private RString shinseishoKanriNo;
    private RString dbT5302_ikenshoIraiRirekiNo;
    private RString shujiiIryoKikanCode;
    private RString shujiiCode;
    private RString iryoKikanMeisho;
    private RString shujiiName;
    private boolean shiteiiFlag;
    private RString ninteiShinseiYMD;
    private RString ninteiShinseiShinseijiKubunCode;
    private RString ikenshoJuryoYMD;
    private RString ikenshoKinyuYMD;
    private RString ikenshoSakuseiIraiYMD;
    private RString ishiKubunCode;
    private RString dbT5602_ikenshoIraiRirekiNo;
    private int ikenshoSakuseiryo;
    private int ikenshoBettoShinryohi;
    private int ikenshoHoshu;
    private RString hoshuShiharaiMemo;
    private boolean ginkoFurikomiShutsuryokuFlag;
}
