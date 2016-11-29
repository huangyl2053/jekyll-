/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba140010;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch.JyukiRendoTorokushaListBatchMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 住基連動登録者リストのバッチ処理クラスのパラメータ。
 *
 * @reamsid_L DBA-0560-020 xuyannan
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
    private Long shuturyokujunID;
    private RString loginId;
    private List<Code> shutokuJiyu_Hihokensha;
    private List<Code> tekiyoJiyu_TaTokureisha;
    private List<Code> tekiyoJiyu_Jogaisha;
    private List<Code> soshitsuJiyu_Hihokensha;
    private List<Code> kaijoJiyu_TaTokureisha;
    private List<Code> kaijoJiyu_Jogaisha;
    private List<Code> henkoJiyu_Hihokensha;
    private List<Code> jutokuTekiyo;
    private List<Code> jutokuKaijo;
    private Code idouJiyu_tennyu;
    private Code idouJiyu_tensyutu;
    private Code idouJiyu_sibou;
    private Code idouJiyu_tenkyo;
    private RString psmShikibetsuTaisho;

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
     * @param loginId LOGINユーザID
     */
    public JyukiRendoTorokushaListBatchProcessParameter(
            RString zenkaikaishiYMDHMS,
            RString zenkaishuryoYMDHMS,
            RString konkaikaishiYMDHMS,
            RString konkaishuryoYMDHMS,
            boolean hihokenshadaichoFLG,
            boolean tajushochitokureishakanriFLG,
            boolean tekiyojogaishadaichoFLG,
            Long shuturyokujunID,
            RString loginId) {
        this.zenkaikaishiYMDHMS = zenkaikaishiYMDHMS;
        this.zenkaishuryoYMDHMS = zenkaishuryoYMDHMS;
        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.hihokenshadaichoFLG = hihokenshadaichoFLG;
        this.tajushochitokureishakanriFLG = tajushochitokureishakanriFLG;
        this.tekiyojogaishadaichoFLG = tekiyojogaishadaichoFLG;
        this.shuturyokujunID = shuturyokujunID;
        this.loginId = loginId;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param shutsuryokujun 出力順
     * @param key 宛名キー
     * @return JyukiRendoTorokushaListBatchMybatisParameter
     */
    public JyukiRendoTorokushaListBatchMybatisParameter toJyukiRendoTorokushaListBatchMybatisParameter(
            RString shutsuryokujun,
            IShikibetsuTaishoPSMSearchKey key) {
        Boolean shutsuryokujunFlg = true;
        if (shutsuryokujun == null || shutsuryokujun.isEmpty()) {

            shutsuryokujunFlg = false;
        }
        return new JyukiRendoTorokushaListBatchMybatisParameter(
                konkaikaishiYMDHMS,
                konkaishuryoYMDHMS,
                loginId,
                shutokuJiyu_Hihokensha,
                tekiyoJiyu_TaTokureisha,
                tekiyoJiyu_Jogaisha,
                soshitsuJiyu_Hihokensha,
                kaijoJiyu_TaTokureisha,
                kaijoJiyu_Jogaisha,
                henkoJiyu_Hihokensha,
                jutokuTekiyo,
                jutokuKaijo,
                idouJiyu_tennyu,
                idouJiyu_tensyutu,
                idouJiyu_sibou,
                idouJiyu_tenkyo,
                shutsuryokujun,
                shutsuryokujunFlg,
                key
        );
    }
}
