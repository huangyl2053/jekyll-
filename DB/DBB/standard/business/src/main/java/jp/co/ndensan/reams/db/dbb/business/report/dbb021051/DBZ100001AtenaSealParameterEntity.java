/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbb021051;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）の帳票用エンティティクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBZ100001AtenaSealParameterEntity {

    private RString 市町村コード;
    private RString 市町村名称;
    private RString タイトル;
    private RString 作成日;
    private List<DBZ100001AtenaSealEntity> entityList;
}
