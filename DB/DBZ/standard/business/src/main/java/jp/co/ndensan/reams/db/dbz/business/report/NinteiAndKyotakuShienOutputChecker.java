/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report;

import jp.co.ndensan.reams.db.dbz.business.config.shikaku.HihokenshashoPrintConfig;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshaShikakuHakkoModel;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshashoModel;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 被保険者証の一部項目（認定情報・居宅支援事業者情報など）を印字するかしないかについて判定するためのクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteiAndKyotakuShienOutputChecker {

    private final HihokenshashoModel hihokenshashoModel;
    private final HihokenshashoPrintConfig printConfig;

    /**
     * コンストラクタです。
     *
     * @param hihokenshashoModel 被保険者証Model
     * @param printConfig 被保険者証表示方法コンフィグ
     */
    public NinteiAndKyotakuShienOutputChecker(HihokenshashoModel hihokenshashoModel, HihokenshashoPrintConfig printConfig) {
        requireNonNull(hihokenshashoModel, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証情報", getClass().getName()));
        requireNonNull(printConfig, UrSystemErrorMessages.引数がnullのため生成不可
                .getReplacedMessage("被保険者証表示方法コンフィグ", getClass().getName()));
        this.hihokenshashoModel = hihokenshashoModel;
        this.printConfig = printConfig;
    }

    /**
     * is居宅支援事業者表示
     *
     * @return boolean
     */
    public boolean is居宅支援事業者表示() {
        HihokenshaShikakuHakkoModel shikakuHakko = hihokenshashoModel.getShikakuHakko();
        FlexibleDate kofuDate = shikakuHakko.get交付日();

        FlexibleDate tekiyoKaishiDate = shikakuHakko.get支援事業者適用開始日().get(0);
        FlexibleDate tekiyoShuryoDate = shikakuHakko.get支援事業者適用終了日().get(0);
        if (tekiyoShuryoDate.isEmpty()) {
            tekiyoShuryoDate = FlexibleDate.MAX;
        }

        boolean is居宅適用継続中 = tekiyoKaishiDate.isBefore(kofuDate) && kofuDate.isBefore(tekiyoShuryoDate);
        return printConfig.is居宅支援事業者適用切れ表示有り() || is居宅適用継続中;
    }

    /**
     * is認定情報表示
     *
     * @return boolean
     */
    public boolean is認定情報表示() {
        HihokenshaShikakuHakkoModel shikakuHakko = hihokenshashoModel.getShikakuHakko();
        FlexibleDate kofuDate = shikakuHakko.get交付日();

        FlexibleDate yukoKaishiDate = shikakuHakko.get有効期間開始日();
        FlexibleDate yukoShuryoDate = shikakuHakko.get有効期間終了日();

        if (kofuDate.isEmpty() || yukoKaishiDate.isEmpty()) {
            return false;
        }

        if (yukoShuryoDate.isEmpty()) {
            yukoShuryoDate = FlexibleDate.MAX;
        }

        boolean is認定期間継続中 = yukoKaishiDate.isBefore(kofuDate) && kofuDate.isBefore(yukoShuryoDate);
        return printConfig.is要介護認定期限切れ表示有り() || is認定期間継続中;
    }
}
