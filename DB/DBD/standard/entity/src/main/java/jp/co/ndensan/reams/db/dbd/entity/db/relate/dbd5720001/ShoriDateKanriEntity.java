/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5720001;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタEntityクラスです。
 *
 * @reamsid_L DBD-1770-020 donghj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriDateKanriEntity {

    private int updateCount;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private SubGyomuCode subGyomuCode;
    private RString shoriName;
    private RString shoriEdaban;
    private FlexibleDate kijunYMD;
    private YMDHMS kijunTimestamp;
    private FlexibleDate taishoKaishiYMD;
    private FlexibleDate taishoShuryoYMD;
    private YMDHMS taishoKaishiTimestamp;
    private YMDHMS taishoShuryoTimestamp;

}
