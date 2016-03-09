/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.NinteiShinseiRenrakusakiJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseirenrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.business.ninteishinseirenrakusakikihon.NinteiShinseiRenrakusakiKihon;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiRenrakusakiJoho.NinteiShinseiRenrakusakiJoho.dgRenrakusakiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定申請連絡先情報のHandlerクラスです。
 */
public class NinteiShinseiRenrakusakiJohoHandler {
    
    private final NinteiShinseiRenrakusakiJohoDiv div;
    
    /**
     * コンストラクタです。
     * @param div 画面情報
     */
    public NinteiShinseiRenrakusakiJohoHandler(NinteiShinseiRenrakusakiJohoDiv div) {
        this.div = div;
    }
    
    /**
     * 画面項目をクリアします。
     */
    public void setClear() {
        div.getRenrakusakiNyuryoku().getTxtRenban().clearValue();
        div.getDdlRenrakusakiKubun().getDataSource().clear();
        div.getDdlShisho().getDataSource().clear();
        div.getDdlTsuzukigara().getDataSource().clear();
        div.getTxtShimei().clearValue();
        div.getTxtKanaShimei().clearValue();
        div.getTxtYubinNo().clearValue();
        div.getTxtJusho().clearValue();
        div.getTxtTelNo().clearDomain();
        div.getTxtMobileNo().clearDomain();
        div.getTxtYusenJuni().clearValue();
    }
    
    /**
     * 介護連絡先情報（認定）の設定します。
     * @param ninteiShinseiList 介護連絡先情報（認定）
     */
    public void setDBERenrakusaki(List<NinteiShinseiRenrakusakiKihon> ninteiShinseiList) {
        List<dgRenrakusakiIchiran_Row> dateSource = new ArrayList<>();
        for (NinteiShinseiRenrakusakiKihon ninteiShinseiRenrakusakiKihon : ninteiShinseiList) {
            dgRenrakusakiIchiran_Row row = new dgRenrakusakiIchiran_Row(new RString(String.valueOf(ninteiShinseiRenrakusakiKihon.get連番())),
                    ninteiShinseiRenrakusakiKihon.get連絡先氏名() == null ? RString.EMPTY : ninteiShinseiRenrakusakiKihon.
                            get連絡先氏名().getColumnValue(),
                    ninteiShinseiRenrakusakiKihon.get連絡先続柄(),
                    ninteiShinseiRenrakusakiKihon.get連絡先住所() == null ? RString.EMPTY : ninteiShinseiRenrakusakiKihon
                            .get連絡先住所().getColumnValue(),
                    ninteiShinseiRenrakusakiKihon.get連絡先電話番号() == null ? RString.EMPTY : ninteiShinseiRenrakusakiKihon.
                            get連絡先電話番号().getColumnValue(),
                    ninteiShinseiRenrakusakiKihon.get連絡先携帯番号() == null ? RString.EMPTY : ninteiShinseiRenrakusakiKihon.
                            get連絡先携帯番号().getColumnValue(),
                    new RString(String.valueOf(ninteiShinseiRenrakusakiKihon.get優先順位())));
            dateSource.add(row);
        }
        div.getDgRenrakusakiIchiran().setDataSource(dateSource);
    } 
    
    /**
     * 介護連絡先情報（受給）の設定します。
     * @param renrakusakiJohoList 介護連絡先情報（受給）
     */
    public void setDBDRenrakusaki(List<RenrakusakiJoho> renrakusakiJohoList) {
        List<dgRenrakusakiIchiran_Row> dateSource = new ArrayList<>();
        for (RenrakusakiJoho renrakusakiJoho : renrakusakiJohoList) {
            dgRenrakusakiIchiran_Row row = new dgRenrakusakiIchiran_Row(new RString(String.valueOf(renrakusakiJoho.get連番())),
                    renrakusakiJoho.get連絡先氏名() == null ? RString.EMPTY : renrakusakiJoho.
                            get連絡先氏名().getColumnValue(),
                    renrakusakiJoho.get連絡先続柄(),
                    renrakusakiJoho.get連絡先住所() == null ? RString.EMPTY : renrakusakiJoho
                            .get連絡先住所().getColumnValue(),
                    renrakusakiJoho.get連絡先電話番号() == null ? RString.EMPTY : renrakusakiJoho.
                            get連絡先電話番号().getColumnValue(),
                    renrakusakiJoho.get連絡先携帯番号() == null ? RString.EMPTY : renrakusakiJoho.
                            get連絡先携帯番号().getColumnValue(),
                    new RString(String.valueOf(renrakusakiJoho.get優先順位())));
            dateSource.add(row);
        }
        div.getDgRenrakusakiIchiran().setDataSource(dateSource);
    }
    
}
