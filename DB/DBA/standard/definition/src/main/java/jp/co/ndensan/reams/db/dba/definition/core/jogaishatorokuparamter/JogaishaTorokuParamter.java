/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.core.jogaishatorokuparamter;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 資格取得除外者登録パラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JogaishaTorokuParamter implements Serializable {

    private static final long serialVersionUID = -7667515892539653512L;

    private RString lasdecCode;
    private RString lasdecMei;
    private RString shikibetsuCode;
    private RString rirekiNo;
    private RString shimei;
    private FlexibleDate dateOfBirth;
    private RString gender;
    private RString juminJotai;
    private RString jogaiRiyu;
    private RDate jogaiTekiyoDate;
    private RDate jogaiKaijyoDate;
    private RowState rowState;
}
