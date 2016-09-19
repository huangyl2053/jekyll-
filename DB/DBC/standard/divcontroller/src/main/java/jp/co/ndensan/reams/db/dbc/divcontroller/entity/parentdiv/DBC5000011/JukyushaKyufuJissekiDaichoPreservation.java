/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5000011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 受給者給付実績一覧表発行.xlsx のDivControllerクラスです。
 *
 * @author DBC-3070-010 dangjingjing
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKyufuJissekiDaichoPreservation implements Serializable {

    private RString radKonkaiTaishoYM;
    private RString txtRangeYMFrom;
    private RString txtRangeYMTo;
    private RString txtRangeHihokenshaNoFrom;
    private RString txtRangeHihokenshaNoTo;
    private RString radKyufuJissekiKubun;
    private List<RString> chkYokaigodo;
    private List<RString> chkShutsuryokuYoshiki1;
    private List<RString> chkShutsuryokuYoshiki2;
    private List<RString> chkShutsuryokuYoshiki3;
    private List<RString> chkShutsuryokuYoshiki4;
    private List<RString> chkShutsuryokuYoshiki5;

}
