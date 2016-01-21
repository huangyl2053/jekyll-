/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsutorokushalistbatch;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 年齢到達登録者リストのMyBatisパラメータ。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NenreiTotatsuTorokushaListMybatisParameter implements IMyBatisParameter {

    private final RString konkaikaishiYMDHMS;
    private final RString konkaishuryoYMDHMS;
    private final RString psmShikibetsuTaisho;

    /**
     * コンストラクタ。
     *
     * @param konkaikaishiYMDHMS 今回開始日時
     * @param konkaishuryoYMDHMS 今回終了日時
     * @param psmShikibetsuTaisho 宛名識別対象
     */
    public NenreiTotatsuTorokushaListMybatisParameter(
            RString konkaikaishiYMDHMS,
            RString konkaishuryoYMDHMS,
            RString psmShikibetsuTaisho) {

        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }
}
