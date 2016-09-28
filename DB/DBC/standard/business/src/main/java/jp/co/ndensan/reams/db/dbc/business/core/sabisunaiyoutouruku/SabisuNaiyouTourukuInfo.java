/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.sabisunaiyoutouruku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoservicenaiyou.KaigoServiceNaiyou;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBC4000011_サービス内容登録
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SabisuNaiyouTourukuInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    private KaigoServiceNaiyou サービス内容;
    private RString サービス分類コード;
    private RString サービス小分類;

}
