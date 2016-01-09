/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.jyukirendotorokushalistbatch;

import jp.co.ndensan.reams.db.dba.definition.processprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住基連動登録者リストバッチのパラメータ
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class JyukiRendoTorokushaListBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 1L;

    private static final String KEY_ZENKAIKAISHI_YMDHMS = "zenkaikaishiYMDHMS";
    private static final String KEY_ZENKAISHURYO_YMDHMS = "zenkaishuryoYMDHMS";
    private static final String KEY_KONKAIKAISHI_YMDHMS = "konkaikaishiYMDHMS";
    private static final String KEY_KONKAISHURYO_YMDHMS = "konkaishuryoYMDHMS";
    private static final String KEY_HIHOKENSHADAICHO_FLG = "hihokenshadaichoFLG";
    private static final String KEY_TAJUSHOCHITOKUREISHAKANRI_FLG = "tajushochitokureishakanriFLG";
    private static final String KEY_TEKIYOJOGAISHADAICHO_FLG = "tekiyojogaishadaichoFLG";
    private static final String KEY_SHUTURYOKUJUN_ID = "shuturyokujunID";

    @BatchParameter(key = KEY_ZENKAIKAISHI_YMDHMS, name = "前回開始日時")
    private RString zenkaikaishiYMDHMS;
    @BatchParameter(key = KEY_ZENKAISHURYO_YMDHMS, name = "前回終了日時")
    private RString zenkaishuryoYMDHMS;
    @BatchParameter(key = KEY_KONKAIKAISHI_YMDHMS, name = "今回開始日時")
    private RString konkaikaishiYMDHMS;
    @BatchParameter(key = KEY_KONKAISHURYO_YMDHMS, name = "今回終了日時")
    private RString konkaishuryoYMDHMS;
    @BatchParameter(key = KEY_HIHOKENSHADAICHO_FLG, name = "被保険者台帳フラグ")
    private boolean hihokenshadaichoFLG;
    @BatchParameter(key = KEY_TAJUSHOCHITOKUREISHAKANRI_FLG, name = "他住所地特例者管理フラグ")
    private boolean tajushochitokureishakanriFLG;
    @BatchParameter(key = KEY_TEKIYOJOGAISHADAICHO_FLG, name = "適用除外者台帳フラグ")
    private boolean tekiyojogaishadaichoFLG;
    @BatchParameter(key = KEY_SHUTURYOKUJUN_ID, name = "出力順ID")
    private RString shuturyokujunID;

    public JyukiRendoTorokushaListBatchProcessParameter toJyukiRendoTorokushaListBatchProcessParameter() {
        return new JyukiRendoTorokushaListBatchProcessParameter(
                zenkaikaishiYMDHMS,
                zenkaishuryoYMDHMS,
                konkaikaishiYMDHMS,
                konkaishuryoYMDHMS,
                hihokenshadaichoFLG,
                tajushochitokureishakanriFLG,
                tekiyojogaishadaichoFLG,
                shuturyokujunID);
    }
}
