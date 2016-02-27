/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.dbe2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.definition.core.ViewStateKeys;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_21;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_22;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_23;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_10;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_11;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_12;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_14;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_15;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_16;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_23;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_26;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_27;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_28;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_29;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_30;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_31;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_6;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_7;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_8;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku06A_9;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_10;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_11;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_12;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_14;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_15;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_16;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_26;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_27;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_28;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_29;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_30;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_31;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_32;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_6;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_7;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_8;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09A_9;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_10;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_11;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_12;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_14;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_15;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_16;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_21;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_24;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_25;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_26;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_27;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_28;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_29;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_30;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_31;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_32;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_6;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_7;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_8;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku09B_9;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku99A_21;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceFirstHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceSecondHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1Finder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果登録1のクラスです。
 */
public class NinnteiChousaKekkaTouroku1Handler {

    private final NinnteiChousaKekkaTouroku1Div div;

    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString 介護予防 = new RString("（介護予防）");
    private static final RString カンマ = new RString(",");
    private static final int 住宅改修_連番 = 1;
    private static final int 市町村特別給付_連番 = 1;
    private static final int 介護保険給付外の在宅サービス_連番 = 2;
    private static final RString 厚労省IF識別コード_02A = new RString("02A");
    private static final RString 厚労省IF識別コード_06A = new RString("06A");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString 厚労省IF識別コード_99A = new RString("99A");
    private static final int データベース内連番_1 = 1;
    private static final int データベース内連番_2 = 2;
    private static final int データベース内連番_3 = 3;
    private static final int データベース内連番_4 = 4;
    private static final int データベース内連番_5 = 5;
    private static final int データベース内連番_6 = 6;
    private static final int データベース内連番_7 = 7;
    private static final int データベース内連番_8 = 8;
    private static final int データベース内連番_9 = 9;
    private static final int データベース内連番_10 = 10;
    private static final int データベース内連番_11 = 11;
    private static final int データベース内連番_12 = 12;
    private static final int データベース内連番_13 = 13;
    private static final int データベース内連番_14 = 14;
    private static final int データベース内連番_15 = 15;
    private static final int データベース内連番_16 = 16;
    private static final int データベース内連番_17 = 17;
    private static final int データベース内連番_18 = 18;
    private static final int データベース内連番_19 = 19;
    private static final int データベース内連番_20 = 20;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会対象者割付
     */
    public NinnteiChousaKekkaTouroku1Handler(NinnteiChousaKekkaTouroku1Div div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     */
    public void initialize() {

        // test用
//        ViewStateHolder.put(ViewStateKeys.認定調査履歴番号, 123);
//        ViewStateHolder.put(ViewStateKeys.認定調査委託先コード, new RString("1"));
//        ViewStateHolder.put(ViewStateKeys.申請書管理番号, new ShinseishoKanriNo(new RString("221001")));
        //TODO DBZ.KaigoNinteiShinseishaInfoのinitializeは未作成です
        //div.getCcdKaigoNinteiShinseishaInfo()
        //TODO DBZ.NinteiShinseiRenrakusakiKihonのinitializeメソッドは未作成です
        //div.getCcdNinteiShinseiRenrakusakiKihon()
        //TODO DBZ.ChosaJisshishaJohoのinitializeメソッドは未作成です
        //div.getCcdChosaJisshishaJoho()
        //TODO DBZ.KihonChosaInputは未作成です
        //div.getCcdIchigunKihonChosa()
        TempData tempData = 認定調査情報を取得();
        RString temp_厚労省IF識別コード = tempData.getTemp_厚労省IF識別コード();
//        RString temp_認定調査依頼区分コード = tempData.getTemp_認定調査依頼区分コード();
//        RString temp_認定調査委託区分コード = tempData.getTemp_認定調査委託区分コード();
        RString temp_認定調査回数 = tempData.getTemp_認定調査回数();

        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, temp_厚労省IF識別コード);
        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.認定調査回数, temp_認定調査回数);

        div.getRadGenzaiservis().setSelectedKey(予防給付サービス_選択);
        ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 予防給付サービス_選択);
        予防給付サービス名称取得(temp_厚労省IF識別コード);
        介護給付サービス非表示();
        施設利用名称取得(temp_厚労省IF識別コード);

        if (is再調査の場合()) {
            既存概況調査情報取得(temp_厚労省IF識別コード);
        }
    }

    /**
     * 入力内容を取り消します。
     */
    public void resetData() {
        initialize();
    }

    private TempData 認定調査情報を取得() {

        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_認定調査委託先コード = ViewStateHolder.get(ViewStateKeys.認定調査委託先コード, RString.class);
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        return finder.get認定調査情報(temp_認定調査履歴番号, temp_認定調査委託先コード, temp_申請書管理番号);
    }

    private void 既存概況調査情報取得(RString temp_厚労省IF識別コード) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        予防給付サービス_利用状況の設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);
        在宅_住宅改修radの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        在宅_市町村特別給付txtの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        在宅_介護保険給付以外の在宅サービスtxtの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        施設_施設利用フラグの設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);

        NinteichosahyoGaikyoChosaManager manager = new NinteichosahyoGaikyoChosaManager();
        NinteichosahyoGaikyoChosa ninteichosahyoGaikyoChosa = manager.get認定調査票_概況調査_子(temp_申請書管理番号, temp_認定調査履歴番号, new RString("1")); //TODO QA 概況調査テキストイメージ区分
        if (ninteichosahyoGaikyoChosa != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().setValue(ninteichosahyoGaikyoChosa.get利用施設名());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().setValue(ninteichosahyoGaikyoChosa.get利用施設郵便番号());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().setTxtShisetsuJusho(null); // TODO setValueメソッドがない
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo(); //TODO setValueメソッドがない
            div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(ninteichosahyoGaikyoChosa.get特記());
        }
    }

    /**
     * 予防給付サービス非表示の処理です。
     */
    public void 予防給付サービス非表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setVisible(false);
    }

    private void 予防給付サービス表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setVisible(true);
    }

    private List<dgRiyoSerViceFirstHalf_Row> 予防給付サービス名称取得(RString temp_厚労省IF識別コード) {

        List<dgRiyoSerViceFirstHalf_Row> halfListTmp = new ArrayList();
        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku06A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(予防データ(GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get単位()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(予防データ(GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get単位()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09B_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(予防データ(GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(予防データ(GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get単位()));
        }

        List<dgRiyoSerViceFirstHalf_Row> halfList = new ArrayList();
        RString 予防給付状況 = RString.EMPTY;
        for (dgRiyoSerViceFirstHalf_Row rowData : halfListTmp) {
            if (rowData.getServiceMeisho().getValue().contains(介護予防)) {
                halfList.add(予防_介護予防を取り除く(rowData));
            }
            予防給付状況 = 予防給付状況.concat(カンマ);
        }
        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の予防給付サービス, 予防給付状況);
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setDataSource(halfList);
        return halfList;
    }

    /**
     * 介護給付サービス非表示の処理です。
     */
    public void 介護給付サービス非表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setVisible(false);
    }

    private void 介護給付サービス表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setVisible(true);
    }

    private List<dgRiyoSerViceSecondHalf_Row> 介護給付サービス名称取得(RString temp_厚労省IF識別コード) {
        List<dgRiyoSerViceSecondHalf_Row> halfListTmp = new ArrayList();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku06A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku06A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku06A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku06A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku06A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku06A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku06A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku06A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku06A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku06A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku06A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(介護データ(GaikyochosaKomoku06A_14.夜間対応型訪問介護.get名称(), GaikyochosaKomoku06A_14.夜間対応型訪問介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku06A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku06A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku06A_17._介護予防_認知症対応型共同生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_18.地域密着型特定施設入居者生活介護.get名称(), GaikyochosaKomoku06A_18.地域密着型特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku06A_19.地域密着型介護老人福祉施設入所者生活介護.get名称(), GaikyochosaKomoku06A_19.地域密着型介護老人福祉施設入所者生活介護.get単位()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09A_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09A_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09A_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09A_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09A_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09A_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09A_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09A_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09A_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09A_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09A_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(介護データ(GaikyochosaKomoku09A_14.夜間対応型訪問介護.get名称(), GaikyochosaKomoku09A_14.夜間対応型訪問介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09A_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09A_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09A_17._介護予防_認知症対応型共同生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_18.地域密着型特定施設入居者生活介護.get名称(), GaikyochosaKomoku09A_18.地域密着型特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09A_19.地域密着型介護老人福祉施設入所者生活介護.get名称(), GaikyochosaKomoku09A_19.地域密着型介護老人福祉施設入所者生活介護.get単位()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_1._介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get名称(), GaikyochosaKomoku09B_2._介護予防_訪問入浴介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_3._介護予防_訪問看護.get名称(), GaikyochosaKomoku09B_3._介護予防_訪問看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get名称(), GaikyochosaKomoku09B_4._介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get名称(), GaikyochosaKomoku09B_5._介護予防_居宅療養管理指導.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get名称(), GaikyochosaKomoku09B_6._介護予防_通所介護_ﾃﾞｲｻｰﾋﾞｽ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get名称(), GaikyochosaKomoku09B_7._介護予防_通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝ_ﾃﾞｲｹｱ.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get名称(), GaikyochosaKomoku09B_8._介護予防_短期入所生活介護_特養等.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get名称(), GaikyochosaKomoku09B_9._介護予防_短期入所療養介護_老健_診療所.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get名称(), GaikyochosaKomoku09B_10._介護予防_特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get名称(), GaikyochosaKomoku09B_11._介護予防_福祉用具貸与.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get名称(), GaikyochosaKomoku09B_12.特定_介護予防_福祉用具販売.get単位()));

            halfListTmp.add(介護データ(GaikyochosaKomoku09B_14.夜間対応型訪問介護.get名称(), GaikyochosaKomoku09B_14.夜間対応型訪問介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get名称(), GaikyochosaKomoku09B_15._介護予防_認知症対応型通所介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get名称(), GaikyochosaKomoku09B_16._介護予防_小規模多機能型居宅介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get名称(), GaikyochosaKomoku09B_17._介護予防_認知症対応型共同生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_18.地域密着型特定施設入居者生活介護.get名称(), GaikyochosaKomoku09B_18.地域密着型特定施設入居者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_19.地域密着型介護老人福祉施設入所者生活介護.get名称(), GaikyochosaKomoku09B_19.地域密着型介護老人福祉施設入所者生活介護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_20.定期巡回_随時対応型訪問介護看護.get名称(), GaikyochosaKomoku09B_20.定期巡回_随時対応型訪問介護看護.get単位()));
            halfListTmp.add(介護データ(GaikyochosaKomoku09B_21.複合型サービス.get名称(), GaikyochosaKomoku09B_21.複合型サービス.get単位()));
        }

        List<dgRiyoSerViceSecondHalf_Row> halfList = new ArrayList();
        RString 介護給付状況 = RString.EMPTY;
        for (dgRiyoSerViceSecondHalf_Row rowData : halfListTmp) {
            if (rowData.getServiceMeisho().getValue().contains(介護予防)) {
                halfList.add(介護_介護予防を取り除く(rowData));
            } else {
                halfList.add(rowData);
            }
            介護給付状況 = 介護給付状況.concat(カンマ);
        }
        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の介護給付サービス, 介護給付状況);
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setDataSource(halfList);
        return halfList;
    }

    private void 施設利用名称取得(RString temp_厚労省IF識別コード) {

        List<dgRiyoShisetsu_Row> riyoShisetsuList = new ArrayList();

        if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_21.居宅.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku99A_20.介護保険施設外の施設.get名称()));
        } else if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_25.居宅.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_20.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_21.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_22.医療機関_療養.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_23.医療機関_療養以外.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku02A_24.その他の施設.get名称()));
        } else if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_31.居宅.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_23.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_24.介護老人保健施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_25.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_26.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_27.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_28.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_29.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku06A_30.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_32.居宅.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_24.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_25.介護老人保健施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_26.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_29.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_30.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09A_31.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_32.居宅.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_24.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_25.介護老人保健施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_26.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_29.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_30.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(getRiyoShisetsuData(GaikyochosaKomoku09B_31.その他の施設.get名称()));
        }

        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().setDataSource(riyoShisetsuList);
    }

    private dgRiyoSerViceFirstHalf_Row 予防_介護予防を取り除く(dgRiyoSerViceFirstHalf_Row row) {
        row.getServiceMeisho().setValue(row.getServiceMeisho().getValue().replace(介護予防, RString.EMPTY));
        return row;
    }

    private dgRiyoSerViceFirstHalf_Row 予防データ(RString name, RString tani) {
        dgRiyoSerViceFirstHalf_Row row = new dgRiyoSerViceFirstHalf_Row();
        row.getServiceMeisho().setValue(name);
        row.setTani(tani);
        return row;
    }

    private dgRiyoSerViceSecondHalf_Row 介護_介護予防を取り除く(dgRiyoSerViceSecondHalf_Row row) {
        row.getServiceMeisho().setValue(row.getServiceMeisho().getValue().replace(介護予防, RString.EMPTY));
        return row;
    }

    private dgRiyoSerViceSecondHalf_Row 介護データ(RString name, RString tani) {
        dgRiyoSerViceSecondHalf_Row row = new dgRiyoSerViceSecondHalf_Row();
        row.getServiceMeisho().setValue(name);
        row.setTani(tani);
        return row;
    }

    private dgRiyoShisetsu_Row getRiyoShisetsuData(RString name) {
        dgRiyoShisetsu_Row row = new dgRiyoShisetsu_Row();
        row.setShisetsuRiyoName(name);
        return row;
    }

    private boolean is再調査の場合() {
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        NinteichosahyoGaikyoChosaManager dbt5202Manager = new NinteichosahyoGaikyoChosaManager();
        NinteichosahyoGaikyoChosa joho = dbt5202Manager.get認定調査票_概況調査_子(temp_申請書管理番号, temp_認定調査履歴番号, new RString("1"));  //TODO  QA
        return joho != null;
    }

    private void 予防給付サービス_利用状況の設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_厚労省IF識別コード) {

        NinteichosahyoServiceJokyoManager manager = new NinteichosahyoServiceJokyoManager();
        List<Integer> 連番 = new ArrayList();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番.add(データベース内連番_1);
            連番.add(データベース内連番_2);
            連番.add(データベース内連番_3);
            連番.add(データベース内連番_4);
            連番.add(データベース内連番_5);
            連番.add(データベース内連番_6);
            連番.add(データベース内連番_7);
            連番.add(データベース内連番_8);
            連番.add(データベース内連番_9);
            連番.add(データベース内連番_10);
            連番.add(データベース内連番_11);
            連番.add(データベース内連番_12);
            連番.add(データベース内連番_14);
            連番.add(データベース内連番_15);
            連番.add(データベース内連番_16);
        }

        List<dgRiyoSerViceFirstHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().getDataSource();
        int index = 0;
        RString 予防給付状況 = RString.EMPTY;
        NinteichosahyoServiceJokyo joho;
        for (dgRiyoSerViceFirstHalf_Row row : halfList) {
            joho = manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番.get(index++));
            if (joho != null) {
                row.getServiceJokyo().setValue(new Decimal(joho.getサービスの状況()));
                予防給付状況 = 予防給付状況.concat(new RString(Integer.valueOf(joho.getサービスの状況()).toString())).concat(カンマ);
            } else {
                予防給付状況 = 予防給付状況.concat(カンマ);
            }
        }

        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の予防給付サービス, 予防給付状況);
    }

    private void 介護給付サービス_利用状況の設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_厚労省IF識別コード) {

        NinteichosahyoServiceJokyoManager manager = new NinteichosahyoServiceJokyoManager();
        List<Integer> 連番 = new ArrayList();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番.add(データベース内連番_1);
            連番.add(データベース内連番_2);
            連番.add(データベース内連番_3);
            連番.add(データベース内連番_4);
            連番.add(データベース内連番_5);
            連番.add(データベース内連番_6);
            連番.add(データベース内連番_7);
            連番.add(データベース内連番_8);
            連番.add(データベース内連番_9);
            連番.add(データベース内連番_10);
            連番.add(データベース内連番_11);
            連番.add(データベース内連番_12);
            連番.add(データベース内連番_13);
            連番.add(データベース内連番_14);
            連番.add(データベース内連番_15);
            連番.add(データベース内連番_16);
            連番.add(データベース内連番_17);
            連番.add(データベース内連番_18);
        }
        if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番.add(データベース内連番_19);
            連番.add(データベース内連番_20);
        }

        List<dgRiyoSerViceSecondHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().getDataSource();
        if (halfList.isEmpty()) {
            介護給付サービス名称取得(temp_厚労省IF識別コード);
            halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().getDataSource();
        }
        int index = 0;
        RString 介護給付状況 = RString.EMPTY;
        NinteichosahyoServiceJokyo joho;
        for (dgRiyoSerViceSecondHalf_Row row : halfList) {
            joho = manager.get認定調査票_概況調査_サービスの状況(temp_申請書管理番号, temp_認定調査履歴番号, 連番.get(index++));
            if (joho != null) {
                row.getServiceJokyo().setValue(new Decimal(joho.getサービスの状況()));
                介護給付状況 = 介護給付状況.concat(new RString(Integer.valueOf(joho.getサービスの状況()).toString())).concat(カンマ);
            } else {
                介護給付状況 = 介護給付状況.concat(カンマ);
            }
        }
        ViewStateHolder.put(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の介護給付サービス, 介護給付状況);
    }

    private void 施設_施設利用フラグの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_厚労省IF識別コード) {

        NinteichosahyoShisetsuRiyoManager manager = new NinteichosahyoShisetsuRiyoManager();
        List<Integer> 連番 = new ArrayList();

        if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番.add(データベース内連番_1);
            連番.add(データベース内連番_2);
            連番.add(データベース内連番_3);
            連番.add(データベース内連番_4);
            連番.add(データベース内連番_5);
            連番.add(データベース内連番_6);
            連番.add(データベース内連番_7);
            連番.add(データベース内連番_8);
            連番.add(データベース内連番_9);
        } else if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            連番.add(データベース内連番_1);
            連番.add(データベース内連番_2);
            連番.add(データベース内連番_3);
            連番.add(データベース内連番_4);
            連番.add(データベース内連番_9);
        }

        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        int index = 0;
        NinteichosahyoShisetsuRiyo joho;
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            joho = manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 連番.get(index++));
            if (joho != null && joho.is施設利用フラグ()) {
                row.setShisetsuRiyoUmu(Boolean.TRUE);
            }
        }
    }

    private void 在宅_住宅改修radの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoServiceJokyoFlagManager manager = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag joho = manager.get認定調査票_概況調査_サービスの状況フラグ(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        boolean 住宅改修 = joho.getサービスの状況フラグ();
        if (住宅改修) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(new RString("key0"));
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(new RString("key1"));

    }

    private void 在宅_市町村特別給付txtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoKinyuItemManager manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem joho = manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        if (joho != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().setValue(joho.getサービスの状況記入());
        }
    }

    private void 在宅_介護保険給付以外の在宅サービスtxtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoKinyuItemManager manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem joho = manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        if (joho != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().setValue(joho.getサービスの状況記入());
        }
    }

//    private void 前回基本調査情報() { // TODO 画面に何の部品にセットしますか？ #75188 この機能はTodoとしてください。また、テストも未実施で良いです。
//        return BusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, SubGyomuCode.DBE認定支援);
//    }
    /**
     * 前回申請書管理番号の取得処理です。
     *
     * @return 前回申請書管理番号
     */
    public ShinseishoKanriNo get前回申請書管理番号() {
        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        return finder.get前回申請書管理番号(ShinseishoKanriNo.EMPTY);
    }

    /**
     * 前回最大認定調査依頼履歴番号の取得処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     *
     * @return 前回最大認定調査依頼履歴番号
     */
    public int get前回最大認定調査依頼履歴番号(ShinseishoKanriNo 申請書管理番号) {
        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        return finder.getMax認定調査依頼履歴番号(申請書管理番号);
    }

    /**
     * 調査項目の取得処理です。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 前回最大認定調査依頼履歴番号 前回最大認定調査依頼履歴番号
     *
     * @return 調査項目
     */
    public RString get調査項目(ShinseishoKanriNo 申請書管理番号, int 前回最大認定調査依頼履歴番号) {
        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        return finder.get調査項目(申請書管理番号, 前回最大認定調査依頼履歴番号, 1);

    }

    /**
     * 在宅編集内容破棄の処理です。
     *
     * @param 選択値 現在サービス区分の選択値
     */
    public void 在宅編集内容の破棄(RString 選択値) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.厚労省IF識別コード, RString.class);

        RString 変更前の設定値 = RString.EMPTY;
        if (予防給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            変更前の設定値 = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の予防給付サービス, RString.class);
        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            変更前の設定値 = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の介護給付サービス, RString.class);
            if (変更前の設定値 == null) {
                介護給付サービス_利用状況の設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);
                変更前の設定値 = ViewStateHolder.get(NinnteiChousaKekkaTouroku1Handler.Dbe2210001Keys.初期の介護給付サービス, RString.class);
            }
        }

        List<RString> 変更前の設定値List = 変更前の設定値.split(カンマ.toString());
        int index = 0;
        if (予防給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {

            介護給付サービス非表示();
            予防給付サービス表示();
            予防給付サービス名称取得(temp_厚労省IF識別コード);
            List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                if (!変更前の設定値List.get(index).isEmpty()) {
                    row.getServiceJokyo().setValue(new Decimal(変更前の設定値List.get(index).toString()));
                }
                index++;
            }
        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {

            予防給付サービス非表示();
            介護給付サービス表示();
            List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
            for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
                if (変更前の設定値List.get(index) != null && !変更前の設定値List.get(index).isEmpty()) {
                    row.getServiceJokyo().setValue(new Decimal(変更前の設定値List.get(index).toString()));
                }
                index++;
            }
        }
    }

    /**
     * Dbe2210001Keys
     */
    public enum Dbe2210001Keys {

        /**
         * 初期の予防給付サービス
         */
        初期の予防給付サービス,
        /**
         * 初期の介護給付サービス
         */
        初期の介護給付サービス,
        /**
         * 厚労省IF識別コード
         */
        厚労省IF識別コード,
        /**
         * 認定調査回数
         */
        認定調査回数,
        /**
         * 認定調査回数
         */
        現在のサービス区分
    }

}
