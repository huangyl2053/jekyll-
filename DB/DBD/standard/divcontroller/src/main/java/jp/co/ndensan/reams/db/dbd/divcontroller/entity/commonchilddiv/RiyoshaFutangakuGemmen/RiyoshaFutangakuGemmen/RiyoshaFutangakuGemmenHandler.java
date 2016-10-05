/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.RiyoshaFutangakuGemmen.RiyoshaFutangakuGemmen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.service.core.riyoshafutangakugemmen.RiyoshaFutangakuGemmenFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 【共有子Div】 利用者負担額減免ハンドラクラスです。
 *
 * @reamsid_L DBD-3560-060 wangjie2
 */
public class RiyoshaFutangakuGemmenHandler {

    private final RiyoshaFutangakuGemmenDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 【共有子Div】利用者負担額減免Div
     */
    public RiyoshaFutangakuGemmenHandler(RiyoshaFutangakuGemmenDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @return 申請一覧情報
     */
    public List<RiyoshaFutangakuGengaku> onLoad(HihokenshaNo 被保険者番号) {
        RiyoshaFutangakuGemmenFinder finder = RiyoshaFutangakuGemmenFinder.createIntance();
        List<RiyoshaFutangakuGengaku> 申請一覧情報 = finder.get申請一覧_利用者負担額減額情報(被保険者番号);
        if (!申請一覧情報.isEmpty()) {
            set利用負担額減免リスト(申請一覧情報);
        }
        div.getRiyoshaFutangakuGemmenDetail().setDisplayNone(true);
        return 申請一覧情報;
    }

    private void set利用負担額減免リスト(List<RiyoshaFutangakuGengaku> 申請一覧情報) {
        List<dgRiyoshaFutangakuGemmenList_Row> dataSourceList = new ArrayList<>();
        for (RiyoshaFutangakuGengaku 申請情報 : 申請一覧情報) {
            dgRiyoshaFutangakuGemmenList_Row dataSource = new dgRiyoshaFutangakuGemmenList_Row();
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
            if (申請情報.get給付率() != null) {
                TextBoxNum 給付率 = new TextBoxNum();
                給付率.setValue(申請情報.get給付率().getColumnValue());
                dataSource.setKyufuRitsu(給付率);
            }
            dataSource.setFushoninRiyu(申請情報.get非承認理由());
            dataSourceList.add(dataSource);
        }
        div.getDgRiyoshaFutangakuGemmenList().setDataSource(dataSourceList);
    }

    /**
     * 一覧を選択し、詳細を表示ます。。
     *
     */
    public void 一覧の詳細表示() {
        div.getRiyoshaFutangakuGemmenDetail().setDisplayNone(false);
        dgRiyoshaFutangakuGemmenList_Row dataSource = div.getDgRiyoshaFutangakuGemmenList().getActiveRow();
        if (dataSource.getShinseiDate() != null) {
            div.getRiyoshaFutangakuGemmenDetail().getTxtShinseiDate().setValue(dataSource.getShinseiDate().getValue());
        } else {
            div.getRiyoshaFutangakuGemmenDetail().getTxtShinseiDate().clearValue();
        }
        if (dataSource.getKetteiDate() != null) {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtKetteiDate().setValue(dataSource.getKetteiDate().getValue());
        } else {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtKetteiDate().clearValue();
        }
        if (dataSource.getTekiyoDate() != null) {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtTekiyoDate().setValue(dataSource.getTekiyoDate().getValue());
        } else {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtTekiyoDate().clearValue();
        }
        if (dataSource.getYukoKigen() != null) {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtYukokigenDate().setValue(dataSource.getYukoKigen().getValue());
        } else {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtYukokigenDate().clearValue();
        }
        div.getRiyoshaFutangakuGemmenDetail()
                .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtKetteiKubun().setValue(dataSource.getKetteiKubun());
        if (dataSource.getKyufuRitsu() != null) {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtKyufuRitsu().setValue(dataSource.getKyufuRitsu().getValue());
        } else {
            div.getRiyoshaFutangakuGemmenDetail()
                    .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtKyufuRitsu().clearValue();
        }
        if (dataSource.getFushoninRiyu() != null) {
        div.getRiyoshaFutangakuGemmenDetail()
                .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtFushoninRiyu().setValue(dataSource.getFushoninRiyu());
        } else {
        // 内容をクリア
        div.getRiyoshaFutangakuGemmenDetail()
                .getRiyoshaFutangakuGemmenRiyoshaFutan().getTxtFushoninRiyu().clearValue();
        }
    }

}
