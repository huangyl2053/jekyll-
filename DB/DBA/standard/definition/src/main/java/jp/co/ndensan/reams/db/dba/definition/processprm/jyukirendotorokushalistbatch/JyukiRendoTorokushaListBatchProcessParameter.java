/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.jyukirendotorokushalistbatch;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住基連動登録者リストのバッチ処理クラスのパラメータ。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JyukiRendoTorokushaListBatchProcessParameter implements IBatchProcessParameter {

    private RString zenkaikaishiYMDHMS;
    private RString zenkaishuryoYMDHMS;
    private RString konkaikaishiYMDHMS;
    private RString konkaishuryoYMDHMS;
    private boolean hihokenshadaichoFLG;
    private boolean tajushochitokureishakanriFLG;
    private boolean tekiyojogaishadaichoFLG;
    private RString shuturyokujunID;
    private RString loginId;

    /**
     * コンストラクタ。
     *
     * @param zenkaikaishiYMDHMS 前回開始日時
     * @param zenkaishuryoYMDHMS 前回終了日時
     * @param konkaikaishiYMDHMS 今回開始日時
     * @param konkaishuryoYMDHMS 今回終了日時
     * @param hihokenshadaichoFLG 被保険者台帳フラグ
     * @param tajushochitokureishakanriFLG 他住所地特例者管理フラグ
     * @param tekiyojogaishadaichoFLG 適用除外者台帳フラグ
     * @param shuturyokujunID 出力順ID
     */
    public JyukiRendoTorokushaListBatchProcessParameter(
            RString zenkaikaishiYMDHMS,
            RString zenkaishuryoYMDHMS,
            RString konkaikaishiYMDHMS,
            RString konkaishuryoYMDHMS,
            boolean hihokenshadaichoFLG,
            boolean tajushochitokureishakanriFLG,
            boolean tekiyojogaishadaichoFLG,
            RString shuturyokujunID) {
        this.zenkaikaishiYMDHMS = zenkaikaishiYMDHMS;
        this.zenkaishuryoYMDHMS = zenkaishuryoYMDHMS;
        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.hihokenshadaichoFLG = hihokenshadaichoFLG;
        this.tajushochitokureishakanriFLG = tajushochitokureishakanriFLG;
        this.tekiyojogaishadaichoFLG = tekiyojogaishadaichoFLG;
        this.shuturyokujunID = shuturyokujunID;
    }

    public JyukiRendoTorokushaListBatchMybatisParameter toJyukiRendoTorokushaListBatchMybatisParameter() {
        return new JyukiRendoTorokushaListBatchMybatisParameter(konkaikaishiYMDHMS, konkaishuryoYMDHMS, loginId);
    }
}
