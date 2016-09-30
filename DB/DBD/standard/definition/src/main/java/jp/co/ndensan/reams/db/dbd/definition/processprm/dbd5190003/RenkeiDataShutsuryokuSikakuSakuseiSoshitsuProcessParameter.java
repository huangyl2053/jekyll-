/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5190003;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd5190003.RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 資格喪失（死亡）データ作成のプロセスパラメータ。
 *
 * @reamsid_L DBD-2110-010 LDNS shaotw
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter implements IBatchProcessParameter {

    private RDateTime konkaikaishidatetime;
    private RDateTime konkaishoridatetime;
    private RString hanteiiraiichiranhyou;
    private RString newfilename;

    /**
     * コンストラクタ。
     *
     * @param konkaikaishidatetime RDateTime
     * @param konkaishoridatetime RDateTime
     * @param hanteiiraiichiranhyou RString
     * @param newfilename RString
     */
    public RenkeiDataShutsuryokuSikakuSakuseiSoshitsuProcessParameter(RDateTime konkaikaishidatetime,
            RDateTime konkaishoridatetime, RString hanteiiraiichiranhyou, RString newfilename) {
        this.konkaikaishidatetime = konkaikaishidatetime;
        this.konkaishoridatetime = konkaishoridatetime;
        this.hanteiiraiichiranhyou = hanteiiraiichiranhyou;
        this.newfilename = newfilename;
    }

    /**
     * Mybatisパラメータの作成。
     *
     * @param key IShikibetsuTaishoPSMSearchKey
     * @return RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter
     */
    public RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter toRenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter(
            IShikibetsuTaishoPSMSearchKey key) {
        return new RenkeiDataShutsuryokuSikakuSakuseiSoshitsuMybatisParameter(
                new FlexibleDate(konkaikaishidatetime.getDate().toDateString()),
                new FlexibleDate(konkaishoridatetime.getDate().toDateString()), key);
    }
}
