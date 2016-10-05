/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.shakaifukushihojinkeigen.GemmenKubun;
import jp.co.ndensan.reams.db.dbd.service.core.shakaifukushihojinkeigen.ShakaiFukushiHojinKeigenFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 【共有子Div】 社会福祉法人軽減ハンドラクラスです。
 *
 * @reamsid_L DBD-3560-050 wangjie2
 */
public class ShakaiFukushiHojinKeigenHandler {

    private final ShakaiFukushiHojinKeigenDiv div;
    private final RString 制限あり = new RString("制限あり");

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】社会福祉法人軽減Div
     */
    public ShakaiFukushiHojinKeigenHandler(ShakaiFukushiHojinKeigenDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<ShakaifukuRiyoshaFutanKeigen> onLoad(HihokenshaNo 被保険者番号) {
        ShakaiFukushiHojinKeigenFinder finder = ShakaiFukushiHojinKeigenFinder.createIntance();
        List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報 = finder.get申請一覧_社会福祉法人等利用者負担軽減の情報(被保険者番号);
        if (!申請一覧情報.isEmpty()) {
            画面初期化表示(申請一覧情報);
        }
        return 申請一覧情報;
    }

    private void 画面初期化表示(List<ShakaifukuRiyoshaFutanKeigen> 申請一覧情報) {
        List<dgShakaiFukushiHojinKeigenList_Row> dataSourceList = new ArrayList<>();
        for (ShakaifukuRiyoshaFutanKeigen 申請情報 : 申請一覧情報) {
            dgShakaiFukushiHojinKeigenList_Row dataSource = getDataSourceList(申請情報);
            dataSourceList.add(dataSource);
        }
        div.getDgShakaiFukushiHojinKeigenList().setDataSource(dataSourceList);
        div.getShakaiFukushiHojinKeigenDetail().setDisplayNone(true);
    }

    private dgShakaiFukushiHojinKeigenList_Row getDataSourceList(ShakaifukuRiyoshaFutanKeigen 申請情報) {
        dgShakaiFukushiHojinKeigenList_Row dataSource = new dgShakaiFukushiHojinKeigenList_Row();
        dataSource.setKakuninNo(申請情報.get確認番号());
        TextBoxFlexibleDate 申請日 = new TextBoxFlexibleDate();
        申請日.setValue(申請情報.get申請年月日());
        dataSource.setShinseiDate(申請日);
        if (申請情報.get適用開始年月日() != null) {
            TextBoxFlexibleDate 適用日 = new TextBoxFlexibleDate();
            適用日.setValue(申請情報.get適用開始年月日());
            dataSource.setTekiyoDate(適用日);
        }
        if (申請情報.get適用終了年月日() != null) {
            TextBoxFlexibleDate 有効期限 = new TextBoxFlexibleDate();
            有効期限.setValue(申請情報.get適用終了年月日());
            dataSource.setYukoKigen(有効期限);
        }
        if (申請情報.get決定区分() != null && !申請情報.get決定区分().isEmpty()) {
            dataSource.setKetteiKubun(KetteiKubun.toValue(申請情報.get決定区分()).get名称());
        }
        if (申請情報.get決定年月日() != null) {
            TextBoxFlexibleDate 決定日 = new TextBoxFlexibleDate();
            決定日.setValue(申請情報.get決定年月日());
            dataSource.setKetteiDate(決定日);
        }
        if (申請情報.get軽減率_分子() != null) {
            TextBoxNum 軽減率_分子 = new TextBoxNum();
            軽減率_分子.setValue(申請情報.get軽減率_分子());
            dataSource.setKeigenRitsuBunshi(軽減率_分子);
        }
        if (申請情報.get軽減率_分母() != null) {
            TextBoxNum 軽減率_分母 = new TextBoxNum();
            軽減率_分母.setValue(申請情報.get軽減率_分母());
            dataSource.setKeigenRitsuBunbo(軽減率_分母);
        }
        if (申請情報.get軽減率_分子() != null && 申請情報.get軽減率_分母() != null) {
            dataSource.setKeigenRitsu(new RString(申請情報.get軽減率_分子().toString()).concat("/").concat(申請情報.get軽減率_分母().toString()));
        }
        if (申請情報.get減免区分() != null) {
            dataSource.setKeigenJiyu(GemmenKubun.toValue(申請情報.get減免区分()).get名称());
        }
        dataSource.setKyotakuServiceOnly(get制限(申請情報.is居宅サービス限定()));
        dataSource.setKyojuhiShokujiOnly(get制限(申請情報.is居住費_食費のみ()));
        dataSource.setUnitPrivateRoomOnly(get制限(申請情報.is旧措置者ユニット型個室のみ()));
        dataSource.setFushoninRiyu(申請情報.get非承認理由());
        return dataSource;
    }

    private RString get制限(boolean is制限あり) {
        return is制限あり ? 制限あり : RString.EMPTY;
    }

    /**
     * 一覧を選択し、詳細を表示ます。。
     *
     */
    public void 一覧の詳細表示() {
        div.getShakaiFukushiHojinKeigenDetail().setDisplayNone(false);
        dgShakaiFukushiHojinKeigenList_Row dataSource = div.getDgShakaiFukushiHojinKeigenList().getActiveRow();
        set社会福祉法人軽減詳細パネル(dataSource);
        set社会福祉法人軽減利用者負担パネル(dataSource);
    }

    private void set社会福祉法人軽減詳細パネル(dgShakaiFukushiHojinKeigenList_Row dataSource) {
        if (dataSource.getShinseiDate() != null) {
            div.getShakaiFukushiHojinKeigenDetail().getTxtShinseiDate().setValue(dataSource.getShinseiDate().getValue());
        }
        div.getShakaiFukushiHojinKeigenDetail().getTxtKyotakuServiceOnly().setValue(dataSource.getKyotakuServiceOnly());
        div.getShakaiFukushiHojinKeigenDetail().getTxtKyojuhiShokujiOnly().setValue(dataSource.getKyojuhiShokujiOnly());
        div.getShakaiFukushiHojinKeigenDetail().getTxtUnitPrivateRoomOnly().setValue(dataSource.getUnitPrivateRoomOnly());
    }

    private void set社会福祉法人軽減利用者負担パネル(dgShakaiFukushiHojinKeigenList_Row dataSource) {
        if (dataSource.getKetteiDate() != null) {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKetteiDate().setValue(dataSource.getKetteiDate().getValue());
        } else {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKetteiDate().clearValue();
        }
        div.getShakaiFukushiHojinKeigenDetail()
                .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKetteiKubun().setValue(dataSource.getKetteiKubun());
        if (dataSource.getTekiyoDate() != null) {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtTekiyoDate().setValue(dataSource.getTekiyoDate().getValue());
        } else {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtTekiyoDate().clearValue();
        }
        if (dataSource.getYukoKigen() != null) {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtYukokigenDate().setValue(dataSource.getYukoKigen().getValue());
        } else {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtYukokigenDate().clearValue();
        }
        div.getShakaiFukushiHojinKeigenDetail()
                .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKeigenJiyu().setValue(dataSource.getKeigenJiyu());
        RString 軽減率 = dataSource.getKeigenRitsu();
        if (軽減率 != null && !軽減率.isEmpty()) {
            List<RString> 軽減率List = 軽減率.split("/");
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKeigenRitsuBunshi().setValue(new Decimal(軽減率List.get(0).toString()));
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKeigenRitsuBunbo().setValue(new Decimal(軽減率List.get(1).toString()));
        } else {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKeigenRitsuBunshi().clearValue();
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKeigenRitsuBunbo().clearValue();
        }
        if (dataSource.getKakuninNo()!= null) {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKakuninNo().setValue(dataSource.getKakuninNo());
        } else {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtKakuninNo().clearValue();
        }
        if (dataSource.getFushoninRiyu()!= null) {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtFushoninRiyu().setValue(dataSource.getFushoninRiyu());
        } else {
            div.getShakaiFukushiHojinKeigenDetail()
                    .getShakaiFukushiHojinKeigenRiyoshaFutan().getTxtFushoninRiyu().clearValue();
        }
    }
}
