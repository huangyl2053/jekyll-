/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.shotokujohoichiranhyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象終了日時のパラメタ
 *
 * @reamsid_L DBB-1650-030 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShotokuJohoIchiranhyoParameter {

    private List<LasdecCode> 市町村コードリスト;
    private List<RString> 市町村識別IDリスト;
    private FlexibleYear 処理年度;
}
