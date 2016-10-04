/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteitsuchihakko;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicehishikyuketteitsuchisho.KogakuShikyuFushikyuKetteiTsuchiHakkoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakushikyufushikyuketteitsuchihakkoichiran.KogakuShikyuFushikyuKetteiTsuchiHakkoSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費支給（不支給）決定通知一覧表BodyEditorクラスです。
 *
 * @reamsid_L DBC-2000-080 wangxingpeng
 */
public class KogakuShikyuFushikyuKetteiTsuchiHakkoBodyEditor implements IKogakuShikyuFushikyuKetteiTsuchiHakkoEditor {

    // private static final RString 支給計 = new RString("支給計");
    private final KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity;
    private final int 連番;

    /**
     * コンストラクタです
     *
     * @param entity KogakuShikyuFushikyuKetteiTsuchiHakkoEntity
     * @param 連番 int
     */
    public KogakuShikyuFushikyuKetteiTsuchiHakkoBodyEditor(KogakuShikyuFushikyuKetteiTsuchiHakkoEntity entity, int 連番) {
        this.entity = entity;
        this.連番 = 連番;
    }

    @Override
    public KogakuShikyuFushikyuKetteiTsuchiHakkoSource edit(KogakuShikyuFushikyuKetteiTsuchiHakkoSource source) {
        source.listUpper_1 = new RString(連番);
        source.listUpper_2 = entity.get決定通知No();
        source.listUpper_3 = entity.get被保険者番号();
        source.listUpper_4 = entity.get被保険者氏名();
        source.listUpper_5 = entity.get郵便番号();
        source.listLower_1 = entity.get住所();
        source.listUpper_6 = entity.get提供年月();
        source.listLower_2 = entity.get要介護度();
        source.listUpper_7 = entity.get認定開始日();
        source.listLower_3 = entity.get認定終了日();
        source.listUpper_8 = entity.get受付年月日();
        source.listLower_4 = entity.get決定年月日();
        source.listUpper_9 = entity.get本人支払額();
        source.listLower_5 = entity.get支給額();
        source.listUpper_10 = entity.get支給_不支給_決定区分();
        source.listUpper_11 = entity.get資格喪失日();
        source.listUpper_12 = entity.get自動償還();
        // source.listUpper_7 = 支給計;
        // source.listUpper_8 = entity.get支給総件数();
        // source.listUpper_9 = entity.get本人支給額合計();
        source.listLower_7 = entity.get喪失事由();
        return source;
    }
}
