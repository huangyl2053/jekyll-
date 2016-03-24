/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.honsanteiidogennen;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 出力帳票一覧のクラスです。
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChohyoMeter implements Serializable {

    private ReportId 帳票分類ID;
    private RString 出力順ID;
}
