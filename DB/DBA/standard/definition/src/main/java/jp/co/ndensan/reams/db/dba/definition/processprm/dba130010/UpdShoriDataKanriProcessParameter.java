/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba130010;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 異動チェックリストのパラメータクラスです。
 *
 * @reamsid_L DBA-0530-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdShoriDataKanriProcessParameter implements IBatchProcessParameter {

    private RDateTime zenkaiKaishi;
    private RDateTime zenkaiShuryo;
    private RDateTime konkaiKaishi;
    private RDateTime konkaiShuryo;

    /**
     * コンストラクタです。
     *
     * @param zenkaiKaishi 前回開始日時
     * @param zenkaiShuryo 前回終了日時
     * @param konkaiKaishi 今回開始日時
     * @param konkaiShuryo 今回終了日時
     */
    public UpdShoriDataKanriProcessParameter(
            RDateTime zenkaiKaishi, RDateTime zenkaiShuryo,
            RDateTime konkaiKaishi, RDateTime konkaiShuryo) {
        this.zenkaiKaishi = zenkaiKaishi;
        this.zenkaiShuryo = zenkaiShuryo;
        this.konkaiKaishi = konkaiKaishi;
        this.konkaiShuryo = konkaiShuryo;
    }

}
