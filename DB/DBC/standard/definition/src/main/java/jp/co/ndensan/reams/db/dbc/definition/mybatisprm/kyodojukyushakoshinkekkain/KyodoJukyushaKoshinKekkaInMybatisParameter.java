/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyodojukyushakoshinkekkain;

import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 共同処理用受給者情報一覧表のMybatisParameterクラスです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoJukyushaKoshinKekkaInMybatisParameter {

    private SubGyomuCode subGyomuCode;
    private RString chohyoBunruiID;
    private RString kanriNendo;
    private RString komokuName;

}
