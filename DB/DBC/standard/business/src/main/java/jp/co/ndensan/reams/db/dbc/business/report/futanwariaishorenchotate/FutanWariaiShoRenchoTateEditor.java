/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.futanwariaishorenchotate;

import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishokattokami.FutanWariaiShoKattokamiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.futanwariaishorenchotate.FutanWariaiShoRenchoTateSource;

/**
 * 帳票設計_DBC100066_負担割合証（連帳・縦）のEditorです。
 *
 * @reamsid_L DBC-4990-050 pengxingyi
 */
public class FutanWariaiShoRenchoTateEditor implements IFutanWariaiShoRenchoTateEditor {

    private final FutanWariaiShoKattokamiEntity entity;

    /**
     * インスタンスを生成します。
     *
     * @param entity {@link FutanWariaiShoKattokamiEntity}
     */
    public FutanWariaiShoRenchoTateEditor(FutanWariaiShoKattokamiEntity entity) {
        this.entity = entity;
    }

    @Override
    public FutanWariaiShoRenchoTateSource edit(FutanWariaiShoRenchoTateSource source) {
        source.kofuYmd = entity.get交付年月日();
        source.hihokenshaNo = entity.get被保険者番号();
        source.jusho = entity.get住所();
        source.kanaMei = entity.getカナ氏名();
        source.shimei = entity.get氏名();
        source.umareYmd = entity.get生年月日();
        source.seibetsu = entity.get性別();
        source.tekiyoKaishiYmd1 = entity.get適用開始年月日１();
        source.futanWariai1 = entity.get負担割合１();
        source.tekiyoShuryoYmd1 = entity.get適用終了年月日１();
        source.tekiyoKaishiYmd2 = entity.get適用開始年月日２();
        source.futanWariai2 = entity.get負担割合２();
        source.tekiyoShuryoYmd2 = entity.get適用終了年月日２();
        source.hokenshaCode1 = entity.get保険者コード１();
        source.hokenshaCode2 = entity.get保険者コード２();
        source.hokenshaCode3 = entity.get保険者コード３();
        source.hokenshaCode4 = entity.get保険者コード４();
        source.hokenshaCode5 = entity.get保険者コード５();
        source.hokenshaCode6 = entity.get保険者コード６();
        source.hokenshaJusho = entity.get保険者住所();
        source.ninshosha_ninshoshaShimeiKakenai = entity.get保険者名();
        source.tel = entity.get保険者電話番号();
        source.ninshosha_denshiKoin = entity.get電子公印();
        source.renban = entity.get連番();
        source.ocrRenban = entity.getOcr連番();
        source.compSofubutsuAtesakiSource = entity.get送付物宛先();
        return source;
    }

}
