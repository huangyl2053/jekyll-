/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.TokubetsuChiikiKasanGemmen.TokubetsuChiikiKasanGemmen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.service.core.tokubetsuchiikikasangemmen.TokubetsuChiikiKasanGemmenFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 【共有子Div】 特別地域加算減免ハンドラクラスです。
 *
 * @reamsid_L DBD-3560-070 wangjie2
 */
public class TokubetsuChiikiKasanGemmenHandler {

    private final TokubetsuChiikiKasanGemmenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】特別地域加算減免Div
     */
    public TokubetsuChiikiKasanGemmenHandler(TokubetsuChiikiKasanGemmenDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<TokubetsuchiikiKasanGemmen> onLoad(HihokenshaNo 被保険者番号) {
        TokubetsuChiikiKasanGemmenFinder finder = TokubetsuChiikiKasanGemmenFinder.createIntance();
        List<TokubetsuchiikiKasanGemmen> 申請一覧情報 = finder.get申請一覧_特別地域加算減免情報(被保険者番号);
        if (!申請一覧情報.isEmpty()) {
            set特別地域加算減免リストデータグリッド(申請一覧情報);
        }
        div.getTokubetsuChiikiKasanGemmenDetail().setDisplayNone(true);
        return 申請一覧情報;
    }

    private void set特別地域加算減免リストデータグリッド(List<TokubetsuchiikiKasanGemmen> 申請一覧情報) {
        List<dgTokubetsuChiikiKasanGemmenList_Row> dataSourceList = new ArrayList<>();
        for (TokubetsuchiikiKasanGemmen 申請情報 : 申請一覧情報) {
            dgTokubetsuChiikiKasanGemmenList_Row dataSource = new dgTokubetsuChiikiKasanGemmenList_Row();
            dataSource.setKakuninNo(申請情報.get確認番号());
            if (申請情報.get申請年月日() != null) {
                TextBoxFlexibleDate 申請日 = new TextBoxFlexibleDate();
                申請日.setValue(申請情報.get申請年月日());
                dataSource.setShinseiDate(申請日);
            }
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
            if (申請情報.get決定年月日() != null) {
                TextBoxFlexibleDate 決定日 = new TextBoxFlexibleDate();
                決定日.setValue(申請情報.get決定年月日());
                dataSource.setKetteiDate(決定日);
            }
            if (申請情報.get決定区分() != null && !申請情報.get決定区分().isEmpty()) {
                dataSource.setKetteiKubun(KetteiKubun.toValue(申請情報.get決定区分()).get名称());
            }
            if (申請情報.get減額率() != null) {
                TextBoxNum 減額率 = new TextBoxNum();
                減額率.setValue(申請情報.get減額率().getColumnValue());
                dataSource.setGengakuRitsu(減額率);
            }
            dataSource.setFushoninRiyu(申請情報.get非承認理由());
            dataSourceList.add(dataSource);
        }
        div.getDgTokubetsuChiikiKasanGemmenList().setDataSource(dataSourceList);
    }

    /**
     * 一覧を選択し、詳細を表示ます。。
     *
     */
    public void 一覧の詳細表示() {
        div.getTokubetsuChiikiKasanGemmenDetail().setDisplayNone(false);
        dgTokubetsuChiikiKasanGemmenList_Row dataSource = div.getDgTokubetsuChiikiKasanGemmenList().getActiveRow();
        if (dataSource.getShinseiDate() != null) {
            div.getTokubetsuChiikiKasanGemmenDetail().getTxtShinseiDate().setValue(dataSource.getShinseiDate().getValue());
        } else {
            div.getTokubetsuChiikiKasanGemmenDetail().getTxtShinseiDate().clearValue();
        }
        if (dataSource.getKetteiDate() != null) {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtKetteiDate().setValue(dataSource.getKetteiDate().getValue());
        } else {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtKetteiDate().clearValue();
        }
        if (dataSource.getTekiyoDate() != null) {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtTekiyoDate().setValue(dataSource.getTekiyoDate().getValue());
        } else {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtTekiyoDate().clearValue();
        }
        if (dataSource.getYukoKigen() != null) {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtYukokigenDate().setValue(dataSource.getYukoKigen().getValue());
        } else {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtYukokigenDate().clearValue();
        }
        div.getTokubetsuChiikiKasanGemmenDetail()
                .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtKetteiKubun().setValue(dataSource.getKetteiKubun());
        if (dataSource.getGengakuRitsu() != null) {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtGengakuRitsu().setValue(dataSource.getGengakuRitsu().getValue());
        } else {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtGengakuRitsu().clearValue();
        }
        if (dataSource.getKakuninNo() != null) {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtKakuninNo().setValue(dataSource.getKakuninNo());
        } else {
            // 内容をクリック
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtKakuninNo().clearValue();
        }
        if (dataSource.getFushoninRiyu() != null) {
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtFushoninRiyu().setValue(dataSource.getFushoninRiyu());
        } else {
            // 内容をクリック
            div.getTokubetsuChiikiKasanGemmenDetail()
                    .getTokubetsuChiikiKasanGemmenRiyoshaFutan().getTxtFushoninRiyu().clearValue();
        }
    }

}
