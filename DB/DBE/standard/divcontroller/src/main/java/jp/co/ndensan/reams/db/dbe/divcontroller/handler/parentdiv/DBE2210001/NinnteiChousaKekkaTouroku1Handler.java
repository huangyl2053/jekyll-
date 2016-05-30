/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2210001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninnteichousakekkatouroku1.TempData;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.chosa.ChosaJisshiBashoCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_17;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_18;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_19;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_20;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_21;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_22;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_23;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku.GaikyochosaKomoku02A_24;
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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.NinnteiChousaKekkaTouroku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceFirstHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoSerViceSecondHalf_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.dgRiyoShisetsu_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplShisetsuDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2210001.tplZaitakuDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninnteichousakekkatouroku1.NinnteiChousaKekkaTouroku1Finder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInput;
import jp.co.ndensan.reams.db.dbz.business.core.kihonchosainput.KihonChosaInputBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.chosajisshishajoho.ChosaJisshishaJohoModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaJisshishaJoho.ChosaJisshishaJoho.ChosaJisshishaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput1.KihonChosaInput1.KihonChosaInputHandler1;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput2.KihonChosaInput2.KihonChosaInputHandler2;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput3.KihonChosaInput3.KihonChosaInputHandler3;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput4.KihonChosaInput4.KihonChosaInputHandler4;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput5.KihonChosaInput5.KihonChosaInputHandler5;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput6.KihonChosaInput6.KihonChosaInputHandler6;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KihonChosaInput7.KihonChosaInput7.KihonChosaInputHandler7;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoKinyuItemManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.basic.NinteichosahyoShisetsuRiyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.kihonchosainput.KihonChosaInputFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定調査結果登録1のクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
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
    private static final int データベース内連番_63 = 63;
    private static final int データベース内連番_64 = 64;
    private static final int データベース内連番_65 = 65;
    private static final int データベース内連番_66 = 66;
    private static final int データベース内連番_67 = 67;
    private static final int データベース内連番_68 = 68;
    private static final int データベース内連番_69 = 69;
    private static final int データベース内連番_70 = 70;
    private static final int データベース内連番_71 = 71;
    private static final int データベース内連番_72 = 72;
    private static final int データベース内連番_73 = 73;
    private static final int データベース内連番_74 = 74;
    private static final RString 第1群の連番_有無 = new RString(",1,2,3,4,5,6,7,8,9,");
    private static final RString 第1群の連番 = new RString(",10,11,12,13,14,15,16,17,18,19,20,");
    private static final RString 第2群の連番 = new RString(",21,22,23,24,25,26,27,28,29,30,31,32,");
    private static final RString 第3群の連番 = new RString(",33,34,35,36,37,38,39,40,41,");
    private static final RString 第4群の連番 = new RString(",42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,");
    private static final RString 第5群の連番 = new RString(",57,58,59,60,61,62,");
    private static final RString 特別な医療の連番 = new RString(",63,64,65,66,67,68,69,70,71,72,73,74,");
    private static final RString 項目値１ = new RString("1");
    private static final RString 調査項目_ない = new RString("1");
    private static final RString 調査項目_ある = new RString("2");
    private static final RString 認定調査前回結果表示 = new RString("1");

    /**
     * コンストラクタです。
     *
     * @param div 認定調査結果登録1のコントロールdiv
     */
    public NinnteiChousaKekkaTouroku1Handler(NinnteiChousaKekkaTouroku1Div div) {
        this.div = div;
    }

    /**
     * 初期化の処理です。
     */
    public void initialize() {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, Integer.class);

        div.getCcdNinteiShinseishaKihonInfo().initialize(temp_申請書管理番号);
        div.getCcdNinteiShinseiRenrakusakiKihon().initialize(temp_申請書管理番号);
        div.getCcdChosaJisshishaJoho().setMode_State(ChosaJisshishaJohoDiv.State.Input);
        ChosaJisshishaJohoModel model = new ChosaJisshishaJohoModel();
        model.set申請書管理番号(temp_申請書管理番号.getColumnValue());
        div.getCcdChosaJisshishaJoho().intialize(model);
        ViewStateHolder.put(Dbe2210001Keys.実施場所, div.getCcdChosaJisshishaJoho().getDdlChosaJisshiBasho().getSelectedKey());

        RString 認定調査委託先コード = div.getCcdChosaJisshishaJoho().getDdlShozokuKikan().getSelectedValue();
        TempData tempData = 認定調査情報を取得(temp_申請書管理番号, temp_認定調査履歴番号, 認定調査委託先コード);
        RString temp_厚労省IF識別コード = tempData.getTemp_厚労省IF識別コード();
        RString temp_認定調査依頼区分コード = tempData.getTemp_認定調査依頼区分コード();
        RString temp_認定調査回数 = tempData.getTemp_認定調査回数();
        ViewStateHolder.put(Dbe2210001Keys.厚労省IF識別コード, temp_厚労省IF識別コード);
        ViewStateHolder.put(Dbe2210001Keys.認定調査依頼区分コード, temp_認定調査依頼区分コード);
        ViewStateHolder.put(Dbe2210001Keys.認定調査回数, temp_認定調査回数);

        boolean is再調査の場合 = ChosaKubun.再調査.get名称().equals(div.getCcdChosaJisshishaJoho().getTxtChosaKubun().getValue());
        ViewStateHolder.put(Dbe2210001Keys.再調査の場合, is再調査の場合);

        基本調査の初期化();

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
        ViewStateHolder.put(Dbe2210001Keys.特記, div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().getText());
    }

    /**
     * 入力内容を取り消します。
     */
    public void resetData() {

        ViewStateHolder.put(Dbe2210001Keys.再調査の場合, Boolean.FALSE);
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

        ArrayList<KihonChosaInput> list = new ArrayList<>();
        ViewStateHolder.put(KihonChosaInputHandler1.ViewStateKey.第一群認定調査基本情報リスト, list);
        ViewStateHolder.put(KihonChosaInputHandler2.ViewStateKey.第二群認定調査基本情報リスト, list);
        ViewStateHolder.put(KihonChosaInputHandler3.ViewStateKey.第三群認定調査基本情報リスト, list);
        ViewStateHolder.put(KihonChosaInputHandler4.ViewStateKey.第四群認定調査基本情報リスト, list);
        ViewStateHolder.put(KihonChosaInputHandler5.ViewStateKey.第五群認定調査基本情報リスト, list);
        ViewStateHolder.put(KihonChosaInputHandler6.ViewStateKey.第六群認定調査基本情報リスト, list);
        ViewStateHolder.put(KihonChosaInputHandler7.ViewStateKey.第七群認定調査基本情報リスト, list);

        利用サービス前半Gridのクリア();
        利用サービス後半Gridのクリア();
        利用サービス前半Grid表示();
        利用サービス後半Grid表示();
        住宅改修と記入項目のクリア();
        div.getTabChosaShurui().getGaikyoTokkiInput().getTxtGaikyoTokkiNyuroku().clearValue();
        施設tplのクリア();

        initialize();
    }

    private TempData 認定調査情報を取得(ShinseishoKanriNo temp_申請書管理番号, Integer temp_認定調査履歴番号, RString temp_認定調査委託先コード) {

        NinnteiChousaKekkaTouroku1Finder finder = NinnteiChousaKekkaTouroku1Finder.createInstance();
        return finder.get認定調査情報(temp_認定調査履歴番号, temp_認定調査委託先コード, temp_申請書管理番号);
    }

    private void 既存概況調査情報取得(RString temp_厚労省IF識別コード) {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);
        Integer temp_認定調査履歴番号 = ViewStateHolder.get(ViewStateKeys.主治医意見書作成依頼履歴番号, Integer.class);

        在宅_住宅改修radの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        在宅_市町村特別給付txtの設定(temp_申請書管理番号, temp_認定調査履歴番号);
        在宅_介護保険給付以外の在宅サービスtxtの設定(temp_申請書管理番号, temp_認定調査履歴番号);

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
            div.getRadGenzaiservis().setDisabled(Boolean.TRUE);
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
                利用サービス後半Grid非表示();
            } else if (ServiceKubunCode.介護給付サービス.getコード().equals(サービス区分コード)) {
                div.getRadGenzaiservis().setSelectedKey(介護給付サービス_選択);
                ViewStateHolder.put(Dbe2210001Keys.初期のサービス区分, 介護給付サービス_選択);
                ViewStateHolder.put(Dbe2210001Keys.現在のサービス区分, 介護給付サービス_選択);
                介護給付サービス_利用状況の設定(temp_申請書管理番号, temp_認定調査履歴番号, temp_厚労省IF識別コード);
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

        boolean is再調査の場合 = ViewStateHolder.get(Dbe2210001Keys.再調査の場合, Boolean.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(Dbe2210001Keys.厚労省IF識別コード, RString.class);
        予防給付サービス名称取得(temp_厚労省IF識別コード, Boolean.FALSE);
        if (is再調査の場合) {
            利用サービス前半Gridの破棄();
        }
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

        boolean is再調査の場合 = ViewStateHolder.get(Dbe2210001Keys.再調査の場合, Boolean.class);
        RString temp_厚労省IF識別コード = ViewStateHolder.get(Dbe2210001Keys.厚労省IF識別コード, RString.class);
        介護給付サービス名称取得(temp_厚労省IF識別コード);
        if (is再調査の場合) {
            利用サービス後半Gridの破棄();
        }
        div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().setVisible(true);
    }

    private void 施設利用名称取得(RString temp_厚労省IF識別コード, boolean 初期) {

        List<dgRiyoShisetsu_Row> riyoShisetsuList = new ArrayList<>();

        if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku99A_20.介護保険施設外の施設.get名称()));
        } else if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_17.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_18.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_19.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_20.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_21.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_22.医療機関_療養.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_23.医療機関_療養以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku02A_24.その他の施設.get名称()));
        } else if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_23.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_24.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_25.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_26.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_27.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_28.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_29.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku06A_30.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)) {
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_24.介護老人福祉施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_25.介護老人保健施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_26.介護療養型医療施設.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_27.認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_28.特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_29.医療機関_医療保険適用療養病床.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_30.医療機関_療養病床以外.get名称()));
            riyoShisetsuList.add(施設データ(GaikyochosaKomoku09A_31.その他の施設.get名称()));
        } else if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
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
        List<Integer> 連番 = get予防給付サービス連番List(temp_厚労省IF識別コード);

        List<dgRiyoSerViceFirstHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().getDataSource();
        if (halfList == null || halfList.isEmpty()) {
            予防給付サービス名称取得(temp_厚労省IF識別コード, Boolean.TRUE);
            halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceFirstHalf().getDataSource();
        }

        List<NinteichosahyoServiceJokyo> johoList = manager.get認定調査票_概況調査_サービスの状況By連番List(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        RString 予防給付状況 = RString.EMPTY;
        NinteichosahyoServiceJokyo joho;
        int index = 0;
        for (dgRiyoSerViceFirstHalf_Row row : halfList) {
            joho = johoList.get(index++);
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
        List<Integer> 連番 = get介護給付サービス連番List(temp_厚労省IF識別コード);

        List<dgRiyoSerViceSecondHalf_Row> halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().getDataSource();
        if (halfList == null || halfList.isEmpty()) {
            介護給付サービス名称取得(temp_厚労省IF識別コード);
            halfList = div.getTabChosaShurui().getTplGaikyoChosa().getTplZaitaku().getDgRiyoSerViceSecondHalf().getDataSource();
        }

        List<NinteichosahyoServiceJokyo> johoList = manager.get認定調査票_概況調査_サービスの状況By連番List(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        int index = 0;
        RString 介護給付状況 = RString.EMPTY;
        NinteichosahyoServiceJokyo joho;
        for (dgRiyoSerViceSecondHalf_Row row : halfList) {
            joho = johoList.get(index++);
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
        List<Integer> 連番 = get施設利用連番List(temp_厚労省IF識別コード);

        List<dgRiyoShisetsu_Row> shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        if (shisetsuList.isEmpty()) {
            施設利用名称取得(temp_厚労省IF識別コード, Boolean.TRUE);
            shisetsuList = div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource();
        }

        List<NinteichosahyoShisetsuRiyo> johoList = manager.get認定調査票_概況調査_施設利用By連番List(temp_申請書管理番号, temp_認定調査履歴番号, 連番);
        int index = 0;
        NinteichosahyoShisetsuRiyo joho;
        RString 施設利用 = RString.EMPTY;
        for (dgRiyoShisetsu_Row row : shisetsuList) {
            joho = johoList.get(index++);
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
        if (div.getDgRiyoShisetsu().getDataSource() == null || div.getDgRiyoShisetsu().getDataSource().isEmpty()) {
            施設利用名称取得(temp_厚労省IF識別コード, Boolean.FALSE);
        }
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
        boolean 住宅改修 = joho.isサービスの状況フラグ();
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
     * @param 現在の選択 現在サービス区分の選択値
     */
    public void 利用サービス前半or後半の切り替え(RString 現在の選択) {

        if (予防給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            利用サービス前半Grid表示();
            利用サービス後半Grid非表示();
            利用サービス後半Gridのクリア();

        } else if (介護給付サービス_選択.toString().equalsIgnoreCase(現在の選択.toString())) {
            利用サービス後半Grid表示();
            利用サービス前半Grid非表示();
            利用サービス前半Gridのクリア();

        } else if (なし_選択.toString().equalsIgnoreCase(現在の選択.toString())) {

            利用サービス前半Grid非表示();
            利用サービス後半Grid非表示();
            利用サービス前半Gridのクリア();
            利用サービス後半Gridのクリア();
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
        div.getDgRiyoSerViceFirstHalf().getDataSource().clear();
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
        div.getDgRiyoSerViceSecondHalf().getDataSource().clear();
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
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getDgRiyoShisetsu().getDataSource().clear();

        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuMeisdho().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuYubinNo().clearValue();
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtShisetsuJusho().setDomain(new AtenaJusho(RString.EMPTY));
        div.getTabChosaShurui().getTplGaikyoChosa().getTplShisetsu().getTxtTelNo().setDomain(new TelNo(RString.EMPTY));
    }

    private void 基本調査の初期化() {

        ShinseishoKanriNo temp_申請書管理番号 = ViewStateHolder.get(ViewStateKeys.申請書管理番号, ShinseishoKanriNo.class);

        ArrayList<KihonChosaInput> 第1群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 特別な医療List = new ArrayList<>();
        ArrayList<KihonChosaInput> 自立度List = new ArrayList<>();

        RString 自立度 = RString.EMPTY;

        boolean 前回基本調査項目値あり = false;

        boolean is再調査の場合 = ViewStateHolder.get(Dbe2210001Keys.再調査の場合, Boolean.class);
        KihonChosaInputFinder findler = KihonChosaInputFinder.createInstance();
        List<KihonChosaInput> 認定調査基本情報リスト = new ArrayList<>();
        if (is再調査の場合) {
            認定調査基本情報リスト = findler.get認定調査基本情報(temp_申請書管理番号);
        }

        if (認定調査基本情報リスト.isEmpty()) {
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_1, 調査項目_ない, new Code(), new Code(), データベース内連番_1,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_2, 調査項目_ない, new Code(), new Code(), データベース内連番_2,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_3, 調査項目_ない, new Code(), new Code(), データベース内連番_3,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_4, 調査項目_ない, new Code(), new Code(), データベース内連番_4,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_5, 調査項目_ない, new Code(), new Code(), データベース内連番_5,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_6, 調査項目_ない, new Code(), new Code(), データベース内連番_6,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_7, 調査項目_ない, new Code(), new Code(), データベース内連番_7,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_8, 調査項目_ない, new Code(), new Code(), データベース内連番_8,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            第1群List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_9, 調査項目_ない, new Code(), new Code(), データベース内連番_9,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));

            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_63, 調査項目_ない, new Code(), new Code(), データベース内連番_63,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_64, 調査項目_ない, new Code(), new Code(), データベース内連番_64,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_65, 調査項目_ない, new Code(), new Code(), データベース内連番_65,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_66, 調査項目_ない, new Code(), new Code(), データベース内連番_66,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_67, 調査項目_ない, new Code(), new Code(), データベース内連番_67,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_68, 調査項目_ない, new Code(), new Code(), データベース内連番_68,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_69, 調査項目_ない, new Code(), new Code(), データベース内連番_69,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_70, 調査項目_ない, new Code(), new Code(), データベース内連番_70,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_71, 調査項目_ない, new Code(), new Code(), データベース内連番_71,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_72, 調査項目_ない, new Code(), new Code(), データベース内連番_72,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_73, 調査項目_ない, new Code(), new Code(), データベース内連番_73,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            特別な医療List.add(new KihonChosaInput(new Code(), new Code(), データベース内連番_74, 調査項目_ない, new Code(), new Code(), データベース内連番_74,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));

            認定調査基本情報リスト.addAll(第1群List);
            認定調査基本情報リスト.addAll(特別な医療List);

            自立度List.add(new KihonChosaInput(new Code(), new Code(), 0, 調査項目_ない, new Code(), new Code(), 0,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
            自立度List.add(new KihonChosaInput(new Code(), new Code(), 0, 調査項目_ない, new Code(), new Code(), 0,
                    RString.EMPTY, RString.EMPTY, 0, new Code(), RString.EMPTY));
        } else {

            KihonChosaInput 第7群 = 認定調査基本情報リスト.get(0);

            KihonChosaInput 障害高齢者 = new KihonChosaInput(new Code(), 第7群.get障害高齢者自立度(), 0, 調査項目_ない, new Code(),
                    第7群.get前回障害高齢者自立度(), 0, RString.EMPTY, 第7群.get認定調査特記事項番号(), 0, new Code(), RString.EMPTY);
            KihonChosaInputBuilder 障害高齢者Builder = 障害高齢者.createBuilderForEdit();
            if (第7群.get障害高齢者自立度() != null && !第7群.get障害高齢者自立度().isEmpty()) {
                障害高齢者Builder.set特記事項有無(true);
            }

            KihonChosaInput 認知症高齢者 = new KihonChosaInput(第7群.get認知症高齢者自立度(), new Code(), 0, 調査項目_ない, 第7群.get前回認知症高齢者自立度(),
                    new Code(), 0, RString.EMPTY, 第7群.get認定調査特記事項番号(), 0, new Code(), RString.EMPTY);
            KihonChosaInputBuilder 認知症高齢者Builder = 認知症高齢者.createBuilderForEdit();
            if (第7群.get認知症高齢者自立度() != null && !第7群.get認知症高齢者自立度().isEmpty()) {
                認知症高齢者Builder.set特記事項有無(true);
            }

            自立度List.add(障害高齢者Builder.build());
            自立度List.add(認知症高齢者Builder.build());
            自立度 = 自立度.concat(障害高齢者.get障害高齢者自立度().getKey()).concat(認知症高齢者.get認知症高齢者自立度().getKey());

            if ((第7群.get前回認知症高齢者自立度() != null && !第7群.get前回認知症高齢者自立度().isEmpty())
                    || (第7群.get前回障害高齢者自立度() != null && !第7群.get前回障害高齢者自立度().isEmpty())) {
                前回基本調査項目値あり = true;
            }
        }

        基本調査初期データの保存(認定調査基本情報リスト, 自立度List, 前回基本調査項目値あり, 自立度);
    }

    private void 基本調査初期データの保存(List<KihonChosaInput> 認定調査基本情報リスト, ArrayList<KihonChosaInput> 自立度List,
            boolean 前回基本調査項目値あり, RString 自立度) {

        ArrayList<KihonChosaInput> 第1群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第2群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第3群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第4群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 第5群List = new ArrayList<>();
        ArrayList<KihonChosaInput> 特別な医療List = new ArrayList<>();

        RString 第1群 = RString.EMPTY;
        RString 第2群 = RString.EMPTY;
        RString 第3群 = RString.EMPTY;
        RString 第4群 = RString.EMPTY;
        RString 第5群 = RString.EMPTY;
        RString 特別な医療 = RString.EMPTY;

        KihonChosaInputBuilder joho;
        for (KihonChosaInput 基本情報 : 認定調査基本情報リスト) {
            if (!前回基本調査項目値あり && ((基本情報.get前回調査項目() != null && !基本情報.get前回調査項目().isEmpty()))) {
                前回基本調査項目値あり = true;
            }

            if (第1群の連番_有無.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                if (調査項目_ある.equals(基本情報.get調査項目())) {
                    joho.set特記事項有無(true);
                }
                第1群List.add(joho.build());
                第1群 = 第1群.concat(基本情報.get調査項目());
            } else if (第1群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第1群List.add(joho.build());
                第1群 = 第1群.concat(基本情報.get調査項目());
            } else if (第2群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第2群List.add(joho.build());
                第2群 = 第2群.concat(基本情報.get調査項目());

            } else if (第3群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第3群List.add(joho.build());
                第3群 = 第3群.concat(基本情報.get調査項目());
            } else if (第4群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第4群List.add(joho.build());
                第4群 = 第4群.concat(基本情報.get調査項目());

            } else if (第5群の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                joho.set特記事項有無(true);
                第5群List.add(joho.build());
                第5群 = 第5群.concat(基本情報.get調査項目());
            } else if (特別な医療の連番.contains(カンマ + String.valueOf(基本情報.get調査連番()) + カンマ)) {
                joho = 基本情報.createBuilderForEdit();
                if (調査項目_ある.equals(基本情報.get調査項目())) {
                    joho.set特記事項有無(true);
                }
                特別な医療List.add(joho.build());
                特別な医療 = 特別な医療.concat(String.valueOf(基本情報.get調査項目()));

            }
        }

        RString 認定調査前回結果表示Val = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果表示, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (!認定調査前回結果表示.equals(認定調査前回結果表示Val)) {
            前回基本調査項目値あり = false;
        }

        ViewStateHolder.put(Dbe2210001Keys.前回基本調査項目値あり, 前回基本調査項目値あり);
        ViewStateHolder.put(KihonChosaInputHandler1.ViewStateKey.第一群認定調査基本情報リスト, 第1群List);
        ViewStateHolder.put(KihonChosaInputHandler2.ViewStateKey.第二群認定調査基本情報リスト, 第2群List);
        ViewStateHolder.put(KihonChosaInputHandler3.ViewStateKey.第三群認定調査基本情報リスト, 第3群List);
        ViewStateHolder.put(KihonChosaInputHandler4.ViewStateKey.第四群認定調査基本情報リスト, 第4群List);
        ViewStateHolder.put(KihonChosaInputHandler5.ViewStateKey.第五群認定調査基本情報リスト, 第5群List);
        ViewStateHolder.put(KihonChosaInputHandler6.ViewStateKey.第六群認定調査基本情報リスト, 特別な医療List);
        ViewStateHolder.put(KihonChosaInputHandler7.ViewStateKey.第七群認定調査基本情報リスト, 自立度List);

        RString 初期の基本調査 = 第1群.concat(第2群).concat(第3群).concat(第4群).concat(第5群).concat(特別な医療).concat(自立度);
        ViewStateHolder.put(Dbe2210001Keys.初期の基本調査, 初期の基本調査);
    }

    /**
     * 予防給付サービスの連番リストを取得します。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     * @return 予防給付サービスの連番リスト
     */
    public List<Integer> get予防給付サービス連番List(RString temp_厚労省IF識別コード) {
        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
        }
        return 連番List;
    }

    /**
     * 介護給付サービスの連番リストを取得します。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     * @return 介護給付サービスの連番リスト
     */
    public List<Integer> get介護給付サービス連番List(RString temp_厚労省IF識別コード) {
        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_1);
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
            連番List.add(データベース内連番_10);
            連番List.add(データベース内連番_11);
            連番List.add(データベース内連番_12);
            連番List.add(データベース内連番_13);
            連番List.add(データベース内連番_14);
            連番List.add(データベース内連番_15);
            連番List.add(データベース内連番_16);
            連番List.add(データベース内連番_17);
            連番List.add(データベース内連番_18);
        }

        if (厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_19);
            連番List.add(データベース内連番_20);
        }
        return 連番List;
    }

    /**
     * 施設利用の連番リストを取得します。
     *
     * @param temp_厚労省IF識別コード 厚労省IF識別コード
     * @return 施設利用の連番リスト
     */
    public List<Integer> get施設利用連番List(RString temp_厚労省IF識別コード) {

        List<Integer> 連番List = new ArrayList<>();

        if (厚労省IF識別コード_02A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_06A.equals(temp_厚労省IF識別コード)
                || 厚労省IF識別コード_09A.equals(temp_厚労省IF識別コード) || 厚労省IF識別コード_09B.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_5);
            連番List.add(データベース内連番_6);
            連番List.add(データベース内連番_7);
            連番List.add(データベース内連番_8);
            連番List.add(データベース内連番_9);
        } else if (厚労省IF識別コード_99A.equals(temp_厚労省IF識別コード)) {
            連番List.add(データベース内連番_2);
            連番List.add(データベース内連番_3);
            連番List.add(データベース内連番_4);
            連番List.add(データベース内連番_9);
        }
        return 連番List;
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
        RString 現在の基本調査 = get現在の基本調査();
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

    @SuppressWarnings("unchecked")
    private RString get現在の基本調査() {

        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(KihonChosaInputHandler1.ViewStateKey.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(KihonChosaInputHandler2.ViewStateKey.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(KihonChosaInputHandler3.ViewStateKey.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(KihonChosaInputHandler4.ViewStateKey.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(KihonChosaInputHandler5.ViewStateKey.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(KihonChosaInputHandler6.ViewStateKey.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(KihonChosaInputHandler7.ViewStateKey.第七群認定調査基本情報リスト, ArrayList.class);

        RString 第1群 = RString.EMPTY;
        RString 第2群 = RString.EMPTY;
        RString 第3群 = RString.EMPTY;
        RString 第4群 = RString.EMPTY;
        RString 第5群 = RString.EMPTY;
        RString 特別な医療 = RString.EMPTY;
        RString 自立度 = RString.EMPTY;

        if (第1群List != null) {
            for (KihonChosaInput 基本情報 : 第1群List) {
                第1群 = 第1群.concat(基本情報.get調査項目());
            }
        }
        if (第2群List != null) {
            for (KihonChosaInput 基本情報 : 第2群List) {
                第2群 = 第2群.concat(基本情報.get調査項目());
            }
        }
        if (第3群List != null) {
            for (KihonChosaInput 基本情報 : 第3群List) {
                第3群 = 第3群.concat(基本情報.get調査項目());
            }
        }
        if (第4群List != null) {
            for (KihonChosaInput 基本情報 : 第4群List) {
                第4群 = 第4群.concat(基本情報.get調査項目());
            }
        }
        if (第5群List != null) {
            for (KihonChosaInput 基本情報 : 第5群List) {
                第5群 = 第5群.concat(基本情報.get調査項目());
            }
        }
        if (特別な医療List != null) {
            for (KihonChosaInput 基本情報 : 特別な医療List) {
                特別な医療 = 特別な医療.concat(String.valueOf(基本情報.get調査項目()));
            }
        }
        if (自立度List != null) {
            int i = 0;
            for (KihonChosaInput 基本情報 : 自立度List) {
                if (i == 0) {
                    自立度 = 自立度.concat(基本情報.get障害高齢者自立度().getKey());
                } else if (i == 1) {
                    自立度 = 自立度.concat(基本情報.get認知症高齢者自立度().getKey());
                }
                i++;
            }
        }

        return 第1群.concat(第2群).concat(第3群).concat(第4群).concat(第5群).concat(特別な医療).concat(自立度);
    }

    /**
     * ボタン「前回値をコピーする」を押下する処理です。
     */
    @SuppressWarnings("unchecked")
    public void 前回値コピー処理() {

        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(KihonChosaInputHandler1.ViewStateKey.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(KihonChosaInputHandler2.ViewStateKey.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(KihonChosaInputHandler3.ViewStateKey.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(KihonChosaInputHandler4.ViewStateKey.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(KihonChosaInputHandler5.ViewStateKey.第五群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 特別な医療List = ViewStateHolder.get(KihonChosaInputHandler6.ViewStateKey.第六群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 自立度List = ViewStateHolder.get(KihonChosaInputHandler7.ViewStateKey.第七群認定調査基本情報リスト, ArrayList.class);

        for (KihonChosaInput 基本情報 : 第1群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第2群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第3群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第4群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第5群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 特別な医療List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get前回調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 自立度List) {
            基本情報 = new KihonChosaInput(基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(), 基本情報.get調査連番(),
                    基本情報.get調査項目(), 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        ViewStateHolder.put(KihonChosaInputHandler1.ViewStateKey.第一群認定調査基本情報リスト, 第1群List);
        ViewStateHolder.put(KihonChosaInputHandler2.ViewStateKey.第二群認定調査基本情報リスト, 第2群List);
        ViewStateHolder.put(KihonChosaInputHandler3.ViewStateKey.第三群認定調査基本情報リスト, 第3群List);
        ViewStateHolder.put(KihonChosaInputHandler4.ViewStateKey.第四群認定調査基本情報リスト, 第4群List);
        ViewStateHolder.put(KihonChosaInputHandler5.ViewStateKey.第五群認定調査基本情報リスト, 第5群List);
        ViewStateHolder.put(KihonChosaInputHandler6.ViewStateKey.第六群認定調査基本情報リスト, 特別な医療List);
        ViewStateHolder.put(KihonChosaInputHandler7.ViewStateKey.第七群認定調査基本情報リスト, 自立度List);

    }

    /**
     * ボタン「規定値を設定する」を押下する処理です。
     */
    @SuppressWarnings("unchecked")
    public void 規定値設定処理() {
        ArrayList<KihonChosaInput> 第1群List = ViewStateHolder.get(KihonChosaInputHandler1.ViewStateKey.第一群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第2群List = ViewStateHolder.get(KihonChosaInputHandler2.ViewStateKey.第二群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第3群List = ViewStateHolder.get(KihonChosaInputHandler3.ViewStateKey.第三群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第4群List = ViewStateHolder.get(KihonChosaInputHandler4.ViewStateKey.第四群認定調査基本情報リスト, ArrayList.class);
        ArrayList<KihonChosaInput> 第5群List = ViewStateHolder.get(KihonChosaInputHandler5.ViewStateKey.第五群認定調査基本情報リスト, ArrayList.class);

        for (KihonChosaInput 基本情報 : 第1群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第2群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第3群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第4群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        for (KihonChosaInput 基本情報 : 第5群List) {
            基本情報 = new KihonChosaInput(基本情報.get認知症高齢者自立度(), 基本情報.get障害高齢者自立度(), 基本情報.get調査連番(),
                    項目値１, 基本情報.get前回認知症高齢者自立度(), 基本情報.get前回障害高齢者自立度(),
                    基本情報.get前回調査連番(), 基本情報.get前回調査項目(), 基本情報.get認定調査特記事項番号(), 基本情報.get認定調査特記事項連番(),
                    基本情報.get原本マスク区分(), 基本情報.get特記事項());
        }
        ViewStateHolder.put(KihonChosaInputHandler1.ViewStateKey.第一群認定調査基本情報リスト, 第1群List);
        ViewStateHolder.put(KihonChosaInputHandler2.ViewStateKey.第二群認定調査基本情報リスト, 第2群List);
        ViewStateHolder.put(KihonChosaInputHandler3.ViewStateKey.第三群認定調査基本情報リスト, 第3群List);
        ViewStateHolder.put(KihonChosaInputHandler4.ViewStateKey.第四群認定調査基本情報リスト, 第4群List);
        ViewStateHolder.put(KihonChosaInputHandler5.ViewStateKey.第五群認定調査基本情報リスト, 第5群List);
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
        実施場所,
        /**
         * 前回基本調査項目値あり
         */
        前回基本調査項目値あり;
    }

}
