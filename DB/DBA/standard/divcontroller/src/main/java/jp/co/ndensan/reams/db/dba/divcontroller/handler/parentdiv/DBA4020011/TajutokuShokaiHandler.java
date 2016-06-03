/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA4020011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tashichosonjushochitokureidaicho.OtherAddressLedgerBusiness;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoHeadItem;
import jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReportJoho;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他市町村住所地特例者照会のハンドラークラスです。
 *
 * @reamsid_L DBA-0402-010 xuyannan
 */
public class TajutokuShokaiHandler {

    /**
     * 他市町村住所地特例者台帳を作成します。
     *
     * @param list 他市町村住所地特例者台帳のデータ
     * @return TashichosonJushochitokureishaDaichoReportJoho 他市町村住所地特例者台帳
     */
    public TashichosonJushochitokureishaDaichoReportJoho printTyouhyouData(List<OtherAddressLedgerBusiness> list) {
        TashichosonJushochitokureishaDaichoHeadItem headItem = new TashichosonJushochitokureishaDaichoHeadItem();
        List<TashichosonJushochitokureishaDaichoBodyItem> bodyItemList = new ArrayList<>();
        for (OtherAddressLedgerBusiness business : list) {
            setHead(headItem, business);
            setBody(bodyItemList, business);
        }
        return new TashichosonJushochitokureishaDaichoReportJoho(headItem, bodyItemList);
    }

    private void setHead(TashichosonJushochitokureishaDaichoHeadItem headItem, OtherAddressLedgerBusiness business) {
        headItem.setPrintTimeStamp(business.get印刷日時());
        headItem.setShichosonCode(business.get市町村コード() == null ? RString.EMPTY : business.get市町村コード().value());
        headItem.setShichosonName(business.get市町村名称());
        headItem.setBirthYMD(business.get生年月日() == null ? RString.EMPTY : new RString(business.get生年月日().toString()));
        headItem.setSeibetsu(business.get性別());
        headItem.setSetaiCode(business.get世帯コード() == null ? RString.EMPTY : business.get世帯コード().value());
        headItem.setShikibetsuCode(business.get識別コード() == null ? RString.EMPTY : business.get識別コード().value());
        headItem.setShimeiKana(business.get氏名カナ() == null ? RString.EMPTY : business.get氏名カナ().value());
        headItem.setChiku1CodeTitle(business.get地区タイトル1());
        headItem.setChiku1Code(business.get地区コード1() == null ? RString.EMPTY : business.get地区コード1().value());
        headItem.setShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
        headItem.setJotai(business.get状態());
        headItem.setTelNoTitle(business.get電話番号タイトル());
        headItem.setChiku2CodeTitle(business.get地区タイトル2());
        headItem.setChiku2Code(business.get地区コード2() == null ? RString.EMPTY : business.get地区コード2().value());
        headItem.setJusho1(business.get住所1());
        headItem.setTelNo1(business.get電話番号１());
        headItem.setJusho1Title(business.get住所タイトル1());
        headItem.setTelNo2(business.get電話番号２());
        headItem.setChiku3CodeTitle(business.get地区タイトル3());
        headItem.setChiku3Code(business.get地区コード3() == null ? RString.EMPTY : business.get地区コード3().value());
        headItem.setGyoseikuTitle(business.get行政区タイトル());
        headItem.setJusho1Code(business.get住所コード() == null ? RString.EMPTY : business.get住所コード());
        headItem.setGyoseikuCode(business.get行政区コード() == null ? RString.EMPTY : business.get行政区コード().value());
        headItem.setMaeJushoCode(business.get前住所コード() == null ? RString.EMPTY : business.get前住所コード().value());
        headItem.setJusho2(business.get住所2());
        headItem.setTennyuYMD(business.get転入年月日() == null ? RString.EMPTY : new RString(business.get転入年月日().toString()));
        headItem.setJusho2Title(business.get住所タイトル2());
        headItem.setTenshutsuYMD(business.get転出年月日() == null ? RString.EMPTY : new RString(business.get転出年月日().toString()));
    }

    private void setBody(List<TashichosonJushochitokureishaDaichoBodyItem> bodyItemList, OtherAddressLedgerBusiness business) {
        TashichosonJushochitokureishaDaichoBodyItem bodyItem = new TashichosonJushochitokureishaDaichoBodyItem();
        bodyItem.setListNo_1(business.getNo());
        bodyItem.setListUpper_1(business.get適用年月日() == null ? RString.EMPTY : business.get適用年月日().toDateString());
        bodyItem.setListUpper_2(business.get適用届出年月日() == null ? RString.EMPTY : business.get適用届出年月日().toDateString());
        bodyItem.setListUpper_3(business.get他市町村住所地特例適用事由コード());
        bodyItem.setListUpper_4(business.get他市町村住所地特例適用事由名称());
        bodyItem.setListUpper_5(business.get入所年月日() == null ? RString.EMPTY : business.get入所年月日().toDateString());
        bodyItem.setListUpper_6(business.get事業者名称() == null ? RString.EMPTY : business.get事業者名称().value());
        bodyItem.setListUpper_7(business.get電話番号() == null ? RString.EMPTY : business.get電話番号().value());
        bodyItem.setListUpper_8(business.get保険者名称());
        bodyItem.setListLower_1(business.get解除年月日() == null ? RString.EMPTY : business.get解除年月日().toDateString());
        bodyItem.setListLower_2(business.get解除届出年月日() == null ? RString.EMPTY : business.get解除届出年月日().toDateString());
        bodyItem.setListLower_3(business.get他市町村住所地特例解除事由コード());
        bodyItem.setListLower_4(business.get他市町村住所地特例解除事由名称());
        bodyItem.setListLower_5(business.get退所年月日() == null ? RString.EMPTY : business.get退所年月日().toDateString());
        bodyItem.setListLower_6(business.get事業者住所());
        bodyItem.setListLower_7(business.get郵便番号() == null ? RString.EMPTY : business.get郵便番号().value());
        bodyItem.setListLower_8(business.get他被保番号() == null ? RString.EMPTY : business.get他被保番号().value());
        bodyItemList.add(bodyItem);
    }
}
