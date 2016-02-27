/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA1080011;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA1080011.dgNenreiTotatshusha_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 資格取得除外者登録のクラスです。
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JogaishaTorokuSetter implements Serializable {

    private static final long serialVersionUID = -2996208893201997484L;
    private List<dgNenreiTotatshusha_Row> viewState;
    private RString shikibetsuCode;
    private RString shikibetsuCodeName;
    private RString jogaiRiyu;
    private RDate jogaiKaijyoYMD;
    private RDate jogaiTekiyoYMD;
}
