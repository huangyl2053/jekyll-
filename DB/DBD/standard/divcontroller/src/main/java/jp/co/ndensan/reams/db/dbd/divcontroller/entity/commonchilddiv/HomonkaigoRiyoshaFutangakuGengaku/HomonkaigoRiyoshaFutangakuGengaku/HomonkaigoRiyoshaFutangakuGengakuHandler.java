/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.HomonkaigoRiyoshaFutangakuGengaku.HomonkaigoRiyoshaFutangakuGengaku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.homonkaigogemmen.HobetsuKubun;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 共有子Div「訪問介護利用者負担額減額」の状態を変更するクラスです。
 *
 * @reamsid_L DBD-3560-040 huangh
 */
public class HomonkaigoRiyoshaFutangakuGengakuHandler {

    private final HomonkaigoRiyoshaFutangakuGengakuDiv div;
    private final RString TRUE = new RString("有");
    private final RString FALSE = new RString("無");

    /**
     * コンストラクタです。
     *
     * @param div HomonkaigoRiyoshaFutangakuGengakuDiv
     */
    public HomonkaigoRiyoshaFutangakuGengakuHandler(HomonkaigoRiyoshaFutangakuGengakuDiv div) {
        this.div = div;
    }

    /**
     * 表示リスト取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return boolean
     */
    public List<HomonKaigoRiyoshaFutangakuGengaku> 表示リスト取得(HihokenshaNo 被保険者番号) {
        return HomonKaigoRiyoshaFutangakuGengakuManager.createInstance().get訪問介護利用者負担額減額By被保険者番号(被保険者番号);
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param homonKaigoGengakuList List<HomonKaigoRiyoshaFutangakuGengaku>
     */
    public void initialize(List<HomonKaigoRiyoshaFutangakuGengaku> homonKaigoGengakuList) {

        List<dgHomonkaigoRiyoshaFutangakuGengakuList_Row> dgList = new ArrayList<>();
        for (HomonKaigoRiyoshaFutangakuGengaku homonKaigoGengaku : homonKaigoGengakuList) {
            dgHomonkaigoRiyoshaFutangakuGengakuList_Row row = new dgHomonkaigoRiyoshaFutangakuGengakuList_Row();

            TextBoxFlexibleDate 申請日 = new TextBoxFlexibleDate();
            申請日.setValue(homonKaigoGengaku.get申請年月日());
            row.setShinseiDate(申請日);

            row.setShinseiRiyu(homonKaigoGengaku.get申請事由());

            TextBoxFlexibleDate 適用日 = new TextBoxFlexibleDate();
            適用日.setValue(homonKaigoGengaku.get適用開始年月日());
            row.setTekiyoDate(適用日);

            TextBoxFlexibleDate 有効期限 = new TextBoxFlexibleDate();
            有効期限.setValue(homonKaigoGengaku.get適用終了年月日());
            row.setYukoKigen(有効期限);

            try {
                row.setKetteiKubun(KetteiKubun.toValue(homonKaigoGengaku.get決定区分()).get名称());
            } catch (IllegalArgumentException e) {
                row.setKetteiKubun(RString.EMPTY);
            }

            TextBoxFlexibleDate 決定日 = new TextBoxFlexibleDate();
            決定日.setValue(homonKaigoGengaku.get決定年月日());
            row.setKetteiDate(決定日);

            row.setFushoninRiyu(homonKaigoGengaku.get非承認理由());
            try {
                row.setHobetsuKubun(HobetsuKubun.toValue(homonKaigoGengaku.get法別区分()).get名称());
            } catch (IllegalArgumentException e) {
                row.setHobetsuKubun(RString.EMPTY);
            }
            TextBoxNum 給付率 = new TextBoxNum();
            if (homonKaigoGengaku.get給付率() != null) {
                給付率.setValue(homonKaigoGengaku.get給付率().value());
                row.setKyufuRitsu(給付率);
            }

            row.setKohiFutanshaNo(homonKaigoGengaku.get公費負担者番号());
            row.setKohiJukyushaNo(homonKaigoGengaku.get公費受給者番号());
            row.setHasShogaishaTecho(homonKaigoGengaku.is障害者手帳有無());
            row.setShogaishaTechoTokyu(homonKaigoGengaku.get障害者手帳等級());
            row.setShogaishaTechoNo(homonKaigoGengaku.get障害者手帳番号());

            dgList.add(row);
        }

        div.getDgHomonkaigoRiyoshaFutangakuGengakuList().setDataSource(dgList);

        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().setDisplayNone(true);
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     */
    public void 詳細表示() {

        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().setDisplayNone(false);
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuShinsei().getTxtShinseiDate().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getShinseiDate().getValue());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuShinsei().getTxtHobetsuKubun().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getHobetsuKubun());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuShinsei().getTxtShinseiRiyu().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getShinseiRiyu());

        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getShogaishaTecho().getTxtHasShogaishaTecho().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getHasShogaishaTecho() ? TRUE : FALSE);
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getShogaishaTecho().getTxtShogaishaTechoTokyu().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getShogaishaTechoTokyu());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getShogaishaTecho().getTxtShogaishaTechoNo().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getShogaishaTechoNo());

        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtKetteiDate().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getKetteiDate().getValue());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtKetteiKubun().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getKetteiKubun());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtTekiyoDate().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getTekiyoDate().getValue());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtYukokigenDate().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getYukoKigen().getValue());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtKyufuRitsu().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getKyufuRitsu().getValue());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtFushoninRiyu().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getFushoninRiyu());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtKohiFutanshaNo().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getKohiFutanshaNo());
        div.getHomonkaigoRiyoshaFutangakuGengakuDetail().getHomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan().getTxtKohiJukyushaNo().
                setValue(div.getDgHomonkaigoRiyoshaFutangakuGengakuList().getClickedItem().getKohiJukyushaNo());
    }
}
