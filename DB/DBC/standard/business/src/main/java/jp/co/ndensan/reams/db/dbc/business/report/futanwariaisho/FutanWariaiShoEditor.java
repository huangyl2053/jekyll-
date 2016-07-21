/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.futanwariaisho.FutanWariaiShoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 帳票設計_DBC100065_負担割合証Editor
 *
 * @reamsid_L DBC-5010-030 surun
 */
public class FutanWariaiShoEditor implements IFutanWariaiShoEditor {

    private final FutanWariaiShoEntity entity;
    private final NinshoshaSource sourceBuilder;

    /**
     * コンストラクタです。
     *
     * @param entity FutanWariaiShoEntity
     * @param sourceBuilder NinshoshaSource
     */
    public FutanWariaiShoEditor(FutanWariaiShoEntity entity, NinshoshaSource sourceBuilder) {
        this.entity = entity;
        this.sourceBuilder = sourceBuilder;
    }

    @Override
    public FutanWariaiShoSource edit(FutanWariaiShoSource source) {
        source.kofuYmd = entity.get交付年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.hihokenshaNo = entity.get被保険者番号();
        source.jusho = entity.get住所();
        source.kanaMei = entity.getカナ氏名();
        source.shimei = entity.get氏名();
        source.umareYmd = entity.get生年月日();
        source.seibetsu = entity.get性別();
        source.futanWariai1 = entity.get負担割合１();
        source.tekiyoKaishiYmd1 = entity.get適用開始年月日１().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.tekiyoShuryoYmd1 = entity.get適用終了年月日１().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.futanWariai2 = entity.get負担割合２();
        source.tekiyoKaishiYmd2 = entity.get適用開始年月日２().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.tekiyoShuryoYmd2 = entity.get適用終了年月日２().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
        source.hokenshaCode1 = entity.get保険者コード１();
        source.hokenshaCode2 = entity.get保険者コード２();
        source.hokenshaCode3 = entity.get保険者コード３();
        source.hokenshaCode4 = entity.get保険者コード４();
        source.hokenshaCode5 = entity.get保険者コード５();
        source.hokenshaCode6 = entity.get保険者コード６();
        source.hokenshaJusho = entity.get保険者住所();
        source.ninshosha_ninshoshaShimeiKakenai = entity.get保険者名();
        source.tel = entity.get保険者電話番号();
        source.ninshosha_denshiKoin = sourceBuilder.denshiKoin;
        source.renban = entity.get連番();
        source.ocrRenban = entity.getOcr連番();
        return source;
    }

}
