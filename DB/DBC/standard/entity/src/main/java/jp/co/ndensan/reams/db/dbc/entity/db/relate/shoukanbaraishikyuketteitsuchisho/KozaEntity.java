/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shoukanbaraishikyuketteitsuchisho;

import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * ビジネス設計_DBCMN12028_償還払い支給（不支給）決定通知書作成（単）のEntity。
 *
 * @reamsid_L DBC-5310-030 jinge
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KozaEntity {

    private GyomuCode 業務コード;
    private SubGyomuCode サブ業務コード;
    private KamokuCode 科目コード;
    private RString 業務固有キー;
    private KozaYotoKubunCodeValue 用途区分;
}
