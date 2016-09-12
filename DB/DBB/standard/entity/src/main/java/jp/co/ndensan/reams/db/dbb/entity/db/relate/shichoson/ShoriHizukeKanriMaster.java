/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shichoson;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理マスタentity ShoriHizukeKanriMaster
 *
 * @reamsid_L DBB-1690-040 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriHizukeKanriMaster {

    private RString 処理状態;
    private RString 表示用処理状態;
    private YMDHMS 処理日時;
    private RString 処理区分;
}
