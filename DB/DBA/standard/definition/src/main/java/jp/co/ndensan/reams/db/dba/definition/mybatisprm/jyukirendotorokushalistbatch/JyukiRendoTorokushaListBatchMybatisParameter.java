/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.jyukirendotorokushalistbatch;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 住基連動登録者リストのMyBatisパラメータ。
 *
 * @reamsid_L DBA-0560-020 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class JyukiRendoTorokushaListBatchMybatisParameter implements IMyBatisParameter {

    private final RString konkaikaishiYMDHMS;
    private final RString konkaishuryoYMDHMS;
    private final RString loginId;
    private final List<Code> shutokuJiyu_Hihokensha;
    private final List<Code> tekiyoJiyu_TaTokureisha;
    private final List<Code> tekiyoJiyu_Jogaisha;
    private final List<Code> soshitsuJiyu_Hihokensha;
    private final List<Code> kaijoJiyu_TaTokureisha;
    private final List<Code> kaijoJiyu_Jogaisha;
    private final List<Code> henkoJiyu_Hihokensha;
    private final List<Code> jutokuTekiyo;
    private final List<Code> jutokuKaijo;
    private final Code idouJiyu_tennyu;
    private final Code idouJiyu_tensyutu;
    private final Code idouJiyu_sibou;
    private final Code idouJiyu_tenkyo;

    /**
     * コンストラクタ。
     *
     * @param konkaikaishiYMDHMS 今回開始日時
     * @param konkaishuryoYMDHMS 今回終了日時
     * @param loginId 登録者ID
     * @param shutokuJiyu_Hihokensha 介護資格取得事由（被保険者）
     * @param tekiyoJiyu_TaTokureisha 介護資格適用事由（他特例者）
     * @param tekiyoJiyu_Jogaisha 介護資格適用事由（除外者）
     * @param soshitsuJiyu_Hihokensha 介護資格喪失事由（被保険者）
     * @param kaijoJiyu_TaTokureisha 介護資格解除事由（他特例者）
     * @param kaijoJiyu_Jogaisha 介護資格解除事由（除外者）
     * @param henkoJiyu_Hihokensha 介護資格変更事由（被保険者）
     * @param jutokuTekiyo 介護資格住特適用
     * @param jutokuKaijo 介護資格住特解除
     * @param idouJiyu_tennyu 異動事由（転入）転入
     * @param idouJiyu_tensyutu 異動事由（転出）
     * @param idouJiyu_sibou 異動事由（死亡）
     * @param idouJiyu_tenkyo 異動事由（転居）
     */
    public JyukiRendoTorokushaListBatchMybatisParameter(
            RString konkaikaishiYMDHMS,
            RString konkaishuryoYMDHMS,
            RString loginId,
            List<Code> shutokuJiyu_Hihokensha,
            List<Code> tekiyoJiyu_TaTokureisha,
            List<Code> tekiyoJiyu_Jogaisha,
            List<Code> soshitsuJiyu_Hihokensha,
            List<Code> kaijoJiyu_TaTokureisha,
            List<Code> kaijoJiyu_Jogaisha,
            List<Code> henkoJiyu_Hihokensha,
            List<Code> jutokuTekiyo,
            List<Code> jutokuKaijo,
            Code idouJiyu_tennyu,
            Code idouJiyu_tensyutu,
            Code idouJiyu_sibou,
            Code idouJiyu_tenkyo) {

        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.loginId = loginId;
        this.shutokuJiyu_Hihokensha = shutokuJiyu_Hihokensha;
        this.tekiyoJiyu_TaTokureisha = tekiyoJiyu_TaTokureisha;
        this.tekiyoJiyu_Jogaisha = tekiyoJiyu_Jogaisha;
        this.soshitsuJiyu_Hihokensha = soshitsuJiyu_Hihokensha;
        this.kaijoJiyu_TaTokureisha = kaijoJiyu_TaTokureisha;
        this.kaijoJiyu_Jogaisha = kaijoJiyu_Jogaisha;
        this.henkoJiyu_Hihokensha = henkoJiyu_Hihokensha;
        this.jutokuTekiyo = jutokuTekiyo;
        this.jutokuKaijo = jutokuKaijo;
        this.idouJiyu_tennyu = idouJiyu_tennyu;
        this.idouJiyu_tensyutu = idouJiyu_tensyutu;
        this.idouJiyu_sibou = idouJiyu_sibou;
        this.idouJiyu_tenkyo = idouJiyu_tenkyo;
    }
}
