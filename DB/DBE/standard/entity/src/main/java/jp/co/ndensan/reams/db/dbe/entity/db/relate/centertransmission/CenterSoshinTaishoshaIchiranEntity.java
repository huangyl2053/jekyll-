/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;

/**
 * 完了処理・センター送信Report用のentityクラスです。
 *
 * @reamsid_L DBE_1520_DBEMN91010 n8466
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterSoshinTaishoshaIchiranEntity {

    private RString printTimeStamp;
    private RString listTaishoshaIchiran_1;
    private RString listTaishoshaIchiran_2;
    private RString listTaishoshaIchiran_3;
    private RString listTaishoshaIchiran_4;
    private RString listTaishoshaIchiran_5;
    private RString listTaishoshaIchiran_6;
    private RString listTaishoshaIchiran_7;
    private RString listTaishoshaIchiran_8;
    private RString listTaishoshaIchiran_9;
    private RString listTaishoshaIchiran_10;
    private RString listTaishoshaIchiran_11;

    private ShikibetsuCode shikibetsuCode;
    private ExpandedInformation expandedInformation;

    public void setPrintTimeStamp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
