/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力順情報RelateEntityクラスです。
 *
 * @reamsid_L DBZ-9999-021 duanzhanli
 */
@lombok.Getter
@lombok.Setter
public class ShutsuryokujunRelateEntity {

    private RString 出力順OrderBy;
    private List<RString> 出力順項目;
    private RString 出力順1;
    private RString 出力順2;
    private RString 出力順3;
    private RString 出力順4;
    private RString 出力順5;
    private List<RString> 改頁項目;
    private RString 改頁項目1;
    private RString 改頁項目2;
    private RString 改頁項目3;
    private RString 改頁項目4;
    private RString 改頁項目5;
    private List<RString> pageBreakKeys;
}
