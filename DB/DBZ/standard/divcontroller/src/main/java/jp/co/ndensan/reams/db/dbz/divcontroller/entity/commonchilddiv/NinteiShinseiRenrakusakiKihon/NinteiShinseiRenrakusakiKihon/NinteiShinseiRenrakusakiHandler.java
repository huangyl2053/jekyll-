/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiKihon.NinteiShinseiRenrakusakiKihon;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihon;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihonFinder;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 *
 * 共有子Div「認定申請連絡先」の実装クラスです。
 */
public class NinteiShinseiRenrakusakiHandler {

    private final NinteiShinseiRenrakusakiKihonDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShinseiShichosonRenrakuJikoDiv
     */
    public NinteiShinseiRenrakusakiHandler(NinteiShinseiRenrakusakiKihonDiv div) {
        this.div = div;
    }

    /**
     * 認定申請連絡先基本に初期化を設定する。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     */
    public void initialize(ShinseishoKanriNo 申請書管理番号) {
        NinteiShinseiRenrakusakiKihonFinder renrakusakiKihonFinder = new NinteiShinseiRenrakusakiKihonFinder();
        List<jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihon> kiKihonentityList
                = renrakusakiKihonFinder.getNinteiShinseiRenrakusakiKihon(申請書管理番号).records();
        if (!kiKihonentityList.isEmpty()) {
            List<KeyValueDataSource> kinyusha = new ArrayList<>();
            for (NinteiShinseiRenrakusakiKihon renrakusakiKihon : kiKihonentityList) {
                // TODO  内部QA：820 Redmine： (本人との関係のEnum(介護連絡先続柄)存在ない、一時固定値を使用します)
                KeyValueDataSource data = new KeyValueDataSource(renrakusakiKihon.get連絡先続柄(),
                        renrakusakiKihon.get連絡先続柄());
                kinyusha.add(data);
            }
            div.getDdlTsuzukigara().setDataSource(kinyusha);
            div.getTxtJusho().setValue(kiKihonentityList.get(0).get連絡先住所() == null ? RString.EMPTY
                    : kiKihonentityList.get(0).get連絡先住所().getColumnValue());
            div.getTxtMobileNo().setDomain(kiKihonentityList.get(0).get連絡先携帯番号() == null ? TelNo.EMPTY
                    : kiKihonentityList.get(0).get連絡先携帯番号());
            div.getTxtShimei().setValue(kiKihonentityList.get(0).get連絡先氏名() == null ? RString.EMPTY
                    : kiKihonentityList.get(0).get連絡先氏名().getColumnValue());
            div.getTxtTelNo().setDomain(kiKihonentityList.get(0).get連絡先電話番号() == null ? TelNo.EMPTY
                    : kiKihonentityList.get(0).get連絡先電話番号());
            div.getTxtYubinNo().setValue(kiKihonentityList.get(0).get連絡先郵便番号() == null ? YubinNo.EMPTY
                    : kiKihonentityList.get(0).get連絡先郵便番号());
        }
    }
}
