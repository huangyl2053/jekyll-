/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shinnendokanrijohosakusei;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBB9010001_新年度管理情報作成のハンドラクラスです。
 *
 * @reamsid_L DBB-5721-010 chenyadong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinNendoKanriJohoSakuseiEntity {

    private RString schemaName;
    private SubGyomuCode subGyomuCode;
    private RString configName;
    private RString optionKeyword;
    private RDate effectiveDate;
    private RString configValue;
    private RString changeLog;
    private RDateTime insertTimestamp;
    private LasdecCode lasdecCode;
}
