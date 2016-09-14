/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbb021051;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.lang.RString.EMPTY;

/**
 *
 * バッチ設計_DBB021051_宛名シール作成（介護賦課）の帳票用エンティティクラスです。
 *
 * @reamsid_L DBB-5660-030 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBZ100001AtenaSealEntity {

    private RString 郵便番号;
    private RString 行政区;
    private RString 住所TXT;
    private RString 方書2;
    private RString 方書1;
    private RString 代納区分名称;
    private RString 氏名2;
    private RString 氏名1;
    private RString 様分氏名2;
    private RString 様分氏名1;
    private RString 左括号1;
    private RString 左括号2;
    private RString 名称付与2;
    private RString 名称付与1;
    private RString 様分2;
    private RString 様分1;
    private RString 右括号1;
    private RString 右括号2;
    private RString バーコード住所;
    private ShikibetsuCode 識別コード;

    /**
     * DBZ100001AtenaSealEntityのコンストラクタです。
     */
    public DBZ100001AtenaSealEntity() {
        this.郵便番号 = EMPTY;
        this.行政区 = EMPTY;
        this.住所TXT = EMPTY;
        this.方書2 = EMPTY;
        this.方書1 = EMPTY;
        this.代納区分名称 = EMPTY;
        this.氏名2 = EMPTY;
        this.氏名1 = EMPTY;
        this.様分氏名2 = EMPTY;
        this.様分氏名1 = EMPTY;
        this.左括号1 = EMPTY;
        this.左括号2 = EMPTY;
        this.名称付与2 = EMPTY;
        this.名称付与1 = EMPTY;
        this.様分2 = EMPTY;
        this.様分1 = EMPTY;
        this.右括号1 = EMPTY;
        this.右括号2 = EMPTY;
        this.バーコード住所 = EMPTY;
        this.識別コード = ShikibetsuCode.EMPTY;
    }

}
