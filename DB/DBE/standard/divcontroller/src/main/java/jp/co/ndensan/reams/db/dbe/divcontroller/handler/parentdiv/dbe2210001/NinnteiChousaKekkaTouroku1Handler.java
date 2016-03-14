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
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.ChosaJisshiBashoCode;
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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplShisetsuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplZaitakuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1Finder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoGaikyoChosa;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoGaikyoChosaManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 認定調査結果登録1のクラスです。
 */
public class NinnteiChousaKekkaTouroku1Handler {

    private final NinnteiChousaKekkaTouroku1Div div;

    private static final RString 予防給付サービス_選択 = new RString("key0");
    private static final RString 介護給付サービス_選択 = new RString("key1");
    private static final RString 住宅改修_有 = new RString("key0");
    private static final RString 住宅改修_無 = new RString("key1");
    private static final RString なし_選択 = new RString("key2");
    private static final RString 在宅 = new RString("在宅");
    private static final RString 施設 = new RString("施設");
    private static final RString 介護予防 = new RString("（介護予防）");
    private static final RString モードDAIGUN = new RString("Dai1gun");
    private static final RString モードDA2GUN = new RString("Dai2gun");
    private static final RString モードDA3GUN = new RString("Dai3gun");
    private static final RString モードDA4GUN = new RString("Dai4gun");
    private static final RString モードDA5GUN = new RString("Dai5gun");
    private static final RString モードDA6GUN = new RString("Dai6gun");
    private static final RString モードDA7GUN = new RString("Dai7gun");
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

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        div.getCcdNinteiShinseishaKihonInfo().onload(temp_申請書管理番号);
        div.getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Input);
        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        div.getCcdChosaJisshishaJoho().intialize(model);
        ViewStateHolder.put(Dbe2210001Keys.実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey());

        div.getCcdIchigunKihonChosa().onLoad(temp_申請書管理番号, new RString(temp_認定調査履歴番号.toString()), モードDAIGUN);
        div.getCcdNigunKihonChosa().onLoad(temp_申請書管理番号, new RString(temp_認定調査履歴番号.toString()), モードDA2GUN);
        div.getCcdSangunKihonChosa().onLoad(temp_申請書管理番号, new RString(temp_認定調査履歴番号.toString()), モードDA3GUN);
        div.getCcdYongunKihonChosa().onLoad(temp_申請書管理番号, new RString(temp_認定調査履歴番号.toString()), モードDA4GUN);
        div.getCcdGogun().onLoad(temp_申請書管理番号, new RString(temp_認定調査履歴番号.toString()), モードDA5GUN);
        div.getCcdTokubetsuIryoKihonChosa().onLoad(temp_申請書管理番号, new RString(temp_認定調査履歴番号.toString()), モードDA6GUN);
        div.getCcdSeikatsuJiritsudoKihonchosa().onLoad(temp_申請書管理番号, new RString(temp_認定調査履歴番号.toString()), モードDA7GUN);
        初期の基本調査の保存();

        RString 認定調査委託先コード = div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedValue();
        TempData tempData = 認定調査情報を取得(temp_申請書管理番号, temp_認定調査履歴番号, 認定調査委託先コード);
        RString temp_厚労省IF識別コード = tempData.getTemp_厚労省IF識別コード();
        RString temp_認定調査依頼区分コード = tempData.getTemp_認定調査依頼区分コード();
        RString temp_認定調査回数 = tempData.getTemp_認定調査回数();
        ViewStateHolder.put(Dbe2210001Keys.厚労省IF識別コード, temp_厚労省IF識別コード);
        ViewStateHolder.put(Dbe2210001Keys.認定調査依頼区分コード, temp_認定調査依頼区分コード);
        ViewStateHolder.put(Dbe2210001Keys.認定調査回数, temp_認定調査回数);

        boolean is再調査の場合 = is再調査の場合();
        ViewStateHolder.put(Dbe2210001Keys.再調査の場合, is再調査の場合);
        if (is再調査の場合) {
            既存概況調査情報取得(temp_厚労省IF識別コード);
        } else {
            div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().setSelectedKey(ChosaJisshiBashoCode.自宅内.getコード());
            ViewStateHolder.put(Dbe2210001Keys.実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey());

            ViewStateHolder.put(Dbe2210001Keys.現在の概況調査場所, 在宅);
            ViewStateHolder.put(Dbe2210001Keys.初期の概況調査場所, 在宅);
            ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 予防給付サービス_選択);
            ViewStateHolder.put(Dbe2210001Keys.初期のサービス区分, 予防給付サービス_選択);
            div.getRadGenzaiservis().setSelectedKey(予防給付サービス_選択);
            ViewStateHolder.put(Dbe2210001Keys.住宅改修rad, 住宅改修_無);
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修_無);

            div.getTabChosaBasho().setSelectedItem(new tplZaitakuDiv());
            予防給付サービス名称取得(temp_厚労省IF識別コード, Boolean.TRUE);
            利用サービス前半Grid表示();
            利用サービス後半Grid非表示();
        }
        ViewStateHolder.put(Dbe2210001Keys.特記, div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue());
    }

    /**
     * 入力内容を取り消します。
     */
    public void resetData() {

        ViewStateHolder.put(Dbe2210001Keys.再調査の場合, null);
        ViewStateHolder.put(Dbe2210001Keys.初期の予防給付サービス, null);
        ViewStateHolder.put(Dbe2210001Keys.初期の介護給付サービス, null);
        ViewStateHolder.put(Dbe2210001Keys.住宅改修rad, null);
        ViewStateHolder.put(Dbe2210001Keys.市町村特別給付TXT, null);
        ViewStateHolder.put(Dbe2210001Keys.介護保険給付以外の在宅サービスTXT, null);
        ViewStateHolder.put(Dbe2210001Keys.初期の施設利用, null);
        ViewStateHolder.put(Dbe2210001Keys.初期の施設連絡先, null);
        ViewStateHolder.put(Dbe2210001Keys.特記, null);
        ViewStateHolder.put(Dbe2210001Keys.初期の基本調査, null);
        ViewStateHolder.put(Dbe2210001Keys.厚労省IF識別コード, null);
        ViewStateHolder.put(Dbe2210001Keys.認定調査依頼区分コード, null);
        ViewStateHolder.put(Dbe2210001Keys.認定調査回数, null);
        ViewStateHolder.put(Dbe2210001Keys.初期のサービス区分, null);
        ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, null);
        ViewStateHolder.put(Dbe2210001Keys.現在の概況調査場所, null);
        ViewStateHolder.put(Dbe2210001Keys.初期の概況調査場所, null);
        ViewStateHolder.put(Dbe2210001Keys.実施場所, null);

        利用サービス前半Gridのクリア();
        利用サービス後半Gridのクリア();
        住宅改修と記入項目のクリア();
        div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().clearValue();
        施設tplのクリア();

        initialize();
    }

    private TempData 認定調査情報を取得(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_認定調査委託先コード) {

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        return finder.get認定調査情報(temp_認定調査履歴番号, temp_認定調査委託先コード, temp_申請書管理番号);
    }

    private boolean is再調査の場合() {
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);
        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        RString 概況調査テキストイメージ区分 = BusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate());
        NinteichosahyoGaikyoChosaManager dbt5202Manager = new NinteichosahyoGaikyoChosaManager();
        NinteichosahyoGaikyoChosa joho = dbt5202Manager.get認定調査票_概況調査_子(temp_申請書管理番号, temp_認定調査履歴番号, 概況調査テキストイメージ区分);
        return joho != null;
    }

    private void 既存概況調査情報取得(RString temp_厚労省IF識別コード) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.認定調査履歴番号, Integer.class);

        在宅_住宅改修radの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        在宅_市町村特別給付txtの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        在宅_介護保険給付以外の在宅サービスtxtの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        施設_施設利用フラグの設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        TempData gaikyoChosa = finder.get既存概況調査情報(temp_認定調査履歴番号, temp_申請書管理番号);
        if (gaikyoChosa == null) {
            return;
        }
        div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(gaikyoChosa.getTemp_特記());

        RString 現在の状況コード = gaikyoChosa.getTemp_現在の状況コード();
        RString サービス区分コード = gaikyoChosa.getTemp_現在のサービス区分コード();
        if (施設.equals(現在の状況コード) && ServiceKubunCode.なし.getコード().equals(サービス区分コード)) {

            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().setValue(gaikyoChosa.getTemp_利用施設名());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo()
                    .setValue(new YubinNo(gaikyoChosa.getTemp_利用施設郵便番号()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho()
                    .setDomain(new AtenaJusho(gaikyoChosa.getTemp_利用施設住所()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().setDomain(new TelNo(gaikyoChosa.getTemp_利用施設電話番号()));

            RString 施設連絡先 = gaikyoChosa.getTemp_利用施設名().concat(カンマ).concat(gaikyoChosa.getTemp_利用施設郵便番号()).concat(カンマ)
                    .concat(gaikyoChosa.getTemp_利用施設住所()).concat(カンマ).concat(gaikyoChosa.getTemp_利用施設電話番号());
            ViewStateHolder.put(Dbe2210001Keys.初期の施設連絡先, 施設連絡先);

            div.getTabChosaBasho().setSelectedItem(new tplShisetsuDiv());
            ViewStateHolder.put(Dbe2210001Keys.現在の概況調査場所, 施設);
            ViewStateHolder.put(Dbe2210001Keys.初期の概況調査場所, 施設);
            div.getRadGenzaiservis().setSelectedKey(なし_選択);
            ViewStateHolder.put(Dbe2210001Keys.初期のサービス区分, なし_選択);
            ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, なし_選択);
            施設_施設利用フラグの設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);
            利用サービス前半Grid非表示();
            利用サービス後半Grid非表示();

        } else if (在宅.equals(現在の状況コード)) {
            div.getTabChosaBasho().setSelectedItem(new tplZaitakuDiv());
            ViewStateHolder.put(Dbe2210001Keys.現在の概況調査場所, 在宅);
            ViewStateHolder.put(Dbe2210001Keys.初期の概況調査場所, 在宅);

            if (ServiceKubunCode.予防給付サービス.getコード().equals(サービス区分コード)) {
                div.getRadGenzaiservis().setSelectedKey(予防給付サービス_選択);
                ViewStateHolder.put(Dbe2210001Keys.初期のサービス区分, 予防給付サービス_選択);
                ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 予防給付サービス_選択);
                予防給付サービス_利用状況の設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);
                利用サービス前半Grid表示();
                利用サービス後半Grid非表示();
            } else if (ServiceKubunCode.介護給付サービス.getコード().equals(サービス区分コード)) {
                div.getRadGenzaiservis().setSelectedKey(介護給付サービス_選択);
                ViewStateHolder.put(Dbe2210001Keys.初期のサービス区分, 介護給付サービス_選択);
                ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 介護給付サービス_選択);
                介護給付サービス_利用状況の設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);
                利用サービス後半Grid表示();
                利用サービス前半Grid非表示();
            } else {
                div.getRadGenzaiservis().setSelectedKey(なし_選択);
                ViewStateHolder.put(Dbe2210001Keys.初期のサービス区分, なし_選択);
                ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, なし_選択);
                利用サービス前半Grid非表示();
                利用サービス後半Grid非表示();
            }
        }
    }

    private List<dgRiyoSerViceFirstHalf_Row> 予防給付サービス名称取得(RString temp_厚労省IF識別コード, boolean 初期) {

        List<dgRiyoSerViceFirstHalf_Row> halfListTmp = new ArrayList<>();
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

        List<dgRiyoSerViceFirstHalf_Row> halfList = new ArrayList<>();
        RString 予防給付状況 = RString.EMPTY;
        for (dgRiyoSerViceFirstHalf_Row rowData : halfListTmp) {
            if (rowData.getServiceMeisho().getValue().contains(介護予防)) {
                halfList.add(予防_介護予防を取り除く(rowData));
            }
            予防給付状況 = 予防給付状況.concat(カンマ);
        }
        if (初期) {
            ViewStateHolder.put(Dbe2210001Keys.初期の予防給付サービス, 予防給付状況);
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setDataSource(halfList);
        return halfList;
    }

    /**
     * 利用サービス前半Grid非表示を行います。
     */
    public void 利用サービス前半Grid非表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setVisible(false);
    }

    private void 利用サービス前半Grid表示() {

        RString temp_厚労省IF識別コード = ViewStateHolder.get(Dbe2210001Keys.厚労省IF識別コード, RString.class);
        予防給付サービス名称取得(temp_厚労省IF識別コード, Boolean.FALSE);
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().setVisible(true);
    }

    private List<dgRiyoSerViceSecondHalf_Row> 介護給付サービス名称取得(RString temp_厚労省IF識別コード) {
        List<dgRiyoSerViceSecondHalf_Row> halfListTmp = new ArrayList<>();

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

        List<dgRiyoSerViceSecondHalf_Row> halfList = new ArrayList<>();
        for (dgRiyoSerViceSecondHalf_Row rowData : halfListTmp) {
            if (rowData.getServiceMeisho().getValue().contains(介護予防)) {
                halfList.add(介護_介護予防を取り除く(rowData));
            } else {
                halfList.add(rowData);
            }
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setDataSource(halfList);
        return halfList;
    }

    /**
     * 利用サービス後半Grid非表示を行います。
     */
    public void 利用サービス後半Grid非表示() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setVisible(false);
    }

    private void 利用サービス後半Grid表示() {

        RString temp_厚労省IF識別コード = ViewStateHolder.get(Dbe2210001Keys.厚労省IF識別コード, RString.class);
        介護給付サービス名称取得(temp_厚労省IF識別コード);
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setVisible(true);
    }

    private void 施設利用名称取得(RString temp_厚労省IF識別コード, boolean 初期) {

        List<dgRiyoShisetsu_Row> riyoShisetsuList = new ArrayList<>();

        if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_21.居宅.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_20.介護保険施設外の施設.get名称()));
        } else if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_25.居宅.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_20.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_21.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_22.医療機関_療養.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_23.医療機関_療養以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_24.その他の施設.get名称()));
        } else if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_31.居宅.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_23.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_24.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_25.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_26.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_27.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_28.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_29.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_30.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_32.居宅.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_24.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_25.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_26.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_29.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_30.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_31.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_32.居宅.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_24.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_25.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_26.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_29.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_30.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09B_31.その他の施設.get名称()));
        }

        RString 施設利用 = RString.EMPTY;
        for (dgRiyoShisetsu_Row row : riyoShisetsuList) {
            施設利用 = 施設利用.concat(new RString(Boolean.FALSE.toString())).concat(カンマ);
        }
        if (初期) {
            ViewStateHolder.put(Dbe2210001Keys.初期の施設利用, 施設利用);
        }

        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().setDataSource(riyoShisetsuList);
    }

    private void 予防給付サービス_利用状況の設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_厚労省IF識別コード) {

        NinteichosahyoServiceJokyoManager manager = new NinteichosahyoServiceJokyoManager();
        List<Integer> 連番 = new ArrayList<>();

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
        if (halfList.isEmpty()) {
            予防給付サービス名称取得(temp_厚労省IF識別コード, Boolean.TRUE);
            halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().getDataSource();
        }
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
        ViewStateHolder.put(Dbe2210001Keys.初期の予防給付サービス, 予防給付状況);
    }

    private void 介護給付サービス_利用状況の設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_厚労省IF識別コード) {

        NinteichosahyoServiceJokyoManager manager = new NinteichosahyoServiceJokyoManager();
        List<Integer> 連番 = new ArrayList<>();

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
        ViewStateHolder.put(Dbe2210001Keys.初期の介護給付サービス, 介護給付状況);
    }

    private void 施設_施設利用フラグの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_厚労省IF識別コード) {

        NinteichosahyoShisetsuRiyoManager manager = new NinteichosahyoShisetsuRiyoManager();
        List<Integer> 連番 = new ArrayList<>();

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
        if (shisetsuList.isEmpty()) {
            施設利用名称取得(temp_厚労省IF識別コード, Boolean.TRUE);
            shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        }
        int index = 0;
        NinteichosahyoShisetsuRiyo joho;
        RString 施設利用 = RString.EMPTY;
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            joho = manager.get認定調査票_概況調査_施設利用(temp_申請書管理番号, temp_認定調査履歴番号, 連番.get(index++));
            if (joho != null && joho.is施設利用フラグ()) {
                row.setShisetsuRiyoUmu(Boolean.TRUE);
                施設利用 = 施設利用.concat(new RString(Boolean.TRUE.toString())).concat(カンマ);
            } else {
                施設利用 = 施設利用.concat(new RString(Boolean.FALSE.toString())).concat(カンマ);
            }
        }
        ViewStateHolder.put(Dbe2210001Keys.初期の施設利用, 施設利用);
    }

    /**
     * 施設の表示を行います。
     */
    public void 施設の表示() {

        RString temp_厚労省IF識別コード = ViewStateHolder.get(Dbe2210001Keys.厚労省IF識別コード, RString.class);
        施設利用名称取得(temp_厚労省IF識別コード, Boolean.FALSE);
    }

    /**
     * 再調査の場合、施設連絡先の設定を行います。
     *
     * @param temp_申請書管理番号 申請書管理番号
     * @param temp_認定調査履歴番号 認定調査履歴番号
     */
    public void 施設連絡先の設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        TempData gaikyoChosa = finder.get既存概況調査情報(temp_認定調査履歴番号, temp_申請書管理番号);

        RString 施設連絡先 = RString.EMPTY;
        if (gaikyoChosa != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().setValue(gaikyoChosa.getTemp_利用施設名());
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo()
                    .setValue(new YubinNo(gaikyoChosa.getTemp_利用施設郵便番号()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho()
                    .setDomain(new AtenaJusho(gaikyoChosa.getTemp_利用施設住所()));
            div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().setDomain(new TelNo(gaikyoChosa.getTemp_利用施設電話番号()));
            div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().setValue(gaikyoChosa.getTemp_特記());

            施設連絡先 = gaikyoChosa.getTemp_利用施設名().concat(カンマ).concat(gaikyoChosa.getTemp_利用施設郵便番号()).concat(カンマ)
                    .concat(gaikyoChosa.getTemp_利用施設住所()).concat(カンマ).concat(gaikyoChosa.getTemp_利用施設電話番号())
                    .concat(カンマ).concat(gaikyoChosa.getTemp_特記());
        }
        ViewStateHolder.put(Dbe2210001Keys.初期の施設連絡先, 施設連絡先);
    }

    private void 在宅_住宅改修radの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoServiceJokyoFlagManager manager = new NinteichosahyoServiceJokyoFlagManager();
        NinteichosahyoServiceJokyoFlag joho = manager.get認定調査票_概況調査_サービスの状況フラグ(temp_申請書管理番号, temp_認定調査履歴番号, 住宅改修_連番);
        boolean 住宅改修 = joho.getサービスの状況フラグ();
        RString 住宅改修rad = 住宅改修_無;
        if (住宅改修) {
            住宅改修rad = 住宅改修_有;
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修rad);
        ViewStateHolder.put(Dbe2210001Keys.住宅改修rad, 住宅改修rad);
    }

    private void 在宅_市町村特別給付txtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoKinyuItemManager manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem joho = manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 市町村特別給付_連番);
        RString 市町村特別給付TXT = RString.EMPTY;
        if (joho != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().setValue(joho.getサービスの状況記入());
            市町村特別給付TXT = joho.getサービスの状況記入();
        }
        ViewStateHolder.put(Dbe2210001Keys.市町村特別給付TXT, 市町村特別給付TXT);
    }

    private void 在宅_介護保険給付以外の在宅サービスtxtの設定(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号) {
        NinteichosahyoKinyuItemManager manager = new NinteichosahyoKinyuItemManager();
        NinteichosahyoKinyuItem joho = manager.get認定調査票_概況調査_記入項目(temp_申請書管理番号, temp_認定調査履歴番号, 介護保険給付外の在宅サービス_連番);
        RString 介護保険給付以外の在宅サービスTXT = RString.EMPTY;
        if (joho != null) {
            div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().setValue(joho.getサービスの状況記入());
            介護保険給付以外の在宅サービスTXT = joho.getサービスの状況記入();
        }
        ViewStateHolder.put(Dbe2210001Keys.介護保険給付以外の在宅サービスTXT, 介護保険給付以外の在宅サービスTXT);
    }

//    private void 前回基本調査情報() { #75188 この機能はTodoとしてください。また、テストも未実施で良いです。
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

    private dgRiyoShisetsu_Row 施設データ(RString name) {
        dgRiyoShisetsu_Row row = new dgRiyoShisetsu_Row();
        row.setShisetsuRiyoName(name);
        return row;
    }

    /**
     * 利用サービス前半or後半の切り替え処理です。
     *
     * @param 変更あり 予防給付サービス/介護給付サービス 変更あり
     * @param 現在の選択 現在サービス区分の選択値
     * @param 元の選択 元のサービス区分の選択値
     */
    public void 利用サービス前半or後半の切り替え(boolean 変更あり, RString 現在の選択, RString 元の選択) {

        if (予防給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            利用サービス前半Grid表示();
            利用サービス後半Grid非表示();

        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            利用サービス後半Grid表示();
            利用サービス前半Grid非表示();

        } else if (なし_選択.toString().equalsIgnoreCase(現在の選択.toString())) {

            利用サービス前半Grid非表示();
            利用サービス後半Grid非表示();
        }

        if (変更あり && 予防給付サービス_選択.toString().equalsIgnoreCase(元の選択.toString())) {
            利用サービス前半Gridの破棄();

        } else if (変更あり && 介護給付サービス_選択.toString().equalsIgnoreCase(元の選択.toString())) {
            利用サービス後半Gridの破棄();
        }
    }

    /**
     * 利用サービス前半Gridの破棄を行います。
     */
    public void 利用サービス前半Gridの破棄() {

        List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();

        RString 変更前の設定値 = ViewStateHolder.get(Dbe2210001Keys.初期の予防給付サービス, RString.class);
        if (変更前の設定値 == null || 変更前の設定値.isEmpty()) {
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                row.getServiceJokyo().clearValue();
            }
            return;
        }

        List<RString> 変更前の設定値List = 変更前の設定値.split(カンマ.toString());
        int index = 0;
        RString 数値 = RString.EMPTY;
        for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
            row.setSelected(Boolean.FALSE);
            数値 = 変更前の設定値List.get(index);
            if (数値.isEmpty()) {
                row.getServiceJokyo().clearValue();
            } else {
                row.getServiceJokyo().setValue(new Decimal(数値.toString()));
            }
            index++;
        }
    }

    /**
     * 利用サービス前半Gridのクリアを行います。
     */
    public void 利用サービス前半Gridのクリア() {
        div.getDgRiyoSerViceFirstHalf().setDataSource(null);
    }

    /**
     * 利用サービス後半Gridの破棄を行います。
     */
    public void 利用サービス後半Gridの破棄() {

        List<dgRiyoSerViceSecondHalf_Row> secondHalf = div.getDgRiyoSerViceSecondHalf().getDataSource();
        RString 変更前の設定値 = ViewStateHolder.get(Dbe2210001Keys.初期の介護給付サービス, RString.class);
        if (変更前の設定値 == null || 変更前の設定値.isEmpty()) {
            for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
                row.getServiceJokyo().clearValue();
            }
            return;
        }

        List<RString> 変更前の設定値List = 変更前の設定値.split(カンマ.toString());
        int index = 0;
        RString 数値 = RString.EMPTY;
        for (dgRiyoSerViceSecondHalf_Row row : secondHalf) {
            row.setSelected(Boolean.FALSE);
            数値 = 変更前の設定値List.get(index);
            if (数値.isEmpty()) {
                row.getServiceJokyo().clearValue();
            } else {
                row.getServiceJokyo().setValue(new Decimal(数値.toString()));
            }
            index++;
        }
    }

    /**
     * 利用サービス後半Gridのクリアを行います。
     */
    public void 利用サービス後半Gridのクリア() {

        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().setDataSource(null);
    }

    /**
     * 住宅改修と記入項目のクリアを行います。
     */
    public void 住宅改修と記入項目のクリア() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getRadJutakuKaishu().setSelectedKey(住宅改修_無);
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtShichosonTokubetsuKyufu().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getTxtKyufuIgaiJutakuService().clearValue();
    }

    /**
     * 施設tplのクリアを行います。
     */
    public void 施設tplのクリア() {
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().setDataSource(null);

        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().setDomain(new AtenaJusho(RString.EMPTY));
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().setDomain(new TelNo(RString.EMPTY));

    }

    private void 初期の基本調査の保存() {

        RString 初期の基本調査 = get基本調査();
        ViewStateHolder.put(Dbe2210001Keys.初期の基本調査, 初期の基本調査);
    }

    /**
     * 入力内容の変更が存在しないかを判断します。
     *
     * @return 判断結果(true:変更がない false:変更があり)
     */
    public boolean is入力内容変更なし() {

        boolean is在宅等しい = is在宅等しい();
        boolean is市町村特別給付_等しい = is等しい(ViewStateHolder.get(Dbe2210001Keys.市町村特別給付TXT, RString.class),
                div.getTxtShichosonTokubetsuKyufu().getValue());
        boolean is介護保険給付以外の在宅サービス_等しい = is等しい(ViewStateHolder.get(Dbe2210001Keys.介護保険給付以外の在宅サービスTXT,
                RString.class), div.getTxtKyufuIgaiJutakuService().getValue());
        boolean is特記等しい = is等しい(ViewStateHolder.get(Dbe2210001Keys.特記, RString.class),
                div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getValue());
        boolean is施設等しい = is施設等しい();
        boolean is施設連絡先 = is施設連絡先等しい();
        boolean is基本調査等しい = is基本調査等しい();

        boolean is状況コード等しい = is等しい(ViewStateHolder.get(Dbe2210001Keys.初期の概況調査場所, RString.class),
                ViewStateHolder.get(Dbe2210001Keys.現在の概況調査場所, RString.class));
        boolean サービス区分等しい = is等しい(ViewStateHolder.get(Dbe2210001Keys.初期のサービス区分, RString.class),
                ViewStateHolder.get(Dbe2210001Keys.現在のサービス区分, RString.class));

        return is在宅等しい && is市町村特別給付_等しい && is介護保険給付以外の在宅サービス_等しい && is特記等しい
                && is施設等しい && is施設連絡先 && is基本調査等しい && is状況コード等しい && サービス区分等しい;

    }

    private boolean is在宅等しい() {
        boolean is在宅等しい;
        RString 選択値 = div.getRadGenzaiservis().getSelectedKey();
        RString 現在の設定値 = RString.EMPTY;
        if (予防給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            is在宅等しい = is等しい(ViewStateHolder.get(Dbe2210001Keys.初期の予防給付サービス, RString.class), 現在の設定値);
        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(選択値.toString())) {
            List<dgRiyoSerViceFirstHalf_Row> fistHalf = div.getDgRiyoSerViceFirstHalf().getDataSource();
            for (dgRiyoSerViceFirstHalf_Row row : fistHalf) {
                if (row.getServiceJokyo().getValue() != null) {
                    現在の設定値 = 現在の設定値.concat(row.getServiceJokyo().getValue().toString()).concat(カンマ);
                } else {
                    現在の設定値 = 現在の設定値.concat(カンマ);
                }
            }
            is在宅等しい = is等しい(ViewStateHolder.get(Dbe2210001Keys.初期の介護給付サービス, RString.class), 現在の設定値);
        } else {
            is在宅等しい = true;
        }
        return is在宅等しい;
    }

    private boolean is施設等しい() {

        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        RString 施設利用 = RString.EMPTY;
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            施設利用 = 施設利用.concat(new RString(row.getShisetsuRiyoUmu().toString())).concat(カンマ);
        }
        return is等しい(ViewStateHolder.get(Dbe2210001Keys.初期の施設利用, RString.class), 施設利用);
    }

    private boolean is施設連絡先等しい() {

        RString 施設連絡先 = RString.EMPTY;
        RString 施設名称 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().getValue();
        RString 郵便 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().getValue().getColumnValue();
        RString 住所 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().getDomain().getColumnValue();
        RString 電話番号 = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().getDomain().getColumnValue();

        if (施設名称.isEmpty() && 郵便.isEmpty() && 住所.isEmpty() && 電話番号.isEmpty()) {
            施設連絡先 = null;
        } else {
            施設連絡先 = 施設名称.concat(カンマ).concat(郵便).concat(カンマ).concat(住所).concat(カンマ)
                    .concat(電話番号);
        }
        return is等しい(ViewStateHolder.get(Dbe2210001Keys.初期の施設連絡先, RString.class), 施設連絡先);

    }

    private boolean is基本調査等しい() {
        RString 現在の基本調査 = get基本調査();
        RString 初期の基本調査 = ViewStateHolder.get(Dbe2210001Keys.初期の基本調査, RString.class);
        return is等しい(現在の基本調査, 初期の基本調査);
    }

    private boolean is等しい(RString beforeVal, RString afterVal) {
        if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal == null || afterVal.isEmpty())) {
            return true;
        } else if ((beforeVal == null || beforeVal.isEmpty()) && (afterVal != null && !afterVal.isEmpty())) {
            return false;
        }
        return beforeVal.equals(afterVal);
    }

    private RString get基本調査() {
        List<RString> 麻痺List = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getChkMahi().getSelectedKeys();
        RString 麻痺 = RString.EMPTY;
        for (RString val : 麻痺List) {
            麻痺 = 麻痺.concat(val);
        }
        List<RString> 拘縮List = div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getChkKoshuku().getSelectedKeys();
        RString 拘縮 = RString.EMPTY;
        for (RString val : 拘縮List) {
            拘縮 = 拘縮.concat(val);
        }
        RString 第1群 = 麻痺.concat(拘縮)
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadNeKaeri().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadOkiAgari().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadZai().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadRyoAshi().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadBuko().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadTachiAgari().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadKataAshi().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadSenshin().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadTumeKiri().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadShiryoku().getSelectedKey())
                .concat(div.getCcdIchigunKihonChosa().getDaiichigunShintaiKino().getRadChoryoku().getSelectedKey());

        RString 第2群 = div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadIjyo().getSelectedKey()
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadIdou().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadEnka().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadShokuji().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHainyo().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHaiben().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadKokou().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadSengan().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadSeihatsu().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadUwagi().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadZubon().getSelectedKey())
                .concat(div.getCcdNigunKihonChosa().getSeikatsuKinou().getRadHindo().getSelectedKey());

        RString 第3群 = div.getCcdSangunKihonChosa().getNinchiKinou().getRadIshiDentatsu().getSelectedKey()
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadNikka().getSelectedKey())
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadInfo().getSelectedKey())
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadDankiKioku().getSelectedKey())
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadNameInfo().getSelectedKey())
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadKisetsu().getSelectedKey())
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadBasho().getSelectedKey())
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadHaikai().getSelectedKey())
                .concat(div.getCcdSangunKihonChosa().getNinchiKinou().getRadModoru().getSelectedKey());

        RString 第4群 = div.getCcdYongunKihonChosa().getKoudoShogai().getRadbtnHiryaku().getSelectedKey()
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadTukuriHanashi().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadKanjyo().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadChuyaku().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadOnajiHanashi().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadBigVoice().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadTeikou().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadOchituki().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadOutLonly().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadShushu().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadKowasu().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadMonoWasure().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadHitoriWarai().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadKateKodo().getSelectedKey())
                .concat(div.getCcdYongunKihonChosa().getKoudoShogai().getRadMatomeNai().getSelectedKey());

        RString 第5群 = div.getCcdGogun().getShakaiSekatsu().getRadKusuri().getSelectedKey()
                .concat(div.getCcdGogun().getShakaiSekatsu().getRadKingakuKanri().getSelectedKey())
                .concat(div.getCcdGogun().getShakaiSekatsu().getRadIshiKetei().getSelectedKey())
                .concat(div.getCcdGogun().getShakaiSekatsu().getRadShudan().getSelectedKey())
                .concat(div.getCcdGogun().getShakaiSekatsu().getRadKaiMono().getSelectedKey())
                .concat(div.getCcdGogun().getShakaiSekatsu().getRadKantanChori().getSelectedKey());

        RString 処置内容 = RString.EMPTY;
        RString 特別な対応 = RString.EMPTY;
        List<RString> 処置内容List = div.getCcdTokubetsuIryoKihonChosa().getTokubetsuIryo().getChkShochiNaiyo().getSelectedKeys();
        for (RString val : 処置内容List) {
            処置内容 = 処置内容.concat(val);
        }
        List<RString> 特別な対応List = div.getCcdTokubetsuIryoKihonChosa().getTokubetsuIryo().getChkTokiTaiou().getSelectedKeys();
        for (RString val : 特別な対応List) {
            特別な対応 = 特別な対応.concat(val);
        }
        RString 特別な医療 = 処置内容.concat(特別な対応);

        RString 生活自立度 = div.getCcdSeikatsuJiritsudoKihonchosa().getJiritsudo().getRadShogaiKoreisha().getSelectedKey()
                .concat(div.getCcdSeikatsuJiritsudoKihonchosa().getJiritsudo().getRadNinchishaJiritsudo().getSelectedKey());

        return 第1群.concat(第2群).concat(第3群).concat(第4群).concat(第5群).concat(特別な医療).concat(生活自立度);
    }

    /**
     * Dbe2210001Keys
     */
    public enum Dbe2210001Keys {

        /**
         * 再調査の場合
         */
        再調査の場合,
        /**
         * 初期の予防給付サービス
         */
        初期の予防給付サービス,
        /**
         * 初期の介護給付サービス
         */
        初期の介護給付サービス,
        /**
         * 住宅改修rad
         */
        住宅改修rad,
        /**
         * 市町村特別給付TXT
         */
        市町村特別給付TXT,
        /**
         * 介護保険給付以外の在宅サービスTXT
         */
        介護保険給付以外の在宅サービスTXT,
        /**
         * 初期の施設利用
         */
        初期の施設利用,
        /**
         * 初期の施設連絡先
         */
        初期の施設連絡先,
        /**
         * 特記
         */
        特記,
        /**
         * 初期の基本調査
         */
        初期の基本調査,
        /**
         * 厚労省IF識別コード
         */
        厚労省IF識別コード,
        /**
         * 認定調査依頼区分コード
         */
        認定調査依頼区分コード,
        /**
         * 認定調査回数
         */
        認定調査回数,
        /**
         * 初期のサービス区分
         */
        初期のサービス区分,
        /**
         * 現在のサービス区分
         */
        現在のサービス区分,
        /**
         * 現在の概況調査場所（在宅/施設）
         */
        現在の概況調査場所,
        /**
         * 初期の概況調査場所（在宅/施設）
         */
        初期の概況調査場所,
        /**
         * 実施場所
         */
        実施場所
    }

}
