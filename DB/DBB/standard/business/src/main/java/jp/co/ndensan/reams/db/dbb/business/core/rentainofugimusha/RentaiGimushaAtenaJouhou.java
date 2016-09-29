/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.rentainofugimusha;

import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KojinNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 連帯納付義務者宛名情報のEntity
 *
 * @reamsid_L DBB-1640-020 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RentaiGimushaAtenaJouhou {

    private FlexibleDate 開始日;
    private FlexibleDate 終了日;
    private ShikibetsuCode 識別コード;
    private KojinNo 個人番号;
    private SetaiCode 世帯コード;
    private AtenaMeisho 氏名;
    private FlexibleDate 生年月日;
    private RString 性別;
    private RString 住民種別;
    private RString 続柄;
    private AtenaJusho 住所;
    private EntityDataState 状態;
    private int 履歴番号;
}
