/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.ShinshinIken;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku11;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku13;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku15;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku18;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku19;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 意見項目処理クラスです。
 */
public class KeyToIkenKomoku {

    private static final RString KEY_0 = new RString("key0");
    private static final RString KEY_1 = new RString("key1");
    private static final RString KEY_2 = new RString("key2");
    private static final RString KEY_3 = new RString("key3");
    private static final RString KEY_4 = new RString("key4");
    private static final RString KEY_5 = new RString("key5");
    private static final RString KEY_6 = new RString("key6");
    private static final RString KEY_7 = new RString("key7");
    private static final RString KEY_8 = new RString("key8");
    private static final RString KEY_9 = new RString("key9");
   
    public RString ikenKomoku01KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku01.無.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku01.有.getコード();
        } else{
            return RString.EMPTY;
        }
    }

    public RString ikenKomoku02KeyToItem(RString key) {
        if (KEY_0.equals(key)) {
            return IkenKomoku02.未記入.getコード();
        } else if (KEY_1.equals(key)) {
            return IkenKomoku02.自立.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku02.J1.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku02.J2.getコード();
        } else if (KEY_4.equals(key)) {
            return IkenKomoku02.A1.getコード();
        } else if (KEY_5.equals(key)) {
            return IkenKomoku02.A2.getコード();
        } else if (KEY_6.equals(key)) {
            return IkenKomoku02.B1.getコード();
        } else if (KEY_7.equals(key)) {
            return IkenKomoku02.B2.getコード();
        } else if (KEY_8.equals(key)) {
            return IkenKomoku02.C1.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku02.C2.getコード();
        } else {
            return RString.EMPTY;
        }
    }

    public RString ikenKomoku03KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku03.自立.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku03.Ⅰ.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku03.Ⅱa.getコード();
        } else if (KEY_4.equals(key)) {
            return IkenKomoku03.Ⅱb.getコード();
        } else if (KEY_5.equals(key)) {
            return IkenKomoku03.Ⅲa.getコード();
        } else if (KEY_6.equals(key)) {
            return IkenKomoku03.Ⅲb.getコード();
        } else if (KEY_7.equals(key)) {
            return IkenKomoku03.Ⅳ.getコード();
        } else if (KEY_8.equals(key)) {
            return IkenKomoku03.M.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku03.記載なし.getコード();
        } else {
            return IkenKomoku03.記載なし.getコード();
        }
    }
    
    public RString ikenKomoku04KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku04.問題なし.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku04.問題あり.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku04.記載なし.getコード();
        } else {
            return IkenKomoku04.記載なし.getコード();
        }
    }

    public RString ikenKomoku05KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku05.自立.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku05.いくらか困難.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku05.見守りが必要.getコード();
        } else if (KEY_4.equals(key)) {
            return IkenKomoku05.判断できない.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku05.記載なし.getコード();
        } else {
            return IkenKomoku05.記載なし.getコード();
        }
    }

    public RString ikenKomoku06KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku06.伝えられる.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku06.いくらか困難.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku06.具体的要求に限られる.getコード();
        } else if (KEY_4.equals(key)) {
            return IkenKomoku06.伝えられない.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku06.記載なし.getコード();
        } else {
            return IkenKomoku06.記載なし.getコード();
        }
    }
    
    public RString ikenKomoku07KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku07.無.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku07.有.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku07.記載なし.getコード();
        } else{
            return IkenKomoku07.記載なし.getコード();
        }
    }

    public RString ikenKomoku08KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku08.右.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku08.左.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku08.記載なし.getコード();
        } else {
            return IkenKomoku08.記載なし.getコード();
        }
    }

    public RString ikenKomoku09KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku09.増加.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku09.維持.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku09.減少.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku09.記載なし.getコード();
        } else {
            return IkenKomoku09.記載なし.getコード();
        }
    }

    public RString ikenKomoku10KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku10.軽.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku10.中.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku10.重.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku10.記載なし.getコード();
        } else {
            return IkenKomoku10.記載なし.getコード();
        }
    }

    public RString ikenKomoku11KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku11.自立.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku11.介助があればしている.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku11.していない.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku11.記載なし.getコード();
        } else {
            return IkenKomoku11.記載なし.getコード();
        }
    }

    public RString ikenKomoku12KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku12.用いていない.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku12.主に自分で操作している.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku12.主に他人が操作している.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku12.記載なし.getコード();
        } else {
            return IkenKomoku12.記載なし.getコード();
        }
    }

    public RString ikenKomoku13KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku13.チェック無.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku13.チェック有.getコード();
        } else {
            return RString.EMPTY;
        }
    }

    public RString ikenKomoku14KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku14.自立ないし何とか自分で食べられる.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku14.全面介助.getコード();
        }else if (KEY_9.equals(key)) {
            return IkenKomoku14.記載なし.getコード();
        } else {
            return IkenKomoku14.記載なし.getコード();
        }
    }

    public RString ikenKomoku15KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku15.良好.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku15.不良.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku15.記載なし.getコード();
        } else {
            return IkenKomoku15.記載なし.getコード();
        }
    }
    
    public RString ikenKomoku16KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku16.期待できる.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku16.期待できない.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku16.不明.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku16.記載なし.getコード();
        } else {
            return IkenKomoku16.記載なし.getコード();
        }
    }

    public RString ikenKomoku17KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku17.特になし.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku17.あり.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku17.記載なし.getコード();
        } else {
            return IkenKomoku17.記載なし.getコード();
        }
    }
    
    public RString ikenKomoku18KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku18.無.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku18.有.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku18.不明.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku18.記載なし.getコード();
        } else {
            return IkenKomoku18.記載なし.getコード();
        }
    }

    public RString ikenKomoku19KeyToItem(RString key) {
        if (KEY_1.equals(key)) {
            return IkenKomoku19.改善.getコード();
        } else if (KEY_2.equals(key)) {
            return IkenKomoku19.不変.getコード();
        } else if (KEY_3.equals(key)) {
            return IkenKomoku19.悪化.getコード();
        } else if (KEY_9.equals(key)) {
            return IkenKomoku19.記載なし.getコード();
        } else {
            return IkenKomoku19.記載なし.getコード();
        }
    }
}
