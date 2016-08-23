/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * センター送信データ出力OutputEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterTransmissionOutputEntity {

    private List<RString> 出力された申請書管理番号;
}
