/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriDateKanriEntity {

    private int updateCount;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private SubGyomuCode subGyomuCode;
    private LasdecCode shichosonCode;
    private RString shoriName;
    private RString nendoNaiRenban;
    private YMDHMS taishoKaishiTimestamp;
    private YMDHMS taishoShuryoTimestamp;

}
