/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理日付管理entityクラスです。
 *
 */
public class ShorijyokyoEntity {

    private RString 処理名;
    private FlexibleDate 基準年月日;
    private YMDHMS 基準日時;

    public RString get処理名() {
        return 処理名;
    }

    public void set処理名(RString 処理名) {
        this.処理名 = 処理名;

    }

    public FlexibleDate get基準年月日() {
        return 基準年月日;
    }

    public void set基準年月日(FlexibleDate 基準年月日) {
        this.基準年月日 = 基準年月日;

    }

    public YMDHMS get基準日時() {
        return 基準日時;
    }

    public void set基準日時(YMDHMS 基準日時) {
        this.基準日時 = 基準日時;

    }

}
