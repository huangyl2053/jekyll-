/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichousasukejuru;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査スケジュール登録1RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NinteiChousaSukejuruRelateEntity {

    private int 全午前件数;
    private int 全午後件数;
    private int 午前の仮予約件数;
    private int 午後の仮予約件数;
    private int 午前の確定件数;
    private int 午後の確定件数;
    private FlexibleDate 認定調査予定年月日;
    private FlexibleDate メモ年月日;
    private int 通常メモ件数;
    private int 重要メモ件数;
}
