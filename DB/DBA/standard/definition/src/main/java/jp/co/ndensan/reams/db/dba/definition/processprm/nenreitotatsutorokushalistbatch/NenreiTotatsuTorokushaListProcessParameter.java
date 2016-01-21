/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.nenreitotatsutorokushalistbatch;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsutorokushalistbatch.NenreiTotatsuTorokushaListMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 年齢到達登録者リストのバッチ処理クラスのパラメータ。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class NenreiTotatsuTorokushaListProcessParameter implements IBatchProcessParameter {

    private RString zenkaikaishiYMDHMS;
    private RString zenkaishuryoYMDHMS;
    private RString konkaikaishiYMDHMS;
    private RString konkaishuryoYMDHMS;
    private RString shuturyokujunID;
    private RString psmShikibetsuTaisho;

    /**
     * コンストラクタ。
     *
     * @param zenkaikaishiYMDHMS 前回開始日時
     * @param zenkaishuryoYMDHMS 前回終了日時
     * @param konkaikaishiYMDHMS 今回開始日時
     * @param konkaishuryoYMDHMS 今回終了日時
     * @param shuturyokujunID 出力順ID
     */
    public NenreiTotatsuTorokushaListProcessParameter(
            RString zenkaikaishiYMDHMS,
            RString zenkaishuryoYMDHMS,
            RString konkaikaishiYMDHMS,
            RString konkaishuryoYMDHMS,
            RString shuturyokujunID) {
        this.zenkaikaishiYMDHMS = zenkaikaishiYMDHMS;
        this.zenkaishuryoYMDHMS = zenkaishuryoYMDHMS;
        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.shuturyokujunID = shuturyokujunID;
    }

    public NenreiTotatsuTorokushaListMybatisParameter toNenreiTotatsushaTorokuListMybatisParameter() {
        return new NenreiTotatsuTorokushaListMybatisParameter(
                konkaikaishiYMDHMS,
                konkaishuryoYMDHMS,
                psmShikibetsuTaisho);
    }
}
