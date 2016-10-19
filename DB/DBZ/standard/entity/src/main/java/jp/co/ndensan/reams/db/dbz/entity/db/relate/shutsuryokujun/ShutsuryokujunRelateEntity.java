/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医医療機関情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class ShutsuryokujunRelateEntity {

    private RString 出力順OrderBy;
    private List<RString> 出力順項目;
    private List<RString> 改頁項目;
    private List<RString> pageBreakKeys;
}
