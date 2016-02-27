/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka6;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.ShorijyokyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護徴収方法を管理するクラスです。
 */
public class ShorijyokyoJoho {

    private final ShorijyokyoEntity entity;

    /**
     * コンストラクタです。<br/>
     *
     * @param entity 処理日付管理entity
     */
    public ShorijyokyoJoho(ShorijyokyoEntity entity) {
        this.entity = entity;
    }

    /**
     * 処理名を取得します。
     *
     * @return 処理名
     */
    public RString get処理名() {
        return entity.get処理名();
    }

    /**
     * 処理名を設定します。
     *
     * @param 処理名 処理名
     */
    public void set処理名(RString 処理名) {
        entity.set処理名(処理名);

    }

    /**
     * 基準年月日を取得します。
     *
     * @return 基準年月日
     */
    public FlexibleDate get基準年月日() {
        return entity.get基準年月日();
    }

    /**
     * 基準年月日を設定します。
     *
     * @param 基準年月日 基準年月日
     */
    public void set基準年月日(FlexibleDate 基準年月日) {
        entity.set基準年月日(基準年月日);

    }

    /**
     * 基準日時を取得します。
     *
     * @return 基準日時
     */
    public YMDHMS get基準日時() {
        return entity.get基準日時();
    }

    /**
     * 基準日時を設定します。
     *
     * @param 基準日時 基準日時
     */
    public void set基準日時(YMDHMS 基準日時) {
        entity.set基準日時(基準日時);
    }

}
