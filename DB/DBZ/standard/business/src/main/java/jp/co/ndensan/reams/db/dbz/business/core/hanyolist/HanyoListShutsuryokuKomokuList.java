/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.hanyolist;

import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputitemkanri.ShutsuryokuKomoku;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力項目リストのクラスです。
 *
 * @reamsid_L DBZ-4570-010 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShutsuryokuKomokuList {

    private RString 項目ID;
    private int 出力項目順位;
    private RString 省略区分;
    private int 出力項目文字数;
    private ShutsuryokuKomoku 出力項目日付区分;
    private RString 項目名称;
    private int 項目桁数;
    private int 項目位置;
    private RString 編集方法;
    private RString 金額編集;

}
