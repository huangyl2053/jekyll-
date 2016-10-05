/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kaigoshiensenmoninjouhou;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護支援専門員登録画面 Parameterクラスです。
 *
 * @reamsid_L DBC-3370-010 yuqingzhang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KaigoShienSenmoninJouhouParameter {

    private RString 介護支援専門員番号;
    private RString 所属事業者番号;
    private RString カナ氏名;
    private RString 漢字氏名;
    private RString 有効開始年月日;
    private RString 有効終了年月日;
    private int 最大表示件数;
    private boolean isカナ氏名の前方一致;
    private boolean is漢字氏名の前方一致;
}
