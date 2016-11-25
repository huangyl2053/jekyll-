/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.GemmenGengakuRirekiList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.FutanGendogakuRirekiJyohoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.HyojunFutangakuGemmenJyohoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.RiyoshaFutangakuGengakuJyohoEntity;
import jp.co.ndensan.reams.db.dbc.business.core.gmmengngakurrekijoho.ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity;
import jp.co.ndensan.reams.db.dbc.definition.core.gemmengengakugirekijoho.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbc.service.core.gmmengngakurrekijoho.GemmenGengakuRirekiJyoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * GemmenGengakuRirekiList_減免・減額履歴情報のクラスです。
 *
 * @reamsid_L DBC-4350-030 liuxiaoyu
 */
public class GemmenGengakuRirekiListHandler {

    private final GemmenGengakuRirekiListDiv div;
    private static final int NUM_0 = 0;
    private static final RString 円 = new RString("\\");
    private static final RString 率 = new RString("%");

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public GemmenGengakuRirekiListHandler(GemmenGengakuRirekiListDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     *
     * @return GemmenGengakuRirekiListHandler
     */
    public static GemmenGengakuRirekiListHandler of(GemmenGengakuRirekiListDiv div) {
        return new GemmenGengakuRirekiListHandler(div);
    }

    /**
     * 減免・減額履歴情報画面のonLoadンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void onLoad(HihokenshaNo 被保険者番号) {
        GemmenGengakuRirekiJyoho gemmenJyoho = InstanceProvider.create(GemmenGengakuRirekiJyoho.class);
        dgFutanGendogakuList_Row fRow;
        List<dgFutanGendogakuList_Row> fRowList = new ArrayList<>();
        dgTaGemmenGengakuList_Row tRow;
        List<dgTaGemmenGengakuList_Row> tRowList = new ArrayList<>();

        List<FutanGendogakuRirekiJyohoEntity> fuList = gemmenJyoho.getFutanGendogakuRirekiJyoho(被保険者番号);
        List<ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity> shList = gemmenJyoho.getShakaiFukushiHojinRiyoshaFutanKeigenJyoho(被保険者番号);
        List<RiyoshaFutangakuGengakuJyohoEntity> riList = gemmenJyoho.getRiyoshaFutangakuGengakuJyoho(被保険者番号);
        List<HyojunFutangakuGemmenJyohoEntity> hyList = gemmenJyoho.getHyojunFutangakuGemmenJyoho(被保険者番号);

        for (FutanGendogakuRirekiJyohoEntity entity : fuList) {
            fRow = new dgFutanGendogakuList_Row();
            fRow.setGemmenGengakuShurui(GemmenGengakuShurui.toValue(entity.get減免_減額種類()).get名称());
            fRow.getTekiyoKaishiYMD().setValue(entity.get適用開始日());
            fRow.getTekiyoShuryoYMD().setValue(entity.get適用終了日());
            fRow.getShokuhiFutanGendogaku().setValue(entity.get食費負担限度額());
            fRow.getUnitKoshitsu().setValue(entity.getユニット型個室());
            fRow.getUnitJunkoshitsu().setValue(entity.getユニット型準個室());
            fRow.getJuraiKoshitsuTokuyo().setValue(entity.get従来型個室_特養等());
            fRow.getJuraiKoshitsuRokenRyoyo().setValue(entity.get従来型個室_老健_療養等());
            fRow.getTashoshitsu().setValue(entity.get多床室());
            fRowList.add(fRow);
        }

        for (HyojunFutangakuGemmenJyohoEntity entity : hyList) {
            tRow = new dgTaGemmenGengakuList_Row();
            tRow.setGemmenGengakuShurui(GemmenGengakuShurui.toValue(entity.get減免_減額種類()).get名称());
            tRow.getTekiyoKaishiYMD().setValue(entity.get適用開始日());
            tRow.getTekiyoShuryoYMD().setValue(entity.get適用終了日());
            tRow.getKyufuritsuKeigenritsuFutangaku().setValue(
                    entity.get負担額() == null
                            ? RString.EMPTY : 円.concat(DecimalFormatter.toコンマ区切りRString(entity.get負担額(), NUM_0)));
            tRowList.add(tRow);
        }
        for (RiyoshaFutangakuGengakuJyohoEntity entity : riList) {
            tRow = new dgTaGemmenGengakuList_Row();
            tRow.setGemmenGengakuShurui(GemmenGengakuShurui.toValue(entity.get減免_減額種類()).get名称());
            tRow.getTekiyoKaishiYMD().setValue(entity.get適用開始日());
            tRow.getTekiyoShuryoYMD().setValue(entity.get適用終了日());
            tRow.getKyufuritsuKeigenritsuFutangaku().setValue(
                    entity.get給付率() == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.get給付率().value(), NUM_0).concat(率));
            tRowList.add(tRow);
        }
        for (ShakaiFukushiHojinRiyoshaFutanKeigenJyohoEntity entity : shList) {
            tRow = new dgTaGemmenGengakuList_Row();
            tRow.setGemmenGengakuShurui(GemmenGengakuShurui.toValue(entity.get減免_減額種類()).get名称());
            tRow.getTekiyoKaishiYMD().setValue(entity.get適用開始日());
            tRow.getTekiyoShuryoYMD().setValue(entity.get適用終了日());
            tRow.getKyufuritsuKeigenritsuFutangaku().setValue(entity.get軽減率());

            tRowList.add(tRow);
        }

        div.getPnlFutangendogakuRireki().getDgFutanGendogakuList().setDataSource(fRowList);
        div.getPnlTaGemmenGengakuRireki().getDgTaGemmenGengakuList().setDataSource(tRowList);
    }
}
