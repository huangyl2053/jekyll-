/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.nenreitotatsutorokushalistbatch;

import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 年齢到達登録者リストのMyBatisパラメータ。
 *
 * @reamsid_L DBA-0570-040 xuyannan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class NenreiTotatsuTorokushaListMybatisParameter
        extends UaFt200FindShikibetsuTaishoParam implements IMyBatisParameter {

    private final RString konkaikaishiYMDHMS;
    private final RString konkaishuryoYMDHMS;
    private final RString psmShikibetsuTaisho;
    private final Code shutokuJiyu_Hihokensha;
    private final List<Code> soshitsuJiyu_Hihokensha;
    private final Code henkoJiyu_Hihokensha;
    private final List<Code> jutokuTekiyo;
    private final List<Code> jutokuKaijo;
    private final RString shutsuryokuSort;

    private final Boolean userShutsuryokuSort;

    /**
     * コンストラクタ。
     *
     * @param konkaikaishiYMDHMS 今回開始日時
     * @param konkaishuryoYMDHMS 今回終了日時
     * @param psmShikibetsuTaisho 宛名識別対象
     * @param shutokuJiyu_Hihokensha 介護資格取得事由（被保険者）
     * @param soshitsuJiyu_Hihokensha 介護資格喪失事由（被保険者）
     * @param henkoJiyu_Hihokensha 介護資格変更事由（被保険者）
     * @param jutokuTekiyo 介護資格住特適用
     * @param jutokuKaijo 介護資格住特解除
     * @param shutsuryokuSort 出力順
     * @param userShutsuryokuSort uses出力順
     * @param key 宛名PSMキー
     */
    public NenreiTotatsuTorokushaListMybatisParameter(
            RString konkaikaishiYMDHMS,
            RString konkaishuryoYMDHMS,
            RString psmShikibetsuTaisho,
            Code shutokuJiyu_Hihokensha,
            List<Code> soshitsuJiyu_Hihokensha,
            Code henkoJiyu_Hihokensha,
            List<Code> jutokuTekiyo,
            List<Code> jutokuKaijo,
            RString shutsuryokuSort,
            Boolean userShutsuryokuSort,
            IShikibetsuTaishoPSMSearchKey key) {
        super(key);
        if (Boolean.FALSE.equals(userShutsuryokuSort)) {
            shutsuryokuSort = new RString("");
        }
        this.konkaikaishiYMDHMS = konkaikaishiYMDHMS;
        this.konkaishuryoYMDHMS = konkaishuryoYMDHMS;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.shutokuJiyu_Hihokensha = shutokuJiyu_Hihokensha;
        this.soshitsuJiyu_Hihokensha = soshitsuJiyu_Hihokensha;
        this.henkoJiyu_Hihokensha = henkoJiyu_Hihokensha;
        this.jutokuTekiyo = jutokuTekiyo;
        this.jutokuKaijo = jutokuKaijo;
        this.shutsuryokuSort = shutsuryokuSort;

        this.userShutsuryokuSort = userShutsuryokuSort;
    }
}
