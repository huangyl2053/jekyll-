/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 住基連動登録者リストのMyBatisパラメータ。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JyukiRendoTorokushaListBatchMybatisParameter implements IMyBatisParameter {

    private final RString konkaikaishiYMDHMS;
    private final RString konkaishuryoYMDHMS;
    private final RString loginId;

    /**
     * コンストラクタ。
     *
     * @param konkaikaishiYMDHMS 今回開始日時
     * @param konkaishuryoYMDHMS 今回終了日時
     */
    public JyukiRendoTorokushaListBatchMybatisParameter(RString konkaikaishiYMDHMS, RString konkaishuryoYMDHMS, RString loginId) {

        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.loginId = loginId;
    }
}
