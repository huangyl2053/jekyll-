/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 事務所の場合で認定調査スケジュール情報戻るのEntity。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JiMuSyoEntity {

    private FlexibleDate temp_ninteiChosaYoteiYMD;
    private RString 空きの午前イメージ;
    private int 空きの午前件数;
    private RString 空きの午後イメージ;
    private int 空きの午後件数;
    private RString 仮予約の午前イメージ;
    private int 仮予約の午前件数;
    private RString 仮予約の午後イメージ;
    private int 仮予約の午後件数;
    private RString 確定の午前イメージ;
    private int 確定の午前件数;
    private RString 確定の午後イメージ;
    private int 確定の午後件数;
}
